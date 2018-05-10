package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

public final class SingleDoFinally<T> extends Single<T> {
    final SingleSource<T> f35793a;
    final Action f35794b;

    static final class DoFinallyObserver<T> extends AtomicInteger implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> f32335a;
        final Action f32336b;
        Disposable f32337c;

        DoFinallyObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.f32335a = singleObserver;
            this.f32336b = action;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32337c, disposable)) {
                this.f32337c = disposable;
                this.f32335a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f32335a.onSuccess(t);
            m32704c();
        }

        public final void onError(Throwable th) {
            this.f32335a.onError(th);
            m32704c();
        }

        public final void mo5626a() {
            this.f32337c.mo5626a();
            m32704c();
        }

        public final boolean mo5627b() {
            return this.f32337c.mo5627b();
        }

        private void m32704c() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f32336b.run();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
            }
        }
    }

    public SingleDoFinally(SingleSource<T> singleSource, Action action) {
        this.f35793a = singleSource;
        this.f35794b = action;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35793a.subscribe(new DoFinallyObserver(singleObserver, this.f35794b));
    }
}
