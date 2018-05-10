package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check.DefaultImpls;

/* compiled from: modifierChecks.kt */
final class IsKPropertyCheck implements Check {
    public static final IsKPropertyCheck f33087a = null;
    private static final String f33088b = "second parameter must have a KProperty type or its supertype";

    static {
        IsKPropertyCheck isKPropertyCheck = new IsKPropertyCheck();
    }

    private IsKPropertyCheck() {
        f33087a = this;
        f33088b = f33088b;
    }

    public final String mo5945b(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
        return DefaultImpls.m28076a(this, functionDescriptor);
    }

    public final String mo5943a() {
        return f33088b;
    }

    public final boolean mo5944a(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
        ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) functionDescriptor.mo7757k().get(1);
        Companion companion = ReflectionTypes.f25444c;
        KotlinType a = Companion.m27031a(DescriptorUtilsKt.m27744c((DeclarationDescriptor) valueParameterDescriptor));
        if (a == null) {
            return null;
        }
        KotlinType c = TypeUtilsKt.m28066c(valueParameterDescriptor.mo7777x());
        Intrinsics.m26843a((Object) c, "secondParameter.type.makeNotNullable()");
        return TypeUtilsKt.m28064a(a, c);
    }
}
