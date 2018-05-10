package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;

@zzzv
public final class zzamq {
    final Context f6564a;
    final String f6565b;
    final zzakd f6566c;
    final zzns f6567d;
    final zznu f6568e;
    final zzair f6569f = new zzair(new zzaiu().m5292a("min_1", Double.MIN_VALUE, 1.0d).m5292a("1_5", 1.0d, 5.0d).m5292a("5_10", 5.0d, 10.0d).m5292a("10_20", 10.0d, 20.0d).m5292a("20_30", 20.0d, 30.0d).m5292a("30_max", 30.0d, Double.MAX_VALUE));
    final long[] f6570g;
    final String[] f6571h;
    boolean f6572i = false;
    boolean f6573j = false;
    boolean f6574k = false;
    boolean f6575l = false;
    boolean f6576m;
    zzamb f6577n;
    boolean f6578o;
    boolean f6579p;
    long f6580q = -1;

    public zzamq(Context context, zzakd com_google_android_gms_internal_zzakd, String str, zznu com_google_android_gms_internal_zznu, zzns com_google_android_gms_internal_zzns) {
        int i = 0;
        this.f6564a = context;
        this.f6566c = com_google_android_gms_internal_zzakd;
        this.f6565b = str;
        this.f6568e = com_google_android_gms_internal_zznu;
        this.f6567d = com_google_android_gms_internal_zzns;
        String str2 = (String) zzkb.m6350f().m6488a(zznh.f7908q);
        if (str2 == null) {
            r1.f6571h = new String[0];
            r1.f6570g = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        r1.f6571h = new String[split.length];
        r1.f6570g = new long[split.length];
        while (i < split.length) {
            try {
                r1.f6570g[i] = Long.parseLong(split[i]);
            } catch (Throwable e) {
                zzakb.m5369c("Unable to parse frame hash target time number.", e);
                r1.f6570g[i] = -1;
            }
            i++;
        }
    }
}
