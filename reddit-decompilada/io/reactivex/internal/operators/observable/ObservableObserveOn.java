package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.QueueDisposable;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;

public final class ObservableObserveOn<T> extends AbstractObservableWithUpstream<T, T> {
    final Scheduler f38032a;
    final boolean f38033b;
    final int f38034c;

    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        final Observer<? super T> f39603a;
        final Worker f39604b;
        final boolean f39605c;
        final int f39606d;
        SimpleQueue<T> f39607e;
        Disposable f39608f;
        Throwable f39609g;
        volatile boolean f39610h;
        volatile boolean f39611i;
        int f39612j;
        boolean f39613k;

        ObserveOnObserver(Observer<? super T> observer, Worker worker, boolean z, int i) {
            this.f39603a = observer;
            this.f39604b = worker;
            this.f39605c = z;
            this.f39606d = i;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39608f, disposable)) {
                this.f39608f = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int a = queueDisposable.mo7033a(7);
                    if (a == 1) {
                        this.f39612j = a;
                        this.f39607e = queueDisposable;
                        this.f39610h = true;
                        this.f39603a.onSubscribe(this);
                        m39743c();
                        return;
                    } else if (a == 2) {
                        this.f39612j = a;
                        this.f39607e = queueDisposable;
                        this.f39603a.onSubscribe(this);
                        return;
                    }
                }
                this.f39607e = new SpscLinkedArrayQueue(this.f39606d);
                this.f39603a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f39610h) {
                if (this.f39612j != 2) {
                    this.f39607e.offer(t);
                }
                m39743c();
            }
        }

        public final void onError(Throwable th) {
            if (this.f39610h) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f39609g = th;
            this.f39610h = true;
            m39743c();
        }

        public final void onComplete() {
            if (!this.f39610h) {
                this.f39610h = true;
                m39743c();
            }
        }

        public final void mo5626a() {
            if (!this.f39611i) {
                this.f39611i = true;
                this.f39608f.mo5626a();
                this.f39604b.mo5626a();
                if (getAndIncrement() == 0) {
                    this.f39607e.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return this.f39611i;
        }

        private void m39743c() {
            if (getAndIncrement() == 0) {
                this.f39604b.mo6651a((Runnable) this);
            }
        }

        public final void run() {
            int i = 1;
            if (this.f39613k) {
                while (!this.f39611i) {
                    boolean z = this.f39610h;
                    Throwable th = this.f39609g;
                    if (this.f39605c || !z || th == null) {
                        this.f39603a.onNext(null);
                        if (!z) {
                            i = addAndGet(-i);
                            if (i == 0) {
                                break;
                            }
                        }
                        Throwable th2 = this.f39609g;
                        if (th2 != null) {
                            this.f39603a.onError(th2);
                        } else {
                            this.f39603a.onComplete();
                        }
                        this.f39604b.mo5626a();
                        return;
                    }
                    this.f39603a.onError(this.f39609g);
                    this.f39604b.mo5626a();
                    return;
                }
                return;
            }
            SimpleQueue simpleQueue = this.f39607e;
            Observer observer = this.f39603a;
            int i2 = 1;
            loop1:
            while (!m39742a(this.f39610h, simpleQueue.isEmpty(), observer)) {
                while (true) {
                    boolean z2 = this.f39610h;
                    try {
                        Object poll = simpleQueue.poll();
                        boolean z3 = poll == null;
                        if (!m39742a(z2, z3, observer)) {
                            if (z3) {
                                break;
                            }
                            observer.onNext(poll);
                        } else {
                            break loop1;
                        }
                    } catch (Throwable th3) {
                        Exceptions.m26521b(th3);
                        this.f39608f.mo5626a();
                        simpleQueue.clear();
                        observer.onError(th3);
                        this.f39604b.mo5626a();
                        return;
                    }
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    break;
                }
            }
        }

        private boolean m39742a(boolean z, boolean z2, Observer<? super T> observer) {
            if (this.f39611i) {
                this.f39607e.clear();
                return true;
            }
            if (z) {
                z = this.f39609g;
                if (this.f39605c) {
                    if (z2) {
                        if (z) {
                            observer.onError(z);
                        } else {
                            observer.onComplete();
                        }
                        this.f39604b.mo5626a();
                        return true;
                    }
                } else if (z) {
                    this.f39607e.clear();
                    observer.onError(z);
                    this.f39604b.mo5626a();
                    return true;
                } else if (z2) {
                    observer.onComplete();
                    this.f39604b.mo5626a();
                    return true;
                }
            }
            return false;
        }

        public final int mo7033a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.f39613k = true;
            return 2;
        }

        public final T poll() throws Exception {
            return this.f39607e.poll();
        }

        public final void clear() {
            this.f39607e.clear();
        }

        public final boolean isEmpty() {
            return this.f39607e.isEmpty();
        }
    }

    public ObservableObserveOn(ObservableSource<T> observableSource, Scheduler scheduler, boolean z, int i) {
        super(observableSource);
        this.f38032a = scheduler;
        this.f38033b = z;
        this.f38034c = i;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        if (this.f38032a instanceof TrampolineScheduler) {
            this.source.subscribe(observer);
            return;
        }
        this.source.subscribe(new ObserveOnObserver(observer, this.f38032a.mo5629a(), this.f38033b, this.f38034c));
    }
}
