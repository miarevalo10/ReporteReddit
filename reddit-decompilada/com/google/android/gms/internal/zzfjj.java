package com.google.android.gms.internal;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.io.IOException;

public final class zzfjj {
    final byte[] f7529a;
    final int f7530b;
    private final int f7531c;
    private int f7532d;
    private int f7533e;
    private int f7534f;
    private int f7535g;
    private int f7536h = RedditJobManager.f10810d;
    private int f7537i;
    private int f7538j = 64;
    private int f7539k = 67108864;

    private zzfjj(byte[] bArr, int i) {
        this.f7529a = bArr;
        this.f7530b = 0;
        i += 0;
        this.f7532d = i;
        this.f7531c = i;
        this.f7534f = 0;
    }

    public static zzfjj m6130a(byte[] bArr, int i) {
        return new zzfjj(bArr, i);
    }

    private final void m6131f(int i) throws IOException {
        if (i < 0) {
            throw zzfjr.m6200b();
        } else if (this.f7534f + i > this.f7536h) {
            m6131f(this.f7536h - this.f7534f);
            throw zzfjr.m6199a();
        } else if (i <= this.f7532d - this.f7534f) {
            this.f7534f += i;
        } else {
            throw zzfjr.m6199a();
        }
    }

    private final void m6132l() {
        this.f7532d += this.f7533e;
        int i = this.f7532d;
        if (i > this.f7536h) {
            this.f7533e = i - this.f7536h;
            this.f7532d -= this.f7533e;
            return;
        }
        this.f7533e = 0;
    }

    private final byte m6133m() throws IOException {
        if (this.f7534f == this.f7532d) {
            throw zzfjr.m6199a();
        }
        byte[] bArr = this.f7529a;
        int i = this.f7534f;
        this.f7534f = i + 1;
        return bArr[i];
    }

    public final int m6134a() throws IOException {
        if (this.f7534f == this.f7532d) {
            this.f7535g = 0;
            return 0;
        }
        this.f7535g = m6146f();
        if (this.f7535g != 0) {
            return this.f7535g;
        }
        throw new zzfjr("Protocol message contained an invalid tag (zero).");
    }

    public final void m6135a(int i) throws zzfjr {
        if (this.f7535g != i) {
            throw new zzfjr("Protocol message end-group tag did not match expected tag.");
        }
    }

    final void m6136a(int i, int i2) {
        if (i > this.f7534f - this.f7530b) {
            int i3 = this.f7534f - this.f7530b;
            StringBuilder stringBuilder = new StringBuilder(50);
            stringBuilder.append("Position ");
            stringBuilder.append(i);
            stringBuilder.append(" is beyond current ");
            stringBuilder.append(i3);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i < 0) {
            StringBuilder stringBuilder2 = new StringBuilder(24);
            stringBuilder2.append("Bad position ");
            stringBuilder2.append(i);
            throw new IllegalArgumentException(stringBuilder2.toString());
        } else {
            this.f7534f = this.f7530b + i;
            this.f7535g = i2;
        }
    }

    public final void m6137a(zzfjs com_google_android_gms_internal_zzfjs) throws IOException {
        int f = m6146f();
        if (this.f7537i >= this.f7538j) {
            throw zzfjr.m6202d();
        }
        f = m6140c(f);
        this.f7537i++;
        com_google_android_gms_internal_zzfjs.mo3478a(this);
        m6135a(0);
        this.f7537i--;
        m6143d(f);
    }

    public final int m6138b() throws IOException {
        return m6146f();
    }

    public final boolean m6139b(int i) throws IOException {
        switch (i & 7) {
            case 0:
                m6146f();
                return true;
            case 1:
                m6149i();
                return true;
            case 2:
                m6131f(m6146f());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                m6148h();
                return true;
            default:
                throw new zzfjr("Protocol message tag had invalid wire type.");
        }
        int a;
        do {
            a = m6134a();
            if (a != 0) {
            }
            m6135a(((i >>> 3) << 3) | 4);
            return true;
        } while (m6139b(a));
        m6135a(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int m6140c(int i) throws zzfjr {
        if (i < 0) {
            throw zzfjr.m6200b();
        }
        i += this.f7534f;
        int i2 = this.f7536h;
        if (i > i2) {
            throw zzfjr.m6199a();
        }
        this.f7536h = i;
        m6132l();
        return i2;
    }

    public final boolean m6141c() throws IOException {
        return m6146f() != 0;
    }

    public final String m6142d() throws IOException {
        int f = m6146f();
        if (f < 0) {
            throw zzfjr.m6200b();
        } else if (f > this.f7532d - this.f7534f) {
            throw zzfjr.m6199a();
        } else {
            String str = new String(this.f7529a, this.f7534f, f, zzfjq.f7553a);
            this.f7534f += f;
            return str;
        }
    }

    public final void m6143d(int i) {
        this.f7536h = i;
        m6132l();
    }

    public final void m6144e(int i) {
        m6136a(i, this.f7535g);
    }

    public final byte[] m6145e() throws IOException {
        int f = m6146f();
        if (f < 0) {
            throw zzfjr.m6200b();
        } else if (f == 0) {
            return zzfjv.f7566h;
        } else {
            if (f > this.f7532d - this.f7534f) {
                throw zzfjr.m6199a();
            }
            Object obj = new byte[f];
            System.arraycopy(this.f7529a, this.f7534f, obj, 0, f);
            this.f7534f += f;
            return obj;
        }
    }

    public final int m6146f() throws IOException {
        byte m = m6133m();
        if (m >= (byte) 0) {
            return m;
        }
        int i;
        int i2 = m & 127;
        byte m2 = m6133m();
        if (m2 >= (byte) 0) {
            i = m2 << 7;
        } else {
            i2 |= (m2 & 127) << 7;
            m2 = m6133m();
            if (m2 >= (byte) 0) {
                i = m2 << 14;
            } else {
                i2 |= (m2 & 127) << 14;
                m2 = m6133m();
                if (m2 >= (byte) 0) {
                    i = m2 << 21;
                } else {
                    i2 |= (m2 & 127) << 21;
                    m2 = m6133m();
                    i2 |= m2 << 28;
                    if (m2 >= (byte) 0) {
                        return i2;
                    }
                    for (i = 0; i < 5; i++) {
                        if (m6133m() >= (byte) 0) {
                            return i2;
                        }
                    }
                    throw zzfjr.m6201c();
                }
            }
        }
        return i2 | i;
    }

    public final long m6147g() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte m = m6133m();
            j |= ((long) (m & 127)) << i;
            if ((m & 128) == 0) {
                return j;
            }
        }
        throw zzfjr.m6201c();
    }

    public final int m6148h() throws IOException {
        return (((m6133m() & 255) | ((m6133m() & 255) << 8)) | ((m6133m() & 255) << 16)) | ((m6133m() & 255) << 24);
    }

    public final long m6149i() throws IOException {
        byte m = m6133m();
        byte m2 = m6133m();
        return ((((((((((long) m2) & 255) << 8) | (((long) m) & 255)) | ((((long) m6133m()) & 255) << 16)) | ((((long) m6133m()) & 255) << 24)) | ((((long) m6133m()) & 255) << 32)) | ((((long) m6133m()) & 255) << 40)) | ((((long) m6133m()) & 255) << 48)) | ((((long) m6133m()) & 255) << 56);
    }

    public final int m6150j() {
        if (this.f7536h == RedditJobManager.f10810d) {
            return -1;
        }
        return this.f7536h - this.f7534f;
    }

    public final int m6151k() {
        return this.f7534f - this.f7530b;
    }
}
