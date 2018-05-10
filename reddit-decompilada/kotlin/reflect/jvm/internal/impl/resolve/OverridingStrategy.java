package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* compiled from: OverridingStrategy.kt */
public abstract class OverridingStrategy {
    public abstract void mo6690a(CallableMemberDescriptor callableMemberDescriptor);

    public abstract void mo5915b(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public abstract void mo5916c(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2);

    public void mo6692a(CallableMemberDescriptor callableMemberDescriptor, Collection<? extends CallableMemberDescriptor> collection) {
        Intrinsics.m26847b(callableMemberDescriptor, "member");
        Intrinsics.m26847b(collection, "overridden");
        callableMemberDescriptor.mo7749a(collection);
    }
}
