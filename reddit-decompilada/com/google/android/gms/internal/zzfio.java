package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzfio {
    private static final zzfio f7465f = new zzfio(0, new int[0], new Object[0], false);
    int f7466a;
    int[] f7467b;
    Object[] f7468c;
    int f7469d;
    boolean f7470e;

    private zzfio() {
        this(0, new int[8], new Object[8], true);
    }

    private zzfio(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f7469d = -1;
        this.f7466a = i;
        this.f7467b = iArr;
        this.f7468c = objArr;
        this.f7470e = z;
    }

    public static zzfio m6085a() {
        return f7465f;
    }

    static zzfio m6086a(zzfio com_google_android_gms_internal_zzfio, zzfio com_google_android_gms_internal_zzfio2) {
        int i = com_google_android_gms_internal_zzfio.f7466a + com_google_android_gms_internal_zzfio2.f7466a;
        Object copyOf = Arrays.copyOf(com_google_android_gms_internal_zzfio.f7467b, i);
        System.arraycopy(com_google_android_gms_internal_zzfio2.f7467b, 0, copyOf, com_google_android_gms_internal_zzfio.f7466a, com_google_android_gms_internal_zzfio2.f7466a);
        Object copyOf2 = Arrays.copyOf(com_google_android_gms_internal_zzfio.f7468c, i);
        System.arraycopy(com_google_android_gms_internal_zzfio2.f7468c, 0, copyOf2, com_google_android_gms_internal_zzfio.f7466a, com_google_android_gms_internal_zzfio2.f7466a);
        return new zzfio(i, copyOf, copyOf2, true);
    }

    private void m6087a(int i, Object obj) {
        m6089d();
        if (this.f7466a == this.f7467b.length) {
            int i2 = this.f7466a + (this.f7466a < 4 ? 8 : this.f7466a >> 1);
            this.f7467b = Arrays.copyOf(this.f7467b, i2);
            this.f7468c = Arrays.copyOf(this.f7468c, i2);
        }
        this.f7467b[this.f7466a] = i;
        this.f7468c[this.f7466a] = obj;
        this.f7466a++;
    }

    static zzfio m6088b() {
        return new zzfio();
    }

    private final void m6089d() {
        if (!this.f7470e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void m6090a(zzffg com_google_android_gms_internal_zzffg) throws IOException {
        for (int i = 0; i < this.f7466a; i++) {
            int i2 = this.f7467b[i];
            int i3 = i2 >>> 3;
            i2 &= 7;
            if (i2 != 5) {
                switch (i2) {
                    case 0:
                        com_google_android_gms_internal_zzffg.mo3514a(i3, ((Long) this.f7468c[i]).longValue());
                        break;
                    case 1:
                        com_google_android_gms_internal_zzffg.mo3526b(i3, ((Long) this.f7468c[i]).longValue());
                        break;
                    case 2:
                        com_google_android_gms_internal_zzffg.mo3515a(i3, (zzfes) this.f7468c[i]);
                        break;
                    case 3:
                        com_google_android_gms_internal_zzffg.mo3513a(i3, 3);
                        ((zzfio) this.f7468c[i]).m6090a(com_google_android_gms_internal_zzffg);
                        com_google_android_gms_internal_zzffg.mo3513a(i3, 4);
                        break;
                    default:
                        throw zzfge.m6025f();
                }
            }
            com_google_android_gms_internal_zzffg.mo3533d(i3, ((Integer) this.f7468c[i]).intValue());
        }
    }

    final void m6091a(StringBuilder stringBuilder, int i) {
        for (int i2 = 0; i2 < this.f7466a; i2++) {
            zzfhh.m6046a(stringBuilder, i, String.valueOf(this.f7467b[i2] >>> 3), this.f7468c[i2]);
        }
    }

    final boolean m6092a(int i, zzffb com_google_android_gms_internal_zzffb) throws IOException {
        m6089d();
        int i2 = i >>> 3;
        switch (i & 7) {
            case 0:
                m6087a(i, Long.valueOf(com_google_android_gms_internal_zzffb.mo1882b()));
                return true;
            case 1:
                m6087a(i, Long.valueOf(com_google_android_gms_internal_zzffb.mo1883c()));
                return true;
            case 2:
                m6087a(i, com_google_android_gms_internal_zzffb.mo1888g());
                return true;
            case 3:
                Object com_google_android_gms_internal_zzfio = new zzfio();
                int a;
                do {
                    a = com_google_android_gms_internal_zzffb.mo1878a();
                    if (a != 0) {
                    }
                    com_google_android_gms_internal_zzffb.mo1880a((i2 << 3) | 4);
                    m6087a(i, com_google_android_gms_internal_zzfio);
                    return true;
                } while (com_google_android_gms_internal_zzfio.m6092a(a, com_google_android_gms_internal_zzffb));
                com_google_android_gms_internal_zzffb.mo1880a((i2 << 3) | 4);
                m6087a(i, com_google_android_gms_internal_zzfio);
                return true;
            case 4:
                return false;
            case 5:
                m6087a(i, Integer.valueOf(com_google_android_gms_internal_zzffb.mo1885d()));
                return true;
            default:
                throw zzfge.m6025f();
        }
    }

    public final int m6093c() {
        int i = this.f7469d;
        if (i != -1) {
            return i;
        }
        i = 0;
        int i2 = 0;
        while (i < this.f7466a) {
            int i3 = this.f7467b[i];
            int i4 = i3 >>> 3;
            i3 &= 7;
            if (i3 != 5) {
                switch (i3) {
                    case 0:
                        i3 = zzffg.m13775c(i4, ((Long) this.f7468c[i]).longValue());
                        break;
                    case 1:
                        ((Long) this.f7468c[i]).longValue();
                        i3 = zzffg.m13786e(i4);
                        break;
                    case 2:
                        i3 = zzffg.m13776c(i4, (zzfes) this.f7468c[i]);
                        break;
                    case 3:
                        i3 = (zzffg.m13790f(i4) << 1) + ((zzfio) this.f7468c[i]).m6093c();
                        break;
                    default:
                        throw new IllegalStateException(zzfge.m6025f());
                }
            }
            ((Integer) this.f7468c[i]).intValue();
            i3 = zzffg.m13781d(i4);
            i2 += i3;
            i++;
        }
        this.f7469d = i2;
        return i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzfio)) {
            return false;
        }
        zzfio com_google_android_gms_internal_zzfio = (zzfio) obj;
        if (this.f7466a == com_google_android_gms_internal_zzfio.f7466a) {
            boolean z;
            int[] iArr = this.f7467b;
            int[] iArr2 = com_google_android_gms_internal_zzfio.f7467b;
            int i = this.f7466a;
            for (int i2 = 0; i2 < i; i2++) {
                if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                boolean z2;
                Object[] objArr = this.f7468c;
                Object[] objArr2 = com_google_android_gms_internal_zzfio.f7468c;
                int i3 = this.f7466a;
                for (i = 0; i < i3; i++) {
                    if (!objArr[i].equals(objArr2[i])) {
                        z2 = false;
                        break;
                    }
                }
                z2 = true;
                return z2;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((527 + this.f7466a) * 31) + Arrays.hashCode(this.f7467b)) * 31) + Arrays.deepHashCode(this.f7468c);
    }
}
