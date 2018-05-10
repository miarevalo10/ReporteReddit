package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class zzi {
    private static zzi f8647a;
    private final Context f8648b;
    private final ScheduledExecutorService f8649c;
    private zzk f8650d = new zzk();
    private int f8651e = 1;

    private zzi(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f8649c = scheduledExecutorService;
        this.f8648b = context.getApplicationContext();
    }

    public static synchronized zzi m7384a(Context context) {
        zzi com_google_firebase_iid_zzi;
        synchronized (zzi.class) {
            if (f8647a == null) {
                f8647a = new zzi(context, Executors.newSingleThreadScheduledExecutor());
            }
            com_google_firebase_iid_zzi = f8647a;
        }
        return com_google_firebase_iid_zzi;
    }

    public final synchronized int m7386a() {
        int i;
        i = this.f8651e;
        this.f8651e = i + 1;
        return i;
    }

    public final synchronized <T> Task<T> m7387a(zzr<T> com_google_firebase_iid_zzr_T) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(com_google_firebase_iid_zzr_T);
            StringBuilder stringBuilder = new StringBuilder(9 + String.valueOf(valueOf).length());
            stringBuilder.append("Queueing ");
            stringBuilder.append(valueOf);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        if (!this.f8650d.m7394a((zzr) com_google_firebase_iid_zzr_T)) {
            this.f8650d = new zzk();
            this.f8650d.m7394a((zzr) com_google_firebase_iid_zzr_T);
        }
        return com_google_firebase_iid_zzr_T.f8666b.f8211a;
    }
}
