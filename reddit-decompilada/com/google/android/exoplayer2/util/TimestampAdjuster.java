package com.google.android.exoplayer2.util;

public final class TimestampAdjuster {
    public long f5279a;
    public volatile long f5280b = -9223372036854775807L;
    private long f5281c;

    public TimestampAdjuster(long j) {
        m4285a(j);
    }

    public final synchronized void m4285a(long j) {
        Assertions.m4186b(this.f5280b == -9223372036854775807L);
        this.f5279a = j;
    }

    public final long m4284a() {
        if (this.f5279a == Long.MAX_VALUE) {
            return 0;
        }
        return this.f5280b == -9223372036854775807L ? -9223372036854775807L : this.f5281c;
    }

    public final long m4286b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f5280b != -9223372036854775807L) {
            long e = m4283e(this.f5280b);
            long j2 = (4294967296L + e) / 8589934592L;
            long j3 = ((j2 - 1) * 8589934592L) + j;
            j += 8589934592L * j2;
            if (Math.abs(j3 - e) < Math.abs(j - e)) {
                j = j3;
            }
        }
        return m4288c(m4282d(j));
    }

    public final long m4288c(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f5280b != -9223372036854775807L) {
            this.f5280b = j;
        } else {
            if (this.f5279a != Long.MAX_VALUE) {
                this.f5281c = this.f5279a - j;
            }
            synchronized (this) {
                this.f5280b = j;
                notifyAll();
            }
        }
        return j + this.f5281c;
    }

    public final synchronized void m4287b() throws InterruptedException {
        while (this.f5280b == -9223372036854775807L) {
            wait();
        }
    }

    public static long m4282d(long j) {
        return (j * 1000000) / 90000;
    }

    public static long m4283e(long j) {
        return (j * 90000) / 1000000;
    }
}
