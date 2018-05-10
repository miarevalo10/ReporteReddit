package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$createSuspendFunctionType$result$1 extends Lambda implements Function1<SimpleType, Boolean> {
    public static final TypeDeserializer$createSuspendFunctionType$result$1 f38861a = new TypeDeserializer$createSuspendFunctionType$result$1();

    TypeDeserializer$createSuspendFunctionType$result$1() {
        super(1);
    }

    public final /* synthetic */ Object mo6492a(Object obj) {
        SimpleType simpleType = (SimpleType) obj;
        Intrinsics.m26847b(simpleType, "it");
        return Boolean.valueOf(FunctionTypesKt.m26948a((KotlinType) simpleType));
    }
}
