package io.reactivex.internal.operators.single;

import io.reactivex.FlowableSubscriber;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.ResumeSingleObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

public final class SingleDelayWithPublisher<T, U> extends Single<T> {
    final SingleSource<T> f35784a;
    final Publisher<U> f35785b;

    static final class OtherSubscriber<T, U> extends AtomicReference<Disposable> implements FlowableSubscriber<U>, Disposable {
        final SingleObserver<? super T> f35780a;
        final SingleSource<T> f35781b;
        boolean f35782c;
        Subscription f35783d;

        OtherSubscriber(SingleObserver<? super T> singleObserver, SingleSource<T> singleSource) {
            this.f35780a = singleObserver;
            this.f35781b = singleSource;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35783d, subscription)) {
                this.f35783d = subscription;
                this.f35780a.onSubscribe(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(U u) {
            this.f35783d.cancel();
            onComplete();
        }

        public final void onError(Throwable th) {
            if (this.f35782c) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35782c = true;
            this.f35780a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35782c) {
                this.f35782c = true;
                this.f35781b.subscribe(new ResumeSingleObserver(this, this.f35780a));
            }
        }

        public final void mo5626a() {
            this.f35783d.cancel();
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }
    }

    public SingleDelayWithPublisher(SingleSource<T> singleSource, Publisher<U> publisher) {
        this.f35784a = singleSource;
        this.f35785b = publisher;
    }

    protected final void subscribeActual(SingleObserver<? super T> singleObserver) {
        this.f35785b.subscribe(new OtherSubscriber(singleObserver, this.f35784a));
    }
}
