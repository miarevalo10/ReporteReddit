package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

final class zzad implements OnCompleteListener<Map<zzh<?>, String>> {
    private zzcu f13848a;
    private /* synthetic */ zzaa f13849b;

    zzad(zzaa com_google_android_gms_common_api_internal_zzaa, zzcu com_google_android_gms_common_api_internal_zzcu) {
        this.f13849b = com_google_android_gms_common_api_internal_zzaa;
        this.f13848a = com_google_android_gms_common_api_internal_zzcu;
    }

    final void m12869a() {
        this.f13848a.mo3404m();
    }

    public final void mo1558a(Task<Map<zzh<?>, String>> task) {
        this.f13849b.f13834f.lock();
        try {
            if (this.f13849b.f13842n) {
                if (task.mo2311b()) {
                    this.f13849b.f13844p = new ArrayMap(this.f13849b.f13830b.size());
                    task = this.f13849b.f13830b.values().iterator();
                    while (task.hasNext()) {
                        this.f13849b.f13844p.put(((zzz) task.next()).zzagn(), ConnectionResult.f17256a);
                    }
                } else if (task.mo2313d() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.mo2313d();
                    if (this.f13849b.f13840l) {
                        this.f13849b.f13844p = new ArrayMap(this.f13849b.f13830b.size());
                        for (zzz com_google_android_gms_common_api_internal_zzz : this.f13849b.f13830b.values()) {
                            Map g;
                            zzh zzagn = com_google_android_gms_common_api_internal_zzz.zzagn();
                            Object a = availabilityException.m4632a(com_google_android_gms_common_api_internal_zzz);
                            if (zzaa.m12840a(this.f13849b, com_google_android_gms_common_api_internal_zzz, a)) {
                                g = this.f13849b.f13844p;
                                a = new ConnectionResult(16);
                            } else {
                                g = this.f13849b.f13844p;
                            }
                            g.put(zzagn, a);
                        }
                    } else {
                        this.f13849b.f13844p = availabilityException.f5738a;
                    }
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.mo2313d());
                    this.f13849b.f13844p = Collections.emptyMap();
                }
                if (this.f13849b.mo1554d() != null) {
                    this.f13849b.f13843o.putAll(this.f13849b.f13844p);
                    if (zzaa.m12847f(this.f13849b) == null) {
                        zzaa.m12851i(this.f13849b);
                        zzaa.m12852j(this.f13849b);
                        this.f13849b.f13837i.signalAll();
                    }
                }
                this.f13848a.mo3404m();
                this.f13849b.f13834f.unlock();
                return;
            }
            this.f13848a.mo3404m();
        } finally {
            this.f13849b.f13834f.unlock();
        }
    }
}
