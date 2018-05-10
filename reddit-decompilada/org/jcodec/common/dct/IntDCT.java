package org.jcodec.common.dct;

import java.nio.IntBuffer;

public class IntDCT extends DCT {
    private static final int CENTERJSAMPLE = 128;
    private static final int CONST_BITS = 13;
    private static final int DCTSIZE = 8;
    private static final int FIX_0_298631336 = FIX(0.298631336d);
    private static final int FIX_0_390180644 = FIX(0.390180644d);
    private static final int FIX_0_541196100 = FIX(0.5411961d);
    private static final int FIX_0_765366865 = FIX(0.765366865d);
    private static final int FIX_0_899976223 = FIX(0.899976223d);
    private static final int FIX_1_175875602 = FIX(1.175875602d);
    private static final int FIX_1_501321110 = FIX(1.50132111d);
    private static final int FIX_1_847759065 = FIX(1.847759065d);
    private static final int FIX_1_961570560 = FIX(1.96157056d);
    private static final int FIX_2_053119869 = FIX(2.053119869d);
    private static final int FIX_2_562915447 = FIX(2.562915447d);
    private static final int FIX_3_072711026 = FIX(3.072711026d);
    public static final IntDCT INSTANCE = new IntDCT();
    private static final int MAXJSAMPLE = 255;
    private static final int ONE_HALF = 4096;
    private static final int PASS1_BITS = 2;
    private static final int RANGE_MASK = 1023;
    private static final IntBuffer idct_sample_range_limit;
    private static final IntBuffer sample_range_limit;

    private static final int FIX(double d) {
        return (int) ((d * 8192.0d) + 0.5d);
    }

    private static final int MULTIPLY(int i, int i2) {
        return i * i2;
    }

    private static int RIGHT_SHIFT(int i, int i2) {
        return i >> i2;
    }

    static {
        IntBuffer allocate = IntBuffer.allocate(1408);
        sample_range_limit = allocate;
        idct_sample_range_limit = IntBuffer.allocate(allocate.capacity() - 128);
        prepare_range_limit_table();
    }

    public int[] decode(int[] iArr) {
        iArr = IntBuffer.wrap(iArr);
        IntBuffer allocate = IntBuffer.allocate(64);
        IntBuffer allocate2 = IntBuffer.allocate(64);
        decode(iArr, allocate, allocate2);
        return allocate2.array();
    }

    protected IntBuffer decode(IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3) {
        pass1(intBuffer, intBuffer2.duplicate());
        pass2(intBuffer3, intBuffer2.duplicate());
        return intBuffer3;
    }

    private static void pass2(IntBuffer intBuffer, IntBuffer intBuffer2) {
        IntBuffer intBuffer3 = intBuffer;
        int i = 0;
        IntBuffer intBuffer4 = intBuffer2;
        int i2 = 0;
        while (i2 < 8) {
            int i3 = intBuffer4.get(2);
            int i4 = intBuffer4.get(6);
            int MULTIPLY = MULTIPLY(i3 + i4, FIX_0_541196100);
            i4 = MULTIPLY(i4, -FIX_1_847759065) + MULTIPLY;
            MULTIPLY += MULTIPLY(i3, FIX_0_765366865);
            i3 = (intBuffer4.get(i) + intBuffer4.get(4)) << 13;
            int i5 = (intBuffer4.get(i) - intBuffer4.get(4)) << 13;
            int i6 = i3 + MULTIPLY;
            i3 -= MULTIPLY;
            MULTIPLY = i5 + i4;
            i5 -= i4;
            i4 = intBuffer4.get(7);
            int i7 = intBuffer4.get(5);
            int i8 = intBuffer4.get(3);
            int i9 = intBuffer4.get(1);
            int i10 = i4 + i9;
            int i11 = i7 + i8;
            int i12 = i4 + i8;
            i = i7 + i9;
            int i13 = i2;
            i2 = MULTIPLY(i12 + i, FIX_1_175875602);
            int MULTIPLY2 = MULTIPLY(i4, FIX_0_298631336);
            i4 = MULTIPLY(i7, FIX_2_053119869);
            i7 = MULTIPLY(i8, FIX_3_072711026);
            i8 = MULTIPLY(i9, FIX_1_501321110);
            i9 = MULTIPLY(i10, -FIX_0_899976223);
            i10 = MULTIPLY(i11, -FIX_2_562915447);
            i11 = MULTIPLY(i12, -FIX_1_961570560) + i2;
            i = MULTIPLY(i, -FIX_0_390180644) + i2;
            MULTIPLY2 += i9 + i11;
            i4 += i10 + i;
            i7 += i10 + i11;
            i8 += i9 + i;
            intBuffer3.put(range_limit(DESCALE(i6 + i8, 18) & RANGE_MASK));
            intBuffer3.put(range_limit(DESCALE(MULTIPLY + i7, 18) & RANGE_MASK));
            intBuffer3.put(range_limit(DESCALE(i5 + i4, 18) & RANGE_MASK));
            intBuffer3.put(range_limit(DESCALE(i3 + MULTIPLY2, 18) & RANGE_MASK));
            intBuffer3.put(range_limit(DESCALE(i3 - MULTIPLY2, 18) & RANGE_MASK));
            intBuffer3.put(range_limit(DESCALE(i5 - i4, 18) & RANGE_MASK));
            intBuffer3.put(range_limit(DESCALE(MULTIPLY - i7, 18) & RANGE_MASK));
            intBuffer3.put(range_limit(DESCALE(i6 - i8, 18) & RANGE_MASK));
            intBuffer4 = advance(intBuffer4, 8);
            i2 = i13 + 1;
            i = 0;
        }
    }

