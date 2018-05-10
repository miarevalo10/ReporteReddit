package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy.None;

/* compiled from: NewKotlinTypeChecker.kt */
final class NullabilityChecker$hasNotNullSupertype$2 extends Lambda implements Function1<SimpleType, SupertypesPolicy> {
    final /* synthetic */ SupertypesPolicy f38941a;

    NullabilityChecker$hasNotNullSupertype$2(SupertypesPolicy supertypesPolicy) {
        this.f38941a = supertypesPolicy;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        SimpleType simpleType = (SimpleType) obj;
        Intrinsics.m26847b(simpleType, "it");
        return simpleType.mo6741c() != null ? (SupertypesPolicy) None.f33081a : this.f38941a;
    }
}
