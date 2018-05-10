package rx.internal.operators;

import rx.Observable.OnSubscribe;
import rx.Subscriber;

public final class OnSubscribeThrow<T> implements OnSubscribe<T> {
    private final Throwable f41918a;

    public final /* bridge */ /* synthetic */ void mo7899a(Object obj) {
        ((Subscriber) obj).mo7904a(this.f41918a);
    }

    public OnSubscribeThrow(Throwable th) {
        this.f41918a = th;
    }
}
