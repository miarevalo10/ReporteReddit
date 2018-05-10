package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

public final class SingleDefer<T> extends Single<T> {
    final Callable<? extends SingleSource<? extends T>> f35770a;

    public SingleDefer(Callable<? extends SingleSource<? extends T>> callable) {
        this.f35770a = callable;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        try {
            ((SingleSource) ObjectHelper.m26573a(this.f35770a.call(), "The singleSupplier returned a null SingleSource")).subscribe(singleObserver);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            EmptyDisposable.m38052a(th, (SingleObserver) singleObserver);
        }
    }
}
