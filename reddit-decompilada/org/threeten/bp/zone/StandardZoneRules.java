package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDateTime;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.zone.ZoneOffsetTransitionRule.C30601;
import org.threeten.bp.zone.ZoneOffsetTransitionRule.TimeDefinition;

final class StandardZoneRules extends ZoneRules implements Serializable {
    final long[] f41546a;
    final ZoneOffset[] f41547b;
    final long[] f41548c;
    final ZoneOffset[] f41549d;
    final ZoneOffsetTransitionRule[] f41550e;
    private final LocalDateTime[] f41551f;
    private final ConcurrentMap<Integer, ZoneOffsetTransition[]> f41552g = new ConcurrentHashMap();

    private StandardZoneRules(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr) {
        this.f41546a = jArr;
        this.f41547b = zoneOffsetArr;
        this.f41548c = jArr2;
        this.f41549d = zoneOffsetArr2;
        this.f41550e = zoneOffsetTransitionRuleArr;
        jArr = new ArrayList();
        zoneOffsetArr = null;
        while (zoneOffsetArr < jArr2.length) {
            int i = zoneOffsetArr + 1;
            ZoneOffsetTransition zoneOffsetTransition = new ZoneOffsetTransition(jArr2[zoneOffsetArr], zoneOffsetArr2[zoneOffsetArr], zoneOffsetArr2[i]);
            if (zoneOffsetTransition.m43223d() != null) {
                jArr.add(zoneOffsetTransition.f41103a);
                jArr.add(zoneOffsetTransition.m43221b());
            } else {
                jArr.add(zoneOffsetTransition.m43221b());
                jArr.add(zoneOffsetTransition.f41103a);
            }
            zoneOffsetArr = i;
        }
        this.f41551f = (LocalDateTime[]) jArr.toArray(new LocalDateTime[jArr.size()]);
    }

    static StandardZoneRules m43644a(DataInput dataInput) throws IOException, ClassNotFoundException {
        int readInt = dataInput.readInt();
        long[] jArr = new long[readInt];
        byte b = (byte) 0;
        for (int i = 0; i < readInt; i++) {
            jArr[i] = Ser.m43214c(dataInput);
        }
        ZoneOffset[] zoneOffsetArr = new ZoneOffset[(readInt + 1)];
        for (readInt = 0; readInt < zoneOffsetArr.length; readInt++) {
            zoneOffsetArr[readInt] = Ser.m43213b(dataInput);
        }
        readInt = dataInput.readInt();
        long[] jArr2 = new long[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            jArr2[i2] = Ser.m43214c(dataInput);
        }
        ZoneOffset[] zoneOffsetArr2 = new ZoneOffset[(readInt + 1)];
        for (readInt = 0; readInt < zoneOffsetArr2.length; readInt++) {
            zoneOffsetArr2[readInt] = Ser.m43213b(dataInput);
        }
        byte readByte = dataInput.readByte();
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = new ZoneOffsetTransitionRule[readByte];
        while (b < readByte) {
            zoneOffsetTransitionRuleArr[b] = ZoneOffsetTransitionRule.m43224a(dataInput);
            b++;
        }
        return new StandardZoneRules(jArr, zoneOffsetArr, jArr2, zoneOffsetArr2, zoneOffsetTransitionRuleArr);
    }

    public final boolean mo7866a() {
        return this.f41548c.length == 0;
    }

    public final List<ZoneOffset> mo7864a(LocalDateTime localDateTime) {
        localDateTime = m43646c(localDateTime);
        if (!(localDateTime instanceof ZoneOffsetTransition)) {
            return Collections.singletonList((ZoneOffset) localDateTime);
        }
        if (((ZoneOffsetTransition) localDateTime).m43223d()) {
            return Collections.emptyList();
        }
        return Arrays.asList(new ZoneOffset[]{((ZoneOffsetTransition) localDateTime).f41104b, ((ZoneOffsetTransition) localDateTime).f41105c});
    }

    public final ZoneOffsetTransition mo7868b(LocalDateTime localDateTime) {
        localDateTime = m43646c(localDateTime);
        return localDateTime instanceof ZoneOffsetTransition ? (ZoneOffsetTransition) localDateTime : null;
    }

