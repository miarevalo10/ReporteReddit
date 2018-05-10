package org.jcodec.codecs.common.biari;

import com.google.android.gms.ads.AdRequest;
import java.nio.ByteBuffer;
import org.jcodec.containers.mxf.model.BER;

public class MEncoder {
    private int bitsInOutReg;
    private int[][] models;
    private int offset;
    private int onesOutstanding;
    private ByteBuffer out;
    private int outReg;
    private int range = 510;
    private boolean zeroBorrowed;

    public MEncoder(ByteBuffer byteBuffer, int[][] iArr) {
        this.models = iArr;
        this.out = byteBuffer;
    }

    public void encodeBin(int i, int i2) {
        int i3 = MConst.rangeLPS[(this.range >> 6) & 3][this.models[0][i]];
        this.range -= i3;
        if (i2 != this.models[1][i]) {
            this.offset += this.range;
            this.range = i3;
            if (this.models[0][i] == 0) {
                this.models[1][i] = 1 - this.models[1][i];
            }
            this.models[0][i] = MConst.transitLPS[this.models[0][i]];
        } else if (this.models[0][i] < 62) {
            i2 = this.models[0];
            i2[i] = i2[i] + 1;
        }
        renormalize();
    }

    public void encodeBinBypass(int i) {
        this.offset <<= 1;
        if (i == 1) {
            this.offset += this.range;
        }
        if ((this.offset & 1024) != 0) {
            flushOutstanding(1);
            this.offset &= 1023;
        } else if ((this.offset & AdRequest.MAX_CONTENT_URL_LENGTH) != 0) {
            this.offset &= 511;
            this.onesOutstanding++;
        } else {
            flushOutstanding(0);
        }
    }

    public void encodeBinFinal(int i) {
        this.range -= 2;
        if (i == 0) {
            renormalize();
            return;
        }
        this.offset += this.range;
        this.range = 2;
        renormalize();
    }

    public void finishEncoding() {
        flushOutstanding((this.offset >> 9) & 1);
        putBit((this.offset >> 8) & 1);
        stuffBits();
    }

    private void renormalize() {
        while (this.range < 256) {
            if (this.offset < 256) {
                flushOutstanding(0);
            } else if (this.offset < AdRequest.MAX_CONTENT_URL_LENGTH) {
                this.offset &= 255;
                this.onesOutstanding++;
            } else {
                this.offset &= 511;
                flushOutstanding(1);
            }
            this.range <<= 1;
            this.offset <<= 1;
        }
    }

    private void flushOutstanding(int i) {
        if (this.zeroBorrowed) {
            putBit(i);
        }
        i = 1 - i;
        while (this.onesOutstanding > 0) {
            putBit(i);
            this.onesOutstanding--;
        }
        this.zeroBorrowed = true;
    }

    private void putBit(int i) {
        this.outReg = i | (this.outReg << 1);
        this.bitsInOutReg++;
        if (this.bitsInOutReg == 8) {
            this.out.put((byte) this.outReg);
            this.outReg = 0;
            this.bitsInOutReg = 0;
        }
    }

    private void stuffBits() {
        if (this.bitsInOutReg == 0) {
            this.out.put(BER.ASN_LONG_LEN);
            return;
        }
        this.outReg = (this.outReg << 1) | 1;
        this.outReg <<= 8 - (this.bitsInOutReg + 1);
        this.out.put((byte) this.outReg);
        this.outReg = 0;
        this.bitsInOutReg = 0;
    }
}
