package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* compiled from: CapturedTypeApproximation.kt */
final class CapturedTypeApproximationKt$approximateCapturedTypes$1 extends Lambda implements Function1<KotlinType, KotlinType> {
    final /* synthetic */ KotlinType f38946a;

    CapturedTypeApproximationKt$approximateCapturedTypes$1(KotlinType kotlinType) {
        this.f38946a = kotlinType;
        super(1);
    }

    public final KotlinType m38709a(KotlinType kotlinType) {
        Intrinsics.m26847b(kotlinType, "$receiver");
        return TypeUtils.m28013b(kotlinType, this.f38946a.mo6741c());
    }
}
