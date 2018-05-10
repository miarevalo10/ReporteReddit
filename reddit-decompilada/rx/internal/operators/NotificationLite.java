package rx.internal.operators;

import java.io.Serializable;
import rx.Observer;

public final class NotificationLite<T> {
    private static final NotificationLite f41316a = new NotificationLite();
    private static final Object f41317b = new C30671();
    private static final Object f41318c = new C30682();

    static class C30671 implements Serializable {
        public final String toString() {
            return "Notification=>Completed";
        }

        C30671() {
        }
    }

    static class C30682 implements Serializable {
        public final String toString() {
            return "Notification=>NULL";
        }

        C30682() {
        }
    }

    static final class OnErrorSentinel implements Serializable {
        final Throwable f41315a;

        public OnErrorSentinel(Throwable th) {
            this.f41315a = th;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Notification=>Error:");
            stringBuilder.append(this.f41315a);
            return stringBuilder.toString();
        }
    }

    private NotificationLite() {
    }

    public static <T> NotificationLite<T> m43450a() {
        return f41316a;
    }

    public static Object m43448a(T t) {
        return t == null ? f41318c : t;
    }

    public static Object m43452b() {
        return f41317b;
    }

    public static Object m43449a(Throwable th) {
        return new OnErrorSentinel(th);
    }

    public static boolean m43451a(Observer<? super T> observer, Object obj) {
        if (obj == f41317b) {
            observer.mo7906b();
            return true;
        } else if (obj == f41318c) {
            observer.a_(null);
            return false;
        } else if (obj == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        } else if (obj.getClass() == OnErrorSentinel.class) {
            observer.mo7904a(((OnErrorSentinel) obj).f41315a);
            return true;
        } else {
            observer.a_(obj);
            return false;
        }
    }

    public static boolean m43453b(Object obj) {
        return obj == f41317b ? true : null;
    }

    public static T m43454c(Object obj) {
        return obj == f41318c ? null : obj;
    }
}
