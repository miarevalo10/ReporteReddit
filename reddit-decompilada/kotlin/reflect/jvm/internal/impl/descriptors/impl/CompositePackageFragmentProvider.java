package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: CompositePackageFragmentProvider.kt */
public final class CompositePackageFragmentProvider implements PackageFragmentProvider {
    private final List<PackageFragmentProvider> f32645a;

    public CompositePackageFragmentProvider(List<? extends PackageFragmentProvider> list) {
        Intrinsics.m26847b(list, "providers");
        this.f32645a = list;
    }

    public final List<PackageFragmentDescriptor> mo5712a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        for (PackageFragmentProvider a : this.f32645a) {
            arrayList.addAll(a.mo5712a(fqName));
        }
        return CollectionsKt.m28089a((Collection) arrayList);
    }

    public final Collection<FqName> mo5711a(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(fqName, "fqName");
        Intrinsics.m26847b(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        for (PackageFragmentProvider a : this.f32645a) {
            hashSet.addAll(a.mo5711a(fqName, function1));
        }
        return hashSet;
    }
}
