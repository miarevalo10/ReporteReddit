package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOperator;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;

public final class SingleLift<T, R> extends Single<R> {
    final SingleSource<T> f35828a;
    final SingleOperator<? extends R, ? super T> f35829b;

    public SingleLift(SingleSource<T> singleSource, SingleOperator<? extends R, ? super T> singleOperator) {
        this.f35828a = singleSource;
        this.f35829b = singleOperator;
    }

    protected final void subscribeActual(SingleObserver<? super R> singleObserver) {
        try {
            this.f35828a.subscribe((SingleObserver) ObjectHelper.m26573a(this.f35829b.m26503a(), "The onLift returned a null SingleObserver"));
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38052a(th, (SingleObserver) singleObserver);
        }
    }
}
