package org.threeten.bp;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.zone.ZoneRules;

public abstract class ZoneId implements Serializable {
    public static final TemporalQuery<ZoneId> f10943a = new C15711();
    public static final Map<String, String> f10944b;

    static class C15711 implements TemporalQuery<ZoneId> {
        C15711() {
        }

        public final /* bridge */ /* synthetic */ Object m16453a(TemporalAccessor temporalAccessor) {
            return ZoneId.m9400a(temporalAccessor);
        }
    }

    public abstract String mo3062b();

    public abstract ZoneRules mo3063c();

    static {
        Map hashMap = new HashMap();
        hashMap.put("ACT", "Australia/Darwin");
        hashMap.put("AET", "Australia/Sydney");
        hashMap.put("AGT", "America/Argentina/Buenos_Aires");
        hashMap.put("ART", "Africa/Cairo");
        hashMap.put("AST", "America/Anchorage");
        hashMap.put("BET", "America/Sao_Paulo");
        hashMap.put("BST", "Asia/Dhaka");
        hashMap.put("CAT", "Africa/Harare");
        hashMap.put("CNT", "America/St_Johns");
        hashMap.put("CST", "America/Chicago");
        hashMap.put("CTT", "Asia/Shanghai");
        hashMap.put("EAT", "Africa/Addis_Ababa");
        hashMap.put("ECT", "Europe/Paris");
        hashMap.put("IET", "America/Indiana/Indianapolis");
        hashMap.put("IST", "Asia/Kolkata");
        hashMap.put("JST", "Asia/Tokyo");
        hashMap.put("MIT", "Pacific/Apia");
        hashMap.put("NET", "Asia/Yerevan");
        hashMap.put("NST", "Pacific/Auckland");
        hashMap.put("PLT", "Asia/Karachi");
        hashMap.put("PNT", "America/Phoenix");
        hashMap.put("PRT", "America/Puerto_Rico");
        hashMap.put("PST", "America/Los_Angeles");
        hashMap.put("SST", "Pacific/Guadalcanal");
        hashMap.put("VST", "Asia/Ho_Chi_Minh");
        hashMap.put("EST", "-05:00");
        hashMap.put("MST", "-07:00");
        hashMap.put("HST", "-10:00");
        f10944b = Collections.unmodifiableMap(hashMap);
    }

    public static ZoneId m9399a() {
        String id = TimeZone.getDefault().getID();
        Map map = f10944b;
        Jdk8Methods.a(id, "zoneId");
        Jdk8Methods.a(map, "aliasMap");
        String str = (String) map.get(id);
        if (str != null) {
            id = str;
        }
        Jdk8Methods.a(id, "zoneId");
        if (id.equals("Z")) {
            return ZoneOffset.f16382d;
        }
        if (id.length() == 1) {
            StringBuilder stringBuilder = new StringBuilder("Invalid zone: ");
            stringBuilder.append(id);
            throw new DateTimeException(stringBuilder.toString());
        }
        if (!id.startsWith(Operation.PLUS)) {
            if (!id.startsWith(Operation.MINUS)) {
                if (!(id.equals("UTC") || id.equals("GMT"))) {
                    if (!id.equals("UT")) {
                        if (!(id.startsWith("UTC+") || id.startsWith("GMT+") || id.startsWith("UTC-"))) {
                            if (!id.startsWith("GMT-")) {
                                if (!id.startsWith("UT+")) {
                                    if (!id.startsWith("UT-")) {
                                        return ZoneRegion.m16469a(id);
                                    }
                                }
                                ZoneOffset a = ZoneOffset.m16458a(id.substring(2));
                                if (a.f16387g == 0) {
                                    return new ZoneRegion("UT", ZoneRules.a(a));
                                }
                                stringBuilder = new StringBuilder("UT");
                                stringBuilder.append(a.f16388h);
                                return new ZoneRegion(stringBuilder.toString(), ZoneRules.a(a));
                            }
                        }
                        ZoneOffset a2 = ZoneOffset.m16458a(id.substring(3));
                        if (a2.f16387g == 0) {
                            return new ZoneRegion(id.substring(0, 3), ZoneRules.a(a2));
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(id.substring(0, 3));
                        stringBuilder2.append(a2.f16388h);
                        return new ZoneRegion(stringBuilder2.toString(), ZoneRules.a(a2));
                    }
                }
                return new ZoneRegion(id, ZoneRules.a(ZoneOffset.f16382d));
            }
        }
        return ZoneOffset.m16458a(id);
    }

    public static ZoneId m9400a(TemporalAccessor temporalAccessor) {
        ZoneId zoneId = (ZoneId) temporalAccessor.a(TemporalQueries.d());
        if (zoneId != null) {
            return zoneId;
        }
        StringBuilder stringBuilder = new StringBuilder("Unable to obtain ZoneId from TemporalAccessor: ");
        stringBuilder.append(temporalAccessor);
        stringBuilder.append(", type ");
        stringBuilder.append(temporalAccessor.getClass().getName());
        throw new DateTimeException(stringBuilder.toString());
    }

    ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != ZoneRegion.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public final org.threeten.bp.ZoneId m9403d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        r0 = r2.mo3063c();	 Catch:{ ZoneRulesException -> 0x0011 }
        r1 = r0.a();	 Catch:{ ZoneRulesException -> 0x0011 }
        if (r1 == 0) goto L_0x0011;	 Catch:{ ZoneRulesException -> 0x0011 }
    L_0x000a:
        r1 = org.threeten.bp.Instant.f18814a;	 Catch:{ ZoneRulesException -> 0x0011 }
        r0 = r0.a(r1);	 Catch:{ ZoneRulesException -> 0x0011 }
        return r0;
    L_0x0011:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZoneId.d():org.threeten.bp.ZoneId");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZoneId)) {
            return null;
        }
        return mo3062b().equals(((ZoneId) obj).mo3062b());
    }

    public int hashCode() {
        return mo3062b().hashCode();
    }

    public String toString() {
        return mo3062b();
    }
}
