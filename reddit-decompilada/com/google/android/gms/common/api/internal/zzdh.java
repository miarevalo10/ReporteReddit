package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;

final class zzdh implements Runnable {
    private /* synthetic */ Result f5830a;
    private /* synthetic */ zzdg f5831b;

    zzdh(zzdg com_google_android_gms_common_api_internal_zzdg, Result result) {
        this.f5831b = com_google_android_gms_common_api_internal_zzdg;
        this.f5830a = result;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0077 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r2 = com.google.android.gms.common.api.internal.BasePendingResult.f13813c;	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r3 = java.lang.Boolean.valueOf(r0);	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r2.set(r3);	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r2 = r5.f5831b;	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r2 = r2.f13944a;	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r2 = r2.m4677a();	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r3 = r5.f5831b;	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r3 = r3.f13952i;	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r4 = r5.f5831b;	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r4 = r4.f13952i;	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r2 = r4.obtainMessage(r1, r2);	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r3.sendMessage(r2);	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r0 = com.google.android.gms.common.api.internal.BasePendingResult.f13813c;
        r1 = java.lang.Boolean.valueOf(r1);
        r0.set(r1);
        r0 = r5.f5831b;
        r0 = r0.f13949f;
        r0 = r0.get();
        r0 = (com.google.android.gms.common.api.GoogleApiClient) r0;
        if (r0 == 0) goto L_0x0044;
    L_0x003f:
        r1 = r5.f5831b;
        r0.mo1598b(r1);
    L_0x0044:
        return;
    L_0x0045:
        r0 = move-exception;
        goto L_0x0078;
    L_0x0047:
        r2 = move-exception;
        r3 = r5.f5831b;	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r3 = r3.f13952i;	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r4 = r5.f5831b;	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r4 = r4.f13952i;	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r0 = r4.obtainMessage(r0, r2);	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r3.sendMessage(r0);	 Catch:{ RuntimeException -> 0x0047, all -> 0x0045 }
        r0 = com.google.android.gms.common.api.internal.BasePendingResult.f13813c;
        r1 = java.lang.Boolean.valueOf(r1);
        r0.set(r1);
        r0 = r5.f5831b;
        r0 = r0.f13949f;
        r0 = r0.get();
        r0 = (com.google.android.gms.common.api.GoogleApiClient) r0;
        if (r0 == 0) goto L_0x0077;
    L_0x0072:
        r1 = r5.f5831b;
        r0.mo1598b(r1);
    L_0x0077:
        return;
    L_0x0078:
        r2 = com.google.android.gms.common.api.internal.BasePendingResult.f13813c;
        r1 = java.lang.Boolean.valueOf(r1);
        r2.set(r1);
        r1 = r5.f5831b;
        r1 = r1.f13949f;
        r1 = r1.get();
        r1 = (com.google.android.gms.common.api.GoogleApiClient) r1;
        if (r1 == 0) goto L_0x0094;
    L_0x008f:
        r2 = r5.f5831b;
        r1.mo1598b(r2);
    L_0x0094:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzdh.run():void");
    }
}
