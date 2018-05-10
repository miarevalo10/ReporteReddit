package com.google.firebase.iid;

import android.util.Log;

final class zzg implements Runnable {
    private /* synthetic */ zzd f8639a;
    private /* synthetic */ zzf f8640b;

    zzg(zzf com_google_firebase_iid_zzf, zzd com_google_firebase_iid_zzd) {
        this.f8640b = com_google_firebase_iid_zzf;
        this.f8639a = com_google_firebase_iid_zzd;
    }

    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.f8640b.f8638a.mo2452b(this.f8639a.f8632a);
        this.f8639a.m7379a();
    }
}
