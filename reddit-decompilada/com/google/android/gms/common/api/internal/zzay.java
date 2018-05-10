package com.google.android.gms.common.api.internal;

abstract class zzay implements Runnable {
    private /* synthetic */ zzao f5769a;

    private zzay(zzao com_google_android_gms_common_api_internal_zzao) {
        this.f5769a = com_google_android_gms_common_api_internal_zzao;
    }

    protected abstract void mo1580a();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r4 = this;
        r0 = r4.f5769a;
        r0 = r0.f13860b;
        r0.lock();
        r0 = java.lang.Thread.interrupted();	 Catch:{ RuntimeException -> 0x001f }
        if (r0 == 0) goto L_0x0019;
    L_0x000f:
        r0 = r4.f5769a;
        r0 = r0.f13860b;
        r0.unlock();
        return;
    L_0x0019:
        r4.mo1580a();	 Catch:{ RuntimeException -> 0x001f }
        goto L_0x000f;
    L_0x001d:
        r0 = move-exception;
        goto L_0x003c;
    L_0x001f:
        r0 = move-exception;
        r1 = r4.f5769a;	 Catch:{ all -> 0x001d }
        r1 = r1.f13859a;	 Catch:{ all -> 0x001d }
        r2 = r1.f17280e;	 Catch:{ all -> 0x001d }
        r3 = 2;
        r0 = r2.obtainMessage(r3, r0);	 Catch:{ all -> 0x001d }
        r1 = r1.f17280e;	 Catch:{ all -> 0x001d }
        r1.sendMessage(r0);	 Catch:{ all -> 0x001d }
        r0 = r4.f5769a;
        r0 = r0.f13860b;
        r0.unlock();
        return;
    L_0x003c:
        r1 = r4.f5769a;
        r1 = r1.f13860b;
        r1.unlock();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzay.run():void");
    }
}
