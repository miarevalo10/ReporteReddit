package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;

/* compiled from: DeserializedClassDescriptor.kt */
final class C2996x32944d2c extends Lambda implements Function0<List<? extends TypeParameterDescriptor>> {
    final /* synthetic */ DeserializedClassTypeConstructor f38874a;

    C2996x32944d2c(DeserializedClassTypeConstructor deserializedClassTypeConstructor) {
        this.f38874a = deserializedClassTypeConstructor;
        super(0);
    }

    public final /* synthetic */ Object invoke() {
        return TypeParameterUtilsKt.m27089a((ClassifierDescriptorWithTypeParameters) this.f38874a.f38875a);
    }
}
