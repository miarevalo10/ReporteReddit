package org.threeten.bp.format;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.instabug.library.model.State;
import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.chrono.Chronology;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQueries;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.WeekFields;

public final class DateTimeFormatterBuilder {
    static final Comparator<String> f41030a = new C30553();
    private static final TemporalQuery<ZoneId> f41031b = new C30781();
    private static final Map<Character, TemporalField> f41032j;
    private DateTimeFormatterBuilder f41033c;
    private final DateTimeFormatterBuilder f41034d;
    private final List<DateTimePrinterParser> f41035e;
    private final boolean f41036f;
    private int f41037g;
    private char f41038h;
    private int f41039i;

    static class C30553 implements Comparator<String> {
        C30553() {
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            String str = (String) obj;
            String str2 = (String) obj2;
            return str.length() == str2.length() ? str.compareTo(str2) : str.length() - str2.length();
        }
    }

    interface DateTimePrinterParser {
        boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder);
    }

    static class C30781 implements TemporalQuery<ZoneId> {
        C30781() {
        }

        public final /* bridge */ /* synthetic */ Object mo7842a(TemporalAccessor temporalAccessor) {
            ZoneId zoneId = (ZoneId) temporalAccessor.mo7851a(TemporalQueries.m43190a());
            return (zoneId == null || (zoneId instanceof ZoneOffset)) ? null : zoneId;
        }
    }

    static final class CharLiteralPrinterParser implements DateTimePrinterParser {
        private final char f41429a;

        CharLiteralPrinterParser(char c) {
            this.f41429a = c;
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            stringBuilder.append(this.f41429a);
            return true;
        }

        public final String toString() {
            if (this.f41429a == '\'') {
                return "''";
            }
            StringBuilder stringBuilder = new StringBuilder("'");
            stringBuilder.append(this.f41429a);
            stringBuilder.append("'");
            return stringBuilder.toString();
        }
    }

    static final class CompositePrinterParser implements DateTimePrinterParser {
        final DateTimePrinterParser[] f41430a;
        final boolean f41431b;

        CompositePrinterParser(List<DateTimePrinterParser> list, boolean z) {
            this((DateTimePrinterParser[]) list.toArray(new DateTimePrinterParser[list.size()]), z);
        }

        CompositePrinterParser(DateTimePrinterParser[] dateTimePrinterParserArr, boolean z) {
            this.f41430a = dateTimePrinterParserArr;
            this.f41431b = z;
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            int length = stringBuilder.length();
            if (this.f41431b) {
                dateTimePrintContext.f41043d++;
            }
            try {
                DateTimePrinterParser[] dateTimePrinterParserArr = this.f41430a;
                int length2 = dateTimePrinterParserArr.length;
                int i = 0;
                while (i < length2) {
                    if (dateTimePrinterParserArr[i].mo7850a(dateTimePrintContext, stringBuilder)) {
                        i++;
                    } else {
                        stringBuilder.setLength(length);
                        return true;
                    }
                }
                if (this.f41431b != null) {
                    dateTimePrintContext.m43158a();
                }
                return true;
            } finally {
                if (this.f41431b) {
                    dateTimePrintContext.m43158a();
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (this.f41430a != null) {
                stringBuilder.append(this.f41431b ? "[" : "(");
                for (Object append : this.f41430a) {
                    stringBuilder.append(append);
                }
                stringBuilder.append(this.f41431b ? "]" : ")");
            }
            return stringBuilder.toString();
        }
    }

    static final class FractionPrinterParser implements DateTimePrinterParser {
        private final TemporalField f41432a;
        private final int f41433b;
        private final int f41434c;
        private final boolean f41435d;

        FractionPrinterParser(TemporalField temporalField, int i, int i2, boolean z) {
            Jdk8Methods.m43168a((Object) temporalField, "field");
            ValueRange a = temporalField.mo7855a();
            Object obj = (a.f41083a == a.f41084b && a.f41085c == a.f41086d) ? 1 : null;
            if (obj == null) {
                i2 = new StringBuilder("Field must have a fixed set of values: ");
                i2.append(temporalField);
                throw new IllegalArgumentException(i2.toString());
            }
            if (i >= 0) {
                if (i <= 9) {
                    if (i2 > 0) {
                        if (i2 <= 9) {
                            if (i2 < i) {
                                z = new StringBuilder("Maximum width must exceed or equal the minimum width but ");
                                z.append(i2);
                                z.append(" < ");
                                z.append(i);
                                throw new IllegalArgumentException(z.toString());
                            }
                            this.f41432a = temporalField;
                            this.f41433b = i;
                            this.f41434c = i2;
                            this.f41435d = z;
                            return;
                        }
                    }
                    i = new StringBuilder("Maximum width must be from 1 to 9 inclusive but was ");
                    i.append(i2);
                    throw new IllegalArgumentException(i.toString());
                }
            }
            i2 = new StringBuilder("Minimum width must be from 0 to 9 inclusive but was ");
            i2.append(i);
            throw new IllegalArgumentException(i2.toString());
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            Long a = dateTimePrintContext.m43156a(this.f41432a);
            int i = 0;
            if (a == null) {
                return false;
            }
            dateTimePrintContext = dateTimePrintContext.f41042c;
            long longValue = a.longValue();
            ValueRange a2 = this.f41432a.mo7855a();
            a2.m43203a(longValue, this.f41432a);
            BigDecimal valueOf = BigDecimal.valueOf(a2.f41083a);
            BigDecimal divide = BigDecimal.valueOf(longValue).subtract(valueOf).divide(BigDecimal.valueOf(a2.f41086d).subtract(valueOf).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
            divide = divide.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : divide.stripTrailingZeros();
            if (divide.scale() != 0) {
                String a3 = dateTimePrintContext.m43161a(divide.setScale(Math.min(Math.max(divide.scale(), this.f41433b), this.f41434c), RoundingMode.FLOOR).toPlainString().substring(2));
                if (this.f41435d) {
                    stringBuilder.append(dateTimePrintContext.f41049e);
                }
                stringBuilder.append(a3);
            } else if (this.f41433b > 0) {
                if (this.f41435d) {
                    stringBuilder.append(dateTimePrintContext.f41049e);
                }
                while (i < this.f41433b) {
                    stringBuilder.append(dateTimePrintContext.f41046b);
                    i++;
                }
            }
            return true;
        }

        public final String toString() {
            String str = this.f41435d ? ",DecimalPoint" : "";
            StringBuilder stringBuilder = new StringBuilder("Fraction(");
            stringBuilder.append(this.f41432a);
            stringBuilder.append(",");
            stringBuilder.append(this.f41433b);
            stringBuilder.append(",");
            stringBuilder.append(this.f41434c);
            stringBuilder.append(str);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static final class InstantPrinterParser implements DateTimePrinterParser {
        private final int f41436a = -2;

        public final String toString() {
            return "Instant()";
        }

        InstantPrinterParser() {
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            InstantPrinterParser instantPrinterParser = this;
            DateTimePrintContext dateTimePrintContext2 = dateTimePrintContext;
            StringBuilder stringBuilder2 = stringBuilder;
            Long a = dateTimePrintContext2.m43156a(ChronoField.INSTANT_SECONDS);
            Long valueOf = Long.valueOf(0);
            if (dateTimePrintContext2.f41040a.mo7919a(ChronoField.NANO_OF_SECOND)) {
                valueOf = Long.valueOf(dateTimePrintContext2.f41040a.mo7920d(ChronoField.NANO_OF_SECOND));
            }
            int i = 0;
            if (a == null) {
                return false;
            }
            long longValue = a.longValue();
            int b = ChronoField.NANO_OF_SECOND.m43601b(valueOf.longValue());
            long d;
            LocalDateTime a2;
            if (longValue >= -62167219200L) {
                longValue = (longValue - 315569520000L) + 62167219200L;
                d = Jdk8Methods.m43173d(longValue, 315569520000L) + 1;
                a2 = LocalDateTime.a(Jdk8Methods.m43174e(longValue, 315569520000L) - 62167219200L, 0, ZoneOffset.d);
                if (d > 0) {
                    stringBuilder2.append('+');
                    stringBuilder2.append(d);
                }
                stringBuilder2.append(a2);
                if (a2.e.g == (byte) 0) {
                    stringBuilder2.append(":00");
                }
            } else {
                longValue += 62167219200L;
                d = longValue / 315569520000L;
                longValue %= 315569520000L;
                a2 = LocalDateTime.a(longValue - 62167219200L, 0, ZoneOffset.d);
                int length = stringBuilder.length();
                stringBuilder2.append(a2);
                if (a2.e.g == (byte) 0) {
                    stringBuilder2.append(":00");
                }
                if (d < 0) {
                    if (a2.d.d == -10000) {
                        stringBuilder2.replace(length, length + 2, Long.toString(d - 1));
                    } else if (longValue == 0) {
                        stringBuilder2.insert(length, d);
                    } else {
                        stringBuilder2.insert(length + 1, Math.abs(d));
                    }
                }
            }
            if (instantPrinterParser.f41436a == -2) {
                if (b != 0) {
                    stringBuilder2.append('.');
                    if (b % 1000000 == 0) {
                        stringBuilder2.append(Integer.toString((b / 1000000) + 1000).substring(1));
                    } else if (b % 1000 == 0) {
                        stringBuilder2.append(Integer.toString((b / 1000) + 1000000).substring(1));
                    } else {
                        stringBuilder2.append(Integer.toString(b + 1000000000).substring(1));
                    }
                }
            } else if (instantPrinterParser.f41436a > 0 || (instantPrinterParser.f41436a == -1 && b > 0)) {
                stringBuilder2.append('.');
                int i2 = 100000000;
                while (true) {
                    if ((instantPrinterParser.f41436a != -1 || b <= 0) && i >= instantPrinterParser.f41436a) {
                        break;
                    }
                    int i3 = b / i2;
                    stringBuilder2.append((char) (i3 + 48));
                    b -= i3 * i2;
                    i2 /= 10;
                    i++;
                }
            }
            stringBuilder2.append('Z');
            return true;
        }
    }

    static final class LocalizedOffsetPrinterParser implements DateTimePrinterParser {
        private final TextStyle f41437a;

        public LocalizedOffsetPrinterParser(TextStyle textStyle) {
            this.f41437a = textStyle;
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            Long a = dateTimePrintContext.m43156a(ChronoField.OFFSET_SECONDS);
            if (a == null) {
                return null;
            }
            stringBuilder.append("GMT");
            if (this.f41437a == TextStyle.FULL) {
                return new OffsetIdPrinterParser("", "+HH:MM:ss").mo7850a(dateTimePrintContext, stringBuilder);
            }
            dateTimePrintContext = Jdk8Methods.m43165a(a.longValue());
            if (dateTimePrintContext != null) {
                int abs = Math.abs((dateTimePrintContext / 3600) % 100);
                int abs2 = Math.abs((dateTimePrintContext / 60) % 60);
                int abs3 = Math.abs(dateTimePrintContext % 60);
                stringBuilder.append(dateTimePrintContext < null ? Operation.MINUS : Operation.PLUS);
                stringBuilder.append(abs);
                if (abs2 > 0 || abs3 > 0) {
                    stringBuilder.append(":");
                    stringBuilder.append((char) ((abs2 / 10) + 48));
                    stringBuilder.append((char) ((abs2 % 10) + 48));
                    if (abs3 > 0) {
                        stringBuilder.append(":");
                        stringBuilder.append((char) ((abs3 / 10) + 48));
                        stringBuilder.append((char) ((abs3 % 10) + 48));
                    }
                }
            }
            return true;
        }
    }

    static class NumberPrinterParser implements DateTimePrinterParser {
        static final int[] f41438a = new int[]{0, 10, 100, 1000, AbstractSpiCall.DEFAULT_TIMEOUT, 100000, 1000000, 10000000, 100000000, 1000000000};
        final TemporalField f41439b;
        final int f41440c;
        final int f41441d;
        final SignStyle f41442e;
        final int f41443f;

        long mo7921a(DateTimePrintContext dateTimePrintContext, long j) {
            return j;
        }

        NumberPrinterParser(TemporalField temporalField, int i, int i2, SignStyle signStyle) {
            this.f41439b = temporalField;
            this.f41440c = i;
            this.f41441d = i2;
            this.f41442e = signStyle;
            this.f41443f = null;
        }

        private NumberPrinterParser(TemporalField temporalField, int i, int i2, SignStyle signStyle, int i3) {
            this.f41439b = temporalField;
            this.f41440c = i;
            this.f41441d = i2;
            this.f41442e = signStyle;
            this.f41443f = i3;
        }

        NumberPrinterParser mo7922a() {
            if (this.f41443f == -1) {
                return this;
            }
            return new NumberPrinterParser(this.f41439b, this.f41440c, this.f41441d, this.f41442e, -1);
        }

        NumberPrinterParser mo7923a(int i) {
            return new NumberPrinterParser(this.f41439b, this.f41440c, this.f41441d, this.f41442e, this.f41443f + i);
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            Long a = dateTimePrintContext.m43156a(this.f41439b);
            int i = 0;
            if (a == null) {
                return false;
            }
            long a2 = mo7921a(dateTimePrintContext, a.longValue());
            dateTimePrintContext = dateTimePrintContext.f41042c;
            String l = a2 == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(a2));
            if (l.length() > this.f41441d) {
                stringBuilder = new StringBuilder("Field ");
                stringBuilder.append(this.f41439b);
                stringBuilder.append(" cannot be printed as the value ");
                stringBuilder.append(a2);
                stringBuilder.append(" exceeds the maximum print width of ");
                stringBuilder.append(this.f41441d);
                throw new DateTimeException(stringBuilder.toString());
            }
            l = dateTimePrintContext.m43161a(l);
            if (a2 < 0) {
                switch (this.f41442e) {
                    case EXCEEDS_PAD:
                    case ALWAYS:
                    case NORMAL:
                        stringBuilder.append(dateTimePrintContext.f41048d);
                        break;
                    case NOT_NEGATIVE:
                        stringBuilder = new StringBuilder("Field ");
                        stringBuilder.append(this.f41439b);
                        stringBuilder.append(" cannot be printed as the value ");
                        stringBuilder.append(a2);
                        stringBuilder.append(" cannot be negative according to the SignStyle");
                        throw new DateTimeException(stringBuilder.toString());
                    default:
                        break;
                }
            }
            switch (this.f41442e) {
                case EXCEEDS_PAD:
                    if (this.f41440c < 19 && a2 >= ((long) f41438a[this.f41440c])) {
                        stringBuilder.append(dateTimePrintContext.f41047c);
                        break;
                    }
                case ALWAYS:
                    stringBuilder.append(dateTimePrintContext.f41047c);
                    break;
                default:
                    break;
            }
            while (i < this.f41440c - l.length()) {
                stringBuilder.append(dateTimePrintContext.f41046b);
                i++;
            }
            stringBuilder.append(l);
            return true;
        }

        public String toString() {
            StringBuilder stringBuilder;
            if (this.f41440c == 1 && this.f41441d == 19 && this.f41442e == SignStyle.NORMAL) {
                stringBuilder = new StringBuilder("Value(");
                stringBuilder.append(this.f41439b);
                stringBuilder.append(")");
                return stringBuilder.toString();
            } else if (this.f41440c == this.f41441d && this.f41442e == SignStyle.NOT_NEGATIVE) {
                stringBuilder = new StringBuilder("Value(");
                stringBuilder.append(this.f41439b);
                stringBuilder.append(",");
                stringBuilder.append(this.f41440c);
                stringBuilder.append(")");
                return stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder("Value(");
                stringBuilder.append(this.f41439b);
                stringBuilder.append(",");
                stringBuilder.append(this.f41440c);
                stringBuilder.append(",");
                stringBuilder.append(this.f41441d);
                stringBuilder.append(",");
                stringBuilder.append(this.f41442e);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        }
    }

    static final class OffsetIdPrinterParser implements DateTimePrinterParser {
        static final String[] f41444a = new String[]{"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
        static final OffsetIdPrinterParser f41445b = new OffsetIdPrinterParser("Z", "+HH:MM:ss");
        private final String f41446c;
        private final int f41447d;

        OffsetIdPrinterParser(String str, String str2) {
            Jdk8Methods.m43168a((Object) str, "noOffsetText");
            Jdk8Methods.m43168a((Object) str2, "pattern");
            this.f41446c = str;
            this.f41447d = m43580a(str2);
        }

        private static int m43580a(String str) {
            for (int i = 0; i < f41444a.length; i++) {
                if (f41444a[i].equals(str)) {
                    return i;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Invalid zone offset pattern: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            dateTimePrintContext = dateTimePrintContext.m43156a(ChronoField.OFFSET_SECONDS);
            if (dateTimePrintContext == null) {
                return null;
            }
            dateTimePrintContext = Jdk8Methods.m43165a(dateTimePrintContext.longValue());
            if (dateTimePrintContext == null) {
                stringBuilder.append(this.f41446c);
            } else {
                int abs = Math.abs((dateTimePrintContext / 3600) % 100);
                int abs2 = Math.abs((dateTimePrintContext / 60) % 60);
                int abs3 = Math.abs(dateTimePrintContext % 60);
                int length = stringBuilder.length();
                stringBuilder.append(dateTimePrintContext < null ? Operation.MINUS : Operation.PLUS);
                stringBuilder.append((char) ((abs / 10) + 48));
                stringBuilder.append((char) ((abs % 10) + 48));
                if (this.f41447d >= 3 || (this.f41447d > null && abs2 > 0)) {
                    stringBuilder.append(this.f41447d % 2 == null ? ":" : "");
                    stringBuilder.append((char) ((abs2 / 10) + 48));
                    stringBuilder.append((char) ((abs2 % 10) + 48));
                    abs += abs2;
                    if (this.f41447d >= 7 || (this.f41447d >= 5 && abs3 > 0)) {
                        stringBuilder.append(this.f41447d % 2 == null ? ":" : "");
                        stringBuilder.append((char) ((abs3 / 10) + 48));
                        stringBuilder.append((char) ((abs3 % 10) + 48));
                        abs += abs3;
                    }
                }
                if (abs == 0) {
                    stringBuilder.setLength(length);
                    stringBuilder.append(this.f41446c);
                }
            }
            return true;
        }

        public final String toString() {
            String replace = this.f41446c.replace("'", "''");
            StringBuilder stringBuilder = new StringBuilder("Offset(");
            stringBuilder.append(f41444a[this.f41447d]);
            stringBuilder.append(",'");
            stringBuilder.append(replace);
            stringBuilder.append("')");
            return stringBuilder.toString();
        }
    }

    static final class PadPrinterParserDecorator implements DateTimePrinterParser {
        private final DateTimePrinterParser f41448a;
        private final int f41449b;
        private final char f41450c;

        PadPrinterParserDecorator(DateTimePrinterParser dateTimePrinterParser, int i, char c) {
            this.f41448a = dateTimePrinterParser;
            this.f41449b = i;
            this.f41450c = c;
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            int length = stringBuilder.length();
            int i = 0;
            if (this.f41448a.mo7850a(dateTimePrintContext, stringBuilder) == null) {
                return false;
            }
            dateTimePrintContext = stringBuilder.length() - length;
            if (dateTimePrintContext > this.f41449b) {
                StringBuilder stringBuilder2 = new StringBuilder("Cannot print as output of ");
                stringBuilder2.append(dateTimePrintContext);
                stringBuilder2.append(" characters exceeds pad width of ");
                stringBuilder2.append(this.f41449b);
                throw new DateTimeException(stringBuilder2.toString());
            }
            while (i < this.f41449b - dateTimePrintContext) {
                stringBuilder.insert(length, this.f41450c);
                i++;
            }
            return true;
        }

        public final String toString() {
            String str;
            StringBuilder stringBuilder = new StringBuilder("Pad(");
            stringBuilder.append(this.f41448a);
            stringBuilder.append(",");
            stringBuilder.append(this.f41449b);
            if (this.f41450c == ' ') {
                str = ")";
            } else {
                StringBuilder stringBuilder2 = new StringBuilder(",'");
                stringBuilder2.append(this.f41450c);
                stringBuilder2.append("')");
                str = stringBuilder2.toString();
            }
            stringBuilder.append(str);
            return stringBuilder.toString();
        }
    }

    enum SettingsParser implements DateTimePrinterParser {
        SENSITIVE,
        INSENSITIVE,
        STRICT,
        LENIENT;

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            return true;
        }

        public final String toString() {
            switch (ordinal()) {
                case 0:
                    return "ParseCaseSensitive(true)";
                case 1:
                    return "ParseCaseSensitive(false)";
                case 2:
                    return "ParseStrict(true)";
                case 3:
                    return "ParseStrict(false)";
                default:
                    throw new IllegalStateException("Unreachable");
            }
        }
    }

    static final class StringLiteralPrinterParser implements DateTimePrinterParser {
        private final String f41456a;

        StringLiteralPrinterParser(String str) {
            this.f41456a = str;
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            stringBuilder.append(this.f41456a);
            return true;
        }

        public final String toString() {
            String replace = this.f41456a.replace("'", "''");
            StringBuilder stringBuilder = new StringBuilder("'");
            stringBuilder.append(replace);
            stringBuilder.append("'");
            return stringBuilder.toString();
        }
    }

    static final class TextPrinterParser implements DateTimePrinterParser {
        private final TemporalField f41457a;
        private final TextStyle f41458b;
        private final DateTimeTextProvider f41459c;
        private volatile NumberPrinterParser f41460d;

        TextPrinterParser(TemporalField temporalField, TextStyle textStyle, DateTimeTextProvider dateTimeTextProvider) {
            this.f41457a = temporalField;
            this.f41458b = textStyle;
            this.f41459c = dateTimeTextProvider;
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            Long a = dateTimePrintContext.m43156a(this.f41457a);
            if (a == null) {
                return null;
            }
            String a2 = this.f41459c.mo7849a(this.f41457a, a.longValue(), this.f41458b, dateTimePrintContext.f41041b);
            if (a2 == null) {
                if (this.f41460d == null) {
                    this.f41460d = new NumberPrinterParser(this.f41457a, 1, 19, SignStyle.NORMAL);
                }
                return this.f41460d.mo7850a(dateTimePrintContext, stringBuilder);
            }
            stringBuilder.append(a2);
            return true;
        }

        public final String toString() {
            if (this.f41458b == TextStyle.FULL) {
                StringBuilder stringBuilder = new StringBuilder("Text(");
                stringBuilder.append(this.f41457a);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder("Text(");
            stringBuilder.append(this.f41457a);
            stringBuilder.append(",");
            stringBuilder.append(this.f41458b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static final class WeekFieldsPrinterParser implements DateTimePrinterParser {
        private final char f41461a;
        private final int f41462b;

        public WeekFieldsPrinterParser(char c, int i) {
            this.f41461a = c;
            this.f41462b = i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(30);
            stringBuilder.append("Localized(");
            if (this.f41461a != 'Y') {
                if (this.f41461a != 'c') {
                    if (this.f41461a != 'e') {
                        if (this.f41461a == 'w') {
                            stringBuilder.append("WeekOfWeekBasedYear");
                        } else if (this.f41461a == 'W') {
                            stringBuilder.append("WeekOfMonth");
                        }
                        stringBuilder.append(",");
                        stringBuilder.append(this.f41462b);
                    }
                }
                stringBuilder.append("DayOfWeek");
                stringBuilder.append(",");
                stringBuilder.append(this.f41462b);
            } else if (this.f41462b == 1) {
                stringBuilder.append("WeekBasedYear");
            } else if (this.f41462b == 2) {
                stringBuilder.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
            } else {
                stringBuilder.append("WeekBasedYear,");
                stringBuilder.append(this.f41462b);
                stringBuilder.append(",19,");
                stringBuilder.append(this.f41462b < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD);
            }
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            DateTimePrinterParser numberPrinterParser;
            WeekFields a = WeekFields.m43207a(dateTimePrintContext.f41041b);
            char c = this.f41461a;
            if (c == 'W') {
                numberPrinterParser = new NumberPrinterParser(a.f41093f, 1, 2, SignStyle.NOT_NEGATIVE);
            } else if (c != 'Y') {
                numberPrinterParser = c != 'c' ? c != 'e' ? c != 'w' ? null : new NumberPrinterParser(a.f41094g, this.f41462b, 2, SignStyle.NOT_NEGATIVE) : new NumberPrinterParser(a.f41092e, this.f41462b, 2, SignStyle.NOT_NEGATIVE) : new NumberPrinterParser(a.f41092e, this.f41462b, 2, SignStyle.NOT_NEGATIVE);
            } else if (this.f41462b == 2) {
                numberPrinterParser = new ReducedPrinterParser(a.f41095h, ReducedPrinterParser.f41850g);
            } else {
                DateTimePrinterParser numberPrinterParser2 = new NumberPrinterParser(a.f41095h, this.f41462b, 19, this.f41462b < 4 ? SignStyle.NORMAL : SignStyle.EXCEEDS_PAD, -1);
            }
            return numberPrinterParser.mo7850a(dateTimePrintContext, stringBuilder);
        }
    }

    static final class ZoneIdPrinterParser implements DateTimePrinterParser {
        private final TemporalQuery<ZoneId> f41463a;
        private final String f41464b;

        ZoneIdPrinterParser(TemporalQuery<ZoneId> temporalQuery, String str) {
            this.f41463a = temporalQuery;
            this.f41464b = str;
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.m43157a(this.f41463a);
            if (zoneId == null) {
                return null;
            }
            stringBuilder.append(zoneId.b());
            return true;
        }

        public final String toString() {
            return this.f41464b;
        }
    }

    static final class ZoneTextPrinterParser implements DateTimePrinterParser {
        private static final Comparator<String> f41465a = new C30571();
        private final TextStyle f41466b;

        static class C30571 implements Comparator<String> {
            C30571() {
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                int length = str2.length() - str.length();
                return length == 0 ? str.compareTo(str2) : length;
            }
        }

        ZoneTextPrinterParser(TextStyle textStyle) {
            this.f41466b = (TextStyle) Jdk8Methods.m43168a((Object) textStyle, "textStyle");
        }

        public final boolean mo7850a(DateTimePrintContext dateTimePrintContext, StringBuilder stringBuilder) {
            ZoneId zoneId = (ZoneId) dateTimePrintContext.m43157a(TemporalQueries.m43190a());
            int i = 0;
            if (zoneId == null) {
                return false;
            }
            if (zoneId.d() instanceof ZoneOffset) {
                stringBuilder.append(zoneId.b());
                return true;
            }
            boolean b;
            TemporalAccessor temporalAccessor = dateTimePrintContext.f41040a;
            if (temporalAccessor.mo7919a(ChronoField.INSTANT_SECONDS)) {
                b = zoneId.c().mo7869b(Instant.a(temporalAccessor.mo7920d(ChronoField.INSTANT_SECONDS)));
            } else {
                b = false;
            }
            TimeZone timeZone = TimeZone.getTimeZone(zoneId.b());
            if (TextStyle.values()[this.f41466b.ordinal() & -2] == TextStyle.FULL) {
                i = 1;
            }
            stringBuilder.append(timeZone.getDisplayName(b, i, dateTimePrintContext.f41041b));
            return true;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("ZoneText(");
            stringBuilder.append(this.f41466b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    static final class ReducedPrinterParser extends NumberPrinterParser {
        static final LocalDate f41850g = LocalDate.a(CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, 1, 1);
        private final int f41851h;
        private final ChronoLocalDate f41852i;

        ReducedPrinterParser(TemporalField temporalField, ChronoLocalDate chronoLocalDate) {
            super(temporalField, 2, 2, SignStyle.NOT_NEGATIVE);
            if (chronoLocalDate == null) {
                if (temporalField.mo7855a().m43204a(0) == null) {
                    throw new IllegalArgumentException("The base value must be within the range of the field");
                } else if (0 + ((long) a[2]) > 2147483647L) {
                    throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
                }
            }
            this.f41851h = null;
            this.f41852i = chronoLocalDate;
        }

        private ReducedPrinterParser(TemporalField temporalField, int i, int i2, int i3, ChronoLocalDate chronoLocalDate, int i4) {
            super(temporalField, i, i2, SignStyle.NOT_NEGATIVE, i4);
            this.f41851h = i3;
            this.f41852i = chronoLocalDate;
        }

        final long mo7921a(DateTimePrintContext dateTimePrintContext, long j) {
            long abs = Math.abs(j);
            int i = this.f41851h;
            if (this.f41852i != null) {
                i = Chronology.m43116a(dateTimePrintContext.f41040a).mo7847b(this.f41852i).mo7853c(this.b);
            }
            if (j < ((long) i) || j >= ((long) (i + a[this.c]))) {
                return abs % ((long) a[this.d]);
            }
            return abs % ((long) a[this.c]);
        }

        final NumberPrinterParser mo7922a() {
            if (this.f == -1) {
                return this;
            }
            return new ReducedPrinterParser(this.b, this.c, this.d, this.f41851h, this.f41852i, -1);
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("ReducedValue(");
            stringBuilder.append(this.b);
            stringBuilder.append(",");
            stringBuilder.append(this.c);
            stringBuilder.append(",");
            stringBuilder.append(this.d);
            stringBuilder.append(",");
            stringBuilder.append(this.f41852i != null ? this.f41852i : Integer.valueOf(this.f41851h));
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        final /* synthetic */ NumberPrinterParser mo7923a(int i) {
            return new ReducedPrinterParser(this.b, this.c, this.d, this.f41851h, this.f41852i, this.f + i);
        }
    }

    static {
        Map hashMap = new HashMap();
        f41032j = hashMap;
        hashMap.put(Character.valueOf('G'), ChronoField.ERA);
        f41032j.put(Character.valueOf('y'), ChronoField.YEAR_OF_ERA);
        f41032j.put(Character.valueOf('u'), ChronoField.YEAR);
        f41032j.put(Character.valueOf('Q'), IsoFields.f41071b);
        f41032j.put(Character.valueOf('q'), IsoFields.f41071b);
        f41032j.put(Character.valueOf('M'), ChronoField.MONTH_OF_YEAR);
        f41032j.put(Character.valueOf('L'), ChronoField.MONTH_OF_YEAR);
        f41032j.put(Character.valueOf('D'), ChronoField.DAY_OF_YEAR);
        f41032j.put(Character.valueOf('d'), ChronoField.DAY_OF_MONTH);
        f41032j.put(Character.valueOf('F'), ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        f41032j.put(Character.valueOf('E'), ChronoField.DAY_OF_WEEK);
        f41032j.put(Character.valueOf('c'), ChronoField.DAY_OF_WEEK);
        f41032j.put(Character.valueOf('e'), ChronoField.DAY_OF_WEEK);
        f41032j.put(Character.valueOf('a'), ChronoField.AMPM_OF_DAY);
        f41032j.put(Character.valueOf('H'), ChronoField.HOUR_OF_DAY);
        f41032j.put(Character.valueOf('k'), ChronoField.CLOCK_HOUR_OF_DAY);
        f41032j.put(Character.valueOf('K'), ChronoField.HOUR_OF_AMPM);
        f41032j.put(Character.valueOf('h'), ChronoField.CLOCK_HOUR_OF_AMPM);
        f41032j.put(Character.valueOf('m'), ChronoField.MINUTE_OF_HOUR);
        f41032j.put(Character.valueOf('s'), ChronoField.SECOND_OF_MINUTE);
        f41032j.put(Character.valueOf('S'), ChronoField.NANO_OF_SECOND);
        f41032j.put(Character.valueOf('A'), ChronoField.MILLI_OF_DAY);
        f41032j.put(Character.valueOf('n'), ChronoField.NANO_OF_SECOND);
        f41032j.put(Character.valueOf('N'), ChronoField.NANO_OF_DAY);
    }

    public DateTimeFormatterBuilder() {
        this.f41033c = this;
        this.f41035e = new ArrayList();
        this.f41039i = -1;
        this.f41034d = null;
        this.f41036f = false;
    }

    private DateTimeFormatterBuilder(DateTimeFormatterBuilder dateTimeFormatterBuilder) {
        this.f41033c = this;
        this.f41035e = new ArrayList();
        this.f41039i = -1;
        this.f41034d = dateTimeFormatterBuilder;
        this.f41036f = true;
    }

    public final DateTimeFormatterBuilder m43140a() {
        m43137a(SettingsParser.SENSITIVE);
        return this;
    }

    public final DateTimeFormatterBuilder m43149b() {
        m43137a(SettingsParser.INSENSITIVE);
        return this;
    }

    private DateTimeFormatterBuilder m43134a(TemporalField temporalField) {
        Jdk8Methods.m43168a((Object) temporalField, "field");
        m43132a(new NumberPrinterParser(temporalField, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public final DateTimeFormatterBuilder m43145a(TemporalField temporalField, int i) {
        Jdk8Methods.m43168a((Object) temporalField, "field");
        if (i > 0) {
            if (i <= 19) {
                m43132a(new NumberPrinterParser(temporalField, i, i, SignStyle.NOT_NEGATIVE));
                return this;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("The width must be from 1 to 19 inclusive but was ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final DateTimeFormatterBuilder m43146a(TemporalField temporalField, int i, int i2, SignStyle signStyle) {
        if (i == i2 && signStyle == SignStyle.NOT_NEGATIVE) {
            return m43145a(temporalField, i2);
        }
        Jdk8Methods.m43168a((Object) temporalField, "field");
        Jdk8Methods.m43168a((Object) signStyle, "signStyle");
        if (i > 0) {
            if (i <= 19) {
                if (i2 > 0) {
                    if (i2 <= 19) {
                        if (i2 < i) {
                            signStyle = new StringBuilder("The maximum width must exceed or equal the minimum width but ");
                            signStyle.append(i2);
                            signStyle.append(" < ");
                            signStyle.append(i);
                            throw new IllegalArgumentException(signStyle.toString());
                        }
                        m43132a(new NumberPrinterParser(temporalField, i, i2, signStyle));
                        return this;
                    }
                }
                i = new StringBuilder("The maximum width must be from 1 to 19 inclusive but was ");
                i.append(i2);
                throw new IllegalArgumentException(i.toString());
            }
        }
        i2 = new StringBuilder("The minimum width must be from 1 to 19 inclusive but was ");
        i2.append(i);
        throw new IllegalArgumentException(i2.toString());
    }

    private DateTimeFormatterBuilder m43132a(NumberPrinterParser numberPrinterParser) {
        if (this.f41033c.f41039i < 0 || !(this.f41033c.f41035e.get(this.f41033c.f41039i) instanceof NumberPrinterParser)) {
            this.f41033c.f41039i = m43137a((DateTimePrinterParser) numberPrinterParser);
        } else {
            Object a;
            int i = this.f41033c.f41039i;
            NumberPrinterParser numberPrinterParser2 = (NumberPrinterParser) this.f41033c.f41035e.get(i);
            if (numberPrinterParser.f41440c == numberPrinterParser.f41441d && numberPrinterParser.f41442e == SignStyle.NOT_NEGATIVE) {
                a = numberPrinterParser2.mo7923a(numberPrinterParser.f41441d);
                m43137a(numberPrinterParser.mo7922a());
                this.f41033c.f41039i = i;
            } else {
                a = numberPrinterParser2.mo7922a();
                this.f41033c.f41039i = m43137a((DateTimePrinterParser) numberPrinterParser);
            }
            this.f41033c.f41035e.set(i, a);
        }
        return this;
    }

    public final DateTimeFormatterBuilder m43147a(TemporalField temporalField, int i, int i2, boolean z) {
        m43137a(new FractionPrinterParser(temporalField, i, i2, z));
        return this;
    }

    private DateTimeFormatterBuilder m43135a(TemporalField temporalField, TextStyle textStyle) {
        Jdk8Methods.m43168a((Object) temporalField, "field");
        Jdk8Methods.m43168a((Object) textStyle, "textStyle");
        m43137a(new TextPrinterParser(temporalField, textStyle, DateTimeTextProvider.m43159a()));
        return this;
    }

    public final DateTimeFormatterBuilder m43148a(TemporalField temporalField, Map<Long, String> map) {
        Jdk8Methods.m43168a((Object) temporalField, "field");
        Jdk8Methods.m43168a((Object) map, "textLookup");
        final LocaleStore localeStore = new LocaleStore(Collections.singletonMap(TextStyle.FULL, new LinkedHashMap(map)));
        m43137a(new TextPrinterParser(temporalField, TextStyle.FULL, new DateTimeTextProvider(this) {
            final /* synthetic */ DateTimeFormatterBuilder f41428b;

            public final String mo7849a(TemporalField temporalField, long j, TextStyle textStyle, Locale locale) {
                return localeStore.m43162a(j, textStyle);
            }
        }));
        return this;
    }

    public final DateTimeFormatterBuilder m43151c() {
        m43137a(OffsetIdPrinterParser.f41445b);
        return this;
    }

    public final DateTimeFormatterBuilder m43143a(String str, String str2) {
        m43137a(new OffsetIdPrinterParser(str2, str));
        return this;
    }

    private DateTimeFormatterBuilder m43133a(TextStyle textStyle) {
        Jdk8Methods.m43168a((Object) textStyle, "style");
        if (textStyle == TextStyle.FULL || textStyle == TextStyle.SHORT) {
            m43137a(new LocalizedOffsetPrinterParser(textStyle));
            return this;
        }
        throw new IllegalArgumentException("Style must be either full or short");
    }

    public final DateTimeFormatterBuilder m43152d() {
        m43137a(new ZoneIdPrinterParser(f41031b, "ZoneRegionId()"));
        return this;
    }

    private DateTimeFormatterBuilder m43136b(TextStyle textStyle) {
        m43137a(new ZoneTextPrinterParser(textStyle));
        return this;
    }

    public final DateTimeFormatterBuilder m43141a(char c) {
        m43137a(new CharLiteralPrinterParser(c));
        return this;
    }

    public final DateTimeFormatterBuilder m43142a(String str) {
        Jdk8Methods.m43168a((Object) str, "literal");
        if (str.length() > 0) {
            if (str.length() == 1) {
                m43137a(new CharLiteralPrinterParser(str.charAt(0)));
            } else {
                m43137a(new StringLiteralPrinterParser(str));
            }
        }
        return this;
    }

    public final DateTimeFormatterBuilder m43144a(DateTimeFormatter dateTimeFormatter) {
        Jdk8Methods.m43168a((Object) dateTimeFormatter, "formatter");
        DateTimePrinterParser dateTimePrinterParser = dateTimeFormatter.f41022p;
        if (dateTimePrinterParser.f41431b) {
            dateTimePrinterParser = new CompositePrinterParser(dateTimePrinterParser.f41430a, false);
        }
        m43137a(dateTimePrinterParser);
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.threeten.bp.format.DateTimeFormatterBuilder m43150b(java.lang.String r12) {
        /*
        r11 = this;
        r0 = "pattern";
        org.threeten.bp.jdk8.Jdk8Methods.m43168a(r12, r0);
        r0 = 0;
        r1 = r0;
    L_0x0007:
        r2 = r12.length();
        if (r1 >= r2) goto L_0x04b0;
    L_0x000d:
        r2 = r12.charAt(r1);
        r3 = 97;
        r4 = 65;
        r5 = 122; // 0x7a float:1.71E-43 double:6.03E-322;
        r6 = 90;
        r7 = 1;
        if (r2 < r4) goto L_0x001e;
    L_0x001c:
        if (r2 <= r6) goto L_0x0022;
    L_0x001e:
        if (r2 < r3) goto L_0x040d;
    L_0x0020:
        if (r2 > r5) goto L_0x040d;
    L_0x0022:
        r8 = r1 + 1;
    L_0x0024:
        r9 = r12.length();
        if (r8 >= r9) goto L_0x0033;
    L_0x002a:
        r9 = r12.charAt(r8);
        if (r9 != r2) goto L_0x0033;
    L_0x0030:
        r8 = r8 + 1;
        goto L_0x0024;
    L_0x0033:
        r1 = r8 - r1;
        r9 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r10 = -1;
        if (r2 != r9) goto L_0x009e;
    L_0x003a:
        r9 = r12.length();
        if (r8 >= r9) goto L_0x0061;
    L_0x0040:
        r2 = r12.charAt(r8);
        if (r2 < r4) goto L_0x0048;
    L_0x0046:
        if (r2 <= r6) goto L_0x004c;
    L_0x0048:
        if (r2 < r3) goto L_0x0061;
    L_0x004a:
        if (r2 > r5) goto L_0x0061;
    L_0x004c:
        r3 = r8 + 1;
    L_0x004e:
        r4 = r12.length();
        if (r3 >= r4) goto L_0x005d;
    L_0x0054:
        r4 = r12.charAt(r3);
        if (r4 != r2) goto L_0x005d;
    L_0x005a:
        r3 = r3 + 1;
        goto L_0x004e;
    L_0x005d:
        r4 = r3 - r8;
        r8 = r3;
        goto L_0x0063;
    L_0x0061:
        r4 = r1;
        r1 = r0;
    L_0x0063:
        if (r1 != 0) goto L_0x0079;
    L_0x0065:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "Pad letter 'p' must be followed by valid pad pattern: ";
        r1.<init>(r2);
        r1.append(r12);
        r12 = r1.toString();
        r0.<init>(r12);
        throw r0;
    L_0x0079:
        if (r1 > 0) goto L_0x008f;
    L_0x007b:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r2 = "The pad width must be at least one but was ";
        r0.<init>(r2);
        r0.append(r1);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x008f:
        r3 = r11.f41033c;
        r3.f41037g = r1;
        r1 = r11.f41033c;
        r3 = 32;
        r1.f41038h = r3;
        r1 = r11.f41033c;
        r1.f41039i = r10;
        r1 = r4;
    L_0x009e:
        r3 = f41032j;
        r4 = java.lang.Character.valueOf(r2);
        r3 = r3.get(r4);
        r3 = (org.threeten.bp.temporal.TemporalField) r3;
        r4 = 4;
        r9 = 2;
        if (r3 == 0) goto L_0x0290;
    L_0x00ae:
        switch(r2) {
            case 68: goto L_0x026d;
            case 69: goto L_0x0241;
            case 70: goto L_0x0226;
            case 71: goto L_0x0241;
            case 72: goto L_0x0204;
            default: goto L_0x00b1;
        };
    L_0x00b1:
        switch(r2) {
            case 75: goto L_0x0204;
            case 76: goto L_0x01ce;
            case 77: goto L_0x0198;
            default: goto L_0x00b4;
        };
    L_0x00b4:
        switch(r2) {
            case 99: goto L_0x014c;
            case 100: goto L_0x0204;
            case 101: goto L_0x0114;
            default: goto L_0x00b7;
        };
    L_0x00b7:
        switch(r2) {
            case 81: goto L_0x0198;
            case 83: goto L_0x010d;
            case 97: goto L_0x00f0;
            case 104: goto L_0x0204;
            case 107: goto L_0x0204;
            case 109: goto L_0x0204;
            case 113: goto L_0x01ce;
            case 115: goto L_0x0204;
            case 117: goto L_0x00c6;
            case 121: goto L_0x00c6;
            default: goto L_0x00ba;
        };
    L_0x00ba:
        if (r1 != r7) goto L_0x00c1;
    L_0x00bc:
        r11.m43134a(r3);
        goto L_0x03f5;
    L_0x00c1:
        r11.m43145a(r3, r1);
        goto L_0x03f5;
    L_0x00c6:
        if (r1 != r9) goto L_0x00de;
    L_0x00c8:
        r1 = org.threeten.bp.format.DateTimeFormatterBuilder.ReducedPrinterParser.f41850g;
        r2 = "field";
        org.threeten.bp.jdk8.Jdk8Methods.m43168a(r3, r2);
        r2 = "baseDate";
        org.threeten.bp.jdk8.Jdk8Methods.m43168a(r1, r2);
        r2 = new org.threeten.bp.format.DateTimeFormatterBuilder$ReducedPrinterParser;
        r2.<init>(r3, r1);
        r11.m43132a(r2);
        goto L_0x03f5;
    L_0x00de:
        r2 = 19;
        if (r1 >= r4) goto L_0x00e9;
    L_0x00e2:
        r4 = org.threeten.bp.format.SignStyle.NORMAL;
        r11.m43146a(r3, r1, r2, r4);
        goto L_0x03f5;
    L_0x00e9:
        r4 = org.threeten.bp.format.SignStyle.EXCEEDS_PAD;
        r11.m43146a(r3, r1, r2, r4);
        goto L_0x03f5;
    L_0x00f0:
        if (r1 != r7) goto L_0x00f9;
    L_0x00f2:
        r1 = org.threeten.bp.format.TextStyle.SHORT;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x00f9:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x010d:
        r2 = org.threeten.bp.temporal.ChronoField.NANO_OF_SECOND;
        r11.m43147a(r2, r1, r1, r0);
        goto L_0x03f5;
    L_0x0114:
        switch(r1) {
            case 1: goto L_0x0140;
            case 2: goto L_0x0140;
            case 3: goto L_0x0139;
            case 4: goto L_0x0132;
            case 5: goto L_0x012b;
            default: goto L_0x0117;
        };
    L_0x0117:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x012b:
        r1 = org.threeten.bp.format.TextStyle.NARROW;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x0132:
        r1 = org.threeten.bp.format.TextStyle.FULL;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x0139:
        r1 = org.threeten.bp.format.TextStyle.SHORT;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x0140:
        r2 = new org.threeten.bp.format.DateTimeFormatterBuilder$WeekFieldsPrinterParser;
        r3 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        r2.<init>(r3, r1);
        r11.m43137a(r2);
        goto L_0x03f5;
    L_0x014c:
        switch(r1) {
            case 1: goto L_0x018c;
            case 2: goto L_0x0178;
            case 3: goto L_0x0171;
            case 4: goto L_0x016a;
            case 5: goto L_0x0163;
            default: goto L_0x014f;
        };
    L_0x014f:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x0163:
        r1 = org.threeten.bp.format.TextStyle.NARROW_STANDALONE;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x016a:
        r1 = org.threeten.bp.format.TextStyle.FULL_STANDALONE;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x0171:
        r1 = org.threeten.bp.format.TextStyle.SHORT_STANDALONE;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x0178:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Invalid number of pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x018c:
        r2 = new org.threeten.bp.format.DateTimeFormatterBuilder$WeekFieldsPrinterParser;
        r3 = 99;
        r2.<init>(r3, r1);
        r11.m43137a(r2);
        goto L_0x03f5;
    L_0x0198:
        switch(r1) {
            case 1: goto L_0x01c9;
            case 2: goto L_0x01c4;
            case 3: goto L_0x01bd;
            case 4: goto L_0x01b6;
            case 5: goto L_0x01af;
            default: goto L_0x019b;
        };
    L_0x019b:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x01af:
        r1 = org.threeten.bp.format.TextStyle.NARROW;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x01b6:
        r1 = org.threeten.bp.format.TextStyle.FULL;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x01bd:
        r1 = org.threeten.bp.format.TextStyle.SHORT;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x01c4:
        r11.m43145a(r3, r9);
        goto L_0x03f5;
    L_0x01c9:
        r11.m43134a(r3);
        goto L_0x03f5;
    L_0x01ce:
        switch(r1) {
            case 1: goto L_0x01ff;
            case 2: goto L_0x01fa;
            case 3: goto L_0x01f3;
            case 4: goto L_0x01ec;
            case 5: goto L_0x01e5;
            default: goto L_0x01d1;
        };
    L_0x01d1:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x01e5:
        r1 = org.threeten.bp.format.TextStyle.NARROW_STANDALONE;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x01ec:
        r1 = org.threeten.bp.format.TextStyle.FULL_STANDALONE;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x01f3:
        r1 = org.threeten.bp.format.TextStyle.SHORT_STANDALONE;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x01fa:
        r11.m43145a(r3, r9);
        goto L_0x03f5;
    L_0x01ff:
        r11.m43134a(r3);
        goto L_0x03f5;
    L_0x0204:
        if (r1 != r7) goto L_0x020b;
    L_0x0206:
        r11.m43134a(r3);
        goto L_0x03f5;
    L_0x020b:
        if (r1 != r9) goto L_0x0212;
    L_0x020d:
        r11.m43145a(r3, r1);
        goto L_0x03f5;
    L_0x0212:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x0226:
        if (r1 != r7) goto L_0x022d;
    L_0x0228:
        r11.m43134a(r3);
        goto L_0x03f5;
    L_0x022d:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x0241:
        switch(r1) {
            case 1: goto L_0x0266;
            case 2: goto L_0x0266;
            case 3: goto L_0x0266;
            case 4: goto L_0x025f;
            case 5: goto L_0x0258;
            default: goto L_0x0244;
        };
    L_0x0244:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x0258:
        r1 = org.threeten.bp.format.TextStyle.NARROW;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x025f:
        r1 = org.threeten.bp.format.TextStyle.FULL;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x0266:
        r1 = org.threeten.bp.format.TextStyle.SHORT;
        r11.m43135a(r3, r1);
        goto L_0x03f5;
    L_0x026d:
        if (r1 != r7) goto L_0x0274;
    L_0x026f:
        r11.m43134a(r3);
        goto L_0x03f5;
    L_0x0274:
        r4 = 3;
        if (r1 > r4) goto L_0x027c;
    L_0x0277:
        r11.m43145a(r3, r1);
        goto L_0x03f5;
    L_0x027c:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x0290:
        if (r2 != r5) goto L_0x02b8;
    L_0x0292:
        if (r1 <= r4) goto L_0x02a8;
    L_0x0294:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x02a8:
        if (r1 != r4) goto L_0x02b1;
    L_0x02aa:
        r1 = org.threeten.bp.format.TextStyle.FULL;
        r11.m43136b(r1);
        goto L_0x03f5;
    L_0x02b1:
        r1 = org.threeten.bp.format.TextStyle.SHORT;
        r11.m43136b(r1);
        goto L_0x03f5;
    L_0x02b8:
        r3 = 86;
        if (r2 != r3) goto L_0x02e2;
    L_0x02bc:
        if (r1 == r9) goto L_0x02d2;
    L_0x02be:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Pattern letter count must be 2: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x02d2:
        r1 = new org.threeten.bp.format.DateTimeFormatterBuilder$ZoneIdPrinterParser;
        r2 = org.threeten.bp.temporal.TemporalQueries.m43190a();
        r3 = "ZoneId()";
        r1.<init>(r2, r3);
        r11.m43137a(r1);
        goto L_0x03f5;
    L_0x02e2:
        r3 = 5;
        if (r2 != r6) goto L_0x0318;
    L_0x02e5:
        if (r1 >= r4) goto L_0x02f0;
    L_0x02e7:
        r1 = "+HHMM";
        r2 = "+0000";
        r11.m43143a(r1, r2);
        goto L_0x03f5;
    L_0x02f0:
        if (r1 != r4) goto L_0x02f9;
    L_0x02f2:
        r1 = org.threeten.bp.format.TextStyle.FULL;
        r11.m43133a(r1);
        goto L_0x03f5;
    L_0x02f9:
        if (r1 != r3) goto L_0x0304;
    L_0x02fb:
        r1 = "+HH:MM:ss";
        r2 = "Z";
        r11.m43143a(r1, r2);
        goto L_0x03f5;
    L_0x0304:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x0318:
        r5 = 79;
        if (r2 != r5) goto L_0x0342;
    L_0x031c:
        if (r1 != r7) goto L_0x0325;
    L_0x031e:
        r1 = org.threeten.bp.format.TextStyle.SHORT;
        r11.m43133a(r1);
        goto L_0x03f5;
    L_0x0325:
        if (r1 != r4) goto L_0x032e;
    L_0x0327:
        r1 = org.threeten.bp.format.TextStyle.FULL;
        r11.m43133a(r1);
        goto L_0x03f5;
    L_0x032e:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Pattern letter count must be 1 or 4: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x0342:
        r4 = 88;
        if (r2 != r4) goto L_0x036d;
    L_0x0346:
        if (r1 <= r3) goto L_0x035c;
    L_0x0348:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x035c:
        r2 = org.threeten.bp.format.DateTimeFormatterBuilder.OffsetIdPrinterParser.f41444a;
        if (r1 != r7) goto L_0x0362;
    L_0x0360:
        r3 = r0;
        goto L_0x0363;
    L_0x0362:
        r3 = r7;
    L_0x0363:
        r1 = r1 + r3;
        r1 = r2[r1];
        r2 = "Z";
        r11.m43143a(r1, r2);
        goto L_0x03f5;
    L_0x036d:
        r4 = 120; // 0x78 float:1.68E-43 double:5.93E-322;
        if (r2 != r4) goto L_0x03a3;
    L_0x0371:
        if (r1 <= r3) goto L_0x0387;
    L_0x0373:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x0387:
        if (r1 != r7) goto L_0x038c;
    L_0x0389:
        r2 = "+00";
        goto L_0x0395;
    L_0x038c:
        r2 = r1 % 2;
        if (r2 != 0) goto L_0x0393;
    L_0x0390:
        r2 = "+0000";
        goto L_0x0395;
    L_0x0393:
        r2 = "+00:00";
    L_0x0395:
        r3 = org.threeten.bp.format.DateTimeFormatterBuilder.OffsetIdPrinterParser.f41444a;
        if (r1 != r7) goto L_0x039b;
    L_0x0399:
        r4 = r0;
        goto L_0x039c;
    L_0x039b:
        r4 = r7;
    L_0x039c:
        r1 = r1 + r4;
        r1 = r3[r1];
        r11.m43143a(r1, r2);
        goto L_0x03f5;
    L_0x03a3:
        r3 = 87;
        if (r2 != r3) goto L_0x03c6;
    L_0x03a7:
        if (r1 <= r7) goto L_0x03bd;
    L_0x03a9:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x03bd:
        r2 = new org.threeten.bp.format.DateTimeFormatterBuilder$WeekFieldsPrinterParser;
        r2.<init>(r3, r1);
        r11.m43137a(r2);
        goto L_0x03f5;
    L_0x03c6:
        r3 = 119; // 0x77 float:1.67E-43 double:5.9E-322;
        if (r2 != r3) goto L_0x03e9;
    L_0x03ca:
        if (r1 <= r9) goto L_0x03e0;
    L_0x03cc:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Too many pattern letters: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x03e0:
        r2 = new org.threeten.bp.format.DateTimeFormatterBuilder$WeekFieldsPrinterParser;
        r2.<init>(r3, r1);
        r11.m43137a(r2);
        goto L_0x03f5;
    L_0x03e9:
        r3 = 89;
        if (r2 != r3) goto L_0x03f9;
    L_0x03ed:
        r2 = new org.threeten.bp.format.DateTimeFormatterBuilder$WeekFieldsPrinterParser;
        r2.<init>(r3, r1);
        r11.m43137a(r2);
    L_0x03f5:
        r1 = r8 + -1;
        goto L_0x0494;
    L_0x03f9:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Unknown pattern letter: ";
        r0.<init>(r1);
        r0.append(r2);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x040d:
        r3 = 39;
        if (r2 != r3) goto L_0x0466;
    L_0x0411:
        r1 = r1 + 1;
        r2 = r1;
    L_0x0414:
        r4 = r12.length();
        if (r2 >= r4) goto L_0x0431;
    L_0x041a:
        r4 = r12.charAt(r2);
        if (r4 != r3) goto L_0x042f;
    L_0x0420:
        r4 = r2 + 1;
        r5 = r12.length();
        if (r4 >= r5) goto L_0x0431;
    L_0x0428:
        r5 = r12.charAt(r4);
        if (r5 != r3) goto L_0x0431;
    L_0x042e:
        r2 = r4;
    L_0x042f:
        r2 = r2 + r7;
        goto L_0x0414;
    L_0x0431:
        r4 = r12.length();
        if (r2 < r4) goto L_0x044b;
    L_0x0437:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r2 = "Pattern ends with an incomplete string literal: ";
        r1.<init>(r2);
        r1.append(r12);
        r12 = r1.toString();
        r0.<init>(r12);
        throw r0;
    L_0x044b:
        r1 = r12.substring(r1, r2);
        r4 = r1.length();
        if (r4 != 0) goto L_0x0459;
    L_0x0455:
        r11.m43141a(r3);
        goto L_0x0464;
    L_0x0459:
        r3 = "''";
        r4 = "'";
        r1 = r1.replace(r3, r4);
        r11.m43142a(r1);
    L_0x0464:
        r1 = r2;
        goto L_0x0494;
    L_0x0466:
        r3 = 91;
        if (r2 != r3) goto L_0x046e;
    L_0x046a:
        r11.m43153e();
        goto L_0x0494;
    L_0x046e:
        r3 = 93;
        if (r2 != r3) goto L_0x0484;
    L_0x0472:
        r2 = r11.f41033c;
        r2 = r2.f41034d;
        if (r2 != 0) goto L_0x0480;
    L_0x0478:
        r12 = new java.lang.IllegalArgumentException;
        r0 = "Pattern invalid as it contains ] without previous [";
        r12.<init>(r0);
        throw r12;
    L_0x0480:
        r11.m43154f();
        goto L_0x0494;
    L_0x0484:
        r3 = 123; // 0x7b float:1.72E-43 double:6.1E-322;
        if (r2 == r3) goto L_0x0497;
    L_0x0488:
        r3 = 125; // 0x7d float:1.75E-43 double:6.2E-322;
        if (r2 == r3) goto L_0x0497;
    L_0x048c:
        r3 = 35;
        if (r2 != r3) goto L_0x0491;
    L_0x0490:
        goto L_0x0497;
    L_0x0491:
        r11.m43141a(r2);
    L_0x0494:
        r1 = r1 + r7;
        goto L_0x0007;
    L_0x0497:
        r12 = new java.lang.IllegalArgumentException;
        r0 = new java.lang.StringBuilder;
        r1 = "Pattern includes reserved character: '";
        r0.<init>(r1);
        r0.append(r2);
        r1 = "'";
        r0.append(r1);
        r0 = r0.toString();
        r12.<init>(r0);
        throw r12;
    L_0x04b0:
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.format.DateTimeFormatterBuilder.b(java.lang.String):org.threeten.bp.format.DateTimeFormatterBuilder");
    }

    public final DateTimeFormatterBuilder m43153e() {
        this.f41033c.f41039i = -1;
        this.f41033c = new DateTimeFormatterBuilder(this.f41033c);
        return this;
    }

    public final DateTimeFormatterBuilder m43154f() {
        if (this.f41033c.f41034d == null) {
            throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
        }
        if (this.f41033c.f41035e.size() > 0) {
            DateTimePrinterParser compositePrinterParser = new CompositePrinterParser(this.f41033c.f41035e, this.f41033c.f41036f);
            this.f41033c = this.f41033c.f41034d;
            m43137a(compositePrinterParser);
        } else {
            this.f41033c = this.f41033c.f41034d;
        }
        return this;
    }

    final int m43137a(DateTimePrinterParser dateTimePrinterParser) {
        Jdk8Methods.m43168a((Object) dateTimePrinterParser, "pp");
        if (this.f41033c.f41037g > 0) {
            if (dateTimePrinterParser != null) {
                dateTimePrinterParser = new PadPrinterParserDecorator(dateTimePrinterParser, this.f41033c.f41037g, this.f41033c.f41038h);
            }
            this.f41033c.f41037g = 0;
            this.f41033c.f41038h = '\u0000';
        }
        this.f41033c.f41035e.add(dateTimePrinterParser);
        this.f41033c.f41039i = -1;
        return this.f41033c.f41035e.size() - 1;
    }

    public final DateTimeFormatter m43138a(Locale locale) {
        Jdk8Methods.m43168a((Object) locale, State.KEY_LOCALE);
        while (this.f41033c.f41034d != null) {
            m43154f();
        }
        return new DateTimeFormatter(new CompositePrinterParser(this.f41035e, false), locale, DecimalStyle.f41044a, ResolverStyle.SMART, null, null, null);
    }

    final DateTimeFormatter m43139a(ResolverStyle resolverStyle) {
        DateTimeFormatter a = m43138a(Locale.getDefault());
        Jdk8Methods.m43168a((Object) resolverStyle, "resolverStyle");
        if (Jdk8Methods.m43169a(a.f41025s, (Object) resolverStyle)) {
            return a;
        }
        return new DateTimeFormatter(a.f41022p, a.f41023q, a.f41024r, resolverStyle, a.f41026t, a.f41027u, a.f41028v);
    }
}
