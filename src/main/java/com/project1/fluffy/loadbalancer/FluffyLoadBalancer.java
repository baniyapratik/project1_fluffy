package com.project1.fluffy.loadbalancer;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.proto.fluffy.*;

public class FluffyLoadBalancer {
	private final Server server;
	private final Hashtable<String, Object[]> _servers = new Hashtable<String, Object[]>();

	public FluffyLoadBalancer(ArrayList<Object[]> servers) {
		// loop through given servers and add them to Hashtable of servers, the key here
		// is a combination of ip and port
		for (int i = 0; i < servers.size(); i++) {
			Object[] serverInfo = (Object[]) servers.get(i);
			String ip = (String) serverInfo[0];
			int portNumber = (int) serverInfo[1];
			String key = ip + ":" + Integer.toString(portNumber);
			ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, portNumber).usePlaintext().build();

			Object[] clientStubInfo = new Object[] { ip, portNumber, DataServiceGrpc.newBlockingStub(channel) };
			_servers.put(key, clientStubInfo);
		}
		server = ServerBuilder.forPort(50051).addService(new DataService(_servers)).build();
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
		ArrayList<Object[]> serverList = new ArrayList<Object[]>();
		try {
			JsonArray serverArray = (JsonArray) new JsonParser().parse(new FileReader("Servers.json"));
			for (int i = 0; i < serverArray.size(); i++) {
				JsonObject serverInfo = (JsonObject) serverArray.get(i);
				serverList.add(new Object[] { serverInfo.get("ip").getAsString(), serverInfo.get("port").getAsInt() });
			}
		} catch (JsonIOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonSyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		FluffyLoadBalancer server = new FluffyLoadBalancer(serverList);
		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static class DataService extends DataServiceGrpc.DataServiceImplBase {
		private Hashtable<String, Object[]> _fileUploaders = new Hashtable<String, Object[]>();
		private Hashtable<String, Object[]> _servers;
		private int _uploadId = 0;
		private Random _rand = new Random();

		DataService(Hashtable<String, Object[]> servers) {
			this._servers = servers;
		}

		@Override
		public void sendChunk(sendChunkRequest request, StreamObserver<sendChunkResponse> responseObserver) {
			ChunkInfo chunkInfo = request.getChunkInfo();
			sendChunkResponse response = null;

			// look up if upload id has corresponding server to send to, if so send it, if
			// not get a new server for upload id which
			// they will use during their whole file upload.

			// we are also simply forwarding the request we got from the clients to the
			// chosen server.
			Object[] fileUploadInfo = _fileUploaders.get(Integer.toString(chunkInfo.getUploadId()));
			if (fileUploadInfo == null) {
				Object[] clientInfo = getClient();
				_fileUploaders.put(Integer.toString(chunkInfo.getUploadId()), clientInfo);
				response = ((DataServiceGrpc.DataServiceBlockingStub) clientInfo[2]).sendChunk(request);
			} else {
				Object[] clientInfo = _fileUploaders.get(Integer.toString(chunkInfo.getUploadId()));
				response = ((DataServiceGrpc.DataServiceBlockingStub) clientInfo[2]).sendChunk(request);
			}

			if (chunkInfo.getIsEnd() || response.getResponse().equals("OK")) {
				_fileUploaders.remove(chunkInfo.getUploadId());
			}

			// forward response from server to client
			responseObserver.onNext(response);
			responseObserver.onCompleted();
		}

		@Override
		public void getUploadId(getUploadIdRequest request, StreamObserver<getUploadIdResponse> responseObserver) {
			responseObserver.onNext(getUploadIdResponse.newBuilder().setUploadId(_uploadId).build());
			responseObserver.onCompleted();
			_uploadId++;
		}

		private Object[] getClient() {
			// go through all entries in server hashtable and find server best fit for
			// storing data
			// TODO replace random selection with load balancer algorithm
			Set<String> keys = _servers.keySet();
			Object[] clientInfo = null;
			for (String key : keys) {
				if (_rand.nextInt(2) == 0 || clientInfo == null) {
					clientInfo = _servers.get(key);
				}
			}
			return clientInfo;
		}

		public void addServer(String ip, int portNumber) {
			String key = ip + ":" + Integer.toString(portNumber);
			ManagedChannel channel = ManagedChannelBuilder.forAddress(ip, portNumber).usePlaintext().build();

			Object[] clientStubInfo = new Object[] { ip, portNumber, DataServiceGrpc.newBlockingStub(channel) };
			_servers.put(key, clientStubInfo);
		}

		public void removeServer(String ip, int portNumber) {
			String key = ip + ":" + Integer.toString(portNumber);
			_servers.remove(key);
		}
	}
}
