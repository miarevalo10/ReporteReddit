package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.common.internal.zzbq;

public final class AdView extends BaseAdView {
    public AdView(Context context) {
        super(context);
        zzbq.m4809a((Object) context, (Object) "Context cannot be null");
    }

    public final /* bridge */ /* synthetic */ void mo1497a() {
        super.mo1497a();
    }

    public final /* bridge */ /* synthetic */ void mo1498a(AdRequest adRequest) {
        super.mo1498a(adRequest);
    }

    public final /* bridge */ /* synthetic */ void mo1499b() {
        super.mo1499b();
    }

    public final /* bridge */ /* synthetic */ void mo1500c() {
        super.mo1500c();
    }

    public final /* bridge */ /* synthetic */ AdListener getAdListener() {
        return super.getAdListener();
    }

    public final /* bridge */ /* synthetic */ AdSize getAdSize() {
        return super.getAdSize();
    }

    public final /* bridge */ /* synthetic */ String getAdUnitId() {
        return super.getAdUnitId();
    }

    public final /* bridge */ /* synthetic */ String getMediationAdapterClassName() {
        return super.getMediationAdapterClassName();
    }

    public final /* bridge */ /* synthetic */ void setAdListener(AdListener adListener) {
        super.setAdListener(adListener);
    }

    public final /* bridge */ /* synthetic */ void setAdSize(AdSize adSize) {
        super.setAdSize(adSize);
    }

    public final /* bridge */ /* synthetic */ void setAdUnitId(String str) {
        super.setAdUnitId(str);
    }

    public final VideoController getVideoController() {
        return this.a != null ? this.a.f7811b : null;
    }
}
