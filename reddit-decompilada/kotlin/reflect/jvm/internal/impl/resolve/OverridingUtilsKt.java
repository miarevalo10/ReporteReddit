package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet.Companion;

/* compiled from: overridingUtils.kt */
public final class OverridingUtilsKt {
    public static final <H> Collection<H> m27708a(Collection<? extends H> collection, Function1<? super H, ? extends CallableDescriptor> function1) {
        Intrinsics.m26847b(collection, "$receiver");
        Intrinsics.m26847b(function1, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        collection = SmartSet.f26429a;
        collection = Companion.m28116a();
        while (true) {
            Collection collection2 = linkedList;
            if ((collection2.isEmpty() ^ 1) == 0) {
                return collection;
            }
            Object d = CollectionsKt___CollectionsKt.m41430d((List) linkedList);
            Companion companion = SmartSet.f26429a;
            SmartSet a = Companion.m28116a();
            collection2 = OverridingUtil.m27681a(d, collection2, (Function1) function1, (Function1) new C2985x410e6287(a));
            if (collection2.size() == 1 && a.isEmpty()) {
                Object h = CollectionsKt___CollectionsKt.m41440h((Iterable) collection2);
                Intrinsics.m26843a(h, "overridableGroup.single()");
                collection.add(h);
            } else {
                d = OverridingUtil.m27680a(collection2, (Function1) function1);
                CallableDescriptor callableDescriptor = (CallableDescriptor) function1.mo6492a(d);
                for (Object next : collection2) {
                    if (!OverridingUtil.m27697a(callableDescriptor, (CallableDescriptor) function1.mo6492a(next))) {
                        a.add(next);
                    }
                }
                Collection collection3 = a;
                if ((collection3.isEmpty() ^ 1) != 0) {
                    collection.addAll(collection3);
                }
                Intrinsics.m26843a(d, "mostSpecific");
                collection.add(d);
            }
        }
    }
}
