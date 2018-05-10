package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* compiled from: DeserializedClassDescriptor.kt */
final class DeserializedClassDescriptor$sealedSubclasses$1 extends Lambda implements Function0<Collection<? extends ClassDescriptor>> {
    final /* synthetic */ DeserializedClassDescriptor f38886a;

    DeserializedClassDescriptor$sealedSubclasses$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        this.f38886a = deserializedClassDescriptor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return DeserializedClassDescriptor.m42843g(this.f38886a);
    }
}
