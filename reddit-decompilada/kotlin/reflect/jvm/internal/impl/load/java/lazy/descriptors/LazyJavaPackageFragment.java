package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageFragmentDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryPackageSourceElement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;

/* compiled from: LazyJavaPackageFragment.kt */
public final class LazyJavaPackageFragment extends PackageFragmentDescriptorImpl {
    static final /* synthetic */ KProperty[] f40799c = new KProperty[]{Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LazyJavaPackageFragment.class), "binaryClasses", "getBinaryClasses$kotlin_core()Ljava/util/Map;")), Reflection.m26856a(new PropertyReference1Impl(Reflection.m26850a(LazyJavaPackageFragment.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    public final JvmPackageScope f40800a = new JvmPackageScope(this.f40804g, this.f40805h, this);
    public final NotNullLazyValue<List<FqName>> f40801b = this.f40804g.f25703b.f25685a.mo5927a((Function0) new LazyJavaPackageFragment$subPackages$1(this), CollectionsKt__CollectionsKt.m26790a());
    private final NotNullLazyValue f40802e = this.f40804g.f25703b.f25685a.mo5926a((Function0) new LazyJavaPackageFragment$binaryClasses$2(this));
    private final NotNullLazyValue f40803f = this.f40804g.f25703b.f25685a.mo5926a((Function0) new LazyJavaPackageFragment$partToFacade$2(this));
    private final LazyJavaResolverContext f40804g;
    private final JavaPackage f40805h;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] f25705a;

        static {
            int[] iArr = new int[Kind.values().length];
            f25705a = iArr;
            iArr[Kind.f25832f.ordinal()] = 1;
            f25705a[Kind.f25829c.ordinal()] = 2;
        }
    }

    public final Map<String, KotlinJvmBinaryClass> m42680b() {
        return (Map) StorageKt.m27920a(this.f40802e, f40799c[0]);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Lazy Java package fragment: ");
        stringBuilder.append(this.f40724d);
        return stringBuilder.toString();
    }

    public final SourceElement mo7258r() {
        return new KotlinJvmBinaryPackageSourceElement(this);
    }

    public final /* bridge */ /* synthetic */ MemberScope aC_() {
        return this.f40800a;
    }

    public LazyJavaPackageFragment(LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Intrinsics.m26847b(javaPackage, "jPackage");
        super(lazyJavaResolverContext.f25703b.f25700p, javaPackage.mo6712a());
        this.f40804g = lazyJavaResolverContext;
        this.f40805h = javaPackage;
    }
}
