package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: NewKotlinTypeChecker.kt */
final class NewKotlinTypeChecker$hasNothingSupertype$1 extends FunctionReference implements Function1<KotlinType, Boolean> {
    public static final NewKotlinTypeChecker$hasNothingSupertype$1 f38936a = new NewKotlinTypeChecker$hasNothingSupertype$1();

    NewKotlinTypeChecker$hasNothingSupertype$1() {
        super(1);
    }

    public final KDeclarationContainer mo6931a() {
        return Reflection.m26850a(KotlinBuiltIns.class);
    }

    public final String mo5687b() {
        return "isNothingOrNullableNothing";
    }

    public final String mo6932c() {
        return "isNothingOrNullableNothing(Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        KotlinType kotlinType = (KotlinType) obj;
        Intrinsics.m26847b(kotlinType, "p1");
        return Boolean.valueOf(KotlinBuiltIns.m26990f(kotlinType));
    }
}
