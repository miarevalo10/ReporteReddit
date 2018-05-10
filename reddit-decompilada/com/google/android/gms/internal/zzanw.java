package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.C0436R;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.internal.zzbq;
import java.util.Map;
import org.json.JSONObject;

@zzzv
final class zzanw extends FrameLayout implements zzanh {
    private static final int f19165a = Color.argb(0, 0, 0, 0);
    private final zzanh f19166b;
    private final zzamg f19167c;

    public zzanw(zzanh com_google_android_gms_internal_zzanh) {
        super(com_google_android_gms_internal_zzanh.getContext());
        this.f19166b = com_google_android_gms_internal_zzanh;
        this.f19167c = new zzamg(com_google_android_gms_internal_zzanh.mo4010r(), (ViewGroup) this, (zzanh) this);
        zzani w = this.f19166b.mo4019w();
        if (w != null) {
            w.f6614a = this;
        }
        com_google_android_gms_internal_zzanh = this.f19166b;
        if (com_google_android_gms_internal_zzanh == null) {
            throw null;
        }
        addView((View) com_google_android_gms_internal_zzanh);
    }

    public final int mo3964A() {
        return this.f19166b.mo3964A();
    }

    public final boolean mo3965B() {
        return this.f19166b.mo3965B();
    }

    public final boolean mo3967D() {
        return this.f19166b.mo3967D();
    }

    public final boolean mo3968E() {
        return this.f19166b.mo3968E();
    }

    public final boolean mo3969F() {
        return this.f19166b.mo3969F();
    }

    public final void mo3970G() {
        this.f19166b.mo3970G();
    }

    public final void mo3971H() {
        this.f19166b.mo3971H();
    }

    public final OnClickListener mo3972I() {
        return this.f19166b.mo3972I();
    }

    public final zzoq mo3973J() {
        return this.f19166b.mo3973J();
    }

    public final void mo3974K() {
        setBackgroundColor(f19165a);
        this.f19166b.setBackgroundColor(f19165a);
    }

