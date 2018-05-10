package io.reactivex;

import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.util.NotificationLite;

public final class Notification<T> {
    static final Notification<Object> f24988b = new Notification(null);
    public final Object f24989a;

    private Notification(Object obj) {
        this.f24989a = obj;
    }

    public final boolean m26486a() {
        return this.f24989a == null;
    }

    public final boolean m26487b() {
        Object obj = this.f24989a;
        return (obj == null || NotificationLite.m26704c(obj)) ? false : true;
    }

    public final T m26488c() {
        Object obj = this.f24989a;
        return (obj == null || NotificationLite.m26704c(obj)) ? null : this.f24989a;
    }

    public final Throwable m26489d() {
        Object obj = this.f24989a;
        return NotificationLite.m26704c(obj) ? NotificationLite.m26707f(obj) : null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Notification)) {
            return null;
        }
        return ObjectHelper.m26574a(this.f24989a, ((Notification) obj).f24989a);
    }

    public final int hashCode() {
        Object obj = this.f24989a;
        return obj != null ? obj.hashCode() : 0;
    }

    public final String toString() {
        Object obj = this.f24989a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.m26704c(obj)) {
            StringBuilder stringBuilder = new StringBuilder("OnErrorNotification[");
            stringBuilder.append(NotificationLite.m26707f(obj));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder("OnNextNotification[");
        stringBuilder2.append(this.f24989a);
        stringBuilder2.append("]");
        return stringBuilder2.toString();
    }

    public static <T> Notification<T> m26483a(T t) {
        ObjectHelper.m26573a((Object) t, "value is null");
        return new Notification(t);
    }

    public static <T> Notification<T> m26484a(Throwable th) {
        ObjectHelper.m26573a((Object) th, "error is null");
        return new Notification(NotificationLite.m26697a(th));
    }

    public static <T> Notification<T> m26485e() {
        return f24988b;
    }
}
