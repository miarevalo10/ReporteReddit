package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;

public final class SingleOnErrorReturn<T> extends Single<T> {
    final SingleSource<? extends T> f35835a;
    final Function<? super Throwable, ? extends T> f35836b;
    final T f35837c;

    final class OnErrorReturn implements SingleObserver<T> {
        final /* synthetic */ SingleOnErrorReturn f32376a;
        private final SingleObserver<? super T> f32377b;

        OnErrorReturn(SingleOnErrorReturn singleOnErrorReturn, SingleObserver<? super T> singleObserver) {
            this.f32376a = singleOnErrorReturn;
            this.f32377b = singleObserver;
        }

        public final void onError(Throwable th) {
            Throwable th2;
            if (this.f32376a.f35836b != null) {
                try {
                    Object apply = this.f32376a.f35836b.apply(th);
                } catch (Throwable th22) {
                    Exceptions.m26521b(th22);
                    this.f32377b.onError(new CompositeException(th, th22));
                    return;
                }
            }
            apply = this.f32376a.f35837c;
            if (apply == null) {
                th22 = new NullPointerException("Value supplied was null");
                th22.initCause(th);
                this.f32377b.onError(th22);
                return;
            }
            this.f32377b.onSuccess(apply);
        }

        public final void onSubscribe(Disposable disposable) {
            this.f32377b.onSubscribe(disposable);
        }

        public final void onSuccess(T t) {
            this.f32377b.onSuccess(t);
        }
    }

    public SingleOnErrorReturn(SingleSource<? extends T> singleSource, Function<? super Throwable, ? extends T> function, T t) {
        this.f35835a = singleSource;
        this.f35836b = function;
        this.f35837c = t;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35835a.subscribe(new OnErrorReturn(this, singleObserver));
    }
}
