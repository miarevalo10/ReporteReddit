package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzaey extends zzbfm {
    public static final Creator<zzaey> CREATOR = new zzaez();
    public final String f17536a;
    public final String f17537b;
    public final boolean f17538c;
    public final boolean f17539d;
    public final List<String> f17540e;
    public final boolean f17541f;
    public final boolean f17542g;

    public zzaey(String str, String str2, boolean z, boolean z2, List<String> list, boolean z3, boolean z4) {
        this.f17536a = str;
        this.f17537b = str2;
        this.f17538c = z;
        this.f17539d = z2;
        this.f17540e = list;
        this.f17541f = z3;
        this.f17542g = z4;
    }

    public static zzaey m17779a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("click_string", "");
        String optString2 = jSONObject.optString("report_url", "");
        boolean optBoolean = jSONObject.optBoolean("rendered_ad_enabled", false);
        boolean optBoolean2 = jSONObject.optBoolean("non_malicious_reporting_enabled", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("allowed_headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            Object optString3 = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString3)) {
                arrayList.add(optString3.toLowerCase(Locale.ENGLISH));
            }
        }
        return new zzaey(optString, optString2, optBoolean, optBoolean2, arrayList, jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 2, this.f17536a);
        zzbfp.m5545a(parcel, 3, this.f17537b);
        zzbfp.m5547a(parcel, 4, this.f17538c);
        zzbfp.m5547a(parcel, 5, this.f17539d);
        zzbfp.m5557b(parcel, 6, this.f17540e);
        zzbfp.m5547a(parcel, 7, this.f17541f);
        zzbfp.m5547a(parcel, 8, this.f17542g);
        zzbfp.m5537a(parcel, i);
    }
}
