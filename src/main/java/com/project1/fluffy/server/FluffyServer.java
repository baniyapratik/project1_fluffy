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
	private final Server _server;
	private String _baseDir;
	
	public FluffyServer(int portNumber) {
		// create baseDirectory which is port number, this will store uploaded files
		_baseDir = Integer.toString(portNumber);
		new File(_baseDir).mkdirs();
		_server = ServerBuilder.forPort(portNumber).addService(new DataService(_baseDir)).build();
	}

	public void start() throws IOException, InterruptedException {
		_server.start();
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Received shutdown Request");
			_server.shutdown();
			System.out.println("Successfully stopped the server");
		}));
		_server.awaitTermination();
	}

	public static void main(String[] args) {
		// start server at port given as argument
		FluffyServer server = new FluffyServer(Integer.parseInt(args[0]));
		
		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static class DataService extends DataServiceGrpc.DataServiceImplBase {
		// Hash table to store upload id with corresponding server to know where to forward data chunk
		Hashtable<String, Object[]> _fileUploaders = new Hashtable();
		int uploadId = 0;
		private String _baseDir;

		DataService(String baseDir) {
			_baseDir = baseDir;
		}

		@Override
		public void sendChunk(sendChunkRequest request, StreamObserver<sendChunkResponse> responseObserver) {
			// get data chunk request from load balancer
			FileOutputStream fileOutputStream = null;

			ChunkInfo chunkInfo = request.getChunkInfo();
			String fileKey = chunkInfo.getKey();
			String uploadId = Integer.toString(chunkInfo.getUploadId());
			
			// look up if upload id has corresponding output stream for their uploaded file
			// if not assign it a new one and add entry to hash table
			Object[] uploadInfo = _fileUploaders.get(uploadId);
			try {
				if (uploadInfo == null) {
					File targetDir = new File(_baseDir);
					fileOutputStream = new FileOutputStream(new File(targetDir, fileKey + ".tmp"));
					fileOutputStream.write(chunkInfo.getData().toByteArray(), 0, chunkInfo.getLen());
					if (chunkInfo.getIsEnd() == false) {
						_fileUploaders.put(uploadId, new Object[] { fileKey, fileOutputStream });
					}
				} else {
					fileOutputStream = (FileOutputStream) uploadInfo[1];
					fileOutputStream.write(chunkInfo.getData().toByteArray(), 0, chunkInfo.getLen());
				}

				// if client sent last bytes to server then copy then rename tmp file to actual file and close the stream
				// also remove uploadid from hash table as we are now finished receiving the uploaded file
				if (chunkInfo.getIsEnd()) {
					fileOutputStream.close();
					File baseDir = new File(_baseDir);
					File uploadedFile = new File(baseDir, fileKey);
					File tmpFile = new File(baseDir,  fileKey + ".tmp");
					tmpFile.renameTo(uploadedFile);
					_fileUploaders.remove(uploadId);
				}
				responseObserver.onNext(sendChunkResponse.newBuilder().setResponse("OK").build());
			} catch (IOException e) {
				// if error occurs close file stream and remove uploadid from hash table
				if (fileOutputStream != null) {
					try {
						fileOutputStream.close();
					} catch (IOException e1) {
						// ignore
						e1.printStackTrace();
					}
				}
				
				if (uploadInfo != null) {
					_fileUploaders.remove(uploadId);
				}
				
				System.out.println("Error " + e.getMessage());
				responseObserver.onNext(sendChunkResponse.newBuilder().setResponse("ERROR").build());
			}
			responseObserver.onCompleted();
		}
	}
}
