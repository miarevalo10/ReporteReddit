package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class MaybeDoAfterSuccess<T> extends AbstractMaybeWithUpstream<T, T> {
    final Consumer<? super T> f37913b;

    static final class DoAfterObserver<T> implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31429a;
        final Consumer<? super T> f31430b;
        Disposable f31431c;

        DoAfterObserver(MaybeObserver<? super T> maybeObserver, Consumer<? super T> consumer) {
            this.f31429a = maybeObserver;
            this.f31430b = consumer;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31431c, disposable)) {
                this.f31431c = disposable;
                this.f31429a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31429a.onSuccess(t);
            try {
                this.f31430b.accept(t);
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onError(Throwable th) {
            this.f31429a.onError(th);
        }

        public final void onComplete() {
            this.f31429a.onComplete();
        }

        public final void mo5626a() {
            this.f31431c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31431c.mo5627b();
        }
    }

    public MaybeDoAfterSuccess(MaybeSource<T> maybeSource, Consumer<? super T> consumer) {
        super(maybeSource);
        this.f37913b = consumer;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new DoAfterObserver(maybeObserver, this.f37913b));
    }
}
