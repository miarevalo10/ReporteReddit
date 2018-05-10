package org.threeten.bp;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneRules;

public final class ZoneOffset extends ZoneId implements Serializable, Comparable<ZoneOffset>, TemporalAccessor, TemporalAdjuster {
    public static final TemporalQuery<ZoneOffset> f16381c = new C15721();
    public static final ZoneOffset f16382d = m16456a(0);
    public static final ZoneOffset f16383e = m16456a(-64800);
    public static final ZoneOffset f16384f = m16456a(64800);
    private static final ConcurrentMap<Integer, ZoneOffset> f16385i = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap<String, ZoneOffset> f16386j = new ConcurrentHashMap(16, 0.75f, 4);
    public final int f16387g;
    final transient String f16388h;

    static class C15721 implements TemporalQuery<ZoneOffset> {
        C15721() {
        }

        public final /* synthetic */ Object m16454a(TemporalAccessor temporalAccessor) {
            return ZoneOffset.m16459b(temporalAccessor);
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return m16460a((ZoneOffset) obj);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.threeten.bp.ZoneOffset m16458a(java.lang.String r6) {
        /*
        r0 = "offsetId";
        org.threeten.bp.jdk8.Jdk8Methods.a(r6, r0);
        r0 = f16386j;
        r0 = r0.get(r6);
        r0 = (org.threeten.bp.ZoneOffset) r0;
        if (r0 == 0) goto L_0x0010;
    L_0x000f:
        return r0;
    L_0x0010:
        r0 = r6.length();
        r1 = 3;
        r2 = 4;
        r3 = 1;
        r4 = 0;
        switch(r0) {
            case 2: goto L_0x005e;
            case 3: goto L_0x007a;
            case 4: goto L_0x001b;
            case 5: goto L_0x0054;
            case 6: goto L_0x004b;
            case 7: goto L_0x003d;
            case 8: goto L_0x001b;
            case 9: goto L_0x002f;
            default: goto L_0x001b;
        };
    L_0x001b:
        r0 = new org.threeten.bp.DateTimeException;
        r1 = new java.lang.StringBuilder;
        r2 = "Invalid ID for ZoneOffset, invalid format: ";
        r1.<init>(r2);
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x002f:
        r0 = m16455a(r6, r3, r4);
        r1 = m16455a(r6, r2, r3);
        r2 = 7;
        r2 = m16455a(r6, r2, r3);
        goto L_0x0080;
    L_0x003d:
        r0 = m16455a(r6, r3, r4);
        r1 = m16455a(r6, r1, r4);
        r2 = 5;
        r2 = m16455a(r6, r2, r4);
        goto L_0x0080;
    L_0x004b:
        r0 = m16455a(r6, r3, r4);
        r1 = m16455a(r6, r2, r3);
        goto L_0x005c;
    L_0x0054:
        r0 = m16455a(r6, r3, r4);
        r1 = m16455a(r6, r1, r4);
    L_0x005c:
        r2 = r4;
        goto L_0x0080;
    L_0x005e:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r6.charAt(r4);
        r0.append(r1);
        r1 = "0";
        r0.append(r1);
        r6 = r6.charAt(r3);
        r0.append(r6);
        r6 = r0.toString();
    L_0x007a:
        r0 = m16455a(r6, r3, r4);
        r1 = r4;
        r2 = r1;
    L_0x0080:
        r3 = r6.charAt(r4);
        r4 = 43;
        r5 = 45;
        if (r3 == r4) goto L_0x00a0;
    L_0x008a:
        if (r3 == r5) goto L_0x00a0;
    L_0x008c:
        r0 = new org.threeten.bp.DateTimeException;
        r1 = new java.lang.StringBuilder;
        r2 = "Invalid ID for ZoneOffset, plus/minus not found when expected: ";
        r1.<init>(r2);
        r1.append(r6);
        r6 = r1.toString();
        r0.<init>(r6);
        throw r0;
    L_0x00a0:
        if (r3 != r5) goto L_0x00aa;
    L_0x00a2:
        r6 = -r0;
        r0 = -r1;
        r1 = -r2;
        r6 = m16457a(r6, r0, r1);
        return r6;
    L_0x00aa:
        r6 = m16457a(r0, r1, r2);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZoneOffset.a(java.lang.String):org.threeten.bp.ZoneOffset");
    }

    private static int m16455a(CharSequence charSequence, int i, boolean z) {
        if (!z || charSequence.charAt(i - 1)) {
            z = charSequence.charAt(i);
            i = charSequence.charAt(i + 1);
            if (z >= true && z <= true && i >= 48) {
                if (i <= 57) {
                    return ((z - true) * 10) + (i - 48);
                }
            }
            z = new StringBuilder("Invalid ID for ZoneOffset, non numeric characters found: ");
            z.append(charSequence);
            throw new DateTimeException(z.toString());
        }
        z = new StringBuilder("Invalid ID for ZoneOffset, colon not found when expected: ");
        z.append(charSequence);
        throw new DateTimeException(z.toString());
    }

    public static ZoneOffset m16459b(TemporalAccessor temporalAccessor) {
        ZoneOffset zoneOffset = (ZoneOffset) temporalAccessor.a(TemporalQueries.e());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        StringBuilder stringBuilder = new StringBuilder("Unable to obtain ZoneOffset from TemporalAccessor: ");
        stringBuilder.append(temporalAccessor);
        stringBuilder.append(", type ");
        stringBuilder.append(temporalAccessor.getClass().getName());
        throw new DateTimeException(stringBuilder.toString());
    }

    public static ZoneOffset m16456a(int i) {
        if (Math.abs(i) > 64800) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        } else if (i % 900 != 0) {
            return new ZoneOffset(i);
        } else {
            Integer valueOf = Integer.valueOf(i);
            ZoneOffset zoneOffset = (ZoneOffset) f16385i.get(valueOf);
            if (zoneOffset == null) {
                f16385i.putIfAbsent(valueOf, new ZoneOffset(i));
                zoneOffset = (ZoneOffset) f16385i.get(valueOf);
                f16386j.putIfAbsent(zoneOffset.f16388h, zoneOffset);
            }
            return zoneOffset;
        }
    }

    private ZoneOffset(int i) {
        this.f16387g = i;
        if (i == 0) {
            i = "Z";
        } else {
            int abs = Math.abs(i);
            StringBuilder stringBuilder = new StringBuilder();
            int i2 = abs / 3600;
            int i3 = (abs / 60) % 60;
            stringBuilder.append(i < 0 ? Operation.MINUS : Operation.PLUS);
            stringBuilder.append(i2 < 10 ? "0" : "");
            stringBuilder.append(i2);
            stringBuilder.append(i3 < 10 ? ":0" : ":");
            stringBuilder.append(i3);
            abs %= 60;
            if (abs != 0) {
                stringBuilder.append(abs < 10 ? ":0" : ":");
                stringBuilder.append(abs);
            }
            i = stringBuilder.toString();
        }
        this.f16388h = i;
    }

    public final String mo3062b() {
        return this.f16388h;
    }

    public final ZoneRules mo3063c() {
        return ZoneRules.a(this);
    }

    public final boolean m16463a(TemporalField temporalField) {
        return temporalField instanceof ChronoField ? temporalField == ChronoField.D : (temporalField == null || temporalField.a(this) == null) ? false : true;
    }

    public final ValueRange m16465b(TemporalField temporalField) {
        if (temporalField == ChronoField.D) {
            return temporalField.a();
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.b(this);
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
        stringBuilder.append(temporalField);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public final int m16466c(TemporalField temporalField) {
        if (temporalField == ChronoField.D) {
            return this.f16387g;
        }
        if (!(temporalField instanceof ChronoField)) {
            return m16465b(temporalField).b(m16468d(temporalField), temporalField);
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
        stringBuilder.append(temporalField);
        throw new UnsupportedTemporalTypeException(stringBuilder.toString());
    }

    public final long m16468d(TemporalField temporalField) {
        if (temporalField == ChronoField.D) {
            return (long) this.f16387g;
        }
        if (!(temporalField instanceof ChronoField)) {
            return temporalField.c(this);
        }
        StringBuilder stringBuilder = new StringBuilder("Unsupported field: ");
        stringBuilder.append(temporalField);
        throw new DateTimeException(stringBuilder.toString());
    }

    public final <R> R m16461a(TemporalQuery<R> temporalQuery) {
        if (temporalQuery != TemporalQueries.e()) {
            if (temporalQuery != TemporalQueries.d()) {
                if (!(temporalQuery == TemporalQueries.f() || temporalQuery == TemporalQueries.g() || temporalQuery == TemporalQueries.c() || temporalQuery == TemporalQueries.b())) {
                    if (temporalQuery != TemporalQueries.a()) {
                        return temporalQuery.a(this);
                    }
                }
                return null;
            }
        }
        return this;
    }

    public final Temporal m16462a(Temporal temporal) {
        return temporal.a(ChronoField.D, (long) this.f16387g);
    }

    public final int m16460a(ZoneOffset zoneOffset) {
        return zoneOffset.f16387g - this.f16387g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.f16387g == ((ZoneOffset) obj).f16387g;
    }

    public final int hashCode() {
        return this.f16387g;
    }

    public final String toString() {
        return this.f16388h;
    }

    private static ZoneOffset m16457a(int i, int i2, int i3) {
        if (i >= -18) {
            if (i <= 18) {
                if (i > 0) {
                    if (i2 < 0 || i3 < 0) {
                        throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
                    }
                } else if (i < 0) {
                    if (i2 > 0 || i3 > 0) {
                        throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
                    }
                } else if ((i2 > 0 && i3 < 0) || (i2 < 0 && i3 > 0)) {
                    throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
                }
                if (Math.abs(i2) > 59) {
                    i3 = new StringBuilder("Zone offset minutes not in valid range: abs(value) ");
                    i3.append(Math.abs(i2));
                    i3.append(" is not in the range 0 to 59");
                    throw new DateTimeException(i3.toString());
                } else if (Math.abs(i3) > 59) {
                    i2 = new StringBuilder("Zone offset seconds not in valid range: abs(value) ");
                    i2.append(Math.abs(i3));
                    i2.append(" is not in the range 0 to 59");
                    throw new DateTimeException(i2.toString());
                } else if (Math.abs(i) != 18 || (Math.abs(i2) <= 0 && Math.abs(i3) <= 0)) {
                    return m16456a(((i * 3600) + (i2 * 60)) + i3);
                } else {
                    throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
                }
            }
        }
        i3 = new StringBuilder("Zone offset hours not in valid range: value ");
        i3.append(i);
        i3.append(" is not in the range -18 to 18");
        throw new DateTimeException(i3.toString());
    }
}
