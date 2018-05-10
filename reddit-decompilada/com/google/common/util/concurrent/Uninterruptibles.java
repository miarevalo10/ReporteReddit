package com.google.common.util.concurrent;

public final class Uninterruptibles {
    public static <V> V m7340a(java.util.concurrent.Future<V> r2) throws java.util.concurrent.ExecutionException {
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
    L_0x0001:
        r1 = r2.get();	 Catch:{ InterruptedException -> 0x001a, all -> 0x000f }
        if (r0 == 0) goto L_0x000e;
    L_0x0007:
        r2 = java.lang.Thread.currentThread();
        r2.interrupt();
    L_0x000e:
        return r1;
    L_0x000f:
        r2 = move-exception;
        if (r0 == 0) goto L_0x0019;
    L_0x0012:
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
    L_0x0019:
        throw r2;
    L_0x001a:
        r0 = 1;
        goto L_0x0001;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.a(java.util.concurrent.Future):V");
    }
}
