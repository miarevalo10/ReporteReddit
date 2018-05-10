package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class MaybeDoFinally<T> extends AbstractMaybeWithUpstream<T, T> {
    final Action f37914b;

    static final class DoFinallyObserver<T> extends AtomicInteger implements MaybeObserver<T>, Disposable {
        final MaybeObserver<? super T> f31432a;
        final Action f31433b;
        Disposable f31434c;

        DoFinallyObserver(MaybeObserver<? super T> maybeObserver, Action action) {
            this.f31432a = maybeObserver;
            this.f31433b = action;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31434c, disposable)) {
                this.f31434c = disposable;
                this.f31432a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f31432a.onSuccess(t);
            m32260c();
        }

        public final void onError(Throwable th) {
            this.f31432a.onError(th);
            m32260c();
        }

        public final void onComplete() {
            this.f31432a.onComplete();
            m32260c();
        }

        public final void mo5626a() {
            this.f31434c.mo5626a();
            m32260c();
        }

        public final boolean mo5627b() {
            return this.f31434c.mo5627b();
        }

        private void m32260c() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f31433b.run();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
            }
        }
    }

    public MaybeDoFinally(MaybeSource<T> maybeSource, Action action) {
        super(maybeSource);
        this.f37914b = action;
    }

    protected final void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.a.subscribe(new DoFinallyObserver(maybeObserver, this.f37914b));
    }
}
