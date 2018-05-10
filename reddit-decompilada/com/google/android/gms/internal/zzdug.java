package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;

public abstract class zzdug implements zzdpp {
    private final zzdub f14379a;

    private zzdug(zzdub com_google_android_gms_internal_zzdub) {
        this.f14379a = com_google_android_gms_internal_zzdub;
    }

    public static zzdug m13696a(byte[] bArr) {
        return new zzdui(zzdub.m13686b(bArr), (byte) 0);
    }

    abstract byte[] mo3498a(byte[] bArr, ByteBuffer byteBuffer);

    public final byte[] mo1861a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate((this.f14379a.mo4029a() + bArr.length) + 16);
        if (allocate.remaining() < (bArr.length + this.f14379a.mo4029a()) + 16) {
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        int position = allocate.position();
        this.f14379a.m13688a(allocate, bArr);
        allocate.position(position);
        bArr = new byte[this.f14379a.mo4029a()];
        allocate.get(bArr);
        allocate.limit(allocate.limit() - 16);
        zzduf com_google_android_gms_internal_zzduf = new zzduf(this.f14379a, bArr, 0);
        if (com_google_android_gms_internal_zzduf.f7313f != null) {
            throw new IllegalStateException("first can only be called once and before next().");
        }
        com_google_android_gms_internal_zzduf.f7313f = 1;
        com_google_android_gms_internal_zzduf.f7312e = 8;
        ByteBuffer order = ByteBuffer.allocate(32).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(com_google_android_gms_internal_zzduf.f7310c, 0, 8);
        bArr = zzdvh.m5920a(order.array(), mo3498a(bArr2, allocate));
        allocate.limit(allocate.limit() + 16);
        allocate.put(bArr);
        return allocate.array();
    }
}
