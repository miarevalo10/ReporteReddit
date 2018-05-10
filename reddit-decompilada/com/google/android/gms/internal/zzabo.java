package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.gmsg.HttpClient;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.gmsg.zzy;
import com.google.android.gms.ads.internal.js.zzaa;
import com.google.android.gms.ads.internal.js.zzc;
import com.google.android.gms.ads.internal.js.zzn;
import com.google.android.gms.ads.internal.zzbs;
import java.util.concurrent.TimeUnit;

@zzzv
public final class zzabo extends zzagb {
    private static long f17481a = TimeUnit.SECONDS.toMillis(10);
    private static final Object f17482b = new Object();
    private static boolean f17483c = false;
    private static zzn f17484d;
    private static HttpClient f17485e;
    private static zzy f17486f;
    private static zzt<Object> f17487g;
    private final zzzx f17488h;
    private final zzaau f17489i;
    private final Object f17490j = new Object();
    private final Context f17491k;
    private zzaa f17492l;
    private zzix f17493m;

    public zzabo(Context context, zzaau com_google_android_gms_internal_zzaau, zzzx com_google_android_gms_internal_zzzx, zzix com_google_android_gms_internal_zzix) {
        super((byte) 0);
        this.f17488h = com_google_android_gms_internal_zzzx;
        this.f17491k = context;
        this.f17489i = com_google_android_gms_internal_zzaau;
        this.f17493m = com_google_android_gms_internal_zzix;
        synchronized (f17482b) {
            if (!f17483c) {
                f17486f = new zzy();
                f17485e = new HttpClient(context.getApplicationContext(), com_google_android_gms_internal_zzaau.f6051j);
                f17487g = new zzabw();
                f17484d = new zzn(this.f17491k.getApplicationContext(), this.f17489i.f6051j, (String) zzkb.m6350f().m6488a(zznh.f7891a), new zzabv(), new zzabu());
                f17483c = true;
            }
        }
    }

