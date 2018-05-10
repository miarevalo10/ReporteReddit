package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCombineLatest<T, R> extends Flowable<R> {
    final Publisher<? extends T>[] f34885a;
    final Iterable<? extends Publisher<? extends T>> f34886b;
    final Function<? super Object[], ? extends R> f34887c;
    final int f34888d;
    final boolean f34889e;

    final class SingletonArrayFunc implements Function<T, R> {
        final /* synthetic */ FlowableCombineLatest f31251a;

        SingletonArrayFunc(FlowableCombineLatest flowableCombineLatest) {
            this.f31251a = flowableCombineLatest;
        }

        public final R apply(T t) throws Exception {
            return this.f31251a.f34887c.apply(new Object[]{t});
        }
    }

    static final class CombineLatestInnerSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T> {
        final CombineLatestCoordinator<T, ?> f34880a;
        final int f34881b;
        final int f34882c;
        final int f34883d;
        int f34884e;

        CombineLatestInnerSubscriber(CombineLatestCoordinator<T, ?> combineLatestCoordinator, int i, int i2) {
            this.f34880a = combineLatestCoordinator;
            this.f34881b = i;
            this.f34882c = i2;
            this.f34883d = i2 - (i2 >> 2);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32779a((AtomicReference) this, subscription)) {
                subscription.request((long) this.f34882c);
            }
        }

        public final void onNext(T t) {
            this.f34880a.m39631a(this.f34881b, t);
        }

        public final void onError(Throwable th) {
            CombineLatestCoordinator combineLatestCoordinator = this.f34880a;
            int i = this.f34881b;
            if (!ExceptionHelper.m26684a(combineLatestCoordinator.f39395m, th)) {
                RxJavaPlugins.m26757a(th);
            } else if (combineLatestCoordinator.f39388f == null) {
                combineLatestCoordinator.m39632b();
                combineLatestCoordinator.f39394l = true;
                combineLatestCoordinator.m39630a();
            } else {
                combineLatestCoordinator.m39633b(i);
            }
        }

        public final void onComplete() {
            this.f34880a.m39633b(this.f34881b);
        }

        public final void m35664a() {
            int i = this.f34884e + 1;
            if (i == this.f34883d) {
                this.f34884e = 0;
                ((Subscription) get()).request((long) i);
                return;
            }
            this.f34884e = i;
        }
    }

    static final class CombineLatestCoordinator<T, R> extends BasicIntQueueSubscription<R> {
        final Subscriber<? super R> f39383a;
        final Function<? super Object[], ? extends R> f39384b;
        final CombineLatestInnerSubscriber<T>[] f39385c;
        final SpscLinkedArrayQueue<Object> f39386d;
        final Object[] f39387e;
        final boolean f39388f;
        boolean f39389g;
        int f39390h;
        int f39391i;
        volatile boolean f39392j;
        final AtomicLong f39393k;
        volatile boolean f39394l;
        final AtomicReference<Throwable> f39395m;

        CombineLatestCoordinator(Subscriber<? super R> subscriber, Function<? super Object[], ? extends R> function, int i, int i2, boolean z) {
            this.f39383a = subscriber;
            this.f39384b = function;
            subscriber = new CombineLatestInnerSubscriber[i];
            for (function = null; function < i; function++) {
                subscriber[function] = new CombineLatestInnerSubscriber(this, function, i2);
            }
            this.f39385c = subscriber;
            this.f39387e = new Object[i];
            this.f39386d = new SpscLinkedArrayQueue(i2);
            this.f39393k = new AtomicLong();
            this.f39395m = new AtomicReference();
            this.f39388f = z;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f39393k, j);
                m39630a();
            }
        }

        public final void cancel() {
            this.f39392j = true;
            m39632b();
        }

        final void m39631a(int i, T t) {
            synchronized (this) {
                Object obj = this.f39387e;
                T t2 = this.f39390h;
                if (obj[i] == null) {
                    t2++;
                    this.f39390h = t2;
                }
                obj[i] = t;
                if (obj.length == t2) {
                    this.f39386d.m35964a(this.f39385c[i], obj.clone());
                    t = null;
                } else {
                    t = true;
                }
            }
            if (t != null) {
                this.f39385c[i].m35664a();
            } else {
                m39630a();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final void m39633b(int r3) {
            /*
            r2 = this;
            monitor-enter(r2);
            r0 = r2.f39387e;	 Catch:{ all -> 0x001c }
            r3 = r0[r3];	 Catch:{ all -> 0x001c }
            r1 = 1;
            if (r3 == 0) goto L_0x0015;
        L_0x0008:
            r3 = r2.f39391i;	 Catch:{ all -> 0x001c }
            r3 = r3 + r1;
            r0 = r0.length;	 Catch:{ all -> 0x001c }
            if (r3 != r0) goto L_0x0011;
        L_0x000e:
            r2.f39394l = r1;	 Catch:{ all -> 0x001c }
            goto L_0x0017;
        L_0x0011:
            r2.f39391i = r3;	 Catch:{ all -> 0x001c }
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
            return;
        L_0x0015:
            r2.f39394l = r1;	 Catch:{ all -> 0x001c }
        L_0x0017:
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
            r2.m39630a();
            return;
        L_0x001c:
            r3 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x001c }
            throw r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCombineLatest.CombineLatestCoordinator.b(int):void");
        }

        final void m39630a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                Subscriber subscriber;
                SpscLinkedArrayQueue spscLinkedArrayQueue;
                if (this.f39389g) {
                    subscriber = this.f39383a;
                    spscLinkedArrayQueue = this.f39386d;
                    while (!this.f39392j) {
                        Throwable th = (Throwable) this.f39395m.get();
                        if (th != null) {
                            spscLinkedArrayQueue.clear();
                            subscriber.onError(th);
                            return;
                        }
                        boolean z = this.f39394l;
                        boolean isEmpty = spscLinkedArrayQueue.isEmpty();
                        if (!isEmpty) {
                            subscriber.onNext(null);
                        }
                        if (z && isEmpty) {
                            subscriber.onComplete();
                            return;
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                    spscLinkedArrayQueue.clear();
                    return;
                }
                subscriber = this.f39383a;
                spscLinkedArrayQueue = this.f39386d;
                int i2 = 1;
                loop1:
                do {
                    int i3;
                    long j = this.f39393k.get();
                    long j2 = 0;
                    while (true) {
                        i3 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i3 == 0) {
                            break;
                        }
                        boolean z2 = this.f39394l;
                        Object poll = spscLinkedArrayQueue.poll();
                        boolean z3 = poll == null;
                        if (!m39628a(z2, z3, subscriber, spscLinkedArrayQueue)) {
                            if (z3) {
                                break;
                            }
                            try {
                                subscriber.onNext(ObjectHelper.m26573a(this.f39384b.apply((Object[]) spscLinkedArrayQueue.poll()), "The combiner returned a null value"));
                                ((CombineLatestInnerSubscriber) poll).m35664a();
                                j2++;
                            } catch (Throwable th2) {
                                Exceptions.m26521b(th2);
                                m39632b();
                                ExceptionHelper.m26684a(this.f39395m, th2);
                                subscriber.onError(ExceptionHelper.m26683a(this.f39395m));
                                return;
                            }
                        }
                        break loop1;
                    }
                    if (i3 == 0 && m39628a(this.f39394l, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                        break;
                    }
                    if (!(j2 == 0 || j == Long.MAX_VALUE)) {
                        this.f39393k.addAndGet(-j2);
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        private boolean m39628a(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.f39392j) {
                m39632b();
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (z) {
                if (!this.f39388f) {
                    z = ExceptionHelper.m26683a(this.f39395m);
                    if (z && z != ExceptionHelper.f25187a) {
                        m39632b();
                        spscLinkedArrayQueue.clear();
                        subscriber.onError(z);
                        return true;
                    } else if (z2) {
                        m39632b();
                        subscriber.onComplete();
                        return true;
                    }
                } else if (z2) {
                    m39632b();
                    z = ExceptionHelper.m26683a(this.f39395m);
                    if (!z || z == ExceptionHelper.f25187a) {
                        subscriber.onComplete();
                    } else {
                        subscriber.onError(z);
                    }
                    return true;
                }
            }
            return false;
        }

        final void m39632b() {
            for (AtomicReference a : this.f39385c) {
                SubscriptionHelper.m32777a(a);
            }
        }

        public final int mo7033a(int i) {
            boolean z = false;
            if ((i & 4) != 0) {
                return 0;
            }
            i &= 2;
            if (i != 0) {
                z = true;
            }
            this.f39389g = z;
            return i;
        }

        public final R poll() throws Exception {
            Object poll = this.f39386d.poll();
            if (poll == null) {
                return null;
            }
            R a = ObjectHelper.m26573a(this.f39384b.apply((Object[]) this.f39386d.poll()), "The combiner returned a null value");
            ((CombineLatestInnerSubscriber) poll).m35664a();
            return a;
        }

        public final void clear() {
            this.f39386d.clear();
        }

        public final boolean isEmpty() {
            return this.f39386d.isEmpty();
        }
    }

    public FlowableCombineLatest(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.f34885a = publisherArr;
        this.f34886b = null;
        this.f34887c = function;
        this.f34888d = i;
        this.f34889e = z;
    }

    public FlowableCombineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i, boolean z) {
        this.f34885a = null;
        this.f34886b = iterable;
        this.f34887c = function;
        this.f34888d = i;
        this.f34889e = z;
    }

    public final void subscribeActual(Subscriber<? super R> subscriber) {
        Object obj = this.f34885a;
        int i = 0;
        int i2;
        if (obj == null) {
            obj = new Publisher[8];
            try {
                Iterator it = (Iterator) ObjectHelper.m26573a(this.f34886b.iterator(), "The iterator returned is null");
                i2 = 0;
                while (it.hasNext()) {
                    try {
                        try {
                            Publisher publisher = (Publisher) ObjectHelper.m26573a(it.next(), "The publisher returned by the iterator is null");
                            if (i2 == obj.length) {
                                Object obj2 = new Publisher[((i2 >> 2) + i2)];
                                System.arraycopy(obj, 0, obj2, 0, i2);
                                obj = obj2;
                            }
                            int i3 = i2 + 1;
                            obj[i2] = publisher;
                            i2 = i3;
                        } catch (Throwable th) {
                            Exceptions.m26521b(th);
                            EmptySubscription.m38160a(th, subscriber);
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.m26521b(th2);
                        EmptySubscription.m38160a(th2, subscriber);
                        return;
                    }
                }
            } catch (Throwable th22) {
                Exceptions.m26521b(th22);
                EmptySubscription.m38160a(th22, subscriber);
                return;
            }
        }
        i2 = obj.length;
        if (i2 == 0) {
            EmptySubscription.m38161a((Subscriber) subscriber);
        } else if (i2 == 1) {
            obj[0].subscribe(new MapSubscriber(subscriber, new SingletonArrayFunc(this)));
        } else {
            CombineLatestCoordinator combineLatestCoordinator = new CombineLatestCoordinator(subscriber, this.f34887c, i2, this.f34888d, this.f34889e);
            subscriber.mo5623a(combineLatestCoordinator);
            subscriber = combineLatestCoordinator.f39385c;
            while (i < i2 && !combineLatestCoordinator.f39394l) {
                if (combineLatestCoordinator.f39392j) {
                    break;
                }
                obj[i].subscribe(subscriber[i]);
                i++;
            }
        }
    }
}
