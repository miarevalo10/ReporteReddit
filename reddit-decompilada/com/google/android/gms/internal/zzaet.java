package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

final class zzaet implements Runnable {
    private /* synthetic */ Bitmap f6255a;
    private /* synthetic */ zzaes f6256b;

    zzaet(zzaes com_google_android_gms_internal_zzaes, Bitmap bitmap) {
        this.f6256b = com_google_android_gms_internal_zzaes;
        this.f6255a = bitmap;
    }

    public final void run() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f6255a.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
        synchronized (this.f6256b.f14050b) {
            this.f6256b.f14051c.f18051g = new zzfkd();
            this.f6256b.f14051c.f18051g.f18084c = byteArrayOutputStream.toByteArray();
            this.f6256b.f14051c.f18051g.f18083b = "image/png";
            this.f6256b.f14051c.f18051g.f18082a = Integer.valueOf(1);
        }
    }
}
