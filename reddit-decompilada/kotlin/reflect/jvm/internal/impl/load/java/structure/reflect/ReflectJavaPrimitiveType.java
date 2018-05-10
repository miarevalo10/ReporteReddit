package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: ReflectJavaPrimitiveType.kt */
public final class ReflectJavaPrimitiveType extends ReflectJavaType implements JavaPrimitiveType {
    private final Class<?> f36108a;

    public ReflectJavaPrimitiveType(Class<?> cls) {
        Intrinsics.m26847b(cls, "reflectType");
        this.f36108a = cls;
    }

    public final PrimitiveType mo6714a() {
        if (Intrinsics.m26845a(this.f36108a, Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.m27753a(this.f36108a.getName()).m27755a();
    }

    public final /* bridge */ /* synthetic */ Type aQ_() {
        return this.f36108a;
    }
}
