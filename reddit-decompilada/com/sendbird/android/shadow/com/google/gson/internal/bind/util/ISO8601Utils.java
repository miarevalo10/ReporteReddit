package com.sendbird.android.shadow.com.google.gson.internal.bind.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class ISO8601Utils {
    private static final TimeZone f22995a = TimeZone.getTimeZone("UTC");

    public static Date m25139a(String str, ParsePosition parsePosition) throws ParseException {
        StringBuilder stringBuilder;
        Throwable th;
        String message;
        StringBuilder stringBuilder2;
        ParseException parseException;
        String str2 = str;
        ParsePosition parsePosition2 = parsePosition;
        try {
            int index = parsePosition.getIndex();
            int i = index + 4;
            index = m25138a(str2, index, i);
            if (m25140a(str2, i, '-')) {
                i++;
            }
            int i2 = i + 2;
            i = m25138a(str2, i, i2);
            if (m25140a(str2, i2, '-')) {
                i2++;
            }
            int i3 = i2 + 2;
            i2 = m25138a(str2, i2, i3);
            boolean a = m25140a(str2, i3, 'T');
            Calendar gregorianCalendar;
            if (a || str.length() > i3) {
                int i4;
                int i5;
                int i6;
                int min;
                char charAt;
                TimeZone timeZone;
                String substring;
                StringBuilder stringBuilder3;
                TimeZone timeZone2;
                String id;
                if (a) {
                    i3++;
                    i4 = i3 + 2;
                    i3 = m25138a(str2, i3, i4);
                    if (m25140a(str2, i4, ':')) {
                        i4++;
                    }
                    i5 = i4 + 2;
                    i4 = m25138a(str2, i4, i5);
                    if (m25140a(str2, i5, ':')) {
                        i5++;
                    }
                    if (str.length() > i5) {
                        char charAt2 = str2.charAt(i5);
                        if (!(charAt2 == 'Z' || charAt2 == '+' || charAt2 == '-')) {
                            i6 = i5 + 2;
                            i5 = m25138a(str2, i5, i6);
                            if (i5 > 59 && i5 < 63) {
                                i5 = 59;
                            }
                            if (m25140a(str2, i6, '.')) {
                                i6++;
                                int a2 = m25137a(str2, i6 + 1);
                                min = Math.min(a2, i6 + 3);
                                int a3 = m25138a(str2, i6, min);
                                switch (min - i6) {
                                    case 1:
                                        a3 *= 100;
                                        break;
                                    case 2:
                                        a3 *= 10;
                                        break;
                                }
                                min = a3;
                                i6 = a2;
                            } else {
                                min = 0;
                            }
                            if (str.length() > i6) {
                                throw new IllegalArgumentException("No time zone indicator");
                            }
                            charAt = str2.charAt(i6);
                            if (charAt != 'Z') {
                                timeZone = f22995a;
                                i6++;
                            } else {
                                if (charAt != '+') {
                                    if (charAt == '-') {
                                        stringBuilder = new StringBuilder("Invalid time zone indicator '");
                                        stringBuilder.append(charAt);
                                        stringBuilder.append("'");
                                        throw new IndexOutOfBoundsException(stringBuilder.toString());
                                    }
                                }
                                substring = str2.substring(i6);
                                if (substring.length() >= 5) {
                                    stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append(substring);
                                    stringBuilder3.append("00");
                                    substring = stringBuilder3.toString();
                                }
                                i6 += substring.length();
                                if (!"+0000".equals(substring)) {
                                    if ("+00:00".equals(substring)) {
                                        stringBuilder3 = new StringBuilder("GMT");
                                        stringBuilder3.append(substring);
                                        substring = stringBuilder3.toString();
                                        timeZone2 = TimeZone.getTimeZone(substring);
                                        id = timeZone2.getID();
                                        if (!id.equals(substring) || id.replace(":", "").equals(substring)) {
                                            timeZone = timeZone2;
                                        } else {
                                            stringBuilder = new StringBuilder("Mismatching time zone indicator: ");
                                            stringBuilder.append(substring);
                                            stringBuilder.append(" given, resolves to ");
                                            stringBuilder.append(timeZone2.getID());
                                            throw new IndexOutOfBoundsException(stringBuilder.toString());
                                        }
                                    }
                                }
                                timeZone = f22995a;
                            }
                            gregorianCalendar = new GregorianCalendar(timeZone);
                            gregorianCalendar.setLenient(false);
                            gregorianCalendar.set(1, index);
                            gregorianCalendar.set(2, i - 1);
                            gregorianCalendar.set(5, i2);
                            gregorianCalendar.set(11, i3);
                            gregorianCalendar.set(12, i4);
                            gregorianCalendar.set(13, i5);
                            gregorianCalendar.set(14, min);
                            parsePosition2.setIndex(i6);
                            return gregorianCalendar.getTime();
                        }
                    }
                    i6 = i5;
                } else {
                    i6 = i3;
                    i3 = 0;
                    i4 = 0;
                }
                min = 0;
                i5 = 0;
                if (str.length() > i6) {
                    charAt = str2.charAt(i6);
                    if (charAt != 'Z') {
                        if (charAt != '+') {
                            if (charAt == '-') {
                                stringBuilder = new StringBuilder("Invalid time zone indicator '");
                                stringBuilder.append(charAt);
                                stringBuilder.append("'");
                                throw new IndexOutOfBoundsException(stringBuilder.toString());
                            }
                        }
                        substring = str2.substring(i6);
                        if (substring.length() >= 5) {
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(substring);
                            stringBuilder3.append("00");
                            substring = stringBuilder3.toString();
                        }
                        i6 += substring.length();
                        if ("+0000".equals(substring)) {
                            if ("+00:00".equals(substring)) {
                                stringBuilder3 = new StringBuilder("GMT");
                                stringBuilder3.append(substring);
                                substring = stringBuilder3.toString();
                                timeZone2 = TimeZone.getTimeZone(substring);
                                id = timeZone2.getID();
                                if (id.equals(substring)) {
                                }
                                timeZone = timeZone2;
                            }
                        }
                        timeZone = f22995a;
                    } else {
                        timeZone = f22995a;
                        i6++;
                    }
                    gregorianCalendar = new GregorianCalendar(timeZone);
                    gregorianCalendar.setLenient(false);
                    gregorianCalendar.set(1, index);
                    gregorianCalendar.set(2, i - 1);
                    gregorianCalendar.set(5, i2);
                    gregorianCalendar.set(11, i3);
                    gregorianCalendar.set(12, i4);
                    gregorianCalendar.set(13, i5);
                    gregorianCalendar.set(14, min);
                    parsePosition2.setIndex(i6);
                    return gregorianCalendar.getTime();
                }
                throw new IllegalArgumentException("No time zone indicator");
            }
            gregorianCalendar = new GregorianCalendar(index, i - 1, i2);
            parsePosition2.setIndex(i3);
            return gregorianCalendar.getTime();
        } catch (Throwable e) {
            th = e;
            if (str2 == null) {
                str2 = null;
            } else {
                stringBuilder = new StringBuilder("\"");
                stringBuilder.append(str2);
                stringBuilder.append("'");
                str2 = stringBuilder.toString();
            }
            message = th.getMessage();
            if (message == null || message.isEmpty()) {
                stringBuilder = new StringBuilder("(");
                stringBuilder.append(th.getClass().getName());
                stringBuilder.append(")");
                message = stringBuilder.toString();
            }
            stringBuilder2 = new StringBuilder("Failed to parse date [");
            stringBuilder2.append(str2);
            stringBuilder2.append("]: ");
            stringBuilder2.append(message);
            parseException = new ParseException(stringBuilder2.toString(), parsePosition.getIndex());
            parseException.initCause(th);
            throw parseException;
        } catch (Throwable e2) {
            th = e2;
            if (str2 == null) {
                stringBuilder = new StringBuilder("\"");
                stringBuilder.append(str2);
                stringBuilder.append("'");
                str2 = stringBuilder.toString();
            } else {
                str2 = null;
            }
            message = th.getMessage();
            stringBuilder = new StringBuilder("(");
            stringBuilder.append(th.getClass().getName());
            stringBuilder.append(")");
            message = stringBuilder.toString();
            stringBuilder2 = new StringBuilder("Failed to parse date [");
            stringBuilder2.append(str2);
            stringBuilder2.append("]: ");
            stringBuilder2.append(message);
            parseException = new ParseException(stringBuilder2.toString(), parsePosition.getIndex());
            parseException.initCause(th);
            throw parseException;
        } catch (Throwable e22) {
            th = e22;
            if (str2 == null) {
                str2 = null;
            } else {
                stringBuilder = new StringBuilder("\"");
                stringBuilder.append(str2);
                stringBuilder.append("'");
                str2 = stringBuilder.toString();
            }
            message = th.getMessage();
            stringBuilder = new StringBuilder("(");
            stringBuilder.append(th.getClass().getName());
            stringBuilder.append(")");
            message = stringBuilder.toString();
            stringBuilder2 = new StringBuilder("Failed to parse date [");
            stringBuilder2.append(str2);
            stringBuilder2.append("]: ");
            stringBuilder2.append(message);
            parseException = new ParseException(stringBuilder2.toString(), parsePosition.getIndex());
            parseException.initCause(th);
            throw parseException;
        }
    }

    private static boolean m25140a(String str, int i, char c) {
        return (i >= str.length() || str.charAt(i) != c) ? null : true;
    }

    private static int m25138a(String str, int i, int i2) throws NumberFormatException {
        if (i >= 0 && i2 <= str.length()) {
            if (i <= i2) {
                int i3;
                int digit;
                StringBuilder stringBuilder;
                if (i < i2) {
                    i3 = i + 1;
                    digit = Character.digit(str.charAt(i), 10);
                    if (digit < 0) {
                        stringBuilder = new StringBuilder("Invalid number: ");
                        stringBuilder.append(str.substring(i, i2));
                        throw new NumberFormatException(stringBuilder.toString());
                    }
                    digit = -digit;
                } else {
                    digit = 0;
                    i3 = i;
                }
                while (i3 < i2) {
                    int i4 = i3 + 1;
                    i3 = Character.digit(str.charAt(i3), 10);
                    if (i3 < 0) {
                        stringBuilder = new StringBuilder("Invalid number: ");
                        stringBuilder.append(str.substring(i, i2));
                        throw new NumberFormatException(stringBuilder.toString());
                    }
                    digit = (digit * 10) - i3;
                    i3 = i4;
                }
                return -digit;
            }
        }
        throw new NumberFormatException(str);
    }

    private static int m25137a(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt >= '0') {
                if (charAt <= '9') {
                    i++;
                }
            }
            return i;
        }
        return str.length();
    }
}
