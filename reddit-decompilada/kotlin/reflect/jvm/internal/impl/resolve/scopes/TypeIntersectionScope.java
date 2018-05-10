package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: TypeIntersectionScope.kt */
public final class TypeIntersectionScope extends AbstractScopeAdapter {
    public static final Companion f38828a = new Companion();
    private final ChainedMemberScope f38829b;

    /* compiled from: TypeIntersectionScope.kt */
    public static final class Companion {
        private Companion() {
        }

        public static MemberScope m27792a(String str, Collection<? extends KotlinType> collection) {
            Intrinsics.m26847b(str, "message");
            Intrinsics.m26847b(collection, "types");
            Iterable<KotlinType> iterable = collection;
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(iterable));
            for (KotlinType b : iterable) {
                arrayList.add(b.mo6740b());
            }
            ChainedMemberScope chainedMemberScope = new ChainedMemberScope(str, (List) arrayList);
            if (collection.size() <= 1) {
                return chainedMemberScope;
            }
            return (MemberScope) new TypeIntersectionScope(chainedMemberScope);
        }
    }

    public static final MemberScope m38595a(String str, Collection<? extends KotlinType> collection) {
        Intrinsics.m26847b(str, "message");
        Intrinsics.m26847b(collection, "types");
        return Companion.m27792a(str, collection);
    }

    private TypeIntersectionScope(ChainedMemberScope chainedMemberScope) {
        this.f38829b = chainedMemberScope;
    }

    public final Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return OverridingUtilsKt.m27708a(super.mo6698b(name, lookupLocation), (Function1) TypeIntersectionScope$getContributedFunctions$1.f38826a);
    }

    public final Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return OverridingUtilsKt.m27708a(super.mo6694a(name, lookupLocation), (Function1) TypeIntersectionScope$getContributedVariables$1.f38827a);
    }

    public final Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        Iterable a = super.mo6695a(descriptorKindFilter, (Function1) function1);
        function1 = new ArrayList();
        ArrayList arrayList = new ArrayList();
        for (Object next : a) {
            if (((DeclarationDescriptor) next) instanceof CallableDescriptor) {
                function1.add(next);
            } else {
                arrayList.add(next);
            }
        }
        descriptorKindFilter = new Pair(function1, arrayList);
        List list = (List) descriptorKindFilter.f25267a;
        List list2 = (List) descriptorKindFilter.f25268b;
        if (list != null) {
            return CollectionsKt___CollectionsKt.m41423b((Collection) OverridingUtilsKt.m27708a(list, TypeIntersectionScope$getContributedDescriptors$2.f38825a), (Iterable) list2);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.Collection<org.jetbrains.kotlin.descriptors.CallableDescriptor>");
    }

    public final /* bridge */ /* synthetic */ MemberScope mo7113c() {
        return this.f38829b;
    }
}
