package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzlc extends zzeu implements zzla {
    zzlc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public final zzkn createAdLoaderBuilder(IObjectWrapper iObjectWrapper, String str, zzux com_google_android_gms_internal_zzux, int i) throws RemoteException {
        zzkn com_google_android_gms_internal_zzkn;
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        o_.writeString(str);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzux);
        o_.writeInt(i);
        Parcel a = m5934a(3, o_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzkn = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            com_google_android_gms_internal_zzkn = queryLocalInterface instanceof zzkn ? (zzkn) queryLocalInterface : new zzkp(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzkn;
    }

    public final zzxe createAdOverlay(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        Parcel a = m5934a(8, o_);
        zzxe a2 = zzxf.m14435a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzks createBannerAdManager(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, int i) throws RemoteException {
        zzks com_google_android_gms_internal_zzks;
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjn);
        o_.writeString(str);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzux);
        o_.writeInt(i);
        Parcel a = m5934a(1, o_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzks = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            com_google_android_gms_internal_zzks = queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new zzku(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzks;
    }

    public final zzxo createInAppPurchaseManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        Parcel a = m5934a(7, o_);
        zzxo a2 = zzxp.m14452a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzks createInterstitialAdManager(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, String str, zzux com_google_android_gms_internal_zzux, int i) throws RemoteException {
        zzks com_google_android_gms_internal_zzks;
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjn);
        o_.writeString(str);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzux);
        o_.writeInt(i);
        Parcel a = m5934a(2, o_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzks = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            com_google_android_gms_internal_zzks = queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new zzku(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzks;
    }

    public final zzpu createNativeAdViewDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5938a(o_, (IInterface) iObjectWrapper2);
        Parcel a = m5934a(5, o_);
        zzpu a2 = zzpv.m14165a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzpz createNativeAdViewHolderDelegate(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5938a(o_, (IInterface) iObjectWrapper2);
        zzew.m5938a(o_, (IInterface) iObjectWrapper3);
        Parcel a = m5934a(11, o_);
        zzpz a2 = zzqa.m14172a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzadk createRewardedVideoAd(IObjectWrapper iObjectWrapper, zzux com_google_android_gms_internal_zzux, int i) throws RemoteException {
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5938a(o_, (IInterface) com_google_android_gms_internal_zzux);
        o_.writeInt(i);
        Parcel a = m5934a(6, o_);
        zzadk a2 = zzadl.m13171a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final zzks createSearchAdManager(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, String str, int i) throws RemoteException {
        zzks com_google_android_gms_internal_zzks;
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        zzew.m5939a(o_, (Parcelable) com_google_android_gms_internal_zzjn);
        o_.writeString(str);
        o_.writeInt(i);
        Parcel a = m5934a(10, o_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzks = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            com_google_android_gms_internal_zzks = queryLocalInterface instanceof zzks ? (zzks) queryLocalInterface : new zzku(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzks;
    }

    public final zzlg getMobileAdsSettingsManager(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzlg com_google_android_gms_internal_zzlg;
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        Parcel a = m5934a(4, o_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzlg = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            com_google_android_gms_internal_zzlg = queryLocalInterface instanceof zzlg ? (zzlg) queryLocalInterface : new zzli(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzlg;
    }

    public final zzlg getMobileAdsSettingsManagerWithClientJarVersion(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzlg com_google_android_gms_internal_zzlg;
        Parcel o_ = o_();
        zzew.m5938a(o_, (IInterface) iObjectWrapper);
        o_.writeInt(i);
        Parcel a = m5934a(9, o_);
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            com_google_android_gms_internal_zzlg = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            com_google_android_gms_internal_zzlg = queryLocalInterface instanceof zzlg ? (zzlg) queryLocalInterface : new zzli(readStrongBinder);
        }
        a.recycle();
        return com_google_android_gms_internal_zzlg;
    }
}
