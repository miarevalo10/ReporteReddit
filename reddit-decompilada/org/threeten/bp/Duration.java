package org.threeten.bp;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.regex.Pattern;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class Duration implements Serializable, Comparable<Duration> {
    public static final Duration f10928a = new Duration(0, 0);
    private static final BigInteger f10929c = BigInteger.valueOf(1000000000);
    private static final Pattern f10930d = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);
    public final long f10931b;
    private final int f10932e;

    public final /* synthetic */ int compareTo(Object obj) {
        Duration duration = (Duration) obj;
        int a = Jdk8Methods.a(this.f10931b, duration.f10931b);
        if (a != 0) {
            return a;
        }
        return this.f10932e - duration.f10932e;
    }

    public static Duration m9396a(long j) {
        return m9397a(j, 0);
    }

    public static Duration m9395a() {
        return m9397a(Jdk8Methods.b(Long.MAX_VALUE, Jdk8Methods.d(999999999, 1000000000)), Jdk8Methods.b(999999999, 1000000000));
    }

    public static Duration m9398b(long j) {
        long j2 = j / 1000000000;
        j = (int) (j % 1000000000);
        if (j < null) {
            j += 1000000000;
            j2--;
        }
        return m9397a(j2, j);
    }

    private static Duration m9397a(long j, int i) {
        if ((((long) i) | j) == 0) {
            return f10928a;
        }
        return new Duration(j, i);
    }

    private Duration(long j, int i) {
        this.f10931b = j;
        this.f10932e = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.f10931b == duration.f10931b && this.f10932e == duration.f10932e;
    }

    public final int hashCode() {
        return ((int) (this.f10931b ^ (this.f10931b >>> 32))) + (51 * this.f10932e);
    }

    public final String toString() {
        if (this == f10928a) {
            return "PT0S";
        }
        long j = this.f10931b / 3600;
        int i = (int) ((this.f10931b % 3600) / 60);
        int i2 = (int) (this.f10931b % 60);
        StringBuilder stringBuilder = new StringBuilder(24);
        stringBuilder.append("PT");
        if (j != 0) {
            stringBuilder.append(j);
            stringBuilder.append('H');
        }
        if (i != 0) {
            stringBuilder.append(i);
            stringBuilder.append('M');
        }
        if (i2 == 0 && this.f10932e == 0 && stringBuilder.length() > 2) {
            return stringBuilder.toString();
        }
        if (i2 >= 0 || this.f10932e <= 0) {
            stringBuilder.append(i2);
        } else if (i2 == -1) {
            stringBuilder.append("-0");
        } else {
            stringBuilder.append(i2 + 1);
        }
        if (this.f10932e > 0) {
            int length = stringBuilder.length();
            if (i2 < 0) {
                stringBuilder.append(2000000000 - this.f10932e);
            } else {
                stringBuilder.append(this.f10932e + 1000000000);
            }
            while (stringBuilder.charAt(stringBuilder.length() - 1) == '0') {
                stringBuilder.setLength(stringBuilder.length() - 1);
            }
            stringBuilder.setCharAt(length, '.');
        }
        stringBuilder.append('S');
        return stringBuilder.toString();
    }
}
