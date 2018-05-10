package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.gmsg.zzz;
import com.google.android.gms.ads.internal.js.JavascriptEngineFactory;
import com.google.android.gms.ads.internal.js.zzn;
import com.google.android.gms.ads.internal.zzba;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzw;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

@zzzv
public final class zzzf extends zzyk<zzzf> {
    private static final long f18350d = TimeUnit.SECONDS.toMillis(60);
    private static final Object f18351e = new Object();
    private static boolean f18352f = false;
    private static zzn f18353g;
    String f18354a;
    private JavascriptEngineFactory f18355b;
    private zzakv<zzanh> f18356c;
    private final zzz f18357h;
    private final zzox f18358i;
    private final Context f18359j;
    private final zzakd f18360k;
    private final zzba f18361l;
    private final zzcv f18362m;
    private final Object f18363n = new Object();

    public zzzf(Context context, zzba com_google_android_gms_ads_internal_zzba, String str, zzcv com_google_android_gms_internal_zzcv, zzakd com_google_android_gms_internal_zzakd) {
        zzakb.m5370d("Webview loading for native ads.");
        this.f18359j = context;
        this.f18361l = com_google_android_gms_ads_internal_zzba;
        this.f18362m = com_google_android_gms_internal_zzcv;
        this.f18360k = com_google_android_gms_internal_zzakd;
        this.f18354a = str;
        this.f18355b = new JavascriptEngineFactory();
        zzbs.m4487f();
        zzakv a = zzanr.m5463a(this.f18359j, this.f18360k, (String) zzkb.m6350f().m6488a(zznh.bK), this.f18362m, this.f18361l.m17462h());
        this.f18357h = new zzz(this.f18359j);
        this.f18358i = new zzox(com_google_android_gms_ads_internal_zzba, str);
        this.f18356c = zzakl.m5379a(a, new zzzg(this), zzala.f6512b);
        zzakj.m5376a(this.f18356c, "WebViewNativeAdsUtil.constructor");
    }

    final /* synthetic */ zzakv m19175a(zzanh com_google_android_gms_internal_zzanh) throws Exception {
        zzakb.m5370d("Javascript has loaded for native ads.");
        com_google_android_gms_internal_zzanh.mo4019w().m5445a(this.f18361l, this.f18361l, this.f18361l, this.f18361l, false, null, new zzw(this.f18359j, null, null), null, null);
        com_google_android_gms_internal_zzanh.mo4019w().m5446a("/logScionEvent", this.f18357h);
        com_google_android_gms_internal_zzanh.mo4019w().m5446a("/logScionEvent", this.f18358i);
        return zzakl.m5377a(com_google_android_gms_internal_zzanh);
    }

    public final zzakv<JSONObject> mo3575a(JSONObject jSONObject) {
        return zzakl.m5379a(this.f18356c, new zzzh(this, jSONObject), zzala.f6511a);
    }

    public final void mo3576a() {
        zzakl.m5384a(this.f18356c, new zzzo(), zzala.f6511a);
    }

    public final void mo2292a(String str, zzt com_google_android_gms_ads_internal_gmsg_zzt) {
        zzakl.m5384a(this.f18356c, new zzzl(str, com_google_android_gms_ads_internal_gmsg_zzt), zzala.f6511a);
    }

    public final void mo3577a(String str, JSONObject jSONObject) {
        zzakl.m5384a(this.f18356c, new zzzn(str, jSONObject), zzala.f6511a);
    }

    public final zzakv<JSONObject> mo3578b(JSONObject jSONObject) {
        return zzakl.m5379a(this.f18356c, new zzzi(this, jSONObject), zzala.f6511a);
    }

    public final void mo2293b(String str, zzt com_google_android_gms_ads_internal_gmsg_zzt) {
        zzakl.m5384a(this.f18356c, new zzzm(str, com_google_android_gms_ads_internal_gmsg_zzt), zzala.f6511a);
    }

    public final zzakv<JSONObject> mo3579c(JSONObject jSONObject) {
        return zzakl.m5379a(this.f18356c, new zzzj(this, jSONObject), zzala.f6511a);
    }
}
