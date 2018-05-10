package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Func1;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeFilter<T> implements OnSubscribe<T> {
    final Observable<T> f41893a;
    final Func1<? super T, Boolean> f41894b;

    static final class FilterSubscriber<T> extends Subscriber<T> {
        final Subscriber<? super T> f41890a;
        final Func1<? super T, Boolean> f41891b;
        boolean f41892c;

        public FilterSubscriber(Subscriber<? super T> subscriber, Func1<? super T, Boolean> func1) {
            this.f41890a = subscriber;
            this.f41891b = func1;
            m43807a((long) null);
        }

        public final void a_(T t) {
            try {
                if (((Boolean) this.f41891b.call(t)).booleanValue()) {
                    this.f41890a.a_(t);
                } else {
                    m43807a(1);
                }
            } catch (Throwable th) {
                Exceptions.m43435b(th);
                this.f41662d.mo7893c();
                mo7904a(OnErrorThrowable.m43437a(th, t));
            }
        }

        public final void mo7904a(Throwable th) {
            if (this.f41892c) {
                RxJavaHooks.m43500a(th);
                return;
            }
            this.f41892c = true;
            this.f41890a.mo7904a(th);
        }

        public final void mo7906b() {
            if (!this.f41892c) {
                this.f41890a.mo7906b();
            }
        }

        public final void mo7929a(Producer producer) {
            super.mo7929a(producer);
            this.f41890a.mo7929a(producer);
        }
    }

    public final /* synthetic */ void mo7899a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Subscriber filterSubscriber = new FilterSubscriber(subscriber, this.f41894b);
        subscriber.m43809a((Subscription) filterSubscriber);
        this.f41893a.m43406a(filterSubscriber);
    }

    public OnSubscribeFilter(Observable<T> observable, Func1<? super T, Boolean> func1) {
        this.f41893a = observable;
        this.f41894b = func1;
    }
}
