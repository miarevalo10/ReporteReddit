package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: OverridingStrategy.kt */
public abstract class NonReportingOverrideStrategy extends OverridingStrategy {
    public abstract void mo6691a(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public final void mo5915b(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.m26847b(callableMemberDescriptor, "fromSuper");
        Intrinsics.m26847b(callableMemberDescriptor2, "fromCurrent");
        mo6691a(callableMemberDescriptor, callableMemberDescriptor2);
    }

    public final void mo5916c(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.m26847b(callableMemberDescriptor, "first");
        Intrinsics.m26847b(callableMemberDescriptor2, "second");
        mo6691a(callableMemberDescriptor, callableMemberDescriptor2);
    }
}
