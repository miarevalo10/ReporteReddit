package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Binder;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class JobService extends Service {
    final SimpleArrayMap<String, JobCallback> f3868a = new SimpleArrayMap(1);
    private final LocalBinder f3869b = new LocalBinder(this);

    private static final class JobCallback {
        public final Message f3866a;

        private JobCallback(Message message) {
            this.f3866a = message;
        }

        final void m3494a(int i) {
            this.f3866a.arg1 = i;
            this.f3866a.sendToTarget();
        }
    }

    class LocalBinder extends Binder {
        final /* synthetic */ JobService f3867a;

        LocalBinder(JobService jobService) {
            this.f3867a = jobService;
        }
    }

    public abstract boolean m3496a(JobParameters jobParameters);

    public abstract boolean m3497b(JobParameters jobParameters);

    public final void onStart(Intent intent, int i) {
    }

    public final void m3495a(JobParameters jobParameters, boolean z) {
        if (jobParameters == null) {
            Log.e("FJD.JobService", "jobFinished called with a null JobParameters");
            return;
        }
        synchronized (this.f3868a) {
            JobCallback jobCallback = (JobCallback) this.f3868a.remove(jobParameters.mo1249e());
            if (jobCallback != null) {
                jobCallback.m3494a(z);
            }
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        stopSelf(i2);
        return 2;
    }

    public final IBinder onBind(Intent intent) {
        return this.f3869b;
    }

    public final boolean onUnbind(Intent intent) {
        synchronized (this.f3868a) {
            for (int size = this.f3868a.size() - 1; size >= 0; size--) {
                JobCallback jobCallback = (JobCallback) this.f3868a.remove(this.f3868a.m1053b(size));
                if (jobCallback != null) {
                    jobCallback.m3494a(m3497b((JobParameters) jobCallback.f3866a.obj) ? 1 : 2);
                }
            }
        }
        return super.onUnbind(intent);
    }

    public final void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    protected final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(fileDescriptor, printWriter, strArr);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
    }
}
