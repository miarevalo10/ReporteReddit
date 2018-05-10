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
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.operators.flowable.FlowableConcatMapPublisher;
import io.reactivex.internal.operators.flowable.FlowableFlatMapPublisher;
import io.reactivex.internal.operators.maybe.MaybeAmb;
import io.reactivex.internal.operators.maybe.MaybeCache;
import io.reactivex.internal.operators.maybe.MaybeCallbackObserver;
import io.reactivex.internal.operators.maybe.MaybeConcatArray;
import io.reactivex.internal.operators.maybe.MaybeConcatArrayDelayError;
import io.reactivex.internal.operators.maybe.MaybeConcatIterable;
import io.reactivex.internal.operators.maybe.MaybeContains;
import io.reactivex.internal.operators.maybe.MaybeCount;
import io.reactivex.internal.operators.maybe.MaybeCreate;
import io.reactivex.internal.operators.maybe.MaybeDefer;
import io.reactivex.internal.operators.maybe.MaybeDelay;
import io.reactivex.internal.operators.maybe.MaybeDelayOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDelaySubscriptionOtherPublisher;
import io.reactivex.internal.operators.maybe.MaybeDetach;
import io.reactivex.internal.operators.maybe.MaybeDoAfterSuccess;
import io.reactivex.internal.operators.maybe.MaybeDoFinally;
import io.reactivex.internal.operators.maybe.MaybeDoOnEvent;
import io.reactivex.internal.operators.maybe.MaybeEmpty;
import io.reactivex.internal.operators.maybe.MaybeEqualSingle;
import io.reactivex.internal.operators.maybe.MaybeError;
import io.reactivex.internal.operators.maybe.MaybeErrorCallable;
import io.reactivex.internal.operators.maybe.MaybeFilter;
import io.reactivex.internal.operators.maybe.MaybeFlatMapBiSelector;
import io.reactivex.internal.operators.maybe.MaybeFlatMapCompletable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableFlowable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapIterableObservable;
import io.reactivex.internal.operators.maybe.MaybeFlatMapNotification;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingle;
import io.reactivex.internal.operators.maybe.MaybeFlatMapSingleElement;
import io.reactivex.internal.operators.maybe.MaybeFlatten;
import io.reactivex.internal.operators.maybe.MaybeFromAction;
import io.reactivex.internal.operators.maybe.MaybeFromCallable;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromFuture;
import io.reactivex.internal.operators.maybe.MaybeFromRunnable;
import io.reactivex.internal.operators.maybe.MaybeFromSingle;
import io.reactivex.internal.operators.maybe.MaybeHide;
import io.reactivex.internal.operators.maybe.MaybeIgnoreElementCompletable;
import io.reactivex.internal.operators.maybe.MaybeIsEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeJust;
import io.reactivex.internal.operators.maybe.MaybeLift;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeMergeArray;
import io.reactivex.internal.operators.maybe.MaybeNever;
import io.reactivex.internal.operators.maybe.MaybeObserveOn;
import io.reactivex.internal.operators.maybe.MaybeOnErrorComplete;
import io.reactivex.internal.operators.maybe.MaybeOnErrorNext;
import io.reactivex.internal.operators.maybe.MaybeOnErrorReturn;
import io.reactivex.internal.operators.maybe.MaybePeek;
import io.reactivex.internal.operators.maybe.MaybeSubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmpty;
import io.reactivex.internal.operators.maybe.MaybeSwitchIfEmptySingle;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilMaybe;
import io.reactivex.internal.operators.maybe.MaybeTakeUntilPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimeoutMaybe;
import io.reactivex.internal.operators.maybe.MaybeTimeoutPublisher;
import io.reactivex.internal.operators.maybe.MaybeTimer;
import io.reactivex.internal.operators.maybe.MaybeToFlowable;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.maybe.MaybeToPublisher;
import io.reactivex.internal.operators.maybe.MaybeToSingle;
import io.reactivex.internal.operators.maybe.MaybeUnsafeCreate;
import io.reactivex.internal.operators.maybe.MaybeUnsubscribeOn;
import io.reactivex.internal.operators.maybe.MaybeUsing;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import io.reactivex.internal.operators.maybe.MaybeZipIterable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Maybe<T> implements MaybeSource<T> {
    public abstract void subscribeActual(MaybeObserver<? super T> maybeObserver);

    public static <T> Maybe<T> amb(Iterable<? extends MaybeSource<? extends T>> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26740a(new MaybeAmb(null, iterable));
    }

    public static <T> Maybe<T> ambArray(MaybeSource<? extends T>... maybeSourceArr) {
        if (maybeSourceArr.length == 0) {
            return empty();
        }
        if (maybeSourceArr.length == 1) {
            return wrap(maybeSourceArr[0]);
        }
        return RxJavaPlugins.m26740a(new MaybeAmb(maybeSourceArr, null));
    }

    public static <T> Flowable<T> concat(Iterable<? extends MaybeSource<? extends T>> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26739a(new MaybeConcatIterable(iterable));
    }

    public static <T> Flowable<T> concat(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        return concatArray(maybeSource, maybeSource2);
    }

    public static <T> Flowable<T> concat(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        return concatArray(maybeSource, maybeSource2, maybeSource3);
    }

    public static <T> Flowable<T> concat(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3, MaybeSource<? extends T> maybeSource4) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        ObjectHelper.m26573a((Object) maybeSource4, "source4 is null");
        return concatArray(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    public static <T> Flowable<T> concat(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return concat((Publisher) publisher, 2);
    }

    public static <T> Flowable<T> concat(Publisher<? extends MaybeSource<? extends T>> publisher, int i) {
        ObjectHelper.m26573a((Object) publisher, "sources is null");
        ObjectHelper.m26569a(i, "prefetch");
        return RxJavaPlugins.m26739a(new FlowableConcatMapPublisher(publisher, MaybeToPublisher.m32335a(), i, ErrorMode.IMMEDIATE));
    }

    public static <T> Flowable<T> concatArray(MaybeSource<? extends T>... maybeSourceArr) {
        ObjectHelper.m26573a((Object) maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return Flowable.empty();
        }
        if (maybeSourceArr.length == 1) {
            return RxJavaPlugins.m26739a(new MaybeToFlowable(maybeSourceArr[0]));
        }
        return RxJavaPlugins.m26739a(new MaybeConcatArray(maybeSourceArr));
    }

    public static <T> Flowable<T> concatArrayDelayError(MaybeSource<? extends T>... maybeSourceArr) {
        if (maybeSourceArr.length == 0) {
            return Flowable.empty();
        }
        if (maybeSourceArr.length == 1) {
            return RxJavaPlugins.m26739a(new MaybeToFlowable(maybeSourceArr[0]));
        }
        return RxJavaPlugins.m26739a(new MaybeConcatArrayDelayError(maybeSourceArr));
    }

    public static <T> Flowable<T> concatArrayEager(MaybeSource<? extends T>... maybeSourceArr) {
        return Flowable.fromArray(maybeSourceArr).concatMapEager(MaybeToPublisher.m32335a());
    }

    public static <T> Flowable<T> concatDelayError(Iterable<? extends MaybeSource<? extends T>> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return Flowable.fromIterable(iterable).concatMapDelayError(MaybeToPublisher.m32335a());
    }

    public static <T> Flowable<T> concatDelayError(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return Flowable.fromPublisher(publisher).concatMapDelayError(MaybeToPublisher.m32335a());
    }

    public static <T> Flowable<T> concatEager(Iterable<? extends MaybeSource<? extends T>> iterable) {
        return Flowable.fromIterable(iterable).concatMapEager(MaybeToPublisher.m32335a());
    }

    public static <T> Flowable<T> concatEager(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return Flowable.fromPublisher(publisher).concatMapEager(MaybeToPublisher.m32335a());
    }

    public static <T> Maybe<T> create(MaybeOnSubscribe<T> maybeOnSubscribe) {
        ObjectHelper.m26573a((Object) maybeOnSubscribe, "onSubscribe is null");
        return RxJavaPlugins.m26740a(new MaybeCreate(maybeOnSubscribe));
    }

    public static <T> Maybe<T> defer(Callable<? extends MaybeSource<? extends T>> callable) {
        ObjectHelper.m26573a((Object) callable, "maybeSupplier is null");
        return RxJavaPlugins.m26740a(new MaybeDefer(callable));
    }

    public static <T> Maybe<T> empty() {
        return RxJavaPlugins.m26740a(MaybeEmpty.f35567a);
    }

    public static <T> Maybe<T> error(Throwable th) {
        ObjectHelper.m26573a((Object) th, "exception is null");
        return RxJavaPlugins.m26740a(new MaybeError(th));
    }

    public static <T> Maybe<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.m26573a((Object) callable, "errorSupplier is null");
        return RxJavaPlugins.m26740a(new MaybeErrorCallable(callable));
    }

    public static <T> Maybe<T> fromAction(Action action) {
        ObjectHelper.m26573a((Object) action, "run is null");
        return RxJavaPlugins.m26740a(new MaybeFromAction(action));
    }

    public static <T> Maybe<T> fromCompletable(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "completableSource is null");
        return RxJavaPlugins.m26740a(new MaybeFromCompletable(completableSource));
    }

    public static <T> Maybe<T> fromSingle(SingleSource<T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "singleSource is null");
        return RxJavaPlugins.m26740a(new MaybeFromSingle(singleSource));
    }

    public static <T> Maybe<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.m26573a((Object) callable, "callable is null");
        return RxJavaPlugins.m26740a(new MaybeFromCallable(callable));
    }

    public static <T> Maybe<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.m26573a((Object) future, "future is null");
        return RxJavaPlugins.m26740a(new MaybeFromFuture(future, 0, null));
    }

    public static <T> Maybe<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        ObjectHelper.m26573a((Object) future, "future is null");
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        return RxJavaPlugins.m26740a(new MaybeFromFuture(future, j, timeUnit));
    }

    public static <T> Maybe<T> fromRunnable(Runnable runnable) {
        ObjectHelper.m26573a((Object) runnable, "run is null");
        return RxJavaPlugins.m26740a(new MaybeFromRunnable(runnable));
    }

    public static <T> Maybe<T> just(T t) {
        ObjectHelper.m26573a((Object) t, "item is null");
        return RxJavaPlugins.m26740a(new MaybeJust(t));
    }

    public static <T> Flowable<T> merge(Iterable<? extends MaybeSource<? extends T>> iterable) {
        return merge(Flowable.fromIterable(iterable));
    }

    public static <T> Flowable<T> merge(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return merge((Publisher) publisher, (int) RedditJobManager.f10810d);
    }

    public static <T> Flowable<T> merge(Publisher<? extends MaybeSource<? extends T>> publisher, int i) {
        ObjectHelper.m26573a((Object) publisher, "source is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        return RxJavaPlugins.m26739a(new FlowableFlatMapPublisher(publisher, MaybeToPublisher.m32335a(), false, i, Flowable.bufferSize()));
    }

    public static <T> Maybe<T> merge(MaybeSource<? extends MaybeSource<? extends T>> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "source is null");
        return RxJavaPlugins.m26740a(new MaybeFlatten(maybeSource, Functions.m26541a()));
    }

    public static <T> Flowable<T> merge(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        return mergeArray(maybeSource, maybeSource2);
    }

    public static <T> Flowable<T> merge(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        return mergeArray(maybeSource, maybeSource2, maybeSource3);
    }

    public static <T> Flowable<T> merge(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3, MaybeSource<? extends T> maybeSource4) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        ObjectHelper.m26573a((Object) maybeSource4, "source4 is null");
        return mergeArray(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    public static <T> Flowable<T> mergeArray(MaybeSource<? extends T>... maybeSourceArr) {
        ObjectHelper.m26573a((Object) maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return Flowable.empty();
        }
        if (maybeSourceArr.length == 1) {
            return RxJavaPlugins.m26739a(new MaybeToFlowable(maybeSourceArr[0]));
        }
        return RxJavaPlugins.m26739a(new MaybeMergeArray(maybeSourceArr));
    }

    public static <T> Flowable<T> mergeArrayDelayError(MaybeSource<? extends T>... maybeSourceArr) {
        if (maybeSourceArr.length == 0) {
            return Flowable.empty();
        }
        return Flowable.fromArray(maybeSourceArr).flatMap(MaybeToPublisher.m32335a(), true, maybeSourceArr.length);
    }

    public static <T> Flowable<T> mergeDelayError(Iterable<? extends MaybeSource<? extends T>> iterable) {
        return Flowable.fromIterable(iterable).flatMap(MaybeToPublisher.m32335a(), true);
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends MaybeSource<? extends T>> publisher) {
        return Flowable.fromPublisher(publisher).flatMap(MaybeToPublisher.m32335a(), true);
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends MaybeSource<? extends T>> publisher, int i) {
        return Flowable.fromPublisher(publisher).flatMap(MaybeToPublisher.m32335a(), true, i);
    }

    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        return mergeArrayDelayError(maybeSource, maybeSource2);
    }

    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        return mergeArrayDelayError(maybeSource, maybeSource2, maybeSource3);
    }

    public static <T> Flowable<T> mergeDelayError(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, MaybeSource<? extends T> maybeSource3, MaybeSource<? extends T> maybeSource4) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        ObjectHelper.m26573a((Object) maybeSource4, "source4 is null");
        return mergeArrayDelayError(maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    public static <T> Maybe<T> never() {
        return RxJavaPlugins.m26740a(MaybeNever.f35601a);
    }

    public static <T> Single<Boolean> sequenceEqual(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
        return sequenceEqual(maybeSource, maybeSource2, ObjectHelper.m26572a());
    }

    public static <T> Single<Boolean> sequenceEqual(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) biPredicate, "isEqual is null");
        return RxJavaPlugins.m26747a(new MaybeEqualSingle(maybeSource, maybeSource2, biPredicate));
    }

    public static Maybe<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.m26770a());
    }

    public static Maybe<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26740a(new MaybeTimer(Math.max(0, j), timeUnit, scheduler));
    }

    public static <T> Maybe<T> unsafeCreate(MaybeSource<T> maybeSource) {
        if (maybeSource instanceof Maybe) {
            throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
        }
        ObjectHelper.m26573a((Object) maybeSource, "onSubscribe is null");
        return RxJavaPlugins.m26740a(new MaybeUnsafeCreate(maybeSource));
    }

    public static <T, D> Maybe<T> using(Callable<? extends D> callable, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T, D> Maybe<T> using(Callable<? extends D> callable, Function<? super D, ? extends MaybeSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        ObjectHelper.m26573a((Object) callable, "resourceSupplier is null");
        ObjectHelper.m26573a((Object) function, "sourceSupplier is null");
        ObjectHelper.m26573a((Object) consumer, "disposer is null");
        return RxJavaPlugins.m26740a(new MaybeUsing(callable, function, consumer, z));
    }

    public static <T> Maybe<T> wrap(MaybeSource<T> maybeSource) {
        if (maybeSource instanceof Maybe) {
            return RxJavaPlugins.m26740a((Maybe) maybeSource);
        }
        ObjectHelper.m26573a((Object) maybeSource, "onSubscribe is null");
        return RxJavaPlugins.m26740a(new MaybeUnsafeCreate(maybeSource));
    }

    public static <T, R> Maybe<R> zip(Iterable<? extends MaybeSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.m26573a((Object) function, "zipper is null");
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26740a(new MaybeZipIterable(iterable, function));
    }

    public static <T1, T2, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        return zipArray(Functions.m26542a((BiFunction) biFunction), maybeSource, maybeSource2);
    }

    public static <T1, T2, T3, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        return zipArray(Functions.m26543a((Function3) function3), maybeSource, maybeSource2, maybeSource3);
    }

    public static <T1, T2, T3, T4, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        ObjectHelper.m26573a((Object) maybeSource4, "source4 is null");
        return zipArray(Functions.m26544a((Function4) function4), maybeSource, maybeSource2, maybeSource3, maybeSource4);
    }

    public static <T1, T2, T3, T4, T5, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        ObjectHelper.m26573a((Object) maybeSource4, "source4 is null");
        ObjectHelper.m26573a((Object) maybeSource5, "source5 is null");
        return zipArray(Functions.m26545a((Function5) function5), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        ObjectHelper.m26573a((Object) maybeSource4, "source4 is null");
        ObjectHelper.m26573a((Object) maybeSource5, "source5 is null");
        ObjectHelper.m26573a((Object) maybeSource6, "source6 is null");
        return zipArray(Functions.m26546a((Function6) function6), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, MaybeSource<? extends T7> maybeSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        ObjectHelper.m26573a((Object) maybeSource4, "source4 is null");
        ObjectHelper.m26573a((Object) maybeSource5, "source5 is null");
        ObjectHelper.m26573a((Object) maybeSource6, "source6 is null");
        ObjectHelper.m26573a((Object) maybeSource7, "source7 is null");
        return zipArray(Functions.m26547a((Function7) function7), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, MaybeSource<? extends T7> maybeSource7, MaybeSource<? extends T8> maybeSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        ObjectHelper.m26573a((Object) maybeSource4, "source4 is null");
        ObjectHelper.m26573a((Object) maybeSource5, "source5 is null");
        ObjectHelper.m26573a((Object) maybeSource6, "source6 is null");
        ObjectHelper.m26573a((Object) maybeSource7, "source7 is null");
        ObjectHelper.m26573a((Object) maybeSource8, "source8 is null");
        return zipArray(Functions.m26548a((Function8) function8), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Maybe<R> zip(MaybeSource<? extends T1> maybeSource, MaybeSource<? extends T2> maybeSource2, MaybeSource<? extends T3> maybeSource3, MaybeSource<? extends T4> maybeSource4, MaybeSource<? extends T5> maybeSource5, MaybeSource<? extends T6> maybeSource6, MaybeSource<? extends T7> maybeSource7, MaybeSource<? extends T8> maybeSource8, MaybeSource<? extends T9> maybeSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.m26573a((Object) maybeSource, "source1 is null");
        ObjectHelper.m26573a((Object) maybeSource2, "source2 is null");
        ObjectHelper.m26573a((Object) maybeSource3, "source3 is null");
        ObjectHelper.m26573a((Object) maybeSource4, "source4 is null");
        ObjectHelper.m26573a((Object) maybeSource5, "source5 is null");
        ObjectHelper.m26573a((Object) maybeSource6, "source6 is null");
        ObjectHelper.m26573a((Object) maybeSource7, "source7 is null");
        ObjectHelper.m26573a((Object) maybeSource8, "source8 is null");
        ObjectHelper.m26573a((Object) maybeSource9, "source9 is null");
        return zipArray(Functions.m26549a((Function9) function9), maybeSource, maybeSource2, maybeSource3, maybeSource4, maybeSource5, maybeSource6, maybeSource7, maybeSource8, maybeSource9);
    }

    public static <T, R> Maybe<R> zipArray(Function<? super Object[], ? extends R> function, MaybeSource<? extends T>... maybeSourceArr) {
        ObjectHelper.m26573a((Object) maybeSourceArr, "sources is null");
        if (maybeSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.m26573a((Object) function, "zipper is null");
        return RxJavaPlugins.m26740a(new MaybeZipArray(maybeSourceArr, function));
    }

    public final Maybe<T> ambWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "other is null");
        return ambArray(this, maybeSource);
    }

    public final <R> R as(MaybeConverter<T, ? extends R> maybeConverter) {
        return ((MaybeConverter) ObjectHelper.m26573a((Object) maybeConverter, "converter is null")).m26477a();
    }

    public final T blockingGet() {
        MaybeObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.m32116a();
    }

    public final T blockingGet(T t) {
        ObjectHelper.m26573a((Object) t, "defaultValue is null");
        MaybeObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.m32117a(t);
    }

    public final Maybe<T> cache() {
        return RxJavaPlugins.m26740a(new MaybeCache(this));
    }

    public final <U> Maybe<U> cast(Class<? extends U> cls) {
        ObjectHelper.m26573a((Object) cls, "clazz is null");
        return map(Functions.m26550a((Class) cls));
    }

    public final <R> Maybe<R> compose(MaybeTransformer<? super T, ? extends R> maybeTransformer) {
        return wrap(((MaybeTransformer) ObjectHelper.m26573a((Object) maybeTransformer, "transformer is null")).m26482a());
    }

    public final <R> Maybe<R> concatMap(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26740a(new MaybeFlatten(this, function));
    }

    public final Flowable<T> concatWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "other is null");
        return concat((MaybeSource) this, (MaybeSource) maybeSource);
    }

    public final Single<Boolean> contains(Object obj) {
        ObjectHelper.m26573a(obj, "item is null");
        return RxJavaPlugins.m26747a(new MaybeContains(this, obj));
    }

    public final Single<Long> count() {
        return RxJavaPlugins.m26747a(new MaybeCount(this));
    }

    public final Maybe<T> defaultIfEmpty(T t) {
        ObjectHelper.m26573a((Object) t, "item is null");
        return switchIfEmpty(just(t));
    }

    public final Maybe<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.m26770a());
    }

    public final Maybe<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26740a(new MaybeDelay(this, Math.max(0, j), timeUnit, scheduler));
    }

    public final <U, V> Maybe<T> delay(Publisher<U> publisher) {
        ObjectHelper.m26573a((Object) publisher, "delayIndicator is null");
        return RxJavaPlugins.m26740a(new MaybeDelayOtherPublisher(this, publisher));
    }

    public final <U> Maybe<T> delaySubscription(Publisher<U> publisher) {
        ObjectHelper.m26573a((Object) publisher, "subscriptionIndicator is null");
        return RxJavaPlugins.m26740a(new MaybeDelaySubscriptionOtherPublisher(this, publisher));
    }

    public final Maybe<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, Schedulers.m26770a());
    }

    public final Maybe<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(Flowable.timer(j, timeUnit, scheduler));
    }

    public final Maybe<T> doAfterSuccess(Consumer<? super T> consumer) {
        ObjectHelper.m26573a((Object) consumer, "doAfterSuccess is null");
        return RxJavaPlugins.m26740a(new MaybeDoAfterSuccess(this, consumer));
    }

    public final Maybe<T> doAfterTerminate(Action action) {
        return RxJavaPlugins.m26740a(new MaybePeek(this, Functions.m26556b(), Functions.m26556b(), Functions.m26556b(), Functions.f25014c, (Action) ObjectHelper.m26573a((Object) action, "onAfterTerminate is null"), Functions.f25014c));
    }

    public final Maybe<T> doFinally(Action action) {
        ObjectHelper.m26573a((Object) action, "onFinally is null");
        return RxJavaPlugins.m26740a(new MaybeDoFinally(this, action));
    }

    public final Maybe<T> doOnDispose(Action action) {
        return RxJavaPlugins.m26740a(new MaybePeek(this, Functions.m26556b(), Functions.m26556b(), Functions.m26556b(), Functions.f25014c, Functions.f25014c, (Action) ObjectHelper.m26573a((Object) action, "onDispose is null")));
    }

    public final Maybe<T> doOnComplete(Action action) {
        return RxJavaPlugins.m26740a(new MaybePeek(this, Functions.m26556b(), Functions.m26556b(), Functions.m26556b(), (Action) ObjectHelper.m26573a((Object) action, "onComplete is null"), Functions.f25014c, Functions.f25014c));
    }

    public final Maybe<T> doOnError(Consumer<? super Throwable> consumer) {
        return RxJavaPlugins.m26740a(new MaybePeek(this, Functions.m26556b(), Functions.m26556b(), (Consumer) ObjectHelper.m26573a((Object) consumer, "onError is null"), Functions.f25014c, Functions.f25014c, Functions.f25014c));
    }

    public final Maybe<T> doOnEvent(BiConsumer<? super T, ? super Throwable> biConsumer) {
        ObjectHelper.m26573a((Object) biConsumer, "onEvent is null");
        return RxJavaPlugins.m26740a(new MaybeDoOnEvent(this, biConsumer));
    }

    public final Maybe<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        return RxJavaPlugins.m26740a(new MaybePeek(this, (Consumer) ObjectHelper.m26573a((Object) consumer, "onSubscribe is null"), Functions.m26556b(), Functions.m26556b(), Functions.f25014c, Functions.f25014c, Functions.f25014c));
    }

    public final Maybe<T> doOnSuccess(Consumer<? super T> consumer) {
        return RxJavaPlugins.m26740a(new MaybePeek(this, Functions.m26556b(), (Consumer) ObjectHelper.m26573a((Object) consumer, "onSubscribe is null"), Functions.m26556b(), Functions.f25014c, Functions.f25014c, Functions.f25014c));
    }

    public final Maybe<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26740a(new MaybeFilter(this, predicate));
    }

    public final <R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26740a(new MaybeFlatten(this, function));
    }

    public final <R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
        ObjectHelper.m26573a((Object) function, "onSuccessMapper is null");
        ObjectHelper.m26573a((Object) function2, "onErrorMapper is null");
        ObjectHelper.m26573a((Object) callable, "onCompleteSupplier is null");
        return RxJavaPlugins.m26740a(new MaybeFlatMapNotification(this, function, function2, callable));
    }

    public final <U, R> Maybe<R> flatMap(Function<? super T, ? extends MaybeSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26573a((Object) biFunction, "resultSelector is null");
        return RxJavaPlugins.m26740a(new MaybeFlatMapBiSelector(this, function, biFunction));
    }

    public final <U> Flowable<U> flattenAsFlowable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26739a(new MaybeFlatMapIterableFlowable(this, function));
    }

    public final <U> Observable<U> flattenAsObservable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26742a(new MaybeFlatMapIterableObservable(this, function));
    }

    public final <R> Observable<R> flatMapObservable(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return toObservable().flatMap(function);
    }

    public final <R> Flowable<R> flatMapPublisher(Function<? super T, ? extends Publisher<? extends R>> function) {
        return toFlowable().flatMap(function);
    }

    public final <R> Single<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26747a(new MaybeFlatMapSingle(this, function));
    }

    public final <R> Maybe<R> flatMapSingleElement(Function<? super T, ? extends SingleSource<? extends R>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26740a(new MaybeFlatMapSingleElement(this, function));
    }

    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26737a(new MaybeFlatMapCompletable(this, function));
    }

    public final Maybe<T> hide() {
        return RxJavaPlugins.m26740a(new MaybeHide(this));
    }

    public final Completable ignoreElement() {
        return RxJavaPlugins.m26737a(new MaybeIgnoreElementCompletable(this));
    }

    public final Single<Boolean> isEmpty() {
        return RxJavaPlugins.m26747a(new MaybeIsEmptySingle(this));
    }

    public final <R> Maybe<R> lift(MaybeOperator<? extends R, ? super T> maybeOperator) {
        ObjectHelper.m26573a((Object) maybeOperator, "onLift is null");
        return RxJavaPlugins.m26740a(new MaybeLift(this, maybeOperator));
    }

    public final <R> Maybe<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26740a(new MaybeMap(this, function));
    }

    public final Flowable<T> mergeWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "other is null");
        return merge((MaybeSource) this, (MaybeSource) maybeSource);
    }

    public final Maybe<T> observeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26740a(new MaybeObserveOn(this, scheduler));
    }

    public final <U> Maybe<U> ofType(Class<U> cls) {
        ObjectHelper.m26573a((Object) cls, "clazz is null");
        return filter(Functions.m26559b((Class) cls)).cast(cls);
    }

    public final <R> R to(Function<? super Maybe<T>, R> function) {
        try {
            return ((Function) ObjectHelper.m26573a((Object) function, "convert is null")).apply(this);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            function = ExceptionHelper.m26682a(th);
        }
    }

    public final Flowable<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).mo6616a();
        }
        return RxJavaPlugins.m26739a(new MaybeToFlowable(this));
    }

    public final Observable<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).mo6641a();
        }
        return RxJavaPlugins.m26742a(new MaybeToObservable(this));
    }

    public final Single<T> toSingle(T t) {
        ObjectHelper.m26573a((Object) t, "defaultValue is null");
        return RxJavaPlugins.m26747a(new MaybeToSingle(this, t));
    }

    public final Single<T> toSingle() {
        return RxJavaPlugins.m26747a(new MaybeToSingle(this, null));
    }

    public final Maybe<T> onErrorComplete() {
        return onErrorComplete(Functions.m26561c());
    }

    public final Maybe<T> onErrorComplete(Predicate<? super Throwable> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26740a(new MaybeOnErrorComplete(this, predicate));
    }

    public final Maybe<T> onErrorResumeNext(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "next is null");
        return onErrorResumeNext(Functions.m26558b((Object) maybeSource));
    }

    public final Maybe<T> onErrorResumeNext(Function<? super Throwable, ? extends MaybeSource<? extends T>> function) {
        ObjectHelper.m26573a((Object) function, "resumeFunction is null");
        return RxJavaPlugins.m26740a(new MaybeOnErrorNext(this, function, true));
    }

    public final Maybe<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.m26573a((Object) function, "valueSupplier is null");
        return RxJavaPlugins.m26740a(new MaybeOnErrorReturn(this, function));
    }

    public final Maybe<T> onErrorReturnItem(T t) {
        ObjectHelper.m26573a((Object) t, "item is null");
        return onErrorReturn(Functions.m26558b((Object) t));
    }

    public final Maybe<T> onExceptionResumeNext(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "next is null");
        return RxJavaPlugins.m26740a(new MaybeOnErrorNext(this, Functions.m26558b((Object) maybeSource), false));
    }

    public final Maybe<T> onTerminateDetach() {
        return RxJavaPlugins.m26740a(new MaybeDetach(this));
    }

    public final Flowable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final Flowable<T> repeat(long j) {
        return toFlowable().repeat(j);
    }

    public final Flowable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        return toFlowable().repeatUntil(booleanSupplier);
    }

    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return toFlowable().repeatWhen(function);
    }

    public final Maybe<T> retry() {
        return retry(Long.MAX_VALUE, Functions.m26561c());
    }

    public final Maybe<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return toFlowable().retry((BiPredicate) biPredicate).singleElement();
    }

    public final Maybe<T> retry(long j) {
        return retry(j, Functions.m26561c());
    }

    public final Maybe<T> retry(long j, Predicate<? super Throwable> predicate) {
        return toFlowable().retry(j, predicate).singleElement();
    }

    public final Maybe<T> retry(Predicate<? super Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    public final Maybe<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.m26573a((Object) booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, Functions.m26553a(booleanSupplier));
    }

    public final Maybe<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return toFlowable().retryWhen(function).singleElement();
    }

    public final Disposable subscribe() {
        return subscribe(Functions.m26556b(), Functions.f25017f, Functions.f25014c);
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.f25017f, Functions.f25014c);
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.f25014c);
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObjectHelper.m26573a((Object) consumer, "onSuccess is null");
        ObjectHelper.m26573a((Object) consumer2, "onError is null");
        ObjectHelper.m26573a((Object) action, "onComplete is null");
        return (Disposable) subscribeWith(new MaybeCallbackObserver(consumer, consumer2, action));
    }

    public final void subscribe(MaybeObserver<? super T> maybeObserver) {
        ObjectHelper.m26573a((Object) maybeObserver, "observer is null");
        Object a = RxJavaPlugins.m26741a(this, (MaybeObserver) maybeObserver);
        ObjectHelper.m26573a(a, "observer returned by the RxJavaPlugins hook is null");
        try {
            subscribeActual(a);
        } catch (MaybeObserver<? super T> maybeObserver2) {
            throw maybeObserver2;
        } catch (MaybeObserver<? super T> maybeObserver22) {
            Exceptions.m26521b(maybeObserver22);
            new NullPointerException("subscribeActual failed").initCause(maybeObserver22);
        }
    }

    public final Maybe<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26740a(new MaybeSubscribeOn(this, scheduler));
    }

    public final <E extends MaybeObserver<? super T>> E subscribeWith(E e) {
        subscribe((MaybeObserver) e);
        return e;
    }

    public final Maybe<T> switchIfEmpty(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "other is null");
        return RxJavaPlugins.m26740a(new MaybeSwitchIfEmpty(this, maybeSource));
    }

    public final Single<T> switchIfEmpty(SingleSource<? extends T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "other is null");
        return RxJavaPlugins.m26747a(new MaybeSwitchIfEmptySingle(this, singleSource));
    }

    public final <U> Maybe<T> takeUntil(MaybeSource<U> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "other is null");
        return RxJavaPlugins.m26740a(new MaybeTakeUntilMaybe(this, maybeSource));
    }

    public final <U> Maybe<T> takeUntil(Publisher<U> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return RxJavaPlugins.m26740a(new MaybeTakeUntilPublisher(this, publisher));
    }

    public final Maybe<T> timeout(long j, TimeUnit timeUnit) {
        return timeout(j, timeUnit, Schedulers.m26770a());
    }

    public final Maybe<T> timeout(long j, TimeUnit timeUnit, MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "other is null");
        return timeout(j, timeUnit, Schedulers.m26770a(), maybeSource);
    }

    public final Maybe<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "fallback is null");
        return timeout(timer(j, timeUnit, scheduler), (MaybeSource) maybeSource);
    }

    public final Maybe<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout(timer(j, timeUnit, scheduler));
    }

    public final <U> Maybe<T> timeout(MaybeSource<U> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "timeoutIndicator is null");
        return RxJavaPlugins.m26740a(new MaybeTimeoutMaybe(this, maybeSource, null));
    }

    public final <U> Maybe<T> timeout(MaybeSource<U> maybeSource, MaybeSource<? extends T> maybeSource2) {
        ObjectHelper.m26573a((Object) maybeSource, "timeoutIndicator is null");
        ObjectHelper.m26573a((Object) maybeSource2, "fallback is null");
        return RxJavaPlugins.m26740a(new MaybeTimeoutMaybe(this, maybeSource, maybeSource2));
    }

    public final <U> Maybe<T> timeout(Publisher<U> publisher) {
        ObjectHelper.m26573a((Object) publisher, "timeoutIndicator is null");
        return RxJavaPlugins.m26740a(new MaybeTimeoutPublisher(this, publisher, null));
    }

    public final <U> Maybe<T> timeout(Publisher<U> publisher, MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) publisher, "timeoutIndicator is null");
        ObjectHelper.m26573a((Object) maybeSource, "fallback is null");
        return RxJavaPlugins.m26740a(new MaybeTimeoutPublisher(this, publisher, maybeSource));
    }

    public final Maybe<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26740a(new MaybeUnsubscribeOn(this, scheduler));
    }

    public final <U, R> Maybe<R> zipWith(MaybeSource<? extends U> maybeSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) maybeSource, "other is null");
        return zip(this, maybeSource, biFunction);
    }

    public final TestObserver<T> test() {
        MaybeObserver testObserver = new TestObserver();
        subscribe(testObserver);
        return testObserver;
    }

    public final TestObserver<T> test(boolean z) {
        MaybeObserver testObserver = new TestObserver();
        if (z) {
            testObserver.m36021c();
        }
        subscribe(testObserver);
        return testObserver;
    }
}
