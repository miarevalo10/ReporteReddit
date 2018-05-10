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
import java.util.Collection;
import java.util.concurrent.Callable;

public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    final ObservableSource<B> f37955a;
    final Callable<U> f37956b;

    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        final BufferExactBoundaryObserver<T, U, B> f35639a;

        BufferBoundaryObserver(BufferExactBoundaryObserver<T, U, B> bufferExactBoundaryObserver) {
            this.f35639a = bufferExactBoundaryObserver;
        }

        public final void onNext(B b) {
            this.f35639a.m39711h();
        }

        public final void onError(Throwable th) {
            this.f35639a.onError(th);
        }

        public final void onComplete() {
            this.f35639a.onComplete();
        }
    }

    static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        final Callable<U> f39541g;
        final ObservableSource<B> f39542h;
        Disposable f39543i;
        Disposable f39544j;
        U f39545k;

        public final /* synthetic */ void mo7035a(Observer observer, Object obj) {
            this.a.onNext((Collection) obj);
        }

        BufferExactBoundaryObserver(Observer<? super U> observer, Callable<U> callable, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.f39541g = callable;
            this.f39542h = observableSource;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f39543i, disposable)) {
                this.f39543i = disposable;
                try {
                    this.f39545k = (Collection) ObjectHelper.m26573a(this.f39541g.call(), "The buffer supplied is null");
                    disposable = new BufferBoundaryObserver(this);
                    this.f39544j = disposable;
                    this.a.onSubscribe(this);
                    if (!this.c) {
                        this.f39542h.subscribe(disposable);
                    }
                } catch (Throwable th) {
                    Exceptions.m26521b(th);
                    this.c = true;
                    disposable.mo5626a();
                    EmptyDisposable.m38051a(th, this.a);
                }
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                Collection collection = this.f39545k;
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
            r0 = r2.f39545k;	 Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x0007;
        L_0x0005:
            monitor-exit(r2);	 Catch:{ all -> 0x0021 }
            return;
        L_0x0007:
            r1 = 0;
            r2.f39545k = r1;	 Catch:{ all -> 0x0021 }
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
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.observable.ObservableBufferExactBoundary.BufferExactBoundaryObserver.onComplete():void");
        }

        public final void mo5626a() {
            if (!this.c) {
                this.c = true;
                this.f39544j.mo5626a();
                this.f39543i.mo5626a();
                if (m38074e()) {
                    this.b.clear();
                }
            }
        }

        public final boolean mo5627b() {
            return this.c;
        }

        final void m39711h() {
            try {
                Collection collection = (Collection) ObjectHelper.m26573a(this.f39541g.call(), "The buffer supplied is null");
                synchronized (this) {
                    Collection collection2 = this.f39545k;
                    if (collection2 == null) {
                        return;
                    }
                    this.f39545k = collection;
                    m38070a((Object) collection2, (Disposable) this);
                }
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                mo5626a();
                this.a.onError(th);
            }
        }
    }

    public ObservableBufferExactBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Callable<U> callable) {
        super(observableSource);
        this.f37955a = observableSource2;
        this.f37956b = callable;
    }

    protected final void subscribeActual(Observer<? super U> observer) {
        this.source.subscribe(new BufferExactBoundaryObserver(new SerializedObserver(observer), this.f37956b, this.f37955a));
    }
}
