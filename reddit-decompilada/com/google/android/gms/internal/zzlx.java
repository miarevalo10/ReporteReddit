package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

@zzzv
public final class zzlx {
    public final zzuw f7827a;
    public final Context f7828b;
    public AdListener f7829c;
    public zzje f7830d;
    public zzks f7831e;
    public String f7832f;
    public AppEventListener f7833g;
    public OnCustomRenderedAdLoadedListener f7834h;
    public Correlator f7835i;
    public RewardedVideoAdListener f7836j;
    public boolean f7837k;
    public boolean f7838l;
    private final zzjm f7839m;
    private PublisherInterstitialAd f7840n;

    public zzlx(Context context) {
        this(context, zzjm.f7755a);
    }

    private zzlx(Context context, zzjm com_google_android_gms_internal_zzjm) {
        this.f7827a = new zzuw();
        this.f7828b = context;
        this.f7839m = com_google_android_gms_internal_zzjm;
        this.f7840n = null;
    }

    public final void m6466a(String str) {
        if (this.f7831e == null) {
            StringBuilder stringBuilder = new StringBuilder(63 + String.valueOf(str).length());
            stringBuilder.append("The ad unit ID must be set on InterstitialAd before ");
            stringBuilder.append(str);
            stringBuilder.append(" is called.");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
