package com.bumptech.glide.util;

import android.graphics.Bitmap.Config;
import android.os.Looper;
import com.bumptech.glide.load.model.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class Util {
    private static final char[] f3674a = "0123456789abcdef".toCharArray();
    private static final char[] f3675b = new char[64];

    static /* synthetic */ class C02801 {
        static final /* synthetic */ int[] f3673a = new int[Config.values().length];

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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = android.graphics.Bitmap.Config.values();
            r0 = r0.length;
            r0 = new int[r0];
            f3673a = r0;
            r0 = f3673a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.graphics.Bitmap.Config.ALPHA_8;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f3673a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.graphics.Bitmap.Config.RGB_565;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f3673a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.graphics.Bitmap.Config.ARGB_4444;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f3673a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.Util.1.<clinit>():void");
        }
    }

    public static int m3226a(boolean z, int i) {
        return (i * 31) + z;
    }

    public static int m3233b(int i) {
        return 527 + i;
    }

    public static int m3234b(int i, int i2) {
        return (i2 * 31) + i;
    }

    private static boolean m3238c(int i) {
        if (i <= 0) {
            if (i != Integer.MIN_VALUE) {
                return false;
            }
        }
        return true;
    }

    public static String m3227a(byte[] bArr) {
        synchronized (f3675b) {
            char[] cArr = f3675b;
            for (int i = 0; i < bArr.length; i++) {
                int i2 = bArr[i] & 255;
                int i3 = i * 2;
                cArr[i3] = f3674a[i2 >>> 4];
                cArr[i3 + 1] = f3674a[i2 & 15];
            }
            bArr = new String(cArr);
        }
        return bArr;
    }

    @android.annotation.TargetApi(19)
    public static int m3224a(android.graphics.Bitmap r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = r3.isRecycled();
        if (r0 == 0) goto L_0x003e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Cannot obtain size for recycled Bitmap: ";
        r1.<init>(r2);
        r1.append(r3);
        r2 = "[";
        r1.append(r2);
        r2 = r3.getWidth();
        r1.append(r2);
        r2 = "x";
        r1.append(r2);
        r2 = r3.getHeight();
        r1.append(r2);
        r2 = "] ";
        r1.append(r2);
        r3 = r3.getConfig();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
    L_0x003e:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 19;
        if (r0 < r1) goto L_0x0049;
    L_0x0044:
        r0 = r3.getAllocationByteCount();	 Catch:{ NullPointerException -> 0x0049 }
        return r0;
    L_0x0049:
        r0 = r3.getHeight();
        r3 = r3.getRowBytes();
        r0 = r0 * r3;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.Util.a(android.graphics.Bitmap):int");
    }

    public static boolean m3231a(int i, int i2) {
        return (m3238c(i) == 0 || m3238c(i2) == 0) ? false : true;
    }

    public static void m3230a() {
        if (!m3237c()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static void m3235b() {
        if (!m3239d()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static boolean m3237c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean m3239d() {
        return !m3237c();
    }

    public static <T> Queue<T> m3229a(int i) {
        return new ArrayDeque(i);
    }

    public static <T> List<T> m3228a(Collection<T> collection) {
        List<T> arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static boolean m3232a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null ? true : null;
        } else {
            return obj.equals(obj2);
        }
    }

    public static boolean m3236b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null ? true : null;
        } else {
            if (obj instanceof Model) {
                return ((Model) obj).m2997a();
            }
            return obj.equals(obj2);
        }
    }

    public static int m3225a(Object obj, int i) {
        return (i * 31) + (obj == null ? null : obj.hashCode());
    }

    public static int m3223a(int i, int i2, Config config) {
        i *= i2;
        if (config == null) {
            config = Config.ARGB_8888;
        }
        switch (C02801.f3673a[config.ordinal()]) {
            case 1:
                i2 = 1;
                break;
            case 2:
            case 3:
                i2 = 2;
                break;
            default:
                i2 = 4;
                break;
        }
        return i * i2;
    }

    public static int m3222a(float f) {
        return 527 + Float.floatToIntBits(f);
    }
}
