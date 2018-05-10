package io.reactivex.internal.operators.observable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Scheduler.Worker;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.util.ObservableQueueDrain;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final long f37957a;
    final long f37958b;
    final TimeUnit f37959c;
    final Scheduler f37960d;
    final Callable<U> f37961e;
    final int f37962f;
    final boolean f37963g;

    static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Disposable, Runnable {
        final Callable<U> f39546g;
        final long f39547h;
        final TimeUnit f39548i;
        final int f39549j;
        final boolean f39550k;
        final Worker f39551l;
        U f39552m;
        Disposable f39553n;
        Disposable f39554o;
        long f39555p;
        long f39556q;

        public final /* synthetic */ void mo7035a(Observer observer, Object obj) {
            observer.onNext((Collection) obj);
        }

        BufferExactBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, int i, boolean z, Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f39546g = callable;
            this.f39547h = j;
            this.f39548i = timeUnit;
            this.f39549j = i;
            this.f39550k = z;
            this.f39551l = worker;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39554o, disposable)) {
                this.f39554o = disposable;
                try {
                    this.f39552m = (Collection) ObjectHelper.m26573a(this.f39546g.call(), "The buffer supplied is null");
                    this.a.onSubscribe(this);
                    this.f39553n = this.f39551l.mo6652a(this, this.f39547h, this.f39547h, this.f39548i);
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    disposable.mo5626a();
                    EmptyDisposable.m38051a(th, this.a);
                    this.f39551l.mo5626a();
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(T r8) {
            /*
            r7 = this;
            monitor-enter(r7);
            r0 = r7.f39552m;	 Catch:{ all -> 0x0066 }
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r7);	 Catch:{ all -> 0x0066 }
            return;
        L_0x0007:
            r0.add(r8);	 Catch:{ all -> 0x0066 }
            r8 = r0.size();	 Catch:{ all -> 0x0066 }
            r1 = r7.f39549j;	 Catch:{ all -> 0x0066 }
            if (r8 >= r1) goto L_0x0014;
        L_0x0012:
            monitor-exit(r7);	 Catch:{ all -> 0x0066 }
            return;
        L_0x0014:
            r8 = 0;
            r7.f39552m = r8;	 Catch:{ all -> 0x0066 }
            r1 = r7.f39555p;	 Catch:{ all -> 0x0066 }
            r3 = 1;
            r1 = r1 + r3;
            r7.f39555p = r1;	 Catch:{ all -> 0x0066 }
            monitor-exit(r7);	 Catch:{ all -> 0x0066 }
            r8 = r7.f39550k;
            if (r8 == 0) goto L_0x0028;
        L_0x0023:
            r8 = r7.f39553n;
            r8.mo5626a();
        L_0x0028:
            r7.m38071b(r0, r7);
            r8 = r7.f39546g;	 Catch:{ Throwable -> 0x0059 }
            r8 = r8.call();	 Catch:{ Throwable -> 0x0059 }
            r0 = "The buffer supplied is null";
            r8 = io.reactivex.internal.functions.ObjectHelper.m26573a(r8, r0);	 Catch:{ Throwable -> 0x0059 }
            r8 = (java.util.Collection) r8;	 Catch:{ Throwable -> 0x0059 }
            monitor-enter(r7);
            r7.f39552m = r8;	 Catch:{ all -> 0x0056 }
            r0 = r7.f39556q;	 Catch:{ all -> 0x0056 }
            r0 = r0 + r3;
            r7.f39556q = r0;	 Catch:{ all -> 0x0056 }
            monitor-exit(r7);	 Catch:{ all -> 0x0056 }
            r8 = r7.f39550k;
            if (r8 == 0) goto L_0x0055;
        L_0x0046:
            r0 = r7.f39551l;
            r2 = r7.f39547h;
            r4 = r7.f39547h;
            r6 = r7.f39548i;
            r1 = r7;
            r8 = r0.mo6652a(r1, r2, r4, r6);
            r7.f39553n = r8;
        L_0x0055:
            return;
        L_0x0056:
            r8 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x0056 }
            throw r8;
        L_0x0059:
            r8 = move-exception;
            io.reactivex.exceptions.Exceptions.m26521b(r8);
            r0 = r7.a;
            r0.onError(r8);
            r7.mo5626a();
            return;
        L_0x0066:
            r8 = move-exception;
            monitor-exit(r7);	 Catch:{ all -> 0x0066 }
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferTimed.BufferExactBoundedObserver.onNext(java.lang.Object):void");
        }

        public final void onError(Throwable th) {
            synchronized (this) {
                this.f39552m = null;
            }
            this.a.onError(th);
            this.f39551l.mo5626a();
        }

        public final void onComplete() {
            Collection collection;
            this.f39551l.mo5626a();
            synchronized (this) {
                collection = this.f39552m;
                this.f39552m = null;
            }
            this.b.offer(collection);
            this.d = true;
            if (m38074e()) {
                QueueDrainHelper.m26726a(this.b, this.a, (Disposable) this, (ObservableQueueDrain) this);
            }
        }

        public final void mo5626a() {
            if (!this.c) {
                this.c = true;
                this.f39554o.mo5626a();
                this.f39551l.mo5626a();
                synchronized (this) {
                    this.f39552m = null;
                }
            }
        }

        public final boolean mo5627b() {
            return this.c;
        }

        public final void run() {
            try {
                Collection collection = (Collection) ObjectHelper.m26573a(this.f39546g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    Collection collection2 = this.f39552m;
                    if (collection2 != null) {
                        if (this.f39555p == this.f39556q) {
                            this.f39552m = collection;
                            m38071b(collection2, this);
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                mo5626a();
                this.a.onError(th);
            }
        }
    }

    static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Disposable, Runnable {
        final Callable<U> f39557g;
        final long f39558h;
        final TimeUnit f39559i;
        final Scheduler f39560j;
        Disposable f39561k;
        U f39562l;
        final AtomicReference<Disposable> f39563m = new AtomicReference();

        public final /* synthetic */ void mo7035a(Observer observer, Object obj) {
            this.a.onNext((Collection) obj);
        }

        BufferExactUnboundedObserver(Observer<? super U> observer, Callable<U> callable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.f39557g = callable;
            this.f39558h = j;
            this.f39559i = timeUnit;
            this.f39560j = scheduler;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39561k, disposable)) {
                this.f39561k = disposable;
                try {
                    this.f39562l = (Collection) ObjectHelper.m26573a(this.f39557g.call(), "The buffer supplied is null");
                    this.a.onSubscribe(this);
                    if (this.c == null) {
                        disposable = this.f39560j.mo5675a(this, this.f39558h, this.f39558h, this.f39559i);
                        if (!this.f39563m.compareAndSet(null, disposable)) {
                            disposable.mo5626a();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    mo5626a();
                    EmptyDisposable.m38051a(th, this.a);
                }
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                Collection collection = this.f39562l;
                if (collection == null) {
                    return;
                }
                collection.add(t);
            }
        }

        public final void onError(Throwable th) {
            synchronized (this) {
                this.f39562l = null;
            }
            this.a.onError(th);
            DisposableHelper.m32090a(this.f39563m);
        }

        public final void onComplete() {
            synchronized (this) {
                Collection collection = this.f39562l;
                this.f39562l = null;
            }
            if (collection != null) {
                this.b.offer(collection);
                this.d = true;
                if (m38074e()) {
                    QueueDrainHelper.m26726a(this.b, this.a, null, (ObservableQueueDrain) this);
                }
            }
            DisposableHelper.m32090a(this.f39563m);
        }

        public final void mo5626a() {
            DisposableHelper.m32090a(this.f39563m);
            this.f39561k.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f39563m.get() == DisposableHelper.f31095a;
        }

        public final void run() {
            try {
                Collection collection;
                Collection collection2 = (Collection) ObjectHelper.m26573a(this.f39557g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    collection = this.f39562l;
                    if (collection != null) {
                        this.f39562l = collection2;
                    }
                }
                if (collection == null) {
                    DisposableHelper.m32090a(this.f39563m);
                } else {
                    m38070a((Object) collection, (Disposable) this);
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                this.a.onError(th);
                mo5626a();
            }
        }
    }

    static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Disposable, Runnable {
        final Callable<U> f39564g;
        final long f39565h;
        final long f39566i;
        final TimeUnit f39567j;
        final Worker f39568k;
        final List<U> f39569l = new LinkedList();
        Disposable f39570m;

        final class RemoveFromBuffer implements Runnable {
            final /* synthetic */ BufferSkipBoundedObserver f25108a;
            private final U f25109b;

            RemoveFromBuffer(BufferSkipBoundedObserver bufferSkipBoundedObserver, U u) {
                this.f25108a = bufferSkipBoundedObserver;
                this.f25109b = u;
            }

            public final void run() {
                synchronized (this.f25108a) {
                    this.f25108a.f39569l.remove(this.f25109b);
                }
                this.f25108a.m38071b(this.f25109b, this.f25108a.f39568k);
            }
        }

        final class RemoveFromBufferEmit implements Runnable {
            final /* synthetic */ BufferSkipBoundedObserver f25110a;
            private final U f25111b;

            RemoveFromBufferEmit(BufferSkipBoundedObserver bufferSkipBoundedObserver, U u) {
                this.f25110a = bufferSkipBoundedObserver;
                this.f25111b = u;
            }

            public final void run() {
                synchronized (this.f25110a) {
                    this.f25110a.f39569l.remove(this.f25111b);
                }
                this.f25110a.m38071b(this.f25111b, this.f25110a.f39568k);
            }
        }

        public final /* synthetic */ void mo7035a(Observer observer, Object obj) {
            observer.onNext((Collection) obj);
        }

        BufferSkipBoundedObserver(Observer<? super U> observer, Callable<U> callable, long j, long j2, TimeUnit timeUnit, Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.f39564g = callable;
            this.f39565h = j;
            this.f39566i = j2;
            this.f39567j = timeUnit;
            this.f39568k = worker;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39570m, disposable)) {
                this.f39570m = disposable;
                try {
                    Collection collection = (Collection) ObjectHelper.m26573a(this.f39564g.call(), "The buffer supplied is null");
                    this.f39569l.add(collection);
                    this.a.onSubscribe(this);
                    this.f39568k.mo6652a(this, this.f39566i, this.f39566i, this.f39567j);
                    this.f39568k.mo6607a(new RemoveFromBufferEmit(this, collection), this.f39565h, this.f39567j);
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    disposable.mo5626a();
                    EmptyDisposable.m38051a(th, this.a);
                    this.f39568k.mo5626a();
                }
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                for (Collection add : this.f39569l) {
                    add.add(t);
                }
            }
        }

        public final void onError(Throwable th) {
            this.d = true;
            m39720h();
            this.a.onError(th);
            this.f39568k.mo5626a();
        }

        public final void onComplete() {
            synchronized (this) {
                List<Collection> arrayList = new ArrayList(this.f39569l);
                this.f39569l.clear();
            }
            for (Collection offer : arrayList) {
                this.b.offer(offer);
            }
            this.d = true;
            if (m38074e()) {
                QueueDrainHelper.m26726a(this.b, this.a, this.f39568k, (ObservableQueueDrain) this);
            }
        }

        public final void mo5626a() {
            if (!this.c) {
                this.c = true;
                m39720h();
                this.f39570m.mo5626a();
                this.f39568k.mo5626a();
            }
        }

        public final boolean mo5627b() {
            return this.c;
        }

        private void m39720h() {
            synchronized (this) {
                this.f39569l.clear();
            }
        }

        public final void run() {
            if (!this.c) {
                try {
                    Collection collection = (Collection) ObjectHelper.m26573a(this.f39564g.call(), "The bufferSupplier returned a null buffer");
                    synchronized (this) {
                        if (this.c) {
                            return;
                        }
                        this.f39569l.add(collection);
                        this.f39568k.mo6607a(new RemoveFromBuffer(this, collection), this.f39565h, this.f39567j);
                    }
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    this.a.onError(th);
                    mo5626a();
                }
            }
        }
    }

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable, int i, boolean z) {
        super(observableSource);
        this.f37957a = j;
        this.f37958b = j2;
        this.f37959c = timeUnit;
        this.f37960d = scheduler;
        this.f37961e = callable;
        this.f37962f = i;
        this.f37963g = z;
    }

    protected final void subscribeActual(Observer<? super U> observer) {
        if (this.f37957a == this.f37958b && this.f37962f == RedditJobManager.f10810d) {
            this.source.subscribe(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.f37961e, this.f37957a, this.f37959c, this.f37960d));
            return;
        }
        Worker a = this.f37960d.mo5629a();
        if (this.f37957a == this.f37958b) {
            this.source.subscribe(new BufferExactBoundedObserver(new SerializedObserver(observer), this.f37961e, this.f37957a, this.f37959c, this.f37962f, this.f37963g, a));
        } else {
            this.source.subscribe(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.f37961e, this.f37957a, this.f37958b, this.f37959c, a));
        }
    }
}
