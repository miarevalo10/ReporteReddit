package io.reactivex.internal.operators.maybe;

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

public final class MaybeFlatMapSingleElement<T, R> extends Maybe<R> {
    final MaybeSource<T> f35583a;
    final Function<? super T, ? extends SingleSource<? extends R>> f35584b;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super R> f31467a;
        final Function<? super T, ? extends SingleSource<? extends R>> f31468b;

        FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.f31467a = maybeObserver;
            this.f31468b = function;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f31467a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            try {
                ((SingleSource) ObjectHelper.m26573a(this.f31468b.apply(t), "The mapper returned a null SingleSource")).subscribe(new FlatMapSingleObserver(this, this.f31467a));
            } catch (T t2) {
                Exceptions.m26521b(t2);
                onError(t2);
            }
        }

        public final void onError(Throwable th) {
            this.f31467a.onError(th);
        }

        public final void onComplete() {
            this.f31467a.onComplete();
        }
    }

    static final class FlatMapSingleObserver<R> implements SingleObserver<R> {
        final AtomicReference<Disposable> f31469a;
        final MaybeObserver<? super R> f31470b;

        FlatMapSingleObserver(AtomicReference<Disposable> atomicReference, MaybeObserver<? super R> maybeObserver) {
            this.f31469a = atomicReference;
            this.f31470b = maybeObserver;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32094c(this.f31469a, disposable);
        }

        public final void onSuccess(R r) {
            this.f31470b.onSuccess(r);
        }

        public final void onError(Throwable th) {
            this.f31470b.onError(th);
        }
    }

    public MaybeFlatMapSingleElement(MaybeSource<T> maybeSource, Function<? super T, ? extends SingleSource<? extends R>> function) {
        this.f35583a = maybeSource;
        this.f35584b = function;
    }

    protected final void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        this.f35583a.subscribe(new FlatMapMaybeObserver(maybeObserver, this.f35584b));
    }
}
