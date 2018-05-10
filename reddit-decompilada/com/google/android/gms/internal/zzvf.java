package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzvf extends zzeu implements zzvd {
    zzvf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void mo2196a() throws RemoteException {
        m5935b(1, o_());
    }

    public final void mo2197a(int i) throws RemoteException {
        Parcel o_ = o_();
        o_.writeInt(i);
        m5935b(3, o_);
    }

    public final void mo2198a(zzqm com_google_android_gms_internal_zzqm, String str) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzqm);
        o_.writeString(str);
        m5935b(10, o_);
    }

    public final void mo2199a(zzvg com_google_android_gms_internal_zzvg) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzvg);
        m5935b(7, o_);
    }

    public final void mo2200a(String str, String str2) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        o_.writeString(str2);
        m5935b(9, o_);
    }

    public final void mo2201b() throws RemoteException {
        m5935b(2, o_());
    }

    public final void mo2202c() throws RemoteException {
        m5935b(4, o_());
    }

    public final void mo2203d() throws RemoteException {
        m5935b(5, o_());
    }

    public final void mo2204e() throws RemoteException {
        m5935b(6, o_());
    }

    public final void mo2205f() throws RemoteException {
        m5935b(8, o_());
    }

    public final void mo2206g() throws RemoteException {
        m5935b(11, o_());
    }
}
