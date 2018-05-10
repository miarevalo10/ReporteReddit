package com.reddit.datalibrary.frontpage.job;

import android.content.Intent;
import android.net.Uri;
import com.birbit.android.jobqueue.Params;
import com.reddit.config.GlideApp;
import com.reddit.datalibrary.frontpage.data.common.busevents.BaseEvent;
import com.reddit.datalibrary.frontpage.data.common.busevents.ErrorEvent;
import com.reddit.frontpage.FrontpageApplication;
import com.reddit.frontpage.util.FileUtil;
import de.greenrobot.event.EventBus;
import java.io.File;
import timber.log.Timber;

public class SaveMediaJob extends BaseRedditJob {
    private final String f18793m;
    private final String f18794n;

    public static class SavedMediaEvent extends BaseEvent {
    }

    public static class SavedMediaErrorEvent extends ErrorEvent {
        public SavedMediaErrorEvent(Exception exception) {
            super(exception);
        }
    }

    public SaveMediaJob(String str, String str2) {
        Params a = new Params(1).m2535a();
        super(a);
        this.f18793m = str;
        this.f18794n = str2;
    }

    public final void mo3019b() throws Throwable {
        try {
            File file = (File) GlideApp.m8727a(FrontpageApplication.a).m19646b(this.f18793m).downloadOnly(-1, -1).get();
            File a = FileUtil.a(this.f18793m, this.f18794n);
            FileUtil.a(file, a);
            Timber.b("cache file source: %s", new Object[]{file.getAbsolutePath()});
            Timber.b("new file destination: %s", new Object[]{a.getAbsolutePath()});
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(a));
            FrontpageApplication.a.sendBroadcast(intent);
            EventBus.getDefault().post(new SavedMediaEvent());
            super.mo3019b();
        } catch (Exception e) {
            EventBus.getDefault().post(new SavedMediaErrorEvent(e));
        }
    }
}
