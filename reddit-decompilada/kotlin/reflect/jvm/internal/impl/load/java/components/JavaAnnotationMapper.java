package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: JavaAnnotationMapper.kt */
public final class JavaAnnotationMapper {
    public static final JavaAnnotationMapper f25649a = null;
    private static final FqName f25650b = null;
    private static final FqName f25651c = null;
    private static final FqName f25652d = null;
    private static final FqName f25653e = null;
    private static final FqName f25654f = null;
    private static final Name f25655g = null;
    private static final Name f25656h = null;
    private static final Map<FqName, FqName> f25657i = null;
    private static final Map<FqName, FqName> f25658j = null;

    static {
        JavaAnnotationMapper javaAnnotationMapper = new JavaAnnotationMapper();
    }

    private JavaAnnotationMapper() {
        f25649a = this;
        f25650b = new FqName(Target.class.getCanonicalName());
        f25651c = new FqName(Retention.class.getCanonicalName());
        f25652d = new FqName(Deprecated.class.getCanonicalName());
        f25653e = new FqName(Documented.class.getCanonicalName());
        f25654f = new FqName("java.lang.annotation.Repeatable");
        f25655g = Name.m27424a("message");
        f25656h = Name.m27424a("allowedTargets");
        f25657i = MapsKt__MapsKt.m36121a(TuplesKt.m26780a(KotlinBuiltIns.f25420j.f25356C, f25650b), TuplesKt.m26780a(KotlinBuiltIns.f25420j.f25359F, f25651c), TuplesKt.m26780a(KotlinBuiltIns.f25420j.f25360G, f25654f), TuplesKt.m26780a(KotlinBuiltIns.f25420j.f25361H, f25653e));
        f25658j = MapsKt__MapsKt.m36121a(TuplesKt.m26780a(f25650b, KotlinBuiltIns.f25420j.f25356C), TuplesKt.m26780a(f25651c, KotlinBuiltIns.f25420j.f25359F), TuplesKt.m26780a(f25652d, KotlinBuiltIns.f25420j.f25403x), TuplesKt.m26780a(f25654f, KotlinBuiltIns.f25420j.f25360G), TuplesKt.m26780a(f25653e, KotlinBuiltIns.f25420j.f25361H));
    }

    public static Name m27183a() {
        return f25655g;
    }

    public static Name m27184b() {
        return f25656h;
    }

    public static AnnotationDescriptor m27181a(JavaAnnotation javaAnnotation, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.m26847b(javaAnnotation, "annotation");
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        Object b = javaAnnotation.mo6702b();
        if (Intrinsics.m26845a(b, ClassId.m27396a(f25650b))) {
            return new JavaTargetAnnotationDescriptor(javaAnnotation, lazyJavaResolverContext);
        }
        if (Intrinsics.m26845a(b, ClassId.m27396a(f25651c))) {
            return new JavaRetentionAnnotationDescriptor(javaAnnotation, lazyJavaResolverContext);
        }
        Object a;
        if (Intrinsics.m26845a(b, ClassId.m27396a(f25654f))) {
            a = lazyJavaResolverContext.f25703b.f25700p.mo7089b().m26999a(KotlinBuiltIns.f25420j.f25360G.m27412e());
            if (a == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getRepeatableAnnotation"}));
            }
            Intrinsics.m26843a(a, "c.module.builtIns.repeatableAnnotation");
            return new JavaAnnotationDescriptor(lazyJavaResolverContext, javaAnnotation, a);
        } else if (Intrinsics.m26845a(b, ClassId.m27396a(f25653e))) {
            a = lazyJavaResolverContext.f25703b.f25700p.mo7089b().m26999a(KotlinBuiltIns.f25420j.f25361H.m27412e());
            if (a == null) {
                throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", new Object[]{"kotlin/reflect/jvm/internal/impl/builtins/KotlinBuiltIns", "getMustBeDocumentedAnnotation"}));
            }
            Intrinsics.m26843a(a, "c.module.builtIns.mustBeDocumentedAnnotation");
            return new JavaAnnotationDescriptor(lazyJavaResolverContext, javaAnnotation, a);
        } else if (Intrinsics.m26845a(b, ClassId.m27396a(f25652d))) {
            return null;
        } else {
            return new LazyJavaAnnotationDescriptor(lazyJavaResolverContext, javaAnnotation);
        }
    }

    public static AnnotationDescriptor m27182a(FqName fqName, JavaAnnotationOwner javaAnnotationOwner, LazyJavaResolverContext lazyJavaResolverContext) {
        Intrinsics.m26847b(fqName, "kotlinName");
        Intrinsics.m26847b(javaAnnotationOwner, "annotationOwner");
        Intrinsics.m26847b(lazyJavaResolverContext, "c");
        if (Intrinsics.m26845a((Object) fqName, KotlinBuiltIns.f25420j.f25403x)) {
            JavaAnnotation a = javaAnnotationOwner.mo7092a(f25652d);
            if (a != null) {
                return (AnnotationDescriptor) new JavaDeprecatedAnnotationDescriptor(a, lazyJavaResolverContext);
            }
        }
        fqName = (FqName) f25657i.get(fqName);
        AnnotationDescriptor annotationDescriptor = null;
        if (fqName != null) {
            fqName = javaAnnotationOwner.mo7092a(fqName);
            if (fqName != null) {
                annotationDescriptor = m27181a((JavaAnnotation) fqName, lazyJavaResolverContext);
            }
            annotationDescriptor = annotationDescriptor;
        }
        return annotationDescriptor;
    }
}
