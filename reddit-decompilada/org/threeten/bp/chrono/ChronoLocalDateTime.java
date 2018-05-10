package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;

public abstract class ChronoLocalDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Comparable<ChronoLocalDateTime<?>>, Temporal, TemporalAdjuster {
    private static final Comparator<ChronoLocalDateTime<?>> f42056a = new C30501();

    static class C30501 implements Comparator<ChronoLocalDateTime<?>> {
        C30501() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            ChronoLocalDateTime chronoLocalDateTime = (ChronoLocalDateTime) obj;
            ChronoLocalDateTime chronoLocalDateTime2 = (ChronoLocalDateTime) obj2;
            int a = Jdk8Methods.m43166a(chronoLocalDateTime.mo7936b().m44175g(), chronoLocalDateTime2.mo7936b().m44175g());
            return a == 0 ? Jdk8Methods.m43166a(chronoLocalDateTime.mo7935a().b(), chronoLocalDateTime2.mo7935a().b()) : a;
        }
    }

    public abstract LocalTime mo7935a();

    public abstract D mo7936b();

    public abstract ChronoLocalDateTime<D> mo7938c(TemporalField temporalField, long j);

    public abstract ChronoLocalDateTime<D> mo7939e(long j, TemporalUnit temporalUnit);

    public /* synthetic */ Temporal mo7925a(long j, TemporalUnit temporalUnit) {
        return m44192d(j, temporalUnit);
    }

    public /* synthetic */ Temporal mo7926a(TemporalAdjuster temporalAdjuster) {
        return mo7937b(temporalAdjuster);
    }

    public /* synthetic */ Temporal mo7933a(TemporalField temporalField, long j) {
        return mo7938c(temporalField, j);
    }

    public /* synthetic */ Temporal mo7934b(long j, TemporalUnit temporalUnit) {
        return mo7939e(j, temporalUnit);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m44177a((ChronoLocalDateTime) obj);
    }

    public ChronoLocalDateTime<D> mo7937b(TemporalAdjuster temporalAdjuster) {
        return mo7936b().m44176h().m43124b(super.mo7926a(temporalAdjuster));
    }

    public ChronoLocalDateTime<D> m44192d(long j, TemporalUnit temporalUnit) {
        return mo7936b().m44176h().m43124b(super.mo7925a(j, temporalUnit));
    }

    public <R> R mo7851a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.m43191b()) {
            return mo7936b().m44176h();
        }
        if (temporalQuery == TemporalQueries.m43192c()) {
            return ChronoUnit.NANOS;
        }
        if (temporalQuery == TemporalQueries.m43195f()) {
            return LocalDate.a(mo7936b().m44175g());
        }
        if (temporalQuery == TemporalQueries.m43196g()) {
            return mo7935a();
        }
        if (!(temporalQuery == TemporalQueries.m43193d() || temporalQuery == TemporalQueries.m43190a())) {
            if (temporalQuery != TemporalQueries.m43194e()) {
                return super.mo7851a(temporalQuery);
            }
        }
        return null;
    }

    public Temporal mo7863a(Temporal temporal) {
        return temporal.mo7933a(ChronoField.EPOCH_DAY, mo7936b().m44175g()).mo7933a(ChronoField.NANO_OF_DAY, mo7935a().b());
    }

    public final Instant m44179a(ZoneOffset zoneOffset) {
        return Instant.a(m44185b(zoneOffset), (long) mo7935a().h);
    }

    public final long m44185b(ZoneOffset zoneOffset) {
        Jdk8Methods.m43168a((Object) zoneOffset, "offset");
        return ((mo7936b().m44175g() * 86400) + ((long) mo7935a().a())) - ((long) zoneOffset.g);
    }

    public int m44177a(ChronoLocalDateTime<?> chronoLocalDateTime) {
        int a = mo7936b().m44160a(chronoLocalDateTime.mo7936b());
        if (a != 0) {
            return a;
        }
        a = mo7935a().a(chronoLocalDateTime.mo7935a());
        return a == 0 ? mo7936b().m44176h().m43117a(chronoLocalDateTime.mo7936b().m44176h()) : a;
    }

    public boolean m44189b(ChronoLocalDateTime<?> chronoLocalDateTime) {
        int i = (mo7936b().m44175g() > chronoLocalDateTime.mo7936b().m44175g() ? 1 : (mo7936b().m44175g() == chronoLocalDateTime.mo7936b().m44175g() ? 0 : -1));
        if (i <= 0) {
            if (i != 0 || mo7935a().b() <= chronoLocalDateTime.mo7935a().b()) {
                return null;
            }
        }
        return true;
    }

    public boolean m44191c(ChronoLocalDateTime<?> chronoLocalDateTime) {
        int i = (mo7936b().m44175g() > chronoLocalDateTime.mo7936b().m44175g() ? 1 : (mo7936b().m44175g() == chronoLocalDateTime.mo7936b().m44175g() ? 0 : -1));
        if (i >= 0) {
            if (i != 0 || mo7935a().b() >= chronoLocalDateTime.mo7935a().b()) {
                return null;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDateTime) && m44177a((ChronoLocalDateTime) obj) == null;
    }

    public int hashCode() {
        return mo7936b().hashCode() ^ mo7935a().hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mo7936b().toString());
        stringBuilder.append('T');
        stringBuilder.append(mo7935a().toString());
        return stringBuilder.toString();
    }
}
