package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PackageFragmentProviderImpl.kt */
final class PackageFragmentProviderImpl$getSubPackagesOf$1 extends Lambda implements Function1<PackageFragmentDescriptor, FqName> {
    public static final PackageFragmentProviderImpl$getSubPackagesOf$1 f38326a = new PackageFragmentProviderImpl$getSubPackagesOf$1();

    PackageFragmentProviderImpl$getSubPackagesOf$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        PackageFragmentDescriptor packageFragmentDescriptor = (PackageFragmentDescriptor) obj;
        Intrinsics.m26847b(packageFragmentDescriptor, "it");
        return packageFragmentDescriptor.mo7722d();
    }
}
