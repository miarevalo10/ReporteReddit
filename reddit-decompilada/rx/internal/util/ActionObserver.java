package rx.internal.util;

import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

public final class ActionObserver<T> implements Observer<T> {
    final Action1<? super T> f41769a;
    final Action1<Throwable> f41770b;
    final Action0 f41771c;

    public ActionObserver(Action1<? super T> action1, Action1<Throwable> action12, Action0 action0) {
        this.f41769a = action1;
        this.f41770b = action12;
        this.f41771c = action0;
    }

    public final void a_(T t) {
        this.f41769a.mo7899a(t);
    }

    public final void mo7904a(Throwable th) {
        this.f41770b.mo7899a(th);
    }

    public final void mo7906b() {
        this.f41771c.mo7898a();
    }
}
