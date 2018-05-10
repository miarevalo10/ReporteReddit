package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public final class zzku extends zzeu implements zzks {
    zzku(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public final String mo1985A() throws RemoteException {
        Parcel a = m5934a(31, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final zzkx mo1986B() throws RemoteException {
        zzkx com_google_android_gms_internal_zzkx;
        Parcel a = m5934a(32, o_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzkx = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
            com_google_android_gms_internal_zzkx = queryLocalInterface instanceof zzkx ? (zzkx) queryLocalInterface : new zzkz(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzkx;
    }

    public final zzkh mo1987C() throws RemoteException {
        zzkh com_google_android_gms_internal_zzkh;
        Parcel a = m5934a(33, o_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzkh = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
            com_google_android_gms_internal_zzkh = queryLocalInterface instanceof zzkh ? (zzkh) queryLocalInterface : new zzkj(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzkh;
    }

    public final void mo1988D() throws RemoteException {
        m5935b(9, o_());
    }

    public final String mo1989a() throws RemoteException {
        Parcel a = m5934a(18, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo1990a(zzadp com_google_android_gms_internal_zzadp) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzadp);
        m5935b(24, o_);
    }

    public final void mo1991a(zzjn com_google_android_gms_internal_zzjn) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjn);
        m5935b(13, o_);
    }

    public final void mo1992a(zzke com_google_android_gms_internal_zzke) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzke);
        m5935b(20, o_);
    }

    public final void mo1993a(zzkh com_google_android_gms_internal_zzkh) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzkh);
        m5935b(7, o_);
    }

    public final void mo1994a(zzkx com_google_android_gms_internal_zzkx) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzkx);
        m5935b(8, o_);
    }

    public final void mo1995a(zzld com_google_android_gms_internal_zzld) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzld);
        m5935b(21, o_);
    }

    public final void mo1996a(zzlr com_google_android_gms_internal_zzlr) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzlr);
        m5935b(30, o_);
    }

    public final void mo1997a(zzmr com_google_android_gms_internal_zzmr) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzmr);
        m5935b(29, o_);
    }

    public final void mo1998a(zzoa com_google_android_gms_internal_zzoa) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzoa);
        m5935b(19, o_);
    }

    public final void mo1999a(zzxl com_google_android_gms_internal_zzxl) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzxl);
        m5935b(14, o_);
    }

    public final void mo2000a(zzxr com_google_android_gms_internal_zzxr, String str) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzxr);
        o_.writeString(str);
        m5935b(15, o_);
    }

    public final void mo2001a(String str) throws RemoteException {
        Parcel o_ = o_();
        o_.writeString(str);
        m5935b(25, o_);
    }

    public final void mo2002b(boolean z) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5940a(o_, z);
        m5935b(22, o_);
    }

    public final boolean mo2003b(zzjj com_google_android_gms_internal_zzjj) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjj);
        Parcel a = m5934a(4, o_);
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final void mo2004c(boolean z) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5940a(o_, z);
        m5935b(34, o_);
    }

    public final String g_() throws RemoteException {
        Parcel a = m5934a(35, o_());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void mo2006i() throws RemoteException {
        m5935b(2, o_());
    }

    public final IObjectWrapper mo2007j() throws RemoteException {
        Parcel a = m5934a(1, o_());
        IObjectWrapper a2 = zza.m13115a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzjn mo2008k() throws RemoteException {
        Parcel a = m5934a(12, o_());
        zzjn com_google_android_gms_internal_zzjn = (zzjn) zzew.m5937a(a, zzjn.CREATOR);
        a.recycle();
        return com_google_android_gms_internal_zzjn;
    }

    public final boolean mo2009l() throws RemoteException {
        Parcel a = m5934a(3, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final void mo2010m() throws RemoteException {
        m5935b(11, o_());
    }

    public final void mo2011n() throws RemoteException {
        m5935b(5, o_());
    }

    public final void mo2012o() throws RemoteException {
        m5935b(6, o_());
    }

    public final void mo2013p() throws RemoteException {
        m5935b(10, o_());
    }

    public final boolean mo2014q() throws RemoteException {
        Parcel a = m5934a(23, o_());
        boolean a2 = zzew.m5941a(a);
        a.recycle();
        return a2;
    }

    public final zzll mo2015r() throws RemoteException {
        zzll com_google_android_gms_internal_zzll;
        Parcel a = m5934a(26, o_());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzll = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
            com_google_android_gms_internal_zzll = queryLocalInterface instanceof zzll ? (zzll) queryLocalInterface : new zzln(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzll;
    }
}
