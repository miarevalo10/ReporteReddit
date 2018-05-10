package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class SingleHide<T> extends Single<T> {
    final SingleSource<? extends T> f35826a;

    static final class HideSingleObserver<T> implements SingleObserver<T>, Disposable {
        final SingleObserver<? super T> f32364a;
        Disposable f32365b;

        HideSingleObserver(SingleObserver<? super T> singleObserver) {
            this.f32364a = singleObserver;
        }

        public final void mo5626a() {
            this.f32365b.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f32365b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32365b, disposable)) {
                this.f32365b = disposable;
                this.f32364a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f32364a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f32364a.onError(th);
        }
    }

    public SingleHide(SingleSource<? extends T> singleSource) {
        this.f35826a = singleSource;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35826a.subscribe(new HideSingleObserver(singleObserver));
    }
}
