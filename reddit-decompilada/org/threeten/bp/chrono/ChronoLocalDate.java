package org.threeten.bp.chrono;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.Comparator;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
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

public abstract class ChronoLocalDate extends DefaultInterfaceTemporal implements Comparable<ChronoLocalDate>, Temporal, TemporalAdjuster {
    private static final Comparator<ChronoLocalDate> f42055a = new C30491();

    static class C30491 implements Comparator<ChronoLocalDate> {
        C30491() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return Jdk8Methods.m43166a(((ChronoLocalDate) obj).m44175g(), ((ChronoLocalDate) obj2).m44175g());
        }
    }

    public abstract ChronoLocalDate m44171c(TemporalField temporalField, long j);

    public abstract ChronoLocalDate m44173e(long j, TemporalUnit temporalUnit);

    public abstract Chronology m44176h();

    public /* synthetic */ Temporal mo7925a(long j, TemporalUnit temporalUnit) {
        return m44172d(j, temporalUnit);
    }

    public /* synthetic */ Temporal mo7926a(TemporalAdjuster temporalAdjuster) {
        return m44170c(temporalAdjuster);
    }

    public /* synthetic */ Temporal mo7933a(TemporalField temporalField, long j) {
        return m44171c(temporalField, j);
    }

    public /* synthetic */ Temporal mo7934b(long j, TemporalUnit temporalUnit) {
        return m44173e(j, temporalUnit);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m44160a((ChronoLocalDate) obj);
    }

    public Era m44168b() {
        return m44176h().mo7845a(mo7853c(ChronoField.ERA));
    }

    public boolean m44174e() {
        return m44176h().mo7846a(mo7920d(ChronoField.YEAR));
    }

    public boolean mo7919a(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.mo7858b();
        }
        return (temporalField == null || temporalField.mo7856a(this) == null) ? null : true;
    }

    public ChronoLocalDate m44170c(TemporalAdjuster temporalAdjuster) {
        return m44176h().m43119a(super.mo7926a(temporalAdjuster));
    }

    public ChronoLocalDate m44172d(long j, TemporalUnit temporalUnit) {
        return m44176h().m43119a(super.mo7925a(j, temporalUnit));
    }

    public <R> R mo7851a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.m43191b()) {
            return m44176h();
        }
        if (temporalQuery == TemporalQueries.m43192c()) {
            return ChronoUnit.DAYS;
        }
        if (temporalQuery == TemporalQueries.m43195f()) {
            return LocalDate.a(m44175g());
        }
        if (!(temporalQuery == TemporalQueries.m43196g() || temporalQuery == TemporalQueries.m43193d() || temporalQuery == TemporalQueries.m43190a())) {
            if (temporalQuery != TemporalQueries.m43194e()) {
                return super.mo7851a(temporalQuery);
            }
        }
        return null;
    }

    public Temporal mo7863a(Temporal temporal) {
        return temporal.mo7933a(ChronoField.EPOCH_DAY, m44175g());
    }

    public ChronoLocalDateTime<?> m44162a(LocalTime localTime) {
        return ChronoLocalDateTimeImpl.m44216a(this, localTime);
    }

    public long m44175g() {
        return mo7920d(ChronoField.EPOCH_DAY);
    }

    public int m44160a(ChronoLocalDate chronoLocalDate) {
        int a = Jdk8Methods.m43166a(m44175g(), chronoLocalDate.m44175g());
        return a == 0 ? m44176h().m43117a(chronoLocalDate.m44176h()) : a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoLocalDate) && m44160a((ChronoLocalDate) obj) == null;
    }

    public int hashCode() {
        long g = m44175g();
        return ((int) (g ^ (g >>> 32))) ^ m44176h().hashCode();
    }

    public String toString() {
        long d = mo7920d(ChronoField.YEAR_OF_ERA);
        long d2 = mo7920d(ChronoField.MONTH_OF_YEAR);
        long d3 = mo7920d(ChronoField.DAY_OF_MONTH);
        StringBuilder stringBuilder = new StringBuilder(30);
        stringBuilder.append(m44176h().toString());
        stringBuilder.append(" ");
        stringBuilder.append(m44168b());
        stringBuilder.append(" ");
        stringBuilder.append(d);
        stringBuilder.append(d2 < 10 ? "-0" : Operation.MINUS);
        stringBuilder.append(d2);
        stringBuilder.append(d3 < 10 ? "-0" : Operation.MINUS);
        stringBuilder.append(d3);
        return stringBuilder.toString();
    }
}
