package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: Annotations.kt */
final class CompositeAnnotations$findAnnotation$1 extends Lambda implements Function1<Annotations, AnnotationDescriptor> {
    final /* synthetic */ FqName f38330a;

    CompositeAnnotations$findAnnotation$1(FqName fqName) {
        this.f38330a = fqName;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Annotations annotations = (Annotations) obj;
        Intrinsics.m26847b(annotations, "it");
        return annotations.mo6679a(this.f38330a);
    }
}
