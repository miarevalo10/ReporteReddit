package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler;

/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt$firstOverridden$2 extends AbstractNodeHandler<CallableMemberDescriptor, CallableMemberDescriptor> {
    final /* synthetic */ ObjectRef f36150a;
    final /* synthetic */ Function1 f36151b;

    DescriptorUtilsKt$firstOverridden$2(ObjectRef objectRef, Function1 function1) {
        this.f36150a = objectRef;
        this.f36151b = function1;
    }

    public final /* synthetic */ boolean mo5948a(Object obj) {
        Intrinsics.m26847b((CallableMemberDescriptor) obj, "current");
        return ((CallableMemberDescriptor) this.f36150a.f25291a) == null ? true : null;
    }

    public final /* synthetic */ void mo5949b(Object obj) {
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
        Intrinsics.m26847b(callableMemberDescriptor, "current");
        if (((CallableMemberDescriptor) this.f36150a.f25291a) == null && ((Boolean) this.f36151b.mo6492a(callableMemberDescriptor)).booleanValue()) {
            this.f36150a.f25291a = callableMemberDescriptor;
        }
    }

    public final /* bridge */ /* synthetic */ Object mo6700a() {
        return (CallableMemberDescriptor) this.f36150a.f25291a;
    }
}
