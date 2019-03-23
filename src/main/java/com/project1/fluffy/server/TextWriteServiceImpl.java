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

public class TextWriteServiceImpl extends TextWriteServiceGrpc.TextWriteServiceImplBase {

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
    public void createText(createTextRequest request, StreamObserver<createTextResponse> responseObserver) {
    	long startTime = System.nanoTime();
        System.out.println("Received Create Text request");

        Text text = request.getText();
        Document doc = new Document("content", text.getContent())
                .append("description", text.getDescription());

        System.out.println("Inserting Text in the DB...");
        // inserting one document to our collection
        collection.insertOne(doc);

        // MongoDB generated _id
        String id = doc.getObjectId("_id").toString();
        System.out.println("Inserted Text id is: "+id);

        createTextResponse response = createTextResponse
                .newBuilder()
                .setText(text.toBuilder().setId(id).build())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);

    }

    @Override
    public void updateText(updateTextRequest request, StreamObserver<updateTextResponse> responseObserver) {
    	long startTime = System.nanoTime();
        System.out.println("Received an Update request");

        Text text = request.getText();

        String textId = text.getId();

        System.out.println("Searching for the provided text_id");

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
            System.out.println("Text found, updating response");
            Document updated_doc = new Document("content", text.getContent())
                    .append("description", text.getDescription())
                    .append("_id", new ObjectId(textId));

            collection.replaceOne(eq("_id", result.getObjectId("_id")), updated_doc);
            System.out.println("Replaced! Sending as a response");
            responseObserver.onNext(updateTextResponse.newBuilder().build().newBuilder()
                            .setText(documentToText(updated_doc))
                            .build()
            );

            responseObserver.onCompleted();
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);
    }

    @Override
    public void deleteText(deleteTextRequest request, StreamObserver<deleteTextResponse> responseObserver) {
    	long startTime = System.nanoTime();
        String textId = request.getTextId();

        try {
            collection.deleteOne(eq("_id", new ObjectId(textId)));
        }
        catch (Exception e) {
            System.out.println("Item not found");
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("id was not found to be deleted.")
                            .augmentDescription(e.getLocalizedMessage())
                            .asRuntimeException()
            );
        }

        System.out.println("Item was deleted");
        responseObserver.onNext(deleteTextResponse
                .newBuilder()
                .setTextId(textId)
                .build());

        responseObserver.onCompleted();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);
    }
}
