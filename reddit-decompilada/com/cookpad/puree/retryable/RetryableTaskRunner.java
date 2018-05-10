package com.cookpad.puree.retryable;

import android.os.Handler;

public class RetryableTaskRunner {
    private Handler f3709a;
    private boolean f3710b;
    private Runnable f3711c;
    private BackoffCounter f3712d;

    public RetryableTaskRunner(Runnable runnable, int i, int i2) {
        this(runnable, i, i2, new Handler());
    }

    private RetryableTaskRunner(final Runnable runnable, int i, int i2, Handler handler) {
        this.f3712d = new BackoffCounter(i, i2);
        this.f3709a = handler;
        this.f3710b = false;
        this.f3711c = new Runnable(this) {
            final /* synthetic */ RetryableTaskRunner f3708b;

            public void run() {
                runnable.run();
            }
        };
    }

    public final synchronized void m3268a() {
        if (!this.f3710b) {
            this.f3712d.f3706c = 0;
            m3267d();
        }
    }

    private synchronized void m3267d() {
        int i;
        this.f3709a.removeCallbacks(this.f3711c);
        Handler handler = this.f3709a;
        Runnable runnable = this.f3711c;
        BackoffCounter backoffCounter = this.f3712d;
        if (backoffCounter.f3706c == 0) {
            i = backoffCounter.f3704a;
        } else {
            i = (backoffCounter.f3706c + 1) * backoffCounter.f3704a;
        }
        handler.postDelayed(runnable, (long) i);
        this.f3710b = true;
    }

    public final synchronized void m3269b() {
        this.f3710b = false;
        this.f3712d.f3706c = 0;
    }

    public final synchronized void m3270c() {
        BackoffCounter backoffCounter = this.f3712d;
        if ((backoffCounter.f3705b - backoffCounter.f3706c > 0 ? 1 : 0) != 0) {
            BackoffCounter backoffCounter2 = this.f3712d;
            backoffCounter2.f3706c++;
            m3267d();
            return;
        }
        m3269b();
    }
}
