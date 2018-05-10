package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUnsubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler f38110a;

    static final class UnsubscribeObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        final Observer<? super T> f32247a;
        final Scheduler f32248b;
        Disposable f32249c;

        final class DisposeTask implements Runnable {
            final /* synthetic */ UnsubscribeObserver f25138a;

            DisposeTask(UnsubscribeObserver unsubscribeObserver) {
                this.f25138a = unsubscribeObserver;
            }

            public final void run() {
                this.f25138a.f32249c.mo5626a();
            }
        }

        UnsubscribeObserver(Observer<? super T> observer, Scheduler scheduler) {
            this.f32247a = observer;
            this.f32248b = scheduler;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32249c, disposable)) {
                this.f32249c = disposable;
                this.f32247a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!get()) {
                this.f32247a.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            if (get()) {
                RxJavaPlugins.m26757a(th);
            } else {
                this.f32247a.onError(th);
            }
        }

        public final void onComplete() {
            if (!get()) {
                this.f32247a.onComplete();
            }
        }

        public final void mo5626a() {
            if (compareAndSet(false, true)) {
                this.f32248b.mo5677a(new DisposeTask(this));
            }
        }

        public final boolean mo5627b() {
            return get();
        }
    }

    public ObservableUnsubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f38110a = scheduler;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new UnsubscribeObserver(observer, this.f38110a));
    }
}
