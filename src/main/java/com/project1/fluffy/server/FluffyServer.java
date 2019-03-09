package com.project1.fluffy.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.proto.fluffy.*;

public class FluffyServer {
	private final Server server;

	public FluffyServer() {
		server = ServerBuilder.forPort(50051).addService(new DataService()).build();
	}

	public void start() throws IOException, InterruptedException {
		server.start();
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Received shutdown Request");
			server.shutdown();
			System.out.println("Successfully stopped the server");
		}));
		server.awaitTermination();
	}

	public static void main(String[] args) {
		FluffyServer server = new FluffyServer();
		try {
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static class DataService extends DataServiceGrpc.DataServiceImplBase {
		DataService() {

		}

		@Override
		public StreamObserver<saveDataRequest> saveData(final StreamObserver<saveDataResponse> responseObserver) {

			return new StreamObserver<saveDataRequest>() {
				FileOutputStream fileOutputStream = null;
				String fileKey = null;
				@Override
				public void onNext(saveDataRequest dataRequest) {
					Data dataInfo = dataRequest.getData();
					try {
						if (dataInfo.getStartByte() == 0) {
							fileKey = dataInfo.getKey();
							fileOutputStream = new FileOutputStream(fileKey + ".tmp");
						}
						fileOutputStream.write(dataInfo.getData().toByteArray(), 0, dataInfo.getLen());
					} catch (IOException e) {
						responseObserver.onNext(saveDataResponse.newBuilder().setResponse("Error").build());
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				@Override
				public void onError(Throwable t) {
					System.out.println("Error: " + t.getMessage());
					try {
						fileOutputStream.close();
						deleteTmpFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				@Override
				public void onCompleted() {
					try {
						fileOutputStream.close();
						File createdTmpFile = new File(fileKey + ".tmp");
						File createdFile = new File(fileKey);
						createdTmpFile.renameTo(createdFile);
						deleteTmpFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					responseObserver.onNext(saveDataResponse.newBuilder().setResponse("Ok").build());
					responseObserver.onCompleted();
				}
				
				public void deleteTmpFile() {
					File createdTmpFile = new File(fileKey + ".tmp");
					if (createdTmpFile.exists()) {
						createdTmpFile.delete();
					}
				}
				
			};
		}
	}

}
