package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

public final class SingleMap<T, R> extends Single<R> {
    final SingleSource<? extends T> f35830a;
    final Function<? super T, ? extends R> f35831b;

    static final class MapSingleObserver<T, R> implements SingleObserver<T> {
        final SingleObserver<? super R> f32370a;
        final Function<? super T, ? extends R> f32371b;

        MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.f32370a = singleObserver;
            this.f32371b = function;
        }

        public final void onSubscribe(Disposable disposable) {
            this.f32370a.onSubscribe(disposable);
        }

        public final void onSuccess(T t) {
            try {
                this.f32370a.onSuccess(ObjectHelper.m26573a(this.f32371b.apply(t), "The mapper function returned a null value."));
            } catch (T t2) {
                Exceptions.m26521b(t2);
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f32370a.onError(th);
        }
    }

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.f35830a = singleSource;
        this.f35831b = function;
    }

    protected final void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f35830a.subscribe(new MapSingleObserver(singleObserver, this.f35831b));
    }
}
