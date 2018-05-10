package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzadl extends zzev implements zzadk {
    public zzadl() {
        attachInterface(this, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzadk m13171a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        return queryLocalInterface instanceof zzadk ? (zzadk) queryLocalInterface : new zzadm(iBinder);
    }

    public boolean onTransact(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:33:0x009e in {2, 8, 9, 11, 12, 13, 14, 15, 16, 17, 19, 22, 25, 26, 27, 28, 29, 31, 32} preds:[]
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
        r1 = this;
        r5 = r1.zza(r2, r3, r4, r5);
        r0 = 1;
        if (r5 == 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r5 = 34;
        if (r2 == r5) goto L_0x0096;
    L_0x000c:
        switch(r2) {
            case 1: goto L_0x0087;
            case 2: goto L_0x0083;
            case 3: goto L_0x0063;
            default: goto L_0x000f;
        };
    L_0x000f:
        switch(r2) {
            case 5: goto L_0x0058;
            case 6: goto L_0x0054;
            case 7: goto L_0x0050;
            case 8: goto L_0x004c;
            case 9: goto L_0x0040;
            case 10: goto L_0x0034;
            case 11: goto L_0x0028;
            case 12: goto L_0x001d;
            case 13: goto L_0x0014;
            default: goto L_0x0012;
        };
    L_0x0012:
        r2 = 0;
        return r2;
    L_0x0014:
        r2 = r3.readString();
        r1.mo1665a(r2);
        goto L_0x0092;
    L_0x001d:
        r2 = r1.mo1673f();
        r4.writeNoException();
        r4.writeString(r2);
        return r0;
    L_0x0028:
        r2 = r3.readStrongBinder();
        r2 = com.google.android.gms.dynamic.IObjectWrapper.zza.m13115a(r2);
        r1.mo1670c(r2);
        goto L_0x0092;
    L_0x0034:
        r2 = r3.readStrongBinder();
        r2 = com.google.android.gms.dynamic.IObjectWrapper.zza.m13115a(r2);
        r1.mo1667b(r2);
        goto L_0x0092;
    L_0x0040:
        r2 = r3.readStrongBinder();
        r2 = com.google.android.gms.dynamic.IObjectWrapper.zza.m13115a(r2);
        r1.mo1662a(r2);
        goto L_0x0092;
    L_0x004c:
        r1.mo1672e();
        goto L_0x0092;
    L_0x0050:
        r1.mo1671d();
        goto L_0x0092;
    L_0x0054:
        r1.mo1669c();
        goto L_0x0092;
    L_0x0058:
        r2 = r1.mo1668b();
        r4.writeNoException();
        com.google.android.gms.internal.zzew.m5940a(r4, r2);
        return r0;
    L_0x0063:
        r2 = r3.readStrongBinder();
        if (r2 != 0) goto L_0x006b;
    L_0x0069:
        r2 = 0;
        goto L_0x007f;
    L_0x006b:
        r3 = "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener";
        r3 = r2.queryLocalInterface(r3);
        r5 = r3 instanceof com.google.android.gms.internal.zzadp;
        if (r5 == 0) goto L_0x0079;
    L_0x0075:
        r2 = r3;
        r2 = (com.google.android.gms.internal.zzadp) r2;
        goto L_0x007f;
    L_0x0079:
        r3 = new com.google.android.gms.internal.zzadr;
        r3.<init>(r2);
        r2 = r3;
    L_0x007f:
        r1.mo1663a(r2);
        goto L_0x0092;
    L_0x0083:
        r1.mo1661a();
        goto L_0x0092;
    L_0x0087:
        r2 = com.google.android.gms.internal.zzadv.CREATOR;
        r2 = com.google.android.gms.internal.zzew.m5937a(r3, r2);
        r2 = (com.google.android.gms.internal.zzadv) r2;
        r1.mo1664a(r2);
    L_0x0092:
        r4.writeNoException();
        return r0;
    L_0x0096:
        r2 = com.google.android.gms.internal.zzew.m5941a(r3);
        r1.mo1666a(r2);
        goto L_0x0092;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzadl.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
