package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.GroupedFlowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableGroupBy<T, K, V> extends AbstractFlowableWithUpstream<T, GroupedFlowable<K, V>> {
    final Function<? super T, ? extends K> f37737a;
    final Function<? super T, ? extends V> f37738b;
    final int f37739c;
    final boolean f37740d;
    final Function<? super Consumer<Object>, ? extends Map<K, Object>> f37741e;

    static final class EvictionAction<K, V> implements Consumer<GroupedUnicast<K, V>> {
        final Queue<GroupedUnicast<K, V>> f31274a;

        public final /* synthetic */ void accept(Object obj) throws Exception {
            this.f31274a.offer((GroupedUnicast) obj);
        }

        EvictionAction(Queue<GroupedUnicast<K, V>> queue) {
            this.f31274a = queue;
        }
    }

    static final class GroupedUnicast<K, T> extends GroupedFlowable<K, T> {
        final State<T, K> f37736b;

        public static <T, K> GroupedUnicast<K, T> m38102a(K k, int i, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z) {
            return new GroupedUnicast(k, new State(i, groupBySubscriber, k, z));
        }

        private GroupedUnicast(K k, State<T, K> state) {
            super(k);
            this.f37736b = state;
        }

        protected final void subscribeActual(Subscriber<? super T> subscriber) {
            this.f37736b.subscribe(subscriber);
        }

        public final void m38103a() {
            State state = this.f37736b;
            state.f39476f = true;
            state.m39677a();
        }
    }

    public static final class GroupBySubscriber<T, K, V> extends BasicIntQueueSubscription<GroupedFlowable<K, V>> implements FlowableSubscriber<T> {
        static final Object f39455i = new Object();
        final Subscriber<? super GroupedFlowable<K, V>> f39456a;
        final Function<? super T, ? extends K> f39457b;
        final Function<? super T, ? extends V> f39458c;
        final int f39459d;
        final boolean f39460e;
        final Map<Object, GroupedUnicast<K, V>> f39461f;
        final SpscLinkedArrayQueue<GroupedFlowable<K, V>> f39462g;
        final Queue<GroupedUnicast<K, V>> f39463h;
        Subscription f39464j;
        final AtomicBoolean f39465k = new AtomicBoolean();
        final AtomicLong f39466l = new AtomicLong();
        final AtomicInteger f39467m = new AtomicInteger(1);
        Throwable f39468n;
        volatile boolean f39469o;
        boolean f39470p;

        public GroupBySubscriber(Subscriber<? super GroupedFlowable<K, V>> subscriber, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Map<Object, GroupedUnicast<K, V>> map, Queue<GroupedUnicast<K, V>> queue) {
            this.f39456a = subscriber;
            this.f39457b = function;
            this.f39458c = function2;
            this.f39459d = i;
            this.f39460e = z;
            this.f39461f = map;
            this.f39463h = queue;
            this.f39462g = new SpscLinkedArrayQueue(i);
        }

        public final void mo5623a(Subscription subscription) {
            if (SubscriptionHelper.m32781a(this.f39464j, subscription)) {
                this.f39464j = subscription;
                this.f39456a.mo5623a(this);
                subscription.request((long) this.f39459d);
            }
        }

        public final void onNext(T t) {
            if (!this.f39469o) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f39462g;
                try {
                    Object obj;
                    Object apply = this.f39457b.apply(t);
                    Object obj2 = null;
                    if (apply != null) {
                        obj = apply;
                    } else {
                        obj = f39455i;
                    }
                    GroupedUnicast groupedUnicast = (GroupedUnicast) this.f39461f.get(obj);
                    if (groupedUnicast == null) {
                        if (!this.f39465k.get()) {
                            groupedUnicast = GroupedUnicast.m38102a(apply, this.f39459d, this, this.f39460e);
                            this.f39461f.put(obj, groupedUnicast);
                            this.f39467m.getAndIncrement();
                            obj2 = 1;
                        } else {
                            return;
                        }
                    }
                    try {
                        t = ObjectHelper.m26573a(this.f39458c.apply(t), "The valueSelector returned null");
                        State state = groupedUnicast.f37736b;
                        state.f39472b.offer(t);
                        state.m39677a();
                        if (this.f39463h != null) {
                            while (true) {
                                GroupedUnicast groupedUnicast2 = (GroupedUnicast) this.f39463h.poll();
                                if (groupedUnicast2 == null) {
                                    break;
                                }
                                groupedUnicast2.m38103a();
                            }
                        }
                        if (obj2 != null) {
                            spscLinkedArrayQueue.offer(groupedUnicast);
                            m39671a();
                        }
                    } catch (T t2) {
                        Exceptions.m26521b(t2);
                        this.f39464j.cancel();
                        onError(t2);
                    }
                } catch (T t22) {
                    Exceptions.m26521b(t22);
                    this.f39464j.cancel();
                    onError(t22);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f39469o) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            for (GroupedUnicast groupedUnicast : this.f39461f.values()) {
                State state = groupedUnicast.f37736b;
                state.f39477g = th;
                state.f39476f = true;
                state.m39677a();
            }
            this.f39461f.clear();
            if (this.f39463h != null) {
                this.f39463h.clear();
            }
            this.f39468n = th;
            this.f39469o = true;
            m39671a();
        }

        public final void onComplete() {
            if (!this.f39469o) {
                for (GroupedUnicast a : this.f39461f.values()) {
                    a.m38103a();
                }
                this.f39461f.clear();
                if (this.f39463h != null) {
                    this.f39463h.clear();
                }
                this.f39469o = true;
                m39671a();
            }
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f39466l, j);
                m39671a();
            }
        }

        public final void cancel() {
            if (this.f39465k.compareAndSet(false, true) && this.f39467m.decrementAndGet() == 0) {
                this.f39464j.cancel();
            }
        }

        private void m39671a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                SpscLinkedArrayQueue spscLinkedArrayQueue;
                Subscriber subscriber;
                if (this.f39470p) {
                    spscLinkedArrayQueue = this.f39462g;
                    subscriber = this.f39456a;
                    while (!this.f39465k.get()) {
                        boolean z = this.f39469o;
                        if (z && !this.f39460e) {
                            Throwable th = this.f39468n;
                            if (th != null) {
                                spscLinkedArrayQueue.clear();
                                subscriber.onError(th);
                                return;
                            }
                        }
                        subscriber.onNext(null);
                        if (z) {
                            Throwable th2 = this.f39468n;
                            if (th2 != null) {
                                subscriber.onError(th2);
                                return;
                            } else {
                                subscriber.onComplete();
                                return;
                            }
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                    spscLinkedArrayQueue.clear();
                    return;
                }
                spscLinkedArrayQueue = this.f39462g;
                subscriber = this.f39456a;
                int i2 = 1;
                loop1:
                do {
                    int i3;
                    long j = this.f39466l.get();
                    long j2 = 0;
                    while (true) {
                        i3 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                        if (i3 == 0) {
                            break;
                        }
                        boolean z2 = this.f39469o;
                        GroupedFlowable groupedFlowable = (GroupedFlowable) spscLinkedArrayQueue.poll();
                        boolean z3 = groupedFlowable == null;
                        if (!m39672a(z2, z3, subscriber, spscLinkedArrayQueue)) {
                            if (z3) {
                                break;
                            }
                            subscriber.onNext(groupedFlowable);
                            j2++;
                        } else {
                            break loop1;
                        }
                    }
                    if (i3 == 0 && m39672a(this.f39469o, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue)) {
                        break;
                    }
                    if (j2 != 0) {
                        if (j != Long.MAX_VALUE) {
                            this.f39466l.addAndGet(-j2);
                        }
                        this.f39464j.request(j2);
                    }
                    i2 = addAndGet(-i2);
                } while (i2 != 0);
            }
        }

        private boolean m39672a(boolean z, boolean z2, Subscriber<?> subscriber, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            if (this.f39465k.get()) {
                spscLinkedArrayQueue.clear();
                return true;
            }
            if (this.f39460e) {
                if (z && z2) {
                    z = this.f39468n;
                    if (z) {
                        subscriber.onError(z);
                    } else {
                        subscriber.onComplete();
                    }
                    return true;
                }
            } else if (z) {
                z = this.f39468n;
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

        public final int mo7033a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f39470p = true;
            return 2;
        }

        public final void clear() {
            this.f39462g.clear();
        }

        public final boolean isEmpty() {
            return this.f39462g.isEmpty();
        }

        public final /* bridge */ /* synthetic */ Object poll() throws Exception {
            return (GroupedFlowable) this.f39462g.poll();
        }
    }

    static final class State<T, K> extends BasicIntQueueSubscription<T> implements Publisher<T> {
        final K f39471a;
        final SpscLinkedArrayQueue<T> f39472b;
        final GroupBySubscriber<?, K, T> f39473c;
        final boolean f39474d;
        final AtomicLong f39475e = new AtomicLong();
        volatile boolean f39476f;
        Throwable f39477g;
        final AtomicBoolean f39478h = new AtomicBoolean();
        final AtomicReference<Subscriber<? super T>> f39479i = new AtomicReference();
        final AtomicBoolean f39480j = new AtomicBoolean();
        boolean f39481k;
        int f39482l;

        State(int i, GroupBySubscriber<?, K, T> groupBySubscriber, K k, boolean z) {
            this.f39472b = new SpscLinkedArrayQueue(i);
            this.f39473c = groupBySubscriber;
            this.f39471a = k;
            this.f39474d = z;
        }

        public final void request(long j) {
            if (SubscriptionHelper.m32776a(j)) {
                BackpressureHelper.m26670a(this.f39475e, j);
                m39677a();
            }
        }

        public final void cancel() {
            if (this.f39478h.compareAndSet(false, true)) {
                GroupBySubscriber groupBySubscriber = this.f39473c;
                Object obj = this.f39471a;
                if (obj == null) {
                    obj = GroupBySubscriber.f39455i;
                }
                groupBySubscriber.f39461f.remove(obj);
                if (groupBySubscriber.f39467m.decrementAndGet() == 0) {
                    groupBySubscriber.f39464j.cancel();
                    if (groupBySubscriber.getAndIncrement() == 0) {
                        groupBySubscriber.f39462g.clear();
                    }
                }
            }
        }

        public final void subscribe(Subscriber<? super T> subscriber) {
            if (this.f39480j.compareAndSet(false, true)) {
                subscriber.mo5623a(this);
                this.f39479i.lazySet(subscriber);
                m39677a();
                return;
            }
            EmptySubscription.m38160a(new IllegalStateException("Only one Subscriber allowed!"), subscriber);
        }

        final void m39677a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                SpscLinkedArrayQueue spscLinkedArrayQueue;
                if (this.f39481k) {
                    spscLinkedArrayQueue = this.f39472b;
                    Subscriber subscriber = (Subscriber) this.f39479i.get();
                    while (true) {
                        if (subscriber != null) {
                            if (!this.f39478h.get()) {
                                boolean z = this.f39476f;
                                if (z && !this.f39474d) {
                                    Throwable th = this.f39477g;
                                    if (th != null) {
                                        spscLinkedArrayQueue.clear();
                                        subscriber.onError(th);
                                        return;
                                    }
                                }
                                subscriber.onNext(null);
                                if (z) {
                                    break;
                                }
                            }
                            spscLinkedArrayQueue.clear();
                            return;
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                        if (subscriber == null) {
                            subscriber = (Subscriber) this.f39479i.get();
                        }
                    }
                    Throwable th2 = this.f39477g;
                    if (th2 != null) {
                        subscriber.onError(th2);
                        return;
                    } else {
                        subscriber.onComplete();
                        return;
                    }
                }
                spscLinkedArrayQueue = this.f39472b;
                boolean z2 = this.f39474d;
                Subscriber subscriber2 = (Subscriber) this.f39479i.get();
                int i2 = 1;
                loop1:
                while (true) {
                    if (subscriber2 != null) {
                        int i3;
                        long j = this.f39475e.get();
                        long j2 = 0;
                        while (true) {
                            i3 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                            if (i3 == 0) {
                                break;
                            }
                            boolean z3 = this.f39476f;
                            Object poll = spscLinkedArrayQueue.poll();
                            boolean z4 = poll == null;
                            if (!m39675a(z3, z4, subscriber2, z2)) {
                                if (z4) {
                                    break;
                                }
                                subscriber2.onNext(poll);
                                j2++;
                            } else {
                                break loop1;
                            }
                        }
                        if (i3 == 0 && m39675a(this.f39476f, spscLinkedArrayQueue.isEmpty(), subscriber2, z2)) {
                            break;
                        } else if (j2 != 0) {
                            if (j != Long.MAX_VALUE) {
                                this.f39475e.addAndGet(-j2);
                            }
                            this.f39473c.f39464j.request(j2);
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        break;
                    } else if (subscriber2 == null) {
                        subscriber2 = (Subscriber) this.f39479i.get();
                    }
                }
            }
        }

        private boolean m39675a(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.f39478h.get()) {
                this.f39472b.clear();
                return true;
            }
            if (z) {
                if (!z3) {
                    z = this.f39477g;
                    if (z) {
                        this.f39472b.clear();
                        subscriber.onError(z);
                        return true;
                    } else if (z2) {
                        subscriber.onComplete();
                        return true;
                    }
                } else if (z2) {
                    z = this.f39477g;
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

        public final int mo7033a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f39481k = true;
            return 2;
        }

        public final T poll() {
            T poll = this.f39472b.poll();
            if (poll != null) {
                this.f39482l++;
                return poll;
            }
            int i = this.f39482l;
            if (i != 0) {
                this.f39482l = 0;
                this.f39473c.f39464j.request((long) i);
            }
            return null;
        }

        public final boolean isEmpty() {
            return this.f39472b.isEmpty();
        }

        public final void clear() {
            this.f39472b.clear();
        }
    }

    public FlowableGroupBy(Flowable<T> flowable, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        super(flowable);
        this.f37737a = function;
        this.f37738b = function2;
        this.f37739c = i;
        this.f37740d = z;
        this.f37741e = function3;
    }

    protected final void subscribeActual(Subscriber<? super GroupedFlowable<K, V>> subscriber) {
        try {
            Queue queue;
            ConcurrentHashMap concurrentHashMap;
            if (this.f37741e == null) {
                queue = null;
                concurrentHashMap = new ConcurrentHashMap();
            } else {
                queue = new ConcurrentLinkedQueue();
                Map map = (Map) this.f37741e.apply(new EvictionAction(queue));
            }
            this.source.subscribe(new GroupBySubscriber(subscriber, this.f37737a, this.f37738b, this.f37739c, this.f37740d, concurrentHashMap, queue));
        } catch (Throwable e) {
            Exceptions.m26521b(e);
            subscriber.mo5623a(EmptyComponent.f35937a);
            subscriber.onError(e);
        }
    }
}
