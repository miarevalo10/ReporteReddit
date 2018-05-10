package com.reddit.frontpage.util;

public class ModCacheCommentsDummy extends ModCacheComments {
    private static final ModCacheComments f34491a = new ModCacheCommentsDummy();

    public void cacheApprovedState(String str, Boolean bool) {
    }

    public void cacheRemovedState(String str, Boolean bool) {
    }

    public void cacheStickyState(String str, Boolean bool) {
    }

    public boolean getApprovedState(String str, boolean z) {
        return z;
    }

    public boolean getRemovedState(String str, boolean z) {
        return z;
    }

    public boolean getStickyState(String str, boolean z) {
        return z;
    }

    public static ModCacheComments m35278a() {
        return f34491a;
    }
}
