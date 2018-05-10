package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.UtilKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
import kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors;
import kotlin.reflect.jvm.internal.impl.utils.DFS.NodeHandler;

/* compiled from: LazyJavaStaticClassScope.kt */
public final class LazyJavaStaticClassScope extends LazyJavaStaticScope {
    final LazyJavaClassDescriptor f40291a;
    private final JavaClass f40292b;

    public final ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return null;
    }

    public LazyJavaStaticClassScope(LazyJavaResolverContext lazyJavaResolverContext, JavaClass javaClass, LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Intrinsics.m26847b(javaClass, "jClass");
        Intrinsics.m26847b(lazyJavaClassDescriptor, "ownerDescriptor");
        super(lazyJavaResolverContext);
        this.f40292b = javaClass;
        this.f40291a = lazyJavaClassDescriptor;
    }

    protected final Set<Name> mo7265c(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        return SetsKt__SetsKt.m26799a();
    }

    private static <R> Set<R> m41502a(ClassDescriptor classDescriptor, Set<R> set, Function1<? super MemberScope, ? extends Collection<? extends R>> function1) {
        DFS.m28101a((Collection) CollectionsKt__CollectionsKt.m26791a((Object) classDescriptor), (Neighbors) LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$1.f32730a, (NodeHandler) new LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(classDescriptor, set, function1));
        return set;
    }

    private final PropertyDescriptor m41503a(PropertyDescriptor propertyDescriptor) {
        if (propertyDescriptor.mo7760t().m27041a()) {
            return propertyDescriptor;
        }
        Iterable<PropertyDescriptor> m = propertyDescriptor.mo7609m();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(m));
        for (PropertyDescriptor a : m) {
            arrayList.add(m41503a(a));
        }
        return (PropertyDescriptor) CollectionsKt___CollectionsKt.m41441h((List) CollectionsKt___CollectionsKt.m41453r((List) arrayList));
    }

    public final /* synthetic */ DeclaredMemberIndex mo7266c() {
        return new ClassDeclaredMemberIndex(this.f40292b, LazyJavaStaticClassScope$computeMemberIndex$1.f38431a);
    }

    protected final Set<Name> mo7264b(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Set s = CollectionsKt___CollectionsKt.m41454s(((DeclaredMemberIndex) this.f38426c.invoke()).mo5782a());
        function1 = UtilKt.m27195a((ClassDescriptor) this.f40291a);
        function1 = function1 != null ? function1.aE_() : null;
        if (function1 == null) {
            function1 = SetsKt__SetsKt.m26799a();
        }
        s.addAll((Collection) function1);
        if (this.f40292b.mo7280h() != null) {
            s.addAll(CollectionsKt__CollectionsKt.m26796b((Object[]) new Name[]{DescriptorUtils.f26053b, DescriptorUtils.f26052a}));
        }
        Iterable<JavaClass> d = this.f40292b.mo7276d();
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(d));
        for (JavaClass p : d) {
            arrayList.add(p.mo7103p());
        }
        s.addAll((List) arrayList);
        return s;
    }

    protected final Set<Name> mo7259a(DescriptorKindFilter descriptorKindFilter) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Set s = CollectionsKt___CollectionsKt.m41454s(((DeclaredMemberIndex) this.f38426c.invoke()).mo5783b());
        m41502a(this.f40291a, s, LazyJavaStaticClassScope$computePropertyNames$1$1.f38435a);
        return s;
    }

    protected final void mo7261a(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Set a;
        Intrinsics.m26847b(collection, "result");
        Intrinsics.m26847b(name, "name");
        this.f38427d.f25703b.f25694j.mo5775a(this.f40291a, new LazyJavaStaticClassScope$computeNonDeclaredFunctions$1(this, name));
        LazyJavaStaticClassScope a2 = UtilKt.m27195a((ClassDescriptor) this.f40291a);
        if (a2 == null) {
            a = SetsKt__SetsKt.m26799a();
        } else {
            a = CollectionsKt___CollectionsKt.m41451p(a2.mo6698b(name, (LookupLocation) NoLookupLocation.f32685o));
        }
        Object b = DescriptorResolverUtils.m27180b(name, a, collection, this.f40291a, this.f38427d.f25703b.f25691g);
        Intrinsics.m26843a(b, "resolveOverridesForStati…components.errorReporter)");
        collection.addAll(b);
        if (this.f40292b.mo7280h()) {
            Object b2;
            if (Intrinsics.m26845a((Object) name, DescriptorUtils.f26053b)) {
                b2 = DescriptorFactory.m27633b((ClassDescriptor) this.f40291a);
                Intrinsics.m26843a(b2, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(b2);
            } else if (Intrinsics.m26845a((Object) name, DescriptorUtils.f26052a) != null) {
                b2 = DescriptorFactory.m27628a((ClassDescriptor) this.f40291a);
                Intrinsics.m26843a(b2, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(b2);
            }
        }
    }

    protected final void mo7262a(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(collection, "result");
        Set a = m41502a(this.f40291a, new LinkedHashSet(), new C2942xd2f8c9a5(name));
        if ((collection.isEmpty() ^ 1) != 0) {
            Object b = DescriptorResolverUtils.m27180b(name, a, collection, this.f40291a, this.f38427d.f25703b.f25691g);
            Intrinsics.m26843a(b, "resolveOverridesForStati…rorReporter\n            )");
            collection.addAll(b);
            return;
        }
        Map linkedHashMap = new LinkedHashMap();
        for (Object next : a) {
            PropertyDescriptor a2 = m41503a((PropertyDescriptor) next);
            ArrayList arrayList = linkedHashMap.get(a2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(a2, arrayList);
            }
            arrayList.add(next);
        }
        Collection arrayList2 = new ArrayList();
        for (Entry value : linkedHashMap.entrySet()) {
            CollectionsKt__MutableCollectionsKt.m38194a(arrayList2, (Iterable) DescriptorResolverUtils.m27180b(name, (Collection) value.getValue(), collection, this.f40291a, this.f38427d.f25703b.f25691g));
        }
        collection.addAll((List) arrayList2);
    }

    public final /* bridge */ /* synthetic */ DeclarationDescriptor mo7268e() {
        return this.f40291a;
    }
}
