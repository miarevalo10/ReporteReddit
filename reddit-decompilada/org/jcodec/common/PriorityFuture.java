package org.jcodec.common;

import java.util.Comparator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class PriorityFuture<T> implements RunnableFuture<T> {
    public static Comparator<Runnable> COMP = new C22021();
    private int priority;
    private RunnableFuture<T> src;

    static class C22021 implements Comparator<Runnable> {
        C22021() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            Runnable runnable = (Runnable) obj;
            Runnable runnable2 = (Runnable) obj2;
            if (runnable == null && runnable2 == null) {
                return 0;
            }
            if (runnable != null) {
                if (runnable2 == null) {
                    return 1;
                }
                obj = ((PriorityFuture) runnable).getPriority();
                obj2 = ((PriorityFuture) runnable2).getPriority();
                if (obj > obj2) {
                    return 1;
                }
                if (obj == obj2) {
                    return 0;
                }
            }
            return -1;
        }
    }

    public PriorityFuture(RunnableFuture<T> runnableFuture, int i) {
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
