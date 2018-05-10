package rx.plugins;

import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Subscription;

public abstract class RxJavaObservableExecutionHook {
    @Deprecated
    public static <T> Throwable m43505a(Throwable th) {
        return th;
    }

    @Deprecated
    public static <T> OnSubscribe<T> m43506a(OnSubscribe<T> onSubscribe) {
        return onSubscribe;
    }

    @Deprecated
    public static <T, R> Operator<? extends R, ? super T> m43507a(Operator<? extends R, ? super T> operator) {
        return operator;
    }

    @Deprecated
    public static <T> Subscription m43508a(Subscription subscription) {
        return subscription;
    }

    @Deprecated
    public static <T> OnSubscribe<T> m43509b(OnSubscribe<T> onSubscribe) {
        return onSubscribe;
    }
}
