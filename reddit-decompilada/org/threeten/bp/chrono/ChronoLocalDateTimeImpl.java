package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.LocalTime;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.ValueRange;

final class ChronoLocalDateTimeImpl<D extends ChronoLocalDate> extends ChronoLocalDateTime<D> implements Serializable, Temporal, TemporalAdjuster {
    final D f42060a;
    private final LocalTime f42061b;

    public final /* synthetic */ Temporal mo7926a(TemporalAdjuster temporalAdjuster) {
        return m44220c(temporalAdjuster);
    }

    public final /* synthetic */ Temporal mo7933a(TemporalField temporalField, long j) {
        return m44229b(temporalField, j);
    }

    public final /* synthetic */ ChronoLocalDateTime mo7937b(TemporalAdjuster temporalAdjuster) {
        return m44220c(temporalAdjuster);
    }

    public final /* synthetic */ Temporal mo7934b(long j, TemporalUnit temporalUnit) {
        return m44234c(j, temporalUnit);
    }

    public final /* synthetic */ ChronoLocalDateTime mo7938c(TemporalField temporalField, long j) {
        return m44229b(temporalField, j);
    }

    public final /* synthetic */ ChronoLocalDateTime mo7939e(long j, TemporalUnit temporalUnit) {
        return m44234c(j, temporalUnit);
    }

    static <R extends ChronoLocalDate> ChronoLocalDateTimeImpl<R> m44216a(R r, LocalTime localTime) {
        return new ChronoLocalDateTimeImpl(r, localTime);
    }

    private ChronoLocalDateTimeImpl(D d, LocalTime localTime) {
        Jdk8Methods.m43168a((Object) d, "date");
        Jdk8Methods.m43168a((Object) localTime, "time");
        this.f42060a = d;
        this.f42061b = localTime;
    }

    private ChronoLocalDateTimeImpl<D> m44217a(Temporal temporal, LocalTime localTime) {
        if (this.f42060a == temporal && this.f42061b == localTime) {
            return this;
        }
        return new ChronoLocalDateTimeImpl(this.f42060a.m44176h().m43119a(temporal), localTime);
    }

    public final D mo7936b() {
        return this.f42060a;
    }

    public final LocalTime mo7935a() {
        return this.f42061b;
    }

    public final boolean mo7919a(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return (temporalField == null || temporalField.mo7856a(this) == null) ? false : true;
        } else {
            if (!temporalField.mo7858b()) {
                if (temporalField.mo7860c() == null) {
                    return false;
                }
            }
            return true;
        }
    }

    public final ValueRange mo7852b(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.mo7860c() ? this.f42061b.b(temporalField) : this.f42060a.mo7852b(temporalField);
        } else {
            return temporalField.mo7857b(this);
        }
    }

    public final int mo7853c(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.mo7860c() ? this.f42061b.c(temporalField) : this.f42060a.mo7853c(temporalField);
        } else {
            return mo7852b(temporalField).m43205b(mo7920d(temporalField), temporalField);
        }
    }

    public final long mo7920d(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.mo7860c() ? this.f42061b.d(temporalField) : this.f42060a.mo7920d(temporalField);
        } else {
            return temporalField.mo7859c(this);
        }
    }

    private ChronoLocalDateTimeImpl<D> m44220c(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof ChronoLocalDate) {
            return m44217a((ChronoLocalDate) temporalAdjuster, this.f42061b);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return m44217a(this.f42060a, (LocalTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof ChronoLocalDateTimeImpl) {
            return this.f42060a.m44176h().m43124b((ChronoLocalDateTimeImpl) temporalAdjuster);
        }
        return this.f42060a.m44176h().m43124b((ChronoLocalDateTimeImpl) temporalAdjuster.mo7863a(this));
    }

    public final ChronoLocalDateTimeImpl<D> m44229b(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return this.f42060a.m44176h().m43124b(temporalField.mo7854a(this, j));
        }
        if (temporalField.mo7860c()) {
            return m44217a(this.f42060a, this.f42061b.b(temporalField, j));
        }
        return m44217a(this.f42060a.m44171c(temporalField, j), this.f42061b);
    }

    public final ChronoLocalDateTimeImpl<D> m44234c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return this.f42060a.m44176h().m43124b(temporalUnit.mo7861a(this, j));
        }
        switch ((ChronoUnit) temporalUnit) {
            case NANOS:
                return m44221d(j);
            case MICROS:
                return m44218b(j / 86400000000L).m44221d((j % 86400000000L) * 1000);
            case MILLIS:
                return m44218b(j / 86400000).m44221d((j % 86400000) * 1000000);
            case SECONDS:
                return m44223a(j);
            case MINUTES:
                return m44215a(this.f42060a, 0, j, 0, 0);
            case HOURS:
                return m44219c(j);
            case HALF_DAYS:
                return m44218b(j / 256).m44219c((j % 256) * 12);
            default:
                return m44217a(this.f42060a.m44173e(j, temporalUnit), this.f42061b);
        }
    }

    private ChronoLocalDateTimeImpl<D> m44218b(long j) {
        return m44217a(this.f42060a.m44173e(j, ChronoUnit.DAYS), this.f42061b);
    }

    private ChronoLocalDateTimeImpl<D> m44219c(long j) {
        return m44215a(this.f42060a, j, 0, 0, 0);
    }

    final ChronoLocalDateTimeImpl<D> m44223a(long j) {
        return m44215a(this.f42060a, 0, 0, j, 0);
    }

    private ChronoLocalDateTimeImpl<D> m44221d(long j) {
        return m44215a(this.f42060a, 0, 0, 0, j);
    }

    private ChronoLocalDateTimeImpl<D> m44215a(D d, long j, long j2, long j3, long j4) {
        ChronoLocalDateTimeImpl chronoLocalDateTimeImpl = this;
        Temporal temporal = d;
        if ((((j | j2) | j3) | j4) == 0) {
            return m44217a(temporal, chronoLocalDateTimeImpl.f42061b);
        }
        long j5 = (((j4 / 86400000000000L) + (j3 / 86400)) + (j2 / 1440)) + (j / 24);
        long j6 = (((j4 % 86400000000000L) + ((j3 % 86400) * 1000000000)) + ((j2 % 1440) * 60000000000L)) + ((j % 24) * 3600000000000L);
        long b = chronoLocalDateTimeImpl.f42061b.b();
        j6 += b;
        j5 += Jdk8Methods.m43173d(j6, 86400000000000L);
        long e = Jdk8Methods.m43174e(j6, 86400000000000L);
        return m44217a(temporal.m44173e(j5, ChronoUnit.DAYS), e == b ? chronoLocalDateTimeImpl.f42061b : LocalTime.b(e));
    }
}
