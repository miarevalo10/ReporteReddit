package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.webkit.WebChromeClient;

@TargetApi(14)
public class zzahy extends zzahw {
    public final String mo3962a(SslError sslError) {
        return sslError.getUrl();
    }

    public final WebChromeClient mo3441c(zzanh com_google_android_gms_internal_zzanh) {
        return new zzaor(com_google_android_gms_internal_zzanh);
    }

    public int mo3963f() {
        return 1;
    }
}
