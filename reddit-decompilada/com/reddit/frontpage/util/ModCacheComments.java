package com.reddit.frontpage.util;

public class ModCacheComments extends ModCache {
    public final boolean m30451a(String str, boolean z) {
        return getValue(this.CACHE_SPAM, str, Boolean.valueOf(z));
    }

    public final void m30450a(String str, Boolean bool) {
        if (bool.booleanValue()) {
            this.CACHE_APPROVED.remove(str);
            this.CACHE_REMOVED.remove(str);
        }
        putValue(this.CACHE_SPAM, str, bool);
    }
}
