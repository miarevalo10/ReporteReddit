package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.util.zzq;
import com.google.firebase.FirebaseApp;
import java.util.List;

final class zzu {
    private final Context f8670a;
    private String f8671b;
    private String f8672c;
    private int f8673d;
    private int f8674e = 0;

    public zzu(Context context) {
        this.f8670a = context;
    }

    private final PackageInfo m7400a(String str) {
        try {
            return this.f8670a.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            str = String.valueOf(e);
            StringBuilder stringBuilder = new StringBuilder(23 + String.valueOf(str).length());
            stringBuilder.append("Failed to find package ");
            stringBuilder.append(str);
            Log.w("FirebaseInstanceId", stringBuilder.toString());
            return null;
        }
    }

    public static java.lang.String m7402a(java.security.KeyPair r4) {
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
        r4 = r4.getPublic();
        r4 = r4.getEncoded();
        r0 = "SHA1";	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r4 = r0.digest(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r0 = 0;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r1 = r4[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r3 = 15;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r1 = r1 & r3;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r2 = r2 + r1;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r1 = (byte) r2;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r4[r0] = r1;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r1 = 8;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r2 = 11;	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        r4 = android.util.Base64.encodeToString(r4, r0, r1, r2);	 Catch:{ NoSuchAlgorithmException -> 0x0027 }
        return r4;
    L_0x0027:
        r4 = "FirebaseInstanceId";
        r0 = "Unexpected error, device missing required algorithms";
        android.util.Log.w(r4, r0);
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzu.a(java.security.KeyPair):java.lang.String");
    }

    private final synchronized void m7403e() {
        PackageInfo a = m7400a(this.f8670a.getPackageName());
        if (a != null) {
            this.f8671b = Integer.toString(a.versionCode);
            this.f8672c = a.versionName;
        }
    }

    public final synchronized int m7404a() {
        if (this.f8674e != 0) {
            return this.f8674e;
        }
        PackageManager packageManager = this.f8670a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        Intent intent;
        if (!zzq.m4917i()) {
            intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f8674e = 1;
                return this.f8674e;
            }
        }
        intent = new Intent("com.google.iid.TOKEN_REQUEST");
        intent.setPackage("com.google.android.gms");
        List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
            if (zzq.m4917i()) {
                this.f8674e = 2;
            } else {
                this.f8674e = 1;
            }
            return this.f8674e;
        }
        this.f8674e = 2;
        return this.f8674e;
    }

    public final synchronized String m7405b() {
        if (this.f8671b == null) {
            m7403e();
        }
        return this.f8671b;
    }

    public final synchronized String m7406c() {
        if (this.f8672c == null) {
            m7403e();
        }
        return this.f8672c;
    }

    public final synchronized int m7407d() {
        if (this.f8673d == 0) {
            PackageInfo a = m7400a("com.google.android.gms");
            if (a != null) {
                this.f8673d = a.versionCode;
            }
        }
        return this.f8673d;
    }

    public static String m7401a(FirebaseApp firebaseApp) {
        String str = firebaseApp.m7354b().f8604b;
        if (str != null) {
            return str;
        }
        firebaseApp = firebaseApp.m7354b().f8603a;
        if (!firebaseApp.startsWith("1:")) {
            return firebaseApp;
        }
        firebaseApp = firebaseApp.split(":");
        if (firebaseApp.length < 2) {
            return null;
        }
        firebaseApp = firebaseApp[1];
        return firebaseApp.isEmpty() ? null : firebaseApp;
    }
}
