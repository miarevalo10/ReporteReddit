package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.io.Serializable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public enum NotificationLite {
    ;

    static final class DisposableNotification implements Serializable {
        final Disposable f25195a;

        DisposableNotification(Disposable disposable) {
            this.f25195a = disposable;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotificationLite.Disposable[");
            stringBuilder.append(this.f25195a);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    static final class ErrorNotification implements Serializable {
        final Throwable f25196a;

        ErrorNotification(Throwable th) {
            this.f25196a = th;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotificationLite.Error[");
            stringBuilder.append(this.f25196a);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        public final int hashCode() {
            return this.f25196a.hashCode();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ErrorNotification)) {
                return null;
            }
            return ObjectHelper.m26574a(this.f25196a, ((ErrorNotification) obj).f25196a);
        }
    }

    static final class SubscriptionNotification implements Serializable {
        final Subscription f25197a;

        SubscriptionNotification(Subscription subscription) {
            this.f25197a = subscription;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("NotificationLite.Subscription[");
            stringBuilder.append(this.f25197a);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static <T> Object m26696a(T t) {
        return t;
    }

    public static <T> T m26706e(Object obj) {
        return obj;
    }

    public final String toString() {
        return "NotificationLite.Complete";
    }

    private NotificationLite(String str) {
    }

    public static Object m26694a() {
        return f25198a;
    }

    public static Object m26697a(Throwable th) {
        return new ErrorNotification(th);
    }

    public static Object m26698a(Subscription subscription) {
        return new SubscriptionNotification(subscription);
    }

    public static Object m26695a(Disposable disposable) {
        return new DisposableNotification(disposable);
    }

    public static boolean m26701b(Object obj) {
        return obj == f25198a ? true : null;
    }

    public static boolean m26704c(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean m26705d(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static Throwable m26707f(Object obj) {
        return ((ErrorNotification) obj).f25196a;
    }

    public static Disposable m26708g(Object obj) {
        return ((DisposableNotification) obj).f25195a;
    }

    public static <T> boolean m26700a(Object obj, Subscriber<? super T> subscriber) {
        if (obj == f25198a) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f25196a);
            return true;
        } else {
            subscriber.onNext(obj);
            return null;
        }
    }

    public static <T> boolean m26699a(Object obj, Observer<? super T> observer) {
        if (obj == f25198a) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f25196a);
            return true;
        } else {
            observer.onNext(obj);
            return null;
        }
    }

    public static <T> boolean m26703b(Object obj, Subscriber<? super T> subscriber) {
        if (obj == f25198a) {
            subscriber.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            subscriber.onError(((ErrorNotification) obj).f25196a);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            subscriber.mo5623a(((SubscriptionNotification) obj).f25197a);
            return false;
        } else {
            subscriber.onNext(obj);
            return false;
        }
    }

    public static <T> boolean m26702b(Object obj, Observer<? super T> observer) {
        if (obj == f25198a) {
            observer.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            observer.onError(((ErrorNotification) obj).f25196a);
            return true;
        } else if (obj instanceof DisposableNotification) {
            observer.onSubscribe(((DisposableNotification) obj).f25195a);
            return false;
        } else {
            observer.onNext(obj);
            return false;
        }
    }
}
