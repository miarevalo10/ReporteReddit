package com.sendbird.android.shadow.okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout {
    public static final Timeout f23616c = new C24921();
    private boolean f23617a;
    private long f23618b;
    private long f23619d;

    class C24921 extends Timeout {
        public final Timeout mo5384a(long j) {
            return this;
        }

        public final Timeout mo5385a(long j, TimeUnit timeUnit) {
            return this;
        }

        public final void mo5391f() throws IOException {
        }

        C24921() {
        }
    }

    public Timeout mo5385a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("timeout < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.f23619d = timeUnit.toNanos(j);
            return this;
        }
    }

    public long av_() {
        return this.f23619d;
    }

    public boolean aw_() {
        return this.f23617a;
    }

    public long mo5389c() {
        if (this.f23617a) {
            return this.f23618b;
        }
        throw new IllegalStateException("No deadline");
    }

    public Timeout mo5384a(long j) {
        this.f23617a = true;
        this.f23618b = j;
        return this;
    }

    public Timeout mo5390d() {
        this.f23619d = 0;
        return this;
    }

    public Timeout ax_() {
        this.f23617a = false;
        return this;
    }

    public void mo5391f() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.f23617a && this.f23618b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
