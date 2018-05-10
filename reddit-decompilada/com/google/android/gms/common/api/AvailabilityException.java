package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    public final ArrayMap<zzh<?>, ConnectionResult> f5738a;

    public AvailabilityException(ArrayMap<zzh<?>, ConnectionResult> arrayMap) {
        this.f5738a = arrayMap;
    }

    public final ConnectionResult m4632a(GoogleApi<? extends ApiOptions> googleApi) {
        zzh zzagn = googleApi.zzagn();
        zzbq.m4818b(this.f5738a.get(zzagn) != null, "The given API was not part of the availability request.");
        return (ConnectionResult) this.f5738a.get(zzagn);
    }

    public String getMessage() {
        Iterable arrayList = new ArrayList();
        Object obj = 1;
        for (zzh com_google_android_gms_common_api_internal_zzh : this.f5738a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) this.f5738a.get(com_google_android_gms_common_api_internal_zzh);
            if (connectionResult.m17584b()) {
                obj = null;
            }
            String name = com_google_android_gms_common_api_internal_zzh.f5839a.getName();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder stringBuilder = new StringBuilder((2 + String.valueOf(name).length()) + String.valueOf(valueOf).length());
            stringBuilder.append(name);
            stringBuilder.append(": ");
            stringBuilder.append(valueOf);
            arrayList.add(stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(obj != null ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        stringBuilder2.append(TextUtils.join("; ", arrayList));
        return stringBuilder2.toString();
    }
}
