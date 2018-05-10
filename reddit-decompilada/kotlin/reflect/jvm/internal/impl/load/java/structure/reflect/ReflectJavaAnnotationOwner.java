package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaAnnotationOwner.kt */
public interface ReflectJavaAnnotationOwner extends JavaAnnotationOwner {

    /* compiled from: ReflectJavaAnnotationOwner.kt */
    public static final class DefaultImpls {
        public static List<ReflectJavaAnnotation> m27248a(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner) {
            reflectJavaAnnotationOwner = reflectJavaAnnotationOwner.mo7104r();
            if (reflectJavaAnnotationOwner != null) {
                reflectJavaAnnotationOwner = reflectJavaAnnotationOwner.getDeclaredAnnotations();
                if (reflectJavaAnnotationOwner != null) {
                    return ReflectJavaAnnotationOwnerKt.m27250a(reflectJavaAnnotationOwner);
                }
            }
            return CollectionsKt__CollectionsKt.m26790a();
        }

        public static ReflectJavaAnnotation m27249a(ReflectJavaAnnotationOwner reflectJavaAnnotationOwner, FqName fqName) {
            Intrinsics.m26847b(fqName, "fqName");
            reflectJavaAnnotationOwner = reflectJavaAnnotationOwner.mo7104r();
            if (reflectJavaAnnotationOwner != null) {
                reflectJavaAnnotationOwner = reflectJavaAnnotationOwner.getDeclaredAnnotations();
                if (reflectJavaAnnotationOwner != null) {
                    return ReflectJavaAnnotationOwnerKt.m27251a(reflectJavaAnnotationOwner, fqName);
                }
            }
            return null;
        }
    }

    AnnotatedElement mo7104r();
}
