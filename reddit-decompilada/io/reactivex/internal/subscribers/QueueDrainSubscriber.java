package io.reactivex.internal.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import org.reactivestreams.Subscriber;

public abstract class QueueDrainSubscriber<T, U, V> extends QueueDrainSubscriberPad4 implements FlowableSubscriber<T>, QueueDrain<U, V> {
    protected final Subscriber<? super V> f40272n;
    protected final SimplePlainQueue<U> f40273o;
    protected volatile boolean f40274p;
    protected volatile boolean f40275q;
    protected Throwable f40276r;

    public boolean mo7603a(Subscriber<? super V> subscriber, U u) {
        return false;
    }

    public QueueDrainSubscriber(Subscriber<? super V> subscriber, SimplePlainQueue<U> simplePlainQueue) {
        this.f40272n = subscriber;
        this.f40273o = simplePlainQueue;
    }

    public final boolean mo7604d() {
        return this.f40274p;
    }

    public final boolean mo7605e() {
        return this.f40275q;
    }

    public final boolean m41404f() {
        return this.t.getAndIncrement() == 0;
    }

    public final boolean m41405g() {
        return this.t.get() == 0 && this.t.compareAndSet(0, 1);
    }

    protected final void m41399a(U u, Disposable disposable) {
        Subscriber subscriber = this.f40272n;
        SimplePlainQueue simplePlainQueue = this.f40273o;
        if (this.t.get() == 0 && this.t.compareAndSet(0, 1)) {
            long j = this.s.get();
            if (j != 0) {
                if (!(mo7603a(subscriber, (Object) u) == null || j == Long.MAX_VALUE)) {
                    mo7608j();
                }
                if (mo7602a(-1) == null) {
                    return;
                }
            }
            disposable.mo5626a();
            subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
            return;
        }
        simplePlainQueue.offer(u);
        if (m41404f() == null) {
            return;
        }
        QueueDrainHelper.m26727a(simplePlainQueue, subscriber, disposable, (QueueDrain) this);
    }

    protected final void m41401b(U u, Disposable disposable) {
        Subscriber subscriber = this.f40272n;
        SimplePlainQueue simplePlainQueue = this.f40273o;
        if (this.t.get() == 0 && this.t.compareAndSet(0, 1)) {
            long j = this.s.get();
            if (j == 0) {
                this.f40274p = true;
                disposable.mo5626a();
                subscriber.onError(new MissingBackpressureException("Could not emit buffer due to lack of requests"));
                return;
            } else if (simplePlainQueue.isEmpty()) {
                if (!(mo7603a(subscriber, (Object) u) == null || j == Long.MAX_VALUE)) {
                    mo7608j();
                }
                if (mo7602a(-1) == null) {
                    return;
                }
            } else {
                simplePlainQueue.offer(u);
            }
        } else {
            simplePlainQueue.offer(u);
            if (m41404f() == null) {
                return;
            }
        }
        QueueDrainHelper.m26727a(simplePlainQueue, subscriber, disposable, (QueueDrain) this);
    }

    public final Throwable mo7606h() {
        return this.f40276r;
    }

    public final int mo7602a(int i) {
        return this.t.addAndGet(i);
    }

    public final long mo7607i() {
        return this.s.get();
    }

    public final long mo7608j() {
        return this.s.addAndGet(-1);
    }

    public final void m41398a(long j) {
        if (SubscriptionHelper.m32776a(j)) {
            BackpressureHelper.m26670a(this.s, j);
        }
    }
}
