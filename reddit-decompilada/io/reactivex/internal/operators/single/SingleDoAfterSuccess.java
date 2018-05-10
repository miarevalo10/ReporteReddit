package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;

public final class SingleDoAfterSuccess<T> extends Single<T> {
    final SingleSource<T> f35789a;
    final Consumer<? super T> f35790b;

    static final class DoAfterObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> f32329a;
        final Consumer<? super T> f32330b;
        Disposable f32331c;

        DoAfterObserver(SingleObserver<? super T> singleObserver, Consumer<? super T> consumer) {
            this.f32329a = singleObserver;
            this.f32330b = consumer;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32331c, disposable)) {
                this.f32331c = disposable;
                this.f32329a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f32329a.onSuccess(t);
            try {
                this.f32330b.accept(t);
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                RxJavaPlugins.m26757a(th);
            }
        }

        public final void onError(Throwable th) {
            this.f32329a.onError(th);
        }

        public final void mo5626a() {
            this.f32331c.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32331c.mo5627b();
        }
    }

    public SingleDoAfterSuccess(SingleSource<T> singleSource, Consumer<? super T> consumer) {
        this.f35789a = singleSource;
        this.f35790b = consumer;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35789a.subscribe(new DoAfterObserver(singleObserver, this.f35790b));
    }
}
