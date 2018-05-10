package rx.internal.operators;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

public final class OperatorMerge<T> implements Operator<T, Observable<? extends T>> {
    final boolean f41970a = false;
    final int f41971b;

    static final class HolderNoDelay {
        static final OperatorMerge<Object> f41324a = new OperatorMerge(RedditJobManager.f10810d);
    }

    static final class MergeProducer<T> extends AtomicLong implements Producer {
        final MergeSubscriber<T> f41709a;

        public MergeProducer(MergeSubscriber<T> mergeSubscriber) {
            this.f41709a = mergeSubscriber;
        }

        public final void mo7901a(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i > 0) {
                if (get() != Long.MAX_VALUE) {
                    BackpressureUtils.m43445a((AtomicLong) this, j);
                    this.f41709a.m44076f();
                }
            } else if (i < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }
    }

    static final class InnerSubscriber<T> extends Subscriber<T> {
        static final int f41945g = (RxRingBuffer.f41779b / 4);
        final MergeSubscriber<T> f41946a;
        final long f41947b;
        volatile boolean f41948c;
        volatile RxRingBuffer f41949e;
        int f41950f;

        public InnerSubscriber(MergeSubscriber<T> mergeSubscriber, long j) {
            this.f41946a = mergeSubscriber;
            this.f41947b = j;
        }

        public final void aV_() {
            this.f41950f = RxRingBuffer.f41779b;
            m43807a((long) RxRingBuffer.f41779b);
        }

        public final void a_(T t) {
            this.f41946a.m44073a(this, t);
        }

        public final void mo7904a(Throwable th) {
            this.f41948c = true;
            this.f41946a.m44075e().offer(th);
            this.f41946a.m44076f();
        }

        public final void mo7906b() {
            this.f41948c = true;
            this.f41946a.m44076f();
        }

        public final void m44065b(long j) {
            int i = this.f41950f - ((int) j);
            if (i > f41945g) {
                this.f41950f = i;
                return;
            }
            this.f41950f = RxRingBuffer.f41779b;
            j = RxRingBuffer.f41779b - i;
            if (j > null) {
                m43807a((long) j);
            }
        }
    }

    static final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final InnerSubscriber<?>[] f41951r = new InnerSubscriber[0];
        final Subscriber<? super T> f41952a;
        final boolean f41953b;
        final int f41954c;
        MergeProducer<T> f41955e;
        volatile Queue<Object> f41956f;
        volatile CompositeSubscription f41957g;
        volatile ConcurrentLinkedQueue<Throwable> f41958h;
        final NotificationLite<T> f41959i = NotificationLite.m43450a();
        volatile boolean f41960j;
        boolean f41961k;
        boolean f41962l;
        final Object f41963m = new Object();
        volatile InnerSubscriber<?>[] f41964n = f41951r;
        long f41965o;
        long f41966p;
        int f41967q;
        final int f41968s;
        int f41969t;

        public final /* synthetic */ void a_(Object obj) {
            Observable observable = (Observable) obj;
            if (observable != null) {
                boolean z = true;
                if (observable == Observable.m43388a()) {
                    obj = this.f41969t + 1;
                    if (obj == this.f41968s) {
                        this.f41969t = 0;
                        m43807a((long) obj);
                        return;
                    }
                    this.f41969t = obj;
                    return;
                } else if (observable instanceof ScalarSynchronousObservable) {
                    boolean z2;
                    obj = ((ScalarSynchronousObservable) observable).f41801b;
                    if (this.f41955e.get() != 0) {
                        synchronized (this) {
                            r3 = this.f41955e.get();
                            if (this.f41961k || r3 == 0) {
                                z2 = false;
                            } else {
                                this.f41961k = true;
                                z2 = true;
                            }
                        }
                    } else {
                        z2 = false;
                        r3 = 0;
                    }
                    if (z2) {
                        Queue queue = this.f41956f;
                        if (queue != null) {
                            if (!queue.isEmpty()) {
                                m44066b(obj);
                                m44070i();
                                return;
                            }
                        }
                        try {
                            this.f41952a.a_(obj);
                        } catch (Throwable th) {
                            obj = th;
                        }
                        if (r3 != Long.MAX_VALUE) {
                            this.f41955e.addAndGet(-1);
                        }
                        obj = this.f41969t + 1;
                        if (obj == this.f41968s) {
                            this.f41969t = 0;
                            m43807a((long) obj);
                        } else {
                            this.f41969t = obj;
                        }
                        synchronized (this) {
                            if (this.f41962l == null) {
                                this.f41961k = false;
                                return;
                            }
                            this.f41962l = false;
                            m44070i();
                            return;
                        }
                    }
                    m44066b(obj);
                    m44076f();
                    return;
                } else {
                    r3 = this.f41965o;
                    this.f41965o = 1 + r3;
                    Subscriber innerSubscriber = new InnerSubscriber(this, r3);
                    m44068g().m43948a((Subscription) innerSubscriber);
                    synchronized (this.f41963m) {
                        Object obj2 = this.f41964n;
                        int length = obj2.length;
                        Object obj3 = new InnerSubscriber[(length + 1)];
                        System.arraycopy(obj2, 0, obj3, 0, length);
                        obj3[length] = innerSubscriber;
                        this.f41964n = obj3;
                    }
                    observable.m43406a(innerSubscriber);
                    m44076f();
                }
            }
            return;
            if (!z) {
                synchronized (this) {
                    this.f41961k = false;
                }
            }
            throw obj;
        }

