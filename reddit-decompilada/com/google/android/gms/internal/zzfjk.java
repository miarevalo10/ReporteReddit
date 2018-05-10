package com.google.android.gms.internal;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.containers.mps.MPSUtils;

public final class zzfjk {
    private final ByteBuffer f7540a;

    private zzfjk(ByteBuffer byteBuffer) {
        this.f7540a = byteBuffer;
        this.f7540a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzfjk(byte[] bArr, int i) {
        this(ByteBuffer.wrap(bArr, 0, i));
    }

    public static int m6152a(int i) {
        return i >= 0 ? m6169d(i) : 10;
    }

    public static int m6153a(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private static int m6154a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < '') {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 'ࠀ') {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 'ࠀ') {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if ('?' <= charAt2 && charAt2 <= '?') {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                StringBuilder stringBuilder = new StringBuilder(39);
                                stringBuilder.append("Unpaired surrogate at index ");
                                stringBuilder.append(i2);
                                throw new IllegalArgumentException(stringBuilder.toString());
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
                if (i3 < length) {
                    return i3;
                }
                long j = ((long) i3) + 4294967296L;
                StringBuilder stringBuilder2 = new StringBuilder(54);
                stringBuilder2.append("UTF-8 length does not fit in int: ");
                stringBuilder2.append(j);
                throw new IllegalArgumentException(stringBuilder2.toString());
            }
        }
        if (i3 < length) {
            return i3;
        }
        long j2 = ((long) i3) + 4294967296L;
        StringBuilder stringBuilder22 = new StringBuilder(54);
        stringBuilder22.append("UTF-8 length does not fit in int: ");
        stringBuilder22.append(j2);
        throw new IllegalArgumentException(stringBuilder22.toString());
    }

