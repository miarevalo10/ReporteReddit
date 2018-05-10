package org.threeten.bp;

import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.ChronoLocalDateTime;
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

public final class LocalDateTime extends ChronoLocalDateTime<LocalDate> implements Serializable, Temporal, TemporalAdjuster {
    public static final LocalDateTime f19780a = m21432a(LocalDate.f19774a, LocalTime.f18820a);
    public static final LocalDateTime f19781b = m21432a(LocalDate.f19775b, LocalTime.f18821b);
    public static final TemporalQuery<LocalDateTime> f19782c = new C15671();
    public final LocalDate f19783d;
    public final LocalTime f19784e;

    static /* synthetic */ class C09652 {
        static final /* synthetic */ int[] f10937a = new int[ChronoUnit.values().length];

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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = org.threeten.bp.temporal.ChronoUnit.values();
            r0 = r0.length;
            r0 = new int[r0];
            f10937a = r0;
            r0 = f10937a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = org.threeten.bp.temporal.ChronoUnit.a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f10937a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = org.threeten.bp.temporal.ChronoUnit.b;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = f10937a;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = org.threeten.bp.temporal.ChronoUnit.c;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = f10937a;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = org.threeten.bp.temporal.ChronoUnit.d;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r0 = f10937a;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = org.threeten.bp.temporal.ChronoUnit.e;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r2 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r0 = f10937a;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = org.threeten.bp.temporal.ChronoUnit.f;	 Catch:{ NoSuchFieldError -> 0x004b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r2 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            r0 = f10937a;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = org.threeten.bp.temporal.ChronoUnit.g;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
            r2 = 7;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.LocalDateTime.2.<clinit>():void");
        }
    }

    static class C15671 implements TemporalQuery<LocalDateTime> {
        C15671() {
        }

        public final /* bridge */ /* synthetic */ Object m16438a(TemporalAccessor temporalAccessor) {
            return LocalDateTime.m21433a(temporalAccessor);
        }
    }

    public final /* synthetic */ Temporal m21444a(long j, TemporalUnit temporalUnit) {
        return m21439f(j, temporalUnit);
    }

    public final /* synthetic */ Temporal m21446a(TemporalAdjuster temporalAdjuster) {
        return m21437c(temporalAdjuster);
    }

    public final /* synthetic */ Temporal m21447a(TemporalField temporalField, long j) {
        return m21449b(temporalField, j);
    }

    public final /* synthetic */ ChronoLocalDateTime m21451b(TemporalAdjuster temporalAdjuster) {
        return m21437c(temporalAdjuster);
    }

    public final /* synthetic */ Temporal m21452b(long j, TemporalUnit temporalUnit) {
        return m21456c(j, temporalUnit);
    }

    public final /* synthetic */ ChronoLocalDateTime m21457c(TemporalField temporalField, long j) {
        return m21449b(temporalField, j);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return m21440a((ChronoLocalDateTime) obj);
    }

    public final /* synthetic */ ChronoLocalDateTime m21460d(long j, TemporalUnit temporalUnit) {
        return m21439f(j, temporalUnit);
    }

    public final /* synthetic */ ChronoLocalDateTime m21461e(long j, TemporalUnit temporalUnit) {
        return m21456c(j, temporalUnit);
    }

