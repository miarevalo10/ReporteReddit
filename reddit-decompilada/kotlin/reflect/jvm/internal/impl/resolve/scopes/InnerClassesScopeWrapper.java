package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion;

/* compiled from: InnerClassesScopeWrapper.kt */
public final class InnerClassesScopeWrapper extends MemberScopeImpl {
    private final MemberScope f38816a;

    public InnerClassesScopeWrapper(MemberScope memberScope) {
        Intrinsics.m26847b(memberScope, "workerScope");
        this.f38816a = memberScope;
    }

    public final /* synthetic */ Collection mo6695a(DescriptorKindFilter descriptorKindFilter, Function1 function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        Companion companion = DescriptorKindFilter.f26123m;
        int h = Companion.m27767h() & descriptorKindFilter.f26137a;
        if (h == 0) {
            descriptorKindFilter = null;
        } else {
            descriptorKindFilter = new DescriptorKindFilter(h, descriptorKindFilter.f26138b);
        }
        if (descriptorKindFilter == null) {
            descriptorKindFilter = CollectionsKt__CollectionsKt.m26790a();
        } else {
            Iterable a = this.f38816a.mo6695a(descriptorKindFilter, function1);
            Collection collection = (Collection) new ArrayList();
            for (Object next : a) {
                if (next instanceof ClassifierDescriptorWithTypeParameters) {
                    collection.add(next);
                }
            }
            descriptorKindFilter = (List) collection;
        }
        return (Collection) descriptorKindFilter;
    }

    public final ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        name = this.f38816a.mo6699c(name, lookupLocation);
        if (name == null) {
            return null;
        }
        ClassifierDescriptor classifierDescriptor;
        name = (ClassifierDescriptor) name;
        ClassDescriptor classDescriptor = (ClassDescriptor) (!(name instanceof ClassDescriptor) ? null : name);
        if (classDescriptor != null) {
            classifierDescriptor = classDescriptor;
        } else {
            if (!(name instanceof TypeAliasDescriptor)) {
                name = null;
            }
            classifierDescriptor = (TypeAliasDescriptor) name;
        }
        return classifierDescriptor;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Classes from ");
        stringBuilder.append(this.f38816a);
        return stringBuilder.toString();
    }
}
