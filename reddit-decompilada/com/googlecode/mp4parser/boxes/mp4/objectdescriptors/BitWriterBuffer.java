package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import java.nio.ByteBuffer;

public class BitWriterBuffer {
    static final /* synthetic */ boolean f8976c = true;
    int f8977a;
    int f8978b = 0;
    private ByteBuffer f8979d;

    public BitWriterBuffer(ByteBuffer byteBuffer) {
        this.f8979d = byteBuffer;
        this.f8977a = byteBuffer.position();
    }

    public final void m7687a(boolean z) {
        m7686a(z, 1);
    }

    public final void m7686a(int i, int i2) {
        int i3 = 0;
        if (f8976c || i <= (1 << i2) - 1) {
            int i4 = 8 - (this.f8978b % 8);
            if (i2 <= i4) {
                int i5 = this.f8979d.get(this.f8977a + (this.f8978b / 8));
                if (i5 < 0) {
                    i5 += 256;
                }
                i5 += i << (i4 - i2);
                i = this.f8979d;
                i4 = this.f8977a + (this.f8978b / 8);
                if (i5 > 127) {
                    i5 -= 256;
                }
                i.put(i4, (byte) i5);
                this.f8978b += i2;
            } else {
                i2 -= i4;
                m7686a(i >> i2, i4);
                m7686a(i & ((1 << i2) - 1), i2);
            }
            i = this.f8979d;
            i2 = this.f8977a + (this.f8978b / 8);
            if (this.f8978b % 8 > 0) {
                i3 = 1;
            }
            i.position(i2 + i3);
            return;
        }
        throw new AssertionError(String.format("Trying to write a value bigger (%s) than the number bits (%s) allows. Please mask the value before writing it and make your code is really working as intended.", new Object[]{Integer.valueOf(i), Integer.valueOf((1 << i2) - 1)}));
    }
}
