package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Notification.Kind;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeRedo<T> implements OnSubscribe<T> {
    static final Func1<Observable<? extends Notification<?>>, Observable<?>> f41912d = new C31081();
    final Observable<T> f41913a;
    final boolean f41914b = true;
    final boolean f41915c = null;
    private final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> f41916e;
    private final Scheduler f41917f;

    static class C31081 implements Func1<Observable<? extends Notification<?>>, Observable<?>> {

        class C31071 implements Func1<Notification<?>, Notification<?>> {
            final /* synthetic */ C31081 f41683a;

            C31071(C31081 c31081) {
                this.f41683a = c31081;
            }

            public /* synthetic */ Object call(Object obj) {
                return Notification.m43382a();
            }
        }

        C31081() {
        }

        public final /* synthetic */ Object call(Object obj) {
            return ((Observable) obj).m43410b(new C31071(this));
        }
    }

    class C31543 implements Operator<Notification<?>, Notification<?>> {
        final /* synthetic */ OnSubscribeRedo f41910a;

        C31543(OnSubscribeRedo onSubscribeRedo) {
            this.f41910a = onSubscribeRedo;
        }

        public /* synthetic */ Object call(Object obj) {
            final Subscriber subscriber = (Subscriber) obj;
            return new Subscriber<Notification<?>>(this, subscriber) {
                final /* synthetic */ C31543 f41909b;

                public final /* synthetic */ void a_(Object obj) {
                    Notification notification = (Notification) obj;
                    if ((notification.f41299a == Kind.OnCompleted ? 1 : null) != null && this.f41909b.f41910a.f41914b) {
                        subscriber.mo7906b();
                    } else if (notification.m43387c() && this.f41909b.f41910a.f41915c) {
                        subscriber.mo7904a(notification.f41300b);
                    } else {
                        subscriber.a_(notification);
                    }
                }

                public final void mo7906b() {
                    subscriber.mo7906b();
                }

                public final void mo7904a(Throwable th) {
                    subscriber.mo7904a(th);
                }

                public final void mo7929a(Producer producer) {
                    producer.mo7901a(Long.MAX_VALUE);
                }
            };
        }
    }

    public final /* synthetic */ void mo7899a(Object obj) {
        Observable observable;
        Subscriber subscriber = (Subscriber) obj;
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        Subscription a = this.f41917f.mo7895a();
        subscriber.m43809a(a);
        final Subscription serialSubscription = new SerialSubscription();
        subscriber.m43809a(serialSubscription);
        Subject d = BehaviorSubject.m44141d();
        if (d.getClass() == SerializedSubject.class) {
            observable = (SerializedSubject) d;
        } else {
            observable = new SerializedSubject(d);
        }
        Observable.m43397a(Subscribers.m43487a(), observable);
        ProducerArbiter producerArbiter = new ProducerArbiter();
        final Subscriber subscriber2 = subscriber;
        final Observable observable2 = observable;
        final ProducerArbiter producerArbiter2 = producerArbiter;
        final AtomicLong atomicLong2 = atomicLong;
        C31092 c31092 = new Action0(this) {
            final /* synthetic */ OnSubscribeRedo f41689f;

            class C31521 extends Subscriber<T> {
                boolean f41906a;
                final /* synthetic */ C31092 f41907b;

                C31521(C31092 c31092) {
                    this.f41907b = c31092;
                }

                public final void mo7906b() {
                    if (!this.f41906a) {
                        this.f41906a = true;
                        this.f41662d.mo7893c();
                        observable2.a_(Notification.m43384b());
                    }
                }

                public final void mo7904a(Throwable th) {
                    if (!this.f41906a) {
                        this.f41906a = true;
                        this.f41662d.mo7893c();
                        observable2.a_(Notification.m43383a(th));
                    }
                }

                public final void a_(T t) {
                    if (!this.f41906a) {
                        subscriber2.a_(t);
                        long j;
                        do {
                            j = atomicLong2.get();
                            if (j == Long.MAX_VALUE) {
                                break;
                            }
                        } while (atomicLong2.compareAndSet(j, j - 1) == null);
                        producerArbiter2.m43845b(1);
                    }
                }

                public final void mo7929a(Producer producer) {
                    producerArbiter2.m43844a(producer);
                }
            }

            public final void mo7898a() {
                if (!subscriber2.mo7894d()) {
                    Subscriber c31521 = new C31521(this);
                    serialSubscription.m43952a(c31521);
                    this.f41689f.f41913a.m43406a(c31521);
                }
            }
        };
        final Observable observable3 = (Observable) this.f41916e.call(observable.m43402a(new C31543(this)));
        final Subscriber subscriber3 = subscriber;
        final AtomicLong atomicLong3 = atomicLong;
        final Subscription subscription = a;
        final C31092 c310922 = c31092;
        final AtomicBoolean atomicBoolean2 = atomicBoolean;
        a.mo7927a(new Action0(this) {
            final /* synthetic */ OnSubscribeRedo f41696g;

            public final void mo7898a() {
                observable3.m43406a(new Subscriber<Object>(this, subscriber3) {
                    final /* synthetic */ C31104 f41911a;

                    public final void mo7906b() {
                        subscriber3.mo7906b();
                    }

                    public final void mo7904a(Throwable th) {
                        subscriber3.mo7904a(th);
                    }

                    public final void a_(Object obj) {
                        if (subscriber3.mo7894d() == null) {
                            if (atomicLong3.get() > 0) {
                                subscription.mo7927a(c310922);
                                return;
                            }
                            atomicBoolean2.compareAndSet(false, true);
                        }
                    }

                    public final void mo7929a(Producer producer) {
                        producer.mo7901a(Long.MAX_VALUE);
                    }
                });
            }
        });
        final AtomicLong atomicLong4 = atomicLong;
        final ProducerArbiter producerArbiter3 = producerArbiter;
        final AtomicBoolean atomicBoolean3 = atomicBoolean;
        subscriber.mo7929a(new Producer(this) {
            final /* synthetic */ OnSubscribeRedo f41702f;

            public final void mo7901a(long j) {
                if (j > 0) {
                    BackpressureUtils.m43445a(atomicLong4, j);
                    producerArbiter3.mo7901a(j);
                    if (atomicBoolean3.compareAndSet(true, false) != null) {
                        subscription.mo7927a(c310922);
                    }
                }
            }
        });
    }

    public static <T> Observable<T> m44049a(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1) {
        return Observable.m43391a(new OnSubscribeRedo(observable, func1, Schedulers.m43530a()));
    }

    private OnSubscribeRedo(Observable<T> observable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> func1, Scheduler scheduler) {
        this.f41913a = observable;
        this.f41916e = func1;
        this.f41917f = scheduler;
    }
}
