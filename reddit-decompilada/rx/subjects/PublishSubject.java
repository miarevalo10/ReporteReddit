package rx.subjects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.BackpressureUtils;

public final class PublishSubject<T> extends Subject<T, T> {
    final PublishSubjectState<T> f42045b;

    static final class PublishSubjectProducer<T> extends AtomicLong implements Observer<T>, Producer, Subscription {
        final PublishSubjectState<T> f41825a;
        final Subscriber<? super T> f41826b;
        long f41827c;

        public PublishSubjectProducer(PublishSubjectState<T> publishSubjectState, Subscriber<? super T> subscriber) {
            this.f41825a = publishSubjectState;
            this.f41826b = subscriber;
        }

        public final void mo7901a(long j) {
            if (BackpressureUtils.m43446a(j)) {
                long j2;
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j2, BackpressureUtils.m43444a(j2, j)));
            }
        }

        public final boolean mo7894d() {
            return get() == Long.MIN_VALUE;
        }

        public final void mo7893c() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f41825a.m44147a(this);
            }
        }

        public final void a_(T t) {
            long j = get();
            if (j != Long.MIN_VALUE) {
                long j2 = this.f41827c;
                if (j != j2) {
                    this.f41827c = j2 + 1;
                    this.f41826b.a_(t);
                    return;
                }
                mo7893c();
                this.f41826b.mo7904a(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
            }
        }

        public final void mo7904a(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.f41826b.mo7904a(th);
            }
        }

        public final void mo7906b() {
            if (get() != Long.MIN_VALUE) {
                this.f41826b.mo7906b();
            }
        }
    }

    static final class PublishSubjectState<T> extends AtomicReference<PublishSubjectProducer<T>[]> implements OnSubscribe<T>, Observer<T> {
        static final PublishSubjectProducer[] f42042a = new PublishSubjectProducer[0];
        static final PublishSubjectProducer[] f42043b = new PublishSubjectProducer[0];
        Throwable f42044c;

        public final /* synthetic */ void mo7899a(Object obj) {
            int i;
            Subscriber subscriber = (Subscriber) obj;
            PublishSubjectProducer publishSubjectProducer = new PublishSubjectProducer(this, subscriber);
            subscriber.m43809a((Subscription) publishSubjectProducer);
            subscriber.mo7929a((Producer) publishSubjectProducer);
            PublishSubjectProducer[] publishSubjectProducerArr;
            Object obj2;
            do {
                publishSubjectProducerArr = (PublishSubjectProducer[]) get();
                i = 0;
                if (publishSubjectProducerArr == f42043b) {
                    break;
                }
                int length = publishSubjectProducerArr.length;
                obj2 = new PublishSubjectProducer[(length + 1)];
                System.arraycopy(publishSubjectProducerArr, 0, obj2, 0, length);
                obj2[length] = publishSubjectProducer;
            } while (!compareAndSet(publishSubjectProducerArr, obj2));
            i = 1;
            if (i == 0) {
                Throwable th = this.f42044c;
                if (th != null) {
                    subscriber.mo7904a(th);
                    return;
                }
                subscriber.mo7906b();
            } else if (publishSubjectProducer.mo7894d() != null) {
                m44147a(publishSubjectProducer);
            }
        }

        public PublishSubjectState() {
            lazySet(f42042a);
        }

        final void m44147a(PublishSubjectProducer<T> publishSubjectProducer) {
            PublishSubjectProducer[] publishSubjectProducerArr;
            Object obj;
            do {
                publishSubjectProducerArr = (PublishSubjectProducer[]) get();
                if (publishSubjectProducerArr != f42043b) {
                    if (publishSubjectProducerArr != f42042a) {
                        int length = publishSubjectProducerArr.length;
                        int i = -1;
                        for (int i2 = 0; i2 < length; i2++) {
                            if (publishSubjectProducerArr[i2] == publishSubjectProducer) {
                                i = i2;
                                break;
                            }
                        }
                        if (i >= 0) {
                            if (length == 1) {
                                obj = f42042a;
                            } else {
                                Object obj2 = new PublishSubjectProducer[(length - 1)];
                                System.arraycopy(publishSubjectProducerArr, 0, obj2, 0, i);
                                System.arraycopy(publishSubjectProducerArr, i + 1, obj2, i, (length - i) - 1);
                                obj = obj2;
                            }
                        } else {
                            return;
                        }
                    }
                }
                return;
            } while (!compareAndSet(publishSubjectProducerArr, obj));
        }

        public final void a_(T t) {
            for (PublishSubjectProducer a_ : (PublishSubjectProducer[]) get()) {
                a_.a_(t);
            }
        }

        public final void mo7904a(Throwable th) {
            this.f42044c = th;
            List list = null;
            for (PublishSubjectProducer a : (PublishSubjectProducer[]) getAndSet(f42043b)) {
                try {
                    a.mo7904a(th);
                } catch (Throwable th2) {
                    if (list == null) {
                        list = new ArrayList(1);
                    }
                    list.add(th2);
                }
            }
            Exceptions.m43434a(list);
        }

        public final void mo7906b() {
            for (PublishSubjectProducer b : (PublishSubjectProducer[]) getAndSet(f42043b)) {
                b.mo7906b();
            }
        }
    }

    public static <T> PublishSubject<T> m44149d() {
        return new PublishSubject(new PublishSubjectState());
    }

    private PublishSubject(PublishSubjectState<T> publishSubjectState) {
        super(publishSubjectState);
        this.f42045b = publishSubjectState;
    }

    public final void a_(T t) {
        this.f42045b.a_(t);
    }

    public final void mo7904a(Throwable th) {
        this.f42045b.mo7904a(th);
    }

    public final void mo7906b() {
        this.f42045b.mo7906b();
    }

    public final boolean mo7932e() {
        return ((PublishSubjectProducer[]) this.f42045b.get()).length != 0;
    }
}
