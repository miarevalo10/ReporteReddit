package io.reactivex.internal.subscriptions;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public class SubscriptionArbiter extends AtomicInteger implements Subscription {
    Subscription f32447j;
    long f32448k;
    final AtomicReference<Subscription> f32449l = new AtomicReference();
    final AtomicLong f32450m = new AtomicLong();
    final AtomicLong f32451n = new AtomicLong();
    public volatile boolean f32452o;
    protected boolean f32453p;

    public final void m32772b(Subscription subscription) {
        if (this.f32452o) {
            subscription.cancel();
            return;
        }
        ObjectHelper.m26573a((Object) subscription, "s is null");
        if (get() == 0 && compareAndSet(0, 1)) {
            Subscription subscription2 = this.f32447j;
            if (subscription2 != null) {
                subscription2.cancel();
            }
            this.f32447j = subscription;
            long j = this.f32448k;
            if (decrementAndGet() != 0) {
                m32770c();
            }
            if (j != 0) {
                subscription.request(j);
            }
            return;
        }
        subscription = (Subscription) this.f32449l.getAndSet(subscription);
        if (subscription != null) {
            subscription.cancel();
        }
        m32769b();
    }

    public final void request(long j) {
        if (SubscriptionHelper.m32776a(j) && !this.f32453p) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.f32448k;
                if (j2 != Long.MAX_VALUE) {
                    j2 = BackpressureHelper.m26669a(j2, j);
                    this.f32448k = j2;
                    if (j2 == Long.MAX_VALUE) {
                        this.f32453p = true;
                    }
                }
                Subscription subscription = this.f32447j;
                if (decrementAndGet() != 0) {
                    m32770c();
                }
                if (subscription != null) {
                    subscription.request(j);
                }
                return;
            }
            BackpressureHelper.m26670a(this.f32450m, j);
            m32769b();
        }
    }

    public final void m32773c(long j) {
        if (!this.f32453p) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j2 = this.f32448k;
                if (j2 != Long.MAX_VALUE) {
                    j2 -= j;
                    j = 0;
                    if (j2 < 0) {
                        SubscriptionHelper.m32782b(j2);
                    } else {
                        j = j2;
                    }
                    this.f32448k = j;
                }
                if (decrementAndGet() != null) {
                    m32770c();
                    return;
                }
                return;
            }
            BackpressureHelper.m26670a(this.f32451n, j);
            m32769b();
        }
    }

    public void cancel() {
        if (!this.f32452o) {
            this.f32452o = true;
            m32769b();
        }
    }

    private void m32769b() {
        if (getAndIncrement() == 0) {
            m32770c();
        }
    }

    private void m32770c() {
        SubscriptionArbiter subscriptionArbiter = this;
        Subscription subscription = null;
        int i = 1;
        long j = 0;
        do {
            Subscription subscription2 = (Subscription) subscriptionArbiter.f32449l.get();
            if (subscription2 != null) {
                subscription2 = (Subscription) subscriptionArbiter.f32449l.getAndSet(null);
            }
            long j2 = subscriptionArbiter.f32450m.get();
            if (j2 != 0) {
                j2 = subscriptionArbiter.f32450m.getAndSet(0);
            }
            long j3 = subscriptionArbiter.f32451n.get();
            if (j3 != 0) {
                j3 = subscriptionArbiter.f32451n.getAndSet(0);
            }
            Subscription subscription3 = subscriptionArbiter.f32447j;
            if (subscriptionArbiter.f32452o) {
                if (subscription3 != null) {
                    subscription3.cancel();
                    subscriptionArbiter.f32447j = null;
                }
                if (subscription2 != null) {
                    subscription2.cancel();
                }
            } else {
                long j4 = subscriptionArbiter.f32448k;
                if (j4 != Long.MAX_VALUE) {
                    j4 = BackpressureHelper.m26669a(j4, j2);
                    if (j4 != Long.MAX_VALUE) {
                        j3 = j4 - j3;
                        if (j3 < 0) {
                            SubscriptionHelper.m32782b(j3);
                            j3 = 0;
                        }
                        j4 = j3;
                    }
                    subscriptionArbiter.f32448k = j4;
                }
                if (subscription2 != null) {
                    if (subscription3 != null) {
                        subscription3.cancel();
                    }
                    subscriptionArbiter.f32447j = subscription2;
                    if (j4 != 0) {
                        j = BackpressureHelper.m26669a(j, j4);
                        subscription = subscription2;
                    }
                } else if (!(subscription3 == null || j2 == 0)) {
                    j = BackpressureHelper.m26669a(j, j2);
                    subscription = subscription3;
                }
            }
            i = addAndGet(-i);
        } while (i != 0);
        if (j != 0) {
            subscription.request(j);
        }
    }

    public final boolean m32771a() {
        return this.f32453p;
    }
}
