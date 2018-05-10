package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: SubstitutingScope.kt */
public final class SubstitutingScope implements MemberScope {
    static final /* synthetic */ KProperty[] f36157a = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(SubstitutingScope.class), "_allDescriptors", "get_allDescriptors()Ljava/util/Collection;"))};
    private final TypeSubstitutor f36158b;
    private Map<DeclarationDescriptor, DeclarationDescriptor> f36159c;
    private final Lazy f36160d = LazyKt.m26777a((Function0) new SubstitutingScope$_allDescriptors$2(this));
    private final MemberScope f36161e;

    public SubstitutingScope(MemberScope memberScope, TypeSubstitutor typeSubstitutor) {
        Intrinsics.m26847b(memberScope, "workerScope");
        Intrinsics.m26847b(typeSubstitutor, "givenSubstitutor");
        this.f36161e = memberScope;
        this.f36158b = CapturedTypeConstructorKt.m27711a(typeSubstitutor.m28004a()).m27987d();
    }

    private final <D extends DeclarationDescriptor> D m36367a(D d) {
        if (this.f36158b.f26329b.mo5796a()) {
            return d;
        }
        if (this.f36159c == null) {
            this.f36159c = new HashMap();
        }
        Map map = this.f36159c;
        if (map == null) {
            Intrinsics.m26842a();
        }
        Object obj = map.get(d);
        if (obj == null) {
            obj = d.mo7079b(this.f36158b);
            if (obj == null) {
                StringBuilder stringBuilder = new StringBuilder("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, ");
                StringBuilder stringBuilder2 = new StringBuilder("but ");
                stringBuilder2.append(d);
                stringBuilder2.append(" substitution fails");
                stringBuilder.append(stringBuilder2.toString());
                throw new AssertionError(stringBuilder.toString());
            }
            Intrinsics.m26843a(obj, "descriptor.substitute(su…tion fails\"\n            }");
            obj = (DeclarationDescriptor) obj;
            map.put(d, obj);
        }
        DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
        if (declarationDescriptor != null) {
            return declarationDescriptor;
        }
        throw new TypeCastException("null cannot be cast to non-null type D");
    }

    private final <D extends DeclarationDescriptor> Collection<D> m36365a(Collection<? extends D> collection) {
        if (this.f36158b.f26329b.mo5796a() || collection.isEmpty()) {
            return collection;
        }
        HashSet a = CollectionsKt.m28086a(collection.size());
        collection = collection.iterator();
        while (collection.hasNext()) {
            a.add(m36367a((DeclarationDescriptor) collection.next()));
        }
        return a;
    }

    public final Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return m36365a(this.f36161e.mo6694a(name, lookupLocation));
    }

    public final ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        name = this.f36161e.mo6699c(name, lookupLocation);
        return name != null ? (ClassifierDescriptor) m36367a((DeclarationDescriptor) (ClassifierDescriptor) name) : null;
    }

    public final Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return m36365a(this.f36161e.mo6698b(name, lookupLocation));
    }

    public final Set<Name> aE_() {
        return this.f36161e.aE_();
    }

    public final Set<Name> aF_() {
        return this.f36161e.aF_();
    }

    public final Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        return (Collection) this.f36160d.mo5678b();
    }
}
