package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;

@zzzv
public abstract class zzxw extends zzagb {
    protected final zzyb f18335a;
    protected final Context f18336b;
    protected final Object f18337c = new Object();
    protected final Object f18338d = new Object();
    protected final zzafp f18339e;
    protected zzaax f18340f;

    protected zzxw(Context context, zzafp com_google_android_gms_internal_zzafp, zzyb com_google_android_gms_internal_zzyb) {
        super((byte) 0);
        this.f18336b = context;
        this.f18339e = com_google_android_gms_internal_zzafp;
        this.f18340f = com_google_android_gms_internal_zzafp.f6315b;
        this.f18335a = com_google_android_gms_internal_zzyb;
    }

    protected abstract zzafo mo4045a(int i);

    protected abstract void mo4046a(long j) throws zzxz;

    public void mo3385b() {
    }

    public final void mo3384a() {
        int i;
        synchronized (this.f18337c) {
            zzakb.m5366b("AdRendererBackgroundTask started.");
            int i2 = this.f18339e.f6318e;
            try {
                mo4046a(SystemClock.elapsedRealtime());
            } catch (zzxz e) {
                i = e.f8146a;
                if (i != 3) {
                    if (i != -1) {
                        zzakb.m5371e(e.getMessage());
                        this.f18340f = this.f18340f != null ? new zzaax(i) : new zzaax(i, this.f18340f.f17450j);
                        zzahn.f6379a.post(new zzxx(this));
                        i2 = i;
                    }
                }
                zzakb.m5370d(e.getMessage());
                if (this.f18340f != null) {
                }
                this.f18340f = this.f18340f != null ? new zzaax(i) : new zzaax(i, this.f18340f.f17450j);
                zzahn.f6379a.post(new zzxx(this));
                i2 = i;
            }
            zzahn.f6379a.post(new zzxy(this, mo4045a(i2)));
        }
    }
}
