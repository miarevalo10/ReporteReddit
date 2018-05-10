package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzlm extends zzev implements zzll {
    public zzlm() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzll m14064a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return queryLocalInterface instanceof zzll ? (zzll) queryLocalInterface : new zzln(iBinder);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTransact(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
        r1 = this;
        r5 = r1.zza(r2, r3, r4, r5);
        r0 = 1;
        if (r5 == 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        switch(r2) {
            case 1: goto L_0x0079;
            case 2: goto L_0x0075;
            case 3: goto L_0x006d;
            case 4: goto L_0x0062;
            case 5: goto L_0x0057;
            case 6: goto L_0x004c;
            case 7: goto L_0x0047;
            case 8: goto L_0x0027;
            case 9: goto L_0x0022;
            case 10: goto L_0x001d;
            case 11: goto L_0x0012;
            case 12: goto L_0x000d;
            default: goto L_0x000b;
        };
    L_0x000b:
        r2 = 0;
        return r2;
    L_0x000d:
        r2 = r1.mo2049j();
        goto L_0x0066;
    L_0x0012:
        r2 = r1.mo2047h();
        r4.writeNoException();
        com.google.android.gms.internal.zzew.m5938a(r4, r2);
        return r0;
    L_0x001d:
        r2 = r1.mo2048i();
        goto L_0x0066;
    L_0x0022:
        r2 = r1.mo2044e();
        goto L_0x0050;
    L_0x0027:
        r2 = r3.readStrongBinder();
        if (r2 != 0) goto L_0x002f;
    L_0x002d:
        r2 = 0;
        goto L_0x0043;
    L_0x002f:
        r3 = "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks";
        r3 = r2.queryLocalInterface(r3);
        r5 = r3 instanceof com.google.android.gms.internal.zzlo;
        if (r5 == 0) goto L_0x003d;
    L_0x0039:
        r2 = r3;
        r2 = (com.google.android.gms.internal.zzlo) r2;
        goto L_0x0043;
    L_0x003d:
        r3 = new com.google.android.gms.internal.zzlq;
        r3.<init>(r2);
        r2 = r3;
    L_0x0043:
        r1.mo2039a(r2);
        goto L_0x007c;
    L_0x0047:
        r2 = r1.mo2046g();
        goto L_0x0050;
    L_0x004c:
        r2 = r1.mo2045f();
    L_0x0050:
        r4.writeNoException();
        r4.writeFloat(r2);
        return r0;
    L_0x0057:
        r2 = r1.mo2043d();
        r4.writeNoException();
        r4.writeInt(r2);
        return r0;
    L_0x0062:
        r2 = r1.mo2042c();
    L_0x0066:
        r4.writeNoException();
        com.google.android.gms.internal.zzew.m5940a(r4, r2);
        return r0;
    L_0x006d:
        r2 = com.google.android.gms.internal.zzew.m5941a(r3);
        r1.mo2040a(r2);
        goto L_0x007c;
    L_0x0075:
        r1.mo2041b();
        goto L_0x007c;
    L_0x0079:
        r1.mo2038a();
    L_0x007c:
        r4.writeNoException();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlm.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
