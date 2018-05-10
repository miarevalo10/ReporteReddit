package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
final class LazyPackageViewDescriptorImpl$fragments$2 extends Lambda implements Function0<List<? extends PackageFragmentDescriptor>> {
    final /* synthetic */ LazyPackageViewDescriptorImpl f38338a;

    LazyPackageViewDescriptorImpl$fragments$2(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        this.f38338a = lazyPackageViewDescriptorImpl;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f38338a.f38341a.m38344d().mo5712a(this.f38338a.f38342b);
    }
}