    public static LocalDateTime m21432a(LocalDate localDate, LocalTime localTime) {
        Jdk8Methods.a(localDate, "date");
        Jdk8Methods.a(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }

    public static LocalDateTime m21430a(long j, int i, ZoneOffset zoneOffset) {
        Jdk8Methods.a(zoneOffset, "offset");
        j += (long) zoneOffset.f16387g;
        return new LocalDateTime(LocalDate.m21389a(Jdk8Methods.d(j, 86400)), LocalTime.m19833a((long) Jdk8Methods.b(j, 86400), i));
    }

    public static org.threeten.bp.LocalDateTime m21433a(org.threeten.bp.temporal.TemporalAccessor r3) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = r3 instanceof org.threeten.bp.LocalDateTime;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r3 = (org.threeten.bp.LocalDateTime) r3;
        return r3;
    L_0x0007:
        r0 = r3 instanceof org.threeten.bp.ZonedDateTime;
        if (r0 == 0) goto L_0x0010;
    L_0x000b:
        r3 = (org.threeten.bp.ZonedDateTime) r3;
        r3 = r3.f19786b;
        return r3;
    L_0x0010:
        r0 = org.threeten.bp.LocalDate.m21390a(r3);	 Catch:{ DateTimeException -> 0x001e }
        r1 = org.threeten.bp.LocalTime.m19834a(r3);	 Catch:{ DateTimeException -> 0x001e }
        r2 = new org.threeten.bp.LocalDateTime;	 Catch:{ DateTimeException -> 0x001e }
        r2.<init>(r0, r1);	 Catch:{ DateTimeException -> 0x001e }
        return r2;
    L_0x001e:
        r0 = new org.threeten.bp.DateTimeException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unable to obtain LocalDateTime from TemporalAccessor: ";
        r1.<init>(r2);
        r1.append(r3);
        r2 = ", type ";
        r1.append(r2);
        r3 = r3.getClass();
        r3 = r3.getName();
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.LocalDateTime.a(org.threeten.bp.temporal.TemporalAccessor):org.threeten.bp.LocalDateTime");
    }

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.f19783d = localDate;
        this.f19784e = localTime;
    }

    private LocalDateTime m21435b(LocalDate localDate, LocalTime localTime) {
        if (this.f19783d == localDate && this.f19784e == localTime) {
            return this;
        }
        return new LocalDateTime(localDate, localTime);
    }

    public final boolean m21448a(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return (temporalField == null || temporalField.a(this) == null) ? false : true;
        } else {
            if (!temporalField.b()) {
                if (temporalField.c() == null) {
                    return false;
                }
            }
            return true;
        }
    }

    public final ValueRange m21453b(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.c() ? this.f19784e.m19855b(temporalField) : this.f19783d.m21413b(temporalField);
        } else {
            return temporalField.b(this);
        }
    }

    public final int m21455c(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.c() ? this.f19784e.m19856c(temporalField) : this.f19783d.m21415c(temporalField);
        } else {
            return super.c(temporalField);
        }
    }

    public final long m21459d(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.c() ? this.f19784e.m19857d(temporalField) : this.f19783d.m21420d(temporalField);
        } else {
            return temporalField.c(this);
        }
    }

    private LocalDateTime m21437c(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return m21435b((LocalDate) temporalAdjuster, this.f19784e);
        }
        if (temporalAdjuster instanceof LocalTime) {
            return m21435b(this.f19783d, (LocalTime) temporalAdjuster);
        }
        if (temporalAdjuster instanceof LocalDateTime) {
            return (LocalDateTime) temporalAdjuster;
        }
        return (LocalDateTime) temporalAdjuster.a(this);
    }

    public final LocalDateTime m21449b(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalDateTime) temporalField.a(this, j);
        }
        if (temporalField.c()) {
            return m21435b(this.f19783d, this.f19784e.m19853b(temporalField, j));
        }
        return m21435b(this.f19783d.m21410b(temporalField, j), this.f19784e);
    }

    public final LocalDateTime m21456c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDateTime) temporalUnit.a(this, j);
        }
        switch (C09652.f10937a[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return m21438d(j);
            case 2:
                return m21434b(j / 86400000000L).m21438d((j % 86400000000L) * 1000);
            case 3:
                return m21434b(j / 86400000).m21438d((j % 86400000) * 1000000);
            case 4:
                return m21442a(j);
            case 5:
                return m21431a(this.f19783d, 0, j, 0, 0);
            case 6:
                return m21436c(j);
            case 7:
                return m21434b(j / 256).m21436c((j % 256) * 12);
            default:
                return m21435b(this.f19783d.m21417c(j, temporalUnit), this.f19784e);
        }
    }

    private LocalDateTime m21434b(long j) {
        return m21435b(this.f19783d.m21422d(j), this.f19784e);
    }

    private LocalDateTime m21436c(long j) {
        return m21431a(this.f19783d, j, 0, 0, 0);
    }

    public final LocalDateTime m21442a(long j) {
        return m21431a(this.f19783d, 0, 0, j, 0);
    }

    private LocalDateTime m21438d(long j) {
        return m21431a(this.f19783d, 0, 0, 0, j);
    }

    private LocalDateTime m21439f(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? m21456c(Long.MAX_VALUE, temporalUnit).m21456c(1, temporalUnit) : m21456c(-j, temporalUnit);
    }

    private LocalDateTime m21431a(LocalDate localDate, long j, long j2, long j3, long j4) {
        LocalDateTime localDateTime = this;
        LocalDate localDate2 = localDate;
        if ((((j | j2) | j3) | j4) == 0) {
            return m21435b(localDate2, localDateTime.f19784e);
        }
        long j5 = ((((j4 / 86400000000000L) + (j3 / 86400)) + (j2 / 1440)) + (j / 24)) * 1;
        long j6 = (((j4 % 86400000000000L) + ((j3 % 86400) * 1000000000)) + ((j2 % 1440) * 60000000000L)) + ((j % 24) * 3600000000000L);
        long b = localDateTime.f19784e.m19852b();
        j6 = (j6 * 1) + b;
        j5 += Jdk8Methods.d(j6, 86400000000000L);
        long e = Jdk8Methods.e(j6, 86400000000000L);
        return m21435b(localDate2.m21422d(j5), e == b ? localDateTime.f19784e : LocalTime.m19836b(e));
    }

    public final <R> R m21441a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.f()) {
            return this.f19783d;
        }
        return super.a(temporalQuery);
    }

    public final Temporal m21445a(Temporal temporal) {
        return super.a(temporal);
    }

    public final LocalTime m21443a() {
        return this.f19784e;
    }

    public final int m21440a(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return m21429a((LocalDateTime) chronoLocalDateTime);
        }
        return super.a(chronoLocalDateTime);
    }

    private int m21429a(LocalDateTime localDateTime) {
        int a = this.f19783d.m21397a(localDateTime.f19783d);
        return a == 0 ? this.f19784e.m19845a(localDateTime.f19784e) : a;
    }

    public final boolean m21454b(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return m21429a((LocalDateTime) chronoLocalDateTime) > null ? true : null;
        } else {
            return super.b(chronoLocalDateTime);
        }
    }

    public final boolean m21458c(ChronoLocalDateTime<?> chronoLocalDateTime) {
        if (chronoLocalDateTime instanceof LocalDateTime) {
            return m21429a((LocalDateTime) chronoLocalDateTime) < null ? true : null;
        } else {
            return super.c(chronoLocalDateTime);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.f19783d.equals(localDateTime.f19783d) && this.f19784e.equals(localDateTime.f19784e) != null;
    }

    public final int hashCode() {
        return this.f19783d.hashCode() ^ this.f19784e.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.f19783d.toString());
        stringBuilder.append('T');
        stringBuilder.append(this.f19784e.toString());
        return stringBuilder.toString();
    }

    public final /* bridge */ /* synthetic */ ChronoLocalDate m21450b() {
        return this.f19783d;
    }
}
