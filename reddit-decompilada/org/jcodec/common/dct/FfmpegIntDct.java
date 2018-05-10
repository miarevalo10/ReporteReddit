package org.jcodec.common.dct;

import java.nio.ShortBuffer;

public class FfmpegIntDct {
    private static final int CONST_BITS = 13;
    private static final int D1 = 11;
    private static final int D2 = 18;
    private static final int DCTSIZE = 8;
    private static final int DCTSIZE_0 = 0;
    private static final int DCTSIZE_1 = 8;
    private static final int DCTSIZE_2 = 16;
    private static final int DCTSIZE_3 = 24;
    private static final int DCTSIZE_4 = 32;
    private static final int DCTSIZE_5 = 40;
    private static final int DCTSIZE_6 = 48;
    private static final int DCTSIZE_7 = 56;
    private static final short FIX_0_211164243 = (short) 1730;
    private static final short FIX_0_275899380 = (short) 2260;
    private static final short FIX_0_298631336 = (short) 2446;
    private static final short FIX_0_390180644 = (short) 3196;
    private static final short FIX_0_509795579 = (short) 4176;
    private static final short FIX_0_541196100 = (short) 4433;
    private static final short FIX_0_601344887 = (short) 4926;
    private static final short FIX_0_765366865 = (short) 6270;
    private static final short FIX_0_785694958 = (short) 6436;
    private static final short FIX_0_899976223 = (short) 7373;
    private static final short FIX_1_061594337 = (short) 8697;
    private static final short FIX_1_111140466 = (short) 9102;
    private static final short FIX_1_175875602 = (short) 9633;
    private static final short FIX_1_306562965 = (short) 10703;
    private static final short FIX_1_387039845 = (short) 11363;
    private static final short FIX_1_451774981 = (short) 11893;
    private static final short FIX_1_501321110 = (short) 12299;
    private static final short FIX_1_662939225 = (short) 13623;
    private static final short FIX_1_847759065 = (short) 15137;
    private static final short FIX_1_961570560 = (short) 16069;
    private static final short FIX_2_053119869 = (short) 16819;
    private static final short FIX_2_172734803 = (short) 17799;
    private static final short FIX_2_562915447 = (short) 20995;
    private static final short FIX_3_072711026 = (short) 25172;
    private static final int ONEHALF_11 = 1024;
    private static final int ONEHALF_18 = 131072;
    private static final int PASS1_BITS = 2;

    private static final int DESCALE(int i, int i2) {
        return (i + (1 << (i2 - 1))) >> i2;
    }

    private static final short DESCALE11(int i) {
        return (short) ((i + 1024) >> 11);
    }

    private static final short DESCALE18(int i) {
        return (short) ((i + ONEHALF_18) >> 18);
    }

    private static int MULTIPLY(int i, short s) {
        return s * ((short) i);
    }

    public short[] decode(short[] sArr) {
        ShortBuffer wrap = ShortBuffer.wrap(sArr);
        pass1(wrap);
        pass2(wrap);
        return sArr;
    }

    private static ShortBuffer advance(ShortBuffer shortBuffer, int i) {
        return ((ShortBuffer) shortBuffer.position(shortBuffer.position() + i)).slice();
    }

