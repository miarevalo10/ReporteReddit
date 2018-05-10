package io.reactivex.internal.operators.single;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapMaybe<T, R> extends Maybe<R> {
    final SingleSource<? extends T> f35816a;
    final Function<? super T, ? extends MaybeSource<? extends R>> f35817b;

    static final class FlatMapMaybeObserver<R> implements MaybeObserver<R> {
        final AtomicReference<Disposable> f32360a;
        final MaybeObserver<? super R> f32361b;

        FlatMapMaybeObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
            this.f32360a = atomicReference;
            this.f32361b = maybeObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f32360a, disposable);
        }

        public final void onSuccess(R r) {
            this.f32361b.onSuccess(r);
        }

        public final void onError(Throwable th) {
            this.f32361b.onError(th);
        }

        public final void onComplete() {
            this.f32361b.onComplete();
        }
    }

    static final class FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        final MaybeObserver<? super R> f32362a;
        final Function<? super T, ? extends MaybeSource<? extends R>> f32363b;

        FlatMapSingleObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function) {
            this.f32362a = maybeObserver;
            this.f32363b = function;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f32362a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                MaybeSource maybeSource = (MaybeSource) ObjectHelper.m26573a(this.f32363b.apply(t), "The mapper returned a null MaybeSource");
                if (!mo5627b()) {
                    maybeSource.subscribe(new FlatMapMaybeObserver(this, this.f32362a));
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f32362a.onError(th);
        }
    }

    public SingleFlatMapMaybe(SingleSource<? extends T> singleSource, Function<? super T, ? extends MaybeSource<? extends R>> function) {
        this.f35817b = function;
        this.f35816a = singleSource;
    }

    protected final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f35816a.subscribe(new FlatMapSingleObserver(maybeObserver, this.f35817b));
    }
}
