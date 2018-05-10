package rx.internal.util;

import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

public final class ActionSubscriber<T> extends Subscriber<T> {
    final Action1<? super T> f42020a;
    final Action1<Throwable> f42021b;
    final Action0 f42022c;

    public ActionSubscriber(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        this.f42020a = action1;
        this.f42021b = action12;
        this.f42022c = action0;
    }

    public final void a_(T t) {
        this.f42020a.mo7899a(t);
    }

    public final void mo7904a(Throwable th) {
        this.f42021b.mo7899a(th);
    }

    public final void mo7906b() {
        this.f42022c.mo7898a();
    }
}
