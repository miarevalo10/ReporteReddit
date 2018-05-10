package io.reactivex;

import com.coremedia.iso.boxes.FreeSpaceBox;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.flowables.GroupedFlowable;
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
import io.reactivex.functions.LongConsumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.ScalarCallable;
import io.reactivex.internal.operators.flowable.BlockingFlowableIterable;
import io.reactivex.internal.operators.flowable.BlockingFlowableLatest;
import io.reactivex.internal.operators.flowable.BlockingFlowableMostRecent;
import io.reactivex.internal.operators.flowable.BlockingFlowableNext;
import io.reactivex.internal.operators.flowable.FlowableAllSingle;
import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.operators.flowable.FlowableAnySingle;
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe;
import io.reactivex.internal.operators.flowable.FlowableBuffer;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary;
import io.reactivex.internal.operators.flowable.FlowableBufferTimed;
import io.reactivex.internal.operators.flowable.FlowableCache;
import io.reactivex.internal.operators.flowable.FlowableCollectSingle;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEagerPublisher;
import io.reactivex.internal.operators.flowable.FlowableConcatWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableConcatWithSingle;
import io.reactivex.internal.operators.flowable.FlowableCountSingle;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDebounce;
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.internal.operators.flowable.FlowableDefer;
import io.reactivex.internal.operators.flowable.FlowableDelay;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.operators.flowable.FlowableDematerialize;
import io.reactivex.internal.operators.flowable.FlowableDetach;
import io.reactivex.internal.operators.flowable.FlowableDistinct;
import io.reactivex.internal.operators.flowable.FlowableDistinctUntilChanged;
import io.reactivex.internal.operators.flowable.FlowableDoAfterNext;
import io.reactivex.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.internal.operators.flowable.FlowableDoOnEach;
import io.reactivex.internal.operators.flowable.FlowableDoOnLifecycle;
import io.reactivex.internal.operators.flowable.FlowableElementAtMaybe;
import io.reactivex.internal.operators.flowable.FlowableElementAtSingle;
import io.reactivex.internal.operators.flowable.FlowableEmpty;
import io.reactivex.internal.operators.flowable.FlowableError;
import io.reactivex.internal.operators.flowable.FlowableFilter;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromCallable;
import io.reactivex.internal.operators.flowable.FlowableFromFuture;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableFromPublisher;
import io.reactivex.internal.operators.flowable.FlowableGenerate;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.operators.flowable.FlowableHide;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElements;
import io.reactivex.internal.operators.flowable.FlowableIgnoreElementsCompletable;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper.RequestMax;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.internal.operators.flowable.FlowableJoin;
import io.reactivex.internal.operators.flowable.FlowableJust;
import io.reactivex.internal.operators.flowable.FlowableLastMaybe;
import io.reactivex.internal.operators.flowable.FlowableLastSingle;
import io.reactivex.internal.operators.flowable.FlowableLift;
import io.reactivex.internal.operators.flowable.FlowableLimit;
import io.reactivex.internal.operators.flowable.FlowableMap;
import io.reactivex.internal.operators.flowable.FlowableMapNotification;
import io.reactivex.internal.operators.flowable.FlowableMaterialize;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableMergeWithSingle;
import io.reactivex.internal.operators.flowable.FlowableNever;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.operators.flowable.FlowableRange;
import io.reactivex.internal.operators.flowable.FlowableRangeLong;
import io.reactivex.internal.operators.flowable.FlowableReduceMaybe;
import io.reactivex.internal.operators.flowable.FlowableReduceSeedSingle;
import io.reactivex.internal.operators.flowable.FlowableReduceWithSingle;
import io.reactivex.internal.operators.flowable.FlowableRefCount;
import io.reactivex.internal.operators.flowable.FlowableRepeat;
import io.reactivex.internal.operators.flowable.FlowableRepeatUntil;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.operators.flowable.FlowableRetryBiPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.internal.operators.flowable.FlowableScalarXMap;
import io.reactivex.internal.operators.flowable.FlowableScan;
import io.reactivex.internal.operators.flowable.FlowableScanSeed;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.internal.operators.flowable.FlowableSerialized;
import io.reactivex.internal.operators.flowable.FlowableSingleMaybe;
import io.reactivex.internal.operators.flowable.FlowableSingleSingle;
import io.reactivex.internal.operators.flowable.FlowableSkip;
import io.reactivex.internal.operators.flowable.FlowableSkipLast;
import io.reactivex.internal.operators.flowable.FlowableSkipLastTimed;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.internal.operators.flowable.FlowableSkipWhile;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableSwitchIfEmpty;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.internal.operators.flowable.FlowableTake;
import io.reactivex.internal.operators.flowable.FlowableTakeLast;
import io.reactivex.internal.operators.flowable.FlowableTakeLastOne;
import io.reactivex.internal.operators.flowable.FlowableTakeLastTimed;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.internal.operators.flowable.FlowableTakeUntilPredicate;
import io.reactivex.internal.operators.flowable.FlowableTakeWhile;
import io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed;
import io.reactivex.internal.operators.flowable.FlowableTimeInterval;
import io.reactivex.internal.operators.flowable.FlowableTimeout;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableToListSingle;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableUsing;
import io.reactivex.internal.operators.flowable.FlowableWindow;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySelector;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableWindowTimed;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.operators.flowable.FlowableZipIterable;
import io.reactivex.internal.operators.observable.ObservableFromPublisher;
import io.reactivex.internal.schedulers.ImmediateThinScheduler;
import io.reactivex.internal.subscribers.BlockingFirstSubscriber;
import io.reactivex.internal.subscribers.BlockingLastSubscriber;
import io.reactivex.internal.subscribers.ForEachWhileSubscriber;
import io.reactivex.internal.subscribers.FutureSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import io.reactivex.subscribers.SafeSubscriber;
import io.reactivex.subscribers.TestSubscriber;
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
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class Flowable<T> implements Publisher<T> {
    static final int BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public abstract void subscribeActual(Subscriber<? super T> subscriber);

    public static <T> Flowable<T> amb(Iterable<? extends Publisher<? extends T>> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26739a(new FlowableAmb(null, iterable));
    }

    public static <T> Flowable<T> ambArray(Publisher<? extends T>... publisherArr) {
        ObjectHelper.m26573a((Object) publisherArr, "sources is null");
        int length = publisherArr.length;
        if (length == 0) {
            return empty();
        }
        if (length == 1) {
            return fromPublisher(publisherArr[0]);
        }
        return RxJavaPlugins.m26739a(new FlowableAmb(publisherArr, null));
    }

    public static int bufferSize() {
        return BUFFER_SIZE;
    }

    public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function) {
        return combineLatest((Publisher[]) publisherArr, (Function) function, bufferSize());
    }

    public static <T, R> Flowable<R> combineLatest(Function<? super Object[], ? extends R> function, Publisher<? extends T>... publisherArr) {
        return combineLatest((Publisher[]) publisherArr, (Function) function, bufferSize());
    }

    public static <T, R> Flowable<R> combineLatest(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.m26573a((Object) publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return empty();
        }
        ObjectHelper.m26573a((Object) function, "combiner is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableCombineLatest((Publisher[]) publisherArr, (Function) function, i, false));
    }

    public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatest((Iterable) iterable, (Function) function, bufferSize());
    }

    public static <T, R> Flowable<R> combineLatest(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        ObjectHelper.m26573a((Object) function, "combiner is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableCombineLatest((Iterable) iterable, (Function) function, i, false));
    }

    public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError((Publisher[]) publisherArr, (Function) function, bufferSize());
    }

    public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, Publisher<? extends T>... publisherArr) {
        return combineLatestDelayError((Publisher[]) publisherArr, (Function) function, bufferSize());
    }

    public static <T, R> Flowable<R> combineLatestDelayError(Function<? super Object[], ? extends R> function, int i, Publisher<? extends T>... publisherArr) {
        return combineLatestDelayError((Publisher[]) publisherArr, (Function) function, i);
    }

    public static <T, R> Flowable<R> combineLatestDelayError(Publisher<? extends T>[] publisherArr, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.m26573a((Object) publisherArr, "sources is null");
        ObjectHelper.m26573a((Object) function, "combiner is null");
        ObjectHelper.m26569a(i, "bufferSize");
        if (publisherArr.length == 0) {
            return empty();
        }
        return RxJavaPlugins.m26739a(new FlowableCombineLatest((Publisher[]) publisherArr, (Function) function, i, true));
    }

    public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        return combineLatestDelayError((Iterable) iterable, (Function) function, bufferSize());
    }

    public static <T, R> Flowable<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, int i) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        ObjectHelper.m26573a((Object) function, "combiner is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableCombineLatest((Iterable) iterable, (Function) function, i, true));
    }

    public static <T1, T2, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        return combineLatest(Functions.m26542a((BiFunction) biFunction), publisher, publisher2);
    }

    public static <T1, T2, T3, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        return combineLatest(Functions.m26543a((Function3) function3), publisher, publisher2, publisher3);
    }

    public static <T1, T2, T3, T4, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        return combineLatest(Functions.m26544a((Function4) function4), publisher, publisher2, publisher3, publisher4);
    }

    public static <T1, T2, T3, T4, T5, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        ObjectHelper.m26573a((Object) publisher5, "source5 is null");
        return combineLatest(Functions.m26545a((Function5) function5), publisher, publisher2, publisher3, publisher4, publisher5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        ObjectHelper.m26573a((Object) publisher5, "source5 is null");
        ObjectHelper.m26573a((Object) publisher6, "source6 is null");
        return combineLatest(Functions.m26546a((Function6) function6), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        ObjectHelper.m26573a((Object) publisher5, "source5 is null");
        ObjectHelper.m26573a((Object) publisher6, "source6 is null");
        ObjectHelper.m26573a((Object) publisher7, "source7 is null");
        return combineLatest(Functions.m26547a((Function7) function7), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        ObjectHelper.m26573a((Object) publisher5, "source5 is null");
        ObjectHelper.m26573a((Object) publisher6, "source6 is null");
        ObjectHelper.m26573a((Object) publisher7, "source7 is null");
        ObjectHelper.m26573a((Object) publisher8, "source8 is null");
        return combineLatest(Functions.m26548a((Function8) function8), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Publisher<? extends T9> publisher9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        ObjectHelper.m26573a((Object) publisher5, "source5 is null");
        ObjectHelper.m26573a((Object) publisher6, "source6 is null");
        ObjectHelper.m26573a((Object) publisher7, "source7 is null");
        ObjectHelper.m26573a((Object) publisher8, "source8 is null");
        ObjectHelper.m26573a((Object) publisher9, "source9 is null");
        return combineLatest(Functions.m26549a((Function9) function9), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
    }

    public static <T> Flowable<T> concat(Iterable<? extends Publisher<? extends T>> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.m26541a(), 2, false);
    }

    public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> publisher) {
        return concat((Publisher) publisher, bufferSize());
    }

    public static <T> Flowable<T> concat(Publisher<? extends Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).concatMap(Functions.m26541a(), i);
    }

    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        return concatArray(publisher, publisher2);
    }

    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        return concatArray(publisher, publisher2, publisher3);
    }

    public static <T> Flowable<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        return concatArray(publisher, publisher2, publisher3, publisher4);
    }

    public static <T> Flowable<T> concatArray(Publisher<? extends T>... publisherArr) {
        if (publisherArr.length == 0) {
            return empty();
        }
        if (publisherArr.length == 1) {
            return fromPublisher(publisherArr[0]);
        }
        return RxJavaPlugins.m26739a(new FlowableConcatArray(publisherArr, false));
    }

    public static <T> Flowable<T> concatArrayDelayError(Publisher<? extends T>... publisherArr) {
        if (publisherArr.length == 0) {
            return empty();
        }
        if (publisherArr.length == 1) {
            return fromPublisher(publisherArr[0]);
        }
        return RxJavaPlugins.m26739a(new FlowableConcatArray(publisherArr, true));
    }

    public static <T> Flowable<T> concatArrayEager(Publisher<? extends T>... publisherArr) {
        return concatArrayEager(bufferSize(), bufferSize(), publisherArr);
    }

    public static <T> Flowable<T> concatArrayEager(int i, int i2, Publisher<? extends T>... publisherArr) {
        ObjectHelper.m26573a((Object) publisherArr, "sources is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        ObjectHelper.m26569a(i2, "prefetch");
        return RxJavaPlugins.m26739a(new FlowableConcatMapEager(new FlowableFromArray(publisherArr), Functions.m26541a(), i, i2, ErrorMode.IMMEDIATE));
    }

    public static <T> Flowable<T> concatDelayError(Iterable<? extends Publisher<? extends T>> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.m26541a());
    }

    public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return concatDelayError(publisher, bufferSize(), true);
    }

    public static <T> Flowable<T> concatDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i, boolean z) {
        return fromPublisher(publisher).concatMapDelayError(Functions.m26541a(), i, z);
    }

    public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> publisher) {
        return concatEager((Publisher) publisher, bufferSize(), bufferSize());
    }

    public static <T> Flowable<T> concatEager(Publisher<? extends Publisher<? extends T>> publisher, int i, int i2) {
        ObjectHelper.m26573a((Object) publisher, "sources is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        ObjectHelper.m26569a(i2, "prefetch");
        return RxJavaPlugins.m26739a(new FlowableConcatMapEagerPublisher(publisher, Functions.m26541a(), i, i2, ErrorMode.IMMEDIATE));
    }

    public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> iterable) {
        return concatEager((Iterable) iterable, bufferSize(), bufferSize());
    }

    public static <T> Flowable<T> concatEager(Iterable<? extends Publisher<? extends T>> iterable, int i, int i2) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        ObjectHelper.m26569a(i2, "prefetch");
        return RxJavaPlugins.m26739a(new FlowableConcatMapEager(new FlowableFromIterable(iterable), Functions.m26541a(), i, i2, ErrorMode.IMMEDIATE));
    }

    public static <T> Flowable<T> create(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        ObjectHelper.m26573a((Object) flowableOnSubscribe, "source is null");
        ObjectHelper.m26573a((Object) backpressureStrategy, "mode is null");
        return RxJavaPlugins.m26739a(new FlowableCreate(flowableOnSubscribe, backpressureStrategy));
    }

    public static <T> Flowable<T> defer(Callable<? extends Publisher<? extends T>> callable) {
        ObjectHelper.m26573a((Object) callable, "supplier is null");
        return RxJavaPlugins.m26739a(new FlowableDefer(callable));
    }

    public static <T> Flowable<T> empty() {
        return RxJavaPlugins.m26739a(FlowableEmpty.f35000a);
    }

    public static <T> Flowable<T> error(Callable<? extends Throwable> callable) {
        ObjectHelper.m26573a((Object) callable, "errorSupplier is null");
        return RxJavaPlugins.m26739a(new FlowableError(callable));
    }

    public static <T> Flowable<T> error(Throwable th) {
        ObjectHelper.m26573a((Object) th, "throwable is null");
        return error(Functions.m26555a((Object) th));
    }

    public static <T> Flowable<T> fromArray(T... tArr) {
        ObjectHelper.m26573a((Object) tArr, "items is null");
        if (tArr.length == 0) {
            return empty();
        }
        if (tArr.length == 1) {
            return just(tArr[0]);
        }
        return RxJavaPlugins.m26739a(new FlowableFromArray(tArr));
    }

    public static <T> Flowable<T> fromCallable(Callable<? extends T> callable) {
        ObjectHelper.m26573a((Object) callable, "supplier is null");
        return RxJavaPlugins.m26739a(new FlowableFromCallable(callable));
    }

    public static <T> Flowable<T> fromFuture(Future<? extends T> future) {
        ObjectHelper.m26573a((Object) future, "future is null");
        return RxJavaPlugins.m26739a(new FlowableFromFuture(future, 0, null));
    }

    public static <T> Flowable<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        ObjectHelper.m26573a((Object) future, "future is null");
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        return RxJavaPlugins.m26739a(new FlowableFromFuture(future, j, timeUnit));
    }

    public static <T> Flowable<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(scheduler);
    }

    public static <T> Flowable<T> fromFuture(Future<? extends T> future, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return fromFuture(future).subscribeOn(scheduler);
    }

    public static <T> Flowable<T> fromIterable(Iterable<? extends T> iterable) {
        ObjectHelper.m26573a((Object) iterable, "source is null");
        return RxJavaPlugins.m26739a(new FlowableFromIterable(iterable));
    }

    public static <T> Flowable<T> fromPublisher(Publisher<? extends T> publisher) {
        if (publisher instanceof Flowable) {
            return RxJavaPlugins.m26739a((Flowable) publisher);
        }
        ObjectHelper.m26573a((Object) publisher, "publisher is null");
        return RxJavaPlugins.m26739a(new FlowableFromPublisher(publisher));
    }

    public static <T> Flowable<T> generate(Consumer<Emitter<T>> consumer) {
        ObjectHelper.m26573a((Object) consumer, "generator is null");
        return generate(Functions.m26564e(), FlowableInternalHelper.m26595a((Consumer) consumer), Functions.m26556b());
    }

    public static <T, S> Flowable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer) {
        ObjectHelper.m26573a((Object) biConsumer, "generator is null");
        return generate((Callable) callable, FlowableInternalHelper.m26594a((BiConsumer) biConsumer), Functions.m26556b());
    }

    public static <T, S> Flowable<T> generate(Callable<S> callable, BiConsumer<S, Emitter<T>> biConsumer, Consumer<? super S> consumer) {
        ObjectHelper.m26573a((Object) biConsumer, "generator is null");
        return generate((Callable) callable, FlowableInternalHelper.m26594a((BiConsumer) biConsumer), (Consumer) consumer);
    }

    public static <T, S> Flowable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction) {
        return generate((Callable) callable, (BiFunction) biFunction, Functions.m26556b());
    }

    public static <T, S> Flowable<T> generate(Callable<S> callable, BiFunction<S, Emitter<T>, S> biFunction, Consumer<? super S> consumer) {
        ObjectHelper.m26573a((Object) callable, "initialState is null");
        ObjectHelper.m26573a((Object) biFunction, "generator is null");
        ObjectHelper.m26573a((Object) consumer, "disposeState is null");
        return RxJavaPlugins.m26739a(new FlowableGenerate(callable, biFunction, consumer));
    }

    public static Flowable<Long> interval(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, Schedulers.m26770a());
    }

    public static Flowable<Long> interval(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26739a(new FlowableInterval(Math.max(0, j), Math.max(0, j2), timeUnit, scheduler));
    }

    public static Flowable<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, Schedulers.m26770a());
    }

    public static Flowable<Long> interval(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return interval(j, j, timeUnit, scheduler);
    }

    public static Flowable<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        return intervalRange(j, j2, j3, j4, timeUnit, Schedulers.m26770a());
    }

    public static Flowable<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, Scheduler scheduler) {
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
                return RxJavaPlugins.m26739a(new FlowableIntervalRange(j, j5, Math.max(0, j6), Math.max(0, j4), obj, obj2));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    public static <T> Flowable<T> just(T t) {
        ObjectHelper.m26573a((Object) t, "item is null");
        return RxJavaPlugins.m26739a(new FlowableJust(t));
    }

    public static <T> Flowable<T> just(T t, T t2) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        return fromArray(t, t2);
    }

    public static <T> Flowable<T> just(T t, T t2, T t3) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        return fromArray(t, t2, t3);
    }

    public static <T> Flowable<T> just(T t, T t2, T t3, T t4) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        return fromArray(t, t2, t3, t4);
    }

    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        ObjectHelper.m26573a((Object) t5, "The fifth item is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        ObjectHelper.m26573a((Object) t5, "The fifth item is null");
        ObjectHelper.m26573a((Object) t6, "The sixth item is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        ObjectHelper.m26573a((Object) t5, "The fifth item is null");
        ObjectHelper.m26573a((Object) t6, "The sixth item is null");
        ObjectHelper.m26573a((Object) t7, "The seventh item is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
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

    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        ObjectHelper.m26573a((Object) t, "The first item is null");
        ObjectHelper.m26573a((Object) t2, "The second item is null");
        ObjectHelper.m26573a((Object) t3, "The third item is null");
        ObjectHelper.m26573a((Object) t4, "The fourth item is null");
        ObjectHelper.m26573a((Object) t5, "The fifth item is null");
        ObjectHelper.m26573a((Object) t6, "The sixth item is null");
        ObjectHelper.m26573a((Object) t7, "The seventh item is null");
        ObjectHelper.m26573a((Object) t8, "The eighth item is null");
        ObjectHelper.m26573a((Object) t9, "The ninth is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    public static <T> Flowable<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
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

    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.m26541a(), false, i, i2);
    }

    public static <T> Flowable<T> mergeArray(int i, int i2, Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.m26541a(), false, i, i2);
    }

    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.m26541a());
    }

    public static <T> Flowable<T> merge(Iterable<? extends Publisher<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.m26541a(), i);
    }

    public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> publisher) {
        return merge((Publisher) publisher, bufferSize());
    }

    public static <T> Flowable<T> merge(Publisher<? extends Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).flatMap(Functions.m26541a(), i);
    }

    public static <T> Flowable<T> mergeArray(Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.m26541a(), publisherArr.length);
    }

    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        return fromArray(publisher, publisher2).flatMap(Functions.m26541a(), false, 2);
    }

    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        return fromArray(publisher, publisher2, publisher3).flatMap(Functions.m26541a(), false, 3);
    }

    public static <T> Flowable<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.m26541a(), false, 4);
    }

    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.m26541a(), true);
    }

    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.m26541a(), true, i, i2);
    }

    public static <T> Flowable<T> mergeArrayDelayError(int i, int i2, Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.m26541a(), true, i, i2);
    }

    public static <T> Flowable<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.m26541a(), true, i);
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return mergeDelayError((Publisher) publisher, bufferSize());
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).flatMap(Functions.m26541a(), true, i);
    }

    public static <T> Flowable<T> mergeArrayDelayError(Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.m26541a(), true, publisherArr.length);
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        return fromArray(publisher, publisher2).flatMap(Functions.m26541a(), true, 2);
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        return fromArray(publisher, publisher2, publisher3).flatMap(Functions.m26541a(), true, 3);
    }

    public static <T> Flowable<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.m26541a(), true, 4);
    }

    public static <T> Flowable<T> never() {
        return RxJavaPlugins.m26739a(FlowableNever.f35150a);
    }

    public static Flowable<Integer> range(int i, int i2) {
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
                return RxJavaPlugins.m26739a(new FlowableRange(i, i2));
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    public static Flowable<Long> rangeLong(long j, long j2) {
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
                return RxJavaPlugins.m26739a(new FlowableRangeLong(j, j2));
            }
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
    }

    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        return sequenceEqual(publisher, publisher2, ObjectHelper.m26572a(), bufferSize());
    }

    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate) {
        return sequenceEqual(publisher, publisher2, biPredicate, bufferSize());
    }

    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, BiPredicate<? super T, ? super T> biPredicate, int i) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) biPredicate, "isEqual is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26747a(new FlowableSequenceEqualSingle(publisher, publisher2, biPredicate, i));
    }

    public static <T> Single<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, int i) {
        return sequenceEqual(publisher, publisher2, ObjectHelper.m26572a(), i);
    }

    public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).switchMap(Functions.m26541a(), i);
    }

    public static <T> Flowable<T> switchOnNext(Publisher<? extends Publisher<? extends T>> publisher) {
        return fromPublisher(publisher).switchMap(Functions.m26541a());
    }

    public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return switchOnNextDelayError(publisher, bufferSize());
    }

    public static <T> Flowable<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).switchMapDelayError(Functions.m26541a(), i);
    }

    public static Flowable<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.m26770a());
    }

    public static Flowable<Long> timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26739a(new FlowableTimer(Math.max(0, j), timeUnit, scheduler));
    }

    public static <T> Flowable<T> unsafeCreate(Publisher<T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "onSubscribe is null");
        if (!(publisher instanceof Flowable)) {
            return RxJavaPlugins.m26739a(new FlowableFromPublisher(publisher));
        }
        throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
    }

    public static <T, D> Flowable<T> using(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <T, D> Flowable<T> using(Callable<? extends D> callable, Function<? super D, ? extends Publisher<? extends T>> function, Consumer<? super D> consumer, boolean z) {
        ObjectHelper.m26573a((Object) callable, "resourceSupplier is null");
        ObjectHelper.m26573a((Object) function, "sourceSupplier is null");
        ObjectHelper.m26573a((Object) consumer, "disposer is null");
        return RxJavaPlugins.m26739a(new FlowableUsing(callable, function, consumer, z));
    }

    public static <T, R> Flowable<R> zip(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function) {
        ObjectHelper.m26573a((Object) function, "zipper is null");
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26739a(new FlowableZip(null, iterable, function, bufferSize(), false));
    }

    public static <T, R> Flowable<R> zip(Publisher<? extends Publisher<? extends T>> publisher, Function<? super Object[], ? extends R> function) {
        ObjectHelper.m26573a((Object) function, "zipper is null");
        return fromPublisher(publisher).toList().flatMapPublisher(FlowableInternalHelper.m26607c((Function) function));
    }

    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        return zipArray(Functions.m26542a((BiFunction) biFunction), false, bufferSize(), publisher, publisher2);
    }

    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        return zipArray(Functions.m26542a((BiFunction) biFunction), z, bufferSize(), publisher, publisher2);
    }

    public static <T1, T2, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, BiFunction<? super T1, ? super T2, ? extends R> biFunction, boolean z, int i) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        return zipArray(Functions.m26542a((BiFunction) biFunction), z, i, publisher, publisher2);
    }

    public static <T1, T2, T3, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        return zipArray(Functions.m26543a((Function3) function3), false, bufferSize(), publisher, publisher2, publisher3);
    }

    public static <T1, T2, T3, T4, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        return zipArray(Functions.m26544a((Function4) function4), false, bufferSize(), publisher, publisher2, publisher3, publisher4);
    }

    public static <T1, T2, T3, T4, T5, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        ObjectHelper.m26573a((Object) publisher5, "source5 is null");
        return zipArray(Functions.m26545a((Function5) function5), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        ObjectHelper.m26573a((Object) publisher5, "source5 is null");
        ObjectHelper.m26573a((Object) publisher6, "source6 is null");
        return zipArray(Functions.m26546a((Function6) function6), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        ObjectHelper.m26573a((Object) publisher5, "source5 is null");
        ObjectHelper.m26573a((Object) publisher6, "source6 is null");
        ObjectHelper.m26573a((Object) publisher7, "source7 is null");
        return zipArray(Functions.m26547a((Function7) function7), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        ObjectHelper.m26573a((Object) publisher5, "source5 is null");
        ObjectHelper.m26573a((Object) publisher6, "source6 is null");
        ObjectHelper.m26573a((Object) publisher7, "source7 is null");
        ObjectHelper.m26573a((Object) publisher8, "source8 is null");
        return zipArray(Functions.m26548a((Function8) function8), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Flowable<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Publisher<? extends T9> publisher9, Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        ObjectHelper.m26573a((Object) publisher5, "source5 is null");
        ObjectHelper.m26573a((Object) publisher6, "source6 is null");
        ObjectHelper.m26573a((Object) publisher7, "source7 is null");
        ObjectHelper.m26573a((Object) publisher8, "source8 is null");
        ObjectHelper.m26573a((Object) publisher9, "source9 is null");
        return zipArray(Functions.m26549a((Function9) function9), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
    }

    public static <T, R> Flowable<R> zipArray(Function<? super Object[], ? extends R> function, boolean z, int i, Publisher<? extends T>... publisherArr) {
        if (publisherArr.length == 0) {
            return empty();
        }
        ObjectHelper.m26573a((Object) function, "zipper is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableZip(publisherArr, null, function, i, z));
    }

    public static <T, R> Flowable<R> zipIterable(Iterable<? extends Publisher<? extends T>> iterable, Function<? super Object[], ? extends R> function, boolean z, int i) {
        ObjectHelper.m26573a((Object) function, "zipper is null");
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableZip(null, iterable, function, i, z));
    }

    public final Single<Boolean> all(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26747a(new FlowableAllSingle(this, predicate));
    }

    public final Flowable<T> ambWith(Publisher<? extends T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return ambArray(this, publisher);
    }

    public final Single<Boolean> any(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26747a(new FlowableAnySingle(this, predicate));
    }

    public final <R> R as(FlowableConverter<T, ? extends R> flowableConverter) {
        return ((FlowableConverter) ObjectHelper.m26573a((Object) flowableConverter, "converter is null")).m26474a();
    }

    public final T blockingFirst() {
        FlowableSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber();
        subscribe(blockingFirstSubscriber);
        T a = blockingFirstSubscriber.m35994a();
        if (a != null) {
            return a;
        }
        throw new NoSuchElementException();
    }

    public final T blockingFirst(T t) {
        FlowableSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber();
        subscribe(blockingFirstSubscriber);
        T a = blockingFirstSubscriber.m35994a();
        return a != null ? a : t;
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
        return new BlockingFlowableIterable(this, i);
    }

    public final T blockingLast() {
        FlowableSubscriber blockingLastSubscriber = new BlockingLastSubscriber();
        subscribe(blockingLastSubscriber);
        T a = blockingLastSubscriber.m35994a();
        if (a != null) {
            return a;
        }
        throw new NoSuchElementException();
    }

    public final T blockingLast(T t) {
        FlowableSubscriber blockingLastSubscriber = new BlockingLastSubscriber();
        subscribe(blockingLastSubscriber);
        T a = blockingLastSubscriber.m35994a();
        return a != null ? a : t;
    }

    public final Iterable<T> blockingLatest() {
        return new BlockingFlowableLatest(this);
    }

    public final Iterable<T> blockingMostRecent(T t) {
        return new BlockingFlowableMostRecent(this, t);
    }

    public final Iterable<T> blockingNext() {
        return new BlockingFlowableNext(this);
    }

    public final T blockingSingle() {
        return singleOrError().blockingGet();
    }

    public final T blockingSingle(T t) {
        return single(t).blockingGet();
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureSubscriber());
    }

    public final void blockingSubscribe() {
        FlowableBlockingSubscribe.m26583a(this);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer) {
        FlowableBlockingSubscribe.m26584a(this, consumer, Functions.f25017f, Functions.f25014c);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        FlowableBlockingSubscribe.m26584a(this, consumer, consumer2, Functions.f25014c);
    }

    public final void blockingSubscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        FlowableBlockingSubscribe.m26584a(this, consumer, consumer2, action);
    }

    public final void blockingSubscribe(Subscriber<? super T> subscriber) {
        FlowableBlockingSubscribe.m26585a(this, subscriber);
    }

    public final Flowable<List<T>> buffer(int i) {
        return buffer(i, i);
    }

    public final Flowable<List<T>> buffer(int i, int i2) {
        return buffer(i, i2, ArrayListSupplier.m32783a());
    }

    public final <U extends Collection<? super T>> Flowable<U> buffer(int i, int i2, Callable<U> callable) {
        ObjectHelper.m26569a(i, "count");
        ObjectHelper.m26569a(i2, FreeSpaceBox.TYPE);
        ObjectHelper.m26573a((Object) callable, "bufferSupplier is null");
        return RxJavaPlugins.m26739a(new FlowableBuffer(this, i, i2, callable));
    }

    public final <U extends Collection<? super T>> Flowable<U> buffer(int i, Callable<U> callable) {
        return buffer(i, i, (Callable) callable);
    }

    public final Flowable<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        return buffer(j, j2, timeUnit, Schedulers.m26770a(), ArrayListSupplier.m32783a());
    }

    public final Flowable<List<T>> buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j, j2, timeUnit, scheduler, ArrayListSupplier.m32783a());
    }

    public final <U extends Collection<? super T>> Flowable<U> buffer(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, Callable<U> callable) {
        Object obj = timeUnit;
        ObjectHelper.m26573a(obj, "unit is null");
        Object obj2 = scheduler;
        ObjectHelper.m26573a(obj2, "scheduler is null");
        Object obj3 = callable;
        ObjectHelper.m26573a(obj3, "bufferSupplier is null");
        return RxJavaPlugins.m26739a(new FlowableBufferTimed(this, j, j2, obj, obj2, obj3, RedditJobManager.f10810d, false));
    }

    public final Flowable<List<T>> buffer(long j, TimeUnit timeUnit) {
        return buffer(j, timeUnit, Schedulers.m26770a(), (int) RedditJobManager.f10810d);
    }

    public final Flowable<List<T>> buffer(long j, TimeUnit timeUnit, int i) {
        return buffer(j, timeUnit, Schedulers.m26770a(), i);
    }

    public final Flowable<List<T>> buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i) {
        return buffer(j, timeUnit, scheduler, i, ArrayListSupplier.m32783a(), false);
    }

    public final <U extends Collection<? super T>> Flowable<U> buffer(long j, TimeUnit timeUnit, Scheduler scheduler, int i, Callable<U> callable, boolean z) {
        Object obj = timeUnit;
        ObjectHelper.m26573a(obj, "unit is null");
        Object obj2 = scheduler;
        ObjectHelper.m26573a(obj2, "scheduler is null");
        Object obj3 = callable;
        ObjectHelper.m26573a(obj3, "bufferSupplier is null");
        int i2 = i;
        ObjectHelper.m26569a(i2, "count");
        return RxJavaPlugins.m26739a(new FlowableBufferTimed(this, j, j, obj, obj2, obj3, i2, z));
    }

    public final Flowable<List<T>> buffer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return buffer(j, timeUnit, scheduler, RedditJobManager.f10810d, ArrayListSupplier.m32783a(), false);
    }

    public final <TOpening, TClosing> Flowable<List<T>> buffer(Flowable<? extends TOpening> flowable, Function<? super TOpening, ? extends Publisher<? extends TClosing>> function) {
        return buffer((Flowable) flowable, (Function) function, ArrayListSupplier.m32783a());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> Flowable<U> buffer(Flowable<? extends TOpening> flowable, Function<? super TOpening, ? extends Publisher<? extends TClosing>> function, Callable<U> callable) {
        ObjectHelper.m26573a((Object) flowable, "openingIndicator is null");
        ObjectHelper.m26573a((Object) function, "closingIndicator is null");
        ObjectHelper.m26573a((Object) callable, "bufferSupplier is null");
        return RxJavaPlugins.m26739a(new FlowableBufferBoundary(this, flowable, function, callable));
    }

    public final <B> Flowable<List<T>> buffer(Publisher<B> publisher) {
        return buffer((Publisher) publisher, ArrayListSupplier.m32783a());
    }

    public final <B> Flowable<List<T>> buffer(Publisher<B> publisher, int i) {
        ObjectHelper.m26569a(i, "initialCapacity");
        return buffer((Publisher) publisher, Functions.m26554a(i));
    }

    public final <B, U extends Collection<? super T>> Flowable<U> buffer(Publisher<B> publisher, Callable<U> callable) {
        ObjectHelper.m26573a((Object) publisher, "boundaryIndicator is null");
        ObjectHelper.m26573a((Object) callable, "bufferSupplier is null");
        return RxJavaPlugins.m26739a(new FlowableBufferExactBoundary(this, publisher, callable));
    }

    public final <B> Flowable<List<T>> buffer(Callable<? extends Publisher<B>> callable) {
        return buffer((Callable) callable, ArrayListSupplier.m32783a());
    }

    public final <B, U extends Collection<? super T>> Flowable<U> buffer(Callable<? extends Publisher<B>> callable, Callable<U> callable2) {
        ObjectHelper.m26573a((Object) callable, "boundaryIndicatorSupplier is null");
        ObjectHelper.m26573a((Object) callable2, "bufferSupplier is null");
        return RxJavaPlugins.m26739a(new FlowableBufferBoundarySupplier(this, callable, callable2));
    }

    public final Flowable<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final Flowable<T> cacheWithInitialCapacity(int i) {
        ObjectHelper.m26569a(i, "initialCapacity");
        return RxJavaPlugins.m26739a(new FlowableCache(this, i));
    }

    public final <U> Flowable<U> cast(Class<U> cls) {
        ObjectHelper.m26573a((Object) cls, "clazz is null");
        return map(Functions.m26550a((Class) cls));
    }

    public final <U> Single<U> collect(Callable<? extends U> callable, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.m26573a((Object) callable, "initialItemSupplier is null");
        ObjectHelper.m26573a((Object) biConsumer, "collector is null");
        return RxJavaPlugins.m26747a(new FlowableCollectSingle(this, callable, biConsumer));
    }

    public final <U> Single<U> collectInto(U u, BiConsumer<? super U, ? super T> biConsumer) {
        ObjectHelper.m26573a((Object) u, "initialItem is null");
        return collect(Functions.m26555a((Object) u), biConsumer);
    }

    public final <R> Flowable<R> compose(FlowableTransformer<? super T, ? extends R> flowableTransformer) {
        return fromPublisher(((FlowableTransformer) ObjectHelper.m26573a((Object) flowableTransformer, "composer is null")).m26476a());
    }

    public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        return concatMap(function, 2);
    }

    public final <R> Flowable<R> concatMap(Function<? super T, ? extends Publisher<? extends R>> function, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "prefetch");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.m26739a(new FlowableConcatMap(this, function, i, ErrorMode.IMMEDIATE));
        }
        i = ((ScalarCallable) this).call();
        if (i == 0) {
            return empty();
        }
        return FlowableScalarXMap.m26612a(i, function);
    }

    public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function) {
        return concatMapDelayError(function, 2, true);
    }

    public final <R> Flowable<R> concatMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "prefetch");
        if (this instanceof ScalarCallable) {
            i = ((ScalarCallable) this).call();
            if (i == 0) {
                return empty();
            }
            return FlowableScalarXMap.m26612a(i, function);
        }
        return RxJavaPlugins.m26739a(new FlowableConcatMap(this, function, i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> function) {
        return concatMapEager(function, bufferSize(), bufferSize());
    }

    public final <R> Flowable<R> concatMapEager(Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        ObjectHelper.m26569a(i2, "prefetch");
        return RxJavaPlugins.m26739a(new FlowableConcatMapEager(this, function, i, i2, ErrorMode.IMMEDIATE));
    }

    public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        return concatMapEagerDelayError(function, bufferSize(), bufferSize(), z);
    }

    public final <R> Flowable<R> concatMapEagerDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int i, int i2, boolean z) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        ObjectHelper.m26569a(i2, "prefetch");
        return RxJavaPlugins.m26739a(new FlowableConcatMapEager(this, function, i, i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return concatMapIterable(function, 2);
    }

    public final <U> Flowable<U> concatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "prefetch");
        return RxJavaPlugins.m26739a(new FlowableFlattenIterable(this, function, i));
    }

    public final Flowable<T> concatWith(Publisher<? extends T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return concat((Publisher) this, (Publisher) publisher);
    }

    public final Flowable<T> concatWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "other is null");
        return RxJavaPlugins.m26739a(new FlowableConcatWithSingle(this, singleSource));
    }

    public final Flowable<T> concatWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "other is null");
        return RxJavaPlugins.m26739a(new FlowableConcatWithMaybe(this, maybeSource));
    }

    public final Flowable<T> concatWith(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return RxJavaPlugins.m26739a(new FlowableConcatWithCompletable(this, completableSource));
    }

    public final Single<Boolean> contains(Object obj) {
        ObjectHelper.m26573a(obj, "item is null");
        return any(Functions.m26562c(obj));
    }

    public final Single<Long> count() {
        return RxJavaPlugins.m26747a(new FlowableCountSingle(this));
    }

    public final <U> Flowable<T> debounce(Function<? super T, ? extends Publisher<U>> function) {
        ObjectHelper.m26573a((Object) function, "debounceIndicator is null");
        return RxJavaPlugins.m26739a(new FlowableDebounce(this, function));
    }

    public final Flowable<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, Schedulers.m26770a());
    }

    public final Flowable<T> debounce(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26739a(new FlowableDebounceTimed(this, j, timeUnit, scheduler));
    }

    public final Flowable<T> defaultIfEmpty(T t) {
        ObjectHelper.m26573a((Object) t, "item is null");
        return switchIfEmpty(just(t));
    }

    public final <U> Flowable<T> delay(Function<? super T, ? extends Publisher<U>> function) {
        ObjectHelper.m26573a((Object) function, "itemDelayIndicator is null");
        return flatMap(FlowableInternalHelper.m26597a((Function) function));
    }

    public final Flowable<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.m26770a(), false);
    }

    public final Flowable<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, Schedulers.m26770a(), z);
    }

    public final Flowable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    public final Flowable<T> delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26739a(new FlowableDelay(this, Math.max(0, j), timeUnit, scheduler, z));
    }

    public final <U, V> Flowable<T> delay(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function) {
        return delaySubscription(publisher).delay(function);
    }

    public final <U> Flowable<T> delaySubscription(Publisher<U> publisher) {
        ObjectHelper.m26573a((Object) publisher, "subscriptionIndicator is null");
        return RxJavaPlugins.m26739a(new FlowableDelaySubscriptionOther(this, publisher));
    }

    public final Flowable<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, Schedulers.m26770a());
    }

    public final Flowable<T> delaySubscription(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delaySubscription(timer(j, timeUnit, scheduler));
    }

    public final <T2> Flowable<T2> dematerialize() {
        return RxJavaPlugins.m26739a(new FlowableDematerialize(this));
    }

    public final Flowable<T> distinct() {
        return distinct(Functions.m26541a(), Functions.m26566g());
    }

    public final <K> Flowable<T> distinct(Function<? super T, K> function) {
        return distinct(function, Functions.m26566g());
    }

    public final <K> Flowable<T> distinct(Function<? super T, K> function, Callable<? extends Collection<? super K>> callable) {
        ObjectHelper.m26573a((Object) function, "keySelector is null");
        ObjectHelper.m26573a((Object) callable, "collectionSupplier is null");
        return RxJavaPlugins.m26739a(new FlowableDistinct(this, function, callable));
    }

    public final Flowable<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.m26541a());
    }

    public final <K> Flowable<T> distinctUntilChanged(Function<? super T, K> function) {
        ObjectHelper.m26573a((Object) function, "keySelector is null");
        return RxJavaPlugins.m26739a(new FlowableDistinctUntilChanged(this, function, ObjectHelper.m26572a()));
    }

    public final Flowable<T> distinctUntilChanged(BiPredicate<? super T, ? super T> biPredicate) {
        ObjectHelper.m26573a((Object) biPredicate, "comparer is null");
        return RxJavaPlugins.m26739a(new FlowableDistinctUntilChanged(this, Functions.m26541a(), biPredicate));
    }

    public final Flowable<T> doFinally(Action action) {
        ObjectHelper.m26573a((Object) action, "onFinally is null");
        return RxJavaPlugins.m26739a(new FlowableDoFinally(this, action));
    }

    public final Flowable<T> doAfterNext(Consumer<? super T> consumer) {
        ObjectHelper.m26573a((Object) consumer, "onAfterNext is null");
        return RxJavaPlugins.m26739a(new FlowableDoAfterNext(this, consumer));
    }

    public final Flowable<T> doAfterTerminate(Action action) {
        return doOnEach(Functions.m26556b(), Functions.m26556b(), Functions.f25014c, action);
    }

    public final Flowable<T> doOnCancel(Action action) {
        return doOnLifecycle(Functions.m26556b(), Functions.f25018g, action);
    }

    public final Flowable<T> doOnComplete(Action action) {
        return doOnEach(Functions.m26556b(), Functions.m26556b(), action, Functions.f25014c);
    }

    private Flowable<T> doOnEach(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2) {
        ObjectHelper.m26573a((Object) consumer, "onNext is null");
        ObjectHelper.m26573a((Object) consumer2, "onError is null");
        ObjectHelper.m26573a((Object) action, "onComplete is null");
        ObjectHelper.m26573a((Object) action2, "onAfterTerminate is null");
        return RxJavaPlugins.m26739a(new FlowableDoOnEach(this, consumer, consumer2, action, action2));
    }

    public final Flowable<T> doOnEach(Consumer<? super Notification<T>> consumer) {
        ObjectHelper.m26573a((Object) consumer, "consumer is null");
        return doOnEach(Functions.m26540a((Consumer) consumer), Functions.m26557b((Consumer) consumer), Functions.m26560c((Consumer) consumer), Functions.f25014c);
    }

    public final Flowable<T> doOnEach(Subscriber<? super T> subscriber) {
        ObjectHelper.m26573a((Object) subscriber, "subscriber is null");
        return doOnEach(FlowableInternalHelper.m26596a((Subscriber) subscriber), FlowableInternalHelper.m26604b((Subscriber) subscriber), FlowableInternalHelper.m26606c((Subscriber) subscriber), Functions.f25014c);
    }

    public final Flowable<T> doOnError(Consumer<? super Throwable> consumer) {
        return doOnEach(Functions.m26556b(), consumer, Functions.f25014c, Functions.f25014c);
    }

    public final Flowable<T> doOnLifecycle(Consumer<? super Subscription> consumer, LongConsumer longConsumer, Action action) {
        ObjectHelper.m26573a((Object) consumer, "onSubscribe is null");
        ObjectHelper.m26573a((Object) longConsumer, "onRequest is null");
        ObjectHelper.m26573a((Object) action, "onCancel is null");
        return RxJavaPlugins.m26739a(new FlowableDoOnLifecycle(this, consumer, longConsumer, action));
    }

    public final Flowable<T> doOnNext(Consumer<? super T> consumer) {
        return doOnEach(consumer, Functions.m26556b(), Functions.f25014c, Functions.f25014c);
    }

    public final Flowable<T> doOnRequest(LongConsumer longConsumer) {
        return doOnLifecycle(Functions.m26556b(), longConsumer, Functions.f25014c);
    }

    public final Flowable<T> doOnSubscribe(Consumer<? super Subscription> consumer) {
        return doOnLifecycle(consumer, Functions.f25018g, Functions.f25014c);
    }

    public final Flowable<T> doOnTerminate(Action action) {
        return doOnEach(Functions.m26556b(), Functions.m26539a(action), action, Functions.f25014c);
    }

    public final Maybe<T> elementAt(long j) {
        if (j >= 0) {
            return RxJavaPlugins.m26740a(new FlowableElementAtMaybe(this, j));
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
        return RxJavaPlugins.m26747a(new FlowableElementAtSingle(this, j, t));
    }

    public final Single<T> elementAtOrError(long j) {
        if (j >= 0) {
            return RxJavaPlugins.m26747a(new FlowableElementAtSingle(this, j, null));
        }
        StringBuilder stringBuilder = new StringBuilder("index >= 0 required but it was ");
        stringBuilder.append(j);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final Flowable<T> filter(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26739a(new FlowableFilter(this, predicate));
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

    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        return flatMap((Function) function, false, bufferSize(), bufferSize());
    }

    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean z) {
        return flatMap((Function) function, z, bufferSize(), bufferSize());
    }

    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, int i) {
        return flatMap((Function) function, false, i, bufferSize());
    }

    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i) {
        return flatMap((Function) function, z, i, bufferSize());
    }

    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, boolean z, int i, int i2) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        ObjectHelper.m26569a(i2, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.m26739a(new FlowableFlatMap(this, function, z, i, i2));
        }
        z = ((ScalarCallable) this).call();
        if (z) {
            return FlowableScalarXMap.m26612a(z, function);
        }
        return empty();
    }

    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, Function<? super Throwable, ? extends Publisher<? extends R>> function2, Callable<? extends Publisher<? extends R>> callable) {
        ObjectHelper.m26573a((Object) function, "onNextMapper is null");
        ObjectHelper.m26573a((Object) function2, "onErrorMapper is null");
        ObjectHelper.m26573a((Object) callable, "onCompleteSupplier is null");
        return merge(new FlowableMapNotification(this, function, function2, callable));
    }

    public final <R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends R>> function, Function<Throwable, ? extends Publisher<? extends R>> function2, Callable<? extends Publisher<? extends R>> callable, int i) {
        ObjectHelper.m26573a((Object) function, "onNextMapper is null");
        ObjectHelper.m26573a((Object) function2, "onErrorMapper is null");
        ObjectHelper.m26573a((Object) callable, "onCompleteSupplier is null");
        return merge(new FlowableMapNotification(this, function, function2, callable), i);
    }

    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        return flatMap(function, biFunction, false, bufferSize(), bufferSize());
    }

    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return flatMap(function, biFunction, z, bufferSize(), bufferSize());
    }

    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return flatMap(function, biFunction, z, i, bufferSize());
    }

    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i, int i2) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26573a((Object) biFunction, "combiner is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        ObjectHelper.m26569a(i2, "bufferSize");
        return flatMap(FlowableInternalHelper.m26599a((Function) function, (BiFunction) biFunction), z, i, i2);
    }

    public final <U, R> Flowable<R> flatMap(Function<? super T, ? extends Publisher<? extends U>> function, BiFunction<? super T, ? super U, ? extends R> biFunction, int i) {
        return flatMap(function, biFunction, false, i, bufferSize());
    }

    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function) {
        return flatMapCompletable(function, false, RedditJobManager.f10810d);
    }

    public final Completable flatMapCompletable(Function<? super T, ? extends CompletableSource> function, boolean z, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        return RxJavaPlugins.m26737a(new FlowableFlatMapCompletableCompletable(this, function, z, i));
    }

    public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function) {
        return flatMapIterable((Function) function, bufferSize());
    }

    public final <U> Flowable<U> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableFlattenIterable(this, function, i));
    }

    public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26573a((Object) biFunction, "resultSelector is null");
        return flatMap(FlowableInternalHelper.m26605b((Function) function), biFunction, false, bufferSize(), bufferSize());
    }

    public final <U, V> Flowable<V> flatMapIterable(Function<? super T, ? extends Iterable<? extends U>> function, BiFunction<? super T, ? super U, ? extends V> biFunction, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26573a((Object) biFunction, "resultSelector is null");
        return flatMap(FlowableInternalHelper.m26605b((Function) function), biFunction, false, bufferSize(), i);
    }

    public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function) {
        return flatMapMaybe(function, false, RedditJobManager.f10810d);
    }

    public final <R> Flowable<R> flatMapMaybe(Function<? super T, ? extends MaybeSource<? extends R>> function, boolean z, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        return RxJavaPlugins.m26739a(new FlowableFlatMapMaybe(this, function, z, i));
    }

    public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function) {
        return flatMapSingle(function, false, RedditJobManager.f10810d);
    }

    public final <R> Flowable<R> flatMapSingle(Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        return RxJavaPlugins.m26739a(new FlowableFlatMapSingle(this, function, z, i));
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
        FlowableSubscriber forEachWhileSubscriber = new ForEachWhileSubscriber(predicate, consumer, action);
        subscribe(forEachWhileSubscriber);
        return forEachWhileSubscriber;
    }

    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> function) {
        return groupBy(function, Functions.m26541a(), false, bufferSize());
    }

    public final <K> Flowable<GroupedFlowable<K, T>> groupBy(Function<? super T, ? extends K> function, boolean z) {
        return groupBy(function, Functions.m26541a(), z, bufferSize());
    }

    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return groupBy(function, function2, false, bufferSize());
    }

    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z) {
        return groupBy(function, function2, z, bufferSize());
    }

    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z, int i) {
        ObjectHelper.m26573a((Object) function, "keySelector is null");
        ObjectHelper.m26573a((Object) function2, "valueSelector is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableGroupBy(this, function, function2, i, z, null));
    }

    public final <K, V> Flowable<GroupedFlowable<K, V>> groupBy(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, boolean z, int i, Function<? super Consumer<Object>, ? extends Map<K, Object>> function3) {
        ObjectHelper.m26573a((Object) function, "keySelector is null");
        ObjectHelper.m26573a((Object) function2, "valueSelector is null");
        ObjectHelper.m26569a(i, "bufferSize");
        ObjectHelper.m26573a((Object) function3, "evictingMapFactory is null");
        return RxJavaPlugins.m26739a(new FlowableGroupBy(this, function, function2, i, z, function3));
    }

    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> groupJoin(Publisher<? extends TRight> publisher, Function<? super T, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super T, ? super Flowable<TRight>, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        ObjectHelper.m26573a((Object) function, "leftEnd is null");
        ObjectHelper.m26573a((Object) function2, "rightEnd is null");
        ObjectHelper.m26573a((Object) biFunction, "resultSelector is null");
        return RxJavaPlugins.m26739a(new FlowableGroupJoin(this, publisher, function, function2, biFunction));
    }

    public final Flowable<T> hide() {
        return RxJavaPlugins.m26739a(new FlowableHide(this));
    }

    public final Completable ignoreElements() {
        return RxJavaPlugins.m26737a(new FlowableIgnoreElementsCompletable(this));
    }

    public final Single<Boolean> isEmpty() {
        return all(Functions.m26563d());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> Flowable<R> join(Publisher<? extends TRight> publisher, Function<? super T, ? extends Publisher<TLeftEnd>> function, Function<? super TRight, ? extends Publisher<TRightEnd>> function2, BiFunction<? super T, ? super TRight, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        ObjectHelper.m26573a((Object) function, "leftEnd is null");
        ObjectHelper.m26573a((Object) function2, "rightEnd is null");
        ObjectHelper.m26573a((Object) biFunction, "resultSelector is null");
        return RxJavaPlugins.m26739a(new FlowableJoin(this, publisher, function, function2, biFunction));
    }

    public final Maybe<T> lastElement() {
        return RxJavaPlugins.m26740a(new FlowableLastMaybe(this));
    }

    public final Single<T> last(T t) {
        ObjectHelper.m26573a((Object) t, "defaultItem");
        return RxJavaPlugins.m26747a(new FlowableLastSingle(this, t));
    }

    public final Single<T> lastOrError() {
        return RxJavaPlugins.m26747a(new FlowableLastSingle(this, null));
    }

    public final <R> Flowable<R> lift(FlowableOperator<? extends R, ? super T> flowableOperator) {
        ObjectHelper.m26573a((Object) flowableOperator, "lifter is null");
        return RxJavaPlugins.m26739a(new FlowableLift(this, flowableOperator));
    }

    public final Flowable<T> limit(long j) {
        if (j >= 0) {
            return RxJavaPlugins.m26739a(new FlowableLimit(this, j));
        }
        StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final <R> Flowable<R> map(Function<? super T, ? extends R> function) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        return RxJavaPlugins.m26739a(new FlowableMap(this, function));
    }

    public final Flowable<Notification<T>> materialize() {
        return RxJavaPlugins.m26739a(new FlowableMaterialize(this));
    }

    public final Flowable<T> mergeWith(Publisher<? extends T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return merge((Publisher) this, (Publisher) publisher);
    }

    public final Flowable<T> mergeWith(SingleSource<? extends T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "other is null");
        return RxJavaPlugins.m26739a(new FlowableMergeWithSingle(this, singleSource));
    }

    public final Flowable<T> mergeWith(MaybeSource<? extends T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "other is null");
        return RxJavaPlugins.m26739a(new FlowableMergeWithMaybe(this, maybeSource));
    }

    public final Flowable<T> mergeWith(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return RxJavaPlugins.m26739a(new FlowableMergeWithCompletable(this, completableSource));
    }

    public final Flowable<T> observeOn(Scheduler scheduler) {
        return observeOn(scheduler, false, bufferSize());
    }

    public final Flowable<T> observeOn(Scheduler scheduler, boolean z) {
        return observeOn(scheduler, z, bufferSize());
    }

    public final Flowable<T> observeOn(Scheduler scheduler, boolean z, int i) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableObserveOn(this, scheduler, z, i));
    }

    public final <U> Flowable<U> ofType(Class<U> cls) {
        ObjectHelper.m26573a((Object) cls, "clazz is null");
        return filter(Functions.m26559b((Class) cls)).cast(cls);
    }

    public final Flowable<T> onBackpressureBuffer() {
        return onBackpressureBuffer(bufferSize(), false, true);
    }

    public final Flowable<T> onBackpressureBuffer(boolean z) {
        return onBackpressureBuffer(bufferSize(), z, true);
    }

    public final Flowable<T> onBackpressureBuffer(int i) {
        return onBackpressureBuffer(i, false, false);
    }

    public final Flowable<T> onBackpressureBuffer(int i, boolean z) {
        return onBackpressureBuffer(i, z, false);
    }

    public final Flowable<T> onBackpressureBuffer(int i, boolean z, boolean z2) {
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableOnBackpressureBuffer(this, i, z2, z, Functions.f25014c));
    }

    public final Flowable<T> onBackpressureBuffer(int i, boolean z, boolean z2, Action action) {
        ObjectHelper.m26573a((Object) action, "onOverflow is null");
        ObjectHelper.m26569a(i, "capacity");
        return RxJavaPlugins.m26739a(new FlowableOnBackpressureBuffer(this, i, z2, z, action));
    }

    public final Flowable<T> onBackpressureBuffer(int i, Action action) {
        return onBackpressureBuffer(i, false, false, action);
    }

    public final Flowable<T> onBackpressureBuffer(long j, Action action, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        ObjectHelper.m26573a((Object) backpressureOverflowStrategy, "strategy is null");
        ObjectHelper.m26571a(j, "capacity");
        return RxJavaPlugins.m26739a(new FlowableOnBackpressureBufferStrategy(this, j, action, backpressureOverflowStrategy));
    }

    public final Flowable<T> onBackpressureDrop() {
        return RxJavaPlugins.m26739a(new FlowableOnBackpressureDrop(this));
    }

    public final Flowable<T> onBackpressureDrop(Consumer<? super T> consumer) {
        ObjectHelper.m26573a((Object) consumer, "onDrop is null");
        return RxJavaPlugins.m26739a(new FlowableOnBackpressureDrop(this, consumer));
    }

    public final Flowable<T> onBackpressureLatest() {
        return RxJavaPlugins.m26739a(new FlowableOnBackpressureLatest(this));
    }

    public final Flowable<T> onErrorResumeNext(Function<? super Throwable, ? extends Publisher<? extends T>> function) {
        ObjectHelper.m26573a((Object) function, "resumeFunction is null");
        return RxJavaPlugins.m26739a(new FlowableOnErrorNext(this, function, false));
    }

    public final Flowable<T> onErrorResumeNext(Publisher<? extends T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "next is null");
        return onErrorResumeNext(Functions.m26558b((Object) publisher));
    }

    public final Flowable<T> onErrorReturn(Function<? super Throwable, ? extends T> function) {
        ObjectHelper.m26573a((Object) function, "valueSupplier is null");
        return RxJavaPlugins.m26739a(new FlowableOnErrorReturn(this, function));
    }

    public final Flowable<T> onErrorReturnItem(T t) {
        ObjectHelper.m26573a((Object) t, "item is null");
        return onErrorReturn(Functions.m26558b((Object) t));
    }

    public final Flowable<T> onExceptionResumeNext(Publisher<? extends T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "next is null");
        return RxJavaPlugins.m26739a(new FlowableOnErrorNext(this, Functions.m26558b((Object) publisher), true));
    }

    public final Flowable<T> onTerminateDetach() {
        return RxJavaPlugins.m26739a(new FlowableDetach(this));
    }

    public final ParallelFlowable<T> parallel() {
        return ParallelFlowable.m26734a(this);
    }

    public final ParallelFlowable<T> parallel(int i) {
        ObjectHelper.m26569a(i, "parallelism");
        return ParallelFlowable.m26735a(this, i);
    }

    public final ParallelFlowable<T> parallel(int i, int i2) {
        ObjectHelper.m26569a(i, "parallelism");
        ObjectHelper.m26569a(i2, "prefetch");
        return ParallelFlowable.m26736a(this, i, i2);
    }

    public final ConnectableFlowable<T> publish() {
        return publish(bufferSize());
    }

    public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        return publish(function, bufferSize());
    }

    public final <R> Flowable<R> publish(Function<? super Flowable<T>, ? extends Publisher<? extends R>> function, int i) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        ObjectHelper.m26569a(i, "prefetch");
        return RxJavaPlugins.m26739a(new FlowablePublishMulticast(this, function, i));
    }

    public final ConnectableFlowable<T> publish(int i) {
        ObjectHelper.m26569a(i, "bufferSize");
        return FlowablePublish.m38107a(this, i);
    }

    public final Flowable<T> rebatchRequests(int i) {
        return observeOn(ImmediateThinScheduler.f32418b, true, i);
    }

    public final Maybe<T> reduce(BiFunction<T, T, T> biFunction) {
        ObjectHelper.m26573a((Object) biFunction, "reducer is null");
        return RxJavaPlugins.m26740a(new FlowableReduceMaybe(this, biFunction));
    }

    public final <R> Single<R> reduce(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.m26573a((Object) r, "seed is null");
        ObjectHelper.m26573a((Object) biFunction, "reducer is null");
        return RxJavaPlugins.m26747a(new FlowableReduceSeedSingle(this, r, biFunction));
    }

    public final <R> Single<R> reduceWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.m26573a((Object) callable, "seedSupplier is null");
        ObjectHelper.m26573a((Object) biFunction, "reducer is null");
        return RxJavaPlugins.m26747a(new FlowableReduceWithSingle(this, callable, biFunction));
    }

    public final Flowable<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final Flowable<T> repeat(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("times >= 0 required but it was ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (i == 0) {
            return empty();
        } else {
            return RxJavaPlugins.m26739a(new FlowableRepeat(this, j));
        }
    }

    public final Flowable<T> repeatUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.m26573a((Object) booleanSupplier, "stop is null");
        return RxJavaPlugins.m26739a(new FlowableRepeatUntil(this, booleanSupplier));
    }

    public final Flowable<T> repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        ObjectHelper.m26573a((Object) function, "handler is null");
        return RxJavaPlugins.m26739a(new FlowableRepeatWhen(this, function));
    }

    public final ConnectableFlowable<T> replay() {
        return FlowableReplay.m38112a(this);
    }

    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        return FlowableReplay.m38111a(FlowableInternalHelper.m26600a(this), (Function) function);
    }

    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return FlowableReplay.m38111a(FlowableInternalHelper.m26601a(this, i), (Function) function);
    }

    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i, long j, TimeUnit timeUnit) {
        return replay(function, i, j, timeUnit, Schedulers.m26770a());
    }

    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26569a(i, "bufferSize");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return FlowableReplay.m38111a(FlowableInternalHelper.m26602a(this, i, j, timeUnit, scheduler), (Function) function);
    }

    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, int i, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return FlowableReplay.m38111a(FlowableInternalHelper.m26601a(this, i), FlowableInternalHelper.m26598a((Function) function, scheduler));
    }

    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, long j, TimeUnit timeUnit) {
        return replay((Function) function, j, timeUnit, Schedulers.m26770a());
    }

    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return FlowableReplay.m38111a(FlowableInternalHelper.m26603a(this, j, timeUnit, scheduler), (Function) function);
    }

    public final <R> Flowable<R> replay(Function<? super Flowable<T>, ? extends Publisher<R>> function, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) function, "selector is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return FlowableReplay.m38111a(FlowableInternalHelper.m26600a(this), FlowableInternalHelper.m26598a((Function) function, scheduler));
    }

    public final ConnectableFlowable<T> replay(int i) {
        ObjectHelper.m26569a(i, "bufferSize");
        return FlowableReplay.m38113a(this, i);
    }

    public final ConnectableFlowable<T> replay(int i, long j, TimeUnit timeUnit) {
        return replay(i, j, timeUnit, Schedulers.m26770a());
    }

    public final ConnectableFlowable<T> replay(int i, long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26569a(i, "bufferSize");
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return FlowableReplay.m38115a(this, j, timeUnit, scheduler, i);
    }

    public final ConnectableFlowable<T> replay(int i, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return FlowableReplay.m38117a(replay(i), scheduler);
    }

    public final ConnectableFlowable<T> replay(long j, TimeUnit timeUnit) {
        return replay(j, timeUnit, Schedulers.m26770a());
    }

    public final ConnectableFlowable<T> replay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return FlowableReplay.m38114a(this, j, timeUnit, scheduler);
    }

    public final ConnectableFlowable<T> replay(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return FlowableReplay.m38117a(replay(), scheduler);
    }

    public final Flowable<T> retry() {
        return retry(Long.MAX_VALUE, Functions.m26561c());
    }

    public final Flowable<T> retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        ObjectHelper.m26573a((Object) biPredicate, "predicate is null");
        return RxJavaPlugins.m26739a(new FlowableRetryBiPredicate(this, biPredicate));
    }

    public final Flowable<T> retry(long j) {
        return retry(j, Functions.m26561c());
    }

    public final Flowable<T> retry(long j, Predicate<? super Throwable> predicate) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("times >= 0 required but it was ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26739a(new FlowableRetryPredicate(this, j, predicate));
    }

    public final Flowable<T> retry(Predicate<? super Throwable> predicate) {
        return retry(Long.MAX_VALUE, predicate);
    }

    public final Flowable<T> retryUntil(BooleanSupplier booleanSupplier) {
        ObjectHelper.m26573a((Object) booleanSupplier, "stop is null");
        return retry(Long.MAX_VALUE, Functions.m26553a(booleanSupplier));
    }

    public final Flowable<T> retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        ObjectHelper.m26573a((Object) function, "handler is null");
        return RxJavaPlugins.m26739a(new FlowableRetryWhen(this, function));
    }

    public final void safeSubscribe(Subscriber<? super T> subscriber) {
        ObjectHelper.m26573a((Object) subscriber, "s is null");
        if (subscriber instanceof SafeSubscriber) {
            subscribe((SafeSubscriber) subscriber);
        } else {
            subscribe(new SafeSubscriber(subscriber));
        }
    }

    public final Flowable<T> sample(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit, Schedulers.m26770a());
    }

    public final Flowable<T> sample(long j, TimeUnit timeUnit, boolean z) {
        return sample(j, timeUnit, Schedulers.m26770a(), z);
    }

    public final Flowable<T> sample(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26739a(new FlowableSampleTimed(this, j, timeUnit, scheduler, false));
    }

    public final Flowable<T> sample(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26739a(new FlowableSampleTimed(this, j, timeUnit, scheduler, z));
    }

    public final <U> Flowable<T> sample(Publisher<U> publisher) {
        ObjectHelper.m26573a((Object) publisher, "sampler is null");
        return RxJavaPlugins.m26739a(new FlowableSamplePublisher(this, publisher, false));
    }

    public final <U> Flowable<T> sample(Publisher<U> publisher, boolean z) {
        ObjectHelper.m26573a((Object) publisher, "sampler is null");
        return RxJavaPlugins.m26739a(new FlowableSamplePublisher(this, publisher, z));
    }

    public final Flowable<T> scan(BiFunction<T, T, T> biFunction) {
        ObjectHelper.m26573a((Object) biFunction, "accumulator is null");
        return RxJavaPlugins.m26739a(new FlowableScan(this, biFunction));
    }

    public final <R> Flowable<R> scan(R r, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.m26573a((Object) r, "seed is null");
        return scanWith(Functions.m26555a((Object) r), biFunction);
    }

    public final <R> Flowable<R> scanWith(Callable<R> callable, BiFunction<R, ? super T, R> biFunction) {
        ObjectHelper.m26573a((Object) callable, "seedSupplier is null");
        ObjectHelper.m26573a((Object) biFunction, "accumulator is null");
        return RxJavaPlugins.m26739a(new FlowableScanSeed(this, callable, biFunction));
    }

    public final Flowable<T> serialize() {
        return RxJavaPlugins.m26739a(new FlowableSerialized(this));
    }

    public final Flowable<T> share() {
        return RxJavaPlugins.m26739a(new FlowableRefCount(publish()));
    }

    public final Maybe<T> singleElement() {
        return RxJavaPlugins.m26740a(new FlowableSingleMaybe(this));
    }

    public final Single<T> single(T t) {
        ObjectHelper.m26573a((Object) t, "defaultItem is null");
        return RxJavaPlugins.m26747a(new FlowableSingleSingle(this, t));
    }

    public final Single<T> singleOrError() {
        return RxJavaPlugins.m26747a(new FlowableSingleSingle(this, null));
    }

    public final Flowable<T> skip(long j) {
        if (j <= 0) {
            return RxJavaPlugins.m26739a(this);
        }
        return RxJavaPlugins.m26739a(new FlowableSkip(this, j));
    }

    public final Flowable<T> skip(long j, TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    public final Flowable<T> skip(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return skipUntil(timer(j, timeUnit, scheduler));
    }

    public final Flowable<T> skipLast(int i) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
            stringBuilder.append(i);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (i == 0) {
            return RxJavaPlugins.m26739a(this);
        } else {
            return RxJavaPlugins.m26739a(new FlowableSkipLast(this, i));
        }
    }

    public final Flowable<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, Schedulers.m26770a(), false, bufferSize());
    }

    public final Flowable<T> skipLast(long j, TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, Schedulers.m26770a(), z, bufferSize());
    }

    public final Flowable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return skipLast(j, timeUnit, scheduler, false, bufferSize());
    }

    public final Flowable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return skipLast(j, timeUnit, scheduler, z, bufferSize());
    }

    public final Flowable<T> skipLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableSkipLastTimed(this, j, timeUnit, scheduler, i << 1, z));
    }

    public final <U> Flowable<T> skipUntil(Publisher<U> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return RxJavaPlugins.m26739a(new FlowableSkipUntil(this, publisher));
    }

    public final Flowable<T> skipWhile(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26739a(new FlowableSkipWhile(this, predicate));
    }

    public final Flowable<T> sorted() {
        return toList().toFlowable().map(Functions.m26551a(Functions.m26567h())).flatMapIterable(Functions.m26541a());
    }

    public final Flowable<T> sorted(Comparator<? super T> comparator) {
        ObjectHelper.m26573a((Object) comparator, "sortFunction");
        return toList().toFlowable().map(Functions.m26551a((Comparator) comparator)).flatMapIterable(Functions.m26541a());
    }

    public final Flowable<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final Flowable<T> startWith(Publisher<? extends T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return concatArray(publisher, this);
    }

    public final Flowable<T> startWith(T t) {
        ObjectHelper.m26573a((Object) t, "item is null");
        return concatArray(just(t), this);
    }

    public final Flowable<T> startWithArray(T... tArr) {
        if (fromArray(tArr) == empty()) {
            return RxJavaPlugins.m26739a(this);
        }
        return concatArray(fromArray(tArr), this);
    }

    public final Disposable subscribe() {
        return subscribe(Functions.m26556b(), Functions.f25017f, Functions.f25014c, RequestMax.f31301a);
    }

    public final Disposable subscribe(Consumer<? super T> consumer) {
        return subscribe(consumer, Functions.f25017f, Functions.f25014c, RequestMax.f31301a);
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2) {
        return subscribe(consumer, consumer2, Functions.f25014c, RequestMax.f31301a);
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action) {
        return subscribe(consumer, consumer2, action, RequestMax.f31301a);
    }

    public final Disposable subscribe(Consumer<? super T> consumer, Consumer<? super Throwable> consumer2, Action action, Consumer<? super Subscription> consumer3) {
        ObjectHelper.m26573a((Object) consumer, "onNext is null");
        ObjectHelper.m26573a((Object) consumer2, "onError is null");
        ObjectHelper.m26573a((Object) action, "onComplete is null");
        ObjectHelper.m26573a((Object) consumer3, "onSubscribe is null");
        FlowableSubscriber lambdaSubscriber = new LambdaSubscriber(consumer, consumer2, action, consumer3);
        subscribe(lambdaSubscriber);
        return lambdaSubscriber;
    }

    public final void subscribe(Subscriber<? super T> subscriber) {
        if (subscriber instanceof FlowableSubscriber) {
            subscribe((FlowableSubscriber) subscriber);
            return;
        }
        ObjectHelper.m26573a((Object) subscriber, "s is null");
        subscribe(new StrictSubscriber(subscriber));
    }

    public final void subscribe(FlowableSubscriber<? super T> flowableSubscriber) {
        ObjectHelper.m26573a((Object) flowableSubscriber, "s is null");
        try {
            Object a = RxJavaPlugins.m26755a(this, (Subscriber) flowableSubscriber);
            ObjectHelper.m26573a(a, "Plugin returned null Subscriber");
            subscribeActual(a);
        } catch (FlowableSubscriber<? super T> flowableSubscriber2) {
            throw flowableSubscriber2;
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
            new NullPointerException("Actually not, but can't throw other exceptions due to RS").initCause(th);
        }
    }

    public final <E extends Subscriber<? super T>> E subscribeWith(E e) {
        subscribe((Subscriber) e);
        return e;
    }

    public final Flowable<T> subscribeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return subscribeOn(scheduler, !(this instanceof FlowableCreate));
    }

    public final Flowable<T> subscribeOn(Scheduler scheduler, boolean z) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26739a(new FlowableSubscribeOn(this, scheduler, z));
    }

    public final Flowable<T> switchIfEmpty(Publisher<? extends T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return RxJavaPlugins.m26739a(new FlowableSwitchIfEmpty(this, publisher));
    }

    public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> function) {
        return switchMap(function, bufferSize());
    }

    public final <R> Flowable<R> switchMap(Function<? super T, ? extends Publisher<? extends R>> function, int i) {
        return switchMap0(function, i, false);
    }

    public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function) {
        return switchMapDelayError(function, bufferSize());
    }

    public final <R> Flowable<R> switchMapDelayError(Function<? super T, ? extends Publisher<? extends R>> function, int i) {
        return switchMap0(function, i, true);
    }

    <R> Flowable<R> switchMap0(Function<? super T, ? extends Publisher<? extends R>> function, int i, boolean z) {
        ObjectHelper.m26573a((Object) function, "mapper is null");
        ObjectHelper.m26569a(i, "bufferSize");
        if (!(this instanceof ScalarCallable)) {
            return RxJavaPlugins.m26739a(new FlowableSwitchMap(this, function, i, z));
        }
        i = ((ScalarCallable) this).call();
        if (i == 0) {
            return empty();
        }
        return FlowableScalarXMap.m26612a(i, function);
    }

    public final Flowable<T> take(long j) {
        if (j >= 0) {
            return RxJavaPlugins.m26739a(new FlowableTake(this, j));
        }
        StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
        stringBuilder.append(j);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final Flowable<T> take(long j, TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    public final Flowable<T> take(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeUntil(timer(j, timeUnit, scheduler));
    }

    public final Flowable<T> takeLast(int i) {
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
            stringBuilder.append(i);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        } else if (i == 0) {
            return RxJavaPlugins.m26739a(new FlowableIgnoreElements(this));
        } else {
            if (i == 1) {
                return RxJavaPlugins.m26739a(new FlowableTakeLastOne(this));
            }
            return RxJavaPlugins.m26739a(new FlowableTakeLast(this, i));
        }
    }

    public final Flowable<T> takeLast(long j, long j2, TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, Schedulers.m26770a(), false, bufferSize());
    }

    public final Flowable<T> takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j, j2, timeUnit, scheduler, false, bufferSize());
    }

    public final Flowable<T> takeLast(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        long j3 = j;
        Object obj = timeUnit;
        ObjectHelper.m26573a(obj, "unit is null");
        Object obj2 = scheduler;
        ObjectHelper.m26573a(obj2, "scheduler is null");
        int i2 = i;
        ObjectHelper.m26569a(i2, "bufferSize");
        if (j3 >= 0) {
            return RxJavaPlugins.m26739a(new FlowableTakeLastTimed(this, j3, j2, obj, obj2, i2, z));
        }
        StringBuilder stringBuilder = new StringBuilder("count >= 0 required but it was ");
        stringBuilder.append(j3);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public final Flowable<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, Schedulers.m26770a(), false, bufferSize());
    }

    public final Flowable<T> takeLast(long j, TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, Schedulers.m26770a(), z, bufferSize());
    }

    public final Flowable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return takeLast(j, timeUnit, scheduler, false, bufferSize());
    }

    public final Flowable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return takeLast(j, timeUnit, scheduler, z, bufferSize());
    }

    public final Flowable<T> takeLast(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z, int i) {
        return takeLast(Long.MAX_VALUE, j, timeUnit, scheduler, z, i);
    }

    public final Flowable<T> takeUntil(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "stopPredicate is null");
        return RxJavaPlugins.m26739a(new FlowableTakeUntilPredicate(this, predicate));
    }

    public final <U> Flowable<T> takeUntil(Publisher<U> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return RxJavaPlugins.m26739a(new FlowableTakeUntil(this, publisher));
    }

    public final Flowable<T> takeWhile(Predicate<? super T> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26739a(new FlowableTakeWhile(this, predicate));
    }

    public final Flowable<T> throttleFirst(long j, TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, Schedulers.m26770a());
    }

    public final Flowable<T> throttleFirst(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26739a(new FlowableThrottleFirstTimed(this, j, timeUnit, scheduler));
    }

    public final Flowable<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    public final Flowable<T> throttleLast(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return sample(j, timeUnit, scheduler);
    }

    public final Flowable<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    public final Flowable<T> throttleWithTimeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return debounce(j, timeUnit, scheduler);
    }

    public final Flowable<Timed<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, Schedulers.m26770a());
    }

    public final Flowable<Timed<T>> timeInterval(Scheduler scheduler) {
        return timeInterval(TimeUnit.MILLISECONDS, scheduler);
    }

    public final Flowable<Timed<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, Schedulers.m26770a());
    }

    public final Flowable<Timed<T>> timeInterval(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26739a(new FlowableTimeInterval(this, timeUnit, scheduler));
    }

    public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> function) {
        return timeout0(null, function, null);
    }

    public final <V> Flowable<T> timeout(Function<? super T, ? extends Publisher<V>> function, Flowable<? extends T> flowable) {
        ObjectHelper.m26573a((Object) flowable, "other is null");
        return timeout0(null, function, flowable);
    }

    public final Flowable<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, null, Schedulers.m26770a());
    }

    public final Flowable<T> timeout(long j, TimeUnit timeUnit, Publisher<? extends T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return timeout0(j, timeUnit, publisher, Schedulers.m26770a());
    }

    public final Flowable<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return timeout0(j, timeUnit, publisher, scheduler);
    }

    public final Flowable<T> timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, null, scheduler);
    }

    public final <U, V> Flowable<T> timeout(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function) {
        ObjectHelper.m26573a((Object) publisher, "firstTimeoutIndicator is null");
        return timeout0(publisher, function, null);
    }

    public final <U, V> Flowable<T> timeout(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        ObjectHelper.m26573a((Object) publisher, "firstTimeoutSelector is null");
        ObjectHelper.m26573a((Object) publisher2, "other is null");
        return timeout0(publisher, function, publisher2);
    }

    private Flowable<T> timeout0(long j, TimeUnit timeUnit, Publisher<? extends T> publisher, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "timeUnit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26739a(new FlowableTimeoutTimed(this, j, timeUnit, scheduler, publisher));
    }

    private <U, V> Flowable<T> timeout0(Publisher<U> publisher, Function<? super T, ? extends Publisher<V>> function, Publisher<? extends T> publisher2) {
        ObjectHelper.m26573a((Object) function, "itemTimeoutIndicator is null");
        return RxJavaPlugins.m26739a(new FlowableTimeout(this, publisher, function, publisher2));
    }

    public final Flowable<Timed<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, Schedulers.m26770a());
    }

    public final Flowable<Timed<T>> timestamp(Scheduler scheduler) {
        return timestamp(TimeUnit.MILLISECONDS, scheduler);
    }

    public final Flowable<Timed<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, Schedulers.m26770a());
    }

    public final Flowable<Timed<T>> timestamp(TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return map(Functions.m26552a(timeUnit, scheduler));
    }

    public final <R> R to(Function<? super Flowable<T>, R> function) {
        try {
            return ((Function) ObjectHelper.m26573a((Object) function, "converter is null")).apply(this);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            function = ExceptionHelper.m26682a(th);
        }
    }

    public final Single<List<T>> toList() {
        return RxJavaPlugins.m26747a(new FlowableToListSingle(this));
    }

    public final Single<List<T>> toList(int i) {
        ObjectHelper.m26569a(i, "capacityHint");
        return RxJavaPlugins.m26747a(new FlowableToListSingle(this, Functions.m26554a(i)));
    }

    public final <U extends Collection<? super T>> Single<U> toList(Callable<U> callable) {
        ObjectHelper.m26573a((Object) callable, "collectionSupplier is null");
        return RxJavaPlugins.m26747a(new FlowableToListSingle(this, callable));
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

    public final Observable<T> toObservable() {
        return RxJavaPlugins.m26742a(new ObservableFromPublisher(this));
    }

    public final Single<List<T>> toSortedList() {
        return toSortedList(Functions.m26567h());
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
        return toSortedList(Functions.m26567h(), i);
    }

    public final Flowable<T> unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26739a(new FlowableUnsubscribeOn(this, scheduler));
    }

    public final Flowable<Flowable<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    public final Flowable<Flowable<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    public final Flowable<Flowable<T>> window(long j, long j2, int i) {
        ObjectHelper.m26571a(j2, FreeSpaceBox.TYPE);
        ObjectHelper.m26571a(j, "count");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableWindow(this, j, j2, i));
    }

    public final Flowable<Flowable<T>> window(long j, long j2, TimeUnit timeUnit) {
        return window(j, j2, timeUnit, Schedulers.m26770a(), bufferSize());
    }

    public final Flowable<Flowable<T>> window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, j2, timeUnit, scheduler, bufferSize());
    }

    public final Flowable<Flowable<T>> window(long j, long j2, TimeUnit timeUnit, Scheduler scheduler, int i) {
        int i2 = i;
        ObjectHelper.m26569a(i2, "bufferSize");
        long j3 = j;
        ObjectHelper.m26571a(j3, "timespan");
        long j4 = j2;
        ObjectHelper.m26571a(j4, "timeskip");
        Object obj = scheduler;
        ObjectHelper.m26573a(obj, "scheduler is null");
        Object obj2 = timeUnit;
        ObjectHelper.m26573a(obj2, "unit is null");
        return RxJavaPlugins.m26739a(new FlowableWindowTimed(this, j3, j4, obj2, obj, Long.MAX_VALUE, i2, false));
    }

    public final Flowable<Flowable<T>> window(long j, TimeUnit timeUnit) {
        return window(j, timeUnit, Schedulers.m26770a(), Long.MAX_VALUE, false);
    }

    public final Flowable<Flowable<T>> window(long j, TimeUnit timeUnit, long j2) {
        return window(j, timeUnit, Schedulers.m26770a(), j2, false);
    }

    public final Flowable<Flowable<T>> window(long j, TimeUnit timeUnit, long j2, boolean z) {
        return window(j, timeUnit, Schedulers.m26770a(), j2, z);
    }

    public final Flowable<Flowable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return window(j, timeUnit, scheduler, Long.MAX_VALUE, false);
    }

    public final Flowable<Flowable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2) {
        return window(j, timeUnit, scheduler, j2, false);
    }

    public final Flowable<Flowable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z) {
        return window(j, timeUnit, scheduler, j2, z, bufferSize());
    }

    public final Flowable<Flowable<T>> window(long j, TimeUnit timeUnit, Scheduler scheduler, long j2, boolean z, int i) {
        int i2 = i;
        ObjectHelper.m26569a(i2, "bufferSize");
        Object obj = scheduler;
        ObjectHelper.m26573a(obj, "scheduler is null");
        Object obj2 = timeUnit;
        ObjectHelper.m26573a(obj2, "unit is null");
        long j3 = j2;
        ObjectHelper.m26571a(j3, "count");
        return RxJavaPlugins.m26739a(new FlowableWindowTimed(this, j, j, obj2, obj, j3, i2, z));
    }

    public final <B> Flowable<Flowable<T>> window(Publisher<B> publisher) {
        return window((Publisher) publisher, bufferSize());
    }

    public final <B> Flowable<Flowable<T>> window(Publisher<B> publisher, int i) {
        ObjectHelper.m26573a((Object) publisher, "boundaryIndicator is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableWindowBoundary(this, publisher, i));
    }

    public final <U, V> Flowable<Flowable<T>> window(Publisher<U> publisher, Function<? super U, ? extends Publisher<V>> function) {
        return window((Publisher) publisher, (Function) function, bufferSize());
    }

    public final <U, V> Flowable<Flowable<T>> window(Publisher<U> publisher, Function<? super U, ? extends Publisher<V>> function, int i) {
        ObjectHelper.m26573a((Object) publisher, "openingIndicator is null");
        ObjectHelper.m26573a((Object) function, "closingIndicator is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableWindowBoundarySelector(this, publisher, function, i));
    }

    public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> callable) {
        return window((Callable) callable, bufferSize());
    }

    public final <B> Flowable<Flowable<T>> window(Callable<? extends Publisher<B>> callable, int i) {
        ObjectHelper.m26573a((Object) callable, "boundaryIndicatorSupplier is null");
        ObjectHelper.m26569a(i, "bufferSize");
        return RxJavaPlugins.m26739a(new FlowableWindowBoundarySupplier(this, callable, i));
    }

    public final <U, R> Flowable<R> withLatestFrom(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        ObjectHelper.m26573a((Object) biFunction, "combiner is null");
        return RxJavaPlugins.m26739a(new FlowableWithLatestFrom(this, biFunction, publisher));
    }

    public final <T1, T2, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Function3<? super T, ? super T1, ? super T2, R> function3) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        return withLatestFrom(new Publisher[]{publisher, publisher2}, Functions.m26543a((Function3) function3));
    }

    public final <T1, T2, T3, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Function4<? super T, ? super T1, ? super T2, ? super T3, R> function4) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        return withLatestFrom(new Publisher[]{publisher, publisher2, publisher3}, Functions.m26544a((Function4) function4));
    }

    public final <T1, T2, T3, T4, R> Flowable<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Publisher<T4> publisher4, Function5<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> function5) {
        ObjectHelper.m26573a((Object) publisher, "source1 is null");
        ObjectHelper.m26573a((Object) publisher2, "source2 is null");
        ObjectHelper.m26573a((Object) publisher3, "source3 is null");
        ObjectHelper.m26573a((Object) publisher4, "source4 is null");
        return withLatestFrom(new Publisher[]{publisher, publisher2, publisher3, publisher4}, Functions.m26545a((Function5) function5));
    }

    public final <R> Flowable<R> withLatestFrom(Publisher<?>[] publisherArr, Function<? super Object[], R> function) {
        ObjectHelper.m26573a((Object) publisherArr, "others is null");
        ObjectHelper.m26573a((Object) function, "combiner is null");
        return RxJavaPlugins.m26739a(new FlowableWithLatestFromMany(this, (Publisher[]) publisherArr, (Function) function));
    }

    public final <R> Flowable<R> withLatestFrom(Iterable<? extends Publisher<?>> iterable, Function<? super Object[], R> function) {
        ObjectHelper.m26573a((Object) iterable, "others is null");
        ObjectHelper.m26573a((Object) function, "combiner is null");
        return RxJavaPlugins.m26739a(new FlowableWithLatestFromMany(this, (Iterable) iterable, (Function) function));
    }

    public final <U, R> Flowable<R> zipWith(Iterable<U> iterable, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) iterable, "other is null");
        ObjectHelper.m26573a((Object) biFunction, "zipper is null");
        return RxJavaPlugins.m26739a(new FlowableZipIterable(this, iterable, biFunction));
    }

    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return zip(this, publisher, biFunction);
    }

    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z) {
        return zip((Publisher) this, (Publisher) publisher, (BiFunction) biFunction, z);
    }

    public final <U, R> Flowable<R> zipWith(Publisher<? extends U> publisher, BiFunction<? super T, ? super U, ? extends R> biFunction, boolean z, int i) {
        return zip((Publisher) this, (Publisher) publisher, (BiFunction) biFunction, z, i);
    }

    public final TestSubscriber<T> test() {
        FlowableSubscriber testSubscriber = new TestSubscriber();
        subscribe(testSubscriber);
        return testSubscriber;
    }

    public final TestSubscriber<T> test(long j) {
        FlowableSubscriber testSubscriber = new TestSubscriber(j);
        subscribe(testSubscriber);
        return testSubscriber;
    }

    public final TestSubscriber<T> test(long j, boolean z) {
        FlowableSubscriber testSubscriber = new TestSubscriber(j);
        if (z) {
            testSubscriber.cancel();
        }
        subscribe(testSubscriber);
        return testSubscriber;
    }
}
