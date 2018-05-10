package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableObserveOn<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler f37764a;
    final boolean f37765b;
    final int f37766c;

    static abstract class BaseObserveOnSubscriber<T> extends BasicIntQueueSubscription<T> implements FlowableSubscriber<T>, Runnable {
        final Worker f39485a;
        final boolean f39486b;
        final int f39487c;
        final int f39488d;
        final AtomicLong f39489e = new AtomicLong();
        Subscription f39490f;
        SimpleQueue<T> f39491g;
        volatile boolean f39492h;
        volatile boolean f39493i;
        Throwable f39494j;
        int f39495k;
        long f39496l;
        boolean f39497m;

        abstract void mo7595a();

        abstract void mo7596b();

        abstract void mo7597c();

        BaseObserveOnSubscriber(Worker worker, boolean z, int i) {
            this.f39485a = worker;
            this.f39486b = z;
            this.f39487c = i;
            this.f39488d = i - (i >> 2);
        }

        public final void onNext(T t) {
            if (!this.f39493i) {
                if (this.f39495k == 2) {
                    m39681d();
                    return;
                }
                if (this.f39491g.offer(t) == null) {
                    this.f39490f.cancel();
                    this.f39494j = new MissingBackpressureException("Queue is full?!");
                    this.f39493i = true;
                }
                m39681d();
            }
        }

        public final void onError(Throwable th) {
            if (this.f39493i) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f39494j = th;
            this.f39493i = true;
            m39681d();
        }

        public final void onComplete() {
            if (!this.f39493i) {
                this.f39493i = true;
                m39681d();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f39489e, j);
                m39681d();
            }
        }

        public final void cancel() {
            if (!this.f39492h) {
                this.f39492h = true;
                this.f39490f.cancel();
                this.f39485a.mo5626a();
                if (getAndIncrement() == 0) {
                    this.f39491g.clear();
                }
            }
        }

        private void m39681d() {
            if (getAndIncrement() == 0) {
                this.f39485a.mo6651a((Runnable) this);
            }
        }

        public final void run() {
            if (this.f39497m) {
                mo7595a();
            } else if (this.f39495k == 1) {
                mo7596b();
            } else {
                mo7597c();
            }
        }

        final boolean m39684a(boolean z, boolean z2, Subscriber<?> subscriber) {
            if (this.f39492h) {
                clear();
                return true;
            }
            if (z) {
                if (!this.f39486b) {
                    z = this.f39494j;
                    if (z) {
                        clear();
                        subscriber.onError(z);
                        this.f39485a.mo5626a();
                        return true;
                    } else if (z2) {
                        subscriber.onComplete();
                        this.f39485a.mo5626a();
                        return true;
                    }
                } else if (z2) {
                    z = this.f39494j;
                    if (z) {
                        subscriber.onError(z);
                    } else {
                        subscriber.onComplete();
                    }
                    this.f39485a.mo5626a();
                    return true;
                }
            }
            return false;
        }

        public final int mo7033a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f39497m = true;
            return 2;
        }

        public final void clear() {
            this.f39491g.clear();
        }

        public final boolean isEmpty() {
            return this.f39491g.isEmpty();
        }
    }

    static final class ObserveOnConditionalSubscriber<T> extends BaseObserveOnSubscriber<T> {
        final ConditionalSubscriber<? super T> f40248n;
        long f40249o;

        ObserveOnConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Worker worker, boolean z, int i) {
            super(worker, z, i);
            this.f40248n = conditionalSubscriber;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a = queueSubscription.mo7033a(7);
                    if (a == 1) {
                        this.k = 1;
                        this.g = queueSubscription;
                        this.i = true;
                        this.f40248n.mo5623a(this);
                        return;
                    } else if (a == 2) {
                        this.k = 2;
                        this.g = queueSubscription;
                        this.f40248n.mo5623a(this);
                        subscription.request((long) this.c);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(this.c);
                this.f40248n.mo5623a(this);
                subscription.request((long) this.c);
            }
        }

        final void mo7596b() {
            ConditionalSubscriber conditionalSubscriber = this.f40248n;
            SimpleQueue simpleQueue = this.g;
            long j = this.l;
            int i = 1;
            while (true) {
                long j2 = this.e.get();
                while (j != j2) {
                    try {
                        Object poll = simpleQueue.poll();
                        if (!this.h) {
                            if (poll == null) {
                                conditionalSubscriber.onComplete();
                                this.a.mo5626a();
                                return;
                            } else if (conditionalSubscriber.mo7052a(poll)) {
                                j++;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        this.f.cancel();
                        conditionalSubscriber.onError(th);
                        this.a.mo5626a();
                        return;
                    }
                }
                if (!this.h) {
                    if (simpleQueue.isEmpty()) {
                        conditionalSubscriber.onComplete();
                        this.a.mo5626a();
                        return;
                    }
                    int i2 = get();
                    if (i == i2) {
                        this.l = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        }

        final void mo7597c() {
            Subscriber subscriber = this.f40248n;
            SimpleQueue simpleQueue = this.g;
            long j = this.l;
            long j2 = this.f40249o;
            int i = 1;
            while (true) {
                long j3 = this.e.get();
                while (true) {
                    int i2 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.i;
                    try {
                        Object poll = simpleQueue.poll();
                        boolean z2 = poll == null;
                        if (!m39684a(z, z2, subscriber)) {
                            if (z2) {
                                break;
                            }
                            if (subscriber.mo7052a(poll)) {
                                j++;
                            }
                            j2++;
                            if (j2 == ((long) this.d)) {
                                this.f.request(j2);
                                j2 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        this.f.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th);
                        this.a.mo5626a();
                        return;
                    }
                }
                if (i2 != 0 || !m39684a(this.i, simpleQueue.isEmpty(), subscriber)) {
                    int i3 = get();
                    if (i == i3) {
                        this.l = j;
                        this.f40249o = j2;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i3;
                    }
                } else {
                    return;
                }
            }
        }

        final void mo7595a() {
            int i = 1;
            while (!this.h) {
                boolean z = this.i;
                this.f40248n.onNext(null);
                if (z) {
                    Throwable th = this.j;
                    if (th != null) {
                        this.f40248n.onError(th);
                    } else {
                        this.f40248n.onComplete();
                    }
                    this.a.mo5626a();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        public final T poll() throws Exception {
            T poll = this.g.poll();
            if (!(poll == null || this.k == 1)) {
                long j = this.f40249o + 1;
                if (j == ((long) this.d)) {
                    this.f40249o = 0;
                    this.f.request(j);
                } else {
                    this.f40249o = j;
                }
            }
            return poll;
        }
    }

    static final class ObserveOnSubscriber<T> extends BaseObserveOnSubscriber<T> implements FlowableSubscriber<T> {
        final Subscriber<? super T> f40250n;

        ObserveOnSubscriber(Subscriber<? super T> subscriber, Worker worker, boolean z, int i) {
            super(worker, z, i);
            this.f40250n = subscriber;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f, subscription)) {
                this.f = subscription;
                if (subscription instanceof QueueSubscription) {
                    QueueSubscription queueSubscription = (QueueSubscription) subscription;
                    int a = queueSubscription.mo7033a(7);
                    if (a == 1) {
                        this.k = 1;
                        this.g = queueSubscription;
                        this.i = true;
                        this.f40250n.mo5623a(this);
                        return;
                    } else if (a == 2) {
                        this.k = 2;
                        this.g = queueSubscription;
                        this.f40250n.mo5623a(this);
                        subscription.request((long) this.c);
                        return;
                    }
                }
                this.g = new SpscArrayQueue(this.c);
                this.f40250n.mo5623a(this);
                subscription.request((long) this.c);
            }
        }

        final void mo7596b() {
            Subscriber subscriber = this.f40250n;
            SimpleQueue simpleQueue = this.g;
            long j = this.l;
            int i = 1;
            while (true) {
                long j2 = this.e.get();
                while (j != j2) {
                    try {
                        Object poll = simpleQueue.poll();
                        if (!this.h) {
                            if (poll == null) {
                                subscriber.onComplete();
                                this.a.mo5626a();
                                return;
                            }
                            subscriber.onNext(poll);
                            j++;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        this.f.cancel();
                        subscriber.onError(th);
                        this.a.mo5626a();
                        return;
                    }
                }
                if (!this.h) {
                    if (simpleQueue.isEmpty()) {
                        subscriber.onComplete();
                        this.a.mo5626a();
                        return;
                    }
                    int i2 = get();
                    if (i == i2) {
                        this.l = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i2;
                    }
                } else {
                    return;
                }
            }
        }

        final void mo7597c() {
            Subscriber subscriber = this.f40250n;
            SimpleQueue simpleQueue = this.g;
            long j = this.l;
            int i = 1;
            while (true) {
                long j2 = this.e.get();
                while (true) {
                    int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.i;
                    try {
                        Object poll = simpleQueue.poll();
                        boolean z2 = poll == null;
                        if (!m39684a(z, z2, subscriber)) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(poll);
                            j++;
                            if (j == ((long) this.d)) {
                                if (j2 != Long.MAX_VALUE) {
                                    j2 = this.e.addAndGet(-j);
                                }
                                this.f.request(j);
                                j = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        this.f.cancel();
                        simpleQueue.clear();
                        subscriber.onError(th);
                        this.a.mo5626a();
                        return;
                    }
                }
                if (i2 != 0 || !m39684a(this.i, simpleQueue.isEmpty(), subscriber)) {
                    int i3 = get();
                    if (i == i3) {
                        this.l = j;
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        i = i3;
                    }
                } else {
                    return;
                }
            }
        }

        final void mo7595a() {
            int i = 1;
            while (!this.h) {
                boolean z = this.i;
                this.f40250n.onNext(null);
                if (z) {
                    Throwable th = this.j;
                    if (th != null) {
                        this.f40250n.onError(th);
                    } else {
                        this.f40250n.onComplete();
                    }
                    this.a.mo5626a();
                    return;
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        public final T poll() throws Exception {
            T poll = this.g.poll();
            if (!(poll == null || this.k == 1)) {
                long j = this.l + 1;
                if (j == ((long) this.d)) {
                    this.l = 0;
                    this.f.request(j);
                } else {
                    this.l = j;
                }
            }
            return poll;
        }
    }

    public FlowableObserveOn(Flowable<T> flowable, Scheduler scheduler, boolean z, int i) {
        super(flowable);
        this.f37764a = scheduler;
        this.f37765b = z;
        this.f37766c = i;
    }

    public final void subscribeActual(Subscriber<? super T> subscriber) {
        Worker a = this.f37764a.mo5629a();
        if (subscriber instanceof ConditionalSubscriber) {
            this.source.subscribe(new ObserveOnConditionalSubscriber((ConditionalSubscriber) subscriber, a, this.f37765b, this.f37766c));
        } else {
            this.source.subscribe(new ObserveOnSubscriber(subscriber, a, this.f37765b, this.f37766c));
        }
    }
}
