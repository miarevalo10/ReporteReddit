package kotlin.reflect.jvm.internal.impl.load.kotlin.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt;

/* compiled from: ReflectKotlinClass.kt */
final class SignatureSerializer {
    public static final SignatureSerializer f25850a = null;

    static {
        SignatureSerializer signatureSerializer = new SignatureSerializer();
    }

    private SignatureSerializer() {
        f25850a = this;
    }

    public static String m27395a(Method method) {
        Intrinsics.m26847b(method, "method");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        Class[] parameterTypes = method.getParameterTypes();
        for (Class f : parameterTypes) {
            stringBuilder.append(ReflectClassUtilKt.m27245f(f));
        }
        stringBuilder.append(")");
        stringBuilder.append(ReflectClassUtilKt.m27245f(method.getReturnType()));
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "sb.toString()");
        return stringBuilder2;
    }

    public static String m27393a(Constructor<?> constructor) {
        Intrinsics.m26847b(constructor, "constructor");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        constructor = constructor.getParameterTypes();
        for (Class f : constructor) {
            stringBuilder.append(ReflectClassUtilKt.m27245f(f));
        }
        stringBuilder.append(")V");
        Object stringBuilder2 = stringBuilder.toString();
        Intrinsics.m26843a(stringBuilder2, "sb.toString()");
        return stringBuilder2;
    }

    public static String m27394a(Field field) {
        Intrinsics.m26847b(field, "field");
        return ReflectClassUtilKt.m27245f(field.getType());
    }
}
