package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;

/* compiled from: DeserializedAnnotations.kt */
final class DeserializedAnnotationsWithPossibleTargets$iterator$2 extends Lambda implements Function1<AnnotationWithTarget, AnnotationDescriptor> {
    public static final DeserializedAnnotationsWithPossibleTargets$iterator$2 f38870a = new DeserializedAnnotationsWithPossibleTargets$iterator$2();

    DeserializedAnnotationsWithPossibleTargets$iterator$2() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        AnnotationWithTarget annotationWithTarget = (AnnotationWithTarget) obj;
        Intrinsics.m26847b(annotationWithTarget, "it");
        return annotationWithTarget.f25535a;
    }
}
