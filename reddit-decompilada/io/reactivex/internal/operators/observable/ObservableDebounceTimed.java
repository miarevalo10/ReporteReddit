package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableDebounceTimed<T> extends AbstractObservableWithUpstream<T, T> {
    final long f37977a;
    final TimeUnit f37978b;
    final Scheduler f37979c;

    static final class DebounceEmitter<T> extends AtomicReference<Disposable> implements Disposable, Runnable {
        final T f31722a;
        final long f31723b;
        final DebounceTimedObserver<T> f31724c;
        final AtomicBoolean f31725d = new AtomicBoolean();

        DebounceEmitter(T t, long j, DebounceTimedObserver<T> debounceTimedObserver) {
            this.f31722a = t;
            this.f31723b = j;
            this.f31724c = debounceTimedObserver;
        }

        public final void run() {
            if (this.f31725d.compareAndSet(false, true)) {
                DebounceTimedObserver debounceTimedObserver = this.f31724c;
                long j = this.f31723b;
                Object obj = this.f31722a;
                if (j == debounceTimedObserver.f31732g) {
                    debounceTimedObserver.f31726a.onNext(obj);
                    DisposableHelper.m32090a((AtomicReference) this);
                }
            }
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
        }

        public final boolean mo5627b() {
            return get() == DisposableHelper.f31095a;
        }
    }

    static final class DebounceTimedObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> f31726a;
        final long f31727b;
        final TimeUnit f31728c;
        final Worker f31729d;
        Disposable f31730e;
        final AtomicReference<Disposable> f31731f = new AtomicReference();
        volatile long f31732g;
        boolean f31733h;

        DebounceTimedObserver(Observer<? super T> observer, long j, TimeUnit timeUnit, Worker worker) {
            this.f31726a = observer;
            this.f31727b = j;
            this.f31728c = timeUnit;
            this.f31729d = worker;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31730e, disposable)) {
                this.f31730e = disposable;
                this.f31726a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f31733h) {
                long j = this.f31732g + 1;
                this.f31732g = j;
                Disposable disposable = (Disposable) this.f31731f.get();
                if (disposable != null) {
                    disposable.mo5626a();
                }
                Object debounceEmitter = new DebounceEmitter(t, j, this);
                if (this.f31731f.compareAndSet(disposable, debounceEmitter) != null) {
                    DisposableHelper.m32094c(debounceEmitter, this.f31729d.mo6607a(debounceEmitter, this.f31727b, this.f31728c));
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f31733h) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f31733h = true;
            this.f31726a.onError(th);
            this.f31729d.mo5626a();
        }

        public final void onComplete() {
            if (!this.f31733h) {
                this.f31733h = true;
                Disposable disposable = (Disposable) this.f31731f.get();
                if (disposable != DisposableHelper.f31095a) {
                    DebounceEmitter debounceEmitter = (DebounceEmitter) disposable;
                    if (debounceEmitter != null) {
                        debounceEmitter.run();
                    }
                    this.f31726a.onComplete();
                    this.f31729d.mo5626a();
                }
            }
        }

        public final void mo5626a() {
            this.f31730e.mo5626a();
            this.f31729d.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31729d.mo5627b();
        }
    }

    public ObservableDebounceTimed(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        super(observableSource);
        this.f37977a = j;
        this.f37978b = timeUnit;
        this.f37979c = scheduler;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DebounceTimedObserver(new SerializedObserver(observer), this.f37977a, this.f37978b, this.f37979c.mo5629a()));
    }
}
