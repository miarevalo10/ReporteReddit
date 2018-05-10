package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableTakeLastTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long f38087a;
    final long f38088b;
    final TimeUnit f38089c;
    final Scheduler f38090d;
    final int f38091e;
    final boolean f38092f;

    static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        final Observer<? super T> f32175a;
        final long f32176b;
        final long f32177c;
        final TimeUnit f32178d;
        final Scheduler f32179e;
        final SpscLinkedArrayQueue<Object> f32180f;
        final boolean f32181g;
        Disposable f32182h;
        volatile boolean f32183i;
        Throwable f32184j;

        TakeLastTimedObserver(Observer<? super T> observer, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
            this.f32175a = observer;
            this.f32176b = j;
            this.f32177c = j2;
            this.f32178d = timeUnit;
            this.f32179e = scheduler;
            this.f32180f = new SpscLinkedArrayQueue(i);
            this.f32181g = z;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32182h, disposable)) {
                this.f32182h = disposable;
                this.f32175a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            SpscLinkedArrayQueue spscLinkedArrayQueue = this.f32180f;
            long a = Scheduler.m26494a(this.f32178d);
            long j = this.f32177c;
            long j2 = this.f32176b;
            int i = j2 == Long.MAX_VALUE ? 1 : 0;
            spscLinkedArrayQueue.m35964a(Long.valueOf(a), (Object) t);
            while (spscLinkedArrayQueue.isEmpty() == null) {
                if (((Long) spscLinkedArrayQueue.m35963a()).longValue() <= a - j || (i == 0 && ((long) (spscLinkedArrayQueue.m35965b() >> 1)) > j2)) {
                    spscLinkedArrayQueue.poll();
                    spscLinkedArrayQueue.poll();
                } else {
                    return;
                }
            }
        }

        public final void onError(Throwable th) {
            this.f32184j = th;
            m32627c();
        }

        public final void onComplete() {
            m32627c();
        }

        public final void mo5626a() {
            if (!this.f32183i) {
                this.f32183i = true;
                this.f32182h.mo5626a();
                if (compareAndSet(false, true)) {
                    this.f32180f.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return this.f32183i;
        }

        private void m32627c() {
            if (compareAndSet(false, true)) {
                Observer observer = this.f32175a;
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f32180f;
                boolean z = this.f32181g;
                while (!this.f32183i) {
                    if (!z) {
                        Throwable th = this.f32184j;
                        if (th != null) {
                            spscLinkedArrayQueue.clear();
                            observer.onError(th);
                            return;
                        }
                    }
                    Object poll = spscLinkedArrayQueue.poll();
                    if (poll == null) {
                        Throwable th2 = this.f32184j;
                        if (th2 != null) {
                            observer.onError(th2);
                            return;
                        } else {
                            observer.onComplete();
                            return;
                        }
                    }
                    Object poll2 = spscLinkedArrayQueue.poll();
                    if (((Long) poll).longValue() >= Scheduler.m26494a(this.f32178d) - this.f32177c) {
                        observer.onNext(poll2);
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }
    }

    public ObservableTakeLastTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i, boolean z) {
        super(observableSource);
        this.f38087a = j;
        this.f38088b = j2;
        this.f38089c = timeUnit;
        this.f38090d = scheduler;
        this.f38091e = i;
        this.f38092f = z;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new TakeLastTimedObserver(observer, this.f38087a, this.f38088b, this.f38089c, this.f38090d, this.f38091e, this.f38092f));
    }
}
