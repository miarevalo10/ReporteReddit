package org.jcodec.codecs.vp8;

import java.nio.ByteBuffer;

public class BooleanArithmeticDecoder {
    int bit_count;
    long callCounter;
    private String debugName;
    ByteBuffer input;
    int offset;
    int range;
    int value;

    public BooleanArithmeticDecoder(ByteBuffer byteBuffer, int i, String str) {
        this(byteBuffer, i);
        this.debugName = str;
    }

    public BooleanArithmeticDecoder(ByteBuffer byteBuffer, int i) {
        this.callCounter = 0;
        this.input = byteBuffer;
        this.offset = i;
        initBoolDecoder();
    }

    void initBoolDecoder() {
        this.value = 0;
        this.value = (this.input.get() & 255) << 8;
        this.offset++;
        this.range = 255;
        this.bit_count = 0;
    }

    public int decodeBit() {
        return decodeBool(128);
    }

    public int decodeBool(int i) {
        int i2 = this.range;
        int i3 = this.value;
        i = (((i2 - 1) * i) >> 8) + 1;
        i2 = i << 8;
        this.callCounter++;
        if (i3 >= i2) {
            i = this.range - i;
            i3 -= i2;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i4 = this.bit_count;
        int leadingZeroCountInByte = leadingZeroCountInByte((byte) i);
        i <<= leadingZeroCountInByte;
        i3 <<= leadingZeroCountInByte;
        i4 -= leadingZeroCountInByte;
        if (i4 <= 0) {
            i3 |= (this.input.get() & 255) << (-i4);
            this.offset++;
            i4 += 8;
        }
        this.bit_count = i4;
        this.value = i3;
        this.range = i;
        return i2;
    }

    public int decodeInt(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return i2;
            }
            i2 = decodeBool(128) | (i2 << 1);
            i = i3;
        }
    }

    public int readTree(int[] iArr, int[] iArr2) {
        int i = 0;
        do {
            i = iArr[i + decodeBool(iArr2[i >> 1])];
        } while (i > 0);
        return -i;
    }

    public int readTreeSkip(int[] iArr, int[] iArr2, int i) {
        i *= 2;
        do {
            i = iArr[i + decodeBool(iArr2[i >> 1])];
        } while (i > 0);
        return -i;
    }

    public void seek() {
        this.input.position(this.offset);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("bc: ");
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }

    public static int getBitInBytes(byte[] bArr, int i) {
        return (bArr[i >> 3] >> (7 - (i & 7))) & 1;
    }

    public static int getBitsInBytes(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            i4 = (i4 << 1) | getBitInBytes(bArr, i + i3);
            i3++;
        }
        return i4;
    }

    public static int leadingZeroCountInByte(byte b) {
        int i = b & 255;
        if (i < 128) {
            if (i != 0) {
                return Integer.numberOfLeadingZeros(b) - 24;
            }
        }
        return (byte) 0;
    }
}
