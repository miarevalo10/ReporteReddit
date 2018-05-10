package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.stats.zza;
import java.util.HashMap;

final class zzai extends zzag implements Callback {
    private final HashMap<zzah, zzaj> f13995a = new HashMap();
    private final Context f13996b;
    private final Handler f13997c;
    private final zza f13998d;
    private final long f13999e;
    private final long f14000f;

    zzai(Context context) {
        this.f13996b = context.getApplicationContext();
        this.f13997c = new Handler(context.getMainLooper(), this);
        this.f13998d = zza.m4889a();
        this.f13999e = 5000;
        this.f14000f = 300000;
    }

    protected final boolean mo1623a(zzah com_google_android_gms_common_internal_zzah, ServiceConnection serviceConnection) {
        zzbq.m4809a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f13995a) {
            zzaj com_google_android_gms_common_internal_zzaj = (zzaj) this.f13995a.get(com_google_android_gms_common_internal_zzah);
            if (com_google_android_gms_common_internal_zzaj != null) {
                this.f13997c.removeMessages(0, com_google_android_gms_common_internal_zzah);
                if (!com_google_android_gms_common_internal_zzaj.m4790b(serviceConnection)) {
                    com_google_android_gms_common_internal_zzaj.m4788a(serviceConnection);
                    switch (com_google_android_gms_common_internal_zzaj.f5884b) {
                        case 1:
                            serviceConnection.onServiceConnected(com_google_android_gms_common_internal_zzaj.f5888f, com_google_android_gms_common_internal_zzaj.f5886d);
                            break;
                        case 2:
                            com_google_android_gms_common_internal_zzaj.m4787a();
                            break;
                        default:
                            break;
                    }
                }
                com_google_android_gms_common_internal_zzah = String.valueOf(com_google_android_gms_common_internal_zzah);
                StringBuilder stringBuilder = new StringBuilder(81 + String.valueOf(com_google_android_gms_common_internal_zzah).length());
                stringBuilder.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                stringBuilder.append(com_google_android_gms_common_internal_zzah);
                throw new IllegalStateException(stringBuilder.toString());
            }
            com_google_android_gms_common_internal_zzaj = new zzaj(this, com_google_android_gms_common_internal_zzah);
            com_google_android_gms_common_internal_zzaj.m4788a(serviceConnection);
            com_google_android_gms_common_internal_zzaj.m4787a();
            this.f13995a.put(com_google_android_gms_common_internal_zzah, com_google_android_gms_common_internal_zzaj);
            com_google_android_gms_common_internal_zzah = com_google_android_gms_common_internal_zzaj.f5885c;
        }
        return com_google_android_gms_common_internal_zzah;
    }

    protected final void mo1624b(zzah com_google_android_gms_common_internal_zzah, ServiceConnection serviceConnection) {
        zzbq.m4809a((Object) serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.f13995a) {
            zzaj com_google_android_gms_common_internal_zzaj = (zzaj) this.f13995a.get(com_google_android_gms_common_internal_zzah);
            StringBuilder stringBuilder;
            if (com_google_android_gms_common_internal_zzaj == null) {
                com_google_android_gms_common_internal_zzah = String.valueOf(com_google_android_gms_common_internal_zzah);
                stringBuilder = new StringBuilder(50 + String.valueOf(com_google_android_gms_common_internal_zzah).length());
                stringBuilder.append("Nonexistent connection status for service config: ");
                stringBuilder.append(com_google_android_gms_common_internal_zzah);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (com_google_android_gms_common_internal_zzaj.m4790b(serviceConnection)) {
                com_google_android_gms_common_internal_zzaj.f5883a.remove(serviceConnection);
                if (com_google_android_gms_common_internal_zzaj.m4789b() != null) {
                    this.f13997c.sendMessageDelayed(this.f13997c.obtainMessage(0, com_google_android_gms_common_internal_zzah), this.f13999e);
                }
            } else {
                com_google_android_gms_common_internal_zzah = String.valueOf(com_google_android_gms_common_internal_zzah);
                stringBuilder = new StringBuilder(76 + String.valueOf(com_google_android_gms_common_internal_zzah).length());
                stringBuilder.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                stringBuilder.append(com_google_android_gms_common_internal_zzah);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }

    public final boolean handleMessage(Message message) {
        zzah com_google_android_gms_common_internal_zzah;
        switch (message.what) {
            case 0:
                synchronized (this.f13995a) {
                    com_google_android_gms_common_internal_zzah = (zzah) message.obj;
                    zzaj com_google_android_gms_common_internal_zzaj = (zzaj) this.f13995a.get(com_google_android_gms_common_internal_zzah);
                    if (com_google_android_gms_common_internal_zzaj != null && com_google_android_gms_common_internal_zzaj.m4789b()) {
                        if (com_google_android_gms_common_internal_zzaj.f5885c) {
                            com_google_android_gms_common_internal_zzaj.f5889g.f13997c.removeMessages(1, com_google_android_gms_common_internal_zzaj.f5887e);
                            com_google_android_gms_common_internal_zzaj.f5889g.f13996b.unbindService(com_google_android_gms_common_internal_zzaj);
                            com_google_android_gms_common_internal_zzaj.f5885c = false;
                            com_google_android_gms_common_internal_zzaj.f5884b = 2;
                        }
                        this.f13995a.remove(com_google_android_gms_common_internal_zzah);
                    }
                }
                return true;
            case 1:
                synchronized (this.f13995a) {
                    com_google_android_gms_common_internal_zzah = (zzah) message.obj;
                    zzaj com_google_android_gms_common_internal_zzaj2 = (zzaj) this.f13995a.get(com_google_android_gms_common_internal_zzah);
                    if (com_google_android_gms_common_internal_zzaj2 != null && com_google_android_gms_common_internal_zzaj2.f5884b == 3) {
                        String valueOf = String.valueOf(com_google_android_gms_common_internal_zzah);
                        StringBuilder stringBuilder = new StringBuilder(47 + String.valueOf(valueOf).length());
                        stringBuilder.append("Timeout waiting for ServiceConnection callback ");
                        stringBuilder.append(valueOf);
                        Log.wtf("GmsClientSupervisor", stringBuilder.toString(), new Exception());
                        ComponentName componentName = com_google_android_gms_common_internal_zzaj2.f5888f;
                        if (componentName == null) {
                            componentName = com_google_android_gms_common_internal_zzah.f5880b;
                        }
                        if (componentName == null) {
                            componentName = new ComponentName(com_google_android_gms_common_internal_zzah.f5879a, "unknown");
                        }
                        com_google_android_gms_common_internal_zzaj2.onServiceDisconnected(componentName);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
