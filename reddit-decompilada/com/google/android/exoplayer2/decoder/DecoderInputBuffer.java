package com.google.android.exoplayer2.decoder;

import java.nio.ByteBuffer;

public class DecoderInputBuffer extends Buffer {
    public final CryptoInfo f12799b = new CryptoInfo();
    public ByteBuffer f12800c;
    public long f12801d;
    public final int f12802e;

    public static DecoderInputBuffer m11971e() {
        return new DecoderInputBuffer(0);
    }

    public DecoderInputBuffer(int i) {
        this.f12802e = i;
    }

    public final void m11973c(int i) throws IllegalStateException {
        if (this.f12800c == null) {
            this.f12800c = m11970d(i);
            return;
        }
        int capacity = this.f12800c.capacity();
        int position = this.f12800c.position();
        i += position;
        if (capacity < i) {
            i = m11970d(i);
            if (position > 0) {
                this.f12800c.position(0);
                this.f12800c.limit(position);
                i.put(this.f12800c);
            }
            this.f12800c = i;
        }
    }

    public final boolean m11974f() {
        return m3714b(1073741824);
    }

    public final void m11975g() {
        this.f12800c.flip();
    }

    public final void mo1321a() {
        super.mo1321a();
        if (this.f12800c != null) {
            this.f12800c.clear();
        }
    }

    private ByteBuffer m11970d(int i) {
        if (this.f12802e == 1) {
            return ByteBuffer.allocate(i);
        }
        if (this.f12802e == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        int capacity = this.f12800c == null ? 0 : this.f12800c.capacity();
        StringBuilder stringBuilder = new StringBuilder("Buffer too small (");
        stringBuilder.append(capacity);
        stringBuilder.append(" < ");
        stringBuilder.append(i);
        stringBuilder.append(")");
        throw new IllegalStateException(stringBuilder.toString());
    }
}
