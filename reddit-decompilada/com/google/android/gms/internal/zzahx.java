package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebSettings;
import java.util.concurrent.Callable;

final class zzahx implements Callable<Boolean> {
    private /* synthetic */ Context f6390a;
    private /* synthetic */ WebSettings f6391b;

    zzahx(Context context, WebSettings webSettings) {
        this.f6390a = context;
        this.f6391b = webSettings;
    }

    public final /* synthetic */ Object call() throws Exception {
        if (this.f6390a.getCacheDir() != null) {
            this.f6391b.setAppCachePath(this.f6390a.getCacheDir().getAbsolutePath());
            this.f6391b.setAppCacheMaxSize(0);
            this.f6391b.setAppCacheEnabled(true);
        }
        this.f6391b.setDatabasePath(this.f6390a.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
        this.f6391b.setDatabaseEnabled(true);
        this.f6391b.setDomStorageEnabled(true);
        this.f6391b.setDisplayZoomControls(false);
        this.f6391b.setBuiltInZoomControls(true);
        this.f6391b.setSupportZoom(true);
        this.f6391b.setAllowContentAccess(false);
        return Boolean.valueOf(true);
    }
}
