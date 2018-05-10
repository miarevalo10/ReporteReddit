package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* compiled from: MemberScopeImpl.kt */
public abstract class MemberScopeImpl implements MemberScope {
    public ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return null;
    }

    public Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        return CollectionsKt__CollectionsKt.m26790a();
    }

    public Set<Name> aE_() {
        Collection arrayList = new ArrayList();
        for (Object next : mo6695a(DescriptorKindFilter.f26120j, FunctionsKt.m28106b())) {
            if (next instanceof SimpleFunctionDescriptor) {
                arrayList.add(next);
            }
        }
        Collection linkedHashSet = new LinkedHashSet();
        for (SimpleFunctionDescriptor i : (List) arrayList) {
            linkedHashSet.add(i.mo6689i());
        }
        return (Set) linkedHashSet;
    }

    public Set<Name> aF_() {
        Collection arrayList = new ArrayList();
        for (Object next : mo6695a(DescriptorKindFilter.f26121k, FunctionsKt.m28106b())) {
            if (next instanceof VariableDescriptor) {
                arrayList.add(next);
            }
        }
        Collection linkedHashSet = new LinkedHashSet();
        for (VariableDescriptor i : (List) arrayList) {
            linkedHashSet.add(i.mo6689i());
        }
        return (Set) linkedHashSet;
    }
}
