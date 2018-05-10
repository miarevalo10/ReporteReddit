package io.reactivex.internal.operators.flowable;

import io.reactivex.Emitter;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableInternalHelper {

    static final class BufferedReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> f25056a;
        private final int f25057b;

        BufferedReplayCallable(Flowable<T> flowable, int i) {
            this.f25056a = flowable;
            this.f25057b = i;
        }

        public final /* synthetic */ Object call() throws Exception {
            return this.f25056a.replay(this.f25057b);
        }
    }

    static final class BufferedTimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> f25058a;
        private final int f25059b;
        private final long f25060c;
        private final TimeUnit f25061d;
        private final Scheduler f25062e;

        BufferedTimedReplay(Flowable<T> flowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f25058a = flowable;
            this.f25059b = i;
            this.f25060c = j;
            this.f25061d = timeUnit;
            this.f25062e = scheduler;
        }

        public final /* synthetic */ Object call() throws Exception {
            return this.f25058a.replay(this.f25059b, this.f25060c, this.f25061d, this.f25062e);
        }
    }

    static final class ReplayCallable<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> f25063a;

        ReplayCallable(Flowable<T> flowable) {
            this.f25063a = flowable;
        }

        public final /* synthetic */ Object call() throws Exception {
            return this.f25063a.replay();
        }
    }

    static final class TimedReplay<T> implements Callable<ConnectableFlowable<T>> {
        private final Flowable<T> f25064a;
        private final long f25065b;
        private final TimeUnit f25066c;
        private final Scheduler f25067d;

        TimedReplay(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
            this.f25064a = flowable;
            this.f25065b = j;
            this.f25066c = timeUnit;
            this.f25067d = scheduler;
        }

        public final /* synthetic */ Object call() throws Exception {
            return this.f25064a.replay(this.f25065b, this.f25066c, this.f25067d);
        }
    }

    static final class FlatMapIntoIterable<T, U> implements Function<T, Publisher<U>> {
        private final Function<? super T, ? extends Iterable<? extends U>> f31293a;

        FlatMapIntoIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
            this.f31293a = function;
        }

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new FlowableFromIterable((Iterable) ObjectHelper.m26573a(this.f31293a.apply(obj), "The mapper returned a null Iterable"));
        }
    }

    static final class FlatMapWithCombinerInner<U, R, T> implements Function<U, R> {
        private final BiFunction<? super T, ? super U, ? extends R> f31294a;
        private final T f31295b;

        FlatMapWithCombinerInner(BiFunction<? super T, ? super U, ? extends R> biFunction, T t) {
            this.f31294a = biFunction;
            this.f31295b = t;
        }

        public final R apply(U u) throws Exception {
            return this.f31294a.apply(this.f31295b, u);
        }
    }

    static final class FlatMapWithCombinerOuter<T, R, U> implements Function<T, Publisher<R>> {
        private final BiFunction<? super T, ? super U, ? extends R> f31296a;
        private final Function<? super T, ? extends Publisher<? extends U>> f31297b;

        FlatMapWithCombinerOuter(BiFunction<? super T, ? super U, ? extends R> biFunction, Function<? super T, ? extends Publisher<? extends U>> function) {
            this.f31296a = biFunction;
            this.f31297b = function;
        }

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new FlowableMapPublisher((Publisher) ObjectHelper.m26573a(this.f31297b.apply(obj), "The mapper returned a null Publisher"), new FlatMapWithCombinerInner(this.f31296a, obj));
        }
    }

    static final class ItemDelayFunction<T, U> implements Function<T, Publisher<T>> {
        final Function<? super T, ? extends Publisher<U>> f31298a;

        ItemDelayFunction(Function<? super T, ? extends Publisher<U>> function) {
            this.f31298a = function;
        }

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return new FlowableTakePublisher((Publisher) ObjectHelper.m26573a(this.f31298a.apply(obj), "The itemDelay returned a null Publisher")).map(Functions.m26558b(obj)).defaultIfEmpty(obj);
        }
    }

    static final class ReplayFunction<T, R> implements Function<Flowable<T>, Publisher<R>> {
        private final Function<? super Flowable<T>, ? extends Publisher<R>> f31299a;
        private final Scheduler f31300b;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return Flowable.fromPublisher((Publisher) ObjectHelper.m26573a(this.f31299a.apply((Flowable) obj), "The selector returned a null Publisher")).observeOn(this.f31300b);
        }

        ReplayFunction(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
            this.f31299a = function;
            this.f31300b = scheduler;
        }
    }

    public enum RequestMax implements Consumer<Subscription> {
        ;

        private RequestMax(String str) {
        }
    }

    static final class SimpleBiGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final BiConsumer<S, Emitter<T>> f31303a;

        public final /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            this.f31303a.mo4825a(obj, (Emitter) obj2);
            return obj;
        }

        SimpleBiGenerator(BiConsumer<S, Emitter<T>> biConsumer) {
            this.f31303a = biConsumer;
        }
    }

    static final class SimpleGenerator<T, S> implements BiFunction<S, Emitter<T>, S> {
        final Consumer<Emitter<T>> f31304a;

        public final /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            this.f31304a.accept((Emitter) obj2);
            return obj;
        }

        SimpleGenerator(Consumer<Emitter<T>> consumer) {
            this.f31304a = consumer;
        }
    }

    static final class SubscriberOnComplete<T> implements Action {
        final Subscriber<T> f31305a;

        SubscriberOnComplete(Subscriber<T> subscriber) {
            this.f31305a = subscriber;
        }

        public final void run() throws Exception {
            this.f31305a.onComplete();
        }
    }

    static final class SubscriberOnError<T> implements Consumer<Throwable> {
        final Subscriber<T> f31306a;

        public final /* synthetic */ void accept(Object obj) throws Exception {
            this.f31306a.onError((Throwable) obj);
        }

        SubscriberOnError(Subscriber<T> subscriber) {
            this.f31306a = subscriber;
        }
    }

    static final class SubscriberOnNext<T> implements Consumer<T> {
        final Subscriber<T> f31307a;

        SubscriberOnNext(Subscriber<T> subscriber) {
            this.f31307a = subscriber;
        }

        public final void accept(T t) throws Exception {
            this.f31307a.onNext(t);
        }
    }

    static final class ZipIterableFunction<T, R> implements Function<List<Publisher<? extends T>>, Publisher<? extends R>> {
        private final Function<? super Object[], ? extends R> f31308a;

        public final /* synthetic */ Object apply(Object obj) throws Exception {
            return Flowable.zipIterable((List) obj, this.f31308a, false, Flowable.bufferSize());
        }

        ZipIterableFunction(Function<? super Object[], ? extends R> function) {
            this.f31308a = function;
        }
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> m26595a(Consumer<Emitter<T>> consumer) {
        return new SimpleGenerator(consumer);
    }

    public static <T, S> BiFunction<S, Emitter<T>, S> m26594a(BiConsumer<S, Emitter<T>> biConsumer) {
        return new SimpleBiGenerator(biConsumer);
    }

    public static <T, U> Function<T, Publisher<T>> m26597a(Function<? super T, ? extends Publisher<U>> function) {
        return new ItemDelayFunction(function);
    }

    public static <T> Consumer<T> m26596a(Subscriber<T> subscriber) {
        return new SubscriberOnNext(subscriber);
    }

    public static <T> Consumer<Throwable> m26604b(Subscriber<T> subscriber) {
        return new SubscriberOnError(subscriber);
    }

    public static <T> Action m26606c(Subscriber<T> subscriber) {
        return new SubscriberOnComplete(subscriber);
    }

    public static <T, U, R> Function<T, Publisher<R>> m26599a(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return new FlatMapWithCombinerOuter(biFunction, function);
    }

    public static <T, U> Function<T, Publisher<U>> m26605b(Function<? super T, ? extends Iterable<? extends U>> function) {
        return new FlatMapIntoIterable(function);
    }

    public static <T> Callable<ConnectableFlowable<T>> m26600a(Flowable<T> flowable) {
        return new ReplayCallable(flowable);
    }

    public static <T> Callable<ConnectableFlowable<T>> m26601a(Flowable<T> flowable, int i) {
        return new BufferedReplayCallable(flowable, i);
    }

    public static <T> Callable<ConnectableFlowable<T>> m26602a(Flowable<T> flowable, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new BufferedTimedReplay(flowable, i, j, timeUnit, scheduler);
    }

    public static <T> Callable<ConnectableFlowable<T>> m26603a(Flowable<T> flowable, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return new TimedReplay(flowable, j, timeUnit, scheduler);
    }

    public static <T, R> Function<Flowable<T>, Publisher<R>> m26598a(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        return new ReplayFunction(function, scheduler);
    }

    public static <T, R> Function<List<Publisher<? extends T>>, Publisher<? extends R>> m26607c(Function<? super Object[], ? extends R> function) {
        return new ZipIterableFunction(function);
    }
}
