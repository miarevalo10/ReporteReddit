package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaLiteralAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaLiteralAnnotationArgument {
    private final Object f36106b;

    public final Object mo6710b() {
        return this.f36106b;
    }

    public ReflectJavaLiteralAnnotationArgument(Name name, Object obj) {
        Intrinsics.m26847b(obj, "value");
        super(name);
        this.f36106b = obj;
    }
}
