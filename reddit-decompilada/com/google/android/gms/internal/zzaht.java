package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzbs;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@zzzv
@TargetApi(8)
public class zzaht {
    private zzaht() {
    }

    public static boolean m5232a(zzanh com_google_android_gms_internal_zzanh) {
        if (com_google_android_gms_internal_zzanh == null) {
            return false;
        }
        com_google_android_gms_internal_zzanh.onPause();
        return true;
    }

    public static boolean m5233b(zzanh com_google_android_gms_internal_zzanh) {
        if (com_google_android_gms_internal_zzanh == null) {
            return false;
        }
        com_google_android_gms_internal_zzanh.onResume();
        return true;
    }

    public static boolean m5234e() {
        int myUid = Process.myUid();
        if (myUid != 0) {
            if (myUid != 1000) {
                return false;
            }
        }
        return true;
    }

    public int mo1720a() {
        return 0;
    }

    public Drawable mo4387a(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public zzani mo3436a(zzanh com_google_android_gms_internal_zzanh, boolean z) {
        return new zzani(com_google_android_gms_internal_zzanh, z);
    }

    public String mo4388a(Context context) {
        return "";
    }

    public String mo3962a(SslError sslError) {
        return "";
    }

    public Set<String> mo3437a(Uri uri) {
        if (uri.isOpaque()) {
            return Collections.emptySet();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptySet();
        }
        Set linkedHashSet = new LinkedHashSet();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            linkedHashSet.add(Uri.decode(encodedQuery.substring(i, indexOf2)));
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public void mo4287a(Activity activity, OnGlobalLayoutListener onGlobalLayoutListener) {
        Window window = activity.getWindow();
        if (window != null && window.getDecorView() != null && window.getDecorView().getViewTreeObserver() != null) {
            mo4289a(window.getDecorView().getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public void mo4288a(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void mo4289a(ViewTreeObserver viewTreeObserver, OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public boolean mo1721a(Request request) {
        return false;
    }

    public boolean mo3438a(Context context, WebSettings webSettings) {
        return false;
    }

    public boolean mo4423a(View view) {
        if (view.getWindowToken() == null) {
            if (view.getWindowVisibility() == 8) {
                return false;
            }
        }
        return true;
    }

    public boolean mo3439a(Window window) {
        return false;
    }

    public int mo1722b() {
        return 1;
    }

    public void mo4389b(Context context) {
        zzbs.m4490i().m13271s();
    }

    public boolean mo3440b(View view) {
        return false;
    }

    public int mo4424c() {
        return 5;
    }

    public CookieManager mo4448c(Context context) {
        if (m5234e()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzakb.m5367b("Failed to obtain CookieManager.", th);
            zzbs.m4490i().m13246a(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public WebChromeClient mo3441c(zzanh com_google_android_gms_internal_zzanh) {
        return null;
    }

    public boolean mo3442c(View view) {
        return false;
    }

    public LayoutParams mo4446d() {
        return new LayoutParams(-2, -2);
    }

    public int mo3963f() {
        return 0;
    }
}
