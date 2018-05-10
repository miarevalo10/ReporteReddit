package rx;

public final class Notification<T> {
    private static final Notification<Void> f41298d = new Notification(Kind.OnCompleted, null);
    public final Kind f41299a;
    public final Throwable f41300b;
    private final T f41301c = null;

    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    public static <T> Notification<T> m43382a() {
        return new Notification(Kind.OnNext, null);
    }

    public static <T> Notification<T> m43383a(Throwable th) {
        return new Notification(Kind.OnError, th);
    }

    public static <T> Notification<T> m43384b() {
        return f41298d;
    }

    private Notification(Kind kind, Throwable th) {
        this.f41300b = th;
        this.f41299a = kind;
    }

    private boolean m43386e() {
        return m43387c() && this.f41300b != null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append('[');
        stringBuilder.append(super.toString());
        stringBuilder.append(' ');
        stringBuilder.append(this.f41299a);
        if (m43385d()) {
            stringBuilder.append(' ');
            stringBuilder.append(this.f41301c);
        }
        if (m43386e()) {
            stringBuilder.append(' ');
            stringBuilder.append(this.f41300b.getMessage());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.f41299a != this.f41299a) {
            return false;
        }
        if (this.f41301c != notification.f41301c && (this.f41301c == null || !this.f41301c.equals(notification.f41301c))) {
            return false;
        }
        if (this.f41300b != notification.f41300b) {
            if (this.f41300b == null || this.f41300b.equals(notification.f41300b) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean m43385d() {
        return (this.f41299a == Kind.OnNext) && this.f41301c != null;
    }

    public final boolean m43387c() {
        return this.f41299a == Kind.OnError;
    }

    public final int hashCode() {
        int hashCode = this.f41299a.hashCode();
        if (m43385d()) {
            hashCode = (hashCode * 31) + this.f41301c.hashCode();
        }
        return m43386e() ? (hashCode * 31) + this.f41300b.hashCode() : hashCode;
    }
}
