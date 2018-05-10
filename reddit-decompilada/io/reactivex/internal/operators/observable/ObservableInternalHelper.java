package io.reactivex.internal.operators.observable;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.SingleSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class ObservableInternalHelper {

    static final class BufferedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> f25117a;
        private final int f25118b;

        BufferedReplayCallable(Observable<T> observable, int i) {
            this.f25117a = observable;
            this.f25118b = i;
        }

        public final /* synthetic */ Object call() throws Exception {
            return this.f25117a.replay(this.f25118b);
        }
    }

    static final class BufferedTimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> f25119a;
        private final int f25120b;
        private final long f25121c;
        private final TimeUnit f25122d;
        private final Scheduler f25123e;

        BufferedTimedReplayCallable(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f25119a = observable;
            this.f25120b = i;
            this.f25121c = j;
            this.f25122d = timeUnit;
            this.f25123e = scheduler;
        }

        public final /* synthetic */ Object call() throws Exception {
            return this.f25119a.replay(this.f25120b, this.f25121c, this.f25122d, this.f25123e);
        }
    }

    static final class ReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> f25124a;

        ReplayCallable(Observable<T> observable) {
            this.f25124a = observable;
        }

        public final /* synthetic */ Object call() throws Exception {
            return this.f25124a.replay();
        }
    }

    static final class TimedReplayCallable<T> implements Callable<ConnectableObservable<T>> {
        private final Observable<T> f25125a;
        private final long f25126b;
        private final TimeUnit f25127c;
        private final Scheduler f25128d;

        TimedReplayCallable(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f25125a = observable;
            this.f25126b = j;
            this.f25127c = timeUnit;
            this.f25128d = scheduler;
        }

        public final /* synthetic */ Object call() throws Exception {
            return this.f25125a.replay(this.f25126b, this.f25127c, this.f25128d);
        }
    }

    static final class FlatMapIntoIterable<T, U> implements Function<T, ObservableSource<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> f31883a;

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.f31883a = function;
        }

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new ObservableFromIterable((Iterable) ObjectHelper.m26573a(this.f31883a.apply(obj), "The mapper returned a null Iterable"));
        }
    }

    static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> f31884a;
        private final T f31885b;

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            this.f31884a = biFunction;
            this.f31885b = t;
        }

        public final R apply(U u) throws Exception {
            return this.f31884a.apply(this.f31885b, u);
        }
    }

    static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, ObservableSource<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> f31886a;
        private final Function<? super T, ? extends ObservableSource<? extends U>> f31887b;

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends ObservableSource<? extends U>> function) {
            this.f31886a = biFunction;
            this.f31887b = function;
        }

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new ObservableMap((ObservableSource) ObjectHelper.m26573a(this.f31887b.apply(obj), "The mapper returned a null ObservableSource"), new FlatMapWithCombinerInner(this.f31886a, obj));
        }
    }

    static final class ItemDelayFunction<T, U> implements Function<T, ObservableSource<T>> {
        final Function<? super T, ? extends ObservableSource<U>> f31888a;

        ItemDelayFunction(Function<? super T, ? extends ObservableSource<U>> function) {
            this.f31888a = function;
        }

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new ObservableTake((ObservableSource) ObjectHelper.m26573a(this.f31888a.apply(obj), "The itemDelay returned a null ObservableSource"), 1).map(Functions.m26558b(obj)).defaultIfEmpty(obj);
        }
    }

    static final class ObservableMapper<T, R> implements Function<T, Observable<R>> {
        final Function<? super T, ? extends SingleSource<? extends R>> f31889a;

        ObservableMapper(Function<? super T, ? extends SingleSource<? extends R>> function) {
            this.f31889a = function;
        }

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return RxJavaPlugins.m26742a(new SingleToObservable((SingleSource) ObjectHelper.m26573a(this.f31889a.apply(obj), "The mapper returned a null SingleSource")));
        }
    }

    static final class ObserverOnComplete<T> implements Action {
        final Observer<T> f31890a;

        ObserverOnComplete(Observer<T> observer) {
            this.f31890a = observer;
        }

        public final void run() throws Exception {
            this.f31890a.onComplete();
        }
    }

    static final class ObserverOnError<T> implements Consumer<Throwable> {
        final Observer<T> f31891a;

        public final /* synthetic */ void accept(Object obj) throws Exception {
            this.f31891a.onError((Throwable) obj);
        }

        ObserverOnError(Observer<T> observer) {
            this.f31891a = observer;
        }
    }

    static final class ObserverOnNext<T> implements Consumer<T> {
        final Observer<T> f31892a;

        ObserverOnNext(Observer<T> observer) {
            this.f31892a = observer;
        }

        public final void accept(T t) throws Exception {
            this.f31892a.onNext(t);
        }
    }

    static final class ReplayFunction<T, R> implements Function<Observable<T>, ObservableSource<R>> {
        private final Function<? super Observable<T>, ? extends ObservableSource<R>> f31893a;
        private final Scheduler f31894b;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return Observable.wrap((ObservableSource) ObjectHelper.m26573a(this.f31893a.apply((Observable) obj), "The selector returned a null ObservableSource")).observeOn(this.f31894b);
        }

        ReplayFunction(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
            this.f31893a = function;
            this.f31894b = scheduler;
        }
    }

    static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> f31895a;

        public final /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            this.f31895a.mo4825a(obj, (Emitter) obj2);
            return obj;
        }

        SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.f31895a = biConsumer;
        }
    }

    static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> f31896a;

        public final /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            this.f31896a.accept((Emitter) obj2);
            return obj;
        }

        SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.f31896a = consumer;
        }
    }

    static final class ZipIterableFunction<T, R> implements Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> {
        private final Function<? super Object[], ? extends R> f31897a;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return Observable.zipIterable((List) obj, this.f31897a, false, Observable.bufferSize());
        }

        ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.f31897a = function;
        }
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> m26627a(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> m26626a(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, U> Function<T, ObservableSource<T>> m26629a(Function<? super T, ? extends ObservableSource<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Consumer<T> m26628a(Observer<T> observer) {
        return new ObserverOnNext(observer);
    }

    public static <T> Consumer<Throwable> m26637b(Observer<T> observer) {
        return new ObserverOnError(observer);
    }

    public static <T> Action m26639c(Observer<T> observer) {
        return new ObserverOnComplete(observer);
    }

    public static <T, U, R> Function<T, ObservableSource<R>> m26631a(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, ObservableSource<U>> m26638b(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T> Callable<ConnectableObservable<T>> m26632a(Observable<T> observable) {
        return new ReplayCallable(observable);
    }

    public static <T> Callable<ConnectableObservable<T>> m26633a(Observable<T> observable, int i) {
        return new BufferedReplayCallable(observable, i);
    }

    public static <T> Callable<ConnectableObservable<T>> m26634a(Observable<T> observable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplayCallable(observable, i, j, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableObservable<T>> m26635a(Observable<T> observable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplayCallable(observable, j, timeUnit, scheduler);
    }

    public static <T, R> Function<Observable<T>, ObservableSource<R>> m26630a(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T, R> Function<List<ObservableSource<? extends T>>, ObservableSource<? extends R>> m26640c(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }

    public static <T, R> Observable<R> m26625a(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function) {
        return observable.switchMap(m26641d(function), 1);
    }

    public static <T, R> Observable<R> m26636b(Observable<T> observable, Function<? super T, ? extends SingleSource<? extends R>> function) {
        return observable.switchMapDelayError(m26641d(function), 1);
    }

    private static <T, R> Function<T, Observable<R>> m26641d(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return new ObservableMapper(function);
    }
}
