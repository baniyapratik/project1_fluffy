package com.project1.fluffy.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import com.google.protobuf.ByteString;
import com.proto.fluffy.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class FluffyClient {
	private final ManagedChannel channel;
	private final DataServiceGrpc.DataServiceBlockingStub dataClient;

	public static void main(String[] args) {
		System.out.println("Project one application");
		FluffyClient main = new FluffyClient();
		main.run();
	}

	public FluffyClient() {
		channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();
		dataClient = DataServiceGrpc.newBlockingStub(channel);
	}

	private void run() {
		// saveFile("PATH TO YOUR FILE HERE");
	}

	private void saveFile(String filePath) {
		// get Unique uploadId from load balancer. This is used by the load balancer to keep track of which server has file
		// as well as by the server to keep track of the corresponding FileOutputStream
		int uploadId = dataClient.getUploadId(getUploadIdRequest.newBuilder().build()).getUploadId();
		ChunkInfo chunkInfo = null;
		FileInputStream is = null;
		File file = null;
		// chunk the file to support uploading larger files
		try {
			file = new File(filePath);
			is = new FileInputStream(file);
			byte[] chunkByteArray = new byte[1024];
			int chunkLen = 0;
			boolean isEnd = false;
			long readAmount = 0;
			while ((chunkLen = is.read(chunkByteArray)) != -1) {
				readAmount += chunkLen;
				if (readAmount == file.length()) {
					isEnd = true;
				}
				chunkInfo = ChunkInfo.newBuilder().setData(ByteString.copyFrom(chunkByteArray)).setKey(file.getName())
						.setIsEnd(isEnd).setLen(chunkLen).setUploadId(uploadId).build();
				sendChunkRequest sendRequest = sendChunkRequest.newBuilder().setChunkInfo(chunkInfo).build();
				sendChunkResponse chunkResponse = dataClient.sendChunk(sendRequest);
				if (!chunkResponse.getResponse().equals("OK")) {
					throw new RuntimeException("server error, please try reuploading file");
				}
			}
			System.out.println(file.getName() + " sent");
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} catch (RuntimeException e) {
			// Cancel RPC
			System.out.println(e.getMessage());
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
	}
}
