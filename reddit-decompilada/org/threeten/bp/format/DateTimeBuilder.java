package org.threeten.bp.format;

import java.util.HashMap;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

final class DateTimeBuilder extends DefaultInterfaceTemporalAccessor implements Cloneable, TemporalAccessor {
    final Map<TemporalField, Long> f41843a = new HashMap();
    Chronology f41844b;
    ZoneId f41845c;
    ChronoLocalDate f41846d;
    LocalTime f41847e;
    boolean f41848f;
    Period f41849g;

    public final boolean mo7919a(TemporalField temporalField) {
        if (temporalField == null) {
            return false;
        }
        if (!this.f41843a.containsKey(temporalField) && (this.f41846d == null || !this.f41846d.mo7919a(temporalField))) {
            if (this.f41847e == null || this.f41847e.a(temporalField) == null) {
                return false;
            }
        }
        return true;
    }

    public final long mo7920d(TemporalField temporalField) {
        Jdk8Methods.m43168a((Object) temporalField, "field");
        Long l = (Long) this.f41843a.get(temporalField);
        if (l != null) {
            return l.longValue();
        }
        if (this.f41846d != null && this.f41846d.mo7919a(temporalField)) {
            return this.f41846d.mo7920d(temporalField);
        }
        if (this.f41847e != null && this.f41847e.a(temporalField)) {
            return this.f41847e.d(temporalField);
        }
        StringBuilder stringBuilder = new StringBuilder("Field not found: ");
        stringBuilder.append(temporalField);
        throw new DateTimeException(stringBuilder.toString());
    }

    public final <R> R mo7851a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.m43190a()) {
            return this.f41845c;
        }
        if (temporalQuery == TemporalQueries.m43191b()) {
            return this.f41844b;
        }
        if (temporalQuery == TemporalQueries.m43195f()) {
            if (this.f41846d != null) {
                return LocalDate.a(this.f41846d);
            }
            return null;
        } else if (temporalQuery == TemporalQueries.m43196g()) {
            return this.f41847e;
        } else {
            if (temporalQuery != TemporalQueries.m43193d()) {
                if (temporalQuery != TemporalQueries.m43194e()) {
                    if (temporalQuery == TemporalQueries.m43192c()) {
                        return null;
                    }
                    return temporalQuery.mo7842a(this);
                }
            }
            return temporalQuery.mo7842a(this);
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("DateTimeBuilder[");
        if (this.f41843a.size() > 0) {
            stringBuilder.append("fields=");
            stringBuilder.append(this.f41843a);
        }
        stringBuilder.append(", ");
        stringBuilder.append(this.f41844b);
        stringBuilder.append(", ");
        stringBuilder.append(this.f41845c);
        stringBuilder.append(", ");
        stringBuilder.append(this.f41846d);
        stringBuilder.append(", ");
        stringBuilder.append(this.f41847e);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
