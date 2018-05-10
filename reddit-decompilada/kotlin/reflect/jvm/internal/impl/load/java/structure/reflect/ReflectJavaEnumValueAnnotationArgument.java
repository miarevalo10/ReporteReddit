package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaEnumValueAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaEnumValueAnnotationArgument {
    private final Enum<?> f36105b;

    public ReflectJavaEnumValueAnnotationArgument(Name name, Enum<?> enumR) {
        Intrinsics.m26847b(enumR, "value");
        super(name);
        this.f36105b = enumR;
    }

    public final /* synthetic */ JavaField mo6709b() {
        Class cls = this.f36105b.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        Object declaredField = cls.getDeclaredField(this.f36105b.name());
        Intrinsics.m26843a(declaredField, "enumClass.getDeclaredField(value.name)");
        return new ReflectJavaField(declaredField);
    }
}
