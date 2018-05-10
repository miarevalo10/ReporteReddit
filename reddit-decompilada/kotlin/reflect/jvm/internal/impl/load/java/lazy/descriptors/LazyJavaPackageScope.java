package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.SamConstructorDescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* compiled from: LazyJavaPackageScope.kt */
public final class LazyJavaPackageScope extends LazyJavaStaticScope {
    final LazyJavaPackageFragment f40287a;
    private final NullableLazyValue<Set<String>> f40288b;
    private final MemoizedFunctionToNullable<FindClassRequest, ClassDescriptor> f40289g;
    private final JavaPackage f40290h;

    /* compiled from: LazyJavaPackageScope.kt */
    private static final class FindClassRequest {
        final Name f25706a;
        final JavaClass f25707b;

        public FindClassRequest(Name name, JavaClass javaClass) {
            Intrinsics.m26847b(name, "name");
            this.f25706a = name;
            this.f25707b = javaClass;
        }

        public final boolean equals(Object obj) {
            return (!(obj instanceof FindClassRequest) || Intrinsics.m26845a(this.f25706a, ((FindClassRequest) obj).f25706a) == null) ? null : true;
        }

        public final int hashCode() {
            return this.f25706a.hashCode();
        }
    }

    /* compiled from: LazyJavaPackageScope.kt */
    private static abstract class KotlinClassLookupResult {

        /* compiled from: LazyJavaPackageScope.kt */
        public static final class Found extends KotlinClassLookupResult {
            final ClassDescriptor f32727a;

            public Found(ClassDescriptor classDescriptor) {
                Intrinsics.m26847b(classDescriptor, "descriptor");
                super();
                this.f32727a = classDescriptor;
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        public static final class NotFound extends KotlinClassLookupResult {
            public static final NotFound f32728a = null;

            static {
                NotFound notFound = new NotFound();
            }

            private NotFound() {
                super();
                f32728a = this;
            }
        }

        /* compiled from: LazyJavaPackageScope.kt */
        public static final class SyntheticClass extends KotlinClassLookupResult {
            public static final SyntheticClass f32729a = null;

            static {
                SyntheticClass syntheticClass = new SyntheticClass();
            }

            private SyntheticClass() {
                super();
                f32729a = this;
            }
        }

        private KotlinClassLookupResult() {
        }
    }

    public final /* synthetic */ ClassifierDescriptor mo6699c(Name name, LookupLocation lookupLocation) {
        return m41500d(name, lookupLocation);
    }

    public LazyJavaPackageScope(LazyJavaResolverContext lazyJavaResolverContext, JavaPackage javaPackage, LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Intrinsics.m26847b(javaPackage, "jPackage");
        Intrinsics.m26847b(lazyJavaPackageFragment, "ownerDescriptor");
        super(lazyJavaResolverContext);
        this.f40290h = javaPackage;
        this.f40287a = lazyJavaPackageFragment;
        this.f40288b = lazyJavaResolverContext.f25703b.f25685a.mo5931b((Function0) new LazyJavaPackageScope$knownClassNamesInPackage$1(this, lazyJavaResolverContext));
        this.f40289g = lazyJavaResolverContext.f25703b.f25685a.mo5930b((Function1) new LazyJavaPackageScope$classes$1(this, lazyJavaResolverContext));
    }

    public final ClassDescriptor m41500d(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return m41494a(name, (JavaClass) null);
    }

    public final ClassDescriptor m41494a(Name name, JavaClass javaClass) {
        if (!SpecialNames.m27433b(name)) {
            return null;
        }
        Set set = (Set) this.f40288b.invoke();
        if (javaClass != null || set == null || (set.contains(name.m27429a()) ^ 1) == 0) {
            return (ClassDescriptor) this.f40289g.mo6492a(new FindClassRequest(name, javaClass));
        }
        return null;
    }

