package com.google.android.gms.internal;

public abstract class zzabc extends zzev implements zzabb {
    public zzabc() {
        attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public boolean onTransact(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:28:0x0073 in {2, 7, 10, 13, 14, 15, 17, 19, 22, 25, 26, 27} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r6 = r2.zza(r3, r4, r5, r6);
        r0 = 1;
        if (r6 == 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r6 = 4;
        r1 = 0;
        if (r3 == r6) goto L_0x004d;
    L_0x000c:
        switch(r3) {
            case 1: goto L_0x003a;
            case 2: goto L_0x0011;
            default: goto L_0x000f;
        };
    L_0x000f:
        r3 = 0;
        return r3;
    L_0x0011:
        r3 = com.google.android.gms.internal.zzaat.CREATOR;
        r3 = com.google.android.gms.internal.zzew.m5937a(r4, r3);
        r3 = (com.google.android.gms.internal.zzaat) r3;
        r4 = r4.readStrongBinder();
        if (r4 != 0) goto L_0x0020;
    L_0x001f:
        goto L_0x0033;
    L_0x0020:
        r6 = "com.google.android.gms.ads.internal.request.IAdResponseListener";
        r6 = r4.queryLocalInterface(r6);
        r1 = r6 instanceof com.google.android.gms.internal.zzabe;
        if (r1 == 0) goto L_0x002e;
    L_0x002a:
        r1 = r6;
        r1 = (com.google.android.gms.internal.zzabe) r1;
        goto L_0x0033;
    L_0x002e:
        r1 = new com.google.android.gms.internal.zzabg;
        r1.<init>(r4);
    L_0x0033:
        r2.mo1651a(r3, r1);
    L_0x0036:
        r5.writeNoException();
        return r0;
    L_0x003a:
        r3 = com.google.android.gms.internal.zzaat.CREATOR;
        r3 = com.google.android.gms.internal.zzew.m5937a(r4, r3);
        r3 = (com.google.android.gms.internal.zzaat) r3;
        r3 = r2.mo1650a(r3);
        r5.writeNoException();
        com.google.android.gms.internal.zzew.m5943b(r5, r3);
        return r0;
    L_0x004d:
        r3 = com.google.android.gms.internal.zzabm.CREATOR;
        r3 = com.google.android.gms.internal.zzew.m5937a(r4, r3);
        r3 = (com.google.android.gms.internal.zzabm) r3;
        r4 = r4.readStrongBinder();
        if (r4 != 0) goto L_0x005c;
    L_0x005b:
        goto L_0x006f;
    L_0x005c:
        r6 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener";
        r6 = r4.queryLocalInterface(r6);
        r1 = r6 instanceof com.google.android.gms.internal.zzabh;
        if (r1 == 0) goto L_0x006a;
    L_0x0066:
        r1 = r6;
        r1 = (com.google.android.gms.internal.zzabh) r1;
        goto L_0x006f;
    L_0x006a:
        r1 = new com.google.android.gms.internal.zzabi;
        r1.<init>(r4);
    L_0x006f:
        r2.mo1652a(r3, r1);
        goto L_0x0036;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzabc.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
