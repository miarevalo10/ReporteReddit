package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;

@zzzv
public final class zzpt extends Image {
    private final zzpq f14605a;
    private final Drawable f14606b;
    private final Uri f14607c;
    private final double f14608d;

    public zzpt(zzpq com_google_android_gms_internal_zzpq) {
        Drawable drawable;
        double d;
        this.f14605a = com_google_android_gms_internal_zzpq;
        Uri uri = null;
        try {
            IObjectWrapper a = this.f14605a.mo2091a();
            if (a != null) {
                drawable = (Drawable) zzn.m17693a(a);
                this.f14606b = drawable;
                uri = this.f14605a.mo2092b();
                this.f14607c = uri;
                d = 1.0d;
                d = this.f14605a.mo2093c();
                this.f14608d = d;
            }
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get drawable.", e);
        }
        drawable = null;
        this.f14606b = drawable;
        try {
            uri = this.f14605a.mo2092b();
        } catch (Throwable e2) {
            zzakb.m5367b("Failed to get uri.", e2);
        }
        this.f14607c = uri;
        d = 1.0d;
        try {
            d = this.f14605a.mo2093c();
        } catch (Throwable e3) {
            zzakb.m5367b("Failed to get scale.", e3);
        }
        this.f14608d = d;
    }

    public final Drawable mo2094a() {
        return this.f14606b;
    }

    public final Uri mo2095b() {
        return this.f14607c;
    }

    public final double mo2096c() {
        return this.f14608d;
    }
}
