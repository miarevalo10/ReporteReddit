package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@zzzv
public final class zzjm {
    public static final zzjm f7755a = new zzjm();

    protected zzjm() {
    }

    public static zzjj m6331a(Context context, zzlt com_google_android_gms_internal_zzlt) {
        Context context2;
        List list;
        String a;
        zzlt com_google_android_gms_internal_zzlt2 = com_google_android_gms_internal_zzlt;
        Date date = com_google_android_gms_internal_zzlt2.f7779a;
        long time = date != null ? date.getTime() : -1;
        String str = com_google_android_gms_internal_zzlt2.f7780b;
        int i = com_google_android_gms_internal_zzlt2.f7781c;
        Collection collection = com_google_android_gms_internal_zzlt2.f7782d;
        if (collection.isEmpty()) {
            context2 = context;
            list = null;
        } else {
            list = Collections.unmodifiableList(new ArrayList(collection));
            context2 = context;
        }
        boolean a2 = com_google_android_gms_internal_zzlt2.m6435a(context2);
        int i2 = com_google_android_gms_internal_zzlt2.f7790l;
        Location location = com_google_android_gms_internal_zzlt2.f7783e;
        Bundle b = com_google_android_gms_internal_zzlt2.m6436b(AdMobAdapter.class);
        boolean z = com_google_android_gms_internal_zzlt2.f7784f;
        String str2 = com_google_android_gms_internal_zzlt2.f7787i;
        SearchAdRequest searchAdRequest = com_google_android_gms_internal_zzlt2.f7789k;
        zzmn com_google_android_gms_internal_zzmn = searchAdRequest != null ? new zzmn(searchAdRequest) : null;
        context2 = context.getApplicationContext();
        if (context2 != null) {
            String packageName = context2.getPackageName();
            zzkb.m6345a();
            a = zzajr.m5322a(Thread.currentThread().getStackTrace(), packageName);
        } else {
            a = null;
        }
        return new zzjj(7, time, b, i, list, a2, i2, z, str2, com_google_android_gms_internal_zzmn, location, str, com_google_android_gms_internal_zzlt2.f7785g, com_google_android_gms_internal_zzlt2.f7791m, Collections.unmodifiableList(new ArrayList(com_google_android_gms_internal_zzlt2.f7792n)), com_google_android_gms_internal_zzlt2.f7788j, a, com_google_android_gms_internal_zzlt2.f7793o);
    }
}
