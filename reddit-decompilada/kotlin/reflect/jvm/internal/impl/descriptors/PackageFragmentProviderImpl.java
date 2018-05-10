package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: PackageFragmentProviderImpl.kt */
public final class PackageFragmentProviderImpl implements PackageFragmentProvider {
    private final Collection<PackageFragmentDescriptor> f32637a;

    public PackageFragmentProviderImpl(Collection<? extends PackageFragmentDescriptor> collection) {
        Intrinsics.m26847b(collection, "packageFragments");
        this.f32637a = collection;
    }

    public final List<PackageFragmentDescriptor> mo5712a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        Collection arrayList = new ArrayList();
        for (Object next : this.f32637a) {
            if (Intrinsics.m26845a(((PackageFragmentDescriptor) next).mo7722d(), (Object) fqName)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final Collection<FqName> mo5711a(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(fqName, "fqName");
        Intrinsics.m26847b(function1, "nameFilter");
        return SequencesKt___SequencesKt.m33713d(SequencesKt___SequencesKt.m33708a((Sequence) SequencesKt___SequencesKt.m33716e(CollectionsKt___CollectionsKt.m41455t((Iterable) this.f32637a), PackageFragmentProviderImpl$getSubPackagesOf$1.f38326a), (Function1) new PackageFragmentProviderImpl$getSubPackagesOf$2(fqName)));
    }
}
