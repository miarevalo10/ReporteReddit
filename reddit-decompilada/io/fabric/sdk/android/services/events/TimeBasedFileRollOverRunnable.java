package io.fabric.sdk.android.services.events;

import android.content.Context;

public class TimeBasedFileRollOverRunnable implements Runnable {
    private final Context f24838a;
    private final FileRollOverManager f24839b;

    public TimeBasedFileRollOverRunnable(Context context, FileRollOverManager fileRollOverManager) {
        this.f24838a = context;
        this.f24839b = fileRollOverManager;
    }

    public void run() {
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
        r0 = r2.f24838a;	 Catch:{ Exception -> 0x0015 }
        r1 = "Performing time based file roll over.";	 Catch:{ Exception -> 0x0015 }
        io.fabric.sdk.android.services.common.CommonUtils.m26292a(r0, r1);	 Catch:{ Exception -> 0x0015 }
        r0 = r2.f24839b;	 Catch:{ Exception -> 0x0015 }
        r0 = r0.rollFileOver();	 Catch:{ Exception -> 0x0015 }
        if (r0 != 0) goto L_0x0014;	 Catch:{ Exception -> 0x0015 }
    L_0x000f:
        r0 = r2.f24839b;	 Catch:{ Exception -> 0x0015 }
        r0.cancelTimeBasedFileRollOver();	 Catch:{ Exception -> 0x0015 }
    L_0x0014:
        return;
    L_0x0015:
        r0 = r2.f24838a;
        r1 = "Failed to roll over file";
        io.fabric.sdk.android.services.common.CommonUtils.m26302b(r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.events.TimeBasedFileRollOverRunnable.run():void");
    }
}
