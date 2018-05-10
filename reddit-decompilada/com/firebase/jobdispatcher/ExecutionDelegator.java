package com.firebase.jobdispatcher;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.lang.ref.WeakReference;

class ExecutionDelegator {
    static final SimpleArrayMap<JobInvocation, JobServiceConnection> f3844a = new SimpleArrayMap();
    final ResponseHandler f3845b = new ResponseHandler(Looper.getMainLooper(), new WeakReference(this));
    private final Context f3846c;
    private final JobFinishedCallback f3847d;

    interface JobFinishedCallback {
        void mo1244a(JobInvocation jobInvocation, int i);
    }

    static class ResponseHandler extends Handler {
        private final WeakReference<ExecutionDelegator> f3843a;

        ResponseHandler(Looper looper, WeakReference<ExecutionDelegator> weakReference) {
            super(looper);
            this.f3843a = weakReference;
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                StringBuilder stringBuilder = new StringBuilder("handleMessage: unknown message type received: ");
                stringBuilder.append(message.what);
                Log.wtf("FJD.ExternalReceiver", stringBuilder.toString());
            } else if (message.obj instanceof JobInvocation) {
                ExecutionDelegator executionDelegator = (ExecutionDelegator) this.f3843a.get();
                if (executionDelegator == null) {
                    Log.wtf("FJD.ExternalReceiver", "handleMessage: service was unexpectedly GC'd, can't send job result");
                } else {
                    ExecutionDelegator.m3456a(executionDelegator, (JobInvocation) message.obj, message.arg1);
                }
            } else {
                Log.wtf("FJD.ExternalReceiver", "handleMessage: unknown obj returned");
            }
        }
    }

    ExecutionDelegator(Context context, JobFinishedCallback jobFinishedCallback) {
        this.f3846c = context;
        this.f3847d = jobFinishedCallback;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m3458a(com.firebase.jobdispatcher.JobInvocation r8) {
        /*
        r7 = this;
        if (r8 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = f3844a;
        monitor-enter(r0);
        r1 = f3844a;	 Catch:{ all -> 0x0067 }
        r1 = r1.get(r8);	 Catch:{ all -> 0x0067 }
        r1 = (com.firebase.jobdispatcher.JobServiceConnection) r1;	 Catch:{ all -> 0x0067 }
        if (r1 == 0) goto L_0x0022;
    L_0x0010:
        r2 = r1.m3500b();	 Catch:{ all -> 0x0067 }
        if (r2 != 0) goto L_0x001e;
    L_0x0016:
        r2 = r1.m3499a();	 Catch:{ all -> 0x0067 }
        if (r2 != 0) goto L_0x001e;
    L_0x001c:
        monitor-exit(r0);	 Catch:{ all -> 0x0067 }
        return;
    L_0x001e:
        r2 = 0;
        r1.m3498a(r2);	 Catch:{ all -> 0x0067 }
    L_0x0022:
        r1 = new com.firebase.jobdispatcher.JobServiceConnection;	 Catch:{ all -> 0x0067 }
        r2 = r7.f3845b;	 Catch:{ all -> 0x0067 }
        r3 = 1;
        r2 = r2.obtainMessage(r3);	 Catch:{ all -> 0x0067 }
        r4 = r7.f3846c;	 Catch:{ all -> 0x0067 }
        r1.<init>(r8, r2, r4);	 Catch:{ all -> 0x0067 }
        r2 = f3844a;	 Catch:{ all -> 0x0067 }
        r2.put(r8, r1);	 Catch:{ all -> 0x0067 }
        r2 = r7.f3846c;	 Catch:{ all -> 0x0067 }
        r4 = new android.content.Intent;	 Catch:{ all -> 0x0067 }
        r5 = "com.firebase.jobdispatcher.ACTION_EXECUTE";
        r4.<init>(r5);	 Catch:{ all -> 0x0067 }
        r5 = r7.f3846c;	 Catch:{ all -> 0x0067 }
        r6 = r8.mo1253i();	 Catch:{ all -> 0x0067 }
        r4.setClassName(r5, r6);	 Catch:{ all -> 0x0067 }
        r2 = r2.bindService(r4, r1, r3);	 Catch:{ all -> 0x0067 }
        if (r2 != 0) goto L_0x0065;
    L_0x004d:
        r2 = "FJD.ExternalReceiver";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0067 }
        r4 = "Unable to bind to ";
        r3.<init>(r4);	 Catch:{ all -> 0x0067 }
        r8 = r8.f12732b;	 Catch:{ all -> 0x0067 }
        r3.append(r8);	 Catch:{ all -> 0x0067 }
        r8 = r3.toString();	 Catch:{ all -> 0x0067 }
        android.util.Log.e(r2, r8);	 Catch:{ all -> 0x0067 }
        r1.m3501c();	 Catch:{ all -> 0x0067 }
    L_0x0065:
        monitor-exit(r0);	 Catch:{ all -> 0x0067 }
        return;
    L_0x0067:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0067 }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.ExecutionDelegator.a(com.firebase.jobdispatcher.JobInvocation):void");
    }

    static void m3457a(JobInvocation jobInvocation, boolean z) {
        synchronized (f3844a) {
            JobServiceConnection jobServiceConnection = (JobServiceConnection) f3844a.remove(jobInvocation);
            if (jobServiceConnection != null) {
                jobServiceConnection.m3498a(z);
            }
        }
    }

    static /* synthetic */ void m3456a(ExecutionDelegator executionDelegator, JobInvocation jobInvocation, int i) {
        synchronized (f3844a) {
            JobServiceConnection jobServiceConnection = (JobServiceConnection) f3844a.remove(jobInvocation);
            if (jobServiceConnection != null) {
                jobServiceConnection.m3501c();
            }
        }
        executionDelegator.f3847d.mo1244a(jobInvocation, i);
    }
}
