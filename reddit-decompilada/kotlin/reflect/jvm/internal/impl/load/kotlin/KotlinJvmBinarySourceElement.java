package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;

/* compiled from: KotlinJvmBinarySourceElement.kt */
public final class KotlinJvmBinarySourceElement implements DeserializedContainerSource {
    public final KotlinJvmBinaryClass f36122b;
    private final IncompatibleVersionErrorData<JvmMetadataVersion> f36123c;
    private final boolean f36124d;

    public KotlinJvmBinarySourceElement(KotlinJvmBinaryClass kotlinJvmBinaryClass, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z) {
        Intrinsics.m26847b(kotlinJvmBinaryClass, "binaryClass");
        this.f36122b = kotlinJvmBinaryClass;
        this.f36123c = incompatibleVersionErrorData;
        this.f36124d = z;
    }

    public final SourceFile mo5713a() {
        Object obj = SourceFile.f25499a;
        Intrinsics.m26843a(obj, "SourceFile.NO_SOURCE_FILE");
        return obj;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(this.f36122b);
        return stringBuilder.toString();
    }
}
