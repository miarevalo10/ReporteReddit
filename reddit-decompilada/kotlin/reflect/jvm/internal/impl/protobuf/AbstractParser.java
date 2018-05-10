package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    private static final ExtensionRegistryLite f32857a = ExtensionRegistryLite.m27504b();

    public final /* synthetic */ Object mo5862b(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return m33278d(inputStream, extensionRegistryLite);
    }

    private static MessageType m33275a(MessageType messageType) throws InvalidProtocolBufferException {
        if (messageType == null || messageType.mo7303g()) {
            return messageType;
        }
        UninitializedMessageException uninitializedMessageException;
        if (messageType instanceof AbstractMessageLite) {
            uninitializedMessageException = new UninitializedMessageException();
        } else {
            uninitializedMessageException = new UninitializedMessageException();
        }
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(uninitializedMessageException.getMessage());
        invalidProtocolBufferException.f25930a = messageType;
        throw invalidProtocolBufferException;
    }

    private MessageType m33276b(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        MessageLite messageLite;
        try {
            byteString = byteString.mo5876g();
            messageLite = (MessageLite) mo6731a((CodedInputStream) byteString, extensionRegistryLite);
            byteString.m27484a(0);
            return messageLite;
        } catch (ByteString byteString2) {
            byteString2.f25930a = messageLite;
            throw byteString2;
        } catch (ByteString byteString22) {
            throw byteString22;
        }
    }

    private MessageType m33277c(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        inputStream = CodedInputStream.m27474a(inputStream);
        MessageLite messageLite = (MessageLite) mo6731a((CodedInputStream) inputStream, extensionRegistryLite);
        try {
            inputStream.m27484a(0);
            return messageLite;
        } catch (InputStream inputStream2) {
            inputStream2.f25930a = messageLite;
            throw inputStream2;
        }
    }

    private MessageType m33278d(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return m33275a(m33277c(inputStream, extensionRegistryLite));
    }

    private MessageType m33279e(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return m33277c(new LimitedInputStream(inputStream, CodedInputStream.m27473a(read, inputStream)), extensionRegistryLite);
        } catch (InputStream inputStream2) {
            throw new InvalidProtocolBufferException(inputStream2.getMessage());
        }
    }

    public final /* synthetic */ Object mo5860a(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return m33275a(m33279e(inputStream, extensionRegistryLite));
    }

    public final /* synthetic */ Object mo5859a(InputStream inputStream) throws InvalidProtocolBufferException {
        return m33278d(inputStream, f32857a);
    }

    public final /* synthetic */ Object mo5861a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return m33275a(m33276b(byteString, extensionRegistryLite));
    }
}
