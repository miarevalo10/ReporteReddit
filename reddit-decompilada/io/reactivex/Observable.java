package io.reactivex;

import com.coremedia.iso.boxes.FreeSpaceBox;
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
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.observers.BlockingFirstObserver;
import io.reactivex.internal.observers.BlockingLastObserver;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.FutureObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableFromObservable;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.BlockingObservableLatest;
import io.reactivex.internal.operators.observable.BlockingObservableMostRecent;
import io.reactivex.internal.operators.observable.BlockingObservableNext;
import io.reactivex.internal.operators.observable.ObservableAllSingle;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableAnySingle;
import io.reactivex.internal.operators.observable.ObservableBlockingSubscribe;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableBufferExactBoundary;
import io.reactivex.internal.operators.observable.ObservableBufferTimed;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCollectSingle;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCountSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounce;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDefer;
import io.reactivex.internal.operators.observable.ObservableDelay;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.observable.ObservableDematerialize;
import io.reactivex.internal.operators.observable.ObservableDetach;
import io.reactivex.internal.operators.observable.ObservableDistinct;
import io.reactivex.internal.operators.observable.ObservableDistinctUntilChanged;
import io.reactivex.internal.operators.observable.ObservableDoAfterNext;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableDoOnEach;
import io.reactivex.internal.operators.observable.ObservableDoOnLifecycle;
import io.reactivex.internal.operators.observable.ObservableElementAtMaybe;
import io.reactivex.internal.operators.observable.ObservableElementAtSingle;
import io.reactivex.internal.operators.observable.ObservableEmpty;
import io.reactivex.internal.operators.observable.ObservableError;
import io.reactivex.internal.operators.observable.ObservableFilter;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableFlattenIterable;
import io.reactivex.internal.operators.observable.ObservableFromArray;
import io.reactivex.internal.operators.observable.ObservableFromCallable;
import io.reactivex.internal.operators.observable.ObservableFromFuture;
import io.reactivex.internal.operators.observable.ObservableFromIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.operators.observable.ObservableFromUnsafeSource;
import io.reactivex.internal.operators.observable.ObservableGenerate;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableHide;
import io.reactivex.internal.operators.observable.ObservableIgnoreElements;
import io.reactivex.internal.operators.observable.ObservableIgnoreElementsCompletable;
import io.reactivex.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableJust;
import io.reactivex.internal.operators.observable.ObservableLastMaybe;
import io.reactivex.internal.operators.observable.ObservableLastSingle;
import io.reactivex.internal.operators.observable.ObservableLift;
import io.reactivex.internal.operators.observable.ObservableMap;
import io.reactivex.internal.operators.observable.ObservableMapNotification;
import io.reactivex.internal.operators.observable.ObservableMaterialize;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableNever;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservableOnErrorNext;
import io.reactivex.internal.operators.observable.ObservableOnErrorReturn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableReduceMaybe;
import io.reactivex.internal.operators.observable.ObservableReduceSeedSingle;
import io.reactivex.internal.operators.observable.ObservableReduceWithSingle;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableScan;
import io.reactivex.internal.operators.observable.ObservableScanSeed;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSerialized;
import io.reactivex.internal.operators.observable.ObservableSingleMaybe;
import io.reactivex.internal.operators.observable.ObservableSingleSingle;
import io.reactivex.internal.operators.observable.ObservableSkip;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSkipUntil;
import io.reactivex.internal.operators.observable.ObservableSkipWhile;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchIfEmpty;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTake;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastOne;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableTakeUntilPredicate;
import io.reactivex.internal.operators.observable.ObservableTakeWhile;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableTimeInterval;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableToList;
import io.reactivex.internal.operators.observable.ObservableToListSingle;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySelector;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.operators.observable.ObservableZipIterable;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.observers.SafeObserver;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Observable<T> implements ObservableSource<T> {
    public abstract void subscribeActual(Observer<? super T> observer);

    public static <T> Observable<T> amb(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26742a(new ObservableAmb(null, iterable));
    }

    public static <T> Observable<T> ambArray(ObservableSource<? extends T>... observableSourceArr) {
        ObjectHelper.m26573a((Object) observableSourceArr, "sources is null");
        int length = observableSourceArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return RxJavaPlugins.m26742a(new ObservableAmb(observableSourceArr, null));
    }

    public static int bufferSize() {
        return Flowable.bufferSize();
    }

    public static <T, R> Observable<R> combineLatest(Function<? super Object[], ? extends R> function, int i, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatest((ObservableSource[]) observableSourceArr, (Function) function, i);
    }

    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatest((Iterable) iterable, (Function) function, bufferSize());
    }

    public static <T, R> Observable<R> combineLatest(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        ObjectHelper.m26573a((Object) function, "combiner is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableCombineLatest(null, iterable, function, i << 1, false));
    }

    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatest((ObservableSource[]) observableSourceArr, (Function) function, bufferSize());
    }

    public static <T, R> Observable<R> combineLatest(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.m26573a((Object) observableSourceArr, "sources is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.m26573a((Object) function, "combiner is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableCombineLatest(observableSourceArr, null, function, i << 1, false));
    }

    public static <T1, T2, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        return combineLatest(Functions.m26542a((BiFunction) biFunction), bufferSize(), observableSource, observableSource2);
    }

    public static <T1, T2, T3, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        return combineLatest(Functions.m26543a((Function3) function3), bufferSize(), observableSource, observableSource2, observableSource3);
    }

    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        return combineLatest(Functions.m26544a((Function4) function4), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        ObjectHelper.m26573a((Object) observableSource5, "source5 is null");
        return combineLatest(Functions.m26545a((Function5) function5), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        ObjectHelper.m26573a((Object) observableSource5, "source5 is null");
        ObjectHelper.m26573a((Object) observableSource6, "source6 is null");
        return combineLatest(Functions.m26546a((Function6) function6), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        ObjectHelper.m26573a((Object) observableSource5, "source5 is null");
        ObjectHelper.m26573a((Object) observableSource6, "source6 is null");
        ObjectHelper.m26573a((Object) observableSource7, "source7 is null");
        return combineLatest(Functions.m26547a((Function7) function7), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        ObjectHelper.m26573a((Object) observableSource5, "source5 is null");
        ObjectHelper.m26573a((Object) observableSource6, "source6 is null");
        ObjectHelper.m26573a((Object) observableSource7, "source7 is null");
        ObjectHelper.m26573a((Object) observableSource8, "source8 is null");
        return combineLatest(Functions.m26548a((Function8) function8), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        ObjectHelper.m26573a((Object) observableSource5, "source5 is null");
        ObjectHelper.m26573a((Object) observableSource6, "source6 is null");
        ObjectHelper.m26573a((Object) observableSource7, "source7 is null");
        ObjectHelper.m26573a((Object) observableSource8, "source8 is null");
        ObjectHelper.m26573a((Object) observableSource9, "source9 is null");
        return combineLatest(Functions.m26549a((Function9) function9), bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError((ObservableSource[]) observableSourceArr, (Function) function, bufferSize());
    }

    public static <T, R> Observable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i, ObservableSource<? extends T>... observableSourceArr) {
        return combineLatestDelayError((ObservableSource[]) observableSourceArr, (Function) function, i);
    }

    public static <T, R> Observable<R> combineLatestDelayError(ObservableSource<? extends T>[] observableSourceArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.m26569a(i, "bufferSize");
        ObjectHelper.m26573a((Object) function, "combiner is null");
        if (observableSourceArr.length == 0) {
            return empty();
        }
        return RxJavaPlugins.m26742a(new ObservableCombineLatest(observableSourceArr, null, function, i << 1, true));
    }

    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError((Iterable) iterable, (Function) function, bufferSize());
    }

    public static <T, R> Observable<R> combineLatestDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        ObjectHelper.m26573a((Object) function, "combiner is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableCombineLatest(null, iterable, function, i << 1, true));
    }

    public static <T> Observable<T> concat(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.m26541a(), bufferSize(), false);
    }

    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concat((ObservableSource) observableSource, bufferSize());
    }

    public static <T> Observable<T> concat(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.m26573a((Object) observableSource, "sources is null");
        ObjectHelper.m26569a(i, "prefetch");
        return RxJavaPlugins.m26742a(new ObservableConcatMap(observableSource, Functions.m26541a(), i, ErrorMode.IMMEDIATE));
    }

    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        return concatArray(observableSource, observableSource2);
    }

    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        return concatArray(observableSource, observableSource2, observableSource3);
    }

    public static <T> Observable<T> concat(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        return concatArray(observableSource, observableSource2, observableSource3, observableSource4);
    }

    public static <T> Observable<T> concatArray(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return RxJavaPlugins.m26742a(new ObservableConcatMap(fromArray(observableSourceArr), Functions.m26541a(), bufferSize(), ErrorMode.BOUNDARY));
    }

    public static <T> Observable<T> concatArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        if (observableSourceArr.length == 1) {
            return wrap(observableSourceArr[0]);
        }
        return concatDelayError(fromArray(observableSourceArr));
    }

    public static <T> Observable<T> concatArrayEager(ObservableSource<? extends T>... observableSourceArr) {
        return concatArrayEager(bufferSize(), bufferSize(), observableSourceArr);
    }

    public static <T> Observable<T> concatArrayEager(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).concatMapEagerDelayError(Functions.m26541a(), i, i2, false);
    }

    public static <T> Observable<T> concatDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatDelayError(observableSource, bufferSize(), true);
    }

    public static <T> Observable<T> concatDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i, boolean z) {
        ObjectHelper.m26573a((Object) observableSource, "sources is null");
        ObjectHelper.m26569a(i, "prefetch is null");
        return RxJavaPlugins.m26742a(new ObservableConcatMap(observableSource, Functions.m26541a(), i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return concatEager((ObservableSource) observableSource, bufferSize(), bufferSize());
    }

    public static <T> Observable<T> concatEager(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i, int i2) {
        ObjectHelper.m26573a(Integer.valueOf(i), "maxConcurrency is null");
        ObjectHelper.m26573a(Integer.valueOf(i2), "prefetch is null");
        return wrap(observableSource).concatMapEager(Functions.m26541a(), i, i2);
    }

    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return concatEager((Iterable) iterable, bufferSize(), bufferSize());
    }

    public static <T> Observable<T> concatEager(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        ObjectHelper.m26573a(Integer.valueOf(i), "maxConcurrency is null");
        ObjectHelper.m26573a(Integer.valueOf(i2), "prefetch is null");
        return fromIterable(iterable).concatMapEagerDelayError(Functions.m26541a(), i, i2, false);
    }

    public static <T> Observable<T> create(ObservableOnSubscribe<T> observableOnSubscribe) {
        ObjectHelper.m26573a((Object) observableOnSubscribe, "source is null");
        return RxJavaPlugins.m26742a(new ObservableCreate(observableOnSubscribe));
    }

    public static <T> Observable<T> defer(Callable<? extends ObservableSource<? extends T>> callable) {
        ObjectHelper.m26573a((Object) callable, "supplier is null");
        return RxJavaPlugins.m26742a(new ObservableDefer(callable));
    }

    public static <T> Observable<T> empty() {
        return RxJavaPlugins.m26742a(ObservableEmpty.f35667a);
    }

    public static <T> Observable<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.m26573a((Object) callable, "errorSupplier is null");
        return RxJavaPlugins.m26742a(new ObservableError(callable));
    }

    public static <T> Observable<T> error(Throwable th) {
        ObjectHelper.m26573a((Object) th, "e is null");
        return error(Functions.m26555a((Object) th));
    }

    public static <T> Observable<T> fromArray(T... tArr) {
        ObjectHelper.m26573a((Object) tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return RxJavaPlugins.m26742a(new ObservableFromArray(tArr));
    }

    public static <T> Observable<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.m26573a((Object) callable, "supplier is null");
        return RxJavaPlugins.m26742a(new ObservableFromCallable(callable));
    }

    public static <T> Observable<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.m26573a((Object) future, "future is null");
        return RxJavaPlugins.m26742a(new ObservableFromFuture(future, 0, null));
    }

    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        ObjectHelper.m26573a((Object) future, "future is null");
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        return RxJavaPlugins.m26742a(new ObservableFromFuture(future, j, timeUnit));
    }

    public static <T> Observable<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(scheduler);
    }

    public static <T> Observable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    public static <T> Observable<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.m26573a((Object) iterable, "source is null");
        return RxJavaPlugins.m26742a(new ObservableFromIterable(iterable));
    }

    public static <T> Observable<T> fromPublisher(Publisher<? extends T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "publisher is null");
        return RxJavaPlugins.m26742a(new ObservableFromPublisher(publisher));
    }

    public static <T> Observable<T> generate(Consumer<Emitter<T>> consumer) {
        ObjectHelper.m26573a((Object) consumer, "generator  is null");
        return generate(Functions.m26564e(), ObservableInternalHelper.m26627a((Consumer) consumer), Functions.m26556b());
    }

    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        ObjectHelper.m26573a((Object) biConsumer, "generator  is null");
        return generate((Callable) callable, ObservableInternalHelper.m26626a((BiConsumer) biConsumer), Functions.m26556b());
    }

    public static <T, S> Observable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        ObjectHelper.m26573a((Object) biConsumer, "generator  is null");
        return generate((Callable) callable, ObservableInternalHelper.m26626a((BiConsumer) biConsumer), (Consumer) consumer);
    }

    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return generate((Callable) callable, (BiFunction) biFunction, Functions.m26556b());
    }

    public static <T, S> Observable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.m26573a((Object) callable, "initialState is null");
        ObjectHelper.m26573a((Object) biFunction, "generator  is null");
        ObjectHelper.m26573a((Object) consumer, "disposeState is null");
        return RxJavaPlugins.m26742a(new ObservableGenerate(callable, biFunction, consumer));
    }

    public static Observable<Long> interval(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, Schedulers.m26770a());
    }

    public static Observable<Long> interval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26742a(new ObservableInterval(Math.max(0, j), Math.max(0, j2), timeUnit, scheduler));
    }

    public static Observable<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, Schedulers.m26770a());
    }

    public static Observable<Long> interval(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j, j, timeUnit, scheduler);
    }

    public static Observable<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        return intervalRange(j, j2, j3, j4, timeUnit, Schedulers.m26770a());
    }

    public static Observable<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
        long j5 = j2;
        long j6 = j3;
        Object obj = timeUnit;
        Object obj2 = scheduler;
        int i = (j5 > 0 ? 1 : (j5 == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
            stringBuilder.append(j5);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i == 0) {
            return empty().delay(j6, (TimeUnit) obj, (Scheduler) obj2);
        } else {
            j5 = (j5 - 1) + j;
            if (j <= 0 || j5 >= 0) {
                ObjectHelper.m26573a(obj, "unit is null");
                ObjectHelper.m26573a(obj2, "scheduler is null");
                return RxJavaPlugins.m26742a(new ObservableIntervalRange(j, j5, Math.max(0, j6), Math.max(0, j4), obj, obj2));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    public static <T> Observable<T> just(T t) {
        ObjectHelper.m26573a((Object) t, "The item is null");
        return RxJavaPlugins.m26742a(new ObservableJust(t));
    }

    public static <T> Observable<T> just(T t, T t2) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        return fromArray(t, t2);
    }

    public static <T> Observable<T> just(T t, T t2, T t3) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        return fromArray(t, t2, t3);
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        return fromArray(t, t2, t3, t4);
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        ObjectHelper.m26573a((Object) t5, "The fifth item is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        ObjectHelper.m26573a((Object) t5, "The fifth item is null");
        ObjectHelper.m26573a((Object) t6, "The sixth item is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        ObjectHelper.m26573a((Object) t5, "The fifth item is null");
        ObjectHelper.m26573a((Object) t6, "The sixth item is null");
        ObjectHelper.m26573a((Object) t7, "The seventh item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        ObjectHelper.m26573a((Object) t5, "The fifth item is null");
        ObjectHelper.m26573a((Object) t6, "The sixth item is null");
        ObjectHelper.m26573a((Object) t7, "The seventh item is null");
        ObjectHelper.m26573a((Object) t8, "The eighth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        ObjectHelper.m26573a((Object) t5, "The fifth item is null");
        ObjectHelper.m26573a((Object) t6, "The sixth item is null");
        ObjectHelper.m26573a((Object) t7, "The seventh item is null");
        ObjectHelper.m26573a((Object) t8, "The eighth item is null");
        ObjectHelper.m26573a((Object) t9, "The ninth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    public static <T> Observable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        ObjectHelper.m26573a((Object) t5, "The fifth item is null");
        ObjectHelper.m26573a((Object) t6, "The sixth item is null");
        ObjectHelper.m26573a((Object) t7, "The seventh item is null");
        ObjectHelper.m26573a((Object) t8, "The eighth item is null");
        ObjectHelper.m26573a((Object) t9, "The ninth item is null");
        ObjectHelper.m26573a((Object) t10, "The tenth item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.m26541a(), false, i, i2);
    }

    public static <T> Observable<T> mergeArray(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.m26541a(), false, i, i2);
    }

    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.m26541a());
    }

    public static <T> Observable<T> merge(Iterable<? extends ObservableSource<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.m26541a(), i);
    }

    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "sources is null");
        return RxJavaPlugins.m26742a(new ObservableFlatMap(observableSource, Functions.m26541a(), false, RedditJobManager.f10810d, bufferSize()));
    }

    public static <T> Observable<T> merge(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.m26573a((Object) observableSource, "sources is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        return RxJavaPlugins.m26742a(new ObservableFlatMap(observableSource, Functions.m26541a(), false, i, bufferSize()));
    }

    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.m26541a(), false, 2);
    }

    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.m26541a(), false, 3);
    }

    public static <T> Observable<T> merge(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.m26541a(), false, 4);
    }

    public static <T> Observable<T> mergeArray(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.m26541a(), observableSourceArr.length);
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.m26541a(), true);
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.m26541a(), true, i, i2);
    }

    public static <T> Observable<T> mergeArrayDelayError(int i, int i2, ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.m26541a(), true, i, i2);
    }

    public static <T> Observable<T> mergeDelayError(Iterable<? extends ObservableSource<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.m26541a(), true, i);
    }

    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "sources is null");
        return RxJavaPlugins.m26742a(new ObservableFlatMap(observableSource, Functions.m26541a(), true, RedditJobManager.f10810d, bufferSize()));
    }

    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.m26573a((Object) observableSource, "sources is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        return RxJavaPlugins.m26742a(new ObservableFlatMap(observableSource, Functions.m26541a(), true, i, bufferSize()));
    }

    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        return fromArray(observableSource, observableSource2).flatMap(Functions.m26541a(), true, 2);
    }

    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        return fromArray(observableSource, observableSource2, observableSource3).flatMap(Functions.m26541a(), true, 3);
    }

    public static <T> Observable<T> mergeDelayError(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, ObservableSource<? extends T> observableSource3, ObservableSource<? extends T> observableSource4) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        return fromArray(observableSource, observableSource2, observableSource3, observableSource4).flatMap(Functions.m26541a(), true, 4);
    }

    public static <T> Observable<T> mergeArrayDelayError(ObservableSource<? extends T>... observableSourceArr) {
        return fromArray(observableSourceArr).flatMap(Functions.m26541a(), true, observableSourceArr.length);
    }

    public static <T> Observable<T> never() {
        return RxJavaPlugins.m26742a(ObservableNever.f35700a);
    }

    public static Observable<Integer> range(int i, int i2) {
        if (i2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
            stringBuilder.append(i2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i2 == 0) {
            return empty();
        } else {
            if (i2 == 1) {
                return just(Integer.valueOf(i));
            }
            if (((long) i) + ((long) (i2 - 1)) <= 2147483647L) {
                return RxJavaPlugins.m26742a(new ObservableRange(i, i2));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    public static Observable<Long> rangeLong(long j, long j2) {
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
            stringBuilder.append(j2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i == 0) {
            return empty();
        } else {
            if (j2 == 1) {
                return just(Long.valueOf(j));
            }
            long j3 = (j2 - 1) + j;
            if (j <= 0 || j3 >= 0) {
                return RxJavaPlugins.m26742a(new ObservableRangeLong(j, j2));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.m26572a(), bufferSize());
    }

    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(observableSource, observableSource2, biPredicate, bufferSize());
    }

    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) biPredicate, "isEqual is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26747a(new ObservableSequenceEqualSingle(observableSource, observableSource2, biPredicate, i));
    }

    public static <T> Single<Boolean> sequenceEqual(ObservableSource<? extends T> observableSource, ObservableSource<? extends T> observableSource2, int i) {
        return sequenceEqual(observableSource, observableSource2, ObjectHelper.m26572a(), i);
    }

    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.m26573a((Object) observableSource, "sources is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableSwitchMap(observableSource, Functions.m26541a(), i, false));
    }

    public static <T> Observable<T> switchOnNext(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNext(observableSource, bufferSize());
    }

    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource) {
        return switchOnNextDelayError(observableSource, bufferSize());
    }

    public static <T> Observable<T> switchOnNextDelayError(ObservableSource<? extends ObservableSource<? extends T>> observableSource, int i) {
        ObjectHelper.m26573a((Object) observableSource, "sources is null");
        ObjectHelper.m26569a(i, "prefetch");
        return RxJavaPlugins.m26742a(new ObservableSwitchMap(observableSource, Functions.m26541a(), i, true));
    }

    public static Observable<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.m26770a());
    }

    public static Observable<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26742a(new ObservableTimer(Math.max(j, 0), timeUnit, scheduler));
    }

    public static <T> Observable<T> unsafeCreate(ObservableSource<T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "source is null");
        ObjectHelper.m26573a((Object) observableSource, "onSubscribe is null");
        if (!(observableSource instanceof Observable)) {
            return RxJavaPlugins.m26742a(new ObservableFromUnsafeSource(observableSource));
        }
        throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
    }

    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T, D> Observable<T> using(Callable<? extends D> callable, Function<? super D, ? extends ObservableSource<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        ObjectHelper.m26573a((Object) callable, "resourceSupplier is null");
        ObjectHelper.m26573a((Object) function, "sourceSupplier is null");
        ObjectHelper.m26573a((Object) consumer, "disposer is null");
        return RxJavaPlugins.m26742a(new ObservableUsing(callable, function, consumer, z));
    }

    public static <T> Observable<T> wrap(ObservableSource<T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "source is null");
        if (observableSource instanceof Observable) {
            return RxJavaPlugins.m26742a((Observable) observableSource);
        }
        return RxJavaPlugins.m26742a(new ObservableFromUnsafeSource(observableSource));
    }

    public static <T, R> Observable<R> zip(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.m26573a((Object) function, "zipper is null");
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26742a(new ObservableZip(null, iterable, function, bufferSize(), false));
    }

    public static <T, R> Observable<R> zip(ObservableSource<? extends ObservableSource<? extends T>> observableSource, Function<? super Object[], ? extends R> function) {
        ObjectHelper.m26573a((Object) function, "zipper is null");
        ObjectHelper.m26573a((Object) observableSource, "sources is null");
        return RxJavaPlugins.m26742a(new ObservableToList(observableSource).flatMap(ObservableInternalHelper.m26640c((Function) function)));
    }

    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        return zipArray(Functions.m26542a((BiFunction) biFunction), false, bufferSize(), observableSource, observableSource2);
    }

    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        return zipArray(Functions.m26542a((BiFunction) biFunction), z, bufferSize(), observableSource, observableSource2);
    }

    public static <T1, T2, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        return zipArray(Functions.m26542a((BiFunction) biFunction), z, i, observableSource, observableSource2);
    }

    public static <T1, T2, T3, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        return zipArray(Functions.m26543a((Function3) function3), false, bufferSize(), observableSource, observableSource2, observableSource3);
    }

    public static <T1, T2, T3, T4, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        return zipArray(Functions.m26544a((Function4) function4), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4);
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        ObjectHelper.m26573a((Object) observableSource5, "source5 is null");
        return zipArray(Functions.m26545a((Function5) function5), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        ObjectHelper.m26573a((Object) observableSource5, "source5 is null");
        ObjectHelper.m26573a((Object) observableSource6, "source6 is null");
        return zipArray(Functions.m26546a((Function6) function6), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        ObjectHelper.m26573a((Object) observableSource5, "source5 is null");
        ObjectHelper.m26573a((Object) observableSource6, "source6 is null");
        ObjectHelper.m26573a((Object) observableSource7, "source7 is null");
        return zipArray(Functions.m26547a((Function7) function7), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        ObjectHelper.m26573a((Object) observableSource5, "source5 is null");
        ObjectHelper.m26573a((Object) observableSource6, "source6 is null");
        ObjectHelper.m26573a((Object) observableSource7, "source7 is null");
        ObjectHelper.m26573a((Object) observableSource8, "source8 is null");
        return zipArray(Functions.m26548a((Function8) function8), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(ObservableSource<? extends T1> observableSource, ObservableSource<? extends T2> observableSource2, ObservableSource<? extends T3> observableSource3, ObservableSource<? extends T4> observableSource4, ObservableSource<? extends T5> observableSource5, ObservableSource<? extends T6> observableSource6, ObservableSource<? extends T7> observableSource7, ObservableSource<? extends T8> observableSource8, ObservableSource<? extends T9> observableSource9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.m26573a((Object) observableSource, "source1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "source2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "source3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "source4 is null");
        ObjectHelper.m26573a((Object) observableSource5, "source5 is null");
        ObjectHelper.m26573a((Object) observableSource6, "source6 is null");
        ObjectHelper.m26573a((Object) observableSource7, "source7 is null");
        ObjectHelper.m26573a((Object) observableSource8, "source8 is null");
        ObjectHelper.m26573a((Object) observableSource9, "source9 is null");
        return zipArray(Functions.m26549a((Function9) function9), false, bufferSize(), observableSource, observableSource2, observableSource3, observableSource4, observableSource5, observableSource6, observableSource7, observableSource8, observableSource9);
    }

    public static <T, R> Observable<R> zipArray(Function<? super Object[], ? extends R> function, boolean z, int i, ObservableSource<? extends T>... observableSourceArr) {
        if (observableSourceArr.length == 0) {
            return empty();
        }
        ObjectHelper.m26573a((Object) function, "zipper is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableZip(observableSourceArr, null, function, i, z));
    }

    public static <T, R> Observable<R> zipIterable(Iterable<? extends ObservableSource<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z, int i) {
        ObjectHelper.m26573a((Object) function, "zipper is null");
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableZip(null, iterable, function, i, z));
    }

    public final Single<Boolean> all(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26747a(new ObservableAllSingle(this, predicate));
    }

    public final Observable<T> ambWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return ambArray(this, observableSource);
    }

    public final Single<Boolean> any(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26747a(new ObservableAnySingle(this, predicate));
    }

    public final <R> R as(ObservableConverter<T, ? extends R> observableConverter) {
        return ((ObservableConverter) ObjectHelper.m26573a((Object) observableConverter, "converter is null")).m26490a();
    }

    public final T blockingFirst() {
        Observer blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T c = blockingFirstObserver.m32114c();
        if (c != null) {
            return c;
        }
        throw new NoSuchElementException();
    }

    public final T blockingFirst(T t) {
        Observer blockingFirstObserver = new BlockingFirstObserver();
        subscribe(blockingFirstObserver);
        T c = blockingFirstObserver.m32114c();
        return c != null ? c : t;
    }

    public final void blockingForEach(Consumer<? super T> consumer) {
        Iterator it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                consumer.accept(it.next());
            } catch (Throwable th) {
                Exceptions.m26521b(th);
                ((Disposable) it).mo5626a();
                consumer = ExceptionHelper.m26682a(th);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final Iterable<T> blockingIterable(int i) {
        ObjectHelper.m26569a(i, "bufferSize");
        return new BlockingObservableIterable(this, i);
    }

    public final T blockingLast() {
        Observer blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T c = blockingLastObserver.m32114c();
        if (c != null) {
            return c;
        }
        throw new NoSuchElementException();
    }

    public final T blockingLast(T t) {
        Observer blockingLastObserver = new BlockingLastObserver();
        subscribe(blockingLastObserver);
        T c = blockingLastObserver.m32114c();
        return c != null ? c : t;
    }

    public final Iterable<T> blockingLatest() {
        return new BlockingObservableLatest(this);
    }

    public final Iterable<T> blockingMostRecent(T t) {
        return new BlockingObservableMostRecent(this, t);
    }

    public final Iterable<T> blockingNext() {
        return new BlockingObservableNext(this);
    }

    public final T blockingSingle() {
        T blockingGet = singleElement().blockingGet();
        if (blockingGet != null) {
            return blockingGet;
        }
        throw new NoSuchElementException();
    }

    public final T blockingSingle(T t) {
        return single(t).blockingGet();
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureObserver());
    }

    public final void blockingSubscribe() {
        ObservableBlockingSubscribe.m26617a(this);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer) {
        ObservableBlockingSubscribe.m26619a(this, consumer, Functions.f25017f, Functions.f25014c);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        ObservableBlockingSubscribe.m26619a(this, consumer, consumer2, Functions.f25014c);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        ObservableBlockingSubscribe.m26619a(this, consumer, consumer2, action);
    }

    public final void blockingSubscribe(Observer<? super T> observer) {
        ObservableBlockingSubscribe.m26618a(this, observer);
    }

    public final Observable<List<T>> buffer(int i) {
        return buffer(i, i);
    }

    public final Observable<List<T>> buffer(int i, int i2) {
        return buffer(i, i2, ArrayListSupplier.m32783a());
    }

    public final <U extends Collection<? super T>> Observable<U> buffer(int i, int i2, Callable<U> callable) {
        ObjectHelper.m26569a(i, "count");
        ObjectHelper.m26569a(i2, FreeSpaceBox.TYPE);
        ObjectHelper.m26573a((Object) callable, "bufferSupplier is null");
        return RxJavaPlugins.m26742a(new ObservableBuffer(this, i, i2, callable));
    }

    public final <U extends Collection<? super T>> Observable<U> buffer(int i, Callable<U> callable) {
        return buffer(i, i, (Callable) callable);
    }

    public final Observable<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        return buffer(j, j2, timeUnit, Schedulers.m26770a(), ArrayListSupplier.m32783a());
    }

    public final Observable<List<T>> buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j, j2, timeUnit, scheduler, ArrayListSupplier.m32783a());
    }

    public final <U extends Collection<? super T>> Observable<U> buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        Object obj = timeUnit;
        ObjectHelper.m26573a(obj, "unit is null");
        Object obj2 = scheduler;
        ObjectHelper.m26573a(obj2, "scheduler is null");
        Object obj3 = callable;
        ObjectHelper.m26573a(obj3, "bufferSupplier is null");
        return RxJavaPlugins.m26742a(new ObservableBufferTimed(this, j, j2, obj, obj2, obj3, RedditJobManager.f10810d, false));
    }

    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit) {
        return buffer(j, timeUnit, Schedulers.m26770a(), (int) RedditJobManager.f10810d);
    }

    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, int i) {
        return buffer(j, timeUnit, Schedulers.m26770a(), i);
    }

    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return buffer(j, timeUnit, scheduler, i, ArrayListSupplier.m32783a(), false);
    }

    public final <U extends Collection<? super T>> Observable<U> buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i, Callable<U> callable, boolean z) {
        Object obj = timeUnit;
        ObjectHelper.m26573a(obj, "unit is null");
        Object obj2 = scheduler;
        ObjectHelper.m26573a(obj2, "scheduler is null");
        Object obj3 = callable;
        ObjectHelper.m26573a(obj3, "bufferSupplier is null");
        int i2 = i;
        ObjectHelper.m26569a(i2, "count");
        return RxJavaPlugins.m26742a(new ObservableBufferTimed(this, j, j, obj, obj2, obj3, i2, z));
    }

    public final Observable<List<T>> buffer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j, timeUnit, scheduler, RedditJobManager.f10810d, ArrayListSupplier.m32783a(), false);
    }

    public final <TOpening, TClosing> Observable<List<T>> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function) {
        return buffer((ObservableSource) observableSource, (Function) function, ArrayListSupplier.m32783a());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<? extends TOpening> observableSource, Function<? super TOpening, ? extends ObservableSource<? extends TClosing>> function, Callable<U> callable) {
        ObjectHelper.m26573a((Object) observableSource, "openingIndicator is null");
        ObjectHelper.m26573a((Object) function, "closingIndicator is null");
        ObjectHelper.m26573a((Object) callable, "bufferSupplier is null");
        return RxJavaPlugins.m26742a(new ObservableBufferBoundary(this, observableSource, function, callable));
    }

    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource) {
        return buffer((ObservableSource) observableSource, ArrayListSupplier.m32783a());
    }

    public final <B> Observable<List<T>> buffer(ObservableSource<B> observableSource, int i) {
        ObjectHelper.m26569a(i, "initialCapacity");
        return buffer((ObservableSource) observableSource, Functions.m26554a(i));
    }

    public final <B, U extends Collection<? super T>> Observable<U> buffer(ObservableSource<B> observableSource, Callable<U> callable) {
        ObjectHelper.m26573a((Object) observableSource, "boundary is null");
        ObjectHelper.m26573a((Object) callable, "bufferSupplier is null");
        return RxJavaPlugins.m26742a(new ObservableBufferExactBoundary(this, observableSource, callable));
    }

    public final <B> Observable<List<T>> buffer(Callable<? extends ObservableSource<B>> callable) {
        return buffer((Callable) callable, ArrayListSupplier.m32783a());
    }

    public final <B, U extends Collection<? super T>> Observable<U> buffer(Callable<? extends ObservableSource<B>> callable, Callable<U> callable2) {
        ObjectHelper.m26573a((Object) callable, "boundarySupplier is null");
        ObjectHelper.m26573a((Object) callable2, "bufferSupplier is null");
        return RxJavaPlugins.m26742a(new ObservableBufferBoundarySupplier(this, callable, callable2));
    }

    public final Observable<T> cache() {
        return ObservableCache.from(this);
    }

    public final Observable<T> cacheWithInitialCapacity(int i) {
        return ObservableCache.from(this, i);
    }

    public final <U> Observable<U> cast(Class<U> cls) {
        ObjectHelper.m26573a((Object) cls, "clazz is null");
        return map(Functions.m26550a((Class) cls));
    }

    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.m26573a((Object) callable, "initialValueSupplier is null");
        ObjectHelper.m26573a((Object) biConsumer, "collector is null");
        return RxJavaPlugins.m26747a(new ObservableCollectSingle(this, callable, biConsumer));
    }

    public final <U> Single<U> collectInto(U u, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.m26573a((Object) u, "initialValue is null");
        return collect(Functions.m26555a((Object) u), biConsumer);
    }

    public final <R> Observable<R> compose(ObservableTransformer<? super T, ? extends R> observableTransformer) {
        return wrap(((ObservableTransformer) ObjectHelper.m26573a((Object) observableTransformer, "composer is null")).m26493a(this));
    }

    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMap(function, 2);
    }

    public final <R> Observable<R> concatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "prefetch");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.m26742a(new ObservableConcatMap(this, function, i, ErrorMode.IMMEDIATE));
        }
        i = ((ScalarCallable) this).call();
        if (i == 0) {
            return empty();
        }
        return ObservableScalarXMap.m26647a(i, function);
    }

    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapDelayError(function, bufferSize(), true);
    }

    public final <R> Observable<R> concatMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, boolean z) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "prefetch");
        if (this instanceof ScalarCallable) {
            i = ((ScalarCallable) this).call();
            if (i == 0) {
                return empty();
            }
            return ObservableScalarXMap.m26647a(i, function);
        }
        return RxJavaPlugins.m26742a(new ObservableConcatMap(this, function, i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return concatMapEager(function, RedditJobManager.f10810d, bufferSize());
    }

    public final <R> Observable<R> concatMapEager(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, int i2) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        ObjectHelper.m26569a(i2, "prefetch");
        return RxJavaPlugins.m26742a(new ObservableConcatMapEager(this, function, ErrorMode.IMMEDIATE, i, i2));
    }

    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return concatMapEagerDelayError(function, RedditJobManager.f10810d, bufferSize(), z);
    }

    public final <R> Observable<R> concatMapEagerDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i, int i2, boolean z) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        ObjectHelper.m26569a(i2, "prefetch");
        return RxJavaPlugins.m26742a(new ObservableConcatMapEager(this, function, z ? ErrorMode.END : ErrorMode.BOUNDARY, i, i2));
    }

    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return concatMapCompletable(function, 2);
    }

    public final Completable concatMapCompletable(Function<? super T, ? extends CompletableSource> function, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "capacityHint");
        return RxJavaPlugins.m26737a(new ObservableConcatMapCompletable(this, function, i));
    }

    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26742a(new ObservableFlattenIterable(this, function));
    }

    public final <U> Observable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "prefetch");
        return concatMap(ObservableInternalHelper.m26638b((Function) function), i);
    }

    public final Observable<T> concatWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return concat((ObservableSource) this, (ObservableSource) observableSource);
    }

    public final Observable<T> concatWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "other is null");
        return RxJavaPlugins.m26742a(new ObservableConcatWithSingle(this, singleSource));
    }

    public final Observable<T> concatWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "other is null");
        return RxJavaPlugins.m26742a(new ObservableConcatWithMaybe(this, maybeSource));
    }

    public final Observable<T> concatWith(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return RxJavaPlugins.m26742a(new ObservableConcatWithCompletable(this, completableSource));
    }

    public final Single<Boolean> contains(Object obj) {
        ObjectHelper.m26573a(obj, "element is null");
        return any(Functions.m26562c(obj));
    }

    public final Single<Long> count() {
        return RxJavaPlugins.m26747a(new ObservableCountSingle(this));
    }

    public final <U> Observable<T> debounce(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.m26573a((Object) function, "debounceSelector is null");
        return RxJavaPlugins.m26742a(new ObservableDebounce(this, function));
    }

    public final Observable<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, Schedulers.m26770a());
    }

    public final Observable<T> debounce(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26742a(new ObservableDebounceTimed(this, j, timeUnit, scheduler));
    }

    public final Observable<T> defaultIfEmpty(T t) {
        ObjectHelper.m26573a((Object) t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    public final <U> Observable<T> delay(Function<? super T, ? extends ObservableSource<U>> function) {
        ObjectHelper.m26573a((Object) function, "itemDelay is null");
        return flatMap(ObservableInternalHelper.m26629a((Function) function));
    }

    public final Observable<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.m26770a(), false);
    }

    public final Observable<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, Schedulers.m26770a(), z);
    }

    public final Observable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    public final Observable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26742a(new ObservableDelay(this, j, timeUnit, scheduler, z));
    }

    public final <U, V> Observable<T> delay(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        return delaySubscription(observableSource).delay(function);
    }

    public final <U> Observable<T> delaySubscription(ObservableSource<U> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return RxJavaPlugins.m26742a(new ObservableDelaySubscriptionOther(this, observableSource));
    }

    public final Observable<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, Schedulers.m26770a());
    }

    public final Observable<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j, timeUnit, scheduler));
    }

    public final <T2> Observable<T2> dematerialize() {
        return RxJavaPlugins.m26742a(new ObservableDematerialize(this));
    }

    public final Observable<T> distinct() {
        return distinct(Functions.m26541a(), Functions.m26566g());
    }

    public final <K> Observable<T> distinct(Function<? super T, K> function) {
        return distinct(function, Functions.m26566g());
    }

    public final <K> Observable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        ObjectHelper.m26573a((Object) function, "keySelector is null");
        ObjectHelper.m26573a((Object) callable, "collectionSupplier is null");
        return RxJavaPlugins.m26742a(new ObservableDistinct(this, function, callable));
    }

    public final Observable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.m26541a());
    }

    public final <K> Observable<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.m26573a((Object) function, "keySelector is null");
        return RxJavaPlugins.m26742a(new ObservableDistinctUntilChanged(this, function, ObjectHelper.m26572a()));
    }

    public final Observable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.m26573a((Object) biPredicate, "comparer is null");
        return RxJavaPlugins.m26742a(new ObservableDistinctUntilChanged(this, Functions.m26541a(), biPredicate));
    }

    public final Observable<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.m26573a((Object) consumer, "onAfterNext is null");
        return RxJavaPlugins.m26742a(new ObservableDoAfterNext(this, consumer));
    }

    public final Observable<T> doAfterTerminate(Action action) {
        ObjectHelper.m26573a((Object) action, "onFinally is null");
        return doOnEach(Functions.m26556b(), Functions.m26556b(), Functions.f25014c, action);
    }

    public final Observable<T> doFinally(Action action) {
        ObjectHelper.m26573a((Object) action, "onFinally is null");
        return RxJavaPlugins.m26742a(new ObservableDoFinally(this, action));
    }

    public final Observable<T> doOnDispose(Action action) {
        return doOnLifecycle(Functions.m26556b(), action);
    }

    public final Observable<T> doOnComplete(Action action) {
        return doOnEach(Functions.m26556b(), Functions.m26556b(), action, Functions.f25014c);
    }

    private Observable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.m26573a((Object) consumer, "onNext is null");
        ObjectHelper.m26573a((Object) consumer2, "onError is null");
        ObjectHelper.m26573a((Object) action, "onComplete is null");
        ObjectHelper.m26573a((Object) action2, "onAfterTerminate is null");
        return RxJavaPlugins.m26742a(new ObservableDoOnEach(this, consumer, consumer2, action, action2));
    }

    public final Observable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        ObjectHelper.m26573a((Object) consumer, "consumer is null");
        return doOnEach(Functions.m26540a((Consumer) consumer), Functions.m26557b((Consumer) consumer), Functions.m26560c((Consumer) consumer), Functions.f25014c);
    }

    public final Observable<T> doOnEach(Observer<? super T> observer) {
        ObjectHelper.m26573a((Object) observer, "observer is null");
        return doOnEach(ObservableInternalHelper.m26628a((Observer) observer), ObservableInternalHelper.m26637b((Observer) observer), ObservableInternalHelper.m26639c((Observer) observer), Functions.f25014c);
    }

    public final Observable<T> doOnError(Consumer<? super Throwable> consumer) {
        return doOnEach(Functions.m26556b(), consumer, Functions.f25014c, Functions.f25014c);
    }

    public final Observable<T> doOnLifecycle(Consumer<? super Disposable> consumer, Action action) {
        ObjectHelper.m26573a((Object) consumer, "onSubscribe is null");
        ObjectHelper.m26573a((Object) action, "onDispose is null");
        return RxJavaPlugins.m26742a(new ObservableDoOnLifecycle(this, consumer, action));
    }

    public final Observable<T> doOnNext(Consumer<? super T> consumer) {
        return doOnEach(consumer, Functions.m26556b(), Functions.f25014c, Functions.f25014c);
    }

    public final Observable<T> doOnSubscribe(Consumer<? super Disposable> consumer) {
        return doOnLifecycle(consumer, Functions.f25014c);
    }

    public final Observable<T> doOnTerminate(Action action) {
        ObjectHelper.m26573a((Object) action, "onTerminate is null");
        return doOnEach(Functions.m26556b(), Functions.m26539a(action), action, Functions.f25014c);
    }

    public final Maybe<T> elementAt(long j) {
        if (j >= 0) {
            return RxJavaPlugins.m26740a(new ObservableElementAtMaybe(this, j));
        }
        StringBuilder stringBuilder = new StringBuilder("index >= 0 required but it was ");
        stringBuilder.append(j);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final Single<T> elementAt(long j, T t) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("index >= 0 required but it was ");
            stringBuilder.append(j);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        ObjectHelper.m26573a((Object) t, "defaultItem is null");
        return RxJavaPlugins.m26747a(new ObservableElementAtSingle(this, j, t));
    }

    public final Single<T> elementAtOrError(long j) {
        if (j >= 0) {
            return RxJavaPlugins.m26747a(new ObservableElementAtSingle(this, j, null));
        }
        StringBuilder stringBuilder = new StringBuilder("index >= 0 required but it was ");
        stringBuilder.append(j);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final Observable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26742a(new ObservableFilter(this, predicate));
    }

    public final Maybe<T> firstElement() {
        return elementAt(0);
    }

    public final Single<T> first(T t) {
        return elementAt(0, t);
    }

    public final Single<T> firstOrError() {
        return elementAtOrError(0);
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return flatMap((Function) function, false);
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z) {
        return flatMap((Function) function, z, (int) RedditJobManager.f10810d);
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i) {
        return flatMap((Function) function, z, i, bufferSize());
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, boolean z, int i, int i2) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        ObjectHelper.m26569a(i2, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.m26742a(new ObservableFlatMap(this, function, z, i, i2));
        }
        z = ((ScalarCallable) this).call();
        if (z) {
            return ObservableScalarXMap.m26647a(z, function);
        }
        return empty();
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable) {
        ObjectHelper.m26573a((Object) function, "onNextMapper is null");
        ObjectHelper.m26573a((Object) function2, "onErrorMapper is null");
        ObjectHelper.m26573a((Object) callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable));
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, Function<Throwable, ? extends ObservableSource<? extends R>> function2, Callable<? extends ObservableSource<? extends R>> callable, int i) {
        ObjectHelper.m26573a((Object) function, "onNextMapper is null");
        ObjectHelper.m26573a((Object) function2, "onErrorMapper is null");
        ObjectHelper.m26573a((Object) callable, "onCompleteSupplier is null");
        return merge(new ObservableMapNotification(this, function, function2, callable), i);
    }

    public final <R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        return flatMap((Function) function, false, i, bufferSize());
    }

    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return flatMap(function, biFunction, z, bufferSize(), bufferSize());
    }

    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return flatMap(function, biFunction, z, i, bufferSize());
    }

    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i, int i2) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26573a((Object) biFunction, "combiner is null");
        return flatMap(ObservableInternalHelper.m26631a((Function) function, (BiFunction) biFunction), z, i, i2);
    }

    public final <U, R> Observable<R> flatMap(Function<? super T, ? extends ObservableSource<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        return flatMap(function, biFunction, false, i, bufferSize());
    }

    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return flatMapCompletable(function, false);
    }

    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26737a(new ObservableFlatMapCompletableCompletable(this, function, z));
    }

    public final <U> Observable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26742a(new ObservableFlattenIterable(this, function));
    }

    public final <U, V> Observable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26573a((Object) biFunction, "resultSelector is null");
        return flatMap(ObservableInternalHelper.m26638b((Function) function), biFunction, false, bufferSize(), bufferSize());
    }

    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false);
    }

    public final <R> Observable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26742a(new ObservableFlatMapMaybe(this, function, z));
    }

    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return flatMapSingle(function, false);
    }

    public final <R> Observable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26742a(new ObservableFlatMapSingle(this, function, z));
    }

    public final Disposable forEach(Consumer<? super T> consumer) {
        return subscribe((Consumer) consumer);
    }

    public final Disposable forEachWhile(Predicate<? super T> predicate) {
        return forEachWhile(predicate, Functions.f25017f, Functions.f25014c);
    }

    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer) {
        return forEachWhile(predicate, consumer, Functions.f25014c);
    }

    public final Disposable forEachWhile(Predicate<? super T> predicate, Consumer<? super Throwable> consumer, Action action) {
        ObjectHelper.m26573a((Object) predicate, "onNext is null");
        ObjectHelper.m26573a((Object) consumer, "onError is null");
        ObjectHelper.m26573a((Object) action, "onComplete is null");
        Observer forEachWhileObserver = new ForEachWhileObserver(predicate, consumer, action);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return groupBy(function, Functions.m26541a(), false, bufferSize());
    }

    public final <K> Observable<GroupedObservable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z) {
        return groupBy(function, Functions.m26541a(), z, bufferSize());
    }

    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z) {
        return groupBy(function, function2, z, bufferSize());
    }

    public final <K, V> Observable<GroupedObservable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z, int i) {
        ObjectHelper.m26573a((Object) function, "keySelector is null");
        ObjectHelper.m26573a((Object) function2, "valueSelector is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableGroupBy(this, function, function2, i, z));
    }

    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> groupJoin(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super Observable<TRight>, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        ObjectHelper.m26573a((Object) function, "leftEnd is null");
        ObjectHelper.m26573a((Object) function2, "rightEnd is null");
        ObjectHelper.m26573a((Object) biFunction, "resultSelector is null");
        return RxJavaPlugins.m26742a(new ObservableGroupJoin(this, observableSource, function, function2, biFunction));
    }

    public final Observable<T> hide() {
        return RxJavaPlugins.m26742a(new ObservableHide(this));
    }

    public final Completable ignoreElements() {
        return RxJavaPlugins.m26737a(new ObservableIgnoreElementsCompletable(this));
    }

    public final Single<Boolean> isEmpty() {
        return all(Functions.m26563d());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> Observable<R> join(ObservableSource<? extends TRight> observableSource, Function<? super T, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        ObjectHelper.m26573a((Object) function, "leftEnd is null");
        ObjectHelper.m26573a((Object) function2, "rightEnd is null");
        ObjectHelper.m26573a((Object) biFunction, "resultSelector is null");
        return RxJavaPlugins.m26742a(new ObservableJoin(this, observableSource, function, function2, biFunction));
    }

    public final Maybe<T> lastElement() {
        return RxJavaPlugins.m26740a(new ObservableLastMaybe(this));
    }

    public final Single<T> last(T t) {
        ObjectHelper.m26573a((Object) t, "defaultItem is null");
        return RxJavaPlugins.m26747a(new ObservableLastSingle(this, t));
    }

    public final Single<T> lastOrError() {
        return RxJavaPlugins.m26747a(new ObservableLastSingle(this, null));
    }

    public final <R> Observable<R> lift(ObservableOperator<? extends R, ? super T> observableOperator) {
        ObjectHelper.m26573a((Object) observableOperator, "onLift is null");
        return RxJavaPlugins.m26742a(new ObservableLift(this, observableOperator));
    }

    public final <R> Observable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26742a(new ObservableMap(this, function));
    }

    public final Observable<Notification<T>> materialize() {
        return RxJavaPlugins.m26742a(new ObservableMaterialize(this));
    }

    public final Observable<T> mergeWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return merge((ObservableSource) this, (ObservableSource) observableSource);
    }

    public final Observable<T> mergeWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "other is null");
        return RxJavaPlugins.m26742a(new ObservableMergeWithSingle(this, singleSource));
    }

    public final Observable<T> mergeWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "other is null");
        return RxJavaPlugins.m26742a(new ObservableMergeWithMaybe(this, maybeSource));
    }

    public final Observable<T> mergeWith(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return RxJavaPlugins.m26742a(new ObservableMergeWithCompletable(this, completableSource));
    }

    public final Observable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    public final Observable<T> observeOn(Scheduler scheduler, boolean z) {
        return observeOn(scheduler, z, bufferSize());
    }

    public final Observable<T> observeOn(Scheduler scheduler, boolean z, int i) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableObserveOn(this, scheduler, z, i));
    }

    public final <U> Observable<U> ofType(Class<U> cls) {
        ObjectHelper.m26573a((Object) cls, "clazz is null");
        return filter(Functions.m26559b((Class) cls)).cast(cls);
    }

    public final Observable<T> onErrorResumeNext(Function<? super Throwable, ? extends ObservableSource<? extends T>> function) {
        ObjectHelper.m26573a((Object) function, "resumeFunction is null");
        return RxJavaPlugins.m26742a(new ObservableOnErrorNext(this, function, false));
    }

    public final Observable<T> onErrorResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "next is null");
        return onErrorResumeNext(Functions.m26558b((Object) observableSource));
    }

    public final Observable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.m26573a((Object) function, "valueSupplier is null");
        return RxJavaPlugins.m26742a(new ObservableOnErrorReturn(this, function));
    }

    public final Observable<T> onErrorReturnItem(T t) {
        ObjectHelper.m26573a((Object) t, "item is null");
        return onErrorReturn(Functions.m26558b((Object) t));
    }

    public final Observable<T> onExceptionResumeNext(ObservableSource<? extends T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "next is null");
        return RxJavaPlugins.m26742a(new ObservableOnErrorNext(this, Functions.m26558b((Object) observableSource), true));
    }

    public final Observable<T> onTerminateDetach() {
        return RxJavaPlugins.m26742a(new ObservableDetach(this));
    }

    public final ConnectableObservable<T> publish() {
        return ObservablePublish.m38137a((ObservableSource) this);
    }

    public final <R> Observable<R> publish(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        return RxJavaPlugins.m26742a(new ObservablePublishSelector(this, function));
    }

    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        ObjectHelper.m26573a((Object) biFunction, "reducer is null");
        return RxJavaPlugins.m26740a(new ObservableReduceMaybe(this, biFunction));
    }

    public final <R> Single<R> reduce(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.m26573a((Object) r, "seed is null");
        ObjectHelper.m26573a((Object) biFunction, "reducer is null");
        return RxJavaPlugins.m26747a(new ObservableReduceSeedSingle(this, r, biFunction));
    }

    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.m26573a((Object) callable, "seedSupplier is null");
        ObjectHelper.m26573a((Object) biFunction, "reducer is null");
        return RxJavaPlugins.m26747a(new ObservableReduceWithSingle(this, callable, biFunction));
    }

    public final Observable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final Observable<T> repeat(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("times >= 0 required but it was ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i == 0) {
            return empty();
        } else {
            return RxJavaPlugins.m26742a(new ObservableRepeat(this, j));
        }
    }

    public final Observable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.m26573a((Object) booleanSupplier, "stop is null");
        return RxJavaPlugins.m26742a(new ObservableRepeatUntil(this, booleanSupplier));
    }

    public final Observable<T> repeatWhen(Function<? super Observable<Object>, ? extends ObservableSource<?>> function) {
        ObjectHelper.m26573a((Object) function, "handler is null");
        return RxJavaPlugins.m26742a(new ObservableRepeatWhen(this, function));
    }

    public final ConnectableObservable<T> replay() {
        return ObservableReplay.m38142a((ObservableSource) this);
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        return ObservableReplay.m38141a(ObservableInternalHelper.m26632a(this), (Function) function);
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return ObservableReplay.m38141a(ObservableInternalHelper.m26633a(this, i), (Function) function);
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i, long j, TimeUnit timeUnit) {
        return replay(function, i, j, timeUnit, Schedulers.m26770a());
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        ObjectHelper.m26569a(i, "bufferSize");
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return ObservableReplay.m38141a(ObservableInternalHelper.m26634a(this, i, j, timeUnit, scheduler), (Function) function);
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, int i, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return ObservableReplay.m38141a(ObservableInternalHelper.m26633a(this, i), ObservableInternalHelper.m26630a((Function) function, scheduler));
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j, TimeUnit timeUnit) {
        return replay((Function) function, j, timeUnit, Schedulers.m26770a());
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return ObservableReplay.m38141a(ObservableInternalHelper.m26635a(this, j, timeUnit, scheduler), (Function) function);
    }

    public final <R> Observable<R> replay(Function<? super Observable<T>, ? extends ObservableSource<R>> function, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return ObservableReplay.m38141a(ObservableInternalHelper.m26632a(this), ObservableInternalHelper.m26630a((Function) function, scheduler));
    }

    public final ConnectableObservable<T> replay(int i) {
        ObjectHelper.m26569a(i, "bufferSize");
        return ObservableReplay.m38143a((ObservableSource) this, i);
    }

    public final ConnectableObservable<T> replay(int i, long j, TimeUnit timeUnit) {
        return replay(i, j, timeUnit, Schedulers.m26770a());
    }

    public final ConnectableObservable<T> replay(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26569a(i, "bufferSize");
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return ObservableReplay.m38145a(this, j, timeUnit, scheduler, i);
    }

    public final ConnectableObservable<T> replay(int i, Scheduler scheduler) {
        ObjectHelper.m26569a(i, "bufferSize");
        return ObservableReplay.m38147a(replay(i), scheduler);
    }

    public final ConnectableObservable<T> replay(long j, TimeUnit timeUnit) {
        return replay(j, timeUnit, Schedulers.m26770a());
    }

    public final ConnectableObservable<T> replay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return ObservableReplay.m38144a(this, j, timeUnit, scheduler);
    }

    public final ConnectableObservable<T> replay(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return ObservableReplay.m38147a(replay(), scheduler);
    }

    public final Observable<T> retry() {
        return retry(Long.MAX_VALUE, Functions.m26561c());
    }

    public final Observable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.m26573a((Object) biPredicate, "predicate is null");
        return RxJavaPlugins.m26742a(new ObservableRetryBiPredicate(this, biPredicate));
    }

    public final Observable<T> retry(long j) {
        return retry(j, Functions.m26561c());
    }

    public final Observable<T> retry(long j, Predicate<? super Throwable> predicate) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("times >= 0 required but it was ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26742a(new ObservableRetryPredicate(this, j, predicate));
    }

    public final Observable<T> retry(Predicate<? super Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    public final Observable<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.m26573a((Object) booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, Functions.m26553a(booleanSupplier));
    }

    public final Observable<T> retryWhen(Function<? super Observable<Throwable>, ? extends ObservableSource<?>> function) {
        ObjectHelper.m26573a((Object) function, "handler is null");
        return RxJavaPlugins.m26742a(new ObservableRetryWhen(this, function));
    }

    public final void safeSubscribe(Observer<? super T> observer) {
        ObjectHelper.m26573a((Object) observer, "s is null");
        if (observer instanceof SafeObserver) {
            subscribe((Observer) observer);
        } else {
            subscribe(new SafeObserver(observer));
        }
    }

    public final Observable<T> sample(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit, Schedulers.m26770a());
    }

    public final Observable<T> sample(long j, TimeUnit timeUnit, boolean z) {
        return sample(j, timeUnit, Schedulers.m26770a(), z);
    }

    public final Observable<T> sample(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26742a(new ObservableSampleTimed(this, j, timeUnit, scheduler, false));
    }

    public final Observable<T> sample(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26742a(new ObservableSampleTimed(this, j, timeUnit, scheduler, z));
    }

    public final <U> Observable<T> sample(ObservableSource<U> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "sampler is null");
        return RxJavaPlugins.m26742a(new ObservableSampleWithObservable(this, observableSource, false));
    }

    public final <U> Observable<T> sample(ObservableSource<U> observableSource, boolean z) {
        ObjectHelper.m26573a((Object) observableSource, "sampler is null");
        return RxJavaPlugins.m26742a(new ObservableSampleWithObservable(this, observableSource, z));
    }

    public final Observable<T> scan(BiFunction<T, T, T> biFunction) {
        ObjectHelper.m26573a((Object) biFunction, "accumulator is null");
        return RxJavaPlugins.m26742a(new ObservableScan(this, biFunction));
    }

    public final <R> Observable<R> scan(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.m26573a((Object) r, "seed is null");
        return scanWith(Functions.m26555a((Object) r), biFunction);
    }

    public final <R> Observable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.m26573a((Object) callable, "seedSupplier is null");
        ObjectHelper.m26573a((Object) biFunction, "accumulator is null");
        return RxJavaPlugins.m26742a(new ObservableScanSeed(this, callable, biFunction));
    }

    public final Observable<T> serialize() {
        return RxJavaPlugins.m26742a(new ObservableSerialized(this));
    }

    public final Observable<T> share() {
        return RxJavaPlugins.m26742a(new ObservableRefCount(publish()));
    }

    public final Maybe<T> singleElement() {
        return RxJavaPlugins.m26740a(new ObservableSingleMaybe(this));
    }

    public final Single<T> single(T t) {
        ObjectHelper.m26573a((Object) t, "defaultItem is null");
        return RxJavaPlugins.m26747a(new ObservableSingleSingle(this, t));
    }

    public final Single<T> singleOrError() {
        return RxJavaPlugins.m26747a(new ObservableSingleSingle(this, null));
    }

    public final Observable<T> skip(long j) {
        if (j <= 0) {
            return RxJavaPlugins.m26742a(this);
        }
        return RxJavaPlugins.m26742a(new ObservableSkip(this, j));
    }

    public final Observable<T> skip(long j, TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    public final Observable<T> skip(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return skipUntil(timer(j, timeUnit, scheduler));
    }

    public final Observable<T> skipLast(int i) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
            stringBuilder.append(i);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (i == 0) {
            return RxJavaPlugins.m26742a(this);
        } else {
            return RxJavaPlugins.m26742a(new ObservableSkipLast(this, i));
        }
    }

    public final Observable<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, Schedulers.m26772c(), false, bufferSize());
    }

    public final Observable<T> skipLast(long j, TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, Schedulers.m26772c(), z, bufferSize());
    }

    public final Observable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return skipLast(j, timeUnit, scheduler, false, bufferSize());
    }

    public final Observable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return skipLast(j, timeUnit, scheduler, z, bufferSize());
    }

    public final Observable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableSkipLastTimed(this, j, timeUnit, scheduler, i << 1, z));
    }

    public final <U> Observable<T> skipUntil(ObservableSource<U> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return RxJavaPlugins.m26742a(new ObservableSkipUntil(this, observableSource));
    }

    public final Observable<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26742a(new ObservableSkipWhile(this, predicate));
    }

    public final Observable<T> sorted() {
        return toList().toObservable().map(Functions.m26551a(Functions.m26567h())).flatMapIterable(Functions.m26541a());
    }

    public final Observable<T> sorted(Comparator<? super T> comparator) {
        ObjectHelper.m26573a((Object) comparator, "sortFunction is null");
        return toList().toObservable().map(Functions.m26551a((Comparator) comparator)).flatMapIterable(Functions.m26541a());
    }

    public final Observable<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final Observable<T> startWith(ObservableSource<? extends T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return concatArray(observableSource, this);
    }

    public final Observable<T> startWith(T t) {
        ObjectHelper.m26573a((Object) t, "item is null");
        return concatArray(just(t), this);
    }

    public final Observable<T> startWithArray(T... tArr) {
        if (fromArray(tArr) == empty()) {
            return RxJavaPlugins.m26742a(this);
        }
        return concatArray(fromArray(tArr), this);
    }

    public final Disposable subscribe() {
        return subscribe(Functions.m26556b(), Functions.f25017f, Functions.f25014c, Functions.m26556b());
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.f25017f, Functions.f25014c, Functions.m26556b());
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.f25014c, Functions.m26556b());
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return subscribe(consumer, consumer2, action, Functions.m26556b());
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Disposable> consumer3) {
        ObjectHelper.m26573a((Object) consumer, "onNext is null");
        ObjectHelper.m26573a((Object) consumer2, "onError is null");
        ObjectHelper.m26573a((Object) action, "onComplete is null");
        ObjectHelper.m26573a((Object) consumer3, "onSubscribe is null");
        Observer lambdaObserver = new LambdaObserver(consumer, consumer2, action, consumer3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    public final void subscribe(Observer<? super T> observer) {
        ObjectHelper.m26573a((Object) observer, "observer is null");
        try {
            Object a = RxJavaPlugins.m26743a(this, (Observer) observer);
            ObjectHelper.m26573a(a, "Plugin returned null Observer");
            subscribeActual(a);
        } catch (Observer<? super T> observer2) {
            throw observer2;
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
            new NullPointerException("Actually not, but can't throw other exceptions due to RS").initCause(th);
        }
    }

    public final <E extends Observer<? super T>> E subscribeWith(E e) {
        subscribe((Observer) e);
        return e;
    }

    public final Observable<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26742a(new ObservableSubscribeOn(this, scheduler));
    }

    public final Observable<T> switchIfEmpty(ObservableSource<? extends T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return RxJavaPlugins.m26742a(new ObservableSwitchIfEmpty(this, observableSource));
    }

    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    public final <R> Observable<R> switchMap(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.m26742a(new ObservableSwitchMap(this, function, i, false));
        }
        i = ((ScalarCallable) this).call();
        if (i == 0) {
            return empty();
        }
        return ObservableScalarXMap.m26647a(i, function);
    }

    public final <R> Observable<R> switchMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return ObservableInternalHelper.m26625a(this, (Function) function);
    }

    public final <R> Observable<R> switchMapSingleDelayError(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return ObservableInternalHelper.m26636b(this, function);
    }

    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    public final <R> Observable<R> switchMapDelayError(Function<? super T, ? extends ObservableSource<? extends R>> function, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.m26742a(new ObservableSwitchMap(this, function, i, true));
        }
        i = ((ScalarCallable) this).call();
        if (i == 0) {
            return empty();
        }
        return ObservableScalarXMap.m26647a(i, function);
    }

    public final Observable<T> take(long j) {
        if (j >= 0) {
            return RxJavaPlugins.m26742a(new ObservableTake(this, j));
        }
        StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final Observable<T> take(long j, TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    public final Observable<T> take(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeUntil(timer(j, timeUnit, scheduler));
    }

    public final Observable<T> takeLast(int i) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
            stringBuilder.append(i);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (i == 0) {
            return RxJavaPlugins.m26742a(new ObservableIgnoreElements(this));
        } else {
            if (i == 1) {
                return RxJavaPlugins.m26742a(new ObservableTakeLastOne(this));
            }
            return RxJavaPlugins.m26742a(new ObservableTakeLast(this, i));
        }
    }

    public final Observable<T> takeLast(long j, long j2, TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, Schedulers.m26772c(), false, bufferSize());
    }

    public final Observable<T> takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j, j2, timeUnit, scheduler, false, bufferSize());
    }

    public final Observable<T> takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        long j3 = j;
        Object obj = timeUnit;
        ObjectHelper.m26573a(obj, "unit is null");
        Object obj2 = scheduler;
        ObjectHelper.m26573a(obj2, "scheduler is null");
        int i2 = i;
        ObjectHelper.m26569a(i2, "bufferSize");
        if (j3 >= 0) {
            return RxJavaPlugins.m26742a(new ObservableTakeLastTimed(this, j3, j2, obj, obj2, i2, z));
        }
        StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
        stringBuilder.append(j3);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final Observable<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, Schedulers.m26772c(), false, bufferSize());
    }

    public final Observable<T> takeLast(long j, TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, Schedulers.m26772c(), z, bufferSize());
    }

    public final Observable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j, timeUnit, scheduler, false, bufferSize());
    }

    public final Observable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return takeLast(j, timeUnit, scheduler, z, bufferSize());
    }

    public final Observable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        return takeLast(Long.MAX_VALUE, j, timeUnit, scheduler, z, i);
    }

    public final <U> Observable<T> takeUntil(ObservableSource<U> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return RxJavaPlugins.m26742a(new ObservableTakeUntil(this, observableSource));
    }

    public final Observable<T> takeUntil(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26742a(new ObservableTakeUntilPredicate(this, predicate));
    }

    public final Observable<T> takeWhile(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26742a(new ObservableTakeWhile(this, predicate));
    }

    public final Observable<T> throttleFirst(long j, TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, Schedulers.m26770a());
    }

    public final Observable<T> throttleFirst(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26742a(new ObservableThrottleFirstTimed(this, j, timeUnit, scheduler));
    }

    public final Observable<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    public final Observable<T> throttleLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return sample(j, timeUnit, scheduler);
    }

    public final Observable<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    public final Observable<T> throttleWithTimeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return debounce(j, timeUnit, scheduler);
    }

    public final Observable<Timed<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, Schedulers.m26770a());
    }

    public final Observable<Timed<T>> timeInterval(Scheduler scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, Schedulers.m26770a());
    }

    public final Observable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26742a(new ObservableTimeInterval(this, timeUnit, scheduler));
    }

    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function) {
        return timeout0(null, function, null);
    }

    public final <V> Observable<T> timeout(Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return timeout0(null, function, observableSource);
    }

    public final Observable<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, null, Schedulers.m26770a());
    }

    public final Observable<T> timeout(long j, TimeUnit timeUnit, ObservableSource<? extends T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return timeout0(j, timeUnit, observableSource, Schedulers.m26770a());
    }

    public final Observable<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, ObservableSource<? extends T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return timeout0(j, timeUnit, observableSource, scheduler);
    }

    public final Observable<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, null, scheduler);
    }

    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function) {
        ObjectHelper.m26573a((Object) observableSource, "firstTimeoutIndicator is null");
        return timeout0(observableSource, function, null);
    }

    public final <U, V> Observable<T> timeout(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.m26573a((Object) observableSource, "firstTimeoutIndicator is null");
        ObjectHelper.m26573a((Object) observableSource2, "other is null");
        return timeout0(observableSource, function, observableSource2);
    }

    private Observable<T> timeout0(long j, TimeUnit timeUnit, ObservableSource<? extends T> observableSource, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "timeUnit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26742a(new ObservableTimeoutTimed(this, j, timeUnit, scheduler, observableSource));
    }

    private <U, V> Observable<T> timeout0(ObservableSource<U> observableSource, Function<? super T, ? extends ObservableSource<V>> function, ObservableSource<? extends T> observableSource2) {
        ObjectHelper.m26573a((Object) function, "itemTimeoutIndicator is null");
        return RxJavaPlugins.m26742a(new ObservableTimeout(this, observableSource, function, observableSource2));
    }

    public final Observable<Timed<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, Schedulers.m26770a());
    }

    public final Observable<Timed<T>> timestamp(Scheduler scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, Schedulers.m26770a());
    }

    public final Observable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return map(Functions.m26552a(timeUnit, scheduler));
    }

    public final <R> R to(Function<? super Observable<T>, R> function) {
        try {
            return ((Function) ObjectHelper.m26573a((Object) function, "converter is null")).apply(this);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            function = ExceptionHelper.m26682a(th);
        }
    }

    public final Single<List<T>> toList() {
        return toList(16);
    }

    public final Single<List<T>> toList(int i) {
        ObjectHelper.m26569a(i, "capacityHint");
        return RxJavaPlugins.m26747a(new ObservableToListSingle((ObservableSource) this, i));
    }

    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        ObjectHelper.m26573a((Object) callable, "collectionSupplier is null");
        return RxJavaPlugins.m26747a(new ObservableToListSingle((ObservableSource) this, (Callable) callable));
    }

    public final <K> Single<Map<K, T>> toMap(Function<? super T, ? extends K> function) {
        ObjectHelper.m26573a((Object) function, "keySelector is null");
        return collect(HashMapSupplier.m26692a(), Functions.m26536a((Function) function));
    }

    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        ObjectHelper.m26573a((Object) function, "keySelector is null");
        ObjectHelper.m26573a((Object) function2, "valueSelector is null");
        return collect(HashMapSupplier.m26692a(), Functions.m26537a((Function) function, (Function) function2));
    }

    public final <K, V> Single<Map<K, V>> toMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, V>> callable) {
        ObjectHelper.m26573a((Object) function, "keySelector is null");
        ObjectHelper.m26573a((Object) function2, "valueSelector is null");
        ObjectHelper.m26573a((Object) callable, "mapSupplier is null");
        return collect(callable, Functions.m26537a((Function) function, (Function) function2));
    }

    public final <K> Single<Map<K, Collection<T>>> toMultimap(Function<? super T, ? extends K> function) {
        return toMultimap(function, Functions.m26541a(), HashMapSupplier.m26692a(), ArrayListSupplier.m32784b());
    }

    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return toMultimap(function, function2, HashMapSupplier.m26692a(), ArrayListSupplier.m32784b());
    }

    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<? extends Map<K, Collection<V>>> callable, Function<? super K, ? extends Collection<? super V>> function3) {
        ObjectHelper.m26573a((Object) function, "keySelector is null");
        ObjectHelper.m26573a((Object) function2, "valueSelector is null");
        ObjectHelper.m26573a((Object) callable, "mapSupplier is null");
        ObjectHelper.m26573a((Object) function3, "collectionFactory is null");
        return collect(callable, Functions.m26538a(function, function2, function3));
    }

    public final <K, V> Single<Map<K, Collection<V>>> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(function, function2, callable, ArrayListSupplier.m32784b());
    }

    public final Flowable<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        Flowable<T> flowableFromObservable = new FlowableFromObservable(this);
        switch (backpressureStrategy) {
            case DROP:
                return flowableFromObservable.onBackpressureDrop();
            case LATEST:
                return flowableFromObservable.onBackpressureLatest();
            case MISSING:
                return flowableFromObservable;
            case ERROR:
                return RxJavaPlugins.m26739a(new FlowableOnBackpressureError(flowableFromObservable));
            default:
                return flowableFromObservable.onBackpressureBuffer();
        }
    }

    public final Single<List<T>> toSortedList() {
        return toSortedList(Functions.m26565f());
    }

    public final Single<List<T>> toSortedList(Comparator<? super T> comparator) {
        ObjectHelper.m26573a((Object) comparator, "comparator is null");
        return toList().map(Functions.m26551a((Comparator) comparator));
    }

    public final Single<List<T>> toSortedList(Comparator<? super T> comparator, int i) {
        ObjectHelper.m26573a((Object) comparator, "comparator is null");
        return toList(i).map(Functions.m26551a((Comparator) comparator));
    }

    public final Single<List<T>> toSortedList(int i) {
        return toSortedList(Functions.m26565f(), i);
    }

    public final Observable<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26742a(new ObservableUnsubscribeOn(this, scheduler));
    }

    public final Observable<Observable<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    public final Observable<Observable<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    public final Observable<Observable<T>> window(long j, long j2, int i) {
        ObjectHelper.m26571a(j, "count");
        ObjectHelper.m26571a(j2, FreeSpaceBox.TYPE);
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableWindow(this, j, j2, i));
    }

    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit) {
        return window(j, j2, timeUnit, Schedulers.m26770a(), bufferSize());
    }

    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, j2, timeUnit, scheduler, bufferSize());
    }

    public final Observable<Observable<T>> window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i) {
        long j3 = j;
        ObjectHelper.m26571a(j3, "timespan");
        long j4 = j2;
        ObjectHelper.m26571a(j4, "timeskip");
        int i2 = i;
        ObjectHelper.m26569a(i2, "bufferSize");
        Object obj = scheduler;
        ObjectHelper.m26573a(obj, "scheduler is null");
        Object obj2 = timeUnit;
        ObjectHelper.m26573a(obj2, "unit is null");
        return RxJavaPlugins.m26742a(new ObservableWindowTimed(this, j3, j4, obj2, obj, Long.MAX_VALUE, i2, false));
    }

    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit) {
        return window(j, timeUnit, Schedulers.m26770a(), Long.MAX_VALUE, false);
    }

    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, long j2) {
        return window(j, timeUnit, Schedulers.m26770a(), j2, false);
    }

    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, long j2, boolean z) {
        return window(j, timeUnit, Schedulers.m26770a(), j2, z);
    }

    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2) {
        return window(j, timeUnit, scheduler, j2, false);
    }

    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z) {
        return window(j, timeUnit, scheduler, j2, z, bufferSize());
    }

    public final Observable<Observable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z, int i) {
        int i2 = i;
        ObjectHelper.m26569a(i2, "bufferSize");
        Object obj = scheduler;
        ObjectHelper.m26573a(obj, "scheduler is null");
        Object obj2 = timeUnit;
        ObjectHelper.m26573a(obj2, "unit is null");
        long j3 = j2;
        ObjectHelper.m26571a(j3, "count");
        return RxJavaPlugins.m26742a(new ObservableWindowTimed(this, j, j, obj2, obj, j3, i2, z));
    }

    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource) {
        return window((ObservableSource) observableSource, bufferSize());
    }

    public final <B> Observable<Observable<T>> window(ObservableSource<B> observableSource, int i) {
        ObjectHelper.m26573a((Object) observableSource, "boundary is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableWindowBoundary(this, observableSource, i));
    }

    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function) {
        return window((ObservableSource) observableSource, (Function) function, bufferSize());
    }

    public final <U, V> Observable<Observable<T>> window(ObservableSource<U> observableSource, Function<? super U, ? extends ObservableSource<V>> function, int i) {
        ObjectHelper.m26573a((Object) observableSource, "openingIndicator is null");
        ObjectHelper.m26573a((Object) function, "closingIndicator is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableWindowBoundarySelector(this, observableSource, function, i));
    }

    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable) {
        return window((Callable) callable, bufferSize());
    }

    public final <B> Observable<Observable<T>> window(Callable<? extends ObservableSource<B>> callable, int i) {
        ObjectHelper.m26573a((Object) callable, "boundary is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26742a(new ObservableWindowBoundarySupplier(this, callable, i));
    }

    public final <U, R> Observable<R> withLatestFrom(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        ObjectHelper.m26573a((Object) biFunction, "combiner is null");
        return RxJavaPlugins.m26742a(new ObservableWithLatestFrom(this, biFunction, observableSource));
    }

    public final <T1, T2, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        ObjectHelper.m26573a((Object) observableSource, "o1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "o2 is null");
        ObjectHelper.m26573a((Object) function3, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2}, Functions.m26543a((Function3) function3));
    }

    public final <T1, T2, T3, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        ObjectHelper.m26573a((Object) observableSource, "o1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "o2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "o3 is null");
        ObjectHelper.m26573a((Object) function4, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3}, Functions.m26544a((Function4) function4));
    }

    public final <T1, T2, T3, T4, R> Observable<R> withLatestFrom(ObservableSource<T1> observableSource, ObservableSource<T2> observableSource2, ObservableSource<T3> observableSource3, ObservableSource<T4> observableSource4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        ObjectHelper.m26573a((Object) observableSource, "o1 is null");
        ObjectHelper.m26573a((Object) observableSource2, "o2 is null");
        ObjectHelper.m26573a((Object) observableSource3, "o3 is null");
        ObjectHelper.m26573a((Object) observableSource4, "o4 is null");
        ObjectHelper.m26573a((Object) function5, "combiner is null");
        return withLatestFrom(new ObservableSource[]{observableSource, observableSource2, observableSource3, observableSource4}, Functions.m26545a((Function5) function5));
    }

    public final <R> Observable<R> withLatestFrom(ObservableSource<?>[] observableSourceArr, Function<? super Object[], R> function) {
        ObjectHelper.m26573a((Object) observableSourceArr, "others is null");
        ObjectHelper.m26573a((Object) function, "combiner is null");
        return RxJavaPlugins.m26742a(new ObservableWithLatestFromMany((ObservableSource) this, (ObservableSource[]) observableSourceArr, (Function) function));
    }

    public final <R> Observable<R> withLatestFrom(Iterable<? extends ObservableSource<?>> iterable, Function<? super Object[], R> function) {
        ObjectHelper.m26573a((Object) iterable, "others is null");
        ObjectHelper.m26573a((Object) function, "combiner is null");
        return RxJavaPlugins.m26742a(new ObservableWithLatestFromMany((ObservableSource) this, (Iterable) iterable, (Function) function));
    }

    public final <U, R> Observable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) iterable, "other is null");
        ObjectHelper.m26573a((Object) biFunction, "zipper is null");
        return RxJavaPlugins.m26742a(new ObservableZipIterable(this, iterable, biFunction));
    }

    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) observableSource, "other is null");
        return zip(this, observableSource, biFunction);
    }

    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return zip((ObservableSource) this, (ObservableSource) observableSource, (BiFunction) biFunction, z);
    }

    public final <U, R> Observable<R> zipWith(ObservableSource<? extends U> observableSource, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return zip((ObservableSource) this, (ObservableSource) observableSource, (BiFunction) biFunction, z, i);
    }

    public final TestObserver<T> test() {
        Observer testObserver = new TestObserver();
        subscribe(testObserver);
        return testObserver;
    }

    public final TestObserver<T> test(boolean z) {
        Observer testObserver = new TestObserver();
        if (z) {
            testObserver.mo5626a();
        }
        subscribe(testObserver);
        return testObserver;
    }
}
