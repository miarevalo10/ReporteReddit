package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaAnnotationAsAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaAnnotationAsAnnotationArgument {
    private final Annotation f36100b;

    public ReflectJavaAnnotationAsAnnotationArgument(Name name, Annotation annotation) {
        Intrinsics.m26847b(annotation, "annotation");
        super(name);
        this.f36100b = annotation;
    }

    public final JavaAnnotation mo6704b() {
        return new ReflectJavaAnnotation(this.f36100b);
    }
}
