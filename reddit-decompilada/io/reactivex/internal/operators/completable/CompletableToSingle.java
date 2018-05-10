package io.reactivex.internal.operators.completable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;

public final class CompletableToSingle<T> extends Single<T> {
    final CompletableSource f34788a;
    final Callable<? extends T> f34789b;
    final T f34790c;

    final class ToSingle implements CompletableObserver {
        final /* synthetic */ CompletableToSingle f31236a;
        private final SingleObserver<? super T> f31237b;

        ToSingle(CompletableToSingle completableToSingle, SingleObserver<? super T> singleObserver) {
            this.f31236a = completableToSingle;
            this.f31237b = singleObserver;
        }

        public final void onComplete() {
            if (this.f31236a.f34789b != null) {
                try {
                    Object call = this.f31236a.f34789b.call();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    this.f31237b.onError(th);
                    return;
                }
            }
            call = this.f31236a.f34790c;
            if (call == null) {
                this.f31237b.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.f31237b.onSuccess(call);
            }
        }

        public final void onError(Throwable th) {
            this.f31237b.onError(th);
        }

        public final void onSubscribe(Disposable disposable) {
            this.f31237b.onSubscribe(disposable);
        }
    }

    public CompletableToSingle(CompletableSource completableSource, Callable<? extends T> callable, T t) {
        this.f34788a = completableSource;
        this.f34790c = t;
        this.f34789b = callable;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f34788a.subscribe(new ToSingle(this, singleObserver));
    }
}
