package io.reactivex.internal.operators.observable;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay<T> extends ConnectableObservable<T> implements Disposable {
    static final BufferSupplier f38051e = new UnBoundedFactory();
    final ObservableSource<T> f38052a;
    final AtomicReference<ReplayObserver<T>> f38053b;
    final BufferSupplier<T> f38054c;
    final ObservableSource<T> f38055d;

    interface BufferSupplier<T> {
        ReplayBuffer<T> mo5671a();
    }

    static final class Node extends AtomicReference<Node> {
        final Object f25131a;

        Node(Object obj) {
            this.f25131a = obj;
        }
    }

    interface ReplayBuffer<T> {
        void mo5667a();

        void mo5668a(InnerDisposable<T> innerDisposable);

        void mo5669a(T t);

        void mo5670a(Throwable th);
    }

    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        Node f32015a;
        int f32016b;

        Object mo6642b(Object obj) {
            return obj;
        }

        abstract void mo6643b();

        Object mo6644c(Object obj) {
            return obj;
        }

        void mo6645c() {
        }

        BoundedReplayBuffer() {
            Node node = new Node(null);
            this.f32015a = node;
            set(node);
        }

        private void m32550a(Node node) {
            this.f32015a.set(node);
            this.f32015a = node;
            this.f32016b++;
        }

        public final void mo5669a(T t) {
            m32550a(new Node(mo6642b(NotificationLite.m26696a((Object) t))));
            mo6643b();
        }

        public final void mo5670a(Throwable th) {
            m32550a(new Node(mo6642b(NotificationLite.m26697a(th))));
            mo6645c();
        }

        public final void mo5667a() {
            m32550a(new Node(mo6642b(NotificationLite.m26694a())));
            mo6645c();
        }

        public final void mo5668a(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                int i = 1;
                do {
                    Node node = (Node) innerDisposable.f32020c;
                    if (node == null) {
                        node = mo6646d();
                        innerDisposable.f32020c = node;
                    }
                    while (!innerDisposable.mo5627b()) {
                        Node node2 = (Node) node.get();
                        if (node2 == null) {
                            innerDisposable.f32020c = node;
                            i = innerDisposable.addAndGet(-i);
                        } else if (NotificationLite.m26699a(mo6644c(node2.f25131a), innerDisposable.f32019b)) {
                            innerDisposable.f32020c = null;
                            return;
                        } else {
                            node = node2;
                        }
                    }
                    return;
                } while (i != 0);
            }
        }

        Node mo6646d() {
            return (Node) get();
        }
    }

    static final class DisposeConsumer<R> implements Consumer<Disposable> {
        private final ObserverResourceWrapper<R> f32017a;

        public final /* synthetic */ void accept(Object obj) throws Exception {
            DisposableHelper.m32091a(this.f32017a, (Disposable) obj);
        }

        DisposeConsumer(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.f32017a = observerResourceWrapper;
        }
    }

    static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        final ReplayObserver<T> f32018a;
        final Observer<? super T> f32019b;
        Object f32020c;
        volatile boolean f32021d;

        InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            this.f32018a = replayObserver;
            this.f32019b = observer;
        }

        public final boolean mo5627b() {
            return this.f32021d;
        }

        public final void mo5626a() {
            if (!this.f32021d) {
                this.f32021d = true;
                this.f32018a.m32566a(this);
            }
        }
    }

    static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {
        private final int f32022a;

        ReplayBufferSupplier(int i) {
            this.f32022a = i;
        }

        public final ReplayBuffer<T> mo5671a() {
            return new SizeBoundReplayBuffer(this.f32022a);
        }
    }

    static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        static final InnerDisposable[] f32023c = new InnerDisposable[0];
        static final InnerDisposable[] f32024d = new InnerDisposable[0];
        final ReplayBuffer<T> f32025a;
        boolean f32026b;
        final AtomicReference<InnerDisposable[]> f32027e = new AtomicReference(f32023c);
        final AtomicBoolean f32028f = new AtomicBoolean();

        ReplayObserver(ReplayBuffer<T> replayBuffer) {
            this.f32025a = replayBuffer;
        }

        public final boolean mo5627b() {
            return this.f32027e.get() == f32024d;
        }

        public final void mo5626a() {
            this.f32027e.set(f32024d);
            DisposableHelper.m32090a((AtomicReference) this);
        }

        final void m32566a(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            Object obj;
            do {
                innerDisposableArr = (InnerDisposable[]) this.f32027e.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i = -1;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (innerDisposableArr[i2].equals(innerDisposable)) {
                            i = i2;
                            break;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            obj = f32023c;
                        } else {
                            Object obj2 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, obj2, 0, i);
                            System.arraycopy(innerDisposableArr, i + 1, obj2, i, (length - i) - 1);
                            obj = obj2;
                        }
                    } else {
                        return;
                    }
                }
                return;
            } while (!this.f32027e.compareAndSet(innerDisposableArr, obj));
        }

        public final void onSubscribe(Disposable disposable) {
            if (DisposableHelper.m32092b(this, disposable) != null) {
                m32563c();
            }
        }

        public final void onNext(T t) {
            if (!this.f32026b) {
                this.f32025a.mo5669a((Object) t);
                m32563c();
            }
        }

        public final void onError(Throwable th) {
            if (this.f32026b) {
                RxJavaPlugins.m26757a(th);
                return;
            }
            this.f32026b = true;
            this.f32025a.mo5670a(th);
            m32564d();
        }

        public final void onComplete() {
            if (!this.f32026b) {
                this.f32026b = true;
                this.f32025a.mo5667a();
                m32564d();
            }
        }

        private void m32563c() {
            for (InnerDisposable a : (InnerDisposable[]) this.f32027e.get()) {
                this.f32025a.mo5668a(a);
            }
        }

        private void m32564d() {
            for (InnerDisposable a : (InnerDisposable[]) this.f32027e.getAndSet(f32024d)) {
                this.f32025a.mo5668a(a);
            }
        }
    }

    static final class ReplaySource<T> implements ObservableSource<T> {
        private final AtomicReference<ReplayObserver<T>> f32029a;
        private final BufferSupplier<T> f32030b;

        ReplaySource(AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
            this.f32029a = atomicReference;
            this.f32030b = bufferSupplier;
        }

        public final void subscribe(Observer<? super T> observer) {
            ReplayObserver replayObserver;
            ReplayObserver replayObserver2;
            do {
                replayObserver2 = (ReplayObserver) this.f32029a.get();
                if (replayObserver2 != null) {
                    break;
                }
                replayObserver = new ReplayObserver(this.f32030b.mo5671a());
            } while (!this.f32029a.compareAndSet(null, replayObserver));
            replayObserver2 = replayObserver;
            InnerDisposable innerDisposable = new InnerDisposable(replayObserver2, observer);
            observer.onSubscribe(innerDisposable);
            InnerDisposable[] innerDisposableArr;
            Object obj;
            do {
                innerDisposableArr = (InnerDisposable[]) replayObserver2.f32027e.get();
                if (innerDisposableArr == ReplayObserver.f32024d) {
                    break;
                }
                int length = innerDisposableArr.length;
                obj = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, obj, 0, length);
                obj[length] = innerDisposable;
            } while (replayObserver2.f32027e.compareAndSet(innerDisposableArr, obj) == null);
            if (innerDisposable.mo5627b() != null) {
                replayObserver2.m32566a(innerDisposable);
            } else {
                replayObserver2.f32025a.mo5668a(innerDisposable);
            }
        }
    }

    static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {
        private final int f32031a;
        private final long f32032b;
        private final TimeUnit f32033c;
        private final Scheduler f32034d;

        ScheduledReplaySupplier(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f32031a = i;
            this.f32032b = j;
            this.f32033c = timeUnit;
            this.f32034d = scheduler;
        }

        public final ReplayBuffer<T> mo5671a() {
            return new SizeAndTimeBoundReplayBuffer(this.f32031a, this.f32032b, this.f32033c, this.f32034d);
        }
    }

    static final class UnBoundedFactory implements BufferSupplier<Object> {
        UnBoundedFactory() {
        }

        public final ReplayBuffer<Object> mo5671a() {
            return new UnboundedReplayBuffer();
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        volatile int f32035a;

        UnboundedReplayBuffer() {
            super(16);
        }

        public final void mo5669a(T t) {
            add(NotificationLite.m26696a((Object) t));
            this.f32035a++;
        }

        public final void mo5670a(Throwable th) {
            add(NotificationLite.m26697a(th));
            this.f32035a++;
        }

        public final void mo5667a() {
            add(NotificationLite.m26694a());
            this.f32035a++;
        }

        public final void mo5668a(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                Observer observer = innerDisposable.f32019b;
                int i = 1;
                while (!innerDisposable.mo5627b()) {
                    int i2 = this.f32035a;
                    Integer num = (Integer) innerDisposable.f32020c;
                    int intValue = num != null ? num.intValue() : 0;
                    while (intValue < i2) {
                        if (!NotificationLite.m26699a(get(intValue), observer) && !innerDisposable.mo5627b()) {
                            intValue++;
                        } else {
                            return;
                        }
                    }
                    innerDisposable.f32020c = Integer.valueOf(intValue);
                    i = innerDisposable.addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }
    }

    static final class MulticastReplay<R, U> extends Observable<R> {
        private final Callable<? extends ConnectableObservable<U>> f35713a;
        private final Function<? super Observable<U>, ? extends ObservableSource<R>> f35714b;

        MulticastReplay(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
            this.f35713a = callable;
            this.f35714b = function;
        }

        protected final void subscribeActual(Observer<? super R> observer) {
            try {
                ConnectableObservable connectableObservable = (ConnectableObservable) ObjectHelper.m26573a(this.f35713a.call(), "The connectableFactory returned a null ConnectableObservable");
                ObservableSource observableSource = (ObservableSource) ObjectHelper.m26573a(this.f35714b.apply(connectableObservable), "The selector returned a null ObservableSource");
                Object observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.subscribe(observerResourceWrapper);
                connectableObservable.mo7053a(new DisposeConsumer(observerResourceWrapper));
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                EmptyDisposable.m38051a(th, (Observer) observer);
            }
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        final Scheduler f35715c;
        final long f35716d;
        final TimeUnit f35717e;
        final int f35718f;

        SizeAndTimeBoundReplayBuffer(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f35715c = scheduler;
            this.f35718f = i;
            this.f35716d = j;
            this.f35717e = timeUnit;
        }

        final Object mo6642b(Object obj) {
            return new Timed(obj, Scheduler.m26494a(this.f35717e), this.f35717e);
        }

        final Object mo6644c(Object obj) {
            return ((Timed) obj).f25242a;
        }

        final void mo6643b() {
            long a = Scheduler.m26494a(this.f35717e) - this.f35716d;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            int i = 0;
            while (true) {
                Node node3 = node2;
                node2 = node;
                node = node3;
                if (node != null) {
                    if (this.b <= this.f35718f) {
                        if (((Timed) node.f25131a).f25243b > a) {
                            break;
                        }
                        i++;
                        this.b--;
                        node2 = (Node) node.get();
                    } else {
                        i++;
                        this.b--;
                        node2 = (Node) node.get();
                    }
                } else {
                    break;
                }
            }
            if (i != 0) {
                set(node2);
            }
        }

        final void mo6645c() {
            long a = Scheduler.m26494a(this.f35717e) - this.f35716d;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            int i = 0;
            while (true) {
                Node node3 = node2;
                node2 = node;
                node = node3;
                if (node != null && this.b > 1 && ((Timed) node.f25131a).f25243b <= a) {
                    i++;
                    this.b--;
                    node2 = (Node) node.get();
                } else if (i != 0) {
                    set(node2);
                }
            }
            if (i != 0) {
                set(node2);
            }
        }

        final Node mo6646d() {
            long a = Scheduler.m26494a(this.f35717e) - this.f35716d;
            Node node = (Node) get();
            Node node2 = (Node) node.get();
            while (true) {
                Node node3 = node2;
                node2 = node;
                node = node3;
                if (node == null) {
                    break;
                }
                Timed timed = (Timed) node.f25131a;
                if (NotificationLite.m26701b(timed.f25242a) || NotificationLite.m26704c(timed.f25242a) || timed.f25243b > a) {
                    break;
                }
                node2 = (Node) node.get();
            }
            return node2;
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        final int f35719c;

        SizeBoundReplayBuffer(int i) {
            this.f35719c = i;
        }

        final void mo6643b() {
            if (this.b > this.f35719c) {
                Node node = (Node) ((Node) get()).get();
                this.f32016b--;
                set(node);
            }
        }
    }

    static final class Replay<T> extends ConnectableObservable<T> {
        private final ConnectableObservable<T> f38049a;
        private final Observable<T> f38050b;

        Replay(ConnectableObservable<T> connectableObservable, Observable<T> observable) {
            this.f38049a = connectableObservable;
            this.f38050b = observable;
        }

        public final void mo7053a(Consumer<? super Disposable> consumer) {
            this.f38049a.mo7053a(consumer);
        }

        protected final void subscribeActual(Observer<? super T> observer) {
            this.f38050b.subscribe((Observer) observer);
        }
    }

    public static <U, R> Observable<R> m38141a(Callable<? extends ConnectableObservable<U>> callable, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.m26742a(new MulticastReplay(callable, function));
    }

    public static <T> ConnectableObservable<T> m38147a(ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        return RxJavaPlugins.m26750a(new Replay(connectableObservable, connectableObservable.observeOn(scheduler)));
    }

    public static <T> ConnectableObservable<T> m38142a(ObservableSource<? extends T> observableSource) {
        return m38146a((ObservableSource) observableSource, f38051e);
    }

    public static <T> ConnectableObservable<T> m38144a(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m38145a(observableSource, j, timeUnit, scheduler, RedditJobManager.f10810d);
    }

    public static <T> ConnectableObservable<T> m38145a(ObservableSource<T> observableSource, long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return m38146a((ObservableSource) observableSource, new ScheduledReplaySupplier(i, j, timeUnit, scheduler));
    }

    private static <T> ConnectableObservable<T> m38146a(ObservableSource<T> observableSource, BufferSupplier<T> bufferSupplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.m26750a(new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }

    private ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
        this.f38055d = observableSource;
        this.f38052a = observableSource2;
        this.f38053b = atomicReference;
        this.f38054c = bufferSupplier;
    }

    public final void mo5626a() {
        this.f38053b.lazySet(null);
    }

    public final boolean mo5627b() {
        Disposable disposable = (Disposable) this.f38053b.get();
        if (disposable != null) {
            if (!disposable.mo5627b()) {
                return false;
            }
        }
        return true;
    }

    protected final void subscribeActual(Observer<? super T> observer) {
        this.f38055d.subscribe(observer);
    }

    public final void mo7053a(Consumer<? super Disposable> consumer) {
        Object obj;
        ReplayObserver replayObserver;
        do {
            obj = (ReplayObserver) this.f38053b.get();
            if (obj != null && !obj.mo5627b()) {
                break;
            }
            replayObserver = new ReplayObserver(this.f38054c.mo5671a());
        } while (!this.f38053b.compareAndSet(obj, replayObserver));
        obj = replayObserver;
        boolean z = !obj.f32028f.get() && obj.f32028f.compareAndSet(false, true);
        try {
            consumer.accept(obj);
            if (z) {
                this.f38052a.subscribe(obj);
            }
        } catch (Throwable th) {
            if (z) {
                obj.f32028f.compareAndSet(true, false);
            }
            Exceptions.m26521b(th);
            consumer = ExceptionHelper.m26682a(th);
        }
    }

    public static <T> ConnectableObservable<T> m38143a(ObservableSource<T> observableSource, int i) {
        return i == RedditJobManager.f10810d ? m38146a((ObservableSource) observableSource, f38051e) : m38146a((ObservableSource) observableSource, new ReplayBufferSupplier(i));
    }
}
