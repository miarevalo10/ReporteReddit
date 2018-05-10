package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzbl;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.common.util.zzq;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

@zzzv
final class zzanx extends WebView implements OnGlobalLayoutListener, DownloadListener, zzanh {
    private zzns f19168A;
    private zzns f19169B;
    private zznt f19170C;
    private WeakReference<OnClickListener> f19171D;
    private zzd f19172E;
    private boolean f19173F;
    private zzajq f19174G;
    private int f19175H = -1;
    private int f19176I = -1;
    private int f19177J = -1;
    private int f19178K = -1;
    private Map<String, zzana> f19179L;
    private final WindowManager f19180M;
    private final zzis f19181N;
    private final zzaoz f19182a;
    private final Object f19183b = new Object();
    private final zzcv f19184c;
    private final zzakd f19185d;
    private final zzbl f19186e;
    private final zzv f19187f;
    private zzani f19188g;
    private zzd f19189h;
    private zzapa f19190i;
    private String f19191j;
    private boolean f19192k;
    private boolean f19193l;
    private boolean f19194m;
    private boolean f19195n;
    private Boolean f19196o;
    private int f19197p;
    private boolean f19198q = true;
    private boolean f19199r = false;
    private String f19200s = "";
    private zzaoa f19201t;
    private boolean f19202u;
    private boolean f19203v;
    private zzoq f19204w;
    private int f19205x;
    private int f19206y;
    private zzns f19207z;

    private final Boolean m20298N() {
        Boolean bool;
        synchronized (this.f19183b) {
            bool = this.f19196o;
        }
        return bool;
    }

    private final void m20300P() {
        synchronized (this.f19183b) {
            if (!this.f19194m) {
                if (!this.f19190i.m5488c()) {
                    if (VERSION.SDK_INT < 18) {
                        zzakb.m5366b("Disabling hardware acceleration on an AdView.");
                        synchronized (this.f19183b) {
                            if (!this.f19195n) {
                                zzbs.m4488g().mo3442c((View) this);
                            }
                            this.f19195n = true;
                        }
                    } else {
                        zzakb.m5366b("Enabling hardware acceleration on an AdView.");
                        m20301Q();
                    }
                }
            }
            zzakb.m5366b("Enabling hardware acceleration on an overlay.");
            m20301Q();
        }
    }

    private final void m20301Q() {
        synchronized (this.f19183b) {
            if (this.f19195n) {
                zzbs.m4488g().mo3440b((View) this);
            }
            this.f19195n = false;
        }
    }

    private final void m20303S() {
        synchronized (this.f19183b) {
            this.f19179L = null;
        }
    }

    static zzanx m20306a(Context context, zzapa com_google_android_gms_internal_zzapa, String str, boolean z, zzcv com_google_android_gms_internal_zzcv, zzakd com_google_android_gms_internal_zzakd, zznu com_google_android_gms_internal_zznu, zzbl com_google_android_gms_ads_internal_zzbl, zzv com_google_android_gms_ads_internal_zzv, zzis com_google_android_gms_internal_zzis) {
        return new zzanx(new zzaoz(context), com_google_android_gms_internal_zzapa, str, z, com_google_android_gms_internal_zzcv, com_google_android_gms_internal_zzakd, com_google_android_gms_internal_zznu, com_google_android_gms_ads_internal_zzbl, com_google_android_gms_ads_internal_zzv, com_google_android_gms_internal_zzis);
    }

    private final void m20311c(String str) {
        synchronized (this.f19183b) {
            if (mo3965B()) {
                zzakb.m5371e("The webview is destroyed. Ignoring action.");
            } else {
                loadUrl(str);
            }
        }
    }