    public final void mo3975L() {
        View textView = new TextView(getContext());
        Resources r = zzbs.m4490i().m13270r();
        textView.setText(r != null ? r.getString(C0436R.string.s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        if (VERSION.SDK_INT >= 16) {
            textView.setBackground(gradientDrawable);
        } else {
            textView.setBackgroundDrawable(gradientDrawable);
        }
        addView(textView, new LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final zzamg mo3976a() {
        return this.f19167c;
    }

    public final void mo3977a(int i) {
        this.f19166b.mo3977a(i);
    }

    public final void mo3978a(Context context) {
        this.f19166b.mo3978a(context);
    }

    public final void mo3979a(zzc com_google_android_gms_ads_internal_overlay_zzc) {
        this.f19166b.mo3979a(com_google_android_gms_ads_internal_overlay_zzc);
    }

    public final void mo3980a(zzd com_google_android_gms_ads_internal_overlay_zzd) {
        this.f19166b.mo3980a(com_google_android_gms_ads_internal_overlay_zzd);
    }

    public final void mo3461a(zzaoa com_google_android_gms_internal_zzaoa) {
        this.f19166b.mo3461a(com_google_android_gms_internal_zzaoa);
    }

    public final void mo3981a(zzapa com_google_android_gms_internal_zzapa) {
        this.f19166b.mo3981a(com_google_android_gms_internal_zzapa);
    }

    public final void mo1711a(zzgs com_google_android_gms_internal_zzgs) {
        this.f19166b.mo1711a(com_google_android_gms_internal_zzgs);
    }

    public final void mo3982a(zzoq com_google_android_gms_internal_zzoq) {
        this.f19166b.mo3982a(com_google_android_gms_internal_zzoq);
    }

    public final void mo3983a(String str) {
        this.f19166b.mo3983a(str);
    }

    public final void mo3984a(String str, zzt<? super zzanh> com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh) {
        this.f19166b.mo3984a(str, (zzt) com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh);
    }

    public final void mo3462a(String str, Map<String, ?> map) {
        this.f19166b.mo3462a(str, (Map) map);
    }

    public final void mo3463a(String str, JSONObject jSONObject) {
        this.f19166b.mo3463a(str, jSONObject);
    }

    public final void mo3985a(boolean z) {
        this.f19166b.mo3985a(z);
    }

    public final void mo3986a(boolean z, int i) {
        this.f19166b.mo3986a(z, i);
    }

    public final void mo3987a(boolean z, int i, String str) {
        this.f19166b.mo3987a(z, i, str);
    }

    public final void mo3988a(boolean z, int i, String str, String str2) {
        this.f19166b.mo3988a(z, i, str, str2);
    }

    public final zzaoa mo3464b() {
        return this.f19166b.mo3464b();
    }

    public final void mo3989b(int i) {
        this.f19166b.mo3989b(i);
    }

    public final void mo3990b(zzd com_google_android_gms_ads_internal_overlay_zzd) {
        this.f19166b.mo3990b(com_google_android_gms_ads_internal_overlay_zzd);
    }

    public final void mo3991b(String str) {
        this.f19166b.mo3991b(str);
    }

    public final void mo3992b(String str, zzt<? super zzanh> com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh) {
        this.f19166b.mo3992b(str, (zzt) com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh);
    }

    public final void mo3465b(String str, JSONObject jSONObject) {
        this.f19166b.mo3465b(str, jSONObject);
    }

    public final void mo3993b(boolean z) {
        this.f19166b.mo3993b(z);
    }

    public final zzns mo3466c() {
        return this.f19166b.mo3466c();
    }

    public final void mo3994c(boolean z) {
        this.f19166b.mo3994c(z);
    }

    public final Activity mo3467d() {
        return this.f19166b.mo3467d();
    }

    public final void mo3995d(boolean z) {
        this.f19166b.mo3995d(z);
    }

    public final void destroy() {
        this.f19166b.destroy();
    }

    public final zzv mo3468e() {
        return this.f19166b.mo3468e();
    }

    public final void mo3997e(boolean z) {
        this.f19166b.mo3997e(z);
    }

    public final void mo3998f() {
        this.f19166b.mo3998f();
    }

    public final void h_() {
        this.f19166b.h_();
    }

    public final String mo3470i() {
        return this.f19166b.mo3470i();
    }

    public final void i_() {
        this.f19166b.i_();
    }

    public final zznt mo3471j() {
        return this.f19166b.mo3471j();
    }

    public final zzakd mo3472k() {
        return this.f19166b.mo3472k();
    }

    public final int mo3999l() {
        return getMeasuredHeight();
    }

    public final void loadData(String str, String str2, String str3) {
        this.f19166b.loadData(str, str2, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.f19166b.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.f19166b.loadUrl(str);
    }

    public final int mo4003m() {
        return getMeasuredWidth();
    }

    public final WebView mo4004n() {
        return this.f19166b.mo4004n();
    }

    public final void mo4005o() {
        this.f19166b.mo4005o();
    }

    public final void onResume() {
        this.f19166b.onResume();
    }

    public final void mo4008p() {
        this.f19166b.mo4008p();
    }

    public final void mo4009q() {
        this.f19166b.mo4009q();
    }

    public final Context mo4010r() {
        return this.f19166b.mo4010r();
    }

    public final zzd mo4011s() {
        return this.f19166b.mo4011s();
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.f19166b.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(OnTouchListener onTouchListener) {
        this.f19166b.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.f19166b.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.f19166b.setWebViewClient(webViewClient);
    }

    public final void stopLoading() {
        this.f19166b.stopLoading();
    }

    public final zzd mo4017t() {
        return this.f19166b.mo4017t();
    }

    public final zzapa mo3474u() {
        return this.f19166b.mo3474u();
    }

    public final String mo4018v() {
        return this.f19166b.mo4018v();
    }

    public final zzani mo4019w() {
        return this.f19166b.mo4019w();
    }

    public final boolean mo4020x() {
        return this.f19166b.mo4020x();
    }

    public final zzcv mo3475y() {
        return this.f19166b.mo3475y();
    }

    public final boolean mo3476z() {
        return this.f19166b.mo3476z();
    }

    public final void onPause() {
        zzamg com_google_android_gms_internal_zzamg = this.f19167c;
        zzbq.m4816b("onPause must be called from the UI thread.");
        if (com_google_android_gms_internal_zzamg.f6544d != null) {
            com_google_android_gms_internal_zzamg.f6544d.m13365i();
        }
        this.f19166b.onPause();
    }

    public final void mo3966C() {
        zzamg com_google_android_gms_internal_zzamg = this.f19167c;
        zzbq.m4816b("onDestroy must be called from the UI thread.");
        if (com_google_android_gms_internal_zzamg.f6544d != null) {
            zzamd com_google_android_gms_internal_zzamd = com_google_android_gms_internal_zzamg.f6544d;
            com_google_android_gms_internal_zzamd.f14150a.f6581a = true;
            if (com_google_android_gms_internal_zzamd.f14151b != null) {
                com_google_android_gms_internal_zzamd.f14151b.mo3451b();
            }
            com_google_android_gms_internal_zzamd.m13369m();
            com_google_android_gms_internal_zzamg.f6543c.removeView(com_google_android_gms_internal_zzamg.f6544d);
            com_google_android_gms_internal_zzamg.f6544d = null;
        }
        this.f19166b.mo3966C();
    }
}
