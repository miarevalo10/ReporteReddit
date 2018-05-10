package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class Aes128DataSource implements DataSource {
    private final DataSource f13396a;
    private final byte[] f13397b;
    private final byte[] f13398c;
    private CipherInputStream f13399d;

    public Aes128DataSource(DataSource dataSource, byte[] bArr, byte[] bArr2) {
        this.f13396a = dataSource;
        this.f13397b = bArr;
        this.f13398c = bArr2;
    }

    public final long mo1435a(DataSpec dataSpec) throws IOException {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.f13397b, "AES"), new IvParameterSpec(this.f13398c));
                this.f13399d = new CipherInputStream(new DataSourceInputStream(this.f13396a, dataSpec), instance);
                return -1;
            } catch (DataSpec dataSpec2) {
                throw new RuntimeException(dataSpec2);
            }
        } catch (DataSpec dataSpec22) {
            throw new RuntimeException(dataSpec22);
        }
    }

    public final void mo1436a() throws IOException {
        this.f13399d = null;
        this.f13396a.mo1436a();
    }

    public final int mo1434a(byte[] bArr, int i, int i2) throws IOException {
        Assertions.m4186b(this.f13399d != null);
        bArr = this.f13399d.read(bArr, i, i2);
        return bArr < null ? -1 : bArr;
    }

    public final Uri mo1437b() {
        return this.f13396a.mo1437b();
    }
}
