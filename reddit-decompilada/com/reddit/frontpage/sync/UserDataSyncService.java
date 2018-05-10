package com.reddit.frontpage.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.reddit.frontpage.FrontpageApplication;

public class UserDataSyncService extends Service {
    private static final Object f21054a = new Object();
    private static RedditSyncAdapter f21055b;

    public void onCreate() {
        super.onCreate();
        synchronized (f21054a) {
            if (f21055b == null) {
                f21055b = new RedditSyncAdapter(FrontpageApplication.f27402a);
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return f21055b.getSyncAdapterBinder();
    }
}
