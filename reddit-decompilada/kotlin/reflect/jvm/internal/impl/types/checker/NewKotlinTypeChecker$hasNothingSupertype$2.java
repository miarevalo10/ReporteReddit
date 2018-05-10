package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy.LowerIfFlexible;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy.None;

/* compiled from: NewKotlinTypeChecker.kt */
final class NewKotlinTypeChecker$hasNothingSupertype$2 extends Lambda implements Function1<SimpleType, SupertypesPolicy> {
    public static final NewKotlinTypeChecker$hasNothingSupertype$2 f38937a = new NewKotlinTypeChecker$hasNothingSupertype$2();

    NewKotlinTypeChecker$hasNothingSupertype$2() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        SimpleType simpleType = (SimpleType) obj;
        Intrinsics.m26847b(simpleType, "it");
        if ((simpleType.mo6743g().mo5724c() instanceof ClassDescriptor) != null) {
            return (SupertypesPolicy) None.f33081a;
        }
        return (SupertypesPolicy) LowerIfFlexible.f33079a;
    }
}
