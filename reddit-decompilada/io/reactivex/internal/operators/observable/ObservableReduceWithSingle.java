package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class ObservableReduceWithSingle<T, R> extends Single<R> {
    final ObservableSource<T> f35710a;
    final Callable<R> f35711b;
    final BiFunction<R, ? super T, R> f35712c;

    public ObservableReduceWithSingle(ObservableSource<T> observableSource, Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        this.f35710a = observableSource;
        this.f35711b = callable;
        this.f35712c = biFunction;
    }

    protected final void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.f35710a.subscribe(new ReduceSeedObserver(singleObserver, this.f35712c, ObjectHelper.m26573a(this.f35711b.call(), "The seedSupplier returned a null value")));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38052a(th, (SingleObserver) singleObserver);
        }
    }
}
