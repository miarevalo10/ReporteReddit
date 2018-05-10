package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper.zza;

public abstract class zzlb extends zzev implements zzla {
    public zzlb() {
        attachInterface(this, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public static zzla asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
        return queryLocalInterface instanceof zzla ? (zzla) queryLocalInterface : new zzlc(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (zza(i, parcel, parcel2, i2)) {
            return true;
        }
        IInterface createBannerAdManager;
        switch (i) {
            case 1:
                createBannerAdManager = createBannerAdManager(zza.m13115a(parcel.readStrongBinder()), (zzjn) zzew.m5937a(parcel, zzjn.CREATOR), parcel.readString(), zzuy.m14316a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 2:
                createBannerAdManager = createInterstitialAdManager(zza.m13115a(parcel.readStrongBinder()), (zzjn) zzew.m5937a(parcel, zzjn.CREATOR), parcel.readString(), zzuy.m14316a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                createBannerAdManager = createAdLoaderBuilder(zza.m13115a(parcel.readStrongBinder()), parcel.readString(), zzuy.m14316a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 4:
                createBannerAdManager = getMobileAdsSettingsManager(zza.m13115a(parcel.readStrongBinder()));
                break;
            case 5:
                createBannerAdManager = createNativeAdViewDelegate(zza.m13115a(parcel.readStrongBinder()), zza.m13115a(parcel.readStrongBinder()));
                break;
            case 6:
                createBannerAdManager = createRewardedVideoAd(zza.m13115a(parcel.readStrongBinder()), zzuy.m14316a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 7:
                createBannerAdManager = createInAppPurchaseManager(zza.m13115a(parcel.readStrongBinder()));
                break;
            case 8:
                createBannerAdManager = createAdOverlay(zza.m13115a(parcel.readStrongBinder()));
                break;
            case 9:
                createBannerAdManager = getMobileAdsSettingsManagerWithClientJarVersion(zza.m13115a(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                createBannerAdManager = createSearchAdManager(zza.m13115a(parcel.readStrongBinder()), (zzjn) zzew.m5937a(parcel, zzjn.CREATOR), parcel.readString(), parcel.readInt());
                break;
            case 11:
                createBannerAdManager = createNativeAdViewHolderDelegate(zza.m13115a(parcel.readStrongBinder()), zza.m13115a(parcel.readStrongBinder()), zza.m13115a(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        zzew.m5938a(parcel2, createBannerAdManager);
        return true;
    }
}
