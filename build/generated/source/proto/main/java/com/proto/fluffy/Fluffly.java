// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fluffy/fluffly.proto

package com.proto.fluffy;

public final class Fluffly {
  private Fluffly() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fluffy_Text_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fluffy_Text_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fluffy_createTextRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fluffy_createTextRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fluffy_createTextResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fluffy_createTextResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fluffy_readTextRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fluffy_readTextRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fluffy_readTextResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fluffy_readTextResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fluffy_deleteTextRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fluffy_deleteTextRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fluffy_deleteTextResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fluffy_deleteTextResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fluffy_listTextRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fluffy_listTextRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fluffy_listTextResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fluffy_listTextResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fluffy_updateTextRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fluffy_updateTextRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_fluffy_updateTextResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_fluffy_updateTextResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024fluffy/fluffly.proto\022\006fluffy\"8\n\004Text\022\n" +
      "\n\002id\030\001 \001(\t\022\017\n\007content\030\002 \001(\t\022\023\n\013descripti" +
      "on\030\003 \001(\t\"/\n\021createTextRequest\022\032\n\004text\030\001 " +
      "\001(\0132\014.fluffy.Text\"0\n\022createTextResponse\022" +
      "\032\n\004text\030\001 \001(\0132\014.fluffy.Text\"\"\n\017readTextR" +
      "equest\022\017\n\007text_id\030\001 \001(\t\".\n\020readTextRespo" +
      "nse\022\032\n\004text\030\001 \001(\0132\014.fluffy.Text\"$\n\021delet" +
      "eTextRequest\022\017\n\007text_id\030\001 \001(\t\"%\n\022deleteT" +
      "extResponse\022\017\n\007text_id\030\001 \001(\t\"\021\n\017listText" +
      "Request\".\n\020listTextResponse\022\032\n\004text\030\001 \001(" +
      "\0132\014.fluffy.Text\"/\n\021updateTextRequest\022\032\n\004" +
      "text\030\001 \001(\0132\014.fluffy.Text\"0\n\022updateTextRe" +
      "sponse\022\032\n\004text\030\001 \001(\0132\014.fluffy.Text2\346\002\n\013T" +
      "extService\022E\n\nCreateText\022\031.fluffy.create" +
      "TextRequest\032\032.fluffy.createTextResponse\"" +
      "\000\022?\n\010ReadText\022\027.fluffy.readTextRequest\032\030" +
      ".fluffy.readTextResponse\"\000\022E\n\nUpdateText" +
      "\022\031.fluffy.updateTextRequest\032\032.fluffy.upd" +
      "ateTextResponse\"\000\022E\n\nDeleteText\022\031.fluffy" +
      ".deleteTextRequest\032\032.fluffy.deleteTextRe" +
      "sponse\"\000\022A\n\010ListText\022\027.fluffy.listTextRe" +
      "quest\032\030.fluffy.listTextResponse\"\0000\001B\024\n\020c" +
      "om.proto.fluffyP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_fluffy_Text_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_fluffy_Text_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fluffy_Text_descriptor,
        new java.lang.String[] { "Id", "Content", "Description", });
    internal_static_fluffy_createTextRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_fluffy_createTextRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fluffy_createTextRequest_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_fluffy_createTextResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_fluffy_createTextResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fluffy_createTextResponse_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_fluffy_readTextRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_fluffy_readTextRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fluffy_readTextRequest_descriptor,
        new java.lang.String[] { "TextId", });
    internal_static_fluffy_readTextResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_fluffy_readTextResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fluffy_readTextResponse_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_fluffy_deleteTextRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_fluffy_deleteTextRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fluffy_deleteTextRequest_descriptor,
        new java.lang.String[] { "TextId", });
    internal_static_fluffy_deleteTextResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_fluffy_deleteTextResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fluffy_deleteTextResponse_descriptor,
        new java.lang.String[] { "TextId", });
    internal_static_fluffy_listTextRequest_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_fluffy_listTextRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fluffy_listTextRequest_descriptor,
        new java.lang.String[] { });
    internal_static_fluffy_listTextResponse_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_fluffy_listTextResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fluffy_listTextResponse_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_fluffy_updateTextRequest_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_fluffy_updateTextRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fluffy_updateTextRequest_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_fluffy_updateTextResponse_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_fluffy_updateTextResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_fluffy_updateTextResponse_descriptor,
        new java.lang.String[] { "Text", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}