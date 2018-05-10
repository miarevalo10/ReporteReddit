package net.hockeyapp.android.utils;

import android.os.AsyncTask;
import java.util.concurrent.Executor;

public class AsyncTaskUtils {
    private static Executor f26599a;

    public static void m28200a(AsyncTask<Void, ?, ?> asyncTask) {
        asyncTask.executeOnExecutor(f26599a != null ? f26599a : AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
