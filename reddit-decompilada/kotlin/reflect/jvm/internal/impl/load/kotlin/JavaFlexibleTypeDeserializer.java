package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.GeneratedExtension;
import kotlin.reflect.jvm.internal.impl.serialization.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: JavaFlexibleTypeDeserializer.kt */
public final class JavaFlexibleTypeDeserializer implements FlexibleTypeDeserializer {
    public static final JavaFlexibleTypeDeserializer f32790a = null;
    private static final String f32791b = "kotlin.jvm.PlatformType";

    static {
        JavaFlexibleTypeDeserializer javaFlexibleTypeDeserializer = new JavaFlexibleTypeDeserializer();
    }

    private JavaFlexibleTypeDeserializer() {
        f32790a = this;
        f32791b = f32791b;
    }

    public final KotlinType mo5823a(Type type, String str, SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.m26847b(type, "proto");
        Intrinsics.m26847b(str, "flexibleId");
        Intrinsics.m26847b(simpleType, "lowerBound");
        Intrinsics.m26847b(simpleType2, "upperBound");
        if ((Intrinsics.m26845a((Object) str, f32791b) ^ 1) != 0) {
            type = new StringBuilder("Error java flexible type with id: ");
            type.append(str);
            type.append(". (");
            type.append(simpleType);
            type.append("..");
            type.append(simpleType2);
            type.append(")");
            Object c = ErrorUtils.m27943c(type.toString());
            Intrinsics.m26843a(c, "ErrorUtils.createErrorTy…owerBound..$upperBound)\")");
            return (KotlinType) c;
        } else if (type.m39930a((GeneratedExtension) JvmProtoBuf.f26291e) != null) {
            return (KotlinType) new RawTypeImpl(simpleType, simpleType2);
        } else {
            return KotlinTypeFactory.m27953a(simpleType, simpleType2);
        }
    }
}
