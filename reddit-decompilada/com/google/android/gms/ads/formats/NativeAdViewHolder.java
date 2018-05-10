package com.google.android.gms.ads.formats;

import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzpz;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> f5407a = new WeakHashMap();
    private zzpz f5408b;
    private WeakReference<View> f5409c;

    public final void m4411a(NativeAd nativeAd) {
        Object obj = this.f5409c != null ? (View) this.f5409c.get() : null;
        if (obj == null) {
            zzakb.m5371e("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!f5407a.containsKey(obj)) {
            f5407a.put(obj, this);
        }
        if (this.f5408b != null) {
            try {
                this.f5408b.mo2104a((IObjectWrapper) nativeAd.mo3546a());
            } catch (Throwable e) {
                zzakb.m5367b("Unable to call setNativeAd on delegate", e);
            }
        }
    }
}
