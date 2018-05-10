package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> f35074a;

    static class SubscriberObserver<T> implements Observer<T>, Subscription {
        private final Subscriber<? super T> f31265a;
        private Disposable f31266b;

        public void request(long j) {
        }

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.f31265a = subscriber;
        }

        public void onComplete() {
            this.f31265a.onComplete();
        }

        public void onError(Throwable th) {
            this.f31265a.onError(th);
        }

        public void onNext(T t) {
            this.f31265a.onNext(t);
        }

        public void onSubscribe(Disposable disposable) {
            this.f31266b = disposable;
            this.f31265a.mo5623a(this);
        }

        public void cancel() {
            this.f31266b.mo5626a();
        }
    }

    public FlowableFromObservable(Observable<T> observable) {
        this.f35074a = observable;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.f35074a.subscribe(new SubscriberObserver(subscriber));
    }
}
