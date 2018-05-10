package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.zzn;
import java.util.WeakHashMap;

@zzzv
public final class zzqp implements NativeCustomTemplateAd {
    private static WeakHashMap<IBinder, zzqp> f14609b = new WeakHashMap();
    final zzqm f14610a;
    private final MediaView f14611c;
    private final VideoController f14612d = new VideoController();

    private zzqp(zzqm com_google_android_gms_internal_zzqm) {
        Context context;
        this.f14610a = com_google_android_gms_internal_zzqm;
        MediaView mediaView = null;
        try {
            context = (Context) zzn.m17693a(com_google_android_gms_internal_zzqm.mo2147e());
        } catch (Throwable e) {
            zzakb.m5367b("Unable to inflate MediaView.", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.f14610a.mo2141a(zzn.m17692a((Object) mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (Throwable e2) {
                zzakb.m5367b("Unable to render video in MediaView.", e2);
            }
        }
        this.f14611c = mediaView;
    }

    public static zzqp m14221a(zzqm com_google_android_gms_internal_zzqm) {
        synchronized (f14609b) {
            zzqp com_google_android_gms_internal_zzqp = (zzqp) f14609b.get(com_google_android_gms_internal_zzqm.asBinder());
            if (com_google_android_gms_internal_zzqp != null) {
                return com_google_android_gms_internal_zzqp;
            }
            com_google_android_gms_internal_zzqp = new zzqp(com_google_android_gms_internal_zzqm);
            f14609b.put(com_google_android_gms_internal_zzqm.asBinder(), com_google_android_gms_internal_zzqp);
            return com_google_android_gms_internal_zzqp;
        }
    }

    public final String mo2150a() {
        try {
            return this.f14610a.mo2149l();
        } catch (Throwable e) {
            zzakb.m5367b("Failed to get custom template id.", e);
            return null;
        }
    }
}
