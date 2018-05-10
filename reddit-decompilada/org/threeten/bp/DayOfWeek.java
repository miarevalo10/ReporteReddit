package org.threeten.bp;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public enum DayOfWeek implements TemporalAccessor, TemporalAdjuster {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
    
    public static final TemporalQuery<DayOfWeek> f16358h = null;
    public static final DayOfWeek[] f16359i = null;

    static class C15641 implements TemporalQuery<DayOfWeek> {
        C15641() {
        }

        public final /* bridge */ /* synthetic */ Object m16427a(TemporalAccessor temporalAccessor) {
            return DayOfWeek.m16429a(temporalAccessor);
        }
    }

    static {
        f16358h = new C15641();
        f16359i = values();
    }

    public static DayOfWeek m16428a(int i) {
        if (i > 0) {
            if (i <= 7) {
                return f16359i[i - 1];
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid value for DayOfWeek: ");
        stringBuilder.append(i);
        throw new DateTimeException(stringBuilder.toString());
    }

    public static DayOfWeek m16429a(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof DayOfWeek) {
            return (DayOfWeek) temporalAccessor;
        }
        try {
            return m16428a(temporalAccessor.c(ChronoField.p));
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Unable to obtain DayOfWeek from TemporalAccessor: ");
            stringBuilder.append(temporalAccessor);
            stringBuilder.append(", type ");
            stringBuilder.append(temporalAccessor.getClass().getName());
            throw new DateTimeException(stringBuilder.toString(), e);
        }
    }

    public final boolean m16432a(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.p : (temporalField == null || temporalField.a(this) == null) ? false : true;
    }

    public final ValueRange m16433b(TemporalField temporalField) {
        if (temporalField == ChronoField.p) {
            return temporalField.a();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.b(this);
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
        stringBuilder.append(temporalField);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public final int m16434c(TemporalField temporalField) {
        return temporalField == ChronoField.p ? ordinal() + 1 : m16433b(temporalField).b(m16435d(temporalField), temporalField);
    }

    public final long m16435d(TemporalField temporalField) {
        if (temporalField == ChronoField.p) {
            return (long) (ordinal() + 1);
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
        stringBuilder.append(temporalField);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public final <R> R m16430a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.c()) {
            return ChronoUnit.h;
        }
        if (!(temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.a())) {
            if (temporalQuery != TemporalQueries.e()) {
                return temporalQuery.a(this);
            }
        }
        return null;
    }

    public final Temporal m16431a(Temporal temporal) {
        return temporal.a(ChronoField.p, (long) (ordinal() + 1));
    }
}
