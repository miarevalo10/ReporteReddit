package org.jcodec.codecs.vp8;

import org.jcodec.codecs.vp8.Macroblock.Subblock;

public class FilterUtil {

    public static class Segment {
        int p0;
        int p1;
        int p2;
        int p3;
        int q0;
        int q1;
        int q2;
        int q3;

        public boolean isFilterRequired(int i, int i2) {
            return (Math.abs(this.p0 - this.q0) << 2) + (Math.abs(this.p1 - this.q1) >> 2) <= i2 && Math.abs(this.p3 - this.p2) <= i && Math.abs(this.p2 - this.p1) <= i && Math.abs(this.p1 - this.p0) <= i && Math.abs(this.q3 - this.q2) <= i && Math.abs(this.q2 - this.q1) <= i && Math.abs(this.q1 - this.q0) <= i;
        }

        public boolean isHighVariance(int i) {
            if (Math.abs(this.p1 - this.p0) <= i) {
                if (Math.abs(this.q1 - this.q0) <= i) {
                    return false;
                }
            }
            return true;
        }

        public Segment getSigned() {
            Segment segment = new Segment();
            segment.p3 = FilterUtil.minus128(this.p3);
            segment.p2 = FilterUtil.minus128(this.p2);
            segment.p1 = FilterUtil.minus128(this.p1);
            segment.p0 = FilterUtil.minus128(this.p0);
            segment.q0 = FilterUtil.minus128(this.q0);
            segment.q1 = FilterUtil.minus128(this.q1);
            segment.q2 = FilterUtil.minus128(this.q2);
            segment.q3 = FilterUtil.minus128(this.q3);
            return segment;
        }

        public static Segment horizontal(Subblock subblock, Subblock subblock2, int i) {
            Segment segment = new Segment();
            int i2 = 12 + i;
            segment.p0 = subblock2.val[i2];
            int i3 = 8 + i;
            segment.p1 = subblock2.val[i3];
            int i4 = 4 + i;
            segment.p2 = subblock2.val[i4];
            int i5 = 0 + i;
            segment.p3 = subblock2.val[i5];
            segment.q0 = subblock.val[i5];
            segment.q1 = subblock.val[i4];
            segment.q2 = subblock.val[i3];
            segment.q3 = subblock.val[i2];
            return segment;
        }

        public static Segment vertical(Subblock subblock, Subblock subblock2, int i) {
            Segment segment = new Segment();
            i *= 4;
            int i2 = i + 3;
            segment.p0 = subblock2.val[i2];
            int i3 = i + 2;
            segment.p1 = subblock2.val[i3];
            int i4 = i + 1;
            segment.p2 = subblock2.val[i4];
            i += 0;
            segment.p3 = subblock2.val[i];
            segment.q0 = subblock.val[i];
            segment.q1 = subblock.val[i4];
            segment.q2 = subblock.val[i3];
            segment.q3 = subblock.val[i2];
            return segment;
        }

        public void applyHorizontally(Subblock subblock, Subblock subblock2, int i) {
            int i2 = 12 + i;
            subblock2.val[i2] = this.p0;
            int i3 = 8 + i;
            subblock2.val[i3] = this.p1;
            int i4 = 4 + i;
            subblock2.val[i4] = this.p2;
            int i5 = 0 + i;
            subblock2.val[i5] = this.p3;
            subblock.val[i5] = this.q0;
            subblock.val[i4] = this.q1;
            subblock.val[i3] = this.q2;
            subblock.val[i2] = this.q3;
        }

        public void applyVertically(Subblock subblock, Subblock subblock2, int i) {
            i *= 4;
            int i2 = i + 3;
            subblock2.val[i2] = this.p0;
            int i3 = i + 2;
            subblock2.val[i3] = this.p1;
            int i4 = i + 1;
            subblock2.val[i4] = this.p2;
            i += 0;
            subblock2.val[i] = this.p3;
            subblock.val[i] = this.q0;
            subblock.val[i4] = this.q1;
            subblock.val[i3] = this.q2;
            subblock.val[i2] = this.q3;
        }

