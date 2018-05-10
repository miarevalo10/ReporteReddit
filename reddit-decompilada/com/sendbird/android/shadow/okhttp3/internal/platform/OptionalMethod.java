package com.sendbird.android.shadow.okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class OptionalMethod<T> {
    private final Class<?> f23545a;
    private final String f23546b;
    private final Class[] f23547c;

    OptionalMethod(Class<?> cls, String str, Class... clsArr) {
        this.f23545a = cls;
        this.f23546b = str;
        this.f23547c = clsArr;
    }

    public final boolean m25546a(T t) {
        return m25541a(t.getClass()) != null ? true : null;
    }

    private java.lang.Object m25543c(T r3, java.lang.Object... r4) throws java.lang.reflect.InvocationTargetException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = r3.getClass();
        r0 = r2.m25541a(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r3 = r0.invoke(r3, r4);	 Catch:{ IllegalAccessException -> 0x0011 }
        return r3;
    L_0x0011:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.OptionalMethod.c(java.lang.Object, java.lang.Object[]):java.lang.Object");
    }

    public final Object m25545a(T t, Object... objArr) {
        try {
            return m25543c(t, objArr);
        } catch (T t2) {
            t2 = t2.getTargetException();
            if ((t2 instanceof RuntimeException) != null) {
                throw ((RuntimeException) t2);
            }
            objArr = new AssertionError("Unexpected exception");
            objArr.initCause(t2);
            throw objArr;
        }
    }

    private Object m25544d(T t, Object... objArr) throws InvocationTargetException {
        Method a = m25541a(t.getClass());
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder("Method ");
            stringBuilder.append(this.f23546b);
            stringBuilder.append(" not supported for object ");
            stringBuilder.append(t);
            throw new AssertionError(stringBuilder.toString());
        }
        try {
            return a.invoke(t, objArr);
        } catch (T t2) {
            StringBuilder stringBuilder2 = new StringBuilder("Unexpectedly could not call: ");
            stringBuilder2.append(a);
            objArr = new AssertionError(stringBuilder2.toString());
            objArr.initCause(t2);
            throw objArr;
        }
    }

    public final Object m25547b(T t, Object... objArr) {
        try {
            return m25544d(t, objArr);
        } catch (T t2) {
            t2 = t2.getTargetException();
            if ((t2 instanceof RuntimeException) != null) {
                throw ((RuntimeException) t2);
            }
            objArr = new AssertionError("Unexpected exception");
            objArr.initCause(t2);
            throw objArr;
        }
    }

    private Method m25541a(Class<?> cls) {
        if (this.f23546b == null) {
            return null;
        }
        cls = m25542a(cls, this.f23546b, this.f23547c);
        if (cls == null || this.f23545a == null || this.f23545a.isAssignableFrom(cls.getReturnType())) {
            return cls;
        }
        return null;
    }

    private static java.lang.reflect.Method m25542a(java.lang.Class<?> r1, java.lang.String r2, java.lang.Class[] r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        r1 = r1.getMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x000d }
        r2 = r1.getModifiers();	 Catch:{ NoSuchMethodException -> 0x000e }
        r2 = r2 & 1;
        if (r2 != 0) goto L_0x000e;
    L_0x000d:
        r1 = r0;
    L_0x000e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.platform.OptionalMethod.a(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }
}
