package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzadu;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzjf;
import com.google.android.gms.internal.zzjg;
import com.google.android.gms.internal.zzjm;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjp;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzju;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzlx;
import com.google.android.gms.internal.zzod;

public final class InterstitialAd {
    public final zzlx f5383a;

    public InterstitialAd(Context context) {
        this.f5383a = new zzlx(context);
        zzbq.m4809a((Object) context, (Object) "Context cannot be null");
    }

    public final void m4379a(AdRequest adRequest) {
        zzlx com_google_android_gms_internal_zzlx = this.f5383a;
        adRequest = adRequest.zzbg();
        try {
            if (com_google_android_gms_internal_zzlx.f7831e == null) {
                String str = "loadAd";
                if (com_google_android_gms_internal_zzlx.f7832f == null) {
                    com_google_android_gms_internal_zzlx.m6466a(str);
                }
                zzjn b = com_google_android_gms_internal_zzlx.f7837k ? zzjn.m18778b() : new zzjn();
                zzjr b2 = zzkb.m6346b();
                Context context = com_google_android_gms_internal_zzlx.f7828b;
                com_google_android_gms_internal_zzlx.f7831e = (zzks) zzjr.m6338a(context, false, new zzju(b2, context, b, com_google_android_gms_internal_zzlx.f7832f, com_google_android_gms_internal_zzlx.f7827a));
                if (com_google_android_gms_internal_zzlx.f7829c != null) {
                    com_google_android_gms_internal_zzlx.f7831e.mo1993a(new zzjg(com_google_android_gms_internal_zzlx.f7829c));
                }
                if (com_google_android_gms_internal_zzlx.f7830d != null) {
                    com_google_android_gms_internal_zzlx.f7831e.mo1992a(new zzjf(com_google_android_gms_internal_zzlx.f7830d));
                }
                if (com_google_android_gms_internal_zzlx.f7833g != null) {
                    com_google_android_gms_internal_zzlx.f7831e.mo1994a(new zzjp(com_google_android_gms_internal_zzlx.f7833g));
                }
                if (com_google_android_gms_internal_zzlx.f7834h != null) {
                    com_google_android_gms_internal_zzlx.f7831e.mo1998a(new zzod(com_google_android_gms_internal_zzlx.f7834h));
                }
                if (com_google_android_gms_internal_zzlx.f7835i != null) {
                    com_google_android_gms_internal_zzlx.f7831e.mo1995a(com_google_android_gms_internal_zzlx.f7835i.f5382a);
                }
                if (com_google_android_gms_internal_zzlx.f7836j != null) {
                    com_google_android_gms_internal_zzlx.f7831e.mo1990a(new zzadu(com_google_android_gms_internal_zzlx.f7836j));
                }
                com_google_android_gms_internal_zzlx.f7831e.mo2004c(com_google_android_gms_internal_zzlx.f7838l);
            }
            if (com_google_android_gms_internal_zzlx.f7831e.mo2003b(zzjm.m6331a(com_google_android_gms_internal_zzlx.f7828b, adRequest))) {
                com_google_android_gms_internal_zzlx.f7827a.f18313a = adRequest.f7786h;
            }
        } catch (AdRequest adRequest2) {
            zzakb.m5369c("Failed to load ad.", adRequest2);
        }
    }

    public final void m4380a(String str) {
        zzlx com_google_android_gms_internal_zzlx = this.f5383a;
        if (com_google_android_gms_internal_zzlx.f7832f != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        com_google_android_gms_internal_zzlx.f7832f = str;
    }

    public final void m4378a() {
        zzlx com_google_android_gms_internal_zzlx = this.f5383a;
        try {
            com_google_android_gms_internal_zzlx.m6466a("show");
            com_google_android_gms_internal_zzlx.f7831e.mo1988D();
        } catch (Throwable e) {
            zzakb.m5369c("Failed to show interstitial.", e);
        }
    }

    public final void m4381a(boolean z) {
        zzlx com_google_android_gms_internal_zzlx = this.f5383a;
        try {
            com_google_android_gms_internal_zzlx.f7838l = z;
            if (com_google_android_gms_internal_zzlx.f7831e != null) {
                com_google_android_gms_internal_zzlx.f7831e.mo2004c(z);
            }
        } catch (boolean z2) {
            zzakb.m5369c("Failed to set immersive mode", z2);
        }
    }
}
