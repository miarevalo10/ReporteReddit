package io.reactivex.schedulers;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

public final class Timed<T> {
    public final T f25242a;
    public final long f25243b;
    final TimeUnit f25244c;

    public Timed(T t, long j, TimeUnit timeUnit) {
        this.f25242a = t;
        this.f25243b = j;
        this.f25244c = (TimeUnit) ObjectHelper.m26573a((Object) timeUnit, "unit is null");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (ObjectHelper.m26574a(this.f25242a, timed.f25242a) && this.f25243b == timed.f25243b && ObjectHelper.m26574a(this.f25244c, timed.f25244c) != null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f25242a != null ? this.f25242a.hashCode() : 0) * 31) + ((int) ((this.f25243b >>> 31) ^ this.f25243b))) * 31) + this.f25244c.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Timed[time=");
        stringBuilder.append(this.f25243b);
        stringBuilder.append(", unit=");
        stringBuilder.append(this.f25244c);
        stringBuilder.append(", value=");
        stringBuilder.append(this.f25242a);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
