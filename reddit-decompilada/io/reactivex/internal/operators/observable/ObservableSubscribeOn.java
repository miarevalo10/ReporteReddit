package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSubscribeOn<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler f38080a;

    final class SubscribeTask implements Runnable {
        final /* synthetic */ ObservableSubscribeOn f25132a;
        private final SubscribeOnObserver<T> f25133b;

        SubscribeTask(ObservableSubscribeOn observableSubscribeOn, SubscribeOnObserver<T> subscribeOnObserver) {
            this.f25132a = observableSubscribeOn;
            this.f25133b = subscribeOnObserver;
        }

        public final void run() {
            this.f25132a.source.subscribe(this.f25133b);
        }
    }

    static final class SubscribeOnObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        final Observer<? super T> f32143a;
        final AtomicReference<Disposable> f32144b = new AtomicReference();

        SubscribeOnObserver(Observer<? super T> observer) {
            this.f32143a = observer;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this.f32144b, disposable);
        }

        public final void onNext(T t) {
            this.f32143a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f32143a.onError(th);
        }

        public final void onComplete() {
            this.f32143a.onComplete();
        }

        public final void mo5626a() {
            DisposableHelper.m32090a(this.f32144b);
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public ObservableSubscribeOn(ObservableSource<T> observableSource, Scheduler scheduler) {
        super(observableSource);
        this.f38080a = scheduler;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        AtomicReference subscribeOnObserver = new SubscribeOnObserver(observer);
        observer.onSubscribe(subscribeOnObserver);
        DisposableHelper.m32092b(subscribeOnObserver, this.f38080a.mo5677a(new SubscribeTask(this, subscribeOnObserver)));
    }
}
