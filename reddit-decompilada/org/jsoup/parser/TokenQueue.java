package org.jsoup.parser;

import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;

public class TokenQueue {
    public String f27086a;
    public int f27087b = 0;

    public TokenQueue(String str) {
        Validate.m28452a((Object) str);
        this.f27086a = str;
    }

    public final boolean m28582a() {
        return m28580g() == 0;
    }

    private int m28580g() {
        return this.f27086a.length() - this.f27087b;
    }

    public final boolean m28583a(String str) {
        return this.f27086a.regionMatches(true, this.f27087b, str, 0, str.length());
    }

    public final boolean m28584a(String... strArr) {
        for (String a : strArr) {
            if (m28583a(a)) {
                return 1;
            }
        }
        return false;
    }

    public final boolean m28586b(String str) {
        if (!m28583a(str)) {
            return null;
        }
        this.f27087b += str.length();
        return true;
    }

    public final boolean m28585b() {
        return !m28582a() && Character.isLetterOrDigit(this.f27086a.charAt(this.f27087b));
    }

    public final char m28587c() {
        String str = this.f27086a;
        int i = this.f27087b;
        this.f27087b = i + 1;
        return str.charAt(i);
    }

    public final void m28588c(String str) {
        if (m28583a(str)) {
            str = str.length();
            if (str > m28580g()) {
                throw new IllegalStateException("Queue not long enough to consume sequence");
            }
            this.f27087b += str;
            return;
        }
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public final String m28589d(String str) {
        str = this.f27086a.indexOf(str, this.f27087b);
        if (str == -1) {
            return m28593f();
        }
        str = this.f27086a.substring(this.f27087b, str);
        this.f27087b += str.length();
        return str;
    }

    public final String m28592e(String str) {
        String d = m28589d(str);
        m28586b(str);
        return d;
    }

    public final String m28581a(char c, char c2) {
        char c3 = '\u0000';
        int i = 0;
        int i2 = i;
        int i3 = -1;
        int i4 = i3;
        while (!m28582a()) {
            Character valueOf = Character.valueOf(m28587c());
            if (c3 == '\u0000' || c3 != '\\') {
                if ((valueOf.equals(Character.valueOf('\'')) || valueOf.equals(Character.valueOf('\"'))) && valueOf.charValue() != c) {
                    i ^= 1;
                }
                if (i != 0) {
                    continue;
                    if (i2 <= 0) {
                        break;
                    }
                } else if (valueOf.equals(Character.valueOf(c))) {
                    i2++;
                    if (i3 == -1) {
                        i3 = this.f27087b;
                    }
                } else if (valueOf.equals(Character.valueOf(c2))) {
                    i2--;
                }
            }
            if (i2 > 0 && c3 != '\u0000') {
                i4 = this.f27087b;
            }
            c3 = valueOf.charValue();
            continue;
            if (i2 <= 0) {
                break;
            }
        }
        return i4 >= 0 ? this.f27086a.substring(i3, i4) : "";
    }

    public static String m28579f(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        str = str.toCharArray();
        int i = 0;
        int length = str.length;
        int i2 = 0;
        while (i < length) {
            char c = str[i];
            if (c != '\\') {
                stringBuilder.append(c);
            } else if (i2 != 0 && i2 == 92) {
                stringBuilder.append(c);
            }
            i++;
            char c2 = c;
        }
        return stringBuilder.toString();
    }

    public final String m28591e() {
        int i = this.f27087b;
        while (!m28582a()) {
            if (!m28585b()) {
                char[] cArr = new char[]{'-', '_'};
                int i2 = 0;
                if (!m28582a()) {
                    for (int i3 = 0; i3 < 2; i3++) {
                        if (this.f27086a.charAt(this.f27087b) == cArr[i3]) {
                            i2 = 1;
                            break;
                        }
                    }
                }
                if (i2 == 0) {
                    break;
                }
            }
            this.f27087b++;
        }
        return this.f27086a.substring(i, this.f27087b);
    }

    public final String m28593f() {
        String substring = this.f27086a.substring(this.f27087b, this.f27086a.length());
        this.f27087b = this.f27086a.length();
        return substring;
    }

    public String toString() {
        return this.f27086a.substring(this.f27087b);
    }

    public final boolean m28590d() {
        boolean z = false;
        while (true) {
            int i = (m28582a() || !StringUtil.m28449b(this.f27086a.charAt(this.f27087b))) ? 0 : 1;
            if (i == 0) {
                return z;
            }
            this.f27087b++;
            z = true;
        }
    }
}
