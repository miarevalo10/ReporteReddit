package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.temporal.TemporalAccessor;

public final class IsoChronology extends Chronology implements Serializable {
    public static final IsoChronology f41426b = new IsoChronology();

    public final String mo7843a() {
        return "ISO";
    }

    private IsoChronology() {
    }

    public final boolean mo7846a(long j) {
        return ((3 & j) != 0 || (j % 100 == 0 && j % 400 != 0)) ? 0 : 1;
    }

    public final /* bridge */ /* synthetic */ ChronoZonedDateTime mo7844a(Instant instant, ZoneId zoneId) {
        return ZonedDateTime.a(instant, zoneId);
    }

    public final /* synthetic */ ChronoLocalDateTime mo7848c(TemporalAccessor temporalAccessor) {
        return LocalDateTime.a(temporalAccessor);
    }

    public final /* synthetic */ ChronoLocalDate mo7847b(TemporalAccessor temporalAccessor) {
        return LocalDate.a(temporalAccessor);
    }
}
