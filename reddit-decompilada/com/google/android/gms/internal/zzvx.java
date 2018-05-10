package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

@zzzv
public final class zzvx<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzvd f14698a;

    public zzvx(zzvd com_google_android_gms_internal_zzvd) {
        this.f14698a = com_google_android_gms_internal_zzvd;
    }

    public final void mo2275a(ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder stringBuilder = new StringBuilder(47 + String.valueOf(valueOf).length());
        stringBuilder.append("Adapter called onFailedToReceiveAd with error. ");
        stringBuilder.append(valueOf);
        zzakb.m5366b(stringBuilder.toString());
        zzkb.m6345a();
        if (zzajr.m5332b()) {
            try {
                this.f14698a.mo2197a(zzwj.m6772a(errorCode));
                return;
            } catch (Throwable e) {
                zzakb.m5369c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzakb.m5371e("onFailedToReceiveAd must be called on the main UI thread.");
        zzajr.f6473a.post(new zzwc(this, errorCode));
    }

    public final void mo2276b(ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder stringBuilder = new StringBuilder(47 + String.valueOf(valueOf).length());
        stringBuilder.append("Adapter called onFailedToReceiveAd with error ");
        stringBuilder.append(valueOf);
        stringBuilder.append(".");
        zzakb.m5366b(stringBuilder.toString());
        zzkb.m6345a();
        if (zzajr.m5332b()) {
            try {
                this.f14698a.mo2197a(zzwj.m6772a(errorCode));
                return;
            } catch (Throwable e) {
                zzakb.m5369c("Could not call onAdFailedToLoad.", e);
                return;
            }
        }
        zzakb.m5371e("onFailedToReceiveAd must be called on the main UI thread.");
        zzajr.f6473a.post(new zzwh(this, errorCode));
    }
}
