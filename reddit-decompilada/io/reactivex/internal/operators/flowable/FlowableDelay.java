package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long f37700a;
    final TimeUnit f37701b;
    final Scheduler f37702c;
    final boolean f37703d;

    static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f34961a;
        final long f34962b;
        final TimeUnit f34963c;
        final Worker f34964d;
        final boolean f34965e;
        Subscription f34966f;

        final class OnComplete implements Runnable {
            final /* synthetic */ DelaySubscriber f25051a;

            OnComplete(DelaySubscriber delaySubscriber) {
                this.f25051a = delaySubscriber;
            }

            public final void run() {
                try {
                    this.f25051a.f34961a.onComplete();
                } finally {
                    this.f25051a.f34964d.mo5626a();
                }
            }
        }

        final class OnError implements Runnable {
            final /* synthetic */ DelaySubscriber f25052a;
            private final Throwable f25053b;

            OnError(DelaySubscriber delaySubscriber, Throwable th) {
                this.f25052a = delaySubscriber;
                this.f25053b = th;
            }

            public final void run() {
                try {
                    this.f25052a.f34961a.onError(this.f25053b);
                } finally {
                    this.f25052a.f34964d.mo5626a();
                }
            }
        }

        final class OnNext implements Runnable {
            final /* synthetic */ DelaySubscriber f25054a;
            private final T f25055b;

            OnNext(DelaySubscriber delaySubscriber, T t) {
                this.f25054a = delaySubscriber;
                this.f25055b = t;
            }

            public final void run() {
                this.f25054a.f34961a.onNext(this.f25055b);
            }
        }

        DelaySubscriber(Subscriber<? super T> subscriber, long j, TimeUnit timeUnit, Worker worker, boolean z) {
            this.f34961a = subscriber;
            this.f34962b = j;
            this.f34963c = timeUnit;
            this.f34964d = worker;
            this.f34965e = z;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34966f, subscription)) {
                this.f34966f = subscription;
                this.f34961a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            this.f34964d.mo6607a(new OnNext(this, t), this.f34962b, this.f34963c);
        }

        public final void onError(Throwable th) {
            this.f34964d.mo6607a(new OnError(this, th), this.f34965e != null ? this.f34962b : 0, this.f34963c);
        }

        public final void onComplete() {
            this.f34964d.mo6607a(new OnComplete(this), this.f34962b, this.f34963c);
        }

        public final void request(long j) {
            this.f34966f.request(j);
        }

        public final void cancel() {
            this.f34966f.cancel();
            this.f34964d.mo5626a();
        }
    }

    public FlowableDelay(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.f37700a = j;
        this.f37701b = timeUnit;
        this.f37702c = scheduler;
        this.f37703d = z;
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new DelaySubscriber(!this.f37703d ? new SerializedSubscriber(subscriber) : subscriber, this.f37700a, this.f37701b, this.f37702c.mo5629a(), this.f37703d));
    }
}
