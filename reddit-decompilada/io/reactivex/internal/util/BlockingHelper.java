package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.NonBlockingThread;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CountDownLatch;

public final class BlockingHelper {
    public static void m26676a(CountDownLatch countDownLatch, Disposable disposable) {
        if (countDownLatch.getCount() != 0) {
            try {
                m26675a();
                countDownLatch.await();
            } catch (CountDownLatch countDownLatch2) {
                disposable.mo5626a();
                Thread.currentThread().interrupt();
                throw new IllegalStateException("Interrupted while waiting for subscription to complete.", countDownLatch2);
            }
        }
    }

    public static void m26675a() {
        if (!RxJavaPlugins.m26758a()) {
            return;
        }
        if ((Thread.currentThread() instanceof NonBlockingThread) || RxJavaPlugins.m26762b()) {
            StringBuilder stringBuilder = new StringBuilder("Attempt to block on a Scheduler ");
            stringBuilder.append(Thread.currentThread().getName());
            stringBuilder.append(" that doesn't support blocking operators as they may lead to deadlock");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }
}
