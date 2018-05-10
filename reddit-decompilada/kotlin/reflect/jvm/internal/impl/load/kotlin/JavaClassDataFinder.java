package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.ClassDataWithSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder;

/* compiled from: JavaClassDataFinder.kt */
public final class JavaClassDataFinder implements ClassDataFinder {
    private final KotlinClassFinder f32788a;
    private final DeserializedDescriptorResolver f32789b;

    public JavaClassDataFinder(KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver) {
        Intrinsics.m26847b(kotlinClassFinder, "kotlinClassFinder");
        Intrinsics.m26847b(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        this.f32788a = kotlinClassFinder;
        this.f32789b = deserializedDescriptorResolver;
    }

    public final ClassDataWithSource mo5703a(ClassId classId) {
        Intrinsics.m26847b(classId, "classId");
        KotlinJvmBinaryClass a = this.f32788a.mo5855a(classId);
        if (a == null) {
            return null;
        }
        boolean a2 = Intrinsics.m26845a(a.mo5849a(), (Object) classId);
        if (!_Assertions.f25274a || a2) {
            return DeserializedDescriptorResolver.m27291a(a);
        }
        StringBuilder stringBuilder = new StringBuilder("Class with incorrect id found: expected ");
        stringBuilder.append(classId);
        stringBuilder.append(", actual ");
        stringBuilder.append(a.mo5849a());
        throw new AssertionError(stringBuilder.toString());
    }
}
