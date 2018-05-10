package org.apache.commons.cli;

import com.raizlabs.android.dbflow.sql.language.Operator.Operation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HelpFormatter {
    public int f26690a = 74;
    public int f26691b = 1;
    public int f26692c = 3;
    public String f26693d = "usage: ";
    public String f26694e = System.getProperty("line.separator");
    public String f26695f = Operation.MINUS;
    public String f26696g = "--";
    public String f26697h = "arg";
    protected Comparator f26698i = new OptionComparator((byte) 0);

    private static class OptionComparator implements Comparator {
        private OptionComparator() {
        }

        OptionComparator(byte b) {
            this();
        }

        public int compare(Object obj, Object obj2) {
            return ((Option) obj).m28322a().compareToIgnoreCase(((Option) obj2).m28322a());
        }
    }

    public final StringBuffer m28320a(StringBuffer stringBuffer, int i, Options options, int i2, int i3) {
        i2 = m28317a(i2);
        String a = m28317a(i3);
        List arrayList = new ArrayList();
        Options<Option> a2 = options.m28327a();
        Collections.sort(a2, this.f26698i);
        int i4 = 0;
        int i5 = 0;
        for (Option option : a2) {
            StringBuffer stringBuffer2 = new StringBuffer(8);
            if (option.f26699a == null) {
                stringBuffer2.append(i2);
                StringBuffer stringBuffer3 = new StringBuffer("   ");
                stringBuffer3.append(this.f26696g);
                stringBuffer2.append(stringBuffer3.toString());
                stringBuffer2.append(option.f26700b);
            } else {
                stringBuffer2.append(i2);
                stringBuffer2.append(this.f26695f);
                stringBuffer2.append(option.f26699a);
                if (option.m28324b()) {
                    stringBuffer2.append(',');
                    stringBuffer2.append(this.f26696g);
                    stringBuffer2.append(option.f26700b);
                }
            }
            if (option.m28325c()) {
                int i6 = (option.f26701c == null || option.f26701c.length() <= 0) ? 0 : 1;
                if (i6 != 0) {
                    stringBuffer2.append(" <");
                    stringBuffer2.append(option.f26701c);
                    stringBuffer2.append(Operation.GREATER_THAN);
                } else {
                    stringBuffer2.append(' ');
                }
            }
            arrayList.add(stringBuffer2);
            if (stringBuffer2.length() > i5) {
                i5 = stringBuffer2.length();
            }
        }
        options = a2.iterator();
        while (options.hasNext() != 0) {
            Option option2 = (Option) options.next();
            int i7 = i4 + 1;
            StringBuffer stringBuffer4 = new StringBuffer(arrayList.get(i4).toString());
            if (stringBuffer4.length() < i5) {
                stringBuffer4.append(m28317a(i5 - stringBuffer4.length()));
            }
            stringBuffer4.append(a);
            i4 = i5 + i3;
            if (option2.f26702d != null) {
                stringBuffer4.append(option2.f26702d);
            }
            m28319a(stringBuffer, i, i4, stringBuffer4.toString());
            if (options.hasNext() != 0) {
                stringBuffer.append(this.f26694e);
            }
            i4 = i7;
        }
        return stringBuffer;
    }

    private StringBuffer m28319a(StringBuffer stringBuffer, int i, int i2, String str) {
        int a = m28316a(str, i);
        if (a == -1) {
            stringBuffer.append(m28318a(str));
            return stringBuffer;
        }
        stringBuffer.append(m28318a(str.substring(0, a)));
        stringBuffer.append(this.f26694e);
        if (i2 >= i) {
            i2 = 1;
        }
        String a2 = m28317a(i2);
        while (true) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(a2);
            stringBuffer2.append(str.substring(a).trim());
            str = stringBuffer2.toString();
            a = m28316a(str, i);
            if (a == -1) {
                stringBuffer.append(str);
                return stringBuffer;
            }
            if (str.length() > i && a == i2 - 1) {
                a = i;
            }
            stringBuffer.append(m28318a(str.substring(0, a)));
            stringBuffer.append(this.f26694e);
        }
    }

    private static int m28316a(String str, int i) {
        int indexOf = str.indexOf(10, 0);
        if (indexOf == -1 || indexOf > i) {
            indexOf = str.indexOf(9, 0);
            if (indexOf == -1 || indexOf > i) {
                int i2 = 0 + i;
                if (i2 >= str.length()) {
                    return -1;
                }
                i = i2;
                while (i >= 0) {
                    char charAt = str.charAt(i);
                    if (charAt == ' ' || charAt == '\n' || charAt == '\r') {
                        break;
                    }
                    i--;
                }
                if (i > 0) {
                    return i;
                }
                while (i2 <= str.length()) {
                    i = str.charAt(i2);
                    if (i == 32 || i == 10 || i == 13) {
                        break;
                    }
                    i2++;
                }
                if (i2 == str.length()) {
                    return -1;
                }
                return i2;
            }
        }
        return indexOf + 1;
    }

    private static String m28317a(int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    private static String m28318a(String str) {
        if (str != null) {
            if (str.length() != 0) {
                int length = str.length();
                while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
                    length--;
                }
                return str.substring(0, length);
            }
        }
        return str;
    }
}
