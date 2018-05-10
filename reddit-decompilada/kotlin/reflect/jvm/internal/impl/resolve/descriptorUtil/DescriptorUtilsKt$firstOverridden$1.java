package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;

/* compiled from: DescriptorUtils.kt */
final class DescriptorUtilsKt$firstOverridden$1<N> implements Neighbors<N> {
    final /* synthetic */ boolean f32948a = false;

    DescriptorUtilsKt$firstOverridden$1() {
    }

    public final /* synthetic */ Iterable mo5785a(Object obj) {
        obj = (CallableMemberDescriptor) obj;
        if (this.f32948a) {
            obj = obj != null ? obj.mo7759s() : null;
        }
        if (obj != null) {
            obj = obj.mo7609m();
            if (obj != null) {
                return (Iterable) obj;
            }
        }
        return CollectionsKt__CollectionsKt.m26790a();
    }
}
