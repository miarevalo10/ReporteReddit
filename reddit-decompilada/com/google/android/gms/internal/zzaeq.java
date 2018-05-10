package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

@zzzv
public final class zzaeq extends zzbfm {
    public static final Creator<zzaeq> CREATOR = new zzaer();
    public final String f17534a;
    public final int f17535b;

    public zzaeq(RewardItem rewardItem) {
        this(rewardItem.mo1681a(), rewardItem.mo1682b());
    }

    public zzaeq(String str, int i) {
        this.f17534a = str;
        this.f17535b = i;
    }

    public static com.google.android.gms.internal.zzaeq m17777a(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r2);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x0012 }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x0012 }
        r2 = m17778a(r0);	 Catch:{ JSONException -> 0x0012 }
        return r2;
    L_0x0012:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaeq.a(java.lang.String):com.google.android.gms.internal.zzaeq");
    }

    public static zzaeq m17778a(JSONArray jSONArray) throws JSONException {
        if (jSONArray != null) {
            if (jSONArray.length() != 0) {
                return new zzaeq(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
            }
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzaeq)) {
            return false;
        }
        zzaeq com_google_android_gms_internal_zzaeq = (zzaeq) obj;
        if (zzbg.m4806a(this.f17534a, com_google_android_gms_internal_zzaeq.f17534a) && zzbg.m4806a(Integer.valueOf(this.f17535b), Integer.valueOf(com_google_android_gms_internal_zzaeq.f17535b))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f17534a, Integer.valueOf(this.f17535b)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        i = zzbfp.m5536a(parcel);
        zzbfp.m5545a(parcel, 2, this.f17534a);
        zzbfp.m5540a(parcel, 3, this.f17535b);
        zzbfp.m5537a(parcel, i);
    }
}
