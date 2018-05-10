package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzakb;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    private View f17194a;
    private CustomEventBanner f17195b;
    private CustomEventInterstitial f17196c;
    private CustomEventNative f17197d;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter f13798a;
        private final MediationBannerListener f13799b;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f13798a = customEventAdapter;
            this.f13799b = mediationBannerListener;
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter f13800a;
        private final MediationInterstitialListener f13801b;
        private /* synthetic */ CustomEventAdapter f13802c;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f13802c = customEventAdapter;
            this.f13800a = customEventAdapter2;
            this.f13801b = mediationInterstitialListener;
        }
    }

    static class zzc implements CustomEventNativeListener {
        private final CustomEventAdapter f13803a;
        private final MediationNativeListener f13804b;

        public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.f13803a = customEventAdapter;
            this.f13804b = mediationNativeListener;
        }
    }

    private static <T> T m17559a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder stringBuilder = new StringBuilder((46 + String.valueOf(str).length()) + String.valueOf(message).length());
            stringBuilder.append("Could not instantiate custom event adapter: ");
            stringBuilder.append(str);
            stringBuilder.append(". ");
            stringBuilder.append(message);
            zzakb.m5371e(stringBuilder.toString());
            return null;
        }
    }

    public final View getBannerView() {
        return this.f17194a;
    }

    public final void onDestroy() {
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f17195b = (CustomEventBanner) m17559a(bundle.getString("class_name"));
        if (this.f17195b == null) {
            mediationBannerListener.mo2254a(0);
        } else {
            this.f17195b.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f17196c = (CustomEventInterstitial) m17559a(bundle.getString("class_name"));
        if (this.f17196c == null) {
            mediationInterstitialListener.mo2260b(0);
        } else {
            this.f17196c.requestInterstitialAd(context, new zzb(this, this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.f17197d = (CustomEventNative) m17559a(bundle.getString("class_name"));
        if (this.f17197d == null) {
            mediationNativeListener.mo2262c(0);
        } else {
            this.f17197d.requestNativeAd(context, new zzc(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public final void showInterstitial() {
        this.f17196c.showInterstitial();
    }
}
