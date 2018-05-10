package rx.observers;

import rx.Observer;
import rx.Subscriber;

public final class Subscribers {
    public static <T> Subscriber<T> m43487a() {
        final Observer a = Observers.m43485a();
        return new Subscriber<T>() {
            public final void mo7906b() {
                a.mo7906b();
            }

            public final void mo7904a(Throwable th) {
                a.mo7904a(th);
            }

            public final void a_(T t) {
                a.a_(t);
            }
        };
    }

    public static <T> Subscriber<T> m43488a(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            public final void mo7906b() {
                subscriber.mo7906b();
            }

            public final void mo7904a(Throwable th) {
                subscriber.mo7904a(th);
            }

            public final void a_(T t) {
                subscriber.a_(t);
            }
        };
    }
}
