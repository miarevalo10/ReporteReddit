package com.google.common.cache;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import sun.misc.Unsafe;

abstract class Striped64 extends Number {
    static final ThreadLocal<int[]> f8363a = new ThreadLocal();
    static final Random f8364b = new Random();
    static final int f8365c = Runtime.getRuntime().availableProcessors();
    private static final Unsafe f8366g;
    private static final long f8367h;
    private static final long f8368i;
    volatile transient Cell[] f8369d;
    volatile transient long f8370e;
    volatile transient int f8371f;

    static class C04421 implements PrivilegedExceptionAction<Unsafe> {
        C04421() {
        }

        public final /* synthetic */ Object run() throws Exception {
            Class cls = Unsafe.class;
            for (Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                Object obj = field.get(null);
                if (cls.isInstance(obj)) {
                    return (Unsafe) cls.cast(obj);
                }
            }
            throw new NoSuchFieldError("the Unsafe");
        }
    }

    static final class Cell {
        private static final Unsafe f8360b;
        private static final long f8361c;
        volatile long f8362a;

        Cell(long j) {
            this.f8362a = j;
        }

        final boolean m7070a(long j, long j2) {
            return f8360b.compareAndSwapLong(this, f8361c, j, j2);
        }

        static {
            try {
                f8360b = Striped64.mo2379a();
                f8361c = f8360b.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Throwable e) {
                throw new Error(e);
            }
        }
    }

    abstract long mo2382a(long j, long j2);

    static {
        try {
            f8366g = mo2379a();
            Class cls = Striped64.class;
            f8367h = f8366g.objectFieldOffset(cls.getDeclaredField("base"));
            f8368i = f8366g.objectFieldOffset(cls.getDeclaredField("busy"));
        } catch (Throwable e) {
            throw new Error(e);
        }
    }

    Striped64() {
    }

    final boolean m7074b(long j, long j2) {
        return f8366g.compareAndSwapLong(this, f8367h, j, j2);
    }

    final boolean m7075c() {
        return f8366g.compareAndSwapInt(this, f8368i, 0, 1);
    }

    private static sun.misc.Unsafe mo2379a() {
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
        r0 = sun.misc.Unsafe.getUnsafe();	 Catch:{ SecurityException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = new com.google.common.cache.Striped64$1;	 Catch:{ PrivilegedActionException -> 0x0011 }
        r0.<init>();	 Catch:{ PrivilegedActionException -> 0x0011 }
        r0 = java.security.AccessController.doPrivileged(r0);	 Catch:{ PrivilegedActionException -> 0x0011 }
        r0 = (sun.misc.Unsafe) r0;	 Catch:{ PrivilegedActionException -> 0x0011 }
        return r0;
    L_0x0011:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = "Could not initialize intrinsics";
        r0 = r0.getCause();
        r1.<init>(r2, r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.Striped64.a():sun.misc.Unsafe");
    }
}
