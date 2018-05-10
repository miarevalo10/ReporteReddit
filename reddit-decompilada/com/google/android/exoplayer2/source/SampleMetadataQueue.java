package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput.CryptoData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class SampleMetadataQueue {
    public int[] f4759a = new int[this.f4770l];
    int f4760b;
    int f4761c;
    int f4762d;
    public int f4763e;
    long f4764f = Long.MIN_VALUE;
    long f4765g = Long.MIN_VALUE;
    boolean f4766h = true;
    boolean f4767i = true;
    Format f4768j;
    public int f4769k;
    private int f4770l = 1000;
    private long[] f4771m = new long[this.f4770l];
    private int[] f4772n = new int[this.f4770l];
    private int[] f4773o = new int[this.f4770l];
    private long[] f4774p = new long[this.f4770l];
    private CryptoData[] f4775q = new CryptoData[this.f4770l];
    private Format[] f4776r = new Format[this.f4770l];

    public static final class SampleExtrasHolder {
        public int f4756a;
        public long f4757b;
        public CryptoData f4758c;
    }

    public final int m3947a() {
        return this.f4761c + this.f4760b;
    }

    public final long m3949a(int i) {
        int a = m3947a() - i;
        boolean z = a >= 0 && a <= this.f4760b - this.f4763e;
        Assertions.m4184a(z);
        this.f4760b -= a;
        this.f4765g = Math.max(this.f4764f, m3946d(this.f4760b));
        if (this.f4760b == 0) {
            return 0;
        }
        i = m3955b(this.f4760b - 1);
        return this.f4771m[i] + ((long) this.f4772n[i]);
    }

    public final synchronized boolean m3956b() {
        return this.f4763e != this.f4760b;
    }

    public final synchronized Format m3957c() {
        if (this.f4767i) {
            return null;
        }
        return this.f4768j;
    }

    public final synchronized long m3958d() {
        return this.f4765g;
    }

    public final synchronized void m3959e() {
        this.f4763e = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int m3948a(com.google.android.exoplayer2.FormatHolder r5, com.google.android.exoplayer2.decoder.DecoderInputBuffer r6, boolean r7, boolean r8, com.google.android.exoplayer2.Format r9, com.google.android.exoplayer2.source.SampleMetadataQueue.SampleExtrasHolder r10) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.m3956b();	 Catch:{ all -> 0x006f }
        r1 = -3;
        r2 = -5;
        r3 = -4;
        if (r0 != 0) goto L_0x0023;
    L_0x000a:
        if (r8 == 0) goto L_0x0011;
    L_0x000c:
        r5 = 4;
        r6.f4220a = r5;	 Catch:{ all -> 0x006f }
        monitor-exit(r4);
        return r3;
    L_0x0011:
        r6 = r4.f4768j;	 Catch:{ all -> 0x006f }
        if (r6 == 0) goto L_0x0021;
    L_0x0015:
        if (r7 != 0) goto L_0x001b;
    L_0x0017:
        r6 = r4.f4768j;	 Catch:{ all -> 0x006f }
        if (r6 == r9) goto L_0x0021;
    L_0x001b:
        r6 = r4.f4768j;	 Catch:{ all -> 0x006f }
        r5.f4039a = r6;	 Catch:{ all -> 0x006f }
        monitor-exit(r4);
        return r2;
    L_0x0021:
        monitor-exit(r4);
        return r1;
    L_0x0023:
        r8 = r4.f4763e;	 Catch:{ all -> 0x006f }
        r8 = r4.m3955b(r8);	 Catch:{ all -> 0x006f }
        if (r7 != 0) goto L_0x0067;
    L_0x002b:
        r7 = r4.f4776r;	 Catch:{ all -> 0x006f }
        r7 = r7[r8];	 Catch:{ all -> 0x006f }
        if (r7 == r9) goto L_0x0032;
    L_0x0031:
        goto L_0x0067;
    L_0x0032:
        r5 = r6.f12800c;	 Catch:{ all -> 0x006f }
        r7 = 1;
        if (r5 != 0) goto L_0x003d;
    L_0x0037:
        r5 = r6.f12802e;	 Catch:{ all -> 0x006f }
        if (r5 != 0) goto L_0x003d;
    L_0x003b:
        r5 = r7;
        goto L_0x003e;
    L_0x003d:
        r5 = 0;
    L_0x003e:
        if (r5 == 0) goto L_0x0042;
    L_0x0040:
        monitor-exit(r4);
        return r1;
    L_0x0042:
        r5 = r4.f4774p;	 Catch:{ all -> 0x006f }
        r0 = r5[r8];	 Catch:{ all -> 0x006f }
        r6.f12801d = r0;	 Catch:{ all -> 0x006f }
        r5 = r4.f4773o;	 Catch:{ all -> 0x006f }
        r5 = r5[r8];	 Catch:{ all -> 0x006f }
        r6.f4220a = r5;	 Catch:{ all -> 0x006f }
        r5 = r4.f4772n;	 Catch:{ all -> 0x006f }
        r5 = r5[r8];	 Catch:{ all -> 0x006f }
        r10.f4756a = r5;	 Catch:{ all -> 0x006f }
        r5 = r4.f4771m;	 Catch:{ all -> 0x006f }
        r0 = r5[r8];	 Catch:{ all -> 0x006f }
        r10.f4757b = r0;	 Catch:{ all -> 0x006f }
        r5 = r4.f4775q;	 Catch:{ all -> 0x006f }
        r5 = r5[r8];	 Catch:{ all -> 0x006f }
        r10.f4758c = r5;	 Catch:{ all -> 0x006f }
        r5 = r4.f4763e;	 Catch:{ all -> 0x006f }
        r5 = r5 + r7;
        r4.f4763e = r5;	 Catch:{ all -> 0x006f }
        monitor-exit(r4);
        return r3;
    L_0x0067:
        r6 = r4.f4776r;	 Catch:{ all -> 0x006f }
        r6 = r6[r8];	 Catch:{ all -> 0x006f }
        r5.f4039a = r6;	 Catch:{ all -> 0x006f }
        monitor-exit(r4);
        return r2;
    L_0x006f:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleMetadataQueue.a(com.google.android.exoplayer2.FormatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer, boolean, boolean, com.google.android.exoplayer2.Format, com.google.android.exoplayer2.source.SampleMetadataQueue$SampleExtrasHolder):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean m3953a(long r9, boolean r11) {
        /*
        r8 = this;
        monitor-enter(r8);
        r0 = r8.f4763e;	 Catch:{ all -> 0x003b }
        r2 = r8.m3955b(r0);	 Catch:{ all -> 0x003b }
        r0 = r8.m3956b();	 Catch:{ all -> 0x003b }
        r7 = 0;
        if (r0 == 0) goto L_0x0039;
    L_0x000e:
        r0 = r8.f4774p;	 Catch:{ all -> 0x003b }
        r3 = r0[r2];	 Catch:{ all -> 0x003b }
        r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1));
        if (r0 < 0) goto L_0x0039;
    L_0x0016:
        r0 = r8.f4765g;	 Catch:{ all -> 0x003b }
        r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x001f;
    L_0x001c:
        if (r11 != 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0039;
    L_0x001f:
        r11 = r8.f4760b;	 Catch:{ all -> 0x003b }
        r0 = r8.f4763e;	 Catch:{ all -> 0x003b }
        r3 = r11 - r0;
        r6 = 1;
        r1 = r8;
        r4 = r9;
        r9 = r1.m3943a(r2, r3, r4, r6);	 Catch:{ all -> 0x003b }
        r10 = -1;
        if (r9 != r10) goto L_0x0031;
    L_0x002f:
        monitor-exit(r8);
        return r7;
    L_0x0031:
        r10 = r8.f4763e;	 Catch:{ all -> 0x003b }
        r10 = r10 + r9;
        r8.f4763e = r10;	 Catch:{ all -> 0x003b }
        r9 = 1;
        monitor-exit(r8);
        return r9;
    L_0x0039:
        monitor-exit(r8);
        return r7;
    L_0x003b:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleMetadataQueue.a(long, boolean):boolean");
    }

    public final synchronized void m3960f() {
        if (m3956b()) {
            this.f4763e = this.f4760b;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long m3950a(long r10, boolean r12, boolean r13) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = r9.f4760b;	 Catch:{ all -> 0x0038 }
        r1 = -1;
        if (r0 == 0) goto L_0x0036;
    L_0x0007:
        r0 = r9.f4774p;	 Catch:{ all -> 0x0038 }
        r3 = r9.f4762d;	 Catch:{ all -> 0x0038 }
        r3 = r0[r3];	 Catch:{ all -> 0x0038 }
        r0 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1));
        if (r0 >= 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0036;
    L_0x0012:
        if (r13 == 0) goto L_0x001f;
    L_0x0014:
        r13 = r9.f4763e;	 Catch:{ all -> 0x0038 }
        r0 = r9.f4760b;	 Catch:{ all -> 0x0038 }
        if (r13 == r0) goto L_0x001f;
    L_0x001a:
        r13 = r9.f4763e;	 Catch:{ all -> 0x0038 }
        r13 = r13 + 1;
        goto L_0x0021;
    L_0x001f:
        r13 = r9.f4760b;	 Catch:{ all -> 0x0038 }
    L_0x0021:
        r5 = r13;
        r4 = r9.f4762d;	 Catch:{ all -> 0x0038 }
        r3 = r9;
        r6 = r10;
        r8 = r12;
        r10 = r3.m3943a(r4, r5, r6, r8);	 Catch:{ all -> 0x0038 }
        r11 = -1;
        if (r10 != r11) goto L_0x0030;
    L_0x002e:
        monitor-exit(r9);
        return r1;
    L_0x0030:
        r10 = r9.m3945c(r10);	 Catch:{ all -> 0x0038 }
        monitor-exit(r9);
        return r10;
    L_0x0036:
        monitor-exit(r9);
        return r1;
    L_0x0038:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleMetadataQueue.a(long, boolean, boolean):long");
    }

    public final synchronized long m3961g() {
        if (this.f4763e == 0) {
            return -1;
        }
        return m3945c(this.f4763e);
    }

    public final synchronized long m3962h() {
        if (this.f4760b == 0) {
            return -1;
        }
        return m3945c(this.f4760b);
    }

    public final synchronized boolean m3954a(Format format) {
        if (format == null) {
            this.f4767i = true;
            return false;
        }
        this.f4767i = false;
        if (Util.m4313a((Object) format, this.f4768j)) {
            return false;
        }
        this.f4768j = format;
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m3951a(long r6, int r8, long r9, int r11, com.google.android.exoplayer2.extractor.TrackOutput.CryptoData r12) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.f4766h;	 Catch:{ all -> 0x00cf }
        r1 = 0;
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = r8 & 1;
        if (r0 != 0) goto L_0x000c;
    L_0x000a:
        monitor-exit(r5);
        return;
    L_0x000c:
        r5.f4766h = r1;	 Catch:{ all -> 0x00cf }
    L_0x000e:
        r0 = r5.f4767i;	 Catch:{ all -> 0x00cf }
        r0 = r0 ^ 1;
        com.google.android.exoplayer2.util.Assertions.m4186b(r0);	 Catch:{ all -> 0x00cf }
        r5.m3944b(r6);	 Catch:{ all -> 0x00cf }
        r0 = r5.f4760b;	 Catch:{ all -> 0x00cf }
        r0 = r5.m3955b(r0);	 Catch:{ all -> 0x00cf }
        r2 = r5.f4774p;	 Catch:{ all -> 0x00cf }
        r2[r0] = r6;	 Catch:{ all -> 0x00cf }
        r6 = r5.f4771m;	 Catch:{ all -> 0x00cf }
        r6[r0] = r9;	 Catch:{ all -> 0x00cf }
        r6 = r5.f4772n;	 Catch:{ all -> 0x00cf }
        r6[r0] = r11;	 Catch:{ all -> 0x00cf }
        r6 = r5.f4773o;	 Catch:{ all -> 0x00cf }
        r6[r0] = r8;	 Catch:{ all -> 0x00cf }
        r6 = r5.f4775q;	 Catch:{ all -> 0x00cf }
        r6[r0] = r12;	 Catch:{ all -> 0x00cf }
        r6 = r5.f4776r;	 Catch:{ all -> 0x00cf }
        r7 = r5.f4768j;	 Catch:{ all -> 0x00cf }
        r6[r0] = r7;	 Catch:{ all -> 0x00cf }
        r6 = r5.f4759a;	 Catch:{ all -> 0x00cf }
        r7 = r5.f4769k;	 Catch:{ all -> 0x00cf }
        r6[r0] = r7;	 Catch:{ all -> 0x00cf }
        r6 = r5.f4760b;	 Catch:{ all -> 0x00cf }
        r6 = r6 + 1;
        r5.f4760b = r6;	 Catch:{ all -> 0x00cf }
        r6 = r5.f4760b;	 Catch:{ all -> 0x00cf }
        r7 = r5.f4770l;	 Catch:{ all -> 0x00cf }
        if (r6 != r7) goto L_0x00cd;
    L_0x004a:
        r6 = r5.f4770l;	 Catch:{ all -> 0x00cf }
        r6 = r6 + 1000;
        r7 = new int[r6];	 Catch:{ all -> 0x00cf }
        r8 = new long[r6];	 Catch:{ all -> 0x00cf }
        r9 = new long[r6];	 Catch:{ all -> 0x00cf }
        r10 = new int[r6];	 Catch:{ all -> 0x00cf }
        r11 = new int[r6];	 Catch:{ all -> 0x00cf }
        r12 = new com.google.android.exoplayer2.extractor.TrackOutput.CryptoData[r6];	 Catch:{ all -> 0x00cf }
        r0 = new com.google.android.exoplayer2.Format[r6];	 Catch:{ all -> 0x00cf }
        r2 = r5.f4770l;	 Catch:{ all -> 0x00cf }
        r3 = r5.f4762d;	 Catch:{ all -> 0x00cf }
        r2 = r2 - r3;
        r3 = r5.f4771m;	 Catch:{ all -> 0x00cf }
        r4 = r5.f4762d;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r8, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f4774p;	 Catch:{ all -> 0x00cf }
        r4 = r5.f4762d;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r9, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f4773o;	 Catch:{ all -> 0x00cf }
        r4 = r5.f4762d;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r10, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f4772n;	 Catch:{ all -> 0x00cf }
        r4 = r5.f4762d;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r11, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f4775q;	 Catch:{ all -> 0x00cf }
        r4 = r5.f4762d;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r12, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f4776r;	 Catch:{ all -> 0x00cf }
        r4 = r5.f4762d;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r0, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f4759a;	 Catch:{ all -> 0x00cf }
        r4 = r5.f4762d;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r3, r4, r7, r1, r2);	 Catch:{ all -> 0x00cf }
        r3 = r5.f4762d;	 Catch:{ all -> 0x00cf }
        r4 = r5.f4771m;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r8, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f4774p;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r9, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f4773o;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r10, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f4772n;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r11, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f4775q;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r12, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f4776r;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r0, r2, r3);	 Catch:{ all -> 0x00cf }
        r4 = r5.f4759a;	 Catch:{ all -> 0x00cf }
        java.lang.System.arraycopy(r4, r1, r7, r2, r3);	 Catch:{ all -> 0x00cf }
        r5.f4771m = r8;	 Catch:{ all -> 0x00cf }
        r5.f4774p = r9;	 Catch:{ all -> 0x00cf }
        r5.f4773o = r10;	 Catch:{ all -> 0x00cf }
        r5.f4772n = r11;	 Catch:{ all -> 0x00cf }
        r5.f4775q = r12;	 Catch:{ all -> 0x00cf }
        r5.f4776r = r0;	 Catch:{ all -> 0x00cf }
        r5.f4759a = r7;	 Catch:{ all -> 0x00cf }
        r5.f4762d = r1;	 Catch:{ all -> 0x00cf }
        r7 = r5.f4770l;	 Catch:{ all -> 0x00cf }
        r5.f4760b = r7;	 Catch:{ all -> 0x00cf }
        r5.f4770l = r6;	 Catch:{ all -> 0x00cf }
    L_0x00cd:
        monitor-exit(r5);
        return;
    L_0x00cf:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleMetadataQueue.a(long, int, long, int, com.google.android.exoplayer2.extractor.TrackOutput$CryptoData):void");
    }

    private synchronized void m3944b(long j) {
        this.f4765g = Math.max(this.f4765g, j);
    }

    public final synchronized boolean m3952a(long j) {
        if (this.f4760b == 0) {
            return j > this.f4764f;
        } else {
            if (Math.max(this.f4764f, m3946d(this.f4763e)) >= j) {
                return false;
            }
            int i = this.f4760b;
            int b = m3955b(this.f4760b - 1);
            while (i > this.f4763e && this.f4774p[b] >= j) {
                i--;
                b--;
                if (b == -1) {
                    b = this.f4770l - 1;
                }
            }
            m3949a(this.f4761c + i);
            return true;
        }
    }

    private int m3943a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = i;
        for (i = 0; i < i2 && this.f4774p[i4] <= j; i++) {
            if (!(z && (this.f4773o[i4] & 1) == 0)) {
                i3 = i;
            }
            i4++;
            if (i4 == this.f4770l) {
                i4 = 0;
            }
        }
        return i3;
    }

    private long m3945c(int i) {
        this.f4764f = Math.max(this.f4764f, m3946d(i));
        this.f4760b -= i;
        this.f4761c += i;
        this.f4762d += i;
        if (this.f4762d >= this.f4770l) {
            this.f4762d -= this.f4770l;
        }
        this.f4763e -= i;
        if (this.f4763e < 0) {
            this.f4763e = 0;
        }
        if (this.f4760b != 0) {
            return this.f4771m[this.f4762d];
        }
        i = (this.f4762d == 0 ? this.f4770l : this.f4762d) - 1;
        return this.f4771m[i] + ((long) this.f4772n[i]);
    }

    private long m3946d(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int b = m3955b(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.f4774p[b]);
            if ((this.f4773o[b] & 1) != 0) {
                break;
            }
            b--;
            if (b == -1) {
                b = this.f4770l - 1;
            }
        }
        return j;
    }

    public final int m3955b(int i) {
        int i2 = this.f4762d + i;
        return i2 < this.f4770l ? i2 : i2 - this.f4770l;
    }
}
