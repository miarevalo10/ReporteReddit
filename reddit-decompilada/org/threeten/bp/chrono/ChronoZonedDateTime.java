package org.threeten.bp.chrono;

import java.util.Comparator;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporal;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

public abstract class ChronoZonedDateTime<D extends ChronoLocalDate> extends DefaultInterfaceTemporal implements Comparable<ChronoZonedDateTime<?>>, Temporal {
    private static Comparator<ChronoZonedDateTime<?>> f42057a = new C30521();

    static class C30521 implements Comparator<ChronoZonedDateTime<?>> {
        C30521() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            ChronoZonedDateTime chronoZonedDateTime = (ChronoZonedDateTime) obj;
            ChronoZonedDateTime chronoZonedDateTime2 = (ChronoZonedDateTime) obj2;
            int a = Jdk8Methods.m43166a(chronoZonedDateTime.m44213f(), chronoZonedDateTime2.m44213f());
            return a == 0 ? Jdk8Methods.m43166a(chronoZonedDateTime.m44207c().b(), chronoZonedDateTime2.m44207c().b()) : a;
        }
    }

    public abstract ZoneOffset mo7940a();

    public abstract ZoneId mo7941b();

    public abstract ChronoZonedDateTime<D> mo7942b(TemporalField temporalField, long j);

    public abstract ChronoLocalDateTime<D> mo7943d();

    public abstract ChronoZonedDateTime<D> mo7944d(long j, TemporalUnit temporalUnit);

    public /* synthetic */ Temporal mo7925a(long j, TemporalUnit temporalUnit) {
        return m44208c(j, temporalUnit);
    }

    public /* synthetic */ Temporal mo7926a(TemporalAdjuster temporalAdjuster) {
        return m44202b(temporalAdjuster);
    }

    public /* synthetic */ Temporal mo7933a(TemporalField temporalField, long j) {
        return mo7942b(temporalField, j);
    }

    public /* synthetic */ Temporal mo7934b(long j, TemporalUnit temporalUnit) {
        return mo7944d(j, temporalUnit);
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m44194a((ChronoZonedDateTime) obj);
    }

    public ValueRange mo7852b(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.mo7857b(this);
        }
        if (temporalField != ChronoField.INSTANT_SECONDS) {
            if (temporalField != ChronoField.OFFSET_SECONDS) {
                return mo7943d().mo7852b(temporalField);
            }
        }
        return temporalField.mo7855a();
    }

    public int mo7853c(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.mo7853c(temporalField);
        }
        switch ((ChronoField) temporalField) {
            case INSTANT_SECONDS:
                StringBuilder stringBuilder = new StringBuilder("Field too large for an int: ");
                stringBuilder.append(temporalField);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
            case OFFSET_SECONDS:
                return mo7940a().g;
            default:
                return mo7943d().mo7853c(temporalField);
        }
    }

    public long mo7920d(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.mo7859c(this);
        }
        switch ((ChronoField) temporalField) {
            case INSTANT_SECONDS:
                return m44213f();
            case OFFSET_SECONDS:
                return (long) mo7940a().g;
            default:
                return mo7943d().mo7920d(temporalField);
        }
    }

    public D m44212e() {
        return mo7943d().mo7936b();
    }

    public LocalTime m44207c() {
        return mo7943d().mo7935a();
    }

    public ChronoZonedDateTime<D> m44202b(TemporalAdjuster temporalAdjuster) {
        return m44212e().m44176h().m43126c(super.mo7926a(temporalAdjuster));
    }

    public ChronoZonedDateTime<D> m44208c(long j, TemporalUnit temporalUnit) {
        return m44212e().m44176h().m43126c(super.mo7925a(j, temporalUnit));
    }

    public <R> R mo7851a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery != TemporalQueries.m43190a()) {
            if (temporalQuery != TemporalQueries.m43193d()) {
                if (temporalQuery == TemporalQueries.m43191b()) {
                    return m44212e().m44176h();
                }
                if (temporalQuery == TemporalQueries.m43192c()) {
                    return ChronoUnit.NANOS;
                }
                if (temporalQuery == TemporalQueries.m43194e()) {
                    return mo7940a();
                }
                if (temporalQuery == TemporalQueries.m43195f()) {
                    return LocalDate.a(m44212e().m44175g());
                }
                if (temporalQuery == TemporalQueries.m43196g()) {
                    return m44207c();
                }
                return super.mo7851a(temporalQuery);
            }
        }
        return mo7941b();
    }

    public String m44196a(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.m43168a((Object) dateTimeFormatter, "formatter");
        return dateTimeFormatter.m43130a((TemporalAccessor) this);
    }

    public final long m44213f() {
        return ((m44212e().m44175g() * 86400) + ((long) m44207c().a())) - ((long) mo7940a().g);
    }

    public final int m44194a(ChronoZonedDateTime<?> chronoZonedDateTime) {
        int a = Jdk8Methods.m43166a(m44213f(), chronoZonedDateTime.m44213f());
        if (a != 0) {
            return a;
        }
        a = m44207c().h - chronoZonedDateTime.m44207c().h;
        if (a != 0) {
            return a;
        }
        a = mo7943d().m44177a(chronoZonedDateTime.mo7943d());
        if (a != 0) {
            return a;
        }
        a = mo7941b().b().compareTo(chronoZonedDateTime.mo7941b().b());
        return a == 0 ? m44212e().m44176h().m43117a(chronoZonedDateTime.m44212e().m44176h()) : a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && m44194a((ChronoZonedDateTime) obj) == null;
    }

    public int hashCode() {
        return (mo7943d().hashCode() ^ mo7940a().hashCode()) ^ Integer.rotateLeft(mo7941b().hashCode(), 3);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(mo7943d().toString());
        stringBuilder.append(mo7940a().toString());
        String stringBuilder2 = stringBuilder.toString();
        if (mo7940a() == mo7941b()) {
            return stringBuilder2;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append('[');
        stringBuilder3.append(mo7941b().toString());
        stringBuilder3.append(']');
        return stringBuilder3.toString();
    }
}