    private final org.json.JSONObject m17709a(com.google.android.gms.internal.zzaat r6, java.lang.String r7) {
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
        r0 = r6.f17396c;
        r0 = r0.f18136c;
        r1 = "sdk_less_server_data";
        r0 = r0.getBundle(r1);
        r1 = 0;
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r2 = com.google.android.gms.ads.internal.zzbs.m4496o();	 Catch:{ Exception -> 0x001f }
        r3 = r5.f17491k;	 Catch:{ Exception -> 0x001f }
        r2 = r2.m5014a(r3);	 Catch:{ Exception -> 0x001f }
        r2 = r2.get();	 Catch:{ Exception -> 0x001f }
        r2 = (com.google.android.gms.internal.zzaco) r2;	 Catch:{ Exception -> 0x001f }
        goto L_0x0026;
    L_0x001f:
        r2 = move-exception;
        r3 = "Error grabbing device info: ";
        com.google.android.gms.internal.zzakb.m5369c(r3, r2);
        r2 = r1;
    L_0x0026:
        r3 = r5.f17491k;
        r4 = new com.google.android.gms.internal.zzabz;
        r4.<init>();
        r4.f6084i = r6;
        r4.f6085j = r2;
        r6 = com.google.android.gms.internal.zzacg.m4991a(r3, r4);
        if (r6 != 0) goto L_0x0038;
    L_0x0037:
        return r1;
    L_0x0038:
        r2 = r5.f17491k;	 Catch:{ IOException -> 0x003f, IOException -> 0x003f, IOException -> 0x003f, IOException -> 0x003f }
        r2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r2);	 Catch:{ IOException -> 0x003f, IOException -> 0x003f, IOException -> 0x003f, IOException -> 0x003f }
        goto L_0x0046;
    L_0x003f:
        r2 = move-exception;
        r3 = "Cannot get advertising id info";
        com.google.android.gms.internal.zzakb.m5369c(r3, r2);
        r2 = r1;
    L_0x0046:
        r3 = new java.util.HashMap;
        r3.<init>();
        r4 = "request_id";
        r3.put(r4, r7);
        r7 = "request_param";
        r3.put(r7, r6);
        r6 = "data";
        r3.put(r6, r0);
        if (r2 == 0) goto L_0x0072;
    L_0x005c:
        r6 = "adid";
        r7 = r2.getId();
        r3.put(r6, r7);
        r6 = "lat";
        r7 = r2.isLimitAdTrackingEnabled();
        r7 = java.lang.Integer.valueOf(r7);
        r3.put(r6, r7);
    L_0x0072:
        r6 = com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ JSONException -> 0x007b }
        r6 = r6.m5227a(r3);	 Catch:{ JSONException -> 0x007b }
        return r6;
    L_0x007b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzabo.a(com.google.android.gms.internal.zzaat, java.lang.String):org.json.JSONObject");
    }

    protected static void m17710a(zzc com_google_android_gms_ads_internal_js_zzc) {
        com_google_android_gms_ads_internal_js_zzc.mo3934a("/loadAd", f17486f);
        com_google_android_gms_ads_internal_js_zzc.mo3934a("/fetchHttpRequest", f17485e);
        com_google_android_gms_ads_internal_js_zzc.mo3934a("/invalidRequest", f17487g);
    }

    protected static void m17712b(zzc com_google_android_gms_ads_internal_js_zzc) {
        com_google_android_gms_ads_internal_js_zzc.mo3935b("/loadAd", f17486f);
        com_google_android_gms_ads_internal_js_zzc.mo3935b("/fetchHttpRequest", f17485e);
        com_google_android_gms_ads_internal_js_zzc.mo3935b("/invalidRequest", f17487g);
    }

    public final void mo3384a() {
        zzakb.m5366b("SdkLessAdLoaderBackgroundTask started.");
        String i = zzbs.m4507z().m5104i(this.f17491k);
        zzaat com_google_android_gms_internal_zzaat = new zzaat(this.f17489i, -1, zzbs.m4507z().m5102g(this.f17491k), zzbs.m4507z().m5103h(this.f17491k), i);
        zzbs.m4507z().m5096c(this.f17491k, i);
        zzaax a = m17707a(com_google_android_gms_internal_zzaat);
        com_google_android_gms_internal_zzaat = com_google_android_gms_internal_zzaat;
        zzajr.f6473a.post(new zzabp(this, new zzafp(com_google_android_gms_internal_zzaat, a, a.f17444d, zzbs.m4492k().mo1633b(), a.f17453m, this.f17493m)));
    }

    public final void mo3385b() {
        synchronized (this.f17490j) {
            zzajr.f6473a.post(new zzabt(this));
        }
    }

    private final com.google.android.gms.internal.zzaax m17707a(com.google.android.gms.internal.zzaat r10) {
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
        r9 = this;
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r0 = com.google.android.gms.internal.zzahn.m5157a();
        r1 = r9.m17709a(r10, r0);
        r2 = 0;
        if (r1 != 0) goto L_0x0014;
    L_0x000e:
        r10 = new com.google.android.gms.internal.zzaax;
        r10.<init>(r2);
        return r10;
    L_0x0014:
        r3 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r3 = r3.mo1633b();
        r5 = f17486f;
        r6 = new com.google.android.gms.internal.zzalf;
        r6.<init>();
        r5 = r5.f13737a;
        r5.put(r0, r6);
        r5 = com.google.android.gms.internal.zzajr.f6473a;
        r7 = new com.google.android.gms.internal.zzabq;
        r7.<init>(r9, r1, r0);
        r5.post(r7);
        r0 = f17481a;
        r5 = com.google.android.gms.ads.internal.zzbs.m4492k();
        r7 = r5.mo1633b();
        r7 = r7 - r3;
        r0 = r0 - r7;
        r3 = -1;
        r4 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ CancellationException -> 0x007a, CancellationException -> 0x007a, TimeoutException -> 0x0073, ExecutionException -> 0x006d }
        r0 = r6.get(r0, r4);	 Catch:{ CancellationException -> 0x007a, CancellationException -> 0x007a, TimeoutException -> 0x0073, ExecutionException -> 0x006d }
        r0 = (org.json.JSONObject) r0;	 Catch:{ CancellationException -> 0x007a, CancellationException -> 0x007a, TimeoutException -> 0x0073, ExecutionException -> 0x006d }
        if (r0 != 0) goto L_0x004f;
    L_0x0049:
        r10 = new com.google.android.gms.internal.zzaax;
        r10.<init>(r3);
        return r10;
    L_0x004f:
        r1 = r9.f17491k;
        r0 = r0.toString();
        r10 = com.google.android.gms.internal.zzacg.m4987a(r1, r10, r0);
        r0 = r10.f17444d;
        r1 = -3;
        if (r0 == r1) goto L_0x006c;
    L_0x005e:
        r0 = r10.f17442b;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x006c;
    L_0x0066:
        r10 = new com.google.android.gms.internal.zzaax;
        r0 = 3;
        r10.<init>(r0);
    L_0x006c:
        return r10;
    L_0x006d:
        r10 = new com.google.android.gms.internal.zzaax;
        r10.<init>(r2);
        return r10;
    L_0x0073:
        r10 = new com.google.android.gms.internal.zzaax;
        r0 = 2;
        r10.<init>(r0);
        return r10;
    L_0x007a:
        r10 = new com.google.android.gms.internal.zzaax;
        r10.<init>(r3);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzabo.a(com.google.android.gms.internal.zzaat):com.google.android.gms.internal.zzaax");
    }
}
