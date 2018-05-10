package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.zzba;
import java.lang.ref.WeakReference;

@zzzv
public final class zzyt {
    final Context f8175a;
    final zzcv f8176b;
    final zzafp f8177c;
    final zznu f8178d;
    final zzba f8179e;
    private final Object f8180f = new Object();
    private OnGlobalLayoutListener f8181g;
    private OnScrollChangedListener f8182h;
    private zzaji f8183i;
    private int f8184j = -1;
    private int f8185k = -1;

    public zzyt(Context context, zzcv com_google_android_gms_internal_zzcv, zzafp com_google_android_gms_internal_zzafp, zznu com_google_android_gms_internal_zznu, zzba com_google_android_gms_ads_internal_zzba) {
        this.f8175a = context;
        this.f8176b = com_google_android_gms_internal_zzcv;
        this.f8177c = com_google_android_gms_internal_zzafp;
        this.f8178d = com_google_android_gms_internal_zznu;
        this.f8179e = com_google_android_gms_ads_internal_zzba;
        this.f8183i = new zzaji(200);
    }

    static /* synthetic */ OnGlobalLayoutListener m6823a(zzyt com_google_android_gms_internal_zzyt, WeakReference weakReference) {
        if (com_google_android_gms_internal_zzyt.f8181g == null) {
            com_google_android_gms_internal_zzyt.f8181g = new zzyz(com_google_android_gms_internal_zzyt, weakReference);
        }
        return com_google_android_gms_internal_zzyt.f8181g;
    }

    static /* synthetic */ OnScrollChangedListener m6827b(zzyt com_google_android_gms_internal_zzyt, WeakReference weakReference) {
        if (com_google_android_gms_internal_zzyt.f8182h == null) {
            com_google_android_gms_internal_zzyt.f8182h = new zzza(com_google_android_gms_internal_zzyt, weakReference);
        }
        return com_google_android_gms_internal_zzyt.f8182h;
    }

    static /* synthetic */ void m6825a(zzyt com_google_android_gms_internal_zzyt, zzanh com_google_android_gms_internal_zzanh) {
        com_google_android_gms_internal_zzanh = com_google_android_gms_internal_zzanh.mo4019w();
        com_google_android_gms_internal_zzanh.m5446a("/video", zzd.f5437l);
        com_google_android_gms_internal_zzanh.m5446a("/videoMeta", zzd.f5438m);
        com_google_android_gms_internal_zzanh.m5446a("/precache", new zzane());
        com_google_android_gms_internal_zzanh.m5446a("/delayPageLoaded", zzd.f5441p);
        com_google_android_gms_internal_zzanh.m5446a("/instrument", zzd.f5439n);
        com_google_android_gms_internal_zzanh.m5446a("/log", zzd.f5432g);
        com_google_android_gms_internal_zzanh.m5446a("/videoClicked", zzd.f5433h);
        com_google_android_gms_internal_zzanh.m5446a("/trackActiveViewUnit", new zzyx(com_google_android_gms_internal_zzyt));
        com_google_android_gms_internal_zzanh.m5446a("/untrackActiveViewUnit", new zzyy(com_google_android_gms_internal_zzyt));
    }

    static /* synthetic */ void m6826a(zzyt com_google_android_gms_internal_zzyt, WeakReference weakReference, boolean z) {
        if (weakReference != null) {
            zzanh com_google_android_gms_internal_zzanh = (zzanh) weakReference.get();
            if (com_google_android_gms_internal_zzanh != null) {
                if (com_google_android_gms_internal_zzanh == null) {
                    throw null;
                }
                View view = (View) com_google_android_gms_internal_zzanh;
                if (view != null) {
                    if (!z || com_google_android_gms_internal_zzyt.f8183i.m5301a()) {
                        if (com_google_android_gms_internal_zzanh == null) {
                            throw null;
                        }
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        zzkb.m6345a();
                        int b = zzajr.m5329b(com_google_android_gms_internal_zzyt.f8175a, iArr[0]);
                        zzkb.m6345a();
                        int b2 = zzajr.m5329b(com_google_android_gms_internal_zzyt.f8175a, iArr[1]);
                        synchronized (com_google_android_gms_internal_zzyt.f8180f) {
                            if (!(com_google_android_gms_internal_zzyt.f8184j == b && com_google_android_gms_internal_zzyt.f8185k == b2)) {
                                com_google_android_gms_internal_zzyt.f8184j = b;
                                com_google_android_gms_internal_zzyt.f8185k = b2;
                                com_google_android_gms_internal_zzanh.mo4019w().m5442a(com_google_android_gms_internal_zzyt.f8184j, com_google_android_gms_internal_zzyt.f8185k, z ^ true);
                            }
                        }
                    }
                }
            }
        }
    }
}
