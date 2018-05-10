package org.threeten.bp.temporal;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.Chronology;

public final class TemporalQueries {
    static final TemporalQuery<ZoneId> f41076a = new C30801();
    static final TemporalQuery<Chronology> f41077b = new C30812();
    static final TemporalQuery<TemporalUnit> f41078c = new C30823();
    static final TemporalQuery<ZoneId> f41079d = new C30834();
    static final TemporalQuery<ZoneOffset> f41080e = new C30845();
    static final TemporalQuery<LocalDate> f41081f = new C30856();
    static final TemporalQuery<LocalTime> f41082g = new C30867();

    static class C30801 implements TemporalQuery<ZoneId> {
        C30801() {
        }

        public final /* bridge */ /* synthetic */ Object mo7842a(TemporalAccessor temporalAccessor) {
            return (ZoneId) temporalAccessor.mo7851a((TemporalQuery) this);
        }
    }

    static class C30812 implements TemporalQuery<Chronology> {
        C30812() {
        }

        public final /* bridge */ /* synthetic */ Object mo7842a(TemporalAccessor temporalAccessor) {
            return (Chronology) temporalAccessor.mo7851a((TemporalQuery) this);
        }
    }

    static class C30823 implements TemporalQuery<TemporalUnit> {
        C30823() {
        }

        public final /* bridge */ /* synthetic */ Object mo7842a(TemporalAccessor temporalAccessor) {
            return (TemporalUnit) temporalAccessor.mo7851a((TemporalQuery) this);
        }
    }

    static class C30834 implements TemporalQuery<ZoneId> {
        C30834() {
        }

        public final /* bridge */ /* synthetic */ Object mo7842a(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.mo7851a(TemporalQueries.f41076a);
            if (zoneId != null) {
                return zoneId;
            }
            return (ZoneId) temporalAccessor.mo7851a(TemporalQueries.f41080e);
        }
    }

    static class C30845 implements TemporalQuery<ZoneOffset> {
        C30845() {
        }

        public final /* synthetic */ Object mo7842a(TemporalAccessor temporalAccessor) {
            return temporalAccessor.mo7919a(ChronoField.OFFSET_SECONDS) ? ZoneOffset.a(temporalAccessor.mo7853c(ChronoField.OFFSET_SECONDS)) : null;
        }
    }

    static class C30856 implements TemporalQuery<LocalDate> {
        C30856() {
        }

        public final /* synthetic */ Object mo7842a(TemporalAccessor temporalAccessor) {
            return temporalAccessor.mo7919a(ChronoField.EPOCH_DAY) ? LocalDate.a(temporalAccessor.mo7920d(ChronoField.EPOCH_DAY)) : null;
        }
    }

    static class C30867 implements TemporalQuery<LocalTime> {
        C30867() {
        }

        public final /* synthetic */ Object mo7842a(TemporalAccessor temporalAccessor) {
            return temporalAccessor.mo7919a(ChronoField.NANO_OF_DAY) ? LocalTime.b(temporalAccessor.mo7920d(ChronoField.NANO_OF_DAY)) : null;
        }
    }

    public static final TemporalQuery<ZoneId> m43190a() {
        return f41076a;
    }

    public static final TemporalQuery<Chronology> m43191b() {
        return f41077b;
    }

    public static final TemporalQuery<TemporalUnit> m43192c() {
        return f41078c;
    }

    public static final TemporalQuery<ZoneId> m43193d() {
        return f41079d;
    }

    public static final TemporalQuery<ZoneOffset> m43194e() {
        return f41080e;
    }

    public static final TemporalQuery<LocalDate> m43195f() {
        return f41081f;
    }

    public static final TemporalQuery<LocalTime> m43196g() {
        return f41082g;
    }
}
