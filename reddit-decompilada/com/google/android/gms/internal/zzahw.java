package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import java.util.Set;

@TargetApi(11)
public class zzahw extends zzahv {
    public zzani mo3436a(zzanh com_google_android_gms_internal_zzanh, boolean z) {
        return new zzaoq(com_google_android_gms_internal_zzanh, z);
    }

    public final Set<String> mo3437a(Uri uri) {
        return uri.getQueryParameterNames();
    }

    public final boolean mo1721a(Request request) {
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(1);
        return true;
    }

    public boolean mo3438a(Context context, WebSettings webSettings) {
        super.mo3438a(context, webSettings);
        return ((Boolean) zzajk.m5302a(context, new zzahx(context, webSettings))).booleanValue();
    }

    public final boolean mo3439a(Window window) {
        window.setFlags(16777216, 16777216);
        return true;
    }

    public final boolean mo3440b(View view) {
        view.setLayerType(0, null);
        return true;
    }

    public WebChromeClient mo3441c(zzanh com_google_android_gms_internal_zzanh) {
        return new zzaoi(com_google_android_gms_internal_zzanh);
    }

    public final boolean mo3442c(View view) {
        view.setLayerType(1, null);
        return true;
    }
}
