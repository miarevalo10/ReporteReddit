package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.Operator;
import rx.Producer;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.schedulers.ImmediateScheduler;
import rx.internal.schedulers.TrampolineScheduler;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;

public final class OperatorObserveOn<T> implements Operator<T, T> {
    private final Scheduler f41983a;
    private final boolean f41984b = null;
    private final int f41985c;

    static final class ObserveOnSubscriber<T> extends Subscriber<T> implements Action0 {
        final Subscriber<? super T> f41972a;
        final Worker f41973b;
        final NotificationLite<T> f41974c;
        final boolean f41975e;
        final Queue<Object> f41976f;
        final int f41977g;
        volatile boolean f41978h;
        final AtomicLong f41979i = new AtomicLong();
        final AtomicLong f41980j = new AtomicLong();
        Throwable f41981k;
        long f41982l;

        class C31151 implements Producer {
            final /* synthetic */ ObserveOnSubscriber f41710a;

            C31151(ObserveOnSubscriber observeOnSubscriber) {
                this.f41710a = observeOnSubscriber;
            }

            public final void mo7901a(long j) {
                if (j > 0) {
                    BackpressureUtils.m43445a(this.f41710a.f41979i, j);
                    this.f41710a.m44083e();
                }
            }
        }

        public ObserveOnSubscriber(Scheduler scheduler, Subscriber<? super T> subscriber, boolean z, int i) {
            this.f41972a = subscriber;
            this.f41973b = scheduler.mo7895a();
            this.f41975e = z;
            this.f41974c = NotificationLite.m43450a();
            if (i <= 0) {
                i = RxRingBuffer.f41779b;
            }
            this.f41977g = i - (i >> 2);
            if (UnsafeAccess.m43484a() != null) {
                this.f41976f = new SpscArrayQueue(i);
            } else {
                this.f41976f = new SpscAtomicArrayQueue(i);
            }
            m43807a((long) (long) i);
        }

        public final void a_(T t) {
            if (!mo7894d()) {
                if (!this.f41978h) {
                    if (this.f41976f.offer(NotificationLite.m43448a((Object) t)) == null) {
                        mo7904a(new MissingBackpressureException());
                    } else {
                        m44083e();
                    }
                }
            }
        }

        public final void mo7906b() {
            if (!mo7894d()) {
                if (!this.f41978h) {
                    this.f41978h = true;
                    m44083e();
                }
            }
        }

        public final void mo7904a(Throwable th) {
            if (!mo7894d()) {
                if (!this.f41978h) {
                    this.f41981k = th;
                    this.f41978h = true;
                    m44083e();
                    return;
                }
            }
            RxJavaHooks.m43500a(th);
        }

        protected final void m44083e() {
            if (this.f41980j.getAndIncrement() == 0) {
                this.f41973b.mo7927a(this);
            }
        }

        public final void mo7898a() {
            long j = this.f41982l;
            Queue queue = this.f41976f;
            Subscriber subscriber = this.f41972a;
            long j2 = j;
            j = 1;
            do {
                long j3 = r0.f41979i.get();
                while (true) {
                    int i = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z = r0.f41978h;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (!m44079a(z, z2, subscriber, queue)) {
                        if (z2) {
                            break;
                        }
                        subscriber.a_(NotificationLite.m43454c(poll));
                        j2++;
                        if (j2 == ((long) r0.f41977g)) {
                            j3 = BackpressureUtils.m43447b(r0.f41979i, j2);
                            m43807a(j2);
                            j2 = 0;
                        }
                    } else {
                        return;
                    }
                }
                if (i != 0 || !m44079a(r0.f41978h, queue.isEmpty(), subscriber, queue)) {
                    r0.f41982l = j2;
                    j = r0.f41980j.addAndGet(-j);
                } else {
                    return;
                }
            } while (j != 0);
        }

        private boolean m44079a(boolean z, boolean z2, Subscriber<? super T> subscriber, Queue<Object> queue) {
            if (subscriber.mo7894d()) {
                queue.clear();
                return true;
            }
            if (z) {
                if (!this.f41975e) {
                    z = this.f41981k;
                    if (z) {
                        queue.clear();
                        try {
                            subscriber.mo7904a(z);
                            return true;
                        } finally {
                            this.f41973b.mo7893c();
                        }
                    } else if (z2) {
                        try {
                            subscriber.mo7906b();
                            return true;
                        } finally {
                            this.f41973b.mo7893c();
                        }
                    }
                } else if (z2) {
                    z = this.f41981k;
                    if (z) {
                        try {
                            subscriber.mo7904a(z);
                        } catch (Throwable th) {
                            this.f41973b.mo7893c();
                        }
                    } else {
                        subscriber.mo7906b();
                    }
                    this.f41973b.mo7893c();
                }
            }
            return false;
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        if ((this.f41983a instanceof ImmediateScheduler) || (this.f41983a instanceof TrampolineScheduler)) {
            return subscriber;
        }
        Subscription observeOnSubscriber = new ObserveOnSubscriber(this.f41983a, subscriber, this.f41984b, this.f41985c);
        obj = observeOnSubscriber.f41972a;
        obj.mo7929a(new C31151(observeOnSubscriber));
        obj.m43809a(observeOnSubscriber.f41973b);
        obj.m43809a(observeOnSubscriber);
        return observeOnSubscriber;
    }

    public OperatorObserveOn(Scheduler scheduler, int i) {
        this.f41983a = scheduler;
        if (i <= 0) {
            i = RxRingBuffer.f41779b;
        }
        this.f41985c = i;
    }
}
