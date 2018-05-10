package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleUnsubscribeOn<T> extends Single<T> {
    final SingleSource<T> f35855a;
    final Scheduler f35856b;

    static final class UnsubscribeOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        final SingleObserver<? super T> f32393a;
        final Scheduler f32394b;
        Disposable f32395c;

        UnsubscribeOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.f32393a = singleObserver;
            this.f32394b = scheduler;
        }

        public final void mo5626a() {
            Disposable disposable = (Disposable) getAndSet(DisposableHelper.f31095a);
            if (disposable != DisposableHelper.f31095a) {
                this.f32395c = disposable;
                this.f32394b.mo5677a((Runnable) this);
            }
        }

        public final void run() {
            this.f32395c.mo5626a();
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f32393a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f32393a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            this.f32393a.onError(th);
        }
    }

    public SingleUnsubscribeOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f35855a = singleSource;
        this.f35856b = scheduler;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35855a.subscribe(new UnsubscribeOnSingleObserver(singleObserver, this.f35856b));
    }
}
