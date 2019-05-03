// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stock.proto

package stock;

/**
 * Protobuf type {@code stock.stockResponse}
 */
public  final class stockResponse extends
    com.google.protobuf.GeneratedMessage
    implements stockResponseOrBuilder {
  // Use stockResponse.newBuilder() to construct.
  private stockResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
    this.unknownFields = builder.getUnknownFields();
  }
  private stockResponse(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

  private static final stockResponse defaultInstance;
  public static stockResponse getDefaultInstance() {
    return defaultInstance;
  }

  public stockResponse getDefaultInstanceForType() {
    return defaultInstance;
  }

  private final com.google.protobuf.UnknownFieldSet unknownFields;
  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
      getUnknownFields() {
    return this.unknownFields;
  }
  private stockResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    initFields();
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
            if (!parseUnknownField(input, unknownFields,
                                   extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
              updatedCurrencies_ = new java.util.ArrayList<stock.currencyData>();
              mutable_bitField0_ |= 0x00000001;
            }
            updatedCurrencies_.add(input.readMessage(stock.currencyData.PARSER, extensionRegistry));
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e.getMessage()).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
        updatedCurrencies_ = java.util.Collections.unmodifiableList(updatedCurrencies_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return stock.Stock.internal_static_stock_stockResponse_descriptor;
  }

  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return stock.Stock.internal_static_stock_stockResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            stock.stockResponse.class, stock.stockResponse.Builder.class);
  }

  public static com.google.protobuf.Parser<stockResponse> PARSER =
      new com.google.protobuf.AbstractParser<stockResponse>() {
    public stockResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new stockResponse(input, extensionRegistry);
    }
  };

  @java.lang.Override
  public com.google.protobuf.Parser<stockResponse> getParserForType() {
    return PARSER;
  }

  // repeated .stock.currencyData updatedCurrencies = 1;
  public static final int UPDATEDCURRENCIES_FIELD_NUMBER = 1;
  private java.util.List<stock.currencyData> updatedCurrencies_;
  /**
   * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
   */
  public java.util.List<stock.currencyData> getUpdatedCurrenciesList() {
    return updatedCurrencies_;
  }
  /**
   * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
   */
  public java.util.List<? extends stock.currencyDataOrBuilder> 
      getUpdatedCurrenciesOrBuilderList() {
    return updatedCurrencies_;
  }
  /**
   * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
   */
  public int getUpdatedCurrenciesCount() {
    return updatedCurrencies_.size();
  }
  /**
   * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
   */
  public stock.currencyData getUpdatedCurrencies(int index) {
    return updatedCurrencies_.get(index);
  }
  /**
   * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
   */
  public stock.currencyDataOrBuilder getUpdatedCurrenciesOrBuilder(
      int index) {
    return updatedCurrencies_.get(index);
  }

  private void initFields() {
    updatedCurrencies_ = java.util.Collections.emptyList();
  }
  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized != -1) return isInitialized == 1;

    for (int i = 0; i < getUpdatedCurrenciesCount(); i++) {
      if (!getUpdatedCurrencies(i).isInitialized()) {
        memoizedIsInitialized = 0;
        return false;
      }
    }
    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    getSerializedSize();
    for (int i = 0; i < updatedCurrencies_.size(); i++) {
      output.writeMessage(1, updatedCurrencies_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  private int memoizedSerializedSize = -1;
  public int getSerializedSize() {
    int size = memoizedSerializedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < updatedCurrencies_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, updatedCurrencies_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSerializedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  protected java.lang.Object writeReplace()
      throws java.io.ObjectStreamException {
    return super.writeReplace();
  }

  public static stock.stockResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static stock.stockResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static stock.stockResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static stock.stockResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static stock.stockResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static stock.stockResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }
  public static stock.stockResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input);
  }
  public static stock.stockResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseDelimitedFrom(input, extensionRegistry);
  }
  public static stock.stockResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return PARSER.parseFrom(input);
  }
  public static stock.stockResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return PARSER.parseFrom(input, extensionRegistry);
  }

  public static Builder newBuilder() { return Builder.create(); }
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder(stock.stockResponse prototype) {
    return newBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() { return newBuilder(this); }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code stock.stockResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder>
     implements stock.stockResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return stock.Stock.internal_static_stock_stockResponse_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return stock.Stock.internal_static_stock_stockResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              stock.stockResponse.class, stock.stockResponse.Builder.class);
    }

    // Construct using stock.stockResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        getUpdatedCurrenciesFieldBuilder();
      }
    }
    private static Builder create() {
      return new Builder();
    }

    public Builder clear() {
      super.clear();
      if (updatedCurrenciesBuilder_ == null) {
        updatedCurrencies_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        updatedCurrenciesBuilder_.clear();
      }
      return this;
    }

    public Builder clone() {
      return create().mergeFrom(buildPartial());
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return stock.Stock.internal_static_stock_stockResponse_descriptor;
    }

    public stock.stockResponse getDefaultInstanceForType() {
      return stock.stockResponse.getDefaultInstance();
    }

    public stock.stockResponse build() {
      stock.stockResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public stock.stockResponse buildPartial() {
      stock.stockResponse result = new stock.stockResponse(this);
      int from_bitField0_ = bitField0_;
      if (updatedCurrenciesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          updatedCurrencies_ = java.util.Collections.unmodifiableList(updatedCurrencies_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.updatedCurrencies_ = updatedCurrencies_;
      } else {
        result.updatedCurrencies_ = updatedCurrenciesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof stock.stockResponse) {
        return mergeFrom((stock.stockResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(stock.stockResponse other) {
      if (other == stock.stockResponse.getDefaultInstance()) return this;
      if (updatedCurrenciesBuilder_ == null) {
        if (!other.updatedCurrencies_.isEmpty()) {
          if (updatedCurrencies_.isEmpty()) {
            updatedCurrencies_ = other.updatedCurrencies_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureUpdatedCurrenciesIsMutable();
            updatedCurrencies_.addAll(other.updatedCurrencies_);
          }
          onChanged();
        }
      } else {
        if (!other.updatedCurrencies_.isEmpty()) {
          if (updatedCurrenciesBuilder_.isEmpty()) {
            updatedCurrenciesBuilder_.dispose();
            updatedCurrenciesBuilder_ = null;
            updatedCurrencies_ = other.updatedCurrencies_;
            bitField0_ = (bitField0_ & ~0x00000001);
            updatedCurrenciesBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getUpdatedCurrenciesFieldBuilder() : null;
          } else {
            updatedCurrenciesBuilder_.addAllMessages(other.updatedCurrencies_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      return this;
    }

    public final boolean isInitialized() {
      for (int i = 0; i < getUpdatedCurrenciesCount(); i++) {
        if (!getUpdatedCurrencies(i).isInitialized()) {
          
          return false;
        }
      }
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      stock.stockResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (stock.stockResponse) e.getUnfinishedMessage();
        throw e;
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    // repeated .stock.currencyData updatedCurrencies = 1;
    private java.util.List<stock.currencyData> updatedCurrencies_ =
      java.util.Collections.emptyList();
    private void ensureUpdatedCurrenciesIsMutable() {
      if (!((bitField0_ & 0x00000001) == 0x00000001)) {
        updatedCurrencies_ = new java.util.ArrayList<stock.currencyData>(updatedCurrencies_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        stock.currencyData, stock.currencyData.Builder, stock.currencyDataOrBuilder> updatedCurrenciesBuilder_;

    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public java.util.List<stock.currencyData> getUpdatedCurrenciesList() {
      if (updatedCurrenciesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(updatedCurrencies_);
      } else {
        return updatedCurrenciesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public int getUpdatedCurrenciesCount() {
      if (updatedCurrenciesBuilder_ == null) {
        return updatedCurrencies_.size();
      } else {
        return updatedCurrenciesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public stock.currencyData getUpdatedCurrencies(int index) {
      if (updatedCurrenciesBuilder_ == null) {
        return updatedCurrencies_.get(index);
      } else {
        return updatedCurrenciesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public Builder setUpdatedCurrencies(
        int index, stock.currencyData value) {
      if (updatedCurrenciesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUpdatedCurrenciesIsMutable();
        updatedCurrencies_.set(index, value);
        onChanged();
      } else {
        updatedCurrenciesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public Builder setUpdatedCurrencies(
        int index, stock.currencyData.Builder builderForValue) {
      if (updatedCurrenciesBuilder_ == null) {
        ensureUpdatedCurrenciesIsMutable();
        updatedCurrencies_.set(index, builderForValue.build());
        onChanged();
      } else {
        updatedCurrenciesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public Builder addUpdatedCurrencies(stock.currencyData value) {
      if (updatedCurrenciesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUpdatedCurrenciesIsMutable();
        updatedCurrencies_.add(value);
        onChanged();
      } else {
        updatedCurrenciesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public Builder addUpdatedCurrencies(
        int index, stock.currencyData value) {
      if (updatedCurrenciesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureUpdatedCurrenciesIsMutable();
        updatedCurrencies_.add(index, value);
        onChanged();
      } else {
        updatedCurrenciesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public Builder addUpdatedCurrencies(
        stock.currencyData.Builder builderForValue) {
      if (updatedCurrenciesBuilder_ == null) {
        ensureUpdatedCurrenciesIsMutable();
        updatedCurrencies_.add(builderForValue.build());
        onChanged();
      } else {
        updatedCurrenciesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public Builder addUpdatedCurrencies(
        int index, stock.currencyData.Builder builderForValue) {
      if (updatedCurrenciesBuilder_ == null) {
        ensureUpdatedCurrenciesIsMutable();
        updatedCurrencies_.add(index, builderForValue.build());
        onChanged();
      } else {
        updatedCurrenciesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public Builder addAllUpdatedCurrencies(
        java.lang.Iterable<? extends stock.currencyData> values) {
      if (updatedCurrenciesBuilder_ == null) {
        ensureUpdatedCurrenciesIsMutable();
        super.addAll(values, updatedCurrencies_);
        onChanged();
      } else {
        updatedCurrenciesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public Builder clearUpdatedCurrencies() {
      if (updatedCurrenciesBuilder_ == null) {
        updatedCurrencies_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        updatedCurrenciesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public Builder removeUpdatedCurrencies(int index) {
      if (updatedCurrenciesBuilder_ == null) {
        ensureUpdatedCurrenciesIsMutable();
        updatedCurrencies_.remove(index);
        onChanged();
      } else {
        updatedCurrenciesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public stock.currencyData.Builder getUpdatedCurrenciesBuilder(
        int index) {
      return getUpdatedCurrenciesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public stock.currencyDataOrBuilder getUpdatedCurrenciesOrBuilder(
        int index) {
      if (updatedCurrenciesBuilder_ == null) {
        return updatedCurrencies_.get(index);  } else {
        return updatedCurrenciesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public java.util.List<? extends stock.currencyDataOrBuilder> 
         getUpdatedCurrenciesOrBuilderList() {
      if (updatedCurrenciesBuilder_ != null) {
        return updatedCurrenciesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(updatedCurrencies_);
      }
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public stock.currencyData.Builder addUpdatedCurrenciesBuilder() {
      return getUpdatedCurrenciesFieldBuilder().addBuilder(
          stock.currencyData.getDefaultInstance());
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public stock.currencyData.Builder addUpdatedCurrenciesBuilder(
        int index) {
      return getUpdatedCurrenciesFieldBuilder().addBuilder(
          index, stock.currencyData.getDefaultInstance());
    }
    /**
     * <code>repeated .stock.currencyData updatedCurrencies = 1;</code>
     */
    public java.util.List<stock.currencyData.Builder> 
         getUpdatedCurrenciesBuilderList() {
      return getUpdatedCurrenciesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        stock.currencyData, stock.currencyData.Builder, stock.currencyDataOrBuilder> 
        getUpdatedCurrenciesFieldBuilder() {
      if (updatedCurrenciesBuilder_ == null) {
        updatedCurrenciesBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            stock.currencyData, stock.currencyData.Builder, stock.currencyDataOrBuilder>(
                updatedCurrencies_,
                ((bitField0_ & 0x00000001) == 0x00000001),
                getParentForChildren(),
                isClean());
        updatedCurrencies_ = null;
      }
      return updatedCurrenciesBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:stock.stockResponse)
  }

  static {
    defaultInstance = new stockResponse(true);
    defaultInstance.initFields();
  }

  // @@protoc_insertion_point(class_scope:stock.stockResponse)
}

