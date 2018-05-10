package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: NewKotlinTypeChecker.kt */
final class NullabilityChecker$hasNotNullSupertype$1 extends Lambda implements Function1<SimpleType, Boolean> {
    public static final NullabilityChecker$hasNotNullSupertype$1 f38940a = new NullabilityChecker$hasNotNullSupertype$1();

    NullabilityChecker$hasNotNullSupertype$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        SimpleType simpleType = (SimpleType) obj;
        Intrinsics.m26847b(simpleType, "it");
        obj = ((simpleType.mo6743g().mo5724c() instanceof ClassDescriptor) && simpleType.mo6741c() == null) ? true : null;
        return Boolean.valueOf(obj);
    }
}
