package io.reactivex.internal.subscriptions;

import org.reactivestreams.Subscriber;

public class DeferredScalarSubscription<T> extends BasicIntQueueSubscription<T> {
    protected final Subscriber<? super T> f39687h;
    protected T f39688i;

    public DeferredScalarSubscription(Subscriber<? super T> subscriber) {
        this.f39687h = subscriber;
    }

    public final void request(long j) {
        if (SubscriptionHelper.m32776a(j) != null) {
            do {
                j = get();
                if ((j & -2) == 0) {
                    if (j == 1) {
                        if (compareAndSet(1, 3) != null) {
                            j = this.f39688i;
                            if (j != null) {
                                this.f39688i = null;
                                Subscriber subscriber = this.f39687h;
                                subscriber.onNext(j);
                                if (get() != 4) {
                                    subscriber.onComplete();
                                }
                            }
                        }
                        return;
                    }
                } else {
                    return;
                }
            } while (compareAndSet(0, 2) == null);
        }
    }

    public final void m39789a(T t) {
        Subscriber subscriber;
        int i = get();
        while (i != 8) {
            if ((i & -3) == 0) {
                if (i == 2) {
                    lazySet(3);
                    subscriber = this.f39687h;
                    subscriber.onNext(t);
                    if (get() != 4) {
                        subscriber.onComplete();
                    }
                    return;
                }
                this.f39688i = t;
                if (!compareAndSet(0, 1)) {
                    i = get();
                    if (i == 4) {
                        this.f39688i = null;
                        return;
                    }
                }
                return;
            }
            return;
        }
        this.f39688i = t;
        lazySet(16);
        subscriber = this.f39687h;
        subscriber.onNext(t);
        if (get() != 4) {
            subscriber.onComplete();
        }
    }

    public final int mo7033a(int i) {
        if ((i & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t = this.f39688i;
        this.f39688i = null;
        return t;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final void clear() {
        lazySet(32);
        this.f39688i = null;
    }

    public void cancel() {
        set(4);
        this.f39688i = null;
    }

    public final boolean m39790b() {
        return get() == 4;
    }
}
