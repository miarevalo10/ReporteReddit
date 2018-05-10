package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class NullValue extends ConstantValue<Void> {
    private final SimpleType f32946a;

    public final String toString() {
        return "null";
    }

    public NullValue(KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        super(null);
        kotlinBuiltIns = kotlinBuiltIns.m27014l().mo7297b(true);
        if (kotlinBuiltIns == null) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getNullableNothingType"}));
        } else {
            this.f32946a = kotlinBuiltIns;
        }
    }

    public final /* bridge */ /* synthetic */ KotlinType mo5917a() {
        return this.f32946a;
    }
}
