package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSkipLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long f38073a;
    final TimeUnit f38074b;
    final Scheduler f38075c;
    final int f38076d;
    final boolean f38077e;

    static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        final Observer<? super T> f32119a;
        final long f32120b;
        final TimeUnit f32121c;
        final Scheduler f32122d;
        final SpscLinkedArrayQueue<Object> f32123e;
        final boolean f32124f;
        Disposable f32125g;
        volatile boolean f32126h;
        volatile boolean f32127i;
        Throwable f32128j;

        SkipLastTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.f32119a = observer;
            this.f32120b = j;
            this.f32121c = timeUnit;
            this.f32122d = scheduler;
            this.f32123e = new SpscLinkedArrayQueue(i);
            this.f32124f = z;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32125g, disposable)) {
                this.f32125g = disposable;
                this.f32119a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f32123e.m35964a(Long.valueOf(Scheduler.m26494a(this.f32121c)), (Object) t);
            m32610c();
        }

        public final void onError(Throwable th) {
            this.f32128j = th;
            this.f32127i = true;
            m32610c();
        }

        public final void onComplete() {
            this.f32127i = true;
            m32610c();
        }

        public final void mo5626a() {
            if (!this.f32126h) {
                this.f32126h = true;
                this.f32125g.mo5626a();
                if (getAndIncrement() == 0) {
                    this.f32123e.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return this.f32126h;
        }

        private void m32610c() {
            if (getAndIncrement() == 0) {
                Observer observer = this.f32119a;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f32123e;
                boolean z = this.f32124f;
                TimeUnit timeUnit = this.f32121c;
                long j = this.f32120b;
                int i = 1;
                while (!this.f32126h) {
                    boolean z2 = this.f32127i;
                    Long l = (Long) spscLinkedArrayQueue.m35963a();
                    Object obj = l == null ? 1 : null;
                    long a = Scheduler.m26494a(timeUnit);
                    if (obj == null && l.longValue() > a - j) {
                        obj = 1;
                    }
                    if (z2) {
                        if (!z) {
                            Throwable th = this.f32128j;
                            if (th != null) {
                                this.f32123e.clear();
                                observer.onError(th);
                                return;
                            } else if (obj != null) {
                                observer.onComplete();
                                return;
                            }
                        } else if (obj != null) {
                            Throwable th2 = this.f32128j;
                            if (th2 != null) {
                                observer.onError(th2);
                                return;
                            } else {
                                observer.onComplete();
                                return;
                            }
                        }
                    }
                    if (obj == null) {
                        spscLinkedArrayQueue.poll();
                        observer.onNext(spscLinkedArrayQueue.poll());
                    } else {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                }
                this.f32123e.clear();
            }
        }
    }

    public ObservableSkipLastTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(observableSource);
        this.f38073a = j;
        this.f38074b = timeUnit;
        this.f38075c = scheduler;
        this.f38076d = i;
        this.f38077e = z;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipLastTimedObserver(observer, this.f38073a, this.f38074b, this.f38075c, this.f38076d, this.f38077e));
    }
}
