package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@zzzv
public final class zzaaz extends zzbfm {
    public static final Creator<zzaaz> CREATOR = new zzaba();
    public final boolean f17467a;
    public final List<String> f17468b;

    public zzaaz() {
        this(false, Collections.emptyList());
    }

    public zzaaz(boolean z, List<String> list) {
        this.f17467a = z;
        this.f17468b = list;
    }

    public static zzaaz m17702a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new zzaaz();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("reporting_urls");
        List arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    arrayList.add(optJSONArray.getString(i));
                } catch (Throwable e) {
                    zzakb.m5369c("Error grabbing url from json.", e);
                }
            }
        }
        return new zzaaz(jSONObject.optBoolean("enable_protection"), arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5547a(parcel, 2, this.f17467a);
        zzbfp.m5557b(parcel, 3, this.f17468b);
        zzbfp.m5537a(parcel, i);
    }
}
