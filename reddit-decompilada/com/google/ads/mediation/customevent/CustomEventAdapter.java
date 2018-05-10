package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.zzakb;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View f16759a;
    private CustomEventBanner f16760b;
    private CustomEventInterstitial f16761c;

    static final class zza {
        private final CustomEventAdapter f3965a;
        private final MediationBannerListener f3966b;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f3965a = customEventAdapter;
            this.f3966b = mediationBannerListener;
        }
    }

    class zzb {
        private final CustomEventAdapter f3967a;
        private final MediationInterstitialListener f3968b;
        private /* synthetic */ CustomEventAdapter f3969c;

        public zzb(CustomEventAdapter customEventAdapter, CustomEventAdapter customEventAdapter2, MediationInterstitialListener mediationInterstitialListener) {
            this.f3969c = customEventAdapter;
            this.f3967a = customEventAdapter2;
            this.f3968b = mediationInterstitialListener;
        }
    }

    private static <T> T m17064a(String str) {
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

    public final void destroy() {
    }

    public final Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public final View getBannerView() {
        return this.f16759a;
    }

    public final Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f16760b = (CustomEventBanner) m17064a(customEventServerParameters.f12753b);
        if (this.f16760b == null) {
            mediationBannerListener.mo2275a(ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras != null) {
            customEventExtras.m17560a(customEventServerParameters.f12752a);
        }
        zza com_google_ads_mediation_customevent_CustomEventAdapter_zza = new zza(this, mediationBannerListener);
    }

    public final void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.f16761c = (CustomEventInterstitial) m17064a(customEventServerParameters.f12753b);
        if (this.f16761c == null) {
            mediationInterstitialListener.mo2276b(ErrorCode.INTERNAL_ERROR);
            return;
        }
        if (customEventExtras != null) {
            customEventExtras.m17560a(customEventServerParameters.f12752a);
        }
        zzb com_google_ads_mediation_customevent_CustomEventAdapter_zzb = new zzb(this, this, mediationInterstitialListener);
    }

    public final void showInterstitial() {
    }
}
