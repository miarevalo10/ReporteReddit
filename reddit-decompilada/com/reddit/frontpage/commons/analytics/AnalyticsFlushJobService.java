package com.reddit.frontpage.commons.analytics;

import android.os.PowerManager;
import com.cookpad.puree.Puree;
import com.firebase.jobdispatcher.JobParameters;
import com.firebase.jobdispatcher.JobService;
import com.reddit.frontpage.FrontpageApplication;

public class AnalyticsFlushJobService extends JobService {
    public static final String f27443b = "AnalyticsFlushJobService";

    public final boolean m28910b(JobParameters jobParameters) {
        return false;
    }

    public final boolean m28909a(JobParameters jobParameters) {
        ((PowerManager) FrontpageApplication.f27402a.getSystemService("power")).newWakeLock(1, f27443b).acquire(7500);
        Puree.a();
        return null;
    }
}
