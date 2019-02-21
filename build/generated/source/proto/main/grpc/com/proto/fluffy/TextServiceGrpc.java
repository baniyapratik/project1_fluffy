package com.proto.fluffy;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.18.0)",
    comments = "Source: fluffy/fluffly.proto")
public final class TextServiceGrpc {

  private TextServiceGrpc() {}

  public static final String SERVICE_NAME = "fluffy.TextService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.fluffy.createTextRequest,
      com.proto.fluffy.createTextResponse> getCreateTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateText",
      requestType = com.proto.fluffy.createTextRequest.class,
      responseType = com.proto.fluffy.createTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.fluffy.createTextRequest,
      com.proto.fluffy.createTextResponse> getCreateTextMethod() {
    io.grpc.MethodDescriptor<com.proto.fluffy.createTextRequest, com.proto.fluffy.createTextResponse> getCreateTextMethod;
    if ((getCreateTextMethod = TextServiceGrpc.getCreateTextMethod) == null) {
      synchronized (TextServiceGrpc.class) {
        if ((getCreateTextMethod = TextServiceGrpc.getCreateTextMethod) == null) {
          TextServiceGrpc.getCreateTextMethod = getCreateTextMethod = 
              io.grpc.MethodDescriptor.<com.proto.fluffy.createTextRequest, com.proto.fluffy.createTextResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fluffy.TextService", "CreateText"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.fluffy.createTextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.fluffy.createTextResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TextServiceMethodDescriptorSupplier("CreateText"))
                  .build();
          }
        }
     }
     return getCreateTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.fluffy.readTextRequest,
      com.proto.fluffy.readTextResponse> getReadTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReadText",
      requestType = com.proto.fluffy.readTextRequest.class,
      responseType = com.proto.fluffy.readTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.fluffy.readTextRequest,
      com.proto.fluffy.readTextResponse> getReadTextMethod() {
    io.grpc.MethodDescriptor<com.proto.fluffy.readTextRequest, com.proto.fluffy.readTextResponse> getReadTextMethod;
    if ((getReadTextMethod = TextServiceGrpc.getReadTextMethod) == null) {
      synchronized (TextServiceGrpc.class) {
        if ((getReadTextMethod = TextServiceGrpc.getReadTextMethod) == null) {
          TextServiceGrpc.getReadTextMethod = getReadTextMethod = 
              io.grpc.MethodDescriptor.<com.proto.fluffy.readTextRequest, com.proto.fluffy.readTextResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fluffy.TextService", "ReadText"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.fluffy.readTextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.fluffy.readTextResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TextServiceMethodDescriptorSupplier("ReadText"))
                  .build();
          }
        }
     }
     return getReadTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.fluffy.updateTextRequest,
      com.proto.fluffy.updateTextResponse> getUpdateTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateText",
      requestType = com.proto.fluffy.updateTextRequest.class,
      responseType = com.proto.fluffy.updateTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.fluffy.updateTextRequest,
      com.proto.fluffy.updateTextResponse> getUpdateTextMethod() {
    io.grpc.MethodDescriptor<com.proto.fluffy.updateTextRequest, com.proto.fluffy.updateTextResponse> getUpdateTextMethod;
    if ((getUpdateTextMethod = TextServiceGrpc.getUpdateTextMethod) == null) {
      synchronized (TextServiceGrpc.class) {
        if ((getUpdateTextMethod = TextServiceGrpc.getUpdateTextMethod) == null) {
          TextServiceGrpc.getUpdateTextMethod = getUpdateTextMethod = 
              io.grpc.MethodDescriptor.<com.proto.fluffy.updateTextRequest, com.proto.fluffy.updateTextResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fluffy.TextService", "UpdateText"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.fluffy.updateTextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.fluffy.updateTextResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TextServiceMethodDescriptorSupplier("UpdateText"))
                  .build();
          }
        }
     }
     return getUpdateTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.fluffy.deleteTextRequest,
      com.proto.fluffy.deleteTextResponse> getDeleteTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteText",
      requestType = com.proto.fluffy.deleteTextRequest.class,
      responseType = com.proto.fluffy.deleteTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.fluffy.deleteTextRequest,
      com.proto.fluffy.deleteTextResponse> getDeleteTextMethod() {
    io.grpc.MethodDescriptor<com.proto.fluffy.deleteTextRequest, com.proto.fluffy.deleteTextResponse> getDeleteTextMethod;
    if ((getDeleteTextMethod = TextServiceGrpc.getDeleteTextMethod) == null) {
      synchronized (TextServiceGrpc.class) {
        if ((getDeleteTextMethod = TextServiceGrpc.getDeleteTextMethod) == null) {
          TextServiceGrpc.getDeleteTextMethod = getDeleteTextMethod = 
              io.grpc.MethodDescriptor.<com.proto.fluffy.deleteTextRequest, com.proto.fluffy.deleteTextResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "fluffy.TextService", "DeleteText"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.fluffy.deleteTextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.fluffy.deleteTextResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TextServiceMethodDescriptorSupplier("DeleteText"))
                  .build();
          }
        }
     }
     return getDeleteTextMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.proto.fluffy.listTextRequest,
      com.proto.fluffy.listTextResponse> getListTextMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListText",
      requestType = com.proto.fluffy.listTextRequest.class,
      responseType = com.proto.fluffy.listTextResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.proto.fluffy.listTextRequest,
      com.proto.fluffy.listTextResponse> getListTextMethod() {
    io.grpc.MethodDescriptor<com.proto.fluffy.listTextRequest, com.proto.fluffy.listTextResponse> getListTextMethod;
    if ((getListTextMethod = TextServiceGrpc.getListTextMethod) == null) {
      synchronized (TextServiceGrpc.class) {
        if ((getListTextMethod = TextServiceGrpc.getListTextMethod) == null) {
          TextServiceGrpc.getListTextMethod = getListTextMethod = 
              io.grpc.MethodDescriptor.<com.proto.fluffy.listTextRequest, com.proto.fluffy.listTextResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "fluffy.TextService", "ListText"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.fluffy.listTextRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.fluffy.listTextResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new TextServiceMethodDescriptorSupplier("ListText"))
                  .build();
          }
        }
     }
     return getListTextMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TextServiceStub newStub(io.grpc.Channel channel) {
    return new TextServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TextServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TextServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TextServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TextServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TextServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * return NOT_FOUND if not text_id is not found
     * </pre>
     */
    public void createText(com.proto.fluffy.createTextRequest request,
        io.grpc.stub.StreamObserver<com.proto.fluffy.createTextResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTextMethod(), responseObserver);
    }

    /**
     */
    public void readText(com.proto.fluffy.readTextRequest request,
        io.grpc.stub.StreamObserver<com.proto.fluffy.readTextResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReadTextMethod(), responseObserver);
    }

    /**
     */
    public void updateText(com.proto.fluffy.updateTextRequest request,
        io.grpc.stub.StreamObserver<com.proto.fluffy.updateTextResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTextMethod(), responseObserver);
    }

    /**
     */
    public void deleteText(com.proto.fluffy.deleteTextRequest request,
        io.grpc.stub.StreamObserver<com.proto.fluffy.deleteTextResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTextMethod(), responseObserver);
    }