        void filterMb(int i, int i2, int i3) {
            Segment signed = getSigned();
            if (signed.isFilterRequired(i2, i3) != 0) {
                if (signed.isHighVariance(i) == 0) {
                    i = FilterUtil.clipSigned(FilterUtil.clipSigned(signed.p1 - signed.q1) + (3 * (signed.q0 - signed.p0)));
                    i2 = ((27 * i) + 63) >> 7;
                    this.q0 = FilterUtil.clipPlus128(signed.q0 - i2);
                    this.p0 = FilterUtil.clipPlus128(signed.p0 + i2);
                    i2 = ((18 * i) + 63) >> 7;
                    this.q1 = FilterUtil.clipPlus128(signed.q1 - i2);
                    this.p1 = FilterUtil.clipPlus128(signed.p1 + i2);
                    i = ((9 * i) + 63) >> 7;
                    this.q2 = FilterUtil.clipPlus128(signed.q2 - i);
                    this.p2 = FilterUtil.clipPlus128(signed.p2 + i);
                    return;
                }
                adjust(1);
            }
        }

        public void filterSb(int i, int i2, int i3) {
            Segment signed = getSigned();
            if (signed.isFilterRequired(i2, i3) != 0) {
                i = signed.isHighVariance(i);
                i2 = (adjust(i) + 1) >> 1;
                if (i == 0) {
                    this.q1 = FilterUtil.clipPlus128(signed.q1 - i2);
                    this.p1 = FilterUtil.clipPlus128(signed.p1 + i2);
                }
            }
        }

        private int adjust(boolean z) {
            int access$000 = FilterUtil.minus128(this.p1);
            int access$0002 = FilterUtil.minus128(this.p0);
            int access$0003 = FilterUtil.minus128(this.q0);
            z = FilterUtil.clipSigned((z ? FilterUtil.clipSigned(access$000 - FilterUtil.minus128(this.q1)) : false) + ((access$0003 - access$0002) * 3));
            access$000 = FilterUtil.clipSigned(z + 3) >> 3;
            z = FilterUtil.clipSigned(z + 4) >> true;
            this.q0 = FilterUtil.clipPlus128(access$0003 - z);
            this.p0 = FilterUtil.clipPlus128(access$0002 + access$000);
            return z;
        }
    }

    private static int clipSigned(int i) {
        return i < -128 ? -128 : i > 127 ? 127 : i;
    }

    private static int minus128(int i) {
        return i - 128;
    }

    private static int clipPlus128(int i) {
        return clipSigned(i) + 128;
    }

