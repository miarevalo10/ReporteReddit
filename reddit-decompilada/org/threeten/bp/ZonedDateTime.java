package org.threeten.bp;

import java.io.Serializable;
import java.util.List;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.ChronoZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;
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
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneRules;

public final class ZonedDateTime extends ChronoZonedDateTime<LocalDate> implements Serializable, Temporal {
    public static final TemporalQuery<ZonedDateTime> f19785a = new C15731();
    public final LocalDateTime f19786b;
    private final ZoneOffset f19787c;
    private final ZoneId f19788d;

    static /* synthetic */ class C09692 {
        static final /* synthetic */ int[] f10945a = new int[ChronoField.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = org.threeten.bp.temporal.ChronoField.values();
            r0 = r0.length;
            r0 = new int[r0];
            f10945a = r0;
            r0 = f10945a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = org.threeten.bp.temporal.ChronoField.C;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f10945a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = org.threeten.bp.temporal.ChronoField.D;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZonedDateTime.2.<clinit>():void");
        }
    }

    static class C15731 implements TemporalQuery<ZonedDateTime> {
        C15731() {
        }

        public final /* bridge */ /* synthetic */ Object m16472a(TemporalAccessor temporalAccessor) {
            return ZonedDateTime.m21467a(temporalAccessor);
        }
    }

    public final /* synthetic */ Temporal m21475a(long j, TemporalUnit temporalUnit) {
        return m21471f(j, temporalUnit);
    }

    public final /* synthetic */ Temporal m21476a(TemporalAdjuster temporalAdjuster) {
        return m21468c(temporalAdjuster);
    }

    public final /* synthetic */ Temporal m21477a(TemporalField temporalField, long j) {
        return m21469c(temporalField, j);
    }

    public final /* synthetic */ ChronoZonedDateTime m21480b(TemporalAdjuster temporalAdjuster) {
        return m21468c(temporalAdjuster);
    }

    public final /* synthetic */ ChronoZonedDateTime m21481b(TemporalField temporalField, long j) {
        return m21469c(temporalField, j);
    }

    public final /* synthetic */ Temporal m21482b(long j, TemporalUnit temporalUnit) {
        return m21470e(j, temporalUnit);
    }

    public final /* synthetic */ ChronoZonedDateTime m21486c(long j, TemporalUnit temporalUnit) {
        return m21471f(j, temporalUnit);
    }

    public final /* synthetic */ ChronoZonedDateTime m21489d(long j, TemporalUnit temporalUnit) {
        return m21470e(j, temporalUnit);
    }

    private static ZonedDateTime m21465a(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Jdk8Methods.a(localDateTime, "localDateTime");
        Jdk8Methods.a(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules c = zoneId.mo3063c();
        List a = c.a(localDateTime);
        if (a.size() == 1) {
            zoneOffset = (ZoneOffset) a.get(0);
        } else if (a.size() == 0) {
            zoneOffset = c.b(localDateTime);
            localDateTime = localDateTime.m21442a(zoneOffset.c().f10931b);
            zoneOffset = zoneOffset.c;
        } else if (zoneOffset == null || !a.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) Jdk8Methods.a(a.get(0), "offset");
        }
        return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
    }

    public static ZonedDateTime m21463a(Instant instant, ZoneId zoneId) {
        Jdk8Methods.a(instant, "instant");
        Jdk8Methods.a(zoneId, "zone");
        return m21462a(instant.f18818e, instant.f18819f, zoneId);
    }

    private static ZonedDateTime m21462a(long j, int i, ZoneId zoneId) {
        ZoneOffset a = zoneId.mo3063c().a(Instant.m19814a(j, (long) i));
        return new ZonedDateTime(LocalDateTime.m21430a(j, i, a), a, zoneId);
    }

    public static org.threeten.bp.ZonedDateTime m21467a(org.threeten.bp.temporal.TemporalAccessor r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = r4 instanceof org.threeten.bp.ZonedDateTime;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r4 = (org.threeten.bp.ZonedDateTime) r4;
        return r4;
    L_0x0007:
        r0 = org.threeten.bp.ZoneId.m9400a(r4);	 Catch:{ DateTimeException -> 0x002e }
        r1 = org.threeten.bp.temporal.ChronoField.C;	 Catch:{ DateTimeException -> 0x002e }
        r1 = r4.a(r1);	 Catch:{ DateTimeException -> 0x002e }
        if (r1 == 0) goto L_0x0024;
    L_0x0013:
        r1 = org.threeten.bp.temporal.ChronoField.C;	 Catch:{ DateTimeException -> 0x0024 }
        r1 = r4.d(r1);	 Catch:{ DateTimeException -> 0x0024 }
        r3 = org.threeten.bp.temporal.ChronoField.a;	 Catch:{ DateTimeException -> 0x0024 }
        r3 = r4.c(r3);	 Catch:{ DateTimeException -> 0x0024 }
        r1 = m21462a(r1, r3, r0);	 Catch:{ DateTimeException -> 0x0024 }
        return r1;
    L_0x0024:
        r1 = org.threeten.bp.LocalDateTime.m21433a(r4);	 Catch:{ DateTimeException -> 0x002e }
        r2 = 0;	 Catch:{ DateTimeException -> 0x002e }
        r0 = m21465a(r1, r0, r2);	 Catch:{ DateTimeException -> 0x002e }
        return r0;
    L_0x002e:
        r0 = new org.threeten.bp.DateTimeException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unable to obtain ZonedDateTime from TemporalAccessor: ";
        r1.<init>(r2);
        r1.append(r4);
        r2 = ", type ";
        r1.append(r2);
        r4 = r4.getClass();
        r4 = r4.getName();
        r1.append(r4);
        r4 = r1.toString();
        r0.<init>(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZonedDateTime.a(org.threeten.bp.temporal.TemporalAccessor):org.threeten.bp.ZonedDateTime");
    }

    private ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.f19786b = localDateTime;
        this.f19787c = zoneOffset;
        this.f19788d = zoneId;
    }

