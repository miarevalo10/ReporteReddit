package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ModuleDescriptorImpl.kt */
final class ModuleDescriptorImpl$packages$1 extends Lambda implements Function1<FqName, LazyPackageViewDescriptorImpl> {
    final /* synthetic */ ModuleDescriptorImpl f38346a;

    ModuleDescriptorImpl$packages$1(ModuleDescriptorImpl moduleDescriptorImpl) {
        this.f38346a = moduleDescriptorImpl;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FqName fqName = (FqName) obj;
        Intrinsics.m26847b(fqName, "fqName");
        return new LazyPackageViewDescriptorImpl(this.f38346a, fqName, this.f38346a.f38354h);
    }
}
