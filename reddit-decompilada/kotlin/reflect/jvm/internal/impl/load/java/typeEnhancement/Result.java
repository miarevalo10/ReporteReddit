package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: typeEnhancement.kt */
class Result {
    final int f25758a;
    final boolean f25759b;
    private final KotlinType f25760c;

    public Result(KotlinType kotlinType, int i, boolean z) {
        Intrinsics.m26847b(kotlinType, "type");
        this.f25760c = kotlinType;
        this.f25758a = i;
        this.f25759b = z;
    }

    public KotlinType mo5801a() {
        return this.f25760c;
    }
}