        public MergeSubscriber(Subscriber<? super T> subscriber, boolean z, int i) {
            this.f41952a = subscriber;
            this.f41953b = z;
            this.f41954c = i;
            if (i == RedditJobManager.f10810d) {
                this.f41968s = RedditJobManager.f10810d;
                m43807a((long) -1);
                return;
            }
            this.f41968s = Math.max(true, i >> 1);
            m43807a((long) (long) i);
        }

        final Queue<Throwable> m44075e() {
            Queue<Throwable> queue = this.f41958h;
            if (queue == null) {
                synchronized (this) {
                    queue = this.f41958h;
                    if (queue == null) {
                        queue = new ConcurrentLinkedQueue();
                        this.f41958h = queue;
                    }
                }
            }
            return queue;
        }

        private CompositeSubscription m44068g() {
            CompositeSubscription compositeSubscription = this.f41957g;
            if (compositeSubscription != null) {
                return compositeSubscription;
            }
            Subscription subscription;
            Object obj = null;
            synchronized (this) {
                subscription = this.f41957g;
                if (subscription == null) {
                    compositeSubscription = new CompositeSubscription();
                    this.f41957g = compositeSubscription;
                    subscription = compositeSubscription;
                    obj = 1;
                }
            }
            if (obj != null) {
                m43809a(subscription);
            }
            return subscription;
        }

        private void m44069h() {
            Collection arrayList = new ArrayList(this.f41958h);
            if (arrayList.size() == 1) {
                this.f41952a.mo7904a((Throwable) arrayList.get(0));
            } else {
                this.f41952a.mo7904a(new CompositeException(arrayList, (byte) 0));
            }
        }

        public final void mo7904a(Throwable th) {
            m44075e().offer(th);
            this.f41960j = true;
            m44076f();
        }

        public final void mo7906b() {
            this.f41960j = true;
            m44076f();
        }

        final void m44073a(InnerSubscriber<T> innerSubscriber, T t) {
            boolean z;
            long j = 0;
            boolean z2 = true;
            if (this.f41955e.get() != 0) {
                long j2;
                synchronized (this) {
                    j2 = this.f41955e.get();
                    if (this.f41961k || j2 == 0) {
                        z = false;
                    } else {
                        this.f41961k = true;
                        z = true;
                    }
                }
                j = j2;
            } else {
                z = false;
            }
            if (z) {
                RxRingBuffer rxRingBuffer = innerSubscriber.f41949e;
                if (rxRingBuffer != null) {
                    if (!rxRingBuffer.m43899f()) {
                        m44067b(innerSubscriber, t);
                        m44070i();
                        return;
                    }
                }
                try {
                    this.f41952a.a_(t);
                } catch (Throwable th) {
                    innerSubscriber = th;
                }
                if (j != Long.MAX_VALUE) {
                    this.f41955e.addAndGet(-1);
                }
                innerSubscriber.m44065b(1);
                synchronized (this) {
                    if (this.f41962l == null) {
                        this.f41961k = false;
                        return;
                    }
                    this.f41962l = false;
                    m44070i();
                    return;
                }
            }
            m44067b(innerSubscriber, t);
            m44076f();
            return;
            if (!z2) {
                synchronized (this) {
                    this.f41961k = false;
                }
            }
            throw innerSubscriber;
        }

        private static void m44067b(InnerSubscriber<T> innerSubscriber, T t) {
            RxRingBuffer rxRingBuffer = innerSubscriber.f41949e;
            if (rxRingBuffer == null) {
                rxRingBuffer = RxRingBuffer.m43891a();
                innerSubscriber.m43809a((Subscription) rxRingBuffer);
                innerSubscriber.f41949e = rxRingBuffer;
            }
            try {
                rxRingBuffer.m43895a(NotificationLite.m43448a((Object) t));
            } catch (T t2) {
                innerSubscriber.f41662d.mo7893c();
                innerSubscriber.mo7904a(t2);
            } catch (T t22) {
                if (!innerSubscriber.mo7894d()) {
                    innerSubscriber.f41662d.mo7893c();
                    innerSubscriber.mo7904a(t22);
                }
            }
        }

