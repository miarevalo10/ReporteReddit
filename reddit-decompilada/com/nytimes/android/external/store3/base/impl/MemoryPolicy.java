package com.nytimes.android.external.store3.base.impl;

import java.util.concurrent.TimeUnit;

public class MemoryPolicy {
    public final long f10236a;
    final long f10237b;
    public final TimeUnit f10238c;
    final long f10239d;

    public static class MemoryPolicyBuilder {
        public TimeUnit f10232a = TimeUnit.SECONDS;
        public long f10233b = 1;
        private long f10234c = -1;
        private long f10235d = -1;

        public final MemoryPolicyBuilder m8698a(long j) {
            if (this.f10235d != -1) {
                throw new IllegalStateException("Cannot set expireAfterWrite with expireAfterAccess already set");
            }
            this.f10234c = j;
            return this;
        }

        public final MemoryPolicy m8699a() {
            return new MemoryPolicy(this.f10234c, this.f10235d, this.f10232a, this.f10233b);
        }
    }

    MemoryPolicy(long j, long j2, TimeUnit timeUnit, long j3) {
        this.f10236a = j;
        this.f10237b = j2;
        this.f10238c = timeUnit;
        this.f10239d = j3;
    }

    public static MemoryPolicyBuilder m8700a() {
        return new MemoryPolicyBuilder();
    }
}
