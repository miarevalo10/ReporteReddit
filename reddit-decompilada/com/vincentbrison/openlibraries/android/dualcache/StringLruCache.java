package com.vincentbrison.openlibraries.android.dualcache;

import java.nio.charset.Charset;

class StringLruCache extends RamLruCache<String, String> {
    protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
        return ((String) obj2).getBytes(Charset.defaultCharset()).length;
    }

    public StringLruCache(int i) {
        super(i);
    }
}
