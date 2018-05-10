package org.jsoup.parser;

import com.google.android.gms.ads.AdRequest;
import java.util.Arrays;
import java.util.Locale;
import org.jsoup.helper.Validate;

public final class CharacterReader {
    final char[] f27001a;
    final int f27002b;
    int f27003c = 0;
    int f27004d = 0;
    private final String[] f27005e = new String[AdRequest.MAX_CONTENT_URL_LENGTH];

    public CharacterReader(String str) {
        Validate.m28452a((Object) str);
        this.f27001a = str.toCharArray();
        this.f27002b = this.f27001a.length;
    }

    public final boolean m28523a() {
        return this.f27003c >= this.f27002b;
    }

    public final char m28525b() {
        return this.f27003c >= this.f27002b ? '￿' : this.f27001a[this.f27003c];
    }

    final char m28529c() {
        char c = this.f27003c >= this.f27002b ? '￿' : this.f27001a[this.f27003c];
        this.f27003c++;
        return c;
    }

    final void m28532d() {
        this.f27003c--;
    }

    public final void m28533e() {
        this.f27003c++;
    }

    final void m28534f() {
        this.f27003c = this.f27004d;
    }

    final int m28519a(CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        int i = this.f27003c;
        while (i < this.f27002b) {
            if (charAt != this.f27001a[i]) {
                do {
                    i++;
                    if (i >= this.f27002b) {
                        break;
                    }
                } while (charAt != this.f27001a[i]);
            }
            int i2 = i + 1;
            int length = (charSequence.length() + i2) - 1;
            if (i < this.f27002b && length <= this.f27002b) {
                int i3 = 1;
                int i4 = i2;
                while (i4 < length && charSequence.charAt(i3) == this.f27001a[i4]) {
                    i4++;
                    i3++;
                }
                if (i4 == length) {
                    return i - this.f27003c;
                }
            }
            i = i2;
        }
        return -1;
    }

    public final String m28522a(char... cArr) {
        int i = this.f27003c;
        int i2 = this.f27002b;
        char[] cArr2 = this.f27001a;
        loop0:
        while (this.f27003c < i2) {
            for (char c : cArr) {
                if (cArr2[this.f27003c] == c) {
                    break loop0;
                }
            }
            this.f27003c++;
        }
        return this.f27003c > i ? m28521a(i, this.f27003c - i) : "";
    }

    final String m28526b(char... cArr) {
        int i = this.f27003c;
        int i2 = this.f27002b;
        char[] cArr2 = this.f27001a;
        while (this.f27003c < i2 && Arrays.binarySearch(cArr, cArr2[this.f27003c]) < 0) {
            this.f27003c++;
        }
        return this.f27003c > i ? m28521a(i, this.f27003c - i) : "";
    }

    final String m28535g() {
        String a = m28521a(this.f27003c, this.f27002b - this.f27003c);
        this.f27003c = this.f27002b;
        return a;
    }

    final String m28536h() {
        int i = this.f27003c;
        while (this.f27003c < this.f27002b) {
            char c = this.f27001a[this.f27003c];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c))) {
                break;
            }
            this.f27003c++;
        }
        return m28521a(i, this.f27003c - i);
    }

    final boolean m28527b(char c) {
        return !m28523a() && this.f27001a[this.f27003c] == c;
    }

    final boolean m28531c(char... cArr) {
        if (m28523a()) {
            return false;
        }
        char c = this.f27001a[this.f27003c];
        for (char c2 : cArr) {
            if (c2 == c) {
                return 1;
            }
        }
        return false;
    }

    final boolean m28537i() {
        if (m28523a()) {
            return false;
        }
        char c = this.f27001a[this.f27003c];
        if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c))) {
            return false;
        }
        return true;
    }

    final boolean m28530c(String str) {
        CharSequence toLowerCase = str.toLowerCase(Locale.ENGLISH);
        CharSequence toUpperCase = str.toUpperCase(Locale.ENGLISH);
        if (m28519a(toLowerCase) < 0) {
            if (m28519a(toUpperCase) < null) {
                return null;
            }
        }
        return true;
    }

    public final String toString() {
        return new String(this.f27001a, this.f27003c, this.f27002b - this.f27003c);
    }

    final String m28521a(int i, int i2) {
        char[] cArr = this.f27001a;
        String[] strArr = this.f27005e;
        if (i2 > 12) {
            return new String(cArr, i, i2);
        }
        int i3 = 0;
        int i4 = i;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = 31 * i5;
            i3++;
            int i7 = cArr[i4] + i6;
            i4++;
            i5 = i7;
        }
        i3 = (strArr.length - 1) & i5;
        String str = strArr[i3];
        if (str == null) {
            str = new String(cArr, i, i2);
            strArr[i3] = str;
        } else if (m28518a(i, i2, str)) {
            return str;
        } else {
            str = new String(cArr, i, i2);
            strArr[i3] = str;
        }
        return str;
    }

    private boolean m28518a(int i, int i2, String str) {
        if (i2 != str.length()) {
            return false;
        }
        char[] cArr = this.f27001a;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 == 0) {
                return true;
            }
            i2 = i + 1;
            int i5 = i3 + 1;
            if (cArr[i] != str.charAt(i3)) {
                return false;
            }
            i = i2;
            i2 = i4;
            i3 = i5;
        }
    }

    public final String m28520a(char c) {
        for (int i = this.f27003c; i < this.f27002b; i++) {
            if (c == this.f27001a[i]) {
                c = i - this.f27003c;
                break;
            }
        }
        c = '￿';
        if (c == '￿') {
            return m28535g();
        }
        String a = m28521a(this.f27003c, c);
        this.f27003c += c;
        return a;
    }

    final boolean m28524a(String str) {
        boolean z;
        int length = str.length();
        if (length <= this.f27002b - this.f27003c) {
            int i = 0;
            while (i < length) {
                if (str.charAt(i) == this.f27001a[this.f27003c + i]) {
                    i++;
                }
            }
            z = true;
            if (z) {
                return false;
            }
            this.f27003c += str.length();
            return true;
        }
        z = false;
        if (z) {
            return false;
        }
        this.f27003c += str.length();
        return true;
    }

    final boolean m28528b(String str) {
        boolean z;
        int length = str.length();
        if (length <= this.f27002b - this.f27003c) {
            int i = 0;
            while (i < length) {
                if (Character.toUpperCase(str.charAt(i)) == Character.toUpperCase(this.f27001a[this.f27003c + i])) {
                    i++;
                }
            }
            z = true;
            if (z) {
                return false;
            }
            this.f27003c += str.length();
            return true;
        }
        z = false;
        if (z) {
            return false;
        }
        this.f27003c += str.length();
        return true;
    }
}
