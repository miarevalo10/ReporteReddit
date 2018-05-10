package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.gmsg.zzae;
import com.google.android.gms.ads.internal.js.zzaa;

final class zzud implements zzae {
    private final zzaa f14635a;
    private final zzalf f14636b;
    private /* synthetic */ zzua f14637c;

    public zzud(zzua com_google_android_gms_internal_zzua, zzaa com_google_android_gms_ads_internal_js_zzaa, zzalf com_google_android_gms_internal_zzalf) {
        this.f14637c = com_google_android_gms_internal_zzua;
        this.f14635a = com_google_android_gms_ads_internal_js_zzaa;
        this.f14636b = com_google_android_gms_internal_zzalf;
    }

    public final void mo2160a(java.lang.String r3) {
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
        r2 = this;
        if (r3 != 0) goto L_0x000f;
    L_0x0002:
        r3 = r2.f14636b;	 Catch:{ IllegalStateException -> 0x0019, all -> 0x000d }
        r0 = new com.google.android.gms.internal.zzto;	 Catch:{ IllegalStateException -> 0x0019, all -> 0x000d }
        r0.<init>();	 Catch:{ IllegalStateException -> 0x0019, all -> 0x000d }
        r3.m13329a(r0);	 Catch:{ IllegalStateException -> 0x0019, all -> 0x000d }
        goto L_0x0019;	 Catch:{ IllegalStateException -> 0x0019, all -> 0x000d }
    L_0x000d:
        r3 = move-exception;	 Catch:{ IllegalStateException -> 0x0019, all -> 0x000d }
        goto L_0x001f;	 Catch:{ IllegalStateException -> 0x0019, all -> 0x000d }
    L_0x000f:
        r0 = r2.f14636b;	 Catch:{ IllegalStateException -> 0x0019, all -> 0x000d }
        r1 = new com.google.android.gms.internal.zzto;	 Catch:{ IllegalStateException -> 0x0019, all -> 0x000d }
        r1.<init>(r3);	 Catch:{ IllegalStateException -> 0x0019, all -> 0x000d }
        r0.m13329a(r1);	 Catch:{ IllegalStateException -> 0x0019, all -> 0x000d }
    L_0x0019:
        r3 = r2.f14635a;
        r3.m17383a();
        return;
    L_0x001f:
        r0 = r2.f14635a;
        r0.m17383a();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzud.a(java.lang.String):void");
    }

    public final void mo2161a(org.json.JSONObject r3) {
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
        r2 = this;
        r0 = r2.f14636b;	 Catch:{ IllegalStateException -> 0x000f, JSONException -> 0x0017 }
        r1 = r2.f14637c;	 Catch:{ IllegalStateException -> 0x000f, JSONException -> 0x0017 }
        r1 = r1.f18305a;	 Catch:{ IllegalStateException -> 0x000f, JSONException -> 0x0017 }
        r3 = r1.mo2158a(r3);	 Catch:{ IllegalStateException -> 0x000f, JSONException -> 0x0017 }
        r0.m13330b(r3);	 Catch:{ IllegalStateException -> 0x000f, JSONException -> 0x0017 }
    L_0x000f:
        r3 = r2.f14635a;
        r3.m17383a();
        return;
    L_0x0015:
        r3 = move-exception;
        goto L_0x001e;
    L_0x0017:
        r3 = move-exception;
        r0 = r2.f14636b;	 Catch:{ all -> 0x0015 }
        r0.m13330b(r3);	 Catch:{ all -> 0x0015 }
        goto L_0x000f;
    L_0x001e:
        r0 = r2.f14635a;
        r0.m17383a();
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzud.a(org.json.JSONObject):void");
    }
}
