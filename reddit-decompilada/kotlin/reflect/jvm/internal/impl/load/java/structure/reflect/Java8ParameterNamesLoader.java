package kotlin.reflect.jvm.internal.impl.load.java.structure.reflect;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReflectJavaMember.kt */
final class Java8ParameterNamesLoader {
    public static final Java8ParameterNamesLoader f25731a = null;
    private static Cache f25732b;

    /* compiled from: ReflectJavaMember.kt */
    public static final class Cache {
        private final Method getName;
        private final Method getParameters;

        public Cache(Method method, Method method2) {
            this.getParameters = method;
            this.getName = method2;
        }

        public final Method getGetName() {
            return this.getName;
        }

        public final Method getGetParameters() {
            return this.getParameters;
        }
    }

    static {
        Java8ParameterNamesLoader java8ParameterNamesLoader = new Java8ParameterNamesLoader();
    }

    private Java8ParameterNamesLoader() {
        f25731a = this;
    }

    private static kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.Java8ParameterNamesLoader.Cache m27238b(java.lang.reflect.Member r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "member";
        kotlin.jvm.internal.Intrinsics.m26847b(r4, r0);
        r4 = r4.getClass();
        r0 = "getParameters";	 Catch:{ NoSuchMethodException -> 0x002a }
        r1 = 0;	 Catch:{ NoSuchMethodException -> 0x002a }
        r2 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x002a }
        r0 = r4.getMethod(r0, r2);	 Catch:{ NoSuchMethodException -> 0x002a }
        r4 = kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.ReflectClassUtilKt.m27239a(r4);
        r2 = "java.lang.reflect.Parameter";
        r4 = r4.loadClass(r2);
        r2 = new kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.Java8ParameterNamesLoader$Cache;
        r3 = "getName";
        r1 = new java.lang.Class[r1];
        r4 = r4.getMethod(r3, r1);
        r2.<init>(r0, r4);
        return r2;
    L_0x002a:
        r4 = new kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.Java8ParameterNamesLoader$Cache;
        r0 = 0;
        r4.<init>(r0, r0);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.Java8ParameterNamesLoader.b(java.lang.reflect.Member):kotlin.reflect.jvm.internal.impl.load.java.structure.reflect.Java8ParameterNamesLoader$Cache");
    }

    public static List<String> m27237a(Member member) {
        Intrinsics.m26847b(member, "member");
        Cache cache = f25732b;
        if (cache == null) {
            cache = m27238b(member);
            f25732b = cache;
        }
        Method getParameters = cache.getGetParameters();
        if (getParameters == null) {
            return null;
        }
        Method getName = cache.getGetName();
        if (getName == null) {
            return null;
        }
        member = getParameters.invoke(member, new Object[0]);
        if (member == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<*>");
        }
        Object[] objArr = (Object[]) member;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object invoke : objArr) {
            Object invoke2 = getName.invoke(invoke2, new Object[0]);
            if (invoke2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            arrayList.add((String) invoke2);
        }
        return (List) arrayList;
    }
}
