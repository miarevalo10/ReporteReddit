package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.observers.Subscribers;

public final class OnSubscribeDefer<T> implements OnSubscribe<T> {
    final Func0<? extends Observable<? extends T>> f41884a;

    public final /* synthetic */ void mo7899a(Object obj) {
        Observer observer = (Subscriber) obj;
        try {
            ((Observable) this.f41884a.call()).m43406a(Subscribers.m43488a(observer));
        } catch (Throwable th) {
            Exceptions.m43432a(th, observer);
        }
    }

    public OnSubscribeDefer(Func0<? extends Observable<? extends T>> func0) {
        this.f41884a = func0;
    }
}
