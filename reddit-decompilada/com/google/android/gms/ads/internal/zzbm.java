package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.internal.zzadp;
import com.google.android.gms.internal.zzahh;
import com.google.android.gms.internal.zzakb;
import com.google.android.gms.internal.zzakd;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzjj;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzkb;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzkx;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzoa;
import com.google.android.gms.internal.zzxl;
import com.google.android.gms.internal.zzxr;
import com.google.android.gms.internal.zzzv;
import java.util.Map;
import java.util.concurrent.Future;

@zzzv
public final class zzbm extends zzkt {
    private final zzakd f17185a;
    private final zzjn f17186b;
    private final Future<zzcv> f17187c = zzahh.m5149a(zzahh.f6369a, new zzbp(this));
    private final Context f17188d;
    private final zzbr f17189e;
    private WebView f17190f = new WebView(this.f17188d);
    private zzkh f17191g;
    private zzcv f17192h;
    private AsyncTask<Void, Void, String> f17193i;

    public zzbm(Context context, zzjn com_google_android_gms_internal_zzjn, String str, zzakd com_google_android_gms_internal_zzakd) {
        this.f17188d = context;
        this.f17185a = com_google_android_gms_internal_zzakd;
        this.f17186b = com_google_android_gms_internal_zzjn;
        this.f17189e = new zzbr(str);
        m17530a(0);
        this.f17190f.setVerticalScrollBarEnabled(false);
        this.f17190f.getSettings().setJavaScriptEnabled(true);
        this.f17190f.setWebViewClient(new zzbn(this));
        this.f17190f.setOnTouchListener(new zzbo(this));
    }

    private final String m17521c(String str) {
        if (this.f17192h == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.f17192h.m5818a(parse, this.f17188d, null, null);
        } catch (Throwable e) {
            zzakb.m5369c("Unable to process ad data", e);
        }
        return parse.toString();
    }

    public final String mo1985A() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    public final zzkx mo1986B() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzkh mo1987C() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    public final void mo1988D() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final String mo1989a() throws RemoteException {
        return null;
    }

    final void m17530a(int i) {
        if (this.f17190f != null) {
            this.f17190f.setLayoutParams(new LayoutParams(-1, i));
        }
    }

    public final void mo1990a(zzadp com_google_android_gms_internal_zzadp) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void mo1991a(zzjn com_google_android_gms_internal_zzjn) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void mo1992a(zzke com_google_android_gms_internal_zzke) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void mo1993a(zzkh com_google_android_gms_internal_zzkh) throws RemoteException {
        this.f17191g = com_google_android_gms_internal_zzkh;
    }

    public final void mo1994a(zzkx com_google_android_gms_internal_zzkx) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void mo1995a(zzld com_google_android_gms_internal_zzld) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void mo1996a(zzlr com_google_android_gms_internal_zzlr) {
        throw new IllegalStateException("Unused method");
    }

    public final void mo1997a(zzmr com_google_android_gms_internal_zzmr) {
        throw new IllegalStateException("Unused method");
    }

