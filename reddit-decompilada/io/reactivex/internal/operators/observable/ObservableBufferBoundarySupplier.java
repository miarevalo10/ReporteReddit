package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.observers.SerializedObserver;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferBoundarySupplier<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    final Callable<? extends ObservableSource<B>> f37953a;
    final Callable<U> f37954b;

    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        final BufferBoundarySupplierObserver<T, U, B> f35637a;
        boolean f35638b;

        BufferBoundaryObserver(BufferBoundarySupplierObserver<T, U, B> bufferBoundarySupplierObserver) {
            this.f35637a = bufferBoundarySupplierObserver;
        }

        public final void onNext(B b) {
            if (this.f35638b == null) {
                this.f35638b = true;
                mo5626a();
                this.f35637a.m39707h();
            }
        }

        public final void onError(Throwable th) {
            if (this.f35638b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f35638b = true;
            this.f35637a.onError(th);
        }

        public final void onComplete() {
            if (!this.f35638b) {
                this.f35638b = true;
                this.f35637a.m39707h();
            }
        }
    }

    static final class BufferBoundarySupplierObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        final Callable<U> f39536g;
        final Callable<? extends ObservableSource<B>> f39537h;
        Disposable f39538i;
        final AtomicReference<Disposable> f39539j = new AtomicReference();
        U f39540k;

        public final /* synthetic */ void mo7035a(Observer observer, Object obj) {
            this.a.onNext((Collection) obj);
        }

        BufferBoundarySupplierObserver(Observer<? super U> observer, Callable<U> callable, Callable<? extends ObservableSource<B>> callable2) {
            super(observer, new MpscLinkedQueue());
            this.f39536g = callable;
            this.f39537h = callable2;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39538i, disposable)) {
                this.f39538i = disposable;
                Observer observer = this.a;
                try {
                    this.f39540k = (Collection) ObjectHelper.m26573a(this.f39536g.call(), "The buffer supplied is null");
                    try {
                        ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f39537h.call(), "The boundary ObservableSource supplied is null");
                        disposable = new BufferBoundaryObserver(this);
                        this.f39539j.set(disposable);
                        observer.onSubscribe(this);
                        if (!this.c) {
                            observableSource.subscribe(disposable);
                        }
                    } catch (Throwable th) {
                        Exceptions.m26521b(th);
                        this.c = true;
                        disposable.mo5626a();
                        EmptyDisposable.m38051a(th, observer);
                    }
                } catch (Throwable th2) {
                    Exceptions.m26521b(th2);
                    this.c = true;
                    disposable.mo5626a();
                    EmptyDisposable.m38051a(th2, observer);
                }
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                Collection collection = this.f39540k;
                if (collection == null) {
                    return;
                }
                collection.add(t);
            }
        }

        public final void onError(Throwable th) {
            mo5626a();
            this.a.onError(th);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onComplete() {
            /*
            r2 = this;
            monitor-enter(r2);
            r0 = r2.f39540k;	 Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r2);	 Catch:{ all -> 0x0021 }
            return;
        L_0x0007:
            r1 = 0;
            r2.f39540k = r1;	 Catch:{ all -> 0x0021 }
            monitor-exit(r2);	 Catch:{ all -> 0x0021 }
            r1 = r2.b;
            r1.offer(r0);
            r0 = 1;
            r2.d = r0;
            r0 = r2.m38074e();
            if (r0 == 0) goto L_0x0020;
        L_0x0019:
            r0 = r2.b;
            r1 = r2.a;
            io.reactivex.internal.util.QueueDrainHelper.m26726a(r0, r1, r2, r2);
        L_0x0020:
            return;
        L_0x0021:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x0021 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier.BufferBoundarySupplierObserver.onComplete():void");
        }

        public final void mo5626a() {
            if (!this.c) {
                this.c = true;
                this.f39538i.mo5626a();
                DisposableHelper.m32090a(this.f39539j);
                if (m38074e()) {
                    this.b.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return this.c;
        }

        final void m39707h() {
            try {
                Collection collection = (Collection) ObjectHelper.m26573a(this.f39536g.call(), "The buffer supplied is null");
                try {
                    ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f39537h.call(), "The boundary ObservableSource supplied is null");
                    Observer bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    if (this.f39539j.compareAndSet((Disposable) this.f39539j.get(), bufferBoundaryObserver)) {
                        synchronized (this) {
                            Collection collection2 = this.f39540k;
                            if (collection2 == null) {
                                return;
                            }
                            this.f39540k = collection;
                            observableSource.subscribe(bufferBoundaryObserver);
                            m38070a((Object) collection2, (Disposable) this);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    this.c = true;
                    this.f39538i.mo5626a();
                    this.a.onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.m26521b(th2);
                mo5626a();
                this.a.onError(th2);
            }
        }
    }

    public ObservableBufferBoundarySupplier(ObservableSource<T> observableSource, Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        super(observableSource);
        this.f37953a = callable;
        this.f37954b = callable2;
    }

    protected final void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new BufferBoundarySupplierObserver(new SerializedObserver(observer), this.f37954b, this.f37953a));
    }
}
