package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* compiled from: ReflectJavaType.kt */
public abstract class ReflectJavaType implements JavaType {
    public static final Factory f32758b = new Factory();

    /* compiled from: ReflectJavaType.kt */
    public static final class Factory {
        private Factory() {
        }

        public static ReflectJavaType m27256a(Type type) {
            Intrinsics.m26847b(type, "type");
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return (ReflectJavaType) new ReflectJavaPrimitiveType(cls);
                }
            }
            if (!(type instanceof GenericArrayType)) {
                if (!z || !((Class) type).isArray()) {
                    if (type instanceof WildcardType) {
                        return new ReflectJavaWildcardType((WildcardType) type);
                    }
                    return new ReflectJavaClassifierType(type);
                }
            }
            return new ReflectJavaArrayType(type);
        }
    }

    protected abstract Type aQ_();

    public boolean equals(Object obj) {
        return (!(obj instanceof ReflectJavaType) || Intrinsics.m26845a(aQ_(), ((ReflectJavaType) obj).aQ_()) == null) ? null : true;
    }

    public int hashCode() {
        return aQ_().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName());
        stringBuilder.append(": ");
        stringBuilder.append(aQ_());
        return stringBuilder.toString();
    }
}
