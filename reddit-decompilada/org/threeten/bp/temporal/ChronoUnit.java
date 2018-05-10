package org.threeten.bp.temporal;

import org.threeten.bp.Duration;

public enum ChronoUnit implements TemporalUnit {
    NANOS("Nanos", Duration.b(1)),
    MICROS("Micros", Duration.b(1000)),
    MILLIS("Millis", Duration.b(1000000)),
    SECONDS("Seconds", Duration.a(1)),
    MINUTES("Minutes", Duration.a(60)),
    HOURS("Hours", Duration.a(3600)),
    HALF_DAYS("HalfDays", Duration.a(43200)),
    DAYS("Days", Duration.a(86400)),
    WEEKS("Weeks", Duration.a(604800)),
    MONTHS("Months", Duration.a(2629746)),
    YEARS("Years", Duration.a(31556952)),
    DECADES("Decades", Duration.a(315569520)),
    CENTURIES("Centuries", Duration.a(3155695200L)),
    MILLENNIA("Millennia", Duration.a(31556952000L)),
    ERAS("Eras", Duration.a(31556952000000000L)),
    FOREVER("Forever", Duration.a());
    
    private final String f41521q;
    private final Duration f41522r;

    private ChronoUnit(String str, Duration duration) {
        this.f41521q = str;
        this.f41522r = duration;
    }

    public final boolean mo7862a() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    public final <R extends Temporal> R mo7861a(R r, long j) {
        return r.mo7934b(j, this);
    }

    public final String toString() {
        return this.f41521q;
    }
}
