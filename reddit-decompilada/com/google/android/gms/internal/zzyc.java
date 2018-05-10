package com.google.android.gms.internal;

import android.content.Context;
import com.instabug.library.model.NetworkLog;

@zzzv
public class zzyc extends zzxu implements zzanm {
    zzyc(Context context, zzafp com_google_android_gms_internal_zzafp, zzanh com_google_android_gms_internal_zzanh, zzyb com_google_android_gms_internal_zzyb) {
        super(context, com_google_android_gms_internal_zzafp, com_google_android_gms_internal_zzanh, com_google_android_gms_internal_zzyb);
    }

    protected void mo4044b() {
    }

    protected final void mo3574a() {
        if (this.c.f17444d == -2) {
            this.b.mo4019w().f6617d = this;
            mo4044b();
            zzakb.m5366b("Loading HTML in WebView.");
            this.b.loadDataWithBaseURL(this.c.f17441a, this.c.f17442b, NetworkLog.HTML, "UTF-8", null);
        }
    }
}
