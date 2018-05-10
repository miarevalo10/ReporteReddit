package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import java.util.List;

public final class zzvo extends zzeu implements zzvm {
    zzvo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
    }

    public final String mo2228a() throws RemoteException {
        Parcel a = m5934a(2, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo2229a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(9, o_);
    }

    public final List mo2230b() throws RemoteException {
        Parcel a = m5934a(3, o_());
        List b = zzew.m5942b(a);
        a.recycle();
        return b;
    }

    public final void mo2231b(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(10, o_);
    }

    public final String mo2232c() throws RemoteException {
        Parcel a = m5934a(4, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo2233c(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(14, o_);
    }

    public final zzpq mo2234d() throws RemoteException {
        Parcel a = m5934a(5, o_());
        zzpq a2 = zzpr.m14158a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final String mo2235e() throws RemoteException {
        Parcel a = m5934a(6, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final String mo2236f() throws RemoteException {
        Parcel a = m5934a(7, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo2237g() throws RemoteException {
        m5935b(8, o_());
    }

    public final boolean mo2238h() throws RemoteException {
        Parcel a = m5934a(11, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final boolean mo2239i() throws RemoteException {
        Parcel a = m5934a(12, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final Bundle mo2240j() throws RemoteException {
        Parcel a = m5934a(13, o_());
        Bundle bundle = (Bundle) zzew.m5937a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final IObjectWrapper mo2241k() throws RemoteException {
        Parcel a = m5934a(15, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzll mo2242l() throws RemoteException {
        Parcel a = m5934a(16, o_());
        zzll a2 = zzlm.m14064a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzpm mo2243m() throws RemoteException {
        Parcel a = m5934a(19, o_());
        zzpm a2 = zzpn.m14155a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final IObjectWrapper mo2244n() throws RemoteException {
        Parcel a = m5934a(20, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final IObjectWrapper mo2245o() throws RemoteException {
        Parcel a = m5934a(21, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
