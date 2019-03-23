package com.project1.fluffy.server;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.proto.fluffy.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class TextReadServiceImpl extends TextReadServiceGrpc.TextReadServiceImplBase {

    private MongoClient mongoClient = MongoClients.create("mongodb+srv://root:lab@project1-p9qiv.mongodb.net/test?retryWrites=true");
    private MongoDatabase database = mongoClient.getDatabase("test");
    private MongoCollection<Document> collection = database.getCollection("TextData");

    private Text documentToText(Document document){
        return Text.newBuilder()
                .setContent(document.getString("content"))
                .setDescription(document.getString("description"))
                .setId(document.getObjectId("_id").toString())
                .build();
    }

    @Override
    public void readText(readTextRequest request, StreamObserver<readTextResponse> responseObserver) {

        System.out.println("Read Text request received");
        String textId = request.getTextId();

        System.out.println("Searching for a Text");
        Document result = collection.find(eq("_id", new ObjectId(textId))).first();

        if (result == null) {
            System.out.println("Text not found");
            responseObserver.onError(
                    Status.NOT_FOUND
                    .withDescription("This Text with given id is not found")
                    .asRuntimeException()
            );
        }
        else{

            System.out.println("Text found, sending response");
            Text text = documentToText(result);
            responseObserver.onNext(readTextResponse
                    .newBuilder()
                    .setText(text)
                    .build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void listText(listTextRequest request, StreamObserver<listTextResponse> responseObserver) {
        System.out.println("Received List Text Request");

        collection.find().iterator().forEachRemaining(document -> responseObserver.onNext(
                listTextResponse.newBuilder().setText(documentToText(document)).build()
        ));

        responseObserver.onCompleted();
        
    }
}
