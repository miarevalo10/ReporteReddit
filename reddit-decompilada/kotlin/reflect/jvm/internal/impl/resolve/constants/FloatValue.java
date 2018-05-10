package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class FloatValue extends ConstantValue<Float> {
    private final SimpleType f32941a;

    public FloatValue(float f, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        super(Float.valueOf(f));
        this.f32941a = kotlinBuiltIns.m27022t();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) mo5919b()).floatValue());
        stringBuilder.append(".toFloat()");
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ KotlinType mo5917a() {
        return this.f32941a;
    }
}
