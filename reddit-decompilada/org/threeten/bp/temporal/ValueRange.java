package org.threeten.bp.temporal;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;

public final class ValueRange implements Serializable {
    public final long f41083a;
    public final long f41084b;
    public final long f41085c;
    public final long f41086d;

    public static ValueRange m43200a(long j, long j2) {
        if (j <= j2) {
            return new ValueRange(j, j, j2, j2);
        }
        throw new IllegalArgumentException("Minimum value must be less than maximum value");
    }

    public static ValueRange m43202b(long j, long j2) {
        return m43201a(1, j, j2);
    }

    public static ValueRange m43201a(long j, long j2, long j3) {
        if (j > 1) {
            throw new IllegalArgumentException("Smallest minimum value must be less than largest minimum value");
        } else if (j2 > j3) {
            throw new IllegalArgumentException("Smallest maximum value must be less than largest maximum value");
        } else if (1 <= j3) {
            return new ValueRange(j, 1, j2, j3);
        } else {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
    }

    private ValueRange(long j, long j2, long j3, long j4) {
        this.f41083a = j;
        this.f41084b = j2;
        this.f41085c = j3;
        this.f41086d = j4;
    }

    public final long m43203a(long j, TemporalField temporalField) {
        if (m43204a(j)) {
            return j;
        }
        if (temporalField != null) {
            StringBuilder stringBuilder = new StringBuilder("Invalid value for ");
            stringBuilder.append(temporalField);
            stringBuilder.append(" (valid values ");
            stringBuilder.append(this);
            stringBuilder.append("): ");
            stringBuilder.append(j);
            throw new DateTimeException(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder("Invalid value (valid values ");
        stringBuilder2.append(this);
        stringBuilder2.append("): ");
        stringBuilder2.append(j);
        throw new DateTimeException(stringBuilder2.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueRange)) {
            return false;
        }
        ValueRange valueRange = (ValueRange) obj;
        return this.f41083a == valueRange.f41083a && this.f41084b == valueRange.f41084b && this.f41085c == valueRange.f41085c && this.f41086d == valueRange.f41086d;
    }

    public final int hashCode() {
        long j = ((((((this.f41083a + this.f41084b) << ((int) (16 + this.f41084b))) >> ((int) (this.f41085c + 48))) << ((int) (this.f41085c + 32))) >> ((int) (32 + this.f41086d))) << ((int) (48 + this.f41086d))) >> 16;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f41083a);
        if (this.f41083a != this.f41084b) {
            stringBuilder.append('/');
            stringBuilder.append(this.f41084b);
        }
        stringBuilder.append(" - ");
        stringBuilder.append(this.f41085c);
        if (this.f41085c != this.f41086d) {
            stringBuilder.append('/');
            stringBuilder.append(this.f41086d);
        }
        return stringBuilder.toString();
    }

    public final boolean m43204a(long j) {
        return (j < this.f41083a || j > this.f41086d) ? 0 : 1;
    }

    public final int m43205b(long j, TemporalField temporalField) {
        Object obj = null;
        Object obj2 = (this.f41083a < -2147483648L || this.f41086d > 2147483647L) ? null : 1;
        if (obj2 != null && m43204a(j)) {
            obj = 1;
        }
        if (obj != null) {
            return (int) j;
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid int value for ");
        stringBuilder.append(temporalField);
        stringBuilder.append(": ");
        stringBuilder.append(j);
        throw new DateTimeException(stringBuilder.toString());
    }
}
