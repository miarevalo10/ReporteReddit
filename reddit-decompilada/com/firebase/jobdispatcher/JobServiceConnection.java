package com.firebase.jobdispatcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Message;
import android.util.Log;

class JobServiceConnection implements ServiceConnection {
    private final JobInvocation f3870a;
    private final Message f3871b;
    private boolean f3872c = false;
    private final Context f3873d;
    private LocalBinder f3874e;

    JobServiceConnection(JobInvocation jobInvocation, Message message, Context context) {
        this.f3871b = message;
        this.f3870a = jobInvocation;
        this.f3871b.obj = this.f3870a;
        this.f3873d = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onServiceConnected(android.content.ComponentName r7, android.os.IBinder r8) {
        /*
        r6 = this;
        monitor-enter(r6);
        r7 = r8 instanceof com.firebase.jobdispatcher.JobService.LocalBinder;	 Catch:{ all -> 0x0082 }
        if (r7 != 0) goto L_0x000e;
    L_0x0005:
        r7 = "FJD.ExternalReceiver";
        r8 = "Unknown service connected";
        android.util.Log.w(r7, r8);	 Catch:{ all -> 0x0082 }
        monitor-exit(r6);
        return;
    L_0x000e:
        r7 = r6.f3874e;	 Catch:{ all -> 0x0082 }
        if (r7 != 0) goto L_0x0079;
    L_0x0012:
        r7 = r6.m3499a();	 Catch:{ all -> 0x0082 }
        if (r7 == 0) goto L_0x0019;
    L_0x0018:
        goto L_0x0079;
    L_0x0019:
        r8 = (com.firebase.jobdispatcher.JobService.LocalBinder) r8;	 Catch:{ all -> 0x0082 }
        r6.f3874e = r8;	 Catch:{ all -> 0x0082 }
        r7 = r6.f3874e;	 Catch:{ all -> 0x0082 }
        r7 = r7.f3867a;	 Catch:{ all -> 0x0082 }
        r8 = r6.f3870a;	 Catch:{ all -> 0x0082 }
        r0 = r6.f3871b;	 Catch:{ all -> 0x0082 }
        r1 = r7.f3868a;	 Catch:{ all -> 0x0082 }
        monitor-enter(r1);	 Catch:{ all -> 0x0082 }
        r2 = r7.f3868a;	 Catch:{ all -> 0x0076 }
        r3 = r8.mo1249e();	 Catch:{ all -> 0x0076 }
        r2 = r2.containsKey(r3);	 Catch:{ all -> 0x0076 }
        r3 = 0;
        if (r2 == 0) goto L_0x004e;
    L_0x0035:
        r7 = "FJD.JobService";
        r0 = java.util.Locale.US;	 Catch:{ all -> 0x0076 }
        r2 = "Job with tag = %s was already running.";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0076 }
        r8 = r8.mo1249e();	 Catch:{ all -> 0x0076 }
        r4[r3] = r8;	 Catch:{ all -> 0x0076 }
        r8 = java.lang.String.format(r0, r2, r4);	 Catch:{ all -> 0x0076 }
        android.util.Log.w(r7, r8);	 Catch:{ all -> 0x0076 }
        monitor-exit(r1);	 Catch:{ all -> 0x0076 }
        monitor-exit(r6);
        return;
    L_0x004e:
        r2 = r7.f3868a;	 Catch:{ all -> 0x0076 }
        r4 = r8.mo1249e();	 Catch:{ all -> 0x0076 }
        r5 = new com.firebase.jobdispatcher.JobService$JobCallback;	 Catch:{ all -> 0x0076 }
        r5.<init>(r0);	 Catch:{ all -> 0x0076 }
        r2.put(r4, r5);	 Catch:{ all -> 0x0076 }
        r0 = r7.m3496a(r8);	 Catch:{ all -> 0x0076 }
        if (r0 != 0) goto L_0x0073;
    L_0x0062:
        r7 = r7.f3868a;	 Catch:{ all -> 0x0076 }
        r8 = r8.mo1249e();	 Catch:{ all -> 0x0076 }
        r7 = r7.remove(r8);	 Catch:{ all -> 0x0076 }
        r7 = (com.firebase.jobdispatcher.JobService.JobCallback) r7;	 Catch:{ all -> 0x0076 }
        if (r7 == 0) goto L_0x0073;
    L_0x0070:
        r7.m3494a(r3);	 Catch:{ all -> 0x0076 }
    L_0x0073:
        monitor-exit(r1);	 Catch:{ all -> 0x0076 }
        monitor-exit(r6);
        return;
    L_0x0076:
        r7 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0076 }
        throw r7;	 Catch:{ all -> 0x0082 }
    L_0x0079:
        r7 = "FJD.ExternalReceiver";
        r8 = "Connection have been used already.";
        android.util.Log.w(r7, r8);	 Catch:{ all -> 0x0082 }
        monitor-exit(r6);
        return;
    L_0x0082:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.JobServiceConnection.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public synchronized void onServiceDisconnected(ComponentName componentName) {
        m3501c();
    }

    final synchronized boolean m3499a() {
        return this.f3872c;
    }

    final synchronized boolean m3500b() {
        return this.f3874e != null;
    }

    final synchronized void m3498a(boolean z) {
        if (m3499a()) {
            Log.w("FJD.ExternalReceiver", "Can't send stop request because service was unbound.");
            return;
        }
        if (this.f3874e != null) {
            JobService jobService = this.f3874e.f3867a;
            JobParameters jobParameters = this.f3870a;
            synchronized (jobService.f3868a) {
                JobCallback jobCallback = (JobCallback) jobService.f3868a.remove(jobParameters.f12731a);
                if (jobCallback == null) {
                    if (Log.isLoggable("FJD.JobService", 3)) {
                        Log.d("FJD.JobService", "Provided job has already been executed.");
                    }
                } else {
                    boolean b = jobService.m3497b(jobParameters);
                    if (z) {
                        jobCallback.m3494a(b);
                    }
                }
            }
        }
        m3501c();
    }

    final synchronized void m3501c() {
        if (!m3499a()) {
            this.f3874e = null;
            this.f3872c = true;
            try {
                this.f3873d.unbindService(this);
            } catch (IllegalArgumentException e) {
                StringBuilder stringBuilder = new StringBuilder("Error unbinding service: ");
                stringBuilder.append(e.getMessage());
                Log.w("FJD.ExternalReceiver", stringBuilder.toString());
            }
        }
    }
}
