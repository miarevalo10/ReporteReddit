package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableWindow<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final long f38111a;
    final long f38112b;
    final int f38113c;

    static final class WindowExactObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        final Observer<? super Observable<T>> f32255a;
        final long f32256b;
        final int f32257c;
        long f32258d;
        Disposable f32259e;
        UnicastSubject<T> f32260f;
        volatile boolean f32261g;

        WindowExactObserver(Observer<? super Observable<T>> observer, long j, int i) {
            this.f32255a = observer;
            this.f32256b = j;
            this.f32257c = i;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32259e, disposable)) {
                this.f32259e = disposable;
                this.f32255a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            UnicastSubject unicastSubject = this.f32260f;
            if (unicastSubject == null && !this.f32261g) {
                unicastSubject = UnicastSubject.m38183a(this.f32257c, (Runnable) this);
                this.f32260f = unicastSubject;
                this.f32255a.onNext(unicastSubject);
            }
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
                long j = this.f32258d + 1;
                this.f32258d = j;
                if (j >= this.f32256b) {
                    this.f32258d = 0;
                    this.f32260f = null;
                    unicastSubject.onComplete();
                    if (this.f32261g != null) {
                        this.f32259e.mo5626a();
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            UnicastSubject unicastSubject = this.f32260f;
            if (unicastSubject != null) {
                this.f32260f = null;
                unicastSubject.onError(th);
            }
            this.f32255a.onError(th);
        }

        public final void onComplete() {
            UnicastSubject unicastSubject = this.f32260f;
            if (unicastSubject != null) {
                this.f32260f = null;
                unicastSubject.onComplete();
            }
            this.f32255a.onComplete();
        }

        public final void mo5626a() {
            this.f32261g = true;
        }

        public final boolean mo5627b() {
            return this.f32261g;
        }

        public final void run() {
            if (this.f32261g) {
                this.f32259e.mo5626a();
            }
        }
    }

    static final class WindowSkipObserver<T> extends AtomicBoolean implements Observer<T>, Disposable, Runnable {
        final Observer<? super Observable<T>> f32262a;
        final long f32263b;
        final long f32264c;
        final int f32265d;
        final ArrayDeque<UnicastSubject<T>> f32266e;
        long f32267f;
        volatile boolean f32268g;
        long f32269h;
        Disposable f32270i;
        final AtomicInteger f32271j = new AtomicInteger();

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j, long j2, int i) {
            this.f32262a = observer;
            this.f32263b = j;
            this.f32264c = j2;
            this.f32265d = i;
            this.f32266e = new ArrayDeque();
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f32270i, disposable)) {
                this.f32270i = disposable;
                this.f32262a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            ArrayDeque arrayDeque = this.f32266e;
            long j = this.f32267f;
            long j2 = this.f32264c;
            if (j % j2 == 0 && !this.f32268g) {
                this.f32271j.getAndIncrement();
                UnicastSubject a = UnicastSubject.m38183a(this.f32265d, (Runnable) this);
                arrayDeque.offer(a);
                this.f32262a.onNext(a);
            }
            long j3 = this.f32269h + 1;
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                ((UnicastSubject) it.next()).onNext(t);
            }
            if (j3 >= this.f32263b) {
                ((UnicastSubject) arrayDeque.poll()).onComplete();
                if (arrayDeque.isEmpty() == null || this.f32268g == null) {
                    this.f32269h = j3 - j2;
                } else {
                    this.f32270i.mo5626a();
                    return;
                }
            }
            this.f32269h = j3;
            this.f32267f = j + 1;
        }

        public final void onError(Throwable th) {
            ArrayDeque arrayDeque = this.f32266e;
            while (!arrayDeque.isEmpty()) {
                ((UnicastSubject) arrayDeque.poll()).onError(th);
            }
            this.f32262a.onError(th);
        }

        public final void onComplete() {
            ArrayDeque arrayDeque = this.f32266e;
            while (!arrayDeque.isEmpty()) {
                ((UnicastSubject) arrayDeque.poll()).onComplete();
            }
            this.f32262a.onComplete();
        }

        public final void mo5626a() {
            this.f32268g = true;
        }

        public final boolean mo5627b() {
            return this.f32268g;
        }

        public final void run() {
            if (this.f32271j.decrementAndGet() == 0 && this.f32268g) {
                this.f32270i.mo5626a();
            }
        }
    }

    public ObservableWindow(ObservableSource<T> observableSource, long j, long j2, int i) {
        super(observableSource);
        this.f38111a = j;
        this.f38112b = j2;
        this.f38113c = i;
    }

    public final void subscribeActual(Observer<? super Observable<T>> observer) {
        if (this.f38111a == this.f38112b) {
            this.source.subscribe(new WindowExactObserver(observer, this.f38111a, this.f38113c));
            return;
        }
        this.source.subscribe(new WindowSkipObserver(observer, this.f38111a, this.f38112b, this.f38113c));
    }
}
