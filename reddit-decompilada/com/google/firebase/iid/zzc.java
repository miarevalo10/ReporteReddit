package com.google.firebase.iid;

import android.content.Intent;

final class zzc implements Runnable {
    private /* synthetic */ Intent f8629a;
    private /* synthetic */ Intent f8630b;
    private /* synthetic */ zzb f8631c;

    zzc(zzb com_google_firebase_iid_zzb, Intent intent, Intent intent2) {
        this.f8631c = com_google_firebase_iid_zzb;
        this.f8629a = intent;
        this.f8630b = intent2;
    }

    public final void run() {
        this.f8631c.mo2452b(this.f8629a);
        this.f8631c.m7375d(this.f8630b);
    }
}
