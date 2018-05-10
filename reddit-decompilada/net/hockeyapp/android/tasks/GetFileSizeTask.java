package net.hockeyapp.android.tasks;

import android.content.Context;
import java.net.URL;
import net.hockeyapp.android.listeners.DownloadFileListener;
import net.hockeyapp.android.utils.HockeyLog;

public class GetFileSizeTask extends DownloadFileTask {
    public long f33150g;

    protected final void mo5958a(Integer... numArr) {
    }

    protected /* bridge */ /* synthetic */ void onProgressUpdate(Object[] objArr) {
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return mo5956a();
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        mo5957a((Long) obj);
    }

    public GetFileSizeTask(Context context, String str, DownloadFileListener downloadFileListener) {
        super(context, str, downloadFileListener);
    }

    protected final Long mo5956a() {
        try {
            return Long.valueOf((long) DownloadFileTask.m28195a(new URL(m28199b()), 6).getContentLength());
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("Failed to get size ");
            stringBuilder.append(this.c);
            HockeyLog.m28206a(stringBuilder.toString(), e);
            return Long.valueOf(0);
        }
    }

    protected final void mo5957a(Long l) {
        this.f33150g = l.longValue();
        if (this.f33150g > 0) {
            this.b.mo5953a((DownloadFileTask) this);
        } else {
            this.b.mo5954a(Boolean.valueOf(false));
        }
    }
}
