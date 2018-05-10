package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy.LowerIfFlexible;
import kotlin.reflect.jvm.internal.impl.types.checker.TypeCheckerContext.SupertypesPolicy.None;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: NewKotlinTypeChecker.kt */
final class NewKotlinTypeChecker$findCorrespondingSupertypes$3 extends Lambda implements Function1<SimpleType, SupertypesPolicy> {
    final /* synthetic */ SmartList f38935a;

    NewKotlinTypeChecker$findCorrespondingSupertypes$3(SmartList smartList) {
        this.f38935a = smartList;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        SimpleType simpleType = (SimpleType) obj;
        Intrinsics.m26847b(simpleType, "it");
        if (!(simpleType.mo6743g().mo5724c() instanceof ClassDescriptor)) {
            return (SupertypesPolicy) LowerIfFlexible.f33079a;
        }
        this.f38935a.add(simpleType);
        return (SupertypesPolicy) None.f33081a;
    }
}
