package org.threeten.bp.chrono;

import org.threeten.bp.DateTimeException;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public enum IsoEra implements Era {
    BCE,
    CE;

    public static IsoEra m43966a(int i) {
        switch (i) {
            case 0:
                return BCE;
            case 1:
                return CE;
            default:
                StringBuilder stringBuilder = new StringBuilder("Invalid era: ");
                stringBuilder.append(i);
                throw new DateTimeException(stringBuilder.toString());
        }
    }

    public final boolean mo7919a(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.ERA : (temporalField == null || temporalField.mo7856a(this) == null) ? false : true;
    }

    public final ValueRange mo7852b(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return temporalField.mo7855a();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.mo7857b(this);
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
        stringBuilder.append(temporalField);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public final int mo7853c(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return ordinal();
        }
        return mo7852b(temporalField).m43205b(mo7920d(temporalField), temporalField);
    }

    public final long mo7920d(TemporalField temporalField) {
        if (temporalField == ChronoField.ERA) {
            return (long) ordinal();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.mo7859c(this);
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
        stringBuilder.append(temporalField);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public final Temporal mo7863a(Temporal temporal) {
        return temporal.mo7933a(ChronoField.ERA, (long) ordinal());
    }

    public final <R> R mo7851a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.m43192c()) {
            return ChronoUnit.ERAS;
        }
        if (!(temporalQuery == TemporalQueries.m43191b() || temporalQuery == TemporalQueries.m43193d() || temporalQuery == TemporalQueries.m43190a() || temporalQuery == TemporalQueries.m43194e() || temporalQuery == TemporalQueries.m43195f())) {
            if (temporalQuery != TemporalQueries.m43196g()) {
                return temporalQuery.mo7842a(this);
            }
        }
        return null;
    }
}
