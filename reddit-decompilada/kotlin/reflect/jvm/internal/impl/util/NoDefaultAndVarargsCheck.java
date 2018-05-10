package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check.DefaultImpls;

/* compiled from: modifierChecks.kt */
final class NoDefaultAndVarargsCheck implements Check {
    public static final NoDefaultAndVarargsCheck f33091a = null;
    private static final String f33092b = "should not have varargs or parameters with default values";

    static {
        NoDefaultAndVarargsCheck noDefaultAndVarargsCheck = new NoDefaultAndVarargsCheck();
    }

    private NoDefaultAndVarargsCheck() {
        f33091a = this;
        f33092b = f33092b;
    }

    public final String mo5945b(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
        return DefaultImpls.m28076a(this, functionDescriptor);
    }

    public final String mo5943a() {
        return f33092b;
    }

    public final boolean mo5944a(FunctionDescriptor functionDescriptor) {
        Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
        functionDescriptor = functionDescriptor.mo7757k().iterator();
        boolean z;
        do {
            z = true;
            if (!functionDescriptor.hasNext()) {
                return true;
            }
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) functionDescriptor.next();
            if (DescriptorUtilsKt.m27740a(valueParameterDescriptor) || valueParameterDescriptor.mo7803n() != null) {
                z = false;
                continue;
            } else {
                continue;
            }
        } while (z);
        return false;
    }
}
