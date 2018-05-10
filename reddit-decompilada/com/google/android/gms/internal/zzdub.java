package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public abstract class zzdub implements zzdvf {
    static final int[] f14376a = m13685a(ByteBuffer.wrap(new byte[]{(byte) 101, Framer.EXIT_FRAME_PREFIX, (byte) 112, (byte) 97, (byte) 110, (byte) 100, (byte) 32, (byte) 51, Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, (byte) 98, (byte) 121, (byte) 116, (byte) 101, (byte) 32, (byte) 107}));
    private static final byte[] f14377c = new byte[16];
    final zzdve f14378b;

    zzdub(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
        this.f14378b = zzdve.m5914a(bArr);
    }

    static int m13683a(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    static int[] m13685a(ByteBuffer byteBuffer) {
        IntBuffer asIntBuffer = byteBuffer.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    static zzdub m13686b(byte[] bArr) {
        return new zzdud(bArr, (byte) 0);
    }

    abstract int mo4029a();

    final void m13688a(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
        if (bArr.length > 2147483635) {
            throw new GeneralSecurityException("plaintext too long");
        } else if (byteBuffer.remaining() < bArr.length + 12) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        } else {
            byte[] a = zzdvi.m5921a(12);
            byteBuffer.put(a);
            m13684a(byteBuffer, ByteBuffer.wrap(bArr), mo4031c(a));
        }
    }

    public final byte[] mo1866a(byte[] bArr) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(12 + bArr.length);
        m13688a(allocate, bArr);
        return allocate.array();
    }

    abstract int[] mo4030a(byte[] bArr, int i);

    final int[] m13691a(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        mo3497b(copyOf);
        for (int i = 0; i < iArr.length; i++) {
            copyOf[i] = copyOf[i] + iArr[i];
        }
        return copyOf;
    }

    abstract void mo3497b(int[] iArr);

    abstract zzduf mo4031c(byte[] bArr);

    abstract void mo4032c(int[] iArr);

    private static void m13684a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, zzduf com_google_android_gms_internal_zzduf) {
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        while (byteBuffer2.hasRemaining()) {
            int remaining = byteBuffer2.remaining() < 64 ? byteBuffer2.remaining() : 64;
            IntBuffer asIntBuffer = order.asIntBuffer();
            com_google_android_gms_internal_zzduf.f7313f = true;
            int i = 0;
            System.arraycopy(com_google_android_gms_internal_zzduf.f7310c, com_google_android_gms_internal_zzduf.f7312e, com_google_android_gms_internal_zzduf.f7311d, 0, 16 - com_google_android_gms_internal_zzduf.f7312e);
            com_google_android_gms_internal_zzduf.f7308a.mo4032c(com_google_android_gms_internal_zzduf.f7309b);
            com_google_android_gms_internal_zzduf.f7310c = com_google_android_gms_internal_zzduf.f7308a.m13691a(com_google_android_gms_internal_zzduf.f7309b);
            System.arraycopy(com_google_android_gms_internal_zzduf.f7310c, 0, com_google_android_gms_internal_zzduf.f7311d, 16 - com_google_android_gms_internal_zzduf.f7312e, com_google_android_gms_internal_zzduf.f7312e);
            asIntBuffer.put(com_google_android_gms_internal_zzduf.f7311d);
            while (i < remaining) {
                byteBuffer.put((byte) (byteBuffer2.get() ^ order.get(i)));
                i++;
            }
        }
    }
}
