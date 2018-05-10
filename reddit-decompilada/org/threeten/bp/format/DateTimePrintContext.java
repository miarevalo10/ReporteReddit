package org.threeten.bp.format;

import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;

final class DateTimePrintContext {
    TemporalAccessor f41040a;
    Locale f41041b;
    DecimalStyle f41042c;
    int f41043d;

    DateTimePrintContext(TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        this.f41040a = m43155a(temporalAccessor, dateTimeFormatter);
        this.f41041b = dateTimeFormatter.f41023q;
        this.f41042c = dateTimeFormatter.f41024r;
    }

    final void m43158a() {
        this.f41043d--;
    }

    final <R> R m43157a(TemporalQuery<R> temporalQuery) {
        temporalQuery = this.f41040a.mo7851a((TemporalQuery) temporalQuery);
        if (temporalQuery != null || this.f41043d != 0) {
            return temporalQuery;
        }
        StringBuilder stringBuilder = new StringBuilder("Unable to extract value: ");
        stringBuilder.append(this.f41040a.getClass());
        throw new DateTimeException(stringBuilder.toString());
    }

    final Long m43156a(TemporalField temporalField) {
        try {
            return Long.valueOf(this.f41040a.mo7920d(temporalField));
        } catch (TemporalField temporalField2) {
            if (this.f41043d > 0) {
                return null;
            }
            throw temporalField2;
        }
    }

    public final String toString() {
        return this.f41040a.toString();
    }

    private static TemporalAccessor m43155a(final TemporalAccessor temporalAccessor, DateTimeFormatter dateTimeFormatter) {
        Chronology chronology = dateTimeFormatter.f41027u;
        dateTimeFormatter = dateTimeFormatter.f41028v;
        if (chronology == null && dateTimeFormatter == null) {
            return temporalAccessor;
        }
        Chronology chronology2 = (Chronology) temporalAccessor.mo7851a(TemporalQueries.m43191b());
        ZoneId zoneId = (ZoneId) temporalAccessor.mo7851a(TemporalQueries.m43190a());
        ChronoLocalDate chronoLocalDate = null;
        if (Jdk8Methods.m43169a((Object) chronology2, (Object) chronology)) {
            chronology = null;
        }
        if (Jdk8Methods.m43169a((Object) zoneId, (Object) dateTimeFormatter)) {
            dateTimeFormatter = null;
        }
        if (chronology == null && dateTimeFormatter == null) {
            return temporalAccessor;
        }
        final Chronology chronology3 = chronology != null ? chronology : chronology2;
        if (dateTimeFormatter != null) {
            zoneId = dateTimeFormatter;
        }
        if (dateTimeFormatter != null) {
            if (temporalAccessor.mo7919a(ChronoField.INSTANT_SECONDS)) {
                if (chronology3 == null) {
                    chronology3 = IsoChronology.f41426b;
                }
                return chronology3.mo7844a(Instant.a(temporalAccessor), dateTimeFormatter);
            }
            ZoneId d = dateTimeFormatter.d();
            ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.mo7851a(TemporalQueries.m43194e());
            if (!(!(d instanceof ZoneOffset) || zoneOffset == null || d.equals(zoneOffset))) {
                StringBuilder stringBuilder = new StringBuilder("Invalid override zone for temporal: ");
                stringBuilder.append(dateTimeFormatter);
                stringBuilder.append(" ");
                stringBuilder.append(temporalAccessor);
                throw new DateTimeException(stringBuilder.toString());
            }
        }
        if (chronology != null) {
            if (temporalAccessor.mo7919a(ChronoField.EPOCH_DAY) != null) {
                chronoLocalDate = chronology3.mo7847b(temporalAccessor);
            } else if (!(chronology == IsoChronology.f41426b && chronology2 == null)) {
                for (TemporalField temporalField : ChronoField.values()) {
                    if (temporalField.mo7858b() && temporalAccessor.mo7919a(temporalField)) {
                        stringBuilder = new StringBuilder("Invalid override chronology for temporal: ");
                        stringBuilder.append(chronology);
                        stringBuilder.append(" ");
                        stringBuilder.append(temporalAccessor);
                        throw new DateTimeException(stringBuilder.toString());
                    }
                }
            }
        }
        return new DefaultInterfaceTemporalAccessor() {
            public final boolean mo7919a(TemporalField temporalField) {
                if (chronoLocalDate == null || !temporalField.mo7858b()) {
                    return temporalAccessor.mo7919a(temporalField);
                }
                return chronoLocalDate.mo7919a(temporalField);
            }

            public final ValueRange mo7852b(TemporalField temporalField) {
                if (chronoLocalDate == null || !temporalField.mo7858b()) {
                    return temporalAccessor.mo7852b(temporalField);
                }
                return chronoLocalDate.mo7852b(temporalField);
            }

            public final long mo7920d(TemporalField temporalField) {
                if (chronoLocalDate == null || !temporalField.mo7858b()) {
                    return temporalAccessor.mo7920d(temporalField);
                }
                return chronoLocalDate.mo7920d(temporalField);
            }

            public final <R> R mo7851a(TemporalQuery<R> temporalQuery) {
                if (temporalQuery == TemporalQueries.m43191b()) {
                    return chronology3;
                }
                if (temporalQuery == TemporalQueries.m43190a()) {
                    return zoneId;
                }
                if (temporalQuery == TemporalQueries.m43192c()) {
                    return temporalAccessor.mo7851a((TemporalQuery) temporalQuery);
                }
                return temporalQuery.mo7842a(this);
            }
        };
    }
}
