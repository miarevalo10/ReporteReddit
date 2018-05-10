package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;

/* compiled from: ReflectAnnotationSource.kt */
public final class ReflectAnnotationSource implements SourceElement {
    public final Annotation f32846b;

    public ReflectAnnotationSource(Annotation annotation) {
        Intrinsics.m26847b(annotation, "annotation");
        this.f32846b = annotation;
    }

    public final SourceFile mo5713a() {
        Object obj = SourceFile.f25499a;
        Intrinsics.m26843a(obj, "SourceFile.NO_SOURCE_FILE");
        return obj;
    }
}
