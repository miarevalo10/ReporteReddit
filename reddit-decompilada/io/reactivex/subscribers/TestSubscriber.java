package io.reactivex.subscribers;

import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.fuseable.QueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements FlowableSubscriber<T>, Disposable, Subscription {
    private final Subscriber<? super T> f35970i;
    private volatile boolean f35971j;
    private final AtomicReference<Subscription> f35972k;
    private final AtomicLong f35973l;
    private QueueSubscription<T> f35974m;

    enum EmptySubscriber implements FlowableSubscriber<Object> {
        ;

        public final void mo5623a(Subscription subscription) {
        }

        public final void onComplete() {
        }

        public final void onError(Throwable th) {
        }

        public final void onNext(Object obj) {
        }

        private EmptySubscriber(String str) {
        }
    }

    public TestSubscriber() {
        this(EmptySubscriber.f35968a, Long.MAX_VALUE);
    }

    public TestSubscriber(long j) {
        this(EmptySubscriber.f35968a, j);
    }

    private TestSubscriber(Subscriber<? super T> subscriber, long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Negative initial request not allowed");
        }
        this.f35970i = subscriber;
        this.f35972k = new AtomicReference();
        this.f35973l = new AtomicLong(j);
    }

    public final void mo5623a(Subscription subscription) {
        this.e = Thread.currentThread();
        if (subscription == null) {
            this.c.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (this.f35972k.compareAndSet(null, subscription)) {
            if (this.g != 0 && (subscription instanceof QueueSubscription)) {
                this.f35974m = (QueueSubscription) subscription;
                int a = this.f35974m.mo7033a(this.g);
                this.h = a;
                if (a == 1) {
                    this.f = true;
                    this.e = Thread.currentThread();
                    while (true) {
                        try {
                            subscription = this.f35974m.poll();
                            if (subscription != null) {
                                this.b.add(subscription);
                            } else {
                                this.d++;
                                return;
                            }
                        } catch (Subscription subscription2) {
                            this.c.add(subscription2);
                            return;
                        }
                    }
                }
            }
            this.f35970i.mo5623a(subscription2);
            long andSet = this.f35973l.getAndSet(0);
            if (andSet != 0) {
                subscription2.request(andSet);
            }
        } else {
            subscription2.cancel();
            if (this.f35972k.get() != SubscriptionHelper.f32454a) {
                List list = this.c;
                StringBuilder stringBuilder = new StringBuilder("onSubscribe received multiple subscriptions: ");
                stringBuilder.append(subscription2);
                list.add(new IllegalStateException(stringBuilder.toString()));
            }
        }
    }

    public void onNext(T t) {
        if (!this.f) {
            this.f = true;
            if (this.f35972k.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.e = Thread.currentThread();
        if (this.h == 2) {
            while (true) {
                try {
                    t = this.f35974m.poll();
                    if (t != null) {
                        this.b.add(t);
                    } else {
                        return;
                    }
                } catch (T t2) {
                    this.c.add(t2);
                    this.f35974m.cancel();
                    return;
                }
            }
        }
        this.b.add(t2);
        if (t2 == null) {
            this.c.add(new NullPointerException("onNext received a null value"));
        }
        this.f35970i.onNext(t2);
    }

    public void onError(Throwable th) {
        if (!this.f) {
            this.f = true;
            if (this.f35972k.get() == null) {
                this.c.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.e = Thread.currentThread();
            this.c.add(th);
            if (th == null) {
                this.c.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.f35970i.onError(th);
        } finally {
            this.a.countDown();
        }
    }

    public void onComplete() {
        if (!this.f) {
            this.f = true;
            if (this.f35972k.get() == null) {
                this.c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.e = Thread.currentThread();
            this.d++;
            this.f35970i.onComplete();
        } finally {
            this.a.countDown();
        }
    }

    public final void request(long j) {
        SubscriptionHelper.m32775a(this.f35972k, this.f35973l, j);
    }

    public final void cancel() {
        if (!this.f35971j) {
            this.f35971j = true;
            SubscriptionHelper.m32777a(this.f35972k);
        }
    }

    public final void mo5626a() {
        cancel();
    }

    public final boolean mo5627b() {
        return this.f35971j;
    }
}
