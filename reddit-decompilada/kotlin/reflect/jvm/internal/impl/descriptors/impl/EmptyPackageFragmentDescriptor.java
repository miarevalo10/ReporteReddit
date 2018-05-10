package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;

/* compiled from: EmptyPackageFragmentDesciptor.kt */
public final class EmptyPackageFragmentDescriptor extends PackageFragmentDescriptorImpl {
    public EmptyPackageFragmentDescriptor(ModuleDescriptor moduleDescriptor, FqName fqName) {
        Intrinsics.m26847b(moduleDescriptor, "module");
        Intrinsics.m26847b(fqName, "fqName");
        super(moduleDescriptor, fqName);
    }

    public final /* bridge */ /* synthetic */ MemberScope aC_() {
        return Empty.f38819a;
    }
}
