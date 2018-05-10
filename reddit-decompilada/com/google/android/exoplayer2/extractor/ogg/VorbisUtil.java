package com.google.android.exoplayer2.extractor.ogg;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;

final class VorbisUtil {

    public static final class CodeBook {
        public final int f4535a;
        public final int f4536b;
        public final long[] f4537c;
        public final int f4538d;
        public final boolean f4539e;

        public CodeBook(int i, int i2, long[] jArr, int i3, boolean z) {
            this.f4535a = i;
            this.f4536b = i2;
            this.f4537c = jArr;
            this.f4538d = i3;
            this.f4539e = z;
        }
    }

    public static final class CommentHeader {
        public final String f4540a;
        public final String[] f4541b;
        public final int f4542c;

        public CommentHeader(String str, String[] strArr, int i) {
            this.f4540a = str;
            this.f4541b = strArr;
            this.f4542c = i;
        }
    }

    public static final class Mode {
        public final boolean f4543a;
        public final int f4544b;
        public final int f4545c;
        public final int f4546d;

        public Mode(boolean z, int i, int i2, int i3) {
            this.f4543a = z;
            this.f4544b = i;
            this.f4545c = i2;
            this.f4546d = i3;
        }
    }

    public static final class VorbisIdHeader {
        public final long f4547a;
        public final int f4548b;
        public final long f4549c;
        public final int f4550d;
        public final int f4551e;
        public final int f4552f;
        public final int f4553g;
        public final int f4554h;
        public final boolean f4555i;
        public final byte[] f4556j;

        public VorbisIdHeader(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
            this.f4547a = j;
            this.f4548b = i;
            this.f4549c = j2;
            this.f4550d = i2;
            this.f4551e = i3;
            this.f4552f = i4;
            this.f4553g = i5;
            this.f4554h = i6;
            this.f4555i = z;
            this.f4556j = bArr;
        }
    }

