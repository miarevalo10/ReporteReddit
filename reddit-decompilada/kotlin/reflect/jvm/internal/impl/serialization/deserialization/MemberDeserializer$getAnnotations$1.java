package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationWithTarget;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$getAnnotations$1 extends Lambda implements Function0<List<? extends AnnotationWithTarget>> {
    final /* synthetic */ MemberDeserializer f38834a;
    final /* synthetic */ MessageLite f38835b;
    final /* synthetic */ AnnotatedCallableKind f38836c;

    MemberDeserializer$getAnnotations$1(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        this.f38834a = memberDeserializer;
        this.f38835b = messageLite;
        this.f38836c = annotatedCallableKind;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        ProtoContainer a = this.f38834a.m27848a(this.f38834a.f26257b.f26247e);
        Object a2 = a != null ? this.f38834a.f26257b.f26245c.f26233f.mo5810a(a, this.f38835b, this.f38836c) : null;
        return a2 == null ? CollectionsKt__CollectionsKt.m26790a() : a2;
    }
}
