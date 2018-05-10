package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.Result;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* compiled from: JvmBuiltInsSettings.kt */
final class JvmBuiltInsSettings$getConstructors$1 extends Lambda implements Function2<ConstructorDescriptor, ConstructorDescriptor, Boolean> {
    final /* synthetic */ TypeSubstitutor f38775a;

    JvmBuiltInsSettings$getConstructors$1(TypeSubstitutor typeSubstitutor) {
        this.f38775a = typeSubstitutor;
        super(2);
    }

    public final /* synthetic */ Object mo6497a(Object obj, Object obj2) {
        return Boolean.valueOf(m38534a((ConstructorDescriptor) obj, (ConstructorDescriptor) obj2));
    }

    public final boolean m38534a(ConstructorDescriptor constructorDescriptor, ConstructorDescriptor constructorDescriptor2) {
        Intrinsics.m26847b(constructorDescriptor, "$receiver");
        Intrinsics.m26847b(constructorDescriptor2, "javaConstructor");
        return Intrinsics.m26845a(OverridingUtil.m27703b(constructorDescriptor, constructorDescriptor2.mo7819c(this.f38775a)), Result.OVERRIDABLE);
    }
}
