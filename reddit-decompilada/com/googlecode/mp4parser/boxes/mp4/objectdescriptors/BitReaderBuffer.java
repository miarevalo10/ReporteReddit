package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import java.nio.ByteBuffer;

public class BitReaderBuffer {
    int f8973a;
    int f8974b;
    private ByteBuffer f8975c;

    public BitReaderBuffer(ByteBuffer byteBuffer) {
        this.f8975c = byteBuffer;
        this.f8973a = byteBuffer.position();
    }

    public final boolean m7684a() {
        return m7683a(1) == 1;
    }

    public final int m7683a(int i) {
        int i2 = this.f8975c.get(this.f8973a + (this.f8974b / 8));
        if (i2 < 0) {
            i2 += 256;
        }
        int i3 = 8 - (this.f8974b % 8);
        if (i <= i3) {
            i2 = ((i2 << (this.f8974b % 8)) & 255) >> ((this.f8974b % 8) + (i3 - i));
            this.f8974b += i;
        } else {
            i -= i3;
            i2 = (m7683a(i3) << i) + m7683a(i);
        }
        this.f8975c.position(this.f8973a + ((int) Math.ceil(((double) this.f8974b) / 8.0d)));
        return i2;
    }

    public final int m7685b() {
        return (this.f8975c.limit() * 8) - this.f8974b;
    }
}
