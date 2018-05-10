package com.sendbird.android.shadow.okhttp3;

import com.sendbird.android.shadow.okhttp3.internal.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Headers {
    public final String[] f23197a;

    public static final class Builder {
        final List<String> f23196a = new ArrayList(20);

        final Builder m25260a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return m25264b(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return m25264b("", str.substring(1));
            }
            return m25264b("", str);
        }

        public final Builder m25261a(String str, String str2) {
            m25259c(str, str2);
            return m25264b(str, str2);
        }

        final Builder m25264b(String str, String str2) {
            this.f23196a.add(str);
            this.f23196a.add(str2.trim());
            return this;
        }

        public final Builder m25263b(String str) {
            int i = 0;
            while (i < this.f23196a.size()) {
                if (str.equalsIgnoreCase((String) this.f23196a.get(i))) {
                    this.f23196a.remove(i);
                    this.f23196a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        static void m25259c(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                char charAt;
                int length = str.length();
                int i = 0;
                while (i < length) {
                    charAt = str.charAt(i);
                    if (charAt > ' ') {
                        if (charAt < '') {
                            i++;
                        }
                    }
                    throw new IllegalArgumentException(Util.m25360a("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
                if (str2 == null) {
                    StringBuilder stringBuilder = new StringBuilder("value for name ");
                    stringBuilder.append(str);
                    stringBuilder.append(" == null");
                    throw new NullPointerException(stringBuilder.toString());
                }
                length = str2.length();
                i = 0;
                while (i < length) {
                    charAt = str2.charAt(i);
                    if ((charAt > '\u001f' || charAt == '\t') && charAt < '') {
                        i++;
                    } else {
                        throw new IllegalArgumentException(Util.m25360a("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str, str2));
                    }
                }
            }
        }

        public final String m25265c(String str) {
            for (int size = this.f23196a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.f23196a.get(size))) {
                    return (String) this.f23196a.get(size + 1);
                }
            }
            return null;
        }

        public final Headers m25262a() {
            return new Headers(this);
        }
    }

    Headers(Builder builder) {
        this.f23197a = (String[]) builder.f23196a.toArray(new String[builder.f23196a.size()]);
    }

    private Headers(String[] strArr) {
        this.f23197a = strArr;
    }

    public final String m25269a(String str) {
        String[] strArr = this.f23197a;
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public final String m25268a(int i) {
        return this.f23197a[i * 2];
    }

    public final String m25270b(int i) {
        return this.f23197a[(i * 2) + 1];
    }

    public final Builder m25267a() {
        Builder builder = new Builder();
        Collections.addAll(builder.f23196a, this.f23197a);
        return builder;
    }

    public final boolean equals(Object obj) {
        return (!(obj instanceof Headers) || Arrays.equals(((Headers) obj).f23197a, this.f23197a) == null) ? null : true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f23197a);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int length = this.f23197a.length / 2;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(m25268a(i));
            stringBuilder.append(": ");
            stringBuilder.append(m25270b(i));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static Headers m25266a(String... strArr) {
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        int i;
        strArr = (String[]) strArr.clone();
        for (i = 0; i < strArr.length; i++) {
            if (strArr[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr[i] = strArr[i].trim();
        }
        i = 0;
        while (i < strArr.length) {
            String str = strArr[i];
            String str2 = strArr[i + 1];
            if (str.length() != 0 && str.indexOf(0) == -1) {
                if (str2.indexOf(0) == -1) {
                    i += 2;
                }
            }
            StringBuilder stringBuilder = new StringBuilder("Unexpected header: ");
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return new Headers(strArr);
    }

    public final List<String> m25271b(String str) {
        List list = null;
        int length = this.f23197a.length / 2;
        for (int i = 0; i < length; i++) {
            if (str.equalsIgnoreCase(m25268a(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(m25270b(i));
            }
        }
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }
}