    private ZonedDateTime m21464a(LocalDateTime localDateTime) {
        return m21465a(localDateTime, this.f19788d, this.f19787c);
    }

    private ZonedDateTime m21466a(ZoneOffset zoneOffset) {
        return (zoneOffset.equals(this.f19787c) || !this.f19788d.mo3063c().a(this.f19786b, zoneOffset)) ? this : new ZonedDateTime(this.f19786b, zoneOffset, this.f19788d);
    }

    public final boolean m21478a(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            if (temporalField == null || temporalField.a(this) == null) {
                return null;
            }
        }
        return true;
    }

    public final ValueRange m21483b(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.b(this);
        }
        if (temporalField != ChronoField.C) {
            if (temporalField != ChronoField.D) {
                return this.f19786b.m21453b(temporalField);
            }
        }
        return temporalField.a();
    }

    public final int m21484c(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.c(temporalField);
        }
        switch (C09692.f10945a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                StringBuilder stringBuilder = new StringBuilder("Field too large for an int: ");
                stringBuilder.append(temporalField);
                throw new DateTimeException(stringBuilder.toString());
            case 2:
                return this.f19787c.f16387g;
            default:
                return this.f19786b.m21455c(temporalField);
        }
    }

    public final long m21487d(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        switch (C09692.f10945a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return f();
            case 2:
                return (long) this.f19787c.f16387g;
            default:
                return this.f19786b.m21459d(temporalField);
        }
    }

    public final ZoneOffset m21474a() {
        return this.f19787c;
    }

    public final ZoneId m21479b() {
        return this.f19788d;
    }

    private ZonedDateTime m21468c(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return m21464a(LocalDateTime.m21432a((LocalDate) temporalAdjuster, this.f19786b.f19784e));
        }
        if (temporalAdjuster instanceof LocalTime) {
            return m21464a(LocalDateTime.m21432a(this.f19786b.f19783d, (LocalTime) temporalAdjuster));
        }
        if (temporalAdjuster instanceof LocalDateTime) {
            return m21464a((LocalDateTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof Instant) {
            Instant instant = (Instant) temporalAdjuster;
            return m21462a(instant.f18818e, instant.f18819f, this.f19788d);
        } else if (temporalAdjuster instanceof ZoneOffset) {
            return m21466a((ZoneOffset) temporalAdjuster);
        } else {
            return (ZonedDateTime) temporalAdjuster.a(this);
        }
    }

    private ZonedDateTime m21469c(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (ZonedDateTime) temporalField.a(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        switch (C09692.f10945a[chronoField.ordinal()]) {
            case 1:
                return m21462a(j, this.f19786b.f19784e.f18828h, this.f19788d);
            case 2:
                return m21466a(ZoneOffset.m16456a(chronoField.b(j)));
            default:
                return m21464a(this.f19786b.m21449b(temporalField, j));
        }
    }

    private ZonedDateTime m21470e(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (ZonedDateTime) temporalUnit.a(this, j);
        }
        if (temporalUnit.a()) {
            return m21464a(this.f19786b.m21456c(j, temporalUnit));
        }
        j = this.f19786b.m21456c(j, temporalUnit);
        ZoneOffset zoneOffset = this.f19787c;
        ZoneId zoneId = this.f19788d;
        Jdk8Methods.a(j, "localDateTime");
        Jdk8Methods.a(zoneOffset, "offset");
        Jdk8Methods.a(zoneId, "zone");
        return m21462a(j.b(zoneOffset), j.f19784e.f18828h, zoneId);
    }

    private ZonedDateTime m21471f(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? m21470e(Long.MAX_VALUE, temporalUnit).m21470e(1, temporalUnit) : m21470e(-j, temporalUnit);
    }

    public final <R> R m21472a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.f()) {
            return this.f19786b.f19783d;
        }
        return super.a(temporalQuery);
    }

    public final LocalTime m21485c() {
        return this.f19786b.f19784e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedDateTime)) {
            return false;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
        return this.f19786b.equals(zonedDateTime.f19786b) && this.f19787c.equals(zonedDateTime.f19787c) && this.f19788d.equals(zonedDateTime.f19788d) != null;
    }

    public final int hashCode() {
        return (this.f19786b.hashCode() ^ this.f19787c.hashCode()) ^ Integer.rotateLeft(this.f19788d.hashCode(), 3);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f19786b.toString());
        stringBuilder.append(this.f19787c.toString());
        String stringBuilder2 = stringBuilder.toString();
        if (this.f19787c == this.f19788d) {
            return stringBuilder2;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append('[');
        stringBuilder3.append(this.f19788d.toString());
        stringBuilder3.append(']');
        return stringBuilder3.toString();
    }

    public final String m21473a(DateTimeFormatter dateTimeFormatter) {
        return super.a(dateTimeFormatter);
    }

    public final /* bridge */ /* synthetic */ ChronoLocalDateTime m21488d() {
        return this.f19786b;
    }

    public final /* bridge */ /* synthetic */ ChronoLocalDate m21490e() {
        return this.f19786b.f19783d;
    }
}
