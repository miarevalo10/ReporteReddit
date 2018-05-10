package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;

/* compiled from: DescriptorUtils.kt */
final class DescriptorUtilsKt$hasDefaultValue$1<N> implements Neighbors<ValueParameterDescriptor> {
    public static final DescriptorUtilsKt$hasDefaultValue$1 f32949a = new DescriptorUtilsKt$hasDefaultValue$1();

    DescriptorUtilsKt$hasDefaultValue$1() {
    }

    public final /* synthetic */ Iterable mo5785a(Object obj) {
        Iterable<ValueParameterDescriptor> m = ((ValueParameterDescriptor) obj).mo7609m();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(m));
        for (ValueParameterDescriptor o : m) {
            arrayList.add(o.mo7804o());
        }
        return (List) arrayList;
    }
}
