package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

final class zze implements Runnable {
    private /* synthetic */ Intent f8636a;
    private /* synthetic */ zzd f8637b;

    zze(zzd com_google_firebase_iid_zzd, Intent intent) {
        this.f8637b = com_google_firebase_iid_zzd;
        this.f8636a = intent;
    }

    public final void run() {
        String action = this.f8636a.getAction();
        StringBuilder stringBuilder = new StringBuilder(61 + String.valueOf(action).length());
        stringBuilder.append("Service took too long to process intent: ");
        stringBuilder.append(action);
        stringBuilder.append(" App may get closed.");
        Log.w("EnhancedIntentService", stringBuilder.toString());
        this.f8637b.m7379a();
    }
}