    private static final void pass1(ShortBuffer shortBuffer) {
        int i = 7;
        ShortBuffer duplicate = shortBuffer.duplicate();
        int i2 = 7;
        while (i2 >= 0) {
            int i3;
            int i4;
            int i5 = 0;
            short s = duplicate.get(0);
            short s2 = duplicate.get(1);
            short s3 = duplicate.get(2);
            short s4 = duplicate.get(3);
            short s5 = duplicate.get(4);
            short s6 = duplicate.get(5);
            short s7 = duplicate.get(6);
            short s8 = duplicate.get(i);
            int i6;
            if (((((((s5 | s2) | s6) | s3) | s7) | s4) | s8) == 0) {
                if (s != (short) 0) {
                    i6 = s << 2;
                    while (i5 < 8) {
                        duplicate.put(i5, (short) i6);
                        i5++;
                    }
                }
                duplicate = advance(duplicate, 8);
                i3 = i2;
                i4 = i;
            } else {
                int MULTIPLY;
                int i7;
                int i8;
                int i9;
                if (s4 != (short) 0) {
                    if (s2 != (short) 0) {
                        MULTIPLY = MULTIPLY(s2 + s4, FIX_0_541196100);
                        i4 = MULTIPLY(-s4, FIX_1_847759065) + MULTIPLY;
                        MULTIPLY += MULTIPLY(s2, FIX_0_765366865);
                        i7 = (s + s3) << 13;
                        i6 = (s - s3) << 13;
                        i8 = i7 + MULTIPLY;
                        i7 -= MULTIPLY;
                        MULTIPLY = i6 + i4;
                        i6 -= i4;
                    } else {
                        i7 = MULTIPLY(-s4, FIX_1_306562965);
                        i4 = MULTIPLY(s4, FIX_0_541196100);
                        MULTIPLY = (s + s3) << 13;
                        i6 = (s - s3) << 13;
                        i8 = MULTIPLY + i4;
                        i4 = MULTIPLY - i4;
                        MULTIPLY = i6 + i7;
                        i6 -= i7;
                        i7 = i4;
                    }
                } else if (s2 != (short) 0) {
                    i4 = MULTIPLY(s2, FIX_0_541196100);
                    i7 = MULTIPLY(s2, FIX_1_306562965);
                    MULTIPLY = (s + s3) << 13;
                    i6 = (s - s3) << 13;
                    i8 = MULTIPLY + i7;
                    i7 = MULTIPLY - i7;
                    MULTIPLY = i6 + i4;
                    i6 -= i4;
                } else {
                    i7 = (s + s3) << 13;
                    MULTIPLY = (s - s3) << 13;
                    i8 = i7;
                    i6 = MULTIPLY;
                }
                int MULTIPLY2;
                int MULTIPLY3;
                int MULTIPLY4;
                int MULTIPLY5;
                if (s8 != (short) 0) {
                    if (s7 == (short) 0) {
                        i3 = i2;
                        if (s6 != (short) 0) {
                            if (s5 != (short) 0) {
                                i2 = s8 + s5;
                                i4 = s8 + s6;
                                i = MULTIPLY(i4 + s5, FIX_1_175875602);
                                i5 = MULTIPLY(s8, FIX_0_298631336);
                                MULTIPLY2 = MULTIPLY(s6, FIX_3_072711026);
                                MULTIPLY3 = MULTIPLY(s5, FIX_1_501321110);
                                i2 = MULTIPLY(-i2, FIX_0_899976223);
                                MULTIPLY4 = MULTIPLY(-s6, FIX_2_562915447);
                                i4 = MULTIPLY(-i4, FIX_1_961570560) + i;
                                MULTIPLY5 = MULTIPLY(-s5, FIX_0_390180644) + i;
                                i5 += i2 + i4;
                                i = MULTIPLY4 + MULTIPLY5;
                                i9 = MULTIPLY2 + (MULTIPLY4 + i4);
                                i4 = (i2 + MULTIPLY5) + MULTIPLY3;
                                i2 = i9;
                            } else {
                                i2 = s8 + s6;
                                i5 = -s8;
                                i4 = MULTIPLY(i5, FIX_0_601344887);
                                i5 = MULTIPLY(i5, FIX_0_899976223);
                                MULTIPLY5 = MULTIPLY(s6, FIX_0_509795579);
                                MULTIPLY4 = MULTIPLY(-s6, FIX_2_562915447);
                                i = MULTIPLY(i2, FIX_1_175875602);
                                i2 = MULTIPLY(-i2, FIX_0_785694958);
                                i4 += i2;
                                i2 += MULTIPLY5;
                                i5 += i;
                                i = MULTIPLY4 + i;
                                i9 = i4;
                                i4 = i5;
                                i5 = i9;
                            }
                        } else if (s5 != (short) 0) {
                            i2 = s8 + s5;
                            i = MULTIPLY(i2, FIX_1_175875602);
                            i2 = MULTIPLY(i2, FIX_0_275899380);
                            i5 = -s8;
                            i4 = MULTIPLY(i5, FIX_1_961570560);
                            i5 = MULTIPLY(i5, FIX_1_662939225);
                            i5 += i2;
                            MULTIPLY4 = MULTIPLY(-s5, FIX_0_390180644) + i;
                            i += i4;
                            i2 += MULTIPLY(s5, FIX_1_111140466);
                            i4 = i2;
                            i2 = i;
                            i = MULTIPLY4;
                        } else {
                            i2 = -s8;
                            i5 = MULTIPLY(i2, FIX_1_387039845);
                            i = MULTIPLY(s8, FIX_1_175875602);
                            i2 = MULTIPLY(i2, FIX_0_785694958);
                            i4 = MULTIPLY(s8, FIX_0_275899380);
                        }
                    } else if (s6 == (short) 0) {
                        i3 = i2;
                        if (s5 != (short) 0) {
                            i2 = s8 + s5;
                            i4 = s7 + s5;
                            i = MULTIPLY(s8 + i4, FIX_1_175875602);
                            i5 = MULTIPLY(s8, FIX_0_298631336);
                            MULTIPLY4 = MULTIPLY(s7, FIX_2_053119869);
                            MULTIPLY5 = MULTIPLY(s5, FIX_1_501321110);
                            i2 = MULTIPLY(-i2, FIX_0_899976223);
                            MULTIPLY2 = MULTIPLY(-s7, FIX_2_562915447);
                            MULTIPLY3 = MULTIPLY(-s8, FIX_1_961570560) + i;
                            i4 = MULTIPLY(-i4, FIX_0_390180644) + i;
                            i5 += i2 + MULTIPLY3;
                            i = (MULTIPLY2 + i4) + MULTIPLY4;
                            i4 = (i2 + i4) + MULTIPLY5;
                            i2 = MULTIPLY2 + MULTIPLY3;
                        } else {
                            i2 = -s8;
                            i5 = MULTIPLY(i2, FIX_0_601344887);
                            i4 = MULTIPLY(i2, FIX_0_899976223);
                            i2 = MULTIPLY(i2, FIX_1_961570560);
                            MULTIPLY5 = -s7;
                            MULTIPLY4 = MULTIPLY(MULTIPLY5, FIX_0_509795579);
                            r13 = MULTIPLY(MULTIPLY5, FIX_2_562915447);
                            MULTIPLY5 = MULTIPLY(MULTIPLY5, FIX_0_390180644);
                            i = MULTIPLY(s7 + s8, FIX_1_175875602);
                            i2 += i;
                            MULTIPLY5 += i;
                            i5 += i2;
                            i = MULTIPLY4 + MULTIPLY5;
                            i2 += r13;
                            i4 += MULTIPLY5;
                        }
                    } else if (s5 != (short) 0) {
                        int i10 = s8 + s5;
                        i4 = s7 + s6;
                        r13 = s8 + s6;
                        int i11 = s7 + s5;
                        i3 = i2;
                        i2 = MULTIPLY(r13 + i11, FIX_1_175875602);
                        i = MULTIPLY(s8, FIX_0_298631336);
                        i5 = MULTIPLY(s7, FIX_2_053119869);
                        MULTIPLY4 = MULTIPLY(s6, FIX_3_072711026);
                        MULTIPLY5 = MULTIPLY(s5, FIX_1_501321110);
                        MULTIPLY2 = MULTIPLY(-i10, FIX_0_899976223);
                        i4 = MULTIPLY(-i4, FIX_2_562915447);
                        MULTIPLY3 = MULTIPLY(-r13, FIX_1_961570560) + i2;
                        r13 = MULTIPLY(-i11, FIX_0_390180644) + i2;
                        i2 = (MULTIPLY2 + MULTIPLY3) + i;
                        i5 += i4 + r13;
                        i = MULTIPLY4 + (i4 + MULTIPLY3);
                        i4 = MULTIPLY5 + (MULTIPLY2 + r13);
                        i9 = i5;
                        i5 = i2;
                        i2 = i;
                    } else {
                        i3 = i2;
                        i2 = s7 + s6;
                        i4 = s8 + s6;
                        i = MULTIPLY(i4 + s7, FIX_1_175875602);
                        i5 = MULTIPLY(s8, FIX_0_298631336);
                        MULTIPLY5 = MULTIPLY(s7, FIX_2_053119869);
                        MULTIPLY4 = MULTIPLY(s6, FIX_3_072711026);
                        MULTIPLY3 = MULTIPLY(-s8, FIX_0_899976223);
                        i2 = MULTIPLY(-i2, FIX_2_562915447);
                        i4 = MULTIPLY(-i4, FIX_1_961570560) + i;
                        MULTIPLY2 = MULTIPLY(-s7, FIX_0_390180644) + i;
                        i5 += MULTIPLY3 + i4;
                        i = (i2 + MULTIPLY2) + MULTIPLY5;
                        i2 = (i2 + i4) + MULTIPLY4;
                        i4 = MULTIPLY3 + MULTIPLY2;
                    }
                    duplicate.put(0, DESCALE11(i8 + i4));
                    i4 = 7;
                    duplicate.put(7, DESCALE11(i8 - i4));
                    duplicate.put(1, DESCALE11(MULTIPLY + i2));
                    duplicate.put(6, DESCALE11(MULTIPLY - i2));
                    duplicate.put(2, DESCALE11(i6 + i));
                    duplicate.put(5, DESCALE11(i6 - i));
                    duplicate.put(3, DESCALE11(i7 + i5));
                    duplicate.put(4, DESCALE11(i7 - i5));
                    duplicate = advance(duplicate, 8);
                } else {
                    i3 = i2;
                    if (s7 != (short) 0) {
                        if (s6 != (short) 0) {
                            if (s5 != (short) 0) {
                                i2 = s7 + s6;
                                i5 = s7 + s5;
                                i = MULTIPLY(s6 + i5, FIX_1_175875602);
                                i4 = MULTIPLY(s7, FIX_2_053119869);
                                MULTIPLY2 = MULTIPLY(s6, FIX_3_072711026);
                                MULTIPLY3 = MULTIPLY(s5, FIX_1_501321110);
                                MULTIPLY5 = MULTIPLY(-s5, FIX_0_899976223);
                                i2 = MULTIPLY(-i2, FIX_2_562915447);
                                MULTIPLY4 = MULTIPLY(-s6, FIX_1_961570560) + i;
                                i5 = MULTIPLY(-i5, FIX_0_390180644) + i;
                                i = MULTIPLY5 + MULTIPLY4;
                                i4 += i2 + i5;
                                i2 = (i2 + MULTIPLY4) + MULTIPLY2;
                                i5 = MULTIPLY3 + (MULTIPLY5 + i5);
                            } else {
                                i2 = s7 + s6;
                                i = MULTIPLY(i2, FIX_1_175875602);
                                i5 = MULTIPLY(s7, FIX_1_662939225);
                                i4 = MULTIPLY(-s7, FIX_0_390180644);
                                i2 = MULTIPLY(-i2, FIX_1_387039845);
                                MULTIPLY5 = MULTIPLY(s6, FIX_1_111140466);
                                MULTIPLY4 = MULTIPLY(-s6, FIX_1_961570560) + i;
                                i5 += i2;
                                i2 += MULTIPLY5;
                                i4 = i + i4;
                                i = i5;
                                i5 = MULTIPLY4;
                                duplicate.put(0, DESCALE11(i8 + i4));
                                i4 = 7;
                                duplicate.put(7, DESCALE11(i8 - i4));
                                duplicate.put(1, DESCALE11(MULTIPLY + i2));
                                duplicate.put(6, DESCALE11(MULTIPLY - i2));
                                duplicate.put(2, DESCALE11(i6 + i));
                                duplicate.put(5, DESCALE11(i6 - i));
                                duplicate.put(3, DESCALE11(i7 + i5));
                                duplicate.put(4, DESCALE11(i7 - i5));
                                duplicate = advance(duplicate, 8);
                            }
                        } else if (s5 != (short) 0) {
                            i2 = s7 + s5;
                            i = MULTIPLY(i2, FIX_1_175875602);
                            i5 = MULTIPLY(-s5, FIX_0_899976223);
                            i4 = MULTIPLY(s5, FIX_0_601344887);
                            MULTIPLY5 = -s7;
                            MULTIPLY4 = MULTIPLY(MULTIPLY5, FIX_0_509795579);
                            MULTIPLY5 = MULTIPLY(MULTIPLY5, FIX_2_562915447);
                            i2 = MULTIPLY(i2, FIX_0_785694958);
                            i5 += i;
                            MULTIPLY4 += i2;
                            i += MULTIPLY5;
                            i2 += i4;
                            i4 = i2;
                            i2 = i;
                            i = MULTIPLY4;
                            duplicate.put(0, DESCALE11(i8 + i4));
                            i4 = 7;
                            duplicate.put(7, DESCALE11(i8 - i4));
                            duplicate.put(1, DESCALE11(MULTIPLY + i2));
                            duplicate.put(6, DESCALE11(MULTIPLY - i2));
                            duplicate.put(2, DESCALE11(i6 + i));
                            duplicate.put(5, DESCALE11(i6 - i));
                            duplicate.put(3, DESCALE11(i7 + i5));
                            duplicate.put(4, DESCALE11(i7 - i5));
                            duplicate = advance(duplicate, 8);
                        } else {
                            i5 = MULTIPLY(s7, FIX_1_175875602);
                            i2 = MULTIPLY(s7, FIX_0_275899380);
                            i = MULTIPLY(-s7, FIX_1_387039845);
                            i4 = MULTIPLY(s7, FIX_0_785694958);
                            i9 = i;
                            i = i2;
                            i2 = i9;
                            duplicate.put(0, DESCALE11(i8 + i4));
                            i4 = 7;
                            duplicate.put(7, DESCALE11(i8 - i4));
                            duplicate.put(1, DESCALE11(MULTIPLY + i2));
                            duplicate.put(6, DESCALE11(MULTIPLY - i2));
                            duplicate.put(2, DESCALE11(i6 + i));
                            duplicate.put(5, DESCALE11(i6 - i));
                            duplicate.put(3, DESCALE11(i7 + i5));
                            duplicate.put(4, DESCALE11(i7 - i5));
                            duplicate = advance(duplicate, 8);
                        }
                    } else if (s6 != (short) 0) {
                        if (s5 != (short) 0) {
                            i2 = s5 + s6;
                            i5 = MULTIPLY(s5, FIX_0_211164243);
                            i4 = -s6;
                            MULTIPLY4 = MULTIPLY(i4, FIX_1_451774981);
                            MULTIPLY5 = MULTIPLY(s5, FIX_1_061594337);
                            i4 = MULTIPLY(i4, FIX_2_172734803);
                            MULTIPLY2 = MULTIPLY(i2, FIX_0_785694958);
                            i2 = MULTIPLY(i2, FIX_1_175875602);
                            i = MULTIPLY5 - MULTIPLY2;
                            i4 += MULTIPLY2;
                            i5 += i2;
                            i2 = MULTIPLY4 + i2;
                        } else {
                            i2 = -s6;
                            i5 = MULTIPLY(i2, FIX_0_785694958);
                            i4 = MULTIPLY(i2, FIX_1_387039845);
                            i2 = MULTIPLY(i2, FIX_0_275899380);
                            i9 = i4;
                            i4 = MULTIPLY(s6, FIX_1_175875602);
                        }
                    } else if (s5 != (short) 0) {
                        i5 = MULTIPLY(s5, FIX_0_275899380);
                        i2 = MULTIPLY(s5, FIX_0_785694958);
                        i = MULTIPLY(s5, FIX_1_175875602);
                        i4 = MULTIPLY(s5, FIX_1_387039845);
                        i9 = i;
                        i = i2;
                        i2 = i9;
                        duplicate.put(0, DESCALE11(i8 + i4));
                        i4 = 7;
                        duplicate.put(7, DESCALE11(i8 - i4));
                        duplicate.put(1, DESCALE11(MULTIPLY + i2));
                        duplicate.put(6, DESCALE11(MULTIPLY - i2));
                        duplicate.put(2, DESCALE11(i6 + i));
                        duplicate.put(5, DESCALE11(i6 - i));
                        duplicate.put(3, DESCALE11(i7 + i5));
                        duplicate.put(4, DESCALE11(i7 - i5));
                        duplicate = advance(duplicate, 8);
                    } else {
                        i2 = 0;
                        i = 0;
                        i5 = 0;
                        i4 = 0;
                        duplicate.put(0, DESCALE11(i8 + i4));
                        i4 = 7;
                        duplicate.put(7, DESCALE11(i8 - i4));
                        duplicate.put(1, DESCALE11(MULTIPLY + i2));
                        duplicate.put(6, DESCALE11(MULTIPLY - i2));
                        duplicate.put(2, DESCALE11(i6 + i));
                        duplicate.put(5, DESCALE11(i6 - i));
                        duplicate.put(3, DESCALE11(i7 + i5));
                        duplicate.put(4, DESCALE11(i7 - i5));
                        duplicate = advance(duplicate, 8);
                    }
                    i9 = i5;
                    i5 = i;
                    i = i4;
                    i4 = i9;
                    duplicate.put(0, DESCALE11(i8 + i4));
                    i4 = 7;
                    duplicate.put(7, DESCALE11(i8 - i4));
                    duplicate.put(1, DESCALE11(MULTIPLY + i2));
                    duplicate.put(6, DESCALE11(MULTIPLY - i2));
                    duplicate.put(2, DESCALE11(i6 + i));
                    duplicate.put(5, DESCALE11(i6 - i));
                    duplicate.put(3, DESCALE11(i7 + i5));
                    duplicate.put(4, DESCALE11(i7 - i5));
                    duplicate = advance(duplicate, 8);
                }
                i = i9;
                duplicate.put(0, DESCALE11(i8 + i4));
                i4 = 7;
                duplicate.put(7, DESCALE11(i8 - i4));
                duplicate.put(1, DESCALE11(MULTIPLY + i2));
                duplicate.put(6, DESCALE11(MULTIPLY - i2));
                duplicate.put(2, DESCALE11(i6 + i));
                duplicate.put(5, DESCALE11(i6 - i));
                duplicate.put(3, DESCALE11(i7 + i5));
                duplicate.put(4, DESCALE11(i7 - i5));
                duplicate = advance(duplicate, 8);
            }
            i2 = i3 - 1;
            i = i4;
        }
    }

