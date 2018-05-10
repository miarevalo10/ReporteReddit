package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

public class FirebaseInstanceIdService extends zzb {
    protected final Intent mo2451a(Intent intent) {
        return (Intent) zzx.m7416a().f8685a.poll();
    }

    public void m14888a() {
    }

    public final void mo2452b(Intent intent) {
        if ("com.google.firebase.iid.TOKEN_REFRESH".equals(intent.getAction())) {
            m14888a();
            return;
        }
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                intent = String.valueOf(intent.getExtras());
                StringBuilder stringBuilder = new StringBuilder((21 + String.valueOf(stringExtra).length()) + String.valueOf(intent).length());
                stringBuilder.append("Received command: ");
                stringBuilder.append(stringExtra);
                stringBuilder.append(" - ");
                stringBuilder.append(intent);
                Log.d("FirebaseInstanceId", stringBuilder.toString());
            }
            if ("RST".equals(stringExtra) == null) {
                if ("RST_FULL".equals(stringExtra) == null) {
                    if ("SYNC".equals(stringExtra) != null) {
                        intent = FirebaseInstanceId.m7356a();
                        FirebaseInstanceId.f8610a.m7429d("");
                        intent.m7363b();
                    }
                }
            }
            FirebaseInstanceId.m7356a().m7367h();
        }
    }
}
