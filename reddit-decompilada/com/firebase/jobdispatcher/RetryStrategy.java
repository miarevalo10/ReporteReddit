package com.firebase.jobdispatcher;

public final class RetryStrategy {
    public static final RetryStrategy f3878a = new RetryStrategy(1, 30, 3600);
    public static final RetryStrategy f3879b = new RetryStrategy(2, 30, 3600);
    final int f3880c;
    final int f3881d;
    final int f3882e;

    static final class Builder {
        private final ValidationEnforcer f3877a;

        Builder(ValidationEnforcer validationEnforcer) {
            this.f3877a = validationEnforcer;
        }
    }

    RetryStrategy(int i, int i2, int i3) {
        this.f3880c = i;
        this.f3881d = i2;
        this.f3882e = i3;
    }
}
