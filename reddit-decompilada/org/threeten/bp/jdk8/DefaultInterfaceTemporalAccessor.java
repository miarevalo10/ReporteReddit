package org.threeten.bp.jdk8;

import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public abstract class DefaultInterfaceTemporalAccessor implements TemporalAccessor {
    public ValueRange mo7852b(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.mo7857b(this);
        }
        if (mo7919a(temporalField)) {
            return temporalField.mo7855a();
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
        stringBuilder.append(temporalField);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public int mo7853c(TemporalField temporalField) {
        return mo7852b(temporalField).m43205b(mo7920d(temporalField), temporalField);
    }

    public <R> R mo7851a(TemporalQuery<R> temporalQuery) {
        if (!(temporalQuery == TemporalQueries.m43190a() || temporalQuery == TemporalQueries.m43191b())) {
            if (temporalQuery != TemporalQueries.m43192c()) {
                return temporalQuery.mo7842a(this);
            }
        }
        return null;
    }
}
