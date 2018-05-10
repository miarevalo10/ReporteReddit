package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: CapturedTypeApproximation.kt */
final class CapturedTypeApproximationKt$toTypeProjection$2 extends Lambda implements Function1<Variance, Variance> {
    final /* synthetic */ TypeArgument f38949a;

    CapturedTypeApproximationKt$toTypeProjection$2(TypeArgument typeArgument) {
        this.f38949a = typeArgument;
        super(1);
    }

    public final Variance m38713a(Variance variance) {
        Intrinsics.m26847b(variance, "variance");
        return Intrinsics.m26845a((Object) variance, this.f38949a.f26372a.mo7716k()) ? Variance.f26337a : variance;
    }
}
