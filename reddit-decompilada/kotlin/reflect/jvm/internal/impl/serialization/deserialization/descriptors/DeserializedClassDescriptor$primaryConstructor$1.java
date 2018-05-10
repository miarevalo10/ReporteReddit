package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;

/* compiled from: DeserializedClassDescriptor.kt */
final class DeserializedClassDescriptor$primaryConstructor$1 extends Lambda implements Function0<ClassConstructorDescriptor> {
    final /* synthetic */ DeserializedClassDescriptor f38885a;

    DeserializedClassDescriptor$primaryConstructor$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        this.f38885a = deserializedClassDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return DeserializedClassDescriptor.m42840d(this.f38885a);
    }
}
