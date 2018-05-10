package com.reddit.datalibrary.frontpage.service.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class PriorityFuture<T> implements RunnableFuture<T> {
    public static final int PRIORITY_HIGH = 100;
    public static final int PRIORITY_LOW = 0;
    private final int priority;
    private final RunnableFuture<T> src;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TaskPriority {
    }

    PriorityFuture(RunnableFuture<T> runnableFuture, int i) {
        this.src = runnableFuture;
        this.priority = i;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean cancel(boolean z) {
        return this.src.cancel(z);
    }

    public boolean isCancelled() {
        return this.src.isCancelled();
    }

    public boolean isDone() {
        return this.src.isDone();
    }

    public T get() throws InterruptedException, ExecutionException {
        return this.src.get();
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.src.get();
    }

    public void run() {
        this.src.run();
    }
}
