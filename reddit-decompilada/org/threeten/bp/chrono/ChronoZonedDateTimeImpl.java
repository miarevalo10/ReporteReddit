package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;

final class ChronoZonedDateTimeImpl<D extends ChronoLocalDate> extends ChronoZonedDateTime<D> implements Serializable {
    private final ChronoLocalDateTimeImpl<D> f42062a;
    private final ZoneOffset f42063b;
    private final ZoneId f42064c;

    public final /* synthetic */ Temporal mo7933a(TemporalField temporalField, long j) {
        return mo7942b(temporalField, j);
    }

    public final /* synthetic */ Temporal mo7934b(long j, TemporalUnit temporalUnit) {
        return mo7944d(j, temporalUnit);
    }

    static <R extends ChronoLocalDate> ChronoZonedDateTimeImpl<R> m44237a(Chronology chronology, Instant instant, ZoneId zoneId) {
        Object a = zoneId.c().mo7865a(instant);
        Jdk8Methods.m43168a(a, "offset");
        return new ChronoZonedDateTimeImpl((ChronoLocalDateTimeImpl) chronology.mo7848c(LocalDateTime.a(instant.e, instant.f, a)), a, zoneId);
    }

    private ChronoZonedDateTimeImpl(ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.f42062a = (ChronoLocalDateTimeImpl) Jdk8Methods.m43168a((Object) chronoLocalDateTimeImpl, "dateTime");
        this.f42063b = (ZoneOffset) Jdk8Methods.m43168a((Object) zoneOffset, "offset");
        this.f42064c = (ZoneId) Jdk8Methods.m43168a((Object) zoneId, "zone");
    }

    public final ZoneOffset mo7940a() {
        return this.f42063b;
    }

    public final ChronoLocalDateTime<D> mo7943d() {
        return this.f42062a;
    }

    public final ZoneId mo7941b() {
        return this.f42064c;
    }

    public final boolean mo7919a(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            if (temporalField == null || temporalField.mo7856a(this) == null) {
                return null;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.threeten.bp.chrono.ChronoZonedDateTime<D> mo7942b(org.threeten.bp.temporal.TemporalField r6, long r7) {
        /*
        r5 = this;
        r0 = r6 instanceof org.threeten.bp.temporal.ChronoField;
        if (r0 == 0) goto L_0x00a0;
    L_0x0004:
        r0 = r6;
        r0 = (org.threeten.bp.temporal.ChronoField) r0;
        r1 = org.threeten.bp.chrono.ChronoZonedDateTimeImpl.C30541.f41000a;
        r2 = r0.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0050;
            case 2: goto L_0x0033;
            default: goto L_0x0012;
        };
    L_0x0012:
        r0 = r5.f42062a;
        r6 = r0.m44229b(r6, r7);
        r7 = r5.f42064c;
        r8 = r5.f42063b;
        r0 = "localDateTime";
        org.threeten.bp.jdk8.Jdk8Methods.m43168a(r6, r0);
        r0 = "zone";
        org.threeten.bp.jdk8.Jdk8Methods.m43168a(r7, r0);
        r0 = r7 instanceof org.threeten.bp.ZoneOffset;
        if (r0 == 0) goto L_0x005c;
    L_0x002a:
        r8 = new org.threeten.bp.chrono.ChronoZonedDateTimeImpl;
        r0 = r7;
        r0 = (org.threeten.bp.ZoneOffset) r0;
        r8.<init>(r6, r0, r7);
        return r8;
    L_0x0033:
        r6 = r0.m43601b(r7);
        r6 = org.threeten.bp.ZoneOffset.a(r6);
        r7 = r5.f42062a;
        r6 = r7.m44179a(r6);
        r7 = r5.f42064c;
        r8 = r5.m44212e();
        r8 = r8.m44176h();
        r6 = m44237a(r8, r6, r7);
        return r6;
    L_0x0050:
        r0 = r5.m44213f();
        r7 = r7 - r0;
        r6 = org.threeten.bp.temporal.ChronoUnit.SECONDS;
        r6 = r5.mo7944d(r7, r6);
        return r6;
    L_0x005c:
        r0 = r7.c();
        r1 = org.threeten.bp.LocalDateTime.a(r6);
        r2 = r0.mo7864a(r1);
        r3 = r2.size();
        r4 = 1;
        if (r3 == r4) goto L_0x008e;
    L_0x006f:
        r3 = r2.size();
        if (r3 != 0) goto L_0x0086;
    L_0x0075:
        r8 = r0.mo7868b(r1);
        r0 = r8.m43222c();
        r0 = r0.b;
        r6 = r6.m44223a(r0);
        r8 = r8.f41105c;
        goto L_0x0095;
    L_0x0086:
        if (r8 == 0) goto L_0x008e;
    L_0x0088:
        r0 = r2.contains(r8);
        if (r0 != 0) goto L_0x0095;
    L_0x008e:
        r8 = 0;
        r8 = r2.get(r8);
        r8 = (org.threeten.bp.ZoneOffset) r8;
    L_0x0095:
        r0 = "offset";
        org.threeten.bp.jdk8.Jdk8Methods.m43168a(r8, r0);
        r0 = new org.threeten.bp.chrono.ChronoZonedDateTimeImpl;
        r0.<init>(r6, r8, r7);
        return r0;
    L_0x00a0:
        r0 = r5.m44212e();
        r0 = r0.m44176h();
        r6 = r6.mo7854a(r5, r7);
        r6 = r0.m43126c(r6);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ChronoZonedDateTimeImpl.b(org.threeten.bp.temporal.TemporalField, long):org.threeten.bp.chrono.ChronoZonedDateTime<D>");
    }

    public final ChronoZonedDateTime<D> mo7944d(long j, TemporalUnit temporalUnit) {
        if (temporalUnit instanceof ChronoUnit) {
            return m44202b((TemporalAdjuster) this.f42062a.m44234c(j, temporalUnit));
        }
        return m44212e().m44176h().m43126c(temporalUnit.mo7861a(this, j));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ChronoZonedDateTime) && m44194a((ChronoZonedDateTime) obj) == null;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f42062a.toString());
        stringBuilder.append(this.f42063b.toString());
        String stringBuilder2 = stringBuilder.toString();
        if (this.f42063b == this.f42064c) {
            return stringBuilder2;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append('[');
        stringBuilder3.append(this.f42064c.toString());
        stringBuilder3.append(']');
        return stringBuilder3.toString();
    }

    public final int hashCode() {
        return (this.f42062a.hashCode() ^ this.f42063b.hashCode()) ^ Integer.rotateLeft(this.f42064c.hashCode(), 3);
    }
}
