package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* compiled from: ChainedMemberScope.kt */
public final class ChainedMemberScope implements MemberScope {
    public static final Companion f36152a = new Companion();
    private final String f36153b;
    private final List<MemberScope> f36154c;

    /* compiled from: ChainedMemberScope.kt */
    public static final class Companion {
        private Companion() {
        }
    }

    public ChainedMemberScope(String str, List<? extends MemberScope> list) {
        Intrinsics.m26847b(str, "debugName");
        Intrinsics.m26847b(list, "scopes");
        this.f36153b = str;
        this.f36154c = list;
    }

    public final ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        ClassifierDescriptor classifierDescriptor = null;
        for (MemberScope c : this.f36154c) {
            ClassifierDescriptor c2 = c.mo6699c(name, lookupLocation);
            if (c2 != null) {
                if (!(c2 instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) c2).mo7743n()) {
                    return c2;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = c2;
                }
            }
        }
        return classifierDescriptor;
    }

    public final Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        List<MemberScope> list = this.f36154c;
        if (list.isEmpty()) {
            return SetsKt__SetsKt.m26799a();
        }
        Collection<PropertyDescriptor> collection = null;
        for (MemberScope a : list) {
            collection = ScopeUtilsKt.m28084a(collection, a.mo6694a(name, lookupLocation));
        }
        if (collection == null) {
            collection = SetsKt__SetsKt.m26799a();
        }
        return collection;
    }

    public final Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        List<MemberScope> list = this.f36154c;
        if (list.isEmpty()) {
            return SetsKt__SetsKt.m26799a();
        }
        Collection<SimpleFunctionDescriptor> collection = null;
        for (MemberScope b : list) {
            collection = ScopeUtilsKt.m28084a(collection, b.mo6698b(name, lookupLocation));
        }
        if (collection == null) {
            collection = SetsKt__SetsKt.m26799a();
        }
        return collection;
    }

    public final Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        List<MemberScope> list = this.f36154c;
        if (list.isEmpty()) {
            return SetsKt__SetsKt.m26799a();
        }
        Collection<DeclarationDescriptor> collection = null;
        for (MemberScope a : list) {
            collection = ScopeUtilsKt.m28084a(collection, a.mo6695a(descriptorKindFilter, function1));
        }
        if (collection == null) {
            collection = SetsKt__SetsKt.m26799a();
        }
        return collection;
    }

    public final Set<Name> aE_() {
        Collection linkedHashSet = new LinkedHashSet();
        for (MemberScope aE_ : this.f36154c) {
            CollectionsKt__MutableCollectionsKt.m38194a(linkedHashSet, (Iterable) aE_.aE_());
        }
        return (Set) linkedHashSet;
    }

    public final Set<Name> aF_() {
        Collection linkedHashSet = new LinkedHashSet();
        for (MemberScope aF_ : this.f36154c) {
            CollectionsKt__MutableCollectionsKt.m38194a(linkedHashSet, (Iterable) aF_.aF_());
        }
        return (Set) linkedHashSet;
    }

    public final String toString() {
        return this.f36153b;
    }
}
