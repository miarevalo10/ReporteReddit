package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class ByteValue extends IntegerValueConstant<Byte> {
    private final SimpleType f36143a;

    public ByteValue(byte b, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        super(Byte.valueOf(b));
        this.f36143a = kotlinBuiltIns.m27018p();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) mo5919b()).byteValue());
        stringBuilder.append(".toByte()");
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ KotlinType mo5917a() {
        return this.f36143a;
    }
}
