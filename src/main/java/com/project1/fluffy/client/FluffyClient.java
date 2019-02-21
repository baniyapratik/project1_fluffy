package com.project1.fluffy.client;

import com.proto.fluffy.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class FluffyClient {

    public static void main(String[] args) {
        System.out.println("Project one application");
        FluffyClient main = new FluffyClient();
        main.run();
    }

    private void run(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        TextServiceGrpc.TextServiceBlockingStub textClient = TextServiceGrpc.newBlockingStub(channel);
        textClientCalls(textClient);
    }

    private void textClientCalls(TextServiceGrpc.TextServiceBlockingStub textClient){

        // Creating a new Text
        Text text = Text.newBuilder()
                .setContent("Hello world")
                .setDescription("First Text being sent")
                .build();

        createTextResponse textResponse = textClient.createText(
                createTextRequest.newBuilder().setText(text).build()
        );

        System.out.println("Received create Text Response");
        System.out.println(textResponse.toString());


        // reading text based on given id
        String textId = textResponse.getText().getId();

        System.out.println("Reading text's....");

        readTextResponse readTextResponse = textClient.readText(readTextRequest.newBuilder()
                .setTextId(textId)
                .build());

        System.out.println(readTextResponse.toString());


        // updating the text data ..

        Text newText = Text.newBuilder()
                .setId(textId)
                .setContent("Updated Content")
                .setDescription("Updated Description")
                .build();
        updateTextResponse updateTextResponse = textClient.updateText(
                updateTextRequest.newBuilder().setText(newText).build()
        );
        System.out.println("Received Updated Text Response");
        System.out.println(updateTextResponse.toString());


        // deleting a text data ..
        System.out.println("Received Delete Text Response");
        deleteTextResponse deleteTextResponse = textClient.deleteText(
                deleteTextRequest.newBuilder().setTextId(textId).build());
        System.out.println("Text Data deleted");


        // list all the data in TextData collections
        // stream of List Text response
        System.out.println("Received List Text Response");
        textClient.listText(listTextRequest.newBuilder().build()).forEachRemaining(
                listTextResponse -> System.out.println(listTextResponse.getText().toString())
        );

    }
}
