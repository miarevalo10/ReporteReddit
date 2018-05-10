package com.firebase.jobdispatcher;

import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class GooglePlayReceiver extends Service implements JobFinishedCallback {
    private static final JobCoder f12704d = new JobCoder("com.firebase.jobdispatcher.", true);
    private static final SimpleArrayMap<String, SimpleArrayMap<String, JobCallback>> f12705h = new SimpleArrayMap(1);
    Messenger f12706a;
    Driver f12707b;
    ValidationEnforcer f12708c;
    private final GooglePlayCallbackExtractor f12709e = new GooglePlayCallbackExtractor();
    private ExecutionDelegator f12710f;
    private int f12711g;

    private static void m11795a(JobCallback jobCallback, int i) {
        try {
            jobCallback.mo1243a(i);
        } catch (JobCallback jobCallback2) {
            Log.e("FJD.GooglePlayReceiver", "Encountered error running callback", jobCallback2.getCause());
        }
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            super.onStartCommand(intent, i, i2);
            if (intent == null) {
                Log.w("FJD.GooglePlayReceiver", "Null Intent passed, terminating");
                synchronized (f12705h) {
                    this.f12711g = i2;
                    if (f12705h.isEmpty() != 0) {
                        stopSelf(this.f12711g);
                    }
                }
                return 2;
            }
            String action = intent.getAction();
            if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(action)) {
                ExecutionDelegator a = m11800a();
                Bundle extras = intent.getExtras();
                JobInvocation jobInvocation = null;
                if (extras == null) {
                    Log.e("FJD.GooglePlayReceiver", "No data provided, terminating");
                } else {
                    intent = GooglePlayCallbackExtractor.m3462a(extras);
                    if (intent == null) {
                        Log.i("FJD.GooglePlayReceiver", "no callback found");
                    } else {
                        jobInvocation = m11793a((JobCallback) intent.first, (Bundle) intent.second);
                    }
                }
                a.m3458a(jobInvocation);
                synchronized (f12705h) {
                    this.f12711g = i2;
                    if (f12705h.isEmpty() != 0) {
                        stopSelf(this.f12711g);
                    }
                }
                return 2;
            } else if ("com.google.android.gms.gcm.SERVICE_ACTION_INITIALIZE".equals(action) != null) {
                synchronized (f12705h) {
                    this.f12711g = i2;
                    if (f12705h.isEmpty() != 0) {
                        stopSelf(this.f12711g);
                    }
                }
                return 2;
            } else {
                Log.e("FJD.GooglePlayReceiver", "Unknown action received, terminating");
                synchronized (f12705h) {
                    this.f12711g = i2;
                    if (f12705h.isEmpty() != 0) {
                        stopSelf(this.f12711g);
                    }
                }
                return 2;
            }
        } catch (Throwable th) {
            synchronized (f12705h) {
                this.f12711g = i2;
                if (f12705h.isEmpty() != 0) {
                    stopSelf(this.f12711g);
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        if (intent != null && VERSION.SDK_INT >= 21) {
            if ("com.google.android.gms.gcm.ACTION_TASK_READY".equals(intent.getAction()) != null) {
                return m11797c().getBinder();
            }
        }
        return null;
    }

    private synchronized Messenger m11797c() {
        if (this.f12706a == null) {
            this.f12706a = new Messenger(new GooglePlayMessageHandler(Looper.getMainLooper(), this));
        }
        return this.f12706a;
    }

    final synchronized ExecutionDelegator m11800a() {
        if (this.f12710f == null) {
            this.f12710f = new ExecutionDelegator(this, this);
        }
        return this.f12710f;
    }

    private synchronized Driver m11798d() {
        if (this.f12707b == null) {
            this.f12707b = new GooglePlayDriver(getApplicationContext());
        }
        return this.f12707b;
    }

    private synchronized ValidationEnforcer m11799e() {
        if (this.f12708c == null) {
            this.f12708c = new ValidationEnforcer(m11798d().mo1242a());
        }
        return this.f12708c;
    }

    static JobInvocation m11793a(JobCallback jobCallback, Bundle bundle) {
        SimpleArrayMap simpleArrayMap;
        JobCoder jobCoder = f12704d;
        if (bundle == null) {
            Log.e("FJD.ExternalReceiver", "Unexpected null Bundle provided");
        } else {
            Bundle bundle2 = bundle.getBundle("extras");
            if (bundle2 != null) {
                Builder a = jobCoder.m3473a(bundle2);
                bundle = bundle.getParcelableArrayList("triggered_uris");
                if (bundle != null) {
                    a.f3865j = new TriggerReason(bundle);
                }
                bundle = a.m3484a();
                if (bundle != null) {
                    Log.e("FJD.GooglePlayReceiver", "unable to decode job");
                    m11795a(jobCallback, 2);
                    return null;
                }
                synchronized (f12705h) {
                    simpleArrayMap = (SimpleArrayMap) f12705h.get(bundle.f12732b);
                    if (simpleArrayMap == null) {
                        simpleArrayMap = new SimpleArrayMap(1);
                        f12705h.put(bundle.f12732b, simpleArrayMap);
                    }
                    simpleArrayMap.put(bundle.f12731a, jobCallback);
                }
                return bundle;
            }
        }
        bundle = null;
        if (bundle != null) {
            synchronized (f12705h) {
                simpleArrayMap = (SimpleArrayMap) f12705h.get(bundle.f12732b);
                if (simpleArrayMap == null) {
                    simpleArrayMap = new SimpleArrayMap(1);
                    f12705h.put(bundle.f12732b, simpleArrayMap);
                }
                simpleArrayMap.put(bundle.f12731a, jobCallback);
            }
            return bundle;
        }
        Log.e("FJD.GooglePlayReceiver", "unable to decode job");
        m11795a(jobCallback, 2);
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo1244a(com.firebase.jobdispatcher.JobInvocation r6, int r7) {
        /*
        r5 = this;
        r0 = f12705h;
        monitor-enter(r0);
        r1 = f12705h;	 Catch:{ all -> 0x00a9 }
        r2 = r6.f12732b;	 Catch:{ all -> 0x00a9 }
        r1 = r1.get(r2);	 Catch:{ all -> 0x00a9 }
        r1 = (android.support.v4.util.SimpleArrayMap) r1;	 Catch:{ all -> 0x00a9 }
        if (r1 != 0) goto L_0x001e;
    L_0x000f:
        r6 = f12705h;	 Catch:{ all -> 0x00b8 }
        r6 = r6.isEmpty();	 Catch:{ all -> 0x00b8 }
        if (r6 == 0) goto L_0x001c;
    L_0x0017:
        r6 = r5.f12711g;	 Catch:{ all -> 0x00b8 }
        r5.stopSelf(r6);	 Catch:{ all -> 0x00b8 }
    L_0x001c:
        monitor-exit(r0);	 Catch:{ all -> 0x00b8 }
        return;
    L_0x001e:
        r2 = r6.f12731a;	 Catch:{ all -> 0x00a9 }
        r2 = r1.remove(r2);	 Catch:{ all -> 0x00a9 }
        r2 = (com.firebase.jobdispatcher.JobCallback) r2;	 Catch:{ all -> 0x00a9 }
        if (r2 != 0) goto L_0x0037;
    L_0x0028:
        r6 = f12705h;	 Catch:{ all -> 0x00b8 }
        r6 = r6.isEmpty();	 Catch:{ all -> 0x00b8 }
        if (r6 == 0) goto L_0x0035;
    L_0x0030:
        r6 = r5.f12711g;	 Catch:{ all -> 0x00b8 }
        r5.stopSelf(r6);	 Catch:{ all -> 0x00b8 }
    L_0x0035:
        monitor-exit(r0);	 Catch:{ all -> 0x00b8 }
        return;
    L_0x0037:
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00a9 }
        if (r1 == 0) goto L_0x0044;
    L_0x003d:
        r1 = f12705h;	 Catch:{ all -> 0x00a9 }
        r3 = r6.f12732b;	 Catch:{ all -> 0x00a9 }
        r1.remove(r3);	 Catch:{ all -> 0x00a9 }
    L_0x0044:
        r1 = r6.mo1252h();	 Catch:{ all -> 0x00a9 }
        r3 = 1;
        if (r1 == 0) goto L_0x0057;
    L_0x004b:
        r1 = r6.mo1250f();	 Catch:{ all -> 0x00a9 }
        r1 = r1 instanceof com.firebase.jobdispatcher.JobTrigger.ContentUriTrigger;	 Catch:{ all -> 0x00a9 }
        if (r1 == 0) goto L_0x0057;
    L_0x0053:
        if (r7 == r3) goto L_0x0057;
    L_0x0055:
        r1 = r3;
        goto L_0x0058;
    L_0x0057:
        r1 = 0;
    L_0x0058:
        if (r1 == 0) goto L_0x0071;
    L_0x005a:
        r7 = new com.firebase.jobdispatcher.Job$Builder;	 Catch:{ all -> 0x00a9 }
        r1 = r5.m11799e();	 Catch:{ all -> 0x00a9 }
        r7.<init>(r1, r6);	 Catch:{ all -> 0x00a9 }
        r7.f12716e = r3;	 Catch:{ all -> 0x00a9 }
        r6 = r7.m11827k();	 Catch:{ all -> 0x00a9 }
        r7 = r5.m11798d();	 Catch:{ all -> 0x00a9 }
        r7.mo1241a(r6);	 Catch:{ all -> 0x00a9 }
        goto L_0x009a;
    L_0x0071:
        r1 = "FJD.GooglePlayReceiver";
        r3 = 2;
        r1 = android.util.Log.isLoggable(r1, r3);	 Catch:{ all -> 0x00a9 }
        if (r1 == 0) goto L_0x0097;
    L_0x007a:
        r1 = "FJD.GooglePlayReceiver";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a9 }
        r4 = "sending jobFinished for ";
        r3.<init>(r4);	 Catch:{ all -> 0x00a9 }
        r6 = r6.f12731a;	 Catch:{ all -> 0x00a9 }
        r3.append(r6);	 Catch:{ all -> 0x00a9 }
        r6 = " = ";
        r3.append(r6);	 Catch:{ all -> 0x00a9 }
        r3.append(r7);	 Catch:{ all -> 0x00a9 }
        r6 = r3.toString();	 Catch:{ all -> 0x00a9 }
        android.util.Log.v(r1, r6);	 Catch:{ all -> 0x00a9 }
    L_0x0097:
        m11795a(r2, r7);	 Catch:{ all -> 0x00a9 }
    L_0x009a:
        r6 = f12705h;	 Catch:{ all -> 0x00b8 }
        r6 = r6.isEmpty();	 Catch:{ all -> 0x00b8 }
        if (r6 == 0) goto L_0x00a7;
    L_0x00a2:
        r6 = r5.f12711g;	 Catch:{ all -> 0x00b8 }
        r5.stopSelf(r6);	 Catch:{ all -> 0x00b8 }
    L_0x00a7:
        monitor-exit(r0);	 Catch:{ all -> 0x00b8 }
        return;
    L_0x00a9:
        r6 = move-exception;
        r7 = f12705h;	 Catch:{ all -> 0x00b8 }
        r7 = r7.isEmpty();	 Catch:{ all -> 0x00b8 }
        if (r7 == 0) goto L_0x00b7;
    L_0x00b2:
        r7 = r5.f12711g;	 Catch:{ all -> 0x00b8 }
        r5.stopSelf(r7);	 Catch:{ all -> 0x00b8 }
    L_0x00b7:
        throw r6;	 Catch:{ all -> 0x00b8 }
    L_0x00b8:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00b8 }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.jobdispatcher.GooglePlayReceiver.a(com.firebase.jobdispatcher.JobInvocation, int):void");
    }

    static JobCoder m11796b() {
        return f12704d;
    }

    static void m11794a(Job job) {
        synchronized (f12705h) {
            SimpleArrayMap simpleArrayMap = (SimpleArrayMap) f12705h.get(job.f12722a);
            if (simpleArrayMap == null) {
            } else if (((JobCallback) simpleArrayMap.get(job.f12723b)) == null) {
            } else {
                Builder builder = new Builder();
                builder.f3856a = job.f12723b;
                builder.f3857b = job.f12722a;
                builder.f3858c = job.f12724c;
                ExecutionDelegator.m3457a(builder.m3484a(), false);
            }
        }
    }
}
