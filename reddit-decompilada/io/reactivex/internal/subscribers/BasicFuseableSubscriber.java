package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableSubscriber<T, R> implements FlowableSubscriber<T>, QueueSubscription<R> {
    protected final Subscriber<? super R> f38139e;
    protected Subscription f38140f;
    protected QueueSubscription<T> f38141g;
    protected boolean f38142h;
    protected int f38143i;

    public BasicFuseableSubscriber(Subscriber<? super R> subscriber) {
        this.f38139e = subscriber;
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32781a(this.f38140f, subscription)) {
            this.f38140f = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f38141g = (QueueSubscription) subscription;
            }
            this.f38139e.mo5623a(this);
        }
    }

    public void onError(Throwable th) {
        if (this.f38142h) {
            RxJavaPlugins.m26757a(th);
            return;
        }
        this.f38142h = true;
        this.f38139e.onError(th);
    }

    protected final void m38157a(Throwable th) {
        Exceptions.m26521b(th);
        this.f38140f.cancel();
        onError(th);
    }

    public void onComplete() {
        if (!this.f38142h) {
            this.f38142h = true;
            this.f38139e.onComplete();
        }
    }

    protected final int m38159b(int i) {
        QueueSubscription queueSubscription = this.f38141g;
        if (queueSubscription == null || (i & 4) != 0) {
            return 0;
        }
        i = queueSubscription.mo7033a(i);
        if (i != 0) {
            this.f38143i = i;
        }
        return i;
    }

    public void request(long j) {
        this.f38140f.request(j);
    }

    public void cancel() {
        this.f38140f.cancel();
    }

    public boolean isEmpty() {
        return this.f38141g.isEmpty();
    }

    public void clear() {
        this.f38141g.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
