package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final CompletableSource f37675a;

    static final class ConcatWithSubscriber<T> extends AtomicReference<Disposable> implements CompletableObserver, FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f34934a;
        Subscription f34935b;
        CompletableSource f34936c;
        boolean f34937d;

        ConcatWithSubscriber(Subscriber<? super T> subscriber, CompletableSource completableSource) {
            this.f34934a = subscriber;
            this.f34936c = completableSource;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34935b, subscription)) {
                this.f34935b = subscription;
                this.f34934a.mo5623a(this);
            }
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onNext(T t) {
            this.f34934a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f34934a.onError(th);
        }

        public final void onComplete() {
            if (this.f34937d) {
                this.f34934a.onComplete();
                return;
            }
            this.f34937d = true;
            this.f34935b = SubscriptionHelper.f32454a;
            CompletableSource completableSource = this.f34936c;
            this.f34936c = null;
            completableSource.subscribe(this);
        }

        public final void request(long j) {
            this.f34935b.request(j);
        }

        public final void cancel() {
            this.f34935b.cancel();
            DisposableHelper.m32090a((AtomicReference) this);
        }
    }

    public FlowableConcatWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.f37675a = completableSource;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new ConcatWithSubscriber(subscriber, this.f37675a));
    }
}
