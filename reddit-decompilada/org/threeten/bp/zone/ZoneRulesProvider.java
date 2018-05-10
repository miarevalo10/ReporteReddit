package org.threeten.bp.zone;

import com.google.android.gms.ads.AdRequest;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.threeten.bp.jdk8.Jdk8Methods;

public abstract class ZoneRulesProvider {
    private static final CopyOnWriteArrayList<ZoneRulesProvider> f41120a = new CopyOnWriteArrayList();
    private static final ConcurrentMap<String, ZoneRulesProvider> f41121b = new ConcurrentHashMap(AdRequest.MAX_CONTENT_URL_LENGTH, 0.75f, 2);

    protected abstract Set<String> mo7870a();

    protected abstract ZoneRules mo7871a(String str);

    static {
        Iterator it = ServiceLoader.load(ZoneRulesProvider.class, ZoneRulesProvider.class.getClassLoader()).iterator();
        while (it.hasNext()) {
            try {
                m43235b((ZoneRulesProvider) it.next());
            } catch (ServiceConfigurationError e) {
                if (!(e.getCause() instanceof SecurityException)) {
                    throw e;
                }
            }
        }
    }

    public static ZoneRules m43234b(String str) {
        Jdk8Methods.m43168a((Object) str, "zoneId");
        ZoneRulesProvider zoneRulesProvider = (ZoneRulesProvider) f41121b.get(str);
        if (zoneRulesProvider != null) {
            return zoneRulesProvider.mo7871a(str);
        }
        if (f41121b.isEmpty()) {
            throw new ZoneRulesException("No time-zone data files registered");
        }
        StringBuilder stringBuilder = new StringBuilder("Unknown time-zone ID: ");
        stringBuilder.append(str);
        throw new ZoneRulesException(stringBuilder.toString());
    }

    public static void m43233a(ZoneRulesProvider zoneRulesProvider) {
        Jdk8Methods.m43168a((Object) zoneRulesProvider, "provider");
        m43235b(zoneRulesProvider);
        f41120a.add(zoneRulesProvider);
    }

    private static void m43235b(ZoneRulesProvider zoneRulesProvider) {
        for (Object obj : zoneRulesProvider.mo7870a()) {
            Jdk8Methods.m43168a(obj, "zoneId");
            if (((ZoneRulesProvider) f41121b.putIfAbsent(obj, zoneRulesProvider)) != null) {
                StringBuilder stringBuilder = new StringBuilder("Unable to register zone as one already registered with that ID: ");
                stringBuilder.append(obj);
                stringBuilder.append(", currently loading from provider: ");
                stringBuilder.append(zoneRulesProvider);
                throw new ZoneRulesException(stringBuilder.toString());
            }
        }
    }

    protected ZoneRulesProvider() {
    }
}
