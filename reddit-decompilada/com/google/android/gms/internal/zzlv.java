package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import java.util.concurrent.atomic.AtomicBoolean;

@zzzv
public final class zzlv {
    public final zzuw f7810a;
    public final VideoController f7811b;
    public zzkd f7812c;
    public zzje f7813d;
    public AdListener f7814e;
    public AdSize[] f7815f;
    public AppEventListener f7816g;
    public Correlator f7817h;
    public zzks f7818i;
    public OnCustomRenderedAdLoadedListener f7819j;
    public VideoOptions f7820k;
    public String f7821l;
    public ViewGroup f7822m;
    public int f7823n;
    public boolean f7824o;
    private final zzjm f7825p;
    private final AtomicBoolean f7826q;

    public zzlv(ViewGroup viewGroup) {
        this(viewGroup, zzjm.f7755a, (byte) 0);
    }

    private zzlv(ViewGroup viewGroup, zzjm com_google_android_gms_internal_zzjm) {
        this.f7810a = new zzuw();
        this.f7811b = new VideoController();
        this.f7812c = new zzlw(this);
        this.f7822m = viewGroup;
        this.f7825p = com_google_android_gms_internal_zzjm;
        this.f7818i = null;
        this.f7826q = new AtomicBoolean(false);
        this.f7823n = 0;
    }

    private zzlv(ViewGroup viewGroup, zzjm com_google_android_gms_internal_zzjm, byte b) {
        this(viewGroup, com_google_android_gms_internal_zzjm);
    }

    public final AdSize m6456a() {
        try {
            if (this.f7818i != null) {
                zzjn k = this.f7818i.mo2008k();
                if (k != null) {
                    return k.m18780c();
                }
            }
        } catch (Throwable e) {
            zzakb.m5369c("Failed to get the current AdSize.", e);
        }
        return this.f7815f != null ? this.f7815f[0] : null;
    }

    public final void m6458a(AppEventListener appEventListener) {
        try {
            this.f7816g = appEventListener;
            if (this.f7818i != null) {
                this.f7818i.mo1994a(appEventListener != null ? new zzjp(appEventListener) : null);
            }
        } catch (Throwable e) {
            zzakb.m5369c("Failed to set the AppEventListener.", e);
        }
    }

    public final void m6459a(zzje com_google_android_gms_internal_zzje) {
        try {
            this.f7813d = com_google_android_gms_internal_zzje;
            if (this.f7818i != null) {
                this.f7818i.mo1992a(com_google_android_gms_internal_zzje != null ? new zzjf(com_google_android_gms_internal_zzje) : null);
            }
        } catch (Throwable e) {
            zzakb.m5369c("Failed to set the AdClickListener.", e);
        }
    }

    public final void m6460a(String str) {
        if (this.f7821l != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.f7821l = str;
    }

    public final void m6461a(AdSize... adSizeArr) {
        if (this.f7815f != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        m6463b(adSizeArr);
    }

    public final String m6462b() {
        if (this.f7821l == null && this.f7818i != null) {
            try {
                this.f7821l = this.f7818i.mo1985A();
            } catch (Throwable e) {
                zzakb.m5369c("Failed to get ad unit id.", e);
            }
        }
        return this.f7821l;
    }

    public final void m6463b(AdSize... adSizeArr) {
        this.f7815f = adSizeArr;
        try {
            if (this.f7818i != null) {
                this.f7818i.mo1991a(m6455a(this.f7822m.getContext(), this.f7815f, this.f7823n));
            }
        } catch (Throwable e) {
            zzakb.m5369c("Failed to set the ad size.", e);
        }
        this.f7822m.requestLayout();
    }

    public final String m6464c() {
        try {
            if (this.f7818i != null) {
                return this.f7818i.g_();
            }
        } catch (Throwable e) {
            zzakb.m5369c("Failed to get the mediation adapter class name.", e);
        }
        return null;
    }

    public final zzll m6465d() {
        if (this.f7818i == null) {
            return null;
        }
        try {
            return this.f7818i.mo2015r();
        } catch (Throwable e) {
            zzakb.m5369c("Failed to retrieve VideoController.", e);
            return null;
        }
    }

    public final void m6457a(AdListener adListener) {
        this.f7814e = adListener;
        zzkd com_google_android_gms_internal_zzkd = this.f7812c;
        synchronized (com_google_android_gms_internal_zzkd.f14567a) {
            com_google_android_gms_internal_zzkd.f14568b = adListener;
        }
    }

    public static zzjn m6455a(Context context, AdSize[] adSizeArr, int i) {
        zzjn com_google_android_gms_internal_zzjn = new zzjn(context, adSizeArr);
        context = true;
        if (i != 1) {
            context = null;
        }
        com_google_android_gms_internal_zzjn.f18161j = context;
        return com_google_android_gms_internal_zzjn;
    }
}
