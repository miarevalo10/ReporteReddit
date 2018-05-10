package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.Found;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.NotFound;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageScope.KotlinClassLookupResult.SyntheticClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: LazyJavaPackageScope.kt */
final class LazyJavaPackageScope$classes$1 extends Lambda implements Function1<FindClassRequest, ClassDescriptor> {
    final /* synthetic */ LazyJavaPackageScope f38408a;
    final /* synthetic */ LazyJavaResolverContext f38409b;

    LazyJavaPackageScope$classes$1(LazyJavaPackageScope lazyJavaPackageScope, LazyJavaResolverContext lazyJavaResolverContext) {
        this.f38408a = lazyJavaPackageScope;
        this.f38409b = lazyJavaResolverContext;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        KotlinJvmBinaryClass a;
        FindClassRequest findClassRequest = (FindClassRequest) obj;
        Intrinsics.m26847b(findClassRequest, "request");
        ClassId classId = new ClassId(this.f38408a.f40287a.f40724d, findClassRequest.f25706a);
        if (findClassRequest.f25707b != null) {
            a = this.f38409b.f25703b.f25687c.mo5854a(findClassRequest.f25707b);
        } else {
            a = this.f38409b.f25703b.f25687c.mo5855a(classId);
        }
        ClassId a2 = a != null ? a.mo5849a() : null;
        if (a2 != null && (a2.m27402e() || a2.f25852a)) {
            return null;
        }
        KotlinClassLookupResult a3 = LazyJavaPackageScope.m41490a(this.f38408a, a);
        if (a3 instanceof Found) {
            return ((Found) a3).f32727a;
        }
        if (a3 instanceof SyntheticClass) {
            return null;
        }
        if (a3 instanceof NotFound) {
            JavaClass javaClass = findClassRequest.f25707b;
            if (javaClass == null) {
                javaClass = this.f38409b.f25703b.f25686b.mo5797a(classId);
            }
            if (Intrinsics.m26845a(null, LightClassOriginKind.f25729b)) {
                StringBuilder stringBuilder = new StringBuilder("Couldn't find kotlin binary class for light class created by kotlin binary file\n");
                StringBuilder stringBuilder2 = new StringBuilder("JavaClass: ");
                stringBuilder2.append(javaClass);
                stringBuilder2.append("\n");
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder2 = new StringBuilder("ClassId: ");
                stringBuilder2.append(classId);
                stringBuilder2.append("\n");
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder2 = new StringBuilder("findKotlinClass(JavaClass) = ");
                stringBuilder2.append(this.f38409b.f25703b.f25687c.mo5854a(javaClass));
                stringBuilder2.append("\n");
                stringBuilder.append(stringBuilder2.toString());
                obj = new StringBuilder("findKotlinClass(ClassId) = ");
                obj.append(this.f38409b.f25703b.f25687c.mo5855a(classId));
                obj.append("\n");
                stringBuilder.append(obj.toString());
                throw new IllegalStateException(stringBuilder.toString());
            }
            if (javaClass != null) {
                FqName b = javaClass.mo7274b();
                if (b != null) {
                    Object obj2 = (b.f25856b.f25861b.isEmpty() || !Intrinsics.m26845a(b.m27411d(), this.f38408a.f40287a.f40724d)) ? null : 1;
                    if (!_Assertions.f25274a || obj2 != null) {
                        return new LazyJavaClassDescriptor(this.f38409b, this.f38408a.f40287a, javaClass);
                    }
                    obj = new StringBuilder("Java class by request ");
                    obj.append(classId);
                    obj.append(" should be contained in package ");
                    obj.append(this.f38408a.f40287a.f40724d);
                    obj.append(", but it's fq-name: ");
                    obj.append(b);
                    throw new AssertionError(obj.toString());
                }
            }
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
