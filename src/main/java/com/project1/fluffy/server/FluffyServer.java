package com.project1.fluffy.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

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
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static class DataService extends DataServiceGrpc.DataServiceImplBase {
		Hashtable<String, Object[]> fileUploaders = new Hashtable();
		int uploadId = 0;

		DataService() {
		}

		@Override
		public void sendChunk(sendChunkRequest request, StreamObserver<sendChunkResponse> responseObserver) {
			FileOutputStream fileOutputStream = null;

			ChunkInfo chunkInfo = request.getChunkInfo();
			String fileKey = chunkInfo.getKey();
			String uploadId = Integer.toString(chunkInfo.getUploadId());
			Object[] uploadInfo = fileUploaders.get(uploadId);
			try {
				if (uploadInfo == null) {
					fileOutputStream = new FileOutputStream(fileKey + ".tmp");
					fileOutputStream.write(chunkInfo.getData().toByteArray(), 0, chunkInfo.getLen());
					if (chunkInfo.getIsEnd() == false) {
						fileUploaders.put(uploadId, new Object[] { fileKey, fileOutputStream });
					}
				} else {
					fileOutputStream = (FileOutputStream) uploadInfo[1];
					fileOutputStream.write(chunkInfo.getData().toByteArray(), 0, chunkInfo.getLen());
				}

				if (chunkInfo.getIsEnd()) {
					fileOutputStream.close();
					File uploadedFile = new File(fileKey);
					File tmpFile = new File(fileKey + ".tmp");
					System.out.println(uploadedFile.getAbsolutePath());
					System.out.println(tmpFile.getAbsolutePath());
					tmpFile.renameTo(uploadedFile);
					deleteTmpFile(fileKey);
					fileUploaders.remove(uploadId);
				}
				responseObserver.onNext(sendChunkResponse.newBuilder().setResponse("OK").build());
			} catch (IOException e) {
				System.out.println("Error " + e.getMessage());
				responseObserver.onNext(sendChunkResponse.newBuilder().setResponse("ERROR").build());
			}
			responseObserver.onCompleted();
		}

		@Override
		public void getUploadId(getUploadIdRequest request, StreamObserver<getUploadIdResponse> responseObserver) {
			responseObserver.onNext(getUploadIdResponse.newBuilder().setUploadId(uploadId).build());
			responseObserver.onCompleted();
			uploadId++;
		}

		public void deleteTmpFile(String fileKey) {
			File createdTmpFile = new File(fileKey + ".tmp");
			if (createdTmpFile.exists()) {
				createdTmpFile.delete();
			}
		}
	}
}
