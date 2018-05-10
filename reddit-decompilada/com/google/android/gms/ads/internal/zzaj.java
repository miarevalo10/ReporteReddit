package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzko;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzpe;
import com.google.android.gms.internal.zzqq;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.internal.zzrc;
import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class zzaj extends zzko {
    private zzkh f17153a;
    private zzqq f17154b;
    private zzrc f17155c;
    private zzqt f17156d;
    private SimpleArrayMap<String, zzqw> f17157e = new SimpleArrayMap();
    private SimpleArrayMap<String, zzqz> f17158f = new SimpleArrayMap();
    private zzrf f17159g;
    private zzjn f17160h;
    private PublisherAdViewOptions f17161i;
    private zzpe f17162j;
    private zzld f17163k;
    private final Context f17164l;
    private final zzux f17165m;
    private final String f17166n;
    private final zzakd f17167o;
    private final zzv f17168p;

    public zzaj(Context context, String str, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd, zzv com_google_android_gms_ads_internal_zzv) {
        this.f17164l = context;
        this.f17166n = str;
        this.f17165m = com_google_android_gms_internal_zzux;
        this.f17167o = com_google_android_gms_internal_zzakd;
        this.f17168p = com_google_android_gms_ads_internal_zzv;
    }

    public final zzkk mo1974a() {
        Context context = this.f17164l;
        String str = this.f17166n;
        zzux com_google_android_gms_internal_zzux = this.f17165m;
        zzakd com_google_android_gms_internal_zzakd = this.f17167o;
        zzkh com_google_android_gms_internal_zzkh = this.f17153a;
        zzqq com_google_android_gms_internal_zzqq = this.f17154b;
        zzrc com_google_android_gms_internal_zzrc = this.f17155c;
        zzqt com_google_android_gms_internal_zzqt = this.f17156d;
        SimpleArrayMap simpleArrayMap = this.f17158f;
        SimpleArrayMap simpleArrayMap2 = this.f17157e;
        zzpe com_google_android_gms_internal_zzpe = this.f17162j;
        zzld com_google_android_gms_internal_zzld = this.f17163k;
        zzv com_google_android_gms_ads_internal_zzv = this.f17168p;
        zzrf com_google_android_gms_internal_zzrf = this.f17159g;
        zzrf com_google_android_gms_internal_zzrf2 = com_google_android_gms_internal_zzrf;
        return new zzag(context, str, com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzakd, com_google_android_gms_internal_zzkh, com_google_android_gms_internal_zzqq, com_google_android_gms_internal_zzrc, com_google_android_gms_internal_zzqt, simpleArrayMap, simpleArrayMap2, com_google_android_gms_internal_zzpe, com_google_android_gms_internal_zzld, com_google_android_gms_ads_internal_zzv, com_google_android_gms_internal_zzrf2, this.f17160h, this.f17161i);
    }

    public final void mo1975a(PublisherAdViewOptions publisherAdViewOptions) {
        this.f17161i = publisherAdViewOptions;
    }

    public final void mo1976a(zzkh com_google_android_gms_internal_zzkh) {
        this.f17153a = com_google_android_gms_internal_zzkh;
    }

    public final void mo1977a(zzld com_google_android_gms_internal_zzld) {
        this.f17163k = com_google_android_gms_internal_zzld;
    }

    public final void mo1978a(zzpe com_google_android_gms_internal_zzpe) {
        this.f17162j = com_google_android_gms_internal_zzpe;
    }

    public final void mo1979a(zzqq com_google_android_gms_internal_zzqq) {
        this.f17154b = com_google_android_gms_internal_zzqq;
    }

    public final void mo1980a(zzqt com_google_android_gms_internal_zzqt) {
        this.f17156d = com_google_android_gms_internal_zzqt;
    }

    public final void mo1981a(zzrc com_google_android_gms_internal_zzrc) {
        this.f17155c = com_google_android_gms_internal_zzrc;
    }

    public final void mo1982a(zzrf com_google_android_gms_internal_zzrf, zzjn com_google_android_gms_internal_zzjn) {
        this.f17159g = com_google_android_gms_internal_zzrf;
        this.f17160h = com_google_android_gms_internal_zzjn;
    }

    public final void mo1983a(String str, zzqz com_google_android_gms_internal_zzqz, zzqw com_google_android_gms_internal_zzqw) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.f17158f.put(str, com_google_android_gms_internal_zzqz);
        this.f17157e.put(str, com_google_android_gms_internal_zzqw);
    }
}
