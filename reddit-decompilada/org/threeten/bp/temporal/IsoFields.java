package org.threeten.bp.temporal;

import org.jcodec.codecs.mpeg12.MPEGConst;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class IsoFields {
    public static final TemporalField f41070a = Field.f41523a;
    public static final TemporalField f41071b = Field.f41524b;
    public static final TemporalField f41072c = Field.f41525c;
    public static final TemporalField f41073d = Field.f41526d;
    public static final TemporalUnit f41074e = Unit.WEEK_BASED_YEARS;
    public static final TemporalUnit f41075f = Unit.QUARTER_YEARS;

    private enum Field implements TemporalField {
        ;
        
        static final int[] f41527e = null;

        public final boolean mo7858b() {
            return true;
        }

        public final boolean mo7860c() {
            return false;
        }

        static {
            f41527e = new int[]{0, 90, MPEGConst.EXTENSION_START_CODE, 273, 0, 91, 182, 274};
        }

        static ValueRange m43609a(LocalDate localDate) {
            return ValueRange.m43200a(1, (long) m43608a(m43610b(localDate)));
        }

        static int m43608a(int i) {
            i = LocalDate.a(i, 1, 1);
            if (i.d() != DayOfWeek.d) {
                if (i.d() != DayOfWeek.c || i.e() == 0) {
                    return 52;
                }
            }
            return 53;
        }

        static int m43610b(LocalDate localDate) {
            int i = localDate.d;
            int c = localDate.c();
            if (c <= 3) {
                if (c - localDate.d().ordinal() < -2) {
                    return i - 1;
                }
                return i;
            } else if (c < 363) {
                return i;
            } else {
                return ((c - 363) - localDate.e()) - localDate.d().ordinal() >= 0 ? i + 1 : i;
            }
        }
    }

    private enum Unit implements TemporalUnit {
        WEEK_BASED_YEARS("WeekBasedYears", Duration.a(31556952)),
        QUARTER_YEARS("QuarterYears", Duration.a(7889238));
        
        private final String f41532c;
        private final Duration f41533d;

        public final boolean mo7862a() {
            return true;
        }

        private Unit(String str, Duration duration) {
            this.f41532c = str;
            this.f41533d = duration;
        }

        public final <R extends Temporal> R mo7861a(R r, long j) {
            switch (this) {
                case WEEK_BASED_YEARS:
                    return r.mo7933a(IsoFields.f41073d, Jdk8Methods.m43171b((long) r.mo7853c(IsoFields.f41073d), j));
                case QUARTER_YEARS:
                    return r.mo7934b(j / 256, ChronoUnit.YEARS).mo7934b((j % 256) * 3, ChronoUnit.MONTHS);
                default:
                    throw new IllegalStateException("Unreachable");
            }
        }

        public final String toString() {
            return this.f41532c;
        }
    }
}
