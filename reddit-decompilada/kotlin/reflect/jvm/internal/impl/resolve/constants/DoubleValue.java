package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class DoubleValue extends ConstantValue<Double> {
    private final SimpleType f32939a;

    public DoubleValue(double d, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        super(Double.valueOf(d));
        this.f32939a = kotlinBuiltIns.m27023u();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) mo5919b()).doubleValue());
        stringBuilder.append(".toDouble()");
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ KotlinType mo5917a() {
        return this.f32939a;
    }
}