    private static int m6155a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int length = charSequence.length();
        i2 += i;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + i;
            if (i4 >= i2) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt >= '') {
                break;
            }
            bArr[i4] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        i += i3;
        while (i3 < length) {
            int i5;
            char charAt2 = charSequence.charAt(i3);
            if (charAt2 < '' && i < i2) {
                i5 = i + 1;
                bArr[i] = (byte) charAt2;
            } else if (charAt2 < 'ࠀ' && i <= i2 - 2) {
                i5 = i + 1;
                bArr[i] = (byte) (960 | (charAt2 >>> 6));
                i = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
                i3++;
            } else if ((charAt2 < '?' || '?' < charAt2) && i <= i2 - 3) {
                i5 = i + 1;
                bArr[i] = (byte) (MPSUtils.VIDEO_MIN | (charAt2 >>> 12));
                i = i5 + 1;
                bArr[i5] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i5 = i + 1;
                bArr[i] = (byte) ((charAt2 & 63) | 128);
            } else if (i <= i2 - 4) {
                i5 = i3 + 1;
                if (i5 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i5);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        i3 = Character.toCodePoint(charAt2, charAt3);
                        i4 = i + 1;
                        bArr[i] = (byte) (240 | (i3 >>> 18));
                        i = i4 + 1;
                        bArr[i4] = (byte) (((i3 >>> 12) & 63) | 128);
                        i4 = i + 1;
                        bArr[i] = (byte) (((i3 >>> 6) & 63) | 128);
                        i = i4 + 1;
                        bArr[i4] = (byte) ((i3 & 63) | 128);
                        i3 = i5;
                        i3++;
                    } else {
                        i3 = i5;
                    }
                }
                i3--;
                StringBuilder stringBuilder = new StringBuilder(39);
                stringBuilder.append("Unpaired surrogate at index ");
                stringBuilder.append(i3);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else {
                StringBuilder stringBuilder2 = new StringBuilder(37);
                stringBuilder2.append("Failed writing ");
                stringBuilder2.append(charAt2);
                stringBuilder2.append(" at index ");
                stringBuilder2.append(i);
                throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
            }
            i = i5;
            i3++;
        }
        return i;
    }

    public static int m6156a(String str) {
        int a = m6154a((CharSequence) str);
        return m6169d(a) + a;
    }

    public static zzfjk m6157a(byte[] bArr) {
        return m6158a(bArr, bArr.length);
    }

    public static zzfjk m6158a(byte[] bArr, int i) {
        return new zzfjk(bArr, i);
    }

    private static void m6159a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(m6155a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            m6167b(charSequence, byteBuffer);
        }
    }

    public static int m6160b(int i) {
        return m6169d(i << 3);
    }

    public static int m6165b(byte[] bArr) {
        return m6169d(bArr.length) + bArr.length;
    }

    private final void m6166b(long j) throws IOException {
        while ((-128 & j) != 0) {
            m6170e((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m6170e((int) j);
    }

    private static void m6167b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i);
            if (charAt >= 128) {
                int i2;
                if (charAt < MPEGConst.CODE_END) {
                    i2 = 960 | (charAt >>> 6);
                } else {
                    if (charAt >= 55296) {
                        if (57343 >= charAt) {
                            i2 = i + 1;
                            if (i2 != charSequence.length()) {
                                char charAt2 = charSequence.charAt(i2);
                                if (Character.isSurrogatePair(charAt, charAt2)) {
                                    i = Character.toCodePoint(charAt, charAt2);
                                    byteBuffer.put((byte) (240 | (i >>> 18)));
                                    byteBuffer.put((byte) (((i >>> 12) & 63) | 128));
                                    byteBuffer.put((byte) (((i >>> 6) & 63) | 128));
                                    byteBuffer.put((byte) ((i & 63) | 128));
                                    i = i2;
                                    i++;
                                } else {
                                    i = i2;
                                }
                            }
                            i--;
                            StringBuilder stringBuilder = new StringBuilder(39);
                            stringBuilder.append("Unpaired surrogate at index ");
                            stringBuilder.append(i);
                            throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                    byteBuffer.put((byte) (MPSUtils.VIDEO_MIN | (charAt >>> 12)));
                    i2 = ((charAt >>> 6) & 63) | 128;
                }
                byteBuffer.put((byte) i2);
                charAt = (charAt & 63) | 128;
            }
            byteBuffer.put((byte) charAt);
            i++;
        }
    }

    public static int m6169d(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    private final void m6170e(int i) throws IOException {
        byte b = (byte) i;
        if (this.f7540a.hasRemaining()) {
            this.f7540a.put(b);
            return;
        }
        throw new zzfjl(this.f7540a.position(), this.f7540a.limit());
    }

    public final void m6171a() {
        if (this.f7540a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.f7540a.remaining())}));
        }
    }

    public final void m6173a(int i, float f) throws IOException {
        m6183c(i, 5);
        i = Float.floatToIntBits(f);
        if (this.f7540a.remaining() < 4) {
            throw new zzfjl(this.f7540a.position(), this.f7540a.limit());
        }
        this.f7540a.putInt(i);
    }

    public final void m6174a(int i, int i2) throws IOException {
        m6183c(i, 0);
        if (i2 >= 0) {
            m6182c(i2);
        } else {
            m6166b((long) i2);
        }
    }

    public final void m6175a(int i, long j) throws IOException {
        m6183c(i, 0);
        m6166b(j);
    }

    public final void m6176a(int i, zzfjs com_google_android_gms_internal_zzfjs) throws IOException {
        m6183c(i, 2);
        m6180a(com_google_android_gms_internal_zzfjs);
    }

    public final void m6177a(int i, String str) throws IOException {
        m6183c(i, 2);
        try {
            i = m6169d(str.length());
            if (i == m6169d(str.length() * 3)) {
                int position = this.f7540a.position();
                if (this.f7540a.remaining() < i) {
                    throw new zzfjl(position + i, this.f7540a.limit());
                }
                this.f7540a.position(position + i);
                m6159a((CharSequence) str, this.f7540a);
                int position2 = this.f7540a.position();
                this.f7540a.position(position);
                m6182c((position2 - position) - i);
                this.f7540a.position(position2);
                return;
            }
            m6182c(m6154a((CharSequence) str));
            m6159a((CharSequence) str, this.f7540a);
        } catch (Throwable e) {
            zzfjl com_google_android_gms_internal_zzfjl = new zzfjl(this.f7540a.position(), this.f7540a.limit());
            com_google_android_gms_internal_zzfjl.initCause(e);
            throw com_google_android_gms_internal_zzfjl;
        }
    }

    public final void m6178a(int i, boolean z) throws IOException {
        m6183c(i, 0);
        byte b = (byte) z;
        if (this.f7540a.hasRemaining()) {
            this.f7540a.put(b);
            return;
        }
        throw new zzfjl(this.f7540a.position(), this.f7540a.limit());
    }

    public final void m6179a(int i, byte[] bArr) throws IOException {
        m6183c(i, 2);
        m6182c(bArr.length);
        m6184c(bArr);
    }

    public final void m6180a(zzfjs com_google_android_gms_internal_zzfjs) throws IOException {
        m6182c(com_google_android_gms_internal_zzfjs.m6210d());
        com_google_android_gms_internal_zzfjs.mo1928a(this);
    }

    public final void m6181b(int i, long j) throws IOException {
        m6183c(i, 0);
        m6166b(j);
    }

    public final void m6182c(int i) throws IOException {
        while ((i & -128) != 0) {
            m6170e((i & 127) | 128);
            i >>>= 7;
        }
        m6170e(i);
    }

    public final void m6183c(int i, int i2) throws IOException {
        m6182c((i << 3) | i2);
    }

    public final void m6184c(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.f7540a.remaining() >= length) {
            this.f7540a.put(bArr, 0, length);
            return;
        }
        throw new zzfjl(this.f7540a.position(), this.f7540a.limit());
    }

    public final void m6172a(int i, double d) throws IOException {
        m6183c(i, 1);
        i = Double.doubleToLongBits(d);
        if (this.f7540a.remaining() < 8) {
            throw new zzfjl(this.f7540a.position(), this.f7540a.limit());
        }
        this.f7540a.putLong(i);
    }

    public static int m6168c(int i, long j) {
        return m6169d(i << 3) + m6153a(j);
    }

    public static int m6161b(int i, int i2) {
        return m6169d(i << 3) + m6152a(i2);
    }

    public static int m6163b(int i, String str) {
        return m6169d(i << 3) + m6156a(str);
    }

    public static int m6162b(int i, zzfjs com_google_android_gms_internal_zzfjs) {
        i = m6169d(i << 3);
        com_google_android_gms_internal_zzfjs = com_google_android_gms_internal_zzfjs.m6211e();
        return i + (m6169d(com_google_android_gms_internal_zzfjs) + com_google_android_gms_internal_zzfjs);
    }

    public static int m6164b(int i, byte[] bArr) {
        return m6169d(i << 3) + m6165b(bArr);
    }
}