    public static void loopFilterUV(Macroblock[][] macroblockArr, int i, boolean z) {
        Macroblock[][] macroblockArr2 = macroblockArr;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = 2;
            if (i4 < macroblockArr2.length - 2) {
                int i6;
                int i7 = i3;
                while (i7 < macroblockArr2[i3].length - i5) {
                    int i8 = i4 + 1;
                    int i9 = i7 + 1;
                    Macroblock macroblock = macroblockArr2[i8][i9];
                    Macroblock macroblock2 = macroblockArr2[i8][i9];
                    int i10 = macroblock.filterLevel;
                    if (i10 != 0) {
                        int i11;
                        int i12 = macroblock.filterLevel;
                        if (i2 > 0) {
                            i12 >>= i2 > 4 ? i5 : 1;
                            i11 = 9 - i2;
                            if (i12 > i11) {
                                i12 = i11;
                            }
                        }
                        i11 = i12 == 0 ? 1 : i12;
                        if (z) {
                            Macroblock macroblock3;
                            int i13;
                            Subblock subblock;
                            Subblock subblock2;
                            Subblock subblock3;
                            Macroblock macroblock4;
                            Subblock subblock4;
                            Macroblock macroblock5;
                            int i14;
                            Subblock subblock5;
                            Subblock subblock6;
                            int i15 = i10 >= 40 ? i5 : i10 >= 15 ? 1 : i3;
                            int i16 = ((i10 + 2) * 2) + i11;
                            i10 = (i10 * 2) + i11;
                            if (i7 > 0) {
                                macroblock3 = macroblockArr2[i8][i9 - 1];
                                i13 = i3;
                                while (i13 < i5) {
                                    subblock = macroblock.uSubblocks[i13][i3];
                                    subblock2 = macroblock3.uSubblocks[i13][1];
                                    Subblock subblock7 = macroblock.vSubblocks[i13][0];
                                    subblock3 = macroblock3.vSubblocks[i13][1];
                                    Macroblock macroblock6 = macroblock3;
                                    macroblock4 = macroblock2;
                                    for (i7 = 0; i7 < 4; i7++) {
                                        Segment horizontal = Segment.horizontal(subblock, subblock2, i7);
                                        horizontal.filterMb(i15, i11, i16);
                                        horizontal.applyHorizontally(subblock, subblock2, i7);
                                        horizontal = Segment.horizontal(subblock7, subblock3, i7);
                                        horizontal.filterMb(i15, i11, i16);
                                        horizontal.applyHorizontally(subblock7, subblock3, i7);
                                    }
                                    i13++;
                                    macroblock3 = macroblock6;
                                    macroblock2 = macroblock4;
                                    i2 = i;
                                    i3 = 0;
                                    i5 = 2;
                                }
                            }
                            macroblock4 = macroblock2;
                            if (!macroblock.skipFilter) {
                                i2 = 1;
                                while (true) {
                                    i3 = 2;
                                    if (i2 >= 2) {
                                        break;
                                    }
                                    i5 = 0;
                                    while (i5 < i3) {
                                        i7 = i2 - 1;
                                        subblock2 = macroblock.uSubblocks[i5][i7];
                                        subblock4 = macroblock.uSubblocks[i5][i2];
                                        Subblock subblock8 = macroblock.vSubblocks[i5][i7];
                                        subblock3 = macroblock.vSubblocks[i5][i2];
                                        macroblock5 = macroblock;
                                        i13 = 0;
                                        for (i14 = 4; i13 < i14; i14 = 4) {
                                            Segment horizontal2 = Segment.horizontal(subblock4, subblock2, i13);
                                            horizontal2.filterSb(i15, i11, i10);
                                            horizontal2.applyHorizontally(subblock4, subblock2, i13);
                                            horizontal2 = Segment.horizontal(subblock3, subblock8, i13);
                                            horizontal2.filterSb(i15, i11, i10);
                                            horizontal2.applyHorizontally(subblock3, subblock8, i13);
                                            i13++;
                                        }
                                        i5++;
                                        macroblock = macroblock5;
                                        i3 = 2;
                                    }
                                    macroblock5 = macroblock;
                                    i2++;
                                }
                            }
                            macroblock5 = macroblock;
                            if (i4 > 0) {
                                Macroblock macroblock7 = macroblockArr2[i8 - 1][i9];
                                i3 = 0;
                                while (i3 < 2) {
                                    subblock = macroblock7.uSubblocks[1][i3];
                                    macroblock3 = macroblock4;
                                    subblock5 = macroblock3.uSubblocks[0][i3];
                                    subblock6 = macroblock7.vSubblocks[1][i3];
                                    subblock4 = macroblock3.vSubblocks[0][i3];
                                    for (i12 = 0; i12 < 4; i12++) {
                                        Segment vertical = Segment.vertical(subblock5, subblock, i12);
                                        vertical.filterMb(i15, i11, i16);
                                        vertical.applyVertically(subblock5, subblock, i12);
                                        vertical = Segment.vertical(subblock4, subblock6, i12);
                                        vertical.filterMb(i15, i11, i16);
                                        vertical.applyVertically(subblock4, subblock6, i12);
                                    }
                                    i3++;
                                    macroblock4 = macroblock3;
                                }
                            }
                            macroblock3 = macroblock4;
                            i6 = 0;
                            if (!macroblock5.skipFilter) {
                                i2 = 1;
                                while (true) {
                                    i3 = 2;
                                    if (i2 >= 2) {
                                        break;
                                    }
                                    i5 = 0;
                                    while (i5 < i3) {
                                        i14 = i2 - 1;
                                        subblock5 = macroblock3.uSubblocks[i14][i5];
                                        subblock4 = macroblock3.uSubblocks[i2][i5];
                                        subblock6 = macroblock3.vSubblocks[i14][i5];
                                        subblock3 = macroblock3.vSubblocks[i2][i5];
                                        for (i16 = 0; i16 < 4; i16++) {
                                            Segment vertical2 = Segment.vertical(subblock4, subblock5, i16);
                                            vertical2.filterSb(i15, i11, i10);
                                            vertical2.applyVertically(subblock4, subblock5, i16);
                                            vertical2 = Segment.vertical(subblock3, subblock6, i16);
                                            vertical2.filterSb(i15, i11, i10);
                                            vertical2.applyVertically(subblock3, subblock6, i16);
                                        }
                                        i5++;
                                        i3 = 2;
                                    }
                                    i2++;
                                }
                            }
                        } else {
                            throw new UnsupportedOperationException("TODO: non-key frames are not supported yet.");
                        }
                    }
                    i6 = i3;
                    i7 = i9;
                    i3 = i6;
                    i2 = i;
                    i5 = 2;
                }
                i6 = i3;
                i4++;
                i2 = i;
            } else {
                return;
            }
        }
    }

    public static void loopFilterY(Macroblock[][] macroblockArr, int i, boolean z) {
        Macroblock[][] macroblockArr2 = macroblockArr;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = 2;
            if (i4 < macroblockArr2.length - 2) {
                int i6;
                int i7 = i3;
                while (i7 < macroblockArr2[i3].length - i5) {
                    int i8 = i4 + 1;
                    int i9 = i7 + 1;
                    Macroblock macroblock = macroblockArr2[i8][i9];
                    Macroblock macroblock2 = macroblockArr2[i8][i9];
                    int i10 = macroblock.filterLevel;
                    if (i10 != 0) {
                        int i11;
                        int i12 = macroblock.filterLevel;
                        int i13 = 4;
                        if (i2 > 0) {
                            i12 >>= i2 > 4 ? i5 : 1;
                            i11 = 9 - i2;
                            if (i12 > i11) {
                                i12 = i11;
                            }
                        }
                        i11 = i12 == 0 ? 1 : i12;
                        if (z) {
                            Subblock subblock;
                            Segment horizontal;
                            Subblock subblock2;
                            Subblock subblock3;
                            int i14 = i10 >= 40 ? i5 : i10 >= 15 ? 1 : i3;
                            i5 = ((i10 + 2) * 2) + i11;
                            i10 = (i10 * 2) + i11;
                            if (i7 > 0) {
                                Macroblock macroblock3 = macroblockArr2[i8][(i7 - 1) + 1];
                                i8 = i3;
                                while (i8 < i13) {
                                    subblock = macroblock.ySubblocks[i8][i3];
                                    Subblock subblock4 = macroblock3.ySubblocks[i8][3];
                                    i2 = 0;
                                    while (i2 < i13) {
                                        horizontal = Segment.horizontal(subblock, subblock4, i2);
                                        horizontal.filterMb(i14, i11, i5);
                                        horizontal.applyHorizontally(subblock, subblock4, i2);
                                        i2++;
                                        i13 = 4;
                                    }
                                    i8++;
                                    i2 = i;
                                    i3 = 0;
                                    i13 = 4;
                                }
                            }
                            if (!macroblock.skipFilter) {
                                i2 = 1;
                                while (true) {
                                    i3 = 4;
                                    if (i2 >= 4) {
                                        break;
                                    }
                                    i7 = 0;
                                    while (i7 < i3) {
                                        subblock2 = macroblock.ySubblocks[i7][i2 - 1];
                                        subblock3 = macroblock.ySubblocks[i7][i2];
                                        int i15 = 0;
                                        while (i15 < i3) {
                                            Segment horizontal2 = Segment.horizontal(subblock3, subblock2, i15);
                                            horizontal2.filterSb(i14, i11, i10);
                                            horizontal2.applyHorizontally(subblock3, subblock2, i15);
                                            i15++;
                                            i3 = 4;
                                        }
                                        i7++;
                                        i3 = 4;
                                    }
                                    i2++;
                                }
                            }
                            if (i4 > 0) {
                                Macroblock macroblock4 = macroblockArr2[(i4 - 1) + 1][i9];
                                i7 = 0;
                                while (true) {
                                    i8 = 4;
                                    if (i7 >= 4) {
                                        break;
                                    }
                                    subblock3 = macroblock4.ySubblocks[3][i7];
                                    subblock = macroblock2.ySubblocks[0][i7];
                                    i3 = 0;
                                    while (i3 < i8) {
                                        Segment vertical = Segment.vertical(subblock, subblock3, i3);
                                        vertical.filterMb(i14, i11, i5);
                                        vertical.applyVertically(subblock, subblock3, i3);
                                        i3++;
                                        i8 = 4;
                                    }
                                    i7++;
                                }
                            }
                            i6 = 0;
                            if (!macroblock.skipFilter) {
                                for (i2 = 1; i2 < 4; i2++) {
                                    for (i5 = 0; i5 < 4; i5++) {
                                        Subblock subblock5 = macroblock2.ySubblocks[i2 - 1][i5];
                                        subblock2 = macroblock2.ySubblocks[i2][i5];
                                        for (int i16 = 0; i16 < 4; i16++) {
                                            horizontal = Segment.vertical(subblock2, subblock5, i16);
                                            horizontal.filterSb(i14, i11, i10);
                                            horizontal.applyVertically(subblock2, subblock5, i16);
                                        }
                                    }
                                }
                            }
                        } else {
                            throw new UnsupportedOperationException("TODO: non-key frames are not supported yet");
                        }
                    }
                    i6 = i3;
                    i7 = i9;
                    i3 = i6;
                    i2 = i;
                    i5 = 2;
                }
                i6 = i3;
                i4++;
                i2 = i;
            } else {
                return;
            }
        }
    }
}