    public final Collection<PropertyDescriptor> mo6694a(Name name, LookupLocation lookupLocation) {
        Intrinsics.m26847b(name, "name");
        Intrinsics.m26847b(lookupLocation, "location");
        return CollectionsKt__CollectionsKt.m26790a();
    }

    protected final DeclaredMemberIndex mo7266c() {
        return Empty.f32719a;
    }

    protected final Set<Name> mo7265c(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Companion companion = DescriptorKindFilter.f26123m;
        if (descriptorKindFilter.m27787a(Companion.m27760a()) == null) {
            return SetsKt__SetsKt.m26799a();
        }
        Set<String> set = (Set) this.f40288b.invoke();
        Collection collection;
        if (set != null) {
            collection = (Collection) new HashSet();
            for (String a : set) {
                collection.add(Name.m27424a(a));
            }
            return (Set) collection;
        }
        descriptorKindFilter = this.f40290h;
        if (function1 == null) {
            function1 = FunctionsKt.m28106b();
        }
        Iterable<JavaClass> a2 = descriptorKindFilter.mo6711a(function1);
        collection = (Collection) new LinkedHashSet();
        for (JavaClass javaClass : a2) {
            Object obj = null;
            if (!Intrinsics.m26845a(null, LightClassOriginKind.f25728a)) {
                obj = javaClass.mo7103p();
            }
            if (obj != null) {
                collection.add(obj);
            }
        }
        return (Set) collection;
    }

    protected final Set<Name> mo7259a(DescriptorKindFilter descriptorKindFilter) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        return SetsKt__SetsKt.m26799a();
    }

    public final Collection<DeclarationDescriptor> mo6695a(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        Intrinsics.m26847b(function1, "nameFilter");
        return m38388a(descriptorKindFilter, (Function1) function1, (LookupLocation) NoLookupLocation.f32683m);
    }

    protected final Set<Name> mo7264b(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.m26847b(descriptorKindFilter, "kindFilter");
        if (descriptorKindFilter.f26138b.contains(SamConstructorDescriptorKindExclude.f32704a) != null) {
            return SetsKt__SetsKt.m26799a();
        }
        return mo7265c(DescriptorKindFilter.f26118h, (Function1) function1);
    }

    protected final void mo7261a(Collection<SimpleFunctionDescriptor> collection, Name name) {
        Intrinsics.m26847b(collection, "result");
        Intrinsics.m26847b(name, "name");
        this.f38427d.f25703b.f25694j.mo5775a(this.f40287a, new LazyJavaPackageScope$computeNonDeclaredFunctions$1(this, name));
    }

    public final /* bridge */ /* synthetic */ DeclarationDescriptor mo7268e() {
        return this.f40287a;
    }

    public static final /* synthetic */ KotlinClassLookupResult m41490a(LazyJavaPackageScope lazyJavaPackageScope, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        if (kotlinJvmBinaryClass == null) {
            return (KotlinClassLookupResult) NotFound.f32728a;
        }
        if (!Intrinsics.m26845a(kotlinJvmBinaryClass.mo5853c().f25837a, Kind.f25828b)) {
            return (KotlinClassLookupResult) SyntheticClass.f32729a;
        }
        lazyJavaPackageScope = lazyJavaPackageScope.f38427d.f25703b.f25688d;
        Intrinsics.m26847b(kotlinJvmBinaryClass, "kotlinClass");
        ClassDataWithSource a = DeserializedDescriptorResolver.m27291a(kotlinJvmBinaryClass);
        if (a == null) {
            lazyJavaPackageScope = null;
        } else {
            lazyJavaPackageScope = lazyJavaPackageScope.f25789a;
            if (lazyJavaPackageScope == null) {
                Intrinsics.m26844a("components");
            }
            lazyJavaPackageScope = lazyJavaPackageScope.f26228a.m27825a(kotlinJvmBinaryClass.mo5849a(), a);
        }
        return lazyJavaPackageScope != null ? (KotlinClassLookupResult) new Found(lazyJavaPackageScope) : (KotlinClassLookupResult) NotFound.f32728a;
    }
}
