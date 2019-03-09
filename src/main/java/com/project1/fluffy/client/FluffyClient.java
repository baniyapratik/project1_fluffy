package com.project1.fluffy.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.ByteString;
import com.proto.fluffy.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class FluffyClient {
	private final ManagedChannel channel;
	private final DataServiceGrpc.DataServiceBlockingStub dataClient;
	private final DataServiceGrpc.DataServiceStub asyncStub;
	private Random random = new Random();

	public static void main(String[] args) {
		System.out.println("Project one application");
		FluffyClient main = new FluffyClient();
		main.run();
	}

	public FluffyClient() {
		channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		dataClient = DataServiceGrpc.newBlockingStub(channel);
		asyncStub = DataServiceGrpc.newStub(channel);
	}

	private void run() {
		try {
			saveFile("C:\\IA2013\\IAClasses.zip");
		} catch (UnsupportedEncodingException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void saveFile(String filePath) throws InterruptedException, UnsupportedEncodingException {
		final CountDownLatch finishLatch = new CountDownLatch(1);
		StreamObserver<saveDataResponse> responseObserver = new StreamObserver<saveDataResponse>() {
			@Override
			public void onNext(saveDataResponse response) {
				String responseStatus = response.getResponse();
				System.out.println("Received " + responseStatus);
				if (responseStatus.equals("Error")) {
					finishLatch.countDown();
				}
			}

			@Override
			public void onError(Throwable t) {
				System.out.println(Status.fromThrowable(t));
				finishLatch.countDown();
			}

			@Override
			public void onCompleted() {
				System.out.println("Finished sending file");
				finishLatch.countDown();
			}
		};

		StreamObserver<saveDataRequest> requestObserver = asyncStub.saveData(responseObserver);
		Data chunk = null;
		FileInputStream is = null;
		File file = null;
		long bytesRead = 0;
		try {
			file = new File(filePath);
			is = new FileInputStream(file);
			byte[] chunkByteArray = new byte[1024];
			int chunkLen = 0;
			bytesRead = 0;
			while ((chunkLen = is.read(chunkByteArray)) != -1) {
				chunk = Data.newBuilder().setData(ByteString.copyFrom(chunkByteArray))
						.setKey(file.getName())
						.setStartByte(bytesRead)
						.setLen(chunkLen)
						.build();

				bytesRead += chunkLen;
				saveDataRequest dataRequest = saveDataRequest.newBuilder().setData(chunk).build();
				requestObserver.onNext(dataRequest);
				if (finishLatch.getCount() == 0) {
					// RPC completed or errored before we finished sending.
					// Sending further requests won't error, but they will just be thrown away.
					System.out.println("Ended sending prematurely");
					throw new RuntimeException("Server ended file stream early");
				}
			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} catch (RuntimeException e) {
			// Cancel RPC
			requestObserver.onError(e);
			throw e;
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// do nothing
					e.printStackTrace();
				}
			}
		}
		
		if (file != null && bytesRead == file.length()) {
			requestObserver.onCompleted();
		}

		// Receiving happens asynchronously
		if (!finishLatch.await(1, TimeUnit.MINUTES)) {
			System.out.println("recordRoute can not finish within 1 minutes");
		}
	}
}
