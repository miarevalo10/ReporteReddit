package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observable.Operator;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func2;
import rx.functions.FuncN;
import rx.functions.Functions;
import rx.internal.util.RxRingBuffer;
import rx.subscriptions.CompositeSubscription;

public final class OperatorZip<R> implements Operator<R, Observable<?>[]> {
    final FuncN<? extends R> f41997a;

    static final class Zip<R> extends AtomicLong {
        static final int f41325c = ((int) (((double) RxRingBuffer.f41779b) * 0.7d));
        final Observer<? super R> f41326a;
        final CompositeSubscription f41327b = new CompositeSubscription();
        int f41328d;
        volatile Object[] f41329e;
        AtomicLong f41330f;
        private final FuncN<? extends R> f41331g;

        final class InnerSubscriber extends Subscriber {
            final RxRingBuffer f41990a = RxRingBuffer.m43892b();
            final /* synthetic */ Zip f41991b;

            InnerSubscriber(Zip zip) {
                this.f41991b = zip;
            }

            public final void aV_() {
                m43807a((long) RxRingBuffer.f41779b);
            }

            public final void m44090b(long j) {
                m43807a(j);
            }

            public final void mo7906b() {
                RxRingBuffer rxRingBuffer = this.f41990a;
                if (rxRingBuffer.f41783a == null) {
                    rxRingBuffer.f41783a = NotificationLite.m43452b();
                }
                this.f41991b.m43457a();
            }

            public final void mo7904a(Throwable th) {
                this.f41991b.f41326a.mo7904a(th);
            }

            public final void a_(Object obj) {
                try {
                    this.f41990a.m43895a(obj);
                } catch (Object obj2) {
                    mo7904a(obj2);
                }
                this.f41991b.m43457a();
            }
        }

        public Zip(Subscriber<? super R> subscriber, FuncN<? extends R> funcN) {
            this.f41326a = subscriber;
            this.f41331g = funcN;
            subscriber.m43809a(this.f41327b);
        }

        final void m43457a() {
            Object[] objArr = this.f41329e;
            if (objArr != null && getAndIncrement() == 0) {
                int length = objArr.length;
                Observer observer = this.f41326a;
                AtomicLong atomicLong = this.f41330f;
                while (true) {
                    Object obj = new Object[length];
                    int i = 1;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object h = ((InnerSubscriber) objArr[i2]).f41990a.m43901h();
                        if (h == null) {
                            i = 0;
                        } else if (RxRingBuffer.m43893b(h)) {
                            observer.mo7906b();
                            this.f41327b.mo7893c();
                            return;
                        } else {
                            obj[i2] = RxRingBuffer.m43894c(h);
                        }
                    }
                    if (atomicLong.get() > 0 && r10 != 0) {
                        try {
                            observer.a_(this.f41331g.mo7900a(obj));
                            atomicLong.decrementAndGet();
                            this.f41328d++;
                            for (Object obj2 : objArr) {
                                RxRingBuffer rxRingBuffer = ((InnerSubscriber) obj2).f41990a;
                                rxRingBuffer.m43900g();
                                if (RxRingBuffer.m43893b(rxRingBuffer.m43901h())) {
                                    observer.mo7906b();
                                    this.f41327b.mo7893c();
                                    return;
                                }
                            }
                            if (this.f41328d > f41325c) {
                                for (Object obj22 : objArr) {
                                    ((InnerSubscriber) obj22).m44090b((long) this.f41328d);
                                }
                                this.f41328d = 0;
                            }
                        } catch (Throwable th) {
                            Exceptions.m43433a(th, observer, obj);
                            return;
                        }
                    } else if (decrementAndGet() <= 0) {
                        break;
                    }
                }
            }
        }
    }

    static final class ZipProducer<R> extends AtomicLong implements Producer {
        final Zip<R> f41718a;

        public ZipProducer(Zip<R> zip) {
            this.f41718a = zip;
        }

        public final void mo7901a(long j) {
            BackpressureUtils.m43445a((AtomicLong) this, j);
            this.f41718a.m43457a();
        }
    }

    final class ZipSubscriber extends Subscriber<Observable[]> {
        final Subscriber<? super R> f41992a;
        final Zip<R> f41993b;
        final ZipProducer<R> f41994c;
        boolean f41995e;
        final /* synthetic */ OperatorZip f41996f;

        public final /* synthetic */ void a_(Object obj) {
            Observable[] observableArr = (Observable[]) obj;
            if (observableArr != null) {
                if (observableArr.length != 0) {
                    this.f41995e = true;
                    Zip zip = this.f41993b;
                    AtomicLong atomicLong = this.f41994c;
                    int i = 0;
                    Object[] objArr = new Object[observableArr.length];
                    for (int i2 = 0; i2 < observableArr.length; i2++) {
                        Subscription innerSubscriber = new InnerSubscriber(zip);
                        objArr[i2] = innerSubscriber;
                        zip.f41327b.m43948a(innerSubscriber);
                    }
                    zip.f41330f = atomicLong;
                    zip.f41329e = objArr;
                    while (i < observableArr.length) {
                        observableArr[i].m43406a((InnerSubscriber) objArr[i]);
                        i++;
                    }
                    return;
                }
            }
            this.f41992a.mo7906b();
        }

        public ZipSubscriber(OperatorZip operatorZip, Subscriber<? super R> subscriber, Zip<R> zip, ZipProducer<R> zipProducer) {
            this.f41996f = operatorZip;
            this.f41992a = subscriber;
            this.f41993b = zip;
            this.f41994c = zipProducer;
        }

        public final void mo7906b() {
            if (!this.f41995e) {
                this.f41992a.mo7906b();
            }
        }

        public final void mo7904a(Throwable th) {
            this.f41992a.mo7904a(th);
        }
    }

    public final /* synthetic */ Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Zip zip = new Zip(subscriber, this.f41997a);
        Producer zipProducer = new ZipProducer(zip);
        Subscription zipSubscriber = new ZipSubscriber(this, subscriber, zip, zipProducer);
        subscriber.m43809a(zipSubscriber);
        subscriber.mo7929a(zipProducer);
        return zipSubscriber;
    }

    public OperatorZip(Func2 func2) {
        this.f41997a = Functions.m43443a(func2);
    }
}
