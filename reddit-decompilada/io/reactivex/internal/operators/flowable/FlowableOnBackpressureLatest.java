package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableOnBackpressureLatest<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class BackpressureLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super T> f35168a;
        Subscription f35169b;
        volatile boolean f35170c;
        Throwable f35171d;
        volatile boolean f35172e;
        final AtomicLong f35173f = new AtomicLong();
        final AtomicReference<T> f35174g = new AtomicReference();

        BackpressureLatestSubscriber(Subscriber<? super T> subscriber) {
            this.f35168a = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35169b, subscription)) {
                this.f35169b = subscription;
                this.f35168a.mo5623a(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public final void onNext(T t) {
            this.f35174g.lazySet(t);
            m35766a();
        }

        public final void onError(Throwable th) {
            this.f35171d = th;
            this.f35170c = true;
            m35766a();
        }

        public final void onComplete() {
            this.f35170c = true;
            m35766a();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35173f, j);
                m35766a();
            }
        }

        public final void cancel() {
            if (!this.f35172e) {
                this.f35172e = true;
                this.f35169b.cancel();
                if (getAndIncrement() == 0) {
                    this.f35174g.lazySet(null);
                }
            }
        }

        private void m35766a() {
            if (getAndIncrement() == 0) {
                Subscriber subscriber = this.f35168a;
                AtomicLong atomicLong = this.f35173f;
                AtomicReference atomicReference = this.f35174g;
                int i = 1;
                do {
                    boolean z;
                    boolean z2;
                    long j = 0;
                    while (true) {
                        z = false;
                        if (j == atomicLong.get()) {
                            break;
                        }
                        z2 = this.f35170c;
                        Object andSet = atomicReference.getAndSet(null);
                        boolean z3 = andSet == null;
                        if (!m35767a(z2, z3, subscriber, atomicReference)) {
                            if (z3) {
                                break;
                            }
                            subscriber.onNext(andSet);
                            j++;
                        } else {
                            return;
                        }
                    }
                    if (j == atomicLong.get()) {
                        z2 = this.f35170c;
                        if (atomicReference.get() == null) {
                            z = true;
                        }
                        if (m35767a(z2, z, subscriber, atomicReference)) {
                            return;
                        }
                    }
                    if (j != 0) {
                        BackpressureHelper.m26673c(atomicLong, j);
                    }
                    i = addAndGet(-i);
                } while (i != 0);
            }
        }

        private boolean m35767a(boolean z, boolean z2, Subscriber<?> subscriber, AtomicReference<T> atomicReference) {
            if (this.f35172e) {
                atomicReference.lazySet(null);
                return true;
            }
            if (z) {
                z = this.f35171d;
                if (z) {
                    atomicReference.lazySet(null);
                    subscriber.onError(z);
                    return true;
                } else if (z2) {
                    subscriber.onComplete();
                    return true;
                }
            }
            return false;
        }
    }

    public FlowableOnBackpressureLatest(Flowable<T> flowable) {
        super(flowable);
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe(new BackpressureLatestSubscriber(subscriber));
    }
}
