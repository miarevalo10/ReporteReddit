package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMap<T, R> extends Single<R> {
    final SingleSource<? extends T> f35808a;
    final Function<? super T, ? extends SingleSource<? extends R>> f35809b;

    static final class SingleFlatMapCallback<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super R> f32356a;
        final Function<? super T, ? extends SingleSource<? extends R>> f32357b;

        static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
            final AtomicReference<Disposable> f32354a;
            final SingleObserver<? super R> f32355b;

            FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
                this.f32354a = atomicReference;
                this.f32355b = singleObserver;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32094c(this.f32354a, disposable);
            }

            public final void onSuccess(R r) {
                this.f32355b.onSuccess(r);
            }

            public final void onError(Throwable th) {
                this.f32355b.onError(th);
            }
        }

        SingleFlatMapCallback(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.f32356a = singleObserver;
            this.f32357b = function;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f32356a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.m26573a(this.f32357b.apply(t), "The single returned by the mapper is null");
                if (!mo5627b()) {
                    singleSource.subscribe(new FlatMapSingleObserver(this, this.f32356a));
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                this.f32356a.onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f32356a.onError(th);
        }
    }

    public SingleFlatMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f35809b = function;
        this.f35808a = singleSource;
    }

    protected final void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f35808a.subscribe(new SingleFlatMapCallback(singleObserver, this.f35809b));
    }
}
