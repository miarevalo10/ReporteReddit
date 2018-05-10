package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

public final class SingleDoOnSuccess<T> extends Single<T> {
    final SingleSource<T> f35803a;
    final Consumer<? super T> f35804b;

    final class DoOnSuccess implements SingleObserver<T> {
        final /* synthetic */ SingleDoOnSuccess f32347a;
        private final SingleObserver<? super T> f32348b;

        DoOnSuccess(SingleDoOnSuccess singleDoOnSuccess, SingleObserver<? super T> singleObserver) {
            this.f32347a = singleDoOnSuccess;
            this.f32348b = singleObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f32348b.onSubscribe(disposable);
        }

        public final void onSuccess(T t) {
            try {
                this.f32347a.f35804b.accept(t);
                this.f32348b.onSuccess(t);
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f32348b.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f32348b.onError(th);
        }
    }

    public SingleDoOnSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f35803a = singleSource;
        this.f35804b = consumer;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35803a.subscribe(new DoOnSuccess(this, singleObserver));
    }
}
