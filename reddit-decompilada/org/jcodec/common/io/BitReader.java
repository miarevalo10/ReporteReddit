package org.jcodec.common.io;

import java.nio.ByteBuffer;

public class BitReader {
    private ByteBuffer bb;
    protected int curInt;
    protected int deficit;
    private int initPos;

    public BitReader(ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        this.initPos = byteBuffer.position();
        this.curInt = readInt();
        this.deficit = null;
    }

    private BitReader(BitReader bitReader) {
        this.bb = bitReader.bb.duplicate();
        this.curInt = bitReader.curInt;
        this.deficit = bitReader.deficit;
    }

    public final int readInt() {
        if (this.bb.remaining() < 4) {
            return readIntSafe();
        }
        this.deficit -= 32;
        return ((((this.bb.get() & 255) << 24) | ((this.bb.get() & 255) << 16)) | ((this.bb.get() & 255) << 8)) | (this.bb.get() & 255);
    }

    private int readIntSafe() {
        this.deficit -= this.bb.remaining() << 3;
        int i = 0;
        if (this.bb.hasRemaining()) {
            i = 0 | (this.bb.get() & 255);
        }
        int i2 = i << 8;
        if (this.bb.hasRemaining()) {
            i2 |= this.bb.get() & 255;
        }
        i2 <<= 8;
        if (this.bb.hasRemaining()) {
            i2 |= this.bb.get() & 255;
        }
        i2 <<= 8;
        return this.bb.hasRemaining() ? i2 | (this.bb.get() & 255) : i2;
    }

    public int read1Bit() {
        int i = this.curInt >>> 31;
        this.curInt <<= 1;
        this.deficit++;
        if (this.deficit == 32) {
            this.curInt = readInt();
        }
        return i;
    }

    public int readNBit(int i) {
        if (i > 32) {
            throw new IllegalArgumentException("Can not read more then 32 bit");
        }
        int i2 = 0;
        if (this.deficit + i > 31) {
            i -= 32 - this.deficit;
            i2 = ((this.curInt >>> this.deficit) | 0) << i;
            this.deficit = 32;
            this.curInt = readInt();
        }
        if (i == 0) {
            return i2;
        }
        i2 |= this.curInt >>> (32 - i);
        this.curInt <<= i;
        this.deficit += i;
        return i2;
    }

    public boolean moreData() {
        int remaining = (this.bb.remaining() + 4) - ((this.deficit + 7) >> 3);
        if (remaining <= 1) {
            if (remaining != 1 || this.curInt == 0) {
                return false;
            }
        }
        return true;
    }

    public int remaining() {
        return ((this.bb.remaining() << 3) + 32) - this.deficit;
    }

    public final boolean isByteAligned() {
        return (this.deficit & 7) == 0;
    }

    public int skip(int i) {
        int i2;
        if (this.deficit + i > 31) {
            i2 = i - (32 - this.deficit);
            this.deficit = 32;
            if (i2 > 31) {
                int min = Math.min(i2 >> 3, this.bb.remaining());
                this.bb.position(this.bb.position() + min);
                i2 -= min << 3;
            }
            this.curInt = readInt();
        } else {
            i2 = i;
        }
        this.deficit += i2;
        this.curInt <<= i2;
        return i;
    }

    public int skipFast(int i) {
        this.deficit += i;
        this.curInt <<= i;
        return i;
    }

    public int align() {
        return (this.deficit & 7) > 0 ? skip(8 - (this.deficit & 7)) : 0;
    }

    public int check24Bits() {
        if (this.deficit > 16) {
            this.deficit -= 16;
            this.curInt |= nextIgnore16() << this.deficit;
        }
        if (this.deficit > 8) {
            this.deficit -= 8;
            this.curInt |= nextIgnore() << this.deficit;
        }
        return this.curInt >>> 8;
    }

    public int check16Bits() {
        if (this.deficit > 16) {
            this.deficit -= 16;
            this.curInt |= nextIgnore16() << this.deficit;
        }
        return this.curInt >>> 16;
    }

    public int readFast16(int i) {
        if (i == 0) {
            return 0;
        }
        if (this.deficit > 16) {
            this.deficit -= 16;
            this.curInt |= nextIgnore16() << this.deficit;
        }
        int i2 = this.curInt >>> (32 - i);
        this.deficit += i;
        this.curInt <<= i;
        return i2;
    }

    public int checkNBit(int i) {
        if (i > 24) {
            throw new IllegalArgumentException("Can not check more then 24 bit");
        }
        while (this.deficit + i > 32) {
            this.deficit -= 8;
            this.curInt |= nextIgnore() << this.deficit;
        }
        return this.curInt >>> (32 - i);
    }

    private int nextIgnore16() {
        if (this.bb.remaining() > 1) {
            return this.bb.getShort() & 65535;
        }
        return this.bb.hasRemaining() ? (this.bb.get() & 255) << 8 : 0;
    }

    private int nextIgnore() {
        return this.bb.hasRemaining() ? this.bb.get() & 255 : 0;
    }

    public int curBit() {
        return this.deficit & 7;
    }

    public boolean lastByte() {
        return (this.bb.remaining() + 4) - (this.deficit >> 3) <= 1;
    }

    public BitReader fork() {
        return new BitReader(this);
    }

    public void terminate() {
        this.bb.position(this.bb.position() - ((32 - this.deficit) >> 3));
    }

    public int position() {
        return (((this.bb.position() - this.initPos) - 4) << 3) + this.deficit;
    }

    public void stop() {
        this.bb.position(this.bb.position() - ((32 - this.deficit) >> 3));
    }

    public int checkAllBits() {
        return this.curInt;
    }
}
