package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiConsumer;

public final class SingleDoOnEvent<T> extends Single<T> {
    final SingleSource<T> f35799a;
    final BiConsumer<? super T, ? super Throwable> f35800b;

    final class DoOnEvent implements SingleObserver<T> {
        final /* synthetic */ SingleDoOnEvent f32342a;
        private final SingleObserver<? super T> f32343b;

        DoOnEvent(SingleDoOnEvent singleDoOnEvent, SingleObserver<? super T> singleObserver) {
            this.f32342a = singleDoOnEvent;
            this.f32343b = singleObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f32343b.onSubscribe(disposable);
        }

        public final void onSuccess(T t) {
            try {
                this.f32342a.f35800b.mo4825a(t, null);
                this.f32343b.onSuccess(t);
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f32343b.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            try {
                this.f32342a.f35800b.mo4825a(null, th);
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                th = new CompositeException(th, th2);
            }
            this.f32343b.onError(th);
        }
    }

    public SingleDoOnEvent(SingleSource<T> singleSource, BiConsumer<? super T, ? super Throwable> biConsumer) {
        this.f35799a = singleSource;
        this.f35800b = biConsumer;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35799a.subscribe(new DoOnEvent(this, singleObserver));
    }
}
