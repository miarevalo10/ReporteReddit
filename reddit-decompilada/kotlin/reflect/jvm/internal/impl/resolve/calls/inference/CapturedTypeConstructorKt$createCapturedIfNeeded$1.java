package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: CapturedTypeConstructor.kt */
final class CapturedTypeConstructorKt$createCapturedIfNeeded$1 extends Lambda implements Function0<KotlinType> {
    final /* synthetic */ TypeProjection f38806a;

    CapturedTypeConstructorKt$createCapturedIfNeeded$1(TypeProjection typeProjection) {
        this.f38806a = typeProjection;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object c = this.f38806a.mo6736c();
        Intrinsics.m26843a(c, "this@createCapturedIfNeeded.type");
        return c;
    }
}
