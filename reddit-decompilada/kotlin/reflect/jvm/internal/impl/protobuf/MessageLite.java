package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;

public interface MessageLite extends MessageLiteOrBuilder {

    public interface Builder extends Cloneable, MessageLiteOrBuilder {
        Builder mo6723b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        MessageLite mo7302f();
    }

    Parser<? extends MessageLite> mo7112a();

    Builder mo7304c();

    Builder mo7305e();
}