    public static int range_limit(int i) {
        return idct_sample_range_limit.get(i + 256);
    }

    private static void prepare_range_limit_table() {
        int i;
        sample_range_limit.position(256);
        int i2 = 0;
        for (i = 0; i < CENTERJSAMPLE; i++) {
            sample_range_limit.put(i);
        }
        for (i = -128; i < 0; i++) {
            sample_range_limit.put(i);
        }
        for (i = 0; i < 384; i++) {
            sample_range_limit.put(-1);
        }
        for (i = 0; i < 384; i++) {
            sample_range_limit.put(0);
        }
        for (i = 0; i < CENTERJSAMPLE; i++) {
            sample_range_limit.put(i);
        }
        while (i2 < idct_sample_range_limit.capacity()) {
            idct_sample_range_limit.put(sample_range_limit.get(i2 + CENTERJSAMPLE) & MAXJSAMPLE);
            i2++;
        }
    }

    private static boolean shortcut(IntBuffer intBuffer, IntBuffer intBuffer2) {
        if (intBuffer.get(8) != 0 || intBuffer.get(16) != 0 || intBuffer.get(24) != 0 || intBuffer.get(32) != 0 || intBuffer.get(40) != 0 || intBuffer.get(48) != 0 || intBuffer.get(56) != 0) {
            return false;
        }
        int i = intBuffer.get(0) << 2;
        intBuffer2.put(0, i);
        intBuffer2.put(8, i);
        intBuffer2.put(16, i);
        intBuffer2.put(24, i);
        intBuffer2.put(32, i);
        intBuffer2.put(40, i);
        intBuffer2.put(48, i);
        intBuffer2.put(56, i);
        advance(intBuffer);
        advance(intBuffer2);
        return true;
    }

    private static void pass1(IntBuffer intBuffer, IntBuffer intBuffer2) {
        int i = 8;
        IntBuffer intBuffer3 = intBuffer;
        IntBuffer intBuffer4 = intBuffer2;
        int i2 = 8;
        while (i2 > 0) {
            int i3 = intBuffer3.get(16);
            int i4 = intBuffer3.get(48);
            int MULTIPLY = MULTIPLY(i3 + i4, FIX_0_541196100);
            i4 = MULTIPLY(i4, -FIX_1_847759065) + MULTIPLY;
            MULTIPLY += MULTIPLY(i3, FIX_0_765366865);
            int i5 = intBuffer3.get(0);
            int i6 = intBuffer3.get(32);
            int i7 = (i5 + i6) << 13;
            i5 = (i5 - i6) << 13;
            i6 = i7 + MULTIPLY;
            i7 -= MULTIPLY;
            MULTIPLY = i5 + i4;
            i5 -= i4;
            int i8 = intBuffer3.get(56);
            int i9 = intBuffer3.get(40);
            int i10 = intBuffer3.get(24);
            int i11 = intBuffer3.get(i);
            int i12 = i8 + i11;
            int i13 = i9 + i10;
            i = i8 + i10;
            i4 = i9 + i11;
            int i14 = i2;
            i2 = MULTIPLY(i + i4, FIX_1_175875602);
            i3 = MULTIPLY(i8, FIX_0_298631336);
            i8 = MULTIPLY(i9, FIX_2_053119869);
            i10 = MULTIPLY(i10, FIX_3_072711026);
            i11 = MULTIPLY(i11, FIX_1_501321110);
            i12 = MULTIPLY(i12, -FIX_0_899976223);
            i13 = MULTIPLY(i13, -FIX_2_562915447);
            i = MULTIPLY(i, -FIX_1_961570560) + i2;
            i4 = MULTIPLY(i4, -FIX_0_390180644) + i2;
            i3 += i12 + i;
            i8 += i13 + i4;
            i10 += i13 + i;
            i11 += i12 + i4;
            intBuffer4.put(0, DESCALE(i6 + i11, 11));
            intBuffer4.put(56, DESCALE(i6 - i11, 11));
            intBuffer4.put(8, DESCALE(MULTIPLY + i10, 11));
            intBuffer4.put(48, DESCALE(MULTIPLY - i10, 11));
            intBuffer4.put(16, DESCALE(i5 + i8, 11));
            intBuffer4.put(40, DESCALE(i5 - i8, 11));
            intBuffer4.put(24, DESCALE(i7 + i3, 11));
            intBuffer4.put(32, DESCALE(i7 - i3, 11));
            intBuffer3 = advance(intBuffer3);
            intBuffer4 = advance(intBuffer4);
            i2 = i14 - 1;
            i = 8;
        }
    }

    private static IntBuffer advance(IntBuffer intBuffer) {
        return advance(intBuffer, 1);
    }

    private static IntBuffer advance(IntBuffer intBuffer, int i) {
        return ((IntBuffer) intBuffer.position(intBuffer.position() + i)).slice();
    }

    static int DESCALE(int i, int i2) {
        return RIGHT_SHIFT(i + (1 << (i2 - 1)), i2);
    }
}
