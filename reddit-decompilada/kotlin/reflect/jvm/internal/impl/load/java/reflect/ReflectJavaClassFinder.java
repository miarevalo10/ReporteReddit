package kotlin.reflect.jvm.internal.impl.load.java.reflect;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: ReflectJavaClassFinder.kt */
public final class ReflectJavaClassFinder implements JavaClassFinder {
    private final ClassLoader f32755a;

    public final Set<String> mo5799b(FqName fqName) {
        Intrinsics.m26847b(fqName, "packageFqName");
        return null;
    }

    public ReflectJavaClassFinder(ClassLoader classLoader) {
        Intrinsics.m26847b(classLoader, "classLoader");
        this.f32755a = classLoader;
    }

    public final JavaClass mo5797a(ClassId classId) {
        Intrinsics.m26847b(classId, "classId");
        FqName a = classId.m27398a();
        classId = StringsKt__StringsJVMKt.m41941a((String) classId.m27399b().m27407a(), '.', '$');
        if (!a.f25856b.f25861b.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a.m27407a());
            stringBuilder.append(".");
            stringBuilder.append(classId);
            classId = stringBuilder.toString();
        }
        classId = ReflectJavaClassFinderKt.m27234a(this.f32755a, classId);
        return classId != null ? new ReflectJavaClass(classId) : null;
    }

    public final JavaPackage mo5798a(FqName fqName) {
        Intrinsics.m26847b(fqName, "fqName");
        return new ReflectJavaPackage(fqName);
    }
}
