package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.ref.WeakReference;
import java.util.Map;

@zzzv
public final class zzor extends zzow {
    private zzvj f18232e;
    private zzvm f18233f;
    private final zzot f18234g;
    private zzos f18235h;
    private boolean f18236i;
    private Object f18237j;

    private zzor(Context context, zzot com_google_android_gms_internal_zzot, zzcv com_google_android_gms_internal_zzcv, zzou com_google_android_gms_internal_zzou) {
        super(context, com_google_android_gms_internal_zzot, null, com_google_android_gms_internal_zzcv, null, com_google_android_gms_internal_zzou, null, null);
        this.f18236i = false;
        this.f18237j = new Object();
        this.f18234g = com_google_android_gms_internal_zzot;
    }

    public zzor(Context context, zzot com_google_android_gms_internal_zzot, zzcv com_google_android_gms_internal_zzcv, zzvj com_google_android_gms_internal_zzvj, zzou com_google_android_gms_internal_zzou) {
        this(context, com_google_android_gms_internal_zzot, com_google_android_gms_internal_zzcv, com_google_android_gms_internal_zzou);
        this.f18232e = com_google_android_gms_internal_zzvj;
    }

    public zzor(Context context, zzot com_google_android_gms_internal_zzot, zzcv com_google_android_gms_internal_zzcv, zzvm com_google_android_gms_internal_zzvm, zzou com_google_android_gms_internal_zzou) {
        this(context, com_google_android_gms_internal_zzot, com_google_android_gms_internal_zzcv, com_google_android_gms_internal_zzou);
        this.f18233f = com_google_android_gms_internal_zzvm;
    }

    public final View mo2070a(OnClickListener onClickListener, boolean z) {
        synchronized (this.f18237j) {
            if (this.f18235h != null) {
                View a = this.f18235h.mo2070a(onClickListener, z);
                return a;
            }
            IObjectWrapper n;
            try {
                if (this.f18232e != null) {
                    n = this.f18232e.mo2224n();
                } else {
                    if (this.f18233f != null) {
                        n = this.f18233f.mo2241k();
                    }
                    n = null;
                }
            } catch (Throwable e) {
                zzakb.m5369c("Failed to call getAdChoicesContent", e);
            }
            if (n != null) {
                a = (View) zzn.m17693a(n);
                return a;
            }
            return null;
        }
    }

    public final void mo2075a(View view, Map<String, WeakReference<View>> map) {
        zzbq.m4816b("recordImpression must be called on the main UI thread.");
        synchronized (this.f18237j) {
            this.f14577d = true;
            if (this.f18235h != null) {
                this.f18235h.mo2075a(view, (Map) map);
                this.f18234g.m6542U();
            } else {
                try {
                    zzot com_google_android_gms_internal_zzot;
                    if (this.f18232e != null && !this.f18232e.mo2220j()) {
                        this.f18232e.mo2219i();
                        com_google_android_gms_internal_zzot = this.f18234g;
                    } else if (!(this.f18233f == null || this.f18233f.mo2238h())) {
                        this.f18233f.mo2237g();
                        com_google_android_gms_internal_zzot = this.f18234g;
                    }
                    com_google_android_gms_internal_zzot.m6542U();
                } catch (Throwable e) {
                    zzakb.m5369c("Failed to call recordImpression", e);
                }
            }
        }
    }

    public final void mo2076a(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        zzbq.m4816b("performClick must be called on the main UI thread.");
        synchronized (this.f18237j) {
            if (this.f18235h != null) {
                this.f18235h.mo2076a(view, map, bundle, view2);
                this.f18234g.m6546e();
            } else {
                try {
                    if (!(this.f18232e == null || this.f18232e.mo2221k())) {
                        this.f18232e.mo2209a(zzn.m17692a((Object) view));
                        this.f18234g.m6546e();
                    }
                    if (!(this.f18233f == null || this.f18233f.mo2239i())) {
                        this.f18233f.mo2229a(zzn.m17692a((Object) view));
                        this.f18234g.m6546e();
                    }
                } catch (Throwable e) {
                    zzakb.m5369c("Failed to call performClick", e);
                }
            }
        }
    }

    public final void mo3544a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        synchronized (this.f18237j) {
            this.f18236i = true;
            try {
                if (this.f18232e != null) {
                    this.f18232e.mo2211b(zzn.m17692a((Object) view));
                } else if (this.f18233f != null) {
                    this.f18233f.mo2231b(zzn.m17692a((Object) view));
                }
            } catch (Throwable e) {
                zzakb.m5369c("Failed to call prepareAd", e);
            }
            this.f18236i = false;
        }
    }

    public final void m18922a(zzos com_google_android_gms_internal_zzos) {
        synchronized (this.f18237j) {
            this.f18235h = com_google_android_gms_internal_zzos;
        }
    }

    public final boolean mo2077a() {
        synchronized (this.f18237j) {
            if (this.f18235h != null) {
                boolean a = this.f18235h.mo2077a();
                return a;
            }
            a = this.f18234g.mo4263K();
            return a;
        }
    }

    public final void mo2081b(View view, Map<String, WeakReference<View>> map) {
        synchronized (this.f18237j) {
            try {
                if (this.f18232e != null) {
                    this.f18232e.mo2213c(zzn.m17692a((Object) view));
                } else if (this.f18233f != null) {
                    this.f18233f.mo2233c(zzn.m17692a((Object) view));
                }
            } catch (Throwable e) {
                zzakb.m5369c("Failed to call untrackView", e);
            }
        }
    }

    public final boolean mo2082b() {
        synchronized (this.f18237j) {
            if (this.f18235h != null) {
                boolean b = this.f18235h.mo2082b();
                return b;
            }
            b = this.f18234g.mo4264L();
            return b;
        }
    }

    public final boolean m18926c() {
        boolean z;
        synchronized (this.f18237j) {
            z = this.f18236i;
        }
        return z;
    }

    public final zzos m18927d() {
        zzos com_google_android_gms_internal_zzos;
        synchronized (this.f18237j) {
            com_google_android_gms_internal_zzos = this.f18235h;
        }
        return com_google_android_gms_internal_zzos;
    }

    public final zzanh mo3545e() {
        return null;
    }

    public final void mo2085f() {
    }

    public final void mo2086g() {
    }
}
