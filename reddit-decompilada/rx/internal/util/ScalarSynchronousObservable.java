package rx.internal.util;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.producers.SingleProducer;
import rx.internal.schedulers.EventLoopsScheduler;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;

public final class ScalarSynchronousObservable<T> extends Observable<T> {
    static final boolean f41800c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T f41801b;

    static final class ScalarAsyncProducer<T> extends AtomicBoolean implements Producer, Action0 {
        final Subscriber<? super T> f41794a;
        final T f41795b;
        final Func1<Action0, Subscription> f41796c;

        public ScalarAsyncProducer(Subscriber<? super T> subscriber, T t, Func1<Action0, Subscription> func1) {
            this.f41794a = subscriber;
            this.f41795b = t;
            this.f41796c = func1;
        }

        public final void mo7901a(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder("n >= 0 required but it was ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (i != 0 && compareAndSet(0, true) != null) {
                this.f41794a.m43809a((Subscription) this.f41796c.call(this));
            }
        }

        public final void mo7898a() {
            Observer observer = this.f41794a;
            if (!observer.mo7894d()) {
                Object obj = this.f41795b;
                try {
                    observer.a_(obj);
                    if (!observer.mo7894d()) {
                        observer.mo7906b();
                    }
                } catch (Throwable th) {
                    Exceptions.m43433a(th, observer, obj);
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("ScalarAsyncProducer[");
            stringBuilder.append(this.f41795b);
            stringBuilder.append(", ");
            stringBuilder.append(get());
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    static final class WeakSingleProducer<T> implements Producer {
        final Subscriber<? super T> f41797a;
        final T f41798b;
        boolean f41799c;

        public WeakSingleProducer(Subscriber<? super T> subscriber, T t) {
            this.f41797a = subscriber;
            this.f41798b = t;
        }

        public final void mo7901a(long j) {
            if (!this.f41799c) {
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    StringBuilder stringBuilder = new StringBuilder("n >= required but it was ");
                    stringBuilder.append(j);
                    throw new IllegalStateException(stringBuilder.toString());
                } else if (i != 0) {
                    this.f41799c = 1;
                    j = this.f41797a;
                    if (!j.mo7894d()) {
                        Object obj = this.f41798b;
                        try {
                            j.a_(obj);
                            if (!j.mo7894d()) {
                                j.mo7906b();
                            }
                        } catch (Throwable th) {
                            Exceptions.m43433a(th, j, obj);
                        }
                    }
                }
            }
        }
    }

    static final class JustOnSubscribe<T> implements OnSubscribe<T> {
        final T f42026a;

        public final /* bridge */ /* synthetic */ void mo7899a(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            subscriber.mo7929a(ScalarSynchronousObservable.m43906a(subscriber, this.f42026a));
        }

        JustOnSubscribe(T t) {
            this.f42026a = t;
        }
    }

    static final class ScalarAsyncOnSubscribe<T> implements OnSubscribe<T> {
        final T f42027a;
        final Func1<Action0, Subscription> f42028b;

        public final /* synthetic */ void mo7899a(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            subscriber.mo7929a(new ScalarAsyncProducer(subscriber, this.f42027a, this.f42028b));
        }

        ScalarAsyncOnSubscribe(T t, Func1<Action0, Subscription> func1) {
            this.f42027a = t;
            this.f42028b = func1;
        }
    }

    static <T> Producer m43906a(Subscriber<? super T> subscriber, T t) {
        if (f41800c) {
            return new SingleProducer(subscriber, t);
        }
        return new WeakSingleProducer(subscriber, t);
    }

    public static <T> ScalarSynchronousObservable<T> m43907a(T t) {
        return new ScalarSynchronousObservable(t);
    }

    private ScalarSynchronousObservable(T t) {
        super(RxJavaHooks.m43493a(new JustOnSubscribe(t)));
        this.f41801b = t;
    }

    public final Observable<T> m43908c(final Scheduler scheduler) {
        Func1 c31241;
        if (scheduler instanceof EventLoopsScheduler) {
            final EventLoopsScheduler eventLoopsScheduler = (EventLoopsScheduler) scheduler;
            c31241 = new Func1<Action0, Subscription>(this) {
                final /* synthetic */ ScalarSynchronousObservable f41788b;

                public /* synthetic */ Object call(Object obj) {
                    return ((FixedSchedulerPool) eventLoopsScheduler.f41745f.get()).m43461a().m44113b((Action0) obj, -1, TimeUnit.NANOSECONDS);
                }
            };
        } else {
            c31241 = new Func1<Action0, Subscription>(this) {
                final /* synthetic */ ScalarSynchronousObservable f41793b;

                public /* synthetic */ Object call(Object obj) {
                    final Action0 action0 = (Action0) obj;
                    final Worker a = scheduler.mo7895a();
                    a.mo7927a(new Action0(this) {
                        final /* synthetic */ C31262 f41791c;

                        public final void mo7898a() {
                            try {
                                action0.mo7898a();
                            } finally {
                                a.mo7893c();
                            }
                        }
                    });
                    return a;
                }
            };
        }
        return Observable.m43391a((OnSubscribe) new ScalarAsyncOnSubscribe(this.f41801b, c31241));
    }

    public final <R> Observable<R> m43909c(final Func1<? super T, ? extends Observable<? extends R>> func1) {
        return Observable.m43391a(new OnSubscribe<R>(this) {
            final /* synthetic */ ScalarSynchronousObservable f42025b;

            public final /* synthetic */ void mo7899a(Object obj) {
                Subscriber subscriber = (Subscriber) obj;
                Observable observable = (Observable) func1.call(this.f42025b.f41801b);
                if (observable instanceof ScalarSynchronousObservable) {
                    subscriber.mo7929a(ScalarSynchronousObservable.m43906a(subscriber, ((ScalarSynchronousObservable) observable).f41801b));
                } else {
                    observable.m43406a(Subscribers.m43488a(subscriber));
                }
            }
        });
    }
}
