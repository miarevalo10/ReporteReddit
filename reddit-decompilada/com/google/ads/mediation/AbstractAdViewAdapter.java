package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdRequest.Builder;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.zzadu;
import com.google.android.gms.internal.zzajr;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzapc;
import com.google.android.gms.internal.zzje;
import com.google.android.gms.internal.zzjf;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzzv;
import java.util.Date;
import java.util.Set;

@zzzv
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, com.google.android.gms.ads.mediation.zza, MediationRewardedVideoAdAdapter, zzapc {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzgt;
    private InterstitialAd zzgu;
    private AdLoader zzgv;
    private Context zzgw;
    private InterstitialAd zzgx;
    private MediationRewardedVideoAdListener zzgy;
    private RewardedVideoAdListener zzgz = new zza(this);

    static final class zzc extends AdListener implements AppEventListener, zzje {
        private AbstractAdViewAdapter f12746a;
        private MediationBannerListener f12747b;

        public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.f12746a = abstractAdViewAdapter;
            this.f12747b = mediationBannerListener;
        }

        public final void mo1257a() {
            this.f12747b.mo2253a();
        }

        public final void mo1258a(int i) {
            this.f12747b.mo2254a(i);
        }

        public final void mo1259a(String str, String str2) {
            this.f12747b.mo2258a(str, str2);
        }

        public final void mo1260b() {
            this.f12747b.mo2259b();
        }

        public final void mo1261c() {
            this.f12747b.mo2261c();
        }

        public final void mo1262d() {
            this.f12747b.mo2263d();
        }

        public final void mo1263e() {
            this.f12747b.mo2264e();
        }
    }

    static final class zzd extends AdListener implements zzje {
        private AbstractAdViewAdapter f12748a;
        private MediationInterstitialListener f12749b;

        public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f12748a = abstractAdViewAdapter;
            this.f12749b = mediationInterstitialListener;
        }

        public final void mo1257a() {
            this.f12749b.mo2265f();
        }

        public final void mo1258a(int i) {
            this.f12749b.mo2260b(i);
        }

        public final void mo1260b() {
            this.f12749b.mo2266g();
        }

        public final void mo1261c() {
            this.f12749b.mo2267h();
        }

        public final void mo1262d() {
            this.f12749b.mo2268i();
        }

        public final void mo1263e() {
            this.f12749b.mo2269j();
        }
    }

    static final class zze extends AdListener implements OnAppInstallAdLoadedListener, OnContentAdLoadedListener, OnCustomClickListener, OnCustomTemplateAdLoadedListener {
        private AbstractAdViewAdapter f12750a;
        private MediationNativeListener f12751b;

        public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.f12750a = abstractAdViewAdapter;
            this.f12751b = mediationNativeListener;
        }

        public final void mo1257a() {
        }

        public final void mo1258a(int i) {
            this.f12751b.mo2262c(i);
        }

        public final void mo1264a(NativeAppInstallAd nativeAppInstallAd) {
            this.f12751b.mo2257a(this.f12750a, new zza(nativeAppInstallAd));
        }

        public final void mo1265a(NativeContentAd nativeContentAd) {
            this.f12751b.mo2257a(this.f12750a, new zzb(nativeContentAd));
        }

        public final void mo1266a(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.f12751b.mo2255a(nativeCustomTemplateAd);
        }

        public final void mo1267a(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.f12751b.mo2256a(nativeCustomTemplateAd, str);
        }

        public final void mo1260b() {
            this.f12751b.mo2270k();
        }

        public final void mo1261c() {
            this.f12751b.mo2271l();
        }

        public final void mo1262d() {
            this.f12751b.mo2272m();
        }

        public final void mo1263e() {
            this.f12751b.mo2273n();
        }

        public final void mo1268f() {
            this.f12751b.mo2274o();
        }
    }

    static class zza extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd f16757p;

        public final void mo3302a(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f16757p);
            }
            NativeAdViewHolder nativeAdViewHolder = (NativeAdViewHolder) NativeAdViewHolder.f5407a.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.m4411a(this.f16757p);
            }
        }

        public zza(NativeAppInstallAd nativeAppInstallAd) {
            this.f16757p = nativeAppInstallAd;
            this.f13784h = nativeAppInstallAd.mo3547b().toString();
            this.f13785i = nativeAppInstallAd.mo3548c();
            this.f13786j = nativeAppInstallAd.mo3549d().toString();
            this.f13787k = nativeAppInstallAd.mo3550e();
            this.f13788l = nativeAppInstallAd.mo3551f().toString();
            if (nativeAppInstallAd.mo3552g() != null) {
                this.f13789m = nativeAppInstallAd.mo3552g().doubleValue();
            }
            if (nativeAppInstallAd.mo3553h() != null) {
                this.f13790n = nativeAppInstallAd.mo3553h().toString();
            }
            if (nativeAppInstallAd.mo3554i() != null) {
                this.f13791o = nativeAppInstallAd.mo3554i().toString();
            }
            m4543a();
            m4545b();
            this.f5664f = nativeAppInstallAd.mo3555j();
        }
    }

    static class zzb extends NativeContentAdMapper {
        private final NativeContentAd f16758n;

        public final void mo3302a(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f16758n);
            }
            NativeAdViewHolder nativeAdViewHolder = (NativeAdViewHolder) NativeAdViewHolder.f5407a.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.m4411a(this.f16758n);
            }
        }

        public zzb(NativeContentAd nativeContentAd) {
            this.f16758n = nativeContentAd;
            this.f13792h = nativeContentAd.mo3557b().toString();
            this.f13793i = nativeContentAd.mo3558c();
            this.f13794j = nativeContentAd.mo3559d().toString();
            if (nativeContentAd.mo3560e() != null) {
                this.f13795k = nativeContentAd.mo3560e();
            }
            this.f13796l = nativeContentAd.mo3561f().toString();
            this.f13797m = nativeContentAd.mo3562g().toString();
            m4543a();
            m4545b();
            this.f5664f = nativeContentAd.mo3563h();
        }
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzgt;
    }

    public zzll getVideoController() {
        if (this.zzgt != null) {
            VideoController videoController = this.zzgt.getVideoController();
            if (videoController != null) {
                return videoController.m4382a();
            }
        }
        return null;
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzgw = context.getApplicationContext();
        this.zzgy = mediationRewardedVideoAdListener;
        this.zzgy.mo1694a(this);
    }

    public boolean isInitialized() {
        return this.zzgy != null;
    }

    public void onDestroy() {
        if (this.zzgt != null) {
            this.zzgt.mo1500c();
            this.zzgt = null;
        }
        if (this.zzgu != null) {
            this.zzgu = null;
        }
        if (this.zzgv != null) {
            this.zzgv = null;
        }
        if (this.zzgx != null) {
            this.zzgx = null;
        }
    }

    public void onImmersiveModeUpdated(boolean z) {
        if (this.zzgu != null) {
            this.zzgu.m4381a(z);
        }
        if (this.zzgx != null) {
            this.zzgx.m4381a(z);
        }
    }

    public void onPause() {
        if (this.zzgt != null) {
            this.zzgt.mo1499b();
        }
    }

    public void onResume() {
        if (this.zzgt != null) {
            this.zzgt.mo1497a();
        }
    }

    public void showInterstitial() {
        this.zzgu.m4378a();
    }

    public void showVideo() {
        this.zzgx.m4378a();
    }

    public abstract Bundle zza(Bundle bundle, Bundle bundle2);

    private final AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Builder builder = new Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.f5367a.f7799e = birthday;
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.f5367a.f7800f = gender;
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String add : keywords) {
                builder.f5367a.f7795a.add(add);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.f5367a.f7801g = location;
        }
        if (mediationAdRequest.isTesting()) {
            zzkb.m6345a();
            builder.f5367a.m6453a(zzajr.m5320a(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            gender = 1;
            if (mediationAdRequest.taggedForChildDirectedTreatment() != 1) {
                gender = 0;
            }
            builder.f5367a.f7802h = gender;
        }
        builder.f5367a.f7803i = mediationAdRequest.isDesignedForFamilies();
        context = zza(bundle, bundle2);
        mediationAdRequest = AdMobAdapter.class;
        builder.f5367a.f7796b.putBundle(mediationAdRequest.getName(), context);
        if (!(mediationAdRequest.equals(AdMobAdapter.class) == null || context.getBoolean("_emulatorLiveAds") == null)) {
            builder.f5367a.f7797c.remove("B3EEABB8EE11C2BE770B684D95219ECB");
        }
        return new AdRequest(builder);
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzgt = new AdView(context);
        this.zzgt.setAdSize(new AdSize(adSize.f5378k, adSize.f5379l));
        this.zzgt.setAdUnitId(getAdUnitId(bundle));
        this.zzgt.setAdListener(new zzc(this, mediationBannerListener));
        this.zzgt.mo1498a(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzgu = new InterstitialAd(context);
        this.zzgu.m4380a(getAdUnitId(bundle));
        InterstitialAd interstitialAd = this.zzgu;
        AdListener com_google_ads_mediation_AbstractAdViewAdapter_zzd = new zzd(this, mediationInterstitialListener);
        mediationInterstitialListener = interstitialAd.f5383a;
        try {
            mediationInterstitialListener.f7829c = com_google_ads_mediation_AbstractAdViewAdapter_zzd;
            if (mediationInterstitialListener.f7831e != null) {
                mediationInterstitialListener.f7831e.mo1993a(new zzjg(com_google_ads_mediation_AbstractAdViewAdapter_zzd));
            }
        } catch (MediationInterstitialListener mediationInterstitialListener2) {
            zzakb.m5369c("Failed to set the AdListener.", mediationInterstitialListener2);
        }
        mediationInterstitialListener2 = interstitialAd.f5383a;
        zzje com_google_android_gms_internal_zzje = (zzje) com_google_ads_mediation_AbstractAdViewAdapter_zzd;
        try {
            mediationInterstitialListener2.f7830d = com_google_android_gms_internal_zzje;
            if (mediationInterstitialListener2.f7831e != null) {
                mediationInterstitialListener2.f7831e.mo1992a(new zzjf(com_google_android_gms_internal_zzje));
            }
        } catch (MediationInterstitialListener mediationInterstitialListener22) {
            zzakb.m5369c("Failed to set the AdClickListener.", mediationInterstitialListener22);
        }
        this.zzgu.m4379a(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public Bundle getInterstitialAdapterInfo() {
        com.google.android.gms.ads.mediation.MediationAdapter.zza com_google_android_gms_ads_mediation_MediationAdapter_zza = new com.google.android.gms.ads.mediation.MediationAdapter.zza();
        com_google_android_gms_ads_mediation_MediationAdapter_zza.f5658a = 1;
        Bundle bundle = new Bundle();
        bundle.putInt("capabilities", com_google_android_gms_ads_mediation_MediationAdapter_zza.f5658a);
        return bundle;
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        OnContentAdLoadedListener com_google_ads_mediation_AbstractAdViewAdapter_zze = new zze(this, mediationNativeListener);
        mediationNativeListener = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).m4362a((AdListener) com_google_ads_mediation_AbstractAdViewAdapter_zze);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            mediationNativeListener.m4363a(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            mediationNativeListener.m4364a((OnAppInstallAdLoadedListener) com_google_ads_mediation_AbstractAdViewAdapter_zze);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            mediationNativeListener.m4365a(com_google_ads_mediation_AbstractAdViewAdapter_zze);
        }
        if (nativeMediationAdRequest.zzmo()) {
            for (String str : nativeMediationAdRequest.zzmp().keySet()) {
                mediationNativeListener.m4366a(str, com_google_ads_mediation_AbstractAdViewAdapter_zze, ((Boolean) nativeMediationAdRequest.zzmp().get(str)).booleanValue() ? com_google_ads_mediation_AbstractAdViewAdapter_zze : null);
            }
        }
        this.zzgv = mediationNativeListener.m4367a();
        this.zzgv.m4369a(zza(context, nativeMediationAdRequest, bundle2, bundle).zzbg());
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        if (this.zzgw != null) {
            if (this.zzgy != null) {
                this.zzgx = new InterstitialAd(this.zzgw);
                this.zzgx.f5383a.f7837k = true;
                this.zzgx.m4380a(getAdUnitId(bundle));
                InterstitialAd interstitialAd = this.zzgx;
                RewardedVideoAdListener rewardedVideoAdListener = this.zzgz;
                zzlx com_google_android_gms_internal_zzlx = interstitialAd.f5383a;
                try {
                    com_google_android_gms_internal_zzlx.f7836j = rewardedVideoAdListener;
                    if (com_google_android_gms_internal_zzlx.f7831e != null) {
                        com_google_android_gms_internal_zzlx.f7831e.mo1990a(rewardedVideoAdListener != null ? new zzadu(rewardedVideoAdListener) : null);
                    }
                } catch (Throwable e) {
                    zzakb.m5369c("Failed to set the AdListener.", e);
                }
                this.zzgx.m4379a(zza(this.zzgw, mediationAdRequest, bundle2, bundle));
                return;
            }
        }
        zzakb.m5368c("AdMobAdapter.loadAd called before initialize.");
    }
}
