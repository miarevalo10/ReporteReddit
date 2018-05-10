package com.android.volley;

import java.util.Collections;
import java.util.Map;

public interface Cache {

    public static class Entry {
        public byte[] f2750a;
        public String f2751b;
        public long f2752c;
        public long f2753d;
        public long f2754e;
        public long f2755f;
        public Map<String, String> f2756g = Collections.emptyMap();
    }

    void clear();

    Entry get(String str);

    void initialize();

    void invalidate(String str, boolean z);

    void put(String str, Entry entry);

    void remove(String str);
}
