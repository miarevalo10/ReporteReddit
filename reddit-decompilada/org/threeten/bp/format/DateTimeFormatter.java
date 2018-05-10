package org.threeten.bp.format;

import com.instabug.library.model.State;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;

public final class DateTimeFormatter {
    public static final DateTimeFormatter f41005a = new DateTimeFormatterBuilder().m43146a(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).m43141a('-').m43145a(ChronoField.MONTH_OF_YEAR, 2).m43141a('-').m43145a(ChronoField.DAY_OF_MONTH, 2).m43139a(ResolverStyle.STRICT).m43129a(IsoChronology.f41426b);
    public static final DateTimeFormatter f41006b = new DateTimeFormatterBuilder().m43149b().m43144a(f41005a).m43151c().m43139a(ResolverStyle.STRICT).m43129a(IsoChronology.f41426b);
    public static final DateTimeFormatter f41007c = new DateTimeFormatterBuilder().m43149b().m43144a(f41005a).m43153e().m43151c().m43139a(ResolverStyle.STRICT).m43129a(IsoChronology.f41426b);
    public static final DateTimeFormatter f41008d = new DateTimeFormatterBuilder().m43145a(ChronoField.HOUR_OF_DAY, 2).m43141a(':').m43145a(ChronoField.MINUTE_OF_HOUR, 2).m43153e().m43141a(':').m43145a(ChronoField.SECOND_OF_MINUTE, 2).m43153e().m43147a(ChronoField.NANO_OF_SECOND, 0, 9, true).m43139a(ResolverStyle.STRICT);
    public static final DateTimeFormatter f41009e = new DateTimeFormatterBuilder().m43149b().m43144a(f41008d).m43151c().m43139a(ResolverStyle.STRICT);
    public static final DateTimeFormatter f41010f = new DateTimeFormatterBuilder().m43149b().m43144a(f41008d).m43153e().m43151c().m43139a(ResolverStyle.STRICT);
    public static final DateTimeFormatter f41011g = new DateTimeFormatterBuilder().m43149b().m43144a(f41005a).m43141a('T').m43144a(f41008d).m43139a(ResolverStyle.STRICT).m43129a(IsoChronology.f41426b);
    public static final DateTimeFormatter f41012h = new DateTimeFormatterBuilder().m43149b().m43144a(f41011g).m43151c().m43139a(ResolverStyle.STRICT).m43129a(IsoChronology.f41426b);
    public static final DateTimeFormatter f41013i = new DateTimeFormatterBuilder().m43144a(f41012h).m43153e().m43141a('[').m43140a().m43152d().m43141a(']').m43139a(ResolverStyle.STRICT).m43129a(IsoChronology.f41426b);
    public static final DateTimeFormatter f41014j = new DateTimeFormatterBuilder().m43144a(f41011g).m43153e().m43151c().m43153e().m43141a('[').m43140a().m43152d().m43141a(']').m43139a(ResolverStyle.STRICT).m43129a(IsoChronology.f41426b);
    public static final DateTimeFormatter f41015k = new DateTimeFormatterBuilder().m43149b().m43146a(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).m43141a('-').m43145a(ChronoField.DAY_OF_YEAR, 3).m43153e().m43151c().m43139a(ResolverStyle.STRICT).m43129a(IsoChronology.f41426b);
    public static final DateTimeFormatter f41016l = new DateTimeFormatterBuilder().m43149b().m43146a(IsoFields.f41073d, 4, 10, SignStyle.EXCEEDS_PAD).m43142a("-W").m43145a(IsoFields.f41072c, 2).m43141a('-').m43145a(ChronoField.DAY_OF_WEEK, 1).m43153e().m43151c().m43139a(ResolverStyle.STRICT).m43129a(IsoChronology.f41426b);
    public static final DateTimeFormatter f41017m;
    public static final DateTimeFormatter f41018n = new DateTimeFormatterBuilder().m43149b().m43145a(ChronoField.YEAR, 4).m43145a(ChronoField.MONTH_OF_YEAR, 2).m43145a(ChronoField.DAY_OF_MONTH, 2).m43153e().m43143a("+HHMMss", "Z").m43139a(ResolverStyle.STRICT).m43129a(IsoChronology.f41426b);
    public static final DateTimeFormatter f41019o;
    private static final TemporalQuery<Period> f41020w = new C30761();
    private static final TemporalQuery<Boolean> f41021x = new C30772();
    public final CompositePrinterParser f41022p;
    public final Locale f41023q;
    public final DecimalStyle f41024r;
    public final ResolverStyle f41025s;
    public final Set<TemporalField> f41026t;
    public final Chronology f41027u;
    public final ZoneId f41028v;

    static class C30761 implements TemporalQuery<Period> {
        C30761() {
        }

        public final /* bridge */ /* synthetic */ Object mo7842a(TemporalAccessor temporalAccessor) {
            if (temporalAccessor instanceof DateTimeBuilder) {
                return ((DateTimeBuilder) temporalAccessor).f41849g;
            }
            return Period.a;
        }
    }

    static class C30772 implements TemporalQuery<Boolean> {
        C30772() {
        }

