package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ByteArrayPool {
    protected static final Comparator<byte[]> f2815a = new C02461();
    private List<byte[]> f2816b = new LinkedList();
    private List<byte[]> f2817c = new ArrayList(64);
    private int f2818d = 0;
    private final int f2819e;

    static class C02461 implements Comparator<byte[]> {
        C02461() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((byte[]) obj).length - ((byte[]) obj2).length;
        }
    }

    public ByteArrayPool(int i) {
        this.f2819e = i;
    }

    public final synchronized byte[] m2462a(int i) {
        for (int i2 = 0; i2 < this.f2817c.size(); i2++) {
            byte[] bArr = (byte[]) this.f2817c.get(i2);
            if (bArr.length >= i) {
                this.f2818d -= bArr.length;
                this.f2817c.remove(i2);
                this.f2816b.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m2461a(byte[] r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        if (r3 == 0) goto L_0x002e;
    L_0x0003:
        r0 = r3.length;	 Catch:{ all -> 0x002b }
        r1 = r2.f2819e;	 Catch:{ all -> 0x002b }
        if (r0 <= r1) goto L_0x0009;
    L_0x0008:
        goto L_0x002e;
    L_0x0009:
        r0 = r2.f2816b;	 Catch:{ all -> 0x002b }
        r0.add(r3);	 Catch:{ all -> 0x002b }
        r0 = r2.f2817c;	 Catch:{ all -> 0x002b }
        r1 = f2815a;	 Catch:{ all -> 0x002b }
        r0 = java.util.Collections.binarySearch(r0, r3, r1);	 Catch:{ all -> 0x002b }
        if (r0 >= 0) goto L_0x001b;
    L_0x0018:
        r0 = -r0;
        r0 = r0 + -1;
    L_0x001b:
        r1 = r2.f2817c;	 Catch:{ all -> 0x002b }
        r1.add(r0, r3);	 Catch:{ all -> 0x002b }
        r0 = r2.f2818d;	 Catch:{ all -> 0x002b }
        r3 = r3.length;	 Catch:{ all -> 0x002b }
        r0 = r0 + r3;
        r2.f2818d = r0;	 Catch:{ all -> 0x002b }
        r2.m2460a();	 Catch:{ all -> 0x002b }
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
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.ByteArrayPool.a(byte[]):void");
    }

    private synchronized void m2460a() {
        while (this.f2818d > this.f2819e) {
            byte[] bArr = (byte[]) this.f2816b.remove(0);
            this.f2817c.remove(bArr);
            this.f2818d -= bArr.length;
        }
    }
}
