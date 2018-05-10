package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

public abstract class DataChunk extends Chunk {
    public byte[] f16959a;
    private int f16960b;
    private volatile boolean f16961k;

    protected abstract void mo3922a(byte[] bArr, int i) throws IOException;

    public DataChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, byte[] bArr) {
        super(dataSource, dataSpec, 3, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.f16959a = bArr;
    }

    public final long mo3358d() {
        return (long) this.f16960b;
    }

    public final void mo1404a() {
        this.f16961k = true;
    }

    public final boolean mo1405b() {
        return this.f16961k;
    }

    public final void mo1406c() throws IOException, InterruptedException {
        try {
            this.j.mo1435a(this.c);
            int i = 0;
            this.f16960b = 0;
            while (i != -1 && !this.f16961k) {
                if (this.f16959a == null) {
                    this.f16959a = new byte[16384];
                } else if (this.f16959a.length < this.f16960b + 16384) {
                    this.f16959a = Arrays.copyOf(this.f16959a, this.f16959a.length + 16384);
                }
                i = this.j.mo1434a(this.f16959a, this.f16960b, 16384);
                if (i != -1) {
                    this.f16960b += i;
                }
            }
            if (!this.f16961k) {
                mo3922a(this.f16959a, this.f16960b);
            }
            Util.m4307a(this.j);
        } catch (Throwable th) {
            Util.m4307a(this.j);
        }
    }
}
