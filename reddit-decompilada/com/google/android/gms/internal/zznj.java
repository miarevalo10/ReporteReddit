package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzbs;
import com.instabug.library.model.State;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

@zzzv
public final class zznj {
    boolean f7919a;
    String f7920b;
    Map<String, String> f7921c;
    Context f7922d = null;
    String f7923e = null;

    public zznj(Context context, String str) {
        this.f7922d = context;
        this.f7923e = str;
        this.f7919a = ((Boolean) zzkb.m6350f().m6488a(zznh.f7872H)).booleanValue();
        this.f7920b = (String) zzkb.m6350f().m6488a(zznh.f7873I);
        this.f7921c = new LinkedHashMap();
        this.f7921c.put("s", "gmob_sdk");
        this.f7921c.put("v", "3");
        this.f7921c.put(State.KEY_OS, VERSION.RELEASE);
        this.f7921c.put("sdk", VERSION.SDK);
        Map map = this.f7921c;
        String str2 = State.KEY_DEVICE;
        zzbs.m4486e();
        map.put(str2, zzahn.m5187b());
        this.f7921c.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        map = this.f7921c;
        str2 = "is_lite_sdk";
        zzbs.m4486e();
        map.put(str2, zzahn.m5220l(context) ? "1" : "0");
        Future a = zzbs.m4496o().m5014a(this.f7922d);
        try {
            a.get();
            this.f7921c.put("network_coarse", Integer.toString(((zzaco) a.get()).f6175n));
            this.f7921c.put("network_fine", Integer.toString(((zzaco) a.get()).f6176o));
        } catch (Throwable e) {
            zzbs.m4490i().m13246a(e, "CsiConfiguration.CsiConfiguration");
        }
    }
}
