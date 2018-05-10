package rx.internal.operators;

import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;

public class OperatorDoOnRequest<T> implements Operator<T, T> {
    final Action1<Long> request;

    static final class ParentSubscriber<T> extends Subscriber<T> {
        private final Subscriber<? super T> f41942a;

        ParentSubscriber(Subscriber<? super T> subscriber) {
            this.f41942a = subscriber;
            m43807a(0);
        }

        public final void mo7906b() {
            this.f41942a.mo7906b();
        }

        public final void mo7904a(Throwable th) {
            this.f41942a.mo7904a(th);
        }

        public final void a_(T t) {
            this.f41942a.a_(t);
        }
    }

    public OperatorDoOnRequest(Action1<Long> action1) {
        this.request = action1;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final Subscription parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.mo7929a(new Producer(this) {
            final /* synthetic */ OperatorDoOnRequest f41708b;

            public final void mo7901a(long j) {
                this.f41708b.request.mo7899a(Long.valueOf(j));
                parentSubscriber.m43807a(j);
            }
        });
        subscriber.m43809a(parentSubscriber);
        return parentSubscriber;
    }
}