        private void m44066b(T t) {
            Queue queue = this.f41956f;
            if (queue == null) {
                int i = this.f41954c;
                if (i == RedditJobManager.f10810d) {
                    queue = new SpscUnboundedAtomicArrayQueue(RxRingBuffer.f41779b);
                } else {
                    SpscArrayQueue spscExactAtomicArrayQueue;
                    if (!Pow2.m43482b(i)) {
                        spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue(i);
                    } else if (UnsafeAccess.m43484a()) {
                        spscExactAtomicArrayQueue = new SpscArrayQueue(i);
                    } else {
                        spscExactAtomicArrayQueue = new SpscAtomicArrayQueue(i);
                    }
                    queue = spscExactAtomicArrayQueue;
                }
                this.f41956f = queue;
            }
            if (!queue.offer(NotificationLite.m43448a((Object) t))) {
                this.f41662d.mo7893c();
                mo7904a(OnErrorThrowable.m43437a(new MissingBackpressureException(), t));
            }
        }

        final void m44076f() {
            synchronized (this) {
                if (this.f41961k) {
                    this.f41962l = true;
                    return;
                }
                this.f41961k = true;
                m44070i();
            }
        }

        private void m44070i() {
            Object obj;
            Object obj2;
            Subscriber subscriber = this.f41952a;
            while (!m44071j()) {
                int i;
                int i2;
                Queue queue = r1.f41956f;
                long j = r1.f41955e.get();
                Object obj3 = j == Long.MAX_VALUE ? 1 : null;
                long j2 = 0;
                if (queue != null) {
                    i = 0;
                    while (true) {
                        i2 = 0;
                        Object obj4 = null;
                        while (j > 0) {
                            obj4 = queue.poll();
                            if (!m44071j()) {
                                if (obj4 == null) {
                                    break;
                                }
                                try {
                                    subscriber.a_(NotificationLite.m43454c(obj4));
                                } catch (Throwable th) {
                                    r2 = th;
                                    obj = 1;
                                }
                                i++;
                                i2++;
                                j--;
                            } else {
                                return;
                            }
                        }
                        if (i2 > 0) {
                            if (obj3 != null) {
                                j = Long.MAX_VALUE;
                            } else {
                                j = r1.f41955e.addAndGet((long) (-i2));
                            }
                        }
                        if (j == 0) {
                            break;
                        } else if (obj4 == null) {
                            break;
                        }
                    }
                } else {
                    i = 0;
                }
                boolean z = r1.f41960j;
                Queue queue2 = r1.f41956f;
                InnerSubscriber[] innerSubscriberArr = r1.f41964n;
                int length = innerSubscriberArr.length;
                if (z && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                    Queue queue3 = r1.f41958h;
                    if (queue3 != null) {
                        if (!queue3.isEmpty()) {
                            m44069h();
                            return;
                        }
                    }
                    subscriber.mo7906b();
                    return;
                }
                int i3;
                Object obj5;
                Subscriber subscriber2;
                if (length > 0) {
                    long j3 = r1.f41966p;
                    int i4 = r1.f41967q;
                    if (length <= i4 || innerSubscriberArr[i4].f41947b != j3) {
                        if (length <= i4) {
                            i4 = 0;
                        }
                        i2 = i4;
                        for (i4 = 0; i4 < length && innerSubscriberArr[i2].f41947b != j3; i4++) {
                            i2++;
                            if (i2 == length) {
                                i2 = 0;
                            }
                        }
                        r1.f41967q = i2;
                        r1.f41966p = innerSubscriberArr[i2].f41947b;
                        i4 = i2;
                    }
                    i3 = 0;
                    obj5 = null;
                    while (i3 < length) {
                        if (!m44071j()) {
                            Object obj6;
                            int i5;
                            RxRingBuffer rxRingBuffer;
                            Subscription subscription = innerSubscriberArr[i4];
                            Object obj7 = null;
                            while (true) {
                                obj6 = obj7;
                                i5 = 0;
                                while (j > j2) {
                                    if (!m44071j()) {
                                        rxRingBuffer = subscription.f41949e;
                                        if (rxRingBuffer == null) {
                                            break;
                                        }
                                        obj6 = rxRingBuffer.m43900g();
                                        if (obj6 == null) {
                                            break;
                                        }
                                        try {
                                            subscriber.a_(NotificationLite.m43454c(obj6));
                                            j--;
                                            i5++;
                                            j2 = 0;
                                        } catch (Throwable th2) {
                                            Exceptions.m43435b(th2);
                                            subscriber.mo7904a(th2);
                                            return;
                                        } finally {
                                            r1.f41662d.mo7893c();
                                        }
                                    } else {
                                        return;
                                    }
                                }
                                if (i5 > 0) {
                                    if (obj3 == null) {
                                        j = r1.f41955e.addAndGet((long) (-i5));
                                    } else {
                                        j = Long.MAX_VALUE;
                                    }
                                    subscription.m44065b((long) i5);
                                }
                                j2 = 0;
                                i5 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                                if (i5 == 0) {
                                    break;
                                } else if (obj6 == null) {
                                    break;
                                } else {
                                    obj7 = obj6;
                                }
                            }
                            boolean z2 = subscription.f41948c;
                            rxRingBuffer = subscription.f41949e;
                            if (z2 && (rxRingBuffer == null || rxRingBuffer.m43899f())) {
                                RxRingBuffer rxRingBuffer2 = subscription.f41949e;
                                if (rxRingBuffer2 != null) {
                                    rxRingBuffer2.m43898e();
                                }
                                r1.f41957g.m43949b(subscription);
                                synchronized (r1.f41963m) {
                                    obj6 = r1.f41964n;
                                    int length2 = obj6.length;
                                    int i6 = 0;
                                    while (i6 < length2) {
                                        subscriber2 = subscriber;
                                        if (subscription.equals(obj6[i6])) {
                                            break;
                                        }
                                        i6++;
                                        subscriber = subscriber2;
                                    }
                                    subscriber2 = subscriber;
                                    i6 = -1;
                                    if (i6 < 0) {
                                    } else if (length2 == 1) {
                                        r1.f41964n = f41951r;
                                    } else {
                                        Object obj8 = new InnerSubscriber[(length2 - 1)];
                                        System.arraycopy(obj6, 0, obj8, 0, i6);
                                        obj2 = 1;
                                        System.arraycopy(obj6, i6 + 1, obj8, i6, (length2 - i6) - 1);
                                        r1.f41964n = obj8;
                                    }
                                    obj2 = 1;
                                }
                                if (!m44071j()) {
                                    i++;
                                    obj5 = obj2;
                                } else {
                                    return;
                                }
                            }
                            subscriber2 = subscriber;
                            obj2 = 1;
                            if (i5 == 0) {
                                break;
                            }
                            int i7 = i4 + 1;
                            i4 = i7 == length ? 0 : i7;
                            i3++;
                            subscriber = subscriber2;
                            j2 = 0;
                        } else {
                            return;
                        }
                    }
                    subscriber2 = subscriber;
                    obj2 = 1;
                    Object obj9 = obj5;
                    r1.f41967q = i4;
                    r1.f41966p = innerSubscriberArr[i4].f41947b;
                    obj5 = obj9;
                    i3 = i;
                } else {
                    subscriber2 = subscriber;
                    obj2 = 1;
                    i3 = i;
                    obj5 = null;
                }
                if (i3 > 0) {
                    m43807a((long) i3);
                }
                if (obj5 == null) {
                    synchronized (this) {
                        if (r1.f41962l) {
                            try {
                                r1.f41962l = false;
                            } catch (Throwable th22) {
                                r2 = th22;
                                obj2 = null;
                            }
                        } else {
                            try {
                                r1.f41961k = false;
                                return;
                            } catch (Throwable th222) {
                                r2 = th222;
                                try {
                                    throw r2;
                                } catch (Throwable th2222) {
                                    r2 = th2222;
                                    obj = obj2;
                                }
                            }
                        }
                    }
                }
                subscriber = subscriber2;
            }
            return;
            if (obj == null) {
                synchronized (this) {
                    try {
                        r1.f41961k = false;
                    } catch (Throwable th22222) {
                        r2 = th22222;
                    }
                }
            }
            throw r2;
        }

        private boolean m44071j() {
            boolean z = true;
            if (this.f41952a.mo7894d()) {
                return true;
            }
            Queue queue = this.f41958h;
            if (this.f41953b || queue == null || queue.isEmpty()) {
                return false;
            }
            try {
                m44069h();
                return z;
            } finally {
                z = this.f41662d;
                z.mo7893c();
            }
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Subscription mergeSubscriber = new MergeSubscriber(subscriber, this.f41970a, this.f41971b);
        Producer mergeProducer = new MergeProducer(mergeSubscriber);
        mergeSubscriber.f41955e = mergeProducer;
        subscriber.m43809a(mergeSubscriber);
        subscriber.mo7929a(mergeProducer);
        return mergeSubscriber;
    }

    public static <T> OperatorMerge<T> m44077a() {
        return HolderNoDelay.f41324a;
    }

    public static <T> OperatorMerge<T> m44078b() {
        return new OperatorMerge(1);
    }

    OperatorMerge(int i) {
        this.f41971b = i;
    }
}
