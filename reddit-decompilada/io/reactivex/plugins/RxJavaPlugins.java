package io.reactivex.plugins;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.parallel.ParallelFlowable;
import java.util.concurrent.Callable;
import org.reactivestreams.Subscriber;

public final class RxJavaPlugins {
    static volatile Consumer<? super Throwable> f25206a;
    static volatile Function<? super Runnable, ? extends Runnable> f25207b;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f25208c;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f25209d;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f25210e;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> f25211f;
    static volatile Function<? super Scheduler, ? extends Scheduler> f25212g;
    static volatile Function<? super Scheduler, ? extends Scheduler> f25213h;
    static volatile Function<? super Flowable, ? extends Flowable> f25214i;
    static volatile Function<? super ConnectableFlowable, ? extends ConnectableFlowable> f25215j;
    static volatile Function<? super Observable, ? extends Observable> f25216k;
    static volatile Function<? super ConnectableObservable, ? extends ConnectableObservable> f25217l;
    static volatile Function<? super Maybe, ? extends Maybe> f25218m;
    static volatile Function<? super Single, ? extends Single> f25219n;
    static volatile Function<? super Completable, ? extends Completable> f25220o;
    static volatile Function<? super ParallelFlowable, ? extends ParallelFlowable> f25221p;
    static volatile BiFunction<? super Flowable, ? super Subscriber, ? extends Subscriber> f25222q;
    static volatile BiFunction<? super Maybe, ? super MaybeObserver, ? extends MaybeObserver> f25223r;
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> f25224s;
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> f25225t;
    static volatile BiFunction<? super Completable, ? super CompletableObserver, ? extends CompletableObserver> f25226u;
    static volatile BooleanSupplier f25227v;
    static volatile boolean f25228w;
    static volatile boolean f25229x;

    public static boolean m26758a() {
        return f25229x;
    }

    public static Scheduler m26746a(Callable<Scheduler> callable) {
        ObjectHelper.m26573a((Object) callable, "Scheduler Callable can't be null");
        Function function = f25208c;
        if (function == null) {
            return m26765e(callable);
        }
        return m26745a(function, (Callable) callable);
    }

    public static Scheduler m26760b(Callable<Scheduler> callable) {
        ObjectHelper.m26573a((Object) callable, "Scheduler Callable can't be null");
        Function function = f25210e;
        if (function == null) {
            return m26765e(callable);
        }
        return m26745a(function, (Callable) callable);
    }

    public static Scheduler m26763c(Callable<Scheduler> callable) {
        ObjectHelper.m26573a((Object) callable, "Scheduler Callable can't be null");
        Function function = f25211f;
        if (function == null) {
            return m26765e(callable);
        }
        return m26745a(function, (Callable) callable);
    }

    public static Scheduler m26764d(Callable<Scheduler> callable) {
        ObjectHelper.m26573a((Object) callable, "Scheduler Callable can't be null");
        Function function = f25209d;
        if (function == null) {
            return m26765e(callable);
        }
        return m26745a(function, (Callable) callable);
    }

    public static Scheduler m26744a(Scheduler scheduler) {
        Function function = f25212g;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m26753a(function, (Object) scheduler);
    }

    public static void m26757a(Throwable th) {
        Consumer consumer = f25206a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else {
            Object obj = 1;
            if (!(th instanceof OnErrorNotImplementedException)) {
                if (!(th instanceof MissingBackpressureException)) {
                    if (!(th instanceof IllegalStateException)) {
                        if (!(th instanceof NullPointerException)) {
                            if (!(th instanceof IllegalArgumentException)) {
                                if (!(th instanceof CompositeException)) {
                                    obj = null;
                                }
                            }
                        }
                    }
                }
            }
            if (obj == null) {
                th = new UndeliverableException(th);
            }
        }
        if (consumer != null) {
            try {
                consumer.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                m26761b(th2);
            }
        }
        th.printStackTrace();
        m26761b(th);
    }

