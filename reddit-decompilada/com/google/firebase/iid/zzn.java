package com.google.firebase.iid;

final /* synthetic */ class zzn implements Runnable {
    private final zzk f8660a;

    zzn(zzk com_google_firebase_iid_zzk) {
        this.f8660a = com_google_firebase_iid_zzk;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r8 = this;
        r0 = r8.f8660a;
    L_0x0002:
        monitor-enter(r0);
        r1 = r0.f8652a;	 Catch:{ all -> 0x00c8 }
        r2 = 2;
        if (r1 == r2) goto L_0x000a;
    L_0x0008:
        monitor-exit(r0);	 Catch:{ all -> 0x00c8 }
        return;
    L_0x000a:
        r1 = r0.f8655d;	 Catch:{ all -> 0x00c8 }
        r1 = r1.isEmpty();	 Catch:{ all -> 0x00c8 }
        if (r1 == 0) goto L_0x0017;
    L_0x0012:
        r0.m7390a();	 Catch:{ all -> 0x00c8 }
        monitor-exit(r0);	 Catch:{ all -> 0x00c8 }
        return;
    L_0x0017:
        r1 = r0.f8655d;	 Catch:{ all -> 0x00c8 }
        r1 = r1.poll();	 Catch:{ all -> 0x00c8 }
        r1 = (com.google.firebase.iid.zzr) r1;	 Catch:{ all -> 0x00c8 }
        r3 = r0.f8656e;	 Catch:{ all -> 0x00c8 }
        r4 = r1.f8665a;	 Catch:{ all -> 0x00c8 }
        r3.put(r4, r1);	 Catch:{ all -> 0x00c8 }
        r3 = r0.f8657f;	 Catch:{ all -> 0x00c8 }
        r3 = r3.f8649c;	 Catch:{ all -> 0x00c8 }
        r4 = new com.google.firebase.iid.zzo;	 Catch:{ all -> 0x00c8 }
        r4.<init>(r0, r1);	 Catch:{ all -> 0x00c8 }
        r5 = 30;
        r7 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ all -> 0x00c8 }
        r3.schedule(r4, r5, r7);	 Catch:{ all -> 0x00c8 }
        monitor-exit(r0);	 Catch:{ all -> 0x00c8 }
        r3 = "MessengerIpcClient";
        r4 = 3;
        r3 = android.util.Log.isLoggable(r3, r4);
        if (r3 == 0) goto L_0x0067;
    L_0x0042:
        r3 = "MessengerIpcClient";
        r4 = java.lang.String.valueOf(r1);
        r5 = 8;
        r6 = java.lang.String.valueOf(r4);
        r6 = r6.length();
        r5 = r5 + r6;
        r6 = new java.lang.StringBuilder;
        r6.<init>(r5);
        r5 = "Sending ";
        r6.append(r5);
        r6.append(r4);
        r4 = r6.toString();
        android.util.Log.d(r3, r4);
    L_0x0067:
        r3 = r0.f8657f;
        r3 = r3.f8648b;
        r4 = r0.f8653b;
        r5 = android.os.Message.obtain();
        r6 = r1.f8667c;
        r5.what = r6;
        r6 = r1.f8665a;
        r5.arg1 = r6;
        r5.replyTo = r4;
        r4 = new android.os.Bundle;
        r4.<init>();
        r6 = "oneWay";
        r7 = r1.mo2454a();
        r4.putBoolean(r6, r7);
        r6 = "pkg";
        r3 = r3.getPackageName();
        r4.putString(r6, r3);
        r3 = "data";
        r1 = r1.f8668d;
        r4.putBundle(r3, r1);
        r5.setData(r4);
        r1 = r0.f8654c;	 Catch:{ RemoteException -> 0x00be }
        r3 = r1.f8663a;	 Catch:{ RemoteException -> 0x00be }
        if (r3 == 0) goto L_0x00ab;
    L_0x00a4:
        r1 = r1.f8663a;	 Catch:{ RemoteException -> 0x00be }
        r1.send(r5);	 Catch:{ RemoteException -> 0x00be }
        goto L_0x0002;
    L_0x00ab:
        r3 = r1.f8664b;	 Catch:{ RemoteException -> 0x00be }
        if (r3 == 0) goto L_0x00b6;
    L_0x00af:
        r1 = r1.f8664b;	 Catch:{ RemoteException -> 0x00be }
        r1.m13134a(r5);	 Catch:{ RemoteException -> 0x00be }
        goto L_0x0002;
    L_0x00b6:
        r1 = new java.lang.IllegalStateException;	 Catch:{ RemoteException -> 0x00be }
        r3 = "Both messengers are null";
        r1.<init>(r3);	 Catch:{ RemoteException -> 0x00be }
        throw r1;	 Catch:{ RemoteException -> 0x00be }
    L_0x00be:
        r1 = move-exception;
        r1 = r1.getMessage();
        r0.m7392a(r2, r1);
        goto L_0x0002;
    L_0x00c8:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00c8 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzn.run():void");
    }
}
