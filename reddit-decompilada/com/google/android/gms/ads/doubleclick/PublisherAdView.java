package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzod;

public final class PublisherAdView extends ViewGroup {
    private final zzlv f5394a;

    public final AdSize getAdSize() {
        return this.f5394a.m6456a();
    }

    public final String getAdUnitId() {
        return this.f5394a.m6462b();
    }

    public final String getMediationAdapterClassName() {
        return this.f5394a.m6464c();
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            i3 = ((i3 - i) - measuredWidth) / 2;
            i4 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i3, i4, measuredWidth + i3, measuredHeight + i4);
        }
    }

    protected final void onMeasure(int i, int i2) {
        int a;
        int i3 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (Throwable e) {
                zzakb.m5367b("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int b = adSize.m4373b(context);
                a = adSize.m4372a(context);
                i3 = b;
            } else {
                a = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i3 = childAt.getMeasuredWidth();
            a = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i3, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(a, getSuggestedMinimumHeight()), i2));
    }

    public final void setAdListener(AdListener adListener) {
        this.f5394a.m6457a(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr != null) {
            if (adSizeArr.length > 0) {
                this.f5394a.m6463b(adSizeArr);
                return;
            }
        }
        throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    }

    public final void setAdUnitId(String str) {
        this.f5394a.m6460a(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.f5394a.m6458a(appEventListener);
    }

    public final VideoController getVideoController() {
        return this.f5394a.f7811b;
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        zzlv com_google_android_gms_internal_zzlv = this.f5394a;
        com_google_android_gms_internal_zzlv.f7820k = videoOptions;
        try {
            if (com_google_android_gms_internal_zzlv.f7818i != null) {
                com_google_android_gms_internal_zzlv.f7818i.mo1997a(videoOptions == null ? null : new zzmr(videoOptions));
            }
        } catch (VideoOptions videoOptions2) {
            zzakb.m5369c("Failed to set video options.", videoOptions2);
        }
    }

    public final VideoOptions getVideoOptions() {
        return this.f5394a.f7820k;
    }

    public final AdListener getAdListener() {
        return this.f5394a.f7814e;
    }

    public final AdSize[] getAdSizes() {
        return this.f5394a.f7815f;
    }

    public final AppEventListener getAppEventListener() {
        return this.f5394a.f7816g;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.f5394a.f7819j;
    }

    public final void setManualImpressionsEnabled(boolean z) {
        zzlv com_google_android_gms_internal_zzlv = this.f5394a;
        com_google_android_gms_internal_zzlv.f7824o = z;
        try {
            if (com_google_android_gms_internal_zzlv.f7818i) {
                com_google_android_gms_internal_zzlv.f7818i.mo2002b(com_google_android_gms_internal_zzlv.f7824o);
            }
        } catch (boolean z2) {
            zzakb.m5369c("Failed to set manual impressions.", z2);
        }
    }

    public final void setCorrelator(Correlator correlator) {
        zzlv com_google_android_gms_internal_zzlv = this.f5394a;
        com_google_android_gms_internal_zzlv.f7817h = correlator;
        try {
            if (com_google_android_gms_internal_zzlv.f7818i != null) {
                com_google_android_gms_internal_zzlv.f7818i.mo1995a(com_google_android_gms_internal_zzlv.f7817h == null ? null : com_google_android_gms_internal_zzlv.f7817h.f5382a);
            }
        } catch (Correlator correlator2) {
            zzakb.m5369c("Failed to set correlator.", correlator2);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        zzlv com_google_android_gms_internal_zzlv = this.f5394a;
        com_google_android_gms_internal_zzlv.f7819j = onCustomRenderedAdLoadedListener;
        try {
            if (com_google_android_gms_internal_zzlv.f7818i != null) {
                com_google_android_gms_internal_zzlv.f7818i.mo1998a(onCustomRenderedAdLoadedListener != null ? new zzod(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener2) {
            zzakb.m5369c("Failed to set the onCustomRenderedAdLoadedListener.", onCustomRenderedAdLoadedListener2);
        }
    }
}
