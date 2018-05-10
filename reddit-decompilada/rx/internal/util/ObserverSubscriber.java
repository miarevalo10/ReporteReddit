package rx.internal.util;

import rx.Observer;
import rx.Subscriber;

public final class ObserverSubscriber<T> extends Subscriber<T> {
    final Observer<? super T> f42023a;

    public ObserverSubscriber(Observer<? super T> observer) {
        this.f42023a = observer;
    }

    public final void a_(T t) {
        this.f42023a.a_(t);
    }

    public final void mo7904a(Throwable th) {
        this.f42023a.mo7904a(th);
    }

    public final void mo7906b() {
        this.f42023a.mo7906b();
    }
}
