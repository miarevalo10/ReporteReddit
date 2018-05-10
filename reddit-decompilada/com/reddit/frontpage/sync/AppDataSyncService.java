package com.reddit.frontpage.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.reddit.frontpage.FrontpageApplication;

public class AppDataSyncService extends Service {
    private static final Object f21045a = new Object();
    private static RedditSyncAdapter f21046b;

    public void onCreate() {
        super.onCreate();
        if (f21046b == null) {
            synchronized (f21045a) {
                if (f21046b == null) {
                    f21046b = new RedditSyncAdapter(FrontpageApplication.f27402a);
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return f21046b.getSyncAdapterBinder();
    }
}
