// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fluffy/fluffly.proto

package com.proto.fluffy;

/**
 * Protobuf type {@code fluffy.updateTextRequest}
 */
public  final class updateTextRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:fluffy.updateTextRequest)
    updateTextRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use updateTextRequest.newBuilder() to construct.
  private updateTextRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private updateTextRequest() {
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private updateTextRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            com.proto.fluffy.Text.Builder subBuilder = null;
            if (text_ != null) {
              subBuilder = text_.toBuilder();
            }
            text_ = input.readMessage(com.proto.fluffy.Text.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(text_);
              text_ = subBuilder.buildPartial();
            }

            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.proto.fluffy.Fluffly.internal_static_fluffy_updateTextRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.proto.fluffy.Fluffly.internal_static_fluffy_updateTextRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.proto.fluffy.updateTextRequest.class, com.proto.fluffy.updateTextRequest.Builder.class);
  }

  public static final int TEXT_FIELD_NUMBER = 1;
  private com.proto.fluffy.Text text_;
  /**
   * <code>.fluffy.Text text = 1;</code>
   */
  public boolean hasText() {
    return text_ != null;
  }
  /**
   * <code>.fluffy.Text text = 1;</code>
   */
  public com.proto.fluffy.Text getText() {
    return text_ == null ? com.proto.fluffy.Text.getDefaultInstance() : text_;
  }
  /**
   * <code>.fluffy.Text text = 1;</code>
   */
  public com.proto.fluffy.TextOrBuilder getTextOrBuilder() {
    return getText();
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (text_ != null) {
      output.writeMessage(1, getText());
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (text_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getText());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.proto.fluffy.updateTextRequest)) {
      return super.equals(obj);
    }
    com.proto.fluffy.updateTextRequest other = (com.proto.fluffy.updateTextRequest) obj;

    boolean result = true;
    result = result && (hasText() == other.hasText());
    if (hasText()) {
      result = result && getText()
          .equals(other.getText());
    }
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasText()) {
      hash = (37 * hash) + TEXT_FIELD_NUMBER;
      hash = (53 * hash) + getText().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.proto.fluffy.updateTextRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.fluffy.updateTextRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.fluffy.updateTextRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.fluffy.updateTextRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.fluffy.updateTextRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.proto.fluffy.updateTextRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.proto.fluffy.updateTextRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.proto.fluffy.updateTextRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.proto.fluffy.updateTextRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.proto.fluffy.updateTextRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.proto.fluffy.updateTextRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.proto.fluffy.updateTextRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.proto.fluffy.updateTextRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code fluffy.updateTextRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:fluffy.updateTextRequest)
      com.proto.fluffy.updateTextRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.proto.fluffy.Fluffly.internal_static_fluffy_updateTextRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.proto.fluffy.Fluffly.internal_static_fluffy_updateTextRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.proto.fluffy.updateTextRequest.class, com.proto.fluffy.updateTextRequest.Builder.class);
    }

    // Construct using com.proto.fluffy.updateTextRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      if (textBuilder_ == null) {
        text_ = null;
      } else {
        text_ = null;
        textBuilder_ = null;
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.proto.fluffy.Fluffly.internal_static_fluffy_updateTextRequest_descriptor;
    }

    public com.proto.fluffy.updateTextRequest getDefaultInstanceForType() {
      return com.proto.fluffy.updateTextRequest.getDefaultInstance();
    }

    public com.proto.fluffy.updateTextRequest build() {
      com.proto.fluffy.updateTextRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.proto.fluffy.updateTextRequest buildPartial() {
      com.proto.fluffy.updateTextRequest result = new com.proto.fluffy.updateTextRequest(this);
      if (textBuilder_ == null) {
        result.text_ = text_;
      } else {
        result.text_ = textBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.proto.fluffy.updateTextRequest) {
        return mergeFrom((com.proto.fluffy.updateTextRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.proto.fluffy.updateTextRequest other) {
      if (other == com.proto.fluffy.updateTextRequest.getDefaultInstance()) return this;
      if (other.hasText()) {
        mergeText(other.getText());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.proto.fluffy.updateTextRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.proto.fluffy.updateTextRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.proto.fluffy.Text text_ = null;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.proto.fluffy.Text, com.proto.fluffy.Text.Builder, com.proto.fluffy.TextOrBuilder> textBuilder_;
    /**
     * <code>.fluffy.Text text = 1;</code>
     */
    public boolean hasText() {
      return textBuilder_ != null || text_ != null;
    }
    /**
     * <code>.fluffy.Text text = 1;</code>
     */
    public com.proto.fluffy.Text getText() {
      if (textBuilder_ == null) {
        return text_ == null ? com.proto.fluffy.Text.getDefaultInstance() : text_;
      } else {
        return textBuilder_.getMessage();
      }
    }
    /**
     * <code>.fluffy.Text text = 1;</code>
     */
    public Builder setText(com.proto.fluffy.Text value) {
      if (textBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        text_ = value;
        onChanged();
      } else {
        textBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.fluffy.Text text = 1;</code>
     */
    public Builder setText(
        com.proto.fluffy.Text.Builder builderForValue) {
      if (textBuilder_ == null) {
        text_ = builderForValue.build();
        onChanged();
      } else {
        textBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.fluffy.Text text = 1;</code>
     */
    public Builder mergeText(com.proto.fluffy.Text value) {
      if (textBuilder_ == null) {
        if (text_ != null) {
          text_ =
            com.proto.fluffy.Text.newBuilder(text_).mergeFrom(value).buildPartial();
        } else {
          text_ = value;
        }
        onChanged();
      } else {
        textBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.fluffy.Text text = 1;</code>
     */
    public Builder clearText() {
      if (textBuilder_ == null) {
        text_ = null;
        onChanged();
      } else {
        text_ = null;
        textBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.fluffy.Text text = 1;</code>
     */
    public com.proto.fluffy.Text.Builder getTextBuilder() {
      
      onChanged();
      return getTextFieldBuilder().getBuilder();
    }
    /**
     * <code>.fluffy.Text text = 1;</code>
     */
    public com.proto.fluffy.TextOrBuilder getTextOrBuilder() {
      if (textBuilder_ != null) {
        return textBuilder_.getMessageOrBuilder();
      } else {
        return text_ == null ?
            com.proto.fluffy.Text.getDefaultInstance() : text_;
      }
    }
    /**
     * <code>.fluffy.Text text = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.proto.fluffy.Text, com.proto.fluffy.Text.Builder, com.proto.fluffy.TextOrBuilder> 
        getTextFieldBuilder() {
      if (textBuilder_ == null) {
        textBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.proto.fluffy.Text, com.proto.fluffy.Text.Builder, com.proto.fluffy.TextOrBuilder>(
                getText(),
                getParentForChildren(),
                isClean());
        text_ = null;
      }
      return textBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:fluffy.updateTextRequest)
  }

  // @@protoc_insertion_point(class_scope:fluffy.updateTextRequest)
  private static final com.proto.fluffy.updateTextRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.proto.fluffy.updateTextRequest();
  }

  public static com.proto.fluffy.updateTextRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<updateTextRequest>
      PARSER = new com.google.protobuf.AbstractParser<updateTextRequest>() {
    public updateTextRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new updateTextRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<updateTextRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<updateTextRequest> getParserForType() {
    return PARSER;
  }

  public com.proto.fluffy.updateTextRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

