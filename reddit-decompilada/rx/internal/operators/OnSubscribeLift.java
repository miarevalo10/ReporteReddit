package rx.internal.operators;

import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeLift<T, R> implements OnSubscribe<R> {
    final OnSubscribe<T> f41897a;
    final Operator<? extends R, ? super T> f41898b;

    public final /* synthetic */ void mo7899a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Subscriber subscriber2;
        try {
            subscriber2 = (Subscriber) RxJavaHooks.m43495a(this.f41898b).call(subscriber);
            subscriber2.aV_();
            this.f41897a.mo7899a(subscriber2);
        } catch (Throwable th) {
            Exceptions.m43435b(th);
            subscriber.mo7904a(th);
        }
    }

    public OnSubscribeLift(OnSubscribe<T> onSubscribe, Operator<? extends R, ? super T> operator) {
        this.f41897a = onSubscribe;
        this.f41898b = operator;
    }
}
