package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner;

/* compiled from: LazyJavaAnnotations.kt */
public final class LazyJavaAnnotationsKt {
    public static final Annotations m27201a(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotationOwner javaAnnotationOwner) {
        Intrinsics.m26847b(lazyJavaResolverContext, "$receiver");
        Intrinsics.m26847b(javaAnnotationOwner, "annotationsOwner");
        return new LazyJavaAnnotations(lazyJavaResolverContext, javaAnnotationOwner);
    }
}
