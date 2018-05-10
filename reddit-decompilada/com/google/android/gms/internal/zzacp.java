package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.common.util.zzq;
import java.util.Locale;

public final class zzacp {
    private String f6188A;
    private boolean f6189B;
    private int f6190a;
    private boolean f6191b;
    private boolean f6192c;
    private int f6193d;
    private int f6194e;
    private int f6195f;
    private String f6196g;
    private int f6197h;
    private int f6198i;
    private int f6199j;
    private boolean f6200k;
    private int f6201l;
    private double f6202m;
    private boolean f6203n;
    private String f6204o;
    private String f6205p;
    private boolean f6206q;
    private boolean f6207r;
    private String f6208s;
    private boolean f6209t;
    private boolean f6210u;
    private String f6211v;
    private String f6212w;
    private float f6213x;
    private int f6214y;
    private int f6215z;

    public zzacp(Context context) {
        PackageManager packageManager = context.getPackageManager();
        m5008a(context);
        m5009b(context);
        m5010c(context);
        Locale locale = Locale.getDefault();
        boolean z = false;
        this.f6206q = m5006a(packageManager, "geo:0,0?q=donuts") != null;
        if (m5006a(packageManager, "http://www.google.com") != null) {
            z = true;
        }
        this.f6207r = z;
        this.f6208s = locale.getCountry();
        zzkb.m6345a();
        this.f6209t = zzajr.m5328a();
        this.f6210u = zzi.m4903b(context);
        this.f6211v = locale.getLanguage();
        this.f6212w = m5007a(context, packageManager);
        this.f6188A = m5011d(context);
        Resources resources = context.getResources();
        if (resources != null) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (displayMetrics != null) {
                this.f6213x = displayMetrics.density;
                this.f6214y = displayMetrics.widthPixels;
                this.f6215z = displayMetrics.heightPixels;
            }
        }
    }

    public zzacp(Context context, zzaco com_google_android_gms_internal_zzaco) {
        context.getPackageManager();
        m5008a(context);
        m5009b(context);
        m5010c(context);
        this.f6204o = Build.FINGERPRINT;
        this.f6205p = Build.DEVICE;
        boolean z = zzq.m4909a() && zzoe.m14110a(context);
        this.f6189B = z;
        this.f6206q = com_google_android_gms_internal_zzaco.f6163b;
        this.f6207r = com_google_android_gms_internal_zzaco.f6164c;
        this.f6208s = com_google_android_gms_internal_zzaco.f6166e;
        this.f6209t = com_google_android_gms_internal_zzaco.f6167f;
        this.f6210u = com_google_android_gms_internal_zzaco.f6168g;
        this.f6211v = com_google_android_gms_internal_zzaco.f6171j;
        this.f6212w = com_google_android_gms_internal_zzaco.f6172k;
        this.f6188A = com_google_android_gms_internal_zzaco.f6173l;
        this.f6213x = com_google_android_gms_internal_zzaco.f6180s;
        this.f6214y = com_google_android_gms_internal_zzaco.f6181t;
        this.f6215z = com_google_android_gms_internal_zzaco.f6182u;
    }

    private static ResolveInfo m5006a(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzbs.m4490i().m13246a(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    private static java.lang.String m5007a(android.content.Context r3, android.content.pm.PackageManager r4) {
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
        r0 = "market://details?id=com.google.android.gms.ads";
        r4 = m5006a(r4, r0);
        r0 = 0;
        if (r4 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r4 = r4.activityInfo;
        if (r4 != 0) goto L_0x000f;
    L_0x000e:
        return r0;
    L_0x000f:
        r3 = com.google.android.gms.internal.zzbhf.m5574a(r3);	 Catch:{ NameNotFoundException -> 0x0040 }
        r1 = r4.packageName;	 Catch:{ NameNotFoundException -> 0x0040 }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0040 }
        r3 = r3.m5572b(r1, r2);	 Catch:{ NameNotFoundException -> 0x0040 }
        if (r3 == 0) goto L_0x0040;	 Catch:{ NameNotFoundException -> 0x0040 }
    L_0x001c:
        r3 = r3.versionCode;	 Catch:{ NameNotFoundException -> 0x0040 }
        r4 = r4.packageName;	 Catch:{ NameNotFoundException -> 0x0040 }
        r1 = 12;	 Catch:{ NameNotFoundException -> 0x0040 }
        r2 = java.lang.String.valueOf(r4);	 Catch:{ NameNotFoundException -> 0x0040 }
        r2 = r2.length();	 Catch:{ NameNotFoundException -> 0x0040 }
        r1 = r1 + r2;	 Catch:{ NameNotFoundException -> 0x0040 }
        r2 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0040 }
        r2.<init>(r1);	 Catch:{ NameNotFoundException -> 0x0040 }
        r2.append(r3);	 Catch:{ NameNotFoundException -> 0x0040 }
        r3 = ".";	 Catch:{ NameNotFoundException -> 0x0040 }
        r2.append(r3);	 Catch:{ NameNotFoundException -> 0x0040 }
        r2.append(r4);	 Catch:{ NameNotFoundException -> 0x0040 }
        r3 = r2.toString();	 Catch:{ NameNotFoundException -> 0x0040 }
        return r3;
    L_0x0040:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzacp.a(android.content.Context, android.content.pm.PackageManager):java.lang.String");
    }

    private final void m5008a(Context context) {
        zzbs.m4486e();
        AudioManager h = zzahn.m5216h(context);
        if (h != null) {
            try {
                this.f6190a = h.getMode();
                this.f6191b = h.isMusicActive();
                this.f6192c = h.isSpeakerphoneOn();
                this.f6193d = h.getStreamVolume(3);
                this.f6194e = h.getRingerMode();
                this.f6195f = h.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzbs.m4490i().m13246a(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.f6190a = -2;
        this.f6191b = false;
        this.f6192c = false;
        this.f6193d = 0;
        this.f6194e = 0;
        this.f6195f = 0;
    }

    @TargetApi(16)
    private final void m5009b(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.f6196g = telephonyManager.getNetworkOperator();
        this.f6198i = telephonyManager.getNetworkType();
        this.f6199j = telephonyManager.getPhoneType();
        this.f6197h = -2;
        this.f6200k = false;
        this.f6201l = -1;
        zzbs.m4486e();
        if (zzahn.m5179a(context, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.f6197h = activeNetworkInfo.getType();
                this.f6201l = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.f6197h = -1;
            }
            if (VERSION.SDK_INT >= 16) {
                this.f6200k = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    private final void m5010c(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.f6202m = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.f6203n = z;
            return;
        }
        this.f6202m = -1.0d;
        this.f6203n = false;
    }

    private static java.lang.String m5011d(android.content.Context r4) {
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
        r4 = com.google.android.gms.internal.zzbhf.m5574a(r4);	 Catch:{ Exception -> 0x0033 }
        r1 = "com.android.vending";	 Catch:{ Exception -> 0x0033 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x0033 }
        r4 = r4.m5572b(r1, r2);	 Catch:{ Exception -> 0x0033 }
        if (r4 == 0) goto L_0x0033;	 Catch:{ Exception -> 0x0033 }
    L_0x000f:
        r1 = r4.versionCode;	 Catch:{ Exception -> 0x0033 }
        r4 = r4.packageName;	 Catch:{ Exception -> 0x0033 }
        r2 = 12;	 Catch:{ Exception -> 0x0033 }
        r3 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x0033 }
        r3 = r3.length();	 Catch:{ Exception -> 0x0033 }
        r2 = r2 + r3;	 Catch:{ Exception -> 0x0033 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0033 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0033 }
        r3.append(r1);	 Catch:{ Exception -> 0x0033 }
        r1 = ".";	 Catch:{ Exception -> 0x0033 }
        r3.append(r1);	 Catch:{ Exception -> 0x0033 }
        r3.append(r4);	 Catch:{ Exception -> 0x0033 }
        r4 = r3.toString();	 Catch:{ Exception -> 0x0033 }
        return r4;
    L_0x0033:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzacp.d(android.content.Context):java.lang.String");
    }

    public final zzaco m5012a() {
        int i = this.f6190a;
        boolean z = this.f6206q;
        boolean z2 = this.f6207r;
        String str = this.f6196g;
        String str2 = this.f6208s;
        boolean z3 = this.f6209t;
        boolean z4 = this.f6210u;
        boolean z5 = this.f6191b;
        boolean z6 = this.f6192c;
        String str3 = this.f6211v;
        String str4 = this.f6212w;
        String str5 = this.f6188A;
        int i2 = this.f6193d;
        int i3 = this.f6197h;
        int i4 = this.f6198i;
        int i5 = i3;
        int i6 = this.f6199j;
        int i7 = this.f6194e;
        int i8 = this.f6195f;
        float f = this.f6213x;
        int i9 = this.f6214y;
        int i10 = i2;
        int i11 = this.f6215z;
        double d = this.f6202m;
        boolean z7 = this.f6203n;
        boolean z8 = this.f6200k;
        boolean z9 = z7;
        boolean z10 = z8;
        return new zzaco(i, z, z2, str, str2, z3, z4, z5, z6, str3, str4, str5, i10, i5, i4, i6, i7, i8, f, i9, i11, d, z9, z10, this.f6201l, this.f6204o, this.f6189B, this.f6205p);
    }
}
