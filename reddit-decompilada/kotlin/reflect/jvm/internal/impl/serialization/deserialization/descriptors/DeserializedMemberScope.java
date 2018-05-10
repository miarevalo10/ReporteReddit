package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.MemberComparator;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;
import kotlin.reflect.jvm.internal.impl.serialization.Flags;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Visibility;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.Deserialization;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: DeserializedMemberScope.kt */
public abstract class DeserializedMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty[] f38899c = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DeserializedMemberScope.class), "functionProtos", "getFunctionProtos()Ljava/util/Map;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DeserializedMemberScope.class), "propertyProtos", "getPropertyProtos()Ljava/util/Map;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DeserializedMemberScope.class), "typeAliasProtos", "getTypeAliasProtos()Ljava/util/Map;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DeserializedMemberScope.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DeserializedMemberScope.class), "variableNamesLazy", "getVariableNamesLazy()Ljava/util/Set;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(DeserializedMemberScope.class), "classNames", "getClassNames$kotlin_core()Ljava/util/Set;"))};
    private final NotNullLazyValue f38900a;
    final DeserializationContext f38901b;
    private final NotNullLazyValue f38902d;
    private final NotNullLazyValue f38903e;
    private final MemoizedFunctionToNotNull<Name, Collection<SimpleFunctionDescriptor>> f38904g = this.f38901b.f26245c.f26229b.mo5925a((Function1) new DeserializedMemberScope$functions$1(this));
    private final MemoizedFunctionToNotNull<Name, Collection<PropertyDescriptor>> f38905h = this.f38901b.f26245c.f26229b.mo5925a((Function1) new DeserializedMemberScope$properties$1(this));
    private final MemoizedFunctionToNullable<Name, TypeAliasDescriptor> f38906i = this.f38901b.f26245c.f26229b.mo5930b((Function1) new DeserializedMemberScope$typeAliasByName$1(this));
    private final NotNullLazyValue f38907j = this.f38901b.f26245c.f26229b.mo5926a((Function0) new DeserializedMemberScope$functionNamesLazy$2(this));
    private final NotNullLazyValue f38908k = this.f38901b.f26245c.f26229b.mo5926a((Function0) new DeserializedMemberScope$variableNamesLazy$2(this));
    private final NotNullLazyValue f38909l;

    private final Map<Name, List<Function>> m38635f() {
        return (Map) StorageKt.m27920a(this.f38900a, f38899c[0]);
    }

    private final Map<Name, List<Property>> m38636g() {
        return (Map) StorageKt.m27920a(this.f38902d, f38899c[1]);
    }

    private final Map<Name, List<TypeAlias>> m38637h() {
        return (Map) StorageKt.m27920a(this.f38903e, f38899c[2]);
    }

    protected abstract ClassId mo7306a(Name name);

    protected abstract void mo7307a(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1);

    protected void mo7308a(Name name, Collection<SimpleFunctionDescriptor> collection) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(collection, "functions");
    }

    protected void mo7309b(Name name, Collection<PropertyDescriptor> collection) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(collection, "descriptors");
    }

    protected abstract Set<Name> mo7310c();

    protected abstract Set<Name> mo7311d();

    public final Set<Name> m38650e() {
        return (Set) StorageKt.m27920a(this.f38909l, f38899c[5]);
    }

    protected DeserializedMemberScope(DeserializationContext deserializationContext, Collection<Function> collection, Collection<Property> collection2, Collection<TypeAlias> collection3, Function0<? extends Collection<Name>> function0) {
        Intrinsics.m26847b(deserializationContext, "c");
        Intrinsics.m26847b(collection, "functionList");
        Intrinsics.m26847b(collection2, "propertyList");
        Intrinsics.m26847b(collection3, "typeAliasList");
        Intrinsics.m26847b(function0, "classNames");
        this.f38901b = deserializationContext;
        this.f38900a = this.f38901b.f26245c.f26229b.mo5926a((Function0) new DeserializedMemberScope$functionProtos$2(this, collection));
        this.f38902d = this.f38901b.f26245c.f26229b.mo5926a((Function0) new DeserializedMemberScope$propertyProtos$2(this, collection2));
        this.f38903e = this.f38901b.f26245c.f26229b.mo5926a((Function0) new DeserializedMemberScope$typeAliasProtos$2(this, collection3));
        this.f38909l = this.f38901b.f26245c.f26229b.mo5926a((Function0) new DeserializedMemberScope$classNames$2(function0));
    }

    private final Set<Name> m38638i() {
        return m38637h().keySet();
    }

    public Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        if ((aE_().contains(name) ^ 1) != null) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        return (Collection) this.f38904g.mo6492a(name);
    }

    public Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        if ((aF_().contains(name) ^ 1) != null) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        return (Collection) this.f38905h.mo6492a(name);
    }

    protected final Collection<DeclarationDescriptor> m38640a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        Intrinsics.m26847b(lookupLocation, "location");
        ArrayList arrayList = new ArrayList(0);
        Companion companion = DescriptorKindFilter.f26123m;
        if (descriptorKindFilter.m27787a(Companion.m27761b())) {
            mo7307a((Collection) arrayList, (Function1) function1);
        }
        Collection collection = arrayList;
        m38629a(collection, descriptorKindFilter, function1, lookupLocation);
        lookupLocation = DescriptorKindFilter.f26123m;
        if (descriptorKindFilter.m27787a(Companion.m27767h()) != null) {
            for (Name name : m38650e()) {
                if (((Boolean) function1.mo6492a(name)).booleanValue()) {
                    CollectionsKt.m28092a(collection, m38633c(name));
                }
            }
        }
        lookupLocation = DescriptorKindFilter.f26123m;
        if (descriptorKindFilter.m27787a(Companion.m27762c()) != null) {
            for (Name name2 : m38638i()) {
                if (((Boolean) function1.mo6492a(name2)).booleanValue()) {
                    CollectionsKt.m28092a(collection, this.f38906i.mo6492a(name2));
                }
            }
        }
        return CollectionsKt.m28088a(arrayList);
    }

    private final void m38629a(Collection<DeclarationDescriptor> collection, DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1, LookupLocation lookupLocation) {
        Companion companion = DescriptorKindFilter.f26123m;
        if (descriptorKindFilter.m27787a(Companion.m27765f())) {
            Collection<Name> aF_ = aF_();
            ArrayList arrayList = new ArrayList();
            for (Name name : aF_) {
                if (((Boolean) function1.mo6492a(name)).booleanValue()) {
                    arrayList.addAll(mo6694a(name, lookupLocation));
                }
            }
            List list = arrayList;
            Object obj = MemberComparator.f26069a;
            Intrinsics.m26843a(obj, "MemberComparator.INSTANCE");
            CollectionsKt__MutableCollectionsKt.m38191a(list, (Comparator) obj);
            collection.addAll(arrayList);
        }
        companion = DescriptorKindFilter.f26123m;
        if (descriptorKindFilter.m27787a(Companion.m27764e()) != null) {
            Collection<Name> aE_ = aE_();
            ArrayList arrayList2 = new ArrayList();
            for (Name name2 : aE_) {
                if (((Boolean) function1.mo6492a(name2)).booleanValue()) {
                    arrayList2.addAll(mo6698b(name2, lookupLocation));
                }
            }
            List list2 = arrayList2;
            Object obj2 = MemberComparator.f26069a;
            Intrinsics.m26843a(obj2, "MemberComparator.INSTANCE");
            CollectionsKt__MutableCollectionsKt.m38191a(list2, (Comparator) obj2);
            collection.addAll(arrayList2);
        }
    }

    public ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        if (mo7312b(name) != null) {
            return m38633c(name);
        }
        return m38638i().contains(name) != null ? (ClassifierDescriptor) this.f38906i.mo6492a(name) : null;
    }

    private final ClassDescriptor m38633c(Name name) {
        return this.f38901b.f26245c.m27832a(mo7306a(name));
    }

    protected boolean mo7312b(Name name) {
        Intrinsics.m26847b(name, "name");
        return m38650e().contains(name);
    }

    public final Set<Name> aE_() {
        return (Set) StorageKt.m27920a(this.f38907j, f38899c[3]);
    }

    public final Set<Name> aF_() {
        return (Set) StorageKt.m27920a(this.f38908k, f38899c[4]);
    }

    public static final /* synthetic */ Collection m38627a(DeserializedMemberScope deserializedMemberScope, Name name) {
        Collection collection = (Collection) deserializedMemberScope.m38635f().get(name);
        if (collection == null) {
            collection = CollectionsKt__CollectionsKt.m26790a();
        }
        Collection arrayList = new ArrayList();
        for (Function a : r0) {
            arrayList.add(deserializedMemberScope.f38901b.f26244b.m27852a(a));
        }
        ArrayList arrayList2 = (ArrayList) arrayList;
        deserializedMemberScope.mo7308a(name, (Collection) arrayList2);
        return CollectionsKt.m28088a(arrayList2);
    }

    public static final /* synthetic */ Collection m38630b(DeserializedMemberScope deserializedMemberScope, Name name) {
        Collection collection = (Collection) deserializedMemberScope.m38636g().get(name);
        if (collection == null) {
            collection = CollectionsKt__CollectionsKt.m26790a();
        }
        Collection arrayList = new ArrayList();
        for (Property a : r0) {
            arrayList.add(deserializedMemberScope.f38901b.f26244b.m27851a(a));
        }
        ArrayList arrayList2 = (ArrayList) arrayList;
        deserializedMemberScope.mo7309b(name, (Collection) arrayList2);
        return CollectionsKt.m28088a(arrayList2);
    }

    public static final /* synthetic */ TypeAliasDescriptor m38634c(DeserializedMemberScope deserializedMemberScope, Name name) {
        List list = (List) deserializedMemberScope.m38637h().get(name);
        if (list != null) {
            TypeAlias typeAlias = (TypeAlias) CollectionsKt___CollectionsKt.m41443i(list);
            if (typeAlias != null) {
                typeAlias = typeAlias;
                deserializedMemberScope = deserializedMemberScope.f38901b.f26244b;
                Intrinsics.m26847b(typeAlias, "proto");
                Iterable<Object> iterable = typeAlias.f40490l;
                Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
                for (Object obj : iterable) {
                    AnnotationDeserializer annotationDeserializer = deserializedMemberScope.f26256a;
                    Intrinsics.m26843a(obj, "it");
                    arrayList.add(annotationDeserializer.m27813a(obj, deserializedMemberScope.f26257b.f26246d));
                }
                AnnotationsImpl annotationsImpl = new AnnotationsImpl((List) arrayList);
                Object a = Deserialization.m27829a((Visibility) Flags.f26152c.mo5920b(typeAlias.f40483e));
                DeclarationDescriptor declarationDescriptor = deserializedMemberScope.f26257b.f26247e;
                Annotations annotations = annotationsImpl;
                Object obj2 = deserializedMemberScope.f26257b.f26246d.mo5830b(typeAlias.f40484f);
                Intrinsics.m26843a(obj2, "c.nameResolver.getName(proto.name)");
                Intrinsics.m26843a(a, "visibility");
                DeserializedTypeAliasDescriptor deserializedTypeAliasDescriptor = new DeserializedTypeAliasDescriptor(declarationDescriptor, annotations, obj2, a, typeAlias, deserializedMemberScope.f26257b.f26246d, deserializedMemberScope.f26257b.f26248f, deserializedMemberScope.f26257b.f26249g, deserializedMemberScope.f26257b.f26250h);
                DeserializationContext deserializationContext = deserializedMemberScope.f26257b;
                declarationDescriptor = deserializedTypeAliasDescriptor;
                Object obj3 = typeAlias.f40485g;
                Intrinsics.m26843a(obj3, "proto.typeParameterList");
                deserializationContext = deserializationContext.m27835a(declarationDescriptor, obj3, deserializationContext.f26246d, deserializationContext.f26248f);
                deserializedTypeAliasDescriptor.m42865a(deserializationContext.f26243a.m27889a(), Annotations.f32643a, Annotations.f32643a);
                return deserializedTypeAliasDescriptor;
            }
        }
        return null;
    }
}
