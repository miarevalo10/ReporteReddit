package org.jcodec.codecs.common.biari;

import java.nio.ByteBuffer;

public class MDecoder {
    private int[][] cm;
    private int code;
    private ByteBuffer in;
    private int nBitsPending;
    private int range = 510;

    public MDecoder(ByteBuffer byteBuffer, int[][] iArr) {
        this.in = byteBuffer;
        this.cm = iArr;
        initCodeRegister();
    }

    protected void initCodeRegister() {
        readOneByte();
        if (this.nBitsPending != 8) {
            throw new RuntimeException("Empty stream");
        }
        this.code <<= 8;
        readOneByte();
        this.code <<= 1;
        this.nBitsPending -= 9;
    }

    protected void readOneByte() {
        if (this.in.hasRemaining()) {
            this.code = (this.in.get() & 255) | this.code;
            this.nBitsPending += 8;
        }
    }

    public int decodeBin(int i) {
        int i2 = MConst.rangeLPS[(this.range >> 6) & 3][this.cm[0][i]];
        this.range -= i2;
        int i3 = this.range << 8;
        if (this.code < i3) {
            if (this.cm[0][i] < 62) {
                int[] iArr = this.cm[0];
                iArr[i] = iArr[i] + 1;
            }
            renormalize();
            return this.cm[1][i];
        }
        this.range = i2;
        this.code -= i3;
        renormalize();
        i2 = 1 - this.cm[1][i];
        if (this.cm[0][i] == 0) {
            this.cm[1][i] = 1 - this.cm[1][i];
        }
        this.cm[0][i] = MConst.transitLPS[this.cm[0][i]];
        return i2;
    }

    public int decodeFinalBin() {
        this.range -= 2;
        if (this.code >= (this.range << 8)) {
            return 1;
        }
        renormalize();
        return 0;
    }

    public int decodeBinBypass() {
        this.code <<= 1;
        this.nBitsPending--;
        if (this.nBitsPending <= 0) {
            readOneByte();
        }
        int i = this.code - (this.range << 8);
        if (i < 0) {
            return 0;
        }
        this.code = i;
        return 1;
    }

    private void renormalize() {
        while (this.range < 256) {
            this.range <<= 1;
            this.code <<= 1;
            this.code &= 131071;
            this.nBitsPending--;
            if (this.nBitsPending <= 0) {
                readOneByte();
            }
        }
    }
}
