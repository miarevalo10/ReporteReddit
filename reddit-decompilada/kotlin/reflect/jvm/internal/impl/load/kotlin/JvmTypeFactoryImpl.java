package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Array;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: methodSignatureMapping.kt */
final class JvmTypeFactoryImpl implements JvmTypeFactory<JvmType> {
    public static final JvmTypeFactoryImpl f32824a = null;

    static {
        JvmTypeFactoryImpl jvmTypeFactoryImpl = new JvmTypeFactoryImpl();
    }

    private JvmTypeFactoryImpl() {
        f32824a = this;
    }

    public final /* synthetic */ Object mo5833a(Object obj) {
        JvmType jvmType = (JvmType) obj;
        Intrinsics.m26847b(jvmType, "possiblyPrimitiveType");
        if (jvmType instanceof Primitive) {
            Primitive primitive = (Primitive) jvmType;
            if (primitive.f32823a != null) {
                obj = JvmClassName.m27751a(primitive.f32823a.m27758d()).m27752a();
                Intrinsics.m26843a(obj, "JvmClassName.byFqNameWit…apperFqName).internalName");
                return m33210d(obj);
            }
        }
        return jvmType;
    }

    public final /* synthetic */ Object mo5834a(String str) {
        return m33209c(str);
    }

    public final /* synthetic */ Object mo5835b(String str) {
        return m33210d(str);
    }

    public final /* synthetic */ String mo5836b(Object obj) {
        return m33214a((JvmType) obj);
    }

    private JvmType m33209c(String str) {
        Intrinsics.m26847b(str, "representation");
        int i = 0;
        int i2 = str.length() > 0 ? 1 : 0;
        if (_Assertions.f25274a && i2 == 0) {
            throw new AssertionError("empty string as JvmType");
        }
        char charAt = str.charAt(0);
        Object[] objArr = (Object[]) JvmPrimitiveType.values();
        for (Object obj : objArr) {
            if ((((JvmPrimitiveType) obj).m27757c().charAt(0) == charAt ? 1 : 0) != 0) {
                break;
            }
        }
        Object obj2 = null;
        JvmPrimitiveType jvmPrimitiveType = (JvmPrimitiveType) obj2;
        if (jvmPrimitiveType != null) {
            return (JvmType) new Primitive(jvmPrimitiveType);
        }
        if (charAt == 'V') {
            return (JvmType) new Primitive(null);
        }
        Object substring;
        if (charAt != '[') {
            if (charAt == 'L' && StringsKt__StringsKt.m42468f(str)) {
                i = 1;
            }
            if (_Assertions.f25274a && r1 == 0) {
                StringBuilder stringBuilder = new StringBuilder("Type that is not primitive nor array should be Object, but '");
                stringBuilder.append(str);
                stringBuilder.append("' was found");
                throw new AssertionError(stringBuilder.toString());
            }
            i = str.length() - 1;
            if (str == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            substring = str.substring(1, i);
            Intrinsics.m26843a(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return new Object(substring);
        } else if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } else {
            substring = str.substring(1);
            Intrinsics.m26843a(substring, "(this as java.lang.String).substring(startIndex)");
            return new Array(m33209c(substring));
        }
    }

    private static Object m33210d(String str) {
        Intrinsics.m26847b(str, "internalName");
        return new Object(str);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m33214a(kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType r3) {
        /*
        r2 = this;
        r0 = "type";
        kotlin.jvm.internal.Intrinsics.m26847b(r3, r0);
        r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Array;
        if (r0 == 0) goto L_0x0021;
    L_0x000a:
        r0 = new java.lang.StringBuilder;
        r1 = "[";
        r0.<init>(r1);
        r3 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Array) r3;
        r3 = r3.f32821a;
        r3 = r2.m33214a(r3);
        r0.append(r3);
        r3 = r0.toString();
        return r3;
    L_0x0021:
        r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive;
        if (r0 == 0) goto L_0x0034;
    L_0x0025:
        r3 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive) r3;
        r3 = r3.f32823a;
        if (r3 == 0) goto L_0x0031;
    L_0x002b:
        r3 = r3.m27757c();
        if (r3 != 0) goto L_0x0033;
    L_0x0031:
        r3 = "V";
    L_0x0033:
        return r3;
    L_0x0034:
        r0 = r3 instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object;
        if (r0 == 0) goto L_0x0050;
    L_0x0038:
        r0 = new java.lang.StringBuilder;
        r1 = "L";
        r0.<init>(r1);
        r3 = (kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Object) r3;
        r3 = r3.f32822a;
        r0.append(r3);
        r3 = ";";
        r0.append(r3);
        r3 = r0.toString();
        return r3;
    L_0x0050:
        r3 = new kotlin.NoWhenBranchMatchedException;
        r3.<init>();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmTypeFactoryImpl.a(kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType):java.lang.String");
    }

    public final /* synthetic */ Object mo5832a() {
        return m33210d("java/lang/Class");
    }
}
