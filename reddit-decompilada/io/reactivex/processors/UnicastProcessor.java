package io.reactivex.processors;

import io.reactivex.Flowable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class UnicastProcessor<T> extends FlowableProcessor<T> {
    final SpscLinkedArrayQueue<T> f38153a;
    final AtomicReference<Runnable> f38154b;
    final boolean f38155c;
    volatile boolean f38156d;
    Throwable f38157e;
    final AtomicReference<Subscriber<? super T>> f38158f;
    volatile boolean f38159g;
    final AtomicBoolean f38160h;
    final BasicIntQueueSubscription<T> f38161i;
    final AtomicLong f38162j;
    boolean f38163k;

    final class UnicastQueueSubscription extends BasicIntQueueSubscription<T> {
        final /* synthetic */ UnicastProcessor f39689a;

        UnicastQueueSubscription(UnicastProcessor unicastProcessor) {
            this.f39689a = unicastProcessor;
        }

        public final T poll() {
            return this.f39689a.f38153a.poll();
        }

        public final boolean isEmpty() {
            return this.f39689a.f38153a.isEmpty();
        }

        public final void clear() {
            this.f39689a.f38153a.clear();
        }

        public final int mo7033a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f39689a.f38163k = true;
            return 2;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f39689a.f38162j, j);
                this.f39689a.m38172d();
            }
        }

        public final void cancel() {
            if (!this.f39689a.f38159g) {
                this.f39689a.f38159g = true;
                this.f39689a.m38171c();
                if (!this.f39689a.f38163k && this.f39689a.f38161i.getAndIncrement() == 0) {
                    this.f39689a.f38153a.clear();
                    this.f39689a.f38158f.lazySet(null);
                }
            }
        }
    }

    public static <T> UnicastProcessor<T> m38169b() {
        return new UnicastProcessor(Flowable.bufferSize());
    }

    public static <T> UnicastProcessor<T> m38166a(int i) {
        return new UnicastProcessor(i);
    }

    public static <T> UnicastProcessor<T> m38167a(int i, Runnable runnable) {
        ObjectHelper.m26573a((Object) runnable, "onTerminate");
        return new UnicastProcessor(i, runnable);
    }

    private UnicastProcessor(int i) {
        this(i, null, (byte) 0);
    }

    private UnicastProcessor(int i, Runnable runnable) {
        this(i, runnable, (byte) 0);
    }

    private UnicastProcessor(int i, Runnable runnable, byte b) {
        this.f38153a = new SpscLinkedArrayQueue(ObjectHelper.m26569a(i, "capacityHint"));
        this.f38154b = new AtomicReference(runnable);
        this.f38155c = true;
        this.f38158f = new AtomicReference();
        this.f38160h = new AtomicBoolean();
        this.f38161i = new UnicastQueueSubscription(this);
        this.f38162j = new AtomicLong();
    }

    final void m38171c() {
        Runnable runnable = (Runnable) this.f38154b.get();
        if (runnable != null && this.f38154b.compareAndSet(runnable, null)) {
            runnable.run();
        }
    }

    final void m38172d() {
        if (this.f38161i.getAndIncrement() == 0) {
            boolean z = true;
            Subscriber subscriber = (Subscriber) r6.f38158f.get();
            int i = 1;
            while (subscriber == null) {
                i = r6.f38161i.addAndGet(-i);
                if (i != 0) {
                    subscriber = (Subscriber) r6.f38158f.get();
                    z = true;
                } else {
                    return;
                }
            }
            boolean z2;
            if (r6.f38163k) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = r6.f38153a;
                int i2 = r6.f38155c ^ z;
                while (!r6.f38159g) {
                    z2 = r6.f38156d;
                    if (i2 == 0 || !z2 || r6.f38157e == null) {
                        subscriber.onNext(null);
                        if (z2) {
                            r6.f38158f.lazySet(null);
                            Throwable th = r6.f38157e;
                            if (th != null) {
                                subscriber.onError(th);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                        int addAndGet = r6.f38161i.addAndGet(-addAndGet);
                        if (addAndGet == 0) {
                            return;
                        }
                    }
                    spscLinkedArrayQueue.clear();
                    r6.f38158f.lazySet(null);
                    subscriber.onError(r6.f38157e);
                    return;
                }
                spscLinkedArrayQueue.clear();
                r6.f38158f.lazySet(null);
                return;
            }
            SpscLinkedArrayQueue spscLinkedArrayQueue2 = r6.f38153a;
            boolean z3 = r6.f38155c ^ 1;
            int i3 = z;
            loop2:
            while (true) {
                int i4;
                long j;
                long j2 = r6.f38162j.get();
                long j3 = 0;
                while (true) {
                    i4 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
                    if (i4 == 0) {
                        break;
                    }
                    z2 = r6.f38156d;
                    Object poll = spscLinkedArrayQueue2.poll();
                    boolean z4 = poll == null ? z : false;
                    Object obj = poll;
                    j = j3;
                    if (!m38168a(z3, z2, z4, subscriber, spscLinkedArrayQueue2)) {
                        if (z4) {
                            break;
                        }
                        subscriber.onNext(obj);
                        j3 = j + 1;
                        z = true;
                    } else {
                        break loop2;
                    }
                }
                j = j3;
                if (i4 == 0) {
                    if (m38168a(z3, r6.f38156d, spscLinkedArrayQueue2.isEmpty(), subscriber, spscLinkedArrayQueue2)) {
                        break;
                    }
                }
                if (!(j == 0 || j2 == Long.MAX_VALUE)) {
                    r6.f38162j.addAndGet(-j);
                }
                i3 = r6.f38161i.addAndGet(-i3);
                if (i3 == 0) {
                    break;
                }
                z = true;
            }
        }
    }

    private boolean m38168a(boolean z, boolean z2, boolean z3, Subscriber<? super T> subscriber, SpscLinkedArrayQueue<T> spscLinkedArrayQueue) {
        if (this.f38159g) {
            spscLinkedArrayQueue.clear();
            this.f38158f.lazySet(null);
            return true;
        }
        if (z2) {
            if (z && this.f38157e) {
                spscLinkedArrayQueue.clear();
                this.f38158f.lazySet(null);
                subscriber.onError(this.f38157e);
                return true;
            } else if (z3) {
                z = this.f38157e;
                this.f38158f.lazySet(null);
                if (z) {
                    subscriber.onError(z);
                } else {
                    subscriber.onComplete();
                }
                return true;
            }
        }
        return false;
    }

    public final void mo5623a(Subscription subscription) {
        if (!this.f38156d) {
            if (!this.f38159g) {
                subscription.request(Long.MAX_VALUE);
                return;
            }
        }
        subscription.cancel();
    }

    public final void onNext(T t) {
        ObjectHelper.m26573a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f38156d) {
            if (!this.f38159g) {
                this.f38153a.offer(t);
                m38172d();
            }
        }
    }

    public final void onError(Throwable th) {
        ObjectHelper.m26573a((Object) th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f38156d) {
            if (!this.f38159g) {
                this.f38157e = th;
                this.f38156d = true;
                m38171c();
                m38172d();
                return;
            }
        }
        RxJavaPlugins.m26757a(th);
    }

    public final void onComplete() {
        if (!this.f38156d) {
            if (!this.f38159g) {
                this.f38156d = true;
                m38171c();
                m38172d();
            }
        }
    }

    protected final void subscribeActual(Subscriber<? super T> subscriber) {
        if (this.f38160h.get() || !this.f38160h.compareAndSet(false, true)) {
            EmptySubscription.m38160a(new IllegalStateException("This processor allows only a single Subscriber"), subscriber);
            return;
        }
        subscriber.mo5623a(this.f38161i);
        this.f38158f.set(subscriber);
        if (this.f38159g != null) {
            this.f38158f.lazySet(null);
        } else {
            m38172d();
        }
    }
}
