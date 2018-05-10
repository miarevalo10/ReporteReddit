package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AdditionalClassPartsProvider.kt */
public interface AdditionalClassPartsProvider {

    /* compiled from: AdditionalClassPartsProvider.kt */
    public static final class None implements AdditionalClassPartsProvider {
        public static final None f33030a = null;

        static {
            None none = new None();
        }

        private None() {
            f33030a = this;
        }

        public final Collection<KotlinType> mo5825a(DeserializedClassDescriptor deserializedClassDescriptor) {
            Intrinsics.m26847b(deserializedClassDescriptor, "classDescriptor");
            return CollectionsKt__CollectionsKt.m26790a();
        }

        public final Collection<SimpleFunctionDescriptor> mo5824a(Name name, DeserializedClassDescriptor deserializedClassDescriptor) {
            Intrinsics.m26847b(name, "name");
            Intrinsics.m26847b(deserializedClassDescriptor, "classDescriptor");
            return CollectionsKt__CollectionsKt.m26790a();
        }

        public final Collection<Name> mo5827b(DeserializedClassDescriptor deserializedClassDescriptor) {
            Intrinsics.m26847b(deserializedClassDescriptor, "classDescriptor");
            return CollectionsKt__CollectionsKt.m26790a();
        }

        public final Collection<ClassConstructorDescriptor> mo5828c(DeserializedClassDescriptor deserializedClassDescriptor) {
            Intrinsics.m26847b(deserializedClassDescriptor, "classDescriptor");
            return CollectionsKt__CollectionsKt.m26790a();
        }
    }

    Collection<SimpleFunctionDescriptor> mo5824a(Name name, DeserializedClassDescriptor deserializedClassDescriptor);

    Collection<KotlinType> mo5825a(DeserializedClassDescriptor deserializedClassDescriptor);

    Collection<Name> mo5827b(DeserializedClassDescriptor deserializedClassDescriptor);

    Collection<ClassConstructorDescriptor> mo5828c(DeserializedClassDescriptor deserializedClassDescriptor);
}
