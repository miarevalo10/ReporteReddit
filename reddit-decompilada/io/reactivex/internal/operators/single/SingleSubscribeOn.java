package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubscribeOn<T> extends Single<T> {
    final SingleSource<? extends T> f35840a;
    final Scheduler f35841b;

    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        final SingleObserver<? super T> f32380a;
        final SequentialDisposable f32381b = new SequentialDisposable();
        final SingleSource<? extends T> f32382c;

        SubscribeOnObserver(SingleObserver<? super T> singleObserver, SingleSource<? extends T> singleSource) {
            this.f32380a = singleObserver;
            this.f32382c = singleSource;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onSuccess(T t) {
            this.f32380a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f32380a.onError(th);
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
            this.f32381b.mo5626a();
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void run() {
            this.f32382c.subscribe(this);
        }
    }

    public SingleSubscribeOn(SingleSource<? extends T> singleSource, Scheduler scheduler) {
        this.f35840a = singleSource;
        this.f35841b = scheduler;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        Runnable subscribeOnObserver = new SubscribeOnObserver(singleObserver, this.f35840a);
        singleObserver.onSubscribe(subscribeOnObserver);
        DisposableHelper.m32094c(subscribeOnObserver.f32381b, this.f35841b.mo5677a(subscribeOnObserver));
    }
}
