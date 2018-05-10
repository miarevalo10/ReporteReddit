package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;

/* compiled from: DeserializedClassDescriptor.kt */
final class C2995x1ddbb2bd extends Lambda implements Function1<SimpleFunctionDescriptor, Boolean> {
    final /* synthetic */ DeserializedClassMemberScope f38873a;

    C2995x1ddbb2bd(DeserializedClassMemberScope deserializedClassMemberScope) {
        this.f38873a = deserializedClassMemberScope;
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) obj;
        Intrinsics.m26847b(simpleFunctionDescriptor, "it");
        return Boolean.valueOf(this.f38873a.f38901b.f26245c.f26241n.mo5826a(this.f38873a.f39877a, simpleFunctionDescriptor));
    }
}
