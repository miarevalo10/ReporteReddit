package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: NewKotlinTypeChecker.kt */
final class NullabilityChecker$hasPathByNotMarkedNullableNodes$1 extends Lambda implements Function1<SimpleType, Boolean> {
    final /* synthetic */ TypeConstructor f38942a;

    NullabilityChecker$hasPathByNotMarkedNullableNodes$1(TypeConstructor typeConstructor) {
        this.f38942a = typeConstructor;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        SimpleType simpleType = (SimpleType) obj;
        Intrinsics.m26847b(simpleType, "it");
        obj = (simpleType.mo6741c() || Intrinsics.m26845a(simpleType.mo6743g(), this.f38942a) == null) ? null : true;
        return Boolean.valueOf(obj);
    }
}
