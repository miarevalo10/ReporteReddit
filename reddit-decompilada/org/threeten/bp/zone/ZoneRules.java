package org.threeten.bp.zone;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;

public abstract class ZoneRules {

    static final class Fixed extends ZoneRules implements Serializable {
        final ZoneOffset f41556a;

        public final boolean mo7866a() {
            return true;
        }

        public final ZoneOffsetTransition mo7868b(LocalDateTime localDateTime) {
            return null;
        }

        public final boolean mo7869b(Instant instant) {
            return false;
        }

        Fixed(ZoneOffset zoneOffset) {
            this.f41556a = zoneOffset;
        }

        public final ZoneOffset mo7865a(Instant instant) {
            return this.f41556a;
        }

        public final List<ZoneOffset> mo7864a(LocalDateTime localDateTime) {
            return Collections.singletonList(this.f41556a);
        }

        public final boolean mo7867a(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
            return this.f41556a.equals(zoneOffset);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Fixed) {
                return this.f41556a.equals(((Fixed) obj).f41556a);
            }
            if (!(obj instanceof StandardZoneRules)) {
                return false;
            }
            StandardZoneRules standardZoneRules = (StandardZoneRules) obj;
            if (!standardZoneRules.mo7866a() || this.f41556a.equals(standardZoneRules.mo7865a(Instant.a)) == null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return ((((this.f41556a.hashCode() + 31) ^ 1) ^ 1) ^ (31 + this.f41556a.hashCode())) ^ 1;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("FixedRules:");
            stringBuilder.append(this.f41556a);
            return stringBuilder.toString();
        }
    }

    public abstract List<ZoneOffset> mo7864a(LocalDateTime localDateTime);

    public abstract ZoneOffset mo7865a(Instant instant);

    public abstract boolean mo7866a();

    public abstract boolean mo7867a(LocalDateTime localDateTime, ZoneOffset zoneOffset);

    public abstract ZoneOffsetTransition mo7868b(LocalDateTime localDateTime);

    public abstract boolean mo7869b(Instant instant);

    public static ZoneRules m43226a(ZoneOffset zoneOffset) {
        Jdk8Methods.m43168a((Object) zoneOffset, "offset");
        return new Fixed(zoneOffset);
    }

    ZoneRules() {
    }
}
