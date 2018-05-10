package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;

public final class ObservableFromArray<T> extends Observable<T> {
    final T[] f35672a;

    static final class FromArrayDisposable<T> extends BasicQueueDisposable<T> {
        final Observer<? super T> f39591a;
        final T[] f39592b;
        int f39593c;
        boolean f39594d;
        volatile boolean f39595e;

        FromArrayDisposable(Observer<? super T> observer, T[] tArr) {
            this.f39591a = observer;
            this.f39592b = tArr;
        }

        public final int mo7033a(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f39594d = true;
            return 1;
        }

        public final T poll() {
            int i = this.f39593c;
            Object[] objArr = this.f39592b;
            if (i == objArr.length) {
                return null;
            }
            this.f39593c = i + 1;
            return ObjectHelper.m26573a(objArr[i], "The array element is null");
        }

        public final boolean isEmpty() {
            return this.f39593c == this.f39592b.length;
        }

        public final void clear() {
            this.f39593c = this.f39592b.length;
        }

        public final void mo5626a() {
            this.f39595e = true;
        }

        public final boolean mo5627b() {
            return this.f39595e;
        }
    }

    public ObservableFromArray(T[] tArr) {
        this.f35672a = tArr;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        FromArrayDisposable fromArrayDisposable = new FromArrayDisposable(observer, this.f35672a);
        observer.onSubscribe(fromArrayDisposable);
        if (fromArrayDisposable.f39594d == null) {
            observer = fromArrayDisposable.f39592b;
            int length = observer.length;
            for (int i = 0; i < length && !fromArrayDisposable.mo5627b(); i++) {
                Object obj = observer[i];
                if (obj == null) {
                    observer = fromArrayDisposable.f39591a;
                    StringBuilder stringBuilder = new StringBuilder("The ");
                    stringBuilder.append(i);
                    stringBuilder.append("th element is null");
                    observer.onError(new NullPointerException(stringBuilder.toString()));
                    return;
                }
                fromArrayDisposable.f39591a.onNext(obj);
            }
            if (fromArrayDisposable.mo5627b() == null) {
                fromArrayDisposable.f39591a.onComplete();
            }
        }
    }
}
