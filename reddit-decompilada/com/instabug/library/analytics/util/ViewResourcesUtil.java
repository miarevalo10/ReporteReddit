package com.instabug.library.analytics.util;

public class ViewResourcesUtil {
    public static java.lang.String getViewResourceIdAsString(android.content.Context r1, int r2) {
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
        if (r1 == 0) goto L_0x001b;
    L_0x0002:
        r0 = r1.getResources();	 Catch:{ NotFoundException -> 0x0020 }
        if (r0 == 0) goto L_0x001b;	 Catch:{ NotFoundException -> 0x0020 }
    L_0x0008:
        r0 = r1.getResources();	 Catch:{ NotFoundException -> 0x0020 }
        r0 = r0.getResourceEntryName(r2);	 Catch:{ NotFoundException -> 0x0020 }
        if (r0 == 0) goto L_0x001b;	 Catch:{ NotFoundException -> 0x0020 }
    L_0x0012:
        r1 = r1.getResources();	 Catch:{ NotFoundException -> 0x0020 }
        r1 = r1.getResourceEntryName(r2);	 Catch:{ NotFoundException -> 0x0020 }
        return r1;	 Catch:{ NotFoundException -> 0x0020 }
    L_0x001b:
        r1 = java.lang.String.valueOf(r2);	 Catch:{ NotFoundException -> 0x0020 }
        return r1;
    L_0x0020:
        r1 = java.lang.String.valueOf(r2);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.analytics.util.ViewResourcesUtil.getViewResourceIdAsString(android.content.Context, int):java.lang.String");
    }
}
