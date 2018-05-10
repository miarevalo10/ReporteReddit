package com.bumptech.glide.load.model;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class LazyHeaders implements Headers {
    private final Map<String, List<LazyHeaderFactory>> f12544c;
    private volatile Map<String, String> f12545d;

    public static final class Builder {
        private static final String f3489c;
        private static final Map<String, List<LazyHeaderFactory>> f3490d;
        boolean f3491a = true;
        Map<String, List<LazyHeaderFactory>> f3492b = f3490d;
        private boolean f3493e = true;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder stringBuilder = new StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if ((charAt > '\u001f' || charAt == '\t') && charAt < '') {
                        stringBuilder.append(charAt);
                    } else {
                        stringBuilder.append('?');
                    }
                }
                property = stringBuilder.toString();
            }
            f3489c = property;
            Map hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f3489c)) {
                hashMap.put("User-Agent", Collections.singletonList(new StringHeaderFactory(f3489c)));
            }
            f3490d = Collections.unmodifiableMap(hashMap);
        }
    }

    static final class StringHeaderFactory implements LazyHeaderFactory {
        private final String f12543a;

        StringHeaderFactory(String str) {
            this.f12543a = str;
        }

        public final String mo977a() {
            return this.f12543a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("StringHeaderFactory{value='");
            stringBuilder.append(this.f12543a);
            stringBuilder.append('\'');
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof StringHeaderFactory)) {
                return null;
            }
            return this.f12543a.equals(((StringHeaderFactory) obj).f12543a);
        }

        public final int hashCode() {
            return this.f12543a.hashCode();
        }
    }

    LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.f12544c = Collections.unmodifiableMap(map);
    }

    public final Map<String, String> mo976a() {
        if (this.f12545d == null) {
            synchronized (this) {
                if (this.f12545d == null) {
                    Map hashMap = new HashMap();
                    for (Entry entry : this.f12544c.entrySet()) {
                        CharSequence a = m11494a((List) entry.getValue());
                        if (!TextUtils.isEmpty(a)) {
                            hashMap.put(entry.getKey(), a);
                        }
                    }
                    this.f12545d = Collections.unmodifiableMap(hashMap);
                }
            }
        }
        return this.f12545d;
    }

    private static String m11494a(List<LazyHeaderFactory> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object a = ((LazyHeaderFactory) list.get(i)).mo977a();
            if (!TextUtils.isEmpty(a)) {
                stringBuilder.append(a);
                if (i != list.size() - 1) {
                    stringBuilder.append(',');
                }
            }
        }
        return stringBuilder.toString();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LazyHeaders{headers=");
        stringBuilder.append(this.f12544c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LazyHeaders)) {
            return null;
        }
        return this.f12544c.equals(((LazyHeaders) obj).f12544c);
    }

    public final int hashCode() {
        return this.f12544c.hashCode();
    }
}
