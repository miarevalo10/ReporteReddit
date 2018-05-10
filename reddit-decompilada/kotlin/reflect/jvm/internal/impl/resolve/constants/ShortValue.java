package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class ShortValue extends IntegerValueConstant<Short> {
    private final SimpleType f36149a;

    public ShortValue(short s, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        super(Short.valueOf(s));
        this.f36149a = kotlinBuiltIns.m27019q();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) mo5919b()).shortValue());
        stringBuilder.append(".toShort()");
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ KotlinType mo5917a() {
        return this.f36149a;
    }
}
