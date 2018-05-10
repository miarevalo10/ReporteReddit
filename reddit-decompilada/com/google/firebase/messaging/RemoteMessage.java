package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Map;

public final class RemoteMessage extends zzbfm {
    public static final Creator<RemoteMessage> CREATOR = new zzf();
    public Bundle f18480a;
    private Map<String, String> f18481b;

    RemoteMessage(Bundle bundle) {
        this.f18480a = bundle;
    }

    public final Map<String, String> m19323a() {
        if (this.f18481b == null) {
            this.f18481b = new ArrayMap();
            for (String str : this.f18480a.keySet()) {
                Object obj = this.f18480a.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!(str.startsWith("google.") || str.startsWith("gcm.") || str.equals("from") || str.equals("message_type") || str.equals("collapse_key"))) {
                        this.f18481b.put(str, str2);
                    }
                }
            }
        }
        return this.f18481b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5542a(parcel, 2, this.f18480a);
        zzbfp.m5537a(parcel, i);
    }
}
