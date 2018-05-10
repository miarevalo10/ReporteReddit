package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;

/* compiled from: NewKotlinTypeChecker.kt */
final class NewKotlinTypeChecker$findCorrespondingSupertypes$1 extends Lambda implements Function3<TypeCheckerContext, SimpleType, TypeConstructor, List<? extends SimpleType>> {
    public static final NewKotlinTypeChecker$findCorrespondingSupertypes$1 f38933a = new NewKotlinTypeChecker$findCorrespondingSupertypes$1();

    NewKotlinTypeChecker$findCorrespondingSupertypes$1() {
        super(3);
    }

    public static List<SimpleType> m38690a(TypeCheckerContext typeCheckerContext, SimpleType simpleType, TypeConstructor typeConstructor) {
        Intrinsics.m26847b(typeCheckerContext, "$receiver");
        Intrinsics.m26847b(simpleType, "classType");
        Intrinsics.m26847b(typeConstructor, "constructor");
        NewKotlinTypeChecker newKotlinTypeChecker = NewKotlinTypeChecker.f33078b;
        newKotlinTypeChecker = NewKotlinTypeChecker.f33078b;
        return NewKotlinTypeChecker.m33626a(NewKotlinTypeChecker.m33636c(typeCheckerContext, simpleType, typeConstructor));
    }
}
