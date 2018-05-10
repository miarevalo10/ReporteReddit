package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;

/* compiled from: Annotations.kt */
final class CompositeAnnotations$iterator$1 extends Lambda implements Function1<Annotations, Sequence<? extends AnnotationDescriptor>> {
    public static final CompositeAnnotations$iterator$1 f38331a = new CompositeAnnotations$iterator$1();

    CompositeAnnotations$iterator$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        Annotations annotations = (Annotations) obj;
        Intrinsics.m26847b(annotations, "it");
        return CollectionsKt___CollectionsKt.m41455t(annotations);
    }
}
