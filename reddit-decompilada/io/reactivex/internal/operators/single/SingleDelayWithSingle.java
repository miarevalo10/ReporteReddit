package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleDelayWithSingle<T, U> extends Single<T> {
    final SingleSource<T> f35786a;
    final SingleSource<U> f35787b;

    static final class OtherObserver<T, U> extends AtomicReference<Disposable> implements SingleObserver<U>, Disposable {
        final SingleObserver<? super T> f32325a;
        final SingleSource<T> f32326b;

        OtherObserver(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f32325a = singleObserver;
            this.f32326b = singleSource;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32091a((AtomicReference) this, disposable) != null) {
                this.f32325a.onSubscribe(this);
            }
        }

        public final void onSuccess(U u) {
            this.f32326b.subscribe(new ResumeSingleObserver(this, this.f32325a));
        }

        public final void onError(Throwable th) {
            this.f32325a.onError(th);
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public SingleDelayWithSingle(SingleSource<T> singleSource, SingleSource<U> singleSource2) {
        this.f35786a = singleSource;
        this.f35787b = singleSource2;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35787b.subscribe(new OtherObserver(singleObserver, this.f35786a));
    }
}
