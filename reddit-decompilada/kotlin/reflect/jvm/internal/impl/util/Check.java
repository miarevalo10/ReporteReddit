package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;

/* compiled from: modifierChecks.kt */
public interface Check {

    /* compiled from: modifierChecks.kt */
    public static final class DefaultImpls {
        public static String m28076a(Check check, FunctionDescriptor functionDescriptor) {
            Intrinsics.m26847b(functionDescriptor, "functionDescriptor");
            return check.mo5944a(functionDescriptor) == null ? check.mo5943a() : null;
        }
    }

    String mo5943a();

    boolean mo5944a(FunctionDescriptor functionDescriptor);

    String mo5945b(FunctionDescriptor functionDescriptor);
}
