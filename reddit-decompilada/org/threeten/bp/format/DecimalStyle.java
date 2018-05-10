package org.threeten.bp.format;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class DecimalStyle {
    public static final DecimalStyle f41044a = new DecimalStyle();
    private static final ConcurrentMap<Locale, DecimalStyle> f41045f = new ConcurrentHashMap(16, 0.75f, 2);
    final char f41046b = '0';
    final char f41047c = '+';
    final char f41048d = '-';
    final char f41049e = '.';

    private DecimalStyle() {
    }

    final String m43161a(String str) {
        if (this.f41046b == '0') {
            return str;
        }
        int i = this.f41046b - 48;
        str = str.toCharArray();
        for (int i2 = 0; i2 < str.length; i2++) {
            str[i2] = (char) (str[i2] + i);
        }
        return new String(str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecimalStyle)) {
            return false;
        }
        DecimalStyle decimalStyle = (DecimalStyle) obj;
        return this.f41046b == decimalStyle.f41046b && this.f41047c == decimalStyle.f41047c && this.f41048d == decimalStyle.f41048d && this.f41049e == decimalStyle.f41049e;
    }

    public final int hashCode() {
        return ((this.f41046b + this.f41047c) + this.f41048d) + this.f41049e;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("DecimalStyle[");
        stringBuilder.append(this.f41046b);
        stringBuilder.append(this.f41047c);
        stringBuilder.append(this.f41048d);
        stringBuilder.append(this.f41049e);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
