package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

final class zzac implements OnCompleteListener<Map<zzh<?>, String>> {
    private /* synthetic */ zzaa f13847a;

    private zzac(zzaa com_google_android_gms_common_api_internal_zzaa) {
        this.f13847a = com_google_android_gms_common_api_internal_zzaa;
    }

    public final void mo1558a(Task<Map<zzh<?>, String>> task) {
        this.f13847a.f13834f.lock();
        try {
            if (this.f13847a.f13842n) {
                if (task.mo2311b()) {
                    this.f13847a.f13843o = new ArrayMap(this.f13847a.f13829a.size());
                    task = this.f13847a.f13829a.values().iterator();
                    while (task.hasNext()) {
                        this.f13847a.f13843o.put(((zzz) task.next()).zzagn(), ConnectionResult.f17256a);
                    }
                } else {
                    zzaa com_google_android_gms_common_api_internal_zzaa;
                    ConnectionResult f;
                    if (task.mo2313d() instanceof AvailabilityException) {
                        AvailabilityException availabilityException = (AvailabilityException) task.mo2313d();
                        if (this.f13847a.f13840l) {
                            this.f13847a.f13843o = new ArrayMap(this.f13847a.f13829a.size());
                            for (zzz com_google_android_gms_common_api_internal_zzz : this.f13847a.f13829a.values()) {
                                Map d;
                                zzh zzagn = com_google_android_gms_common_api_internal_zzz.zzagn();
                                Object a = availabilityException.m4632a(com_google_android_gms_common_api_internal_zzz);
                                if (zzaa.m12840a(this.f13847a, com_google_android_gms_common_api_internal_zzz, a)) {
                                    d = this.f13847a.f13843o;
                                    a = new ConnectionResult(16);
                                } else {
                                    d = this.f13847a.f13843o;
                                }
                                d.put(zzagn, a);
                            }
                        } else {
                            this.f13847a.f13843o = availabilityException.f5738a;
                        }
                        com_google_android_gms_common_api_internal_zzaa = this.f13847a;
                        f = zzaa.m12847f(this.f13847a);
                    } else {
                        Log.e("ConnectionlessGAC", "Unexpected availability exception", task.mo2313d());
                        this.f13847a.f13843o = Collections.emptyMap();
                        com_google_android_gms_common_api_internal_zzaa = this.f13847a;
                        f = new ConnectionResult(8);
                    }
                    com_google_android_gms_common_api_internal_zzaa.f13846r = f;
                }
                if (this.f13847a.f13844p != null) {
                    this.f13847a.f13843o.putAll(this.f13847a.f13844p);
                    this.f13847a.f13846r = zzaa.m12847f(this.f13847a);
                }
                if (this.f13847a.f13846r == null) {
                    zzaa.m12851i(this.f13847a);
                    zzaa.m12852j(this.f13847a);
                } else {
                    this.f13847a.f13842n = false;
                    this.f13847a.f13833e.mo1592a(this.f13847a.f13846r);
                }
                this.f13847a.f13837i.signalAll();
                this.f13847a.f13834f.unlock();
            }
        } finally {
            this.f13847a.f13834f.unlock();
        }
    }
}
