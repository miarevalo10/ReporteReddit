package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class DefaultAllocator implements Allocator {
    private final boolean f13641a;
    private final int f13642b;
    private final byte[] f13643c;
    private final Allocation[] f13644d;
    private int f13645e;
    private int f13646f;
    private int f13647g;
    private Allocation[] f13648h;

    public DefaultAllocator() {
        this((byte) 0);
    }

    private DefaultAllocator(byte b) {
        Assertions.m4184a(true);
        Assertions.m4184a(true);
        this.f13641a = true;
        this.f13642b = 65536;
        this.f13647g = 0;
        this.f13648h = new Allocation[100];
        this.f13643c = null;
        this.f13644d = new Allocation[1];
    }

    public final synchronized void m12670d() {
        if (this.f13641a) {
            m12665a(0);
        }
    }

    public final synchronized void m12665a(int i) {
        Object obj = i < this.f13645e ? 1 : null;
        this.f13645e = i;
        if (obj != null) {
            mo1469b();
        }
    }

    public final synchronized Allocation mo1466a() {
        Allocation allocation;
        this.f13646f++;
        if (this.f13647g > 0) {
            Allocation[] allocationArr = this.f13648h;
            int i = this.f13647g - 1;
            this.f13647g = i;
            allocation = allocationArr[i];
            this.f13648h[this.f13647g] = null;
        } else {
            allocation = new Allocation(new byte[this.f13642b]);
        }
        return allocation;
    }

    public final synchronized void mo1467a(Allocation allocation) {
        this.f13644d[0] = allocation;
        mo1468a(this.f13644d);
    }

    public final synchronized void mo1468a(Allocation[] allocationArr) {
        if (this.f13647g + allocationArr.length >= this.f13648h.length) {
            this.f13648h = (Allocation[]) Arrays.copyOf(this.f13648h, Math.max(this.f13648h.length * 2, this.f13647g + allocationArr.length));
        }
        for (Allocation allocation : allocationArr) {
            boolean z;
            Allocation[] allocationArr2;
            int i;
            if (allocation.f5158a != this.f13643c) {
                if (allocation.f5158a.length != this.f13642b) {
                    z = false;
                    Assertions.m4184a(z);
                    allocationArr2 = this.f13648h;
                    i = this.f13647g;
                    this.f13647g = i + 1;
                    allocationArr2[i] = allocation;
                }
            }
            z = true;
            Assertions.m4184a(z);
            allocationArr2 = this.f13648h;
            i = this.f13647g;
            this.f13647g = i + 1;
            allocationArr2[i] = allocation;
        }
        this.f13646f -= allocationArr.length;
        notifyAll();
    }

    public final synchronized void mo1469b() {
        int i = 0;
        int max = Math.max(0, Util.m4296a(this.f13645e, this.f13642b) - this.f13646f);
        if (max < this.f13647g) {
            if (this.f13643c != null) {
                int i2 = this.f13647g - 1;
                while (i <= i2) {
                    Allocation allocation = this.f13648h[i];
                    if (allocation.f5158a == this.f13643c) {
                        i++;
                    } else {
                        Allocation allocation2 = this.f13648h[i2];
                        if (allocation2.f5158a != this.f13643c) {
                            i2--;
                        } else {
                            int i3 = i + 1;
                            this.f13648h[i] = allocation2;
                            int i4 = i2 - 1;
                            this.f13648h[i2] = allocation;
                            i2 = i4;
                            i = i3;
                        }
                    }
                }
                max = Math.max(max, i);
                if (max >= this.f13647g) {
                    return;
                }
            }
            Arrays.fill(this.f13648h, max, this.f13647g, null);
            this.f13647g = max;
        }
    }

    public final synchronized int m12671e() {
        return this.f13646f * this.f13642b;
    }

    public final int mo1470c() {
        return this.f13642b;
    }
}
