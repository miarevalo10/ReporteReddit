package com.danikula.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

public class ByteArrayCache implements Cache {
    private volatile boolean completed;
    private volatile byte[] data;

    public void close() throws ProxyCacheException {
    }

    public ByteArrayCache() {
        this(new byte[0]);
    }

    public ByteArrayCache(byte[] bArr) {
        this.data = (byte[]) Preconditions.m3330a((Object) bArr);
    }

    public int read(byte[] bArr, long j, int i) throws ProxyCacheException {
        if (j >= ((long) this.data.length)) {
            return -1;
        }
        if (j <= 2147483647L) {
            return new ByteArrayInputStream(this.data).read(bArr, (int) j, i);
        }
        i = new StringBuilder("Too long offset for memory cache ");
        i.append(j);
        throw new IllegalArgumentException(i.toString());
    }

    public long available() throws ProxyCacheException {
        return (long) this.data.length;
    }

    public void append(byte[] bArr, int i) throws ProxyCacheException {
        Preconditions.m3330a(this.data);
        boolean z = i >= 0 && i <= bArr.length;
        Preconditions.m3332a(z);
        Object copyOf = Arrays.copyOf(this.data, this.data.length + i);
        System.arraycopy(bArr, 0, copyOf, this.data.length, i);
        this.data = copyOf;
    }

    public void complete() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return this.completed;
    }
}
