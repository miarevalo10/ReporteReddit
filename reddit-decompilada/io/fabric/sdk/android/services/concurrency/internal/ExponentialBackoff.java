package io.fabric.sdk.android.services.concurrency.internal;

public class ExponentialBackoff implements Backoff {
    private final long f31008a = 1000;
    private final int f31009b = 8;

    public long getDelayMillis(int i) {
        return (long) (((double) this.f31008a) * Math.pow((double) this.f31009b, (double) i));
    }
}
