package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;
import rx.subscriptions.Subscriptions;

public class OperatorDoOnUnsubscribe<T> implements Operator<T, T> {
    private final Action0 f41944a;

    public /* synthetic */ Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.m43809a(Subscriptions.m43537a(this.f41944a));
        return Subscribers.m43488a(subscriber);
    }

    public OperatorDoOnUnsubscribe(Action0 action0) {
        this.f41944a = action0;
    }
}
