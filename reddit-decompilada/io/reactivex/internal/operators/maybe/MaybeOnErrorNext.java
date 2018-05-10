package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeOnErrorNext<T> extends AbstractMaybeWithUpstream<T, T> {
    final Function<? super Throwable, ? extends MaybeSource<? extends T>> f37927b;
    final boolean f37928c;

    static final class OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31501a;
        final Function<? super Throwable, ? extends MaybeSource<? extends T>> f31502b;
        final boolean f31503c;

        static final class NextMaybeObserver<T> implements MaybeObserver<T> {
            final MaybeObserver<? super T> f31499a;
            final AtomicReference<Disposable> f31500b;

            NextMaybeObserver(MaybeObserver<? super T> maybeObserver, AtomicReference<Disposable> atomicReference) {
                this.f31499a = maybeObserver;
                this.f31500b = atomicReference;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this.f31500b, disposable);
            }

            public final void onSuccess(T t) {
                this.f31499a.onSuccess(t);
            }

            public final void onError(Throwable th) {
                this.f31499a.onError(th);
            }

            public final void onComplete() {
                this.f31499a.onComplete();
            }
        }

        OnErrorNextMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends MaybeSource<? extends T>> function, boolean z) {
            this.f31501a = maybeObserver;
            this.f31502b = function;
            this.f31503c = z;
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f31501a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31501a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            if (this.f31503c || (th instanceof Exception)) {
                try {
                    MaybeSource maybeSource = (MaybeSource) ObjectHelper.m26573a(this.f31502b.apply(th), "The resumeFunction returned a null MaybeSource");
                    DisposableHelper.m32094c(this, null);
                    maybeSource.subscribe(new NextMaybeObserver(this.f31501a, this));
                    return;
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    this.f31501a.onError(new CompositeException(th, th2));
                    return;
                }
            }
            this.f31501a.onError(th);
        }

        public final void onComplete() {
            this.f31501a.onComplete();
        }
    }

    public MaybeOnErrorNext(MaybeSource<T> maybeSource, Function<? super Throwable, ? extends MaybeSource<? extends T>> function, boolean z) {
        super(maybeSource);
        this.f37927b = function;
        this.f37928c = z;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new OnErrorNextMaybeObserver(maybeObserver, this.f37927b, this.f37928c));
    }
}
