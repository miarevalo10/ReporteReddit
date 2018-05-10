package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;

@zzzv
public final class zzadd extends zzadl {
    private final Context f17502a;
    private final Object f17503b;
    private final zzakd f17504c;
    private final zzade f17505d;

    public zzadd(Context context, zzv com_google_android_gms_ads_internal_zzv, zzux com_google_android_gms_internal_zzux, zzakd com_google_android_gms_internal_zzakd) {
        this(context, com_google_android_gms_internal_zzakd, new zzade(context, com_google_android_gms_ads_internal_zzv, zzjn.m18778b(), com_google_android_gms_internal_zzux, com_google_android_gms_internal_zzakd));
    }

    private zzadd(Context context, zzakd com_google_android_gms_internal_zzakd, zzade com_google_android_gms_internal_zzade) {
        this.f17503b = new Object();
        this.f17502a = context;
        this.f17504c = com_google_android_gms_internal_zzakd;
        this.f17505d = com_google_android_gms_internal_zzade;
    }

    public final void mo1661a() {
        synchronized (this.f17503b) {
            this.f17505d.m20935F();
        }
    }

    public final void mo1662a(IObjectWrapper iObjectWrapper) {
        synchronized (this.f17503b) {
            this.f17505d.mo2011n();
        }
    }

    public final void mo1663a(zzadp com_google_android_gms_internal_zzadp) {
        synchronized (this.f17503b) {
            this.f17505d.mo1990a(com_google_android_gms_internal_zzadp);
        }
    }

    public final void mo1664a(zzadv com_google_android_gms_internal_zzadv) {
        synchronized (this.f17503b) {
            this.f17505d.m20942a(com_google_android_gms_internal_zzadv);
        }
    }

    public final void mo1665a(String str) {
        synchronized (this.f17503b) {
            this.f17505d.mo2001a(str);
        }
    }

    public final void mo1666a(boolean z) {
        synchronized (this.f17503b) {
            this.f17505d.mo2004c(z);
        }
    }

    public final boolean mo1668b() {
        boolean G;
        synchronized (this.f17503b) {
            G = this.f17505d.m20936G();
        }
        return G;
    }

    public final void mo1669c() {
        mo1662a(null);
    }

    public final void mo1670c(IObjectWrapper iObjectWrapper) {
        synchronized (this.f17503b) {
            this.f17505d.mo2006i();
        }
    }

    public final void mo1671d() {
        mo1667b(null);
    }

    public final void mo1672e() {
        mo1670c(null);
    }

    public final String mo1673f() {
        String a;
        synchronized (this.f17503b) {
            a = this.f17505d.mo1989a();
        }
        return a;
    }

    public final void mo1667b(IObjectWrapper iObjectWrapper) {
        synchronized (this.f17503b) {
            Object obj;
            if (iObjectWrapper == null) {
                obj = null;
            } else {
                try {
                    obj = (Context) zzn.m17693a(iObjectWrapper);
                } catch (IObjectWrapper iObjectWrapper2) {
                    zzakb.m5369c("Unable to extract updated context.", iObjectWrapper2);
                }
            }
            if (obj != null) {
                for (zzael com_google_android_gms_internal_zzael : this.f17505d.f19560i.values()) {
                    try {
                        com_google_android_gms_internal_zzael.f6253a.mo2171a(zzn.m17692a(obj));
                    } catch (Throwable e) {
                        zzakb.m5367b("Unable to call Adapter.onContextChanged.", e);
                    }
                }
            }
            this.f17505d.mo2012o();
        }
    }
}
