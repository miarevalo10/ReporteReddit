package io.reactivex.internal.subscribers;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableConditionalSubscriber<T, R> implements ConditionalSubscriber<T>, QueueSubscription<R> {
    protected final ConditionalSubscriber<? super R> f38134e;
    protected Subscription f38135f;
    protected QueueSubscription<T> f38136g;
    protected boolean f38137h;
    protected int f38138i;

    public BasicFuseableConditionalSubscriber(ConditionalSubscriber<? super R> conditionalSubscriber) {
        this.f38134e = conditionalSubscriber;
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32781a(this.f38135f, subscription)) {
            this.f38135f = subscription;
            if (subscription instanceof QueueSubscription) {
                this.f38136g = (QueueSubscription) subscription;
            }
            this.f38134e.mo5623a(this);
        }
    }

    public void onError(Throwable th) {
        if (this.f38137h) {
            RxJavaPlugins.m26757a(th);
            return;
        }
        this.f38137h = true;
        this.f38134e.onError(th);
    }

    protected final void m38154a(Throwable th) {
        Exceptions.m26521b(th);
        this.f38135f.cancel();
        onError(th);
    }

    public void onComplete() {
        if (!this.f38137h) {
            this.f38137h = true;
            this.f38134e.onComplete();
        }
    }

    protected final int m38156b(int i) {
        QueueSubscription queueSubscription = this.f38136g;
        if (queueSubscription == null || (i & 4) != 0) {
            return 0;
        }
        i = queueSubscription.mo7033a(i);
        if (i != 0) {
            this.f38138i = i;
        }
        return i;
    }

    public void request(long j) {
        this.f38135f.request(j);
    }

    public void cancel() {
        this.f38135f.cancel();
    }

    public boolean isEmpty() {
        return this.f38136g.isEmpty();
    }

    public void clear() {
        this.f38136g.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
