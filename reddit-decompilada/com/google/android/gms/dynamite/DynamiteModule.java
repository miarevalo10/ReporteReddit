package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;

public final class DynamiteModule {
    public static final zzd f5985a = new zzb();
    public static final zzd f5986b = new zzd();
    public static final zzd f5987c = new zze();
    public static final zzd f5988d = new zzf();
    public static final zzd f5989e = new zzg();
    private static Boolean f5990g;
    private static zzk f5991h;
    private static zzm f5992i;
    private static String f5993j;
    private static final ThreadLocal<zza> f5994k = new ThreadLocal();
    private static final zzi f5995l = new zza();
    private static zzd f5996m = new zzc();
    public final Context f5997f;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    static class zza {
        public Cursor f5984a;

        private zza() {
        }
    }

    public static class zzc extends Exception {
        private zzc(String str) {
            super(str);
        }

        private zzc(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface zzd {
        zzj mo1637a(Context context, String str, zzi com_google_android_gms_dynamite_zzi) throws zzc;
    }

    static class zzb implements zzi {
        private final int f14016a;
        private final int f14017b = 0;

        public zzb(int i) {
            this.f14016a = i;
        }

        public final int mo1635a(Context context, String str) {
            return this.f14016a;
        }

        public final int mo1636a(Context context, String str, boolean z) {
            return 0;
        }
    }

    private DynamiteModule(Context context) {
        this.f5997f = (Context) zzbq.m4808a((Object) context);
    }

    public static int m4953a(android.content.Context r5, java.lang.String r6) {
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
        r0 = 0;
        r5 = r5.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r5 = r5.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r1 = "com.google.android.gms.dynamite.descriptors.";	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r2 = "ModuleDescriptor";	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4 = java.lang.String.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4 = r4.length();	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3 = r3 + r4;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4 = java.lang.String.valueOf(r6);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4 = r4.length();	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3 = r3 + r4;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4 = java.lang.String.valueOf(r2);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4 = r4.length();	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3 = r3 + r4;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4.<init>(r3);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4.append(r1);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4.append(r6);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r1 = ".";	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4.append(r1);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r4.append(r2);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r1 = r4.toString();	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r5 = r5.loadClass(r1);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r1 = "MODULE_ID";	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r1 = r5.getDeclaredField(r1);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r2 = "MODULE_VERSION";	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r5 = r5.getDeclaredField(r2);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r2 = 0;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3 = r1.get(r2);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3 = r3.equals(r6);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        if (r3 != 0) goto L_0x009b;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
    L_0x005b:
        r5 = "DynamiteModule";	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r1 = r1.get(r2);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r2 = 51;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3 = java.lang.String.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3 = r3.length();	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r2 = r2 + r3;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3 = java.lang.String.valueOf(r6);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3 = r3.length();	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r2 = r2 + r3;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3.<init>(r2);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r2 = "Module descriptor id '";	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3.append(r2);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3.append(r1);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r1 = "' didn't match expected id '";	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3.append(r1);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3.append(r6);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r1 = "'";	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r3.append(r1);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        r1 = r3.toString();	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        android.util.Log.e(r5, r1);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        return r0;	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
    L_0x009b:
        r5 = r5.getInt(r2);	 Catch:{ ClassNotFoundException -> 0x00c1, Exception -> 0x00a0 }
        return r5;
    L_0x00a0:
        r5 = move-exception;
        r6 = "DynamiteModule";
        r1 = "Failed to load module descriptor class: ";
        r5 = r5.getMessage();
        r5 = java.lang.String.valueOf(r5);
        r2 = r5.length();
        if (r2 == 0) goto L_0x00b8;
    L_0x00b3:
        r5 = r1.concat(r5);
        goto L_0x00bd;
    L_0x00b8:
        r5 = new java.lang.String;
        r5.<init>(r1);
    L_0x00bd:
        android.util.Log.e(r6, r5);
        return r0;
    L_0x00c1:
        r5 = "DynamiteModule";
        r1 = 45;
        r2 = java.lang.String.valueOf(r6);
        r2 = r2.length();
        r1 = r1 + r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r1 = "Local module descriptor class for ";
        r2.append(r1);
        r2.append(r6);
        r6 = " not found.";
        r2.append(r6);
        r6 = r2.toString();
        android.util.Log.w(r5, r6);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(android.content.Context, java.lang.String):int");
    }

    public static int m4954a(android.content.Context r8, java.lang.String r9, boolean r10) {
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
        r0 = com.google.android.gms.dynamite.DynamiteModule.class;
        monitor-enter(r0);
        r1 = f5990g;	 Catch:{ all -> 0x00e7 }
        if (r1 != 0) goto L_0x00b4;
    L_0x0007:
        r1 = r8.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r1 = r1.getClassLoader();	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r2 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class;	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r2 = r2.getName();	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r1 = r1.loadClass(r2);	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r2 = "sClassLoader";	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r2 = r1.getDeclaredField(r2);	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        monitor-enter(r1);	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
        r3 = 0;
        r4 = r2.get(r3);	 Catch:{ all -> 0x0087 }
        r4 = (java.lang.ClassLoader) r4;	 Catch:{ all -> 0x0087 }
        if (r4 == 0) goto L_0x0038;	 Catch:{ all -> 0x0087 }
    L_0x0029:
        r2 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0087 }
        if (r4 != r2) goto L_0x0032;	 Catch:{ all -> 0x0087 }
    L_0x002f:
        r2 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x0087 }
        goto L_0x0084;
    L_0x0032:
        m4959a(r4);	 Catch:{ zzc -> 0x0035 }
    L_0x0035:
        r2 = java.lang.Boolean.TRUE;	 Catch:{ all -> 0x0087 }
        goto L_0x0084;	 Catch:{ all -> 0x0087 }
    L_0x0038:
        r4 = "com.google.android.gms";	 Catch:{ all -> 0x0087 }
        r5 = r8.getApplicationContext();	 Catch:{ all -> 0x0087 }
        r5 = r5.getPackageName();	 Catch:{ all -> 0x0087 }
        r4 = r4.equals(r5);	 Catch:{ all -> 0x0087 }
        if (r4 == 0) goto L_0x0050;	 Catch:{ all -> 0x0087 }
    L_0x0048:
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0087 }
        r2.set(r3, r4);	 Catch:{ all -> 0x0087 }
        goto L_0x002f;
    L_0x0050:
        r4 = m4963c(r8, r9, r10);	 Catch:{ zzc -> 0x007c }
        r5 = f5993j;	 Catch:{ zzc -> 0x007c }
        if (r5 == 0) goto L_0x0079;	 Catch:{ zzc -> 0x007c }
    L_0x0058:
        r5 = f5993j;	 Catch:{ zzc -> 0x007c }
        r5 = r5.isEmpty();	 Catch:{ zzc -> 0x007c }
        if (r5 == 0) goto L_0x0061;	 Catch:{ zzc -> 0x007c }
    L_0x0060:
        goto L_0x0079;	 Catch:{ zzc -> 0x007c }
    L_0x0061:
        r5 = new com.google.android.gms.dynamite.zzh;	 Catch:{ zzc -> 0x007c }
        r6 = f5993j;	 Catch:{ zzc -> 0x007c }
        r7 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ zzc -> 0x007c }
        r5.<init>(r6, r7);	 Catch:{ zzc -> 0x007c }
        m4959a(r5);	 Catch:{ zzc -> 0x007c }
        r2.set(r3, r5);	 Catch:{ zzc -> 0x007c }
        r5 = java.lang.Boolean.TRUE;	 Catch:{ zzc -> 0x007c }
        f5990g = r5;	 Catch:{ zzc -> 0x007c }
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        monitor-exit(r0);	 Catch:{ all -> 0x00e7 }
        return r4;
    L_0x0079:
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        monitor-exit(r0);	 Catch:{ all -> 0x00e7 }
        return r4;
    L_0x007c:
        r4 = java.lang.ClassLoader.getSystemClassLoader();	 Catch:{ all -> 0x0087 }
        r2.set(r3, r4);	 Catch:{ all -> 0x0087 }
        goto L_0x002f;	 Catch:{ all -> 0x0087 }
    L_0x0084:
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        r1 = r2;	 Catch:{ all -> 0x0087 }
        goto L_0x00b2;	 Catch:{ all -> 0x0087 }
    L_0x0087:
        r2 = move-exception;	 Catch:{ all -> 0x0087 }
        monitor-exit(r1);	 Catch:{ all -> 0x0087 }
        throw r2;	 Catch:{ ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a, ClassNotFoundException -> 0x008a }
    L_0x008a:
        r1 = move-exception;
        r2 = "DynamiteModule";	 Catch:{ all -> 0x00e7 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00e7 }
        r3 = 30;	 Catch:{ all -> 0x00e7 }
        r4 = java.lang.String.valueOf(r1);	 Catch:{ all -> 0x00e7 }
        r4 = r4.length();	 Catch:{ all -> 0x00e7 }
        r3 = r3 + r4;	 Catch:{ all -> 0x00e7 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e7 }
        r4.<init>(r3);	 Catch:{ all -> 0x00e7 }
        r3 = "Failed to load module via V2: ";	 Catch:{ all -> 0x00e7 }
        r4.append(r3);	 Catch:{ all -> 0x00e7 }
        r4.append(r1);	 Catch:{ all -> 0x00e7 }
        r1 = r4.toString();	 Catch:{ all -> 0x00e7 }
        android.util.Log.w(r2, r1);	 Catch:{ all -> 0x00e7 }
        r1 = java.lang.Boolean.FALSE;	 Catch:{ all -> 0x00e7 }
    L_0x00b2:
        f5990g = r1;	 Catch:{ all -> 0x00e7 }
    L_0x00b4:
        monitor-exit(r0);	 Catch:{ all -> 0x00e7 }
        r0 = r1.booleanValue();
        if (r0 == 0) goto L_0x00e2;
    L_0x00bb:
        r8 = m4963c(r8, r9, r10);	 Catch:{ zzc -> 0x00c0 }
        return r8;
    L_0x00c0:
        r8 = move-exception;
        r9 = "DynamiteModule";
        r10 = "Failed to retrieve remote module version: ";
        r8 = r8.getMessage();
        r8 = java.lang.String.valueOf(r8);
        r0 = r8.length();
        if (r0 == 0) goto L_0x00d8;
    L_0x00d3:
        r8 = r10.concat(r8);
        goto L_0x00dd;
    L_0x00d8:
        r8 = new java.lang.String;
        r8.<init>(r10);
    L_0x00dd:
        android.util.Log.w(r9, r8);
        r8 = 0;
        return r8;
    L_0x00e2:
        r8 = m4961b(r8, r9, r10);
        return r8;
    L_0x00e7:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00e7 }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(android.content.Context, java.lang.String, boolean):int");
    }

    private static Context m4955a(Context context, String str, int i, Cursor cursor, zzm com_google_android_gms_dynamite_zzm) {
        try {
            return (Context) zzn.m17693a(com_google_android_gms_dynamite_zzm.mo1640a(zzn.m17692a((Object) context), str, i, zzn.m17692a((Object) cursor)));
        } catch (Exception e) {
            str = "DynamiteModule";
            String str2 = "Failed to load DynamiteLoader: ";
            String valueOf = String.valueOf(e.toString());
            Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule m4956a(android.content.Context r10, com.google.android.gms.dynamite.DynamiteModule.zzd r11, java.lang.String r12) throws com.google.android.gms.dynamite.DynamiteModule.zzc {
        /*
        r0 = f5994k;
        r0 = r0.get();
        r0 = (com.google.android.gms.dynamite.DynamiteModule.zza) r0;
        r1 = new com.google.android.gms.dynamite.DynamiteModule$zza;
        r2 = 0;
        r1.<init>();
        r3 = f5994k;
        r3.set(r1);
        r3 = f5995l;	 Catch:{ all -> 0x0131 }
        r3 = r11.mo1637a(r10, r12, r3);	 Catch:{ all -> 0x0131 }
        r4 = "DynamiteModule";
        r5 = r3.f5998a;	 Catch:{ all -> 0x0131 }
        r6 = r3.f5999b;	 Catch:{ all -> 0x0131 }
        r7 = 68;
        r8 = java.lang.String.valueOf(r12);	 Catch:{ all -> 0x0131 }
        r8 = r8.length();	 Catch:{ all -> 0x0131 }
        r7 = r7 + r8;
        r8 = java.lang.String.valueOf(r12);	 Catch:{ all -> 0x0131 }
        r8 = r8.length();	 Catch:{ all -> 0x0131 }
        r7 = r7 + r8;
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0131 }
        r8.<init>(r7);	 Catch:{ all -> 0x0131 }
        r7 = "Considering local module ";
        r8.append(r7);	 Catch:{ all -> 0x0131 }
        r8.append(r12);	 Catch:{ all -> 0x0131 }
        r7 = ":";
        r8.append(r7);	 Catch:{ all -> 0x0131 }
        r8.append(r5);	 Catch:{ all -> 0x0131 }
        r5 = " and remote module ";
        r8.append(r5);	 Catch:{ all -> 0x0131 }
        r8.append(r12);	 Catch:{ all -> 0x0131 }
        r5 = ":";
        r8.append(r5);	 Catch:{ all -> 0x0131 }
        r8.append(r6);	 Catch:{ all -> 0x0131 }
        r5 = r8.toString();	 Catch:{ all -> 0x0131 }
        android.util.Log.i(r4, r5);	 Catch:{ all -> 0x0131 }
        r4 = r3.f6000c;	 Catch:{ all -> 0x0131 }
        if (r4 == 0) goto L_0x0107;
    L_0x0063:
        r4 = r3.f6000c;	 Catch:{ all -> 0x0131 }
        r5 = -1;
        if (r4 != r5) goto L_0x006c;
    L_0x0068:
        r4 = r3.f5998a;	 Catch:{ all -> 0x0131 }
        if (r4 == 0) goto L_0x0107;
    L_0x006c:
        r4 = r3.f6000c;	 Catch:{ all -> 0x0131 }
        r6 = 1;
        if (r4 != r6) goto L_0x0077;
    L_0x0071:
        r4 = r3.f5999b;	 Catch:{ all -> 0x0131 }
        if (r4 != 0) goto L_0x0077;
    L_0x0075:
        goto L_0x0107;
    L_0x0077:
        r4 = r3.f6000c;	 Catch:{ all -> 0x0131 }
        if (r4 != r5) goto L_0x008e;
    L_0x007b:
        r10 = m4964c(r10, r12);	 Catch:{ all -> 0x0131 }
        r11 = r1.f5984a;
        if (r11 == 0) goto L_0x0088;
    L_0x0083:
        r11 = r1.f5984a;
        r11.close();
    L_0x0088:
        r11 = f5994k;
        r11.set(r0);
        return r10;
    L_0x008e:
        r4 = r3.f6000c;	 Catch:{ all -> 0x0131 }
        if (r4 != r6) goto L_0x00ec;
    L_0x0092:
        r4 = r3.f5999b;	 Catch:{ zzc -> 0x00a7 }
        r4 = m4957a(r10, r12, r4);	 Catch:{ zzc -> 0x00a7 }
        r10 = r1.f5984a;
        if (r10 == 0) goto L_0x00a1;
    L_0x009c:
        r10 = r1.f5984a;
        r10.close();
    L_0x00a1:
        r10 = f5994k;
        r10.set(r0);
        return r4;
    L_0x00a7:
        r4 = move-exception;
        r6 = "DynamiteModule";
        r7 = "Failed to load remote module: ";
        r8 = r4.getMessage();	 Catch:{ all -> 0x0131 }
        r8 = java.lang.String.valueOf(r8);	 Catch:{ all -> 0x0131 }
        r9 = r8.length();	 Catch:{ all -> 0x0131 }
        if (r9 == 0) goto L_0x00bf;
    L_0x00ba:
        r7 = r7.concat(r8);	 Catch:{ all -> 0x0131 }
        goto L_0x00c5;
    L_0x00bf:
        r8 = new java.lang.String;	 Catch:{ all -> 0x0131 }
        r8.<init>(r7);	 Catch:{ all -> 0x0131 }
        r7 = r8;
    L_0x00c5:
        android.util.Log.w(r6, r7);	 Catch:{ all -> 0x0131 }
        r6 = r3.f5998a;	 Catch:{ all -> 0x0131 }
        if (r6 == 0) goto L_0x00e4;
    L_0x00cc:
        r6 = new com.google.android.gms.dynamite.DynamiteModule$zzb;	 Catch:{ all -> 0x0131 }
        r3 = r3.f5998a;	 Catch:{ all -> 0x0131 }
        r6.<init>(r3);	 Catch:{ all -> 0x0131 }
        r11 = r11.mo1637a(r10, r12, r6);	 Catch:{ all -> 0x0131 }
        r11 = r11.f6000c;	 Catch:{ all -> 0x0131 }
        if (r11 != r5) goto L_0x00e4;
    L_0x00db:
        r10 = m4964c(r10, r12);	 Catch:{ all -> 0x0131 }
        r11 = r1.f5984a;
        if (r11 == 0) goto L_0x0088;
    L_0x00e3:
        goto L_0x0083;
    L_0x00e4:
        r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc;	 Catch:{ all -> 0x0131 }
        r11 = "Remote load failed. No local fallback found.";
        r10.<init>(r11, r4);	 Catch:{ all -> 0x0131 }
        throw r10;	 Catch:{ all -> 0x0131 }
    L_0x00ec:
        r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc;	 Catch:{ all -> 0x0131 }
        r11 = r3.f6000c;	 Catch:{ all -> 0x0131 }
        r12 = 47;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0131 }
        r3.<init>(r12);	 Catch:{ all -> 0x0131 }
        r12 = "VersionPolicy returned invalid code:";
        r3.append(r12);	 Catch:{ all -> 0x0131 }
        r3.append(r11);	 Catch:{ all -> 0x0131 }
        r11 = r3.toString();	 Catch:{ all -> 0x0131 }
        r10.<init>(r11);	 Catch:{ all -> 0x0131 }
        throw r10;	 Catch:{ all -> 0x0131 }
    L_0x0107:
        r10 = new com.google.android.gms.dynamite.DynamiteModule$zzc;	 Catch:{ all -> 0x0131 }
        r11 = r3.f5998a;	 Catch:{ all -> 0x0131 }
        r12 = r3.f5999b;	 Catch:{ all -> 0x0131 }
        r3 = 91;
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0131 }
        r4.<init>(r3);	 Catch:{ all -> 0x0131 }
        r3 = "No acceptable module found. Local version is ";
        r4.append(r3);	 Catch:{ all -> 0x0131 }
        r4.append(r11);	 Catch:{ all -> 0x0131 }
        r11 = " and remote version is ";
        r4.append(r11);	 Catch:{ all -> 0x0131 }
        r4.append(r12);	 Catch:{ all -> 0x0131 }
        r11 = ".";
        r4.append(r11);	 Catch:{ all -> 0x0131 }
        r11 = r4.toString();	 Catch:{ all -> 0x0131 }
        r10.<init>(r11);	 Catch:{ all -> 0x0131 }
        throw r10;	 Catch:{ all -> 0x0131 }
    L_0x0131:
        r10 = move-exception;
        r11 = r1.f5984a;
        if (r11 == 0) goto L_0x013b;
    L_0x0136:
        r11 = r1.f5984a;
        r11.close();
    L_0x013b:
        r11 = f5994k;
        r11.set(r0);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.a(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$zzd, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    private static DynamiteModule m4957a(Context context, String str, int i) throws zzc {
        synchronized (DynamiteModule.class) {
            Boolean bool = f5990g;
        }
        if (bool != null) {
            return bool.booleanValue() ? m4965c(context, str, i) : m4962b(context, str, i);
        } else {
            throw new zzc("Failed to determine which loading route to use.");
        }
    }

    private static zzk m4958a(Context context) {
        synchronized (DynamiteModule.class) {
            zzk com_google_android_gms_dynamite_zzk;
            if (f5991h != null) {
                com_google_android_gms_dynamite_zzk = f5991h;
                return com_google_android_gms_dynamite_zzk;
            } else if (zzf.m4930b().mo1537a(context) != 0) {
                return null;
            } else {
                try {
                    IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                    if (iBinder == null) {
                        com_google_android_gms_dynamite_zzk = null;
                    } else {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                        com_google_android_gms_dynamite_zzk = queryLocalInterface instanceof zzk ? (zzk) queryLocalInterface : new zzl(iBinder);
                    }
                    if (com_google_android_gms_dynamite_zzk != null) {
                        f5991h = com_google_android_gms_dynamite_zzk;
                        return com_google_android_gms_dynamite_zzk;
                    }
                } catch (Exception e) {
                    String str = "DynamiteModule";
                    String str2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }
            }
        }
        return null;
    }

    private static void m4959a(ClassLoader classLoader) throws zzc {
        try {
            zzm com_google_android_gms_dynamite_zzm;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                com_google_android_gms_dynamite_zzm = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                com_google_android_gms_dynamite_zzm = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzn(iBinder);
            }
            f5992i = com_google_android_gms_dynamite_zzm;
        } catch (Throwable e) {
            throw new zzc("Failed to instantiate dynamite loader", e);
        }
    }

    public static int m4960b(Context context, String str) {
        return m4954a(context, str, false);
    }

    private static int m4961b(Context context, String str, boolean z) {
        zzk a = m4958a(context);
        if (a == null) {
            return 0;
        }
        try {
            return a.mo1638a(zzn.m17692a((Object) context), str, z);
        } catch (RemoteException e) {
            str = "DynamiteModule";
            String str2 = "Failed to retrieve remote module version: ";
            String valueOf = String.valueOf(e.getMessage());
            Log.w(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            return 0;
        }
    }

    private static DynamiteModule m4962b(Context context, String str, int i) throws zzc {
        StringBuilder stringBuilder = new StringBuilder(51 + String.valueOf(str).length());
        stringBuilder.append("Selected remote version of ");
        stringBuilder.append(str);
        stringBuilder.append(", version >= ");
        stringBuilder.append(i);
        Log.i("DynamiteModule", stringBuilder.toString());
        zzk a = m4958a(context);
        if (a == null) {
            throw new zzc("Failed to create IDynamiteLoader.");
        }
        try {
            IObjectWrapper a2 = a.mo1639a(zzn.m17692a((Object) context), str, i);
            if (zzn.m17693a(a2) != null) {
                return new DynamiteModule((Context) zzn.m17693a(a2));
            }
            throw new zzc("Failed to load remote module.");
        } catch (Throwable e) {
            throw new zzc("Failed to load remote module.", e);
        }
    }

    private static int m4963c(Context context, String str, boolean z) throws zzc {
        Throwable th;
        Cursor cursor = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            String str2 = z ? "api_force_staging" : "api";
            String str3 = "content://com.google.android.gms.chimera/";
            StringBuilder stringBuilder = new StringBuilder(((1 + String.valueOf(str3).length()) + String.valueOf(str2).length()) + String.valueOf(str).length());
            stringBuilder.append(str3);
            stringBuilder.append(str2);
            stringBuilder.append(Operation.DIVISION);
            stringBuilder.append(str);
            Cursor query = contentResolver.query(Uri.parse(stringBuilder.toString()), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i = query.getInt(0);
                        if (i > 0) {
                            synchronized (DynamiteModule.class) {
                                f5993j = query.getString(2);
                            }
                            zza com_google_android_gms_dynamite_DynamiteModule_zza = (zza) f5994k.get();
                            if (com_google_android_gms_dynamite_DynamiteModule_zza != null && com_google_android_gms_dynamite_DynamiteModule_zza.f5984a == null) {
                                com_google_android_gms_dynamite_DynamiteModule_zza.f5984a = query;
                                query = null;
                            }
                        }
                        if (query != null) {
                            query.close();
                        }
                        return i;
                    }
                } catch (Throwable e) {
                    cursor = query;
                    th = e;
                } catch (Throwable e2) {
                    cursor = query;
                    th = e2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            throw new zzc("Failed to connect to dynamite module ContentResolver.");
        } catch (Exception e3) {
            th = e3;
            try {
                if (th instanceof zzc) {
                    throw th;
                }
                throw new zzc("V2 version check failed", th);
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    private static DynamiteModule m4964c(Context context, String str) {
        String str2 = "DynamiteModule";
        String str3 = "Selected local version of ";
        str = String.valueOf(str);
        Log.i(str2, str.length() != 0 ? str3.concat(str) : new String(str3));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static DynamiteModule m4965c(Context context, String str, int i) throws zzc {
        StringBuilder stringBuilder = new StringBuilder(51 + String.valueOf(str).length());
        stringBuilder.append("Selected remote version of ");
        stringBuilder.append(str);
        stringBuilder.append(", version >= ");
        stringBuilder.append(i);
        Log.i("DynamiteModule", stringBuilder.toString());
        synchronized (DynamiteModule.class) {
            zzm com_google_android_gms_dynamite_zzm = f5992i;
        }
        if (com_google_android_gms_dynamite_zzm == null) {
            throw new zzc("DynamiteLoaderV2 was not cached.");
        }
        zza com_google_android_gms_dynamite_DynamiteModule_zza = (zza) f5994k.get();
        if (com_google_android_gms_dynamite_DynamiteModule_zza != null) {
            if (com_google_android_gms_dynamite_DynamiteModule_zza.f5984a != null) {
                context = m4955a(context.getApplicationContext(), str, i, com_google_android_gms_dynamite_DynamiteModule_zza.f5984a, com_google_android_gms_dynamite_zzm);
                if (context != null) {
                    return new DynamiteModule(context);
                }
                throw new zzc("Failed to get module context");
            }
        }
        throw new zzc("No result cursor");
    }

    public final IBinder m4966a(String str) throws zzc {
        try {
            return (IBinder) this.f5997f.getClassLoader().loadClass(str).newInstance();
        } catch (Throwable e) {
            String str2 = "Failed to instantiate module class: ";
            str = String.valueOf(str);
            throw new zzc(str.length() != 0 ? str2.concat(str) : new String(str2), e);
        }
    }
}
