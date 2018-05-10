package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@zzzv
public final class zzlt {
    public final Date f7779a;
    public final String f7780b;
    public final int f7781c;
    public final Set<String> f7782d;
    public final Location f7783e;
    public final boolean f7784f;
    final Bundle f7785g;
    public final Map<Class<? extends NetworkExtras>, NetworkExtras> f7786h;
    public final String f7787i;
    final String f7788j;
    final SearchAdRequest f7789k;
    final int f7790l;
    public final Bundle f7791m;
    final Set<String> f7792n;
    final boolean f7793o;
    private final Set<String> f7794p;

    public zzlt(zzlu com_google_android_gms_internal_zzlu) {
        this(com_google_android_gms_internal_zzlu, null);
    }

    public zzlt(zzlu com_google_android_gms_internal_zzlu, SearchAdRequest searchAdRequest) {
        this.f7779a = com_google_android_gms_internal_zzlu.f7799e;
        this.f7780b = com_google_android_gms_internal_zzlu.f7806l;
        this.f7781c = com_google_android_gms_internal_zzlu.f7800f;
        this.f7782d = Collections.unmodifiableSet(com_google_android_gms_internal_zzlu.f7795a);
        this.f7783e = com_google_android_gms_internal_zzlu.f7801g;
        this.f7784f = com_google_android_gms_internal_zzlu.f7807m;
        this.f7785g = com_google_android_gms_internal_zzlu.f7796b;
        this.f7786h = Collections.unmodifiableMap(com_google_android_gms_internal_zzlu.f7804j);
        this.f7787i = com_google_android_gms_internal_zzlu.f7808n;
        this.f7788j = com_google_android_gms_internal_zzlu.f7809o;
        this.f7789k = searchAdRequest;
        this.f7790l = com_google_android_gms_internal_zzlu.f7802h;
        this.f7794p = Collections.unmodifiableSet(com_google_android_gms_internal_zzlu.f7797c);
        this.f7791m = com_google_android_gms_internal_zzlu.f7798d;
        this.f7792n = Collections.unmodifiableSet(com_google_android_gms_internal_zzlu.f7805k);
        this.f7793o = com_google_android_gms_internal_zzlu.f7803i;
    }

    @Deprecated
    public final <T extends NetworkExtras> T m6434a(Class<T> cls) {
        return (NetworkExtras) this.f7786h.get(cls);
    }

    public final boolean m6435a(Context context) {
        Set set = this.f7794p;
        zzkb.m6345a();
        return set.contains(zzajr.m5320a(context));
    }

    public final Bundle m6436b(Class<? extends MediationAdapter> cls) {
        return this.f7785g.getBundle(cls.getName());
    }

    public final Bundle m6437c(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.f7785g.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        return bundle != null ? bundle.getBundle(cls.getName()) : null;
    }
}
