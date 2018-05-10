package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$typeAliasDescriptors$1 extends Lambda implements Function1<Integer, ClassifierDescriptor> {
    final /* synthetic */ TypeDeserializer f38866a;

    TypeDeserializer$typeAliasDescriptors$1(TypeDeserializer typeDeserializer) {
        this.f38866a = typeDeserializer;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        return TypeDeserializer.m27886b(this.f38866a, ((Number) obj).intValue());
    }
}
