package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;

public class OperatorDoOnSubscribe<T> implements Operator<T, T> {
    private final Action0 f41943a;

    public /* synthetic */ Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        this.f41943a.mo7898a();
        return Subscribers.m43488a(subscriber);
    }

    public OperatorDoOnSubscribe(Action0 action0) {
        this.f41943a = action0;
    }
}
