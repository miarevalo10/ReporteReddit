package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import org.jcodec.codecs.mjpeg.JpegConst;

final class zzbw {
    static CountDownLatch f6715a = new CountDownLatch(1);
    private static boolean f6716b = false;
    private static MessageDigest f6717c;
    private static final Object f6718d = new Object();
    private static final Object f6719e = new Object();

    static String m5581a(zzaz com_google_android_gms_internal_zzaz, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] a = zzfjs.m6205a((zzfjs) com_google_android_gms_internal_zzaz);
        if (((Boolean) zzkb.m6350f().m6488a(zznh.by)).booleanValue()) {
            a = m5585a(a, str);
        } else if (zzbz.f6720a == null) {
            throw new GeneralSecurityException();
        } else {
            a = zzbz.f6720a.mo1862a(a, str != null ? str.getBytes() : new byte[0]);
            zzfjs com_google_android_gms_internal_zzbf = new zzbf();
            com_google_android_gms_internal_zzbf.f17706a = new byte[][]{a};
            com_google_android_gms_internal_zzbf.f17708c = Integer.valueOf(2);
            a = zzfjs.m6205a(com_google_android_gms_internal_zzbf);
        }
        return zzbu.m5579a(a, true);
    }

    static void m5583a() {
        synchronized (f6719e) {
            if (!f6716b) {
                f6716b = true;
                new Thread(new zzby()).start();
            }
        }
    }

    public static byte[] m5584a(byte[] bArr) throws NoSuchAlgorithmException {
        synchronized (f6718d) {
            MessageDigest b = m5587b();
            if (b == null) {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
            b.reset();
            b.update(bArr);
            bArr = f6717c.digest();
        }
        return bArr;
    }

    private static byte[] m5585a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Vector b = m5588b(bArr);
        if (b != null) {
            if (b.size() != 0) {
                zzfjs com_google_android_gms_internal_zzbf = new zzbf();
                com_google_android_gms_internal_zzbf.f17706a = new byte[b.size()][];
                Iterator it = b.iterator();
                int i = 0;
                while (it.hasNext()) {
                    int i2 = i + 1;
                    com_google_android_gms_internal_zzbf.f17706a[i] = m5586a((byte[]) it.next(), str, false);
                    i = i2;
                }
                com_google_android_gms_internal_zzbf.f17707b = m5584a(bArr);
                return zzfjs.m6205a(com_google_android_gms_internal_zzbf);
            }
        }
        return m5586a(zzfjs.m6205a(m5589c()), str, true);
    }

    private static byte[] m5586a(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        ByteBuffer put;
        int i = z ? JpegConst.APPF : 255;
        if (bArr.length > i) {
            bArr = zzfjs.m6205a(m5589c());
        }
        if (bArr.length < i) {
            byte[] bArr2 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            put = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr2);
        } else {
            put = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr);
        }
        bArr = put.array();
        if (z) {
            bArr = ByteBuffer.allocate(256).put(m5584a(bArr)).put(bArr).array();
        }
        byte[] bArr3 = new byte[256];
        new zzca().m5592a(bArr, bArr3);
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzfdb(str.getBytes("UTF-8")).m5944a(bArr3);
        }
        return bArr3;
    }

    private static java.security.MessageDigest m5587b() {
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
        m5583a();
        r0 = f6715a;	 Catch:{ InterruptedException -> 0x000e }
        r1 = 2;	 Catch:{ InterruptedException -> 0x000e }
        r3 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ InterruptedException -> 0x000e }
        r0 = r0.await(r1, r3);	 Catch:{ InterruptedException -> 0x000e }
        goto L_0x000f;
    L_0x000e:
        r0 = 0;
    L_0x000f:
        r1 = 0;
        if (r0 != 0) goto L_0x0013;
    L_0x0012:
        return r1;
    L_0x0013:
        r0 = f6717c;
        if (r0 != 0) goto L_0x0018;
    L_0x0017:
        return r1;
    L_0x0018:
        r0 = f6717c;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbw.b():java.security.MessageDigest");
    }

    private static java.util.Vector<byte[]> m5588b(byte[] r7) {
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
        if (r7 == 0) goto L_0x002c;
    L_0x0003:
        r1 = r7.length;
        if (r1 > 0) goto L_0x0007;
    L_0x0006:
        return r0;
    L_0x0007:
        r1 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r2 = r7.length;
        r2 = r2 + r1;
        r2 = r2 + -1;
        r2 = r2 / r1;
        r3 = new java.util.Vector;
        r3.<init>();
        r4 = 0;
    L_0x0014:
        if (r4 >= r2) goto L_0x002b;
    L_0x0016:
        r5 = r4 * 255;
        r6 = r7.length;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
        r6 = r6 - r5;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
        if (r6 <= r1) goto L_0x001f;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
    L_0x001c:
        r6 = r5 + 255;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
        goto L_0x0020;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
    L_0x001f:
        r6 = r7.length;	 Catch:{ IndexOutOfBoundsException -> 0x002a }
    L_0x0020:
        r5 = java.util.Arrays.copyOfRange(r7, r5, r6);	 Catch:{ IndexOutOfBoundsException -> 0x002a }
        r3.add(r5);	 Catch:{ IndexOutOfBoundsException -> 0x002a }
        r4 = r4 + 1;
        goto L_0x0014;
    L_0x002a:
        return r0;
    L_0x002b:
        return r3;
    L_0x002c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbw.b(byte[]):java.util.Vector<byte[]>");
    }

    private static zzaz m5589c() {
        zzaz com_google_android_gms_internal_zzaz = new zzaz();
        com_google_android_gms_internal_zzaz.f17651k = Long.valueOf(4096);
        return com_google_android_gms_internal_zzaz;
    }
}
