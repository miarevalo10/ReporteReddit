package org.threeten.bp.chrono;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;

public abstract class Chronology implements Comparable<Chronology> {
    public static final TemporalQuery<Chronology> f41001a = new C30751();
    private static final ConcurrentHashMap<String, Chronology> f41002b = new ConcurrentHashMap();
    private static final ConcurrentHashMap<String, Chronology> f41003c = new ConcurrentHashMap();
    private static final Method f41004d;

    static class C30751 implements TemporalQuery<Chronology> {
        C30751() {
        }

        public final /* bridge */ /* synthetic */ Object mo7842a(TemporalAccessor temporalAccessor) {
            return Chronology.m43116a(temporalAccessor);
        }
    }

    public abstract String mo7843a();

    public abstract Era mo7845a(int i);

    public abstract boolean mo7846a(long j);

    public abstract ChronoLocalDate mo7847b(TemporalAccessor temporalAccessor);

    public /* synthetic */ int compareTo(Object obj) {
        return m43117a((Chronology) obj);
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.threeten.bp.chrono.Chronology$1;
        r0.<init>();
        f41001a = r0;
        r0 = new java.util.concurrent.ConcurrentHashMap;
        r0.<init>();
        f41002b = r0;
        r0 = new java.util.concurrent.ConcurrentHashMap;
        r0.<init>();
        f41003c = r0;
        r0 = java.util.Locale.class;	 Catch:{ Throwable -> 0x0026 }
        r1 = "getUnicodeLocaleType";	 Catch:{ Throwable -> 0x0026 }
        r2 = 1;	 Catch:{ Throwable -> 0x0026 }
        r2 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0026 }
        r3 = 0;	 Catch:{ Throwable -> 0x0026 }
        r4 = java.lang.String.class;	 Catch:{ Throwable -> 0x0026 }
        r2[r3] = r4;	 Catch:{ Throwable -> 0x0026 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ Throwable -> 0x0026 }
        goto L_0x0027;
    L_0x0026:
        r0 = 0;
    L_0x0027:
        f41004d = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.Chronology.<clinit>():void");
    }

    public static Chronology m43116a(TemporalAccessor temporalAccessor) {
        Jdk8Methods.m43168a((Object) temporalAccessor, "temporal");
        Chronology chronology = (Chronology) temporalAccessor.mo7851a(TemporalQueries.m43191b());
        if (chronology != null) {
            return chronology;
        }
        return IsoChronology.f41426b;
    }

    protected Chronology() {
    }

    final <D extends ChronoLocalDate> D m43119a(Temporal temporal) {
        ChronoLocalDate chronoLocalDate = (ChronoLocalDate) temporal;
        if (equals(chronoLocalDate.m44176h())) {
            return chronoLocalDate;
        }
        StringBuilder stringBuilder = new StringBuilder("Chrono mismatch, expected: ");
        stringBuilder.append(mo7843a());
        stringBuilder.append(", actual: ");
        stringBuilder.append(chronoLocalDate.m44176h().mo7843a());
        throw new ClassCastException(stringBuilder.toString());
    }

    final <D extends ChronoLocalDate> ChronoLocalDateTimeImpl<D> m43124b(Temporal temporal) {
        ChronoLocalDateTimeImpl chronoLocalDateTimeImpl = (ChronoLocalDateTimeImpl) temporal;
        if (equals(chronoLocalDateTimeImpl.f42060a.m44176h())) {
            return chronoLocalDateTimeImpl;
        }
        StringBuilder stringBuilder = new StringBuilder("Chrono mismatch, required: ");
        stringBuilder.append(mo7843a());
        stringBuilder.append(", supplied: ");
        stringBuilder.append(chronoLocalDateTimeImpl.f42060a.m44176h().mo7843a());
        throw new ClassCastException(stringBuilder.toString());
    }

    final <D extends ChronoLocalDate> ChronoZonedDateTimeImpl<D> m43126c(Temporal temporal) {
        ChronoZonedDateTimeImpl chronoZonedDateTimeImpl = (ChronoZonedDateTimeImpl) temporal;
        if (equals(chronoZonedDateTimeImpl.m44212e().m44176h())) {
            return chronoZonedDateTimeImpl;
        }
        StringBuilder stringBuilder = new StringBuilder("Chrono mismatch, required: ");
        stringBuilder.append(mo7843a());
        stringBuilder.append(", supplied: ");
        stringBuilder.append(chronoZonedDateTimeImpl.m44212e().m44176h().mo7843a());
        throw new ClassCastException(stringBuilder.toString());
    }

    public ChronoLocalDateTime<?> mo7848c(TemporalAccessor temporalAccessor) {
        try {
            return mo7847b(temporalAccessor).m44162a(LocalTime.a(temporalAccessor));
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Unable to obtain ChronoLocalDateTime from TemporalAccessor: ");
            stringBuilder.append(temporalAccessor.getClass());
            throw new DateTimeException(stringBuilder.toString(), e);
        }
    }

    public ChronoZonedDateTime<?> mo7844a(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.m44237a(this, instant, zoneId);
    }

    public final int m43117a(Chronology chronology) {
        return mo7843a().compareTo(chronology.mo7843a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Chronology) && m43117a((Chronology) obj) == null;
    }

    public int hashCode() {
        return getClass().hashCode() ^ mo7843a().hashCode();
    }

    public String toString() {
        return mo7843a();
    }
}
