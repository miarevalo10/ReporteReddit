package com.google.android.gms.internal;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.IOException;
import java.util.Arrays;

final class zzffd extends zzffb {
    private final byte[] f14426d;
    private final boolean f14427e;
    private int f14428f;
    private int f14429g;
    private int f14430h;
    private int f14431i;
    private int f14432j;
    private int f14433k;

    private zzffd(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f14433k = RedditJobManager.f10810d;
        this.f14426d = bArr;
        this.f14428f = i2 + i;
        this.f14430h = i;
        this.f14431i = this.f14430h;
        this.f14427e = z;
    }

    private final long m13745n() throws IOException {
        int i = this.f14430h;
        if (this.f14428f != i) {
            byte[] bArr = this.f14426d;
            int i2 = i + 1;
            byte b = bArr[i];
            if (b >= (byte) 0) {
                this.f14430h = i2;
                return (long) b;
            } else if (this.f14428f - i2 >= 9) {
                long j;
                int i3 = i2 + 1;
                i = b ^ (bArr[i2] << 7);
                if (i < 0) {
                    i ^= -128;
                } else {
                    i2 = i3 + 1;
                    i ^= bArr[i3] << 14;
                    if (i >= 0) {
                        long j2 = (long) (i ^ 16256);
                        i = i2;
                        j = j2;
                    } else {
                        i3 = i2 + 1;
                        i ^= bArr[i2] << 21;
                        if (i < 0) {
                            i ^= -2080896;
                        } else {
                            long j3 = (long) i;
                            i = i3 + 1;
                            long j4 = (((long) bArr[i3]) << 28) ^ j3;
                            if (j4 >= 0) {
                                j3 = 266354560;
                            } else {
                                long j5;
                                int i4 = i + 1;
                                j4 ^= ((long) bArr[i]) << 35;
                                if (j4 < 0) {
                                    j5 = -34093383808L;
                                } else {
                                    i = i4 + 1;
                                    j4 ^= ((long) bArr[i4]) << 42;
                                    if (j4 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i4 = i + 1;
                                        j4 ^= ((long) bArr[i]) << 49;
                                        if (j4 < 0) {
                                            j5 = -558586000294016L;
                                        } else {
                                            i = i4 + 1;
                                            j4 = (j4 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            if (j4 < 0) {
                                                i4 = i + 1;
                                                if (((long) bArr[i]) >= 0) {
                                                    j = j4;
                                                    i = i4;
                                                }
                                            } else {
                                                j = j4;
                                            }
                                        }
                                    }
                                }
                                j = j5 ^ j4;
                                i = i4;
                            }
                            j = j4 ^ j3;
                        }
                    }
                    this.f14430h = i;
                    return j;
                }
                j = (long) i;
                i = i3;
                this.f14430h = i;
                return j;
            }
        }
        return mo1892k();
    }

    private final void m13746o() {
        this.f14428f += this.f14429g;
        int i = this.f14428f - this.f14431i;
        if (i > this.f14433k) {
            this.f14429g = i - this.f14433k;
            this.f14428f -= this.f14429g;
            return;
        }
        this.f14429g = 0;
    }

    public final int mo1878a() throws IOException {
        if (mo1893l()) {
            this.f14432j = 0;
            return 0;
        }
        this.f14432j = mo1891j();
        if ((this.f14432j >>> 3) != 0) {
            return this.f14432j;
        }
        throw zzfge.m6023d();
    }

    public final <T extends zzffu<T, ?>> T mo1879a(T t, zzffm com_google_android_gms_internal_zzffm) throws IOException {
        int j = mo1891j();
        if (this.a >= this.b) {
            throw zzfge.m6026g();
        }
        j = mo1881b(j);
        this.a++;
        t = zzffu.m20436a((zzffu) t, (zzffb) this, com_google_android_gms_internal_zzffm);
        mo1880a(0);
        this.a--;
        mo1884c(j);
        return t;
    }

    public final void mo1880a(int i) throws zzfge {
        if (this.f14432j != i) {
            throw zzfge.m6024e();
        }
    }

    public final int mo1881b(int i) throws zzfge {
        if (i < 0) {
            throw zzfge.m6021b();
        }
        i += mo1894m();
        int i2 = this.f14433k;
        if (i > i2) {
            throw zzfge.m6020a();
        }
        this.f14433k = i;
        m13746o();
        return i2;
    }

    public final long mo1882b() throws IOException {
        return m13745n();
    }

    public final void mo1884c(int i) {
        this.f14433k = i;
        m13746o();
    }

    public final boolean mo1886e() throws IOException {
        return m13745n() != 0;
    }

    public final String mo1887f() throws IOException {
        int j = mo1891j();
        if (j <= 0 || j > this.f14428f - this.f14430h) {
            if (j == 0) {
                return "";
            }
            if (j <= 0) {
                throw zzfge.m6021b();
            }
            throw zzfge.m6020a();
        } else if (zzfis.m6121a(this.f14426d, this.f14430h, this.f14430h + j)) {
            int i = this.f14430h;
            this.f14430h += j;
            return new String(this.f14426d, i, j, zzffz.f7417a);
        } else {
            throw zzfge.m6027h();
        }
    }

    public final zzfes mo1888g() throws IOException {
        int j = mo1891j();
        if (j > 0 && j <= this.f14428f - this.f14430h) {
            zzfes a = zzfes.m5949a(this.f14426d, this.f14430h, j);
            this.f14430h += j;
            return a;
        } else if (j == 0) {
            return zzfes.f7377a;
        } else {
            byte[] copyOfRange;
            if (j > 0 && j <= this.f14428f - this.f14430h) {
                int i = this.f14430h;
                this.f14430h += j;
                copyOfRange = Arrays.copyOfRange(this.f14426d, i, this.f14430h);
            } else if (j > 0) {
                throw zzfge.m6020a();
            } else if (j == 0) {
                copyOfRange = zzffz.f7418b;
            } else {
                throw zzfge.m6021b();
            }
            return zzfes.m5950b(copyOfRange);
        }
    }

    public final int mo1889h() throws IOException {
        return mo1891j();
    }

    public final int mo1890i() throws IOException {
        return mo1891j();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int mo1891j() throws java.io.IOException {
        /*
        r5 = this;
        r0 = r5.f14430h;
        r1 = r5.f14428f;
        if (r1 == r0) goto L_0x006d;
    L_0x0006:
        r1 = r5.f14426d;
        r2 = r0 + 1;
        r0 = r1[r0];
        if (r0 < 0) goto L_0x0011;
    L_0x000e:
        r5.f14430h = r2;
        return r0;
    L_0x0011:
        r3 = r5.f14428f;
        r3 = r3 - r2;
        r4 = 9;
        if (r3 < r4) goto L_0x006d;
    L_0x0018:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 7;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x0024;
    L_0x0021:
        r0 = r0 ^ -128;
        goto L_0x006a;
    L_0x0024:
        r2 = r3 + 1;
        r3 = r1[r3];
        r3 = r3 << 14;
        r0 = r0 ^ r3;
        if (r0 < 0) goto L_0x0031;
    L_0x002d:
        r0 = r0 ^ 16256;
    L_0x002f:
        r3 = r2;
        goto L_0x006a;
    L_0x0031:
        r3 = r2 + 1;
        r2 = r1[r2];
        r2 = r2 << 21;
        r0 = r0 ^ r2;
        if (r0 >= 0) goto L_0x003f;
    L_0x003a:
        r1 = -2080896; // 0xffffffffffe03f80 float:NaN double:NaN;
        r0 = r0 ^ r1;
        goto L_0x006a;
    L_0x003f:
        r2 = r3 + 1;
        r3 = r1[r3];
        r4 = r3 << 28;
        r0 = r0 ^ r4;
        r4 = 266354560; // 0xfe03f80 float:2.2112565E-29 double:1.315966377E-315;
        r0 = r0 ^ r4;
        if (r3 >= 0) goto L_0x002f;
    L_0x004c:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x006a;
    L_0x0052:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x002f;
    L_0x0058:
        r3 = r2 + 1;
        r2 = r1[r2];
        if (r2 >= 0) goto L_0x006a;
    L_0x005e:
        r2 = r3 + 1;
        r3 = r1[r3];
        if (r3 >= 0) goto L_0x002f;
    L_0x0064:
        r3 = r2 + 1;
        r1 = r1[r2];
        if (r1 < 0) goto L_0x006d;
    L_0x006a:
        r5.f14430h = r3;
        return r0;
    L_0x006d:
        r0 = r5.mo1892k();
        r0 = (int) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffd.j():int");
    }

    public final boolean mo1893l() throws IOException {
        return this.f14430h == this.f14428f;
    }

    public final int mo1894m() {
        return this.f14430h - this.f14431i;
    }

    public final long mo1883c() throws IOException {
        int i = this.f14430h;
        if (this.f14428f - i < 8) {
            throw zzfge.m6020a();
        }
        byte[] bArr = this.f14426d;
        this.f14430h = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((((((((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8)) | ((((long) bArr[i + 2]) & 255) << 16)) | ((((long) bArr[i + 3]) & 255) << 24)) | ((((long) bArr[i + 4]) & 255) << 32)) | ((((long) bArr[i + 5]) & 255) << 40)) | ((((long) bArr[i + 6]) & 255) << 48));
    }

    public final int mo1885d() throws IOException {
        int i = this.f14430h;
        if (this.f14428f - i < 4) {
            throw zzfge.m6020a();
        }
        byte[] bArr = this.f14426d;
        this.f14430h = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (((bArr[i] & 255) | ((bArr[i + 1] & 255) << 8)) | ((bArr[i + 2] & 255) << 16));
    }

    final long mo1892k() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.f14430h == this.f14428f) {
                throw zzfge.m6020a();
            }
            byte[] bArr = this.f14426d;
            int i2 = this.f14430h;
            this.f14430h = i2 + 1;
            byte b = bArr[i2];
            j |= ((long) (b & 127)) << i;
            if ((b & 128) == 0) {
                return j;
            }
        }
        throw zzfge.m6022c();
    }
}
