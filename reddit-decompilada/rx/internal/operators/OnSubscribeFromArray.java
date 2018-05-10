package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;

public final class OnSubscribeFromArray<T> implements OnSubscribe<T> {
    final T[] f41895a;

    static final class FromArrayProducer<T> extends AtomicLong implements Producer {
        final Subscriber<? super T> f41675a;
        final T[] f41676b;
        int f41677c;

        public FromArrayProducer(Subscriber<? super T> subscriber, T[] tArr) {
            this.f41675a = subscriber;
            this.f41676b = tArr;
        }

        public final void mo7901a(long j) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                StringBuilder stringBuilder = new StringBuilder("n >= 0 required but it was ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            if (j == Long.MAX_VALUE) {
                if (BackpressureUtils.m43445a((AtomicLong) this, j) == 0) {
                    m43824a();
                }
            } else if (i != 0 && BackpressureUtils.m43445a((AtomicLong) this, j) == 0) {
                m43825b(j);
            }
        }

        private void m43824a() {
            Subscriber subscriber = this.f41675a;
            Object[] objArr = this.f41676b;
            int i = 0;
            int length = objArr.length;
            while (i < length) {
                Object obj = objArr[i];
                if (!subscriber.mo7894d()) {
                    subscriber.a_(obj);
                    i++;
                } else {
                    return;
                }
            }
            if (!subscriber.mo7894d()) {
                subscriber.mo7906b();
            }
        }

        private void m43825b(long j) {
            Subscriber subscriber = this.f41675a;
            Object[] objArr = this.f41676b;
            int length = objArr.length;
            int i = this.f41677c;
            loop0:
            do {
                long j2 = 0;
                while (true) {
                    if (j == 0 || i == length) {
                        j = get() + j2;
                        if (j == 0) {
                            this.f41677c = i;
                            j = addAndGet(j2);
                        }
                    } else if (!subscriber.mo7894d()) {
                        subscriber.a_(objArr[i]);
                        i++;
                        if (i == length) {
                            break loop0;
                        }
                        j--;
                        j2--;
                    } else {
                        return;
                    }
                }
                if (subscriber.mo7894d() == null) {
                    subscriber.mo7906b();
                }
                return;
            } while (j != 0);
        }
    }

    public final /* synthetic */ void mo7899a(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        subscriber.mo7929a(new FromArrayProducer(subscriber, this.f41895a));
    }

    public OnSubscribeFromArray(T[] tArr) {
        this.f41895a = tArr;
    }
}