    /**
     */
    public void listText(com.proto.fluffy.listTextRequest request,
        io.grpc.stub.StreamObserver<com.proto.fluffy.listTextResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListTextMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.fluffy.createTextRequest,
                com.proto.fluffy.createTextResponse>(
                  this, METHODID_CREATE_TEXT)))
          .addMethod(
            getReadTextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.fluffy.readTextRequest,
                com.proto.fluffy.readTextResponse>(
                  this, METHODID_READ_TEXT)))
          .addMethod(
            getUpdateTextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.fluffy.updateTextRequest,
                com.proto.fluffy.updateTextResponse>(
                  this, METHODID_UPDATE_TEXT)))
          .addMethod(
            getDeleteTextMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.proto.fluffy.deleteTextRequest,
                com.proto.fluffy.deleteTextResponse>(
                  this, METHODID_DELETE_TEXT)))
          .addMethod(
            getListTextMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.proto.fluffy.listTextRequest,
                com.proto.fluffy.listTextResponse>(
                  this, METHODID_LIST_TEXT)))
          .build();
    }
  }

  /**
   */
  public static final class TextServiceStub extends io.grpc.stub.AbstractStub<TextServiceStub> {
    private TextServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TextServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TextServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * return NOT_FOUND if not text_id is not found
     * </pre>
     */
    public void createText(com.proto.fluffy.createTextRequest request,
        io.grpc.stub.StreamObserver<com.proto.fluffy.createTextResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void readText(com.proto.fluffy.readTextRequest request,
        io.grpc.stub.StreamObserver<com.proto.fluffy.readTextResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadTextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateText(com.proto.fluffy.updateTextRequest request,
        io.grpc.stub.StreamObserver<com.proto.fluffy.updateTextResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteText(com.proto.fluffy.deleteTextRequest request,
        io.grpc.stub.StreamObserver<com.proto.fluffy.deleteTextResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTextMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listText(com.proto.fluffy.listTextRequest request,
        io.grpc.stub.StreamObserver<com.proto.fluffy.listTextResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListTextMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TextServiceBlockingStub extends io.grpc.stub.AbstractStub<TextServiceBlockingStub> {
    private TextServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TextServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TextServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * return NOT_FOUND if not text_id is not found
     * </pre>
     */
    public com.proto.fluffy.createTextResponse createText(com.proto.fluffy.createTextRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateTextMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.fluffy.readTextResponse readText(com.proto.fluffy.readTextRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadTextMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.fluffy.updateTextResponse updateText(com.proto.fluffy.updateTextRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateTextMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.proto.fluffy.deleteTextResponse deleteText(com.proto.fluffy.deleteTextRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTextMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.proto.fluffy.listTextResponse> listText(
        com.proto.fluffy.listTextRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getListTextMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TextServiceFutureStub extends io.grpc.stub.AbstractStub<TextServiceFutureStub> {
    private TextServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TextServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TextServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TextServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * return NOT_FOUND if not text_id is not found
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.fluffy.createTextResponse> createText(
        com.proto.fluffy.createTextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTextMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.fluffy.readTextResponse> readText(
        com.proto.fluffy.readTextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadTextMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.fluffy.updateTextResponse> updateText(
        com.proto.fluffy.updateTextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTextMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.fluffy.deleteTextResponse> deleteText(
        com.proto.fluffy.deleteTextRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTextMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TEXT = 0;
  private static final int METHODID_READ_TEXT = 1;
  private static final int METHODID_UPDATE_TEXT = 2;
  private static final int METHODID_DELETE_TEXT = 3;
  private static final int METHODID_LIST_TEXT = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TextServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TextServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TEXT:
          serviceImpl.createText((com.proto.fluffy.createTextRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.fluffy.createTextResponse>) responseObserver);
          break;
        case METHODID_READ_TEXT:
          serviceImpl.readText((com.proto.fluffy.readTextRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.fluffy.readTextResponse>) responseObserver);
          break;
        case METHODID_UPDATE_TEXT:
          serviceImpl.updateText((com.proto.fluffy.updateTextRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.fluffy.updateTextResponse>) responseObserver);
          break;
        case METHODID_DELETE_TEXT:
          serviceImpl.deleteText((com.proto.fluffy.deleteTextRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.fluffy.deleteTextResponse>) responseObserver);
          break;
        case METHODID_LIST_TEXT:
          serviceImpl.listText((com.proto.fluffy.listTextRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.fluffy.listTextResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TextServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TextServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.fluffy.Fluffly.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TextService");
    }
  }

  private static final class TextServiceFileDescriptorSupplier
      extends TextServiceBaseDescriptorSupplier {
    TextServiceFileDescriptorSupplier() {}
  }

  private static final class TextServiceMethodDescriptorSupplier
      extends TextServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TextServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TextServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TextServiceFileDescriptorSupplier())
              .addMethod(getCreateTextMethod())
              .addMethod(getReadTextMethod())
              .addMethod(getUpdateTextMethod())
              .addMethod(getDeleteTextMethod())
              .addMethod(getListTextMethod())
              .build();
        }
      }
    }
    return result;
  }
}
