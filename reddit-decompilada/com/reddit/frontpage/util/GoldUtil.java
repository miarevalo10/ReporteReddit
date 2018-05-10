package com.reddit.frontpage.util;

import android.util.LruCache;
import com.reddit.datalibrary.frontpage.job.GiveGoldJob;
import com.reddit.datalibrary.frontpage.job.RedditJobManager;
import com.reddit.datalibrary.frontpage.redditauth.account.Session;
import com.reddit.datalibrary.frontpage.redditauth.account.SessionManager;

public class GoldUtil {
    private static final LruCache<String, Integer> f21718a = new LruCache(100);

    public static int m23706a(String str, int i) {
        return f21718a.get(str) != null ? ((Integer) f21718a.get(str)).intValue() : i;
    }

    public static void m23707b(String str, int i) {
        Session session = SessionManager.b().c;
        if (!session.isAnonymous()) {
            RedditJobManager.a().a(new GiveGoldJob(session, str));
            f21718a.put(str, Integer.valueOf(i + 1));
            str = SessionManager.b().d();
            str.gold_creddits--;
        }
    }

    public static int m23705a() {
        SessionManager b = SessionManager.b();
        if (!b.c.isAnonymous()) {
            if (b.d() != null) {
                return b.d().gold_creddits;
            }
        }
        return 0;
    }
}
