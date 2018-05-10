package io.reactivex;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.functions.Function4;
import io.reactivex.functions.Function5;
import io.reactivex.functions.Function6;
import io.reactivex.functions.Function7;
import io.reactivex.functions.Function8;
import io.reactivex.functions.Function9;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BiConsumerSingleObserver;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.observers.FutureSingleObserver;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.maybe.MaybeFilterSingle;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.single.SingleAmb;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleContains;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDefer;
import io.reactivex.internal.operators.single.SingleDelay;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithSingle;
import io.reactivex.internal.operators.single.SingleDetach;
import io.reactivex.internal.operators.single.SingleDoAfterSuccess;
import io.reactivex.internal.operators.single.SingleDoAfterTerminate;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleDoOnError;
import io.reactivex.internal.operators.single.SingleDoOnEvent;
import io.reactivex.internal.operators.single.SingleDoOnSubscribe;
import io.reactivex.internal.operators.single.SingleDoOnSuccess;
import io.reactivex.internal.operators.single.SingleEquals;
import io.reactivex.internal.operators.single.SingleError;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.internal.operators.single.SingleFromCallable;
import io.reactivex.internal.operators.single.SingleFromPublisher;
import io.reactivex.internal.operators.single.SingleFromUnsafeSource;
import io.reactivex.internal.operators.single.SingleHide;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import io.reactivex.internal.operators.single.SingleJust;
import io.reactivex.internal.operators.single.SingleLift;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.internal.operators.single.SingleNever;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleOnErrorReturn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.operators.single.SingleZipIterable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Single<T> implements SingleSource<T> {
    public abstract void subscribeActual(SingleObserver<? super T> singleObserver);

    public static <T> Single<T> amb(Iterable<? extends SingleSource<? extends T>> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26747a(new SingleAmb(null, iterable));
    }

    public static <T> Single<T> ambArray(SingleSource<? extends T>... singleSourceArr) {
        if (singleSourceArr.length == 0) {
            return error(SingleInternalHelper.m26651a());
        }
        if (singleSourceArr.length == 1) {
            return wrap(singleSourceArr[0]);
        }
        return RxJavaPlugins.m26747a(new SingleAmb(singleSourceArr, null));
    }

    public static <T> Flowable<T> concat(Iterable<? extends SingleSource<? extends T>> iterable) {
        return concat(Flowable.fromIterable(iterable));
    }

    public static <T> Observable<T> concat(ObservableSource<? extends SingleSource<? extends T>> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "sources is null");
        return RxJavaPlugins.m26742a(new ObservableConcatMap(observableSource, SingleInternalHelper.m26653c(), 2, ErrorMode.IMMEDIATE));
    }

    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> publisher) {
        return concat((Publisher) publisher, 2);
    }

    public static <T> Flowable<T> concat(Publisher<? extends SingleSource<? extends T>> publisher, int i) {
        ObjectHelper.m26573a((Object) publisher, "sources is null");
        ObjectHelper.m26569a(i, "prefetch");
        return RxJavaPlugins.m26739a(new FlowableConcatMapPublisher(publisher, SingleInternalHelper.m26652b(), i, ErrorMode.IMMEDIATE));
    }

    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        return concat(Flowable.fromArray(singleSource, singleSource2));
    }

    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        return concat(Flowable.fromArray(singleSource, singleSource2, singleSource3));
    }

    public static <T> Flowable<T> concat(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        ObjectHelper.m26573a((Object) singleSource4, "source4 is null");
        return concat(Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    public static <T> Flowable<T> concatArray(SingleSource<? extends T>... singleSourceArr) {
        return RxJavaPlugins.m26739a(new FlowableConcatMap(Flowable.fromArray(singleSourceArr), SingleInternalHelper.m26652b(), 2, ErrorMode.BOUNDARY));
    }

    public static <T> Single<T> create(SingleOnSubscribe<T> singleOnSubscribe) {
        ObjectHelper.m26573a((Object) singleOnSubscribe, "source is null");
        return RxJavaPlugins.m26747a(new SingleCreate(singleOnSubscribe));
    }

    public static <T> Single<T> defer(Callable<? extends SingleSource<? extends T>> callable) {
        ObjectHelper.m26573a((Object) callable, "singleSupplier is null");
        return RxJavaPlugins.m26747a(new SingleDefer(callable));
    }

    public static <T> Single<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.m26573a((Object) callable, "errorSupplier is null");
        return RxJavaPlugins.m26747a(new SingleError(callable));
    }

    public static <T> Single<T> error(Throwable th) {
        ObjectHelper.m26573a((Object) th, "error is null");
        return error(Functions.m26555a((Object) th));
    }

    public static <T> Single<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.m26573a((Object) callable, "callable is null");
        return RxJavaPlugins.m26747a(new SingleFromCallable(callable));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future) {
        return toSingle(Flowable.fromFuture(future));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return toSingle(Flowable.fromFuture(future, j, timeUnit));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return toSingle(Flowable.fromFuture(future, j, timeUnit, scheduler));
    }

    public static <T> Single<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        return toSingle(Flowable.fromFuture(future, scheduler));
    }

    public static <T> Single<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "publisher is null");
        return RxJavaPlugins.m26747a(new SingleFromPublisher(publisher));
    }

    public static <T> Single<T> fromObservable(ObservableSource<? extends T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "observableSource is null");
        return RxJavaPlugins.m26747a(new ObservableSingleSingle(observableSource, null));
    }

    public static <T> Single<T> just(T t) {
        ObjectHelper.m26573a((Object) t, "value is null");
        return RxJavaPlugins.m26747a(new SingleJust(t));
    }

    public static <T> Flowable<T> merge(Iterable<? extends SingleSource<? extends T>> iterable) {
        return merge(Flowable.fromIterable(iterable));
    }

    public static <T> Flowable<T> merge(Publisher<? extends SingleSource<? extends T>> publisher) {
        ObjectHelper.m26573a((Object) publisher, "sources is null");
        return RxJavaPlugins.m26739a(new FlowableFlatMapPublisher(publisher, SingleInternalHelper.m26652b(), false, RedditJobManager.f10810d, Flowable.bufferSize()));
    }

    public static <T> Single<T> merge(SingleSource<? extends SingleSource<? extends T>> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "source is null");
        return RxJavaPlugins.m26747a(new SingleFlatMap(singleSource, Functions.m26541a()));
    }

    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        return merge(Flowable.fromArray(singleSource, singleSource2));
    }

    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        return merge(Flowable.fromArray(singleSource, singleSource2, singleSource3));
    }

    public static <T> Flowable<T> merge(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        ObjectHelper.m26573a((Object) singleSource4, "source4 is null");
        return merge(Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    public static <T> Flowable<T> mergeDelayError(Iterable<? extends SingleSource<? extends T>> iterable) {
        return mergeDelayError(Flowable.fromIterable(iterable));
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends SingleSource<? extends T>> publisher) {
        ObjectHelper.m26573a((Object) publisher, "sources is null");
        return RxJavaPlugins.m26739a(new FlowableFlatMapPublisher(publisher, SingleInternalHelper.m26652b(), true, RedditJobManager.f10810d, Flowable.bufferSize()));
    }

    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        return mergeDelayError(Flowable.fromArray(singleSource, singleSource2));
    }

    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        return mergeDelayError(Flowable.fromArray(singleSource, singleSource2, singleSource3));
    }

    public static <T> Flowable<T> mergeDelayError(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2, SingleSource<? extends T> singleSource3, SingleSource<? extends T> singleSource4) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        ObjectHelper.m26573a((Object) singleSource4, "source4 is null");
        return mergeDelayError(Flowable.fromArray(singleSource, singleSource2, singleSource3, singleSource4));
    }

    public static <T> Single<T> never() {
        return RxJavaPlugins.m26747a(SingleNever.f35832a);
    }

    public static Single<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.m26770a());
    }

    public static Single<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26747a(new SingleTimer(j, timeUnit, scheduler));
    }

    public static <T> Single<Boolean> equals(SingleSource<? extends T> singleSource, SingleSource<? extends T> singleSource2) {
        ObjectHelper.m26573a((Object) singleSource, "first is null");
        ObjectHelper.m26573a((Object) singleSource2, "second is null");
        return RxJavaPlugins.m26747a(new SingleEquals(singleSource, singleSource2));
    }

    public static <T> Single<T> unsafeCreate(SingleSource<T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "onSubscribe is null");
        if (!(singleSource instanceof Single)) {
            return RxJavaPlugins.m26747a(new SingleFromUnsafeSource(singleSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
    }

    public static <T, U> Single<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T, U> Single<T> using(Callable<U> callable, Function<? super U, ? extends SingleSource<? extends T>> function, Consumer<? super U> consumer, boolean z) {
        ObjectHelper.m26573a((Object) callable, "resourceSupplier is null");
        ObjectHelper.m26573a((Object) function, "singleFunction is null");
        ObjectHelper.m26573a((Object) consumer, "disposer is null");
        return RxJavaPlugins.m26747a(new SingleUsing(callable, function, consumer, z));
    }

    public static <T> Single<T> wrap(SingleSource<T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "source is null");
        if (singleSource instanceof Single) {
            return RxJavaPlugins.m26747a((Single) singleSource);
        }
        return RxJavaPlugins.m26747a(new SingleFromUnsafeSource(singleSource));
    }

    public static <T, R> Single<R> zip(Iterable<? extends SingleSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.m26573a((Object) function, "zipper is null");
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26747a(new SingleZipIterable(iterable, function));
    }

    public static <T1, T2, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        return zipArray(Functions.m26542a((BiFunction) biFunction), singleSource, singleSource2);
    }

    public static <T1, T2, T3, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        return zipArray(Functions.m26543a((Function3) function3), singleSource, singleSource2, singleSource3);
    }

    public static <T1, T2, T3, T4, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        ObjectHelper.m26573a((Object) singleSource4, "source4 is null");
        return zipArray(Functions.m26544a((Function4) function4), singleSource, singleSource2, singleSource3, singleSource4);
    }

    public static <T1, T2, T3, T4, T5, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        ObjectHelper.m26573a((Object) singleSource4, "source4 is null");
        ObjectHelper.m26573a((Object) singleSource5, "source5 is null");
        return zipArray(Functions.m26545a((Function5) function5), singleSource, singleSource2, singleSource3, singleSource4, singleSource5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        ObjectHelper.m26573a((Object) singleSource4, "source4 is null");
        ObjectHelper.m26573a((Object) singleSource5, "source5 is null");
        ObjectHelper.m26573a((Object) singleSource6, "source6 is null");
        return zipArray(Functions.m26546a((Function6) function6), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        ObjectHelper.m26573a((Object) singleSource4, "source4 is null");
        ObjectHelper.m26573a((Object) singleSource5, "source5 is null");
        ObjectHelper.m26573a((Object) singleSource6, "source6 is null");
        ObjectHelper.m26573a((Object) singleSource7, "source7 is null");
        return zipArray(Functions.m26547a((Function7) function7), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        ObjectHelper.m26573a((Object) singleSource4, "source4 is null");
        ObjectHelper.m26573a((Object) singleSource5, "source5 is null");
        ObjectHelper.m26573a((Object) singleSource6, "source6 is null");
        ObjectHelper.m26573a((Object) singleSource7, "source7 is null");
        ObjectHelper.m26573a((Object) singleSource8, "source8 is null");
        return zipArray(Functions.m26548a((Function8) function8), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Single<R> zip(SingleSource<? extends T1> singleSource, SingleSource<? extends T2> singleSource2, SingleSource<? extends T3> singleSource3, SingleSource<? extends T4> singleSource4, SingleSource<? extends T5> singleSource5, SingleSource<? extends T6> singleSource6, SingleSource<? extends T7> singleSource7, SingleSource<? extends T8> singleSource8, SingleSource<? extends T9> singleSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.m26573a((Object) singleSource, "source1 is null");
        ObjectHelper.m26573a((Object) singleSource2, "source2 is null");
        ObjectHelper.m26573a((Object) singleSource3, "source3 is null");
        ObjectHelper.m26573a((Object) singleSource4, "source4 is null");
        ObjectHelper.m26573a((Object) singleSource5, "source5 is null");
        ObjectHelper.m26573a((Object) singleSource6, "source6 is null");
        ObjectHelper.m26573a((Object) singleSource7, "source7 is null");
        ObjectHelper.m26573a((Object) singleSource8, "source8 is null");
        ObjectHelper.m26573a((Object) singleSource9, "source9 is null");
        return zipArray(Functions.m26549a((Function9) function9), singleSource, singleSource2, singleSource3, singleSource4, singleSource5, singleSource6, singleSource7, singleSource8, singleSource9);
    }

    public static <T, R> Single<R> zipArray(Function<? super Object[], ? extends R> function, SingleSource<? extends T>... singleSourceArr) {
        ObjectHelper.m26573a((Object) function, "zipper is null");
        ObjectHelper.m26573a((Object) singleSourceArr, "sources is null");
        if (singleSourceArr.length == 0) {
            return error(new NoSuchElementException());
        }
        return RxJavaPlugins.m26747a(new SingleZipArray(singleSourceArr, function));
    }

    public final Single<T> ambWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "other is null");
        return ambArray(this, singleSource);
    }

    public final <R> R as(SingleConverter<T, ? extends R> singleConverter) {
        return ((SingleConverter) ObjectHelper.m26573a((Object) singleConverter, "converter is null")).m26500a();
    }

    public final Single<T> hide() {
        return RxJavaPlugins.m26747a(new SingleHide(this));
    }

    public final <R> Single<R> compose(SingleTransformer<? super T, ? extends R> singleTransformer) {
        return wrap(((SingleTransformer) ObjectHelper.m26573a((Object) singleTransformer, "transformer is null")).m26504a());
    }

    public final Single<T> cache() {
        return RxJavaPlugins.m26747a(new SingleCache(this));
    }

    public final <U> Single<U> cast(Class<? extends U> cls) {
        ObjectHelper.m26573a((Object) cls, "clazz is null");
        return map(Functions.m26550a((Class) cls));
    }

    public final Flowable<T> concatWith(SingleSource<? extends T> singleSource) {
        return concat((SingleSource) this, (SingleSource) singleSource);
    }

    public final Single<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.m26770a(), false);
    }

    public final Single<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, Schedulers.m26770a(), z);
    }

    public final Single<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    public final Single<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26747a(new SingleDelay(this, j, timeUnit, scheduler, z));
    }

    public final Single<T> delaySubscription(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return RxJavaPlugins.m26747a(new SingleDelayWithCompletable(this, completableSource));
    }

    public final <U> Single<T> delaySubscription(SingleSource<U> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "other is null");
        return RxJavaPlugins.m26747a(new SingleDelayWithSingle(this, singleSource));
    }

    public final <U> Single<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return RxJavaPlugins.m26747a(new SingleDelayWithObservable(this, observableSource));
    }

    public final <U> Single<T> delaySubscription(Publisher<U> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return RxJavaPlugins.m26747a(new SingleDelayWithPublisher(this, publisher));
    }

    public final Single<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, Schedulers.m26770a());
    }

    public final Single<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(Observable.timer(j, timeUnit, scheduler));
    }

    public final Single<T> doAfterSuccess(Consumer<? super T> consumer) {
        ObjectHelper.m26573a((Object) consumer, "doAfterSuccess is null");
        return RxJavaPlugins.m26747a(new SingleDoAfterSuccess(this, consumer));
    }

    public final Single<T> doAfterTerminate(Action action) {
        ObjectHelper.m26573a((Object) action, "onAfterTerminate is null");
        return RxJavaPlugins.m26747a(new SingleDoAfterTerminate(this, action));
    }

    public final Single<T> doFinally(Action action) {
        ObjectHelper.m26573a((Object) action, "onFinally is null");
        return RxJavaPlugins.m26747a(new SingleDoFinally(this, action));
    }

    public final Single<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        ObjectHelper.m26573a((Object) consumer, "onSubscribe is null");
        return RxJavaPlugins.m26747a(new SingleDoOnSubscribe(this, consumer));
    }

    public final Single<T> doOnSuccess(Consumer<? super T> consumer) {
        ObjectHelper.m26573a((Object) consumer, "onSuccess is null");
        return RxJavaPlugins.m26747a(new SingleDoOnSuccess(this, consumer));
    }

    public final Single<T> doOnEvent(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.m26573a((Object) biConsumer, "onEvent is null");
        return RxJavaPlugins.m26747a(new SingleDoOnEvent(this, biConsumer));
    }

    public final Single<T> doOnError(Consumer<? super Throwable> consumer) {
        ObjectHelper.m26573a((Object) consumer, "onError is null");
        return RxJavaPlugins.m26747a(new SingleDoOnError(this, consumer));
    }

    public final Single<T> doOnDispose(Action action) {
        ObjectHelper.m26573a((Object) action, "onDispose is null");
        return RxJavaPlugins.m26747a(new SingleDoOnDispose(this, action));
    }

    public final Maybe<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26740a(new MaybeFilterSingle(this, predicate));
    }

    public final <R> Single<R> flatMap(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26747a(new SingleFlatMap(this, function));
    }

    public final <R> Maybe<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26740a(new SingleFlatMapMaybe(this, function));
    }

    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        return toFlowable().flatMap(function);
    }

    public final <U> Flowable<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26739a(new SingleFlatMapIterableFlowable(this, function));
    }

    public final <U> Observable<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26742a(new SingleFlatMapIterableObservable(this, function));
    }

    public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return toObservable().flatMap(function);
    }

    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26737a(new SingleFlatMapCompletable(this, function));
    }

    public final T blockingGet() {
        SingleObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.m32116a();
    }

    public final <R> Single<R> lift(SingleOperator<? extends R, ? super T> singleOperator) {
        ObjectHelper.m26573a((Object) singleOperator, "onLift is null");
        return RxJavaPlugins.m26747a(new SingleLift(this, singleOperator));
    }

    public final <R> Single<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26747a(new SingleMap(this, function));
    }

    public final Single<Boolean> contains(Object obj) {
        return contains(obj, ObjectHelper.m26572a());
    }

    public final Single<Boolean> contains(Object obj, BiPredicate<Object, Object> biPredicate) {
        ObjectHelper.m26573a(obj, "value is null");
        ObjectHelper.m26573a((Object) biPredicate, "comparer is null");
        return RxJavaPlugins.m26747a(new SingleContains(this, obj, biPredicate));
    }

    public final Flowable<T> mergeWith(SingleSource<? extends T> singleSource) {
        return merge(this, singleSource);
    }

    public final Single<T> observeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26747a(new SingleObserveOn(this, scheduler));
    }

    public final Single<T> onErrorReturn(Function<Throwable, ? extends T> function) {
        ObjectHelper.m26573a((Object) function, "resumeFunction is null");
        return RxJavaPlugins.m26747a(new SingleOnErrorReturn(this, function, null));
    }

    public final Single<T> onErrorReturnItem(T t) {
        ObjectHelper.m26573a((Object) t, "value is null");
        return RxJavaPlugins.m26747a(new SingleOnErrorReturn(this, null, t));
    }

    public final Single<T> onErrorResumeNext(Single<? extends T> single) {
        ObjectHelper.m26573a((Object) single, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(Functions.m26558b((Object) single));
    }

    public final Single<T> onErrorResumeNext(Function<? super Throwable, ? extends SingleSource<? extends T>> function) {
        ObjectHelper.m26573a((Object) function, "resumeFunctionInCaseOfError is null");
        return RxJavaPlugins.m26747a(new SingleResumeNext(this, function));
    }

    public final Single<T> onTerminateDetach() {
        return RxJavaPlugins.m26747a(new SingleDetach(this));
    }

    public final Flowable<T> repeat() {
        return toFlowable().repeat();
    }

    public final Flowable<T> repeat(long j) {
        return toFlowable().repeat(j);
    }

    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return toFlowable().repeatWhen(function);
    }

    public final Flowable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        return toFlowable().repeatUntil(booleanSupplier);
    }

    public final Single<T> retry() {
        return toSingle(toFlowable().retry());
    }

    public final Single<T> retry(long j) {
        return toSingle(toFlowable().retry(j));
    }

    public final Single<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return toSingle(toFlowable().retry((BiPredicate) biPredicate));
    }

    public final Single<T> retry(long j, Predicate<? super Throwable> predicate) {
        return toSingle(toFlowable().retry(j, predicate));
    }

    public final Single<T> retry(Predicate<? super Throwable> predicate) {
        return toSingle(toFlowable().retry((Predicate) predicate));
    }

    public final Single<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return toSingle(toFlowable().retryWhen(function));
    }

    public final Disposable subscribe() {
        return subscribe(Functions.m26556b(), Functions.f25017f);
    }

    public final Disposable subscribe(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.m26573a((Object) biConsumer, "onCallback is null");
        SingleObserver biConsumerSingleObserver = new BiConsumerSingleObserver(biConsumer);
        subscribe(biConsumerSingleObserver);
        return biConsumerSingleObserver;
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.f25017f);
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObjectHelper.m26573a((Object) consumer, "onSuccess is null");
        ObjectHelper.m26573a((Object) consumer2, "onError is null");
        SingleObserver consumerSingleObserver = new ConsumerSingleObserver(consumer, consumer2);
        subscribe(consumerSingleObserver);
        return consumerSingleObserver;
    }

    public final void subscribe(SingleObserver<? super T> singleObserver) {
        ObjectHelper.m26573a((Object) singleObserver, "subscriber is null");
        Object a = RxJavaPlugins.m26748a(this, (SingleObserver) singleObserver);
        ObjectHelper.m26573a(a, "subscriber returned by the RxJavaPlugins hook is null");
        try {
            subscribeActual(a);
        } catch (SingleObserver<? super T> singleObserver2) {
            throw singleObserver2;
        } catch (SingleObserver<? super T> singleObserver22) {
            Exceptions.m26521b(singleObserver22);
            new NullPointerException("subscribeActual failed").initCause(singleObserver22);
        }
    }

    public final <E extends SingleObserver<? super T>> E subscribeWith(E e) {
        subscribe((SingleObserver) e);
        return e;
    }

    public final Single<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26747a(new SingleSubscribeOn(this, scheduler));
    }

    public final Single<T> takeUntil(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return takeUntil(new CompletableToFlowable(completableSource));
    }

    public final <E> Single<T> takeUntil(Publisher<E> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return RxJavaPlugins.m26747a(new SingleTakeUntil(this, publisher));
    }

    public final <E> Single<T> takeUntil(SingleSource<? extends E> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "other is null");
        return takeUntil(new SingleToFlowable(singleSource));
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, Schedulers.m26770a(), null);
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, scheduler, null);
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "other is null");
        return timeout0(j, timeUnit, scheduler, singleSource);
    }

    public final Single<T> timeout(long j, TimeUnit timeUnit, SingleSource<? extends T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "other is null");
        return timeout0(j, timeUnit, Schedulers.m26770a(), singleSource);
    }

    private Single<T> timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, SingleSource<? extends T> singleSource) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26747a(new SingleTimeout(this, j, timeUnit, scheduler, singleSource));
    }

    public final <R> R to(Function<? super Single<T>, R> function) {
        try {
            return ((Function) ObjectHelper.m26573a((Object) function, "convert is null")).apply(this);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            function = ExceptionHelper.m26682a(th);
        }
    }

    public final Completable toCompletable() {
        return RxJavaPlugins.m26737a(new CompletableFromSingle(this));
    }

    public final Flowable<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).mo6616a();
        }
        return RxJavaPlugins.m26739a(new SingleToFlowable(this));
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureSingleObserver());
    }

    public final Maybe<T> toMaybe() {
        if (this instanceof FuseToMaybe) {
            return ((FuseToMaybe) this).mo6633a();
        }
        return RxJavaPlugins.m26740a(new MaybeFromSingle(this));
    }

    public final Observable<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).mo6641a();
        }
        return RxJavaPlugins.m26742a(new SingleToObservable(this));
    }

    public final Single<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26747a(new SingleUnsubscribeOn(this, scheduler));
    }

    public final <U, R> Single<R> zipWith(SingleSource<U> singleSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return zip(this, singleSource, biFunction);
    }

    public final TestObserver<T> test() {
        SingleObserver testObserver = new TestObserver();
        subscribe(testObserver);
        return testObserver;
    }

    public final TestObserver<T> test(boolean z) {
        SingleObserver testObserver = new TestObserver();
        if (z) {
            testObserver.m36021c();
        }
        subscribe(testObserver);
        return testObserver;
    }

    private static <T> Single<T> toSingle(Flowable<T> flowable) {
        return RxJavaPlugins.m26747a(new FlowableSingleSingle(flowable, null));
    }
}
