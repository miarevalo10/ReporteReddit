package org.threeten.bp;

import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;

final class ZoneRegion extends ZoneId implements Serializable {
    private static final Pattern f16389c = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    private final String f16390d;
    private final transient ZoneRules f16391e;

    static ZoneRegion m16469a(String str) {
        Jdk8Methods.a(str, "zoneId");
        if (str.length() >= 2) {
            if (f16389c.matcher(str).matches()) {
                ZoneRules b;
                try {
                    b = ZoneRulesProvider.b(str);
                } catch (ZoneRulesException e) {
                    if (str.equals("GMT0")) {
                        b = ZoneRules.a(ZoneOffset.f16382d);
                    } else {
                        throw e;
                    }
                }
                return new ZoneRegion(str, b);
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Invalid ID for region-based ZoneId, invalid format: ");
        stringBuilder.append(str);
        throw new DateTimeException(stringBuilder.toString());
    }

    ZoneRegion(String str, ZoneRules zoneRules) {
        this.f16390d = str;
        this.f16391e = zoneRules;
    }

    public final String mo3062b() {
        return this.f16390d;
    }

    public final ZoneRules mo3063c() {
        return this.f16391e != null ? this.f16391e : ZoneRulesProvider.b(this.f16390d);
    }
}
