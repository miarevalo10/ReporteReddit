package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import java.util.List;

public final class zzqg extends zzeu implements zzqe {
    zzqg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAppInstallAd");
    }

    public final String mo2105a() throws RemoteException {
        Parcel a = m5934a(3, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo2106a(Bundle bundle) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) bundle);
        m5935b(14, o_);
    }

    public final List mo2107b() throws RemoteException {
        Parcel a = m5934a(4, o_());
        List b = zzew.m5942b(a);
        a.recycle();
        return b;
    }

    public final boolean mo2108b(Bundle bundle) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) bundle);
        Parcel a = m5934a(15, o_);
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final String mo2109c() throws RemoteException {
        Parcel a = m5934a(5, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo2110c(Bundle bundle) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) bundle);
        m5935b(16, o_);
    }

    public final zzpq mo2111d() throws RemoteException {
        zzpq com_google_android_gms_internal_zzpq;
        Parcel a = m5934a(6, o_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzpq = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            com_google_android_gms_internal_zzpq = queryLocalInterface instanceof zzpq ? (zzpq) queryLocalInterface : new zzps(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzpq;
    }

    public final String mo2112e() throws RemoteException {
        Parcel a = m5934a(7, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final double mo2113f() throws RemoteException {
        Parcel a = m5934a(8, o_());
        double readDouble = a.readDouble();
        a.recycle();
        return readDouble;
    }

    public final String mo2114g() throws RemoteException {
        Parcel a = m5934a(9, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final String mo2115h() throws RemoteException {
        Parcel a = m5934a(10, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final zzll mo2116i() throws RemoteException {
        Parcel a = m5934a(13, o_());
        zzll a2 = zzlm.m14064a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final IObjectWrapper mo2117j() throws RemoteException {
        Parcel a = m5934a(2, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final Bundle mo2118n() throws RemoteException {
        Parcel a = m5934a(11, o_());
        Bundle bundle = (Bundle) zzew.m5937a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final IObjectWrapper mo2119p() throws RemoteException {
        Parcel a = m5934a(18, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final String mo2120q() throws RemoteException {
        Parcel a = m5934a(19, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final zzpm mo2121r() throws RemoteException {
        zzpm com_google_android_gms_internal_zzpm;
        Parcel a = m5934a(17, o_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzpm = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            com_google_android_gms_internal_zzpm = queryLocalInterface instanceof zzpm ? (zzpm) queryLocalInterface : new zzpo(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzpm;
    }

    public final void mo2122s() throws RemoteException {
        m5935b(12, o_());
    }
}
