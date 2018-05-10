package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;

public final class ZoneOffsetTransition implements Serializable, Comparable<ZoneOffsetTransition> {
    final LocalDateTime f41103a;
    final ZoneOffset f41104b;
    public final ZoneOffset f41105c;

    public final /* synthetic */ int compareTo(Object obj) {
        return m43218e().a(((ZoneOffsetTransition) obj).m43218e());
    }

    ZoneOffsetTransition(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f41103a = localDateTime;
        this.f41104b = zoneOffset;
        this.f41105c = zoneOffset2;
    }

    ZoneOffsetTransition(long j, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f41103a = LocalDateTime.a(j, 0, zoneOffset);
        this.f41104b = zoneOffset;
        this.f41105c = zoneOffset2;
    }

    static ZoneOffsetTransition m43217a(DataInput dataInput) throws IOException {
        long c = Ser.m43214c(dataInput);
        ZoneOffset b = Ser.m43213b(dataInput);
        ZoneOffset b2 = Ser.m43213b(dataInput);
        if (!b.equals(b2)) {
            return new ZoneOffsetTransition(c, b, b2);
        }
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    private Instant m43218e() {
        return this.f41103a.a(this.f41104b);
    }

    public final long m43220a() {
        return this.f41103a.b(this.f41104b);
    }

    public final LocalDateTime m43221b() {
        return this.f41103a.a((long) m43219f());
    }

    public final Duration m43222c() {
        return Duration.a((long) m43219f());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ZoneOffsetTransition)) {
            return false;
        }
        ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) obj;
        return this.f41103a.equals(zoneOffsetTransition.f41103a) && this.f41104b.equals(zoneOffsetTransition.f41104b) && this.f41105c.equals(zoneOffsetTransition.f41105c) != null;
    }

    public final int hashCode() {
        return (this.f41103a.hashCode() ^ this.f41104b.hashCode()) ^ Integer.rotateLeft(this.f41105c.hashCode(), 16);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Transition[");
        stringBuilder.append(m43223d() ? "Gap" : "Overlap");
        stringBuilder.append(" at ");
        stringBuilder.append(this.f41103a);
        stringBuilder.append(this.f41104b);
        stringBuilder.append(" to ");
        stringBuilder.append(this.f41105c);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    private int m43219f() {
        return this.f41105c.g - this.f41104b.g;
    }

    public final boolean m43223d() {
        return this.f41105c.g > this.f41104b.g;
    }
}
