package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* compiled from: DeserializedClassDescriptor.kt */
public final class C2790xf150c8cf extends NonReportingOverrideStrategy {
    final /* synthetic */ Collection f36166a;

    protected final void mo6691a(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.m26847b(callableMemberDescriptor, "fromSuper");
        Intrinsics.m26847b(callableMemberDescriptor2, "fromCurrent");
    }

    C2790xf150c8cf(Collection collection) {
        this.f36166a = collection;
    }

    public final void mo6690a(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.m26847b(callableMemberDescriptor, "fakeOverride");
        OverridingUtil.m27693a(callableMemberDescriptor, null);
        Collection collection = this.f36166a;
        if (callableMemberDescriptor == null) {
            throw new TypeCastException("null cannot be cast to non-null type D");
        }
        collection.add(callableMemberDescriptor);
    }
}
