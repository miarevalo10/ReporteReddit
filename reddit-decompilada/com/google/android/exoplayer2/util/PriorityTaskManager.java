package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.PriorityQueue;

public final class PriorityTaskManager {
    public final Object f5263a;
    public final PriorityQueue<Integer> f5264b;
    public int f5265c;

    public static class PriorityTooLowException extends IOException {
    }

    public final void m4280a() {
        synchronized (this.f5263a) {
            this.f5264b.remove(Integer.valueOf(0));
            this.f5265c = this.f5264b.isEmpty() ? Integer.MIN_VALUE : ((Integer) this.f5264b.peek()).intValue();
            this.f5263a.notifyAll();
        }
    }
}
