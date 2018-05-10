package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

@zzzv
@TargetApi(11)
public final class zzaoq extends zzaos {
    public zzaoq(zzanh com_google_android_gms_internal_zzanh, boolean z) {
        super(com_google_android_gms_internal_zzanh, z);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return m13412a(webView, str, null);
    }
}
