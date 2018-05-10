package com.google.android.exoplayer2;

import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;

public final class DefaultLoadControl implements LoadControl {
    private final DefaultAllocator f12756a;
    private final long f12757b;
    private final long f12758c;
    private final long f12759d;
    private final long f12760e;
    private final PriorityTaskManager f12761f;
    private int f12762g;
    private boolean f12763h;

    public DefaultLoadControl() {
        this(new DefaultAllocator());
    }

    private DefaultLoadControl(DefaultAllocator defaultAllocator) {
        this(defaultAllocator, (byte) 0);
    }

    private DefaultLoadControl(DefaultAllocator defaultAllocator, byte b) {
        this(defaultAllocator, (char) (byte) 0);
    }

    private DefaultLoadControl(DefaultAllocator defaultAllocator, char c) {
        this.f12756a = defaultAllocator;
        this.f12757b = 15000000;
        this.f12758c = 30000000;
        this.f12759d = 2500000;
        this.f12760e = 5000000;
        this.f12761f = null;
    }

    public final void mo1276a() {
        m11882a(false);
    }

    public final void mo1277a(Renderer[] rendererArr, TrackSelectionArray trackSelectionArray) {
        int i = 0;
        this.f12762g = 0;
        while (i < rendererArr.length) {
            if (trackSelectionArray.f5148b[i] != null) {
                this.f12762g += Util.m4322d(rendererArr[i].mo3310a());
            }
            i++;
        }
        this.f12756a.m12665a(this.f12762g);
    }

    public final void mo1280b() {
        m11882a(true);
    }

    public final void mo1281c() {
        m11882a(true);
    }

    public final Allocator mo1282d() {
        return this.f12756a;
    }

    public final boolean mo1279a(long j, boolean z) {
        long j2 = z ? this.f12760e : this.f12759d;
        if (j2 > 0) {
            if (j < j2) {
                return 0;
            }
        }
        return 1;
    }

    private void m11882a(boolean z) {
        this.f12762g = 0;
        if (this.f12761f != null && this.f12763h) {
            this.f12761f.m4280a();
        }
        this.f12763h = false;
        if (z) {
            this.f12756a.m12670d();
        }
    }

    public final boolean mo1278a(long j) {
        boolean z = true;
        j = j > this.f12758c ? 0 : j < this.f12757b ? 2 : 1;
        boolean z2 = this.f12756a.m12671e() >= this.f12762g;
        boolean z3 = this.f12763h;
        if (j != 2) {
            if (j != 1 || this.f12763h == null || z2) {
                z = false;
            }
        }
        this.f12763h = z;
        if (!(this.f12761f == null || this.f12763h == z3)) {
            if (this.f12763h != null) {
                j = this.f12761f;
                synchronized (j.f5263a) {
                    j.f5264b.add(Integer.valueOf(0));
                    j.f5265c = Math.max(j.f5265c, 0);
                }
            } else {
                this.f12761f.m4280a();
            }
        }
        return this.f12763h;
    }
}
