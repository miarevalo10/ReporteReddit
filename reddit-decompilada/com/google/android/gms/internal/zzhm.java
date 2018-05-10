package com.google.android.gms.internal;

import android.webkit.ValueCallback;
import android.webkit.WebView;

final class zzhm implements Runnable {
    final /* synthetic */ zzhe f7688a;
    final /* synthetic */ WebView f7689b;
    final /* synthetic */ boolean f7690c;
    final /* synthetic */ zzhk f7691d;
    private ValueCallback<String> f7692e = new zzhn(this);

    zzhm(zzhk com_google_android_gms_internal_zzhk, zzhe com_google_android_gms_internal_zzhe, WebView webView, boolean z) {
        this.f7691d = com_google_android_gms_internal_zzhk;
        this.f7688a = com_google_android_gms_internal_zzhe;
        this.f7689b = webView;
        this.f7690c = z;
    }

    public final void run() {
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
        r3 = this;
        r0 = r3.f7689b;
        r0 = r0.getSettings();
        r0 = r0.getJavaScriptEnabled();
        if (r0 == 0) goto L_0x001d;
    L_0x000c:
        r0 = r3.f7689b;	 Catch:{ Throwable -> 0x0016 }
        r1 = "(function() { return  {text:document.body.innerText}})();";	 Catch:{ Throwable -> 0x0016 }
        r2 = r3.f7692e;	 Catch:{ Throwable -> 0x0016 }
        r0.evaluateJavascript(r1, r2);	 Catch:{ Throwable -> 0x0016 }
        return;
    L_0x0016:
        r0 = r3.f7692e;
        r1 = "";
        r0.onReceiveValue(r1);
    L_0x001d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhm.run():void");
    }
}
