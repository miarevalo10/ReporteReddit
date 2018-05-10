package com.google.common.math;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.math.RoundingMode;
import org.jcodec.codecs.mjpeg.JpegConst;

public final class IntMath {
    static final byte[] f8519a = new byte[]{(byte) 9, (byte) 9, (byte) 9, (byte) 8, (byte) 8, (byte) 8, (byte) 7, (byte) 7, (byte) 7, (byte) 6, (byte) 6, (byte) 6, (byte) 6, (byte) 5, (byte) 5, (byte) 5, (byte) 4, (byte) 4, (byte) 4, (byte) 3, (byte) 3, (byte) 3, (byte) 3, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 1, (byte) 1, (byte) 0, (byte) 0, (byte) 0, (byte) 0};
    static final int[] f8520b = new int[]{1, 10, 100, 1000, AbstractSpiCall.DEFAULT_TIMEOUT, 100000, 1000000, 10000000, 100000000, 1000000000};
    static final int[] f8521c = new int[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, RedditJobManager.f10810d};
    static int[] f8522d = new int[]{RedditJobManager.f10810d, RedditJobManager.f10810d, 65536, 2345, 477, JpegConst.SOF1, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};
    private static final int[] f8523e = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    static /* synthetic */ class C04491 {
        static final /* synthetic */ int[] f8518a = new int[RoundingMode.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = java.math.RoundingMode.values();
            r0 = r0.length;
            r0 = new int[r0];
            f8518a = r0;
            r0 = f8518a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = java.math.RoundingMode.UNNECESSARY;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f8518a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = java.math.RoundingMode.DOWN;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f8518a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = java.math.RoundingMode.FLOOR;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f8518a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = java.math.RoundingMode.UP;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = f8518a;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = java.math.RoundingMode.CEILING;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = f8518a;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = java.math.RoundingMode.HALF_DOWN;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            r0 = f8518a;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = java.math.RoundingMode.HALF_UP;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 7;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            r0 = f8518a;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r1 = java.math.RoundingMode.HALF_EVEN;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0062 }
            r2 = 8;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0062 }
        L_0x0062:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.1.<clinit>():void");
        }
    }

    public static int m7280a(int r1, java.math.RoundingMode r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.google.common.math.IntMath.a(int, java.math.RoundingMode):int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: jadx.core.utils.exceptions.DecodeException: Unknown instruction: not-int
	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:568)
	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:56)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:102)
	... 5 more
*/
        /*
        // Can't load method instructions.
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.a(int, java.math.RoundingMode):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m7279a(int r5, int r6, java.math.RoundingMode r7) {
        /*
        com.google.common.base.Preconditions.m6908a(r7);
        if (r6 != 0) goto L_0x000d;
    L_0x0005:
        r5 = new java.lang.ArithmeticException;
        r6 = "/ by zero";
        r5.<init>(r6);
        throw r5;
    L_0x000d:
        r0 = r5 / r6;
        r1 = r6 * r0;
        r1 = r5 - r1;
        if (r1 != 0) goto L_0x0016;
    L_0x0015:
        return r0;
    L_0x0016:
        r5 = r5 ^ r6;
        r5 = r5 >> 31;
        r2 = 1;
        r5 = r5 | r2;
        r3 = com.google.common.math.IntMath.C04491.f8518a;
        r4 = r7.ordinal();
        r3 = r3[r4];
        r4 = 0;
        switch(r3) {
            case 1: goto L_0x0058;
            case 2: goto L_0x005f;
            case 3: goto L_0x0055;
            case 4: goto L_0x0060;
            case 5: goto L_0x0052;
            case 6: goto L_0x002d;
            case 7: goto L_0x002d;
            case 8: goto L_0x002d;
            default: goto L_0x0027;
        };
    L_0x0027:
        r5 = new java.lang.AssertionError;
        r5.<init>();
        throw r5;
    L_0x002d:
        r1 = java.lang.Math.abs(r1);
        r6 = java.lang.Math.abs(r6);
        r6 = r6 - r1;
        r1 = r1 - r6;
        if (r1 != 0) goto L_0x004f;
    L_0x0039:
        r6 = java.math.RoundingMode.HALF_UP;
        if (r7 == r6) goto L_0x0060;
    L_0x003d:
        r6 = java.math.RoundingMode.HALF_EVEN;
        if (r7 != r6) goto L_0x0043;
    L_0x0041:
        r6 = r2;
        goto L_0x0044;
    L_0x0043:
        r6 = r4;
    L_0x0044:
        r7 = r0 & 1;
        if (r7 == 0) goto L_0x004a;
    L_0x0048:
        r7 = r2;
        goto L_0x004b;
    L_0x004a:
        r7 = r4;
    L_0x004b:
        r6 = r6 & r7;
        if (r6 == 0) goto L_0x005f;
    L_0x004e:
        goto L_0x0060;
    L_0x004f:
        if (r1 <= 0) goto L_0x005f;
    L_0x0051:
        goto L_0x0060;
    L_0x0052:
        if (r5 <= 0) goto L_0x005f;
    L_0x0054:
        goto L_0x0060;
    L_0x0055:
        if (r5 >= 0) goto L_0x005f;
    L_0x0057:
        goto L_0x0060;
    L_0x0058:
        if (r1 != 0) goto L_0x005b;
    L_0x005a:
        goto L_0x005c;
    L_0x005b:
        r2 = r4;
    L_0x005c:
        com.google.common.math.MathPreconditions.m7282a(r2);
    L_0x005f:
        r2 = r4;
    L_0x0060:
        if (r2 == 0) goto L_0x0063;
    L_0x0062:
        r0 = r0 + r5;
    L_0x0063:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.a(int, int, java.math.RoundingMode):int");
    }
}
