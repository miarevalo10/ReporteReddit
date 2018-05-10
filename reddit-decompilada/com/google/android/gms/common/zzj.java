package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class zzj extends zzh {
    private static final WeakReference<byte[]> f19117b = new WeakReference(null);
    private WeakReference<byte[]> f19118a = f19117b;

    zzj(byte[] bArr) {
        super(bArr);
    }

    final byte[] mo3961c() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f19118a.get();
            if (bArr == null) {
                bArr = mo4279d();
                this.f19118a = new WeakReference(bArr);
            }
        }
        return bArr;
    }

    protected abstract byte[] mo4279d();
}
