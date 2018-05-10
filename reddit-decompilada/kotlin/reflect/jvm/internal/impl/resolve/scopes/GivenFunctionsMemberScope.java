package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: GivenFunctionsMemberScope.kt */
public abstract class GivenFunctionsMemberScope extends MemberScopeImpl {
    static final /* synthetic */ KProperty[] f38813c = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    private final NotNullLazyValue f38814a;
    protected final ClassDescriptor f38815b;

    private final List<DeclarationDescriptor> m38578c() {
        return (List) StorageKt.m27920a(this.f38814a, f38813c[0]);
    }

    public abstract List<FunctionDescriptor> mo7256a();

    public GivenFunctionsMemberScope(StorageManager storageManager, ClassDescriptor classDescriptor) {
        Intrinsics.m26847b(storageManager, "storageManager");
        Intrinsics.m26847b(classDescriptor, "containingClass");
        this.f38815b = classDescriptor;
        this.f38814a = storageManager.mo5926a((Function0) new GivenFunctionsMemberScope$allDescriptors$2(this));
    }

    public final Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        if (descriptorKindFilter.m27787a(DescriptorKindFilter.f26114d.f26137a) == null) {
            return CollectionsKt__CollectionsKt.m26790a();
        }
        return m38578c();
    }

    public final Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        Collection arrayList = new ArrayList();
        for (Object next : m38578c()) {
            if (next instanceof SimpleFunctionDescriptor) {
                arrayList.add(next);
            }
        }
        Collection collection = (Collection) new ArrayList();
        for (Object next2 : (List) arrayList) {
            if (Intrinsics.m26845a(((SimpleFunctionDescriptor) next2).mo6689i(), (Object) name)) {
                collection.add(next2);
            }
        }
        return (List) collection;
    }

    public final Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        Collection arrayList = new ArrayList();
        for (Object next : m38578c()) {
            if (next instanceof PropertyDescriptor) {
                arrayList.add(next);
            }
        }
        Collection collection = (Collection) new ArrayList();
        for (Object next2 : (List) arrayList) {
            if (Intrinsics.m26845a(((PropertyDescriptor) next2).mo6689i(), (Object) name)) {
                collection.add(next2);
            }
        }
        return (List) collection;
    }

    public static final /* synthetic */ List m38577a(GivenFunctionsMemberScope givenFunctionsMemberScope, List list) {
        ArrayList arrayList = new ArrayList(3);
        Collection arrayList2 = new ArrayList();
        for (KotlinType b : givenFunctionsMemberScope.f38815b.mo7610c().aL_()) {
            CollectionsKt__MutableCollectionsKt.m38194a(arrayList2, (Iterable) DefaultImpls.m27789a(b.mo6740b(), null, null, 3));
        }
        Collection arrayList3 = new ArrayList();
        for (Object next : (List) arrayList2) {
            Object next2;
            if (next2 instanceof CallableMemberDescriptor) {
                arrayList3.add(next2);
            }
        }
        Map linkedHashMap = new LinkedHashMap();
        for (Object next22 : (List) arrayList3) {
            Name i = ((CallableMemberDescriptor) next22).mo6689i();
            ArrayList arrayList4 = linkedHashMap.get(i);
            if (arrayList4 == null) {
                arrayList4 = new ArrayList();
                linkedHashMap.put(i, arrayList4);
            }
            arrayList4.add(next22);
        }
        for (Entry entry : linkedHashMap.entrySet()) {
            next22 = (Name) entry.getKey();
            Map linkedHashMap2 = new LinkedHashMap();
            for (Object next3 : (List) entry.getValue()) {
                Boolean valueOf = Boolean.valueOf(((CallableMemberDescriptor) next3) instanceof FunctionDescriptor);
                ArrayList arrayList5 = linkedHashMap2.get(valueOf);
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                    linkedHashMap2.put(valueOf, arrayList5);
                }
                arrayList5.add(next3);
            }
            for (Entry entry2 : linkedHashMap2.entrySet()) {
                List list2;
                boolean booleanValue = ((Boolean) entry2.getKey()).booleanValue();
                Collection collection = (List) entry2.getValue();
                if (booleanValue) {
                    Collection arrayList6 = new ArrayList();
                    for (Object next4 : list) {
                        if (Intrinsics.m26845a(((FunctionDescriptor) next4).mo6689i(), next22)) {
                            arrayList6.add(next4);
                        }
                    }
                    list2 = (List) arrayList6;
                } else {
                    list2 = CollectionsKt__CollectionsKt.m26790a();
                }
                OverridingUtil.m27695a(next22, collection, list2, givenFunctionsMemberScope.f38815b, new GivenFunctionsMemberScope$createFakeOverrides$4(givenFunctionsMemberScope, arrayList));
            }
        }
        return CollectionsKt.m28088a(arrayList);
    }
}
