package com.google.android.gms.ads.internal;

import android.os.AsyncTask;

final class zzbq extends AsyncTask<Void, Void, String> {
    private /* synthetic */ zzbm f5545a;

    private zzbq(zzbm com_google_android_gms_ads_internal_zzbm) {
        this.f5545a = com_google_android_gms_ads_internal_zzbm;
    }

    private final java.lang.String m4477a() {
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
        r0 = r5.f5545a;	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        r1 = r5.f5545a;	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        r1 = r1.f17187c;	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        r2 = com.google.android.gms.internal.zznh.cj;	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        r3 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        r2 = r3.m6488a(r2);	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        r2 = (java.lang.Long) r2;	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        r2 = r2.longValue();	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        r4 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        r1 = r1.get(r2, r4);	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        r1 = (com.google.android.gms.internal.zzcv) r1;	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        r0.f17192h = r1;	 Catch:{ InterruptedException -> 0x002a, InterruptedException -> 0x002a, TimeoutException -> 0x0024 }
        goto L_0x0030;
    L_0x0024:
        r0 = "Timed out waiting for ad data";
        com.google.android.gms.internal.zzakb.m5371e(r0);
        goto L_0x0030;
    L_0x002a:
        r0 = move-exception;
        r1 = "Failed to load ad data";
        com.google.android.gms.internal.zzakb.m5369c(r1, r0);
    L_0x0030:
        r0 = r5.f5545a;
        r0 = r0.m17546c();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzbq.a():java.lang.String");
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return m4477a();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (this.f5545a.f17190f != null && str != null) {
            this.f5545a.f17190f.loadUrl(str);
        }
    }
}
