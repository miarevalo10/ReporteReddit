package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: AbstractScopeAdapter.kt */
public abstract class AbstractScopeAdapter implements MemberScope {
    protected abstract MemberScope mo7113c();

    public Collection<SimpleFunctionDescriptor> mo6698b(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return mo7113c().mo6698b(name, lookupLocation);
    }

    public final ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return mo7113c().mo6699c(name, lookupLocation);
    }

    public Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return mo7113c().mo6694a(name, lookupLocation);
    }

    public Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        return mo7113c().mo6695a(descriptorKindFilter, function1);
    }

    public final Set<Name> aE_() {
        return mo7113c().aE_();
    }

    public final Set<Name> aF_() {
        return mo7113c().aF_();
    }
}
