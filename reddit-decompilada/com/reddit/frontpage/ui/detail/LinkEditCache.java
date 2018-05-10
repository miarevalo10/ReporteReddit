package com.reddit.frontpage.ui.detail;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/reddit/frontpage/ui/detail/LinkEditCache;", "", "()V", "CACHE_SIZE", "", "linkBodyEditCache", "Landroid/util/LruCache;", "", "Lcom/reddit/frontpage/ui/detail/LinkEditCache$BodyEditCacheEntry;", "linkBodyEditCache$annotations", "getLinkBodyEditCache", "()Landroid/util/LruCache;", "linkFlairEditCache", "linkFlairEditCache$annotations", "getLinkFlairEditCache", "BodyEditCacheEntry", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: LinkEditCache.kt */
public final class LinkEditCache {
    private static final int CACHE_SIZE = 100;
    public static final LinkEditCache INSTANCE = new LinkEditCache();
    private static final LruCache<String, BodyEditCacheEntry> linkBodyEditCache = new LruCache(100);
    private static final LruCache<String, String> linkFlairEditCache = new LruCache(100);

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/reddit/frontpage/ui/detail/LinkEditCache$BodyEditCacheEntry;", "", "body", "", "bodyHtml", "(Ljava/lang/String;Ljava/lang/String;)V", "getBody", "()Ljava/lang/String;", "getBodyHtml", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
    /* compiled from: LinkEditCache.kt */
    public static final class BodyEditCacheEntry {
        public final String f21172a;
        final String f21173b;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof BodyEditCacheEntry) {
                    BodyEditCacheEntry bodyEditCacheEntry = (BodyEditCacheEntry) obj;
                    if (Intrinsics.m26845a(this.f21172a, bodyEditCacheEntry.f21172a) && Intrinsics.m26845a(this.f21173b, bodyEditCacheEntry.f21173b)) {
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            String str = this.f21172a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.f21173b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("BodyEditCacheEntry(body=");
            stringBuilder.append(this.f21172a);
            stringBuilder.append(", bodyHtml=");
            stringBuilder.append(this.f21173b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        public BodyEditCacheEntry(String str, String str2) {
            Intrinsics.m26847b(str, "body");
            Intrinsics.m26847b(str2, "bodyHtml");
            this.f21172a = str;
            this.f21173b = str2;
        }
    }

    public static /* synthetic */ void linkBodyEditCache$annotations() {
    }

    public static /* synthetic */ void linkFlairEditCache$annotations() {
    }

    private LinkEditCache() {
    }

    public static final LruCache<String, BodyEditCacheEntry> getLinkBodyEditCache() {
        return linkBodyEditCache;
    }

    public static final LruCache<String, String> getLinkFlairEditCache() {
        return linkFlairEditCache;
    }
}
