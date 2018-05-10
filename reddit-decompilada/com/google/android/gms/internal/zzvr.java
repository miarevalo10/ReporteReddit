package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

@zzzv
public final class zzvr extends zzvb {
    private final MediationAdapter f18316a;
    private zzvs f18317b;

    public zzvr(MediationAdapter mediationAdapter) {
        this.f18316a = mediationAdapter;
    }

    private final Bundle m19067a(String str, zzjj com_google_android_gms_internal_zzjj, String str2) throws RemoteException {
        String str3 = "Server parameters: ";
        String valueOf = String.valueOf(str);
        zzakb.m5371e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        try {
            Bundle bundle;
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str4 = (String) keys.next();
                    bundle.putString(str4, jSONObject.getString(str4));
                }
            } else {
                bundle = bundle2;
            }
            if (this.f18316a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (com_google_android_gms_internal_zzjj != null) {
                    bundle.putInt("tagForChildDirectedTreatment", com_google_android_gms_internal_zzjj.f18140g);
                }
            }
            return bundle;
        } catch (Throwable th) {
            zzakb.m5369c("Could not get Server Parameters Bundle.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    private static boolean m19068a(zzjj com_google_android_gms_internal_zzjj) {
        if (!com_google_android_gms_internal_zzjj.f18139f) {
            zzkb.m6345a();
            if (!zzajr.m5328a()) {
                return false;
            }
        }
        return true;
    }

    public final IObjectWrapper mo2170a() throws RemoteException {
        if (this.f18316a instanceof MediationBannerAdapter) {
            try {
                return zzn.m17692a(((MediationBannerAdapter) this.f18316a).getBannerView());
            } catch (Throwable th) {
                zzakb.m5369c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f18316a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public final void mo2171a(IObjectWrapper iObjectWrapper) throws RemoteException {
        try {
            zzn.m17693a(iObjectWrapper);
        } catch (Throwable th) {
            zzakb.m5364a("Could not inform adapter of changed context", th);
        }
    }

    public final void mo2172a(IObjectWrapper iObjectWrapper, zzaem com_google_android_gms_internal_zzaem, List<String> list) throws RemoteException {
        if (this.f18316a instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzakb.m5366b("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.f18316a;
                List arrayList = new ArrayList();
                for (String a : list) {
                    arrayList.add(m19067a(a, null, null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) zzn.m17693a(iObjectWrapper), new zzaep(com_google_android_gms_internal_zzaem), arrayList);
            } catch (Throwable th) {
                zzakb.m5369c("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not an InitializableMediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f18316a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public final void mo2173a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, zzaem com_google_android_gms_internal_zzaem, String str2) throws RemoteException {
        zzjj com_google_android_gms_internal_zzjj2 = com_google_android_gms_internal_zzjj;
        if (this.f18316a instanceof MediationRewardedVideoAdAdapter) {
            zzakb.m5366b("Initialize rewarded video adapter.");
            try {
                Bundle bundle;
                MediationAdRequest mediationAdRequest;
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) r1.f18316a;
                Bundle a = m19067a(str2, com_google_android_gms_internal_zzjj2, null);
                if (com_google_android_gms_internal_zzjj2 != null) {
                    zzvq com_google_android_gms_internal_zzvq = new zzvq(com_google_android_gms_internal_zzjj2.f18135b == -1 ? null : new Date(com_google_android_gms_internal_zzjj2.f18135b), com_google_android_gms_internal_zzjj2.f18137d, com_google_android_gms_internal_zzjj2.f18138e != null ? new HashSet(com_google_android_gms_internal_zzjj2.f18138e) : null, com_google_android_gms_internal_zzjj2.f18144k, m19068a(com_google_android_gms_internal_zzjj), com_google_android_gms_internal_zzjj2.f18140g, com_google_android_gms_internal_zzjj2.f18151r);
                    bundle = com_google_android_gms_internal_zzjj2.f18146m != null ? com_google_android_gms_internal_zzjj2.f18146m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    mediationAdRequest = com_google_android_gms_internal_zzvq;
                } else {
                    mediationAdRequest = null;
                    bundle = mediationAdRequest;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) zzn.m17693a(iObjectWrapper), mediationAdRequest, str, new zzaep(com_google_android_gms_internal_zzaem), a, bundle);
            } catch (Throwable th) {
                zzakb.m5369c("Could not initialize rewarded video adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(r1.f18316a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void mo2174a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        mo2175a(iObjectWrapper, com_google_android_gms_internal_zzjj, str, null, com_google_android_gms_internal_zzvd);
    }

    public final void mo2175a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, String str2, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        zzjj com_google_android_gms_internal_zzjj2 = com_google_android_gms_internal_zzjj;
        if (this.f18316a instanceof MediationInterstitialAdapter) {
            zzakb.m5366b("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) r1.f18316a;
                Bundle bundle = null;
                zzvq com_google_android_gms_internal_zzvq = new zzvq(com_google_android_gms_internal_zzjj2.f18135b == -1 ? null : new Date(com_google_android_gms_internal_zzjj2.f18135b), com_google_android_gms_internal_zzjj2.f18137d, com_google_android_gms_internal_zzjj2.f18138e != null ? new HashSet(com_google_android_gms_internal_zzjj2.f18138e) : null, com_google_android_gms_internal_zzjj2.f18144k, m19068a(com_google_android_gms_internal_zzjj), com_google_android_gms_internal_zzjj2.f18140g, com_google_android_gms_internal_zzjj2.f18151r);
                if (com_google_android_gms_internal_zzjj2.f18146m != null) {
                    bundle = com_google_android_gms_internal_zzjj2.f18146m.getBundle(mediationInterstitialAdapter.getClass().getName());
                }
                mediationInterstitialAdapter.requestInterstitialAd((Context) zzn.m17693a(iObjectWrapper), new zzvs(com_google_android_gms_internal_zzvd), m19067a(str, com_google_android_gms_internal_zzjj2, str2), com_google_android_gms_internal_zzvq, bundle);
            } catch (Throwable th) {
                zzakb.m5369c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(r1.f18316a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void mo2176a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, String str2, zzvd com_google_android_gms_internal_zzvd, zzpe com_google_android_gms_internal_zzpe, List<String> list) throws RemoteException {
        zzjj com_google_android_gms_internal_zzjj2 = com_google_android_gms_internal_zzjj;
        if (this.f18316a instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) r1.f18316a;
                Bundle bundle = null;
                zzvv com_google_android_gms_internal_zzvv = new zzvv(com_google_android_gms_internal_zzjj2.f18135b == -1 ? null : new Date(com_google_android_gms_internal_zzjj2.f18135b), com_google_android_gms_internal_zzjj2.f18137d, com_google_android_gms_internal_zzjj2.f18138e != null ? new HashSet(com_google_android_gms_internal_zzjj2.f18138e) : null, com_google_android_gms_internal_zzjj2.f18144k, m19068a(com_google_android_gms_internal_zzjj), com_google_android_gms_internal_zzjj2.f18140g, com_google_android_gms_internal_zzpe, list, com_google_android_gms_internal_zzjj2.f18151r);
                if (com_google_android_gms_internal_zzjj2.f18146m != null) {
                    bundle = com_google_android_gms_internal_zzjj2.f18146m.getBundle(mediationNativeAdapter.getClass().getName());
                }
                Bundle bundle2 = bundle;
                r1.f18317b = new zzvs(com_google_android_gms_internal_zzvd);
                mediationNativeAdapter.requestNativeAd((Context) zzn.m17693a(iObjectWrapper), r1.f18317b, m19067a(str, com_google_android_gms_internal_zzjj2, str2), com_google_android_gms_internal_zzvv, bundle2);
            } catch (Throwable th) {
                zzakb.m5369c("Could not request native ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationNativeAdapter: ";
            String valueOf = String.valueOf(r1.f18316a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void mo2177a(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, zzjj com_google_android_gms_internal_zzjj, String str, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        mo2178a(iObjectWrapper, com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzjj, str, null, com_google_android_gms_internal_zzvd);
    }

    public final void mo2178a(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, zzjj com_google_android_gms_internal_zzjj, String str, String str2, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        zzjn com_google_android_gms_internal_zzjn2 = com_google_android_gms_internal_zzjn;
        zzjj com_google_android_gms_internal_zzjj2 = com_google_android_gms_internal_zzjj;
        if (this.f18316a instanceof MediationBannerAdapter) {
            zzakb.m5366b("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) r1.f18316a;
                Bundle bundle = null;
                zzvq com_google_android_gms_internal_zzvq = new zzvq(com_google_android_gms_internal_zzjj2.f18135b == -1 ? null : new Date(com_google_android_gms_internal_zzjj2.f18135b), com_google_android_gms_internal_zzjj2.f18137d, com_google_android_gms_internal_zzjj2.f18138e != null ? new HashSet(com_google_android_gms_internal_zzjj2.f18138e) : null, com_google_android_gms_internal_zzjj2.f18144k, m19068a(com_google_android_gms_internal_zzjj), com_google_android_gms_internal_zzjj2.f18140g, com_google_android_gms_internal_zzjj2.f18151r);
                if (com_google_android_gms_internal_zzjj2.f18146m != null) {
                    bundle = com_google_android_gms_internal_zzjj2.f18146m.getBundle(mediationBannerAdapter.getClass().getName());
                }
                mediationBannerAdapter.requestBannerAd((Context) zzn.m17693a(iObjectWrapper), new zzvs(com_google_android_gms_internal_zzvd), m19067a(str, com_google_android_gms_internal_zzjj2, str2), zzb.m4570a(com_google_android_gms_internal_zzjn2.f18156e, com_google_android_gms_internal_zzjn2.f18153b, com_google_android_gms_internal_zzjn2.f18152a), com_google_android_gms_internal_zzvq, bundle);
            } catch (Throwable th) {
                zzakb.m5369c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(r1.f18316a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void mo2179a(zzjj com_google_android_gms_internal_zzjj, String str) throws RemoteException {
        mo2180a(com_google_android_gms_internal_zzjj, str, null);
    }

    public final void mo2180a(zzjj com_google_android_gms_internal_zzjj, String str, String str2) throws RemoteException {
        if (this.f18316a instanceof MediationRewardedVideoAdAdapter) {
            zzakb.m5366b("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.f18316a;
                Bundle bundle = null;
                MediationAdRequest com_google_android_gms_internal_zzvq = new zzvq(com_google_android_gms_internal_zzjj.f18135b == -1 ? null : new Date(com_google_android_gms_internal_zzjj.f18135b), com_google_android_gms_internal_zzjj.f18137d, com_google_android_gms_internal_zzjj.f18138e != null ? new HashSet(com_google_android_gms_internal_zzjj.f18138e) : null, com_google_android_gms_internal_zzjj.f18144k, m19068a(com_google_android_gms_internal_zzjj), com_google_android_gms_internal_zzjj.f18140g, com_google_android_gms_internal_zzjj.f18151r);
                if (com_google_android_gms_internal_zzjj.f18146m != null) {
                    bundle = com_google_android_gms_internal_zzjj.f18146m.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                }
                mediationRewardedVideoAdAdapter.loadAd(com_google_android_gms_internal_zzvq, m19067a(str, com_google_android_gms_internal_zzjj, str2), bundle);
            } catch (Throwable th) {
                zzakb.m5369c("Could not load rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            str = String.valueOf(this.f18316a.getClass().getCanonicalName());
            zzakb.m5371e(str.length() != 0 ? str3.concat(str) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void mo2181a(boolean z) throws RemoteException {
        if (this.f18316a instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) this.f18316a).onImmersiveModeUpdated(z);
                return;
            } catch (Throwable th) {
                zzakb.m5369c("Could not set immersive mode.", th);
                return;
            }
        }
        String str = "MediationAdapter is not an OnImmersiveModeUpdatedListener: ";
        String valueOf = String.valueOf(this.f18316a.getClass().getCanonicalName());
        zzakb.m5370d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public final void mo2182b() throws RemoteException {
        if (this.f18316a instanceof MediationInterstitialAdapter) {
            zzakb.m5366b("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f18316a).showInterstitial();
            } catch (Throwable th) {
                zzakb.m5369c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f18316a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public final void mo2183c() throws RemoteException {
        try {
            this.f18316a.onDestroy();
        } catch (Throwable th) {
            zzakb.m5369c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void mo2184d() throws RemoteException {
        try {
            this.f18316a.onPause();
        } catch (Throwable th) {
            zzakb.m5369c("Could not pause adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void mo2185e() throws RemoteException {
        try {
            this.f18316a.onResume();
        } catch (Throwable th) {
            zzakb.m5369c("Could not resume adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void mo2186f() throws RemoteException {
        if (this.f18316a instanceof MediationRewardedVideoAdAdapter) {
            zzakb.m5366b("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.f18316a).showVideo();
            } catch (Throwable th) {
                zzakb.m5369c("Could not show rewarded video ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f18316a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public final boolean mo2187g() throws RemoteException {
        if (this.f18316a instanceof MediationRewardedVideoAdAdapter) {
            zzakb.m5366b("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.f18316a).isInitialized();
            } catch (Throwable th) {
                zzakb.m5369c("Could not check if adapter is initialized.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationRewardedVideoAdAdapter: ";
            String valueOf = String.valueOf(this.f18316a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public final Bundle mo2190j() {
        if (this.f18316a instanceof zzapb) {
            return ((zzapb) this.f18316a).zzmg();
        }
        String str = "MediationAdapter is not a v2 MediationBannerAdapter: ";
        String valueOf = String.valueOf(this.f18316a.getClass().getCanonicalName());
        zzakb.m5371e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public final Bundle mo2191k() {
        if (this.f18316a instanceof zzapc) {
            return ((zzapc) this.f18316a).getInterstitialAdapterInfo();
        }
        String str = "MediationAdapter is not a v2 MediationInterstitialAdapter: ";
        String valueOf = String.valueOf(this.f18316a.getClass().getCanonicalName());
        zzakb.m5371e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        return new Bundle();
    }

    public final Bundle mo2192l() {
        return new Bundle();
    }

    public final boolean mo2193m() {
        return this.f18316a instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    public final zzll mo2195o() {
        if (!(this.f18316a instanceof zza)) {
            return null;
        }
        try {
            return ((zza) this.f18316a).getVideoController();
        } catch (Throwable th) {
            zzakb.m5369c("Could not get video controller.", th);
            return null;
        }
    }

    public final zzvj mo2188h() {
        NativeAdMapper nativeAdMapper = this.f18317b.f14695a;
        return nativeAdMapper instanceof NativeAppInstallAdMapper ? new zzvt((NativeAppInstallAdMapper) nativeAdMapper) : null;
    }

    public final zzvm mo2189i() {
        NativeAdMapper nativeAdMapper = this.f18317b.f14695a;
        return nativeAdMapper instanceof NativeContentAdMapper ? new zzvu((NativeContentAdMapper) nativeAdMapper) : null;
    }

    public final zzqm mo2194n() {
        NativeCustomTemplateAd nativeCustomTemplateAd = this.f18317b.f14696b;
        return nativeCustomTemplateAd instanceof zzqp ? ((zzqp) nativeCustomTemplateAd).f14610a : null;
    }
}
