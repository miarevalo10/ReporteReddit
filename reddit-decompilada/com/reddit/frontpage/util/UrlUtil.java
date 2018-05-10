package com.reddit.frontpage.util;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/reddit/frontpage/util/UrlUtil;", "", "()V", "REQUEST_METHOD", "", "SUCCESS_RESPONSE_CODE", "", "TIME_INTERVAL_MILLIS", "", "isUrlReachable", "", "url", "numberOfAttempts", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: UrlUtil.kt */
public final class UrlUtil {
    public static final UrlUtil f21807a = new UrlUtil();

    private UrlUtil() {
    }

    public static final boolean m23948a(String str) {
        for (int i = 0; i < 5; i++) {
            if (i != 0) {
                Thread.sleep(5000);
            }
            if (m23949b(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean m23949b(java.lang.String r2) {
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
        r1 = new java.net.URL;	 Catch:{ Exception -> 0x0026 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0026 }
        r2 = r1.openConnection();	 Catch:{ Exception -> 0x0026 }
        if (r2 != 0) goto L_0x0014;	 Catch:{ Exception -> 0x0026 }
    L_0x000c:
        r2 = new kotlin.TypeCastException;	 Catch:{ Exception -> 0x0026 }
        r1 = "null cannot be cast to non-null type java.net.HttpURLConnection";	 Catch:{ Exception -> 0x0026 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0026 }
        throw r2;	 Catch:{ Exception -> 0x0026 }
    L_0x0014:
        r2 = (java.net.HttpURLConnection) r2;	 Catch:{ Exception -> 0x0026 }
        r1 = "HEAD";
        r2.setRequestMethod(r1);
        r2 = r2.getResponseCode();
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r1) goto L_0x0025;
    L_0x0023:
        r2 = 1;
        return r2;
    L_0x0025:
        return r0;
    L_0x0026:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reddit.frontpage.util.UrlUtil.b(java.lang.String):boolean");
    }
}
