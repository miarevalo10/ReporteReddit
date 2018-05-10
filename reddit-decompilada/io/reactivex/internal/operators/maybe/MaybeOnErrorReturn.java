package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

public final class MaybeOnErrorReturn<T> extends AbstractMaybeWithUpstream<T, T> {
    final Function<? super Throwable, ? extends T> f37929b;

    static final class OnErrorReturnMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31504a;
        final Function<? super Throwable, ? extends T> f31505b;
        Disposable f31506c;

        OnErrorReturnMaybeObserver(MaybeObserver<? super T> maybeObserver, Function<? super Throwable, ? extends T> function) {
            this.f31504a = maybeObserver;
            this.f31505b = function;
        }

        public final void mo5626a() {
            this.f31506c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31506c.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31506c, disposable)) {
                this.f31506c = disposable;
                this.f31504a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31504a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            try {
                this.f31504a.onSuccess(ObjectHelper.m26573a(this.f31505b.apply(th), "The valueSupplier returned a null value"));
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.f31504a.onError(new CompositeException(th, th2));
            }
        }

        public final void onComplete() {
            this.f31504a.onComplete();
        }
    }

    public MaybeOnErrorReturn(MaybeSource<T> maybeSource, Function<? super Throwable, ? extends T> function) {
        super(maybeSource);
        this.f37929b = function;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new OnErrorReturnMaybeObserver(maybeObserver, this.f37929b));
    }
}
