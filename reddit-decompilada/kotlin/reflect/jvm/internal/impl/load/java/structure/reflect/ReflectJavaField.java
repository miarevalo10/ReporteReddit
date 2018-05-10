package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectJavaType.Factory;

/* compiled from: ReflectJavaField.kt */
public final class ReflectJavaField extends ReflectJavaMember implements JavaField {
    public final Field f39727a;

    public ReflectJavaField(Field field) {
        Intrinsics.m26847b(field, "member");
        this.f39727a = field;
    }

    public final boolean mo7288b() {
        return this.f39727a.isEnumConstant();
    }

    public final /* synthetic */ JavaType aR_() {
        Factory factory = ReflectJavaType.f32758b;
        Object genericType = this.f39727a.getGenericType();
        Intrinsics.m26843a(genericType, "member.genericType");
        return Factory.m27256a(genericType);
    }

    public final /* bridge */ /* synthetic */ Member mo7286c() {
        return this.f39727a;
    }
}
