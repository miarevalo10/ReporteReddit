package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

public final class OperatorSubscribeOn<T> implements OnSubscribe<T> {
    final Scheduler f41988a;
    final Observable<T> f41989b;

    public final /* synthetic */ void mo7899a(Object obj) {
        final Subscriber subscriber = (Subscriber) obj;
        final Subscription a = this.f41988a.mo7895a();
        subscriber.m43809a(a);
        a.mo7927a(new Action0(this) {
            final /* synthetic */ OperatorSubscribeOn f41717c;

            public final void mo7898a() {
                final Thread currentThread = Thread.currentThread();
                this.f41717c.f41989b.m43406a(new Subscriber<T>(this, subscriber) {
                    final /* synthetic */ C31181 f41987b;

                    public final void a_(T t) {
                        subscriber.a_(t);
                    }

                    public final void mo7904a(Throwable th) {
                        try {
                            subscriber.mo7904a(th);
                        } finally {
                            a.mo7893c();
                        }
                    }

                    public final void mo7906b() {
                        try {
                            subscriber.mo7906b();
                        } finally {
                            a.mo7893c();
                        }
                    }

                    public final void mo7929a(final Producer producer) {
                        subscriber.mo7929a(new Producer(this) {
                            final /* synthetic */ C31581 f41714b;

                            public final void mo7901a(final long j) {
                                if (currentThread == Thread.currentThread()) {
                                    producer.mo7901a(j);
                                } else {
                                    a.mo7927a(new Action0(this) {
                                        final /* synthetic */ C31171 f41712b;

                                        public final void mo7898a() {
                                            producer.mo7901a(j);
                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    public OperatorSubscribeOn(Observable<T> observable, Scheduler scheduler) {
        this.f41988a = scheduler;
        this.f41989b = observable;
    }
}
