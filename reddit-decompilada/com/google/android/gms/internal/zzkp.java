package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

public final class zzkp extends zzeu implements zzkn {
    zzkp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    public final zzkk mo1974a() throws RemoteException {
        zzkk com_google_android_gms_internal_zzkk;
        Parcel a = m5934a(1, o_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzkk = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            com_google_android_gms_internal_zzkk = queryLocalInterface instanceof zzkk ? (zzkk) queryLocalInterface : new zzkm(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzkk;
    }

    public final void mo1975a(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) publisherAdViewOptions);
        m5935b(9, o_);
    }

    public final void mo1976a(zzkh com_google_android_gms_internal_zzkh) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzkh);
        m5935b(2, o_);
    }

    public final void mo1977a(zzld com_google_android_gms_internal_zzld) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzld);
        m5935b(7, o_);
    }

    public final void mo1978a(zzpe com_google_android_gms_internal_zzpe) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzpe);
        m5935b(6, o_);
    }

    public final void mo1979a(zzqq com_google_android_gms_internal_zzqq) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzqq);
        m5935b(3, o_);
    }

    public final void mo1980a(zzqt com_google_android_gms_internal_zzqt) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzqt);
        m5935b(4, o_);
    }

    public final void mo1981a(zzrc com_google_android_gms_internal_zzrc) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzrc);
        m5935b(10, o_);
    }

    public final void mo1982a(zzrf com_google_android_gms_internal_zzrf, zzjn com_google_android_gms_internal_zzjn) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzrf);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjn);
        m5935b(8, o_);
    }

    public final void mo1983a(String str, zzqz com_google_android_gms_internal_zzqz, zzqw com_google_android_gms_internal_zzqw) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzqz);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzqw);
        m5935b(5, o_);
    }
}
