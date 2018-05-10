package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.ValueParameter;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ ProtoContainer f38843a;
    final /* synthetic */ int f38844b;
    final /* synthetic */ ValueParameter f38845c;
    final /* synthetic */ MemberDeserializer f38846d;
    final /* synthetic */ CallableDescriptor f38847e;
    final /* synthetic */ ProtoContainer f38848f;
    final /* synthetic */ MessageLite f38849g;
    final /* synthetic */ AnnotatedCallableKind f38850h;

    MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1(ProtoContainer protoContainer, int i, ValueParameter valueParameter, MemberDeserializer memberDeserializer, CallableDescriptor callableDescriptor, ProtoContainer protoContainer2, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        this.f38843a = protoContainer;
        this.f38844b = i;
        this.f38845c = valueParameter;
        this.f38846d = memberDeserializer;
        this.f38847e = callableDescriptor;
        this.f38848f = protoContainer2;
        this.f38849g = messageLite;
        this.f38850h = annotatedCallableKind;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return this.f38846d.f26257b.f26245c.f26233f.mo5811a(this.f38843a, this.f38849g, this.f38850h, this.f38844b, this.f38845c);
    }
}
