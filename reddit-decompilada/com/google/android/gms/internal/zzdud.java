package com.google.android.gms.internal;

import java.nio.ByteBuffer;

final class zzdud extends zzdue {
    private zzdud(byte[] bArr) {
        super(bArr);
    }

    final int mo4029a() {
        return 12;
    }

    final zzduf mo4031c(byte[] bArr) {
        return new zzduf(this, bArr, 1);
    }

    final void mo4032c(int[] iArr) {
        iArr[12] = iArr[12] + 1;
    }

    final int[] mo4030a(byte[] bArr, int i) {
        Object obj = new int[16];
        System.arraycopy(zzdue.a, 0, obj, 0, zzdue.a.length);
        Object a = zzdub.m13685a(ByteBuffer.wrap(this.b.m5915a()));
        System.arraycopy(a, 0, obj, 4, a.length);
        obj[12] = i;
        System.arraycopy(zzdub.m13685a((ByteBuffer) ByteBuffer.wrap(bArr)), 0, obj, 13, 3);
        return obj;
    }
}
