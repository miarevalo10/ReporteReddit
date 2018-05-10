package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class SingleDoOnError<T> extends Single<T> {
    final SingleSource<T> f35797a;
    final Consumer<? super Throwable> f35798b;

    final class DoOnError implements SingleObserver<T> {
        final /* synthetic */ SingleDoOnError f32340a;
        private final SingleObserver<? super T> f32341b;

        DoOnError(SingleDoOnError singleDoOnError, SingleObserver<? super T> singleObserver) {
            this.f32340a = singleDoOnError;
            this.f32341b = singleObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f32341b.onSubscribe(disposable);
        }

        public final void onSuccess(T t) {
            this.f32341b.onSuccess(t);
        }

        public final void onError(Throwable th) {
            try {
                this.f32340a.f35798b.accept(th);
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                th = new CompositeException(th, th2);
            }
            this.f32341b.onError(th);
        }
    }

    public SingleDoOnError(SingleSource<T> singleSource, Consumer<? super Throwable> consumer) {
        this.f35797a = singleSource;
        this.f35798b = consumer;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35797a.subscribe(new DoOnError(this, singleObserver));
    }
}
