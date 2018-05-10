package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class zzw extends Handler {
    private /* synthetic */ zzv f8683a;

    zzw(zzv com_google_firebase_iid_zzv, Looper looper) {
        this.f8683a = com_google_firebase_iid_zzv;
        super(looper);
    }

    public final void handleMessage(Message message) {
        zzv.m7410a(this.f8683a, message);
    }
}
