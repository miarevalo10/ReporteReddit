package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

final class zzht {
    private ByteArrayOutputStream f7707a = new ByteArrayOutputStream(4096);
    private Base64OutputStream f7708b = new Base64OutputStream(this.f7707a, 10);

    public final void m6300a(byte[] bArr) throws IOException {
        this.f7708b.write(bArr);
    }

    public final String toString() {
        String byteArrayOutputStream;
        try {
            this.f7708b.close();
        } catch (Throwable e) {
            zzakb.m5367b("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.f7707a.close();
            byteArrayOutputStream = this.f7707a.toString();
        } catch (Throwable e2) {
            zzakb.m5367b("HashManager: Unable to convert to Base64.", e2);
            byteArrayOutputStream = "";
        } catch (Throwable th) {
            this.f7707a = null;
            this.f7708b = null;
        }
        this.f7707a = null;
        this.f7708b = null;
        return byteArrayOutputStream;
    }
}
