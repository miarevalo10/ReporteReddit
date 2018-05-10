package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude.TopLevelPackages;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: SubpackagesScope.kt */
public class SubpackagesScope extends MemberScopeImpl {
    private final ModuleDescriptor f38357a;
    private final FqName f38358b;

    public SubpackagesScope(ModuleDescriptor moduleDescriptor, FqName fqName) {
        Intrinsics.m26847b(moduleDescriptor, "moduleDescriptor");
        Intrinsics.m26847b(fqName, "fqName");
        this.f38357a = moduleDescriptor;
        this.f38358b = fqName;
    }

    public final Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        Companion companion = DescriptorKindFilter.f26123m;
        if (!descriptorKindFilter.m27787a(Companion.m27763d())) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        if (this.f38358b.f25856b.f25861b.isEmpty() && descriptorKindFilter.f26138b.contains(TopLevelPackages.f32952a) != null) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        DescriptorKindFilter<FqName> a = this.f38357a.mo7086a(this.f38358b, function1);
        ArrayList arrayList = new ArrayList(a.size());
        for (FqName e : a) {
            FqName e2;
            Name e3 = e2.m27412e();
            Intrinsics.m26843a((Object) e3, "shortName");
            if (((Boolean) function1.mo6492a(e3)).booleanValue()) {
                Collection collection = arrayList;
                Intrinsics.m26843a((Object) e3, "shortName");
                Intrinsics.m26847b(e3, "name");
                Object obj = null;
                if (!e3.f25866a) {
                    ModuleDescriptor moduleDescriptor = this.f38357a;
                    e2 = this.f38358b.m27408a(e3);
                    Intrinsics.m26843a((Object) e2, "fqName.child(name)");
                    PackageViewDescriptor a2 = moduleDescriptor.mo7087a(e2);
                    if (!a2.mo7084g()) {
                        obj = a2;
                    }
                }
                CollectionsKt.m28092a(collection, obj);
            }
        }
        return arrayList;
    }
}
