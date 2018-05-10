package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: FlexibleTypeDeserializer.kt */
public interface FlexibleTypeDeserializer {

    /* compiled from: FlexibleTypeDeserializer.kt */
    public static final class ThrowException implements FlexibleTypeDeserializer {
        public static final ThrowException f33035a = null;

        static {
            ThrowException throwException = new ThrowException();
        }

        private ThrowException() {
            f33035a = this;
        }

        public final KotlinType mo5823a(Type type, String str, SimpleType simpleType, SimpleType simpleType2) {
            Intrinsics.m26847b(type, "proto");
            Intrinsics.m26847b(str, "flexibleId");
            Intrinsics.m26847b(simpleType, "lowerBound");
            Intrinsics.m26847b(simpleType2, "upperBound");
            throw ((Throwable) new IllegalArgumentException("This method should not be used."));
        }
    }

    KotlinType mo5823a(Type type, String str, SimpleType simpleType, SimpleType simpleType2);
}
