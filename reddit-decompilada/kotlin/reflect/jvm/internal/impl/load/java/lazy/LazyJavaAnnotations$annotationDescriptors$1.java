package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaAnnotationMapper;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;

/* compiled from: LazyJavaAnnotations.kt */
final class LazyJavaAnnotations$annotationDescriptors$1 extends Lambda implements Function1<JavaAnnotation, AnnotationDescriptor> {
    final /* synthetic */ LazyJavaAnnotations f38372a;

    LazyJavaAnnotations$annotationDescriptors$1(LazyJavaAnnotations lazyJavaAnnotations) {
        this.f38372a = lazyJavaAnnotations;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        JavaAnnotation javaAnnotation = (JavaAnnotation) obj;
        Intrinsics.m26847b(javaAnnotation, "annotation");
        JavaAnnotationMapper javaAnnotationMapper = JavaAnnotationMapper.f25649a;
        return JavaAnnotationMapper.m27181a(javaAnnotation, this.f38372a.f36089c);
    }
}
