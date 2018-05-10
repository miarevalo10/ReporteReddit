package org.threeten.bp.format;

import java.text.DateFormatSymbols;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalField;

final class SimpleDateTimeTextProvider extends DateTimeTextProvider {
    private static final ConcurrentMap<Entry<TemporalField, Locale>, Object> f41467a = new ConcurrentHashMap(16, 0.75f, 2);
    private static final Comparator<Entry<String, Long>> f41468b = new C30581();

    static class C30581 implements Comparator<Entry<String, Long>> {
        C30581() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return ((String) ((Entry) obj2).getKey()).length() - ((String) ((Entry) obj).getKey()).length();
        }
    }

    static final class LocaleStore {
        private final Map<TextStyle, Map<Long, String>> f41060a;
        private final Map<TextStyle, List<Entry<String, Long>>> f41061b;

        LocaleStore(Map<TextStyle, Map<Long, String>> map) {
            this.f41060a = map;
            Map hashMap = new HashMap();
            List arrayList = new ArrayList();
            for (TextStyle textStyle : map.keySet()) {
                Map hashMap2 = new HashMap();
                for (Entry entry : ((Map) map.get(textStyle)).entrySet()) {
                    Object put = hashMap2.put(entry.getValue(), SimpleDateTimeTextProvider.m43592b(entry.getValue(), entry.getKey()));
                }
                Collection arrayList2 = new ArrayList(hashMap2.values());
                Collections.sort(arrayList2, SimpleDateTimeTextProvider.f41468b);
                hashMap.put(textStyle, arrayList2);
                arrayList.addAll(arrayList2);
                hashMap.put(null, arrayList);
            }
            Collections.sort(arrayList, SimpleDateTimeTextProvider.f41468b);
            this.f41061b = hashMap;
        }

        final String m43162a(long j, TextStyle textStyle) {
            Map map = (Map) this.f41060a.get(textStyle);
            return map != null ? (String) map.get(Long.valueOf(j)) : 0;
        }
    }

    SimpleDateTimeTextProvider() {
    }

    private static <A, B> Entry<A, B> m43592b(A a, B b) {
        return new SimpleImmutableEntry(a, b);
    }

    private static LocaleStore m43590a(Map<TextStyle, Map<Long, String>> map) {
        map.put(TextStyle.FULL_STANDALONE, map.get(TextStyle.FULL));
        map.put(TextStyle.SHORT_STANDALONE, map.get(TextStyle.SHORT));
        if (map.containsKey(TextStyle.NARROW) && !map.containsKey(TextStyle.NARROW_STANDALONE)) {
            map.put(TextStyle.NARROW_STANDALONE, map.get(TextStyle.NARROW));
        }
        return new LocaleStore(map);
    }

    public final String mo7849a(TemporalField temporalField, long j, TextStyle textStyle, Locale locale) {
        TemporalField temporalField2 = temporalField;
        Entry b = m43592b(temporalField2, locale);
        Object obj = f41467a.get(b);
        if (obj == null) {
            Entry entry;
            Object a;
            DateFormatSymbols instance;
            Map hashMap;
            Long valueOf;
            Long valueOf2;
            Long valueOf3;
            Long valueOf4;
            Long valueOf5;
            Long valueOf6;
            Map hashMap2;
            Map hashMap3;
            String[] shortMonths;
            if (temporalField2 == ChronoField.MONTH_OF_YEAR) {
                instance = DateFormatSymbols.getInstance(locale);
                hashMap = new HashMap();
                valueOf = Long.valueOf(1);
                valueOf2 = Long.valueOf(2);
                valueOf3 = Long.valueOf(3);
                valueOf4 = Long.valueOf(4);
                valueOf5 = Long.valueOf(5);
                valueOf6 = Long.valueOf(6);
                Long valueOf7 = Long.valueOf(7);
                Long valueOf8 = Long.valueOf(8);
                Long valueOf9 = Long.valueOf(9);
                Long valueOf10 = Long.valueOf(10);
                Long valueOf11 = Long.valueOf(11);
                Long valueOf12 = Long.valueOf(12);
                String[] months = instance.getMonths();
                entry = b;
                hashMap2 = new HashMap();
                DateFormatSymbols dateFormatSymbols = instance;
                hashMap2.put(valueOf, months[0]);
                hashMap2.put(valueOf2, months[1]);
                hashMap2.put(valueOf3, months[2]);
                hashMap2.put(valueOf4, months[3]);
                hashMap2.put(valueOf5, months[4]);
                hashMap2.put(valueOf6, months[5]);
                hashMap2.put(valueOf7, months[6]);
                hashMap2.put(valueOf8, months[7]);
                hashMap2.put(valueOf9, months[8]);
                Long l = valueOf10;
                hashMap2.put(l, months[9]);
                hashMap2.put(valueOf11, months[10]);
                hashMap2.put(valueOf12, months[11]);
                hashMap.put(TextStyle.FULL, hashMap2);
                hashMap3 = new HashMap();
                Map map = hashMap;
                Long l2 = valueOf12;
                hashMap3.put(valueOf, months[0].substring(0, 1));
                hashMap3.put(valueOf2, months[1].substring(0, 1));
                Long l3 = valueOf2;
                hashMap3.put(valueOf3, months[2].substring(0, 1));
                hashMap3.put(valueOf4, months[3].substring(0, 1));
                hashMap3.put(valueOf5, months[4].substring(0, 1));
                hashMap3.put(valueOf6, months[5].substring(0, 1));
                hashMap3.put(valueOf7, months[6].substring(0, 1));
                hashMap3.put(valueOf8, months[7].substring(0, 1));
                hashMap3.put(valueOf9, months[8].substring(0, 1));
                hashMap3.put(l, months[9].substring(0, 1));
                hashMap3.put(valueOf11, months[10].substring(0, 1));
                valueOf2 = l2;
                hashMap3.put(valueOf2, months[11].substring(0, 1));
                Map map2 = map;
                map2.put(TextStyle.NARROW, hashMap3);
                shortMonths = dateFormatSymbols.getShortMonths();
                hashMap = new HashMap();
                hashMap.put(valueOf, shortMonths[0]);
                hashMap.put(l3, shortMonths[1]);
                hashMap.put(valueOf3, shortMonths[2]);
                hashMap.put(valueOf4, shortMonths[3]);
                hashMap.put(valueOf5, shortMonths[4]);
                hashMap.put(valueOf6, shortMonths[5]);
                hashMap.put(valueOf7, shortMonths[6]);
                hashMap.put(valueOf8, shortMonths[7]);
                hashMap.put(valueOf9, shortMonths[8]);
                hashMap.put(l, shortMonths[9]);
                hashMap.put(valueOf11, shortMonths[10]);
                hashMap.put(valueOf2, shortMonths[11]);
                map2.put(TextStyle.SHORT, hashMap);
                a = m43590a(map2);
            } else {
                entry = b;
                if (temporalField2 == ChronoField.DAY_OF_WEEK) {
                    instance = DateFormatSymbols.getInstance(locale);
                    hashMap = new HashMap();
                    Long valueOf13 = Long.valueOf(1);
                    valueOf = Long.valueOf(2);
                    valueOf3 = Long.valueOf(3);
                    valueOf4 = Long.valueOf(4);
                    valueOf5 = Long.valueOf(5);
                    valueOf6 = Long.valueOf(6);
                    valueOf2 = Long.valueOf(7);
                    String[] weekdays = instance.getWeekdays();
                    Map hashMap4 = new HashMap();
                    hashMap4.put(valueOf13, weekdays[2]);
                    hashMap4.put(valueOf, weekdays[3]);
                    hashMap4.put(valueOf3, weekdays[4]);
                    hashMap4.put(valueOf4, weekdays[5]);
                    hashMap4.put(valueOf5, weekdays[6]);
                    hashMap4.put(valueOf6, weekdays[7]);
                    hashMap4.put(valueOf2, weekdays[1]);
                    hashMap.put(TextStyle.FULL, hashMap4);
                    hashMap4 = new HashMap();
                    hashMap4.put(valueOf13, weekdays[2].substring(0, 1));
                    hashMap4.put(valueOf, weekdays[3].substring(0, 1));
                    hashMap4.put(valueOf3, weekdays[4].substring(0, 1));
                    hashMap4.put(valueOf4, weekdays[5].substring(0, 1));
                    hashMap4.put(valueOf5, weekdays[6].substring(0, 1));
                    hashMap4.put(valueOf6, weekdays[7].substring(0, 1));
                    hashMap4.put(valueOf2, weekdays[1].substring(0, 1));
                    hashMap.put(TextStyle.NARROW, hashMap4);
                    shortMonths = instance.getShortWeekdays();
                    Map hashMap5 = new HashMap();
                    hashMap5.put(valueOf13, shortMonths[2]);
                    hashMap5.put(valueOf, shortMonths[3]);
                    hashMap5.put(valueOf3, shortMonths[4]);
                    hashMap5.put(valueOf4, shortMonths[5]);
                    hashMap5.put(valueOf5, shortMonths[6]);
                    hashMap5.put(valueOf6, shortMonths[7]);
                    hashMap5.put(valueOf2, shortMonths[1]);
                    hashMap.put(TextStyle.SHORT, hashMap5);
                    a = m43590a(hashMap);
                } else if (temporalField2 == ChronoField.AMPM_OF_DAY) {
                    instance = DateFormatSymbols.getInstance(locale);
                    hashMap = new HashMap();
                    shortMonths = instance.getAmPmStrings();
                    hashMap2 = new HashMap();
                    hashMap2.put(Long.valueOf(0), shortMonths[0]);
                    hashMap2.put(Long.valueOf(1), shortMonths[1]);
                    hashMap.put(TextStyle.FULL, hashMap2);
                    hashMap.put(TextStyle.SHORT, hashMap2);
                    a = m43590a(hashMap);
                } else if (temporalField2 == ChronoField.ERA) {
                    instance = DateFormatSymbols.getInstance(locale);
                    hashMap2 = new HashMap();
                    shortMonths = instance.getEras();
                    Map hashMap6 = new HashMap();
                    hashMap6.put(Long.valueOf(0), shortMonths[0]);
                    hashMap6.put(Long.valueOf(1), shortMonths[1]);
                    hashMap2.put(TextStyle.SHORT, hashMap6);
                    if (locale.getLanguage().equals(Locale.ENGLISH.getLanguage())) {
                        hashMap = new HashMap();
                        hashMap.put(Long.valueOf(0), "Before Christ");
                        hashMap.put(Long.valueOf(1), "Anno Domini");
                        hashMap2.put(TextStyle.FULL, hashMap);
                    } else {
                        hashMap2.put(TextStyle.FULL, hashMap6);
                    }
                    hashMap = new HashMap();
                    hashMap.put(Long.valueOf(0), shortMonths[0].substring(0, 1));
                    hashMap.put(Long.valueOf(1), shortMonths[1].substring(0, 1));
                    hashMap2.put(TextStyle.NARROW, hashMap);
                    a = m43590a(hashMap2);
                } else if (temporalField2 == IsoFields.f41071b) {
                    hashMap3 = new HashMap();
                    hashMap = new HashMap();
                    hashMap.put(Long.valueOf(1), "Q1");
                    hashMap.put(Long.valueOf(2), "Q2");
                    hashMap.put(Long.valueOf(3), "Q3");
                    hashMap.put(Long.valueOf(4), "Q4");
                    hashMap3.put(TextStyle.SHORT, hashMap);
                    hashMap = new HashMap();
                    hashMap.put(Long.valueOf(1), "1st quarter");
                    hashMap.put(Long.valueOf(2), "2nd quarter");
                    hashMap.put(Long.valueOf(3), "3rd quarter");
                    hashMap.put(Long.valueOf(4), "4th quarter");
                    hashMap3.put(TextStyle.FULL, hashMap);
                    a = m43590a(hashMap3);
                } else {
                    a = "";
                }
            }
            b = entry;
            f41467a.putIfAbsent(b, a);
            obj = f41467a.get(b);
        }
        return obj instanceof LocaleStore ? ((LocaleStore) obj).m43162a(j, textStyle) : null;
    }
}
