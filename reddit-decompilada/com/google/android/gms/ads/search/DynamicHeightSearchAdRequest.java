package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.zzlt;

public final class DynamicHeightSearchAdRequest {
    private final SearchAdRequest zzdoe;

    public static final class Builder {
        private final com.google.android.gms.ads.search.SearchAdRequest.Builder f5666a;
    }

    public final <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzdoe.getCustomEventExtrasBundle(cls);
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzdoe.getNetworkExtras(cls);
    }

    public final <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzdoe.getNetworkExtrasBundle(cls);
    }

    public final String getQuery() {
        return this.zzdoe.getQuery();
    }

    public final boolean isTestDevice(Context context) {
        return this.zzdoe.isTestDevice(context);
    }

    final zzlt zzbg() {
        return this.zzdoe.zzbg();
    }

    private DynamicHeightSearchAdRequest(Builder builder) {
        this.zzdoe = new SearchAdRequest(builder.f5666a);
    }
}
