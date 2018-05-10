package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class zzai implements zzm {
    private static boolean f14106a = zzae.f6235a;
    @Deprecated
    private zzaq f14107b;
    private final zzah f14108c;
    private zzaj f14109d;

    public zzai(zzah com_google_android_gms_internal_zzah) {
        this(com_google_android_gms_internal_zzah, new zzaj());
    }

    private zzai(zzah com_google_android_gms_internal_zzah, zzaj com_google_android_gms_internal_zzaj) {
        this.f14108c = com_google_android_gms_internal_zzah;
        this.f14107b = com_google_android_gms_internal_zzah;
        this.f14109d = com_google_android_gms_internal_zzaj;
    }

    @Deprecated
    public zzai(zzaq com_google_android_gms_internal_zzaq) {
        this(com_google_android_gms_internal_zzaq, new zzaj());
    }

    @Deprecated
    private zzai(zzaq com_google_android_gms_internal_zzaq, zzaj com_google_android_gms_internal_zzaj) {
        this.f14107b = com_google_android_gms_internal_zzaq;
        this.f14108c = new zzag(com_google_android_gms_internal_zzaq);
        this.f14109d = com_google_android_gms_internal_zzaj;
    }

    private final byte[] m13289a(java.io.InputStream r6, int r7) throws java.io.IOException, com.google.android.gms.internal.zzab {
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
        r5 = this;
        r0 = new com.google.android.gms.internal.zzat;
        r1 = r5.f14109d;
        r0.<init>(r1, r7);
        r7 = 0;
        r1 = 0;
        if (r6 != 0) goto L_0x0013;
    L_0x000b:
        r2 = new com.google.android.gms.internal.zzab;	 Catch:{ all -> 0x0011 }
        r2.<init>();	 Catch:{ all -> 0x0011 }
        throw r2;	 Catch:{ all -> 0x0011 }
    L_0x0011:
        r2 = move-exception;	 Catch:{ all -> 0x0011 }
        goto L_0x0044;	 Catch:{ all -> 0x0011 }
    L_0x0013:
        r2 = r5.f14109d;	 Catch:{ all -> 0x0011 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ all -> 0x0011 }
        r2 = r2.m5297a(r3);	 Catch:{ all -> 0x0011 }
    L_0x001b:
        r1 = r6.read(r2);	 Catch:{ all -> 0x0040 }
        r3 = -1;	 Catch:{ all -> 0x0040 }
        if (r1 == r3) goto L_0x0026;	 Catch:{ all -> 0x0040 }
    L_0x0022:
        r0.write(r2, r7, r1);	 Catch:{ all -> 0x0040 }
        goto L_0x001b;	 Catch:{ all -> 0x0040 }
    L_0x0026:
        r1 = r0.toByteArray();	 Catch:{ all -> 0x0040 }
        if (r6 == 0) goto L_0x0037;
    L_0x002c:
        r6.close();	 Catch:{ IOException -> 0x0030 }
        goto L_0x0037;
    L_0x0030:
        r6 = "Error occurred when closing InputStream";
        r7 = new java.lang.Object[r7];
        com.google.android.gms.internal.zzae.m5041a(r6, r7);
    L_0x0037:
        r6 = r5.f14109d;
        r6.m5296a(r2);
        r0.close();
        return r1;
    L_0x0040:
        r1 = move-exception;
        r4 = r2;
        r2 = r1;
        r1 = r4;
    L_0x0044:
        if (r6 == 0) goto L_0x0051;
    L_0x0046:
        r6.close();	 Catch:{ IOException -> 0x004a }
        goto L_0x0051;
    L_0x004a:
        r6 = "Error occurred when closing InputStream";
        r7 = new java.lang.Object[r7];
        com.google.android.gms.internal.zzae.m5041a(r6, r7);
    L_0x0051:
        r6 = r5.f14109d;
        r6.m5296a(r1);
        r0.close();
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzai.a(java.io.InputStream, int):byte[]");
    }

    public com.google.android.gms.internal.zzp mo1723a(com.google.android.gms.internal.zzr<?> r27) throws com.google.android.gms.internal.zzad {
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
        r26 = this;
        r1 = r26;
        r2 = r27;
        r3 = android.os.SystemClock.elapsedRealtime();
    L_0x0008:
        r5 = java.util.Collections.emptyList();
        r6 = 2;
        r7 = 1;
        r8 = 0;
        r9 = 0;
        r10 = r2.f7975j;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        if (r10 != 0) goto L_0x0019;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
    L_0x0014:
        r10 = java.util.Collections.emptyMap();	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        goto L_0x003d;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
    L_0x0019:
        r11 = new java.util.HashMap;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        r11.<init>();	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        r12 = r10.f6722b;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        if (r12 == 0) goto L_0x0029;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
    L_0x0022:
        r12 = "If-None-Match";	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        r13 = r10.f6722b;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        r11.put(r12, r13);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
    L_0x0029:
        r12 = r10.f6724d;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        r14 = 0;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        if (r12 <= 0) goto L_0x003c;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
    L_0x0031:
        r12 = "If-Modified-Since";	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        r13 = r10.f6724d;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        r10 = com.google.android.gms.internal.zzao.m5467a(r13);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        r11.put(r12, r10);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
    L_0x003c:
        r10 = r11;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
    L_0x003d:
        r11 = r1.f14108c;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        r10 = r11.mo3435a(r2, r10);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0113 }
        r12 = r10.f6679a;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x010e }
        r11 = r10.f6680b;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x010e }
        r11 = java.util.Collections.unmodifiableList(r11);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x010e }
        r5 = 304; // 0x130 float:4.26E-43 double:1.5E-321;
        if (r12 != r5) goto L_0x0088;
    L_0x004f:
        r5 = r2.f7975j;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        if (r5 != 0) goto L_0x0067;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
    L_0x0053:
        r5 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r14 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r15 = 0;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r16 = 1;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r12 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r17 = r12 - r3;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r13 = r5;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r19 = r11;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r13.<init>(r14, r15, r16, r17, r19);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        return r5;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
    L_0x0067:
        r25 = m13287a(r11, r5);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r12 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r20 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r5 = r5.f6721a;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r22 = 1;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r13 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r23 = r13 - r3;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r19 = r12;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r21 = r5;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r19.<init>(r20, r21, r22, r23, r25);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        return r12;
    L_0x0081:
        r0 = move-exception;
        r5 = r0;
        r13 = r8;
        r17 = r11;
        goto L_0x0119;
    L_0x0088:
        r5 = r10.f6682d;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0106 }
        if (r5 == 0) goto L_0x0093;
    L_0x008c:
        r13 = r10.f6681c;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        r5 = r1.m13289a(r5, r13);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0081 }
        goto L_0x0095;
    L_0x0093:
        r5 = new byte[r9];	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x0106 }
    L_0x0095:
        r13 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r13 = r13 - r3;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r8 = f14106a;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        if (r8 != 0) goto L_0x00a4;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
    L_0x009e:
        r15 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r8 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1));	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        if (r8 <= 0) goto L_0x00da;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
    L_0x00a4:
        r8 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]";	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r15 = 5;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r15 = new java.lang.Object[r15];	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r15[r9] = r2;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r13 = java.lang.Long.valueOf(r13);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r15[r7] = r13;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        if (r5 == 0) goto L_0x00bf;
    L_0x00b3:
        r13 = r5.length;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00b9 }
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00b9 }
        goto L_0x00c1;
    L_0x00b9:
        r0 = move-exception;
        r13 = r5;
        r17 = r11;
        goto L_0x0118;
    L_0x00bf:
        r13 = "null";	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
    L_0x00c1:
        r15[r6] = r13;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r13 = 3;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r14 = java.lang.Integer.valueOf(r12);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r15[r13] = r14;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r13 = 4;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r14 = r2.f7974i;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r14 = r14.mo1952b();	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r14 = java.lang.Integer.valueOf(r14);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r15[r13] = r14;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        com.google.android.gms.internal.zzae.m5043b(r8, r15);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
    L_0x00da:
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        if (r12 < r8) goto L_0x00f5;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
    L_0x00de:
        r8 = 299; // 0x12b float:4.19E-43 double:1.477E-321;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        if (r12 <= r8) goto L_0x00e3;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
    L_0x00e2:
        goto L_0x00f5;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
    L_0x00e3:
        r8 = new com.google.android.gms.internal.zzp;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r14 = 0;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r15 = android.os.SystemClock.elapsedRealtime();	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00ff }
        r15 = r15 - r3;
        r18 = r11;
        r11 = r8;
        r13 = r5;
        r17 = r18;
        r11.<init>(r12, r13, r14, r15, r17);	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00fd }
        return r8;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00fd }
    L_0x00f5:
        r18 = r11;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00fd }
        r8 = new java.io.IOException;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00fd }
        r8.<init>();	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00fd }
        throw r8;	 Catch:{ SocketTimeoutException -> 0x01a7, MalformedURLException -> 0x0187, IOException -> 0x00fd }
    L_0x00fd:
        r0 = move-exception;
        goto L_0x0102;
    L_0x00ff:
        r0 = move-exception;
        r18 = r11;
    L_0x0102:
        r13 = r5;
        r17 = r18;
        goto L_0x0118;
    L_0x0106:
        r0 = move-exception;
        r18 = r11;
        r5 = r0;
        r13 = r8;
        r17 = r18;
        goto L_0x0119;
    L_0x010e:
        r0 = move-exception;
        r17 = r5;
        r13 = r8;
        goto L_0x0118;
    L_0x0113:
        r0 = move-exception;
        r17 = r5;
        r10 = r8;
        r13 = r10;
    L_0x0118:
        r5 = r0;
    L_0x0119:
        if (r10 == 0) goto L_0x0181;
    L_0x011b:
        r5 = r10.f6679a;
        r8 = "Unexpected response code %d for %s";
        r6 = new java.lang.Object[r6];
        r10 = java.lang.Integer.valueOf(r5);
        r6[r9] = r10;
        r9 = r2.f7967b;
        r6[r7] = r9;
        com.google.android.gms.internal.zzae.m5044c(r8, r6);
        if (r13 == 0) goto L_0x0175;
    L_0x0130:
        r6 = new com.google.android.gms.internal.zzp;
        r14 = 0;
        r7 = android.os.SystemClock.elapsedRealtime();
        r15 = r7 - r3;
        r11 = r6;
        r12 = r5;
        r11.<init>(r12, r13, r14, r15, r17);
        r7 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r5 == r7) goto L_0x0169;
    L_0x0142:
        r7 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r5 != r7) goto L_0x0147;
    L_0x0146:
        goto L_0x0169;
    L_0x0147:
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r5 < r2) goto L_0x0155;
    L_0x014b:
        r2 = 499; // 0x1f3 float:6.99E-43 double:2.465E-321;
        if (r5 > r2) goto L_0x0155;
    L_0x014f:
        r2 = new com.google.android.gms.internal.zzg;
        r2.<init>(r6);
        throw r2;
    L_0x0155:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r5 < r2) goto L_0x0163;
    L_0x0159:
        r2 = 599; // 0x257 float:8.4E-43 double:2.96E-321;
        if (r5 > r2) goto L_0x0163;
    L_0x015d:
        r2 = new com.google.android.gms.internal.zzab;
        r2.<init>(r6);
        throw r2;
    L_0x0163:
        r2 = new com.google.android.gms.internal.zzab;
        r2.<init>(r6);
        throw r2;
    L_0x0169:
        r5 = "auth";
        r7 = new com.google.android.gms.internal.zza;
        r7.<init>(r6);
        m13288a(r5, r2, r7);
        goto L_0x0008;
    L_0x0175:
        r5 = "network";
        r6 = new com.google.android.gms.internal.zzo;
        r6.<init>();
        m13288a(r5, r2, r6);
        goto L_0x0008;
    L_0x0181:
        r2 = new com.google.android.gms.internal.zzq;
        r2.<init>(r5);
        throw r2;
    L_0x0187:
        r0 = move-exception;
        r3 = r0;
        r4 = new java.lang.RuntimeException;
        r5 = "Bad URL ";
        r2 = r2.f7967b;
        r2 = java.lang.String.valueOf(r2);
        r6 = r2.length();
        if (r6 == 0) goto L_0x019e;
    L_0x0199:
        r2 = r5.concat(r2);
        goto L_0x01a3;
    L_0x019e:
        r2 = new java.lang.String;
        r2.<init>(r5);
    L_0x01a3:
        r4.<init>(r2, r3);
        throw r4;
    L_0x01a7:
        r5 = "socket";
        r6 = new com.google.android.gms.internal.zzac;
        r6.<init>();
        m13288a(r5, r2, r6);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzai.a(com.google.android.gms.internal.zzr):com.google.android.gms.internal.zzp");
    }

    private static void m13288a(String str, zzr<?> com_google_android_gms_internal_zzr_, zzad com_google_android_gms_internal_zzad) throws zzad {
        zzaa com_google_android_gms_internal_zzaa = com_google_android_gms_internal_zzr_.f7974i;
        int c = com_google_android_gms_internal_zzr_.m6629c();
        try {
            com_google_android_gms_internal_zzaa.mo1951a(com_google_android_gms_internal_zzad);
            com_google_android_gms_internal_zzr_.m6628b(String.format("%s-retry [timeout=%s]", new Object[]{str, Integer.valueOf(c)}));
        } catch (zzad com_google_android_gms_internal_zzad2) {
            com_google_android_gms_internal_zzr_.m6628b(String.format("%s-timeout-giveup [timeout=%s]", new Object[]{str, Integer.valueOf(c)}));
            throw com_google_android_gms_internal_zzad2;
        }
    }

    private static List<zzl> m13287a(List<zzl> list, zzc com_google_android_gms_internal_zzc) {
        Set treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (zzl com_google_android_gms_internal_zzl : list) {
                treeSet.add(com_google_android_gms_internal_zzl.f7777a);
            }
        }
        List<zzl> arrayList = new ArrayList(list);
        if (com_google_android_gms_internal_zzc.f6728h != null) {
            if (com_google_android_gms_internal_zzc.f6728h.isEmpty() == null) {
                for (zzl com_google_android_gms_internal_zzl2 : com_google_android_gms_internal_zzc.f6728h) {
                    if (!treeSet.contains(com_google_android_gms_internal_zzl2.f7777a)) {
                        arrayList.add(com_google_android_gms_internal_zzl2);
                    }
                }
            }
        } else if (com_google_android_gms_internal_zzc.f6727g.isEmpty() == null) {
            list = com_google_android_gms_internal_zzc.f6727g.entrySet().iterator();
            while (list.hasNext() != null) {
                Entry entry = (Entry) list.next();
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new zzl((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return arrayList;
    }
}
