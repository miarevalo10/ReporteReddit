package com.google.android.gms.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class zzdui extends zzdug {
    private zzdui(zzdub com_google_android_gms_internal_zzdub) {
        super(com_google_android_gms_internal_zzdub);
    }

    final byte[] mo3498a(byte[] bArr, ByteBuffer byteBuffer) {
        int a = ((((bArr.length + 16) - 1) / 16) << 4);
        int remaining = byteBuffer.remaining();
        int a2 = ((((remaining + 16) - 1) / 16) << 4) + a;
        ByteBuffer order = ByteBuffer.allocate(a2 + 16).order(ByteOrder.LITTLE_ENDIAN);
        order.put(bArr);
        order.position(a);
        order.put(byteBuffer);
        order.position(a2);
        order.putLong((long) bArr.length);
        order.putLong((long) remaining);
        return order.array();
    }
}
