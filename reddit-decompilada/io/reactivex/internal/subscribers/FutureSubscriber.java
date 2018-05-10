package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FutureSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T>, Future<T>, Subscription {
    T f35911a;
    Throwable f35912b;
    final AtomicReference<Subscription> f35913c = new AtomicReference();

    public final void cancel() {
    }

    public final void request(long j) {
    }

    public FutureSubscriber() {
        super(1);
    }

    public final boolean cancel(boolean z) {
        SubscriptionHelper subscriptionHelper;
        do {
            subscriptionHelper = (Subscription) this.f35913c.get();
            if (subscriptionHelper != this) {
                if (subscriptionHelper == SubscriptionHelper.f32454a) {
                }
            }
            return false;
        } while (!this.f35913c.compareAndSet(subscriptionHelper, SubscriptionHelper.f32454a));
        if (subscriptionHelper != null) {
            subscriptionHelper.cancel();
        }
        countDown();
        return true;
    }

    public final boolean isCancelled() {
        return SubscriptionHelper.m32780a((Subscription) this.f35913c.get());
    }

    public final boolean isDone() {
        return getCount() == 0;
    }

    public final T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            BlockingHelper.m26675a();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.f35912b;
        if (th == null) {
            return this.f35911a;
        }
        throw new ExecutionException(th);
    }

    public final T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            BlockingHelper.m26675a();
            if (await(j, timeUnit) == null) {
                throw new TimeoutException();
            }
        }
        if (isCancelled() != null) {
            throw new CancellationException();
        }
        j = this.f35912b;
        if (j == null) {
            return this.f35911a;
        }
        throw new ExecutionException(j);
    }

    public final void mo5623a(Subscription subscription) {
        if (SubscriptionHelper.m32779a(this.f35913c, subscription)) {
            subscription.request(Long.MAX_VALUE);
        }
    }

    public final void onNext(T t) {
        if (this.f35911a != null) {
            ((Subscription) this.f35913c.get()).cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f35911a = t;
    }

    public final void onError(Throwable th) {
        SubscriptionHelper subscriptionHelper;
        do {
            subscriptionHelper = (Subscription) this.f35913c.get();
            if (subscriptionHelper != this) {
                if (subscriptionHelper != SubscriptionHelper.f32454a) {
                    this.f35912b = th;
                }
            }
            RxJavaPlugins.m26757a(th);
            return;
        } while (!this.f35913c.compareAndSet(subscriptionHelper, this));
        countDown();
    }

    public final void onComplete() {
        if (this.f35911a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        SubscriptionHelper subscriptionHelper;
        do {
            subscriptionHelper = (Subscription) this.f35913c.get();
            if (subscriptionHelper != this) {
                if (subscriptionHelper == SubscriptionHelper.f32454a) {
                }
            }
            return;
        } while (!this.f35913c.compareAndSet(subscriptionHelper, this));
        countDown();
    }
}
