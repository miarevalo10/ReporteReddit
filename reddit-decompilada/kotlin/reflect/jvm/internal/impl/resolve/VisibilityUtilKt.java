package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;

/* compiled from: VisibilityUtil.kt */
public final class VisibilityUtilKt {
    public static final CallableMemberDescriptor m27709a(Collection<? extends CallableMemberDescriptor> collection) {
        Intrinsics.m26847b(collection, "descriptors");
        int isEmpty = collection.isEmpty() ^ 1;
        if (_Assertions.f25274a && isEmpty == 0) {
            throw new AssertionError("Assertion failed");
        }
        CallableMemberDescriptor callableMemberDescriptor = null;
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            if (callableMemberDescriptor != null) {
                Number b = Visibilities.m27097b(callableMemberDescriptor.mo7257j(), callableMemberDescriptor2.mo7257j());
                if (b != null && Intrinsics.m26838a(b.intValue(), 0) < 0) {
                }
            }
            callableMemberDescriptor = callableMemberDescriptor2;
        }
        if (callableMemberDescriptor == null) {
            Intrinsics.m26842a();
        }
        return callableMemberDescriptor;
    }
}
