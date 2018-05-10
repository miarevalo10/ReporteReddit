package com.microsoft.thrifty.transport;

import java.io.IOException;
import okio.Buffer;

public class BufferTransport extends Transport {
    public final Buffer f15609a;

    public BufferTransport() {
        this(new Buffer());
    }

    public BufferTransport(Buffer buffer) {
        this.f15609a = buffer;
    }

    public final int mo2653a(byte[] bArr, int i, int i2) throws IOException {
        return this.f15609a.a(bArr, i, i2);
    }

    public final void mo2654a(byte[] bArr, int i) throws IOException {
        this.f15609a.b(bArr, 0, i);
    }

    public void close() throws IOException {
        this.f15609a.close();
    }
}
