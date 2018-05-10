package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class LongValue extends IntegerValueConstant<Long> {
    private final SimpleType f36148a;

    public LongValue(long j, KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.m26847b(kotlinBuiltIns, "builtIns");
        super(Long.valueOf(j));
        this.f36148a = kotlinBuiltIns.m27021s();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(((Number) mo5919b()).longValue());
        stringBuilder.append(".toLong()");
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ KotlinType mo5917a() {
        return this.f36148a;
    }
}
