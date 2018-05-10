package com.google.android.gms.internal;

import java.io.IOException;

class zzfez extends zzfey {
    protected final byte[] f18037c;

    zzfez(byte[] bArr) {
        this.f18037c = bArr;
    }

    public byte mo3502a(int i) {
        return this.f18037c[i];
    }

    public int mo3503a() {
        return this.f18037c.length;
    }

    protected final int mo3504a(int i, int i2) {
        return zzffz.m6011a(i, this.f18037c, mo4033e() + 0, i2);
    }

    final void mo3505a(zzfer com_google_android_gms_internal_zzfer) throws IOException {
        com_google_android_gms_internal_zzfer.mo3523a(this.f18037c, mo4033e(), mo3503a());
    }

    protected void mo3506a(byte[] bArr, int i) {
        System.arraycopy(this.f18037c, 0, bArr, 0, i);
    }

    final boolean mo3507a(zzfes com_google_android_gms_internal_zzfes, int i) {
        if (i > com_google_android_gms_internal_zzfes.mo3503a()) {
            int a = mo3503a();
            StringBuilder stringBuilder = new StringBuilder(40);
            stringBuilder.append("Length too large: ");
            stringBuilder.append(i);
            stringBuilder.append(a);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i2 = 0 + i;
        int a2;
        if (i2 > com_google_android_gms_internal_zzfes.mo3503a()) {
            a2 = com_google_android_gms_internal_zzfes.mo3503a();
            stringBuilder = new StringBuilder(59);
            stringBuilder.append("Ran off end of other: 0, ");
            stringBuilder.append(i);
            stringBuilder.append(", ");
            stringBuilder.append(a2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (!(com_google_android_gms_internal_zzfes instanceof zzfez)) {
            return com_google_android_gms_internal_zzfes.mo3508b(i2).equals(mo3508b(i));
        } else {
            zzfez com_google_android_gms_internal_zzfez = (zzfez) com_google_android_gms_internal_zzfes;
            byte[] bArr = this.f18037c;
            byte[] bArr2 = com_google_android_gms_internal_zzfez.f18037c;
            int e = mo4033e() + i;
            i = mo4033e();
            a2 = com_google_android_gms_internal_zzfez.mo4033e() + 0;
            while (i < e) {
                if (bArr[i] != bArr2[a2]) {
                    return false;
                }
                i++;
                a2++;
            }
            return true;
        }
    }

    public final zzfes mo3508b(int i) {
        i = zzfes.m5946a(0, i, mo3503a());
        return i == 0 ? zzfes.f7377a : new zzfev(this.f18037c, mo4033e() + 0, i);
    }

    public final zzffb mo3509d() {
        return zzffb.m5964a(this.f18037c, mo4033e(), mo3503a(), true);
    }

    protected int mo4033e() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfes) || mo3503a() != ((zzfes) obj).mo3503a()) {
            return false;
        }
        if (mo3503a() == 0) {
            return true;
        }
        if (!(obj instanceof zzfez)) {
            return obj.equals(this);
        }
        zzfez com_google_android_gms_internal_zzfez = (zzfez) obj;
        int i = this.f7379b;
        int i2 = com_google_android_gms_internal_zzfez.f7379b;
        if (i == 0 || i2 == 0 || i == i2) {
            return mo3507a(com_google_android_gms_internal_zzfez, mo3503a());
        }
        return false;
    }
}
