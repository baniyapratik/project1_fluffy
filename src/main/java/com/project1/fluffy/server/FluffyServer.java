package com.project1.fluffy.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class FluffyServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello gRPC");
        Server server = ServerBuilder.forPort(50051)
                .addService(new TextServiceImpl())
                .build();
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("Received shutdown Request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));
        server.awaitTermination();
    }

}
