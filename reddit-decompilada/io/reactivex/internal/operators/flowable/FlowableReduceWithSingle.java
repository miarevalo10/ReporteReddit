package io.reactivex.internal.operators.flowable;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

public final class FlowableReduceWithSingle<T, R> extends Single<R> {
    final Publisher<T> f35225a;
    final Callable<R> f35226b;
    final BiFunction<R, ? super T, R> f35227c;

    public FlowableReduceWithSingle(Publisher<T> publisher, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f35225a = publisher;
        this.f35226b = callable;
        this.f35227c = biFunction;
    }

    protected final void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.f35225a.subscribe(new ReduceSeedObserver(singleObserver, this.f35227c, ObjectHelper.m26573a(this.f35226b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38052a(th, (SingleObserver) singleObserver);
        }
    }
}
