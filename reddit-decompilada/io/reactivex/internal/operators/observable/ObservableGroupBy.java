package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    final Function<? super T, ? extends K> f38012a;
    final Function<? super T, ? extends V> f38013b;
    final int f38014c;
    final boolean f38015d;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        static final Object f31837g = new Object();
        final Observer<? super GroupedObservable<K, V>> f31838a;
        final Function<? super T, ? extends K> f31839b;
        final Function<? super T, ? extends V> f31840c;
        final int f31841d;
        final boolean f31842e;
        final Map<Object, GroupedUnicast<K, V>> f31843f;
        Disposable f31844h;
        final AtomicBoolean f31845i = new AtomicBoolean();

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
            this.f31838a = observer;
            this.f31839b = function;
            this.f31840c = function2;
            this.f31841d = i;
            this.f31842e = z;
            this.f31843f = new ConcurrentHashMap();
            lazySet(1);
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32089a(this.f31844h, disposable)) {
                this.f31844h = disposable;
                this.f31838a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            try {
                Object obj;
                Object apply = this.f31839b.apply(t);
                if (apply != null) {
                    obj = apply;
                } else {
                    obj = f31837g;
                }
                GroupedUnicast groupedUnicast = (GroupedUnicast) this.f31843f.get(obj);
                if (groupedUnicast == null) {
                    if (!this.f31845i.get()) {
                        groupedUnicast = GroupedUnicast.m38136a(apply, this.f31841d, this, this.f31842e);
                        this.f31843f.put(obj, groupedUnicast);
                        getAndIncrement();
                        this.f31838a.onNext(groupedUnicast);
                    } else {
                        return;
                    }
                }
                try {
                    t = ObjectHelper.m26573a(this.f31840c.apply(t), "The value supplied is null");
                    State state = groupedUnicast.f38011a;
                    state.f31847b.offer(t);
                    state.m32476c();
                } catch (T t2) {
                    Exceptions.m26521b(t2);
                    this.f31844h.mo5626a();
                    onError(t2);
                }
            } catch (T t22) {
                Exceptions.m26521b(t22);
                this.f31844h.mo5626a();
                onError(t22);
            }
        }

        public final void onError(Throwable th) {
            List<GroupedUnicast> arrayList = new ArrayList(this.f31843f.values());
            this.f31843f.clear();
            for (GroupedUnicast groupedUnicast : arrayList) {
                State state = groupedUnicast.f38011a;
                state.f31851f = th;
                state.f31850e = true;
                state.m32476c();
            }
            this.f31838a.onError(th);
        }

        public final void onComplete() {
            List<GroupedUnicast> arrayList = new ArrayList(this.f31843f.values());
            this.f31843f.clear();
            for (GroupedUnicast groupedUnicast : arrayList) {
                State state = groupedUnicast.f38011a;
                state.f31850e = true;
                state.m32476c();
            }
            this.f31838a.onComplete();
        }

        public final void mo5626a() {
            if (this.f31845i.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f31844h.mo5626a();
            }
        }

        public final boolean mo5627b() {
            return this.f31845i.get();
        }

        public final void m32472a(K k) {
            if (k == null) {
                k = f31837g;
            }
            this.f31843f.remove(k);
            if (decrementAndGet() == null) {
                this.f31844h.mo5626a();
            }
        }
    }

    static final class State<T, K> extends AtomicInteger implements ObservableSource<T>, Disposable {
        final K f31846a;
        final SpscLinkedArrayQueue<T> f31847b;
        final GroupByObserver<?, K, T> f31848c;
        final boolean f31849d;
        volatile boolean f31850e;
        Throwable f31851f;
        final AtomicBoolean f31852g = new AtomicBoolean();
        final AtomicBoolean f31853h = new AtomicBoolean();
        final AtomicReference<Observer<? super T>> f31854i = new AtomicReference();

        State(int i, GroupByObserver<?, K, T> groupByObserver, K k, boolean z) {
            this.f31847b = new SpscLinkedArrayQueue(i);
            this.f31848c = groupByObserver;
            this.f31846a = k;
            this.f31849d = z;
        }

        public final void mo5626a() {
            if (this.f31852g.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f31854i.lazySet(null);
                this.f31848c.m32472a(this.f31846a);
            }
        }

        public final boolean mo5627b() {
            return this.f31852g.get();
        }

        public final void subscribe(Observer<? super T> observer) {
            if (this.f31853h.compareAndSet(false, true)) {
                observer.onSubscribe(this);
                this.f31854i.lazySet(observer);
                if (this.f31852g.get() != null) {
                    this.f31854i.lazySet(null);
                    return;
                } else {
                    m32476c();
                    return;
                }
            }
            EmptyDisposable.m38051a(new IllegalStateException("Only one Observer allowed!"), (Observer) observer);
        }

        final void m32476c() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue spscLinkedArrayQueue = this.f31847b;
                boolean z = this.f31849d;
                Observer observer = (Observer) this.f31854i.get();
                int i = 1;
                while (true) {
                    if (observer != null) {
                        while (true) {
                            boolean z2 = this.f31850e;
                            Object poll = spscLinkedArrayQueue.poll();
                            Object obj = null;
                            Object obj2 = poll == null ? 1 : null;
                            if (!this.f31852g.get()) {
                                if (z2) {
                                    Throwable th;
                                    if (!z) {
                                        th = this.f31851f;
                                        if (th != null) {
                                            this.f31847b.clear();
                                            this.f31854i.lazySet(null);
                                            observer.onError(th);
                                        } else if (obj2 != null) {
                                            this.f31854i.lazySet(null);
                                            observer.onComplete();
                                        }
                                    } else if (obj2 != null) {
                                        th = this.f31851f;
                                        this.f31854i.lazySet(null);
                                        if (th != null) {
                                            observer.onError(th);
                                        } else {
                                            observer.onComplete();
                                        }
                                    }
                                }
                                if (obj == null) {
                                    if (obj2 == null) {
                                        break;
                                    }
                                    observer.onNext(poll);
                                } else {
                                    return;
                                }
                            }
                            this.f31847b.clear();
                            this.f31848c.m32472a(this.f31846a);
                            this.f31854i.lazySet(null);
                            obj = 1;
                            if (obj == null) {
                                return;
                            }
                            if (obj2 == null) {
                                break;
                            }
                            observer.onNext(poll);
                        }
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                    if (observer == null) {
                        observer = (Observer) this.f31854i.get();
                    }
                }
            }
        }
    }

    static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> f38011a;

        public static <T, K> GroupedUnicast<K, T> m38136a(K k, int i, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new GroupedUnicast(k, new State(i, groupByObserver, k, z));
        }

        private GroupedUnicast(K k, State<T, K> state) {
            super(k);
            this.f38011a = state;
        }

        protected final void subscribeActual(Observer<? super T> observer) {
            this.f38011a.subscribe(observer);
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i, boolean z) {
        super(observableSource);
        this.f38012a = function;
        this.f38013b = function2;
        this.f38014c = i;
        this.f38015d = z;
    }

    public final void subscribeActual(Observer<? super GroupedObservable<K, V>> observer) {
        this.source.subscribe(new GroupByObserver(observer, this.f38012a, this.f38013b, this.f38014c, this.f38015d));
    }
}
