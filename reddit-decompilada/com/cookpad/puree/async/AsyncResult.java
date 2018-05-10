package com.cookpad.puree.async;

import java.util.concurrent.CountDownLatch;

public class AsyncResult extends CountDownLatch {
    public boolean f3696a;

    public AsyncResult() {
        this((byte) 0);
    }

    private AsyncResult(byte b) {
        super((byte) 1);
        this.f3696a = false;
    }

    public final void m3258a() {
        this.f3696a = true;
        countDown();
    }
}
