package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;

/* compiled from: DeserializedClassDataFinder.kt */
public final class DeserializedClassDataFinder implements ClassDataFinder {
    private final PackageFragmentProvider f33034a;

    public DeserializedClassDataFinder(PackageFragmentProvider packageFragmentProvider) {
        Intrinsics.m26847b(packageFragmentProvider, "packageFragmentProvider");
        this.f33034a = packageFragmentProvider;
    }

    public final ClassDataWithSource mo5703a(ClassId classId) {
        Intrinsics.m26847b(classId, "classId");
        PackageFragmentProvider packageFragmentProvider = this.f33034a;
        Object a = classId.m27398a();
        Intrinsics.m26843a(a, "classId.packageFqName");
        Object i = CollectionsKt___CollectionsKt.m41443i(packageFragmentProvider.mo5712a(a));
        if (!(i instanceof DeserializedPackageFragment)) {
            i = null;
        }
        DeserializedPackageFragment deserializedPackageFragment = (DeserializedPackageFragment) i;
        if (deserializedPackageFragment == null) {
            return null;
        }
        return deserializedPackageFragment.mo7792a().mo5703a(classId);
    }
}
