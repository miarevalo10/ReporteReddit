package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzbs;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@zzzv
@TargetApi(11)
public class zzaos extends zzani {
    public zzaos(zzanh com_google_android_gms_internal_zzanh, boolean z) {
        super(com_google_android_gms_internal_zzanh, z);
    }

    protected final WebResourceResponse m13412a(WebView webView, String str, Map<String, String> map) {
        if (webView instanceof zzanh) {
            zzanh com_google_android_gms_internal_zzanh = (zzanh) webView;
            if (this.m != null) {
                this.m.mo1705a(str, map, 1);
            }
            if ("mraid.js".equalsIgnoreCase(new File(str).getName()) == null) {
                return super.shouldInterceptRequest(webView, str);
            }
            if (com_google_android_gms_internal_zzanh.mo4019w() != null) {
                webView = com_google_android_gms_internal_zzanh.mo4019w();
                synchronized (webView.f6616c) {
                    webView.f6620g = false;
                    webView.f6621h = true;
                    zzbs.m4486e();
                    zzahn.m5173a(new zzanl(webView));
                }
            }
            zzmx com_google_android_gms_internal_zzmx = com_google_android_gms_internal_zzanh.mo3474u().m5488c() != null ? zznh.f7871G : com_google_android_gms_internal_zzanh.mo3476z() != null ? zznh.f7870F : zznh.f7869E;
            String str2 = (String) zzkb.m6350f().m6488a(com_google_android_gms_internal_zzmx);
            try {
                Context context = com_google_android_gms_internal_zzanh.getContext();
                String str3 = com_google_android_gms_internal_zzanh.mo3472k().f17551a;
                Map hashMap = new HashMap();
                hashMap.put("User-Agent", zzbs.m4486e().m5225a(context, str3));
                hashMap.put(HttpRequest.HEADER_CACHE_CONTROL, "max-stale=3600");
                zzaiv com_google_android_gms_internal_zzaiv = new zzaiv(context);
                str2 = (String) zzaiv.m5293a(0, str2, hashMap, null).get(60, TimeUnit.SECONDS);
                if (str2 == null) {
                    return null;
                }
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str2.getBytes("UTF-8")));
            } catch (WebView webView2) {
                str = "Could not fetch MRAID JS. ";
                webView2 = String.valueOf(webView2.getMessage());
                zzakb.m5371e(webView2.length() == null ? new String(str) : str.concat(webView2));
                return null;
            }
        }
        zzakb.m5371e("Tried to intercept request from a WebView that wasn't an AdWebView.");
        return null;
    }
}
