package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.reflect.ReflectJavaClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.reflect.ReflectKotlinClass.Factory;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: ReflectKotlinClassFinder.kt */
public final class ReflectKotlinClassFinder implements KotlinClassFinder {
    private final ClassLoader f32850a;

    public ReflectKotlinClassFinder(ClassLoader classLoader) {
        Intrinsics.m26847b(classLoader, "classLoader");
        this.f32850a = classLoader;
    }

    private final KotlinJvmBinaryClass m33265a(String str) {
        str = ReflectJavaClassFinderKt.m27234a(this.f32850a, str);
        if (str != null) {
            Class cls = (Class) str;
            Factory factory = ReflectKotlinClass.f32847c;
            str = Factory.m27389a(cls);
        } else {
            str = null;
        }
        return (KotlinJvmBinaryClass) str;
    }

    public final KotlinJvmBinaryClass mo5855a(ClassId classId) {
        Intrinsics.m26847b(classId, "classId");
        return m33265a(ReflectKotlinClassFinderKt.m27390a(classId));
    }

    public final KotlinJvmBinaryClass mo5854a(JavaClass javaClass) {
        Intrinsics.m26847b(javaClass, "javaClass");
        javaClass = javaClass.mo7274b();
        if (javaClass != null) {
            String a = javaClass.m27407a();
            if (a != null) {
                return m33265a(a);
            }
        }
        return null;
    }
}
