package org.threeten.bp;

import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.chrono.ChronoPeriod;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAccessor;

public final class Period extends ChronoPeriod implements Serializable {
    public static final Period f16376a = new Period(0, 0, 0);
    private static final Pattern f16377e = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
    public final int f16378b;
    public final int f16379c;
    public final int f16380d;

    private Period(int i, int i2, int i3) {
        this.f16378b = i;
        this.f16379c = i2;
        this.f16380d = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.f16378b == period.f16378b && this.f16379c == period.f16379c && this.f16380d == period.f16380d;
    }

    public final int hashCode() {
        return (this.f16378b + Integer.rotateLeft(this.f16379c, 8)) + Integer.rotateLeft(this.f16380d, 16);
    }

    public final String toString() {
        if (this == f16376a) {
            return "P0D";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('P');
        if (this.f16378b != 0) {
            stringBuilder.append(this.f16378b);
            stringBuilder.append('Y');
        }
        if (this.f16379c != 0) {
            stringBuilder.append(this.f16379c);
            stringBuilder.append('M');
        }
        if (this.f16380d != 0) {
            stringBuilder.append(this.f16380d);
            stringBuilder.append('D');
        }
        return stringBuilder.toString();
    }

    public static Period m16451a(LocalDate localDate, LocalDate localDate2) {
        localDate2 = LocalDate.m21390a((TemporalAccessor) localDate2);
        long a = localDate2.m21399a() - localDate.m21399a();
        int i = localDate2.f19778e - localDate.f19778e;
        int i2 = (a > 0 ? 1 : (a == 0 ? 0 : -1));
        if (i2 > 0 && i < 0) {
            a--;
            i = (int) (localDate2.m21427g() - localDate.m21416c(a).m21427g());
        } else if (i2 < 0 && i > 0) {
            a++;
            i -= localDate2.m21426f();
        }
        localDate = (int) (a % 12);
        localDate2 = Jdk8Methods.a(a / 12);
        if (((localDate2 | localDate) | i) == 0) {
            return f16376a;
        }
        return new Period(localDate2, localDate, i);
    }
}
