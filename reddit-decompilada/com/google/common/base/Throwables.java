package com.google.common.base;

import java.lang.reflect.Method;

public final class Throwables {
    private static final Object f8246a;
    private static final Method f8247b;
    private static final Method f8248c;

    public static void m6938a(Throwable th) {
        Preconditions.m6908a((Object) th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    @Deprecated
    public static RuntimeException m6939b(Throwable th) {
        m6938a(th);
        throw new RuntimeException(th);
    }

    static {
        Method method;
        Object a = m6936a();
        f8246a = a;
        Method method2 = null;
        if (a == null) {
            method = null;
        } else {
            method = m6937a("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        f8247b = method;
        if (f8246a != null) {
            method2 = m6940b();
        }
        f8248c = method2;
    }

    private static java.lang.Object m6936a() {
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
        r1 = "sun.misc.SharedSecrets";	 Catch:{ ThreadDeath -> 0x0018, Throwable -> 0x0017 }
        r2 = 0;	 Catch:{ ThreadDeath -> 0x0018, Throwable -> 0x0017 }
        r1 = java.lang.Class.forName(r1, r2, r0);	 Catch:{ ThreadDeath -> 0x0018, Throwable -> 0x0017 }
        r3 = "getJavaLangAccess";	 Catch:{ ThreadDeath -> 0x0018, Throwable -> 0x0017 }
        r4 = new java.lang.Class[r2];	 Catch:{ ThreadDeath -> 0x0018, Throwable -> 0x0017 }
        r1 = r1.getMethod(r3, r4);	 Catch:{ ThreadDeath -> 0x0018, Throwable -> 0x0017 }
        r2 = new java.lang.Object[r2];	 Catch:{ ThreadDeath -> 0x0018, Throwable -> 0x0017 }
        r1 = r1.invoke(r0, r2);	 Catch:{ ThreadDeath -> 0x0018, Throwable -> 0x0017 }
        return r1;
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = move-exception;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Throwables.a():java.lang.Object");
    }

    private static java.lang.reflect.Method m6940b() {
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
        r1 = "getStackTraceDepth";	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r2 = 1;	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r3 = new java.lang.Class[r2];	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r4 = java.lang.Throwable.class;	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r5 = 0;	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r3[r5] = r4;	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r1 = m6937a(r1, r3);	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        if (r1 != 0) goto L_0x0012;	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
    L_0x0011:
        return r0;	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
    L_0x0012:
        r3 = m6936a();	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r2 = new java.lang.Object[r2];	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r4 = new java.lang.Throwable;	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r4.<init>();	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r2[r5] = r4;	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        r1.invoke(r3, r2);	 Catch:{ UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023, UnsupportedOperationException -> 0x0023 }
        return r1;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Throwables.b():java.lang.reflect.Method");
    }

    private static java.lang.reflect.Method m6937a(java.lang.String r3, java.lang.Class<?>... r4) throws java.lang.ThreadDeath {
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
        r1 = "sun.misc.JavaLangAccess";	 Catch:{ ThreadDeath -> 0x000e, Throwable -> 0x000d }
        r2 = 0;	 Catch:{ ThreadDeath -> 0x000e, Throwable -> 0x000d }
        r1 = java.lang.Class.forName(r1, r2, r0);	 Catch:{ ThreadDeath -> 0x000e, Throwable -> 0x000d }
        r3 = r1.getMethod(r3, r4);	 Catch:{ ThreadDeath -> 0x000e, Throwable -> 0x000d }
        return r3;
    L_0x000d:
        return r0;
    L_0x000e:
        r3 = move-exception;
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Throwables.a(java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }
}