    private static final void pass2(ShortBuffer shortBuffer) {
        ShortBuffer duplicate = shortBuffer.duplicate();
        int i = 7;
        while (i >= 0) {
            int MULTIPLY;
            int MULTIPLY2;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int MULTIPLY3;
            int MULTIPLY4;
            short s = duplicate.get(0);
            short s2 = duplicate.get(8);
            short s3 = duplicate.get(16);
            short s4 = duplicate.get(24);
            short s5 = duplicate.get(32);
            short s6 = duplicate.get(40);
            short s7 = duplicate.get(48);
            short s8 = duplicate.get(56);
            if (s7 != (short) 0) {
                if (s3 != (short) 0) {
                    MULTIPLY = MULTIPLY(s3 + s7, FIX_0_541196100);
                    MULTIPLY2 = MULTIPLY(-s7, FIX_1_847759065) + MULTIPLY;
                    MULTIPLY += MULTIPLY(s3, FIX_0_765366865);
                    i2 = (s + s5) << 13;
                    i3 = (s - s5) << 13;
                    i4 = i2 + MULTIPLY;
                    i2 -= MULTIPLY;
                    MULTIPLY = i3 + MULTIPLY2;
                    i3 -= MULTIPLY2;
                } else {
                    i2 = MULTIPLY(-s7, FIX_1_306562965);
                    MULTIPLY2 = MULTIPLY(s7, FIX_0_541196100);
                    MULTIPLY = (s + s5) << 13;
                    i3 = (s - s5) << 13;
                    i4 = MULTIPLY + MULTIPLY2;
                    MULTIPLY2 = MULTIPLY - MULTIPLY2;
                    MULTIPLY = i3 + i2;
                    i3 -= i2;
                    i2 = MULTIPLY2;
                }
            } else if (s3 != (short) 0) {
                MULTIPLY2 = MULTIPLY(s3, FIX_0_541196100);
                i2 = MULTIPLY(s3, FIX_1_306562965);
                MULTIPLY = (s + s5) << 13;
                i3 = (s - s5) << 13;
                i4 = MULTIPLY + i2;
                i2 = MULTIPLY - i2;
                MULTIPLY = i3 + MULTIPLY2;
                i3 -= MULTIPLY2;
            } else {
                i2 = (s + s5) << 13;
                MULTIPLY = (s - s5) << 13;
                i4 = i2;
                i3 = MULTIPLY;
            }
            int MULTIPLY5;
            int MULTIPLY6;
            int MULTIPLY7;
            int MULTIPLY8;
            if (s8 == (short) 0) {
                i5 = i;
                if (s6 != (short) 0) {
                    if (s4 != (short) 0) {
                        if (s2 != (short) 0) {
                            i = s6 + s4;
                            i6 = s6 + s2;
                            MULTIPLY2 = MULTIPLY(s4 + i6, FIX_1_175875602);
                            MULTIPLY5 = MULTIPLY(s6, FIX_2_053119869);
                            MULTIPLY6 = MULTIPLY(s4, FIX_3_072711026);
                            MULTIPLY7 = MULTIPLY(s2, FIX_1_501321110);
                            MULTIPLY3 = MULTIPLY(-s2, FIX_0_899976223);
                            i = MULTIPLY(-i, FIX_2_562915447);
                            MULTIPLY4 = MULTIPLY(-s4, FIX_1_961570560) + MULTIPLY2;
                            i6 = MULTIPLY(-i6, FIX_0_390180644) + MULTIPLY2;
                            MULTIPLY2 = MULTIPLY3 + MULTIPLY4;
                            MULTIPLY5 += i + i6;
                            MULTIPLY4 = (i + MULTIPLY4) + MULTIPLY6;
                            i = MULTIPLY7 + (MULTIPLY3 + i6);
                            i6 = MULTIPLY2;
                            MULTIPLY2 = MULTIPLY5;
                        } else {
                            i = s6 + s4;
                            i6 = MULTIPLY(i, FIX_1_175875602);
                            MULTIPLY3 = MULTIPLY(s6, FIX_1_662939225);
                            MULTIPLY5 = MULTIPLY(-s6, FIX_0_390180644);
                            i = MULTIPLY(-i, FIX_1_387039845);
                            MULTIPLY2 = MULTIPLY(s4, FIX_1_111140466);
                            MULTIPLY3 += i;
                            i += MULTIPLY2;
                            MULTIPLY2 = MULTIPLY3;
                            MULTIPLY8 = MULTIPLY(-s4, FIX_1_961570560) + i6;
                            MULTIPLY4 = i;
                            i = i6 + MULTIPLY5;
                            i6 = MULTIPLY8;
                        }
                    } else if (s2 != (short) 0) {
                        i = s6 + s2;
                        i6 = MULTIPLY(i, FIX_1_175875602);
                        MULTIPLY4 = MULTIPLY(-s2, FIX_0_899976223);
                        MULTIPLY3 = MULTIPLY(s2, FIX_0_601344887);
                        MULTIPLY5 = -s6;
                        MULTIPLY2 = MULTIPLY(MULTIPLY5, FIX_0_509795579);
                        MULTIPLY5 = MULTIPLY(MULTIPLY5, FIX_2_562915447);
                        i = MULTIPLY(i, FIX_0_785694958);
                        MULTIPLY4 += i6;
                        MULTIPLY2 += i;
                        i6 += MULTIPLY5;
                        i += MULTIPLY3;
                        MULTIPLY8 = MULTIPLY4;
                        MULTIPLY4 = i6;
                        i6 = MULTIPLY8;
                    } else {
                        i6 = MULTIPLY(s6, FIX_1_175875602);
                        i = MULTIPLY(s6, FIX_0_275899380);
                        MULTIPLY3 = MULTIPLY(-s6, FIX_1_387039845);
                        MULTIPLY2 = i;
                        i = MULTIPLY(s6, FIX_0_785694958);
                        MULTIPLY4 = MULTIPLY3;
                    }
                } else if (s4 != (short) 0) {
                    if (s2 != (short) 0) {
                        i = s2 + s4;
                        i6 = MULTIPLY(s2, FIX_0_211164243);
                        MULTIPLY4 = -s4;
                        MULTIPLY5 = MULTIPLY(MULTIPLY4, FIX_1_451774981);
                        MULTIPLY3 = MULTIPLY(s2, FIX_1_061594337);
                        MULTIPLY4 = MULTIPLY(MULTIPLY4, FIX_2_172734803);
                        MULTIPLY2 = MULTIPLY(i, FIX_0_785694958);
                        i = MULTIPLY(i, FIX_1_175875602);
                        MULTIPLY5 += i;
                        i = i6 + i;
                        i6 = MULTIPLY3 - MULTIPLY2;
                        MULTIPLY2 = MULTIPLY4 + MULTIPLY2;
                        MULTIPLY4 = MULTIPLY5;
                    } else {
                        i = -s4;
                        i6 = MULTIPLY(i, FIX_0_785694958);
                        MULTIPLY3 = MULTIPLY(i, FIX_1_387039845);
                        i = MULTIPLY(i, FIX_0_275899380);
                        MULTIPLY4 = MULTIPLY(s4, FIX_1_175875602);
                        MULTIPLY2 = MULTIPLY3;
                        MULTIPLY8 = MULTIPLY4;
                        MULTIPLY4 = i;
                        i = MULTIPLY8;
                    }
                } else if (s2 != (short) 0) {
                    i6 = MULTIPLY(s2, FIX_0_275899380);
                    i = MULTIPLY(s2, FIX_0_785694958);
                    MULTIPLY4 = MULTIPLY(s2, FIX_1_175875602);
                    MULTIPLY3 = MULTIPLY(s2, FIX_1_387039845);
                } else {
                    i = 0;
                    i6 = 0;
                    MULTIPLY4 = 0;
                    MULTIPLY2 = 0;
                }
                duplicate.put(0, DESCALE18(i4 + i));
                duplicate.put(56, DESCALE18(i4 - i));
                duplicate.put(8, DESCALE18(MULTIPLY + MULTIPLY4));
                duplicate.put(48, DESCALE18(MULTIPLY - MULTIPLY4));
                duplicate.put(16, DESCALE18(i3 + MULTIPLY2));
                duplicate.put(40, DESCALE18(i3 - MULTIPLY2));
                duplicate.put(24, DESCALE18(i2 + i6));
                duplicate.put(32, DESCALE18(i2 - i6));
                duplicate = advance(duplicate, 1);
                i = i5 - 1;
            } else if (s6 == (short) 0) {
                i5 = i;
                if (s4 != (short) 0) {
                    if (s2 != (short) 0) {
                        i = s8 + s2;
                        MULTIPLY5 = s8 + s4;
                        MULTIPLY2 = MULTIPLY(MULTIPLY5 + s2, FIX_1_175875602);
                        i6 = MULTIPLY(s8, FIX_0_298631336);
                        MULTIPLY6 = MULTIPLY(s4, FIX_3_072711026);
                        MULTIPLY7 = MULTIPLY(s2, FIX_1_501321110);
                        i = MULTIPLY(-i, FIX_0_899976223);
                        MULTIPLY4 = MULTIPLY(-s4, FIX_2_562915447);
                        MULTIPLY5 = MULTIPLY(-MULTIPLY5, FIX_1_961570560) + MULTIPLY2;
                        MULTIPLY3 = MULTIPLY(-s2, FIX_0_390180644) + MULTIPLY2;
                        i6 += i + MULTIPLY5;
                        MULTIPLY2 = MULTIPLY4 + MULTIPLY3;
                        MULTIPLY4 = (MULTIPLY4 + MULTIPLY5) + MULTIPLY6;
                        i = (i + MULTIPLY3) + MULTIPLY7;
                    } else {
                        i = s8 + s4;
                        i6 = -s8;
                        MULTIPLY3 = MULTIPLY(i6, FIX_0_601344887);
                        i6 = MULTIPLY(i6, FIX_0_899976223);
                        MULTIPLY5 = MULTIPLY(s4, FIX_0_509795579);
                        MULTIPLY4 = MULTIPLY(-s4, FIX_2_562915447);
                        MULTIPLY2 = MULTIPLY(i, FIX_1_175875602);
                        i = MULTIPLY(-i, FIX_0_785694958);
                        MULTIPLY3 += i;
                        i6 += MULTIPLY2;
                        MULTIPLY2 = MULTIPLY4 + MULTIPLY2;
                        MULTIPLY4 = i + MULTIPLY5;
                        i = i6;
                        i6 = MULTIPLY3;
                    }
                    duplicate.put(0, DESCALE18(i4 + i));
                    duplicate.put(56, DESCALE18(i4 - i));
                    duplicate.put(8, DESCALE18(MULTIPLY + MULTIPLY4));
                    duplicate.put(48, DESCALE18(MULTIPLY - MULTIPLY4));
                    duplicate.put(16, DESCALE18(i3 + MULTIPLY2));
                    duplicate.put(40, DESCALE18(i3 - MULTIPLY2));
                    duplicate.put(24, DESCALE18(i2 + i6));
                    duplicate.put(32, DESCALE18(i2 - i6));
                    duplicate = advance(duplicate, 1);
                    i = i5 - 1;
                } else if (s2 != (short) 0) {
                    i = s8 + s2;
                    i6 = MULTIPLY(i, FIX_1_175875602);
                    i = MULTIPLY(i, FIX_0_275899380);
                    MULTIPLY4 = -s8;
                    MULTIPLY5 = MULTIPLY(MULTIPLY4, FIX_1_961570560);
                    MULTIPLY4 = MULTIPLY(MULTIPLY4, FIX_1_662939225);
                    MULTIPLY4 += i;
                    MULTIPLY2 = MULTIPLY(-s2, FIX_0_390180644) + i6;
                    i6 += MULTIPLY5;
                    i += MULTIPLY(s2, FIX_1_111140466);
                    MULTIPLY8 = MULTIPLY4;
                    MULTIPLY4 = i6;
                    i6 = MULTIPLY8;
                    duplicate.put(0, DESCALE18(i4 + i));
                    duplicate.put(56, DESCALE18(i4 - i));
                    duplicate.put(8, DESCALE18(MULTIPLY + MULTIPLY4));
                    duplicate.put(48, DESCALE18(MULTIPLY - MULTIPLY4));
                    duplicate.put(16, DESCALE18(i3 + MULTIPLY2));
                    duplicate.put(40, DESCALE18(i3 - MULTIPLY2));
                    duplicate.put(24, DESCALE18(i2 + i6));
                    duplicate.put(32, DESCALE18(i2 - i6));
                    duplicate = advance(duplicate, 1);
                    i = i5 - 1;
                } else {
                    i = -s8;
                    i6 = MULTIPLY(i, FIX_1_387039845);
                    MULTIPLY3 = MULTIPLY(s8, FIX_1_175875602);
                    i = MULTIPLY(i, FIX_0_785694958);
                    MULTIPLY4 = MULTIPLY(s8, FIX_0_275899380);
                    MULTIPLY2 = MULTIPLY3;
                    MULTIPLY8 = MULTIPLY4;
                    MULTIPLY4 = i;
                    i = MULTIPLY8;
                    duplicate.put(0, DESCALE18(i4 + i));
                    duplicate.put(56, DESCALE18(i4 - i));
                    duplicate.put(8, DESCALE18(MULTIPLY + MULTIPLY4));
                    duplicate.put(48, DESCALE18(MULTIPLY - MULTIPLY4));
                    duplicate.put(16, DESCALE18(i3 + MULTIPLY2));
                    duplicate.put(40, DESCALE18(i3 - MULTIPLY2));
                    duplicate.put(24, DESCALE18(i2 + i6));
                    duplicate.put(32, DESCALE18(i2 - i6));
                    duplicate = advance(duplicate, 1);
                    i = i5 - 1;
                }
            } else if (s4 == (short) 0) {
                i5 = i;
                if (s2 != (short) 0) {
                    i = s8 + s2;
                    MULTIPLY4 = s6 + s2;
                    MULTIPLY2 = MULTIPLY(s8 + MULTIPLY4, FIX_1_175875602);
                    i6 = MULTIPLY(s8, FIX_0_298631336);
                    MULTIPLY7 = MULTIPLY(s6, FIX_2_053119869);
                    MULTIPLY3 = MULTIPLY(s2, FIX_1_501321110);
                    i = MULTIPLY(-i, FIX_0_899976223);
                    MULTIPLY5 = MULTIPLY(-s6, FIX_2_562915447);
                    MULTIPLY6 = MULTIPLY(-s8, FIX_1_961570560) + MULTIPLY2;
                    MULTIPLY4 = MULTIPLY(-MULTIPLY4, FIX_0_390180644) + MULTIPLY2;
                    i6 += i + MULTIPLY6;
                    MULTIPLY2 = (MULTIPLY5 + MULTIPLY4) + MULTIPLY7;
                    MULTIPLY5 += MULTIPLY6;
                    i = (i + MULTIPLY4) + MULTIPLY3;
                    MULTIPLY4 = MULTIPLY5;
                    duplicate.put(0, DESCALE18(i4 + i));
                    duplicate.put(56, DESCALE18(i4 - i));
                    duplicate.put(8, DESCALE18(MULTIPLY + MULTIPLY4));
                    duplicate.put(48, DESCALE18(MULTIPLY - MULTIPLY4));
                    duplicate.put(16, DESCALE18(i3 + MULTIPLY2));
                    duplicate.put(40, DESCALE18(i3 - MULTIPLY2));
                    duplicate.put(24, DESCALE18(i2 + i6));
                    duplicate.put(32, DESCALE18(i2 - i6));
                    duplicate = advance(duplicate, 1);
                    i = i5 - 1;
                } else {
                    i = -s8;
                    i6 = MULTIPLY(i, FIX_0_601344887);
                    MULTIPLY3 = MULTIPLY(i, FIX_0_899976223);
                    i = MULTIPLY(i, FIX_1_961570560);
                    MULTIPLY4 = -s6;
                    MULTIPLY2 = MULTIPLY(MULTIPLY4, FIX_0_509795579);
                    MULTIPLY7 = MULTIPLY(MULTIPLY4, FIX_2_562915447);
                    MULTIPLY4 = MULTIPLY(MULTIPLY4, FIX_0_390180644);
                    MULTIPLY5 = MULTIPLY(s6 + s8, FIX_1_175875602);
                    i += MULTIPLY5;
                    MULTIPLY4 += MULTIPLY5;
                    i6 += i;
                    MULTIPLY5 = MULTIPLY2 + MULTIPLY4;
                    MULTIPLY3 += MULTIPLY4;
                    MULTIPLY4 = i + MULTIPLY7;
                    i = MULTIPLY3;
                    MULTIPLY2 = MULTIPLY5;
                    duplicate.put(0, DESCALE18(i4 + i));
                    duplicate.put(56, DESCALE18(i4 - i));
                    duplicate.put(8, DESCALE18(MULTIPLY + MULTIPLY4));
                    duplicate.put(48, DESCALE18(MULTIPLY - MULTIPLY4));
                    duplicate.put(16, DESCALE18(i3 + MULTIPLY2));
                    duplicate.put(40, DESCALE18(i3 - MULTIPLY2));
                    duplicate.put(24, DESCALE18(i2 + i6));
                    duplicate.put(32, DESCALE18(i2 - i6));
                    duplicate = advance(duplicate, 1);
                    i = i5 - 1;
                }
            } else if (s2 != (short) 0) {
                int i7 = s8 + s2;
                MULTIPLY2 = s6 + s4;
                MULTIPLY7 = s8 + s4;
                int i8 = s6 + s2;
                i5 = i;
                i = MULTIPLY(MULTIPLY7 + i8, FIX_1_175875602);
                i6 = MULTIPLY(s8, FIX_0_298631336);
                MULTIPLY5 = MULTIPLY(s6, FIX_2_053119869);
                MULTIPLY4 = MULTIPLY(s4, FIX_3_072711026);
                MULTIPLY3 = MULTIPLY(s2, FIX_1_501321110);
                MULTIPLY6 = MULTIPLY(-i7, FIX_0_899976223);
                MULTIPLY2 = MULTIPLY(-MULTIPLY2, FIX_2_562915447);
                MULTIPLY7 = MULTIPLY(-MULTIPLY7, FIX_1_961570560) + i;
                i8 = MULTIPLY(-i8, FIX_0_390180644) + i;
                i6 += MULTIPLY6 + MULTIPLY7;
                i = (MULTIPLY2 + i8) + MULTIPLY5;
                MULTIPLY4 += MULTIPLY2 + MULTIPLY7;
                MULTIPLY3 += MULTIPLY6 + i8;
            } else {
                i5 = i;
                i = s6 + s4;
                MULTIPLY3 = s8 + s4;
                MULTIPLY2 = MULTIPLY(MULTIPLY3 + s6, FIX_1_175875602);
                i6 = MULTIPLY(s8, FIX_0_298631336);
                MULTIPLY7 = MULTIPLY(s6, FIX_2_053119869);
                MULTIPLY4 = MULTIPLY(s4, FIX_3_072711026);
                MULTIPLY6 = MULTIPLY(-s8, FIX_0_899976223);
                i = MULTIPLY(-i, FIX_2_562915447);
                MULTIPLY3 = MULTIPLY(-MULTIPLY3, FIX_1_961570560) + MULTIPLY2;
                MULTIPLY5 = MULTIPLY(-s6, FIX_0_390180644) + MULTIPLY2;
                i6 += MULTIPLY6 + MULTIPLY3;
                MULTIPLY2 = (i + MULTIPLY5) + MULTIPLY7;
                MULTIPLY3 = MULTIPLY6 + MULTIPLY5;
                MULTIPLY4 = (i + MULTIPLY3) + MULTIPLY4;
                i = MULTIPLY3;
                duplicate.put(0, DESCALE18(i4 + i));
                duplicate.put(56, DESCALE18(i4 - i));
                duplicate.put(8, DESCALE18(MULTIPLY + MULTIPLY4));
                duplicate.put(48, DESCALE18(MULTIPLY - MULTIPLY4));
                duplicate.put(16, DESCALE18(i3 + MULTIPLY2));
                duplicate.put(40, DESCALE18(i3 - MULTIPLY2));
                duplicate.put(24, DESCALE18(i2 + i6));
                duplicate.put(32, DESCALE18(i2 - i6));
                duplicate = advance(duplicate, 1);
                i = i5 - 1;
            }
            MULTIPLY2 = i;
            i = MULTIPLY3;
            duplicate.put(0, DESCALE18(i4 + i));
            duplicate.put(56, DESCALE18(i4 - i));
            duplicate.put(8, DESCALE18(MULTIPLY + MULTIPLY4));
            duplicate.put(48, DESCALE18(MULTIPLY - MULTIPLY4));
            duplicate.put(16, DESCALE18(i3 + MULTIPLY2));
            duplicate.put(40, DESCALE18(i3 - MULTIPLY2));
            duplicate.put(24, DESCALE18(i2 + i6));
            duplicate.put(32, DESCALE18(i2 - i6));
            duplicate = advance(duplicate, 1);
            i = i5 - 1;
        }
    }
}
