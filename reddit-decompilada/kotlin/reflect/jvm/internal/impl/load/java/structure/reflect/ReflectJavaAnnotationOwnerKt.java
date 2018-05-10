package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaAnnotationOwner.kt */
public final class ReflectJavaAnnotationOwnerKt {
    public static final List<ReflectJavaAnnotation> m27250a(Annotation[] annotationArr) {
        Intrinsics.m26847b(annotationArr, "$receiver");
        Object[] objArr = (Object[]) annotationArr;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(new ReflectJavaAnnotation((Annotation) obj));
        }
        return (List) arrayList;
    }

    public static final ReflectJavaAnnotation m27251a(Annotation[] annotationArr, FqName fqName) {
        Intrinsics.m26847b(annotationArr, "$receiver");
        Intrinsics.m26847b(fqName, "fqName");
        Object[] objArr = (Object[]) annotationArr;
        for (Object obj : objArr) {
            if (Intrinsics.m26845a(ReflectClassUtilKt.m27244e(JvmClassMappingKt.m26829a(JvmClassMappingKt.m26831a((Annotation) obj))).m27403f(), (Object) fqName)) {
                break;
            }
        }
        Object obj2 = null;
        Annotation annotation = (Annotation) obj2;
        return annotation != null ? (ReflectJavaAnnotation) new ReflectJavaAnnotation(annotation) : null;
    }
}
