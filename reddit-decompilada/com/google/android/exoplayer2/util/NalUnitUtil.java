package com.google.android.exoplayer2.util;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NalUnitUtil {
    public static final byte[] f5248a = new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 1};
    public static final float[] f5249b = new float[]{1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object f5250c = new Object();
    private static int[] f5251d = new int[10];

    public static final class PpsData {
        public final int f5235a;
        public final int f5236b;
        public final boolean f5237c;

        public PpsData(int i, int i2, boolean z) {
            this.f5235a = i;
            this.f5236b = i2;
            this.f5237c = z;
        }
    }

    public static final class SpsData {
        public final int f5238a;
        public final int f5239b;
        public final int f5240c;
        public final float f5241d;
        public final boolean f5242e;
        public final boolean f5243f;
        public final int f5244g;
        public final int f5245h;
        public final int f5246i;
        public final boolean f5247j;

        public SpsData(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.f5238a = i;
            this.f5239b = i2;
            this.f5240c = i3;
            this.f5241d = f;
            this.f5242e = z;
            this.f5243f = z2;
            this.f5244g = i4;
            this.f5245h = i5;
            this.f5246i = i6;
            this.f5247j = z3;
        }
    }

    public static int m4221a(byte[] bArr, int i) {
        synchronized (f5250c) {
            int i2;
            int i3 = 0;
            int i4 = i3;
            while (i3 < i) {
                while (i3 < i - 2) {
                    if (bArr[i3] == (byte) 0 && bArr[i3 + 1] == (byte) 0 && bArr[i3 + 2] == (byte) 3) {
                        break;
                    }
                    i3++;
                }
                i3 = i;
                if (i3 < i) {
                    if (f5251d.length <= i4) {
                        f5251d = Arrays.copyOf(f5251d, f5251d.length * 2);
                    }
                    i2 = i4 + 1;
                    f5251d[i4] = i3;
                    i3 += 3;
                    i4 = i2;
                }
            }
            i -= i4;
            i3 = 0;
            int i5 = i3;
            i2 = i5;
            while (i3 < i4) {
                int i6 = f5251d[i3] - i2;
                System.arraycopy(bArr, i2, bArr, i5, i6);
                i5 += i6;
                int i7 = i5 + 1;
                bArr[i5] = (byte) 0;
                i5 = i7 + 1;
                bArr[i7] = (byte) 0;
                i2 += i6 + 3;
                i3++;
            }
            System.arraycopy(bArr, i2, bArr, i5, i - i5);
        }
        return i;
    }

    public static void m4224a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = i;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                int i4 = byteBuffer.get(i) & 255;
                if (i2 == 3) {
                    if (i4 == 1 && (byteBuffer.get(i3) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i4 == 0) {
                    i2++;
                }
                if (i4 != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static boolean m4226a(String str, byte b) {
        if ((!"video/avc".equals(str) || (b & 31) != 6) && ("video/hevc".equals(str) == null || ((b & 126) >> 1) != (byte) 39)) {
            return null;
        }
        return true;
    }

    public static int m4227b(byte[] bArr, int i) {
        return bArr[i + 3] & 31;
    }

    public static int m4228c(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    public static SpsData m4223a(byte[] bArr, int i, int i2) {
        boolean z;
        int e;
        int e2;
        int i3;
        boolean z2;
        int e3;
        boolean b;
        long e4;
        int i4;
        int e5;
        boolean b2;
        int i5;
        int i6;
        int i7;
        float f;
        int c;
        int c2;
        float f2;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.m4271a(8);
        int c3 = parsableNalUnitBitArray.m4275c(8);
        parsableNalUnitBitArray.m4271a(16);
        int e6 = parsableNalUnitBitArray.m4278e();
        int i8 = 1;
        if (!(c3 == 100 || c3 == 110 || c3 == 122 || c3 == 244 || c3 == 44 || c3 == 83 || c3 == 86 || c3 == 118 || c3 == 128)) {
            if (c3 != 138) {
                z = false;
                c3 = 1;
                e = parsableNalUnitBitArray.m4278e() + 4;
                e2 = parsableNalUnitBitArray.m4278e();
                if (e2 == 0) {
                    i3 = e6;
                    z2 = false;
                    e3 = parsableNalUnitBitArray.m4278e() + 4;
                } else if (e2 != 1) {
                    b = parsableNalUnitBitArray.m4273b();
                    parsableNalUnitBitArray.m4277d();
                    parsableNalUnitBitArray.m4277d();
                    e4 = (long) parsableNalUnitBitArray.m4278e();
                    i3 = e6;
                    for (i4 = 0; ((long) i4) < e4; i4++) {
                        parsableNalUnitBitArray.m4278e();
                    }
                    e3 = 0;
                    z2 = b;
                } else {
                    i3 = e6;
                    e3 = 0;
                    z2 = e3;
                }
                parsableNalUnitBitArray.m4278e();
                parsableNalUnitBitArray.m4270a();
                e5 = parsableNalUnitBitArray.m4278e() + 1;
                e6 = parsableNalUnitBitArray.m4278e() + 1;
                b2 = parsableNalUnitBitArray.m4273b();
                i5 = (2 - b2) * e6;
                if (!b2) {
                    parsableNalUnitBitArray.m4270a();
                }
                parsableNalUnitBitArray.m4270a();
                e5 *= 16;
                i5 *= 16;
                if (parsableNalUnitBitArray.m4273b()) {
                    e6 = parsableNalUnitBitArray.m4278e();
                    int e7 = parsableNalUnitBitArray.m4278e();
                    int e8 = parsableNalUnitBitArray.m4278e();
                    int e9 = parsableNalUnitBitArray.m4278e();
                    if (c3 != 0) {
                        i6 = 2 - b2;
                        i7 = 1;
                    } else {
                        i7 = c3 != 3 ? 1 : 2;
                        if (c3 == 1) {
                            i8 = 2;
                        }
                        i6 = (2 - b2) * i8;
                    }
                    e5 -= (e6 + e7) * i7;
                    i5 -= (e8 + e9) * i6;
                }
                i6 = e5;
                i8 = i5;
                f = 1.0f;
                if (parsableNalUnitBitArray.m4273b() && parsableNalUnitBitArray.m4273b()) {
                    c = parsableNalUnitBitArray.m4275c(8);
                    if (c == 255) {
                        c = parsableNalUnitBitArray.m4275c(16);
                        c2 = parsableNalUnitBitArray.m4275c(16);
                        if (!(c == 0 || c2 == 0)) {
                            f = ((float) c) / ((float) c2);
                        }
                    } else if (c >= f5249b.length) {
                        f2 = f5249b[c];
                        return new SpsData(i3, i6, i8, f2, z, b2, e, e2, e3, z2);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder("Unexpected aspect_ratio_idc value: ");
                        stringBuilder.append(c);
                        Log.w("NalUnitUtil", stringBuilder.toString());
                    }
                }
                f2 = f;
                return new SpsData(i3, i6, i8, f2, z, b2, e, e2, e3, z2);
            }
        }
        c3 = parsableNalUnitBitArray.m4278e();
        if (c3 == 3) {
            b = parsableNalUnitBitArray.m4273b();
        } else {
            b = false;
        }
        parsableNalUnitBitArray.m4278e();
        parsableNalUnitBitArray.m4278e();
        parsableNalUnitBitArray.m4270a();
        if (parsableNalUnitBitArray.m4273b()) {
            int i9 = c3 != 3 ? 8 : 12;
            i4 = 0;
            while (i4 < i9) {
                if (parsableNalUnitBitArray.m4273b()) {
                    e = i4 < 6 ? 16 : 64;
                    e3 = 8;
                    int i10 = e3;
                    for (e2 = 0; e2 < e; e2++) {
                        if (e3 != 0) {
                            e3 = ((parsableNalUnitBitArray.m4277d() + i10) + 256) % 256;
                        }
                        if (e3 != 0) {
                            i10 = e3;
                        }
                    }
                }
                i4++;
            }
        }
        z = b;
        e = parsableNalUnitBitArray.m4278e() + 4;
        e2 = parsableNalUnitBitArray.m4278e();
        if (e2 == 0) {
            i3 = e6;
            z2 = false;
            e3 = parsableNalUnitBitArray.m4278e() + 4;
        } else if (e2 != 1) {
            i3 = e6;
            e3 = 0;
            z2 = e3;
        } else {
            b = parsableNalUnitBitArray.m4273b();
            parsableNalUnitBitArray.m4277d();
            parsableNalUnitBitArray.m4277d();
            e4 = (long) parsableNalUnitBitArray.m4278e();
            i3 = e6;
            for (i4 = 0; ((long) i4) < e4; i4++) {
                parsableNalUnitBitArray.m4278e();
            }
            e3 = 0;
            z2 = b;
        }
        parsableNalUnitBitArray.m4278e();
        parsableNalUnitBitArray.m4270a();
        e5 = parsableNalUnitBitArray.m4278e() + 1;
        e6 = parsableNalUnitBitArray.m4278e() + 1;
        b2 = parsableNalUnitBitArray.m4273b();
        i5 = (2 - b2) * e6;
        if (b2) {
            parsableNalUnitBitArray.m4270a();
        }
        parsableNalUnitBitArray.m4270a();
        e5 *= 16;
        i5 *= 16;
        if (parsableNalUnitBitArray.m4273b()) {
            e6 = parsableNalUnitBitArray.m4278e();
            int e72 = parsableNalUnitBitArray.m4278e();
            int e82 = parsableNalUnitBitArray.m4278e();
            int e92 = parsableNalUnitBitArray.m4278e();
            if (c3 != 0) {
                if (c3 != 3) {
                }
                if (c3 == 1) {
                    i8 = 2;
                }
                i6 = (2 - b2) * i8;
            } else {
                i6 = 2 - b2;
                i7 = 1;
            }
            e5 -= (e6 + e72) * i7;
            i5 -= (e82 + e92) * i6;
        }
        i6 = e5;
        i8 = i5;
        f = 1.0f;
        c = parsableNalUnitBitArray.m4275c(8);
        if (c == 255) {
            c = parsableNalUnitBitArray.m4275c(16);
            c2 = parsableNalUnitBitArray.m4275c(16);
            f = ((float) c) / ((float) c2);
        } else if (c >= f5249b.length) {
            StringBuilder stringBuilder2 = new StringBuilder("Unexpected aspect_ratio_idc value: ");
            stringBuilder2.append(c);
            Log.w("NalUnitUtil", stringBuilder2.toString());
        } else {
            f2 = f5249b[c];
            return new SpsData(i3, i6, i8, f2, z, b2, e, e2, e3, z2);
        }
        f2 = f;
        return new SpsData(i3, i6, i8, f2, z, b2, e, e2, e3, z2);
    }

    public static PpsData m4229d(byte[] bArr, int i) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, 3, i);
        parsableNalUnitBitArray.m4271a(8);
        bArr = parsableNalUnitBitArray.m4278e();
        i = parsableNalUnitBitArray.m4278e();
        parsableNalUnitBitArray.m4270a();
        return new PpsData(bArr, i, parsableNalUnitBitArray.m4273b());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m4222a(byte[] r7, int r8, int r9, boolean[] r10) {
        /*
        r0 = r9 - r8;
        r1 = 0;
        r2 = 1;
        if (r0 < 0) goto L_0x0008;
    L_0x0006:
        r3 = r2;
        goto L_0x0009;
    L_0x0008:
        r3 = r1;
    L_0x0009:
        com.google.android.exoplayer2.util.Assertions.m4186b(r3);
        if (r0 != 0) goto L_0x000f;
    L_0x000e:
        return r9;
    L_0x000f:
        r3 = 2;
        if (r10 == 0) goto L_0x0040;
    L_0x0012:
        r4 = r10[r1];
        if (r4 == 0) goto L_0x001c;
    L_0x0016:
        m4225a(r10);
        r8 = r8 + -3;
        return r8;
    L_0x001c:
        if (r0 <= r2) goto L_0x002b;
    L_0x001e:
        r4 = r10[r2];
        if (r4 == 0) goto L_0x002b;
    L_0x0022:
        r4 = r7[r8];
        if (r4 != r2) goto L_0x002b;
    L_0x0026:
        m4225a(r10);
        r8 = r8 - r3;
        return r8;
    L_0x002b:
        if (r0 <= r3) goto L_0x0040;
    L_0x002d:
        r4 = r10[r3];
        if (r4 == 0) goto L_0x0040;
    L_0x0031:
        r4 = r7[r8];
        if (r4 != 0) goto L_0x0040;
    L_0x0035:
        r4 = r8 + 1;
        r4 = r7[r4];
        if (r4 != r2) goto L_0x0040;
    L_0x003b:
        m4225a(r10);
        r8 = r8 - r2;
        return r8;
    L_0x0040:
        r4 = r9 + -1;
        r8 = r8 + r3;
    L_0x0043:
        if (r8 >= r4) goto L_0x0066;
    L_0x0045:
        r5 = r7[r8];
        r5 = r5 & 254;
        if (r5 != 0) goto L_0x0063;
    L_0x004b:
        r5 = r8 + -2;
        r6 = r7[r5];
        if (r6 != 0) goto L_0x0061;
    L_0x0051:
        r6 = r8 + -1;
        r6 = r7[r6];
        if (r6 != 0) goto L_0x0061;
    L_0x0057:
        r6 = r7[r8];
        if (r6 != r2) goto L_0x0061;
    L_0x005b:
        if (r10 == 0) goto L_0x0060;
    L_0x005d:
        m4225a(r10);
    L_0x0060:
        return r5;
    L_0x0061:
        r8 = r8 + -2;
    L_0x0063:
        r8 = r8 + 3;
        goto L_0x0043;
    L_0x0066:
        if (r10 == 0) goto L_0x00bc;
    L_0x0068:
        if (r0 <= r3) goto L_0x007e;
    L_0x006a:
        r8 = r9 + -3;
        r8 = r7[r8];
        if (r8 != 0) goto L_0x007c;
    L_0x0070:
        r8 = r9 + -2;
        r8 = r7[r8];
        if (r8 != 0) goto L_0x007c;
    L_0x0076:
        r8 = r7[r4];
        if (r8 != r2) goto L_0x007c;
    L_0x007a:
        r8 = r2;
        goto L_0x0098;
    L_0x007c:
        r8 = r1;
        goto L_0x0098;
    L_0x007e:
        if (r0 != r3) goto L_0x008f;
    L_0x0080:
        r8 = r10[r3];
        if (r8 == 0) goto L_0x007c;
    L_0x0084:
        r8 = r9 + -2;
        r8 = r7[r8];
        if (r8 != 0) goto L_0x007c;
    L_0x008a:
        r8 = r7[r4];
        if (r8 != r2) goto L_0x007c;
    L_0x008e:
        goto L_0x007a;
    L_0x008f:
        r8 = r10[r2];
        if (r8 == 0) goto L_0x007c;
    L_0x0093:
        r8 = r7[r4];
        if (r8 != r2) goto L_0x007c;
    L_0x0097:
        goto L_0x007a;
    L_0x0098:
        r10[r1] = r8;
        if (r0 <= r2) goto L_0x00aa;
    L_0x009c:
        r8 = r9 + -2;
        r8 = r7[r8];
        if (r8 != 0) goto L_0x00a8;
    L_0x00a2:
        r8 = r7[r4];
        if (r8 != 0) goto L_0x00a8;
    L_0x00a6:
        r8 = r2;
        goto L_0x00b3;
    L_0x00a8:
        r8 = r1;
        goto L_0x00b3;
    L_0x00aa:
        r8 = r10[r3];
        if (r8 == 0) goto L_0x00a8;
    L_0x00ae:
        r8 = r7[r4];
        if (r8 != 0) goto L_0x00a8;
    L_0x00b2:
        goto L_0x00a6;
    L_0x00b3:
        r10[r2] = r8;
        r7 = r7[r4];
        if (r7 != 0) goto L_0x00ba;
    L_0x00b9:
        r1 = r2;
    L_0x00ba:
        r10[r3] = r1;
    L_0x00bc:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NalUnitUtil.a(byte[], int, int, boolean[]):int");
    }

    public static void m4225a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
