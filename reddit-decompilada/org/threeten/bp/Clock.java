package org.threeten.bp;

import java.io.Serializable;

public abstract class Clock {

    static final class SystemClock extends Clock implements Serializable {
        private final ZoneId f16350a;

        SystemClock(ZoneId zoneId) {
            this.f16350a = zoneId;
        }

        public final boolean equals(Object obj) {
            return obj instanceof SystemClock ? this.f16350a.equals(((SystemClock) obj).f16350a) : null;
        }

        public final int hashCode() {
            return this.f16350a.hashCode() + 1;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("SystemClock[");
            stringBuilder.append(this.f16350a);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }

        public final Instant mo3059b() {
            return Instant.m19816b(System.currentTimeMillis());
        }
    }

    public abstract Instant mo3059b();

    public static Clock m9393a() {
        return new SystemClock(ZoneOffset.f16382d);
    }

    protected Clock() {
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
