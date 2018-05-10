package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableRange extends Observable<Integer> {
    private final int f35701a;
    private final long f35702b;

    static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        final Observer<? super Integer> f39614a;
        final long f39615b;
        long f39616c;
        boolean f39617d;

        RangeDisposable(Observer<? super Integer> observer, long j, long j2) {
            this.f39614a = observer;
            this.f39616c = j;
            this.f39615b = j2;
        }

        public final boolean isEmpty() {
            return this.f39616c == this.f39615b;
        }

        public final void clear() {
            this.f39616c = this.f39615b;
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
            this.f39617d = true;
            return 1;
        }

        public final /* synthetic */ Object poll() throws Exception {
            long j = this.f39616c;
            if (j != this.f39615b) {
                this.f39616c = 1 + j;
                return Integer.valueOf((int) j);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRange(int i, int i2) {
        this.f35701a = i;
        this.f35702b = ((long) i) + ((long) i2);
    }

    protected final void subscribeActual(Observer<? super Integer> observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, (long) this.f35701a, this.f35702b);
        observer.onSubscribe(rangeDisposable);
        if (rangeDisposable.f39617d == null) {
            observer = rangeDisposable.f39614a;
            long j = rangeDisposable.f39615b;
            for (long j2 = rangeDisposable.f39616c; j2 != j && rangeDisposable.get() == 0; j2++) {
                observer.onNext(Integer.valueOf((int) j2));
            }
            if (rangeDisposable.get() == 0) {
                rangeDisposable.lazySet(1);
                observer.onComplete();
            }
        }
    }
}
