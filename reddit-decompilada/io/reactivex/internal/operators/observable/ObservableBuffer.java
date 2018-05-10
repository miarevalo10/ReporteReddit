package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final int f37947a;
    final int f37948b;
    final Callable<U> f37949c;

    static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        final Observer<? super U> f31585a;
        final int f31586b;
        final Callable<U> f31587c;
        U f31588d;
        int f31589e;
        Disposable f31590f;

        BufferExactObserver(Observer<? super U> observer, int i, Callable<U> callable) {
            this.f31585a = observer;
            this.f31586b = i;
            this.f31587c = callable;
        }

        final boolean m32364c() {
            try {
                this.f31588d = (Collection) ObjectHelper.m26573a(this.f31587c.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                this.f31588d = null;
                if (this.f31590f == null) {
                    EmptyDisposable.m38051a(th, this.f31585a);
                } else {
                    this.f31590f.mo5626a();
                    this.f31585a.onError(th);
                }
                return false;
            }
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31590f, disposable)) {
                this.f31590f = disposable;
                this.f31585a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31590f.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31590f.mo5627b();
        }

        public final void onNext(T t) {
            Collection collection = this.f31588d;
            if (collection != null) {
                collection.add(t);
                t = this.f31589e + 1;
                this.f31589e = t;
                if (t >= this.f31586b) {
                    this.f31585a.onNext(collection);
                    this.f31589e = null;
                    m32364c();
                }
            }
        }

        public final void onError(Throwable th) {
            this.f31588d = null;
            this.f31585a.onError(th);
        }

        public final void onComplete() {
            Collection collection = this.f31588d;
            this.f31588d = null;
            if (!(collection == null || collection.isEmpty())) {
                this.f31585a.onNext(collection);
            }
            this.f31585a.onComplete();
        }
    }

    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        final Observer<? super U> f31591a;
        final int f31592b;
        final int f31593c;
        final Callable<U> f31594d;
        Disposable f31595e;
        final ArrayDeque<U> f31596f = new ArrayDeque();
        long f31597g;

        BufferSkipObserver(Observer<? super U> observer, int i, int i2, Callable<U> callable) {
            this.f31591a = observer;
            this.f31592b = i;
            this.f31593c = i2;
            this.f31594d = callable;
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31595e, disposable)) {
                this.f31595e = disposable;
                this.f31591a.onSubscribe(this);
            }
        }

        public final void mo5626a() {
            this.f31595e.mo5626a();
        }

        public final boolean mo5627b() {
            return this.f31595e.mo5627b();
        }

        public final void onNext(T t) {
            long j = this.f31597g;
            this.f31597g = 1 + j;
            if (j % ((long) this.f31593c) == 0) {
                try {
                    this.f31596f.offer((Collection) ObjectHelper.m26573a(this.f31594d.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (T t2) {
                    this.f31596f.clear();
                    this.f31595e.mo5626a();
                    this.f31591a.onError(t2);
                    return;
                }
            }
            Iterator it = this.f31596f.iterator();
            while (it.hasNext()) {
                Collection collection = (Collection) it.next();
                collection.add(t2);
                if (this.f31592b <= collection.size()) {
                    it.remove();
                    this.f31591a.onNext(collection);
                }
            }
        }

        public final void onError(Throwable th) {
            this.f31596f.clear();
            this.f31591a.onError(th);
        }

        public final void onComplete() {
            while (!this.f31596f.isEmpty()) {
                this.f31591a.onNext(this.f31596f.poll());
            }
            this.f31591a.onComplete();
        }
    }

    public ObservableBuffer(ObservableSource<T> observableSource, int i, int i2, Callable<U> callable) {
        super(observableSource);
        this.f37947a = i;
        this.f37948b = i2;
        this.f37949c = callable;
    }

    protected final void subscribeActual(Observer<? super U> observer) {
        if (this.f37948b == this.f37947a) {
            Observer bufferExactObserver = new BufferExactObserver(observer, this.f37947a, this.f37949c);
            if (bufferExactObserver.m32364c() != null) {
                this.source.subscribe(bufferExactObserver);
            }
            return;
        }
        this.source.subscribe(new BufferSkipObserver(observer, this.f37947a, this.f37948b, this.f37949c));
    }
}
