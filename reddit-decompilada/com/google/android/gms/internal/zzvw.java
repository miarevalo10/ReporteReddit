package com.google.android.gms.internal;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzzv
public final class zzvw<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> extends zzvb {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> f18330a;
    private final NETWORK_EXTRAS f18331b;

    public zzvw(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS network_extras) {
        this.f18330a = mediationAdapter;
        this.f18331b = network_extras;
    }

    private final SERVER_PARAMETERS m19133a(String str) throws RemoteException {
        Map hashMap;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                hashMap = new HashMap(jSONObject.length());
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    hashMap.put(str2, jSONObject.getString(str2));
                }
            } catch (Throwable th) {
                zzakb.m5369c("Could not get MediationServerParameters.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            hashMap = new HashMap(0);
        }
        Class serverParametersType = this.f18330a.getServerParametersType();
        if (serverParametersType == null) {
            return null;
        }
        MediationServerParameters mediationServerParameters = (MediationServerParameters) serverParametersType.newInstance();
        mediationServerParameters.m3538a(hashMap);
        return mediationServerParameters;
    }

    private static boolean m19134a(zzjj com_google_android_gms_internal_zzjj) {
        if (!com_google_android_gms_internal_zzjj.f18139f) {
            zzkb.m6345a();
            if (!zzajr.m5328a()) {
                return false;
            }
        }
        return true;
    }

    public final IObjectWrapper mo2170a() throws RemoteException {
        if (this.f18330a instanceof MediationBannerAdapter) {
            try {
                return zzn.m17692a(((MediationBannerAdapter) this.f18330a).getBannerView());
            } catch (Throwable th) {
                zzakb.m5369c("Could not get banner view from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f18330a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public final void mo2171a(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void mo2172a(IObjectWrapper iObjectWrapper, zzaem com_google_android_gms_internal_zzaem, List<String> list) {
    }

    public final void mo2173a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, zzaem com_google_android_gms_internal_zzaem, String str2) throws RemoteException {
    }

    public final void mo2174a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        mo2175a(iObjectWrapper, com_google_android_gms_internal_zzjj, str, null, com_google_android_gms_internal_zzvd);
    }

    public final void mo2175a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, String str2, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        if (this.f18330a instanceof MediationInterstitialAdapter) {
            zzakb.m5366b("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f18330a;
                MediationInterstitialListener com_google_android_gms_internal_zzvx = new zzvx(com_google_android_gms_internal_zzvd);
                Activity activity = (Activity) zzn.m17693a(iObjectWrapper);
                int i = com_google_android_gms_internal_zzjj.f18140g;
                mediationInterstitialAdapter.requestInterstitialAd(com_google_android_gms_internal_zzvx, activity, m19133a(str), zzwj.m6774a(com_google_android_gms_internal_zzjj, m19134a(com_google_android_gms_internal_zzjj)), this.f18331b);
            } catch (Throwable th) {
                zzakb.m5369c("Could not request interstitial ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f18330a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void mo2176a(IObjectWrapper iObjectWrapper, zzjj com_google_android_gms_internal_zzjj, String str, String str2, zzvd com_google_android_gms_internal_zzvd, zzpe com_google_android_gms_internal_zzpe, List<String> list) {
    }

    public final void mo2177a(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, zzjj com_google_android_gms_internal_zzjj, String str, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        mo2178a(iObjectWrapper, com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzjj, str, null, com_google_android_gms_internal_zzvd);
    }

    public final void mo2178a(IObjectWrapper iObjectWrapper, zzjn com_google_android_gms_internal_zzjn, zzjj com_google_android_gms_internal_zzjj, String str, String str2, zzvd com_google_android_gms_internal_zzvd) throws RemoteException {
        if (this.f18330a instanceof MediationBannerAdapter) {
            zzakb.m5366b("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.f18330a;
                MediationBannerListener com_google_android_gms_internal_zzvx = new zzvx(com_google_android_gms_internal_zzvd);
                Activity activity = (Activity) zzn.m17693a(iObjectWrapper);
                int i = com_google_android_gms_internal_zzjj.f18140g;
                mediationBannerAdapter.requestBannerAd(com_google_android_gms_internal_zzvx, activity, m19133a(str), zzwj.m6773a(com_google_android_gms_internal_zzjn), zzwj.m6774a(com_google_android_gms_internal_zzjj, m19134a(com_google_android_gms_internal_zzjj)), this.f18331b);
            } catch (Throwable th) {
                zzakb.m5369c("Could not request banner ad from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str3 = "MediationAdapter is not a MediationBannerAdapter: ";
            String valueOf = String.valueOf(this.f18330a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
            throw new RemoteException();
        }
    }

    public final void mo2179a(zzjj com_google_android_gms_internal_zzjj, String str) {
    }

    public final void mo2180a(zzjj com_google_android_gms_internal_zzjj, String str, String str2) {
    }

    public final void mo2181a(boolean z) {
    }

    public final void mo2182b() throws RemoteException {
        if (this.f18330a instanceof MediationInterstitialAdapter) {
            zzakb.m5366b("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.f18330a).showInterstitial();
            } catch (Throwable th) {
                zzakb.m5369c("Could not show interstitial from adapter.", th);
                RemoteException remoteException = new RemoteException();
            }
        } else {
            String str = "MediationAdapter is not a MediationInterstitialAdapter: ";
            String valueOf = String.valueOf(this.f18330a.getClass().getCanonicalName());
            zzakb.m5371e(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            throw new RemoteException();
        }
    }

    public final void mo2183c() throws RemoteException {
        try {
            this.f18330a.destroy();
        } catch (Throwable th) {
            zzakb.m5369c("Could not destroy adapter.", th);
            RemoteException remoteException = new RemoteException();
        }
    }

    public final void mo2184d() throws RemoteException {
        throw new RemoteException();
    }

    public final void mo2185e() throws RemoteException {
        throw new RemoteException();
    }

    public final void mo2186f() {
    }

    public final boolean mo2187g() {
        return true;
    }

    public final zzvj mo2188h() {
        return null;
    }

    public final zzvm mo2189i() {
        return null;
    }

    public final Bundle mo2190j() {
        return new Bundle();
    }

    public final Bundle mo2191k() {
        return new Bundle();
    }

    public final Bundle mo2192l() {
        return new Bundle();
    }

    public final boolean mo2193m() {
        return false;
    }

    public final zzqm mo2194n() {
        return null;
    }

    public final zzll mo2195o() {
        return null;
    }
}
