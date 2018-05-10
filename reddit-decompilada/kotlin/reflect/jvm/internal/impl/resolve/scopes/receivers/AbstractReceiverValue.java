package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;

public abstract class AbstractReceiverValue implements ReceiverValue {
    protected final KotlinType f32954a;

    public AbstractReceiverValue(KotlinType kotlinType) {
        if (kotlinType == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"receiverType", "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue", "<init>"}));
        } else {
            this.f32954a = kotlinType;
        }
    }

    public final KotlinType mo5715a() {
        KotlinType kotlinType = this.f32954a;
        if (kotlinType != null) {
            return kotlinType;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue", "getType"}));
    }
}
