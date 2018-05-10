package rx.internal.util;

import java.security.PrivilegedAction;

public final class PlatformDependent {
    private static final int f41361a;
    private static final boolean f41362b;

    static class C30731 implements PrivilegedAction<ClassLoader> {
        C30731() {
        }

        public final /* synthetic */ Object run() {
            return ClassLoader.getSystemClassLoader();
        }
    }

    static {
        int c = m43472c();
        f41361a = c;
        f41362b = c != 0;
    }

    public static boolean m43470a() {
        return f41362b;
    }

    public static int m43471b() {
        return f41361a;
    }

    private static int m43472c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "android.os.Build$VERSION";	 Catch:{ Exception -> 0x002f }
        r1 = 1;	 Catch:{ Exception -> 0x002f }
        r2 = java.lang.System.getSecurityManager();	 Catch:{ Exception -> 0x002f }
        if (r2 != 0) goto L_0x000e;	 Catch:{ Exception -> 0x002f }
    L_0x0009:
        r2 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ Exception -> 0x002f }
        goto L_0x0019;	 Catch:{ Exception -> 0x002f }
    L_0x000e:
        r2 = new rx.internal.util.PlatformDependent$1;	 Catch:{ Exception -> 0x002f }
        r2.<init>();	 Catch:{ Exception -> 0x002f }
        r2 = java.security.AccessController.doPrivileged(r2);	 Catch:{ Exception -> 0x002f }
        r2 = (java.lang.ClassLoader) r2;	 Catch:{ Exception -> 0x002f }
    L_0x0019:
        r0 = java.lang.Class.forName(r0, r1, r2);	 Catch:{ Exception -> 0x002f }
        r1 = "SDK_INT";	 Catch:{ Exception -> 0x002f }
        r0 = r0.getField(r1);	 Catch:{ Exception -> 0x002f }
        r1 = 0;	 Catch:{ Exception -> 0x002f }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x002f }
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception -> 0x002f }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x002f }
        return r0;
    L_0x002f:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.PlatformDependent.c():int");
    }
}
