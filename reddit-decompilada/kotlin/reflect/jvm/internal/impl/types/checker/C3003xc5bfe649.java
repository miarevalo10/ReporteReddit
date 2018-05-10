package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: NewKotlinTypeChecker.kt */
final class C3003xc5bfe649 extends Lambda implements Function1<TypeProjection, Boolean> {
    public static final C3003xc5bfe649 f38938a = new C3003xc5bfe649();

    C3003xc5bfe649() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        TypeProjection typeProjection = (TypeProjection) obj;
        Intrinsics.m26847b(typeProjection, "it");
        return Boolean.valueOf(Intrinsics.m26845a(typeProjection.mo6735b(), Variance.f26337a));
    }
}
