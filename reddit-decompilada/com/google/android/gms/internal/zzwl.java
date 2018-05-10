package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.zzq;

@zzzv
public final class zzwl implements MediationInterstitialAdapter {
    private Activity f18332a;
    private MediationInterstitialListener f18333b;
    private Uri f18334c;

    public final void onDestroy() {
        zzakb.m5366b("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzakb.m5366b("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzakb.m5366b("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f18333b = mediationInterstitialListener;
        if (this.f18333b == null) {
            zzakb.m5371e("Listener not set for mediation. Returning.");
        } else if (context instanceof Activity) {
            int i = (zzq.m4909a() && zzoe.m14110a(context)) ? 1 : 0;
            if (i == 0) {
                zzakb.m5371e("Default browser does not support custom tabs. Bailing out.");
                this.f18333b.mo2260b(0);
                return;
            }
            Object string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzakb.m5371e("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.f18333b.mo2260b(0);
                return;
            }
            this.f18332a = (Activity) context;
            this.f18334c = Uri.parse(string);
            this.f18333b.mo2265f();
        } else {
            zzakb.m5371e("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.f18333b.mo2260b(0);
        }
    }

    public final void showInterstitial() {
        CustomTabsIntent a = new Builder().m146a();
        a.f395a.setData(this.f18334c);
        zzahn.f6379a.post(new zzwn(this, new AdOverlayInfoParcel(new zzc(a.f395a), null, new zzwm(this), null, new zzakd(0, 0, false))));
        zzbs.m4490i().f14078g.m5115a(zzafw.f6349b, zzafw.f6350c);
    }
}
