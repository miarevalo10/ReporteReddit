package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType.Factory;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaClassObjectAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaClassObjectAnnotationArgument {
    private final Class<?> f36104b;

    public ReflectJavaClassObjectAnnotationArgument(Name name, Class<?> cls) {
        Intrinsics.m26847b(cls, "klass");
        super(name);
        this.f36104b = cls;
    }

    public final JavaType mo6708b() {
        Factory factory = ReflectJavaType.f32758b;
        return Factory.m27256a(this.f36104b);
    }
}
