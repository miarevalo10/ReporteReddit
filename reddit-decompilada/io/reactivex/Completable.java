package io.reactivex;

import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.fuseable.FuseToFlowable;
import io.reactivex.internal.fuseable.FuseToMaybe;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.observers.BlockingMultiObserver;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAmb;
import io.reactivex.internal.operators.completable.CompletableCache;
import io.reactivex.internal.operators.completable.CompletableConcat;
import io.reactivex.internal.operators.completable.CompletableConcatArray;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDefer;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableDetach;
import io.reactivex.internal.operators.completable.CompletableDisposeOn;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableDoOnEvent;
import io.reactivex.internal.operators.completable.CompletableEmpty;
import io.reactivex.internal.operators.completable.CompletableError;
import io.reactivex.internal.operators.completable.CompletableErrorSupplier;
import io.reactivex.internal.operators.completable.CompletableFromAction;
import io.reactivex.internal.operators.completable.CompletableFromCallable;
import io.reactivex.internal.operators.completable.CompletableFromObservable;
import io.reactivex.internal.operators.completable.CompletableFromPublisher;
import io.reactivex.internal.operators.completable.CompletableFromRunnable;
import io.reactivex.internal.operators.completable.CompletableFromSingle;
import io.reactivex.internal.operators.completable.CompletableFromUnsafeSource;
import io.reactivex.internal.operators.completable.CompletableHide;
import io.reactivex.internal.operators.completable.CompletableLift;
import io.reactivex.internal.operators.completable.CompletableMerge;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorArray;
import io.reactivex.internal.operators.completable.CompletableMergeDelayErrorIterable;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.internal.operators.completable.CompletableNever;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableOnErrorComplete;
import io.reactivex.internal.operators.completable.CompletablePeek;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.CompletableTimeout;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.internal.operators.completable.CompletableToFlowable;
import io.reactivex.internal.operators.completable.CompletableToObservable;
import io.reactivex.internal.operators.completable.CompletableToSingle;
import io.reactivex.internal.operators.completable.CompletableUsing;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.internal.operators.maybe.MaybeFromCompletable;
import io.reactivex.internal.operators.observable.ObservableDelaySubscriptionOther;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

public abstract class Completable implements CompletableSource {
    public abstract void subscribeActual(CompletableObserver completableObserver);

    public static Completable ambArray(CompletableSource... completableSourceArr) {
        ObjectHelper.m26573a((Object) completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return RxJavaPlugins.m26737a(new CompletableAmb(completableSourceArr, null));
    }

    public static Completable amb(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26737a(new CompletableAmb(null, iterable));
    }

    public static Completable complete() {
        return RxJavaPlugins.m26737a(CompletableEmpty.f34734a);
    }

    public static Completable concatArray(CompletableSource... completableSourceArr) {
        ObjectHelper.m26573a((Object) completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return RxJavaPlugins.m26737a(new CompletableConcatArray(completableSourceArr));
    }

    public static Completable concat(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26737a(new CompletableConcatIterable(iterable));
    }

    public static Completable concat(Publisher<? extends CompletableSource> publisher) {
        return concat(publisher, 2);
    }

    public static Completable concat(Publisher<? extends CompletableSource> publisher, int i) {
        ObjectHelper.m26573a((Object) publisher, "sources is null");
        ObjectHelper.m26569a(i, "prefetch");
        return RxJavaPlugins.m26737a(new CompletableConcat(publisher, i));
    }

    public static Completable create(CompletableOnSubscribe completableOnSubscribe) {
        ObjectHelper.m26573a((Object) completableOnSubscribe, "source is null");
        return RxJavaPlugins.m26737a(new CompletableCreate(completableOnSubscribe));
    }

    public static Completable unsafeCreate(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "source is null");
        if (!(completableSource instanceof Completable)) {
            return RxJavaPlugins.m26737a(new CompletableFromUnsafeSource(completableSource));
        }
        throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
    }

    public static Completable defer(Callable<? extends CompletableSource> callable) {
        ObjectHelper.m26573a((Object) callable, "completableSupplier");
        return RxJavaPlugins.m26737a(new CompletableDefer(callable));
    }

    public static Completable error(Callable<? extends Throwable> callable) {
        ObjectHelper.m26573a((Object) callable, "errorSupplier is null");
        return RxJavaPlugins.m26737a(new CompletableErrorSupplier(callable));
    }

    public static Completable error(Throwable th) {
        ObjectHelper.m26573a((Object) th, "error is null");
        return RxJavaPlugins.m26737a(new CompletableError(th));
    }

    public static Completable fromAction(Action action) {
        ObjectHelper.m26573a((Object) action, "run is null");
        return RxJavaPlugins.m26737a(new CompletableFromAction(action));
    }

    public static Completable fromCallable(Callable<?> callable) {
        ObjectHelper.m26573a((Object) callable, "callable is null");
        return RxJavaPlugins.m26737a(new CompletableFromCallable(callable));
    }

    public static Completable fromFuture(Future<?> future) {
        ObjectHelper.m26573a((Object) future, "future is null");
        return fromAction(Functions.m26535a((Future) future));
    }

    public static Completable fromRunnable(Runnable runnable) {
        ObjectHelper.m26573a((Object) runnable, "run is null");
        return RxJavaPlugins.m26737a(new CompletableFromRunnable(runnable));
    }

    public static <T> Completable fromObservable(ObservableSource<T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "observable is null");
        return RxJavaPlugins.m26737a(new CompletableFromObservable(observableSource));
    }

