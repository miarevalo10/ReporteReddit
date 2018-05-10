package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* compiled from: DeserializedClassDescriptor.kt */
final class DeserializedClassDescriptor$companionObjectDescriptor$1 extends Lambda implements Function0<ClassDescriptor> {
    final /* synthetic */ DeserializedClassDescriptor f38883a;

    DeserializedClassDescriptor$companionObjectDescriptor$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        this.f38883a = deserializedClassDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return DeserializedClassDescriptor.m42842f(this.f38883a);
    }
}
