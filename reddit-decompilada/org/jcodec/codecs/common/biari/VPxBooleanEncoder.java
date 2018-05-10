package org.jcodec.codecs.common.biari;

import java.nio.ByteBuffer;
import org.jcodec.codecs.vpx.VPXConst;

public class VPxBooleanEncoder {
    private int count = -24;
    private int lowvalue = null;
    private ByteBuffer out;
    private int range = 255;

    public VPxBooleanEncoder(ByteBuffer byteBuffer) {
        this.out = byteBuffer;
    }

    public void writeBit(int i, int i2) {
        i = (((this.range - 1) * i) >> 8) + 1;
        if (i2 != 0) {
            this.lowvalue += i;
            this.range -= i;
        } else {
            this.range = i;
        }
        i = VPXConst.vp8Norm[this.range];
        this.range <<= i;
        this.count += i;
        if (this.count >= 0) {
            i -= this.count;
            if (((this.lowvalue << (i - 1)) & Integer.MIN_VALUE) != 0) {
                i2 = this.out.position() - 1;
                while (i2 >= 0 && this.out.get(i2) == (byte) -1) {
                    this.out.put(i2, (byte) 0);
                    i2--;
                }
                this.out.put(i2, (byte) ((this.out.get(i2) & 255) + 1));
            }
            this.out.put((byte) (this.lowvalue >> (24 - i)));
            this.lowvalue <<= i;
            i = this.count;
            this.lowvalue &= 16777215;
            this.count -= 8;
        }
        this.lowvalue <<= i;
    }

    public void stop() {
        for (int i = 0; i < 32; i++) {
            writeBit(128, 0);
        }
    }

    public int position() {
        return this.out.position() + ((this.count + 24) >> 3);
    }
}