    public static <T> Completable fromPublisher(Publisher<T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "publisher is null");
        return RxJavaPlugins.m26737a(new CompletableFromPublisher(publisher));
    }

    public static <T> Completable fromSingle(SingleSource<T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "single is null");
        return RxJavaPlugins.m26737a(new CompletableFromSingle(singleSource));
    }

    public static Completable mergeArray(CompletableSource... completableSourceArr) {
        ObjectHelper.m26573a((Object) completableSourceArr, "sources is null");
        if (completableSourceArr.length == 0) {
            return complete();
        }
        if (completableSourceArr.length == 1) {
            return wrap(completableSourceArr[0]);
        }
        return RxJavaPlugins.m26737a(new CompletableMergeArray(completableSourceArr));
    }

    public static Completable merge(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26737a(new CompletableMergeIterable(iterable));
    }

    public static Completable merge(Publisher<? extends CompletableSource> publisher) {
        return merge0(publisher, RedditJobManager.f10810d, false);
    }

    public static Completable merge(Publisher<? extends CompletableSource> publisher, int i) {
        return merge0(publisher, i, false);
    }

    private static Completable merge0(Publisher<? extends CompletableSource> publisher, int i, boolean z) {
        ObjectHelper.m26573a((Object) publisher, "sources is null");
        ObjectHelper.m26569a(i, "maxConcurrency");
        return RxJavaPlugins.m26737a(new CompletableMerge(publisher, i, z));
    }

    public static Completable mergeArrayDelayError(CompletableSource... completableSourceArr) {
        ObjectHelper.m26573a((Object) completableSourceArr, "sources is null");
        return RxJavaPlugins.m26737a(new CompletableMergeDelayErrorArray(completableSourceArr));
    }

    public static Completable mergeDelayError(Iterable<? extends CompletableSource> iterable) {
        ObjectHelper.m26573a((Object) iterable, "sources is null");
        return RxJavaPlugins.m26737a(new CompletableMergeDelayErrorIterable(iterable));
    }

    public static Completable mergeDelayError(Publisher<? extends CompletableSource> publisher) {
        return merge0(publisher, RedditJobManager.f10810d, true);
    }

    public static Completable mergeDelayError(Publisher<? extends CompletableSource> publisher, int i) {
        return merge0(publisher, i, true);
    }

    public static Completable never() {
        return RxJavaPlugins.m26737a(CompletableNever.f34762a);
    }

    public static Completable timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, Schedulers.m26770a());
    }

    public static Completable timer(long j, TimeUnit timeUnit, Scheduler scheduler) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26737a(new CompletableTimer(j, timeUnit, scheduler));
    }

    private static NullPointerException toNpe(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static <R> Completable using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer) {
        return using(callable, function, consumer, true);
    }

    public static <R> Completable using(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z) {
        ObjectHelper.m26573a((Object) callable, "resourceSupplier is null");
        ObjectHelper.m26573a((Object) function, "completableFunction is null");
        ObjectHelper.m26573a((Object) consumer, "disposer is null");
        return RxJavaPlugins.m26737a(new CompletableUsing(callable, function, consumer, z));
    }

    public static Completable wrap(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "source is null");
        if (completableSource instanceof Completable) {
            return RxJavaPlugins.m26737a((Completable) completableSource);
        }
        return RxJavaPlugins.m26737a(new CompletableFromUnsafeSource(completableSource));
    }

    public final Completable ambWith(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return ambArray(this, completableSource);
    }

    public final <T> Observable<T> andThen(ObservableSource<T> observableSource) {
        ObjectHelper.m26573a((Object) observableSource, "next is null");
        return RxJavaPlugins.m26742a(new ObservableDelaySubscriptionOther(observableSource, toObservable()));
    }

    public final <T> Flowable<T> andThen(Publisher<T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "next is null");
        return RxJavaPlugins.m26739a(new FlowableDelaySubscriptionOther(publisher, toFlowable()));
    }

    public final <T> Single<T> andThen(SingleSource<T> singleSource) {
        ObjectHelper.m26573a((Object) singleSource, "next is null");
        return RxJavaPlugins.m26747a(new SingleDelayWithCompletable(singleSource, this));
    }

    public final <T> Maybe<T> andThen(MaybeSource<T> maybeSource) {
        ObjectHelper.m26573a((Object) maybeSource, "next is null");
        return RxJavaPlugins.m26740a(new MaybeDelayWithCompletable(maybeSource, this));
    }

    public final Completable andThen(CompletableSource completableSource) {
        return concatWith(completableSource);
    }

    public final <R> R as(CompletableConverter<? extends R> completableConverter) {
        return ((CompletableConverter) ObjectHelper.m26573a((Object) completableConverter, "converter is null")).m26469a();
    }

    public final void blockingAwait() {
        CompletableObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        blockingMultiObserver.m32116a();
    }

    public final boolean blockingAwait(long j, TimeUnit timeUnit) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        CompletableObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.m32120b(j, timeUnit);
    }

    public final Throwable blockingGet() {
        CompletableObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.m32119b();
    }

    public final Throwable blockingGet(long j, TimeUnit timeUnit) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        CompletableObserver blockingMultiObserver = new BlockingMultiObserver();
        subscribe(blockingMultiObserver);
        return blockingMultiObserver.m32118a(j, timeUnit);
    }

    public final Completable cache() {
        return RxJavaPlugins.m26737a(new CompletableCache(this));
    }

    public final Completable compose(CompletableTransformer completableTransformer) {
        return wrap(((CompletableTransformer) ObjectHelper.m26573a((Object) completableTransformer, "transformer is null")).m26471a());
    }

    public final Completable concatWith(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return concatArray(this, completableSource);
    }

    public final Completable delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, Schedulers.m26770a(), false);
    }

    public final Completable delay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return delay(j, timeUnit, scheduler, false);
    }

    public final Completable delay(long j, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26737a(new CompletableDelay(this, j, timeUnit, scheduler, z));
    }

    public final Completable doOnComplete(Action action) {
        return doOnLifecycle(Functions.m26556b(), Functions.m26556b(), action, Functions.f25014c, Functions.f25014c, Functions.f25014c);
    }

    public final Completable doOnDispose(Action action) {
        return doOnLifecycle(Functions.m26556b(), Functions.m26556b(), Functions.f25014c, Functions.f25014c, Functions.f25014c, action);
    }

    public final Completable doOnError(Consumer<? super Throwable> consumer) {
        return doOnLifecycle(Functions.m26556b(), consumer, Functions.f25014c, Functions.f25014c, Functions.f25014c, Functions.f25014c);
    }

    public final Completable doOnEvent(Consumer<? super Throwable> consumer) {
        ObjectHelper.m26573a((Object) consumer, "onEvent is null");
        return RxJavaPlugins.m26737a(new CompletableDoOnEvent(this, consumer));
    }

    private Completable doOnLifecycle(Consumer<? super Disposable> consumer, Consumer<? super Throwable> consumer2, Action action, Action action2, Action action3, Action action4) {
        ObjectHelper.m26573a((Object) consumer, "onSubscribe is null");
        ObjectHelper.m26573a((Object) consumer2, "onError is null");
        ObjectHelper.m26573a((Object) action, "onComplete is null");
        ObjectHelper.m26573a((Object) action2, "onTerminate is null");
        ObjectHelper.m26573a((Object) action3, "onAfterTerminate is null");
        ObjectHelper.m26573a((Object) action4, "onDispose is null");
        return RxJavaPlugins.m26737a(new CompletablePeek(this, consumer, consumer2, action, action2, action3, action4));
    }

    public final Completable doOnSubscribe(Consumer<? super Disposable> consumer) {
        return doOnLifecycle(consumer, Functions.m26556b(), Functions.f25014c, Functions.f25014c, Functions.f25014c, Functions.f25014c);
    }

    public final Completable doOnTerminate(Action action) {
        return doOnLifecycle(Functions.m26556b(), Functions.m26556b(), Functions.f25014c, action, Functions.f25014c, Functions.f25014c);
    }

    public final Completable doAfterTerminate(Action action) {
        return doOnLifecycle(Functions.m26556b(), Functions.m26556b(), Functions.f25014c, Functions.f25014c, action, Functions.f25014c);
    }

    public final Completable doFinally(Action action) {
        ObjectHelper.m26573a((Object) action, "onFinally is null");
        return RxJavaPlugins.m26737a(new CompletableDoFinally(this, action));
    }

    public final Completable lift(CompletableOperator completableOperator) {
        ObjectHelper.m26573a((Object) completableOperator, "onLift is null");
        return RxJavaPlugins.m26737a(new CompletableLift(this, completableOperator));
    }

    public final Completable mergeWith(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return mergeArray(this, completableSource);
    }

    public final Completable observeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26737a(new CompletableObserveOn(this, scheduler));
    }

    public final Completable onErrorComplete() {
        return onErrorComplete(Functions.m26561c());
    }

    public final Completable onErrorComplete(Predicate<? super Throwable> predicate) {
        ObjectHelper.m26573a((Object) predicate, "predicate is null");
        return RxJavaPlugins.m26737a(new CompletableOnErrorComplete(this, predicate));
    }

    public final Completable onErrorResumeNext(Function<? super Throwable, ? extends CompletableSource> function) {
        ObjectHelper.m26573a((Object) function, "errorMapper is null");
        return RxJavaPlugins.m26737a(new CompletableResumeNext(this, function));
    }

    public final Completable onTerminateDetach() {
        return RxJavaPlugins.m26737a(new CompletableDetach(this));
    }

    public final Completable repeat() {
        return fromPublisher(toFlowable().repeat());
    }

    public final Completable repeat(long j) {
        return fromPublisher(toFlowable().repeat(j));
    }

    public final Completable repeatUntil(BooleanSupplier booleanSupplier) {
        return fromPublisher(toFlowable().repeatUntil(booleanSupplier));
    }

    public final Completable repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> function) {
        return fromPublisher(toFlowable().repeatWhen(function));
    }

    public final Completable retry() {
        return fromPublisher(toFlowable().retry());
    }

    public final Completable retry(BiPredicate<? super Integer, ? super Throwable> biPredicate) {
        return fromPublisher(toFlowable().retry((BiPredicate) biPredicate));
    }

    public final Completable retry(long j) {
        return fromPublisher(toFlowable().retry(j));
    }

    public final Completable retry(long j, Predicate<? super Throwable> predicate) {
        return fromPublisher(toFlowable().retry(j, predicate));
    }

    public final Completable retry(Predicate<? super Throwable> predicate) {
        return fromPublisher(toFlowable().retry((Predicate) predicate));
    }

    public final Completable retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> function) {
        return fromPublisher(toFlowable().retryWhen(function));
    }

    public final Completable startWith(CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return concatArray(completableSource, this);
    }

    public final <T> Observable<T> startWith(Observable<T> observable) {
        ObjectHelper.m26573a((Object) observable, "other is null");
        return observable.concatWith(toObservable());
    }

    public final <T> Flowable<T> startWith(Publisher<T> publisher) {
        ObjectHelper.m26573a((Object) publisher, "other is null");
        return toFlowable().startWith((Publisher) publisher);
    }

    public final Completable hide() {
        return RxJavaPlugins.m26737a(new CompletableHide(this));
    }

    public final Disposable subscribe() {
        CompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        subscribe(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    public final void subscribe(CompletableObserver completableObserver) {
        ObjectHelper.m26573a((Object) completableObserver, "s is null");
        try {
            subscribeActual(RxJavaPlugins.m26738a(this, completableObserver));
        } catch (CompletableObserver completableObserver2) {
            throw completableObserver2;
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            RxJavaPlugins.m26757a(th);
            completableObserver2 = toNpe(th);
        }
    }

    public final <E extends CompletableObserver> E subscribeWith(E e) {
        subscribe((CompletableObserver) e);
        return e;
    }

    public final Disposable subscribe(Action action, Consumer<? super Throwable> consumer) {
        ObjectHelper.m26573a((Object) consumer, "onError is null");
        ObjectHelper.m26573a((Object) action, "onComplete is null");
        CompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(consumer, action);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final Disposable subscribe(Action action) {
        ObjectHelper.m26573a((Object) action, "onComplete is null");
        CompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(action);
        subscribe(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    public final Completable subscribeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26737a(new CompletableSubscribeOn(this, scheduler));
    }

    public final Completable timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, Schedulers.m26770a(), null);
    }

    public final Completable timeout(long j, TimeUnit timeUnit, CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return timeout0(j, timeUnit, Schedulers.m26770a(), completableSource);
    }

    public final Completable timeout(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return timeout0(j, timeUnit, scheduler, null);
    }

    public final Completable timeout(long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) completableSource, "other is null");
        return timeout0(j, timeUnit, scheduler, completableSource);
    }

    private Completable timeout0(long j, TimeUnit timeUnit, Scheduler scheduler, CompletableSource completableSource) {
        ObjectHelper.m26573a((Object) timeUnit, "unit is null");
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26737a(new CompletableTimeout(this, j, timeUnit, scheduler, completableSource));
    }

    public final <U> U to(Function<? super Completable, U> function) {
        try {
            return ((Function) ObjectHelper.m26573a((Object) function, "converter is null")).apply(this);
        } catch (Throwable th) {
            Exceptions.m26521b(th);
            function = ExceptionHelper.m26682a(th);
        }
    }

    public final <T> Flowable<T> toFlowable() {
        if (this instanceof FuseToFlowable) {
            return ((FuseToFlowable) this).mo6616a();
        }
        return RxJavaPlugins.m26739a(new CompletableToFlowable(this));
    }

    public final <T> Maybe<T> toMaybe() {
        if (this instanceof FuseToMaybe) {
            return ((FuseToMaybe) this).mo6633a();
        }
        return RxJavaPlugins.m26740a(new MaybeFromCompletable(this));
    }

    public final <T> Observable<T> toObservable() {
        if (this instanceof FuseToObservable) {
            return ((FuseToObservable) this).mo6641a();
        }
        return RxJavaPlugins.m26742a(new CompletableToObservable(this));
    }

    public final <T> Single<T> toSingle(Callable<? extends T> callable) {
        ObjectHelper.m26573a((Object) callable, "completionValueSupplier is null");
        return RxJavaPlugins.m26747a(new CompletableToSingle(this, callable, null));
    }

    public final <T> Single<T> toSingleDefault(T t) {
        ObjectHelper.m26573a((Object) t, "completionValue is null");
        return RxJavaPlugins.m26747a(new CompletableToSingle(this, null, t));
    }

    public final Completable unsubscribeOn(Scheduler scheduler) {
        ObjectHelper.m26573a((Object) scheduler, "scheduler is null");
        return RxJavaPlugins.m26737a(new CompletableDisposeOn(this, scheduler));
    }

    public final TestObserver<Void> test() {
        CompletableObserver testObserver = new TestObserver();
        subscribe(testObserver);
        return testObserver;
    }

    public final TestObserver<Void> test(boolean z) {
        CompletableObserver testObserver = new TestObserver();
        if (z) {
            testObserver.m36021c();
        }
        subscribe(testObserver);
        return testObserver;
    }
}
