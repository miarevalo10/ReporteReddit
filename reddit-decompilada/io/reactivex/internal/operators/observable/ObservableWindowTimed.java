package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.subjects.UnicastSubject;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowTimed<T> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final long f38121a;
    final long f38122b;
    final TimeUnit f38123c;
    final Scheduler f38124d;
    final long f38125e;
    final int f38126f;
    final boolean f38127g;

    static final class WindowExactBoundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable {
        final long f39644g;
        final TimeUnit f39645h;
        final Scheduler f39646i;
        final int f39647j;
        final boolean f39648k;
        final long f39649l;
        final Worker f39650m;
        long f39651n;
        long f39652o;
        Disposable f39653p;
        UnicastSubject<T> f39654q;
        volatile boolean f39655r;
        final AtomicReference<Disposable> f39656s = new AtomicReference();

        static final class ConsumerIndexHolder implements Runnable {
            final long f25141a;
            final WindowExactBoundedObserver<?> f25142b;

            ConsumerIndexHolder(long j, WindowExactBoundedObserver<?> windowExactBoundedObserver) {
                this.f25141a = j;
                this.f25142b = windowExactBoundedObserver;
            }

            public final void run() {
                WindowExactBoundedObserver windowExactBoundedObserver = this.f25142b;
                if (windowExactBoundedObserver.c) {
                    windowExactBoundedObserver.f39655r = true;
                    windowExactBoundedObserver.m39773h();
                } else {
                    windowExactBoundedObserver.b.offer(this);
                }
                if (windowExactBoundedObserver.m38074e()) {
                    windowExactBoundedObserver.m39774i();
                }
            }
        }

        WindowExactBoundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i, long j2, boolean z) {
            super(observer, new MpscLinkedQueue());
            this.f39644g = j;
            this.f39645h = timeUnit;
            this.f39646i = scheduler;
            this.f39647j = i;
            this.f39649l = j2;
            this.f39648k = z;
            if (z) {
                this.f39650m = scheduler.mo5629a();
            } else {
                this.f39650m = null;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39653p, disposable)) {
                this.f39653p = disposable;
                disposable = this.a;
                disposable.onSubscribe(this);
                if (!this.c) {
                    UnicastSubject a = UnicastSubject.m38182a(this.f39647j);
                    this.f39654q = a;
                    disposable.onNext(a);
                    Runnable consumerIndexHolder = new ConsumerIndexHolder(this.f39652o, this);
                    if (this.f39648k != null) {
                        disposable = this.f39650m.mo6652a(consumerIndexHolder, this.f39644g, this.f39644g, this.f39645h);
                    } else {
                        disposable = this.f39646i.mo5675a(consumerIndexHolder, this.f39644g, this.f39644g, this.f39645h);
                    }
                    DisposableHelper.m32094c(this.f39656s, disposable);
                }
            }
        }

        public final void onNext(T t) {
            if (!this.f39655r) {
                if (m38075f()) {
                    UnicastSubject unicastSubject = this.f39654q;
                    unicastSubject.onNext(t);
                    long j = this.f39651n + 1;
                    if (j >= this.f39649l) {
                        this.f39652o++;
                        this.f39651n = 0;
                        unicastSubject.onComplete();
                        t = UnicastSubject.m38182a(this.f39647j);
                        this.f39654q = t;
                        this.a.onNext(t);
                        if (this.f39648k != null) {
                            ((Disposable) this.f39656s.get()).mo5626a();
                            DisposableHelper.m32094c(this.f39656s, this.f39650m.mo6652a(new ConsumerIndexHolder(this.f39652o, this), this.f39644g, this.f39644g, this.f39645h));
                        }
                    } else {
                        this.f39651n = j;
                    }
                    if (mo7034a(-1) == null) {
                        return;
                    }
                }
                this.b.offer(NotificationLite.m26696a((Object) t));
                if (m38074e() == null) {
                    return;
                }
                m39774i();
            }
        }

        public final void onError(Throwable th) {
            this.e = th;
            this.d = true;
            if (m38074e()) {
                m39774i();
            }
            this.a.onError(th);
            m39773h();
        }

        public final void onComplete() {
            this.d = true;
            if (m38074e()) {
                m39774i();
            }
            this.a.onComplete();
            m39773h();
        }

        public final void mo5626a() {
            this.c = true;
        }

        public final boolean mo5627b() {
            return this.c;
        }

        final void m39773h() {
            DisposableHelper.m32090a(this.f39656s);
            Worker worker = this.f39650m;
            if (worker != null) {
                worker.mo5626a();
            }
        }

        final void m39774i() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.b;
            Observer observer = this.a;
            UnicastSubject unicastSubject = this.f39654q;
            int i = 1;
            while (!this.f39655r) {
                boolean z = this.d;
                Object poll = mpscLinkedQueue.poll();
                Object obj = poll == null ? 1 : null;
                boolean z2 = poll instanceof ConsumerIndexHolder;
                if (z && (obj != null || z2)) {
                    this.f39654q = null;
                    mpscLinkedQueue.clear();
                    m39773h();
                    Throwable th = this.e;
                    if (th != null) {
                        unicastSubject.onError(th);
                        return;
                    } else {
                        unicastSubject.onComplete();
                        return;
                    }
                } else if (obj != null) {
                    i = mo7034a(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z2) {
                    ConsumerIndexHolder consumerIndexHolder = (ConsumerIndexHolder) poll;
                    if (this.f39648k || this.f39652o == consumerIndexHolder.f25141a) {
                        unicastSubject.onComplete();
                        this.f39651n = 0;
                        unicastSubject = UnicastSubject.m38182a(this.f39647j);
                        this.f39654q = unicastSubject;
                        observer.onNext(unicastSubject);
                    }
                } else {
                    unicastSubject.onNext(NotificationLite.m26706e(poll));
                    long j = this.f39651n + 1;
                    if (j >= this.f39649l) {
                        this.f39652o++;
                        this.f39651n = 0;
                        unicastSubject.onComplete();
                        unicastSubject = UnicastSubject.m38182a(this.f39647j);
                        this.f39654q = unicastSubject;
                        this.a.onNext(unicastSubject);
                        if (this.f39648k) {
                            Disposable disposable = (Disposable) this.f39656s.get();
                            disposable.mo5626a();
                            Disposable a = this.f39650m.mo6652a(new ConsumerIndexHolder(this.f39652o, this), this.f39644g, this.f39644g, this.f39645h);
                            if (!this.f39656s.compareAndSet(disposable, a)) {
                                a.mo5626a();
                            }
                        }
                    } else {
                        this.f39651n = j;
                    }
                }
            }
            this.f39653p.mo5626a();
            mpscLinkedQueue.clear();
            m39773h();
        }
    }

    static final class WindowExactUnboundedObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Observer<T>, Disposable, Runnable {
        static final Object f39657n = new Object();
        final long f39658g;
        final TimeUnit f39659h;
        final Scheduler f39660i;
        final int f39661j;
        Disposable f39662k;
        UnicastSubject<T> f39663l;
        final AtomicReference<Disposable> f39664m = new AtomicReference();
        volatile boolean f39665o;

        WindowExactUnboundedObserver(Observer<? super Observable<T>> observer, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
            super(observer, new MpscLinkedQueue());
            this.f39658g = j;
            this.f39659h = timeUnit;
            this.f39660i = scheduler;
            this.f39661j = i;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39662k, disposable)) {
                this.f39662k = disposable;
                this.f39663l = UnicastSubject.m38182a(this.f39661j);
                disposable = this.a;
                disposable.onSubscribe(this);
                disposable.onNext(this.f39663l);
                if (this.c == null) {
                    DisposableHelper.m32094c(this.f39664m, this.f39660i.mo5675a(this, this.f39658g, this.f39658g, this.f39659h));
                }
            }
        }

        public final void onNext(T t) {
            if (!this.f39665o) {
                if (m38075f()) {
                    this.f39663l.onNext(t);
                    if (mo7034a(-1) == null) {
                        return;
                    }
                }
                this.b.offer(NotificationLite.m26696a((Object) t));
                if (m38074e() == null) {
                    return;
                }
                m39776i();
            }
        }

        public final void onError(Throwable th) {
            this.e = th;
            this.d = true;
            if (m38074e()) {
                m39776i();
            }
            m39775h();
            this.a.onError(th);
        }

        public final void onComplete() {
            this.d = true;
            if (m38074e()) {
                m39776i();
            }
            m39775h();
            this.a.onComplete();
        }

        public final void mo5626a() {
            this.c = true;
        }

        public final boolean mo5627b() {
            return this.c;
        }

        private void m39775h() {
            DisposableHelper.m32090a(this.f39664m);
        }

        public final void run() {
            if (this.c) {
                this.f39665o = true;
                m39775h();
            }
            this.b.offer(f39657n);
            if (m38074e()) {
                m39776i();
            }
        }

        private void m39776i() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.b;
            Observer observer = this.a;
            UnicastSubject unicastSubject = this.f39663l;
            int i = 1;
            while (true) {
                boolean z = this.f39665o;
                boolean z2 = this.d;
                Object poll = mpscLinkedQueue.poll();
                if (!(z2 && (poll == null || poll == f39657n))) {
                    if (poll == null) {
                        i = mo7034a(-i);
                        if (i == 0) {
                            return;
                        }
                    } else if (poll == f39657n) {
                        unicastSubject.onComplete();
                        if (z) {
                            this.f39662k.mo5626a();
                        } else {
                            unicastSubject = UnicastSubject.m38182a(this.f39661j);
                            this.f39663l = unicastSubject;
                            observer.onNext(unicastSubject);
                        }
                    } else {
                        unicastSubject.onNext(NotificationLite.m26706e(poll));
                    }
                }
            }
            this.f39663l = null;
            mpscLinkedQueue.clear();
            m39775h();
            Throwable th = this.e;
            if (th != null) {
                unicastSubject.onError(th);
            } else {
                unicastSubject.onComplete();
            }
        }
    }

    static final class WindowSkipObserver<T> extends QueueDrainObserver<T, Object, Observable<T>> implements Disposable, Runnable {
        final long f39666g;
        final long f39667h;
        final TimeUnit f39668i;
        final Worker f39669j;
        final int f39670k;
        final List<UnicastSubject<T>> f39671l = new LinkedList();
        Disposable f39672m;
        volatile boolean f39673n;

        final class CompletionTask implements Runnable {
            final /* synthetic */ WindowSkipObserver f25143a;
            private final UnicastSubject<T> f25144b;

            CompletionTask(WindowSkipObserver windowSkipObserver, UnicastSubject<T> unicastSubject) {
                this.f25143a = windowSkipObserver;
                this.f25144b = unicastSubject;
            }

            public final void run() {
                this.f25143a.m39781a(this.f25144b);
            }
        }

        static final class SubjectWork<T> {
            final UnicastSubject<T> f25145a;
            final boolean f25146b;

            SubjectWork(UnicastSubject<T> unicastSubject, boolean z) {
                this.f25145a = unicastSubject;
                this.f25146b = z;
            }
        }

        WindowSkipObserver(Observer<? super Observable<T>> observer, long j, long j2, TimeUnit timeUnit, Worker worker, int i) {
            super(observer, new MpscLinkedQueue());
            this.f39666g = j;
            this.f39667h = j2;
            this.f39668i = timeUnit;
            this.f39669j = worker;
            this.f39670k = i;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39672m, disposable)) {
                this.f39672m = disposable;
                this.a.onSubscribe(this);
                if (this.c == null) {
                    disposable = UnicastSubject.m38182a(this.f39670k);
                    this.f39671l.add(disposable);
                    this.a.onNext(disposable);
                    this.f39669j.mo6607a(new CompletionTask(this, disposable), this.f39666g, this.f39668i);
                    this.f39669j.mo6652a(this, this.f39667h, this.f39667h, this.f39668i);
                }
            }
        }

        public final void onNext(T t) {
            if (m38075f()) {
                for (UnicastSubject onNext : this.f39671l) {
                    onNext.onNext(t);
                }
                if (mo7034a(-1) == null) {
                    return;
                }
            }
            this.b.offer(t);
            if (m38074e() == null) {
                return;
            }
            m39779h();
        }

        public final void onError(Throwable th) {
            this.e = th;
            this.d = true;
            if (m38074e()) {
                m39779h();
            }
            this.a.onError(th);
            this.f39669j.mo5626a();
        }

        public final void onComplete() {
            this.d = true;
            if (m38074e()) {
                m39779h();
            }
            this.a.onComplete();
            this.f39669j.mo5626a();
        }

        public final void mo5626a() {
            this.c = true;
        }

        public final boolean mo5627b() {
            return this.c;
        }

        final void m39781a(UnicastSubject<T> unicastSubject) {
            this.b.offer(new SubjectWork(unicastSubject, false));
            if (m38074e() != null) {
                m39779h();
            }
        }

        private void m39779h() {
            MpscLinkedQueue mpscLinkedQueue = (MpscLinkedQueue) this.b;
            Observer observer = this.a;
            List<UnicastSubject> list = this.f39671l;
            int i = 1;
            while (!this.f39673n) {
                boolean z = this.d;
                Object poll = mpscLinkedQueue.poll();
                boolean z2 = poll == null;
                boolean z3 = poll instanceof SubjectWork;
                if (z && (z2 || z3)) {
                    mpscLinkedQueue.clear();
                    Throwable th = this.e;
                    if (th != null) {
                        for (UnicastSubject onError : list) {
                            onError.onError(th);
                        }
                    } else {
                        for (UnicastSubject onComplete : list) {
                            onComplete.onComplete();
                        }
                    }
                    this.f39669j.mo5626a();
                    list.clear();
                    return;
                } else if (z2) {
                    i = mo7034a(-i);
                    if (i == 0) {
                        return;
                    }
                } else if (z3) {
                    SubjectWork subjectWork = (SubjectWork) poll;
                    if (!subjectWork.f25146b) {
                        list.remove(subjectWork.f25145a);
                        subjectWork.f25145a.onComplete();
                        if (list.isEmpty() && this.c) {
                            this.f39673n = true;
                        }
                    } else if (!this.c) {
                        UnicastSubject a = UnicastSubject.m38182a(this.f39670k);
                        list.add(a);
                        observer.onNext(a);
                        this.f39669j.mo6607a(new CompletionTask(this, a), this.f39666g, this.f39668i);
                    }
                } else {
                    for (UnicastSubject onNext : list) {
                        onNext.onNext(poll);
                    }
                }
            }
            this.f39672m.mo5626a();
            this.f39669j.mo5626a();
            mpscLinkedQueue.clear();
            list.clear();
        }

        public final void run() {
            SubjectWork subjectWork = new SubjectWork(UnicastSubject.m38182a(this.f39670k), true);
            if (!this.c) {
                this.b.offer(subjectWork);
            }
            if (m38074e()) {
                m39779h();
            }
        }
    }

    public ObservableWindowTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, long j3, int i, boolean z) {
        super(observableSource);
        this.f38121a = j;
        this.f38122b = j2;
        this.f38123c = timeUnit;
        this.f38124d = scheduler;
        this.f38125e = j3;
        this.f38126f = i;
        this.f38127g = z;
    }

    public final void subscribeActual(Observer<? super Observable<T>> observer) {
        Observer serializedObserver = new SerializedObserver(observer);
        if (this.f38121a != this.f38122b) {
            this.source.subscribe(new WindowSkipObserver(serializedObserver, this.f38121a, this.f38122b, this.f38123c, this.f38124d.mo5629a(), this.f38126f));
        } else if (this.f38125e == Long.MAX_VALUE) {
            this.source.subscribe(new WindowExactUnboundedObserver(serializedObserver, this.f38121a, this.f38123c, this.f38124d, this.f38126f));
        } else {
            this.source.subscribe(new WindowExactBoundedObserver(serializedObserver, this.f38121a, this.f38123c, this.f38124d, this.f38126f, this.f38125e, this.f38127g));
        }
    }
}
