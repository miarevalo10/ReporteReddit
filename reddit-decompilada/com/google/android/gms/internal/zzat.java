package com.google.android.gms.internal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class zzat extends ByteArrayOutputStream {
    private final zzaj f6686a;

    public zzat(zzaj com_google_android_gms_internal_zzaj, int i) {
        this.f6686a = com_google_android_gms_internal_zzaj;
        this.buf = this.f6686a.m5297a(Math.max(i, 256));
    }

    private final void m5491a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f6686a.m5297a((this.count + i) << 1);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f6686a.m5296a(this.buf);
            this.buf = a;
        }
    }

    public final void close() throws IOException {
        this.f6686a.m5296a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.f6686a.m5296a(this.buf);
    }

    public final synchronized void write(int i) {
        m5491a(1);
        super.write(i);
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        m5491a(i2);
        super.write(bArr, i, i2);
    }
}
