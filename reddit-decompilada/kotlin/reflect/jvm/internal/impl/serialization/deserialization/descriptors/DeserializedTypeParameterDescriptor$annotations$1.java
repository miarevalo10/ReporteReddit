package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;

/* compiled from: DeserializedTypeParameterDescriptor.kt */
final class DeserializedTypeParameterDescriptor$annotations$1 extends Lambda implements Function0<List<? extends AnnotationWithTarget>> {
    final /* synthetic */ DeserializedTypeParameterDescriptor f38910a;

    DeserializedTypeParameterDescriptor$annotations$1(DeserializedTypeParameterDescriptor deserializedTypeParameterDescriptor) {
        this.f38910a = deserializedTypeParameterDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Iterable<AnnotationDescriptor> a = this.f38910a.f40896c.f26245c.f26233f.mo5808a(this.f38910a.f40897d, this.f38910a.f40896c.f26246d);
        Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(a));
        for (AnnotationDescriptor annotationWithTarget : a) {
            arrayList.add(new AnnotationWithTarget(annotationWithTarget, null));
        }
        return (List) arrayList;
    }
}
