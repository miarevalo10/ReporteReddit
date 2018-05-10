package org.threeten.bp;

import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.jdk8.DefaultInterfaceTemporalAccessor;
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

public final class Instant extends DefaultInterfaceTemporalAccessor implements Serializable, Comparable<Instant>, Temporal, TemporalAdjuster {
    public static final Instant f18814a = new Instant(0, 0);
    public static final Instant f18815b = m19814a(-31557014167219200L, 0);
    public static final Instant f18816c = m19814a(31556889864403199L, 999999999);
    public static final TemporalQuery<Instant> f18817d = new C15651();
    public final long f18818e;
    public final int f18819f;

    static /* synthetic */ class C09632 {
        static final /* synthetic */ int[] f10933a = new int[ChronoField.values().length];
        static final /* synthetic */ int[] f10934b = new int[ChronoUnit.values().length];

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
            f10934b = r0;
            r0 = 1;
            r1 = f10934b;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = org.threeten.bp.temporal.ChronoUnit.a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2;
            r2 = f10934b;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = org.threeten.bp.temporal.ChronoUnit.b;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3;
            r3 = f10934b;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = org.threeten.bp.temporal.ChronoUnit.c;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r3 = 4;
            r4 = f10934b;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r5 = org.threeten.bp.temporal.ChronoUnit.d;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r4[r5] = r3;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r4 = f10934b;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r5 = org.threeten.bp.temporal.ChronoUnit.e;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r6 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r4[r5] = r6;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r4 = f10934b;	 Catch:{ NoSuchFieldError -> 0x004b }
            r5 = org.threeten.bp.temporal.ChronoUnit.f;	 Catch:{ NoSuchFieldError -> 0x004b }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r6 = 6;	 Catch:{ NoSuchFieldError -> 0x004b }
            r4[r5] = r6;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            r4 = f10934b;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r5 = org.threeten.bp.temporal.ChronoUnit.g;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
            r6 = 7;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r4[r5] = r6;	 Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            r4 = f10934b;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r5 = org.threeten.bp.temporal.ChronoUnit.h;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0062 }
            r6 = 8;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r4[r5] = r6;	 Catch:{ NoSuchFieldError -> 0x0062 }
        L_0x0062:
            r4 = org.threeten.bp.temporal.ChronoField.values();
            r4 = r4.length;
            r4 = new int[r4];
            f10933a = r4;
            r4 = f10933a;	 Catch:{ NoSuchFieldError -> 0x0075 }
            r5 = org.threeten.bp.temporal.ChronoField.a;	 Catch:{ NoSuchFieldError -> 0x0075 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0075 }
            r4[r5] = r0;	 Catch:{ NoSuchFieldError -> 0x0075 }
        L_0x0075:
            r0 = f10933a;	 Catch:{ NoSuchFieldError -> 0x007f }
            r4 = org.threeten.bp.temporal.ChronoField.c;	 Catch:{ NoSuchFieldError -> 0x007f }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x007f }
            r0[r4] = r1;	 Catch:{ NoSuchFieldError -> 0x007f }
        L_0x007f:
            r0 = f10933a;	 Catch:{ NoSuchFieldError -> 0x0089 }
            r1 = org.threeten.bp.temporal.ChronoField.e;	 Catch:{ NoSuchFieldError -> 0x0089 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0089 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0089 }
        L_0x0089:
            r0 = f10933a;	 Catch:{ NoSuchFieldError -> 0x0093 }
            r1 = org.threeten.bp.temporal.ChronoField.C;	 Catch:{ NoSuchFieldError -> 0x0093 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0093 }
            r0[r1] = r3;	 Catch:{ NoSuchFieldError -> 0x0093 }
        L_0x0093:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Instant.2.<clinit>():void");
        }
    }

    static class C15651 implements TemporalQuery<Instant> {
        C15651() {
        }

        public final /* bridge */ /* synthetic */ Object m16436a(TemporalAccessor temporalAccessor) {
            return Instant.m19815a(temporalAccessor);
        }
    }

    public final /* synthetic */ Temporal m19826b(long j, TemporalUnit temporalUnit) {
        return m19818c(j, temporalUnit);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return m19819a((Instant) obj);
    }

    public static Instant m19811a() {
        return Clock.m9393a().mo3059b();
    }

    public static Instant m19812a(long j) {
        return m19813a(j, 0);
    }

    public static Instant m19814a(long j, long j2) {
        return m19813a(Jdk8Methods.b(j, Jdk8Methods.d(j2, 1000000000)), Jdk8Methods.b(j2, 1000000000));
    }

    public static Instant m19816b(long j) {
        return m19813a(Jdk8Methods.d(j, 1000), Jdk8Methods.b(j, 1000) * 1000000);
    }

    public static Instant m19815a(TemporalAccessor temporalAccessor) {
        try {
            return m19814a(temporalAccessor.d(ChronoField.C), (long) temporalAccessor.c(ChronoField.a));
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Unable to obtain Instant from TemporalAccessor: ");
            stringBuilder.append(temporalAccessor);
            stringBuilder.append(", type ");
            stringBuilder.append(temporalAccessor.getClass().getName());
            throw new DateTimeException(stringBuilder.toString(), e);
        }
    }

    private static Instant m19813a(long j, int i) {
        if ((((long) i) | j) == 0) {
            return f18814a;
        }
        if (j >= -31557014167219200L) {
            if (j <= 31556889864403199L) {
                return new Instant(j, i);
            }
        }
        throw new DateTimeException("Instant exceeds minimum or maximum instant");
    }

    private Instant(long j, int i) {
        this.f18818e = j;
        this.f18819f = i;
    }

    public final boolean m19825a(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return (temporalField == null || temporalField.a(this) == null) ? false : true;
        } else {
            if (!(temporalField == ChronoField.C || temporalField == ChronoField.a || temporalField == ChronoField.c)) {
                if (temporalField != ChronoField.e) {
                    return false;
                }
            }
            return true;
        }
    }

    public final ValueRange m19827b(TemporalField temporalField) {
        return super.b(temporalField);
    }

    public final int m19828c(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return super.b(temporalField).b(temporalField.c(this), temporalField);
        }
        switch (C09632.f10933a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.f18819f;
            case 2:
                return this.f18819f / 1000;
            case 3:
                return this.f18819f / 1000000;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
                stringBuilder.append(temporalField);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public final long m19829d(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        switch (C09632.f10933a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return (long) this.f18819f;
            case 2:
                return (long) (this.f18819f / 1000);
            case 3:
                return (long) (this.f18819f / 1000000);
            case 4:
                return this.f18818e;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
                stringBuilder.append(temporalField);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private Instant m19818c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Instant) temporalUnit.a(this, j);
        }
        switch (C09632.f10934b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return m19817b(0, j);
            case 2:
                return m19817b(j / 1000000, (j % 1000000) * 1000);
            case 3:
                return m19817b(j / 1000, (j % 1000) * 1000000);
            case 4:
                return m19817b(j, 0);
            case 5:
                return m19817b(Jdk8Methods.a(j, 60), 0);
            case 6:
                return m19817b(Jdk8Methods.a(j, 3600), 0);
            case 7:
                return m19817b(Jdk8Methods.a(j, 43200), 0);
            case 8:
                return m19817b(Jdk8Methods.a(j, 86400), 0);
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported unit: ");
                stringBuilder.append(temporalUnit);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private Instant m19817b(long j, long j2) {
        if ((j | j2) == 0) {
            return this;
        }
        return m19814a(Jdk8Methods.b(Jdk8Methods.b(this.f18818e, j), j2 / 1000000000), ((long) this.f18819f) + (j2 % 1000000000));
    }

    public final <R> R m19820a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.c()) {
            return ChronoUnit.a;
        }
        if (!(temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.d())) {
            if (temporalQuery != TemporalQueries.e()) {
                return temporalQuery.a(this);
            }
        }
        return null;
    }

    public final Temporal m19822a(Temporal temporal) {
        return temporal.a(ChronoField.C, this.f18818e).a(ChronoField.a, (long) this.f18819f);
    }

    public final int m19819a(Instant instant) {
        int a = Jdk8Methods.a(this.f18818e, instant.f18818e);
        if (a != 0) {
            return a;
        }
        return this.f18819f - instant.f18819f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.f18818e == instant.f18818e && this.f18819f == instant.f18819f;
    }

    public final int hashCode() {
        return ((int) (this.f18818e ^ (this.f18818e >>> 32))) + (51 * this.f18819f);
    }

    public final String toString() {
        return DateTimeFormatter.m.a(this);
    }

    public final /* synthetic */ Temporal m19821a(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? m19818c(Long.MAX_VALUE, temporalUnit).m19818c(1, temporalUnit) : m19818c(-j, temporalUnit);
    }

    public final /* synthetic */ Temporal m19824a(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (Instant) temporalField.a(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.a(j);
        int i;
        switch (C09632.f10933a[chronoField.ordinal()]) {
            case 1:
                return j != ((long) this.f18819f) ? m19813a(this.f18818e, (int) j) : this;
            case 2:
                i = ((int) j) * 1000;
                return i != this.f18819f ? m19813a(this.f18818e, i) : this;
            case 3:
                i = ((int) j) * 1000000;
                return i != this.f18819f ? m19813a(this.f18818e, i) : this;
            case 4:
                return j != this.f18818e ? m19813a(j, this.f18819f) : this;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
                stringBuilder.append(temporalField);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }
}