    private static void m26761b(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static Scheduler m26759b(Scheduler scheduler) {
        Function function = f25213h;
        if (function == null) {
            return scheduler;
        }
        return (Scheduler) m26753a(function, (Object) scheduler);
    }

    public static Runnable m26754a(Runnable runnable) {
        ObjectHelper.m26573a((Object) runnable, "run is null");
        Function function = f25207b;
        if (function == null) {
            return runnable;
        }
        return (Runnable) m26753a(function, (Object) runnable);
    }

    public static void m26756a(Consumer<? super Throwable> consumer) {
        if (f25228w) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f25206a = consumer;
    }

    public static <T> Subscriber<? super T> m26755a(Flowable<T> flowable, Subscriber<? super T> subscriber) {
        BiFunction biFunction = f25222q;
        return biFunction != null ? (Subscriber) m26752a(biFunction, flowable, subscriber) : subscriber;
    }

    public static <T> Observer<? super T> m26743a(Observable<T> observable, Observer<? super T> observer) {
        BiFunction biFunction = f25224s;
        return biFunction != null ? (Observer) m26752a(biFunction, observable, observer) : observer;
    }

    public static <T> SingleObserver<? super T> m26748a(Single<T> single, SingleObserver<? super T> singleObserver) {
        BiFunction biFunction = f25225t;
        return biFunction != null ? (SingleObserver) m26752a(biFunction, single, singleObserver) : singleObserver;
    }

    public static CompletableObserver m26738a(Completable completable, CompletableObserver completableObserver) {
        BiFunction biFunction = f25226u;
        return biFunction != null ? (CompletableObserver) m26752a(biFunction, completable, completableObserver) : completableObserver;
    }

    public static <T> MaybeObserver<? super T> m26741a(Maybe<T> maybe, MaybeObserver<? super T> maybeObserver) {
        BiFunction biFunction = f25223r;
        return biFunction != null ? (MaybeObserver) m26752a(biFunction, maybe, maybeObserver) : maybeObserver;
    }

    public static <T> Maybe<T> m26740a(Maybe<T> maybe) {
        Function function = f25218m;
        return function != null ? (Maybe) m26753a(function, (Object) maybe) : maybe;
    }

    public static <T> Flowable<T> m26739a(Flowable<T> flowable) {
        Function function = f25214i;
        return function != null ? (Flowable) m26753a(function, (Object) flowable) : flowable;
    }

    public static <T> ConnectableFlowable<T> m26749a(ConnectableFlowable<T> connectableFlowable) {
        Function function = f25215j;
        return function != null ? (ConnectableFlowable) m26753a(function, (Object) connectableFlowable) : connectableFlowable;
    }

    public static <T> Observable<T> m26742a(Observable<T> observable) {
        Function function = f25216k;
        return function != null ? (Observable) m26753a(function, (Object) observable) : observable;
    }

    public static <T> ConnectableObservable<T> m26750a(ConnectableObservable<T> connectableObservable) {
        Function function = f25217l;
        return function != null ? (ConnectableObservable) m26753a(function, (Object) connectableObservable) : connectableObservable;
    }

    public static <T> Single<T> m26747a(Single<T> single) {
        Function function = f25219n;
        return function != null ? (Single) m26753a(function, (Object) single) : single;
    }

    public static Completable m26737a(Completable completable) {
        Function function = f25220o;
        return function != null ? (Completable) m26753a(function, (Object) completable) : completable;
    }

    public static <T> ParallelFlowable<T> m26751a(ParallelFlowable<T> parallelFlowable) {
        Function function = f25221p;
        return function != null ? (ParallelFlowable) m26753a(function, (Object) parallelFlowable) : parallelFlowable;
    }

    public static boolean m26762b() {
        BooleanSupplier booleanSupplier = f25227v;
        if (booleanSupplier == null) {
            return false;
        }
        try {
            return booleanSupplier.mo6617a();
        } catch (Throwable th) {
            RuntimeException a = ExceptionHelper.m26682a(th);
        }
    }

    private static <T, R> R m26753a(Function<T, R> function, T t) {
        try {
            return function.apply(t);
        } catch (Throwable th) {
            function = ExceptionHelper.m26682a(th);
        }
    }

    private static <T, U, R> R m26752a(BiFunction<T, U, R> biFunction, T t, U u) {
        try {
            return biFunction.apply(t, u);
        } catch (Throwable th) {
            biFunction = ExceptionHelper.m26682a(th);
        }
    }

    private static Scheduler m26765e(Callable<Scheduler> callable) {
        try {
            return (Scheduler) ObjectHelper.m26573a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            callable = ExceptionHelper.m26682a(th);
        }
    }

    private static Scheduler m26745a(Function<? super Callable<Scheduler>, ? extends Scheduler> function, Callable<Scheduler> callable) {
        return (Scheduler) ObjectHelper.m26573a(m26753a((Function) function, (Object) callable), "Scheduler Callable result can't be null");
    }
}
