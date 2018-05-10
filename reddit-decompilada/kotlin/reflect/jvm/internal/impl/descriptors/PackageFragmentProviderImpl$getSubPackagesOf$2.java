package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PackageFragmentProviderImpl.kt */
final class PackageFragmentProviderImpl$getSubPackagesOf$2 extends Lambda implements Function1<FqName, Boolean> {
    final /* synthetic */ FqName f38327a;

    PackageFragmentProviderImpl$getSubPackagesOf$2(FqName fqName) {
        this.f38327a = fqName;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FqName fqName = (FqName) obj;
        Intrinsics.m26847b(fqName, "it");
        obj = (fqName.f25856b.f25861b.isEmpty() || Intrinsics.m26845a(fqName.m27411d(), this.f38327a) == null) ? null : true;
        return Boolean.valueOf(obj);
    }
}
