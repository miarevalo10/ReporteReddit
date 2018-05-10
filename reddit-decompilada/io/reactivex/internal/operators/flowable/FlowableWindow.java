package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableWindow<T> extends AbstractFlowableWithUpstream<T, Flowable<T>> {
    final long f37862a;
    final long f37863b;
    final int f37864c;

    static final class WindowExactSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Runnable, Subscription {
        final Subscriber<? super Flowable<T>> f35494a;
        final long f35495b;
        final AtomicBoolean f35496c = new AtomicBoolean();
        final int f35497d;
        long f35498e;
        Subscription f35499f;
        UnicastProcessor<T> f35500g;

        WindowExactSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, int i) {
            super(1);
            this.f35494a = subscriber;
            this.f35495b = j;
            this.f35497d = i;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35499f, subscription)) {
                this.f35499f = subscription;
                this.f35494a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            long j = this.f35498e;
            UnicastProcessor unicastProcessor = this.f35500g;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.m38167a(this.f35497d, this);
                this.f35500g = unicastProcessor;
                this.f35494a.onNext(unicastProcessor);
            }
            j++;
            unicastProcessor.onNext(t);
            if (j == this.f35495b) {
                this.f35498e = 0;
                this.f35500g = null;
                unicastProcessor.onComplete();
                return;
            }
            this.f35498e = j;
        }

        public final void onError(Throwable th) {
            Processor processor = this.f35500g;
            if (processor != null) {
                this.f35500g = null;
                processor.onError(th);
            }
            this.f35494a.onError(th);
        }

        public final void onComplete() {
            Processor processor = this.f35500g;
            if (processor != null) {
                this.f35500g = null;
                processor.onComplete();
            }
            this.f35494a.onComplete();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                this.f35499f.request(BackpressureHelper.m26671b(this.f35495b, j));
            }
        }

        public final void cancel() {
            if (this.f35496c.compareAndSet(false, true)) {
                run();
            }
        }

        public final void run() {
            if (decrementAndGet() == 0) {
                this.f35499f.cancel();
            }
        }
    }

    static final class WindowOverlapSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Runnable, Subscription {
        final Subscriber<? super Flowable<T>> f35501a;
        final SpscLinkedArrayQueue<UnicastProcessor<T>> f35502b;
        final long f35503c;
        final long f35504d;
        final ArrayDeque<UnicastProcessor<T>> f35505e = new ArrayDeque();
        final AtomicBoolean f35506f = new AtomicBoolean();
        final AtomicBoolean f35507g = new AtomicBoolean();
        final AtomicLong f35508h = new AtomicLong();
        final AtomicInteger f35509i = new AtomicInteger();
        final int f35510j;
        long f35511k;
        long f35512l;
        Subscription f35513m;
        volatile boolean f35514n;
        Throwable f35515o;
        volatile boolean f35516p;

        WindowOverlapSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, int i) {
            super(1);
            this.f35501a = subscriber;
            this.f35503c = j;
            this.f35504d = j2;
            this.f35502b = new SpscLinkedArrayQueue(i);
            this.f35510j = i;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35513m, subscription)) {
                this.f35513m = subscription;
                this.f35501a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f35514n) {
                long j = this.f35511k;
                if (j == 0 && !this.f35516p) {
                    getAndIncrement();
                    UnicastProcessor a = UnicastProcessor.m38167a(this.f35510j, this);
                    this.f35505e.offer(a);
                    this.f35502b.offer(a);
                    m35890a();
                }
                j++;
                Iterator it = this.f35505e.iterator();
                while (it.hasNext()) {
                    ((Processor) it.next()).onNext(t);
                }
                long j2 = this.f35512l + 1;
                if (j2 == this.f35503c) {
                    this.f35512l = j2 - this.f35504d;
                    Processor processor = (Processor) this.f35505e.poll();
                    if (processor != null) {
                        processor.onComplete();
                    }
                } else {
                    this.f35512l = j2;
                }
                if (j == this.f35504d) {
                    this.f35511k = 0;
                } else {
                    this.f35511k = j;
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f35514n) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            Iterator it = this.f35505e.iterator();
            while (it.hasNext()) {
                ((Processor) it.next()).onError(th);
            }
            this.f35505e.clear();
            this.f35515o = th;
            this.f35514n = true;
            m35890a();
        }

        public final void onComplete() {
            if (!this.f35514n) {
                Iterator it = this.f35505e.iterator();
                while (it.hasNext()) {
                    ((Processor) it.next()).onComplete();
                }
                this.f35505e.clear();
                this.f35514n = true;
                m35890a();
            }
        }

        private void m35890a() {
            if (this.f35509i.getAndIncrement() == 0) {
                Subscriber subscriber = this.f35501a;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f35502b;
                int i = 1;
                do {
                    int i2;
                    long j = this.f35508h.get();
                    long j2 = 0;
                    while (true) {
                        i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i2 == 0) {
                            break;
                        }
                        boolean z = this.f35514n;
                        UnicastProcessor unicastProcessor = (UnicastProcessor) spscLinkedArrayQueue.poll();
                        boolean z2 = unicastProcessor == null;
                        if (!m35891a(z, z2, subscriber, spscLinkedArrayQueue)) {
                            if (z2) {
                                break;
                            }
                            subscriber.onNext(unicastProcessor);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (i2 != 0 || !m35891a(this.f35514n, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                        if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                            this.f35508h.addAndGet(-j2);
                        }
                        i = this.f35509i.addAndGet(-i);
                    } else {
                        return;
                    }
                } while (i != 0);
            }
        }

        private boolean m35891a(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.f35516p) {
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (z) {
                z = this.f35515o;
                if (z) {
                    spscLinkedArrayQueue.clear();
                    subscriber.onError(z);
                    return true;
                } else if (z2) {
                    subscriber.onComplete();
                    return true;
                }
            }
            return false;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f35508h, j);
                if (this.f35507g.get() || !this.f35507g.compareAndSet(false, true)) {
                    this.f35513m.request(BackpressureHelper.m26671b(this.f35504d, j));
                } else {
                    this.f35513m.request(BackpressureHelper.m26669a(this.f35503c, BackpressureHelper.m26671b(this.f35504d, j - 1)));
                }
                m35890a();
            }
        }

        public final void cancel() {
            this.f35516p = true;
            if (this.f35506f.compareAndSet(false, true)) {
                run();
            }
        }

        public final void run() {
            if (decrementAndGet() == 0) {
                this.f35513m.cancel();
            }
        }
    }

    static final class WindowSkipSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Runnable, Subscription {
        final Subscriber<? super Flowable<T>> f35517a;
        final long f35518b;
        final long f35519c;
        final AtomicBoolean f35520d = new AtomicBoolean();
        final AtomicBoolean f35521e = new AtomicBoolean();
        final int f35522f;
        long f35523g;
        Subscription f35524h;
        UnicastProcessor<T> f35525i;

        WindowSkipSubscriber(Subscriber<? super Flowable<T>> subscriber, long j, long j2, int i) {
            super(1);
            this.f35517a = subscriber;
            this.f35518b = j;
            this.f35519c = j2;
            this.f35522f = i;
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f35524h, subscription)) {
                this.f35524h = subscription;
                this.f35517a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            long j = this.f35523g;
            UnicastProcessor unicastProcessor = this.f35525i;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.m38167a(this.f35522f, this);
                this.f35525i = unicastProcessor;
                this.f35517a.onNext(unicastProcessor);
            }
            j++;
            if (unicastProcessor != null) {
                unicastProcessor.onNext(t);
            }
            if (j == this.f35518b) {
                this.f35525i = null;
                unicastProcessor.onComplete();
            }
            if (j == this.f35519c) {
                this.f35523g = 0;
            } else {
                this.f35523g = j;
            }
        }

        public final void onError(Throwable th) {
            Processor processor = this.f35525i;
            if (processor != null) {
                this.f35525i = null;
                processor.onError(th);
            }
            this.f35517a.onError(th);
        }

        public final void onComplete() {
            Processor processor = this.f35525i;
            if (processor != null) {
                this.f35525i = null;
                processor.onComplete();
            }
            this.f35517a.onComplete();
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                if (this.f35521e.get() || !this.f35521e.compareAndSet(false, true)) {
                    this.f35524h.request(BackpressureHelper.m26671b(this.f35519c, j));
                } else {
                    this.f35524h.request(BackpressureHelper.m26669a(BackpressureHelper.m26671b(this.f35518b, j), BackpressureHelper.m26671b(this.f35519c - this.f35518b, j - 1)));
                }
            }
        }

        public final void cancel() {
            if (this.f35520d.compareAndSet(false, true)) {
                run();
            }
        }

        public final void run() {
            if (decrementAndGet() == 0) {
                this.f35524h.cancel();
            }
        }
    }

    public FlowableWindow(Flowable<T> flowable, long j, long j2, int i) {
        super(flowable);
        this.f37862a = j;
        this.f37863b = j2;
        this.f37864c = i;
    }

    public final void subscribeActual(Subscriber<? super Flowable<T>> subscriber) {
        if (this.f37863b == this.f37862a) {
            this.source.subscribe(new WindowExactSubscriber(subscriber, this.f37862a, this.f37864c));
        } else if (this.f37863b > this.f37862a) {
            this.source.subscribe(new WindowSkipSubscriber(subscriber, this.f37862a, this.f37863b, this.f37864c));
        } else {
            this.source.subscribe(new WindowOverlapSubscriber(subscriber, this.f37862a, this.f37863b, this.f37864c));
        }
    }
}
