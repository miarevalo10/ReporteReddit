package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver.EMPTY;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: LazyJavaPackageFragmentProvider.kt */
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProvider {
    private final LazyJavaResolverContext f32705a;
    private final MemoizedFunctionToNullable<FqName, LazyJavaPackageFragment> f32706b = this.f32705a.f25703b.f25685a.mo5930b((Function1) new LazyJavaPackageFragmentProvider$packageFragments$1(this));

    public LazyJavaPackageFragmentProvider(JavaResolverComponents javaResolverComponents) {
        Intrinsics.m26847b(javaResolverComponents, "components");
        this.f32705a = new LazyJavaResolverContext(javaResolverComponents, EMPTY.f32713a);
    }

    public final /* synthetic */ Collection mo5711a(FqName fqName, Function1 function1) {
        Intrinsics.m26847b(fqName, "fqName");
        Intrinsics.m26847b(function1, "nameFilter");
        fqName = m33033b(fqName);
        fqName = fqName != null ? (List) fqName.f40801b.invoke() : null;
        if (fqName == null) {
            fqName = CollectionsKt__CollectionsKt.m26790a();
        }
        return (Collection) fqName;
    }

    private final LazyJavaPackageFragment m33033b(FqName fqName) {
        return (LazyJavaPackageFragment) this.f32706b.mo6492a(fqName);
    }

    public final List<LazyJavaPackageFragment> mo5712a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return CollectionsKt.m28087a(m33033b(fqName));
    }
}
