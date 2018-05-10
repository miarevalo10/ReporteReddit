package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbs;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

@zzzv
public final class zzaim {
    String f6412a = "";
    private final Object f6413b = new Object();
    private String f6414c = "";
    private String f6415d = "";
    private boolean f6416e = false;

    private final String m5276a(Context context) {
        String str;
        synchronized (this.f6413b) {
            if (TextUtils.isEmpty(this.f6414c)) {
                zzbs.m4486e();
                this.f6414c = zzahn.m5188b(context, "debug_signals_id.txt");
                if (TextUtils.isEmpty(this.f6414c)) {
                    zzbs.m4486e();
                    this.f6414c = zzahn.m5157a();
                    zzbs.m4486e();
                    zzahn.m5199c(context, "debug_signals_id.txt", this.f6414c);
                }
            }
            str = this.f6414c;
        }
        return str;
    }

    static void m5277a(Context context, String str, boolean z, boolean z2) {
        if (context instanceof Activity) {
            zzahn.f6379a.post(new zzain(context, str, z, z2));
        } else {
            zzakb.m5370d("Can not create dialog without Activity Context");
        }
    }

    private final Uri m5278b(Context context, String str, String str2, String str3) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", m5276a(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    public final String m5280a() {
        String str;
        synchronized (this.f6413b) {
            str = this.f6415d;
        }
        return str;
    }

    public final void m5281a(Context context, String str, String str2, String str3) {
        Builder buildUpon = m5278b(context, (String) zzkb.m6350f().m6488a(zznh.cD), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzbs.m4486e();
        zzahn.m5192b(context, str, buildUpon.build().toString());
    }

    final boolean m5282a(Context context, String str, String str2) {
        Object d = m5279d(context, m5278b(context, (String) zzkb.m6350f().m6488a(zznh.cB), str, str2).toString(), str2);
        if (TextUtils.isEmpty(d)) {
            zzakb.m5366b("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(d.trim());
            String optString = jSONObject.optString("gct");
            this.f6412a = jSONObject.optString("status");
            synchronized (this.f6413b) {
                this.f6415d = optString;
            }
            return true;
        } catch (Throwable e) {
            zzakb.m5369c("Fail to get in app preview response json.", e);
            return false;
        }
    }

    public final boolean m5283b() {
        boolean z;
        synchronized (this.f6413b) {
            z = this.f6416e;
        }
        return z;
    }

    final boolean m5284b(Context context, String str, String str2) {
        Object d = m5279d(context, m5278b(context, (String) zzkb.m6350f().m6488a(zznh.cC), str, str2).toString(), str2);
        if (TextUtils.isEmpty(d)) {
            zzakb.m5366b("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(d.trim()).optString("debug_mode"));
            synchronized (this.f6413b) {
                this.f6416e = equals;
            }
            return equals;
        } catch (Throwable e) {
            zzakb.m5369c("Fail to get debug mode response json.", e);
            return false;
        }
    }

    final void m5285c(Context context, String str, String str2) {
        zzbs.m4486e();
        zzahn.m5168a(context, m5278b(context, (String) zzkb.m6350f().m6488a(zznh.cA), str, str2));
    }

    private static String m5279d(Context context, String str, String str2) {
        Throwable e;
        String str3;
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", zzbs.m4486e().m5225a(context, str2));
        str2 = new zzaiv(context);
        str2 = zzaiv.m5293a(null, str, hashMap, null);
        try {
            return (String) str2.get((long) ((Integer) zzkb.m6350f().m6488a(zznh.cE)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e2) {
            e = e2;
            str3 = "Timeout while retriving a response from: ";
            str = String.valueOf(str);
            if (str.length() == 0) {
                str = new String(str3);
                zzakb.m5367b(str, e);
                str2.cancel(true);
                return null;
            }
            str = str3.concat(str);
            zzakb.m5367b(str, e);
            str2.cancel(true);
            return null;
        } catch (InterruptedException e3) {
            e = e3;
            str3 = "Interrupted while retriving a response from: ";
            str = String.valueOf(str);
            if (str.length() != 0) {
                str = str3.concat(str);
                zzakb.m5367b(str, e);
                str2.cancel(true);
                return null;
            }
            str = new String(str3);
            zzakb.m5367b(str, e);
            str2.cancel(true);
            return null;
        } catch (String str22) {
            String str4 = "Error retriving a response from: ";
            str = String.valueOf(str);
            zzakb.m5367b(str.length() != 0 ? str4.concat(str) : new String(str4), str22);
            return null;
        }
    }
}
