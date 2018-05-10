package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: JavaDescriptorResolver.kt */
public final class JavaDescriptorResolver {
    public final LazyJavaPackageFragmentProvider f26091a;
    private final JavaResolverCache f26092b;

    public JavaDescriptorResolver(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, JavaResolverCache javaResolverCache) {
        Intrinsics.m26847b(lazyJavaPackageFragmentProvider, "packageFragmentProvider");
        Intrinsics.m26847b(javaResolverCache, "javaResolverCache");
        this.f26091a = lazyJavaPackageFragmentProvider;
        this.f26092b = javaResolverCache;
    }

    public final ClassDescriptor m27747a(JavaClass javaClass) {
        Intrinsics.m26847b(javaClass, "javaClass");
        FqName b = javaClass.mo7274b();
        if (b != null && Intrinsics.m26845a(null, LightClassOriginKind.f25728a)) {
            return this.f26092b.getClassResolvedFromSource(b);
        }
        JavaClass e = javaClass.mo7277e();
        if (e != null) {
            ClassDescriptor a = m27747a(e);
            MemberScope t = a != null ? a.mo7739t() : null;
            javaClass = t != null ? t.mo6699c(javaClass.mo7103p(), NoLookupLocation.f32689s) : null;
            if (!(javaClass instanceof ClassDescriptor)) {
                javaClass = null;
            }
            return (ClassDescriptor) javaClass;
        } else if (b == null) {
            return null;
        } else {
            LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider = this.f26091a;
            b = b.m27411d();
            Intrinsics.m26843a((Object) b, "fqName.parent()");
            LazyJavaPackageFragment lazyJavaPackageFragment = (LazyJavaPackageFragment) CollectionsKt___CollectionsKt.m41434e(lazyJavaPackageFragmentProvider.mo5712a(b));
            if (lazyJavaPackageFragment == null) {
                return null;
            }
            Intrinsics.m26847b(javaClass, "jClass");
            LazyJavaPackageScope lazyJavaPackageScope = lazyJavaPackageFragment.f40800a.f36092a;
            Intrinsics.m26847b(javaClass, "javaClass");
            return lazyJavaPackageScope.m41494a(javaClass.mo7103p(), javaClass);
        }
    }
}
