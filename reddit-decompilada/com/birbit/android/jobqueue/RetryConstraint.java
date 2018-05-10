package com.birbit.android.jobqueue;

public class RetryConstraint {
    public static final RetryConstraint f2948a = new ImmutableRetryConstraint(true);
    public static final RetryConstraint f2949b = new ImmutableRetryConstraint(false);
    boolean f2950c;
    Long f2951d;
    Integer f2952e;
    boolean f2953f = false;

    static class ImmutableRetryConstraint extends RetryConstraint {
        public ImmutableRetryConstraint(boolean z) {
            super(z);
        }
    }

    public RetryConstraint(boolean z) {
        this.f2950c = z;
    }
}
