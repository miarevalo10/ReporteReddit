package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;
import java.util.List;

public final class zzqo extends zzeu implements zzqm {
    zzqo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public final String mo2139a(String str) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        Parcel a = m5934a(1, o_);
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final List<String> mo2140a() throws RemoteException {
        Parcel a = m5934a(3, o_());
        List createStringArrayList = a.createStringArrayList();
        a.recycle();
        return createStringArrayList;
    }

    public final boolean mo2141a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        Parcel a = m5934a(10, o_);
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final IObjectWrapper mo2142b() throws RemoteException {
        Parcel a = m5934a(11, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzpq mo2143b(String str) throws RemoteException {
        zzpq com_google_android_gms_internal_zzpq;
        Parcel o_ = o_();
        o_.writeString(str);
        Parcel a = m5934a(2, o_);
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

    public final zzll mo2144c() throws RemoteException {
        Parcel a = m5934a(7, o_());
        zzll a2 = zzlm.m14064a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void mo2145c(String str) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        m5935b(5, o_);
    }

    public final void mo2146d() throws RemoteException {
        m5935b(6, o_());
    }

    public final IObjectWrapper mo2147e() throws RemoteException {
        Parcel a = m5934a(9, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void mo2148f() throws RemoteException {
        m5935b(8, o_());
    }

    public final String mo2149l() throws RemoteException {
        Parcel a = m5934a(4, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
