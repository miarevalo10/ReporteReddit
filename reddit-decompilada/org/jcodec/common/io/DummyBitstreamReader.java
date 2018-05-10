package org.jcodec.common.io;

import java.io.IOException;
import java.io.InputStream;

public class DummyBitstreamReader {
    protected static int bitsRead;
    int cnt = 0;
    private int curByte;
    private InputStream is;
    int nBit;
    private int nextByte;
    private int secondByte;

    public DummyBitstreamReader(InputStream inputStream) throws IOException {
        this.is = inputStream;
        this.curByte = inputStream.read();
        this.nextByte = inputStream.read();
        this.secondByte = inputStream.read();
    }

    public int read1Bit() throws IOException {
        return read1BitInt();
    }

    public int read1BitInt() throws IOException {
        if (this.nBit == 8) {
            advance();
            if (this.curByte == -1) {
                return -1;
            }
        }
        int i = (this.curByte >> (7 - this.nBit)) & 1;
        this.nBit++;
        bitsRead++;
        return i;
    }

    public int readNBit(int i) throws IOException {
        if (i > 32) {
            throw new IllegalArgumentException("Can not read more then 32 bit");
        }
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            i3 = (i3 << 1) | read1BitInt();
            i2++;
        }
        return i3;
    }

    private final void advance1() throws IOException {
        this.curByte = this.nextByte;
        this.nextByte = this.secondByte;
        this.secondByte = this.is.read();
    }

    private final void advance() throws IOException {
        advance1();
        this.nBit = 0;
    }

    public int readByte() throws IOException {
        if (this.nBit > 0) {
            advance();
        }
        int i = this.curByte;
        advance();
        return i;
    }

    public boolean moreRBSPData() throws IOException {
        if (this.nBit == 8) {
            advance();
        }
        int i = 1 << ((8 - this.nBit) - 1);
        boolean z = (((i << 1) - 1) & this.curByte) == i;
        if (this.curByte == -1 || (this.nextByte == -1 && z)) {
            return false;
        }
        return true;
    }

    public long getBitPosition() {
        return (long) ((bitsRead * 8) + (this.nBit % 8));
    }

    public boolean moreData() throws IOException {
        if (this.nBit == 8) {
            advance();
        }
        if (this.curByte == -1) {
            return false;
        }
        if (this.nextByte != -1) {
            if (this.nextByte != 0 || this.secondByte != -1) {
                return true;
            }
        }
        if ((((1 << (8 - this.nBit)) - 1) & this.curByte) != 0) {
            return true;
        }
        return false;
    }

    public long readRemainingByte() throws IOException {
        return (long) readNBit(8 - this.nBit);
    }

    public int peakNextBits(int i) throws IOException {
        if (i > 8) {
            throw new IllegalArgumentException("N should be less then 8");
        }
        if (this.nBit == 8) {
            advance();
            if (this.curByte == -1) {
                return -1;
            }
        }
        int[] iArr = new int[(16 - this.nBit)];
        int i2 = this.nBit;
        int i3 = 0;
        int i4 = 0;
        while (i2 < 8) {
            int i5 = i4 + 1;
            iArr[i4] = (this.curByte >> (7 - i2)) & 1;
            i2++;
            i4 = i5;
        }
        i2 = 0;
        while (i2 < 8) {
            i5 = i4 + 1;
            iArr[i4] = (this.nextByte >> (7 - i2)) & 1;
            i2++;
            i4 = i5;
        }
        int i6 = 0;
        while (i3 < i) {
            i6 = (i6 << 1) | iArr[i3];
            i3++;
        }
        return i6;
    }

    public boolean isByteAligned() {
        return this.nBit % 8 == 0;
    }

    public void close() throws IOException {
        this.is.close();
    }

    public int getCurBit() {
        return this.nBit;
    }

    public boolean moreData(int i) throws IOException {
        throw new UnsupportedOperationException();
    }

    public final int skip(int i) throws IOException {
        this.nBit += i;
        i = this.nBit;
        while (this.nBit >= 8 && this.curByte != -1) {
            advance1();
            this.nBit -= 8;
        }
        return i - this.nBit;
    }

    public int align() throws IOException {
        int i = (8 - this.nBit) & 7;
        skip((8 - this.nBit) & 7);
        return i;
    }

    public int checkNBit(int i) throws IOException {
        return peakNextBits(i);
    }

    public int curBit() {
        return this.nBit;
    }

    public boolean lastByte() throws IOException {
        return this.nextByte == -1 && this.secondByte == -1;
    }
}
