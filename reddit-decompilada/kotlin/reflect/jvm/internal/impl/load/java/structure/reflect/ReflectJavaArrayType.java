package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType.Factory;

/* compiled from: ReflectJavaArrayType.kt */
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {
    private final ReflectJavaType f36102a;
    private final Type f36103c;

    public ReflectJavaArrayType(Type type) {
        Intrinsics.m26847b(type, "reflectType");
        this.f36103c = type;
        type = this.f36103c;
        Object genericComponentType;
        if (type instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            Intrinsics.m26843a(genericComponentType, "genericComponentType");
            type = Factory.m27256a(genericComponentType);
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    genericComponentType = cls.getComponentType();
                    Intrinsics.m26843a(genericComponentType, "getComponentType()");
                    type = Factory.m27256a((Type) genericComponentType);
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Not an array type (");
            stringBuilder.append(this.f36103c.getClass());
            stringBuilder.append("): ");
            stringBuilder.append(this.f36103c);
            throw ((Throwable) new IllegalArgumentException(stringBuilder.toString()));
        }
        this.f36102a = (ReflectJavaType) type;
    }

    protected final Type aQ_() {
        return this.f36103c;
    }

    public final /* bridge */ /* synthetic */ JavaType mo6706a() {
        return this.f36102a;
    }
}
