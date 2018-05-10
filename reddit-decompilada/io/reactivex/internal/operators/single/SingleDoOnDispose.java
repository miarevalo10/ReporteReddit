package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDoOnDispose<T> extends Single<T> {
    final SingleSource<T> f35795a;
    final Action f35796b;

    static final class DoOnDisposeObserver<T> extends AtomicReference<Action> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> f32338a;
        Disposable f32339b;

        DoOnDisposeObserver(SingleObserver<? super T> singleObserver, Action action) {
            this.f32338a = singleObserver;
            lazySet(action);
        }

        public final void mo5626a() {
            Action action = (Action) getAndSet(null);
            if (action != null) {
                try {
                    action.run();
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    RxJavaPlugins.m26757a(th);
                }
                this.f32339b.mo5626a();
            }
        }

        public final boolean mo5627b() {
            return this.f32339b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32339b, disposable)) {
                this.f32339b = disposable;
                this.f32338a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f32338a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f32338a.onError(th);
        }
    }

    public SingleDoOnDispose(SingleSource<T> singleSource, Action action) {
        this.f35795a = singleSource;
        this.f35796b = action;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35795a.subscribe(new DoOnDisposeObserver(singleObserver, this.f35796b));
    }
}
