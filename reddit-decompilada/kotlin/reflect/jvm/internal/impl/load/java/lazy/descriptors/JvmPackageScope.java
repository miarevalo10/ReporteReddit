package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.UtilsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;

/* compiled from: JvmPackageScope.kt */
public final class JvmPackageScope implements MemberScope {
    static final /* synthetic */ KProperty[] f36091b = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(JvmPackageScope.class), "kotlinScopes", "getKotlinScopes()Ljava/util/List;"))};
    public final LazyJavaPackageScope f36092a;
    private final NotNullLazyValue f36093c = this.f36094d.f25703b.f25685a.mo5926a((Function0) new JvmPackageScope$kotlinScopes$2(this));
    private final LazyJavaResolverContext f36094d;
    private final LazyJavaPackageFragment f36095e;

    private final List<MemberScope> m36260c() {
        return (List) StorageKt.m27920a(this.f36093c, f36091b[0]);
    }

    public JvmPackageScope(LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage, LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Intrinsics.m26847b(javaPackage, "jPackage");
        Intrinsics.m26847b(lazyJavaPackageFragment, "packageFragment");
        this.f36094d = lazyJavaResolverContext;
        this.f36095e = lazyJavaPackageFragment;
        this.f36092a = new LazyJavaPackageScope(this.f36094d, javaPackage, this.f36095e);
    }

    public final ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        m36258a(lookupLocation, name);
        ClassDescriptor d = this.f36092a.m41500d(name, lookupLocation);
        if (d != null) {
            return d;
        }
        ClassifierDescriptor classifierDescriptor = null;
        for (MemberScope c : m36260c()) {
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
        m36258a(lookupLocation, name);
        Collection<PropertyDescriptor> a = this.f36092a.mo6694a(name, lookupLocation);
        for (MemberScope a2 : m36260c()) {
            a = ScopeUtilsKt.m28084a(a, a2.mo6694a(name, lookupLocation));
        }
        return a == null ? SetsKt__SetsKt.m26799a() : a;
    }

    public final Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        m36258a(lookupLocation, name);
        Collection<SimpleFunctionDescriptor> b = this.f36092a.mo6698b(name, lookupLocation);
        for (MemberScope b2 : m36260c()) {
            b = ScopeUtilsKt.m28084a(b, b2.mo6698b(name, lookupLocation));
        }
        return b == null ? SetsKt__SetsKt.m26799a() : b;
    }

    public final Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        Collection<DeclarationDescriptor> a = this.f36092a.mo6695a(descriptorKindFilter, function1);
        for (MemberScope a2 : m36260c()) {
            a = ScopeUtilsKt.m28084a(a, a2.mo6695a(descriptorKindFilter, function1));
        }
        return a == null ? SetsKt__SetsKt.m26799a() : a;
    }

    public final Set<Name> aE_() {
        Collection linkedHashSet = new LinkedHashSet();
        for (MemberScope aE_ : m36260c()) {
            CollectionsKt__MutableCollectionsKt.m38194a(linkedHashSet, (Iterable) aE_.aE_());
        }
        Set<Name> set = (Set) linkedHashSet;
        set.addAll(this.f36092a.aE_());
        return set;
    }

    public final Set<Name> aF_() {
        Collection linkedHashSet = new LinkedHashSet();
        for (MemberScope aF_ : m36260c()) {
            CollectionsKt__MutableCollectionsKt.m38194a(linkedHashSet, (Iterable) aF_.aF_());
        }
        Set<Name> set = (Set) linkedHashSet;
        set.addAll(this.f36092a.aF_());
        return set;
    }

    private final void m36258a(LookupLocation lookupLocation, Name name) {
        UtilsKt.m27124a(this.f36094d.f25703b.f25699o, lookupLocation, (PackageFragmentDescriptor) this.f36095e, name);
    }
}
