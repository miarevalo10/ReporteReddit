package org.jcodec.codecs.h264.decode;

import com.google.android.gms.ads.AdRequest;
import org.jcodec.common.model.Picture;

public class BlockInterpolator {
    private static LumaInterpolator[] safe = new LumaInterpolator[]{new C26361(), new C26372(), new C26383(), new C26394(), new C26405(), new C26416(), new C26427(), new C26438(), new C26449(), new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma12(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma22(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma32(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma03(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma13(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma23(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma33(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }};
    private static int[] tmp1 = new int[1024];
    private static LumaInterpolator[] unsafe = new LumaInterpolator[]{new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma00Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma10Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma20Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma30Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma01Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma11Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma21Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma31Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma02Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma12Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma22Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma32Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma03Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma13Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma23Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }, new LumaInterpolator() {
        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma33Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }};

    private interface LumaInterpolator {
        void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8);
    }

    static class C26361 implements LumaInterpolator {
        C26361() {
        }

        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma00(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }

    static class C26372 implements LumaInterpolator {
        C26372() {
        }

        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma10(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }

    static class C26383 implements LumaInterpolator {
        C26383() {
        }

        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma20(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }

    static class C26394 implements LumaInterpolator {
        C26394() {
        }

        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma30(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }

    static class C26405 implements LumaInterpolator {
        C26405() {
        }

        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma01(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }

    static class C26416 implements LumaInterpolator {
        C26416() {
        }

        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma11(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }

    static class C26427 implements LumaInterpolator {
        C26427() {
        }

        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma21(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }

    static class C26438 implements LumaInterpolator {
        C26438() {
        }

        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma31(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }

    static class C26449 implements LumaInterpolator {
        C26449() {
        }

        public final void mo6209a(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
            BlockInterpolator.getLuma02(iArr, i, iArr2, i3, i4, i5, i6, i7, i8);
        }
    }

    private static int iClip3(int i, int i2, int i3) {
        return i3 < i ? i : i3 > i2 ? i2 : i3;
    }

    public static void getBlockLuma(Picture picture, Picture picture2, int i, int i2, int i3, int i4, int i5) {
        Picture picture3 = picture2;
        int i6 = i2 & 3;
        int i7 = i3 & 3;
        int i8 = i2 >> 2;
        int i9 = i3 >> 2;
        if (i8 >= 2 && i9 >= 2 && i8 <= (picture.getWidth() - i4) - 5) {
            if (i9 <= (picture.getHeight() - i5) - 5) {
                safe[(i7 << 2) + i6].mo6209a(picture.getData()[0], picture.getWidth(), picture.getHeight(), picture3.getPlaneData(0), i, picture3.getPlaneWidth(0), i8, i9, i4, i5);
                return;
            }
        }
        unsafe[(i7 << 2) + i6].mo6209a(picture.getData()[0], picture.getWidth(), picture.getHeight(), picture3.getPlaneData(0), i, picture3.getPlaneWidth(0), i8, i9, i4, i5);
    }

    public static void getBlockChroma(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i5 & 7;
        int i10 = i6 & 7;
        int i11 = i5 >> 3;
        int i12 = i6 >> 3;
        if (i11 >= 0 && i11 <= (i - i7) - 1 && i12 >= 0) {
            if (i12 <= (i2 - i8) - 1) {
                if (i9 == 0 && i10 == 0) {
                    getChroma00(iArr, i, i2, iArr2, i3, i4, i11, i12, i7, i8);
                    return;
                } else if (i10 == 0) {
                    getChromaX0(iArr, i, i2, iArr2, i3, i4, i11, i12, i9, i7, i8);
                    return;
                } else if (i9 == 0) {
                    getChroma0X(iArr, i, i2, iArr2, i3, i4, i11, i12, i10, i7, i8);
                    return;
                } else {
                    getChromaXX(iArr, i, i2, iArr2, i3, i4, i11, i12, i9, i10, i7, i8);
                    return;
                }
            }
        }
        if (i9 == 0 && i10 == 0) {
            getChroma00Unsafe(iArr, i, i2, iArr2, i3, i4, i11, i12, i7, i8);
        } else if (i10 == 0) {
            getChromaX0Unsafe(iArr, i, i2, iArr2, i3, i4, i11, i12, i9, i7, i8);
        } else if (i9 == 0) {
            getChroma0XUnsafe(iArr, i, i2, iArr2, i3, i4, i11, i12, i10, i7, i8);
        } else {
            getChromaXXUnsafe(iArr, i, i2, iArr2, i3, i4, i11, i12, i9, i10, i7, i8);
        }
    }

    private static void getLuma00(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        i5 = (i5 * i) + i4;
        for (i4 = 0; i4 < i7; i4++) {
            System.arraycopy(iArr, i5, iArr2, i2, i6);
            i5 += i;
            i2 += i3;
        }
    }

    private static void getLuma00Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        int i11 = i3;
        int i12 = i8;
        for (int i13 = 0; i13 < i12; i13++) {
            int iClip3 = iClip3(0, i9, i13 + i6) * i;
            int i14 = i7;
            for (int i15 = 0; i15 < i14; i15++) {
                iArr2[i11 + i15] = iArr[iClip3(0, i10, i5 + i15) + iClip3];
            }
            i11 += i4;
        }
    }

    private static void getLuma20NoRound(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        i5 = (i5 * i) + i4;
        int i8 = i2;
        for (i2 = 0; i2 < i7; i2++) {
            int i9 = -2;
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = i5 + i9;
                i9++;
                iArr2[i8 + i10] = ((iArr[i11] + iArr[i11 + 5]) - (5 * (iArr[i11 + 1] + iArr[i11 + 4]))) + (20 * (iArr[i11 + 2] + iArr[i11 + 3]));
            }
            i5 += i;
            i8 += i3;
        }
    }

    private static void getLuma20(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20NoRound(iArr, i, iArr2, i2, i3, i4, i5, i6, i7);
        for (i = 0; i < i7; i++) {
            for (i4 = 0; i4 < i6; i4++) {
                i5 = i2 + i4;
                iArr2[i5] = iClip3(0, 255, (iArr2[i5] + 16) >> 5);
            }
            i2 += i3;
        }
    }

    private static void getLuma20UnsafeNoRound(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i - 1;
        int i10 = i2 - 1;
        int i11 = i7;
        for (int i12 = 0; i12 < i11; i12++) {
            int i13;
            int i14 = i5 + i12;
            int iClip3 = iClip3(0, i9, i14 - 2);
            int iClip32 = iClip3(0, i9, i14 - 1);
            int iClip33 = iClip3(0, i9, i14);
            int iClip34 = iClip3(0, i9, i14 + 1);
            int iClip35 = iClip3(0, i9, i14 + 2);
            i14 = iClip3(0, i9, i14 + 3);
            int i15 = i3;
            int i16 = i8;
            int i17 = 0;
            while (i17 < i16) {
                i13 = i9;
                i9 = iClip3(0, i10, i17 + i6) * i;
                iArr2[i15 + i12] = ((iArr[i9 + iClip3] + iArr[i9 + i14]) - ((iArr[i9 + iClip32] + iArr[i9 + iClip35]) * 5)) + ((iArr[i9 + iClip33] + iArr[i9 + iClip34]) * 20);
                i15 += i4;
                i17++;
                i9 = i13;
            }
            i13 = i9;
        }
    }

    private static void getLuma20Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20UnsafeNoRound(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        for (i = 0; i < i7; i++) {
            i5 = i3;
            for (i2 = 0; i2 < i8; i2++) {
                i6 = i5 + i;
                iArr2[i6] = iClip3(0, 255, (iArr2[i6] + 16) >> 5);
                i5 += i4;
            }
        }
    }

    private static void getLuma02NoRound(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i2;
        int i9 = ((i5 - 2) * i) + i4;
        int i10 = i7;
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = i6;
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = i9 + i13;
                iArr2[i8 + i13] = ((iArr[i14] + iArr[(5 * i) + i14]) - (5 * (iArr[i14 + i] + iArr[(4 * i) + i14]))) + (20 * (iArr[(2 * i) + i14] + iArr[i14 + (3 * i)]));
            }
            i9 += i;
            i8 += i3;
        }
    }

    private static void getLuma02(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma02NoRound(iArr, i, iArr2, i2, i3, i4, i5, i6, i7);
        for (i = 0; i < i7; i++) {
            for (i4 = 0; i4 < i6; i4++) {
                i5 = i2 + i4;
                iArr2[i5] = iClip3(0, 255, (iArr2[i5] + 16) >> 5);
            }
            i2 += i3;
        }
    }

    private static void getLuma02UnsafeNoRound(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        int i11 = 0;
        int i12 = i3;
        int i13 = i8;
        int i14 = 0;
        while (i14 < i13) {
            int i15 = i6 + i14;
            int iClip3 = iClip3(i11, i9, i15 - 2) * i;
            int iClip32 = iClip3(i11, i9, i15 - 1) * i;
            int iClip33 = iClip3(i11, i9, i15) * i;
            int iClip34 = iClip3(i11, i9, i15 + 1) * i;
            int iClip35 = iClip3(i11, i9, i15 + 2) * i;
            i15 = iClip3(i11, i9, i15 + 3) * i;
            int i16 = i7;
            while (i11 < i16) {
                int i17 = i9;
                int iClip36 = iClip3(0, i10, i5 + i11);
                iArr2[i12 + i11] = ((iArr[iClip36 + iClip3] + iArr[iClip36 + i15]) - ((iArr[iClip36 + iClip32] + iArr[iClip36 + iClip35]) * 5)) + ((iArr[iClip36 + iClip33] + iArr[iClip36 + iClip34]) * 20);
                i11++;
                i9 = i17;
            }
            i12 += i4;
            i14++;
            i11 = 0;
            i9 = i9;
        }
    }

    private static void getLuma02Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma02UnsafeNoRound(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        for (i = 0; i < i8; i++) {
            for (i2 = 0; i2 < i7; i2++) {
                i5 = i3 + i2;
                iArr2[i5] = iClip3(0, 255, (iArr2[i5] + 16) >> 5);
            }
            i3 += i4;
        }
    }

    private static void getLuma10(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(iArr, i, iArr2, i2, i3, i4, i5, i6, i7);
        int i8 = (i5 * i) + i4;
        i5 = i2;
        for (i2 = 0; i2 < i7; i2++) {
            for (int i9 = 0; i9 < i6; i9++) {
                int i10 = i5 + i9;
                iArr2[i10] = ((iArr2[i10] + iArr[i8 + i9]) + 1) >> 1;
            }
            i8 += i;
            i5 += i3;
        }
    }

    private static void getLuma10Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        getLuma20Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        int i11 = i3;
        int i12 = i8;
        for (int i13 = 0; i13 < i12; i13++) {
            int iClip3 = iClip3(0, i9, i13 + i6) * i;
            int i14 = i7;
            for (int i15 = 0; i15 < i14; i15++) {
                int i16 = i11 + i15;
                iArr2[i16] = ((iArr2[i16] + iArr[iClip3(0, i10, i5 + i15) + iClip3]) + 1) >> 1;
            }
            i11 += i4;
        }
    }

    private static void getLuma30(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(iArr, i, iArr2, i2, i3, i4, i5, i6, i7);
        int i8 = (i5 * i) + i4;
        i5 = i2;
        for (i2 = 0; i2 < i7; i2++) {
            for (int i9 = 0; i9 < i6; i9++) {
                int i10 = i5 + i9;
                iArr2[i10] = ((iArr[(i8 + i9) + 1] + iArr2[i10]) + 1) >> 1;
            }
            i8 += i;
            i5 += i3;
        }
    }

    private static void getLuma30Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        getLuma20Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        int i11 = i3;
        int i12 = i8;
        for (int i13 = 0; i13 < i12; i13++) {
            int iClip3 = iClip3(0, i9, i13 + i6) * i;
            int i14 = i7;
            for (int i15 = 0; i15 < i14; i15++) {
                int i16 = i11 + i15;
                iArr2[i16] = ((iArr2[i16] + iArr[iClip3(0, i10, (i5 + i15) + 1) + iClip3]) + 1) >> 1;
            }
            i11 += i4;
        }
    }

    private static void getLuma01(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma02(iArr, i, iArr2, i2, i3, i4, i5, i6, i7);
        int i8 = (i5 * i) + i4;
        i5 = i2;
        for (i2 = 0; i2 < i7; i2++) {
            for (int i9 = 0; i9 < i6; i9++) {
                int i10 = i5 + i9;
                iArr2[i10] = ((iArr2[i10] + iArr[i8 + i9]) + 1) >> 1;
            }
            i8 += i;
            i5 += i3;
        }
    }

    private static void getLuma01Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        getLuma02Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        int i11 = i3;
        int i12 = i8;
        for (int i13 = 0; i13 < i12; i13++) {
            int iClip3 = iClip3(0, i9, i6 + i13) * i;
            int i14 = i7;
            for (int i15 = 0; i15 < i14; i15++) {
                int i16 = i11 + i15;
                iArr2[i16] = ((iArr2[i16] + iArr[iClip3(0, i10, i5 + i15) + iClip3]) + 1) >> 1;
            }
            i11 += i4;
        }
    }

    private static void getLuma03(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma02(iArr, i, iArr2, i2, i3, i4, i5, i6, i7);
        int i8 = (i5 * i) + i4;
        i5 = i2;
        for (i2 = 0; i2 < i7; i2++) {
            for (int i9 = 0; i9 < i6; i9++) {
                int i10 = i5 + i9;
                iArr2[i10] = ((iArr2[i10] + iArr[(i8 + i9) + i]) + 1) >> 1;
            }
            i8 += i;
            i5 += i3;
        }
    }

    private static void getLuma03Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        getLuma02Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        int i11 = i3;
        int i12 = i8;
        for (int i13 = 0; i13 < i12; i13++) {
            int iClip3 = iClip3(0, i9, (i6 + i13) + 1) * i;
            int i14 = i7;
            for (int i15 = 0; i15 < i14; i15++) {
                int i16 = i11 + i15;
                iArr2[i16] = ((iArr2[i16] + iArr[iClip3(0, i10, i5 + i15) + iClip3]) + 1) >> 1;
            }
            i11 += i4;
        }
    }

    private static void getLuma21(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i6;
        int i9 = i7;
        int i10 = i8;
        getLuma20NoRound(iArr, i, tmp1, 0, i8, i4, i5 - 2, i10, i9 + 7);
        int i11 = i2;
        getLuma02NoRound(tmp1, i8, iArr2, i11, i3, 0, 2, i10, i9);
        int i12 = i8 << 1;
        for (int i13 = 0; i13 < i9; i13++) {
            for (int i14 = 0; i14 < i8; i14++) {
                int i15 = i11 + i14;
                iArr2[i15] = ((iClip3(0, 255, (iArr2[i15] + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10) + iClip3(0, 255, (tmp1[i12 + i14] + 16) >> 5)) + 1) >> 1;
            }
            i11 += i3;
            i12 += i8;
        }
    }

    private static void getLuma21Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i7;
        int i10 = i8;
        getLuma20UnsafeNoRound(iArr, i, i2, tmp1, 0, i9, i5, i6 - 2, i9, i10 + 7);
        int i11 = i3;
        int i12 = i10;
        int i13 = i9;
        getLuma02NoRound(tmp1, i9, iArr2, i11, i4, 0, 2, i9, i12);
        int i14 = i13 << 1;
        for (int i15 = 0; i15 < i12; i15++) {
            for (int i16 = 0; i16 < i13; i16++) {
                int i17 = i11 + i16;
                iArr2[i17] = ((iClip3(0, 255, (iArr2[i17] + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10) + iClip3(0, 255, (tmp1[i14 + i16] + 16) >> 5)) + 1) >> 1;
            }
            i11 += i4;
            i14 += i13;
        }
    }

    private static void getLuma22(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i7;
        int i9 = i6;
        getLuma20NoRound(iArr, i, tmp1, 0, i6, i4, i5 - 2, i9, i8 + 7);
        getLuma02NoRound(tmp1, i6, iArr2, i2, i3, 0, 2, i9, i8);
        int i10 = i2;
        for (int i11 = 0; i11 < i8; i11++) {
            int i12 = i6;
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = i10 + i13;
                iArr2[i14] = iClip3(0, 255, (iArr2[i14] + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10);
            }
            i10 += i3;
        }
    }

    private static void getLuma22Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i8;
        getLuma20UnsafeNoRound(iArr, i, i2, tmp1, 0, i7, i5, i6 - 2, i7, i9 + 7);
        getLuma02NoRound(tmp1, i7, iArr2, i3, i4, 0, 2, i7, i9);
        int i10 = i3;
        for (int i11 = 0; i11 < i9; i11++) {
            int i12 = i7;
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = i10 + i13;
                iArr2[i14] = iClip3(0, 255, (iArr2[i14] + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10);
            }
            i10 += i4;
        }
    }

    private static void getLuma23(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i6;
        int i9 = i7;
        int i10 = i8;
        getLuma20NoRound(iArr, i, tmp1, 0, i8, i4, i5 - 2, i10, i9 + 7);
        int i11 = i2;
        getLuma02NoRound(tmp1, i8, iArr2, i11, i3, 0, 2, i10, i9);
        int i12 = i8 << 1;
        for (int i13 = 0; i13 < i9; i13++) {
            for (int i14 = 0; i14 < i8; i14++) {
                int i15 = i11 + i14;
                iArr2[i15] = ((iClip3(0, 255, (iArr2[i15] + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10) + iClip3(0, 255, (tmp1[(i12 + i14) + i8] + 16) >> 5)) + 1) >> 1;
            }
            i11 += i3;
            i12 += i8;
        }
    }

    private static void getLuma23Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i7;
        int i10 = i8;
        getLuma20UnsafeNoRound(iArr, i, i2, tmp1, 0, i9, i5, i6 - 2, i9, i10 + 7);
        int i11 = i3;
        int i12 = i10;
        int i13 = i9;
        getLuma02NoRound(tmp1, i9, iArr2, i11, i4, 0, 2, i9, i12);
        int i14 = i13 << 1;
        for (int i15 = 0; i15 < i12; i15++) {
            for (int i16 = 0; i16 < i13; i16++) {
                int i17 = i11 + i16;
                iArr2[i17] = ((iClip3(0, 255, (iArr2[i17] + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10) + iClip3(0, 255, (tmp1[(i14 + i16) + i13] + 16) >> 5)) + 1) >> 1;
            }
            i11 += i4;
            i14 += i13;
        }
    }

    private static void getLuma12(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i6;
        int i9 = i8 + 7;
        int i10 = 2;
        int i11 = i7;
        getLuma02NoRound(iArr, i, tmp1, 0, i9, i4 - 2, i5, i9, i11);
        int i12 = i2;
        getLuma20NoRound(tmp1, i9, iArr2, i12, i3, 2, 0, i8, i11);
        int i13 = i7;
        for (int i14 = 0; i14 < i13; i14++) {
            for (int i15 = 0; i15 < i8; i15++) {
                int i16 = i12 + i15;
                iArr2[i16] = ((iClip3(0, 255, (iArr2[i16] + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10) + iClip3(0, 255, (tmp1[i10 + i15] + 16) >> 5)) + 1) >> 1;
            }
            i12 += i3;
            i10 += i9;
        }
    }

    private static void getLuma12Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i7;
        int i10 = i9 + 7;
        int i11 = 2;
        getLuma02UnsafeNoRound(iArr, i, i2, tmp1, 0, i10, i5 - 2, i6, i10, i8);
        int i12 = i3;
        getLuma20NoRound(tmp1, i10, iArr2, i12, i4, 2, 0, i9, i8);
        int i13 = i8;
        for (int i14 = 0; i14 < i13; i14++) {
            for (int i15 = 0; i15 < i9; i15++) {
                int i16 = i12 + i15;
                iArr2[i16] = ((iClip3(0, 255, (iArr2[i16] + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10) + iClip3(0, 255, (tmp1[i11 + i15] + 16) >> 5)) + 1) >> 1;
            }
            i12 += i4;
            i11 += i10;
        }
    }

    private static void getLuma32(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i6;
        int i9 = i8 + 7;
        int i10 = 2;
        int i11 = i7;
        getLuma02NoRound(iArr, i, tmp1, 0, i9, i4 - 2, i5, i9, i11);
        int i12 = i2;
        getLuma20NoRound(tmp1, i9, iArr2, i12, i3, 2, 0, i8, i11);
        int i13 = i7;
        for (int i14 = 0; i14 < i13; i14++) {
            for (int i15 = 0; i15 < i8; i15++) {
                int i16 = i12 + i15;
                iArr2[i16] = ((iClip3(0, 255, (iArr2[i16] + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10) + iClip3(0, 255, (tmp1[(i10 + i15) + 1] + 16) >> 5)) + 1) >> 1;
            }
            i12 += i3;
            i10 += i9;
        }
    }

    private static void getLuma32Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i7;
        int i10 = i9 + 7;
        int i11 = 2;
        getLuma02UnsafeNoRound(iArr, i, i2, tmp1, 0, i10, i5 - 2, i6, i10, i8);
        int i12 = i3;
        getLuma20NoRound(tmp1, i10, iArr2, i12, i4, 2, 0, i9, i8);
        int i13 = i8;
        for (int i14 = 0; i14 < i13; i14++) {
            for (int i15 = 0; i15 < i9; i15++) {
                int i16 = i12 + i15;
                iArr2[i16] = ((iClip3(0, 255, (iArr2[i16] + AdRequest.MAX_CONTENT_URL_LENGTH) >> 10) + iClip3(0, 255, (tmp1[(i11 + i15) + 1] + 16) >> 5)) + 1) >> 1;
            }
            i12 += i4;
            i11 += i10;
        }
    }

    private static void getLuma33(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(iArr, i, iArr2, i2, i3, i4, i5 + 1, i6, i7);
        getLuma02(iArr, i, tmp1, 0, i6, i4 + 1, i5, i6, i7);
        mergeCrap(iArr2, i2, i3, i6, i7);
    }

    private static void getLuma33Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6 + 1, i7, i8);
        getLuma02Unsafe(iArr, i, i2, tmp1, 0, i7, i5 + 1, i6, i7, i8);
        mergeCrap(iArr2, i3, i4, i7, i8);
    }

    private static void getLuma11(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(iArr, i, iArr2, i2, i3, i4, i5, i6, i7);
        getLuma02(iArr, i, tmp1, 0, i6, i4, i5, i6, i7);
        mergeCrap(iArr2, i2, i3, i6, i7);
    }

    private static void getLuma11Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        getLuma02Unsafe(iArr, i, i2, tmp1, 0, i7, i5, i6, i7, i8);
        mergeCrap(iArr2, i3, i4, i7, i8);
    }

    private static void getLuma13(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(iArr, i, iArr2, i2, i3, i4, i5 + 1, i6, i7);
        getLuma02(iArr, i, tmp1, 0, i6, i4, i5, i6, i7);
        mergeCrap(iArr2, i2, i3, i6, i7);
    }

    private static void getLuma13Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6 + 1, i7, i8);
        getLuma02Unsafe(iArr, i, i2, tmp1, 0, i7, i5, i6, i7, i8);
        mergeCrap(iArr2, i3, i4, i7, i8);
    }

    private static void getLuma31(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6, int i7) {
        getLuma20(iArr, i, iArr2, i2, i3, i4, i5, i6, i7);
        getLuma02(iArr, i, tmp1, 0, i6, i4 + 1, i5, i6, i7);
        mergeCrap(iArr2, i2, i3, i6, i7);
    }

    private static void getLuma31Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        getLuma20Unsafe(iArr, i, i2, iArr2, i3, i4, i5, i6, i7, i8);
        getLuma02Unsafe(iArr, i, i2, tmp1, 0, i7, i5 + 1, i6, i7, i8);
        mergeCrap(iArr2, i3, i4, i7, i8);
    }

