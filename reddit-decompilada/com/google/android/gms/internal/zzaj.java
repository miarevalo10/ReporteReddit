package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class zzaj {
    private static Comparator<byte[]> f6438e = new zzak();
    private final List<byte[]> f6439a = new LinkedList();
    private final List<byte[]> f6440b = new ArrayList(64);
    private int f6441c = 0;
    private final int f6442d = 4096;

    private final synchronized void m5295a() {
        while (this.f6441c > this.f6442d) {
            byte[] bArr = (byte[]) this.f6439a.remove(0);
            this.f6440b.remove(bArr);
            this.f6441c -= bArr.length;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m5296a(byte[] r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        if (r3 == 0) goto L_0x002e;
    L_0x0003:
        r0 = r3.length;	 Catch:{ all -> 0x002b }
        r1 = r2.f6442d;	 Catch:{ all -> 0x002b }
        if (r0 <= r1) goto L_0x0009;
    L_0x0008:
        goto L_0x002e;
    L_0x0009:
        r0 = r2.f6439a;	 Catch:{ all -> 0x002b }
        r0.add(r3);	 Catch:{ all -> 0x002b }
        r0 = r2.f6440b;	 Catch:{ all -> 0x002b }
        r1 = f6438e;	 Catch:{ all -> 0x002b }
        r0 = java.util.Collections.binarySearch(r0, r3, r1);	 Catch:{ all -> 0x002b }
        if (r0 >= 0) goto L_0x001b;
    L_0x0018:
        r0 = -r0;
        r0 = r0 + -1;
    L_0x001b:
        r1 = r2.f6440b;	 Catch:{ all -> 0x002b }
        r1.add(r0, r3);	 Catch:{ all -> 0x002b }
        r0 = r2.f6441c;	 Catch:{ all -> 0x002b }
        r3 = r3.length;	 Catch:{ all -> 0x002b }
        r0 = r0 + r3;
        r2.f6441c = r0;	 Catch:{ all -> 0x002b }
        r2.m5295a();	 Catch:{ all -> 0x002b }
        monitor-exit(r2);
        return;
    L_0x002b:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
    L_0x002e:
        monitor-exit(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaj.a(byte[]):void");
    }

    public final synchronized byte[] m5297a(int i) {
        for (int i2 = 0; i2 < this.f6440b.size(); i2++) {
            byte[] bArr = (byte[]) this.f6440b.get(i2);
            if (bArr.length >= i) {
                this.f6441c -= bArr.length;
                this.f6440b.remove(i2);
                this.f6439a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }
}
