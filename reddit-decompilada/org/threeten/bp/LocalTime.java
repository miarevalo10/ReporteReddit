package org.threeten.bp;

import java.io.Serializable;
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

public final class LocalTime extends DefaultInterfaceTemporalAccessor implements Serializable, Comparable<LocalTime>, Temporal, TemporalAdjuster {
    public static final LocalTime f18820a = f18825i[0];
    public static final LocalTime f18821b = new LocalTime(23, 59, 59, 999999999);
    public static final LocalTime f18822c = f18825i[0];
    public static final LocalTime f18823d = f18825i[12];
    public static final TemporalQuery<LocalTime> f18824e = new C15681();
    private static final LocalTime[] f18825i = new LocalTime[24];
    public final byte f18826f;
    public final byte f18827g;
    public final int f18828h;
    private final byte f18829j;

    static /* synthetic */ class C09662 {
        static final /* synthetic */ int[] f10938a = new int[ChronoField.values().length];
        static final /* synthetic */ int[] f10939b = new int[ChronoUnit.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = org.threeten.bp.temporal.ChronoUnit.values();
            r0 = r0.length;
            r0 = new int[r0];
            f10939b = r0;
            r0 = 1;
            r1 = f10939b;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = org.threeten.bp.temporal.ChronoUnit.a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = r2.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1[r2] = r0;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r1 = 2;
            r2 = f10939b;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = org.threeten.bp.temporal.ChronoUnit.b;	 Catch:{ NoSuchFieldError -> 0x001f }
            r3 = r3.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2[r3] = r1;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r2 = 3;
            r3 = f10939b;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = org.threeten.bp.temporal.ChronoUnit.c;	 Catch:{ NoSuchFieldError -> 0x002a }
            r4 = r4.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r3[r4] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r3 = 4;
            r4 = f10939b;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r5 = org.threeten.bp.temporal.ChronoUnit.d;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r5 = r5.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r4[r5] = r3;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            r4 = 5;
            r5 = f10939b;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r6 = org.threeten.bp.temporal.ChronoUnit.e;	 Catch:{ NoSuchFieldError -> 0x0040 }
            r6 = r6.ordinal();	 Catch:{ NoSuchFieldError -> 0x0040 }
            r5[r6] = r4;	 Catch:{ NoSuchFieldError -> 0x0040 }
        L_0x0040:
            r5 = 6;
            r6 = f10939b;	 Catch:{ NoSuchFieldError -> 0x004b }
            r7 = org.threeten.bp.temporal.ChronoUnit.f;	 Catch:{ NoSuchFieldError -> 0x004b }
            r7 = r7.ordinal();	 Catch:{ NoSuchFieldError -> 0x004b }
            r6[r7] = r5;	 Catch:{ NoSuchFieldError -> 0x004b }
        L_0x004b:
            r6 = 7;
            r7 = f10939b;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r8 = org.threeten.bp.temporal.ChronoUnit.g;	 Catch:{ NoSuchFieldError -> 0x0056 }
            r8 = r8.ordinal();	 Catch:{ NoSuchFieldError -> 0x0056 }
            r7[r8] = r6;	 Catch:{ NoSuchFieldError -> 0x0056 }
        L_0x0056:
            r7 = org.threeten.bp.temporal.ChronoField.values();
            r7 = r7.length;
            r7 = new int[r7];
            f10938a = r7;
            r7 = f10938a;	 Catch:{ NoSuchFieldError -> 0x0069 }
            r8 = org.threeten.bp.temporal.ChronoField.a;	 Catch:{ NoSuchFieldError -> 0x0069 }
            r8 = r8.ordinal();	 Catch:{ NoSuchFieldError -> 0x0069 }
            r7[r8] = r0;	 Catch:{ NoSuchFieldError -> 0x0069 }
        L_0x0069:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x0073 }
            r7 = org.threeten.bp.temporal.ChronoField.b;	 Catch:{ NoSuchFieldError -> 0x0073 }
            r7 = r7.ordinal();	 Catch:{ NoSuchFieldError -> 0x0073 }
            r0[r7] = r1;	 Catch:{ NoSuchFieldError -> 0x0073 }
        L_0x0073:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x007d }
            r1 = org.threeten.bp.temporal.ChronoField.c;	 Catch:{ NoSuchFieldError -> 0x007d }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x007d }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x007d }
        L_0x007d:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x0087 }
            r1 = org.threeten.bp.temporal.ChronoField.d;	 Catch:{ NoSuchFieldError -> 0x0087 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0087 }
            r0[r1] = r3;	 Catch:{ NoSuchFieldError -> 0x0087 }
        L_0x0087:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x0091 }
            r1 = org.threeten.bp.temporal.ChronoField.e;	 Catch:{ NoSuchFieldError -> 0x0091 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0091 }
            r0[r1] = r4;	 Catch:{ NoSuchFieldError -> 0x0091 }
        L_0x0091:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x009b }
            r1 = org.threeten.bp.temporal.ChronoField.f;	 Catch:{ NoSuchFieldError -> 0x009b }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x009b }
            r0[r1] = r5;	 Catch:{ NoSuchFieldError -> 0x009b }
        L_0x009b:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x00a5 }
            r1 = org.threeten.bp.temporal.ChronoField.g;	 Catch:{ NoSuchFieldError -> 0x00a5 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00a5 }
            r0[r1] = r6;	 Catch:{ NoSuchFieldError -> 0x00a5 }
        L_0x00a5:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x00b1 }
            r1 = org.threeten.bp.temporal.ChronoField.h;	 Catch:{ NoSuchFieldError -> 0x00b1 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00b1 }
            r2 = 8;	 Catch:{ NoSuchFieldError -> 0x00b1 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00b1 }
        L_0x00b1:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x00bd }
            r1 = org.threeten.bp.temporal.ChronoField.i;	 Catch:{ NoSuchFieldError -> 0x00bd }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00bd }
            r2 = 9;	 Catch:{ NoSuchFieldError -> 0x00bd }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00bd }
        L_0x00bd:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x00c9 }
            r1 = org.threeten.bp.temporal.ChronoField.j;	 Catch:{ NoSuchFieldError -> 0x00c9 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00c9 }
            r2 = 10;	 Catch:{ NoSuchFieldError -> 0x00c9 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00c9 }
        L_0x00c9:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x00d5 }
            r1 = org.threeten.bp.temporal.ChronoField.k;	 Catch:{ NoSuchFieldError -> 0x00d5 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00d5 }
            r2 = 11;	 Catch:{ NoSuchFieldError -> 0x00d5 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00d5 }
        L_0x00d5:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x00e1 }
            r1 = org.threeten.bp.temporal.ChronoField.l;	 Catch:{ NoSuchFieldError -> 0x00e1 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00e1 }
            r2 = 12;	 Catch:{ NoSuchFieldError -> 0x00e1 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00e1 }
        L_0x00e1:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x00ed }
            r1 = org.threeten.bp.temporal.ChronoField.m;	 Catch:{ NoSuchFieldError -> 0x00ed }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00ed }
            r2 = 13;	 Catch:{ NoSuchFieldError -> 0x00ed }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00ed }
        L_0x00ed:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x00f9 }
            r1 = org.threeten.bp.temporal.ChronoField.n;	 Catch:{ NoSuchFieldError -> 0x00f9 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x00f9 }
            r2 = 14;	 Catch:{ NoSuchFieldError -> 0x00f9 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x00f9 }
        L_0x00f9:
            r0 = f10938a;	 Catch:{ NoSuchFieldError -> 0x0105 }
            r1 = org.threeten.bp.temporal.ChronoField.o;	 Catch:{ NoSuchFieldError -> 0x0105 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0105 }
            r2 = 15;	 Catch:{ NoSuchFieldError -> 0x0105 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0105 }
        L_0x0105:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.LocalTime.2.<clinit>():void");
        }
    }

    static class C15681 implements TemporalQuery<LocalTime> {
        C15681() {
        }

        public final /* bridge */ /* synthetic */ Object m16439a(TemporalAccessor temporalAccessor) {
            return LocalTime.m19834a(temporalAccessor);
        }
    }

    public final /* synthetic */ Temporal m19850a(TemporalField temporalField, long j) {
        return m19853b(temporalField, j);
    }

    public final /* synthetic */ Temporal m19854b(long j, TemporalUnit temporalUnit) {
        return m19839c(j, temporalUnit);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return m19845a((LocalTime) obj);
    }

    static {
        for (int i = 0; i < f18825i.length; i++) {
            f18825i[i] = new LocalTime(i, 0, 0, 0);
        }
    }

    public static LocalTime m19830a(int i) {
        ChronoField.m.a((long) i);
        return f18825i[i];
    }

    public static LocalTime m19832a(long j) {
        ChronoField.h.a(j);
        int i = (int) (j / 3600);
        j -= (long) (i * 3600);
        int i2 = (int) (j / 60);
        return m19831a(i, i2, (int) (j - ((long) (i2 * 60))), 0);
    }

    static LocalTime m19833a(long j, int i) {
        ChronoField.h.a(j);
        ChronoField.a.a((long) i);
        int i2 = (int) (j / 3600);
        j -= (long) (i2 * 3600);
        int i3 = (int) (j / 60);
        return m19831a(i2, i3, (int) (j - ((long) (i3 * 60))), i);
    }

    public static LocalTime m19836b(long j) {
        ChronoField.b.a(j);
        int i = (int) (j / 3600000000000L);
        j -= ((long) i) * 3600000000000L;
        int i2 = (int) (j / 60000000000L);
        j -= ((long) i2) * 60000000000L;
        int i3 = (int) (j / 1000000000);
        return m19831a(i, i2, i3, (int) (j - (((long) i3) * 1000000000)));
    }

    public static LocalTime m19834a(TemporalAccessor temporalAccessor) {
        LocalTime localTime = (LocalTime) temporalAccessor.a(TemporalQueries.g());
        if (localTime != null) {
            return localTime;
        }
        StringBuilder stringBuilder = new StringBuilder("Unable to obtain LocalTime from TemporalAccessor: ");
        stringBuilder.append(temporalAccessor);
        stringBuilder.append(", type ");
        stringBuilder.append(temporalAccessor.getClass().getName());
        throw new DateTimeException(stringBuilder.toString());
    }

    private static LocalTime m19831a(int i, int i2, int i3, int i4) {
        if (((i2 | i3) | i4) == 0) {
            return f18825i[i];
        }
        return new LocalTime(i, i2, i3, i4);
    }

    private LocalTime(int i, int i2, int i3, int i4) {
        this.f18826f = (byte) i;
        this.f18829j = (byte) i2;
        this.f18827g = (byte) i3;
        this.f18828h = i4;
    }

    public final boolean m19851a(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return temporalField.c();
        }
        return (temporalField == null || temporalField.a(this) == null) ? null : true;
    }

    public final ValueRange m19855b(TemporalField temporalField) {
        return super.b(temporalField);
    }

    public final int m19856c(TemporalField temporalField) {
        if (temporalField instanceof ChronoField) {
            return m19841e(temporalField);
        }
        return super.c(temporalField);
    }

    public final long m19857d(TemporalField temporalField) {
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        if (temporalField == ChronoField.b) {
            return m19852b();
        }
        if (temporalField == ChronoField.d) {
            return m19852b() / 1000;
        }
        return (long) m19841e(temporalField);
    }

    private int m19841e(TemporalField temporalField) {
        StringBuilder stringBuilder;
        switch (C09662.f10938a[((ChronoField) temporalField).ordinal()]) {
            case 1:
                return this.f18828h;
            case 2:
                stringBuilder = new StringBuilder("Field too large for an int: ");
                stringBuilder.append(temporalField);
                throw new DateTimeException(stringBuilder.toString());
            case 3:
                return this.f18828h / 1000;
            case 4:
                stringBuilder = new StringBuilder("Field too large for an int: ");
                stringBuilder.append(temporalField);
                throw new DateTimeException(stringBuilder.toString());
            case 5:
                return this.f18828h / 1000000;
            case 6:
                return (int) (m19852b() / 1000000);
            case 7:
                return this.f18827g;
            case 8:
                return m19844a();
            case 9:
                return this.f18829j;
            case 10:
                return (this.f18826f * 60) + this.f18829j;
            case 11:
                return this.f18826f % 12;
            case 12:
                temporalField = this.f18826f % 12;
                if (temporalField % 12 == 0) {
                    return 12;
                }
                return temporalField;
            case 13:
                return this.f18826f;
            case 14:
                return this.f18826f == null ? 24 : this.f18826f;
            case 15:
                return this.f18826f / 12;
            default:
                stringBuilder = new StringBuilder("Unsupported field: ");
                stringBuilder.append(temporalField);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    public final LocalTime m19853b(TemporalField temporalField, long j) {
        if (!(temporalField instanceof ChronoField)) {
            return (LocalTime) temporalField.a(this, j);
        }
        ChronoField chronoField = (ChronoField) temporalField;
        chronoField.a(j);
        switch (C09662.f10938a[chronoField.ordinal()]) {
            case 1:
                return m19837c((int) j);
            case 2:
                return m19836b(j);
            case 3:
                return m19837c(((int) j) * 1000);
            case 4:
                return m19836b(j * 1000);
            case 5:
                return m19837c(((int) j) * 1000000);
            case 6:
                return m19836b(j * 1000000);
            case 7:
                temporalField = (int) j;
                if (this.f18827g == temporalField) {
                    return this;
                }
                ChronoField.g.a((long) temporalField);
                return m19831a(this.f18826f, this.f18829j, temporalField, this.f18828h);
            case 8:
                return m19842e(j - ((long) m19844a()));
            case 9:
                temporalField = (int) j;
                if (this.f18829j == temporalField) {
                    return this;
                }
                ChronoField.i.a((long) temporalField);
                return m19831a(this.f18826f, temporalField, this.f18827g, this.f18828h);
            case 10:
                return m19840d(j - ((long) ((this.f18826f * 60) + this.f18829j)));
            case 11:
                return m19838c(j - ((long) (this.f18826f % 12)));
            case 12:
                if (j == 12) {
                    j = 0;
                }
                return m19838c(j - ((long) (this.f18826f % 12)));
            case 13:
                return m19835b((int) j);
            case 14:
                if (j == 24) {
                    j = 0;
                }
                return m19835b((int) j);
            case 15:
                return m19838c((j - ((long) (this.f18826f / 12))) * 12);
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
                stringBuilder.append(temporalField);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private LocalTime m19835b(int i) {
        if (this.f18826f == i) {
            return this;
        }
        ChronoField.m.a((long) i);
        return m19831a(i, this.f18829j, this.f18827g, this.f18828h);
    }

    private LocalTime m19837c(int i) {
        if (this.f18828h == i) {
            return this;
        }
        ChronoField.a.a((long) i);
        return m19831a(this.f18826f, this.f18829j, this.f18827g, i);
    }

    private LocalTime m19839c(long j, TemporalUnit temporalUnit) {
        if (!(temporalUnit instanceof ChronoUnit)) {
            return (LocalTime) temporalUnit.a(this, j);
        }
        switch (C09662.f10939b[((ChronoUnit) temporalUnit).ordinal()]) {
            case 1:
                return m19843f(j);
            case 2:
                return m19843f((j % 86400000000L) * 1000);
            case 3:
                return m19843f((j % 86400000) * 1000000);
            case 4:
                return m19842e(j);
            case 5:
                return m19840d(j);
            case 6:
                return m19838c(j);
            case 7:
                return m19838c((j % 2) * 12);
            default:
                StringBuilder stringBuilder = new StringBuilder("Unsupported unit: ");
                stringBuilder.append(temporalUnit);
                throw new UnsupportedTemporalTypeException(stringBuilder.toString());
        }
    }

    private LocalTime m19838c(long j) {
        if (j == 0) {
            return this;
        }
        return m19831a(((((int) (j % 24)) + this.f18826f) + 24) % 24, this.f18829j, this.f18827g, this.f18828h);
    }

    private LocalTime m19840d(long j) {
        if (j == 0) {
            return this;
        }
        int i = (this.f18826f * 60) + this.f18829j;
        j = ((((int) (j % 1440)) + i) + 1440) % 1440;
        if (i == j) {
            return this;
        }
        return m19831a(j / 60, j % 60, this.f18827g, this.f18828h);
    }

    private LocalTime m19842e(long j) {
        if (j == 0) {
            return this;
        }
        int i = ((this.f18826f * 3600) + (this.f18829j * 60)) + this.f18827g;
        j = ((((int) (j % 86400)) + i) + 86400) % 86400;
        if (i == j) {
            return this;
        }
        return m19831a(j / 3600, (j / 60) % 60, j % 60, this.f18828h);
    }

    private LocalTime m19843f(long j) {
        if (j == 0) {
            return this;
        }
        long b = m19852b();
        j = (((j % 86400000000000L) + b) + 86400000000000L) % 86400000000000L;
        if (b == j) {
            return this;
        }
        return m19831a((int) (j / 3600000000000L), (int) ((j / 60000000000L) % 60), (int) ((j / 1000000000) % 60), (int) (j % 1000000000));
    }

    public final <R> R m19846a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery == TemporalQueries.c()) {
            return ChronoUnit.a;
        }
        if (temporalQuery == TemporalQueries.g()) {
            return this;
        }
        if (!(temporalQuery == TemporalQueries.b() || temporalQuery == TemporalQueries.a() || temporalQuery == TemporalQueries.d() || temporalQuery == TemporalQueries.e())) {
            if (temporalQuery != TemporalQueries.f()) {
                return temporalQuery.a(this);
            }
        }
        return null;
    }

    public final Temporal m19848a(Temporal temporal) {
        return temporal.a(ChronoField.b, m19852b());
    }

    public final int m19844a() {
        return ((this.f18826f * 3600) + (this.f18829j * 60)) + this.f18827g;
    }

    public final long m19852b() {
        return (((((long) this.f18826f) * 3600000000000L) + (((long) this.f18829j) * 60000000000L)) + (((long) this.f18827g) * 1000000000)) + ((long) this.f18828h);
    }

    public final int m19845a(LocalTime localTime) {
        int a = Jdk8Methods.a(this.f18826f, localTime.f18826f);
        if (a != 0) {
            return a;
        }
        a = Jdk8Methods.a(this.f18829j, localTime.f18829j);
        if (a != 0) {
            return a;
        }
        a = Jdk8Methods.a(this.f18827g, localTime.f18827g);
        return a == 0 ? Jdk8Methods.a(this.f18828h, localTime.f18828h) : a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalTime)) {
            return false;
        }
        LocalTime localTime = (LocalTime) obj;
        return this.f18826f == localTime.f18826f && this.f18829j == localTime.f18829j && this.f18827g == localTime.f18827g && this.f18828h == localTime.f18828h;
    }

    public final int hashCode() {
        long b = m19852b();
        return (int) (b ^ (b >>> 32));
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(18);
        byte b = this.f18826f;
        byte b2 = this.f18829j;
        byte b3 = this.f18827g;
        int i = this.f18828h;
        stringBuilder.append(b < (byte) 10 ? "0" : "");
        stringBuilder.append(b);
        stringBuilder.append(b2 < (byte) 10 ? ":0" : ":");
        stringBuilder.append(b2);
        if (b3 > (byte) 0 || i > 0) {
            stringBuilder.append(b3 < (byte) 10 ? ":0" : ":");
            stringBuilder.append(b3);
            if (i > 0) {
                stringBuilder.append('.');
                if (i % 1000000 == 0) {
                    stringBuilder.append(Integer.toString((i / 1000000) + 1000).substring(1));
                } else if (i % 1000 == 0) {
                    stringBuilder.append(Integer.toString((i / 1000) + 1000000).substring(1));
                } else {
                    stringBuilder.append(Integer.toString(i + 1000000000).substring(1));
                }
            }
        }
        return stringBuilder.toString();
    }

    public final /* synthetic */ Temporal m19847a(long j, TemporalUnit temporalUnit) {
        return j == Long.MIN_VALUE ? m19839c(Long.MAX_VALUE, temporalUnit).m19839c(1, temporalUnit) : m19839c(-j, temporalUnit);
    }
}
