package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: CapturedTypeApproximation.kt */
public final class C2802x12aaa596 extends TypeConstructorSubstitution {
    C2802x12aaa596() {
    }

    public final TypeProjection mo6737a(TypeConstructor typeConstructor) {
        Intrinsics.m26847b(typeConstructor, "key");
        if (!(typeConstructor instanceof CapturedTypeConstructor)) {
            typeConstructor = null;
        }
        CapturedTypeConstructor capturedTypeConstructor = (CapturedTypeConstructor) typeConstructor;
        if (capturedTypeConstructor == null) {
            return null;
        }
        return capturedTypeConstructor.f32935b.mo6734a() ? new TypeProjectionImpl(Variance.f26339c, capturedTypeConstructor.f32935b.mo6736c()) : capturedTypeConstructor.f32935b;
    }
}
