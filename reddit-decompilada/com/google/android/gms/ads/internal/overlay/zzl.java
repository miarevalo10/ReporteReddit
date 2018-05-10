package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.util.zzq;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzzv;

@zzzv
public final class zzl {
    public static void m4450a(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.f17090k == 4 && adOverlayInfoParcel.f17082c == null) {
            if (adOverlayInfoParcel.f17081b != null) {
                adOverlayInfoParcel.f17081b.mo1263e();
            }
            zzbs.m4483b();
            zza.m4449a(context, adOverlayInfoParcel.f17080a, adOverlayInfoParcel.f17088i);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.f17092m.f17554d);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.m17397a(intent, adOverlayInfoParcel);
        if (!zzq.m4915g()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzbs.m4486e();
        zzahn.m5167a(context, intent);
    }
}
