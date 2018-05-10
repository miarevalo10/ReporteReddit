package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy;

/* compiled from: NewKotlinTypeChecker.kt */
public final class NullabilityChecker {
    public static final NullabilityChecker f26351a = null;

    static {
        NullabilityChecker nullabilityChecker = new NullabilityChecker();
    }

    private NullabilityChecker() {
        f26351a = this;
    }

    static boolean m28033a(TypeCheckerContext typeCheckerContext, SimpleType simpleType, SupertypesPolicy supertypesPolicy) {
        return typeCheckerContext.m28041a(simpleType, NullabilityChecker$hasNotNullSupertype$1.f38940a, new NullabilityChecker$hasNotNullSupertype$2(supertypesPolicy));
    }

    static boolean m28032a(TypeCheckerContext typeCheckerContext, SimpleType simpleType, TypeConstructor typeConstructor) {
        return typeCheckerContext.m28041a(simpleType, new NullabilityChecker$hasPathByNotMarkedNullableNodes$1(typeConstructor), (Function1) NullabilityChecker$hasPathByNotMarkedNullableNodes$2.f38943a);
    }
}
