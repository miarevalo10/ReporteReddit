package io.fabric.sdk.android.services.concurrency.internal;

public class DefaultRetryPolicy implements RetryPolicy {
    private final int f31007a;

    public DefaultRetryPolicy() {
        this(1);
    }

    public DefaultRetryPolicy(int i) {
        this.f31007a = i;
    }
}
