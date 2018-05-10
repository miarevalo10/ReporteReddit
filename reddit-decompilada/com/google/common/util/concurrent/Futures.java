package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public final class Futures extends GwtFuturesCatchingSpecialization {
    private static final AsyncFunction<ListenableFuture<Object>, Object> f14971a = new C12033();

    static class C12033 implements AsyncFunction<ListenableFuture<Object>, Object> {
        C12033() {
        }
    }

    public static <V> ListenableFuture<V> m14882a(V v) {
        if (v == null) {
            return ImmediateSuccessfulFuture.f19725a;
        }
        return new ImmediateSuccessfulFuture(v);
    }

    public static <V> ListenableFuture<V> m14883a(Throwable th) {
        Preconditions.m6908a((Object) th);
        return new ImmediateFailedFuture(th);
    }

    public static <I, O> ListenableFuture<O> m14881a(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.m21564a(listenableFuture, function, executor);
    }

    public static <V> V m14884a(Future<V> future) throws ExecutionException {
        Preconditions.m6923b(future.isDone(), "Future was expected to be done: %s", future);
        return Uninterruptibles.m7340a(future);
    }
}
