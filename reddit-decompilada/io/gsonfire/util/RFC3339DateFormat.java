package io.gsonfire.util;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RFC3339DateFormat extends DateFormat {
    private static final Pattern f24968a = Pattern.compile("(.*)([+-][0-9][0-9])\\:?([0-9][0-9])$");
    private static final Pattern f24969b = Pattern.compile("(.*)\\.([0-9]+)(.*)");
    private static final Pattern f24970c = Pattern.compile("^[0-9]{1,4}-[0-1][0-9]-[0-3][0-9]$");
    private final SimpleDateFormat f24971d;
    private final SimpleDateFormat f24972e;
    private final boolean f24973f;

    public RFC3339DateFormat(TimeZone timeZone, boolean z) {
        this.f24971d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        if (z) {
            this.f24972e = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        } else {
            this.f24972e = new SimpleDateFormat("yyyy-MM-dd");
        }
        this.f24973f = z;
        this.f24972e.setTimeZone(timeZone);
    }

    private RFC3339DateFormat() {
        this(TimeZone.getTimeZone("UTC"), true);
    }

    public final StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        stringBuffer = new StringBuffer();
        stringBuffer.append(this.f24972e.format(date).toString());
        if (this.f24973f != null) {
            long time = date.getTime();
            long j = time % 1000;
            if (j != 0) {
                date = Long.toString(j);
                fieldPosition = new StringBuilder(".");
                fieldPosition.append(date);
                stringBuffer.append(fieldPosition.toString());
            }
            date = this.f24972e.getTimeZone();
            if (date.getOffset(time) == null) {
                date = "Z";
            } else {
                date = (int) (((long) date.getOffset(time)) / 1000);
                fieldPosition = date / 3600;
                date = Math.abs((date - (fieldPosition * 3600)) / 60);
                String str = fieldPosition >= null ? Operation.PLUS : Operation.MINUS;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(String.format("%02d", new Object[]{Integer.valueOf(Math.abs(fieldPosition))}));
                stringBuilder.append(":");
                stringBuilder.append(String.format("%02d", new Object[]{Integer.valueOf(date)}));
                date = stringBuilder.toString();
            }
            stringBuffer.append(date);
        }
        return stringBuffer;
    }

    public final Date parse(String str, ParsePosition parsePosition) {
        StringBuilder stringBuilder;
        long parseLong;
        Date parse;
        if (f24970c.matcher(str).matches()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("T00:00:00-0000");
            str = stringBuilder.toString();
        } else if (str.charAt(10) == 't') {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str.substring(0, 10));
            stringBuilder2.append("T");
            stringBuilder2.append(str.substring(12));
            str = stringBuilder2.toString();
        }
        if (str.contains(".")) {
            str = f24969b.matcher(str);
            parseLong = Long.parseLong(str.replaceAll("$2"));
            stringBuilder = new StringBuilder();
            stringBuilder.append(str.replaceAll("$1"));
            stringBuilder.append(str.replaceAll("$3"));
            str = stringBuilder.toString();
        } else {
            parseLong = 0;
        }
        if (!str.endsWith("Z")) {
            if (!str.endsWith("z")) {
                Matcher matcher = f24968a.matcher(str);
                if (matcher.matches()) {
                    str = new StringBuilder();
                    str.append(matcher.replaceAll("$1"));
                    str.append(matcher.replaceAll("$2"));
                    str.append(matcher.replaceAll("$3"));
                    str = str.toString();
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("-0000");
                    str = stringBuilder.toString();
                }
                parse = this.f24971d.parse(str);
                if (parseLong > 0) {
                    parse = new Date(parse.getTime() + parseLong);
                }
                parsePosition.setIndex(str.length());
                return parse;
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str.substring(0, str.length() - 1));
        stringBuilder.append("-0000");
        str = stringBuilder.toString();
        try {
            parse = this.f24971d.parse(str);
            if (parseLong > 0) {
                parse = new Date(parse.getTime() + parseLong);
            }
            parsePosition.setIndex(str.length());
            return parse;
        } catch (String str2) {
            throw new RuntimeException(str2);
        }
    }
}
