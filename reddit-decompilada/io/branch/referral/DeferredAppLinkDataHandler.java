package io.branch.referral;

class DeferredAppLinkDataHandler {

    public interface AppLinkFetchEvents {
        void mo5540a(String str);
    }

    public static java.lang.Boolean m26137a(android.content.Context r10, final io.branch.referral.DeferredAppLinkDataHandler.AppLinkFetchEvents r11) {
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
        r0 = 1;
        r1 = 0;
        r2 = "com.facebook.FacebookSdk";	 Catch:{ Throwable -> 0x0074 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x0074 }
        r3 = "sdkInitialize";	 Catch:{ Throwable -> 0x0074 }
        r4 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0074 }
        r5 = android.content.Context.class;	 Catch:{ Throwable -> 0x0074 }
        r4[r1] = r5;	 Catch:{ Throwable -> 0x0074 }
        r2 = r2.getMethod(r3, r4);	 Catch:{ Throwable -> 0x0074 }
        r3 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0074 }
        r3[r1] = r10;	 Catch:{ Throwable -> 0x0074 }
        r4 = 0;	 Catch:{ Throwable -> 0x0074 }
        r2.invoke(r4, r3);	 Catch:{ Throwable -> 0x0074 }
        r2 = "com.facebook.applinks.AppLinkData";	 Catch:{ Throwable -> 0x0074 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x0074 }
        r3 = "com.facebook.applinks.AppLinkData$CompletionHandler";	 Catch:{ Throwable -> 0x0074 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0074 }
        r5 = "fetchDeferredAppLinkData";	 Catch:{ Throwable -> 0x0074 }
        r6 = 3;	 Catch:{ Throwable -> 0x0074 }
        r7 = new java.lang.Class[r6];	 Catch:{ Throwable -> 0x0074 }
        r8 = android.content.Context.class;	 Catch:{ Throwable -> 0x0074 }
        r7[r1] = r8;	 Catch:{ Throwable -> 0x0074 }
        r8 = java.lang.String.class;	 Catch:{ Throwable -> 0x0074 }
        r7[r0] = r8;	 Catch:{ Throwable -> 0x0074 }
        r8 = 2;	 Catch:{ Throwable -> 0x0074 }
        r7[r8] = r3;	 Catch:{ Throwable -> 0x0074 }
        r5 = r2.getMethod(r5, r7);	 Catch:{ Throwable -> 0x0074 }
        r7 = new io.branch.referral.DeferredAppLinkDataHandler$1;	 Catch:{ Throwable -> 0x0074 }
        r7.<init>(r2, r11);	 Catch:{ Throwable -> 0x0074 }
        r11 = r3.getClassLoader();	 Catch:{ Throwable -> 0x0074 }
        r2 = new java.lang.Class[r0];	 Catch:{ Throwable -> 0x0074 }
        r2[r1] = r3;	 Catch:{ Throwable -> 0x0074 }
        r11 = java.lang.reflect.Proxy.newProxyInstance(r11, r2, r7);	 Catch:{ Throwable -> 0x0074 }
        r2 = r10.getResources();	 Catch:{ Throwable -> 0x0074 }
        r3 = "facebook_app_id";	 Catch:{ Throwable -> 0x0074 }
        r7 = "string";	 Catch:{ Throwable -> 0x0074 }
        r9 = r10.getPackageName();	 Catch:{ Throwable -> 0x0074 }
        r2 = r2.getIdentifier(r3, r7, r9);	 Catch:{ Throwable -> 0x0074 }
        r2 = r10.getString(r2);	 Catch:{ Throwable -> 0x0074 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0074 }
        if (r3 == 0) goto L_0x0068;	 Catch:{ Throwable -> 0x0074 }
    L_0x0067:
        goto L_0x0074;	 Catch:{ Throwable -> 0x0074 }
    L_0x0068:
        r3 = new java.lang.Object[r6];	 Catch:{ Throwable -> 0x0074 }
        r3[r1] = r10;	 Catch:{ Throwable -> 0x0074 }
        r3[r0] = r2;	 Catch:{ Throwable -> 0x0074 }
        r3[r8] = r11;	 Catch:{ Throwable -> 0x0074 }
        r5.invoke(r4, r3);	 Catch:{ Throwable -> 0x0074 }
        r1 = r0;
    L_0x0074:
        r10 = java.lang.Boolean.valueOf(r1);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.DeferredAppLinkDataHandler.a(android.content.Context, io.branch.referral.DeferredAppLinkDataHandler$AppLinkFetchEvents):java.lang.Boolean");
    }
}
