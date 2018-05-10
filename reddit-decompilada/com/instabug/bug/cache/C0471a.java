package com.instabug.bug.cache;

import android.content.Context;
import com.instabug.bug.model.Bug;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.OnDiskCache;
import com.instabug.library.util.InstabugSDKLogger;

/* compiled from: CacheUtility */
public class C0471a {
    public static void m7761a(Context context) {
        InstabugSDKLogger.m8360v(C0471a.class, "Creating bugs disk cache");
        CacheManager.getInstance().addCache(new OnDiskCache(context, BugsCacheManager.BUGS_DISK_CACHE_KEY, BugsCacheManager.BUGS_DISK_CACHE_FILE_NAME, Bug.class));
    }

    public static void m7760a() {
        InstabugSDKLogger.m8356d(C0471a.class, "Bugs: Saving cache to disk");
        BugsCacheManager.saveCacheToDisk();
    }
}