    public final void mo1998a(zzoa com_google_android_gms_internal_zzoa) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void mo1999a(zzxl com_google_android_gms_internal_zzxl) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void mo2000a(zzxr com_google_android_gms_internal_zzxr, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void mo2001a(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    final int m17543b(java.lang.String r3) {
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
        r2 = this;
        r3 = android.net.Uri.parse(r3);
        r0 = "height";
        r3 = r3.getQueryParameter(r0);
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        com.google.android.gms.internal.zzkb.m6345a();	 Catch:{ NumberFormatException -> 0x0020 }
        r0 = r2.f17188d;	 Catch:{ NumberFormatException -> 0x0020 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0020 }
        r3 = com.google.android.gms.internal.zzajr.m5318a(r0, r3);	 Catch:{ NumberFormatException -> 0x0020 }
        return r3;
    L_0x0020:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzbm.b(java.lang.String):int");
    }

    public final void mo2002b(boolean z) throws RemoteException {
    }

    public final void mo2004c(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    public final String g_() throws RemoteException {
        return null;
    }

    public final void mo2006i() throws RemoteException {
        zzbq.m4816b("destroy must be called on the main UI thread.");
        this.f17193i.cancel(true);
        this.f17187c.cancel(true);
        this.f17190f.destroy();
        this.f17190f = null;
    }

    public final IObjectWrapper mo2007j() throws RemoteException {
        zzbq.m4816b("getAdFrame must be called on the main UI thread.");
        return zzn.m17692a(this.f17190f);
    }

    public final zzjn mo2008k() throws RemoteException {
        return this.f17186b;
    }

    public final boolean mo2009l() throws RemoteException {
        return false;
    }

    public final void mo2010m() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void mo2011n() throws RemoteException {
        zzbq.m4816b("pause must be called on the main UI thread.");
    }

    public final void mo2012o() throws RemoteException {
        zzbq.m4816b("resume must be called on the main UI thread.");
    }

    public final void mo2013p() throws RemoteException {
    }

    public final boolean mo2014q() throws RemoteException {
        return false;
    }

    public final zzll mo2015r() {
        return null;
    }

    public final boolean mo2003b(zzjj com_google_android_gms_internal_zzjj) throws RemoteException {
        zzbq.m4809a(this.f17190f, (Object) "This Search Ad has already been torn down");
        zzbr com_google_android_gms_ads_internal_zzbr = this.f17189e;
        zzakd com_google_android_gms_internal_zzakd = this.f17185a;
        com_google_android_gms_ads_internal_zzbr.f5548c = com_google_android_gms_internal_zzjj.f18143j.f18169a;
        com_google_android_gms_internal_zzjj = com_google_android_gms_internal_zzjj.f18146m != null ? com_google_android_gms_internal_zzjj.f18146m.getBundle(AdMobAdapter.class.getName()) : null;
        if (com_google_android_gms_internal_zzjj != null) {
            String str = (String) zzkb.m6350f().m6488a(zznh.ci);
            for (String str2 : com_google_android_gms_internal_zzjj.keySet()) {
                if (str.equals(str2)) {
                    com_google_android_gms_ads_internal_zzbr.f5549d = com_google_android_gms_internal_zzjj.getString(str2);
                } else if (str2.startsWith("csa_")) {
                    com_google_android_gms_ads_internal_zzbr.f5547b.put(str2.substring(4), com_google_android_gms_internal_zzjj.getString(str2));
                }
            }
            com_google_android_gms_ads_internal_zzbr.f5547b.put("SDKVersion", com_google_android_gms_internal_zzakd.f17551a);
        }
        this.f17193i = new zzbq().execute(new Void[0]);
        return true;
    }

    final String m17546c() {
        Builder builder = new Builder();
        builder.scheme("https://").appendEncodedPath((String) zzkb.m6350f().m6488a(zznh.ch));
        builder.appendQueryParameter("query", this.f17189e.f5548c);
        builder.appendQueryParameter("pubId", this.f17189e.f5546a);
        Map map = this.f17189e.f5547b;
        for (String str : map.keySet()) {
            builder.appendQueryParameter(str, (String) map.get(str));
        }
        Uri build = builder.build();
        if (this.f17192h != null) {
            try {
                build = this.f17192h.m5819a(build, this.f17188d, null, false, null, null);
            } catch (Throwable e) {
                zzakb.m5369c("Unable to process ad data", e);
            }
        }
        String d = m17548d();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder stringBuilder = new StringBuilder((1 + String.valueOf(d).length()) + String.valueOf(encodedQuery).length());
        stringBuilder.append(d);
        stringBuilder.append("#");
        stringBuilder.append(encodedQuery);
        return stringBuilder.toString();
    }

    final String m17548d() {
        String str = this.f17189e.f5549d;
        if (TextUtils.isEmpty(str)) {
            str = "www.google.com";
        }
        String str2 = "https://";
        String str3 = (String) zzkb.m6350f().m6488a(zznh.ch);
        StringBuilder stringBuilder = new StringBuilder((String.valueOf(str2).length() + String.valueOf(str).length()) + String.valueOf(str3).length());
        stringBuilder.append(str2);
        stringBuilder.append(str);
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    static /* synthetic */ void m17519b(zzbm com_google_android_gms_ads_internal_zzbm, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        com_google_android_gms_ads_internal_zzbm.f17188d.startActivity(intent);
    }
}
