package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class zzz {
    private static final Lock f5723c = new ReentrantLock();
    private static zzz f5724d;
    final Lock f5725a = new ReentrantLock();
    final SharedPreferences f5726b;

    private zzz(Context context) {
        this.f5726b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static zzz m4620a(Context context) {
        zzbq.m4808a((Object) context);
        f5723c.lock();
        try {
            if (f5724d == null) {
                f5724d = new zzz(context.getApplicationContext());
            }
            zzz com_google_android_gms_auth_api_signin_internal_zzz = f5724d;
            return com_google_android_gms_auth_api_signin_internal_zzz;
        } finally {
            f5723c.unlock();
        }
    }

    public static String m4621b(String str, String str2) {
        String str3 = ":";
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str).length() + String.valueOf(str3).length()) + String.valueOf(str2).length());
        stringBuilder.append(str);
        stringBuilder.append(str3);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    private final com.google.android.gms.auth.api.signin.GoogleSignInAccount m4622c(java.lang.String r3) {
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
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "googleSignInAccount";
        r3 = m4621b(r0, r3);
        r3 = r2.m4625a(r3);
        if (r3 == 0) goto L_0x0019;
    L_0x0014:
        r3 = com.google.android.gms.auth.api.signin.GoogleSignInAccount.m17564a(r3);	 Catch:{ JSONException -> 0x0019 }
        return r3;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zzz.c(java.lang.String):com.google.android.gms.auth.api.signin.GoogleSignInAccount");
    }

    private final com.google.android.gms.auth.api.signin.GoogleSignInOptions m4623d(java.lang.String r3) {
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
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = "googleSignInOptions";
        r3 = m4621b(r0, r3);
        r3 = r2.m4625a(r3);
        if (r3 == 0) goto L_0x0019;
    L_0x0014:
        r3 = com.google.android.gms.auth.api.signin.GoogleSignInOptions.m20171a(r3);	 Catch:{ JSONException -> 0x0019 }
        return r3;
    L_0x0019:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.internal.zzz.d(java.lang.String):com.google.android.gms.auth.api.signin.GoogleSignInOptions");
    }

    public final GoogleSignInAccount m4624a() {
        return m4622c(m4625a("defaultGoogleSignInAccount"));
    }

    public final String m4625a(String str) {
        this.f5725a.lock();
        try {
            str = this.f5726b.getString(str, null);
            return str;
        } finally {
            this.f5725a.unlock();
        }
    }

    protected final void m4627a(String str, String str2) {
        this.f5725a.lock();
        try {
            this.f5726b.edit().putString(str, str2).apply();
        } finally {
            this.f5725a.unlock();
        }
    }

    public final GoogleSignInOptions m4628b() {
        return m4623d(m4625a("defaultGoogleSignInAccount"));
    }

    public final void m4629b(String str) {
        this.f5725a.lock();
        try {
            this.f5726b.edit().remove(str).apply();
        } finally {
            this.f5725a.unlock();
        }
    }

    final void m4626a(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        zzbq.m4808a((Object) googleSignInAccount);
        zzbq.m4808a((Object) googleSignInOptions);
        String str = googleSignInAccount.f17235e;
        String b = m4621b("googleSignInAccount", str);
        googleSignInAccount = googleSignInAccount.m17566b();
        googleSignInAccount.remove("serverAuthCode");
        m4627a(b, googleSignInAccount.toString());
        m4627a(m4621b("googleSignInOptions", str), googleSignInOptions.m20183b().toString());
    }
}
