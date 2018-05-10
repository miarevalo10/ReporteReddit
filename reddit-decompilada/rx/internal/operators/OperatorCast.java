package rx.internal.operators;

import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.plugins.RxJavaHooks;

public class OperatorCast<T, R> implements Operator<R, T> {
    final Class<R> f41932a;

    static final class CastSubscriber<T, R> extends Subscriber<T> {
        final Subscriber<? super R> f41929a;
        final Class<R> f41930b;
        boolean f41931c;

        public CastSubscriber(Subscriber<? super R> subscriber, Class<R> cls) {
            this.f41929a = subscriber;
            this.f41930b = cls;
        }

        public final void a_(T t) {
            try {
                this.f41929a.a_(this.f41930b.cast(t));
            } catch (Throwable th) {
                Exceptions.m43435b(th);
                this.f41662d.mo7893c();
                mo7904a(OnErrorThrowable.m43437a(th, t));
            }
        }

        public final void mo7904a(Throwable th) {
            if (this.f41931c) {
                RxJavaHooks.m43500a(th);
                return;
            }
            this.f41931c = true;
            this.f41929a.mo7904a(th);
        }

        public final void mo7906b() {
            if (!this.f41931c) {
                this.f41929a.mo7906b();
            }
        }

        public final void mo7929a(Producer producer) {
            this.f41929a.mo7929a(producer);
        }
    }

    public /* synthetic */ Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Subscription castSubscriber = new CastSubscriber(subscriber, this.f41932a);
        subscriber.m43809a(castSubscriber);
        return castSubscriber;
    }

    public OperatorCast(Class<R> cls) {
        this.f41932a = cls;
    }
}
