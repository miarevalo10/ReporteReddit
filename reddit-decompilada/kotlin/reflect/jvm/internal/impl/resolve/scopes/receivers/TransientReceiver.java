package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public class TransientReceiver extends AbstractReceiverValue {
    public TransientReceiver(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"type", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver", "<init>"}));
        } else {
            super(kotlinType);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{Transient} : ");
        stringBuilder.append(mo5715a());
        return stringBuilder.toString();
    }
}