        public final /* synthetic */ Object mo7842a(TemporalAccessor temporalAccessor) {
            if (temporalAccessor instanceof DateTimeBuilder) {
                return Boolean.valueOf(((DateTimeBuilder) temporalAccessor).f41848f);
            }
            return Boolean.FALSE;
        }
    }

    static {
        DateTimeFormatterBuilder b = new DateTimeFormatterBuilder().m43149b();
        b.m43137a(new InstantPrinterParser());
        f41017m = b.m43139a(ResolverStyle.STRICT);
        Map hashMap = new HashMap();
        hashMap.put(Long.valueOf(1), "Mon");
        hashMap.put(Long.valueOf(2), "Tue");
        hashMap.put(Long.valueOf(3), "Wed");
        hashMap.put(Long.valueOf(4), "Thu");
        hashMap.put(Long.valueOf(5), "Fri");
        hashMap.put(Long.valueOf(6), "Sat");
        hashMap.put(Long.valueOf(7), "Sun");
        Map hashMap2 = new HashMap();
        hashMap2.put(Long.valueOf(1), "Jan");
        hashMap2.put(Long.valueOf(2), "Feb");
        hashMap2.put(Long.valueOf(3), "Mar");
        hashMap2.put(Long.valueOf(4), "Apr");
        hashMap2.put(Long.valueOf(5), "May");
        hashMap2.put(Long.valueOf(6), "Jun");
        hashMap2.put(Long.valueOf(7), "Jul");
        hashMap2.put(Long.valueOf(8), "Aug");
        hashMap2.put(Long.valueOf(9), "Sep");
        hashMap2.put(Long.valueOf(10), "Oct");
        hashMap2.put(Long.valueOf(11), "Nov");
        hashMap2.put(Long.valueOf(12), "Dec");
        DateTimeFormatterBuilder b2 = new DateTimeFormatterBuilder().m43149b();
        b2.m43137a(SettingsParser.LENIENT);
        f41019o = b2.m43153e().m43148a(ChronoField.DAY_OF_WEEK, hashMap).m43142a(", ").m43154f().m43146a(ChronoField.DAY_OF_MONTH, 1, 2, SignStyle.NOT_NEGATIVE).m43141a(' ').m43148a(ChronoField.MONTH_OF_YEAR, hashMap2).m43141a(' ').m43145a(ChronoField.YEAR, 4).m43141a(' ').m43145a(ChronoField.HOUR_OF_DAY, 2).m43141a(':').m43145a(ChronoField.MINUTE_OF_HOUR, 2).m43153e().m43141a(':').m43145a(ChronoField.SECOND_OF_MINUTE, 2).m43154f().m43141a(' ').m43143a("+HHMM", "GMT").m43139a(ResolverStyle.SMART).m43129a(IsoChronology.f41426b);
    }

    public static DateTimeFormatter m43127a(String str) {
        return new DateTimeFormatterBuilder().m43150b(str).m43138a(Locale.getDefault());
    }

    public static DateTimeFormatter m43128a(String str, Locale locale) {
        return new DateTimeFormatterBuilder().m43150b(str).m43138a(locale);
    }

    public DateTimeFormatter(CompositePrinterParser compositePrinterParser, Locale locale, DecimalStyle decimalStyle, ResolverStyle resolverStyle, Set<TemporalField> set, Chronology chronology, ZoneId zoneId) {
        this.f41022p = (CompositePrinterParser) Jdk8Methods.m43168a((Object) compositePrinterParser, "printerParser");
        this.f41023q = (Locale) Jdk8Methods.m43168a((Object) locale, State.KEY_LOCALE);
        this.f41024r = (DecimalStyle) Jdk8Methods.m43168a((Object) decimalStyle, "decimalStyle");
        this.f41025s = (ResolverStyle) Jdk8Methods.m43168a((Object) resolverStyle, "resolverStyle");
        this.f41026t = set;
        this.f41027u = chronology;
        this.f41028v = zoneId;
    }

    private DateTimeFormatter m43129a(Chronology chronology) {
        if (Jdk8Methods.m43169a(this.f41027u, (Object) chronology)) {
            return this;
        }
        return new DateTimeFormatter(this.f41022p, this.f41023q, this.f41024r, this.f41025s, this.f41026t, chronology, this.f41028v);
    }

    public final String m43130a(TemporalAccessor temporalAccessor) {
        Object stringBuilder = new StringBuilder(32);
        Jdk8Methods.m43168a((Object) temporalAccessor, "temporal");
        Jdk8Methods.m43168a(stringBuilder, "appendable");
        try {
            this.f41022p.mo7850a(new DateTimePrintContext(temporalAccessor, this), (StringBuilder) stringBuilder);
            return stringBuilder.toString();
        } catch (TemporalAccessor temporalAccessor2) {
            throw new DateTimeException(temporalAccessor2.getMessage(), temporalAccessor2);
        }
    }

    public final String toString() {
        String compositePrinterParser = this.f41022p.toString();
        return compositePrinterParser.startsWith("[") ? compositePrinterParser : compositePrinterParser.substring(1, compositePrinterParser.length() - 1);
    }
}
