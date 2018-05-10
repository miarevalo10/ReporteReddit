package rx.internal.operators;

import rx.Observable.Operator;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;
import rx.plugins.RxJavaHooks;

public final class OperatorAny<T> implements Operator<Boolean, T> {
    final Func1<? super T, Boolean> f41927a;
    final boolean f41928b = true;

    public final /* synthetic */ Object call(Object obj) {
        final Subscriber subscriber = (Subscriber) obj;
        final Producer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        Subscription c31561 = new Subscriber<T>(this) {
            boolean f41922a;
            boolean f41923b;
            final /* synthetic */ OperatorAny f41926f;

            public final void a_(T t) {
                if (!this.f41923b) {
                    this.f41922a = true;
                    try {
                        if (((Boolean) this.f41926f.f41927a.call(t)).booleanValue()) {
                            this.f41923b = true;
                            singleDelayedProducer.m43848a(Boolean.valueOf(true ^ this.f41926f.f41928b));
                            this.f41662d.mo7893c();
                        }
                    } catch (Throwable th) {
                        Exceptions.m43433a(th, this, t);
                    }
                }
            }

            public final void mo7904a(Throwable th) {
                if (this.f41923b) {
                    RxJavaHooks.m43500a(th);
                    return;
                }
                this.f41923b = true;
                subscriber.mo7904a(th);
            }

            public final void mo7906b() {
                if (!this.f41923b) {
                    this.f41923b = true;
                    if (this.f41922a) {
                        singleDelayedProducer.m43848a(Boolean.valueOf(false));
                        return;
                    }
                    singleDelayedProducer.m43848a(Boolean.valueOf(this.f41926f.f41928b));
                }
            }
        };
        subscriber.m43809a(c31561);
        subscriber.mo7929a(singleDelayedProducer);
        return c31561;
    }

    public OperatorAny(Func1<? super T, Boolean> func1) {
        this.f41927a = func1;
    }
}
