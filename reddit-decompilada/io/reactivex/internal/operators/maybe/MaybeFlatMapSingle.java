package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapSingle<T, R> extends Single<R> {
    final MaybeSource<T> f35581a;
    final Function<? super T, ? extends SingleSource<? extends R>> f35582b;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final SingleObserver<? super R> f31463a;
        final Function<? super T, ? extends SingleSource<? extends R>> f31464b;

        FlatMapMaybeObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.f31463a = singleObserver;
            this.f31464b = function;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f31463a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                SingleSource singleSource = (SingleSource) ObjectHelper.m26573a(this.f31464b.apply(t), "The mapper returned a null SingleSource");
                if (!mo5627b()) {
                    singleSource.subscribe(new FlatMapSingleObserver(this, this.f31463a));
                }
            } catch (T t2) {
                Exceptions.m26521b(t2);
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f31463a.onError(th);
        }

        public final void onComplete() {
            this.f31463a.onError(new NoSuchElementException());
        }
    }

    static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
        final AtomicReference<Disposable> f31465a;
        final SingleObserver<? super R> f31466b;

        FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super R> singleObserver) {
            this.f31465a = atomicReference;
            this.f31466b = singleObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f31465a, disposable);
        }

        public final void onSuccess(R r) {
            this.f31466b.onSuccess(r);
        }

        public final void onError(Throwable th) {
            this.f31466b.onError(th);
        }
    }

    public MaybeFlatMapSingle(MaybeSource<T> maybeSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f35581a = maybeSource;
        this.f35582b = function;
    }

    protected final void subscribeActual(SingleObserver<? super R> singleObserver) {
        this.f35581a.subscribe(new FlatMapMaybeObserver(singleObserver, this.f35582b));
    }
}
