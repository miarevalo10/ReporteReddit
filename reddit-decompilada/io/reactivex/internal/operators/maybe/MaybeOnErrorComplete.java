package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;

public final class MaybeOnErrorComplete<T> extends AbstractMaybeWithUpstream<T, T> {
    final Predicate<? super Throwable> f37926b;

    static final class OnErrorCompleteMaybeObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31496a;
        final Predicate<? super Throwable> f31497b;
        Disposable f31498c;

        OnErrorCompleteMaybeObserver(MaybeObserver<? super T> maybeObserver, Predicate<? super Throwable> predicate) {
            this.f31496a = maybeObserver;
            this.f31497b = predicate;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31498c, disposable)) {
                this.f31498c = disposable;
                this.f31496a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31496a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            try {
                if (this.f31497b.test(th)) {
                    this.f31496a.onComplete();
                } else {
                    this.f31496a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                this.f31496a.onError(new CompositeException(th, th2));
            }
        }

        public final void onComplete() {
            this.f31496a.onComplete();
        }

        public final void mo5626a() {
            this.f31498c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31498c.mo5627b();
        }
    }

    public MaybeOnErrorComplete(MaybeSource<T> maybeSource, Predicate<? super Throwable> predicate) {
        super(maybeSource);
        this.f37926b = predicate;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new OnErrorCompleteMaybeObserver(maybeObserver, this.f37926b));
    }
}
