package io.reactivex.internal.operators.flowable;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableMergeWithCompletable<T> extends AbstractFlowableWithUpstream<T, T> {
    final CompletableSource f37761a;

    static final class MergeWithSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35115a;
        final AtomicReference<Subscription> f35116b = new AtomicReference();
        final OtherObserver f35117c = new OtherObserver(this);
        final AtomicThrowable f35118d = new AtomicThrowable();
        final AtomicLong f35119e = new AtomicLong();
        volatile boolean f35120f;
        volatile boolean f35121g;

        static final class OtherObserver extends AtomicReference<Disposable> implements CompletableObserver {
            final MergeWithSubscriber<?> f31334a;

            OtherObserver(MergeWithSubscriber<?> mergeWithSubscriber) {
                this.f31334a = mergeWithSubscriber;
            }

            public final void onSubscribe(Disposable disposable) {
                DisposableHelper.m32092b(this, disposable);
            }

            public final void onError(Throwable th) {
                AtomicInteger atomicInteger = this.f31334a;
                SubscriptionHelper.m32777a(atomicInteger.f35116b);
                HalfSerializer.m26690a(atomicInteger.f35115a, th, atomicInteger, atomicInteger.f35118d);
            }

            public final void onComplete() {
                AtomicInteger atomicInteger = this.f31334a;
                atomicInteger.f35121g = true;
                if (atomicInteger.f35120f) {
                    HalfSerializer.m26691a(atomicInteger.f35115a, atomicInteger, atomicInteger.f35118d);
                }
            }
        }

        MergeWithSubscriber(Subscriber<? super T> subscriber) {
            this.f35115a = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            SubscriptionHelper.m32778a(this.f35116b, this.f35119e, subscription);
        }

        public final void onNext(T t) {
            HalfSerializer.m26689a(this.f35115a, (Object) t, (AtomicInteger) this, this.f35118d);
        }

        public final void onError(Throwable th) {
            SubscriptionHelper.m32777a(this.f35116b);
            HalfSerializer.m26690a(this.f35115a, th, (AtomicInteger) this, this.f35118d);
        }

        public final void onComplete() {
            this.f35120f = true;
            if (this.f35121g) {
                HalfSerializer.m26691a(this.f35115a, (AtomicInteger) this, this.f35118d);
            }
        }

        public final void request(long j) {
            SubscriptionHelper.m32775a(this.f35116b, this.f35119e, j);
        }

        public final void cancel() {
            SubscriptionHelper.m32777a(this.f35116b);
            DisposableHelper.m32090a(this.f35117c);
        }
    }

    public FlowableMergeWithCompletable(Flowable<T> flowable, CompletableSource completableSource) {
        super(flowable);
        this.f37761a = completableSource;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        FlowableSubscriber mergeWithSubscriber = new MergeWithSubscriber(subscriber);
        subscriber.mo5623a(mergeWithSubscriber);
        this.source.subscribe(mergeWithSubscriber);
        this.f37761a.subscribe(mergeWithSubscriber.f35117c);
    }
}
