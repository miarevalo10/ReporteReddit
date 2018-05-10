package com.google.android.gms.internal;

final class zzfev extends zzfez {
    private final int f19229d;
    private final int f19230e;

    zzfev(byte[] bArr, int i, int i2) {
        super(bArr);
        zzfes.m5946a(i, i + i2, bArr.length);
        this.f19229d = i;
        this.f19230e = i2;
    }

    public final int mo3503a() {
        return this.f19230e;
    }

    protected final void mo3506a(byte[] bArr, int i) {
        System.arraycopy(this.c, mo4033e() + 0, bArr, 0, i);
    }

    protected final int mo4033e() {
        return this.f19229d;
    }

    public final byte mo3502a(int i) {
        int a = mo3503a();
        if (((a - (i + 1)) | i) >= 0) {
            return this.c[this.f19229d + i];
        }
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder(22);
            stringBuilder.append("Index < 0: ");
            stringBuilder.append(i);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder(40);
        stringBuilder2.append("Index > length: ");
        stringBuilder2.append(i);
        stringBuilder2.append(", ");
        stringBuilder2.append(a);
        throw new ArrayIndexOutOfBoundsException(stringBuilder2.toString());
    }
}
