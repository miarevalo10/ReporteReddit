package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

final class zzab extends BroadcastReceiver {
    zzaa f8623a;

    public zzab(zzaa com_google_firebase_iid_zzaa) {
        this.f8623a = com_google_firebase_iid_zzaa;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f8623a != null && this.f8623a.m7373b()) {
            if (FirebaseInstanceId.m7359g()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.m7357a(this.f8623a, 0);
            this.f8623a.m7372a().unregisterReceiver(this);
            this.f8623a = null;
        }
    }
}
