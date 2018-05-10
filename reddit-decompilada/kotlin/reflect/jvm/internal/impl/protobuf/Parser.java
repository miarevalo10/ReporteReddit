package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

public interface Parser<MessageType> {
    MessageType mo5859a(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType mo5860a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType mo5861a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType mo6731a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType mo5862b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;
}
