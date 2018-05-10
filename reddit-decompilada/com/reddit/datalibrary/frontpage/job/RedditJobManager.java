package com.reddit.datalibrary.frontpage.job;

import android.content.Context;
import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.config.Configuration.Builder;
import com.birbit.android.jobqueue.log.CustomLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n\u0000R0\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@BX\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/reddit/datalibrary/frontpage/job/RedditJobManager;", "", "()V", "PRIORITY_DEFAULT", "", "PRIORITY_HIGH", "PRIORITY_IMMEDIATE", "PRIORITY_LOW", "<set-?>", "Lcom/birbit/android/jobqueue/JobManager;", "jobManager", "jobManager$annotations", "getJobManager", "()Lcom/birbit/android/jobqueue/JobManager;", "setJobManager", "(Lcom/birbit/android/jobqueue/JobManager;)V", "init", "", "context", "Landroid/content/Context;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: RedditJobManager.kt */
public final class RedditJobManager {
    public static final int f10807a = 1;
    public static final int f10808b = 500;
    public static final int f10809c = 1000;
    public static final int f10810d = Integer.MAX_VALUE;
    public static final RedditJobManager f10811e = new RedditJobManager();
    private static JobManager f10812f;

    private RedditJobManager() {
    }

    public static final JobManager m9150a() {
        return f10812f;
    }

    public static final void m9151a(Context context) {
        Intrinsics.b(context, "context");
        f10812f = new JobManager(new Builder(context).m2547a((CustomLogger) new RedditJobManager$init$config$1()).m2549c().m2548b().m2550d().m2546a().m2551e());
    }
}
