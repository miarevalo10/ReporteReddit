package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class ImmediateFuture<V> extends FluentFuture<V> {
    private static final Logger f19274a = Logger.getLogger(ImmediateFuture.class.getName());

    static class ImmediateSuccessfulFuture<V> extends ImmediateFuture<V> {
        static final ImmediateSuccessfulFuture<Object> f19725a = new ImmediateSuccessfulFuture(null);
        private final V f19726b;

        ImmediateSuccessfulFuture(V v) {
            this.f19726b = v;
        }

        public V get() {
            return this.f19726b;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append("[status=SUCCESS, result=[");
            stringBuilder.append(this.f19726b);
            stringBuilder.append("]]");
            return stringBuilder.toString();
        }
    }

    static final class ImmediateFailedFuture<V> extends TrustedFuture<V> {
        ImmediateFailedFuture(Throwable th) {
            mo4400a(th);
        }
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public abstract V get() throws ExecutionException;

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    ImmediateFuture() {
    }

    public final void mo4057a(Runnable runnable, Executor executor) {
        Preconditions.m6909a((Object) runnable, (Object) "Runnable was null.");
        Preconditions.m6909a((Object) executor, (Object) "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (Throwable e) {
            Logger logger = f19274a;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder("RuntimeException while executing runnable ");
            stringBuilder.append(runnable);
            stringBuilder.append(" with executor ");
            stringBuilder.append(executor);
            logger.log(level, stringBuilder.toString(), e);
        }
    }

    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        Preconditions.m6908a((Object) timeUnit);
        return get();
    }
}
