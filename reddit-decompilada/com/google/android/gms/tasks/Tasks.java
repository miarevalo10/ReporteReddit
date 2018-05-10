package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.zzbq;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {

    interface zzb extends OnFailureListener, OnSuccessListener<Object> {
    }

    static final class zza implements zzb {
        final CountDownLatch f18407a;

        private zza() {
            this.f18407a = new CountDownLatch(1);
        }

        public final void mo3580a() {
            this.f18407a.countDown();
        }

        public final void mo3581b() {
            this.f18407a.countDown();
        }
    }

    public static <TResult> Task<TResult> m6861a(Exception exception) {
        Task com_google_android_gms_tasks_zzn = new zzn();
        com_google_android_gms_tasks_zzn.m14527a(exception);
        return com_google_android_gms_tasks_zzn;
    }

    public static <TResult> Task<TResult> m6862a(TResult tResult) {
        Task com_google_android_gms_tasks_zzn = new zzn();
        com_google_android_gms_tasks_zzn.m14528a((Object) tResult);
        return com_google_android_gms_tasks_zzn;
    }

    public static <TResult> Task<TResult> m6863a(Executor executor, Callable<TResult> callable) {
        zzbq.m4809a((Object) executor, (Object) "Executor must not be null");
        zzbq.m4809a((Object) callable, (Object) "Callback must not be null");
        Task com_google_android_gms_tasks_zzn = new zzn();
        executor.execute(new zzo(com_google_android_gms_tasks_zzn, callable));
        return com_google_android_gms_tasks_zzn;
    }

    private static void m6866a(Task<?> task, zzb com_google_android_gms_tasks_Tasks_zzb) {
        task.mo2309a(TaskExecutors.f8214b, (OnSuccessListener) com_google_android_gms_tasks_Tasks_zzb);
        task.mo2308a(TaskExecutors.f8214b, (OnFailureListener) com_google_android_gms_tasks_Tasks_zzb);
    }

    private static <TResult> TResult m6867b(Task<TResult> task) throws ExecutionException {
        if (task.mo2311b()) {
            return task.mo2312c();
        }
        throw new ExecutionException(task.mo2313d());
    }

    public static <TResult> TResult m6864a(Task<TResult> task) throws ExecutionException, InterruptedException {
        zzbq.m4820c("Must not be called on the main application thread");
        zzbq.m4809a((Object) task, (Object) "Task must not be null");
        if (task.mo2310a()) {
            return m6867b(task);
        }
        zzb com_google_android_gms_tasks_Tasks_zza = new zza();
        m6866a((Task) task, com_google_android_gms_tasks_Tasks_zza);
        com_google_android_gms_tasks_Tasks_zza.f18407a.await();
        return m6867b(task);
    }

    public static <TResult> TResult m6865a(Task<TResult> task, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        zzbq.m4820c("Must not be called on the main application thread");
        zzbq.m4809a((Object) task, (Object) "Task must not be null");
        zzbq.m4809a((Object) timeUnit, (Object) "TimeUnit must not be null");
        if (task.mo2310a()) {
            return m6867b(task);
        }
        zzb com_google_android_gms_tasks_Tasks_zza = new zza();
        m6866a((Task) task, com_google_android_gms_tasks_Tasks_zza);
        if (com_google_android_gms_tasks_Tasks_zza.f18407a.await(30000, timeUnit) != null) {
            return m6867b(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }
}
