package com.google.android.gms.internal;

import org.jcodec.containers.mps.MPSUtils;

final class zzfiw extends zzfit {
    zzfiw() {
    }

    private static int m13894a(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return zzfis.m6122b(i);
            case 1:
                return zzfis.m6123b(i, zzfiq.m6097a(bArr, j));
            case 2:
                return zzfis.m6124b(i, zzfiq.m6097a(bArr, j), zzfiq.m6097a(bArr, j + 1));
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int m13895a(byte[] r11, long r12, int r14) {
        /*
        r0 = 0;
        r1 = 1;
        r3 = 16;
        if (r14 >= r3) goto L_0x0009;
    L_0x0007:
        r3 = r0;
        goto L_0x001b;
    L_0x0009:
        r4 = r12;
        r3 = r0;
    L_0x000b:
        if (r3 >= r14) goto L_0x001a;
    L_0x000d:
        r6 = r4 + r1;
        r4 = com.google.android.gms.internal.zzfiq.m6097a(r11, r4);
        if (r4 >= 0) goto L_0x0016;
    L_0x0015:
        goto L_0x001b;
    L_0x0016:
        r3 = r3 + 1;
        r4 = r6;
        goto L_0x000b;
    L_0x001a:
        r3 = r14;
    L_0x001b:
        r14 = r14 - r3;
        r3 = (long) r3;
        r12 = r12 + r3;
    L_0x001e:
        r3 = r0;
    L_0x001f:
        if (r14 <= 0) goto L_0x002f;
    L_0x0021:
        r3 = r12 + r1;
        r12 = com.google.android.gms.internal.zzfiq.m6097a(r11, r12);
        if (r12 < 0) goto L_0x0032;
    L_0x0029:
        r14 = r14 + -1;
        r9 = r3;
        r3 = r12;
        r12 = r9;
        goto L_0x001f;
    L_0x002f:
        r9 = r12;
        r12 = r3;
        r3 = r9;
    L_0x0032:
        if (r14 != 0) goto L_0x0035;
    L_0x0034:
        return r0;
    L_0x0035:
        r14 = r14 + -1;
        r13 = -32;
        r5 = -65;
        r6 = -1;
        if (r12 >= r13) goto L_0x0050;
    L_0x003e:
        if (r14 != 0) goto L_0x0041;
    L_0x0040:
        return r12;
    L_0x0041:
        r14 = r14 + -1;
        r13 = -62;
        if (r12 < r13) goto L_0x004f;
    L_0x0047:
        r12 = r3 + r1;
        r3 = com.google.android.gms.internal.zzfiq.m6097a(r11, r3);
        if (r3 <= r5) goto L_0x001e;
    L_0x004f:
        return r6;
    L_0x0050:
        r7 = -16;
        if (r12 >= r7) goto L_0x007b;
    L_0x0054:
        r7 = 2;
        if (r14 >= r7) goto L_0x005c;
    L_0x0057:
        r11 = m13894a(r11, r12, r3, r14);
        return r11;
    L_0x005c:
        r14 = r14 + -2;
        r7 = r3 + r1;
        r3 = com.google.android.gms.internal.zzfiq.m6097a(r11, r3);
        if (r3 > r5) goto L_0x007a;
    L_0x0066:
        r4 = -96;
        if (r12 != r13) goto L_0x006c;
    L_0x006a:
        if (r3 < r4) goto L_0x007a;
    L_0x006c:
        r13 = -19;
        if (r12 != r13) goto L_0x0072;
    L_0x0070:
        if (r3 >= r4) goto L_0x007a;
    L_0x0072:
        r12 = r7 + r1;
        r3 = com.google.android.gms.internal.zzfiq.m6097a(r11, r7);
        if (r3 <= r5) goto L_0x001e;
    L_0x007a:
        return r6;
    L_0x007b:
        r13 = 3;
        if (r14 >= r13) goto L_0x0083;
    L_0x007e:
        r11 = m13894a(r11, r12, r3, r14);
        return r11;
    L_0x0083:
        r14 = r14 + -3;
        r7 = r3 + r1;
        r13 = com.google.android.gms.internal.zzfiq.m6097a(r11, r3);
        if (r13 > r5) goto L_0x00aa;
    L_0x008d:
        r12 = r12 << 28;
        r13 = r13 + 112;
        r12 = r12 + r13;
        r12 = r12 >> 30;
        if (r12 != 0) goto L_0x00aa;
    L_0x0096:
        r12 = r7 + r1;
        r3 = com.google.android.gms.internal.zzfiq.m6097a(r11, r7);
        if (r3 > r5) goto L_0x00aa;
    L_0x009e:
        r3 = r12 + r1;
        r12 = com.google.android.gms.internal.zzfiq.m6097a(r11, r12);
        if (r12 <= r5) goto L_0x00a7;
    L_0x00a6:
        return r6;
    L_0x00a7:
        r12 = r3;
        goto L_0x001e;
    L_0x00aa:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfiw.a(byte[], long, int):int");
    }

    final int mo1925a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        long j = (long) i3;
        long j2 = ((long) i4) + j;
        int length = charSequence.length();
        if (length <= i4) {
            if (bArr2.length - i4 >= i3) {
                char charAt;
                i3 = 0;
                while (i3 < length) {
                    charAt = charSequence2.charAt(i3);
                    if (charAt >= '') {
                        break;
                    }
                    long j3 = 1 + j;
                    zzfiq.m6103a(bArr2, j, (byte) charAt);
                    i3++;
                    j = j3;
                }
                if (i3 == length) {
                    return (int) j;
                }
                while (i3 < length) {
                    charAt = charSequence2.charAt(i3);
                    if (charAt < '' && j < j2) {
                        long j4 = j + 1;
                        zzfiq.m6103a(bArr2, j, (byte) charAt);
                        j = j4;
                    } else if (charAt < 'ࠀ' && j <= j2 - 2) {
                        r14 = j + 1;
                        zzfiq.m6103a(bArr2, j, (byte) (960 | (charAt >>> 6)));
                        j = r14 + 1;
                        zzfiq.m6103a(bArr2, r14, (byte) ((charAt & 63) | 128));
                    } else if ((charAt < '?' || '?' < charAt) && j <= j2 - 3) {
                        r14 = j + 1;
                        zzfiq.m6103a(bArr2, j, (byte) (MPSUtils.VIDEO_MIN | (charAt >>> 12)));
                        j = r14 + 1;
                        zzfiq.m6103a(bArr2, r14, (byte) (((charAt >>> 6) & 63) | 128));
                        r14 = j + 1;
                        zzfiq.m6103a(bArr2, j, (byte) ((charAt & 63) | 128));
                        j = r14;
                    } else if (j <= j2 - 4) {
                        int i5 = i3 + 1;
                        if (i5 != length) {
                            char charAt2 = charSequence2.charAt(i5);
                            if (Character.isSurrogatePair(charAt, charAt2)) {
                                i3 = Character.toCodePoint(charAt, charAt2);
                                r14 = j + 1;
                                zzfiq.m6103a(bArr2, j, (byte) (240 | (i3 >>> 18)));
                                j = r14 + 1;
                                zzfiq.m6103a(bArr2, r14, (byte) (((i3 >>> 12) & 63) | 128));
                                r14 = j + 1;
                                zzfiq.m6103a(bArr2, j, (byte) (((i3 >>> 6) & 63) | 128));
                                j = r14 + 1;
                                zzfiq.m6103a(bArr2, r14, (byte) ((i3 & 63) | 128));
                                i3 = i5;
                            }
                        } else {
                            i5 = i3;
                        }
                        throw new zzfiv(i5 - 1, length);
                    } else {
                        if ('?' <= charAt && charAt <= '?') {
                            int i6 = i3 + 1;
                            if (i6 == length || !Character.isSurrogatePair(charAt, charSequence2.charAt(i6))) {
                                throw new zzfiv(i3, length);
                            }
                        }
                        StringBuilder stringBuilder = new StringBuilder(46);
                        stringBuilder.append("Failed writing ");
                        stringBuilder.append(charAt);
                        stringBuilder.append(" at index ");
                        stringBuilder.append(j);
                        throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
                    }
                    i3++;
                }
                return (int) j;
            }
        }
        char charAt3 = charSequence2.charAt(length - 1);
        i3 += i4;
        StringBuilder stringBuilder2 = new StringBuilder(37);
        stringBuilder2.append("Failed writing ");
        stringBuilder2.append(charAt3);
        stringBuilder2.append(" at index ");
        stringBuilder2.append(i3);
        throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
    }

    final int mo1926a(byte[] bArr, int i, int i2) {
        if (((i | i2) | (bArr.length - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }
        long j = (long) i;
        return m13895a(bArr, j, (int) (((long) i2) - j));
    }
}
