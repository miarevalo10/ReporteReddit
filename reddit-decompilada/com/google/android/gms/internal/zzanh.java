package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.js.zza;
import com.google.android.gms.ads.internal.js.zzm;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzbl;
import com.google.android.gms.ads.internal.zzv;
import java.util.Map;
import org.json.JSONObject;

@zzzv
public interface zzanh extends zza, zzm, zzbl, zzamp, zzaog, zzaoh, zzaou, zzaow, zzaox, zzaoy, zzgt {
    int mo3964A();

    boolean mo3965B();

    void mo3966C();

    boolean mo3967D();

    boolean mo3968E();

    boolean mo3969F();

    void mo3970G();

    void mo3971H();

    OnClickListener mo3972I();

    zzoq mo3973J();

    void mo3974K();

    void mo3975L();

    void mo3977a(int i);

    void mo3978a(Context context);

    void mo3980a(zzd com_google_android_gms_ads_internal_overlay_zzd);

    void mo3461a(zzaoa com_google_android_gms_internal_zzaoa);

    void mo3981a(zzapa com_google_android_gms_internal_zzapa);

    void mo3982a(zzoq com_google_android_gms_internal_zzoq);

    void mo3983a(String str);

    void mo3984a(String str, zzt<? super zzanh> com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh);

    void mo3462a(String str, Map<String, ?> map);

    void mo3463a(String str, JSONObject jSONObject);

    zzaoa mo3464b();

    void mo3989b(int i);

    void mo3990b(zzd com_google_android_gms_ads_internal_overlay_zzd);

    void mo3991b(String str);

    void mo3992b(String str, zzt<? super zzanh> com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh);

    void mo3465b(String str, JSONObject jSONObject);

    void mo3993b(boolean z);

    zzns mo3466c();

    void mo3994c(boolean z);

    Activity mo3467d();

    void mo3995d(boolean z);

    void destroy();

    zzv mo3468e();

    void mo3997e(boolean z);

    Context getContext();

    int getHeight();

    LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    int getWidth();

    String mo3470i();

    zznt mo3471j();

    zzakd mo3472k();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    WebView mo4004n();

    void mo4005o();

    void onPause();

    void onResume();

    void mo4008p();

    void mo4009q();

    Context mo4010r();

    zzd mo4011s();

    void setBackgroundColor(int i);

    void setOnClickListener(OnClickListener onClickListener);

    void setOnTouchListener(OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void stopLoading();

    zzd mo4017t();

    zzapa mo3474u();

    String mo4018v();

    zzani mo4019w();

    boolean mo4020x();

    zzcv mo3475y();

    boolean mo3476z();
}
