package org.threeten.bp.temporal;

import org.threeten.bp.DayOfWeek;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class TemporalAdjusters {

    private static final class RelativeDayOfWeek implements TemporalAdjuster {
        private final int f41534a;
        private final int f41535b;

        private RelativeDayOfWeek(int i, DayOfWeek dayOfWeek) {
            Jdk8Methods.m43168a((Object) dayOfWeek, "dayOfWeek");
            this.f41534a = i;
            this.f41535b = dayOfWeek.ordinal() + 1;
        }

        public final Temporal mo7863a(Temporal temporal) {
            int c = temporal.mo7853c(ChronoField.DAY_OF_WEEK);
            if (this.f41534a < 2 && c == this.f41535b) {
                return temporal;
            }
            if ((this.f41534a & 1) == 0) {
                c -= this.f41535b;
                return temporal.mo7934b((long) (c >= 0 ? 7 - c : -c), ChronoUnit.DAYS);
            }
            int i = this.f41535b - c;
            return temporal.mo7925a((long) (i >= 0 ? 7 - i : -i), ChronoUnit.DAYS);
        }
    }

    public static TemporalAdjuster m43181a(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(0, dayOfWeek);
    }

    public static TemporalAdjuster m43182b(DayOfWeek dayOfWeek) {
        return new RelativeDayOfWeek(1, dayOfWeek);
    }
}