    public static int m3844a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static VorbisIdHeader m3845a(ParsableByteArray parsableByteArray) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        m3847a(1, parsableByteArray2, false);
        long i = parsableByteArray.m4258i();
        int d = parsableByteArray.m4250d();
        long i2 = parsableByteArray.m4258i();
        int k = parsableByteArray.m4260k();
        int k2 = parsableByteArray.m4260k();
        int k3 = parsableByteArray.m4260k();
        int d2 = parsableByteArray.m4250d();
        return new VorbisIdHeader(i, d, i2, k, k2, k3, (int) Math.pow(2.0d, (double) (d2 & 15)), (int) Math.pow(2.0d, (double) ((d2 & 240) >> 4)), (parsableByteArray.m4250d() & 1) > 0, Arrays.copyOf(parsableByteArray2.f5256a, parsableByteArray2.f5258c));
    }

    public static CommentHeader m3850b(ParsableByteArray parsableByteArray) throws ParserException {
        int i = 0;
        m3847a(3, parsableByteArray, false);
        String e = parsableByteArray.m4253e((int) parsableByteArray.m4258i());
        int length = 11 + e.length();
        long i2 = parsableByteArray.m4258i();
        String[] strArr = new String[((int) i2)];
        length += 4;
        while (((long) i) < i2) {
            length += 4;
            strArr[i] = parsableByteArray.m4253e((int) parsableByteArray.m4258i());
            length += strArr[i].length();
            i++;
        }
        if ((parsableByteArray.m4250d() & 1) != null) {
            return new CommentHeader(e, strArr, length + 1);
        }
        throw new ParserException("framing bit expected to be set");
    }

    public static boolean m3847a(int i, ParsableByteArray parsableByteArray, boolean z) throws ParserException {
        if (parsableByteArray.m4246b() < 7) {
            if (z) {
                return false;
            }
            z = new StringBuilder("too short header: ");
            z.append(parsableByteArray.m4246b());
            throw new ParserException(z.toString());
        } else if (parsableByteArray.m4250d() == i) {
            if (parsableByteArray.m4250d() == 118 && parsableByteArray.m4250d() == 111 && parsableByteArray.m4250d() == 114 && parsableByteArray.m4250d() == 98 && parsableByteArray.m4250d() == 105) {
                if (parsableByteArray.m4250d() == 115) {
                    return true;
                }
            }
            if (z) {
                return false;
            }
            throw new ParserException("expected characters 'vorbis'");
        } else if (z) {
            return false;
        } else {
            z = new StringBuilder("expected header type ");
            z.append(Integer.toHexString(i));
            throw new ParserException(z.toString());
        }
    }

    public static Mode[] m3849a(ParsableByteArray parsableByteArray, int i) throws ParserException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i2 = 5;
        boolean z = false;
        m3847a(5, parsableByteArray2, false);
        int d = parsableByteArray.m4250d() + 1;
        VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray2.f5256a);
        vorbisBitArray.m3843b(parsableByteArray2.f5257b * 8);
        int i3 = 0;
        while (i3 < d) {
            if (vorbisBitArray.m3841a(24) != 5653314) {
                StringBuilder stringBuilder = new StringBuilder("expected code book to start with [0x56, 0x43, 0x42] at ");
                stringBuilder.append((vorbisBitArray.f4526a * 8) + vorbisBitArray.f4527b);
                throw new ParserException(stringBuilder.toString());
            }
            int i4;
            int a = vorbisBitArray.m3841a(16);
            int a2 = vorbisBitArray.m3841a(24);
            long[] jArr = new long[a2];
            boolean a3 = vorbisBitArray.m3842a();
            long j = 0;
            int a4;
            if (a3) {
                a4 = vorbisBitArray.m3841a(i2) + 1;
                int i5 = z;
                while (i5 < jArr.length) {
                    int a5 = vorbisBitArray.m3841a(m3844a(a2 - i5));
                    int i6 = i5;
                    i5 = z;
                    while (i5 < a5 && i6 < jArr.length) {
                        i4 = d;
                        jArr[i6] = (long) a4;
                        i6++;
                        i5++;
                        d = i4;
                    }
                    a4++;
                    i5 = i6;
                    d = d;
                    z = false;
                }
            } else {
                boolean a6 = vorbisBitArray.m3842a();
                for (a4 = z; a4 < jArr.length; a4++) {
                    if (!a6 || vorbisBitArray.m3842a()) {
                        jArr[a4] = (long) (vorbisBitArray.m3841a(i2) + 1);
                    } else {
                        jArr[a4] = 0;
                    }
                }
            }
            i4 = d;
            int a7 = vorbisBitArray.m3841a(4);
            if (a7 > 2) {
                stringBuilder = new StringBuilder("lookup type greater than 2 not decodable: ");
                stringBuilder.append(a7);
                throw new ParserException(stringBuilder.toString());
            }
            if (a7 == 1 || a7 == 2) {
                vorbisBitArray.m3843b(32);
                vorbisBitArray.m3843b(32);
                i2 = vorbisBitArray.m3841a(4) + 1;
                vorbisBitArray.m3843b(1);
                if (a7 != 1) {
                    j = (long) (a2 * a);
                } else if (a != 0) {
                    j = (long) Math.floor(Math.pow((double) ((long) a2), 1.0d / ((double) ((long) a))));
                }
                vorbisBitArray.m3843b((int) (j * ((long) i2)));
            }
            CodeBook codeBook = new CodeBook(a, a2, jArr, a7, a3);
            i3++;
            d = i4;
            i2 = 5;
            z = false;
        }
        i3 = vorbisBitArray.m3841a(6) + 1;
        for (i2 = 0; i2 < i3; i2++) {
            if (vorbisBitArray.m3841a(16) != 0) {
                throw new ParserException("placeholder of time domain transforms not zeroed out");
            }
        }
        m3852c(vorbisBitArray);
        m3851b(vorbisBitArray);
        m3846a(i, vorbisBitArray);
        Mode[] a8 = m3848a(vorbisBitArray);
        if (vorbisBitArray.m3842a()) {
            return a8;
        }
        throw new ParserException("framing bit after modes not set as expected");
    }

    private static Mode[] m3848a(VorbisBitArray vorbisBitArray) {
        int a = vorbisBitArray.m3841a(6) + 1;
        Mode[] modeArr = new Mode[a];
        for (int i = 0; i < a; i++) {
            modeArr[i] = new Mode(vorbisBitArray.m3842a(), vorbisBitArray.m3841a(16), vorbisBitArray.m3841a(16), vorbisBitArray.m3841a(8));
        }
        return modeArr;
    }

    private static void m3846a(int i, VorbisBitArray vorbisBitArray) throws ParserException {
        int a = vorbisBitArray.m3841a(6) + 1;
        for (int i2 = 0; i2 < a; i2++) {
            int a2 = vorbisBitArray.m3841a(16);
            if (a2 != 0) {
                StringBuilder stringBuilder = new StringBuilder("mapping type other than 0 not supported: ");
                stringBuilder.append(a2);
                Log.e("VorbisUtil", stringBuilder.toString());
            } else {
                int a3;
                a2 = vorbisBitArray.m3842a() ? vorbisBitArray.m3841a(4) + 1 : 1;
                if (vorbisBitArray.m3842a()) {
                    a3 = vorbisBitArray.m3841a(8) + 1;
                    for (int i3 = 0; i3 < a3; i3++) {
                        int i4 = i - 1;
                        vorbisBitArray.m3843b(m3844a(i4));
                        vorbisBitArray.m3843b(m3844a(i4));
                    }
                }
                if (vorbisBitArray.m3841a(2) != 0) {
                    throw new ParserException("to reserved bits must be zero after mapping coupling steps");
                }
                if (a2 > 1) {
                    for (a3 = 0; a3 < i; a3++) {
                        vorbisBitArray.m3843b(4);
                    }
                }
                for (int i5 = 0; i5 < a2; i5++) {
                    vorbisBitArray.m3843b(8);
                    vorbisBitArray.m3843b(8);
                    vorbisBitArray.m3843b(8);
                }
            }
        }
    }

    private static void m3851b(VorbisBitArray vorbisBitArray) throws ParserException {
        int a = vorbisBitArray.m3841a(6) + 1;
        for (int i = 0; i < a; i++) {
            if (vorbisBitArray.m3841a(16) > 2) {
                throw new ParserException("residueType greater than 2 is not decodable");
            }
            int i2;
            vorbisBitArray.m3843b(24);
            vorbisBitArray.m3843b(24);
            vorbisBitArray.m3843b(24);
            int a2 = vorbisBitArray.m3841a(6) + 1;
            vorbisBitArray.m3843b(8);
            int[] iArr = new int[a2];
            for (i2 = 0; i2 < a2; i2++) {
                iArr[i2] = ((vorbisBitArray.m3842a() ? vorbisBitArray.m3841a(5) : 0) * 8) + vorbisBitArray.m3841a(3);
            }
            for (i2 = 0; i2 < a2; i2++) {
                for (int i3 = 0; i3 < 8; i3++) {
                    if ((iArr[i2] & (1 << i3)) != 0) {
                        vorbisBitArray.m3843b(8);
                    }
                }
            }
        }
    }

    private static void m3852c(VorbisBitArray vorbisBitArray) throws ParserException {
        int a = vorbisBitArray.m3841a(6) + 1;
        for (int i = 0; i < a; i++) {
            int a2 = vorbisBitArray.m3841a(16);
            int a3;
            switch (a2) {
                case 0:
                    vorbisBitArray.m3843b(8);
                    vorbisBitArray.m3843b(16);
                    vorbisBitArray.m3843b(16);
                    vorbisBitArray.m3843b(6);
                    vorbisBitArray.m3843b(8);
                    a3 = vorbisBitArray.m3841a(4) + 1;
                    for (a2 = 0; a2 < a3; a2++) {
                        vorbisBitArray.m3843b(8);
                    }
                    break;
                case 1:
                    int a4;
                    a3 = vorbisBitArray.m3841a(5);
                    int[] iArr = new int[a3];
                    int i2 = -1;
                    for (a2 = 0; a2 < a3; a2++) {
                        iArr[a2] = vorbisBitArray.m3841a(4);
                        if (iArr[a2] > i2) {
                            i2 = iArr[a2];
                        }
                    }
                    int[] iArr2 = new int[(i2 + 1)];
                    for (i2 = 0; i2 < iArr2.length; i2++) {
                        iArr2[i2] = vorbisBitArray.m3841a(3) + 1;
                        a4 = vorbisBitArray.m3841a(2);
                        if (a4 > 0) {
                            vorbisBitArray.m3843b(8);
                        }
                        for (int i3 = 0; i3 < (1 << a4); i3++) {
                            vorbisBitArray.m3843b(8);
                        }
                    }
                    vorbisBitArray.m3843b(2);
                    int a5 = vorbisBitArray.m3841a(4);
                    int i4 = 0;
                    i2 = i4;
                    a4 = i2;
                    while (i4 < a3) {
                        i2 += iArr2[iArr[i4]];
                        while (a4 < i2) {
                            vorbisBitArray.m3843b(a5);
                            a4++;
                        }
                        i4++;
                    }
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("floor type greater than 1 not decodable: ");
                    stringBuilder.append(a2);
                    throw new ParserException(stringBuilder.toString());
            }
        }
    }
}
