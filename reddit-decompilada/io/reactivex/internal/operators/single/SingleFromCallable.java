package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class SingleFromCallable<T> extends Single<T> {
    final Callable<? extends T> f35818a;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.f35818a = callable;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        Disposable a = Disposables.m26512a();
        singleObserver.onSubscribe(a);
        if (!a.mo5627b()) {
            try {
                Object a2 = ObjectHelper.m26573a(this.f35818a.call(), "The callable returned a null value");
                if (!a.mo5627b()) {
                    singleObserver.onSuccess(a2);
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                if (a.mo5627b()) {
                    RxJavaPlugins.m26757a(th);
                } else {
                    singleObserver.onError(th);
                }
            }
        }
    }
}
