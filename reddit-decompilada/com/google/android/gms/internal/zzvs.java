package com.google.android.gms.internal;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzbq;

@zzzv
public final class zzvs implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    NativeAdMapper f14695a;
    NativeCustomTemplateAd f14696b;
    private final zzvd f14697c;

    public zzvs(zzvd com_google_android_gms_internal_zzvd) {
        this.f14697c = com_google_android_gms_internal_zzvd;
    }

    public final void mo2253a() {
        zzbq.m4816b("onAdLoaded must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdLoaded.");
        try {
            this.f14697c.mo2204e();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdLoaded.", e);
        }
    }

    public final void mo2254a(int i) {
        zzbq.m4816b("onAdFailedToLoad must be called on the main UI thread.");
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Adapter called onAdFailedToLoad with error. ");
        stringBuilder.append(i);
        zzakb.m5366b(stringBuilder.toString());
        try {
            this.f14697c.mo2197a(i);
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void mo2255a(NativeCustomTemplateAd nativeCustomTemplateAd) {
        zzbq.m4816b("onAdLoaded must be called on the main UI thread.");
        String str = "Adapter called onAdLoaded with template id ";
        String valueOf = String.valueOf(nativeCustomTemplateAd.mo2150a());
        zzakb.m5366b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        this.f14696b = nativeCustomTemplateAd;
        try {
            this.f14697c.mo2204e();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdLoaded.", e);
        }
    }

    public final void mo2258a(String str, String str2) {
        zzbq.m4816b("onAppEvent must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAppEvent.");
        try {
            this.f14697c.mo2200a(str, str2);
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAppEvent.", e);
        }
    }

    public final void mo2259b() {
        zzbq.m4816b("onAdOpened must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdOpened.");
        try {
            this.f14697c.mo2203d();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdOpened.", e);
        }
    }

    public final void mo2260b(int i) {
        zzbq.m4816b("onAdFailedToLoad must be called on the main UI thread.");
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Adapter called onAdFailedToLoad with error ");
        stringBuilder.append(i);
        stringBuilder.append(".");
        zzakb.m5366b(stringBuilder.toString());
        try {
            this.f14697c.mo2197a(i);
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void mo2261c() {
        zzbq.m4816b("onAdClosed must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdClosed.");
        try {
            this.f14697c.mo2201b();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdClosed.", e);
        }
    }

    public final void mo2262c(int i) {
        zzbq.m4816b("onAdFailedToLoad must be called on the main UI thread.");
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("Adapter called onAdFailedToLoad with error ");
        stringBuilder.append(i);
        stringBuilder.append(".");
        zzakb.m5366b(stringBuilder.toString());
        try {
            this.f14697c.mo2197a(i);
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdFailedToLoad.", e);
        }
    }

    public final void mo2263d() {
        zzbq.m4816b("onAdLeftApplication must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdLeftApplication.");
        try {
            this.f14697c.mo2202c();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdLeftApplication.", e);
        }
    }

    public final void mo2264e() {
        zzbq.m4816b("onAdClicked must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdClicked.");
        try {
            this.f14697c.mo2196a();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdClicked.", e);
        }
    }

    public final void mo2265f() {
        zzbq.m4816b("onAdLoaded must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdLoaded.");
        try {
            this.f14697c.mo2204e();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdLoaded.", e);
        }
    }

    public final void mo2266g() {
        zzbq.m4816b("onAdOpened must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdOpened.");
        try {
            this.f14697c.mo2203d();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdOpened.", e);
        }
    }

    public final void mo2267h() {
        zzbq.m4816b("onAdClosed must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdClosed.");
        try {
            this.f14697c.mo2201b();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdClosed.", e);
        }
    }

    public final void mo2268i() {
        zzbq.m4816b("onAdLeftApplication must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdLeftApplication.");
        try {
            this.f14697c.mo2202c();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdLeftApplication.", e);
        }
    }

    public final void mo2269j() {
        zzbq.m4816b("onAdClicked must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdClicked.");
        try {
            this.f14697c.mo2196a();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdClicked.", e);
        }
    }

    public final void mo2270k() {
        zzbq.m4816b("onAdOpened must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdOpened.");
        try {
            this.f14697c.mo2203d();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdOpened.", e);
        }
    }

    public final void mo2271l() {
        zzbq.m4816b("onAdClosed must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdClosed.");
        try {
            this.f14697c.mo2201b();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdClosed.", e);
        }
    }

    public final void mo2272m() {
        zzbq.m4816b("onAdLeftApplication must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdLeftApplication.");
        try {
            this.f14697c.mo2202c();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdLeftApplication.", e);
        }
    }

    public final void mo2273n() {
        zzbq.m4816b("onAdClicked must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.f14695a;
        if (this.f14696b == null) {
            if (nativeAdMapper == null) {
                zzakb.m5371e("Could not call onAdClicked since NativeAdMapper is null.");
                return;
            } else if (!nativeAdMapper.m4547d()) {
                zzakb.m5366b("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        zzakb.m5366b("Adapter called onAdClicked.");
        try {
            this.f14697c.mo2196a();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdClicked.", e);
        }
    }

    public final void mo2274o() {
        zzbq.m4816b("onAdImpression must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.f14695a;
        if (this.f14696b == null) {
            if (nativeAdMapper == null) {
                zzakb.m5371e("Could not call onAdImpression since NativeAdMapper is null. ");
                return;
            } else if (!nativeAdMapper.m4546c()) {
                zzakb.m5366b("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        zzakb.m5366b("Adapter called onAdImpression.");
        try {
            this.f14697c.mo2205f();
        } catch (Throwable e) {
            zzakb.m5369c("Could not call onAdImpression.", e);
        }
    }

    public final void mo2257a(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        zzbq.m4816b("onAdLoaded must be called on the main UI thread.");
        zzakb.m5366b("Adapter called onAdLoaded.");
        this.f14695a = nativeAdMapper;
        if ((mediationNativeAdapter instanceof AdMobAdapter) == null && nativeAdMapper.f5665g != null) {
            mediationNativeAdapter = new VideoController();
            mediationNativeAdapter.m4383a(new zzvp());
            this.f14695a.f5664f = mediationNativeAdapter;
        }
        try {
            this.f14697c.mo2204e();
        } catch (MediationNativeAdapter mediationNativeAdapter2) {
            zzakb.m5369c("Could not call onAdLoaded.", mediationNativeAdapter2);
        }
    }

    public final void mo2256a(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        if (nativeCustomTemplateAd instanceof zzqp) {
            try {
                this.f14697c.mo2198a(((zzqp) nativeCustomTemplateAd).f14610a, str);
                return;
            } catch (NativeCustomTemplateAd nativeCustomTemplateAd2) {
                zzakb.m5369c("Could not call onCustomClick.", nativeCustomTemplateAd2);
                return;
            }
        }
        zzakb.m5371e("Unexpected native custom template ad type.");
    }
}
