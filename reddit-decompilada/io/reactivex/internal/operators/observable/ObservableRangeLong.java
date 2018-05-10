package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableRangeLong extends Observable<Long> {
    private final long f35703a;
    private final long f35704b;

    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        final Observer<? super Long> f39618a;
        final long f39619b;
        long f39620c;
        boolean f39621d;

        RangeDisposable(Observer<? super Long> observer, long j, long j2) {
            this.f39618a = observer;
            this.f39620c = j;
            this.f39619b = j2;
        }

        public final boolean isEmpty() {
            return this.f39620c == this.f39619b;
        }

        public final void clear() {
            this.f39620c = this.f39619b;
            lazySet(1);
        }

        public final void mo5626a() {
            set(1);
        }

        public final boolean mo5627b() {
            return get() != 0;
        }

        public final int mo7033a(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f39621d = true;
            return 1;
        }

        public final /* synthetic */ Object poll() throws Exception {
            long j = this.f39620c;
            if (j != this.f39619b) {
                this.f39620c = 1 + j;
                return Long.valueOf(j);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRangeLong(long j, long j2) {
        this.f35703a = j;
        this.f35704b = j2;
    }

    protected final void subscribeActual(Observer<? super Long> observer) {
        Observer<? super Long> observer2 = observer;
        RangeDisposable rangeDisposable = new RangeDisposable(observer2, this.f35703a, this.f35704b + this.f35703a);
        observer.onSubscribe(rangeDisposable);
        if (rangeDisposable.f39621d == null) {
            observer = rangeDisposable.f39618a;
            long j = rangeDisposable.f39619b;
            for (long j2 = rangeDisposable.f39620c; j2 != j && rangeDisposable.get() == 0; j2++) {
                observer.onNext(Long.valueOf(j2));
            }
            if (rangeDisposable.get() == 0) {
                rangeDisposable.lazySet(1);
                observer.onComplete();
            }
        }
    }
}
