package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class SingleDoAfterTerminate<T> extends Single<T> {
    final SingleSource<T> f35791a;
    final Action f35792b;

    static final class DoAfterTerminateObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> f32332a;
        final Action f32333b;
        Disposable f32334c;

        DoAfterTerminateObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.f32332a = singleObserver;
            this.f32333b = action;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32334c, disposable)) {
                this.f32334c = disposable;
                this.f32332a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f32332a.onSuccess(t);
            m32701c();
        }

        public final void onError(Throwable th) {
            this.f32332a.onError(th);
            m32701c();
        }

        public final void mo5626a() {
            this.f32334c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32334c.mo5627b();
        }

        private void m32701c() {
            try {
                this.f32333b.run();
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        }
    }

    public SingleDoAfterTerminate(SingleSource<T> singleSource, Action action) {
        this.f35791a = singleSource;
        this.f35792b = action;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35791a.subscribe(new DoAfterTerminateObserver(singleObserver, this.f35792b));
    }
}
