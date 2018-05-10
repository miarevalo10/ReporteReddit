package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.js.zzn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@zzzv
public final class zzfs implements zzga {
    public final Object f14455a = new Object();
    public final WeakHashMap<zzafo, zzft> f14456b = new WeakHashMap();
    private final ArrayList<zzft> f14457c = new ArrayList();
    private final Context f14458d;
    private final zzakd f14459e;
    private final zzn f14460f;

    public zzfs(Context context, zzakd com_google_android_gms_internal_zzakd) {
        this.f14458d = context.getApplicationContext();
        this.f14459e = com_google_android_gms_internal_zzakd;
        this.f14460f = new zzn(context.getApplicationContext(), com_google_android_gms_internal_zzakd, (String) zzkb.m6350f().m6488a(zznh.f7891a));
    }

    private final boolean m13914d(zzafo com_google_android_gms_internal_zzafo) {
        boolean z;
        synchronized (this.f14455a) {
            zzft com_google_android_gms_internal_zzft = (zzft) this.f14456b.get(com_google_android_gms_internal_zzafo);
            z = com_google_android_gms_internal_zzft != null && com_google_android_gms_internal_zzft.m6244c();
        }
        return z;
    }

    public final void m13915a(zzafo com_google_android_gms_internal_zzafo) {
        synchronized (this.f14455a) {
            zzft com_google_android_gms_internal_zzft = (zzft) this.f14456b.get(com_google_android_gms_internal_zzafo);
            if (com_google_android_gms_internal_zzft != null) {
                com_google_android_gms_internal_zzft.m6240b();
            }
        }
    }

    public final void mo1941a(zzft com_google_android_gms_internal_zzft) {
        synchronized (this.f14455a) {
            if (!com_google_android_gms_internal_zzft.m6244c()) {
                this.f14457c.remove(com_google_android_gms_internal_zzft);
                Iterator it = this.f14456b.entrySet().iterator();
                while (it.hasNext()) {
                    if (((Entry) it.next()).getValue() == com_google_android_gms_internal_zzft) {
                        it.remove();
                    }
                }
            }
        }
    }

    public final void m13917a(zzjn com_google_android_gms_internal_zzjn, zzafo com_google_android_gms_internal_zzafo) {
        zzanh com_google_android_gms_internal_zzanh = com_google_android_gms_internal_zzafo.f6289b;
        if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        }
        m13918a(com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzafo, (View) com_google_android_gms_internal_zzanh);
    }

    public final void m13918a(zzjn com_google_android_gms_internal_zzjn, zzafo com_google_android_gms_internal_zzafo, View view) {
        m13920a(com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzafo, new zzfz(view, com_google_android_gms_internal_zzafo), null);
    }

    public final void m13919a(zzjn com_google_android_gms_internal_zzjn, zzafo com_google_android_gms_internal_zzafo, View view, zzanh com_google_android_gms_internal_zzanh) {
        m13920a(com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzafo, new zzfz(view, com_google_android_gms_internal_zzafo), com_google_android_gms_internal_zzanh);
    }

    public final void m13921b(zzafo com_google_android_gms_internal_zzafo) {
        synchronized (this.f14455a) {
            zzft com_google_android_gms_internal_zzft = (zzft) this.f14456b.get(com_google_android_gms_internal_zzafo);
            if (com_google_android_gms_internal_zzft != null) {
                com_google_android_gms_internal_zzft.m6247f();
            }
        }
    }

    public final void m13922c(zzafo com_google_android_gms_internal_zzafo) {
        synchronized (this.f14455a) {
            zzft com_google_android_gms_internal_zzft = (zzft) this.f14456b.get(com_google_android_gms_internal_zzafo);
            if (com_google_android_gms_internal_zzft != null) {
                com_google_android_gms_internal_zzft.m6248g();
            }
        }
    }

    public final void m13920a(zzjn com_google_android_gms_internal_zzjn, zzafo com_google_android_gms_internal_zzafo, zzhd com_google_android_gms_internal_zzhd, zzanh com_google_android_gms_internal_zzanh) {
        synchronized (this.f14455a) {
            if (m13914d(com_google_android_gms_internal_zzafo)) {
                com_google_android_gms_internal_zzjn = (zzft) this.f14456b.get(com_google_android_gms_internal_zzafo);
            } else {
                zzft com_google_android_gms_internal_zzft = new zzft(this.f14458d, com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzafo, this.f14459e, com_google_android_gms_internal_zzhd);
                synchronized (com_google_android_gms_internal_zzft.f7577a) {
                    com_google_android_gms_internal_zzft.f7579c = this;
                }
                this.f14456b.put(com_google_android_gms_internal_zzafo, com_google_android_gms_internal_zzft);
                this.f14457c.add(com_google_android_gms_internal_zzft);
                com_google_android_gms_internal_zzjn = com_google_android_gms_internal_zzft;
            }
            com_google_android_gms_internal_zzjn.m6241b(com_google_android_gms_internal_zzanh != null ? new zzgb(com_google_android_gms_internal_zzjn, com_google_android_gms_internal_zzanh) : new zzgf(com_google_android_gms_internal_zzjn, this.f14460f, this.f14458d));
        }
    }
}
