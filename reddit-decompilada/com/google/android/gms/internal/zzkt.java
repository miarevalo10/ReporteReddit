package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzkt extends zzev implements zzks {
    public zzkt() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzks m14021a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new zzku(iBinder);
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
        r5 = 0;
        switch(r2) {
            case 1: goto L_0x0171;
            case 2: goto L_0x016a;
            case 3: goto L_0x015f;
            case 4: goto L_0x0152;
            case 5: goto L_0x014e;
            case 6: goto L_0x014a;
            case 7: goto L_0x012c;
            case 8: goto L_0x010e;
            case 9: goto L_0x010a;
            case 10: goto L_0x0105;
            case 11: goto L_0x0100;
            case 12: goto L_0x00f5;
            case 13: goto L_0x00e8;
            case 14: goto L_0x00db;
            case 15: goto L_0x00ca;
            case 16: goto L_0x000c;
            case 17: goto L_0x000c;
            case 18: goto L_0x00bf;
            case 19: goto L_0x00b2;
            case 20: goto L_0x0093;
            case 21: goto L_0x0074;
            case 22: goto L_0x006b;
            case 23: goto L_0x0065;
            case 24: goto L_0x0058;
            case 25: goto L_0x004f;
            case 26: goto L_0x0049;
            case 27: goto L_0x000c;
            case 28: goto L_0x000c;
            case 29: goto L_0x003c;
            case 30: goto L_0x002f;
            case 31: goto L_0x0029;
            case 32: goto L_0x0023;
            case 33: goto L_0x001d;
            case 34: goto L_0x0014;
            case 35: goto L_0x000e;
            default: goto L_0x000c;
        };
    L_0x000c:
        r2 = 0;
        return r2;
    L_0x000e:
        r2 = r1.g_();
        goto L_0x00c3;
    L_0x0014:
        r2 = com.google.android.gms.internal.zzew.m5941a(r3);
        r1.mo2004c(r2);
        goto L_0x016d;
    L_0x001d:
        r2 = r1.mo1987C();
        goto L_0x0175;
    L_0x0023:
        r2 = r1.mo1986B();
        goto L_0x0175;
    L_0x0029:
        r2 = r1.mo1985A();
        goto L_0x00c3;
    L_0x002f:
        r2 = com.google.android.gms.internal.zzlr.CREATOR;
        r2 = com.google.android.gms.internal.zzew.m5937a(r3, r2);
        r2 = (com.google.android.gms.internal.zzlr) r2;
        r1.mo1996a(r2);
        goto L_0x016d;
    L_0x003c:
        r2 = com.google.android.gms.internal.zzmr.CREATOR;
        r2 = com.google.android.gms.internal.zzew.m5937a(r3, r2);
        r2 = (com.google.android.gms.internal.zzmr) r2;
        r1.mo1997a(r2);
        goto L_0x016d;
    L_0x0049:
        r2 = r1.mo2015r();
        goto L_0x0175;
    L_0x004f:
        r2 = r3.readString();
        r1.mo2001a(r2);
        goto L_0x016d;
    L_0x0058:
        r2 = r3.readStrongBinder();
        r2 = com.google.android.gms.internal.zzadq.m13185a(r2);
        r1.mo1990a(r2);
        goto L_0x016d;
    L_0x0065:
        r2 = r1.mo2014q();
        goto L_0x0163;
    L_0x006b:
        r2 = com.google.android.gms.internal.zzew.m5941a(r3);
        r1.mo2002b(r2);
        goto L_0x016d;
    L_0x0074:
        r2 = r3.readStrongBinder();
        if (r2 != 0) goto L_0x007b;
    L_0x007a:
        goto L_0x008e;
    L_0x007b:
        r3 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider";
        r3 = r2.queryLocalInterface(r3);
        r5 = r3 instanceof com.google.android.gms.internal.zzld;
        if (r5 == 0) goto L_0x0089;
    L_0x0085:
        r5 = r3;
        r5 = (com.google.android.gms.internal.zzld) r5;
        goto L_0x008e;
    L_0x0089:
        r5 = new com.google.android.gms.internal.zzlf;
        r5.<init>(r2);
    L_0x008e:
        r1.mo1995a(r5);
        goto L_0x016d;
    L_0x0093:
        r2 = r3.readStrongBinder();
        if (r2 != 0) goto L_0x009a;
    L_0x0099:
        goto L_0x00ad;
    L_0x009a:
        r3 = "com.google.android.gms.ads.internal.client.IAdClickListener";
        r3 = r2.queryLocalInterface(r3);
        r5 = r3 instanceof com.google.android.gms.internal.zzke;
        if (r5 == 0) goto L_0x00a8;
    L_0x00a4:
        r5 = r3;
        r5 = (com.google.android.gms.internal.zzke) r5;
        goto L_0x00ad;
    L_0x00a8:
        r5 = new com.google.android.gms.internal.zzkg;
        r5.<init>(r2);
    L_0x00ad:
        r1.mo1992a(r5);
        goto L_0x016d;
    L_0x00b2:
        r2 = r3.readStrongBinder();
        r2 = com.google.android.gms.internal.zzob.m14108a(r2);
        r1.mo1998a(r2);
        goto L_0x016d;
    L_0x00bf:
        r2 = r1.mo1989a();
    L_0x00c3:
        r4.writeNoException();
        r4.writeString(r2);
        return r0;
    L_0x00ca:
        r2 = r3.readStrongBinder();
        r2 = com.google.android.gms.internal.zzxs.m14453a(r2);
        r3 = r3.readString();
        r1.mo2000a(r2, r3);
        goto L_0x016d;
    L_0x00db:
        r2 = r3.readStrongBinder();
        r2 = com.google.android.gms.internal.zzxm.m14451a(r2);
        r1.mo1999a(r2);
        goto L_0x016d;
    L_0x00e8:
        r2 = com.google.android.gms.internal.zzjn.CREATOR;
        r2 = com.google.android.gms.internal.zzew.m5937a(r3, r2);
        r2 = (com.google.android.gms.internal.zzjn) r2;
        r1.mo1991a(r2);
        goto L_0x016d;
    L_0x00f5:
        r2 = r1.mo2008k();
        r4.writeNoException();
        com.google.android.gms.internal.zzew.m5943b(r4, r2);
        return r0;
    L_0x0100:
        r1.mo2010m();
        goto L_0x016d;
    L_0x0105:
        r1.mo2013p();
        goto L_0x016d;
    L_0x010a:
        r1.mo1988D();
        goto L_0x016d;
    L_0x010e:
        r2 = r3.readStrongBinder();
        if (r2 != 0) goto L_0x0115;
    L_0x0114:
        goto L_0x0128;
    L_0x0115:
        r3 = "com.google.android.gms.ads.internal.client.IAppEventListener";
        r3 = r2.queryLocalInterface(r3);
        r5 = r3 instanceof com.google.android.gms.internal.zzkx;
        if (r5 == 0) goto L_0x0123;
    L_0x011f:
        r5 = r3;
        r5 = (com.google.android.gms.internal.zzkx) r5;
        goto L_0x0128;
    L_0x0123:
        r5 = new com.google.android.gms.internal.zzkz;
        r5.<init>(r2);
    L_0x0128:
        r1.mo1994a(r5);
        goto L_0x016d;
    L_0x012c:
        r2 = r3.readStrongBinder();
        if (r2 != 0) goto L_0x0133;
    L_0x0132:
        goto L_0x0146;
    L_0x0133:
        r3 = "com.google.android.gms.ads.internal.client.IAdListener";
        r3 = r2.queryLocalInterface(r3);
        r5 = r3 instanceof com.google.android.gms.internal.zzkh;
        if (r5 == 0) goto L_0x0141;
    L_0x013d:
        r5 = r3;
        r5 = (com.google.android.gms.internal.zzkh) r5;
        goto L_0x0146;
    L_0x0141:
        r5 = new com.google.android.gms.internal.zzkj;
        r5.<init>(r2);
    L_0x0146:
        r1.mo1993a(r5);
        goto L_0x016d;
    L_0x014a:
        r1.mo2012o();
        goto L_0x016d;
    L_0x014e:
        r1.mo2011n();
        goto L_0x016d;
    L_0x0152:
        r2 = com.google.android.gms.internal.zzjj.CREATOR;
        r2 = com.google.android.gms.internal.zzew.m5937a(r3, r2);
        r2 = (com.google.android.gms.internal.zzjj) r2;
        r2 = r1.mo2003b(r2);
        goto L_0x0163;
    L_0x015f:
        r2 = r1.mo2009l();
    L_0x0163:
        r4.writeNoException();
        com.google.android.gms.internal.zzew.m5940a(r4, r2);
        return r0;
    L_0x016a:
        r1.mo2006i();
    L_0x016d:
        r4.writeNoException();
        return r0;
    L_0x0171:
        r2 = r1.mo2007j();
    L_0x0175:
        r4.writeNoException();
        com.google.android.gms.internal.zzew.m5938a(r4, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzkt.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
