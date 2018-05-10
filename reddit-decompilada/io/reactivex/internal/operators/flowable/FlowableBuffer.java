package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
    final int f37642a;
    final int f37643b;
    final Callable<C> f37644c;

    static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super C> f34822a;
        final Callable<C> f34823b;
        final int f34824c;
        C f34825d;
        Subscription f34826e;
        boolean f34827f;
        int f34828g;

        PublisherBufferExactSubscriber(Subscriber<? super C> subscriber, int i, Callable<C> callable) {
            this.f34822a = subscriber;
            this.f34824c = i;
            this.f34823b = callable;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                this.f34826e.request(BackpressureHelper.m26671b(j, (long) this.f34824c));
            }
        }

        public final void cancel() {
            this.f34826e.cancel();
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34826e, subscription)) {
                this.f34826e = subscription;
                this.f34822a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f34827f) {
                Collection collection = this.f34825d;
                if (collection == null) {
                    try {
                        collection = (Collection) ObjectHelper.m26573a(this.f34823b.call(), "The bufferSupplier returned a null buffer");
                        this.f34825d = collection;
                    } catch (T t2) {
                        Exceptions.m26521b(t2);
                        cancel();
                        onError(t2);
                        return;
                    }
                }
                collection.add(t2);
                t2 = this.f34828g + 1;
                if (t2 == this.f34824c) {
                    this.f34828g = null;
                    this.f34825d = null;
                    this.f34822a.onNext(collection);
                    return;
                }
                this.f34828g = t2;
            }
        }

        public final void onError(Throwable th) {
            if (this.f34827f) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34827f = true;
            this.f34822a.onError(th);
        }

        public final void onComplete() {
            if (!this.f34827f) {
                this.f34827f = true;
                Collection collection = this.f34825d;
                if (!(collection == null || collection.isEmpty())) {
                    this.f34822a.onNext(collection);
                }
                this.f34822a.onComplete();
            }
        }
    }

    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, BooleanSupplier, Subscription {
        final Subscriber<? super C> f34829a;
        final Callable<C> f34830b;
        final int f34831c;
        final int f34832d;
        final ArrayDeque<C> f34833e = new ArrayDeque();
        final AtomicBoolean f34834f = new AtomicBoolean();
        Subscription f34835g;
        boolean f34836h;
        int f34837i;
        volatile boolean f34838j;
        long f34839k;

        PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int i, int i2, Callable<C> callable) {
            this.f34829a = subscriber;
            this.f34831c = i;
            this.f34832d = i2;
            this.f34830b = callable;
        }

        public final boolean mo6617a() {
            return this.f34838j;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                if (!QueueDrainHelper.m26730a(j, this.f34829a, this.f34833e, this, this)) {
                    if (this.f34834f.get() || !this.f34834f.compareAndSet(false, true)) {
                        this.f34835g.request(BackpressureHelper.m26671b((long) this.f34832d, j));
                    } else {
                        this.f34835g.request(BackpressureHelper.m26669a((long) this.f34831c, BackpressureHelper.m26671b((long) this.f34832d, j - 1)));
                    }
                }
            }
        }

        public final void cancel() {
            this.f34838j = true;
            this.f34835g.cancel();
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34835g, subscription)) {
                this.f34835g = subscription;
                this.f34829a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f34836h) {
                ArrayDeque arrayDeque = this.f34833e;
                int i = this.f34837i;
                int i2 = i + 1;
                if (i == 0) {
                    try {
                        arrayDeque.offer((Collection) ObjectHelper.m26573a(this.f34830b.call(), "The bufferSupplier returned a null buffer"));
                    } catch (T t2) {
                        Exceptions.m26521b(t2);
                        cancel();
                        onError(t2);
                        return;
                    }
                }
                Collection collection = (Collection) arrayDeque.peek();
                if (collection != null && collection.size() + 1 == this.f34831c) {
                    arrayDeque.poll();
                    collection.add(t2);
                    this.f34839k++;
                    this.f34829a.onNext(collection);
                }
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(t2);
                }
                if (i2 == this.f34832d) {
                    i2 = 0;
                }
                this.f34837i = i2;
            }
        }

        public final void onError(Throwable th) {
            if (this.f34836h) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34836h = true;
            this.f34833e.clear();
            this.f34829a.onError(th);
        }

        public final void onComplete() {
            if (!this.f34836h) {
                this.f34836h = true;
                long j = this.f34839k;
                if (j != 0) {
                    BackpressureHelper.m26673c(this, j);
                }
                QueueDrainHelper.m26728a(this.f34829a, this.f34833e, (AtomicLong) this, (BooleanSupplier) this);
            }
        }
    }

    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        final Subscriber<? super C> f34840a;
        final Callable<C> f34841b;
        final int f34842c;
        final int f34843d;
        C f34844e;
        Subscription f34845f;
        boolean f34846g;
        int f34847h;

        PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int i, int i2, Callable<C> callable) {
            this.f34840a = subscriber;
            this.f34842c = i;
            this.f34843d = i2;
            this.f34841b = callable;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f34845f.request(BackpressureHelper.m26669a(BackpressureHelper.m26671b(j, (long) this.f34842c), BackpressureHelper.m26671b((long) (this.f34843d - this.f34842c), j - 1)));
                    return;
                }
                this.f34845f.request(BackpressureHelper.m26671b((long) this.f34843d, j));
            }
        }

        public final void cancel() {
            this.f34845f.cancel();
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f34845f, subscription)) {
                this.f34845f = subscription;
                this.f34840a.mo5623a(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f34846g) {
                Collection collection = this.f34844e;
                int i = this.f34847h;
                int i2 = i + 1;
                if (i == 0) {
                    try {
                        collection = (Collection) ObjectHelper.m26573a(this.f34841b.call(), "The bufferSupplier returned a null buffer");
                        this.f34844e = collection;
                    } catch (T t2) {
                        Exceptions.m26521b(t2);
                        cancel();
                        onError(t2);
                        return;
                    }
                }
                if (collection != null) {
                    collection.add(t2);
                    if (collection.size() == this.f34842c) {
                        this.f34844e = null;
                        this.f34840a.onNext(collection);
                    }
                }
                if (i2 == this.f34843d) {
                    i2 = 0;
                }
                this.f34847h = i2;
            }
        }

        public final void onError(Throwable th) {
            if (this.f34846g) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f34846g = true;
            this.f34844e = null;
            this.f34840a.onError(th);
        }

        public final void onComplete() {
            if (!this.f34846g) {
                this.f34846g = true;
                Collection collection = this.f34844e;
                this.f34844e = null;
                if (collection != null) {
                    this.f34840a.onNext(collection);
                }
                this.f34840a.onComplete();
            }
        }
    }

    public FlowableBuffer(Flowable<T> flowable, int i, int i2, Callable<C> callable) {
        super(flowable);
        this.f37642a = i;
        this.f37643b = i2;
        this.f37644c = callable;
    }

    public final void subscribeActual(Subscriber<? super C> subscriber) {
        if (this.f37642a == this.f37643b) {
            this.source.subscribe(new PublisherBufferExactSubscriber(subscriber, this.f37642a, this.f37644c));
        } else if (this.f37643b > this.f37642a) {
            this.source.subscribe(new PublisherBufferSkipSubscriber(subscriber, this.f37642a, this.f37643b, this.f37644c));
        } else {
            this.source.subscribe(new PublisherBufferOverlappingSubscriber(subscriber, this.f37642a, this.f37643b, this.f37644c));
        }
    }
}
