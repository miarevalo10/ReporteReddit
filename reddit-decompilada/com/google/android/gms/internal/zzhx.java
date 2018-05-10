package com.google.android.gms.internal;

import java.util.PriorityQueue;

@zzzv
public final class zzhx {
    private static long m6304a(long j, int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return j;
        }
        return (i % 2 == 0 ? m6304a((j * j) % 1073807359, i / 2) : j * (m6304a((j * j) % 1073807359, i / 2) % 1073807359)) % 1073807359;
    }

    private static long m6305a(String[] strArr, int i) {
        long a = (((long) zzhu.m6301a(strArr[0])) + 2147483647L) % 1073807359;
        for (int i2 = 1; i2 < i; i2++) {
            a = (((a * 16785407) % 1073807359) + ((((long) zzhu.m6301a(strArr[i2])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return a;
    }

    private static String m6306a(String[] strArr, int i, int i2) {
        i2 += i;
        if (strArr.length < i2) {
            zzakb.m5368c("Unable to construct shingle");
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int i3 = i2 - 1;
            if (i < i3) {
                stringBuffer.append(strArr[i]);
                stringBuffer.append(' ');
                i++;
            } else {
                stringBuffer.append(strArr[i3]);
                return stringBuffer.toString();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m6307a(int r1, long r2, java.lang.String r4, int r5, java.util.PriorityQueue<com.google.android.gms.internal.zzhy> r6) {
        /*
        r0 = new com.google.android.gms.internal.zzhy;
        r0.<init>(r2, r4, r5);
        r2 = r6.size();
        if (r2 != r1) goto L_0x0026;
    L_0x000b:
        r2 = r6.peek();
        r2 = (com.google.android.gms.internal.zzhy) r2;
        r2 = r2.f7711c;
        r3 = r0.f7711c;
        if (r2 > r3) goto L_0x0025;
    L_0x0017:
        r2 = r6.peek();
        r2 = (com.google.android.gms.internal.zzhy) r2;
        r2 = r2.f7709a;
        r4 = r0.f7709a;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0026;
    L_0x0025:
        return;
    L_0x0026:
        r2 = r6.contains(r0);
        if (r2 == 0) goto L_0x002d;
    L_0x002c:
        return;
    L_0x002d:
        r6.add(r0);
        r2 = r6.size();
        if (r2 <= r1) goto L_0x0039;
    L_0x0036:
        r6.poll();
    L_0x0039:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzhx.a(int, long, java.lang.String, int, java.util.PriorityQueue):void");
    }

    public static void m6308a(String[] strArr, int i, int i2, PriorityQueue<zzhy> priorityQueue) {
        String[] strArr2 = strArr;
        int i3 = i2;
        if (strArr2.length < i3) {
            m6307a(i, m6305a(strArr2, strArr2.length), m6306a(strArr2, 0, strArr2.length), strArr2.length, priorityQueue);
            return;
        }
        long a = m6305a(strArr2, i3);
        m6307a(i, a, m6306a(strArr2, 0, i3), i3, priorityQueue);
        long a2 = m6304a(16785407, i3 - 1);
        for (int i4 = 1; i4 < (strArr2.length - i3) + 1; i4++) {
            a += 1073807359;
            a = (((((a - ((((((long) zzhu.m6301a(strArr2[i4 - 1])) + 2147483647L) % 1073807359) * a2) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((((long) zzhu.m6301a(strArr2[(i4 + i3) - 1])) + 2147483647L) % 1073807359)) % 1073807359;
            m6307a(i, a, m6306a(strArr2, i4, i3), strArr2.length, priorityQueue);
        }
    }
}
