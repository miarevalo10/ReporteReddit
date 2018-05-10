package android.support.v4.app;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.support.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class JobIntentService extends Service {
    static final Object f1083h = new Object();
    static final HashMap<ComponentName, WorkEnqueuer> f1084i = new HashMap();
    CompatJobEngine f1085a;
    WorkEnqueuer f1086b;
    CommandProcessor f1087c;
    boolean f1088d = false;
    boolean f1089e = false;
    boolean f1090f = false;
    final ArrayList<CompatWorkItem> f1091g;

    final class CommandProcessor extends AsyncTask<Void, Void, Void> {
        final /* synthetic */ JobIntentService f1079a;

        CommandProcessor(JobIntentService jobIntentService) {
            this.f1079a = jobIntentService;
        }

        protected final /* synthetic */ void onCancelled(Object obj) {
            this.f1079a.m654a();
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            this.f1079a.m654a();
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            while (true) {
                objArr = this.f1079a.m657b();
                if (objArr == null) {
                    return null;
                }
                this.f1079a.mo2910a(objArr.mo246a());
                objArr.mo247b();
            }
        }
    }

    interface CompatJobEngine {
        IBinder mo248a();

        GenericWorkItem mo249b();
    }

    interface GenericWorkItem {
        Intent mo246a();

        void mo247b();
    }

    static abstract class WorkEnqueuer {
        final ComponentName f1080c;
        boolean f1081d;
        int f1082e;

        public void mo242a() {
        }

        abstract void mo243a(Intent intent);

        public void mo244b() {
        }

        public void mo245c() {
        }

        WorkEnqueuer(ComponentName componentName) {
            this.f1080c = componentName;
        }

        final void m648a(int i) {
            if (!this.f1081d) {
                this.f1081d = true;
                this.f1082e = i;
            } else if (this.f1082e != i) {
                StringBuilder stringBuilder = new StringBuilder("Given job ID ");
                stringBuilder.append(i);
                stringBuilder.append(" is different than previous ");
                stringBuilder.append(this.f1082e);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
    }

    static final class CompatWorkEnqueuer extends WorkEnqueuer {
        boolean f11340a;
        boolean f11341b;
        private final Context f11342f;
        private final WakeLock f11343g;
        private final WakeLock f11344h;

        CompatWorkEnqueuer(Context context, ComponentName componentName) {
            super(componentName);
            this.f11342f = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(componentName.getClassName());
            stringBuilder.append(":launch");
            this.f11343g = powerManager.newWakeLock(1, stringBuilder.toString());
            this.f11343g.setReferenceCounted(false);
            stringBuilder = new StringBuilder();
            stringBuilder.append(componentName.getClassName());
            stringBuilder.append(":run");
            this.f11344h = powerManager.newWakeLock(1, stringBuilder.toString());
            this.f11344h.setReferenceCounted(false);
        }

        final void mo243a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.c);
            if (this.f11342f.startService(intent2) != null) {
                synchronized (this) {
                    if (this.f11340a == null) {
                        this.f11340a = true;
                        if (this.f11341b == null) {
                            this.f11343g.acquire(60000);
                        }
                    }
                }
            }
        }

        public final void mo242a() {
            synchronized (this) {
                this.f11340a = false;
            }
        }

        public final void mo244b() {
            synchronized (this) {
                if (!this.f11341b) {
                    this.f11341b = true;
                    this.f11344h.acquire(600000);
                    this.f11343g.release();
                }
            }
        }

        public final void mo245c() {
            synchronized (this) {
                if (this.f11341b) {
                    if (this.f11340a) {
                        this.f11343g.acquire(60000);
                    }
                    this.f11341b = false;
                    this.f11344h.release();
                }
            }
        }
    }

    final class CompatWorkItem implements GenericWorkItem {
        final Intent f11345a;
        final int f11346b;
        final /* synthetic */ JobIntentService f11347c;

        CompatWorkItem(JobIntentService jobIntentService, Intent intent, int i) {
            this.f11347c = jobIntentService;
            this.f11345a = intent;
            this.f11346b = i;
        }

        public final Intent mo246a() {
            return this.f11345a;
        }

        public final void mo247b() {
            this.f11347c.stopSelf(this.f11346b);
        }
    }

    @RequiresApi(26)
    static final class JobServiceEngineImpl extends JobServiceEngine implements CompatJobEngine {
        final JobIntentService f11350a;
        final Object f11351b = new Object();
        JobParameters f11352c;

        final class WrapperWorkItem implements GenericWorkItem {
            final JobWorkItem f11348a;
            final /* synthetic */ JobServiceEngineImpl f11349b;

            WrapperWorkItem(JobServiceEngineImpl jobServiceEngineImpl, JobWorkItem jobWorkItem) {
                this.f11349b = jobServiceEngineImpl;
                this.f11348a = jobWorkItem;
            }

            public final Intent mo246a() {
                return this.f11348a.getIntent();
            }

            public final void mo247b() {
                synchronized (this.f11349b.f11351b) {
                    if (this.f11349b.f11352c != null) {
                        this.f11349b.f11352c.completeWork(this.f11348a);
                    }
                }
            }
        }

        JobServiceEngineImpl(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f11350a = jobIntentService;
        }

        public final IBinder mo248a() {
            return getBinder();
        }

        public final boolean onStartJob(JobParameters jobParameters) {
            this.f11352c = jobParameters;
            this.f11350a.m656a(false);
            return true;
        }

        public final boolean onStopJob(JobParameters jobParameters) {
            jobParameters = this.f11350a;
            if (jobParameters.f1087c != null) {
                jobParameters.f1087c.cancel(jobParameters.f1088d);
            }
            jobParameters.f1089e = true;
            synchronized (this.f11351b) {
                this.f11352c = null;
            }
            return true;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.support.v4.app.JobIntentService.GenericWorkItem mo249b() {
            /*
            r3 = this;
            r0 = r3.f11351b;
            monitor-enter(r0);
            r1 = r3.f11352c;	 Catch:{ all -> 0x0027 }
            r2 = 0;
            if (r1 != 0) goto L_0x000a;
        L_0x0008:
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            return r2;
        L_0x000a:
            r1 = r3.f11352c;	 Catch:{ all -> 0x0027 }
            r1 = r1.dequeueWork();	 Catch:{ all -> 0x0027 }
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            if (r1 == 0) goto L_0x0026;
        L_0x0013:
            r0 = r1.getIntent();
            r2 = r3.f11350a;
            r2 = r2.getClassLoader();
            r0.setExtrasClassLoader(r2);
            r0 = new android.support.v4.app.JobIntentService$JobServiceEngineImpl$WrapperWorkItem;
            r0.<init>(r3, r1);
            return r0;
        L_0x0026:
            return r2;
        L_0x0027:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0027 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v4.app.JobIntentService.JobServiceEngineImpl.b():android.support.v4.app.JobIntentService$GenericWorkItem");
        }
    }

    @RequiresApi(26)
    static final class JobWorkEnqueuer extends WorkEnqueuer {
        private final JobInfo f11353a;
        private final JobScheduler f11354b;

        JobWorkEnqueuer(Context context, ComponentName componentName, int i) {
            super(componentName);
            m648a(i);
            this.f11353a = new Builder(i, this.c).setOverrideDeadline(0).build();
            this.f11354b = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        final void mo243a(Intent intent) {
            this.f11354b.enqueue(this.f11353a, new JobWorkItem(intent));
        }
    }

    public abstract void mo2910a(Intent intent);

    public JobIntentService() {
        if (VERSION.SDK_INT >= 26) {
            this.f1091g = null;
        } else {
            this.f1091g = new ArrayList();
        }
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT >= 26) {
            this.f1085a = new JobServiceEngineImpl(this);
            this.f1086b = null;
            return;
        }
        this.f1085a = null;
        this.f1086b = m652a((Context) this, new ComponentName(this, getClass()), false, 0);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.f1091g == 0) {
            return 2;
        }
        this.f1086b.mo242a();
        synchronized (this.f1091g) {
            ArrayList arrayList = this.f1091g;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new CompatWorkItem(this, intent, i2));
            m656a(true);
        }
        return 3;
    }

    public IBinder onBind(Intent intent) {
        return this.f1085a != null ? this.f1085a.mo248a() : null;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f1091g != null) {
            synchronized (this.f1091g) {
                this.f1090f = true;
                this.f1086b.mo245c();
            }
        }
    }

    public static void m653a(Context context, Class cls, int i, Intent intent) {
        ComponentName componentName = new ComponentName(context, cls);
        if (intent == null) {
            throw new IllegalArgumentException("work must not be null");
        }
        synchronized (f1083h) {
            context = m652a(context, componentName, true, i);
            context.m648a(i);
            context.mo243a(intent);
        }
    }

    private static WorkEnqueuer m652a(Context context, ComponentName componentName, boolean z, int i) {
        WorkEnqueuer workEnqueuer = (WorkEnqueuer) f1084i.get(componentName);
        if (workEnqueuer != null) {
            return workEnqueuer;
        }
        if (VERSION.SDK_INT < 26) {
            z = new CompatWorkEnqueuer(context, componentName);
        } else if (z) {
            z = new JobWorkEnqueuer(context, componentName, i);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        workEnqueuer = z;
        f1084i.put(componentName, workEnqueuer);
        return workEnqueuer;
    }

    final void m656a(boolean z) {
        if (this.f1087c == null) {
            this.f1087c = new CommandProcessor(this);
            if (this.f1086b != null && z) {
                this.f1086b.mo244b();
            }
            this.f1087c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    final void m654a() {
        if (this.f1091g != null) {
            synchronized (this.f1091g) {
                this.f1087c = null;
                if (this.f1091g != null && this.f1091g.size() > 0) {
                    m656a(false);
                } else if (!this.f1090f) {
                    this.f1086b.mo245c();
                }
            }
        }
    }

    final GenericWorkItem m657b() {
        if (this.f1085a != null) {
            return this.f1085a.mo249b();
        }
        synchronized (this.f1091g) {
            if (this.f1091g.size() > 0) {
                GenericWorkItem genericWorkItem = (GenericWorkItem) this.f1091g.remove(0);
                return genericWorkItem;
            }
            return null;
        }
    }
}
