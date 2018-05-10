package com.reddit.frontpage.sync;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.os.Bundle;
import com.reddit.datalibrary.frontpage.data.feature.settings.InternalSettings;
import com.reddit.datalibrary.frontpage.redditauth.account.AccountUtil;
import com.reddit.frontpage.debug.RedditLogger;
import com.reddit.frontpage.sync.SyncScheduleConfig.ScheduleMap;
import com.reddit.frontpage.sync.routine.SyncRoutine;
import java.util.HashMap;
import timber.log.Timber;

public class SyncSchedule {
    private static ScheduleMap f21048a;
    private static ScheduleMap f21049b;

    public static void m23259a(SyncScheduleConfig syncScheduleConfig) {
        f21048a = syncScheduleConfig.f21052a;
        f21049b = syncScheduleConfig.f21053b;
    }

    static SyncRoutine m23254a(String str, int i) {
        if (f21048a.containsKey(str)) {
            return (SyncRoutine) ((HashMap) f21048a.get(str)).get(Integer.valueOf(i));
        }
        return f21049b.containsKey(str) ? (SyncRoutine) ((HashMap) f21049b.get(str)).get(Integer.valueOf(i)) : null;
    }

    public static void m23255a(Account account) {
        for (String str : f21048a.keySet()) {
            for (SyncRoutine syncRoutine : ((HashMap) f21048a.get(str)).values()) {
                Bundle bundle = new Bundle();
                bundle.putInt("com.reddit.frontpage.sync_id", syncRoutine.f21058g);
                ContentResolver.addPeriodicSync(account, str, bundle, syncRoutine.f21059h);
                Timber.b("Scheduled %s for %s", new Object[]{Integer.valueOf(syncRoutine.f21058g), account.name});
            }
            ContentResolver.setIsSyncable(account, str, 1);
            ContentResolver.setSyncAutomatically(account, str, false);
        }
    }

    public static void m23258a(Context context) {
        Account d = AccountUtil.d(context);
        if (d == null) {
            AccountUtil.c(context);
            return;
        }
        for (String str : f21049b.keySet()) {
            for (SyncRoutine syncRoutine : ((HashMap) f21049b.get(str)).values()) {
                Bundle bundle = new Bundle();
                bundle.putInt("com.reddit.frontpage.sync_id", syncRoutine.f21058g);
                ContentResolver.addPeriodicSync(d, str, bundle, syncRoutine.f21059h);
                Timber.b("Scheduled %s for default account", new Object[]{Integer.valueOf(syncRoutine.f21058g)});
            }
            ContentResolver.setIsSyncable(d, str, 1);
            ContentResolver.setSyncAutomatically(d, str, false);
        }
    }

    public static void m23256a(Account account, String str) {
        if (!m23260b(account.name, 2)) {
            Bundle bundle = new Bundle();
            bundle.putInt("com.reddit.frontpage.sync_id", 2);
            bundle.putBoolean("force", true);
            Timber.b("Requesting sync %d for %s", new Object[]{Integer.valueOf(2), account.toString()});
            ContentResolver.requestSync(account, str, bundle);
        }
    }

    public static void m23257a(Account account, String str, int i) {
        if (account != null) {
            if (account.name != null) {
                if (!m23260b(account.name, i)) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("com.reddit.frontpage.sync_id", i);
                    bundle.putBoolean("force", true);
                    bundle.putBoolean("expedited", true);
                    Timber.b("Requesting expedited sync %d for %s", new Object[]{Integer.valueOf(i), account.toString()});
                    ContentResolver.requestSync(account, str, bundle);
                    return;
                }
                return;
            }
        }
        RedditLogger.m21983a(new IllegalStateException(), "Requested sync with null account or null account name!");
    }

    private static boolean m23260b(String str, int i) {
        if (System.currentTimeMillis() - InternalSettings.a().a.getLong(InternalSettings.a(str, i), 0) >= 120000) {
            return false;
        }
        Timber.b("Will not perform automatic sync for ID [%d] due to being in blackout period", new Object[]{Integer.valueOf(i)});
        return true;
    }
}
