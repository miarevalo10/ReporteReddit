package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: LazyJavaPackageFragmentProvider.kt */
final class LazyJavaPackageFragmentProvider$packageFragments$1 extends Lambda implements Function1<FqName, LazyJavaPackageFragment> {
    final /* synthetic */ LazyJavaPackageFragmentProvider f38373a;

    LazyJavaPackageFragmentProvider$packageFragments$1(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider) {
        this.f38373a = lazyJavaPackageFragmentProvider;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        FqName fqName = (FqName) obj;
        Intrinsics.m26847b(fqName, "fqName");
        return new LazyJavaPackageFragment(this.f38373a.f32705a, this.f38373a.f32705a.f25703b.f25686b.mo5798a(fqName));
    }
}
