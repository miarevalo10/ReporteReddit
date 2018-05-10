package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

final class zzh extends Handler {
    private /* synthetic */ zzd f5935a;

    public zzh(zzd com_google_android_gms_common_internal_zzd, Looper looper) {
        this.f5935a = com_google_android_gms_common_internal_zzd;
        super(looper);
    }

    private static void m4867a(Message message) {
        ((zzi) message.obj).m4871c();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m4868b(android.os.Message r3) {
        /*
        r0 = r3.what;
        r1 = 1;
        r2 = 2;
        if (r0 == r2) goto L_0x0012;
    L_0x0006:
        r0 = r3.what;
        if (r0 == r1) goto L_0x0012;
    L_0x000a:
        r3 = r3.what;
        r0 = 7;
        if (r3 != r0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r3 = 0;
        return r3;
    L_0x0012:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzh.b(android.os.Message):boolean");
    }

    public final void handleMessage(Message message) {
        if (this.f5935a.f5916h.get() != message.arg1) {
            if (m4868b(message)) {
                m4867a(message);
            }
        } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !this.f5935a.m4854g()) {
            m4867a(message);
        } else if (message.what == 4) {
            this.f5935a.f5933y = new ConnectionResult(message.arg2);
            if (this.f5935a.m4839t() == null || this.f5935a.f5934z != null) {
                r7 = this.f5935a.f5933y != null ? this.f5935a.f5933y : new ConnectionResult(8);
                this.f5935a.f5915g.mo1579a(r7);
                this.f5935a.m4844a(r7);
                return;
            }
            this.f5935a.m4825a(3, null);
        } else if (message.what == 5) {
            r7 = this.f5935a.f5933y != null ? this.f5935a.f5933y : new ConnectionResult(8);
            this.f5935a.f5915g.mo1579a(r7);
            this.f5935a.m4844a(r7);
        } else {
            PendingIntent pendingIntent = null;
            if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, pendingIntent);
                this.f5935a.f5915g.mo1579a(connectionResult);
                this.f5935a.m4844a(connectionResult);
            } else if (message.what == 6) {
                this.f5935a.m4825a(5, null);
                if (this.f5935a.f5929u != null) {
                    this.f5935a.f5929u.mo1621a(message.arg2);
                }
                zzd com_google_android_gms_common_internal_zzd = this.f5935a;
                com_google_android_gms_common_internal_zzd.f5911c = message.arg2;
                com_google_android_gms_common_internal_zzd.f5912d = System.currentTimeMillis();
                this.f5935a.m4828a(5, 1, null);
            } else if (message.what == 2 && !this.f5935a.m4853f()) {
                m4867a(message);
            } else if (m4868b(message)) {
                ((zzi) message.obj).m4870b();
            } else {
                message = message.what;
                StringBuilder stringBuilder = new StringBuilder(45);
                stringBuilder.append("Don't know how to handle message: ");
                stringBuilder.append(message);
                Log.wtf("GmsClient", stringBuilder.toString(), new Exception());
            }
        }
    }
}
