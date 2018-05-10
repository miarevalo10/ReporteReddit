package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;

/* compiled from: DeserializedAnnotations.kt */
final class DeserializedAnnotationsWithPossibleTargets$iterator$1 extends Lambda implements Function1<AnnotationWithTarget, Boolean> {
    public static final DeserializedAnnotationsWithPossibleTargets$iterator$1 f38869a = new DeserializedAnnotationsWithPossibleTargets$iterator$1();

    DeserializedAnnotationsWithPossibleTargets$iterator$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        AnnotationWithTarget annotationWithTarget = (AnnotationWithTarget) obj;
        Intrinsics.m26847b(annotationWithTarget, "it");
        return Boolean.valueOf(annotationWithTarget.f25536b == null ? true : null);
    }
}
