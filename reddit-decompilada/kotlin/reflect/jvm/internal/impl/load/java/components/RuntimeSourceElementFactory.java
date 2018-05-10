package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaElement;

/* compiled from: RuntimeSourceElementFactory.kt */
public final class RuntimeSourceElementFactory implements JavaSourceElementFactory {
    public static final RuntimeSourceElementFactory f32703a = null;

    /* compiled from: RuntimeSourceElementFactory.kt */
    public static final class RuntimeSourceElement implements JavaSourceElement {
        public final ReflectJavaElement f36087b;

        public RuntimeSourceElement(ReflectJavaElement reflectJavaElement) {
            Intrinsics.m26847b(reflectJavaElement, "javaElement");
            this.f36087b = reflectJavaElement;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getClass().getName());
            stringBuilder.append(": ");
            stringBuilder.append(this.f36087b.toString());
            return stringBuilder.toString();
        }

        public final SourceFile mo5713a() {
            Object obj = SourceFile.f25499a;
            Intrinsics.m26843a(obj, "SourceFile.NO_SOURCE_FILE");
            return obj;
        }

        public final /* bridge */ /* synthetic */ JavaElement mo6693b() {
            return this.f36087b;
        }
    }

    static {
        RuntimeSourceElementFactory runtimeSourceElementFactory = new RuntimeSourceElementFactory();
    }

    private RuntimeSourceElementFactory() {
        f32703a = this;
    }

    public final JavaSourceElement mo5773a(JavaElement javaElement) {
        Intrinsics.m26847b(javaElement, "javaElement");
        if (javaElement != null) {
            return new RuntimeSourceElement((ReflectJavaElement) javaElement);
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.load.java.structure.reflect.ReflectJavaElement");
    }
}