    private static void mergeCrap(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = i;
        i = 0;
        int i6 = i;
        while (i < i4) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = i5 + i7;
                iArr[i8] = ((iArr[i8] + tmp1[i6 + i7]) + 1) >> 1;
            }
            i5 += i2;
            i6 += i3;
            i++;
        }
    }

    private static void getChroma00(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        i6 = (i6 * i) + i5;
        for (i2 = 0; i2 < i8; i2++) {
            System.arraycopy(iArr, i6, iArr2, i3, i7);
            i6 += i;
            i3 += i4;
        }
    }

    private static void getChroma00Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i2 - 1;
        int i10 = i - 1;
        int i11 = i3;
        int i12 = i8;
        for (int i13 = 0; i13 < i12; i13++) {
            int iClip3 = iClip3(0, i9, i13 + i6) * i;
            int i14 = i7;
            for (int i15 = 0; i15 < i14; i15++) {
                iArr2[i11 + i15] = iArr[iClip3(0, i10, i5 + i15) + iClip3];
            }
            i11 += i4;
        }
    }

    private static void getChroma0X(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i6;
        int i11 = (i10 * i) + i5;
        int i12 = 8 - i7;
        int i13 = i3;
        int i14 = (i10 < i2 + -1 ? i : 0) + i11;
        int i15 = i11;
        i10 = i9;
        for (i11 = 0; i11 < i10; i11++) {
            int i16 = i8;
            for (int i17 = 0; i17 < i16; i17++) {
                iArr2[i13 + i17] = (((iArr[i15 + i17] * i12) + (iArr[i14 + i17] * i7)) + 4) >> 3;
            }
            i15 += i;
            i14 += i;
            i13 += i4;
        }
    }

    private static void getChroma0XUnsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i - 1;
        int i11 = i2 - 1;
        int i12 = 8 - i7;
        int i13 = i3;
        int i14 = i9;
        for (int i15 = 0; i15 < i14; i15++) {
            int i16 = i6 + i15;
            int iClip3 = iClip3(0, i11, i16) * i;
            i16 = iClip3(0, i11, i16 + 1) * i;
            int i17 = i8;
            for (int i18 = 0; i18 < i17; i18++) {
                int i19 = i5 + i18;
                iArr2[i13 + i18] = (((iArr[iClip3(0, i10, i19) + iClip3] * i12) + (iArr[iClip3(0, i10, i19) + i16] * i7)) + 4) >> 3;
            }
            i13 += i4;
        }
    }

    private static void getChromaX0(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i5;
        int i11 = (i6 * i) + i10;
        int i12 = 8 - i7;
        int i13 = i3;
        int i14 = (i10 < i + -1 ? 1 : 0) + i11;
        int i15 = i11;
        i10 = i9;
        for (i11 = 0; i11 < i10; i11++) {
            int i16 = i8;
            for (int i17 = 0; i17 < i16; i17++) {
                iArr2[i13 + i17] = (((iArr[i15 + i17] * i12) + (iArr[i14 + i17] * i7)) + 4) >> 3;
            }
            i15 += i;
            i14 += i;
            i13 += i4;
        }
    }

    private static void getChromaX0Unsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = 8 - i7;
        int i11 = i - 1;
        int i12 = i2 - 1;
        int i13 = i3;
        int i14 = i9;
        int i15 = 0;
        while (i15 < i14) {
            int i16 = i8;
            int i17 = 0;
            while (i17 < i16) {
                int i18 = i6 + i15;
                i14 = i5 + i17;
                iArr2[i13 + i17] = (((iArr[(iClip3(0, i12, i18) * i) + iClip3(0, i11, i14)] * i10) + (iArr[(iClip3(0, i12, i18) * i) + iClip3(0, i11, i14 + 1)] * i7)) + 4) >> 3;
                i17++;
                i14 = i9;
            }
            i13 += i4;
            i15++;
            i14 = i9;
        }
    }

    private static void getChromaXX(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i5;
        int i12 = i6;
        int i13 = (i12 * i) + i11;
        int i14 = 1;
        i12 = (i12 < i2 + -1 ? i : 0) + i13;
        if (i11 >= i - 1) {
            i14 = 0;
        }
        i14 += i13;
        int i15 = 8 - i7;
        int i16 = 8 - i8;
        int i17 = (i14 + i12) - i13;
        int i18 = i13;
        int i19 = i14;
        i14 = i3;
        i11 = i10;
        i13 = i12;
        for (i12 = 0; i12 < i11; i12++) {
            int i20 = i9;
            for (int i21 = 0; i21 < i20; i21++) {
                iArr2[i14 + i21] = ((((((i15 * i16) * iArr[i18 + i21]) + ((i7 * i16) * iArr[i19 + i21])) + ((i15 * i8) * iArr[i13 + i21])) + ((i7 * i8) * iArr[i17 + i21])) + 32) >> 6;
            }
            i14 += i4;
            i18 += i;
            i13 += i;
            i19 += i;
            i17 += i;
        }
    }

    private static void getChromaXXUnsafe(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11 = i2 - 1;
        int i12 = i - 1;
        int i13 = 8 - i7;
        int i14 = 8 - i8;
        int i15 = i3;
        int i16 = i10;
        int i17 = 0;
        while (i17 < i16) {
            int i18 = i9;
            int i19 = 0;
            while (i19 < i18) {
                int i20 = i6 + i17;
                i16 = i5 + i19;
                int iClip3 = (iClip3(0, i11, i20) * i) + iClip3(0, i12, i16);
                i18 = i20 + 1;
                int iClip32 = (iClip3(0, i11, i18) * i) + iClip3(0, i12, i16);
                i16++;
                iArr2[i15 + i19] = ((((((i13 * i14) * iArr[iClip3]) + ((i7 * i14) * iArr[(iClip3(0, i11, i20) * i) + iClip3(0, i12, i16)])) + ((i13 * i8) * iArr[iClip32])) + ((i7 * i8) * iArr[(iClip3(0, i11, i18) * i) + iClip3(0, i12, i16)])) + 32) >> 6;
                i19++;
                i16 = i10;
                i18 = i9;
            }
            i15 += i4;
            i17++;
            i16 = i10;
        }
    }
}
