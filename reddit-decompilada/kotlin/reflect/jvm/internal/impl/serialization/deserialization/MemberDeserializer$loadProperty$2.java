package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$loadProperty$2 extends Lambda implements Function0<ConstantValue<?>> {
    final /* synthetic */ MemberDeserializer f38840a;
    final /* synthetic */ Property f38841b;
    final /* synthetic */ DeserializedPropertyDescriptor f38842c;

    MemberDeserializer$loadProperty$2(MemberDeserializer memberDeserializer, Property property, DeserializedPropertyDescriptor deserializedPropertyDescriptor) {
        this.f38840a = memberDeserializer;
        this.f38841b = property;
        this.f38842c = deserializedPropertyDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        ProtoContainer a = this.f38840a.m27848a(this.f38840a.f26257b.f26247e);
        if (a == null) {
            Intrinsics.m26842a();
        }
        AnnotationAndConstantLoader annotationAndConstantLoader = this.f38840a.f26257b.f26245c.f26233f;
        Property property = this.f38841b;
        KotlinType aN_ = this.f38842c.aN_();
        Intrinsics.m26843a((Object) aN_, "property.returnType");
        return (ConstantValue) annotationAndConstantLoader.mo5806a(a, property, aN_);
    }
}
