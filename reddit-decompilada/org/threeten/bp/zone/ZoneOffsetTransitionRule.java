package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;

public final class ZoneOffsetTransitionRule implements Serializable {
    final Month f41111a;
    final byte f41112b;
    final DayOfWeek f41113c;
    final LocalTime f41114d;
    final boolean f41115e;
    final TimeDefinition f41116f;
    final ZoneOffset f41117g;
    final ZoneOffset f41118h;
    final ZoneOffset f41119i;

    static /* synthetic */ class C30601 {
        static final /* synthetic */ int[] f41106a = new int[TimeDefinition.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.values();
            r0 = r0.length;
            r0 = new int[r0];
            f41106a = r0;
            r0 = f41106a;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.UTC;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = f41106a;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition.STANDARD;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.zone.ZoneOffsetTransitionRule.1.<clinit>():void");
        }
    }

    public enum TimeDefinition {
        UTC,
        WALL,
        STANDARD
    }

    private ZoneOffsetTransitionRule(Month month, int i, DayOfWeek dayOfWeek, LocalTime localTime, boolean z, TimeDefinition timeDefinition, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f41111a = month;
        this.f41112b = (byte) i;
        this.f41113c = dayOfWeek;
        this.f41114d = localTime;
        this.f41115e = z;
        this.f41116f = timeDefinition;
        this.f41117g = zoneOffset;
        this.f41118h = zoneOffset2;
        this.f41119i = zoneOffset3;
    }

    final void m43225a(DataOutput dataOutput) throws IOException {
        int i;
        int a = this.f41115e ? 86400 : this.f41114d.a();
        int i2 = this.f41117g.g;
        int i3 = this.f41118h.g - i2;
        int i4 = this.f41119i.g - i2;
        int i5 = a % 3600 == 0 ? this.f41115e ? 24 : this.f41114d.f : 31;
        int i6 = i2 % 900 == 0 ? (i2 / 900) + 128 : 255;
        if (!(i3 == 0 || i3 == 1800)) {
            if (i3 != 3600) {
                i3 = 3;
                if (!(i4 == 0 || i4 == 1800)) {
                    if (i4 == 3600) {
                        i4 = 3;
                        if (this.f41113c != null) {
                            i = 0;
                        } else {
                            i = this.f41113c.ordinal() + 1;
                        }
                        dataOutput.writeInt(((((((((this.f41111a.ordinal() + 1) << 28) + ((this.f41112b + 32) << 22)) + (i << 19)) + (i5 << 14)) + (this.f41116f.ordinal() << 12)) + (i6 << 4)) + (i3 << 2)) + i4);
                        if (i5 == 31) {
                            dataOutput.writeInt(a);
                        }
                        if (i6 == 255) {
                            dataOutput.writeInt(i2);
                        }
                        if (i3 == 3) {
                            dataOutput.writeInt(this.f41118h.g);
                        }
                        if (i4 != 3) {
                            dataOutput.writeInt(this.f41119i.g);
                        }
                    }
                }
                i4 /= 1800;
                if (this.f41113c != null) {
                    i = this.f41113c.ordinal() + 1;
                } else {
                    i = 0;
                }
                dataOutput.writeInt(((((((((this.f41111a.ordinal() + 1) << 28) + ((this.f41112b + 32) << 22)) + (i << 19)) + (i5 << 14)) + (this.f41116f.ordinal() << 12)) + (i6 << 4)) + (i3 << 2)) + i4);
                if (i5 == 31) {
                    dataOutput.writeInt(a);
                }
                if (i6 == 255) {
                    dataOutput.writeInt(i2);
                }
                if (i3 == 3) {
                    dataOutput.writeInt(this.f41118h.g);
                }
                if (i4 != 3) {
                    dataOutput.writeInt(this.f41119i.g);
                }
            }
        }
        i3 /= 1800;
        if (i4 == 3600) {
            i4 = 3;
            if (this.f41113c != null) {
                i = 0;
            } else {
                i = this.f41113c.ordinal() + 1;
            }
            dataOutput.writeInt(((((((((this.f41111a.ordinal() + 1) << 28) + ((this.f41112b + 32) << 22)) + (i << 19)) + (i5 << 14)) + (this.f41116f.ordinal() << 12)) + (i6 << 4)) + (i3 << 2)) + i4);
            if (i5 == 31) {
                dataOutput.writeInt(a);
            }
            if (i6 == 255) {
                dataOutput.writeInt(i2);
            }
            if (i3 == 3) {
                dataOutput.writeInt(this.f41118h.g);
            }
            if (i4 != 3) {
                dataOutput.writeInt(this.f41119i.g);
            }
        }
        i4 /= 1800;
        if (this.f41113c != null) {
            i = this.f41113c.ordinal() + 1;
        } else {
            i = 0;
        }
        dataOutput.writeInt(((((((((this.f41111a.ordinal() + 1) << 28) + ((this.f41112b + 32) << 22)) + (i << 19)) + (i5 << 14)) + (this.f41116f.ordinal() << 12)) + (i6 << 4)) + (i3 << 2)) + i4);
        if (i5 == 31) {
            dataOutput.writeInt(a);
        }
        if (i6 == 255) {
            dataOutput.writeInt(i2);
        }
        if (i3 == 3) {
            dataOutput.writeInt(this.f41118h.g);
        }
        if (i4 != 3) {
            dataOutput.writeInt(this.f41119i.g);
        }
    }

