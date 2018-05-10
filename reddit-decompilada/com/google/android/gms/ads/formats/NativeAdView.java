package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzjr;
import com.google.android.gms.internal.zzjx;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzpu;

public class NativeAdView extends FrameLayout {
    private final FrameLayout f5405a;
    private final zzpu f5406b = m4408a();

    public NativeAdView(Context context) {
        super(context);
        this.f5405a = m4407a(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5405a = m4407a(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5405a = m4407a(context);
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f5405a = m4407a(context);
    }

    private final FrameLayout m4407a(Context context) {
        View frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    protected final View m4409a(String str) {
        try {
            IObjectWrapper a = this.f5406b.mo2097a(str);
            if (a != null) {
                return (View) zzn.m17693a(a);
            }
        } catch (Throwable e) {
            zzakb.m5367b("Unable to call getAssetView on delegate", e);
        }
        return null;
    }

    protected final void m4410a(String str, View view) {
        try {
            this.f5406b.mo2101a(str, zzn.m17692a((Object) view));
        } catch (Throwable e) {
            zzakb.m5367b("Unable to call setAssetView on delegate", e);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.f5405a);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        if (this.f5405a != view) {
            super.bringChildToFront(this.f5405a);
        }
    }

    public AdChoicesView getAdChoicesView() {
        View a = m4409a("1098");
        return a instanceof AdChoicesView ? (AdChoicesView) a : null;
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.f5406b != null) {
            try {
                this.f5406b.mo2100a(zzn.m17692a((Object) view), i);
            } catch (Throwable e) {
                zzakb.m5367b("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f5405a);
    }

    public void removeView(View view) {
        if (this.f5405a != view) {
            super.removeView(view);
        }
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        m4410a("1098", adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.f5406b.mo2099a((IObjectWrapper) nativeAd.mo3546a());
        } catch (Throwable e) {
            zzakb.m5367b("Unable to call setNativeAd on delegate", e);
        }
    }

    private final zzpu m4408a() {
        zzbq.m4809a(this.f5405a, (Object) "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        zzjr b = zzkb.m6346b();
        Context context = this.f5405a.getContext();
        return (zzpu) zzjr.m6338a(context, false, new zzjx(b, this, this.f5405a, context));
    }
}
