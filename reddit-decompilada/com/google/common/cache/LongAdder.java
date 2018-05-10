package com.google.common.cache;

import java.io.Serializable;

final class LongAdder extends Striped64 implements LongAddable, Serializable {
    final long mo2382a(long j, long j2) {
        return j + j2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo2380a(long r18) {
        /*
        r17 = this;
        r1 = r17;
        r2 = r18;
        r4 = r1.d;
        if (r4 != 0) goto L_0x0012;
    L_0x0008:
        r5 = r1.e;
        r7 = r5 + r2;
        r5 = r1.m7074b(r5, r7);
        if (r5 != 0) goto L_0x0132;
    L_0x0012:
        r5 = a;
        r5 = r5.get();
        r5 = (int[]) r5;
        r6 = 1;
        r7 = 0;
        if (r5 == 0) goto L_0x0036;
    L_0x001e:
        if (r4 == 0) goto L_0x0036;
    L_0x0020:
        r8 = r4.length;
        if (r8 <= 0) goto L_0x0036;
    L_0x0023:
        r8 = r8 - r6;
        r9 = r5[r7];
        r8 = r8 & r9;
        r4 = r4[r8];
        if (r4 == 0) goto L_0x0036;
    L_0x002b:
        r8 = r4.f8362a;
        r10 = r8 + r2;
        r4 = r4.m7070a(r8, r10);
        if (r4 != 0) goto L_0x0132;
    L_0x0035:
        goto L_0x0037;
    L_0x0036:
        r4 = r6;
    L_0x0037:
        if (r5 != 0) goto L_0x004c;
    L_0x0039:
        r5 = com.google.common.cache.Striped64.f8363a;
        r8 = new int[r6];
        r5.set(r8);
        r5 = com.google.common.cache.Striped64.f8364b;
        r5 = r5.nextInt();
        if (r5 != 0) goto L_0x0049;
    L_0x0048:
        r5 = r6;
    L_0x0049:
        r8[r7] = r5;
        goto L_0x0053;
    L_0x004c:
        r8 = r5[r7];
        r16 = r8;
        r8 = r5;
        r5 = r16;
    L_0x0053:
        r9 = r7;
    L_0x0054:
        r10 = r1.f8369d;
        if (r10 == 0) goto L_0x00f1;
    L_0x0058:
        r11 = r10.length;
        if (r11 <= 0) goto L_0x00f1;
    L_0x005b:
        r12 = r11 + -1;
        r12 = r12 & r5;
        r12 = r10[r12];
        if (r12 != 0) goto L_0x0097;
    L_0x0062:
        r10 = r1.f8371f;
        if (r10 != 0) goto L_0x0095;
    L_0x0066:
        r10 = new com.google.common.cache.Striped64$Cell;
        r10.<init>(r2);
        r11 = r1.f8371f;
        if (r11 != 0) goto L_0x0095;
    L_0x006f:
        r11 = r17.m7075c();
        if (r11 == 0) goto L_0x0095;
    L_0x0075:
        r11 = r1.f8369d;	 Catch:{ all -> 0x0090 }
        if (r11 == 0) goto L_0x0087;
    L_0x0079:
        r12 = r11.length;	 Catch:{ all -> 0x0090 }
        if (r12 <= 0) goto L_0x0087;
    L_0x007c:
        r12 = r12 + -1;
        r12 = r12 & r5;
        r13 = r11[r12];	 Catch:{ all -> 0x0090 }
        if (r13 != 0) goto L_0x0087;
    L_0x0083:
        r11[r12] = r10;	 Catch:{ all -> 0x0090 }
        r10 = r6;
        goto L_0x0088;
    L_0x0087:
        r10 = r7;
    L_0x0088:
        r1.f8371f = r7;
        if (r10 == 0) goto L_0x008d;
    L_0x008c:
        return;
    L_0x008d:
        r6 = r7;
        goto L_0x0133;
    L_0x0090:
        r0 = move-exception;
        r2 = r0;
        r1.f8371f = r7;
        throw r2;
    L_0x0095:
        r9 = r7;
        goto L_0x00e4;
    L_0x0097:
        if (r4 != 0) goto L_0x009b;
    L_0x0099:
        r4 = r6;
        goto L_0x00e4;
    L_0x009b:
        r13 = r12.f8362a;
        r6 = r1.mo2382a(r13, r2);
        r6 = r12.m7070a(r13, r6);
        if (r6 != 0) goto L_0x0132;
    L_0x00a7:
        r6 = com.google.common.cache.Striped64.f8365c;
        if (r11 >= r6) goto L_0x00e3;
    L_0x00ab:
        r6 = r1.f8369d;
        if (r6 == r10) goto L_0x00b0;
    L_0x00af:
        goto L_0x00e3;
    L_0x00b0:
        if (r9 != 0) goto L_0x00b4;
    L_0x00b2:
        r9 = 1;
        goto L_0x00e4;
    L_0x00b4:
        r6 = r1.f8371f;
        if (r6 != 0) goto L_0x00e4;
    L_0x00b8:
        r6 = r17.m7075c();
        if (r6 == 0) goto L_0x00e4;
    L_0x00be:
        r6 = r1.f8369d;	 Catch:{ all -> 0x00dd }
        if (r6 != r10) goto L_0x00d7;
    L_0x00c2:
        r6 = r11 << 1;
        r6 = new com.google.common.cache.Striped64.Cell[r6];	 Catch:{ all -> 0x00d3 }
        r7 = 0;
    L_0x00c7:
        if (r7 >= r11) goto L_0x00d0;
    L_0x00c9:
        r9 = r10[r7];	 Catch:{ all -> 0x00d3 }
        r6[r7] = r9;	 Catch:{ all -> 0x00d3 }
        r7 = r7 + 1;
        goto L_0x00c7;
    L_0x00d0:
        r1.f8369d = r6;	 Catch:{ all -> 0x00d3 }
        goto L_0x00d7;
    L_0x00d3:
        r0 = move-exception;
        r2 = r0;
        r6 = 0;
        goto L_0x00e0;
    L_0x00d7:
        r6 = 0;
        r1.f8371f = r6;
        r7 = r6;
        r9 = r7;
        goto L_0x0134;
    L_0x00dd:
        r0 = move-exception;
        r6 = 0;
        r2 = r0;
    L_0x00e0:
        r1.f8371f = r6;
        throw r2;
    L_0x00e3:
        r9 = 0;
    L_0x00e4:
        r6 = r5 << 13;
        r5 = r5 ^ r6;
        r6 = r5 >>> 17;
        r5 = r5 ^ r6;
        r6 = r5 << 5;
        r5 = r5 ^ r6;
        r6 = 0;
        r8[r6] = r5;
        goto L_0x0133;
    L_0x00f1:
        r6 = r1.f8371f;
        if (r6 != 0) goto L_0x0125;
    L_0x00f5:
        r6 = r1.f8369d;
        if (r6 != r10) goto L_0x0125;
    L_0x00f9:
        r6 = r17.m7075c();
        if (r6 == 0) goto L_0x0125;
    L_0x00ff:
        r6 = r1.f8369d;	 Catch:{ all -> 0x011f }
        if (r6 != r10) goto L_0x0118;
    L_0x0103:
        r6 = 2;
        r6 = new com.google.common.cache.Striped64.Cell[r6];	 Catch:{ all -> 0x0114 }
        r7 = r5 & 1;
        r10 = new com.google.common.cache.Striped64$Cell;	 Catch:{ all -> 0x0114 }
        r10.<init>(r2);	 Catch:{ all -> 0x0114 }
        r6[r7] = r10;	 Catch:{ all -> 0x0114 }
        r1.f8369d = r6;	 Catch:{ all -> 0x0114 }
        r6 = 0;
        r15 = 1;
        goto L_0x011a;
    L_0x0114:
        r0 = move-exception;
        r2 = r0;
        r6 = 0;
        goto L_0x0122;
    L_0x0118:
        r6 = 0;
        r15 = 0;
    L_0x011a:
        r1.f8371f = r6;
        if (r15 != 0) goto L_0x0132;
    L_0x011e:
        goto L_0x0133;
    L_0x011f:
        r0 = move-exception;
        r6 = 0;
        r2 = r0;
    L_0x0122:
        r1.f8371f = r6;
        throw r2;
    L_0x0125:
        r6 = 0;
        r10 = r1.f8370e;
        r12 = r1.mo2382a(r10, r2);
        r7 = r1.m7074b(r10, r12);
        if (r7 == 0) goto L_0x0133;
    L_0x0132:
        return;
    L_0x0133:
        r7 = r6;
    L_0x0134:
        r6 = 1;
        goto L_0x0054;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LongAdder.a(long):void");
    }

    public final void mo2379a() {
        mo2380a(1);
    }

    public final long mo2381b() {
        long j = this.e;
        Cell[] cellArr = this.d;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    j += cell.f8362a;
                }
            }
        }
        return j;
    }

    public final String toString() {
        return Long.toString(mo2381b());
    }

    public final long longValue() {
        return mo2381b();
    }

    public final int intValue() {
        return (int) mo2381b();
    }

    public final float floatValue() {
        return (float) mo2381b();
    }

    public final double doubleValue() {
        return (double) mo2381b();
    }
}
