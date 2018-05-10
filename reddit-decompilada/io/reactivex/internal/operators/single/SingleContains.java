package io.reactivex.internal.operators.single;

import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiPredicate;

public final class SingleContains<T> extends io.reactivex.Single<Boolean> {
    final SingleSource<T> f35766a;
    final Object f35767b;
    final BiPredicate<Object, Object> f35768c;

    final class Single implements SingleObserver<T> {
        final /* synthetic */ SingleContains f32314a;
        private final SingleObserver<? super Boolean> f32315b;

        Single(SingleContains singleContains, SingleObserver<? super Boolean> singleObserver) {
            this.f32314a = singleContains;
            this.f32315b = singleObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f32315b.onSubscribe(disposable);
        }

        public final void onSuccess(T t) {
            try {
                this.f32315b.onSuccess(Boolean.valueOf(this.f32314a.f35768c.mo4928a(t, this.f32314a.f35767b)));
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f32315b.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f32315b.onError(th);
        }
    }

    public SingleContains(SingleSource<T> singleSource, Object obj, BiPredicate<Object, Object> biPredicate) {
        this.f35766a = singleSource;
        this.f35767b = obj;
        this.f35768c = biPredicate;
    }

    protected final void subscribeActual(SingleObserver<? super Boolean> singleObserver) {
        this.f35766a.subscribe(new Single(this, singleObserver));
    }
}
