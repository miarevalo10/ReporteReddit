package rx;

import java.util.concurrent.TimeUnit;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.OnSubscribeConcatMap;
import rx.internal.operators.OnSubscribeDefer;
import rx.internal.operators.OnSubscribeFromArray;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OnSubscribeLift;
import rx.internal.operators.OnSubscribeMap;
import rx.internal.operators.OnSubscribeRange;
import rx.internal.operators.OnSubscribeThrow;
import rx.internal.operators.OnSubscribeTimerOnce;
import rx.internal.operators.OperatorDebounceWithTime;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorObserveOn;
import rx.internal.operators.OperatorSubscribeOn;
import rx.internal.operators.OperatorZip;
import rx.internal.util.ActionSubscriber;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ObserverSubscriber;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.observers.SafeSubscriber;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

public class Observable<T> {
    final OnSubscribe<T> f41302a;

    public interface OnSubscribe<T> extends Action1<Subscriber<? super T>> {
    }

    public interface Operator<R, T> extends Func1<Subscriber<? super R>, Subscriber<? super T>> {
    }

    protected Observable(OnSubscribe<T> onSubscribe) {
        this.f41302a = onSubscribe;
    }

    public static <T> Observable<T> m43391a(OnSubscribe<T> onSubscribe) {
        return new Observable(RxJavaHooks.m43493a((OnSubscribe) onSubscribe));
    }

    public final <R> Observable<R> m43402a(Operator<? extends R, ? super T> operator) {
        return m43391a(new OnSubscribeLift(this.f41302a, operator));
    }

    public static <T> Observable<T> m43394a(Func0<Observable<T>> func0) {
        return m43391a(new OnSubscribeDefer(func0));
    }

    public static <T> Observable<T> m43388a() {
        return EmptyObservableHolder.m44011a();
    }

    public static <T> Observable<T> m43399b(Throwable th) {
        return m43391a(new OnSubscribeThrow(th));
    }

    public static <T> Observable<T> m43390a(Iterable<? extends T> iterable) {
        return m43391a(new OnSubscribeFromIterable(iterable));
    }

    private static <T> Observable<T> m43395a(T[] tArr) {
        int length = tArr.length;
        if (length == 0) {
            return EmptyObservableHolder.m44011a();
        }
        if (length == 1) {
            return ScalarSynchronousObservable.m43907a(tArr[0]);
        }
        return m43391a(new OnSubscribeFromArray(tArr));
    }

    public static <T> Observable<T> m43398b(T t) {
        return ScalarSynchronousObservable.m43907a(t);
    }

    public static <T> Observable<T> m43392a(Observable<? extends Observable<? extends T>> observable) {
        if (observable.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) observable).m43909c(UtilityFunctions.m43474b());
        }
        return observable.m43402a(OperatorMerge.m44077a());
    }

    public static <T> Observable<T> m43396a(Observable<? extends T>[] observableArr) {
        return m43392a(m43395a((Object[]) observableArr));
    }

    public static <T> Observable<T> m43400b(Observable<? extends T>[] observableArr) {
        observableArr = m43395a((Object[]) observableArr);
        if (observableArr.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) observableArr).m43909c(UtilityFunctions.m43474b());
        }
        return observableArr.m43402a(OperatorMerge.m44078b());
    }

    public static Observable<Integer> m43401c() {
        return m43391a(new OnSubscribeRange());
    }

    public static Observable<Long> m43389a(long j, TimeUnit timeUnit) {
        return m43391a(new OnSubscribeTimerOnce(j, timeUnit, Schedulers.m43532c()));
    }

    public static <T1, T2, R> Observable<R> m43393a(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return ScalarSynchronousObservable.m43907a(new Observable[]{observable, observable2}).m43402a(new OperatorZip(func2));
    }

    public final <R> Observable<R> m43404a(Func1<? super T, ? extends Observable<? extends R>> func1) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).m43909c((Func1) func1);
        }
        return m43391a(new OnSubscribeConcatMap(this, func1));
    }

    public final Observable<T> m43408b(long j, TimeUnit timeUnit) {
        return m43402a(new OperatorDebounceWithTime(j, timeUnit, Schedulers.m43532c()));
    }

    public final <R> Observable<R> m43410b(Func1<? super T, ? extends R> func1) {
        return m43391a(new OnSubscribeMap(this, func1));
    }

    public final Observable<T> m43403a(Scheduler scheduler) {
        int i = RxRingBuffer.f41779b;
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).m43908c(scheduler);
        }
        return m43402a(new OperatorObserveOn(scheduler, i));
    }

    public final Subscription m43407a(Action1<? super T> action1) {
        if (action1 != null) {
            return m43397a(new ActionSubscriber(action1, InternalObservableUtils.f41357g, Actions.m43440a()), this);
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final Subscription m43405a(Observer<? super T> observer) {
        if (observer instanceof Subscriber) {
            return m43397a((Subscriber) observer, this);
        }
        return m43397a(new ObserverSubscriber(observer), this);
    }

    public final Subscription m43406a(Subscriber<? super T> subscriber) {
        try {
            subscriber.aV_();
            RxJavaHooks.m43494a(this, this.f41302a).mo7899a(subscriber);
            return RxJavaHooks.m43497a((Subscription) subscriber);
        } catch (Subscriber<? super T> subscriber2) {
            Exceptions.m43435b(subscriber2);
            StringBuilder stringBuilder = new StringBuilder("Error occurred attempting to subscribe [");
            stringBuilder.append(th.getMessage());
            stringBuilder.append("] and then again while trying to pass to onError.");
            RxJavaHooks.m43501b(new OnErrorFailedException(stringBuilder.toString(), subscriber2));
        }
    }

    public static <T> Subscription m43397a(Subscriber<? super T> subscriber, Observable<T> observable) {
        Subscription safeSubscriber;
        if (subscriber == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        } else if (observable.f41302a == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        } else {
            subscriber.aV_();
            if (!(subscriber instanceof SafeSubscriber)) {
                safeSubscriber = new SafeSubscriber(subscriber);
            }
            try {
                RxJavaHooks.m43494a(observable, observable.f41302a).mo7899a(safeSubscriber);
                return RxJavaHooks.m43497a(safeSubscriber);
            } catch (Subscriber<? super T> subscriber2) {
                Exceptions.m43435b(subscriber2);
                StringBuilder stringBuilder = new StringBuilder("Error occurred attempting to subscribe [");
                stringBuilder.append(th.getMessage());
                stringBuilder.append("] and then again while trying to pass to onError.");
                RxJavaHooks.m43501b(new OnErrorFailedException(stringBuilder.toString(), subscriber2));
            }
        }
    }

    public final Observable<T> m43409b(Scheduler scheduler) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).m43908c(scheduler);
        }
        return m43391a(new OperatorSubscribeOn(this, scheduler));
    }
}
