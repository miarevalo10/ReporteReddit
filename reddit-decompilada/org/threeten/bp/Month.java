package org.threeten.bp;

import org.jcodec.codecs.mjpeg.JpegConst;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
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

public enum Month implements TemporalAccessor, TemporalAdjuster {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    
    public static final TemporalQuery<Month> f16373m = null;
    static final Month[] f16374n = null;

    static class C15691 implements TemporalQuery<Month> {
        C15691() {
        }

        public final /* bridge */ /* synthetic */ Object m16440a(TemporalAccessor temporalAccessor) {
            return Month.m16442a(temporalAccessor);
        }
    }

    static {
        f16373m = new C15691();
        f16374n = values();
    }

    public static Month m16441a(int i) {
        if (i > 0) {
            if (i <= 12) {
                return f16374n[i - 1];
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid value for MonthOfYear: ");
        stringBuilder.append(i);
        throw new DateTimeException(stringBuilder.toString());
    }

    public static Month m16442a(TemporalAccessor temporalAccessor) {
        if (temporalAccessor instanceof Month) {
            return (Month) temporalAccessor;
        }
        try {
            if (!IsoChronology.b.equals(Chronology.a(temporalAccessor))) {
                temporalAccessor = LocalDate.m21390a(temporalAccessor);
            }
            return m16441a(temporalAccessor.c(ChronoField.x));
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Unable to obtain Month from TemporalAccessor: ");
            stringBuilder.append(temporalAccessor);
            stringBuilder.append(", type ");
            stringBuilder.append(temporalAccessor.getClass().getName());
            throw new DateTimeException(stringBuilder.toString(), e);
        }
    }

    public final boolean m16446a(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.x : (temporalField == null || temporalField.a(this) == null) ? false : true;
    }

    public final ValueRange m16448b(TemporalField temporalField) {
        if (temporalField == ChronoField.x) {
            return temporalField.a();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.b(this);
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
        stringBuilder.append(temporalField);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public final int m16449c(TemporalField temporalField) {
        return temporalField == ChronoField.x ? ordinal() + 1 : m16448b(temporalField).b(m16450d(temporalField), temporalField);
    }

    public final long m16450d(TemporalField temporalField) {
        if (temporalField == ChronoField.x) {
            return (long) (ordinal() + 1);
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
        stringBuilder.append(temporalField);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public final int m16443a(boolean z) {
        switch (this) {
            case FEBRUARY:
                return z ? true : true;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                return true;
            default:
                return true;
        }
    }

    public final int m16447b(boolean z) {
        switch (this) {
            case FEBRUARY:
                return true;
            case APRIL:
                return 91 + z;
            case JUNE:
                return 152 + z;
            case SEPTEMBER:
                return 244 + z;
            case NOVEMBER:
                return 305 + z;
            case JANUARY:
                return true;
            case MARCH:
                return 60 + z;
            case MAY:
                return 121 + z;
            case JULY:
                return 182 + z;
            case AUGUST:
                return JpegConst.RST5 + z;
            case OCTOBER:
                return 274 + z;
            default:
                return 335 + z;
        }
    }

    public final <R> R m16444a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.b()) {
            return IsoChronology.b;
        }
        if (temporalQuery == TemporalQueries.c()) {
            return ChronoUnit.j;
        }
        if (!(temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.a())) {
            if (temporalQuery != TemporalQueries.e()) {
                return temporalQuery.a(this);
            }
        }
        return null;
    }

    public final Temporal m16445a(Temporal temporal) {
        if (Chronology.a(temporal).equals(IsoChronology.b)) {
            return temporal.a(ChronoField.x, (long) (ordinal() + 1));
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }
}