    private Object m43646c(LocalDateTime localDateTime) {
        int i = 0;
        if (this.f41550e.length <= 0 || !localDateTime.b(this.f41551f[this.f41551f.length - 1])) {
            localDateTime = Arrays.binarySearch(this.f41551f, localDateTime);
            if (localDateTime == -1) {
                return this.f41549d[0];
            }
            if (localDateTime < null) {
                localDateTime = (-localDateTime) - 2;
            } else if (localDateTime < this.f41551f.length - 1) {
                int i2 = localDateTime + 1;
                if (this.f41551f[localDateTime].equals(this.f41551f[i2])) {
                    localDateTime = i2;
                }
            }
            if ((localDateTime & 1) != 0) {
                return this.f41549d[(localDateTime / 2) + 1];
            }
            LocalDateTime localDateTime2 = this.f41551f[localDateTime];
            LocalDateTime localDateTime3 = this.f41551f[localDateTime + 1];
            localDateTime /= 2;
            ZoneOffset zoneOffset = this.f41549d[localDateTime];
            ZoneOffset zoneOffset2 = this.f41549d[localDateTime + 1];
            if (zoneOffset2.g > zoneOffset.g) {
                return new ZoneOffsetTransition(localDateTime2, zoneOffset, zoneOffset2);
            }
            return new ZoneOffsetTransition(localDateTime3, zoneOffset, zoneOffset2);
        }
        ZoneOffsetTransition[] a = m43645a(localDateTime.d.d);
        Object obj = null;
        int length = a.length;
        while (i < length) {
            Object obj2;
            ZoneOffsetTransition zoneOffsetTransition = a[i];
            ChronoLocalDateTime chronoLocalDateTime = zoneOffsetTransition.f41103a;
            if (zoneOffsetTransition.m43223d()) {
                if (localDateTime.c(chronoLocalDateTime)) {
                    obj2 = zoneOffsetTransition.f41104b;
                } else if (!localDateTime.c(zoneOffsetTransition.m43221b())) {
                    obj2 = zoneOffsetTransition.f41105c;
                }
                if (!(obj2 instanceof ZoneOffsetTransition)) {
                    if (obj2.equals(zoneOffsetTransition.f41104b)) {
                        i++;
                        obj = obj2;
                    }
                }
                return obj2;
            }
            if (!localDateTime.c(chronoLocalDateTime)) {
                obj2 = zoneOffsetTransition.f41105c;
            } else if (localDateTime.c(zoneOffsetTransition.m43221b())) {
                obj2 = zoneOffsetTransition.f41104b;
            }
            if (!(obj2 instanceof ZoneOffsetTransition)) {
                if (obj2.equals(zoneOffsetTransition.f41104b)) {
                    i++;
                    obj = obj2;
                }
            }
            return obj2;
            obj2 = zoneOffsetTransition;
            if (!(obj2 instanceof ZoneOffsetTransition)) {
                if (obj2.equals(zoneOffsetTransition.f41104b)) {
                    i++;
                    obj = obj2;
                }
            }
            return obj2;
        }
        return obj;
    }

    public final boolean mo7867a(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return mo7864a(localDateTime).contains(zoneOffset);
    }

