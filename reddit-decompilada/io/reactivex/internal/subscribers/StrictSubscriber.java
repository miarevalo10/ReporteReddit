package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    final Subscriber<? super T> f35929a;
    final AtomicThrowable f35930b = new AtomicThrowable();
    final AtomicLong f35931c = new AtomicLong();
    final AtomicReference<Subscription> f35932d = new AtomicReference();
    final AtomicBoolean f35933e = new AtomicBoolean();
    volatile boolean f35934f;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.f35929a = subscriber;
    }

    public void request(long j) {
        if (j <= 0) {
            cancel();
            StringBuilder stringBuilder = new StringBuilder("§3.9 violated: positive request amount required but it was ");
            stringBuilder.append(j);
            onError(new IllegalArgumentException(stringBuilder.toString()));
            return;
        }
        SubscriptionHelper.m32775a(this.f35932d, this.f35931c, j);
    }

    public void cancel() {
        if (!this.f35934f) {
            SubscriptionHelper.m32777a(this.f35932d);
        }
    }

    public final void mo5623a(Subscription subscription) {
        if (this.f35933e.compareAndSet(false, true)) {
            this.f35929a.mo5623a(this);
            SubscriptionHelper.m32778a(this.f35932d, this.f35931c, subscription);
            return;
        }
        subscription.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void onNext(T t) {
        HalfSerializer.m26689a(this.f35929a, (Object) t, (AtomicInteger) this, this.f35930b);
    }

    public void onError(Throwable th) {
        this.f35934f = true;
        HalfSerializer.m26690a(this.f35929a, th, (AtomicInteger) this, this.f35930b);
    }

    public void onComplete() {
        this.f35934f = true;
        HalfSerializer.m26691a(this.f35929a, (AtomicInteger) this, this.f35930b);
    }
}
