package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: JvmPackagePartSource.kt */
public final class JvmPackagePartSource implements DeserializedContainerSource {
    final JvmClassName f36118b;
    public final JvmClassName f36119c;
    private final IncompatibleVersionErrorData<JvmMetadataVersion> f36120d;
    private final boolean f36121e;

    private JvmPackagePartSource(JvmClassName jvmClassName, JvmClassName jvmClassName2, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z) {
        Intrinsics.m26847b(jvmClassName, "className");
        this.f36118b = jvmClassName;
        this.f36119c = jvmClassName2;
        this.f36120d = incompatibleVersionErrorData;
        this.f36121e = z;
    }

    public JvmPackagePartSource(KotlinJvmBinaryClass kotlinJvmBinaryClass, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z) {
        Intrinsics.m26847b(kotlinJvmBinaryClass, "kotlinClass");
        Object a = JvmClassName.m27749a(kotlinJvmBinaryClass.mo5849a());
        Intrinsics.m26843a(a, "JvmClassName.byClassId(kotlinClass.classId)");
        kotlinJvmBinaryClass = kotlinJvmBinaryClass.mo5853c().m27385a();
        JvmClassName jvmClassName = null;
        if (kotlinJvmBinaryClass != null) {
            String str = (String) kotlinJvmBinaryClass;
            if ((((CharSequence) str).length() > 0 ? 1 : null) != null) {
                jvmClassName = JvmClassName.m27748a(str);
            }
            jvmClassName = jvmClassName;
        }
        this(a, jvmClassName, incompatibleVersionErrorData, z);
    }

    public final Name m36309b() {
        Object a = Name.m27424a(StringsKt__StringsKt.m42458b(this.f36118b.m27752a(), '/'));
        Intrinsics.m26843a(a, "Name.identifier(classNam….substringAfterLast('/'))");
        return a;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(": ");
        stringBuilder.append(this.f36118b);
        return stringBuilder.toString();
    }

    public final SourceFile mo5713a() {
        Object obj = SourceFile.f25499a;
        Intrinsics.m26843a(obj, "SourceFile.NO_SOURCE_FILE");
        return obj;
    }
}
