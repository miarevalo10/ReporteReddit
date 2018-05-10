package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class ExtensionReceiver extends AbstractReceiverValue implements ImplicitReceiver {
    private final CallableDescriptor f36162b;

    public ExtensionReceiver(CallableDescriptor callableDescriptor, KotlinType kotlinType) {
        if (callableDescriptor == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"callableDescriptor", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver", "<init>"}));
        } else if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"receiverType", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver", "<init>"}));
        } else {
            super(kotlinType);
            this.f36162b = callableDescriptor;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mo5715a());
        stringBuilder.append(": Ext {");
        stringBuilder.append(this.f36162b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
