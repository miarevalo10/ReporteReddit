package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BasicQueueDisposable;
import java.util.Iterator;

public final class ObservableFromIterable<T> extends Observable<T> {
    final Iterable<? extends T> f35677a;

    static final class FromIterableDisposable<T> extends BasicQueueDisposable<T> {
        final Observer<? super T> f39596a;
        final Iterator<? extends T> f39597b;
        volatile boolean f39598c;
        boolean f39599d;
        boolean f39600e;
        boolean f39601f;

        FromIterableDisposable(Observer<? super T> observer, Iterator<? extends T> it) {
            this.f39596a = observer;
            this.f39597b = it;
        }

        public final int mo7033a(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f39599d = true;
            return 1;
        }

        public final T poll() {
            if (this.f39600e) {
                return null;
            }
            if (!this.f39601f) {
                this.f39601f = true;
            } else if (!this.f39597b.hasNext()) {
                this.f39600e = true;
                return null;
            }
            return ObjectHelper.m26573a(this.f39597b.next(), "The iterator returned a null value");
        }

        public final boolean isEmpty() {
            return this.f39600e;
        }

        public final void clear() {
            this.f39600e = true;
        }

        public final void mo5626a() {
            this.f39598c = true;
        }

        public final boolean mo5627b() {
            return this.f39598c;
        }
    }

    public ObservableFromIterable(Iterable<? extends T> iterable) {
        this.f35677a = iterable;
    }

    public final void subscribeActual(Observer<? super T> observer) {
        try {
            Iterator it = this.f35677a.iterator();
            try {
                if (it.hasNext()) {
                    FromIterableDisposable fromIterableDisposable = new FromIterableDisposable(observer, it);
                    observer.onSubscribe(fromIterableDisposable);
                    if (fromIterableDisposable.f39599d == null) {
                        while (fromIterableDisposable.mo5627b() == null) {
                            try {
                                fromIterableDisposable.f39596a.onNext(ObjectHelper.m26573a(fromIterableDisposable.f39597b.next(), "The iterator returned a null value"));
                                if (fromIterableDisposable.mo5627b() != null) {
                                    break;
                                }
                                try {
                                    if (fromIterableDisposable.f39597b.hasNext() == null) {
                                        if (fromIterableDisposable.mo5627b() == null) {
                                            fromIterableDisposable.f39596a.onComplete();
                                        }
                                    }
                                } catch (Observer<? super T> observer2) {
                                    Exceptions.m26521b(observer2);
                                    fromIterableDisposable.f39596a.onError(observer2);
                                    return;
                                }
                            } catch (Observer<? super T> observer22) {
                                Exceptions.m26521b(observer22);
                                fromIterableDisposable.f39596a.onError(observer22);
                                return;
                            }
                        }
                    }
                    return;
                }
                EmptyDisposable.m38048a((Observer) observer22);
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                EmptyDisposable.m38051a(th, (Observer) observer22);
            }
        } catch (Throwable th2) {
            Exceptions.m26521b(th2);
            EmptyDisposable.m38051a(th2, (Observer) observer22);
        }
    }
}
