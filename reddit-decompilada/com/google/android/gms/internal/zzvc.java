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

public final class zzvc extends zzeu implements zzva {
    zzvc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final IObjectWrapper mo2170a() throws RemoteException {
        Parcel a = m5934a(2, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void mo2171a(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        m5935b(21, o_);
    }

    public final void mo2172a(IObjectWrapper iObjectWrapper, zzaem com_google_android_gms_internal_zzaem, List<String> list) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzaem);
        o_.writeStringList(list);
        m5935b(23, o_);
    }

    public final void mo2173a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, zzaem com_google_android_gms_internal_zzaem, String str2) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjj);
        o_.writeString(str);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzaem);
        o_.writeString(str2);
        m5935b(10, o_);
    }

    public final void mo2174a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjj);
        o_.writeString(str);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzvd);
        m5935b(3, o_);
    }

    public final void mo2175a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, String str2, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjj);
        o_.writeString(str);
        o_.writeString(str2);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzvd);
        m5935b(7, o_);
    }

    public final void mo2176a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, String str2, zzvd com_google_android_gms_internal_zzvd, zzpe com_google_android_gms_internal_zzpe, List<String> list) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjj);
        o_.writeString(str);
        o_.writeString(str2);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzvd);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzpe);
        o_.writeStringList(list);
        m5935b(14, o_);
    }

    public final void mo2177a(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, zzjj com_google_android_gms_internal_zzjj, String str, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjn);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjj);
        o_.writeString(str);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzvd);
        m5935b(1, o_);
    }

    public final void mo2178a(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, zzjj com_google_android_gms_internal_zzjj, String str, String str2, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjn);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjj);
        o_.writeString(str);
        o_.writeString(str2);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzvd);
        m5935b(6, o_);
    }

    public final void mo2179a(zzjj com_google_android_gms_internal_zzjj, String str) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjj);
        o_.writeString(str);
        m5935b(11, o_);
    }

    public final void mo2180a(zzjj com_google_android_gms_internal_zzjj, String str, String str2) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjj);
        o_.writeString(str);
        o_.writeString(str2);
        m5935b(20, o_);
    }

    public final void mo2181a(boolean z) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5940a(o_, z);
        m5935b(25, o_);
    }

    public final void mo2182b() throws RemoteException {
        m5935b(4, o_());
    }

    public final void mo2183c() throws RemoteException {
        m5935b(5, o_());
    }

    public final void mo2184d() throws RemoteException {
        m5935b(8, o_());
    }

    public final void mo2185e() throws RemoteException {
        m5935b(9, o_());
    }

    public final void mo2186f() throws RemoteException {
        m5935b(12, o_());
    }

    public final boolean mo2187g() throws RemoteException {
        Parcel a = m5934a(13, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final zzvj mo2188h() throws RemoteException {
        zzvj com_google_android_gms_internal_zzvj;
        Parcel a = m5934a(15, o_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzvj = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            com_google_android_gms_internal_zzvj = queryLocalInterface instanceof zzvj ? (zzvj) queryLocalInterface : new zzvl(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzvj;
    }

    public final zzvm mo2189i() throws RemoteException {
        zzvm com_google_android_gms_internal_zzvm;
        Parcel a = m5934a(16, o_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzvm = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            com_google_android_gms_internal_zzvm = queryLocalInterface instanceof zzvm ? (zzvm) queryLocalInterface : new zzvo(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzvm;
    }

    public final Bundle mo2190j() throws RemoteException {
        Parcel a = m5934a(17, o_());
        Bundle bundle = (Bundle) zzew.m5937a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final Bundle mo2191k() throws RemoteException {
        Parcel a = m5934a(18, o_());
        Bundle bundle = (Bundle) zzew.m5937a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final Bundle mo2192l() throws RemoteException {
        Parcel a = m5934a(19, o_());
        Bundle bundle = (Bundle) zzew.m5937a(a, Bundle.CREATOR);
        a.recycle();
        return bundle;
    }

    public final boolean mo2193m() throws RemoteException {
        Parcel a = m5934a(22, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final zzqm mo2194n() throws RemoteException {
        Parcel a = m5934a(24, o_());
        zzqm a2 = zzqn.m14209a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzll mo2195o() throws RemoteException {
        Parcel a = m5934a(26, o_());
        zzll a2 = zzlm.m14064a(a.readStrongBinder());
        a.recycle();
        return a2;
    }
}
