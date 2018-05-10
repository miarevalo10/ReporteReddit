package com.google.android.gms.internal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzffg extends zzfer {
    static final Logger f14434a = Logger.getLogger(zzffg.class.getName());
    static final boolean f14435b = zzfiq.m6104a();
    zzffi f14436c = this;

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzc(String str, Throwable th) {
            String valueOf = String.valueOf("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            str = String.valueOf(str);
            super(str.length() != 0 ? valueOf.concat(str) : new String(valueOf), th);
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    static class zzb extends zzffg {
        private final byte[] f18038d;
        private final int f18039e;
        private final int f18040f;
        private int f18041g;

        zzb(byte[] bArr, int i) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i2 = 0 + i;
            if (((0 | i) | (bArr.length - i2)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(0), Integer.valueOf(i)}));
            }
            this.f18038d = bArr;
            this.f18039e = 0;
            this.f18041g = 0;
            this.f18040f = i2;
        }

        public final void mo3511a(byte b) throws IOException {
            try {
                byte[] bArr = this.f18038d;
                int i = this.f18041g;
                this.f18041g = i + 1;
                bArr[i] = b;
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f18041g), Integer.valueOf(this.f18040f), Integer.valueOf(1)}), e);
            }
        }

        public final void mo3512a(int i) throws IOException {
            if (i >= 0) {
                mo3524b(i);
            } else {
                mo3518a((long) i);
            }
        }

        public final void mo3513a(int i, int i2) throws IOException {
            mo3524b((i << 3) | i2);
        }

        public final void mo3514a(int i, long j) throws IOException {
            mo3513a(i, 0);
            mo3518a(j);
        }

        public final void mo3515a(int i, zzfes com_google_android_gms_internal_zzfes) throws IOException {
            mo3513a(i, 2);
            mo3519a(com_google_android_gms_internal_zzfes);
        }

        public final void mo3516a(int i, zzfhe com_google_android_gms_internal_zzfhe) throws IOException {
            mo3513a(i, 2);
            mo3520a(com_google_android_gms_internal_zzfhe);
        }

        public final void mo3517a(int i, String str) throws IOException {
            mo3513a(i, 2);
            mo3521a(str);
        }

        public final void mo3519a(zzfes com_google_android_gms_internal_zzfes) throws IOException {
            mo3524b(com_google_android_gms_internal_zzfes.mo3503a());
            com_google_android_gms_internal_zzfes.mo3505a((zzfer) this);
        }

        public final void mo3520a(zzfhe com_google_android_gms_internal_zzfhe) throws IOException {
            mo3524b(com_google_android_gms_internal_zzfhe.mo4040c());
            com_google_android_gms_internal_zzfhe.mo4039a(this);
        }

        public final void mo3522a(boolean z) throws IOException {
            mo3513a(4, 0);
            mo3511a((byte) z);
        }

        public final void mo3523a(byte[] bArr, int i, int i2) throws IOException {
            mo3530b(bArr, i, i2);
        }

        public final void mo3525b(int i, int i2) throws IOException {
            mo3513a(i, 0);
            mo3512a(i2);
        }

        public final void mo3526b(int i, long j) throws IOException {
            mo3513a(i, 1);
            mo3529b(j);
        }

        public final void mo3527b(int i, zzfes com_google_android_gms_internal_zzfes) throws IOException {
            mo3513a(1, 3);
            mo3532c(2, i);
            mo3515a(3, com_google_android_gms_internal_zzfes);
            mo3513a(1, 4);
        }

        public final void mo3528b(int i, zzfhe com_google_android_gms_internal_zzfhe) throws IOException {
            mo3513a(1, 3);
            mo3532c(2, i);
            mo3516a(3, com_google_android_gms_internal_zzfhe);
            mo3513a(1, 4);
        }

        public final void mo3529b(long j) throws IOException {
            try {
                byte[] bArr = this.f18038d;
                int i = this.f18041g;
                this.f18041g = i + 1;
                bArr[i] = (byte) ((int) j);
                bArr = this.f18038d;
                i = this.f18041g;
                this.f18041g = i + 1;
                bArr[i] = (byte) ((int) (j >> 8));
                bArr = this.f18038d;
                i = this.f18041g;
                this.f18041g = i + 1;
                bArr[i] = (byte) ((int) (j >> 16));
                bArr = this.f18038d;
                i = this.f18041g;
                this.f18041g = i + 1;
                bArr[i] = (byte) ((int) (j >> 24));
                bArr = this.f18038d;
                i = this.f18041g;
                this.f18041g = i + 1;
                bArr[i] = (byte) ((int) (j >> 32));
                bArr = this.f18038d;
                i = this.f18041g;
                this.f18041g = i + 1;
                bArr[i] = (byte) ((int) (j >> 40));
                bArr = this.f18038d;
                i = this.f18041g;
                this.f18041g = i + 1;
                bArr[i] = (byte) ((int) (j >> 48));
                bArr = this.f18038d;
                i = this.f18041g;
                this.f18041g = i + 1;
                bArr[i] = (byte) ((int) (j >> 56));
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f18041g), Integer.valueOf(this.f18040f), Integer.valueOf(1)}), e);
            }
        }

        public final void mo3530b(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.f18038d, this.f18041g, i2);
                this.f18041g += i2;
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f18041g), Integer.valueOf(this.f18040f), Integer.valueOf(i2)}), e);
            }
        }

        public final void mo3531c(int i) throws IOException {
            try {
                byte[] bArr = this.f18038d;
                int i2 = this.f18041g;
                this.f18041g = i2 + 1;
                bArr[i2] = (byte) i;
                bArr = this.f18038d;
                i2 = this.f18041g;
                this.f18041g = i2 + 1;
                bArr[i2] = (byte) (i >> 8);
                bArr = this.f18038d;
                i2 = this.f18041g;
                this.f18041g = i2 + 1;
                bArr[i2] = (byte) (i >> 16);
                bArr = this.f18038d;
                i2 = this.f18041g;
                this.f18041g = i2 + 1;
                bArr[i2] = i >> 24;
            } catch (Throwable e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f18041g), Integer.valueOf(this.f18040f), Integer.valueOf(1)}), e);
            }
        }

        public final void mo3532c(int i, int i2) throws IOException {
            mo3513a(i, 0);
            mo3524b(i2);
        }

        public final void mo3533d(int i, int i2) throws IOException {
            mo3513a(i, 5);
            mo3531c(i2);
        }

        public final int mo3534i() {
            return this.f18040f - this.f18041g;
        }

        public final void mo3524b(int i) throws IOException {
            byte[] bArr;
            int i2;
            if (!zzffg.f14435b || mo3534i() < 10) {
                while ((i & -128) != 0) {
                    bArr = this.f18038d;
                    i2 = this.f18041g;
                    this.f18041g = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    bArr = this.f18038d;
                    i2 = this.f18041g;
                    this.f18041g = i2 + 1;
                    bArr[i2] = (byte) i;
                    return;
                } catch (int i3) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f18041g), Integer.valueOf(this.f18040f), Integer.valueOf(1)}), i3);
                }
            }
            while ((i3 & -128) != 0) {
                bArr = this.f18038d;
                i2 = this.f18041g;
                this.f18041g = i2 + 1;
                zzfiq.m6103a(bArr, (long) i2, (byte) ((i3 & 127) | 128));
                i3 >>>= 7;
            }
            bArr = this.f18038d;
            i2 = this.f18041g;
            this.f18041g = i2 + 1;
            zzfiq.m6103a(bArr, (long) i2, (byte) i3);
        }

        public final void mo3518a(long j) throws IOException {
            byte[] bArr;
            if (!zzffg.f14435b || mo3534i() < 10) {
                while ((j & -128) != 0) {
                    bArr = this.f18038d;
                    int i = this.f18041g;
                    this.f18041g = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    bArr = this.f18038d;
                    int i2 = this.f18041g;
                    this.f18041g = i2 + 1;
                    bArr[i2] = (byte) ((int) j);
                    return;
                } catch (long j2) {
                    throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.f18041g), Integer.valueOf(this.f18040f), Integer.valueOf(1)}), j2);
                }
            }
            while ((j2 & -128) != 0) {
                bArr = this.f18038d;
                i = this.f18041g;
                this.f18041g = i + 1;
                zzfiq.m6103a(bArr, (long) i, (byte) ((((int) j2) & 127) | 128));
                j2 >>>= 7;
            }
            bArr = this.f18038d;
            i2 = this.f18041g;
            this.f18041g = i2 + 1;
            zzfiq.m6103a(bArr, (long) i2, (byte) ((int) j2));
        }

        public final void mo3521a(String str) throws IOException {
            int i = this.f18041g;
            try {
                int h = zzffg.m13795h(str.length() * 3);
                int h2 = zzffg.m13795h(str.length());
                if (h2 == h) {
                    this.f18041g = i + h2;
                    h = zzfis.m6120a(str, this.f18038d, this.f18041g, mo3534i());
                    this.f18041g = i;
                    mo3524b((h - i) - h2);
                    this.f18041g = h;
                    return;
                }
                mo3524b(zzfis.m6119a((CharSequence) str));
                this.f18041g = zzfis.m6120a(str, this.f18038d, this.f18041g, mo3534i());
            } catch (Throwable e) {
                Throwable th = e;
                this.f18041g = i;
                zzffg.f14434a.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", th);
                str = str.getBytes(zzffz.f7417a);
                try {
                    mo3524b(str.length);
                    mo3523a(str, 0, str.length);
                } catch (String str2) {
                    throw new zzc(str2);
                } catch (String str22) {
                    throw str22;
                }
            } catch (String str222) {
                throw new zzc(str222);
            }
        }
    }

    private zzffg() {
    }

    public static int m13766a(zzfgk com_google_android_gms_internal_zzfgk) {
        int b = com_google_android_gms_internal_zzfgk.m6029b();
        return m13795h(b) + b;
    }

    public static int m13768b() {
        return 4;
    }

    public static int m13770b(zzfes com_google_android_gms_internal_zzfes) {
        int a = com_google_android_gms_internal_zzfes.mo3503a();
        return m13795h(a) + a;
    }

    public static int m13771b(zzfhe com_google_android_gms_internal_zzfhe) {
        int c = com_google_android_gms_internal_zzfhe.mo4040c();
        return m13795h(c) + c;
    }

    public static int m13772b(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = com.google.android.gms.internal.zzfis.m6119a(r1);	 Catch:{ zzfiv -> 0x0005 }
        goto L_0x000c;
    L_0x0005:
        r0 = com.google.android.gms.internal.zzffz.f7417a;
        r1 = r1.getBytes(r0);
        r0 = r1.length;
    L_0x000c:
        r1 = m13795h(r0);
        r1 = r1 + r0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzffg.b(java.lang.String):int");
    }

    public static int m13773b(byte[] bArr) {
        int length = bArr.length;
        return m13795h(length) + length;
    }

    public static int m13774c() {
        return 4;
    }

    public static int m13778c(long j) {
        return m13784d(j);
    }

    @Deprecated
    public static int m13779c(zzfhe com_google_android_gms_internal_zzfhe) {
        return com_google_android_gms_internal_zzfhe.mo4040c();
    }

    public static int m13780d() {
        return 8;
    }

    public static int m13784d(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        int i;
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        if ((j & -16384) != 0) {
            i++;
        }
        return i;
    }

    public static int m13785e() {
        return 8;
    }

    public static int m13789f() {
        return 4;
    }

    public static int m13790f(int i) {
        return m13795h(i << 3);
    }

    public static int m13792g() {
        return 8;
    }

    public static int m13793g(int i) {
        return i >= 0 ? m13795h(i) : 10;
    }

    public static int m13794h() {
        return 1;
    }

    public static int m13795h(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (i & -268435456) == 0 ? 4 : 5;
    }

    public static int m13797j(int i) {
        return m13793g(i);
    }

    @Deprecated
    public static int m13798k(int i) {
        return m13795h(i);
    }

    public abstract void mo3511a(byte b) throws IOException;

    public abstract void mo3512a(int i) throws IOException;

    public abstract void mo3513a(int i, int i2) throws IOException;

    public abstract void mo3514a(int i, long j) throws IOException;

    public abstract void mo3515a(int i, zzfes com_google_android_gms_internal_zzfes) throws IOException;

    public abstract void mo3516a(int i, zzfhe com_google_android_gms_internal_zzfhe) throws IOException;

    public abstract void mo3517a(int i, String str) throws IOException;

    public abstract void mo3518a(long j) throws IOException;

    public abstract void mo3519a(zzfes com_google_android_gms_internal_zzfes) throws IOException;

    public abstract void mo3520a(zzfhe com_google_android_gms_internal_zzfhe) throws IOException;

    public abstract void mo3521a(String str) throws IOException;

    public abstract void mo3522a(boolean z) throws IOException;

    public abstract void mo3524b(int i) throws IOException;

    public abstract void mo3525b(int i, int i2) throws IOException;

    public abstract void mo3526b(int i, long j) throws IOException;

    public abstract void mo3527b(int i, zzfes com_google_android_gms_internal_zzfes) throws IOException;

    public abstract void mo3528b(int i, zzfhe com_google_android_gms_internal_zzfhe) throws IOException;

    public abstract void mo3529b(long j) throws IOException;

    public abstract void mo3530b(byte[] bArr, int i, int i2) throws IOException;

    public abstract void mo3531c(int i) throws IOException;

    public abstract void mo3532c(int i, int i2) throws IOException;

    public abstract void mo3533d(int i, int i2) throws IOException;

    public abstract int mo3534i();

    public final void m13822j() {
        if (mo3534i() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public static zzffg m13767a(byte[] bArr) {
        return new zzb(bArr, bArr.length);
    }

    public static int m13787e(int i, int i2) {
        return m13795h(i << 3) + m13795h(i2);
    }

    public static int m13781d(int i) {
        return m13795h(i << 3) + 4;
    }

    public static int m13775c(int i, long j) {
        return m13795h(i << 3) + m13784d(j);
    }

    public static int m13786e(int i) {
        return m13795h(i << 3) + 8;
    }

    public static int m13764a() {
        return m13795h(32) + 1;
    }

    public static int m13791f(int i, int i2) {
        return m13795h(i << 3) + m13793g(i2);
    }

    public static int m13769b(int i, String str) {
        return m13795h(i << 3) + m13772b(str);
    }

    public static int m13776c(int i, zzfes com_google_android_gms_internal_zzfes) {
        i = m13795h(i << 3);
        com_google_android_gms_internal_zzfes = com_google_android_gms_internal_zzfes.mo3503a();
        return i + (m13795h(com_google_android_gms_internal_zzfes) + com_google_android_gms_internal_zzfes);
    }

    public static int m13777c(int i, zzfhe com_google_android_gms_internal_zzfhe) {
        return m13795h(i << 3) + m13771b(com_google_android_gms_internal_zzfhe);
    }

    public static int m13783d(int i, zzfhe com_google_android_gms_internal_zzfhe) {
        return ((m13795h(8) << 1) + m13787e(2, i)) + m13777c(3, com_google_android_gms_internal_zzfhe);
    }

    public static int m13782d(int i, zzfes com_google_android_gms_internal_zzfes) {
        return ((m13795h(8) << 1) + m13787e(2, i)) + m13776c(3, com_google_android_gms_internal_zzfes);
    }

    public static int m13765a(int i, zzfgk com_google_android_gms_internal_zzfgk) {
        int h = (m13795h(8) << 1) + m13787e(2, i);
        i = m13795h(24);
        com_google_android_gms_internal_zzfgk = com_google_android_gms_internal_zzfgk.m6029b();
        return h + (i + (m13795h(com_google_android_gms_internal_zzfgk) + com_google_android_gms_internal_zzfgk));
    }

    public static int m13796i(int i) {
        return m13795h((i >> 31) ^ (i << 1));
    }

    public static int m13788e(long j) {
        return m13784d((j >> 63) ^ (j << 1));
    }
}
