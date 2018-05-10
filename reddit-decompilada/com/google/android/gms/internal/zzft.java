package com.google.android.gms.internal;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.PowerManager;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzbs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzft implements OnGlobalLayoutListener, OnScrollChangedListener {
    Object f7577a = new Object();
    protected final zzfr f7578b;
    zzga f7579c;
    private final WeakReference<zzafo> f7580d;
    private WeakReference<ViewTreeObserver> f7581e;
    private final zzhd f7582f;
    private final Context f7583g;
    private final WindowManager f7584h;
    private final PowerManager f7585i;
    private final KeyguardManager f7586j;
    private final DisplayMetrics f7587k;
    private boolean f7588l;
    private boolean f7589m = false;
    private boolean f7590n = false;
    private boolean f7591o;
    private boolean f7592p;
    private boolean f7593q;
    private BroadcastReceiver f7594r;
    private final HashSet<Object> f7595s = new HashSet();
    private zzaji f7596t;
    private final HashSet<zzgo> f7597u = new HashSet();
    private final Rect f7598v = new Rect();
    private final zzfw f7599w;
    private float f7600x;

    public zzft(Context context, zzjn com_google_android_gms_internal_zzjn, zzafo com_google_android_gms_internal_zzafo, zzakd com_google_android_gms_internal_zzakd, zzhd com_google_android_gms_internal_zzhd) {
        this.f7580d = new WeakReference(com_google_android_gms_internal_zzafo);
        this.f7582f = com_google_android_gms_internal_zzhd;
        this.f7581e = new WeakReference(null);
        this.f7591o = true;
        this.f7593q = false;
        this.f7596t = new zzaji(200);
        this.f7578b = new zzfr(UUID.randomUUID().toString(), com_google_android_gms_internal_zzakd, com_google_android_gms_internal_zzjn.f18152a, com_google_android_gms_internal_zzafo.f6297j, com_google_android_gms_internal_zzafo.m5110a(), com_google_android_gms_internal_zzjn.f18159h);
        this.f7584h = (WindowManager) context.getSystemService("window");
        this.f7585i = (PowerManager) context.getApplicationContext().getSystemService("power");
        this.f7586j = (KeyguardManager) context.getSystemService("keyguard");
        this.f7583g = context;
        this.f7599w = new zzfw(this, new Handler());
        this.f7583g.getContentResolver().registerContentObserver(System.CONTENT_URI, true, this.f7599w);
        this.f7587k = context.getResources().getDisplayMetrics();
        Display defaultDisplay = this.f7584h.getDefaultDisplay();
        this.f7598v.right = defaultDisplay.getWidth();
        this.f7598v.bottom = defaultDisplay.getHeight();
        m6236a();
    }

    private static int m6228a(int i, DisplayMetrics displayMetrics) {
        return (int) (((float) i) / displayMetrics.density);
    }

    private final JSONObject m6229a(View view, Boolean bool) throws JSONException {
        if (view == null) {
            return m6234j().put("isAttachedToWindow", false).put("isScreenOn", m6235k()).put("isVisible", false);
        }
        boolean a = zzbs.m4488g().mo4423a(view);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationOnScreen(iArr);
            view.getLocationInWindow(iArr2);
        } catch (Throwable e) {
            zzakb.m5367b("Failure getting view location.", e);
        }
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        Rect rect2 = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect2, null);
        Rect rect3 = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect3);
        Rect rect4 = new Rect();
        view.getHitRect(rect4);
        JSONObject j = m6234j();
        j.put("windowVisibility", view.getWindowVisibility()).put("isAttachedToWindow", a).put("viewBox", new JSONObject().put("top", m6228a(this.f7598v.top, this.f7587k)).put("bottom", m6228a(this.f7598v.bottom, this.f7587k)).put("left", m6228a(this.f7598v.left, this.f7587k)).put("right", m6228a(this.f7598v.right, this.f7587k))).put("adBox", new JSONObject().put("top", m6228a(rect.top, this.f7587k)).put("bottom", m6228a(rect.bottom, this.f7587k)).put("left", m6228a(rect.left, this.f7587k)).put("right", m6228a(rect.right, this.f7587k))).put("globalVisibleBox", new JSONObject().put("top", m6228a(rect2.top, this.f7587k)).put("bottom", m6228a(rect2.bottom, this.f7587k)).put("left", m6228a(rect2.left, this.f7587k)).put("right", m6228a(rect2.right, this.f7587k))).put("globalVisibleBoxVisible", globalVisibleRect).put("localVisibleBox", new JSONObject().put("top", m6228a(rect3.top, this.f7587k)).put("bottom", m6228a(rect3.bottom, this.f7587k)).put("left", m6228a(rect3.left, this.f7587k)).put("right", m6228a(rect3.right, this.f7587k))).put("localVisibleBoxVisible", localVisibleRect).put("hitBox", new JSONObject().put("top", m6228a(rect4.top, this.f7587k)).put("bottom", m6228a(rect4.bottom, this.f7587k)).put("left", m6228a(rect4.left, this.f7587k)).put("right", m6228a(rect4.right, this.f7587k))).put("screenDensity", (double) this.f7587k.density);
        if (bool == null) {
            zzbs.m4486e();
            bool = Boolean.valueOf(zzahn.m5181a(view, this.f7585i, this.f7586j));
        }
        j.put("isVisible", bool.booleanValue());
        return j;
    }

    private static JSONObject m6230a(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }

    private final void m6231a(JSONObject jSONObject, boolean z) {
        try {
            jSONObject = m6230a(jSONObject);
            ArrayList arrayList = new ArrayList(this.f7597u);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((zzgo) obj).mo1946a(jSONObject, z);
            }
        } catch (Throwable th) {
            zzakb.m5367b("Skipping active view message.", th);
        }
    }

    private final void m6232h() {
        if (this.f7579c != null) {
            this.f7579c.mo1941a(this);
        }
    }

    private final void m6233i() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f7581e.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this);
            viewTreeObserver.removeGlobalOnLayoutListener(this);
        }
    }

    private final boolean m6235k() {
        return VERSION.SDK_INT >= 20 ? this.f7585i.isInteractive() : this.f7585i.isScreenOn();
    }

    public final void m6236a() {
        zzbs.m4486e();
        this.f7600x = zzahn.m5217i(this.f7583g);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void m6237a(int r8) {
        /*
        r7 = this;
        r0 = r7.f7577a;
        monitor-enter(r0);
        r1 = r7.f7597u;	 Catch:{ all -> 0x00cd }
        r1 = r1.iterator();	 Catch:{ all -> 0x00cd }
    L_0x0009:
        r2 = r1.hasNext();	 Catch:{ all -> 0x00cd }
        r3 = 0;
        r4 = 1;
        if (r2 == 0) goto L_0x001f;
    L_0x0011:
        r2 = r1.next();	 Catch:{ all -> 0x00cd }
        r2 = (com.google.android.gms.internal.zzgo) r2;	 Catch:{ all -> 0x00cd }
        r2 = r2.mo1947a();	 Catch:{ all -> 0x00cd }
        if (r2 == 0) goto L_0x0009;
    L_0x001d:
        r1 = r4;
        goto L_0x0020;
    L_0x001f:
        r1 = r3;
    L_0x0020:
        if (r1 == 0) goto L_0x00cb;
    L_0x0022:
        r1 = r7.f7591o;	 Catch:{ all -> 0x00cd }
        if (r1 != 0) goto L_0x0028;
    L_0x0026:
        goto L_0x00cb;
    L_0x0028:
        r1 = r7.f7582f;	 Catch:{ all -> 0x00cd }
        r1 = r1.mo1943a();	 Catch:{ all -> 0x00cd }
        if (r1 == 0) goto L_0x003f;
    L_0x0030:
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ all -> 0x00cd }
        r2 = r7.f7585i;	 Catch:{ all -> 0x00cd }
        r5 = r7.f7586j;	 Catch:{ all -> 0x00cd }
        r2 = com.google.android.gms.internal.zzahn.m5181a(r1, r2, r5);	 Catch:{ all -> 0x00cd }
        if (r2 == 0) goto L_0x003f;
    L_0x003d:
        r2 = r4;
        goto L_0x0040;
    L_0x003f:
        r2 = r3;
    L_0x0040:
        if (r1 == 0) goto L_0x0052;
    L_0x0042:
        if (r2 == 0) goto L_0x0052;
    L_0x0044:
        r5 = new android.graphics.Rect;	 Catch:{ all -> 0x00cd }
        r5.<init>();	 Catch:{ all -> 0x00cd }
        r6 = 0;
        r5 = r1.getGlobalVisibleRect(r5, r6);	 Catch:{ all -> 0x00cd }
        if (r5 == 0) goto L_0x0052;
    L_0x0050:
        r5 = r4;
        goto L_0x0053;
    L_0x0052:
        r5 = r3;
    L_0x0053:
        r6 = r7.f7582f;	 Catch:{ all -> 0x00cd }
        r6 = r6.mo1944b();	 Catch:{ all -> 0x00cd }
        if (r6 == 0) goto L_0x0060;
    L_0x005b:
        r7.m6240b();	 Catch:{ all -> 0x00cd }
        monitor-exit(r0);	 Catch:{ all -> 0x00cd }
        return;
    L_0x0060:
        if (r8 != r4) goto L_0x0070;
    L_0x0062:
        r6 = r7.f7596t;	 Catch:{ all -> 0x00cd }
        r6 = r6.m5301a();	 Catch:{ all -> 0x00cd }
        if (r6 != 0) goto L_0x0070;
    L_0x006a:
        r6 = r7.f7593q;	 Catch:{ all -> 0x00cd }
        if (r5 != r6) goto L_0x0070;
    L_0x006e:
        monitor-exit(r0);	 Catch:{ all -> 0x00cd }
        return;
    L_0x0070:
        if (r5 != 0) goto L_0x007a;
    L_0x0072:
        r6 = r7.f7593q;	 Catch:{ all -> 0x00cd }
        if (r6 != 0) goto L_0x007a;
    L_0x0076:
        if (r8 != r4) goto L_0x007a;
    L_0x0078:
        monitor-exit(r0);	 Catch:{ all -> 0x00cd }
        return;
    L_0x007a:
        r8 = java.lang.Boolean.valueOf(r2);	 Catch:{ JSONException -> 0x0088, JSONException -> 0x0088 }
        r8 = r7.m6229a(r1, r8);	 Catch:{ JSONException -> 0x0088, JSONException -> 0x0088 }
        r7.m6231a(r8, r3);	 Catch:{ JSONException -> 0x0088, JSONException -> 0x0088 }
        r7.f7593q = r5;	 Catch:{ JSONException -> 0x0088, JSONException -> 0x0088 }
        goto L_0x008e;
    L_0x0088:
        r8 = move-exception;
        r1 = "Active view update failed.";
        com.google.android.gms.internal.zzakb.m5364a(r1, r8);	 Catch:{ all -> 0x00cd }
    L_0x008e:
        r8 = r7.f7582f;	 Catch:{ all -> 0x00cd }
        r8 = r8.mo1945c();	 Catch:{ all -> 0x00cd }
        r8 = r8.mo1943a();	 Catch:{ all -> 0x00cd }
        if (r8 == 0) goto L_0x00c6;
    L_0x009a:
        r1 = r7.f7581e;	 Catch:{ all -> 0x00cd }
        r1 = r1.get();	 Catch:{ all -> 0x00cd }
        r1 = (android.view.ViewTreeObserver) r1;	 Catch:{ all -> 0x00cd }
        r8 = r8.getViewTreeObserver();	 Catch:{ all -> 0x00cd }
        if (r8 == r1) goto L_0x00c6;
    L_0x00a8:
        r7.m6233i();	 Catch:{ all -> 0x00cd }
        r2 = r7.f7588l;	 Catch:{ all -> 0x00cd }
        if (r2 == 0) goto L_0x00b7;
    L_0x00af:
        if (r1 == 0) goto L_0x00bf;
    L_0x00b1:
        r1 = r1.isAlive();	 Catch:{ all -> 0x00cd }
        if (r1 == 0) goto L_0x00bf;
    L_0x00b7:
        r7.f7588l = r4;	 Catch:{ all -> 0x00cd }
        r8.addOnScrollChangedListener(r7);	 Catch:{ all -> 0x00cd }
        r8.addOnGlobalLayoutListener(r7);	 Catch:{ all -> 0x00cd }
    L_0x00bf:
        r1 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x00cd }
        r1.<init>(r8);	 Catch:{ all -> 0x00cd }
        r7.f7581e = r1;	 Catch:{ all -> 0x00cd }
    L_0x00c6:
        r7.m6232h();	 Catch:{ all -> 0x00cd }
        monitor-exit(r0);	 Catch:{ all -> 0x00cd }
        return;
    L_0x00cb:
        monitor-exit(r0);	 Catch:{ all -> 0x00cd }
        return;
    L_0x00cd:
        r8 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00cd }
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzft.a(int):void");
    }

    public final void m6241b(zzgo com_google_android_gms_internal_zzgo) {
        if (this.f7597u.isEmpty()) {
            synchronized (this.f7577a) {
                if (this.f7594r == null) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    this.f7594r = new zzfu(this);
                    zzbs.m4480C().m5309a(this.f7583g, this.f7594r, intentFilter);
                }
            }
            m6237a(3);
        }
        this.f7597u.add(com_google_android_gms_internal_zzgo);
        try {
            com_google_android_gms_internal_zzgo.mo1946a(m6230a(m6229a(this.f7582f.mo1943a(), null)), false);
        } catch (Throwable e) {
            zzakb.m5367b("Skipping measurement update for new client.", e);
        }
    }

    final void m6242b(Map<String, String> map) {
        if (map.containsKey("isVisible")) {
            if (!"1".equals(map.get("isVisible"))) {
                "true".equals(map.get("isVisible"));
            }
            Iterator it = this.f7595s.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void m6243c(zzgo com_google_android_gms_internal_zzgo) {
        this.f7597u.remove(com_google_android_gms_internal_zzgo);
        com_google_android_gms_internal_zzgo.mo1948b();
        if (this.f7597u.isEmpty()) {
            synchronized (this.f7577a) {
                m6233i();
                synchronized (this.f7577a) {
                    if (this.f7594r != null) {
                        try {
                            zzbs.m4480C().m5308a(this.f7583g, this.f7594r);
                        } catch (Throwable e) {
                            zzakb.m5367b("Failed trying to unregister the receiver", e);
                        } catch (Throwable e2) {
                            zzbs.m4490i().m13246a(e2, "ActiveViewUnit.stopScreenStatusMonitoring");
                        }
                        this.f7594r = null;
                    }
                }
                this.f7583g.getContentResolver().unregisterContentObserver(this.f7599w);
                int i = 0;
                this.f7591o = false;
                m6232h();
                ArrayList arrayList = new ArrayList(this.f7597u);
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    m6243c((zzgo) obj);
                }
            }
        }
    }

    public final boolean m6244c() {
        boolean z;
        synchronized (this.f7577a) {
            z = this.f7591o;
        }
        return z;
    }

    final void m6245d() {
        m6237a(3);
    }

    public final void m6246e() {
        synchronized (this.f7577a) {
            this.f7590n = true;
            m6237a(3);
        }
    }

    public final void m6247f() {
        synchronized (this.f7577a) {
            this.f7589m = true;
            m6237a(3);
        }
    }

    public final void m6248g() {
        synchronized (this.f7577a) {
            this.f7589m = false;
            m6237a(3);
        }
    }

    public final void onGlobalLayout() {
        m6237a(2);
    }

    public final void onScrollChanged() {
        m6237a(1);
    }

    public final void m6240b() {
        String str;
        String str2;
        synchronized (this.f7577a) {
            if (this.f7591o) {
                this.f7592p = true;
                try {
                    JSONObject j = m6234j();
                    j.put("doneReasonCode", "u");
                    m6231a(j, true);
                } catch (JSONException e) {
                    Throwable e2 = e;
                    str = "JSON failure while processing active view data.";
                    zzakb.m5367b(str, e2);
                    str2 = "Untracking ad unit: ";
                    str = String.valueOf(this.f7578b.f7573c);
                    zzakb.m5366b(str.length() != 0 ? new String(str2) : str2.concat(str));
                } catch (RuntimeException e3) {
                    e2 = e3;
                    str = "Failure while processing active view data.";
                    zzakb.m5367b(str, e2);
                    str2 = "Untracking ad unit: ";
                    str = String.valueOf(this.f7578b.f7573c);
                    if (str.length() != 0) {
                    }
                    zzakb.m5366b(str.length() != 0 ? new String(str2) : str2.concat(str));
                }
                str2 = "Untracking ad unit: ";
                str = String.valueOf(this.f7578b.f7573c);
                if (str.length() != 0) {
                }
                zzakb.m5366b(str.length() != 0 ? new String(str2) : str2.concat(str));
            }
        }
    }

    final boolean m6239a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return (TextUtils.isEmpty(str) || str.equals(this.f7578b.f7573c) == null) ? false : true;
    }

    final void m6238a(zzgo com_google_android_gms_internal_zzgo) {
        String str = "Received request to untrack: ";
        String valueOf = String.valueOf(this.f7578b.f7573c);
        zzakb.m5366b(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        m6243c(com_google_android_gms_internal_zzgo);
    }

    private final JSONObject m6234j() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        zzbs.m4486e();
        zzbs.m4486e();
        jSONObject.put("afmaVersion", this.f7578b.f7574d).put("activeViewJSON", this.f7578b.f7572b).put("timestamp", zzbs.m4492k().mo1633b()).put("adFormat", this.f7578b.f7571a).put("hashCode", this.f7578b.f7573c).put("isMraid", this.f7578b.f7575e).put("isStopped", this.f7590n).put("isPaused", this.f7589m).put("isNative", this.f7578b.f7576f).put("isScreenOn", m6235k()).put("appMuted", zzahn.m5205d()).put("appVolume", (double) zzahn.m5197c()).put("deviceVolume", (double) this.f7600x);
        return jSONObject;
    }
}
