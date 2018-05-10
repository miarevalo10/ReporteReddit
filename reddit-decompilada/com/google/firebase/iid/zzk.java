package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.stats.zza;
import java.util.ArrayDeque;
import java.util.Queue;

final class zzk implements ServiceConnection {
    int f8652a;
    final Messenger f8653b;
    zzp f8654c;
    final Queue<zzr<?>> f8655d;
    final SparseArray<zzr<?>> f8656e;
    final /* synthetic */ zzi f8657f;

    private zzk(zzi com_google_firebase_iid_zzi) {
        this.f8657f = com_google_firebase_iid_zzi;
        this.f8652a = 0;
        this.f8653b = new Messenger(new Handler(Looper.getMainLooper(), new zzl(this)));
        this.f8655d = new ArrayDeque();
        this.f8656e = new SparseArray();
    }

    private final void m7388a(zzs com_google_firebase_iid_zzs) {
        for (zzr a : this.f8655d) {
            a.m7397a(com_google_firebase_iid_zzs);
        }
        this.f8655d.clear();
        for (int i = 0; i < this.f8656e.size(); i++) {
            ((zzr) this.f8656e.valueAt(i)).m7397a(com_google_firebase_iid_zzs);
        }
        this.f8656e.clear();
    }

    private final void m7389c() {
        this.f8657f.f8649c.execute(new zzn(this));
    }

    final synchronized void m7390a() {
        if (this.f8652a == 2 && this.f8655d.isEmpty() && this.f8656e.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.f8652a = 3;
            zza.m4889a();
            this.f8657f.f8648b.unbindService(this);
        }
    }

    final synchronized void m7391a(int i) {
        zzr com_google_firebase_iid_zzr = (zzr) this.f8656e.get(i);
        if (com_google_firebase_iid_zzr != null) {
            StringBuilder stringBuilder = new StringBuilder(31);
            stringBuilder.append("Timing out request: ");
            stringBuilder.append(i);
            Log.w("MessengerIpcClient", stringBuilder.toString());
            this.f8656e.remove(i);
            com_google_firebase_iid_zzr.m7397a(new zzs(3, "Timed out waiting for response"));
            m7390a();
        }
    }

