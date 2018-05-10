package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.ads.formats.NativeAd.AdChoicesInfo;
import com.google.android.gms.ads.formats.NativeAd.Image;
import java.util.ArrayList;
import java.util.List;

@zzzv
public final class zzpp extends AdChoicesInfo {
    private final zzpm f14602a;
    private final List<Image> f14603b = new ArrayList();
    private String f14604c;

    public zzpp(zzpm com_google_android_gms_internal_zzpm) {
        this.f14602a = com_google_android_gms_internal_zzpm;
        try {
            this.f14604c = this.f14602a.mo2089a();
        } catch (Throwable e) {
            zzakb.m5367b("Error while obtaining attribution text.", e);
            this.f14604c = "";
        }
        try {
            for (Object next : com_google_android_gms_internal_zzpm.mo2090b()) {
                zzpq com_google_android_gms_internal_zzps;
                if (next instanceof IBinder) {
                    IBinder iBinder = (IBinder) next;
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
                        com_google_android_gms_internal_zzps = queryLocalInterface instanceof zzpq ? (zzpq) queryLocalInterface : new zzps(iBinder);
                        if (com_google_android_gms_internal_zzps != null) {
                            this.f14603b.add(new zzpt(com_google_android_gms_internal_zzps));
                        }
                    }
                }
                com_google_android_gms_internal_zzps = null;
                if (com_google_android_gms_internal_zzps != null) {
                    this.f14603b.add(new zzpt(com_google_android_gms_internal_zzps));
                }
            }
        } catch (Throwable e2) {
            zzakb.m5367b("Error while obtaining image.", e2);
        }
    }
}
