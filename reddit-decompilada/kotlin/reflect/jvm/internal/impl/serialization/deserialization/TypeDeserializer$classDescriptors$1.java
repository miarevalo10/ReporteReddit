package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$classDescriptors$1 extends Lambda implements Function1<Integer, ClassDescriptor> {
    final /* synthetic */ TypeDeserializer f38860a;

    TypeDeserializer$classDescriptors$1(TypeDeserializer typeDeserializer) {
        this.f38860a = typeDeserializer;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return TypeDeserializer.m27882a(this.f38860a, ((Number) obj).intValue());
    }
}