    final synchronized void m7392a(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String str2 = "MessengerIpcClient";
            String str3 = "Disconnected: ";
            String valueOf = String.valueOf(str);
            Log.d(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        switch (this.f8652a) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.f8652a = 4;
                zza.m4889a();
                this.f8657f.f8648b.unbindService(this);
                m7388a(new zzs(i, str));
                return;
            case 3:
                this.f8652a = 4;
                return;
            case 4:
                return;
            default:
                int i2 = this.f8652a;
                StringBuilder stringBuilder = new StringBuilder(26);
                stringBuilder.append("Unknown state: ");
                stringBuilder.append(i2);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final boolean m7393a(android.os.Message r5) {
        /*
        r4 = this;
        r0 = r5.arg1;
        r1 = "MessengerIpcClient";
        r2 = 3;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x0023;
    L_0x000b:
        r1 = "MessengerIpcClient";
        r2 = 41;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Received response to request: ";
        r3.append(r2);
        r3.append(r0);
        r2 = r3.toString();
        android.util.Log.d(r1, r2);
    L_0x0023:
        monitor-enter(r4);
        r1 = r4.f8656e;	 Catch:{ all -> 0x006f }
        r1 = r1.get(r0);	 Catch:{ all -> 0x006f }
        r1 = (com.google.firebase.iid.zzr) r1;	 Catch:{ all -> 0x006f }
        r2 = 1;
        if (r1 != 0) goto L_0x0049;
    L_0x002f:
        r5 = "MessengerIpcClient";
        r1 = 50;
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x006f }
        r3.<init>(r1);	 Catch:{ all -> 0x006f }
        r1 = "Received response for unknown request: ";
        r3.append(r1);	 Catch:{ all -> 0x006f }
        r3.append(r0);	 Catch:{ all -> 0x006f }
        r0 = r3.toString();	 Catch:{ all -> 0x006f }
        android.util.Log.w(r5, r0);	 Catch:{ all -> 0x006f }
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        return r2;
    L_0x0049:
        r3 = r4.f8656e;	 Catch:{ all -> 0x006f }
        r3.remove(r0);	 Catch:{ all -> 0x006f }
        r4.m7390a();	 Catch:{ all -> 0x006f }
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        r5 = r5.getData();
        r0 = "unsupported";
        r3 = 0;
        r0 = r5.getBoolean(r0, r3);
        if (r0 == 0) goto L_0x006b;
    L_0x005f:
        r5 = new com.google.firebase.iid.zzs;
        r0 = 4;
        r3 = "Not supported by GmsCore";
        r5.<init>(r0, r3);
        r1.m7397a(r5);
        return r2;
    L_0x006b:
        r1.mo2453a(r5);
        return r2;
    L_0x006f:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x006f }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzk.a(android.os.Message):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final synchronized boolean m7394a(com.google.firebase.iid.zzr r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.f8652a;	 Catch:{ all -> 0x008d }
        r1 = 0;
        r2 = 1;
        switch(r0) {
            case 0: goto L_0x001e;
            case 1: goto L_0x0017;
            case 2: goto L_0x000d;
            case 3: goto L_0x000b;
            case 4: goto L_0x000b;
            default: goto L_0x0008;
        };	 Catch:{ all -> 0x008d }
    L_0x0008:
        r6 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x008d }
        goto L_0x0074;
    L_0x000b:
        monitor-exit(r5);
        return r1;
    L_0x000d:
        r0 = r5.f8655d;	 Catch:{ all -> 0x008d }
        r0.add(r6);	 Catch:{ all -> 0x008d }
        r5.m7389c();	 Catch:{ all -> 0x008d }
        monitor-exit(r5);
        return r2;
    L_0x0017:
        r0 = r5.f8655d;	 Catch:{ all -> 0x008d }
        r0.add(r6);	 Catch:{ all -> 0x008d }
        monitor-exit(r5);
        return r2;
    L_0x001e:
        r0 = r5.f8655d;	 Catch:{ all -> 0x008d }
        r0.add(r6);	 Catch:{ all -> 0x008d }
        r6 = r5.f8652a;	 Catch:{ all -> 0x008d }
        if (r6 != 0) goto L_0x0029;
    L_0x0027:
        r6 = r2;
        goto L_0x002a;
    L_0x0029:
        r6 = r1;
    L_0x002a:
        com.google.android.gms.common.internal.zzbq.m4813a(r6);	 Catch:{ all -> 0x008d }
        r6 = "MessengerIpcClient";
        r0 = 2;
        r6 = android.util.Log.isLoggable(r6, r0);	 Catch:{ all -> 0x008d }
        if (r6 == 0) goto L_0x003d;
    L_0x0036:
        r6 = "MessengerIpcClient";
        r0 = "Starting bind to GmsCore";
        android.util.Log.v(r6, r0);	 Catch:{ all -> 0x008d }
    L_0x003d:
        r5.f8652a = r2;	 Catch:{ all -> 0x008d }
        r6 = new android.content.Intent;	 Catch:{ all -> 0x008d }
        r0 = "com.google.android.c2dm.intent.REGISTER";
        r6.<init>(r0);	 Catch:{ all -> 0x008d }
        r0 = "com.google.android.gms";
        r6.setPackage(r0);	 Catch:{ all -> 0x008d }
        com.google.android.gms.common.stats.zza.m4889a();	 Catch:{ all -> 0x008d }
        r0 = r5.f8657f;	 Catch:{ all -> 0x008d }
        r0 = r0.f8648b;	 Catch:{ all -> 0x008d }
        r6 = com.google.android.gms.common.stats.zza.m4891b(r0, r6, r5, r2);	 Catch:{ all -> 0x008d }
        if (r6 != 0) goto L_0x0060;
    L_0x005a:
        r6 = "Unable to bind to service";
        r5.m7392a(r1, r6);	 Catch:{ all -> 0x008d }
        goto L_0x0072;
    L_0x0060:
        r6 = r5.f8657f;	 Catch:{ all -> 0x008d }
        r6 = r6.f8649c;	 Catch:{ all -> 0x008d }
        r0 = new com.google.firebase.iid.zzm;	 Catch:{ all -> 0x008d }
        r0.<init>(r5);	 Catch:{ all -> 0x008d }
        r3 = 30;
        r1 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x008d }
        r6.schedule(r0, r3, r1);	 Catch:{ all -> 0x008d }
    L_0x0072:
        monitor-exit(r5);
        return r2;
    L_0x0074:
        r0 = r5.f8652a;	 Catch:{ all -> 0x008d }
        r1 = 26;
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008d }
        r2.<init>(r1);	 Catch:{ all -> 0x008d }
        r1 = "Unknown state: ";
        r2.append(r1);	 Catch:{ all -> 0x008d }
        r2.append(r0);	 Catch:{ all -> 0x008d }
        r0 = r2.toString();	 Catch:{ all -> 0x008d }
        r6.<init>(r0);	 Catch:{ all -> 0x008d }
        throw r6;	 Catch:{ all -> 0x008d }
    L_0x008d:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzk.a(com.google.firebase.iid.zzr):boolean");
    }

    final synchronized void m7395b() {
        if (this.f8652a == 1) {
            m7392a(1, "Timed out while binding");
        }
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            m7392a(0, "Null service connection");
            return;
        }
        try {
            this.f8654c = new zzp(iBinder);
            this.f8652a = 2;
            m7389c();
        } catch (RemoteException e) {
            m7392a(0, e.getMessage());
        }
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        m7392a(2, "Service disconnected");
    }
}
