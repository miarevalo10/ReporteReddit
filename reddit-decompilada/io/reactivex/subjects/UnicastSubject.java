package io.reactivex.subjects;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class UnicastSubject<T> extends Subject<T> {
    final SpscLinkedArrayQueue<T> f38181a;
    final AtomicReference<Observer<? super T>> f38182b;
    final AtomicReference<Runnable> f38183c;
    final boolean f38184d;
    volatile boolean f38185e;
    volatile boolean f38186f;
    Throwable f38187g;
    final AtomicBoolean f38188h;
    final BasicIntQueueDisposable<T> f38189i;
    boolean f38190j;

    final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        final /* synthetic */ UnicastSubject f39690a;

        UnicastQueueDisposable(UnicastSubject unicastSubject) {
            this.f39690a = unicastSubject;
        }

        public final int mo7033a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f39690a.f38190j = true;
            return 2;
        }

        public final T poll() throws Exception {
            return this.f39690a.f38181a.poll();
        }

        public final boolean isEmpty() {
            return this.f39690a.f38181a.isEmpty();
        }

        public final void clear() {
            this.f39690a.f38181a.clear();
        }

        public final void mo5626a() {
            if (!this.f39690a.f38185e) {
                this.f39690a.f38185e = true;
                this.f39690a.m38187b();
                this.f39690a.f38182b.lazySet(null);
                if (this.f39690a.f38189i.getAndIncrement() == 0) {
                    this.f39690a.f38182b.lazySet(null);
                    this.f39690a.f38181a.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return this.f39690a.f38185e;
        }
    }

    public static <T> UnicastSubject<T> m38181a() {
        return new UnicastSubject(Observable.bufferSize());
    }

    public static <T> UnicastSubject<T> m38182a(int i) {
        return new UnicastSubject(i);
    }

    public static <T> UnicastSubject<T> m38183a(int i, Runnable runnable) {
        return new UnicastSubject(i, runnable);
    }

    private UnicastSubject(int i) {
        this.f38181a = new SpscLinkedArrayQueue(ObjectHelper.m26569a(i, "capacityHint"));
        this.f38183c = new AtomicReference();
        this.f38184d = true;
        this.f38182b = new AtomicReference();
        this.f38188h = new AtomicBoolean();
        this.f38189i = new UnicastQueueDisposable(this);
    }

    private UnicastSubject(int i, Runnable runnable) {
        this.f38181a = new SpscLinkedArrayQueue(ObjectHelper.m26569a(i, "capacityHint"));
        this.f38183c = new AtomicReference(ObjectHelper.m26573a((Object) runnable, "onTerminate"));
        this.f38184d = true;
        this.f38182b = new AtomicReference();
        this.f38188h = new AtomicBoolean();
        this.f38189i = new UnicastQueueDisposable(this);
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        if (this.f38188h.get() || !this.f38188h.compareAndSet(false, true)) {
            EmptyDisposable.m38051a(new IllegalStateException("Only a single observer allowed."), (Observer) observer);
            return;
        }
        observer.onSubscribe(this.f38189i);
        this.f38182b.lazySet(observer);
        if (this.f38185e != null) {
            this.f38182b.lazySet(null);
        } else {
            m38186c();
        }
    }

    final void m38187b() {
        Runnable runnable = (Runnable) this.f38183c.get();
        if (runnable != null && this.f38183c.compareAndSet(runnable, null)) {
            runnable.run();
        }
    }

    public final void onSubscribe(Disposable disposable) {
        if (this.f38186f || this.f38185e) {
            disposable.mo5626a();
        }
    }

    public final void onNext(T t) {
        ObjectHelper.m26573a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f38186f) {
            if (!this.f38185e) {
                this.f38181a.offer(t);
                m38186c();
            }
        }
    }

    public final void onError(Throwable th) {
        ObjectHelper.m26573a((Object) th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (!this.f38186f) {
            if (!this.f38185e) {
                this.f38187g = th;
                this.f38186f = true;
                m38187b();
                m38186c();
                return;
            }
        }
        RxJavaPlugins.m26757a(th);
    }

    public final void onComplete() {
        if (!this.f38186f) {
            if (!this.f38185e) {
                this.f38186f = true;
                m38187b();
                m38186c();
            }
        }
    }

    private void m38184a(Observer<? super T> observer) {
        this.f38182b.lazySet(null);
        Throwable th = this.f38187g;
        if (th != null) {
            observer.onError(th);
        } else {
            observer.onComplete();
        }
    }

    private boolean m38185a(SimpleQueue<T> simpleQueue, Observer<? super T> observer) {
        Throwable th = this.f38187g;
        if (th == null) {
            return null;
        }
        this.f38182b.lazySet(null);
        simpleQueue.clear();
        observer.onError(th);
        return true;
    }

    private void m38186c() {
        if (this.f38189i.getAndIncrement() == 0) {
            Observer observer = (Observer) this.f38182b.get();
            int i = 1;
            int i2 = 1;
            while (observer == null) {
                i2 = this.f38189i.addAndGet(-i2);
                if (i2 != 0) {
                    observer = (Observer) this.f38182b.get();
                } else {
                    return;
                }
            }
            if (this.f38190j) {
                SimpleQueue simpleQueue = this.f38181a;
                int i3 = this.f38184d ^ 1;
                while (!this.f38185e) {
                    boolean z = this.f38186f;
                    if (i3 == 0 || !z || !m38185a(simpleQueue, observer)) {
                        observer.onNext(null);
                        if (z) {
                            m38184a(observer);
                            return;
                        } else {
                            i = this.f38189i.addAndGet(-i);
                            if (i == 0) {
                            }
                        }
                    }
                    return;
                }
                this.f38182b.lazySet(null);
                simpleQueue.clear();
                return;
            }
            SimpleQueue simpleQueue2 = this.f38181a;
            int i4 = this.f38184d ^ 1;
            i2 = 1;
            int i5 = i2;
            while (!this.f38185e) {
                boolean z2 = this.f38186f;
                Object poll = this.f38181a.poll();
                int i6 = poll == null ? 1 : 0;
                if (z2) {
                    if (!(i4 == 0 || r2 == 0)) {
                        if (!m38185a(simpleQueue2, observer)) {
                            i2 = 0;
                        } else {
                            return;
                        }
                    }
                    if (i6 != 0) {
                        m38184a(observer);
                        return;
                    }
                }
                if (i6 == 0) {
                    observer.onNext(poll);
                } else {
                    i5 = this.f38189i.addAndGet(-i5);
                    if (i5 == 0) {
                        return;
                    }
                }
            }
            this.f38182b.lazySet(null);
            simpleQueue2.clear();
        }
    }

    public final boolean hasObservers() {
        return this.f38182b.get() != null;
    }

    public final Throwable getThrowable() {
        return this.f38186f ? this.f38187g : null;
    }

    public final boolean hasThrowable() {
        return this.f38186f && this.f38187g != null;
    }

    public final boolean hasComplete() {
        return this.f38186f && this.f38187g == null;
    }
}
