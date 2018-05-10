package com.google.android.gms.internal;

import java.util.concurrent.BlockingQueue;

public final class zzd extends Thread {
    private static final boolean f7204a = zzae.f6235a;
    private final BlockingQueue<zzr<?>> f7205b;
    private final BlockingQueue<zzr<?>> f7206c;
    private final zzb f7207d;
    private final zzz f7208e;
    private volatile boolean f7209f = false;
    private final zzf f7210g;

    public zzd(BlockingQueue<zzr<?>> blockingQueue, BlockingQueue<zzr<?>> blockingQueue2, zzb com_google_android_gms_internal_zzb, zzz com_google_android_gms_internal_zzz) {
        this.f7205b = blockingQueue;
        this.f7206c = blockingQueue2;
        this.f7207d = com_google_android_gms_internal_zzb;
        this.f7208e = com_google_android_gms_internal_zzz;
        this.f7210g = new zzf(this);
    }

    public final void m5832a() {
        this.f7209f = true;
        interrupt();
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
        r8 = this;
        r0 = f7204a;
        r1 = 0;
        if (r0 == 0) goto L_0x000c;
    L_0x0005:
        r0 = "start new dispatcher";
        r2 = new java.lang.Object[r1];
        com.google.android.gms.internal.zzae.m5041a(r0, r2);
    L_0x000c:
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
        r0 = r8.f7207d;
        r0.mo1734a();
    L_0x0016:
        r0 = r8.f7205b;	 Catch:{ InterruptedException -> 0x00ac }
        r0 = r0.take();	 Catch:{ InterruptedException -> 0x00ac }
        r0 = (com.google.android.gms.internal.zzr) r0;	 Catch:{ InterruptedException -> 0x00ac }
        r2 = "cache-queue-take";	 Catch:{ InterruptedException -> 0x00ac }
        r0.m6628b(r2);	 Catch:{ InterruptedException -> 0x00ac }
        r2 = r8.f7207d;	 Catch:{ InterruptedException -> 0x00ac }
        r3 = r0.f7967b;	 Catch:{ InterruptedException -> 0x00ac }
        r2 = r2.mo1733a(r3);	 Catch:{ InterruptedException -> 0x00ac }
        if (r2 != 0) goto L_0x0040;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x002d:
        r2 = "cache-miss";	 Catch:{ InterruptedException -> 0x00ac }
        r0.m6628b(r2);	 Catch:{ InterruptedException -> 0x00ac }
        r2 = r8.f7210g;	 Catch:{ InterruptedException -> 0x00ac }
        r2 = r2.m13736b(r0);	 Catch:{ InterruptedException -> 0x00ac }
        if (r2 != 0) goto L_0x0016;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x003a:
        r2 = r8.f7206c;	 Catch:{ InterruptedException -> 0x00ac }
        r2.put(r0);	 Catch:{ InterruptedException -> 0x00ac }
        goto L_0x0016;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x0040:
        r3 = r2.m5591a();	 Catch:{ InterruptedException -> 0x00ac }
        if (r3 == 0) goto L_0x005b;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x0046:
        r3 = "cache-hit-expired";	 Catch:{ InterruptedException -> 0x00ac }
        r0.m6628b(r3);	 Catch:{ InterruptedException -> 0x00ac }
        r0.f7975j = r2;	 Catch:{ InterruptedException -> 0x00ac }
        r2 = r8.f7210g;	 Catch:{ InterruptedException -> 0x00ac }
        r2 = r2.m13736b(r0);	 Catch:{ InterruptedException -> 0x00ac }
        if (r2 != 0) goto L_0x0016;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x0055:
        r2 = r8.f7206c;	 Catch:{ InterruptedException -> 0x00ac }
        r2.put(r0);	 Catch:{ InterruptedException -> 0x00ac }
        goto L_0x0016;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x005b:
        r3 = "cache-hit";	 Catch:{ InterruptedException -> 0x00ac }
        r0.m6628b(r3);	 Catch:{ InterruptedException -> 0x00ac }
        r3 = new com.google.android.gms.internal.zzp;	 Catch:{ InterruptedException -> 0x00ac }
        r4 = r2.f6721a;	 Catch:{ InterruptedException -> 0x00ac }
        r5 = r2.f6727g;	 Catch:{ InterruptedException -> 0x00ac }
        r3.<init>(r4, r5);	 Catch:{ InterruptedException -> 0x00ac }
        r3 = r0.mo1727a(r3);	 Catch:{ InterruptedException -> 0x00ac }
        r4 = "cache-hit-parsed";	 Catch:{ InterruptedException -> 0x00ac }
        r0.m6628b(r4);	 Catch:{ InterruptedException -> 0x00ac }
        r4 = r2.f6726f;	 Catch:{ InterruptedException -> 0x00ac }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ InterruptedException -> 0x00ac }
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ InterruptedException -> 0x00ac }
        r5 = 1;	 Catch:{ InterruptedException -> 0x00ac }
        if (r4 >= 0) goto L_0x007f;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x007d:
        r4 = r5;	 Catch:{ InterruptedException -> 0x00ac }
        goto L_0x0080;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x007f:
        r4 = r1;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x0080:
        if (r4 != 0) goto L_0x0088;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x0082:
        r2 = r8.f7208e;	 Catch:{ InterruptedException -> 0x00ac }
        r2.mo1955a(r0, r3);	 Catch:{ InterruptedException -> 0x00ac }
        goto L_0x0016;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x0088:
        r4 = "cache-hit-refresh-needed";	 Catch:{ InterruptedException -> 0x00ac }
        r0.m6628b(r4);	 Catch:{ InterruptedException -> 0x00ac }
        r0.f7975j = r2;	 Catch:{ InterruptedException -> 0x00ac }
        r3.f8111d = r5;	 Catch:{ InterruptedException -> 0x00ac }
        r2 = r8.f7210g;	 Catch:{ InterruptedException -> 0x00ac }
        r2 = r2.m13736b(r0);	 Catch:{ InterruptedException -> 0x00ac }
        if (r2 != 0) goto L_0x00a5;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x0099:
        r2 = r8.f7208e;	 Catch:{ InterruptedException -> 0x00ac }
        r4 = new com.google.android.gms.internal.zze;	 Catch:{ InterruptedException -> 0x00ac }
        r4.<init>(r8, r0);	 Catch:{ InterruptedException -> 0x00ac }
        r2.mo1956a(r0, r3, r4);	 Catch:{ InterruptedException -> 0x00ac }
        goto L_0x0016;	 Catch:{ InterruptedException -> 0x00ac }
    L_0x00a5:
        r2 = r8.f7208e;	 Catch:{ InterruptedException -> 0x00ac }
        r2.mo1955a(r0, r3);	 Catch:{ InterruptedException -> 0x00ac }
        goto L_0x0016;
    L_0x00ac:
        r0 = r8.f7209f;
        if (r0 == 0) goto L_0x0016;
    L_0x00b0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzd.run():void");
    }
}
