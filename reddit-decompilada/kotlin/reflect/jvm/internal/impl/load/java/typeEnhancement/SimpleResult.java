package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: typeEnhancement.kt */
final class SimpleResult extends Result {
    final SimpleType f32760c;

    public SimpleResult(SimpleType simpleType, int i, boolean z) {
        Intrinsics.m26847b(simpleType, "type");
        super(simpleType, i, z);
        this.f32760c = simpleType;
    }

    public final /* bridge */ /* synthetic */ KotlinType mo5801a() {
        return this.f32760c;
    }
}
