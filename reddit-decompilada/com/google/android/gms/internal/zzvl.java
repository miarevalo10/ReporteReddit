package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import java.util.List;

public final class zzvl extends zzeu implements zzvj {
    zzvl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    public final String mo2208a() throws RemoteException {
        Parcel a = m5934a(2, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo2209a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(11, o_);
    }

    public final List mo2210b() throws RemoteException {
        Parcel a = m5934a(3, o_());
        List b = zzew.m5942b(a);
        a.recycle();
        return b;
    }

    public final void mo2211b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(12, o_);
    }

    public final String mo2212c() throws RemoteException {
        Parcel a = m5934a(4, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo2213c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(16, o_);
    }

    public final zzpq mo2214d() throws RemoteException {
        Parcel a = m5934a(5, o_());
        zzpq a2 = zzpr.m14158a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final String mo2215e() throws RemoteException {
        Parcel a = m5934a(6, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final double mo2216f() throws RemoteException {
        Parcel a = m5934a(7, o_());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    public final String mo2217g() throws RemoteException {
        Parcel a = m5934a(8, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final String mo2218h() throws RemoteException {
        Parcel a = m5934a(9, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo2219i() throws RemoteException {
        m5935b(10, o_());
    }

    public final boolean mo2220j() throws RemoteException {
        Parcel a = m5934a(13, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final boolean mo2221k() throws RemoteException {
        Parcel a = m5934a(14, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final Bundle mo2222l() throws RemoteException {
        Parcel a = m5934a(15, o_());
        Bundle bundle = (Bundle) zzew.m5937a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final zzll mo2223m() throws RemoteException {
        Parcel a = m5934a(17, o_());
        zzll a2 = zzlm.m14064a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final IObjectWrapper mo2224n() throws RemoteException {
        Parcel a = m5934a(18, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzpm mo2225o() throws RemoteException {
        Parcel a = m5934a(19, o_());
        zzpm a2 = zzpn.m14155a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final IObjectWrapper mo2226p() throws RemoteException {
        Parcel a = m5934a(20, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final IObjectWrapper mo2227q() throws RemoteException {
        Parcel a = m5934a(21, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
