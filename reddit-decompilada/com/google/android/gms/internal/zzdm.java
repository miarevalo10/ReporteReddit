package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class zzdm {
    private static final String f7215m = "zzdm";
    protected Context f7216a;
    ExecutorService f7217b;
    DexClassLoader f7218c;
    zzcx f7219d;
    byte[] f7220e;
    volatile zzaz f7221f = null;
    Future f7222g = null;
    zzcp f7223h;
    boolean f7224i = false;
    boolean f7225j = false;
    boolean f7226k = false;
    boolean f7227l;
    private volatile AdvertisingIdClient f7228n = null;
    private volatile boolean f7229o = false;
    private Future f7230p = null;
    private boolean f7231q;
    private Map<Pair<String, String>, zzer> f7232r;
    private boolean f7233s;

    final class zza extends BroadcastReceiver {
        private /* synthetic */ zzdm f7214a;

        private zza(zzdm com_google_android_gms_internal_zzdm) {
            this.f7214a = com_google_android_gms_internal_zzdm;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                this.f7214a.f7227l = true;
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                this.f7214a.f7227l = false;
            }
        }
    }

    private zzdm(Context context) {
        boolean z = true;
        this.f7227l = true;
        this.f7233s = false;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            z = false;
        }
        this.f7231q = z;
        if (this.f7231q) {
            context = applicationContext;
        }
        this.f7216a = context;
        this.f7232r = new HashMap();
    }

    public static com.google.android.gms.internal.zzdm m5836a(android.content.Context r8, java.lang.String r9, java.lang.String r10, boolean r11) {
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
        r0 = new com.google.android.gms.internal.zzdm;
        r0.<init>(r8);
        r8 = java.util.concurrent.Executors.newCachedThreadPool();	 Catch:{ zzdj -> 0x0161 }
        r0.f7217b = r8;	 Catch:{ zzdj -> 0x0161 }
        r0.f7229o = r11;	 Catch:{ zzdj -> 0x0161 }
        if (r11 == 0) goto L_0x001c;	 Catch:{ zzdj -> 0x0161 }
    L_0x000f:
        r8 = r0.f7217b;	 Catch:{ zzdj -> 0x0161 }
        r11 = new com.google.android.gms.internal.zzdn;	 Catch:{ zzdj -> 0x0161 }
        r11.<init>(r0);	 Catch:{ zzdj -> 0x0161 }
        r8 = r8.submit(r11);	 Catch:{ zzdj -> 0x0161 }
        r0.f7230p = r8;	 Catch:{ zzdj -> 0x0161 }
    L_0x001c:
        r8 = r0.f7217b;	 Catch:{ zzdj -> 0x0161 }
        r11 = new com.google.android.gms.internal.zzdp;	 Catch:{ zzdj -> 0x0161 }
        r11.<init>(r0);	 Catch:{ zzdj -> 0x0161 }
        r8.execute(r11);	 Catch:{ zzdj -> 0x0161 }
        r8 = 1;
        r11 = 0;
        r1 = com.google.android.gms.common.zzf.m4930b();	 Catch:{ Throwable -> 0x0046 }
        r2 = r0.f7216a;	 Catch:{ Throwable -> 0x0046 }
        r2 = com.google.android.gms.common.zzf.m4934d(r2);	 Catch:{ Throwable -> 0x0046 }
        if (r2 <= 0) goto L_0x0036;	 Catch:{ Throwable -> 0x0046 }
    L_0x0034:
        r2 = r8;	 Catch:{ Throwable -> 0x0046 }
        goto L_0x0037;	 Catch:{ Throwable -> 0x0046 }
    L_0x0036:
        r2 = r11;	 Catch:{ Throwable -> 0x0046 }
    L_0x0037:
        r0.f7224i = r2;	 Catch:{ Throwable -> 0x0046 }
        r2 = r0.f7216a;	 Catch:{ Throwable -> 0x0046 }
        r1 = r1.mo1537a(r2);	 Catch:{ Throwable -> 0x0046 }
        if (r1 != 0) goto L_0x0043;	 Catch:{ Throwable -> 0x0046 }
    L_0x0041:
        r1 = r8;	 Catch:{ Throwable -> 0x0046 }
        goto L_0x0044;	 Catch:{ Throwable -> 0x0046 }
    L_0x0043:
        r1 = r11;	 Catch:{ Throwable -> 0x0046 }
    L_0x0044:
        r0.f7225j = r1;	 Catch:{ Throwable -> 0x0046 }
    L_0x0046:
        r0.m5847a(r11, r8);	 Catch:{ zzdj -> 0x0161 }
        r1 = com.google.android.gms.internal.zzdr.m5892b();	 Catch:{ zzdj -> 0x0161 }
        if (r1 == 0) goto L_0x0069;	 Catch:{ zzdj -> 0x0161 }
    L_0x004f:
        r1 = com.google.android.gms.internal.zznh.bz;	 Catch:{ zzdj -> 0x0161 }
        r2 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ zzdj -> 0x0161 }
        r1 = r2.m6488a(r1);	 Catch:{ zzdj -> 0x0161 }
        r1 = (java.lang.Boolean) r1;	 Catch:{ zzdj -> 0x0161 }
        r1 = r1.booleanValue();	 Catch:{ zzdj -> 0x0161 }
        if (r1 == 0) goto L_0x0069;	 Catch:{ zzdj -> 0x0161 }
    L_0x0061:
        r8 = new java.lang.IllegalStateException;	 Catch:{ zzdj -> 0x0161 }
        r9 = "Task Context initialization must not be called from the UI thread.";	 Catch:{ zzdj -> 0x0161 }
        r8.<init>(r9);	 Catch:{ zzdj -> 0x0161 }
        throw r8;	 Catch:{ zzdj -> 0x0161 }
    L_0x0069:
        r1 = new com.google.android.gms.internal.zzcx;	 Catch:{ zzdj -> 0x0161 }
        r1.<init>();	 Catch:{ zzdj -> 0x0161 }
        r0.f7219d = r1;	 Catch:{ zzdj -> 0x0161 }
        r9 = com.google.android.gms.internal.zzcx.m5824a(r9);	 Catch:{ zzcy -> 0x015a }
        r0.f7220e = r9;	 Catch:{ zzcy -> 0x015a }
        r9 = r0.f7216a;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r9 = r9.getCacheDir();	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        if (r9 != 0) goto L_0x008e;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
    L_0x007e:
        r9 = r0.f7216a;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r1 = "dex";	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r9 = r9.getDir(r1, r11);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        if (r9 != 0) goto L_0x008e;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
    L_0x0088:
        r8 = new com.google.android.gms.internal.zzdj;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r8.<init>();	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        throw r8;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
    L_0x008e:
        r1 = "1505450608132";	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r2 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r3 = "%s/%s.jar";	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r4 = 2;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r5 = new java.lang.Object[r4];	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r5[r11] = r9;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r5[r8] = r1;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r3 = java.lang.String.format(r3, r5);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r2.<init>(r3);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r3 = r2.exists();	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        if (r3 != 0) goto L_0x00bd;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
    L_0x00a8:
        r3 = r0.f7220e;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r10 = com.google.android.gms.internal.zzcx.m5825a(r3, r10);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r2.createNewFile();	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r3 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r3.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r5 = r10.length;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r3.write(r10, r11, r5);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r3.close();	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
    L_0x00bd:
        r0.m5843b(r9, r1);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r10 = new dalvik.system.DexClassLoader;	 Catch:{ all -> 0x0127 }
        r3 = r2.getAbsolutePath();	 Catch:{ all -> 0x0127 }
        r5 = r9.getAbsolutePath();	 Catch:{ all -> 0x0127 }
        r6 = 0;	 Catch:{ all -> 0x0127 }
        r7 = r0.f7216a;	 Catch:{ all -> 0x0127 }
        r7 = r7.getClassLoader();	 Catch:{ all -> 0x0127 }
        r10.<init>(r3, r5, r6, r7);	 Catch:{ all -> 0x0127 }
        r0.f7218c = r10;	 Catch:{ all -> 0x0127 }
        m5838a(r2);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r0.m5839a(r9, r1);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r10 = "%s/%s.dex";	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r2 = new java.lang.Object[r4];	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r2[r11] = r9;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r2[r8] = r1;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r9 = java.lang.String.format(r10, r2);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        m5840a(r9);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r9 = com.google.android.gms.internal.zznh.br;	 Catch:{ zzdj -> 0x0161 }
        r10 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ zzdj -> 0x0161 }
        r9 = r10.m6488a(r9);	 Catch:{ zzdj -> 0x0161 }
        r9 = (java.lang.Boolean) r9;	 Catch:{ zzdj -> 0x0161 }
        r9 = r9.booleanValue();	 Catch:{ zzdj -> 0x0161 }
        if (r9 == 0) goto L_0x011d;	 Catch:{ zzdj -> 0x0161 }
    L_0x00fd:
        r9 = r0.f7233s;	 Catch:{ zzdj -> 0x0161 }
        if (r9 == 0) goto L_0x0102;	 Catch:{ zzdj -> 0x0161 }
    L_0x0101:
        goto L_0x011d;	 Catch:{ zzdj -> 0x0161 }
    L_0x0102:
        r9 = new android.content.IntentFilter;	 Catch:{ zzdj -> 0x0161 }
        r9.<init>();	 Catch:{ zzdj -> 0x0161 }
        r10 = "android.intent.action.USER_PRESENT";	 Catch:{ zzdj -> 0x0161 }
        r9.addAction(r10);	 Catch:{ zzdj -> 0x0161 }
        r10 = "android.intent.action.SCREEN_OFF";	 Catch:{ zzdj -> 0x0161 }
        r9.addAction(r10);	 Catch:{ zzdj -> 0x0161 }
        r10 = r0.f7216a;	 Catch:{ zzdj -> 0x0161 }
        r1 = new com.google.android.gms.internal.zzdm$zza;	 Catch:{ zzdj -> 0x0161 }
        r1.<init>();	 Catch:{ zzdj -> 0x0161 }
        r10.registerReceiver(r1, r9);	 Catch:{ zzdj -> 0x0161 }
        r0.f7233s = r8;	 Catch:{ zzdj -> 0x0161 }
    L_0x011d:
        r9 = new com.google.android.gms.internal.zzcp;	 Catch:{ zzdj -> 0x0161 }
        r9.<init>(r0);	 Catch:{ zzdj -> 0x0161 }
        r0.f7223h = r9;	 Catch:{ zzdj -> 0x0161 }
        r0.f7226k = r8;	 Catch:{ zzdj -> 0x0161 }
        return r0;
    L_0x0127:
        r10 = move-exception;
        m5838a(r2);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r0.m5839a(r9, r1);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r2 = "%s/%s.dex";	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r3 = new java.lang.Object[r4];	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r3[r11] = r9;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r3[r8] = r1;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        r8 = java.lang.String.format(r2, r3);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        m5840a(r8);	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
        throw r10;	 Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzcy -> 0x0145, NullPointerException -> 0x013e }
    L_0x013e:
        r8 = move-exception;
        r9 = new com.google.android.gms.internal.zzdj;	 Catch:{ zzdj -> 0x0161 }
        r9.<init>(r8);	 Catch:{ zzdj -> 0x0161 }
        throw r9;	 Catch:{ zzdj -> 0x0161 }
    L_0x0145:
        r8 = move-exception;	 Catch:{ zzdj -> 0x0161 }
        r9 = new com.google.android.gms.internal.zzdj;	 Catch:{ zzdj -> 0x0161 }
        r9.<init>(r8);	 Catch:{ zzdj -> 0x0161 }
        throw r9;	 Catch:{ zzdj -> 0x0161 }
    L_0x014c:
        r8 = move-exception;	 Catch:{ zzdj -> 0x0161 }
        r9 = new com.google.android.gms.internal.zzdj;	 Catch:{ zzdj -> 0x0161 }
        r9.<init>(r8);	 Catch:{ zzdj -> 0x0161 }
        throw r9;	 Catch:{ zzdj -> 0x0161 }
    L_0x0153:
        r8 = move-exception;	 Catch:{ zzdj -> 0x0161 }
        r9 = new com.google.android.gms.internal.zzdj;	 Catch:{ zzdj -> 0x0161 }
        r9.<init>(r8);	 Catch:{ zzdj -> 0x0161 }
        throw r9;	 Catch:{ zzdj -> 0x0161 }
    L_0x015a:
        r8 = move-exception;	 Catch:{ zzdj -> 0x0161 }
        r9 = new com.google.android.gms.internal.zzdj;	 Catch:{ zzdj -> 0x0161 }
        r9.<init>(r8);	 Catch:{ zzdj -> 0x0161 }
        throw r9;	 Catch:{ zzdj -> 0x0161 }
    L_0x0161:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.a(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.android.gms.internal.zzdm");
    }

    private static void m5838a(File file) {
        if (file.exists()) {
            file.delete();
            return;
        }
        Log.d(f7215m, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
    }

    private final void m5839a(java.io.File r8, java.lang.String r9) {
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
        r7 = this;
        r0 = new java.io.File;
        r1 = "%s/%s.tmp";
        r2 = 2;
        r3 = new java.lang.Object[r2];
        r4 = 0;
        r3[r4] = r8;
        r5 = 1;
        r3[r5] = r9;
        r1 = java.lang.String.format(r1, r3);
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x001b;
    L_0x001a:
        return;
    L_0x001b:
        r1 = new java.io.File;
        r3 = "%s/%s.dex";
        r2 = new java.lang.Object[r2];
        r2[r4] = r8;
        r2[r5] = r9;
        r8 = java.lang.String.format(r3, r2);
        r1.<init>(r8);
        r8 = r1.exists();
        if (r8 != 0) goto L_0x0033;
    L_0x0032:
        return;
    L_0x0033:
        r2 = r1.length();
        r5 = 0;
        r8 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1));
        if (r8 > 0) goto L_0x003e;
    L_0x003d:
        return;
    L_0x003e:
        r8 = (int) r2;
        r8 = new byte[r8];
        r2 = 0;
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x00ad, IOException -> 0x00ad, IOException -> 0x00ad, all -> 0x009d }
        r3.<init>(r1);	 Catch:{ IOException -> 0x00ad, IOException -> 0x00ad, IOException -> 0x00ad, all -> 0x009d }
        r5 = r3.read(r8);	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        if (r5 > 0) goto L_0x0054;
    L_0x004d:
        r3.close();	 Catch:{ IOException -> 0x0050 }
    L_0x0050:
        m5838a(r1);
        return;
    L_0x0054:
        r5 = new com.google.android.gms.internal.zzbd;	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r5.<init>();	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r6 = android.os.Build.VERSION.SDK;	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r6 = r6.getBytes();	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r5.f17702d = r6;	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r9 = r9.getBytes();	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r5.f17701c = r9;	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r9 = r7.f7220e;	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r8 = com.google.android.gms.internal.zzcx.m5822a(r9, r8);	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r8 = r8.getBytes();	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r5.f17699a = r8;	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r8 = com.google.android.gms.internal.zzbw.m5584a(r8);	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r5.f17700b = r8;	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r0.createNewFile();	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r8 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r8.<init>(r0);	 Catch:{ IOException -> 0x00ae, IOException -> 0x00ae, IOException -> 0x00ae, all -> 0x009b }
        r9 = com.google.android.gms.internal.zzfjs.m6205a(r5);	 Catch:{ IOException -> 0x0099, IOException -> 0x0099, IOException -> 0x0099, all -> 0x0096 }
        r0 = r9.length;	 Catch:{ IOException -> 0x0099, IOException -> 0x0099, IOException -> 0x0099, all -> 0x0096 }
        r8.write(r9, r4, r0);	 Catch:{ IOException -> 0x0099, IOException -> 0x0099, IOException -> 0x0099, all -> 0x0096 }
        r8.close();	 Catch:{ IOException -> 0x0099, IOException -> 0x0099, IOException -> 0x0099, all -> 0x0096 }
        r3.close();	 Catch:{ IOException -> 0x008f }
    L_0x008f:
        r8.close();	 Catch:{ IOException -> 0x0092 }
    L_0x0092:
        m5838a(r1);
        return;
    L_0x0096:
        r9 = move-exception;
        r2 = r8;
        goto L_0x009f;
    L_0x0099:
        r2 = r8;
        goto L_0x00ae;
    L_0x009b:
        r9 = move-exception;
        goto L_0x009f;
    L_0x009d:
        r9 = move-exception;
        r3 = r2;
    L_0x009f:
        if (r3 == 0) goto L_0x00a4;
    L_0x00a1:
        r3.close();	 Catch:{ IOException -> 0x00a4 }
    L_0x00a4:
        if (r2 == 0) goto L_0x00a9;
    L_0x00a6:
        r2.close();	 Catch:{ IOException -> 0x00a9 }
    L_0x00a9:
        m5838a(r1);
        throw r9;
    L_0x00ad:
        r3 = r2;
    L_0x00ae:
        if (r3 == 0) goto L_0x00b3;
    L_0x00b0:
        r3.close();	 Catch:{ IOException -> 0x00b3 }
    L_0x00b3:
        if (r2 == 0) goto L_0x00b8;
    L_0x00b5:
        r2.close();	 Catch:{ IOException -> 0x00b8 }
    L_0x00b8:
        m5838a(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.a(java.io.File, java.lang.String):void");
    }

    private static void m5840a(String str) {
        m5838a(new File(str));
    }

    private final boolean m5843b(java.io.File r9, java.lang.String r10) {
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
        r8 = this;
        r0 = new java.io.File;
        r1 = "%s/%s.tmp";
        r2 = 2;
        r3 = new java.lang.Object[r2];
        r4 = 0;
        r3[r4] = r9;
        r5 = 1;
        r3[r5] = r10;
        r1 = java.lang.String.format(r1, r3);
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 != 0) goto L_0x001b;
    L_0x001a:
        return r4;
    L_0x001b:
        r1 = new java.io.File;
        r3 = "%s/%s.dex";
        r2 = new java.lang.Object[r2];
        r2[r4] = r9;
        r2[r5] = r10;
        r9 = java.lang.String.format(r3, r2);
        r1.<init>(r9);
        r9 = r1.exists();
        if (r9 == 0) goto L_0x0033;
    L_0x0032:
        return r4;
    L_0x0033:
        r9 = 0;
        r2 = r0.length();	 Catch:{ IOException -> 0x00ce, IOException -> 0x00ce, IOException -> 0x00ce, all -> 0x00c1 }
        r6 = 0;	 Catch:{ IOException -> 0x00ce, IOException -> 0x00ce, IOException -> 0x00ce, all -> 0x00c1 }
        r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));	 Catch:{ IOException -> 0x00ce, IOException -> 0x00ce, IOException -> 0x00ce, all -> 0x00c1 }
        if (r6 > 0) goto L_0x0042;	 Catch:{ IOException -> 0x00ce, IOException -> 0x00ce, IOException -> 0x00ce, all -> 0x00c1 }
    L_0x003e:
        m5838a(r0);	 Catch:{ IOException -> 0x00ce, IOException -> 0x00ce, IOException -> 0x00ce, all -> 0x00c1 }
        return r4;	 Catch:{ IOException -> 0x00ce, IOException -> 0x00ce, IOException -> 0x00ce, all -> 0x00c1 }
    L_0x0042:
        r2 = (int) r2;	 Catch:{ IOException -> 0x00ce, IOException -> 0x00ce, IOException -> 0x00ce, all -> 0x00c1 }
        r2 = new byte[r2];	 Catch:{ IOException -> 0x00ce, IOException -> 0x00ce, IOException -> 0x00ce, all -> 0x00c1 }
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x00ce, IOException -> 0x00ce, IOException -> 0x00ce, all -> 0x00c1 }
        r3.<init>(r0);	 Catch:{ IOException -> 0x00ce, IOException -> 0x00ce, IOException -> 0x00ce, all -> 0x00c1 }
        r6 = r3.read(r2);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        if (r6 > 0) goto L_0x005e;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
    L_0x0050:
        r10 = f7215m;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r1 = "Cannot read the cache data.";	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        android.util.Log.d(r10, r1);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        m5838a(r0);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r3.close();	 Catch:{ IOException -> 0x005d }
    L_0x005d:
        return r4;
    L_0x005e:
        r6 = new com.google.android.gms.internal.zzbd;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r6.<init>();	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r2 = com.google.android.gms.internal.zzfjs.m6203a(r6, r2);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r2 = (com.google.android.gms.internal.zzbd) r2;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r6 = new java.lang.String;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r7 = r2.f17701c;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r6.<init>(r7);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r10 = r10.equals(r6);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        if (r10 == 0) goto L_0x00b8;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
    L_0x0076:
        r10 = r2.f17700b;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r6 = r2.f17699a;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r6 = com.google.android.gms.internal.zzbw.m5584a(r6);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r10 = java.util.Arrays.equals(r10, r6);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        if (r10 == 0) goto L_0x00b8;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
    L_0x0084:
        r10 = r2.f17702d;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r6 = android.os.Build.VERSION.SDK;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r6 = r6.getBytes();	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r10 = java.util.Arrays.equals(r10, r6);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        if (r10 != 0) goto L_0x0093;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
    L_0x0092:
        goto L_0x00b8;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
    L_0x0093:
        r10 = r8.f7220e;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r0 = new java.lang.String;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r2 = r2.f17699a;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r0.<init>(r2);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r10 = com.google.android.gms.internal.zzcx.m5825a(r10, r0);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r1.createNewFile();	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r0 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r0.<init>(r1);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r9 = r10.length;	 Catch:{ IOException -> 0x00b6, IOException -> 0x00b6, IOException -> 0x00b6, all -> 0x00b3 }
        r0.write(r10, r4, r9);	 Catch:{ IOException -> 0x00b6, IOException -> 0x00b6, IOException -> 0x00b6, all -> 0x00b3 }
        r3.close();	 Catch:{ IOException -> 0x00af }
    L_0x00af:
        r0.close();	 Catch:{ IOException -> 0x00b2 }
    L_0x00b2:
        return r5;
    L_0x00b3:
        r10 = move-exception;
        r9 = r0;
        goto L_0x00c3;
    L_0x00b6:
        r9 = r0;
        goto L_0x00cf;
    L_0x00b8:
        m5838a(r0);	 Catch:{ IOException -> 0x00cf, IOException -> 0x00cf, IOException -> 0x00cf, all -> 0x00bf }
        r3.close();	 Catch:{ IOException -> 0x00be }
    L_0x00be:
        return r4;
    L_0x00bf:
        r10 = move-exception;
        goto L_0x00c3;
    L_0x00c1:
        r10 = move-exception;
        r3 = r9;
    L_0x00c3:
        if (r3 == 0) goto L_0x00c8;
    L_0x00c5:
        r3.close();	 Catch:{ IOException -> 0x00c8 }
    L_0x00c8:
        if (r9 == 0) goto L_0x00cd;
    L_0x00ca:
        r9.close();	 Catch:{ IOException -> 0x00cd }
    L_0x00cd:
        throw r10;
    L_0x00ce:
        r3 = r9;
    L_0x00cf:
        if (r3 == 0) goto L_0x00d4;
    L_0x00d1:
        r3.close();	 Catch:{ IOException -> 0x00d4 }
    L_0x00d4:
        if (r9 == 0) goto L_0x00d9;
    L_0x00d6:
        r9.close();	 Catch:{ IOException -> 0x00d9 }
    L_0x00d9:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.b(java.io.File, java.lang.String):boolean");
    }

    private final com.google.android.gms.internal.zzaz m5844d() {
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
        r3 = this;
        r0 = r3.f7216a;	 Catch:{ Throwable -> 0x0024 }
        r0 = r0.getPackageManager();	 Catch:{ Throwable -> 0x0024 }
        r1 = r3.f7216a;	 Catch:{ Throwable -> 0x0024 }
        r1 = r1.getPackageName();	 Catch:{ Throwable -> 0x0024 }
        r2 = 0;	 Catch:{ Throwable -> 0x0024 }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ Throwable -> 0x0024 }
        r1 = r3.f7216a;	 Catch:{ Throwable -> 0x0024 }
        r2 = r3.f7216a;	 Catch:{ Throwable -> 0x0024 }
        r2 = r2.getPackageName();	 Catch:{ Throwable -> 0x0024 }
        r0 = r0.versionCode;	 Catch:{ Throwable -> 0x0024 }
        r0 = java.lang.Integer.toString(r0);	 Catch:{ Throwable -> 0x0024 }
        r0 = com.google.android.gms.internal.zzcbm.m5594a(r1, r2, r0);	 Catch:{ Throwable -> 0x0024 }
        return r0;
    L_0x0024:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.d():com.google.android.gms.internal.zzaz");
    }

    public final Context m5845a() {
        return this.f7216a;
    }

    public final Method m5846a(String str, String str2) {
        zzer com_google_android_gms_internal_zzer = (zzer) this.f7232r.get(new Pair(str, str2));
        return com_google_android_gms_internal_zzer == null ? null : com_google_android_gms_internal_zzer.m5931a();
    }

    final void m5847a(int i, boolean z) {
        if (this.f7225j) {
            Future submit = this.f7217b.submit(new zzdo(this, i, z));
            if (i == 0) {
                this.f7222g = submit;
            }
        }
    }

    public final boolean m5848a(String str, String str2, Class<?>... clsArr) {
        if (this.f7232r.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.f7232r.put(new Pair(str, str2), new zzer(this, str, str2, clsArr));
        return true;
    }

    public final com.google.android.gms.ads.identifier.AdvertisingIdClient m5849b() {
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
        r5 = this;
        r0 = r5.f7229o;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r5.f7228n;
        if (r0 == 0) goto L_0x000d;
    L_0x000a:
        r0 = r5.f7228n;
        return r0;
    L_0x000d:
        r0 = r5.f7230p;
        if (r0 == 0) goto L_0x0023;
    L_0x0011:
        r0 = r5.f7230p;	 Catch:{ InterruptedException -> 0x0023, InterruptedException -> 0x0023, TimeoutException -> 0x001d }
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;	 Catch:{ InterruptedException -> 0x0023, InterruptedException -> 0x0023, TimeoutException -> 0x001d }
        r4 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0023, InterruptedException -> 0x0023, TimeoutException -> 0x001d }
        r0.get(r2, r4);	 Catch:{ InterruptedException -> 0x0023, InterruptedException -> 0x0023, TimeoutException -> 0x001d }
        r5.f7230p = r1;	 Catch:{ InterruptedException -> 0x0023, InterruptedException -> 0x0023, TimeoutException -> 0x001d }
        goto L_0x0023;
    L_0x001d:
        r0 = r5.f7230p;
        r1 = 1;
        r0.cancel(r1);
    L_0x0023:
        r0 = r5.f7228n;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.b():com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    final com.google.android.gms.internal.zzaz m5850b(int r1, boolean r2) {
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
        r0 = this;
        if (r1 <= 0) goto L_0x000a;
    L_0x0002:
        if (r2 == 0) goto L_0x000a;
    L_0x0004:
        r1 = r1 * 1000;
        r1 = (long) r1;
        java.lang.Thread.sleep(r1);	 Catch:{ InterruptedException -> 0x000a }
    L_0x000a:
        r1 = r0.m5844d();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.b(int, boolean):com.google.android.gms.internal.zzaz");
    }

    public final int m5851c() {
        return this.f7223h != null ? zzcp.m5806a() : Integer.MIN_VALUE;
    }

    static /* synthetic */ void m5837a(com.google.android.gms.internal.zzdm r2) {
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
        r0 = r2.f7228n;	 Catch:{ GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015 }
        if (r0 != 0) goto L_0x0014;	 Catch:{ GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015 }
    L_0x0004:
        r0 = r2.f7231q;	 Catch:{ GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015 }
        if (r0 == 0) goto L_0x0014;	 Catch:{ GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015 }
    L_0x0008:
        r0 = new com.google.android.gms.ads.identifier.AdvertisingIdClient;	 Catch:{ GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015 }
        r1 = r2.f7216a;	 Catch:{ GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015 }
        r0.<init>(r1);	 Catch:{ GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015 }
        r0.start();	 Catch:{ GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015 }
        r2.f7228n = r0;	 Catch:{ GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015, GooglePlayServicesNotAvailableException -> 0x0015 }
    L_0x0014:
        return;
    L_0x0015:
        r0 = 0;
        r2.f7228n = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdm.a(com.google.android.gms.internal.zzdm):void");
    }

    static /* synthetic */ boolean m5841a(int i, zzaz com_google_android_gms_internal_zzaz) {
        if (i < 4) {
            if (com_google_android_gms_internal_zzaz == null) {
                return true;
            }
            if (((Boolean) zzkb.m6350f().m6488a(zznh.bC)).booleanValue() && (com_google_android_gms_internal_zzaz.f17654n == null || com_google_android_gms_internal_zzaz.f17654n.equals("0000000000000000000000000000000000000000000000000000000000000000"))) {
                return true;
            }
            if (((Boolean) zzkb.m6350f().m6488a(zznh.bD)).booleanValue() && (com_google_android_gms_internal_zzaz.f17639W == null || com_google_android_gms_internal_zzaz.f17639W.f17703a == null || com_google_android_gms_internal_zzaz.f17639W.f17703a.longValue() == -2)) {
                return true;
            }
        }
        return false;
    }
}
