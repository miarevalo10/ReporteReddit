package rx.internal.util.unsafe;

import sun.misc.Unsafe;

public final class UnsafeAccess {
    public static final Unsafe f41383a;
    private static final boolean f41384b;

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "rx.unsafe-disable";
        r0 = java.lang.System.getProperty(r0);
        r1 = 1;
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        r0 = r1;
        goto L_0x000c;
    L_0x000b:
        r0 = 0;
    L_0x000c:
        f41384b = r0;
        r0 = 0;
        r2 = sun.misc.Unsafe.class;	 Catch:{ Throwable -> 0x0021 }
        r3 = "theUnsafe";	 Catch:{ Throwable -> 0x0021 }
        r2 = r2.getDeclaredField(r3);	 Catch:{ Throwable -> 0x0021 }
        r2.setAccessible(r1);	 Catch:{ Throwable -> 0x0021 }
        r1 = r2.get(r0);	 Catch:{ Throwable -> 0x0021 }
        r1 = (sun.misc.Unsafe) r1;	 Catch:{ Throwable -> 0x0021 }
        r0 = r1;
    L_0x0021:
        f41383a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.unsafe.UnsafeAccess.<clinit>():void");
    }

    public static boolean m43484a() {
        return (f41383a == null || f41384b) ? false : true;
    }

    public static long m43483a(Class<?> cls, String str) {
        try {
            return f41383a.objectFieldOffset(cls.getDeclaredField(str));
        } catch (Class<?> cls2) {
            str = new InternalError();
            str.initCause(cls2);
            throw str;
        }
    }
}
