package org.threeten.bp;

import java.io.Serializable;
import java.util.Locale;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
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

public final class Year extends DefaultInterfaceTemporalAccessor implements Serializable, Comparable<Year>, Temporal, TemporalAdjuster {
    public static final TemporalQuery<Year> f18830a = new C15701();
    private static final DateTimeFormatter f18831b = new DateTimeFormatterBuilder().a(ChronoField.A, 4, 10, SignStyle.e).a(Locale.getDefault());
    private final int f18832c;

    static /* synthetic */ class C09682 {
        static final /* synthetic */ int[] f10941a = new int[ChronoField.values().length];
        static final /* synthetic */ int[] f10942b = new int[ChronoUnit.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = org.threeten.bp.temporal.ChronoUnit.values();
            r0 = r0.length;
            r0 = new int[r0];
            f10942b = r0;
            r0 = 1;
            r1 = f10942b;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = org.threeten.bp.temporal.ChronoUnit.k;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2;
            r2 = f10942b;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = org.threeten.bp.temporal.ChronoUnit.l;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3;
            r3 = f10942b;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = org.threeten.bp.temporal.ChronoUnit.m;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r3 = f10942b;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r4 = org.threeten.bp.temporal.ChronoUnit.n;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r5 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r3[r4] = r5;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r3 = f10942b;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r4 = org.threeten.bp.temporal.ChronoUnit.o;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r5 = 5;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r3[r4] = r5;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r3 = org.threeten.bp.temporal.ChronoField.values();
            r3 = r3.length;
            r3 = new int[r3];
            f10941a = r3;
            r3 = f10941a;	 Catch:{ NoSuchFieldError -> 0x0053 }
            r4 = org.threeten.bp.temporal.ChronoField.z;	 Catch:{ NoSuchFieldError -> 0x0053 }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x0053 }
            r3[r4] = r0;	 Catch:{ NoSuchFieldError -> 0x0053 }
        L_0x0053:
            r0 = f10941a;	 Catch:{ NoSuchFieldError -> 0x005d }
            r3 = org.threeten.bp.temporal.ChronoField.A;	 Catch:{ NoSuchFieldError -> 0x005d }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x005d }
            r0[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x005d }
        L_0x005d:
            r0 = f10941a;	 Catch:{ NoSuchFieldError -> 0x0067 }
            r1 = org.threeten.bp.temporal.ChronoField.B;	 Catch:{ NoSuchFieldError -> 0x0067 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0067 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0067 }
        L_0x0067:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Year.2.<clinit>():void");
        }
    }

    static class C15701 implements TemporalQuery<Year> {
        C15701() {
        }

        public final /* bridge */ /* synthetic */ Object m16452a(TemporalAccessor temporalAccessor) {
            return Year.m19859a(temporalAccessor);
        }
    }

    public final /* synthetic */ Temporal m19868a(TemporalField temporalField, long j) {
        return m19862b(temporalField, j);
    }

    public final /* synthetic */ Temporal m19870b(long j, TemporalUnit temporalUnit) {
        return m19863c(j, temporalUnit);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f18832c - ((Year) obj).f18832c;
    }

    private static Year m19858a(int i) {
        ChronoField.A.a((long) i);
        return new Year(i);
    }

    public static org.threeten.bp.Year m19859a(org.threeten.bp.temporal.TemporalAccessor r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3 instanceof org.threeten.bp.Year;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r3 = (org.threeten.bp.Year) r3;
        return r3;
    L_0x0007:
        r0 = org.threeten.bp.chrono.IsoChronology.b;	 Catch:{ DateTimeException -> 0x0023 }
        r1 = org.threeten.bp.chrono.Chronology.a(r3);	 Catch:{ DateTimeException -> 0x0023 }
        r0 = r0.equals(r1);	 Catch:{ DateTimeException -> 0x0023 }
        if (r0 != 0) goto L_0x0018;	 Catch:{ DateTimeException -> 0x0023 }
    L_0x0013:
        r0 = org.threeten.bp.LocalDate.m21390a(r3);	 Catch:{ DateTimeException -> 0x0023 }
        r3 = r0;	 Catch:{ DateTimeException -> 0x0023 }
    L_0x0018:
        r0 = org.threeten.bp.temporal.ChronoField.A;	 Catch:{ DateTimeException -> 0x0023 }
        r0 = r3.c(r0);	 Catch:{ DateTimeException -> 0x0023 }
        r0 = m19858a(r0);	 Catch:{ DateTimeException -> 0x0023 }
        return r0;
    L_0x0023:
        r0 = new org.threeten.bp.DateTimeException;
        r1 = new java.lang.StringBuilder;
        r2 = "Unable to obtain Year from TemporalAccessor: ";
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
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.Year.a(org.threeten.bp.temporal.TemporalAccessor):org.threeten.bp.Year");
    }

    public static boolean m19860a(long j) {
        return ((3 & j) != 0 || (j % 100 == 0 && j % 400 != 0)) ? 0 : 1;
    }

    private Year(int i) {
        this.f18832c = i;
    }

    public final boolean m19869a(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return (temporalField == null || temporalField.a(this) == null) ? false : true;
        } else {
            if (!(temporalField == ChronoField.A || temporalField == ChronoField.z)) {
                if (temporalField != ChronoField.B) {
                    return false;
                }
            }
            return true;
        }
    }

    public final ValueRange m19871b(TemporalField temporalField) {
        if (temporalField != ChronoField.z) {
            return super.b(temporalField);
        }
        return ValueRange.a(1, this.f18832c <= null ? 1000000000 : 999999999);
    }

    public final int m19872c(TemporalField temporalField) {
        return m19871b(temporalField).b(m19873d(temporalField), temporalField);
    }

    public final long m19873d(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        int i = 1;
        switch (C09682.f10941a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return (long) (this.f18832c <= null ? 1 - this.f18832c : this.f18832c);
            case 2:
                return (long) this.f18832c;
            case 3:
                if (this.f18832c <= null) {
                    i = 0;
                }
                return (long) i;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
                stringBuilder.append(temporalField);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private Year m19862b(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (Year) temporalField.a(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.a(j);
        switch (C09682.f10941a[chronoField.ordinal()]) {
            case 1:
                if (this.f18832c <= null) {
                    j = 1 - j;
                }
                return m19858a((int) j);
            case 2:
                return m19858a((int) j);
            case 3:
                return m19873d(ChronoField.B) == j ? this : m19858a(1 - this.f18832c);
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
                stringBuilder.append(temporalField);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private Year m19863c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (Year) temporalUnit.a(this, j);
        }
        switch (C09682.f10942b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return m19861b(j);
            case 2:
                return m19861b(Jdk8Methods.a(j, 10));
            case 3:
                return m19861b(Jdk8Methods.a(j, 100));
            case 4:
                return m19861b(Jdk8Methods.a(j, 1000));
            case 5:
                return m19862b(ChronoField.B, Jdk8Methods.b(m19873d(ChronoField.B), j));
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported unit: ");
                stringBuilder.append(temporalUnit);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private Year m19861b(long j) {
        return j == 0 ? this : m19858a(ChronoField.A.b(((long) this.f18832c) + j));
    }

    public final <R> R m19864a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.b()) {
            return IsoChronology.b;
        }
        if (temporalQuery == TemporalQueries.c()) {
            return ChronoUnit.k;
        }
        if (!(temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.a())) {
            if (temporalQuery != TemporalQueries.e()) {
                return super.a(temporalQuery);
            }
        }
        return null;
    }

    public final Temporal m19866a(Temporal temporal) {
        if (Chronology.a(temporal).equals(IsoChronology.b)) {
            return temporal.a(ChronoField.A, (long) this.f18832c);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Year) && this.f18832c == ((Year) obj).f18832c;
    }

    public final int hashCode() {
        return this.f18832c;
    }

    public final String toString() {
        return Integer.toString(this.f18832c);
    }

    public final /* synthetic */ Temporal m19865a(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? m19863c(Long.MAX_VALUE, temporalUnit).m19863c(1, temporalUnit) : m19863c(-j, temporalUnit);
    }
}
