package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@zzzv
@TargetApi(21)
public final class zzaot extends zzaos {
    public zzaot(zzanh com_google_android_gms_internal_zzanh, boolean z) {
        super(com_google_android_gms_internal_zzanh, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest != null) {
            if (webResourceRequest.getUrl() != null) {
                return m13412a(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
            }
        }
        return null;
    }
}
