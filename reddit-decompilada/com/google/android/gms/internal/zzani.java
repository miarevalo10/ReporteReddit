package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.gmsg.zza;
import com.google.android.gms.ads.internal.gmsg.zzaa;
import com.google.android.gms.ads.internal.gmsg.zzab;
import com.google.android.gms.ads.internal.gmsg.zzb;
import com.google.android.gms.ads.internal.gmsg.zzd;
import com.google.android.gms.ads.internal.gmsg.zzt;
import com.google.android.gms.ads.internal.gmsg.zzx;
import com.google.android.gms.ads.internal.gmsg.zzz;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.ads.internal.zzw;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zzzv
public class zzani extends WebViewClient {
    private static final String[] f6608p = new String[]{"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] f6609q = new String[]{"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private zzxc f6610A;
    private boolean f6611B;
    private boolean f6612C;
    private OnAttachStateChangeListener f6613D;
    protected zzanh f6614a;
    public final HashMap<String, List<zzt<? super zzanh>>> f6615b;
    public final Object f6616c;
    public zzanm f6617d;
    zzann f6618e;
    public zzano f6619f;
    boolean f6620g;
    boolean f6621h;
    public boolean f6622i;
    public zzw f6623j;
    zzwr f6624k;
    public zzanq f6625l;
    protected zzafb f6626m;
    public boolean f6627n;
    public int f6628o;
    private zzje f6629r;
    private zzn f6630s;
    private zzb f6631t;
    private zzx f6632u;
    private boolean f6633v;
    private OnGlobalLayoutListener f6634w;
    private OnScrollChangedListener f6635x;
    private zzq f6636y;
    private final zzxa f6637z;

    public zzani(zzanh com_google_android_gms_internal_zzanh, boolean z) {
        this(com_google_android_gms_internal_zzanh, z, new zzxa(com_google_android_gms_internal_zzanh, com_google_android_gms_internal_zzanh.mo4010r(), new zzmt(com_google_android_gms_internal_zzanh.getContext())));
    }

    private zzani(zzanh com_google_android_gms_internal_zzanh, boolean z, zzxa com_google_android_gms_internal_zzxa) {
        this.f6615b = new HashMap();
        this.f6616c = new Object();
        this.f6620g = false;
        this.f6614a = com_google_android_gms_internal_zzanh;
        this.f6621h = z;
        this.f6637z = com_google_android_gms_internal_zzxa;
        this.f6624k = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.webkit.WebResourceResponse m5433a(java.lang.String r8) throws java.io.IOException {
        /*
        r7 = this;
        r0 = new java.net.URL;
        r0.<init>(r8);
        r8 = 0;
    L_0x0006:
        r8 = r8 + 1;
        r1 = 20;
        if (r8 > r1) goto L_0x00df;
    L_0x000c:
        r1 = r0.openConnection();
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r1.setConnectTimeout(r2);
        r1.setReadTimeout(r2);
        r2 = r1 instanceof java.net.HttpURLConnection;
        if (r2 != 0) goto L_0x0024;
    L_0x001c:
        r8 = new java.io.IOException;
        r0 = "Invalid protocol.";
        r8.<init>(r0);
        throw r8;
    L_0x0024:
        r1 = (java.net.HttpURLConnection) r1;
        r2 = com.google.android.gms.ads.internal.zzbs.m4486e();
        r3 = r7.f6614a;
        r3 = r3.getContext();
        r4 = r7.f6614a;
        r4 = r4.mo3472k();
        r4 = r4.f17551a;
        r2.m5228a(r3, r4, r1);
        r2 = new com.google.android.gms.internal.zzajv;
        r2.<init>();
        r3 = 0;
        r2.m5359a(r1, r3);
        r4 = r1.getResponseCode();
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r5 = r1.getContentType();
        r5 = com.google.android.gms.internal.zzahn.m5211f(r5);
        com.google.android.gms.ads.internal.zzbs.m4486e();
        r6 = r1.getContentType();
        r6 = com.google.android.gms.internal.zzahn.m5214g(r6);
        r2.m5358a(r1, r4);
        r2 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r4 < r2) goto L_0x00d5;
    L_0x0065:
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r4 >= r2) goto L_0x00d5;
    L_0x0069:
        r2 = "Location";
        r2 = r1.getHeaderField(r2);
        if (r2 != 0) goto L_0x0079;
    L_0x0071:
        r8 = new java.io.IOException;
        r0 = "Missing Location header in redirect";
        r8.<init>(r0);
        throw r8;
    L_0x0079:
        r4 = new java.net.URL;
        r4.<init>(r0, r2);
        r0 = r4.getProtocol();
        if (r0 != 0) goto L_0x008a;
    L_0x0084:
        r8 = "Protocol is null";
        com.google.android.gms.internal.zzakb.m5371e(r8);
        return r3;
    L_0x008a:
        r5 = "http";
        r5 = r0.equals(r5);
        if (r5 != 0) goto L_0x00b5;
    L_0x0092:
        r5 = "https";
        r5 = r0.equals(r5);
        if (r5 != 0) goto L_0x00b5;
    L_0x009a:
        r8 = "Unsupported scheme: ";
        r0 = java.lang.String.valueOf(r0);
        r1 = r0.length();
        if (r1 == 0) goto L_0x00ab;
    L_0x00a6:
        r8 = r8.concat(r0);
        goto L_0x00b1;
    L_0x00ab:
        r0 = new java.lang.String;
        r0.<init>(r8);
        r8 = r0;
    L_0x00b1:
        com.google.android.gms.internal.zzakb.m5371e(r8);
        return r3;
    L_0x00b5:
        r0 = "Redirecting to ";
        r2 = java.lang.String.valueOf(r2);
        r3 = r2.length();
        if (r3 == 0) goto L_0x00c6;
    L_0x00c1:
        r0 = r0.concat(r2);
        goto L_0x00cc;
    L_0x00c6:
        r2 = new java.lang.String;
        r2.<init>(r0);
        r0 = r2;
    L_0x00cc:
        com.google.android.gms.internal.zzakb.m5366b(r0);
        r1.disconnect();
        r0 = r4;
        goto L_0x0006;
    L_0x00d5:
        r8 = new android.webkit.WebResourceResponse;
        r0 = r1.getInputStream();
        r8.<init>(r5, r6, r0);
        return r8;
    L_0x00df:
        r8 = new java.io.IOException;
        r0 = 32;
        r1 = new java.lang.StringBuilder;
        r1.<init>(r0);
        r0 = "Too many redirects (20)";
        r1.append(r0);
        r0 = r1.toString();
        r8.<init>(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzani.a(java.lang.String):android.webkit.WebResourceResponse");
    }

    private final void m5435a(Context context, String str, String str2, String str3) {
        if (((Boolean) zzkb.m6350f().m6488a(zznh.be)).booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            str = "host";
            if (!TextUtils.isEmpty(str3)) {
                Uri parse = Uri.parse(str3);
                if (parse.getHost() != null) {
                    str2 = parse.getHost();
                    bundle.putString(str, str2);
                    zzbs.m4486e();
                    zzahn.m5169a(context, this.f6614a.mo3472k().f17551a, "gmob-apps", bundle, true);
                }
            }
            str2 = "";
            bundle.putString(str, str2);
            zzbs.m4486e();
            zzahn.m5169a(context, this.f6614a.mo3472k().f17551a, "gmob-apps", bundle, true);
        }
    }

    private final void m5436a(Uri uri) {
        String path = uri.getPath();
        List<zzt> list = (List) this.f6615b.get(path);
        if (list != null) {
            zzbs.m4486e();
            Map a = zzahn.m5163a(uri);
            if (zzakb.m5365a(2)) {
                String str = "Received GMSG: ";
                path = String.valueOf(path);
                zzagf.m13278a(path.length() != 0 ? str.concat(path) : new String(str));
                for (String str2 : a.keySet()) {
                    String str3 = (String) a.get(str2);
                    StringBuilder stringBuilder = new StringBuilder((4 + String.valueOf(str2).length()) + String.valueOf(str3).length());
                    stringBuilder.append("  ");
                    stringBuilder.append(str2);
                    stringBuilder.append(": ");
                    stringBuilder.append(str3);
                    zzagf.m13278a(stringBuilder.toString());
                }
            }
            for (zzt zza : list) {
                zza.zza(this.f6614a, a);
            }
            return;
        }
        String valueOf = String.valueOf(uri);
        StringBuilder stringBuilder2 = new StringBuilder(32 + String.valueOf(valueOf).length());
        stringBuilder2.append("No GMSG handler found for GMSG: ");
        stringBuilder2.append(valueOf);
        zzagf.m13278a(stringBuilder2.toString());
    }

    private final void m5437a(View view, zzafb com_google_android_gms_internal_zzafb, int i) {
        if (com_google_android_gms_internal_zzafb.mo1706b() && i > 0) {
            com_google_android_gms_internal_zzafb.mo1703a(view);
            if (com_google_android_gms_internal_zzafb.mo1706b()) {
                zzahn.f6379a.postDelayed(new zzanj(this, view, com_google_android_gms_internal_zzafb, i), 100);
            }
        }
    }

    private final void m5438a(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean b = this.f6624k != null ? this.f6624k.m14430b() : false;
        zzbs.m4484c();
        Context context = this.f6614a.getContext();
        if (!b) {
            z = true;
        }
        zzl.m4450a(context, adOverlayInfoParcel, z);
        if (this.f6626m != null) {
            String str = adOverlayInfoParcel.f17091l;
            if (str == null && adOverlayInfoParcel.f17080a != null) {
                str = adOverlayInfoParcel.f17080a.f17095a;
            }
            this.f6626m.mo1704a(str);
        }
    }

    private final void m5441j() {
        if (this.f6613D != null) {
            zzanh com_google_android_gms_internal_zzanh = this.f6614a;
            if (com_google_android_gms_internal_zzanh == null) {
                throw null;
            }
            ((View) com_google_android_gms_internal_zzanh).removeOnAttachStateChangeListener(this.f6613D);
        }
    }

    public final void m5443a(OnGlobalLayoutListener onGlobalLayoutListener, OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.f6616c) {
            this.f6633v = true;
            this.f6614a.mo3970G();
            this.f6634w = onGlobalLayoutListener;
            this.f6635x = onScrollChangedListener;
        }
    }

    public final void m5444a(zzc com_google_android_gms_ads_internal_overlay_zzc) {
        boolean z = this.f6614a.mo3476z();
        zzje com_google_android_gms_internal_zzje = (!z || this.f6614a.mo3474u().m5488c()) ? this.f6629r : null;
        m5438a(new AdOverlayInfoParcel(com_google_android_gms_ads_internal_overlay_zzc, com_google_android_gms_internal_zzje, z ? null : this.f6630s, this.f6636y, this.f6614a.mo3472k()));
    }

    public final void m5445a(zzje com_google_android_gms_internal_zzje, zzn com_google_android_gms_ads_internal_overlay_zzn, zzb com_google_android_gms_ads_internal_gmsg_zzb, zzq com_google_android_gms_ads_internal_overlay_zzq, boolean z, zzx com_google_android_gms_ads_internal_gmsg_zzx, zzw com_google_android_gms_ads_internal_zzw, zzxc com_google_android_gms_internal_zzxc, zzafb com_google_android_gms_internal_zzafb) {
        zzb com_google_android_gms_ads_internal_gmsg_zzb2 = com_google_android_gms_ads_internal_gmsg_zzb;
        zzx com_google_android_gms_ads_internal_gmsg_zzx2 = com_google_android_gms_ads_internal_gmsg_zzx;
        zzxc com_google_android_gms_internal_zzxc2 = com_google_android_gms_internal_zzxc;
        zzafb com_google_android_gms_internal_zzafb2 = com_google_android_gms_internal_zzafb;
        zzw com_google_android_gms_ads_internal_zzw2 = com_google_android_gms_ads_internal_zzw == null ? new zzw(this.f6614a.getContext(), com_google_android_gms_internal_zzafb2, null) : com_google_android_gms_ads_internal_zzw;
        r0.f6624k = new zzwr(r0.f6614a, com_google_android_gms_internal_zzxc2);
        r0.f6626m = com_google_android_gms_internal_zzafb2;
        m5446a("/appEvent", new zza(com_google_android_gms_ads_internal_gmsg_zzb2));
        m5446a("/backButton", zzd.f5435j);
        m5446a("/refresh", zzd.f5436k);
        m5446a("/canOpenURLs", zzd.f5426a);
        m5446a("/canOpenIntents", zzd.f5427b);
        m5446a("/click", zzd.f5428c);
        m5446a("/close", zzd.f5429d);
        m5446a("/customClose", zzd.f5430e);
        m5446a("/instrument", zzd.f5439n);
        m5446a("/delayPageLoaded", zzd.f5441p);
        m5446a("/delayPageClosed", zzd.f5442q);
        m5446a("/getLocationInfo", zzd.f5443r);
        m5446a("/httpTrack", zzd.f5431f);
        m5446a("/log", zzd.f5432g);
        m5446a("/mraid", new zzaa(com_google_android_gms_ads_internal_zzw2, r0.f6624k));
        m5446a("/mraidLoaded", r0.f6637z);
        zzt com_google_android_gms_ads_internal_gmsg_zzt = r1;
        zzab com_google_android_gms_ads_internal_gmsg_zzab = new zzab(r0.f6614a.getContext(), r0.f6614a.mo3472k(), r0.f6614a.mo3475y(), com_google_android_gms_ads_internal_overlay_zzq, com_google_android_gms_internal_zzje, com_google_android_gms_ads_internal_gmsg_zzb2, com_google_android_gms_ads_internal_overlay_zzn, com_google_android_gms_ads_internal_zzw2, r0.f6624k);
        m5446a("/open", com_google_android_gms_ads_internal_gmsg_zzt);
        m5446a("/precache", new zzane());
        m5446a("/touch", zzd.f5434i);
        m5446a("/video", zzd.f5437l);
        m5446a("/videoMeta", zzd.f5438m);
        if (zzbs.m4507z().m5090a(r0.f6614a.getContext())) {
            m5446a("/logScionEvent", new zzz(r0.f6614a.getContext()));
        }
        if (com_google_android_gms_ads_internal_gmsg_zzx2 != null) {
            m5446a("/setInterstitialProperties", new com.google.android.gms.ads.internal.gmsg.zzw(com_google_android_gms_ads_internal_gmsg_zzx2));
        }
        r0.f6629r = com_google_android_gms_internal_zzje;
        r0.f6630s = com_google_android_gms_ads_internal_overlay_zzn;
        r0.f6631t = com_google_android_gms_ads_internal_gmsg_zzb2;
        r0.f6636y = com_google_android_gms_ads_internal_overlay_zzq;
        r0.f6623j = com_google_android_gms_ads_internal_zzw2;
        r0.f6610A = com_google_android_gms_internal_zzxc;
        r0.f6632u = com_google_android_gms_ads_internal_gmsg_zzx2;
        r0.f6620g = z;
    }

    public final void m5446a(String str, zzt<? super zzanh> com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh) {
        synchronized (this.f6616c) {
            List list = (List) this.f6615b.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.f6615b.put(str, list);
            }
            list.add(com_google_android_gms_ads_internal_gmsg_zzt__super_com_google_android_gms_internal_zzanh);
        }
    }

    public final void m5447a(boolean z, int i) {
        zzje com_google_android_gms_internal_zzje = (!this.f6614a.mo3476z() || this.f6614a.mo3474u().m5488c()) ? this.f6629r : null;
        m5438a(new AdOverlayInfoParcel(com_google_android_gms_internal_zzje, this.f6630s, this.f6636y, this.f6614a, z, i, this.f6614a.mo3472k()));
    }

    public final void m5448a(boolean z, int i, String str) {
        boolean z2 = this.f6614a.mo3476z();
        zzje com_google_android_gms_internal_zzje = (!z2 || this.f6614a.mo3474u().m5488c()) ? this.f6629r : null;
        m5438a(new AdOverlayInfoParcel(com_google_android_gms_internal_zzje, z2 ? null : new zzanp(this.f6614a, this.f6630s), this.f6631t, this.f6636y, this.f6614a, z, i, str, this.f6614a.mo3472k()));
    }

    public final void m5449a(boolean z, int i, String str, String str2) {
        boolean z2 = this.f6614a.mo3476z();
        zzje com_google_android_gms_internal_zzje = (!z2 || r0.f6614a.mo3474u().m5488c()) ? r0.f6629r : null;
        m5438a(new AdOverlayInfoParcel(com_google_android_gms_internal_zzje, z2 ? null : new zzanp(r0.f6614a, r0.f6630s), r0.f6631t, r0.f6636y, r0.f6614a, z, i, str, str2, r0.f6614a.mo3472k()));
    }

    public final boolean m5450a() {
        boolean z;
        synchronized (this.f6616c) {
            z = this.f6621h;
        }
        return z;
    }

    public final boolean m5451b() {
        boolean z;
        synchronized (this.f6616c) {
            z = this.f6633v;
        }
        return z;
    }

    public final OnGlobalLayoutListener m5452c() {
        OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.f6616c) {
            onGlobalLayoutListener = this.f6634w;
        }
        return onGlobalLayoutListener;
    }

    public final OnScrollChangedListener m5453d() {
        OnScrollChangedListener onScrollChangedListener;
        synchronized (this.f6616c) {
            onScrollChangedListener = this.f6635x;
        }
        return onScrollChangedListener;
    }

    public final boolean m5454e() {
        boolean z;
        synchronized (this.f6616c) {
            z = this.f6622i;
        }
        return z;
    }

    public final void m5455f() {
        synchronized (this.f6616c) {
            zzagf.m13278a("Loading blank page in WebView, 2...");
            this.f6611B = true;
            this.f6614a.mo3983a("about:blank");
        }
    }

    public final void m5456g() {
        zzafb com_google_android_gms_internal_zzafb = this.f6626m;
        if (com_google_android_gms_internal_zzafb != null) {
            View n = this.f6614a.mo4004n();
            if (ViewCompat.m1209J(n)) {
                m5437a(n, com_google_android_gms_internal_zzafb, 10);
                return;
            }
            m5441j();
            this.f6613D = new zzank(this, com_google_android_gms_internal_zzafb);
            zzanh com_google_android_gms_internal_zzanh = this.f6614a;
            if (com_google_android_gms_internal_zzanh == null) {
                throw null;
            }
            ((View) com_google_android_gms_internal_zzanh).addOnAttachStateChangeListener(this.f6613D);
        }
    }

    public final void m5457h() {
        if (this.f6617d != null && ((this.f6612C && this.f6628o <= 0) || this.f6627n)) {
            this.f6617d.mo1512a(this.f6614a, this.f6627n ^ 1);
            this.f6617d = null;
        }
        this.f6614a.mo3971H();
    }

    public final void m5458i() {
        if (this.f6626m != null) {
            this.f6626m.mo1708d();
            this.f6626m = null;
        }
        m5441j();
        synchronized (this.f6616c) {
            this.f6615b.clear();
            this.f6629r = null;
            this.f6630s = null;
            this.f6617d = null;
            this.f6618e = null;
            this.f6631t = null;
            this.f6620g = false;
            this.f6621h = false;
            this.f6633v = false;
            this.f6622i = false;
            this.f6636y = null;
            this.f6619f = null;
            if (this.f6624k != null) {
                this.f6624k.m14428a(true);
                this.f6624k = null;
            }
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String str2 = "Loading resource: ";
        String valueOf = String.valueOf(str);
        zzagf.m13278a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            m5436a(parse);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
        r0 = this;
        r1 = r0.f6616c;
        monitor-enter(r1);
        r2 = r0.f6611B;	 Catch:{ all -> 0x0027 }
        if (r2 == 0) goto L_0x0013;
    L_0x0007:
        r2 = "Blank page loaded, 1...";
        com.google.android.gms.internal.zzagf.m13278a(r2);	 Catch:{ all -> 0x0027 }
        r2 = r0.f6614a;	 Catch:{ all -> 0x0027 }
        r2.mo3966C();	 Catch:{ all -> 0x0027 }
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        return;
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        r1 = 1;
        r0.f6612C = r1;
        r1 = r0.f6618e;
        if (r1 == 0) goto L_0x0023;
    L_0x001b:
        r1 = r0.f6618e;
        r1.mo2294a();
        r1 = 0;
        r0.f6618e = r1;
    L_0x0023:
        r0.m5457h();
        return;
    L_0x0027:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0027 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzani.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        String str3;
        if (i < 0) {
            int i2 = (-i) - 1;
            if (i2 < f6608p.length) {
                str3 = f6608p[i2];
                m5435a(this.f6614a.getContext(), "http_err", str3, str2);
                super.onReceivedError(webView, i, str, str2);
            }
        }
        str3 = String.valueOf(i);
        m5435a(this.f6614a.getContext(), "http_err", str3, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            String valueOf = (primaryError < 0 || primaryError >= f6609q.length) ? String.valueOf(primaryError) : f6609q[primaryError];
            m5435a(this.f6614a.getContext(), "ssl_err", valueOf, zzbs.m4488g().mo3962a(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            String a = zzafi.m5105a(str, this.f6614a.getContext());
            if (!a.equals(str)) {
                return m5433a(a);
            }
            zzil a2 = zzil.m18752a(str);
            if (a2 != null) {
                zzii a3 = zzbs.m4491j().m6317a(a2);
                if (a3 != null && a3.m18749a()) {
                    return new WebResourceResponse("", "", a3.m18750b());
                }
            }
            if (zzajv.m5355c()) {
                if (((Boolean) zzkb.m6350f().m6488a(zznh.aU)).booleanValue()) {
                    return m5433a(str);
                }
            }
            return null;
        } catch (Throwable e) {
            zzbs.m4490i().m13246a(e, "AdWebViewClient.interceptRequest");
            return null;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (!(keyCode == 79 || keyCode == 222)) {
            switch (keyCode) {
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                    break;
                default:
                    switch (keyCode) {
                        case 126:
                        case 127:
                        case 128:
                        case 129:
                        case 130:
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    public final boolean shouldOverrideUrlLoading(android.webkit.WebView r12, java.lang.String r13) {
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
        r11 = this;
        r0 = "AdWebView shouldOverrideUrlLoading: ";
        r1 = java.lang.String.valueOf(r13);
        r2 = r1.length();
        if (r2 == 0) goto L_0x0011;
    L_0x000c:
        r0 = r0.concat(r1);
        goto L_0x0017;
    L_0x0011:
        r1 = new java.lang.String;
        r1.<init>(r0);
        r0 = r1;
    L_0x0017:
        com.google.android.gms.internal.zzagf.m13278a(r0);
        r0 = android.net.Uri.parse(r13);
        r1 = "gmsg";
        r2 = r0.getScheme();
        r1 = r1.equalsIgnoreCase(r2);
        r2 = 1;
        if (r1 == 0) goto L_0x003b;
    L_0x002b:
        r1 = "mobileads.google.com";
        r3 = r0.getHost();
        r1 = r1.equalsIgnoreCase(r3);
        if (r1 == 0) goto L_0x003b;
    L_0x0037:
        r11.m5436a(r0);
        return r2;
    L_0x003b:
        r1 = r11.f6620g;
        r3 = 0;
        if (r1 == 0) goto L_0x008d;
    L_0x0040:
        r1 = r11.f6614a;
        r1 = r1.mo4004n();
        if (r12 != r1) goto L_0x008d;
    L_0x0048:
        r1 = r0.getScheme();
        r4 = "http";
        r4 = r4.equalsIgnoreCase(r1);
        if (r4 != 0) goto L_0x005f;
    L_0x0054:
        r4 = "https";
        r1 = r4.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x005d;
    L_0x005c:
        goto L_0x005f;
    L_0x005d:
        r1 = 0;
        goto L_0x0060;
    L_0x005f:
        r1 = r2;
    L_0x0060:
        if (r1 == 0) goto L_0x008d;
    L_0x0062:
        r0 = r11.f6629r;
        if (r0 == 0) goto L_0x0088;
    L_0x0066:
        r0 = com.google.android.gms.internal.zznh.ad;
        r1 = com.google.android.gms.internal.zzkb.m6350f();
        r0 = r1.m6488a(r0);
        r0 = (java.lang.Boolean) r0;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0088;
    L_0x0078:
        r0 = r11.f6629r;
        r0.mo1263e();
        r0 = r11.f6626m;
        if (r0 == 0) goto L_0x0086;
    L_0x0081:
        r0 = r11.f6626m;
        r0.mo1704a(r13);
    L_0x0086:
        r11.f6629r = r3;
    L_0x0088:
        r12 = super.shouldOverrideUrlLoading(r12, r13);
        return r12;
    L_0x008d:
        r12 = r11.f6614a;
        r12 = r12.mo4004n();
        r12 = r12.willNotDraw();
        if (r12 != 0) goto L_0x0102;
    L_0x0099:
        r12 = r11.f6614a;	 Catch:{ zzcw -> 0x00c0 }
        r12 = r12.mo3475y();	 Catch:{ zzcw -> 0x00c0 }
        if (r12 == 0) goto L_0x00da;	 Catch:{ zzcw -> 0x00c0 }
    L_0x00a1:
        r1 = r12.m5821a(r0);	 Catch:{ zzcw -> 0x00c0 }
        if (r1 == 0) goto L_0x00da;	 Catch:{ zzcw -> 0x00c0 }
    L_0x00a7:
        r1 = r11.f6614a;	 Catch:{ zzcw -> 0x00c0 }
        r1 = r1.getContext();	 Catch:{ zzcw -> 0x00c0 }
        r4 = r11.f6614a;	 Catch:{ zzcw -> 0x00c0 }
        if (r4 != 0) goto L_0x00b2;	 Catch:{ zzcw -> 0x00c0 }
    L_0x00b1:
        throw r3;	 Catch:{ zzcw -> 0x00c0 }
    L_0x00b2:
        r4 = (android.view.View) r4;	 Catch:{ zzcw -> 0x00c0 }
        r3 = r11.f6614a;	 Catch:{ zzcw -> 0x00c0 }
        r3 = r3.mo3467d();	 Catch:{ zzcw -> 0x00c0 }
        r12 = r12.m5818a(r0, r1, r4, r3);	 Catch:{ zzcw -> 0x00c0 }
        r0 = r12;
        goto L_0x00da;
    L_0x00c0:
        r12 = "Unable to append parameter to URL: ";
        r1 = java.lang.String.valueOf(r13);
        r3 = r1.length();
        if (r3 == 0) goto L_0x00d1;
    L_0x00cc:
        r12 = r12.concat(r1);
        goto L_0x00d7;
    L_0x00d1:
        r1 = new java.lang.String;
        r1.<init>(r12);
        r12 = r1;
    L_0x00d7:
        com.google.android.gms.internal.zzakb.m5371e(r12);
    L_0x00da:
        r12 = r11.f6623j;
        if (r12 == 0) goto L_0x00ed;
    L_0x00de:
        r12 = r11.f6623j;
        r12 = r12.m4520a();
        if (r12 == 0) goto L_0x00e7;
    L_0x00e6:
        goto L_0x00ed;
    L_0x00e7:
        r12 = r11.f6623j;
        r12.m4519a(r13);
        return r2;
    L_0x00ed:
        r12 = new com.google.android.gms.ads.internal.overlay.zzc;
        r4 = "android.intent.action.VIEW";
        r5 = r0.toString();
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r3 = r12;
        r3.<init>(r4, r5, r6, r7, r8, r9, r10);
        r11.m5444a(r12);
        return r2;
    L_0x0102:
        r12 = "AdWebView unable to handle URL: ";
        r13 = java.lang.String.valueOf(r13);
        r0 = r13.length();
        if (r0 == 0) goto L_0x0113;
    L_0x010e:
        r12 = r12.concat(r13);
        goto L_0x0119;
    L_0x0113:
        r13 = new java.lang.String;
        r13.<init>(r12);
        r12 = r13;
    L_0x0119:
        com.google.android.gms.internal.zzakb.m5371e(r12);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzani.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    public final void m5442a(int i, int i2, boolean z) {
        this.f6637z.m14432a(i, i2);
        if (this.f6624k != null) {
            zzwr com_google_android_gms_internal_zzwr = this.f6624k;
            synchronized (com_google_android_gms_internal_zzwr.f14716i) {
                com_google_android_gms_internal_zzwr.f14710c = i;
                com_google_android_gms_internal_zzwr.f14711d = i2;
                if (com_google_android_gms_internal_zzwr.f14723p != 0 && z) {
                    i = com_google_android_gms_internal_zzwr.m14429a();
                    if (i != 0) {
                        z = com_google_android_gms_internal_zzwr.f14723p;
                        zzkb.m6345a();
                        int a = zzajr.m5318a(com_google_android_gms_internal_zzwr.f14718k, i[0]);
                        zzkb.m6345a();
                        z.update(a, zzajr.m5318a(com_google_android_gms_internal_zzwr.f14718k, i[1]), com_google_android_gms_internal_zzwr.f14723p.getWidth(), com_google_android_gms_internal_zzwr.f14723p.getHeight());
                        com_google_android_gms_internal_zzwr.m14427a(i[0], i[1]);
                    } else {
                        com_google_android_gms_internal_zzwr.m14428a(true);
                    }
                }
            }
        }
    }
}
