package com.google.android.gms.internal;

import android.webkit.ValueCallback;

final class zzhn implements ValueCallback<String> {
    private /* synthetic */ zzhm f7693a;

    zzhn(zzhm com_google_android_gms_internal_zzhm) {
        this.f7693a = com_google_android_gms_internal_zzhm;
    }

    public final /* synthetic */ void onReceiveValue(java.lang.Object r10) {
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
        r9 = this;
        r10 = (java.lang.String) r10;
        r0 = r9.f7693a;
        r0 = r0.f7691d;
        r1 = r9.f7693a;
        r1 = r1.f7688a;
        r2 = r9.f7693a;
        r2 = r2.f7689b;
        r3 = r9.f7693a;
        r4 = r3.f7690c;
        r3 = r1.f7637a;
        monitor-enter(r3);
        r5 = r1.f7640d;	 Catch:{ all -> 0x00ae }
        r6 = 1;	 Catch:{ all -> 0x00ae }
        r5 = r5 - r6;	 Catch:{ all -> 0x00ae }
        r1.f7640d = r5;	 Catch:{ all -> 0x00ae }
        monitor-exit(r3);	 Catch:{ all -> 0x00ae }
        r3 = android.text.TextUtils.isEmpty(r10);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        if (r3 != 0) goto L_0x008e;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
    L_0x0022:
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r3.<init>(r10);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r10 = "text";	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r3 = r3.optString(r10);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r10 = r0.f7681l;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        if (r10 != 0) goto L_0x007c;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
    L_0x0031:
        r10 = r2.getTitle();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r10 = android.text.TextUtils.isEmpty(r10);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        if (r10 != 0) goto L_0x007c;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
    L_0x003b:
        r10 = r2.getTitle();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r5 = java.lang.String.valueOf(r10);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r5 = r5.length();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r6 = r6 + r5;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r5 = java.lang.String.valueOf(r3);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r5 = r5.length();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r6 = r6 + r5;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r5 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r5.<init>(r6);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r5.append(r10);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r10 = "\n";	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r5.append(r10);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r5.append(r3);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r3 = r5.toString();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r5 = r2.getX();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r6 = r2.getY();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r10 = r2.getWidth();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r7 = (float) r10;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r10 = r2.getHeight();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
    L_0x0076:
        r8 = (float) r10;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r2 = r1;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r2.m6274a(r3, r4, r5, r6, r7, r8);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        goto L_0x008e;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
    L_0x007c:
        r5 = r2.getX();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r6 = r2.getY();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r10 = r2.getWidth();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r7 = (float) r10;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r10 = r2.getHeight();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        goto L_0x0076;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
    L_0x008e:
        r10 = r1.m6275a();	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        if (r10 == 0) goto L_0x0099;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
    L_0x0094:
        r10 = r0.f7672c;	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
        r10.m6281b(r1);	 Catch:{ JSONException -> 0x00a8, Throwable -> 0x009a }
    L_0x0099:
        return;
    L_0x009a:
        r10 = move-exception;
        r1 = "Failed to get webview content.";
        com.google.android.gms.internal.zzakb.m5364a(r1, r10);
        r0 = r0.f7673d;
        r1 = "ContentFetchTask.processWebViewContent";
        r0.mo2296a(r10, r1);
        return;
    L_0x00a8:
        r10 = "Json string may be malformed.";
        com.google.android.gms.internal.zzakb.m5366b(r10);
        return;
    L_0x00ae:
        r10 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x00ae }
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhn.onReceiveValue(java.lang.Object):void");
    }
}
