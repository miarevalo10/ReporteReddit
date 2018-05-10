package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

public final class SingleDetach<T> extends Single<T> {
    final SingleSource<T> f35788a;

    static final class DetachSingleObserver<T> implements SingleObserver<T>, Disposable {
        SingleObserver<? super T> f32327a;
        Disposable f32328b;

        DetachSingleObserver(SingleObserver<? super T> singleObserver) {
            this.f32327a = singleObserver;
        }

        public final void mo5626a() {
            this.f32327a = null;
            this.f32328b.mo5626a();
            this.f32328b = DisposableHelper.f31095a;
        }

        public final boolean mo5627b() {
            return this.f32328b.mo5627b();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32328b, disposable)) {
                this.f32328b = disposable;
                this.f32327a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f32328b = DisposableHelper.f31095a;
            SingleObserver singleObserver = this.f32327a;
            if (singleObserver != null) {
                this.f32327a = null;
                singleObserver.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            this.f32328b = DisposableHelper.f31095a;
            SingleObserver singleObserver = this.f32327a;
            if (singleObserver != null) {
                this.f32327a = null;
                singleObserver.onError(th);
            }
        }
    }

    public SingleDetach(SingleSource<T> singleSource) {
        this.f35788a = singleSource;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35788a.subscribe(new DetachSingleObserver(singleObserver));
    }
}
