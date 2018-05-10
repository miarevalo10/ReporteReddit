package com.google.android.gms.ads.internal;

import android.view.View;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.internal.zzanh;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class zzat implements zzt<zzanh> {
    private /* synthetic */ CountDownLatch f13775a;

    zzat(CountDownLatch countDownLatch) {
        this.f13775a = countDownLatch;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzanh com_google_android_gms_internal_zzanh = (zzanh) obj;
        this.f13775a.countDown();
        if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        }
        ((View) com_google_android_gms_internal_zzanh).setVisibility(0);
    }
}
