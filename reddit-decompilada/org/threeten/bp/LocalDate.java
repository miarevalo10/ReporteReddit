package org.threeten.bp;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.io.Serializable;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.Era;
import org.threeten.bp.chrono.IsoChronology;
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

public final class LocalDate extends ChronoLocalDate implements Serializable, Temporal, TemporalAdjuster {
    public static final LocalDate f19774a = m21387a(-999999999, 1, 1);
    public static final LocalDate f19775b = m21387a(999999999, 12, 31);
    public static final TemporalQuery<LocalDate> f19776c = new C15661();
    public final int f19777d;
    final short f19778e;
    private final short f19779f;

    static /* synthetic */ class C09642 {
        static final /* synthetic */ int[] f10935a = new int[ChronoField.values().length];
        static final /* synthetic */ int[] f10936b = new int[ChronoUnit.values().length];

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
            f10936b = r0;
            r0 = 1;
            r1 = f10936b;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = org.threeten.bp.temporal.ChronoUnit.h;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2;
            r2 = f10936b;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = org.threeten.bp.temporal.ChronoUnit.i;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3;
            r3 = f10936b;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = org.threeten.bp.temporal.ChronoUnit.j;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r3 = 4;
            r4 = f10936b;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r5 = org.threeten.bp.temporal.ChronoUnit.k;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r4[r5] = r3;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r4 = 5;
            r5 = f10936b;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r6 = org.threeten.bp.temporal.ChronoUnit.l;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r6 = r6.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r5[r6] = r4;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r5 = 6;
            r6 = f10936b;	 Catch:{ NoSuchFieldError -> 0x004b }
            r7 = org.threeten.bp.temporal.ChronoUnit.m;	 Catch:{ NoSuchFieldError -> 0x004b }
            r7 = r7.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r6[r7] = r5;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            r6 = 7;
            r7 = f10936b;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r8 = org.threeten.bp.temporal.ChronoUnit.n;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r8 = r8.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
            r7[r8] = r6;	 Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            r7 = 8;
            r8 = f10936b;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r9 = org.threeten.bp.temporal.ChronoUnit.o;	 Catch:{ NoSuchFieldError -> 0x0062 }
            r9 = r9.ordinal();	 Catch:{ NoSuchFieldError -> 0x0062 }
            r8[r9] = r7;	 Catch:{ NoSuchFieldError -> 0x0062 }
        L_0x0062:
            r8 = org.threeten.bp.temporal.ChronoField.values();
            r8 = r8.length;
            r8 = new int[r8];
            f10935a = r8;
            r8 = f10935a;	 Catch:{ NoSuchFieldError -> 0x0075 }
            r9 = org.threeten.bp.temporal.ChronoField.s;	 Catch:{ NoSuchFieldError -> 0x0075 }
            r9 = r9.ordinal();	 Catch:{ NoSuchFieldError -> 0x0075 }
            r8[r9] = r0;	 Catch:{ NoSuchFieldError -> 0x0075 }
        L_0x0075:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x007f }
            r8 = org.threeten.bp.temporal.ChronoField.t;	 Catch:{ NoSuchFieldError -> 0x007f }
            r8 = r8.ordinal();	 Catch:{ NoSuchFieldError -> 0x007f }
            r0[r8] = r1;	 Catch:{ NoSuchFieldError -> 0x007f }
        L_0x007f:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x0089 }
            r1 = org.threeten.bp.temporal.ChronoField.v;	 Catch:{ NoSuchFieldError -> 0x0089 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0089 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0089 }
        L_0x0089:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x0093 }
            r1 = org.threeten.bp.temporal.ChronoField.z;	 Catch:{ NoSuchFieldError -> 0x0093 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0093 }
            r0[r1] = r3;	 Catch:{ NoSuchFieldError -> 0x0093 }
        L_0x0093:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x009d }
            r1 = org.threeten.bp.temporal.ChronoField.p;	 Catch:{ NoSuchFieldError -> 0x009d }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x009d }
            r0[r1] = r4;	 Catch:{ NoSuchFieldError -> 0x009d }
        L_0x009d:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x00a7 }
            r1 = org.threeten.bp.temporal.ChronoField.q;	 Catch:{ NoSuchFieldError -> 0x00a7 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00a7 }
            r0[r1] = r5;	 Catch:{ NoSuchFieldError -> 0x00a7 }
        L_0x00a7:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x00b1 }
            r1 = org.threeten.bp.temporal.ChronoField.r;	 Catch:{ NoSuchFieldError -> 0x00b1 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00b1 }
            r0[r1] = r6;	 Catch:{ NoSuchFieldError -> 0x00b1 }
        L_0x00b1:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x00bb }
            r1 = org.threeten.bp.temporal.ChronoField.u;	 Catch:{ NoSuchFieldError -> 0x00bb }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00bb }
            r0[r1] = r7;	 Catch:{ NoSuchFieldError -> 0x00bb }
        L_0x00bb:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x00c7 }
            r1 = org.threeten.bp.temporal.ChronoField.w;	 Catch:{ NoSuchFieldError -> 0x00c7 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00c7 }
            r2 = 9;	 Catch:{ NoSuchFieldError -> 0x00c7 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00c7 }
        L_0x00c7:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x00d3 }
            r1 = org.threeten.bp.temporal.ChronoField.x;	 Catch:{ NoSuchFieldError -> 0x00d3 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00d3 }
            r2 = 10;	 Catch:{ NoSuchFieldError -> 0x00d3 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00d3 }
        L_0x00d3:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x00df }
            r1 = org.threeten.bp.temporal.ChronoField.y;	 Catch:{ NoSuchFieldError -> 0x00df }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00df }
            r2 = 11;	 Catch:{ NoSuchFieldError -> 0x00df }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00df }
        L_0x00df:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x00eb }
            r1 = org.threeten.bp.temporal.ChronoField.A;	 Catch:{ NoSuchFieldError -> 0x00eb }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00eb }
            r2 = 12;	 Catch:{ NoSuchFieldError -> 0x00eb }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00eb }
        L_0x00eb:
            r0 = f10935a;	 Catch:{ NoSuchFieldError -> 0x00f7 }
            r1 = org.threeten.bp.temporal.ChronoField.B;	 Catch:{ NoSuchFieldError -> 0x00f7 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00f7 }
            r2 = 13;	 Catch:{ NoSuchFieldError -> 0x00f7 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00f7 }
        L_0x00f7:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.LocalDate.2.<clinit>():void");
        }
    }

    static class C15661 implements TemporalQuery<LocalDate> {
        C15661() {
        }

        public final /* bridge */ /* synthetic */ Object m16437a(TemporalAccessor temporalAccessor) {
            return LocalDate.m21390a(temporalAccessor);
        }
    }

    public final /* synthetic */ Temporal m21403a(long j, TemporalUnit temporalUnit) {
        return m21396f(j, temporalUnit);
    }

    public final /* synthetic */ Temporal m21405a(TemporalAdjuster temporalAdjuster) {
        return m21409b(temporalAdjuster);
    }

    public final /* synthetic */ Temporal m21406a(TemporalField temporalField, long j) {
        return m21410b(temporalField, j);
    }

    public final /* synthetic */ Temporal m21412b(long j, TemporalUnit temporalUnit) {
        return m21417c(j, temporalUnit);
    }

    public final /* synthetic */ ChronoLocalDate m21418c(TemporalAdjuster temporalAdjuster) {
        return m21409b(temporalAdjuster);
    }

    public final /* synthetic */ ChronoLocalDate m21419c(TemporalField temporalField, long j) {
        return m21410b(temporalField, j);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return m21398a((ChronoLocalDate) obj);
    }

    public final /* synthetic */ ChronoLocalDate m21423d(long j, TemporalUnit temporalUnit) {
        return m21396f(j, temporalUnit);
    }

    public final /* synthetic */ ChronoLocalDate m21424e(long j, TemporalUnit temporalUnit) {
        return m21417c(j, temporalUnit);
    }

    public static LocalDate m21388a(int i, Month month, int i2) {
        ChronoField.A.a((long) i);
        Jdk8Methods.a(month, "month");
        ChronoField.s.a((long) i2);
        return m21393b(i, month, i2);
    }

    public static LocalDate m21387a(int i, int i2, int i3) {
        ChronoField.A.a((long) i);
        ChronoField.x.a((long) i2);
        ChronoField.s.a((long) i3);
        return m21393b(i, Month.m16441a(i2), i3);
    }

    public static LocalDate m21389a(long j) {
        long j2;
        long j3;
        long j4 = j;
        ChronoField.u.a(j4);
        j4 = (j4 + 719528) - 60;
        if (j4 < 0) {
            j2 = ((j4 + 1) / 146097) - 1;
            j3 = j2 * 400;
            j4 += (-j2) * 146097;
        } else {
            j3 = 0;
        }
        j2 = ((400 * j4) + 591) / 146097;
        long j5 = j4 - ((((365 * j2) + (j2 / 4)) - (j2 / 100)) + (j2 / 400));
        if (j5 < 0) {
            j2--;
            j5 = j4 - ((((365 * j2) + (j2 / 4)) - (j2 / 100)) + (j2 / 400));
        }
        int i = (int) j5;
        int i2 = ((i * 5) + 2) / 153;
        return new LocalDate(ChronoField.A.b((j2 + j3) + ((long) (i2 / 10))), ((i2 + 2) % 12) + 1, (i - (((i2 * 306) + 5) / 10)) + 1);
    }

    public static LocalDate m21390a(TemporalAccessor temporalAccessor) {
        LocalDate localDate = (LocalDate) temporalAccessor.a(TemporalQueries.f());
        if (localDate != null) {
            return localDate;
        }
        StringBuilder stringBuilder = new StringBuilder("Unable to obtain LocalDate from TemporalAccessor: ");
        stringBuilder.append(temporalAccessor);
        stringBuilder.append(", type ");
        stringBuilder.append(temporalAccessor.getClass().getName());
        throw new DateTimeException(stringBuilder.toString());
    }

    private static LocalDate m21393b(int i, Month month, int i2) {
        if (i2 <= 28 || i2 <= month.m16443a(IsoChronology.b.a((long) i))) {
            return new LocalDate(i, month.ordinal() + 1, i2);
        }
        if (i2 == 29) {
            i2 = new StringBuilder("Invalid date 'February 29' as '");
            i2.append(i);
            i2.append("' is not a leap year");
            throw new DateTimeException(i2.toString());
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid date '");
        stringBuilder.append(month.name());
        stringBuilder.append(" ");
        stringBuilder.append(i2);
        stringBuilder.append("'");
        throw new DateTimeException(stringBuilder.toString());
    }

    private static LocalDate m21392b(int i, int i2, int i3) {
        if (i2 == 2) {
            i3 = Math.min(i3, IsoChronology.b.a((long) i) ? 29 : 28);
        } else if (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) {
            i3 = Math.min(i3, 30);
        }
        return m21387a(i, i2, i3);
    }

    private LocalDate(int i, int i2, int i3) {
        this.f19777d = i;
        this.f19779f = (short) i2;
        this.f19778e = (short) i3;
    }

    public final boolean m21407a(TemporalField temporalField) {
        return super.a(temporalField);
    }

    public final ValueRange m21413b(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.b(this);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        if (chronoField.b()) {
            long j;
            switch (C09642.f10935a[chronoField.ordinal()]) {
                case 1:
                    return ValueRange.a(1, (long) m21426f());
                case 2:
                    return ValueRange.a(1, (long) (m21425e() != null ? 366 : 365));
                case 3:
                    j = (Month.m16441a(this.f19779f) == Month.FEBRUARY && m21425e() == null) ? 4 : 5;
                    return ValueRange.a(1, j);
                case 4:
                    if (this.f19777d <= null) {
                        j = 1000000000;
                    } else {
                        j = 999999999;
                    }
                    return ValueRange.a(1, j);
                default:
                    return temporalField.a();
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
        stringBuilder.append(temporalField);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public final int m21415c(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return m21394e(temporalField);
        }
        return super.c(temporalField);
    }

    public final long m21420d(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        if (temporalField == ChronoField.u) {
            return m21427g();
        }
        if (temporalField == ChronoField.y) {
            return m21399a();
        }
        return (long) m21394e(temporalField);
    }

    private int m21394e(TemporalField temporalField) {
        StringBuilder stringBuilder;
        switch (C09642.f10935a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.f19778e;
            case 2:
                return m21414c();
            case 3:
                return ((this.f19778e - 1) / 7) + 1;
            case 4:
                return this.f19777d > null ? this.f19777d : 1 - this.f19777d;
            case 5:
                return m21421d().ordinal() + 1;
            case 6:
                return ((this.f19778e - 1) % 7) + 1;
            case 7:
                return ((m21414c() - 1) % 7) + 1;
            case 8:
                stringBuilder = new StringBuilder("Field too large for an int: ");
                stringBuilder.append(temporalField);
                throw new DateTimeException(stringBuilder.toString());
            case 9:
                return ((m21414c() - 1) / 7) + 1;
            case 10:
                return this.f19779f;
            case 11:
                stringBuilder = new StringBuilder("Field too large for an int: ");
                stringBuilder.append(temporalField);
                throw new DateTimeException(stringBuilder.toString());
            case 12:
                return this.f19777d;
            case 13:
                if (this.f19777d > null) {
                    return 1;
                }
                return null;
            default:
                stringBuilder = new StringBuilder("Unsupported field: ");
                stringBuilder.append(temporalField);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    final long m21399a() {
        return (((long) this.f19777d) * 12) + ((long) (this.f19779f - 1));
    }

    public final Era m21411b() {
        return super.b();
    }

    public final DayOfWeek m21421d() {
        return DayOfWeek.m16428a(Jdk8Methods.b(m21427g() + 3, 7) + 1);
    }

    public final boolean m21425e() {
        return IsoChronology.b.a((long) this.f19777d);
    }

    public final int m21426f() {
        short s = this.f19779f;
        return s != (short) 2 ? (s == (short) 4 || s == (short) 6 || s == (short) 9 || s == (short) 11) ? 30 : 31 : m21425e() ? 29 : 28;
    }

    public final LocalDate m21409b(TemporalAdjuster temporalAdjuster) {
        if (temporalAdjuster instanceof LocalDate) {
            return (LocalDate) temporalAdjuster;
        }
        return (LocalDate) temporalAdjuster.a(this);
    }

    public final LocalDate m21410b(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalDate) temporalField.a(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.a(j);
        int i;
        switch (C09642.f10935a[chronoField.ordinal()]) {
            case 1:
                i = (int) j;
                if (this.f19778e == i) {
                    return this;
                }
                return m21387a(this.f19777d, this.f19779f, i);
            case 2:
                return m21401a((int) j);
            case 3:
                return m21395e(j - m21420d(ChronoField.v));
            case 4:
                if (this.f19777d <= null) {
                    j = 1 - j;
                }
                return m21391b((int) j);
            case 5:
                return m21422d(j - ((long) (m21421d().ordinal() + 1)));
            case 6:
                return m21422d(j - m21420d(ChronoField.q));
            case 7:
                return m21422d(j - m21420d(ChronoField.r));
            case 8:
                return m21389a(j);
            case 9:
                return m21395e(j - m21420d(ChronoField.w));
            case 10:
                i = (int) j;
                if (this.f19779f == i) {
                    return this;
                }
                ChronoField.x.a((long) i);
                return m21392b(this.f19777d, i, this.f19778e);
            case 11:
                return m21416c(j - m21420d(ChronoField.y));
            case 12:
                return m21391b((int) j);
            case 13:
                return m21420d(ChronoField.B) == j ? this : m21391b(1 - this.f19777d);
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
                stringBuilder.append(temporalField);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private LocalDate m21391b(int i) {
        if (this.f19777d == i) {
            return this;
        }
        ChronoField.A.a((long) i);
        return m21392b(i, this.f19779f, this.f19778e);
    }

    public final LocalDate m21401a(int i) {
        if (m21414c() == i) {
            return this;
        }
        int i2 = this.f19777d;
        long j = (long) i2;
        ChronoField.A.a(j);
        ChronoField.t.a((long) i);
        boolean a = IsoChronology.b.a(j);
        if (i != 366 || a) {
            Month a2 = Month.m16441a(((i - 1) / 31) + 1);
            if (i > (a2.m16447b(a) + a2.m16443a(a)) - 1) {
                a2 = Month.f16374n[(a2.ordinal() + 13) % 12];
            }
            return m21393b(i2, a2, (i - a2.m16447b(a)) + 1);
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid date 'DayOfYear 366' as '");
        stringBuilder.append(i2);
        stringBuilder.append("' is not a leap year");
        throw new DateTimeException(stringBuilder.toString());
    }

    public final LocalDate m21417c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalDate) temporalUnit.a(this, j);
        }
        switch (C09642.f10936b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return m21422d(j);
            case 2:
                return m21395e(j);
            case 3:
                return m21416c(j);
            case 4:
                return m21408b(j);
            case 5:
                return m21408b(Jdk8Methods.a(j, 10));
            case 6:
                return m21408b(Jdk8Methods.a(j, 100));
            case 7:
                return m21408b(Jdk8Methods.a(j, 1000));
            case 8:
                return m21410b(ChronoField.B, Jdk8Methods.b(m21420d(ChronoField.B), j));
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported unit: ");
                stringBuilder.append(temporalUnit);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public final LocalDate m21408b(long j) {
        if (j == 0) {
            return this;
        }
        return m21392b(ChronoField.A.b(((long) this.f19777d) + j), this.f19779f, this.f19778e);
    }

    public final LocalDate m21416c(long j) {
        if (j == 0) {
            return this;
        }
        long j2 = ((((long) this.f19777d) * 12) + ((long) (this.f19779f - 1))) + j;
        return m21392b(ChronoField.A.b(Jdk8Methods.d(j2, 12)), Jdk8Methods.b(j2, 12) + 1, this.f19778e);
    }

    private LocalDate m21395e(long j) {
        return m21422d(Jdk8Methods.a(j, 7));
    }

    public final LocalDate m21422d(long j) {
        if (j == 0) {
            return this;
        }
        return m21389a(Jdk8Methods.b(m21427g(), j));
    }

    private LocalDate m21396f(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? m21417c(Long.MAX_VALUE, temporalUnit).m21417c(1, temporalUnit) : m21417c(-j, temporalUnit);
    }

    public final <R> R m21400a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.f()) {
            return this;
        }
        return super.a(temporalQuery);
    }

    public final Temporal m21404a(Temporal temporal) {
        return super.a(temporal);
    }

    public final long m21427g() {
        long j = (long) this.f19777d;
        long j2 = (long) this.f19779f;
        long j3 = (365 * j) + 0;
        if (j >= 0) {
            j3 += (((3 + j) / 4) - ((99 + j) / 100)) + ((j + 399) / 400);
        } else {
            j3 -= ((j / -4) - (j / -100)) + (j / -400);
        }
        j3 = (j3 + (((367 * j2) - 362) / 12)) + ((long) (this.f19778e - 1));
        if (j2 > 2) {
            j3--;
            if (!m21425e()) {
                j3--;
            }
        }
        return j3 - 719528;
    }

    public final int m21398a(ChronoLocalDate chronoLocalDate) {
        if (chronoLocalDate instanceof LocalDate) {
            return m21397a((LocalDate) chronoLocalDate);
        }
        return super.a(chronoLocalDate);
    }

    final int m21397a(LocalDate localDate) {
        int i = this.f19777d - localDate.f19777d;
        if (i != 0) {
            return i;
        }
        i = this.f19779f - localDate.f19779f;
        return i == 0 ? this.f19778e - localDate.f19778e : i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LocalDate) && m21397a((LocalDate) obj) == null;
    }

    public final int hashCode() {
        int i = this.f19777d;
        return (((i << 11) + (this.f19779f << 6)) + this.f19778e) ^ (i & -2048);
    }

    public final String toString() {
        int i = this.f19777d;
        short s = this.f19779f;
        short s2 = this.f19778e;
        int abs = Math.abs(i);
        StringBuilder stringBuilder = new StringBuilder(10);
        if (abs >= 1000) {
            if (i > 9999) {
                stringBuilder.append('+');
            }
            stringBuilder.append(i);
        } else if (i < 0) {
            stringBuilder.append(i - 10000);
            stringBuilder.deleteCharAt(1);
        } else {
            stringBuilder.append(i + AbstractSpiCall.DEFAULT_TIMEOUT);
            stringBuilder.deleteCharAt(0);
        }
        stringBuilder.append(s < (short) 10 ? "-0" : Operation.MINUS);
        stringBuilder.append(s);
        stringBuilder.append(s2 < (short) 10 ? "-0" : Operation.MINUS);
        stringBuilder.append(s2);
        return stringBuilder.toString();
    }

    public final int m21414c() {
        return (Month.m16441a(this.f19779f).m16447b(m21425e()) + this.f19778e) - 1;
    }

    public final /* bridge */ /* synthetic */ Chronology m21428h() {
        return IsoChronology.b;
    }
}
