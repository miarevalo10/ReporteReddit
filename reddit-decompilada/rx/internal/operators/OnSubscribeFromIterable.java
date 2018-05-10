package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class OnSubscribeFromIterable<T> implements OnSubscribe<T> {
    final Iterable<? extends T> f41896a;

    static final class IterableProducer<T> extends AtomicLong implements Producer {
        private final Subscriber<? super T> f41678a;
        private final Iterator<? extends T> f41679b;

        IterableProducer(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            this.f41678a = subscriber;
            this.f41679b = it;
        }

        public final void mo7901a(long j) {
            if (get() != Long.MAX_VALUE) {
                if (j == Long.MAX_VALUE && compareAndSet(0, Long.MAX_VALUE)) {
                    Observer observer = this.f41678a;
                    Iterator it = this.f41679b;
                    while (!observer.mo7894d()) {
                        try {
                            observer.a_(it.next());
                            if (observer.mo7894d()) {
                                break;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!observer.mo7894d()) {
                                        observer.mo7906b();
                                    }
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.m43432a(th, observer);
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.m43432a(th2, observer);
                            return;
                        }
                    }
                    return;
                }
                if (j > 0 && BackpressureUtils.m43445a((AtomicLong) this, j) == 0) {
                    Observer observer2 = this.f41678a;
                    Iterator it2 = this.f41679b;
                    long j2 = j;
                    loop1:
                    while (true) {
                        j = 0;
                        while (true) {
                            if (j != j2) {
                                if (observer2.mo7894d()) {
                                    break loop1;
                                }
                                try {
                                    observer2.a_(it2.next());
                                    if (observer2.mo7894d()) {
                                        break loop1;
                                    }
                                    try {
                                        if (!it2.hasNext()) {
                                            break loop1;
                                        }
                                        j++;
                                    } catch (Throwable th3) {
                                        Exceptions.m43432a(th3, observer2);
                                        return;
                                    }
                                } catch (Throwable th32) {
                                    Exceptions.m43432a(th32, observer2);
                                    return;
                                }
                            }
                            j2 = get();
                            if (j == j2) {
                                break;
                            }
                        }
                        j2 = BackpressureUtils.m43447b(this, j);
                        if (j2 == 0) {
                            break;
                        }
                    }
                    if (observer2.mo7894d() == null) {
                        observer2.mo7906b();
                    }
                }
            }
        }
    }

    public final /* synthetic */ void mo7899a(Object obj) {
        Observer observer = (Subscriber) obj;
        try {
            Iterator it = this.f41896a.iterator();
            boolean hasNext = it.hasNext();
            if (!observer.mo7894d()) {
                if (hasNext) {
                    observer.mo7929a(new IterableProducer(observer, it));
                } else {
                    observer.mo7906b();
                }
            }
        } catch (Throwable th) {
            Exceptions.m43432a(th, observer);
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable == null) {
            throw new NullPointerException("iterable must not be null");
        }
        this.f41896a = iterable;
    }
}
