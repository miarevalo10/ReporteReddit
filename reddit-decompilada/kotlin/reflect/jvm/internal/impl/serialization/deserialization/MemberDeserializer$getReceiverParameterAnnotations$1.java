package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$getReceiverParameterAnnotations$1 extends Lambda implements Function0<List<? extends AnnotationWithTarget>> {
    final /* synthetic */ MemberDeserializer f38837a;
    final /* synthetic */ MessageLite f38838b;
    final /* synthetic */ AnnotatedCallableKind f38839c;

    MemberDeserializer$getReceiverParameterAnnotations$1(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        this.f38837a = memberDeserializer;
        this.f38838b = messageLite;
        this.f38839c = annotatedCallableKind;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        Object obj;
        ProtoContainer a = this.f38837a.m27848a(this.f38837a.f26257b.f26247e);
        if (a != null) {
            Iterable<AnnotationDescriptor> b = this.f38837a.f26257b.f26245c.f26233f.mo5813b(a, this.f38838b, this.f38839c);
            Collection arrayList = new ArrayList(CollectionsKt__IterablesKt.m32812b(b));
            for (AnnotationDescriptor annotationWithTarget : b) {
                arrayList.add(new AnnotationWithTarget(annotationWithTarget, AnnotationUseSiteTarget.f25527f));
            }
            obj = (List) arrayList;
        } else {
            obj = null;
        }
        return obj == null ? CollectionsKt__CollectionsKt.m26790a() : obj;
    }
}
