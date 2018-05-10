package com.google.android.gms.ads.internal;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zznh;

final class zzbn extends WebViewClient {
    private /* synthetic */ zzbm f5542a;

    zzbn(zzbm com_google_android_gms_ads_internal_zzbm) {
        this.f5542a = com_google_android_gms_ads_internal_zzbm;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.f5542a.f17191g != null) {
            try {
                this.f5542a.f17191g.mo1963a(0);
            } catch (Throwable e) {
                zzakb.m5369c("Could not call AdListener.onAdFailedToLoad().", e);
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.f5542a.m17548d())) {
            return false;
        }
        if (str.startsWith((String) zzkb.m6350f().m6488a(zznh.ce))) {
            if (this.f5542a.f17191g != null) {
                try {
                    this.f5542a.f17191g.mo1963a(3);
                } catch (Throwable e) {
                    zzakb.m5369c("Could not call AdListener.onAdFailedToLoad().", e);
                }
            }
            this.f5542a.m17530a(0);
            return true;
        }
        if (str.startsWith((String) zzkb.m6350f().m6488a(zznh.cf))) {
            if (this.f5542a.f17191g != null) {
                try {
                    this.f5542a.f17191g.mo1963a(0);
                } catch (Throwable e2) {
                    zzakb.m5369c("Could not call AdListener.onAdFailedToLoad().", e2);
                }
            }
            this.f5542a.m17530a(0);
            return true;
        }
        if (str.startsWith((String) zzkb.m6350f().m6488a(zznh.cg))) {
            if (this.f5542a.f17191g != null) {
                try {
                    this.f5542a.f17191g.mo1965c();
                } catch (Throwable e22) {
                    zzakb.m5369c("Could not call AdListener.onAdLoaded().", e22);
                }
            }
            this.f5542a.m17530a(this.f5542a.m17543b(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            if (this.f5542a.f17191g != null) {
                try {
                    this.f5542a.f17191g.mo1964b();
                } catch (Throwable e222) {
                    zzakb.m5369c("Could not call AdListener.onAdLeftApplication().", e222);
                }
            }
            zzbm.m17519b(this.f5542a, this.f5542a.m17521c(str));
            return true;
        }
    }
}
