package com.google.android.gms.internal;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.C0436R;
import com.google.android.gms.ads.internal.zzbs;
import com.instabug.chat.model.Attachment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzzd implements zzys<zzol> {
    private final boolean f14773a;
    private final boolean f14774b;
    private final boolean f14775c;

    public zzzd(boolean z, boolean z2, boolean z3) {
        this.f14773a = z;
        this.f14774b = z2;
        this.f14775c = z3;
    }

    public final /* synthetic */ zzou mo2295a(zzym com_google_android_gms_internal_zzym, JSONObject jSONObject) throws JSONException, InterruptedException, ExecutionException {
        String string;
        String string2;
        zzpq com_google_android_gms_internal_zzpq;
        String string3;
        String string4;
        zzog com_google_android_gms_internal_zzog;
        Bundle bundle;
        zzll b;
        View view;
        zzym com_google_android_gms_internal_zzym2 = com_google_android_gms_internal_zzym;
        JSONObject jSONObject2 = jSONObject;
        List<zzakv> b2 = com_google_android_gms_internal_zzym2.m6821b(jSONObject2, "images", this.f14773a, this.f14774b);
        Future a = com_google_android_gms_internal_zzym2.m6818a(jSONObject2, "secondary_image", false, this.f14773a);
        Future a2 = com_google_android_gms_internal_zzym.m6816a(jSONObject);
        zzakv a3 = com_google_android_gms_internal_zzym2.m6817a(jSONObject2, Attachment.TYPE_VIDEO);
        List arrayList = new ArrayList();
        for (zzakv com_google_android_gms_internal_zzakv : b2) {
            arrayList.add((zzoi) com_google_android_gms_internal_zzakv.get());
        }
        zzanh a4 = zzym.m6808a(a3);
        String string5 = jSONObject2.getString("headline");
        if (r0.f14775c) {
            if (((Boolean) zzkb.m6350f().m6488a(zznh.cQ)).booleanValue()) {
                Resources r = zzbs.m4490i().m13270r();
                string = r != null ? r.getString(C0436R.string.s7) : "Test Ad";
                if (string5 != null) {
                    StringBuilder stringBuilder = new StringBuilder((3 + String.valueOf(string).length()) + String.valueOf(string5).length());
                    stringBuilder.append(string);
                    stringBuilder.append(" : ");
                    stringBuilder.append(string5);
                    string5 = stringBuilder.toString();
                }
                string2 = jSONObject2.getString("body");
                com_google_android_gms_internal_zzpq = (zzpq) a.get();
                string3 = jSONObject2.getString("call_to_action");
                string4 = jSONObject2.getString("advertiser");
                com_google_android_gms_internal_zzog = (zzog) a2.get();
                bundle = new Bundle();
                b = a4 == null ? a4.mo3464b() : null;
                if (a4 != null) {
                    view = null;
                } else if (a4 != null) {
                    throw null;
                } else {
                    view = (View) a4;
                }
                return new zzol(string, arrayList, string2, com_google_android_gms_internal_zzpq, string3, string4, com_google_android_gms_internal_zzog, bundle, b, view, null, null);
            }
        }
        string = string5;
        string2 = jSONObject2.getString("body");
        com_google_android_gms_internal_zzpq = (zzpq) a.get();
        string3 = jSONObject2.getString("call_to_action");
        string4 = jSONObject2.getString("advertiser");
        com_google_android_gms_internal_zzog = (zzog) a2.get();
        bundle = new Bundle();
        if (a4 == null) {
        }
        if (a4 != null) {
            view = null;
        } else if (a4 != null) {
            view = (View) a4;
        } else {
            throw null;
        }
        return new zzol(string, arrayList, string2, com_google_android_gms_internal_zzpq, string3, string4, com_google_android_gms_internal_zzog, bundle, b, view, null, null);
    }
}