    private ZoneOffsetTransition[] m43645a(int i) {
        Integer valueOf = Integer.valueOf(i);
        ZoneOffsetTransition[] zoneOffsetTransitionArr = (ZoneOffsetTransition[]) this.f41552g.get(valueOf);
        if (zoneOffsetTransitionArr != null) {
            return zoneOffsetTransitionArr;
        }
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr = this.f41550e;
        Object obj = new ZoneOffsetTransition[zoneOffsetTransitionRuleArr.length];
        for (int i2 = 0; i2 < zoneOffsetTransitionRuleArr.length; i2++) {
            LocalDate a;
            ZoneOffsetTransitionRule zoneOffsetTransitionRule = zoneOffsetTransitionRuleArr[i2];
            if (zoneOffsetTransitionRule.f41112b < (byte) 0) {
                a = LocalDate.a(i, zoneOffsetTransitionRule.f41111a, (zoneOffsetTransitionRule.f41111a.a(IsoChronology.f41426b.mo7846a((long) i)) + 1) + zoneOffsetTransitionRule.f41112b);
                if (zoneOffsetTransitionRule.f41113c != null) {
                    a = a.b(TemporalAdjusters.m43182b(zoneOffsetTransitionRule.f41113c));
                }
            } else {
                a = LocalDate.a(i, zoneOffsetTransitionRule.f41111a, zoneOffsetTransitionRule.f41112b);
                if (zoneOffsetTransitionRule.f41113c != null) {
                    a = a.b(TemporalAdjusters.m43181a(zoneOffsetTransitionRule.f41113c));
                }
            }
            if (zoneOffsetTransitionRule.f41115e) {
                a = a.d(1);
            }
            LocalDateTime a2 = LocalDateTime.a(a, zoneOffsetTransitionRule.f41114d);
            TimeDefinition timeDefinition = zoneOffsetTransitionRule.f41116f;
            ZoneOffset zoneOffset = zoneOffsetTransitionRule.f41117g;
            ZoneOffset zoneOffset2 = zoneOffsetTransitionRule.f41118h;
            switch (C30601.f41106a[timeDefinition.ordinal()]) {
                case 1:
                    a2 = a2.a((long) (zoneOffset2.g - ZoneOffset.d.g));
                    break;
                case 2:
                    a2 = a2.a((long) (zoneOffset2.g - zoneOffset.g));
                    break;
                default:
                    break;
            }
            obj[i2] = new ZoneOffsetTransition(a2, zoneOffsetTransitionRule.f41118h, zoneOffsetTransitionRule.f41119i);
        }
        if (i < 2100) {
            this.f41552g.putIfAbsent(valueOf, obj);
        }
        return obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof StandardZoneRules) {
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            return Arrays.equals(this.f41546a, standardZoneRules.f41546a) && Arrays.equals(this.f41547b, standardZoneRules.f41547b) && Arrays.equals(this.f41548c, standardZoneRules.f41548c) && Arrays.equals(this.f41549d, standardZoneRules.f41549d) && Arrays.equals(this.f41550e, standardZoneRules.f41550e) != null;
        } else {
            if ((obj instanceof Fixed) && mo7866a()) {
                ZoneOffset a = mo7865a(Instant.a);
                Fixed fixed = (Fixed) obj;
                Instant instant = Instant.a;
                if (a.equals(fixed.f41556a) != null) {
                    return true;
                }
            }
            return false;
        }
    }

    public final int hashCode() {
        return (((Arrays.hashCode(this.f41546a) ^ Arrays.hashCode(this.f41547b)) ^ Arrays.hashCode(this.f41548c)) ^ Arrays.hashCode(this.f41549d)) ^ Arrays.hashCode(this.f41550e);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("StandardZoneRules[currentStandardOffset=");
        stringBuilder.append(this.f41547b[this.f41547b.length - 1]);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final ZoneOffset mo7865a(Instant instant) {
        long j = instant.e;
        if (this.f41550e.length <= null || j <= this.f41548c[this.f41548c.length - 1]) {
            instant = Arrays.binarySearch(this.f41548c, j);
            if (instant < null) {
                instant = (-instant) - 2;
            }
            return this.f41549d[instant + 1];
        }
        instant = m43645a(LocalDate.a(Jdk8Methods.m43173d(((long) this.f41549d[this.f41549d.length - 1].g) + j, 86400)).d);
        ZoneOffsetTransition zoneOffsetTransition = null;
        for (ZoneOffsetTransition zoneOffsetTransition2 : instant) {
            if (j < zoneOffsetTransition2.m43220a()) {
                return zoneOffsetTransition2.f41104b;
            }
        }
        return zoneOffsetTransition2.f41105c;
    }

    public final boolean mo7869b(Instant instant) {
        int binarySearch = Arrays.binarySearch(this.f41546a, instant.e);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.f41547b[binarySearch + 1].equals(mo7865a(instant)) == null ? true : null;
    }
}
