package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: NewKotlinTypeChecker.kt */
final class NewKotlinTypeChecker$transformToNewType$lowerType$1 extends Lambda implements Function1<TypeProjection, Boolean> {
    public static final NewKotlinTypeChecker$transformToNewType$lowerType$1 f38939a = new NewKotlinTypeChecker$transformToNewType$lowerType$1();

    NewKotlinTypeChecker$transformToNewType$lowerType$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        TypeProjection typeProjection = (TypeProjection) obj;
        Intrinsics.m26847b(typeProjection, "it");
        return Boolean.valueOf(Intrinsics.m26845a(typeProjection.mo6735b(), Variance.f26338b));
    }
}