    private final void m20312d(java.lang.String r4) {
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
        r3 = this;
        r0 = com.google.android.gms.common.util.zzq.m4913e();
        if (r0 == 0) goto L_0x0074;
    L_0x0006:
        r0 = r3.m20298N();
        r1 = 0;
        if (r0 != 0) goto L_0x0039;
    L_0x000d:
        r0 = r3.f19183b;
        monitor-enter(r0);
        r2 = com.google.android.gms.ads.internal.zzbs.m4490i();	 Catch:{ all -> 0x0036 }
        r2 = r2.m13261i();	 Catch:{ all -> 0x0036 }
        r3.f19196o = r2;	 Catch:{ all -> 0x0036 }
        r2 = r3.f19196o;	 Catch:{ all -> 0x0036 }
        if (r2 != 0) goto L_0x0034;
    L_0x001e:
        r2 = "(function(){})()";	 Catch:{ IllegalStateException -> 0x002c }
        r3.evaluateJavascript(r2, r1);	 Catch:{ IllegalStateException -> 0x002c }
        r2 = 1;	 Catch:{ IllegalStateException -> 0x002c }
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ IllegalStateException -> 0x002c }
        r3.m20308a(r2);	 Catch:{ IllegalStateException -> 0x002c }
        goto L_0x0034;
    L_0x002c:
        r2 = 0;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ all -> 0x0036 }
        r3.m20308a(r2);	 Catch:{ all -> 0x0036 }
    L_0x0034:
        monitor-exit(r0);	 Catch:{ all -> 0x0036 }
        goto L_0x0039;	 Catch:{ all -> 0x0036 }
    L_0x0036:
        r4 = move-exception;	 Catch:{ all -> 0x0036 }
        monitor-exit(r0);	 Catch:{ all -> 0x0036 }
        throw r4;
    L_0x0039:
        r0 = r3.m20298N();
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x005a;
    L_0x0043:
        r0 = r3.f19183b;
        monitor-enter(r0);
        r2 = r3.mo3965B();	 Catch:{ all -> 0x0057 }
        if (r2 != 0) goto L_0x0050;	 Catch:{ all -> 0x0057 }
    L_0x004c:
        r3.evaluateJavascript(r4, r1);	 Catch:{ all -> 0x0057 }
        goto L_0x0055;	 Catch:{ all -> 0x0057 }
    L_0x0050:
        r4 = "The webview is destroyed. Ignoring action.";	 Catch:{ all -> 0x0057 }
        com.google.android.gms.internal.zzakb.m5371e(r4);	 Catch:{ all -> 0x0057 }
    L_0x0055:
        monitor-exit(r0);	 Catch:{ all -> 0x0057 }
        return;	 Catch:{ all -> 0x0057 }
    L_0x0057:
        r4 = move-exception;	 Catch:{ all -> 0x0057 }
        monitor-exit(r0);	 Catch:{ all -> 0x0057 }
        throw r4;
    L_0x005a:
        r0 = "javascript:";
        r4 = java.lang.String.valueOf(r4);
        r1 = r4.length();
        if (r1 == 0) goto L_0x006b;
    L_0x0066:
        r4 = r0.concat(r4);
        goto L_0x0070;
    L_0x006b:
        r4 = new java.lang.String;
        r4.<init>(r0);
    L_0x0070:
        r3.m20311c(r4);
        return;
    L_0x0074:
        r0 = "javascript:";
        r4 = java.lang.String.valueOf(r4);
        r1 = r4.length();
        if (r1 == 0) goto L_0x0085;
    L_0x0080:
        r4 = r0.concat(r4);
        goto L_0x008a;
    L_0x0085:
        r4 = new java.lang.String;
        r4.<init>(r0);
    L_0x008a:
        r3.m20311c(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzanx.d(java.lang.String):void");
    }

    private final void m20313f(boolean z) {
        Map hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        mo3462a("onAdVisibilityChanged", hashMap);
    }

    public final int mo3964A() {
        int i;
        synchronized (this.f19183b) {
            i = this.f19197p;
        }
        return i;
    }

    public final boolean mo3965B() {
        boolean z;
        synchronized (this.f19183b) {
            z = this.f19193l;
        }
        return z;
    }

    public final void mo3966C() {
        synchronized (this.f19183b) {
            zzagf.m13278a("Destroying WebView!");
            m20302R();
            zzahn.f6379a.post(new zzanz(this));
        }
    }

    public final boolean mo3967D() {
        boolean z;
        synchronized (this.f19183b) {
            z = this.f19198q;
        }
        return z;
    }

    public final boolean mo3968E() {
        boolean z;
        synchronized (this.f19183b) {
            z = this.f19199r;
        }
        return z;
    }

    public final boolean mo3969F() {
        boolean z;
        synchronized (this.f19183b) {
            z = this.f19205x > 0;
        }
        return z;
    }

    public final void mo3970G() {
        this.f19174G.m5314a();
    }

    public final OnClickListener mo3972I() {
        return (OnClickListener) this.f19171D.get();
    }

    public final zzoq mo3973J() {
        zzoq com_google_android_gms_internal_zzoq;
        synchronized (this.f19183b) {
            com_google_android_gms_internal_zzoq = this.f19204w;
        }
        return com_google_android_gms_internal_zzoq;
    }

    public final void mo3974K() {
        setBackgroundColor(0);
    }

    public final void mo3975L() {
        zzagf.m13278a("Cannot add text view to inner AdWebView");
    }

    public final zzamg mo3976a() {
        return null;
    }

    public final void mo3979a(zzc com_google_android_gms_ads_internal_overlay_zzc) {
        this.f19188g.m5444a(com_google_android_gms_ads_internal_overlay_zzc);
    }

    public final void mo3980a(zzd com_google_android_gms_ads_internal_overlay_zzd) {
        synchronized (this.f19183b) {
            this.f19189h = com_google_android_gms_ads_internal_overlay_zzd;
        }
    }

    public final void mo3461a(zzaoa com_google_android_gms_internal_zzaoa) {
        synchronized (this.f19183b) {
            if (this.f19201t != null) {
                zzakb.m5368c("Attempt to create multiple AdWebViewVideoControllers.");
                return;
            }
            this.f19201t = com_google_android_gms_internal_zzaoa;
        }
    }

    public final void mo3981a(zzapa com_google_android_gms_internal_zzapa) {
        synchronized (this.f19183b) {
            this.f19190i = com_google_android_gms_internal_zzapa;
            requestLayout();
        }
    }

    public final void mo1711a(zzgs com_google_android_gms_internal_zzgs) {
        synchronized (this.f19183b) {
            this.f19202u = com_google_android_gms_internal_zzgs.f7621a;
        }
        m20313f(com_google_android_gms_internal_zzgs.f7621a);
    }

    public final void mo3982a(zzoq com_google_android_gms_internal_zzoq) {
        synchronized (this.f19183b) {
            this.f19204w = com_google_android_gms_internal_zzoq;
        }
    }

    public final void mo3983a(String str) {
        synchronized (this.f19183b) {
            try {
                super.loadUrl(str);
            } catch (Throwable e) {
                zzbs.m4490i().m13246a(e, "AdWebViewImpl.loadUrlUnsafe");
                zzakb.m5369c("Could not call loadUrl. ", e);
            }
        }
    }

    public final void mo3984a(String str, zzt<? super zzanh> com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh) {
        if (this.f19188g != null) {
            this.f19188g.m5446a(str, (zzt) com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh);
        }
    }

    public final void mo3462a(java.lang.String r2, java.util.Map<java.lang.String, ?> r3) {
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
        r1 = this;
        r0 = com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ JSONException -> 0x000c }
        r3 = r0.m5227a(r3);	 Catch:{ JSONException -> 0x000c }
        r1.mo3463a(r2, r3);
        return;
    L_0x000c:
        r2 = "Could not convert parameters to JSON.";
        com.google.android.gms.internal.zzakb.m5371e(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzanx.a(java.lang.String, java.util.Map):void");
    }

    public final void mo3463a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(window.AFMA_ReceiveMessage || function() {})('");
        stringBuilder.append(str);
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        str = "Dispatching AFMA event: ";
        jSONObject2 = String.valueOf(stringBuilder.toString());
        zzakb.m5366b(jSONObject2.length() != 0 ? str.concat(jSONObject2) : new String(str));
        m20312d(stringBuilder.toString());
    }

    public final void mo3986a(boolean z, int i) {
        this.f19188g.m5447a(z, i);
    }

    public final void mo3987a(boolean z, int i, String str) {
        this.f19188g.m5448a(z, i, str);
    }

    public final void mo3988a(boolean z, int i, String str, String str2) {
        this.f19188g.m5449a(z, i, str, str2);
    }

    public final zzaoa mo3464b() {
        zzaoa com_google_android_gms_internal_zzaoa;
        synchronized (this.f19183b) {
            com_google_android_gms_internal_zzaoa = this.f19201t;
        }
        return com_google_android_gms_internal_zzaoa;
    }

    public final void mo3989b(int i) {
        synchronized (this.f19183b) {
            this.f19197p = i;
            if (this.f19189h != null) {
                this.f19189h.m17402a(this.f19197p);
            }
        }
    }

    public final void mo3990b(zzd com_google_android_gms_ads_internal_overlay_zzd) {
        synchronized (this.f19183b) {
            this.f19172E = com_google_android_gms_ads_internal_overlay_zzd;
        }
    }

    public final void mo3991b(String str) {
        synchronized (this.f19183b) {
            if (str == null) {
                str = "";
            }
            this.f19200s = str;
        }
    }

    public final void mo3465b(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder((3 + String.valueOf(str).length()) + String.valueOf(jSONObject2).length());
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(jSONObject2);
        stringBuilder.append(");");
        m20312d(stringBuilder.toString());
    }

    public final void mo3993b(boolean z) {
        synchronized (this.f19183b) {
            Object obj = z != this.f19194m ? 1 : null;
            this.f19194m = z;
            m20300P();
            if (obj != null) {
                new zzxb(this).m6784b(z ? "expanded" : "default");
            }
        }
    }

    public final zzns mo3466c() {
        return this.f19168A;
    }

    public final void mo3994c(boolean z) {
        synchronized (this.f19183b) {
            if (this.f19189h != null) {
                this.f19189h.m17407a(this.f19188g.m5450a(), z);
            } else {
                this.f19192k = z;
            }
        }
    }

    public final void mo3995d(boolean z) {
        synchronized (this.f19183b) {
            this.f19198q = z;
        }
    }

    public final void destroy() {
        synchronized (this.f19183b) {
            m20304T();
            this.f19174G.m5315b();
            if (this.f19189h != null) {
                this.f19189h.m17401a();
                this.f19189h.mo2288k();
                this.f19189h = null;
            }
            this.f19188g.m5458i();
            if (this.f19193l) {
                return;
            }
            zzbs.m4505x();
            zzamz.m5429a(this);
            m20303S();
            this.f19193l = true;
            zzagf.m13278a("Initiating WebView self destruct sequence in 3...");
            this.f19188g.m5455f();
        }
    }

    public final zzv mo3468e() {
        return this.f19187f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.TargetApi(19)
    public final void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
        r2 = this;
        r0 = r2.f19183b;
        monitor-enter(r0);
        r1 = r2.mo3965B();	 Catch:{ all -> 0x001b }
        if (r1 == 0) goto L_0x0016;
    L_0x0009:
        r3 = "The webview is destroyed. Ignoring action.";
        com.google.android.gms.internal.zzakb.m5371e(r3);	 Catch:{ all -> 0x001b }
        if (r4 == 0) goto L_0x0014;
    L_0x0010:
        r3 = 0;
        r4.onReceiveValue(r3);	 Catch:{ all -> 0x001b }
    L_0x0014:
        monitor-exit(r0);	 Catch:{ all -> 0x001b }
        return;
    L_0x0016:
        super.evaluateJavascript(r3, r4);	 Catch:{ all -> 0x001b }
        monitor-exit(r0);	 Catch:{ all -> 0x001b }
        return;
    L_0x001b:
        r3 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001b }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzanx.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.f19183b != null) {
                synchronized (this.f19183b) {
                    if (!this.f19193l) {
                        this.f19188g.m5458i();
                        zzbs.m4505x();
                        zzamz.m5429a(this);
                        m20303S();
                        m20302R();
                    }
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public final void h_() {
        synchronized (this.f19183b) {
            this.f19199r = true;
            if (this.f19186e != null) {
                this.f19186e.h_();
            }
        }
    }

    public final String mo3470i() {
        String str;
        synchronized (this.f19183b) {
            str = this.f19200s;
        }
        return str;
    }

    public final void i_() {
        synchronized (this.f19183b) {
            this.f19199r = false;
            if (this.f19186e != null) {
                this.f19186e.i_();
            }
        }
    }

    public final zznt mo3471j() {
        return this.f19170C;
    }

    public final zzakd mo3472k() {
        return this.f19185d;
    }

    public final int mo3999l() {
        return getMeasuredHeight();
    }

    public final void loadData(String str, String str2, String str3) {
        synchronized (this.f19183b) {
            if (mo3965B()) {
                zzakb.m5371e("The webview is destroyed. Ignoring action.");
            } else {
                super.loadData(str, str2, str3);
            }
        }
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.f19183b) {
            if (mo3965B()) {
                zzakb.m5371e("The webview is destroyed. Ignoring action.");
            } else {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            }
        }
    }

    public final void loadUrl(String str) {
        synchronized (this.f19183b) {
            if (mo3965B()) {
                zzakb.m5371e("The webview is destroyed. Ignoring action.");
            } else {
                try {
                    super.loadUrl(str);
                } catch (Throwable e) {
                    zzbs.m4490i().m13246a(e, "AdWebViewImpl.loadUrl");
                    zzakb.m5369c("Could not call loadUrl. ", e);
                }
            }
        }
    }

    public final int mo4003m() {
        return getMeasuredWidth();
    }

    public final WebView mo4004n() {
        return this;
    }

    public final void mo4005o() {
        m20299O();
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.f19185d.f17551a);
        mo3462a("onhide", hashMap);
    }

    protected final void onAttachedToWindow() {
        synchronized (this.f19183b) {
            super.onAttachedToWindow();
            if (!mo3965B()) {
                this.f19174G.m5316c();
            }
            boolean z = this.f19202u;
            if (this.f19188g != null && this.f19188g.m5451b()) {
                if (!this.f19203v) {
                    OnGlobalLayoutListener c = this.f19188g.m5452c();
                    if (c != null) {
                        zzbs.m4506y();
                        if (this == null) {
                            throw null;
                        }
                        zzaln.m5398a((View) this, c);
                    }
                    OnScrollChangedListener d = this.f19188g.m5453d();
                    if (d != null) {
                        zzbs.m4506y();
                        if (this == null) {
                            throw null;
                        }
                        zzaln.m5399a((View) this, d);
                    }
                    this.f19203v = true;
                }
                m20297M();
                z = true;
            }
            m20313f(z);
        }
    }

    protected final void onDetachedFromWindow() {
        synchronized (this.f19183b) {
            if (!mo3965B()) {
                this.f19174G.m5317d();
            }
            super.onDetachedFromWindow();
            if (this.f19203v && this.f19188g != null && this.f19188g.m5451b() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                OnGlobalLayoutListener c = this.f19188g.m5452c();
                if (c != null) {
                    zzbs.m4488g().mo4289a(getViewTreeObserver(), c);
                }
                OnScrollChangedListener d = this.f19188g.m5453d();
                if (d != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(d);
                }
                this.f19203v = false;
            }
        }
        m20313f(false);
    }

    public final void onDownloadStart(java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, long r5) {
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
        r0 = this;
        r2 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x0019 }
        r3 = "android.intent.action.VIEW";	 Catch:{ ActivityNotFoundException -> 0x0019 }
        r2.<init>(r3);	 Catch:{ ActivityNotFoundException -> 0x0019 }
        r3 = android.net.Uri.parse(r1);	 Catch:{ ActivityNotFoundException -> 0x0019 }
        r2.setDataAndType(r3, r4);	 Catch:{ ActivityNotFoundException -> 0x0019 }
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ ActivityNotFoundException -> 0x0019 }
        r3 = r0.getContext();	 Catch:{ ActivityNotFoundException -> 0x0019 }
        com.google.android.gms.internal.zzahn.m5167a(r3, r2);	 Catch:{ ActivityNotFoundException -> 0x0019 }
        return;
    L_0x0019:
        r2 = 51;
        r3 = java.lang.String.valueOf(r1);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = java.lang.String.valueOf(r4);
        r3 = r3.length();
        r2 = r2 + r3;
        r3 = new java.lang.StringBuilder;
        r3.<init>(r2);
        r2 = "Couldn't find an Activity to view url/mimetype: ";
        r3.append(r2);
        r3.append(r1);
        r1 = " / ";
        r3.append(r1);
        r3.append(r4);
        r1 = r3.toString();
        com.google.android.gms.internal.zzakb.m5366b(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzanx.onDownloadStart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (((Boolean) zzkb.m6350f().m6488a(zznh.ar)).booleanValue()) {
            float axisValue = motionEvent.getAxisValue(9);
            float axisValue2 = motionEvent.getAxisValue(10);
            if (motionEvent.getActionMasked() == 8 && ((axisValue > 0.0f && !canScrollVertically(-1)) || ((axisValue < 0.0f && !canScrollVertically(1)) || ((axisValue2 > 0.0f && !canScrollHorizontally(-1)) || (axisValue2 < 0.0f && !canScrollHorizontally(1)))))) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public final void onPause() {
        if (!mo3965B()) {
            try {
                super.onPause();
            } catch (Throwable e) {
                zzakb.m5367b("Could not pause webview.", e);
            }
        }
    }

    public final void onResume() {
        if (!mo3965B()) {
            try {
                super.onResume();
            } catch (Throwable e) {
                zzakb.m5367b("Could not resume webview.", e);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f19188g.m5451b()) {
            synchronized (this.f19183b) {
                if (this.f19204w != null) {
                    this.f19204w.mo2069a(motionEvent);
                }
            }
        } else if (this.f19184c != null) {
            this.f19184c.m5820a(motionEvent);
        }
        return mo3965B() ? false : super.onTouchEvent(motionEvent);
    }

    public final void mo4009q() {
        Map hashMap = new HashMap(3);
        zzbs.m4486e();
        hashMap.put("app_muted", String.valueOf(zzahn.m5205d()));
        zzbs.m4486e();
        hashMap.put("app_volume", String.valueOf(zzahn.m5197c()));
        zzbs.m4486e();
        hashMap.put("device_volume", String.valueOf(zzahn.m5217i(getContext())));
        mo3462a("volume", hashMap);
    }

    public final zzd mo4011s() {
        zzd com_google_android_gms_ads_internal_overlay_zzd;
        synchronized (this.f19183b) {
            com_google_android_gms_ads_internal_overlay_zzd = this.f19189h;
        }
        return com_google_android_gms_ads_internal_overlay_zzd;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.f19171D = new WeakReference(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzani) {
            this.f19188g = (zzani) webViewClient;
        }
    }

    public final void stopLoading() {
        if (!mo3965B()) {
            try {
                super.stopLoading();
            } catch (Throwable e) {
                zzakb.m5367b("Could not stop loading webview.", e);
            }
        }
    }

    public final zzd mo4017t() {
        zzd com_google_android_gms_ads_internal_overlay_zzd;
        synchronized (this.f19183b) {
            com_google_android_gms_ads_internal_overlay_zzd = this.f19172E;
        }
        return com_google_android_gms_ads_internal_overlay_zzd;
    }

    public final zzapa mo3474u() {
        zzapa com_google_android_gms_internal_zzapa;
        synchronized (this.f19183b) {
            com_google_android_gms_internal_zzapa = this.f19190i;
        }
        return com_google_android_gms_internal_zzapa;
    }

    public final String mo4018v() {
        String str;
        synchronized (this.f19183b) {
            str = this.f19191j;
        }
        return str;
    }

    public final zzani mo4019w() {
        return this.f19188g;
    }

    public final boolean mo4020x() {
        boolean z;
        synchronized (this.f19183b) {
            z = this.f19192k;
        }
        return z;
    }

    public final zzcv mo3475y() {
        return this.f19184c;
    }

    public final boolean mo3476z() {
        boolean z;
        synchronized (this.f19183b) {
            z = this.f19194m;
        }
        return z;
    }

    private zzanx(zzaoz com_google_android_gms_internal_zzaoz, zzapa com_google_android_gms_internal_zzapa, String str, boolean z, zzcv com_google_android_gms_internal_zzcv, zzakd com_google_android_gms_internal_zzakd, zznu com_google_android_gms_internal_zznu, zzbl com_google_android_gms_ads_internal_zzbl, zzv com_google_android_gms_ads_internal_zzv, zzis com_google_android_gms_internal_zzis) {
        super(com_google_android_gms_internal_zzaoz);
        this.f19182a = com_google_android_gms_internal_zzaoz;
        this.f19190i = com_google_android_gms_internal_zzapa;
        this.f19191j = str;
        this.f19194m = z;
        this.f19197p = -1;
        this.f19184c = com_google_android_gms_internal_zzcv;
        this.f19185d = com_google_android_gms_internal_zzakd;
        this.f19186e = com_google_android_gms_ads_internal_zzbl;
        this.f19187f = com_google_android_gms_ads_internal_zzv;
        this.f19180M = (WindowManager) getContext().getSystemService("window");
        this.f19181N = com_google_android_gms_internal_zzis;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (String str2) {
            zzakb.m5367b("Unable to enable Javascript.", str2);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= true) {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(zzbs.m4486e().m5225a((Context) com_google_android_gms_internal_zzaoz, com_google_android_gms_internal_zzakd.f17551a));
        zzbs.m4488g().mo3438a(getContext(), settings);
        setDownloadListener(this);
        m20300P();
        if (zzq.m4911c() != null) {
            addJavascriptInterface(new zzaod(this, new zzaoe(this)), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.f19174G = new zzajq(this.f19182a.f6676a, this, this, null);
        m20304T();
        this.f19170C = new zznt(new zznu(true, "make_wv", this.f19191j));
        com_google_android_gms_internal_zzapa = this.f19170C.f7941b;
        synchronized (com_google_android_gms_internal_zzapa.f7943b) {
            com_google_android_gms_internal_zzapa.f7945d = com_google_android_gms_internal_zznu;
        }
        this.f19168A = zznn.m6498a(this.f19170C.f7941b);
        this.f19170C.m6501a("native:view_create", this.f19168A);
        this.f19169B = null;
        this.f19207z = null;
        zzbs.m4488g().mo4389b((Context) com_google_android_gms_internal_zzaoz);
    }

    private final boolean m20297M() {
        boolean z = false;
        if (!this.f19188g.m5450a() && !this.f19188g.m5451b()) {
            return false;
        }
        int b;
        int b2;
        zzbs.m4486e();
        DisplayMetrics a = zzahn.m5154a(this.f19180M);
        zzkb.m6345a();
        int b3 = zzajr.m5330b(a, a.widthPixels);
        zzkb.m6345a();
        int b4 = zzajr.m5330b(a, a.heightPixels);
        Activity activity = this.f19182a.f6676a;
        if (activity != null) {
            if (activity.getWindow() != null) {
                zzbs.m4486e();
                int[] a2 = zzahn.m5184a(activity);
                zzkb.m6345a();
                b = zzajr.m5330b(a, a2[0]);
                zzkb.m6345a();
                b2 = zzajr.m5330b(a, a2[1]);
                if (this.f19176I != b3 && this.f19175H == b4 && this.f19177J == b && this.f19178K == b2) {
                    return false;
                }
                if (!(this.f19176I == b3 && this.f19175H == b4)) {
                    z = true;
                }
                this.f19176I = b3;
                this.f19175H = b4;
                this.f19177J = b;
                this.f19178K = b2;
                new zzxb(this).m6782a(b3, b4, b, b2, a.density, this.f19180M.getDefaultDisplay().getRotation());
                return z;
            }
        }
        b = b3;
        b2 = b4;
        if (this.f19176I != b3) {
        }
        z = true;
        this.f19176I = b3;
        this.f19175H = b4;
        this.f19177J = b;
        this.f19178K = b2;
        new zzxb(this).m6782a(b3, b4, b, b2, a.density, this.f19180M.getDefaultDisplay().getRotation());
        return z;
    }

    private final void m20308a(Boolean bool) {
        synchronized (this.f19183b) {
            this.f19196o = bool;
        }
        zzaft i = zzbs.m4490i();
        synchronized (i.f14072a) {
            i.f14076e = bool;
        }
    }

    public final void mo3977a(int i) {
        if (i == 0) {
            zznn.m6499a(this.f19170C.f7941b, this.f19168A, "aebb2");
        }
        m20299O();
        if (this.f19170C.f7941b != null) {
            this.f19170C.f7941b.m6504a("close_type", String.valueOf(i));
        }
        Map hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.f19185d.f17551a);
        mo3462a("onhide", hashMap);
    }

    private final void m20299O() {
        zznn.m6499a(this.f19170C.f7941b, this.f19168A, "aeh2");
    }

    public final void mo4008p() {
        if (this.f19207z == null) {
            zznn.m6499a(this.f19170C.f7941b, this.f19168A, "aes2");
            this.f19207z = zznn.m6498a(this.f19170C.f7941b);
            this.f19170C.m6501a("native:view_show", this.f19207z);
        }
        Map hashMap = new HashMap(1);
        hashMap.put("version", this.f19185d.f17551a);
        mo3462a("onshow", hashMap);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.annotation.SuppressLint({"DrawAllocation"})
    protected final void onMeasure(int r9, int r10) {
        /*
        r8 = this;
        r0 = r8.f19183b;
        monitor-enter(r0);
        r1 = r8.mo3965B();	 Catch:{ all -> 0x019e }
        r2 = 0;
        if (r1 == 0) goto L_0x000f;
    L_0x000a:
        r8.setMeasuredDimension(r2, r2);	 Catch:{ all -> 0x019e }
        monitor-exit(r0);	 Catch:{ all -> 0x019e }
        return;
    L_0x000f:
        r1 = r8.isInEditMode();	 Catch:{ all -> 0x019e }
        if (r1 != 0) goto L_0x0199;
    L_0x0015:
        r1 = r8.f19194m;	 Catch:{ all -> 0x019e }
        if (r1 != 0) goto L_0x0199;
    L_0x0019:
        r1 = r8.f19190i;	 Catch:{ all -> 0x019e }
        r1 = r1.f6683a;	 Catch:{ all -> 0x019e }
        r3 = 1;
        if (r1 != 0) goto L_0x0022;
    L_0x0020:
        r1 = r3;
        goto L_0x0023;
    L_0x0022:
        r1 = r2;
    L_0x0023:
        if (r1 == 0) goto L_0x0027;
    L_0x0025:
        goto L_0x0199;
    L_0x0027:
        r1 = r8.f19190i;	 Catch:{ all -> 0x019e }
        r1 = r1.f6683a;	 Catch:{ all -> 0x019e }
        r4 = 4;
        if (r1 != r4) goto L_0x0030;
    L_0x002e:
        r1 = r3;
        goto L_0x0031;
    L_0x0030:
        r1 = r2;
    L_0x0031:
        if (r1 == 0) goto L_0x0075;
    L_0x0033:
        r1 = r8.mo3464b();	 Catch:{ all -> 0x019e }
        r2 = 0;
        if (r1 == 0) goto L_0x003f;
    L_0x003a:
        r1 = r1.mo2044e();	 Catch:{ all -> 0x019e }
        goto L_0x0040;
    L_0x003f:
        r1 = r2;
    L_0x0040:
        r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
        if (r2 != 0) goto L_0x0049;
    L_0x0044:
        super.onMeasure(r9, r10);	 Catch:{ all -> 0x019e }
        monitor-exit(r0);	 Catch:{ all -> 0x019e }
        return;
    L_0x0049:
        r9 = android.view.View.MeasureSpec.getSize(r9);	 Catch:{ all -> 0x019e }
        r10 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x019e }
        r2 = (float) r10;	 Catch:{ all -> 0x019e }
        r2 = r2 * r1;
        r2 = (int) r2;	 Catch:{ all -> 0x019e }
        r3 = (float) r9;	 Catch:{ all -> 0x019e }
        r3 = r3 / r1;
        r3 = (int) r3;	 Catch:{ all -> 0x019e }
        if (r10 != 0) goto L_0x0060;
    L_0x0059:
        if (r3 == 0) goto L_0x0060;
    L_0x005b:
        r10 = (float) r3;	 Catch:{ all -> 0x019e }
        r10 = r10 * r1;
        r2 = (int) r10;	 Catch:{ all -> 0x019e }
        r10 = r3;
        goto L_0x0068;
    L_0x0060:
        if (r9 != 0) goto L_0x0068;
    L_0x0062:
        if (r2 == 0) goto L_0x0068;
    L_0x0064:
        r9 = (float) r2;	 Catch:{ all -> 0x019e }
        r9 = r9 / r1;
        r3 = (int) r9;	 Catch:{ all -> 0x019e }
        r9 = r2;
    L_0x0068:
        r9 = java.lang.Math.min(r2, r9);	 Catch:{ all -> 0x019e }
        r10 = java.lang.Math.min(r3, r10);	 Catch:{ all -> 0x019e }
        r8.setMeasuredDimension(r9, r10);	 Catch:{ all -> 0x019e }
        monitor-exit(r0);	 Catch:{ all -> 0x019e }
        return;
    L_0x0075:
        r1 = r8.f19190i;	 Catch:{ all -> 0x019e }
        r1 = r1.f6683a;	 Catch:{ all -> 0x019e }
        r5 = 2;
        if (r1 != r5) goto L_0x007d;
    L_0x007c:
        goto L_0x007e;
    L_0x007d:
        r3 = r2;
    L_0x007e:
        if (r3 == 0) goto L_0x00d1;
    L_0x0080:
        r1 = com.google.android.gms.internal.zznh.bW;	 Catch:{ all -> 0x019e }
        r2 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x019e }
        r1 = r2.m6488a(r1);	 Catch:{ all -> 0x019e }
        r1 = (java.lang.Boolean) r1;	 Catch:{ all -> 0x019e }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x019e }
        if (r1 != 0) goto L_0x00cc;
    L_0x0092:
        r1 = com.google.android.gms.common.util.zzq.m4911c();	 Catch:{ all -> 0x019e }
        if (r1 != 0) goto L_0x0099;
    L_0x0098:
        goto L_0x00cc;
    L_0x0099:
        r1 = "/contentHeight";
        r2 = new com.google.android.gms.internal.zzany;	 Catch:{ all -> 0x019e }
        r2.<init>(r8);	 Catch:{ all -> 0x019e }
        r8.mo3984a(r1, r2);	 Catch:{ all -> 0x019e }
        r1 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();";
        r8.m20312d(r1);	 Catch:{ all -> 0x019e }
        r1 = r8.f19182a;	 Catch:{ all -> 0x019e }
        r1 = r1.getResources();	 Catch:{ all -> 0x019e }
        r1 = r1.getDisplayMetrics();	 Catch:{ all -> 0x019e }
        r1 = r1.density;	 Catch:{ all -> 0x019e }
        r9 = android.view.View.MeasureSpec.getSize(r9);	 Catch:{ all -> 0x019e }
        r2 = r8.f19206y;	 Catch:{ all -> 0x019e }
        r3 = -1;
        if (r2 == r3) goto L_0x00c3;
    L_0x00bd:
        r10 = r8.f19206y;	 Catch:{ all -> 0x019e }
        r10 = (float) r10;	 Catch:{ all -> 0x019e }
        r10 = r10 * r1;
        r10 = (int) r10;	 Catch:{ all -> 0x019e }
        goto L_0x00c7;
    L_0x00c3:
        r10 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x019e }
    L_0x00c7:
        r8.setMeasuredDimension(r9, r10);	 Catch:{ all -> 0x019e }
        monitor-exit(r0);	 Catch:{ all -> 0x019e }
        return;
    L_0x00cc:
        super.onMeasure(r9, r10);	 Catch:{ all -> 0x019e }
        monitor-exit(r0);	 Catch:{ all -> 0x019e }
        return;
    L_0x00d1:
        r1 = r8.f19190i;	 Catch:{ all -> 0x019e }
        r1 = r1.m5488c();	 Catch:{ all -> 0x019e }
        if (r1 == 0) goto L_0x00f0;
    L_0x00d9:
        r9 = new android.util.DisplayMetrics;	 Catch:{ all -> 0x019e }
        r9.<init>();	 Catch:{ all -> 0x019e }
        r10 = r8.f19180M;	 Catch:{ all -> 0x019e }
        r10 = r10.getDefaultDisplay();	 Catch:{ all -> 0x019e }
        r10.getMetrics(r9);	 Catch:{ all -> 0x019e }
        r10 = r9.widthPixels;	 Catch:{ all -> 0x019e }
        r9 = r9.heightPixels;	 Catch:{ all -> 0x019e }
        r8.setMeasuredDimension(r10, r9);	 Catch:{ all -> 0x019e }
        monitor-exit(r0);	 Catch:{ all -> 0x019e }
        return;
    L_0x00f0:
        r1 = android.view.View.MeasureSpec.getMode(r9);	 Catch:{ all -> 0x019e }
        r9 = android.view.View.MeasureSpec.getSize(r9);	 Catch:{ all -> 0x019e }
        r3 = android.view.View.MeasureSpec.getMode(r10);	 Catch:{ all -> 0x019e }
        r10 = android.view.View.MeasureSpec.getSize(r10);	 Catch:{ all -> 0x019e }
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r7 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r1 == r6) goto L_0x010e;
    L_0x0109:
        if (r1 != r5) goto L_0x010c;
    L_0x010b:
        goto L_0x010e;
    L_0x010c:
        r1 = r7;
        goto L_0x010f;
    L_0x010e:
        r1 = r9;
    L_0x010f:
        if (r3 == r6) goto L_0x0113;
    L_0x0111:
        if (r3 != r5) goto L_0x0114;
    L_0x0113:
        r7 = r10;
    L_0x0114:
        r3 = r8.f19190i;	 Catch:{ all -> 0x019e }
        r3 = r3.f6685c;	 Catch:{ all -> 0x019e }
        r5 = 8;
        if (r3 > r1) goto L_0x0138;
    L_0x011c:
        r1 = r8.f19190i;	 Catch:{ all -> 0x019e }
        r1 = r1.f6684b;	 Catch:{ all -> 0x019e }
        if (r1 <= r7) goto L_0x0123;
    L_0x0122:
        goto L_0x0138;
    L_0x0123:
        r9 = r8.getVisibility();	 Catch:{ all -> 0x019e }
        if (r9 == r5) goto L_0x012c;
    L_0x0129:
        r8.setVisibility(r2);	 Catch:{ all -> 0x019e }
    L_0x012c:
        r9 = r8.f19190i;	 Catch:{ all -> 0x019e }
        r9 = r9.f6685c;	 Catch:{ all -> 0x019e }
        r10 = r8.f19190i;	 Catch:{ all -> 0x019e }
        r10 = r10.f6684b;	 Catch:{ all -> 0x019e }
        r8.setMeasuredDimension(r9, r10);	 Catch:{ all -> 0x019e }
        goto L_0x0197;
    L_0x0138:
        r1 = r8.f19182a;	 Catch:{ all -> 0x019e }
        r1 = r1.getResources();	 Catch:{ all -> 0x019e }
        r1 = r1.getDisplayMetrics();	 Catch:{ all -> 0x019e }
        r1 = r1.density;	 Catch:{ all -> 0x019e }
        r3 = r8.f19190i;	 Catch:{ all -> 0x019e }
        r3 = r3.f6685c;	 Catch:{ all -> 0x019e }
        r3 = (float) r3;	 Catch:{ all -> 0x019e }
        r3 = r3 / r1;
        r3 = (int) r3;	 Catch:{ all -> 0x019e }
        r6 = r8.f19190i;	 Catch:{ all -> 0x019e }
        r6 = r6.f6684b;	 Catch:{ all -> 0x019e }
        r6 = (float) r6;	 Catch:{ all -> 0x019e }
        r6 = r6 / r1;
        r6 = (int) r6;	 Catch:{ all -> 0x019e }
        r9 = (float) r9;	 Catch:{ all -> 0x019e }
        r9 = r9 / r1;
        r9 = (int) r9;	 Catch:{ all -> 0x019e }
        r10 = (float) r10;	 Catch:{ all -> 0x019e }
        r10 = r10 / r1;
        r10 = (int) r10;	 Catch:{ all -> 0x019e }
        r1 = 103; // 0x67 float:1.44E-43 double:5.1E-322;
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x019e }
        r7.<init>(r1);	 Catch:{ all -> 0x019e }
        r1 = "Not enough space to show ad. Needs ";
        r7.append(r1);	 Catch:{ all -> 0x019e }
        r7.append(r3);	 Catch:{ all -> 0x019e }
        r1 = "x";
        r7.append(r1);	 Catch:{ all -> 0x019e }
        r7.append(r6);	 Catch:{ all -> 0x019e }
        r1 = " dp, but only has ";
        r7.append(r1);	 Catch:{ all -> 0x019e }
        r7.append(r9);	 Catch:{ all -> 0x019e }
        r9 = "x";
        r7.append(r9);	 Catch:{ all -> 0x019e }
        r7.append(r10);	 Catch:{ all -> 0x019e }
        r9 = " dp.";
        r7.append(r9);	 Catch:{ all -> 0x019e }
        r9 = r7.toString();	 Catch:{ all -> 0x019e }
        com.google.android.gms.internal.zzakb.m5371e(r9);	 Catch:{ all -> 0x019e }
        r9 = r8.getVisibility();	 Catch:{ all -> 0x019e }
        if (r9 == r5) goto L_0x0194;
    L_0x0191:
        r8.setVisibility(r4);	 Catch:{ all -> 0x019e }
    L_0x0194:
        r8.setMeasuredDimension(r2, r2);	 Catch:{ all -> 0x019e }
    L_0x0197:
        monitor-exit(r0);	 Catch:{ all -> 0x019e }
        return;
    L_0x0199:
        super.onMeasure(r9, r10);	 Catch:{ all -> 0x019e }
        monitor-exit(r0);	 Catch:{ all -> 0x019e }
        return;
    L_0x019e:
        r9 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x019e }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzanx.onMeasure(int, int):void");
    }

    public final void onGlobalLayout() {
        boolean M = m20297M();
        zzd s = mo4011s();
        if (s != null && M && s.f17111h) {
            s.f17111h = false;
            s.m17421n();
        }
    }

    public final void mo3978a(Context context) {
        this.f19182a.setBaseContext(context);
        this.f19174G.f6466a = this.f19182a.f6676a;
    }

    public final Activity mo3467d() {
        return this.f19182a.f6676a;
    }

    public final Context mo4010r() {
        return this.f19182a.f6677b;
    }

    private final void m20302R() {
        synchronized (this.f19183b) {
            if (!this.f19173F) {
                this.f19173F = true;
                zzbs.m4490i().f14077f.decrementAndGet();
            }
        }
    }

    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (!mo3965B()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                if (!(this.f19188g == null || this.f19188g.f6625l == null)) {
                    this.f19188g.f6625l.mo1524a();
                }
            }
        }
    }

    public final void mo3971H() {
        if (this.f19169B == null) {
            this.f19169B = zznn.m6498a(this.f19170C.f7941b);
            this.f19170C.m6501a("native:view_load", this.f19169B);
        }
    }

    public final void mo3997e(boolean z) {
        synchronized (this.f19183b) {
            this.f19205x += z ? true : true;
            if (this.f19205x > false && this.f19189h) {
                z = this.f19189h;
                synchronized (z.f17112i) {
                    z.f17114k = true;
                    if (z.f17113j != null) {
                        zzahn.f6379a.removeCallbacks(z.f17113j);
                        zzahn.f6379a.post(z.f17113j);
                    }
                }
            }
        }
    }

    private final void m20304T() {
        if (this.f19170C != null) {
            zznu com_google_android_gms_internal_zznu = this.f19170C.f7941b;
            if (!(com_google_android_gms_internal_zznu == null || zzbs.m4490i().m13257e() == null)) {
                zzbs.m4490i().m13257e().m6496a(com_google_android_gms_internal_zznu);
            }
        }
    }

    public final void mo3985a(boolean z) {
        this.f19188g.f6620g = z;
    }

    public final void mo3998f() {
        zzd s = mo4011s();
        if (s != null) {
            s.f17110g.f5481a = true;
        }
    }

    public final void mo3992b(String str, zzt<? super zzanh> com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh) {
        if (this.f19188g != null) {
            zzani com_google_android_gms_internal_zzani = this.f19188g;
            synchronized (com_google_android_gms_internal_zzani.f6616c) {
                List list = (List) com_google_android_gms_internal_zzani.f6615b.get(str);
                if (list == null) {
                    return;
                }
                list.remove(com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh);
            }
        }
    }
}