    static ZoneOffsetTransitionRule m43224a(DataInput dataInput) throws IOException {
        DayOfWeek dayOfWeek;
        int readInt = dataInput.readInt();
        Object a = Month.a(readInt >>> 28);
        int i = ((264241152 & readInt) >>> 22) - 32;
        int i2 = (3670016 & readInt) >>> 19;
        if (i2 == 0) {
            dayOfWeek = null;
        } else {
            dayOfWeek = DayOfWeek.a(i2);
        }
        DayOfWeek dayOfWeek2 = dayOfWeek;
        i2 = (507904 & readInt) >>> 14;
        Object obj = TimeDefinition.values()[(readInt & 12288) >>> 12];
        int i3 = (readInt & 4080) >>> 4;
        int i4 = (readInt & 12) >>> 2;
        readInt &= 3;
        LocalTime a2 = i2 == 31 ? LocalTime.a((long) dataInput.readInt()) : LocalTime.a(i2 % 24);
        ZoneOffset a3 = ZoneOffset.a(i3 == 255 ? dataInput.readInt() : (i3 - 128) * 900);
        if (i4 == 3) {
            i3 = dataInput.readInt();
        } else {
            i3 = a3.g + (i4 * 1800);
        }
        ZoneOffset a4 = ZoneOffset.a(i3);
        if (readInt == 3) {
            dataInput = dataInput.readInt();
        } else {
            dataInput = a3.g + (readInt * 1800);
        }
        ZoneOffset a5 = ZoneOffset.a(dataInput);
        boolean z = i2 == 24;
        Jdk8Methods.m43168a(a, "month");
        Jdk8Methods.m43168a((Object) a2, "time");
        Jdk8Methods.m43168a(obj, "timeDefnition");
        Jdk8Methods.m43168a((Object) a3, "standardOffset");
        Jdk8Methods.m43168a((Object) a4, "offsetBefore");
        Jdk8Methods.m43168a((Object) a5, "offsetAfter");
        if (i >= -28 && i <= 31) {
            if (i != 0) {
                if (!z || a2.equals(LocalTime.c)) {
                    return new ZoneOffsetTransitionRule(a, i, dayOfWeek2, a2, z, obj, a3, a4, a5);
                }
                throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
            }
        }
        throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransitionRule)) {
            return false;
        }
        ZoneOffsetTransitionRule zoneOffsetTransitionRule = (ZoneOffsetTransitionRule) obj;
        return this.f41111a == zoneOffsetTransitionRule.f41111a && this.f41112b == zoneOffsetTransitionRule.f41112b && this.f41113c == zoneOffsetTransitionRule.f41113c && this.f41116f == zoneOffsetTransitionRule.f41116f && this.f41114d.equals(zoneOffsetTransitionRule.f41114d) && this.f41115e == zoneOffsetTransitionRule.f41115e && this.f41117g.equals(zoneOffsetTransitionRule.f41117g) && this.f41118h.equals(zoneOffsetTransitionRule.f41118h) && this.f41119i.equals(zoneOffsetTransitionRule.f41119i) != null;
    }

    public final int hashCode() {
        return ((((((((this.f41114d.a() + this.f41115e) << 15) + (this.f41111a.ordinal() << 11)) + ((this.f41112b + 32) << 5)) + ((this.f41113c == null ? 7 : this.f41113c.ordinal()) << 2)) + this.f41116f.ordinal()) ^ this.f41117g.hashCode()) ^ this.f41118h.hashCode()) ^ this.f41119i.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TransitionRule[");
        stringBuilder.append(this.f41118h.a(this.f41119i) > 0 ? "Gap " : "Overlap ");
        stringBuilder.append(this.f41118h);
        stringBuilder.append(" to ");
        stringBuilder.append(this.f41119i);
        stringBuilder.append(", ");
        if (this.f41113c == null) {
            stringBuilder.append(this.f41111a.name());
            stringBuilder.append(' ');
            stringBuilder.append(this.f41112b);
        } else if (this.f41112b == (byte) -1) {
            stringBuilder.append(this.f41113c.name());
            stringBuilder.append(" on or before last day of ");
            stringBuilder.append(this.f41111a.name());
        } else if (this.f41112b < (byte) 0) {
            stringBuilder.append(this.f41113c.name());
            stringBuilder.append(" on or before last day minus ");
            stringBuilder.append((-this.f41112b) - 1);
            stringBuilder.append(" of ");
            stringBuilder.append(this.f41111a.name());
        } else {
            stringBuilder.append(this.f41113c.name());
            stringBuilder.append(" on or after ");
            stringBuilder.append(this.f41111a.name());
            stringBuilder.append(' ');
            stringBuilder.append(this.f41112b);
        }
        stringBuilder.append(" at ");
        stringBuilder.append(this.f41115e ? "24:00" : this.f41114d.toString());
        stringBuilder.append(" ");
        stringBuilder.append(this.f41116f);
        stringBuilder.append(", standard offset ");
        stringBuilder.append(this.f41117g);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
