package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;

@zzzv
public final class zzafx {
    public long f6352a = -1;
    public long f6353b = -1;
    public int f6354c = -1;
    public int f6355d = -1;
    public long f6356e = 0;
    public final Object f6357f = new Object();
    public int f6358g = 0;
    public int f6359h = 0;
    private String f6360i;

    public zzafx(String str) {
        this.f6360i = str;
    }

    private static boolean m5116a(android.content.Context r5) {
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
        r0 = r5.getResources();
        r1 = "Theme.Translucent";
        r2 = "style";
        r3 = "android";
        r0 = r0.getIdentifier(r1, r2, r3);
        r1 = 0;
        if (r0 != 0) goto L_0x0017;
    L_0x0011:
        r5 = "Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.";
        com.google.android.gms.internal.zzakb.m5370d(r5);
        return r1;
    L_0x0017:
        r2 = new android.content.ComponentName;
        r3 = r5.getPackageName();
        r4 = "com.google.android.gms.ads.AdActivity";
        r2.<init>(r3, r4);
        r5 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0036 }
        r5 = r5.getActivityInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0036 }
        r5 = r5.theme;	 Catch:{ NameNotFoundException -> 0x0036 }
        if (r0 != r5) goto L_0x0030;	 Catch:{ NameNotFoundException -> 0x0036 }
    L_0x002e:
        r5 = 1;	 Catch:{ NameNotFoundException -> 0x0036 }
        return r5;	 Catch:{ NameNotFoundException -> 0x0036 }
    L_0x0030:
        r5 = "Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.";	 Catch:{ NameNotFoundException -> 0x0036 }
        com.google.android.gms.internal.zzakb.m5370d(r5);	 Catch:{ NameNotFoundException -> 0x0036 }
        return r1;
    L_0x0036:
        r5 = "Fail to fetch AdActivity theme";
        com.google.android.gms.internal.zzakb.m5371e(r5);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzafx.a(android.content.Context):boolean");
    }

    public final Bundle m5117a(Context context, String str) {
        Bundle bundle;
        synchronized (this.f6357f) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f6360i);
            bundle.putLong("basets", this.f6353b);
            bundle.putLong("currts", this.f6352a);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f6354c);
            bundle.putInt("preqs_in_session", this.f6355d);
            bundle.putLong("time_in_session", this.f6356e);
            bundle.putInt("pclick", this.f6358g);
            bundle.putInt("pimp", this.f6359h);
            bundle.putBoolean("support_transparent_background", m5116a(context));
        }
        return bundle;
    }
}
