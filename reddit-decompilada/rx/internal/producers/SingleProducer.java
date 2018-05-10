package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class SingleProducer<T> extends AtomicBoolean implements Producer {
    final Subscriber<? super T> f41728a;
    final T f41729b;

    public SingleProducer(Subscriber<? super T> subscriber, T t) {
        this.f41728a = subscriber;
        this.f41729b = t;
    }

    public final void mo7901a(long j) {
        j = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (j < null) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (!(j == null || compareAndSet(0, true) == null)) {
            j = this.f41728a;
            if (!j.mo7894d()) {
                Object obj = this.f41729b;
                try {
                    j.a_(obj);
                    if (!j.mo7894d()) {
                        j.mo7906b();
                    }
                } catch (Throwable th) {
                    Exceptions.m43433a(th, j, obj);
                }
            }
        }
    }
}
