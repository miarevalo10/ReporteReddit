package io.branch.referral;

class BranchUtil {
    static boolean f24519a = false;

    public static boolean m26108a(android.content.Context r5) {
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
        r0 = f24519a;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r5 = f24519a;
        return r5;
    L_0x0007:
        r0 = "io.branch.sdk.TestMode";
        r1 = 0;
        r2 = r5.getPackageManager();	 Catch:{ Exception -> 0x0042 }
        r3 = r5.getPackageName();	 Catch:{ Exception -> 0x0042 }
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x0042 }
        r2 = r2.getApplicationInfo(r3, r4);	 Catch:{ Exception -> 0x0042 }
        r3 = r2.metaData;	 Catch:{ Exception -> 0x0042 }
        if (r3 == 0) goto L_0x002b;	 Catch:{ Exception -> 0x0042 }
    L_0x001c:
        r3 = r2.metaData;	 Catch:{ Exception -> 0x0042 }
        r3 = r3.containsKey(r0);	 Catch:{ Exception -> 0x0042 }
        if (r3 == 0) goto L_0x002b;	 Catch:{ Exception -> 0x0042 }
    L_0x0024:
        r5 = r2.metaData;	 Catch:{ Exception -> 0x0042 }
        r5 = r5.getBoolean(r0, r1);	 Catch:{ Exception -> 0x0042 }
        goto L_0x0043;	 Catch:{ Exception -> 0x0042 }
    L_0x002b:
        r2 = r5.getResources();	 Catch:{ Exception -> 0x0042 }
        r3 = "string";	 Catch:{ Exception -> 0x0042 }
        r5 = r5.getPackageName();	 Catch:{ Exception -> 0x0042 }
        r5 = r2.getIdentifier(r0, r3, r5);	 Catch:{ Exception -> 0x0042 }
        r5 = r2.getString(r5);	 Catch:{ Exception -> 0x0042 }
        r5 = java.lang.Boolean.parseBoolean(r5);	 Catch:{ Exception -> 0x0042 }
        goto L_0x0043;
    L_0x0042:
        r5 = r1;
    L_0x0043:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchUtil.a(android.content.Context):boolean");
    }
}
