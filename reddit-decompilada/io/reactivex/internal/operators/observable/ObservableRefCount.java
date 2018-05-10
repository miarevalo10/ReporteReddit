package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observables.ConnectableObservable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public final class ObservableRefCount<T> extends AbstractObservableWithUpstream<T, T> {
    final ConnectableObservable<? extends T> f38042a;
    volatile CompositeDisposable f38043b = new CompositeDisposable();
    final AtomicInteger f38044c = new AtomicInteger();
    final ReentrantLock f38045d = new ReentrantLock();

    final class DisposeTask implements Runnable {
        final /* synthetic */ ObservableRefCount f25129a;
        private final CompositeDisposable f25130b;

        DisposeTask(ObservableRefCount observableRefCount, CompositeDisposable compositeDisposable) {
            this.f25129a = observableRefCount;
            this.f25130b = compositeDisposable;
        }

        public final void run() {
            this.f25129a.f38045d.lock();
            try {
                if (this.f25129a.f38043b == this.f25130b && this.f25129a.f38044c.decrementAndGet() == 0) {
                    if (this.f25129a.f38042a instanceof Disposable) {
                        ((Disposable) this.f25129a.f38042a).mo5626a();
                    }
                    this.f25129a.f38043b.mo5626a();
                    this.f25129a.f38043b = new CompositeDisposable();
                }
                this.f25129a.f38045d.unlock();
            } catch (Throwable th) {
                this.f25129a.f38045d.unlock();
            }
        }
    }

    final class ConnectionObserver extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        final Observer<? super T> f31991a;
        final CompositeDisposable f31992b;
        final Disposable f31993c;
        final /* synthetic */ ObservableRefCount f31994d;

        ConnectionObserver(ObservableRefCount observableRefCount, Observer<? super T> observer, CompositeDisposable compositeDisposable, Disposable disposable) {
            this.f31994d = observableRefCount;
            this.f31991a = observer;
            this.f31992b = compositeDisposable;
            this.f31993c = disposable;
        }

        public final void onSubscribe(Disposable disposable) {
            DisposableHelper.m32092b(this, disposable);
        }

        public final void onError(Throwable th) {
            m32542c();
            this.f31991a.onError(th);
        }

        public final void onNext(T t) {
            this.f31991a.onNext(t);
        }

        public final void onComplete() {
            m32542c();
            this.f31991a.onComplete();
        }

        public final void mo5626a() {
            DisposableHelper.m32090a((AtomicReference) this);
            this.f31993c.mo5626a();
        }

        public final boolean mo5627b() {
            return DisposableHelper.m32088a((Disposable) get());
        }

        private void m32542c() {
            this.f31994d.f38045d.lock();
            try {
                if (this.f31994d.f38043b == this.f31992b) {
                    if (this.f31994d.f38042a instanceof Disposable) {
                        ((Disposable) this.f31994d.f38042a).mo5626a();
                    }
                    this.f31994d.f38043b.mo5626a();
                    this.f31994d.f38043b = new CompositeDisposable();
                    this.f31994d.f38044c.set(0);
                }
                this.f31994d.f38045d.unlock();
            } catch (Throwable th) {
                this.f31994d.f38045d.unlock();
            }
        }
    }

    final class DisposeConsumer implements Consumer<Disposable> {
        final /* synthetic */ ObservableRefCount f31995a;
        private final Observer<? super T> f31996b;
        private final AtomicBoolean f31997c;

        public final /* synthetic */ void accept(Object obj) throws Exception {
            try {
                this.f31995a.f38043b.mo5631a((Disposable) obj);
                this.f31995a.m38139a(this.f31996b, this.f31995a.f38043b);
            } finally {
                this.f31995a.f38045d.unlock();
                this.f31997c.set(false);
            }
        }

        DisposeConsumer(ObservableRefCount observableRefCount, Observer<? super T> observer, AtomicBoolean atomicBoolean) {
            this.f31995a = observableRefCount;
            this.f31996b = observer;
            this.f31997c = atomicBoolean;
        }
    }

    public final void subscribeActual(io.reactivex.Observer<? super T> r4) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = r3.f38045d;
        r0.lock();
        r0 = r3.f38044c;
        r0 = r0.incrementAndGet();
        r1 = 1;
        if (r0 != r1) goto L_0x0037;
    L_0x000e:
        r0 = new java.util.concurrent.atomic.AtomicBoolean;
        r0.<init>(r1);
        r1 = r3.f38042a;	 Catch:{ all -> 0x002a }
        r2 = new io.reactivex.internal.operators.observable.ObservableRefCount$DisposeConsumer;	 Catch:{ all -> 0x002a }
        r2.<init>(r3, r4, r0);	 Catch:{ all -> 0x002a }
        r1.mo7053a(r2);	 Catch:{ all -> 0x002a }
        r4 = r0.get();
        if (r4 == 0) goto L_0x0029;
    L_0x0023:
        r4 = r3.f38045d;
        r4.unlock();
        return;
    L_0x0029:
        return;
    L_0x002a:
        r4 = move-exception;
        r0 = r0.get();
        if (r0 == 0) goto L_0x0036;
    L_0x0031:
        r0 = r3.f38045d;
        r0.unlock();
    L_0x0036:
        throw r4;
    L_0x0037:
        r0 = r3.f38043b;	 Catch:{ all -> 0x0042 }
        r3.m38139a(r4, r0);	 Catch:{ all -> 0x0042 }
        r4 = r3.f38045d;
        r4.unlock();
        return;
    L_0x0042:
        r4 = move-exception;
        r0 = r3.f38045d;
        r0.unlock();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableRefCount.subscribeActual(io.reactivex.Observer):void");
    }

    public ObservableRefCount(ConnectableObservable<T> connectableObservable) {
        super(connectableObservable);
        this.f38042a = connectableObservable;
    }

    final void m38139a(Observer<? super T> observer, CompositeDisposable compositeDisposable) {
        Object connectionObserver = new ConnectionObserver(this, observer, compositeDisposable, Disposables.m26513a(new DisposeTask(this, compositeDisposable)));
        observer.onSubscribe(connectionObserver);
        this.f38042a.subscribe((Observer) connectionObserver);
    }
}
