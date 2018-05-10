package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzbs;

@zzzv
public final class zzamx extends zzagb {
    final zzamp f17573a;
    final zzana f17574b;
    private final String f17575c;

    public final void mo3384a() {
        try {
            this.f17574b.mo3460a(this.f17575c);
        } finally {
            zzahn.f6379a.post(new zzamy(this));
        }
    }

    public final void mo3385b() {
        this.f17574b.mo3459a();
    }

    zzamx(zzamp com_google_android_gms_internal_zzamp, zzana com_google_android_gms_internal_zzana, String str) {
        this.f17573a = com_google_android_gms_internal_zzamp;
        this.f17574b = com_google_android_gms_internal_zzana;
        this.f17575c = str;
        zzbs.m4505x().f6590a.add(this);
    }
}
