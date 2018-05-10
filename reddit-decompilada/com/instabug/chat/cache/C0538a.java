package com.instabug.chat.cache;

import android.content.Context;
import com.instabug.chat.model.C1309d;
import com.instabug.chat.model.Chat;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.internal.storage.cache.OnDiskCache;

/* compiled from: CacheUtility */
public class C0538a {
    public static void m7898a(Context context) {
        CacheManager.getInstance().addCache(new OnDiskCache(context, ChatsCacheManager.CHATS_DISK_CACHE_KEY, ChatsCacheManager.CHATS_DISK_CACHE_FILE_NAME, Chat.class));
        CacheManager.getInstance().addCache(new OnDiskCache(context, ReadQueueCacheManager.READ_QUEUE_DISK_CACHE_KEY, ReadQueueCacheManager.READ_QUEUE_DISK_CACHE_FILE_NAME, C1309d.class));
    }

    public static void m7897a() {
        ChatsCacheManager.cleanupChats();
    }

    public static void m7899b() {
        ChatsCacheManager.saveCacheToDisk();
        ReadQueueCacheManager.saveCacheToDisk();
    }
}
