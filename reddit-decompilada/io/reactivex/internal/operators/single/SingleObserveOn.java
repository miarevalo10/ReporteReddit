package io.reactivex.internal.operators.single;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleObserveOn<T> extends Single<T> {
    final SingleSource<T> f35833a;
    final Scheduler f35834b;

    static final class ObserveOnSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable, Runnable {
        final SingleObserver<? super T> f32372a;
        final Scheduler f32373b;
        T f32374c;
        Throwable f32375d;

        ObserveOnSingleObserver(SingleObserver<? super T> singleObserver, Scheduler scheduler) {
            this.f32372a = singleObserver;
            this.f32373b = scheduler;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                this.f32372a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f32374c = t;
            DisposableHelper.m32094c(this, this.f32373b.mo5677a((Runnable) this));
        }

        public final void onError(Throwable th) {
            this.f32375d = th;
            DisposableHelper.m32094c(this, this.f32373b.mo5677a((Runnable) this));
        }

        public final void run() {
            Throwable th = this.f32375d;
            if (th != null) {
                this.f32372a.onError(th);
            } else {
                this.f32372a.onSuccess(this.f32374c);
            }
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public SingleObserveOn(SingleSource<T> singleSource, Scheduler scheduler) {
        this.f35833a = singleSource;
        this.f35834b = scheduler;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35833a.subscribe(new ObserveOnSingleObserver(singleObserver, this.f35834b));
    }
}
