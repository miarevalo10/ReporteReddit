package rx.plugins;

import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Single;
import rx.Subscription;

public abstract class RxJavaSingleExecutionHook {
    @Deprecated
    public static <T> Throwable m43525a(Throwable th) {
        return th;
    }

    @Deprecated
    public static <T> OnSubscribe<T> m43526a(OnSubscribe<T> onSubscribe) {
        return onSubscribe;
    }

    @Deprecated
    public static <T, R> Operator<? extends R, ? super T> m43527a(Operator<? extends R, ? super T> operator) {
        return operator;
    }

    @Deprecated
    public static <T> Single.OnSubscribe<T> m43528a(Single.OnSubscribe<T> onSubscribe) {
        return onSubscribe;
    }

    @Deprecated
    public static <T> Subscription m43529a(Subscription subscription) {
        return subscription;
    }
}
