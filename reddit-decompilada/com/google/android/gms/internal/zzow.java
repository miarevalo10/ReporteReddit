package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.zzbs;
import com.google.android.gms.common.internal.zzbq;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public class zzow implements zzos {
    final zzot f14574a;
    final Context f14575b;
    final zzou f14576c;
    boolean f14577d;
    private final Object f14578e = new Object();
    private final JSONObject f14579f;
    private final zzzb f14580g;
    private final zzcv f14581h;
    private final zzakd f14582i;
    private String f14583j;
    private zzafe f14584k;
    private WeakReference<View> f14585l = null;

    public zzow(Context context, zzot com_google_android_gms_internal_zzot, zzzb com_google_android_gms_internal_zzzb, zzcv com_google_android_gms_internal_zzcv, JSONObject jSONObject, zzou com_google_android_gms_internal_zzou, zzakd com_google_android_gms_internal_zzakd, String str) {
        this.f14575b = context;
        this.f14574a = com_google_android_gms_internal_zzot;
        this.f14580g = com_google_android_gms_internal_zzzb;
        this.f14581h = com_google_android_gms_internal_zzcv;
        this.f14579f = jSONObject;
        this.f14576c = com_google_android_gms_internal_zzou;
        this.f14582i = com_google_android_gms_internal_zzakd;
        this.f14583j = str;
    }

    private final int m14116a(int i) {
        zzkb.m6345a();
        return zzajr.m5329b(this.f14575b, i);
    }

    private final JSONObject m14117a(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", m14116a(rect.right - rect.left));
        jSONObject.put("height", m14116a(rect.bottom - rect.top));
        jSONObject.put("x", m14116a(rect.left));
        jSONObject.put("y", m14116a(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private final org.json.JSONObject m14118a(java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r13, android.view.View r14) {
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
        r12 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        if (r13 == 0) goto L_0x0104;
    L_0x0007:
        if (r14 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r14 = m14123d(r14);
        monitor-enter(r13);
        r1 = r13.entrySet();	 Catch:{ all -> 0x0101 }
        r1 = r1.iterator();	 Catch:{ all -> 0x0101 }
    L_0x0017:
        r2 = r1.hasNext();	 Catch:{ all -> 0x0101 }
        if (r2 == 0) goto L_0x00ff;	 Catch:{ all -> 0x0101 }
    L_0x001d:
        r2 = r1.next();	 Catch:{ all -> 0x0101 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ all -> 0x0101 }
        r3 = r2.getValue();	 Catch:{ all -> 0x0101 }
        r3 = (java.lang.ref.WeakReference) r3;	 Catch:{ all -> 0x0101 }
        r3 = r3.get();	 Catch:{ all -> 0x0101 }
        r3 = (android.view.View) r3;	 Catch:{ all -> 0x0101 }
        if (r3 == 0) goto L_0x0017;	 Catch:{ all -> 0x0101 }
    L_0x0031:
        r4 = m14123d(r3);	 Catch:{ all -> 0x0101 }
        r5 = new org.json.JSONObject;	 Catch:{ all -> 0x0101 }
        r5.<init>();	 Catch:{ all -> 0x0101 }
        r6 = new org.json.JSONObject;	 Catch:{ all -> 0x0101 }
        r6.<init>();	 Catch:{ all -> 0x0101 }
        r7 = "width";	 Catch:{ JSONException -> 0x00f8 }
        r8 = r3.getMeasuredWidth();	 Catch:{ JSONException -> 0x00f8 }
        r8 = r12.m14116a(r8);	 Catch:{ JSONException -> 0x00f8 }
        r6.put(r7, r8);	 Catch:{ JSONException -> 0x00f8 }
        r7 = "height";	 Catch:{ JSONException -> 0x00f8 }
        r8 = r3.getMeasuredHeight();	 Catch:{ JSONException -> 0x00f8 }
        r8 = r12.m14116a(r8);	 Catch:{ JSONException -> 0x00f8 }
        r6.put(r7, r8);	 Catch:{ JSONException -> 0x00f8 }
        r7 = "x";	 Catch:{ JSONException -> 0x00f8 }
        r8 = 0;	 Catch:{ JSONException -> 0x00f8 }
        r9 = r4[r8];	 Catch:{ JSONException -> 0x00f8 }
        r10 = r14[r8];	 Catch:{ JSONException -> 0x00f8 }
        r9 = r9 - r10;	 Catch:{ JSONException -> 0x00f8 }
        r9 = r12.m14116a(r9);	 Catch:{ JSONException -> 0x00f8 }
        r6.put(r7, r9);	 Catch:{ JSONException -> 0x00f8 }
        r7 = "y";	 Catch:{ JSONException -> 0x00f8 }
        r9 = 1;	 Catch:{ JSONException -> 0x00f8 }
        r10 = r4[r9];	 Catch:{ JSONException -> 0x00f8 }
        r11 = r14[r9];	 Catch:{ JSONException -> 0x00f8 }
        r10 = r10 - r11;	 Catch:{ JSONException -> 0x00f8 }
        r10 = r12.m14116a(r10);	 Catch:{ JSONException -> 0x00f8 }
        r6.put(r7, r10);	 Catch:{ JSONException -> 0x00f8 }
        r7 = "relative_to";	 Catch:{ JSONException -> 0x00f8 }
        r10 = "ad_view";	 Catch:{ JSONException -> 0x00f8 }
        r6.put(r7, r10);	 Catch:{ JSONException -> 0x00f8 }
        r7 = "frame";	 Catch:{ JSONException -> 0x00f8 }
        r5.put(r7, r6);	 Catch:{ JSONException -> 0x00f8 }
        r6 = new android.graphics.Rect;	 Catch:{ JSONException -> 0x00f8 }
        r6.<init>();	 Catch:{ JSONException -> 0x00f8 }
        r7 = r3.getLocalVisibleRect(r6);	 Catch:{ JSONException -> 0x00f8 }
        if (r7 == 0) goto L_0x0093;	 Catch:{ JSONException -> 0x00f8 }
    L_0x008e:
        r4 = r12.m14117a(r6);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x00c6;	 Catch:{ JSONException -> 0x00f8 }
    L_0x0093:
        r6 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x00f8 }
        r6.<init>();	 Catch:{ JSONException -> 0x00f8 }
        r7 = "width";	 Catch:{ JSONException -> 0x00f8 }
        r6.put(r7, r8);	 Catch:{ JSONException -> 0x00f8 }
        r7 = "height";	 Catch:{ JSONException -> 0x00f8 }
        r6.put(r7, r8);	 Catch:{ JSONException -> 0x00f8 }
        r7 = "x";	 Catch:{ JSONException -> 0x00f8 }
        r10 = r4[r8];	 Catch:{ JSONException -> 0x00f8 }
        r8 = r14[r8];	 Catch:{ JSONException -> 0x00f8 }
        r10 = r10 - r8;	 Catch:{ JSONException -> 0x00f8 }
        r8 = r12.m14116a(r10);	 Catch:{ JSONException -> 0x00f8 }
        r6.put(r7, r8);	 Catch:{ JSONException -> 0x00f8 }
        r7 = "y";	 Catch:{ JSONException -> 0x00f8 }
        r4 = r4[r9];	 Catch:{ JSONException -> 0x00f8 }
        r8 = r14[r9];	 Catch:{ JSONException -> 0x00f8 }
        r4 = r4 - r8;	 Catch:{ JSONException -> 0x00f8 }
        r4 = r12.m14116a(r4);	 Catch:{ JSONException -> 0x00f8 }
        r6.put(r7, r4);	 Catch:{ JSONException -> 0x00f8 }
        r4 = "relative_to";	 Catch:{ JSONException -> 0x00f8 }
        r7 = "ad_view";	 Catch:{ JSONException -> 0x00f8 }
        r6.put(r4, r7);	 Catch:{ JSONException -> 0x00f8 }
        r4 = r6;	 Catch:{ JSONException -> 0x00f8 }
    L_0x00c6:
        r6 = "visible_bounds";	 Catch:{ JSONException -> 0x00f8 }
        r5.put(r6, r4);	 Catch:{ JSONException -> 0x00f8 }
        r4 = r3 instanceof android.widget.TextView;	 Catch:{ JSONException -> 0x00f8 }
        if (r4 == 0) goto L_0x00ed;	 Catch:{ JSONException -> 0x00f8 }
    L_0x00cf:
        r3 = (android.widget.TextView) r3;	 Catch:{ JSONException -> 0x00f8 }
        r4 = "text_color";	 Catch:{ JSONException -> 0x00f8 }
        r6 = r3.getCurrentTextColor();	 Catch:{ JSONException -> 0x00f8 }
        r5.put(r4, r6);	 Catch:{ JSONException -> 0x00f8 }
        r4 = "font_size";	 Catch:{ JSONException -> 0x00f8 }
        r6 = r3.getTextSize();	 Catch:{ JSONException -> 0x00f8 }
        r6 = (double) r6;	 Catch:{ JSONException -> 0x00f8 }
        r5.put(r4, r6);	 Catch:{ JSONException -> 0x00f8 }
        r4 = "text";	 Catch:{ JSONException -> 0x00f8 }
        r3 = r3.getText();	 Catch:{ JSONException -> 0x00f8 }
        r5.put(r4, r3);	 Catch:{ JSONException -> 0x00f8 }
    L_0x00ed:
        r2 = r2.getKey();	 Catch:{ JSONException -> 0x00f8 }
        r2 = (java.lang.String) r2;	 Catch:{ JSONException -> 0x00f8 }
        r0.put(r2, r5);	 Catch:{ JSONException -> 0x00f8 }
        goto L_0x0017;
    L_0x00f8:
        r2 = "Unable to get asset views information";	 Catch:{ all -> 0x0101 }
        com.google.android.gms.internal.zzakb.m5371e(r2);	 Catch:{ all -> 0x0101 }
        goto L_0x0017;	 Catch:{ all -> 0x0101 }
    L_0x00ff:
        monitor-exit(r13);	 Catch:{ all -> 0x0101 }
        return r0;	 Catch:{ all -> 0x0101 }
    L_0x0101:
        r14 = move-exception;	 Catch:{ all -> 0x0101 }
        monitor-exit(r13);	 Catch:{ all -> 0x0101 }
        throw r14;
    L_0x0104:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzow.a(java.util.Map, android.view.View):org.json.JSONObject");
    }

    private final boolean m14120a(String str) {
        JSONObject optJSONObject = this.f14579f == null ? null : this.f14579f.optJSONObject("allow_pub_event_reporting");
        return optJSONObject == null ? false : optJSONObject.optBoolean(str, false);
    }

    private final boolean m14121a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        zzbq.m4816b("recordImpression must be called on the main UI thread.");
        if (this.f14577d) {
            return true;
        }
        this.f14577d = true;
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.f14579f);
            jSONObject6.put("ads_id", this.f14583j);
            if (jSONObject2 != null) {
                jSONObject6.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject6.put("ad_view_signal", jSONObject);
            }
            if (jSONObject3 != null) {
                jSONObject6.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject6.put("lock_screen_signal", jSONObject4);
            }
            if (jSONObject5 != null) {
                jSONObject6.put("provided_signals", jSONObject5);
            }
            zzakj.m5376a(this.f14580g.mo3579c(jSONObject6), "NativeAdEngineImpl.recordImpression");
            this.f14574a.mo4269a((zzos) this);
            this.f14574a.m6549z();
            return true;
        } catch (Throwable e) {
            zzakb.m5367b("Unable to create impression JSON.", e);
            return false;
        }
    }

    private static boolean m14122c(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    private static int[] m14123d(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    private final org.json.JSONObject m14124e(android.view.View r8) {
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
        r7 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        if (r8 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = m14123d(r8);	 Catch:{ Exception -> 0x0091 }
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0091 }
        r2.<init>();	 Catch:{ Exception -> 0x0091 }
        r3 = "width";	 Catch:{ Exception -> 0x0091 }
        r4 = r8.getMeasuredWidth();	 Catch:{ Exception -> 0x0091 }
        r4 = r7.m14116a(r4);	 Catch:{ Exception -> 0x0091 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x0091 }
        r3 = "height";	 Catch:{ Exception -> 0x0091 }
        r4 = r8.getMeasuredHeight();	 Catch:{ Exception -> 0x0091 }
        r4 = r7.m14116a(r4);	 Catch:{ Exception -> 0x0091 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x0091 }
        r3 = "x";	 Catch:{ Exception -> 0x0091 }
        r4 = 0;	 Catch:{ Exception -> 0x0091 }
        r5 = r1[r4];	 Catch:{ Exception -> 0x0091 }
        r5 = r7.m14116a(r5);	 Catch:{ Exception -> 0x0091 }
        r2.put(r3, r5);	 Catch:{ Exception -> 0x0091 }
        r3 = "y";	 Catch:{ Exception -> 0x0091 }
        r5 = 1;	 Catch:{ Exception -> 0x0091 }
        r6 = r1[r5];	 Catch:{ Exception -> 0x0091 }
        r6 = r7.m14116a(r6);	 Catch:{ Exception -> 0x0091 }
        r2.put(r3, r6);	 Catch:{ Exception -> 0x0091 }
        r3 = "relative_to";	 Catch:{ Exception -> 0x0091 }
        r6 = "window";	 Catch:{ Exception -> 0x0091 }
        r2.put(r3, r6);	 Catch:{ Exception -> 0x0091 }
        r3 = "frame";	 Catch:{ Exception -> 0x0091 }
        r0.put(r3, r2);	 Catch:{ Exception -> 0x0091 }
        r2 = new android.graphics.Rect;	 Catch:{ Exception -> 0x0091 }
        r2.<init>();	 Catch:{ Exception -> 0x0091 }
        r8 = r8.getGlobalVisibleRect(r2);	 Catch:{ Exception -> 0x0091 }
        if (r8 == 0) goto L_0x005f;	 Catch:{ Exception -> 0x0091 }
    L_0x005a:
        r8 = r7.m14117a(r2);	 Catch:{ Exception -> 0x0091 }
        goto L_0x008b;	 Catch:{ Exception -> 0x0091 }
    L_0x005f:
        r8 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0091 }
        r8.<init>();	 Catch:{ Exception -> 0x0091 }
        r2 = "width";	 Catch:{ Exception -> 0x0091 }
        r8.put(r2, r4);	 Catch:{ Exception -> 0x0091 }
        r2 = "height";	 Catch:{ Exception -> 0x0091 }
        r8.put(r2, r4);	 Catch:{ Exception -> 0x0091 }
        r2 = "x";	 Catch:{ Exception -> 0x0091 }
        r3 = r1[r4];	 Catch:{ Exception -> 0x0091 }
        r3 = r7.m14116a(r3);	 Catch:{ Exception -> 0x0091 }
        r8.put(r2, r3);	 Catch:{ Exception -> 0x0091 }
        r2 = "y";	 Catch:{ Exception -> 0x0091 }
        r1 = r1[r5];	 Catch:{ Exception -> 0x0091 }
        r1 = r7.m14116a(r1);	 Catch:{ Exception -> 0x0091 }
        r8.put(r2, r1);	 Catch:{ Exception -> 0x0091 }
        r1 = "relative_to";	 Catch:{ Exception -> 0x0091 }
        r2 = "window";	 Catch:{ Exception -> 0x0091 }
        r8.put(r1, r2);	 Catch:{ Exception -> 0x0091 }
    L_0x008b:
        r1 = "visible_bounds";	 Catch:{ Exception -> 0x0091 }
        r0.put(r1, r8);	 Catch:{ Exception -> 0x0091 }
        return r0;
    L_0x0091:
        r8 = "Unable to get native ad view bounding box";
        com.google.android.gms.internal.zzakb.m5371e(r8);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzow.e(android.view.View):org.json.JSONObject");
    }

    private static org.json.JSONObject m14125f(android.view.View r3) {
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
        r0 = new org.json.JSONObject;
        r0.<init>();
        if (r3 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ Exception -> 0x001a }
        r3 = com.google.android.gms.internal.zzahn.m5203d(r3);	 Catch:{ Exception -> 0x001a }
        r1 = "contained_in_scroll_view";	 Catch:{ Exception -> 0x001a }
        r2 = -1;	 Catch:{ Exception -> 0x001a }
        if (r3 == r2) goto L_0x0016;	 Catch:{ Exception -> 0x001a }
    L_0x0014:
        r3 = 1;	 Catch:{ Exception -> 0x001a }
        goto L_0x0017;	 Catch:{ Exception -> 0x001a }
    L_0x0016:
        r3 = 0;	 Catch:{ Exception -> 0x001a }
    L_0x0017:
        r0.put(r1, r3);	 Catch:{ Exception -> 0x001a }
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzow.f(android.view.View):org.json.JSONObject");
    }

    private final org.json.JSONObject m14126g(android.view.View r3) {
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
        r0 = new org.json.JSONObject;
        r0.<init>();
        if (r3 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = "can_show_on_lock_screen";	 Catch:{ JSONException -> 0x0023 }
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ JSONException -> 0x0023 }
        r3 = com.google.android.gms.internal.zzahn.m5200c(r3);	 Catch:{ JSONException -> 0x0023 }
        r0.put(r1, r3);	 Catch:{ JSONException -> 0x0023 }
        r3 = "is_keyguard_locked";	 Catch:{ JSONException -> 0x0023 }
        com.google.android.gms.ads.internal.zzbs.m4486e();	 Catch:{ JSONException -> 0x0023 }
        r1 = r2.f14575b;	 Catch:{ JSONException -> 0x0023 }
        r1 = com.google.android.gms.internal.zzahn.m5219k(r1);	 Catch:{ JSONException -> 0x0023 }
        r0.put(r3, r1);	 Catch:{ JSONException -> 0x0023 }
        return r0;
    L_0x0023:
        r3 = "Unable to get lock screen information";
        com.google.android.gms.internal.zzakb.m5371e(r3);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzow.g(android.view.View):org.json.JSONObject");
    }

    public final void mo2071a(MotionEvent motionEvent) {
        this.f14581h.m5820a(motionEvent);
    }

    public final void mo2073a(android.view.View r4, com.google.android.gms.internal.zzoq r5) {
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
        r5 = r3.m14141b(r4, r5);
        if (r5 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r5 = new android.widget.FrameLayout$LayoutParams;
        r0 = -1;
        r5.<init>(r0, r0);
        r0 = r4;
        r0 = (android.widget.FrameLayout) r0;
        r0.removeAllViews();
        r0 = r3.f14576c;
        r0 = r0 instanceof com.google.android.gms.internal.zzov;
        if (r0 != 0) goto L_0x001a;
    L_0x0019:
        return;
    L_0x001a:
        r0 = r3.f14576c;
        r0 = (com.google.android.gms.internal.zzov) r0;
        r1 = r0.mo2107b();
        if (r1 == 0) goto L_0x006b;
    L_0x0024:
        r1 = r0.mo2107b();
        r1 = r1.size();
        if (r1 <= 0) goto L_0x006b;
    L_0x002e:
        r0 = r0.mo2107b();
        r1 = 0;
        r0 = r0.get(r1);
        r1 = r0 instanceof android.os.IBinder;
        if (r1 == 0) goto L_0x0042;
    L_0x003b:
        r0 = (android.os.IBinder) r0;
        r0 = com.google.android.gms.internal.zzpr.m14158a(r0);
        goto L_0x0043;
    L_0x0042:
        r0 = 0;
    L_0x0043:
        if (r0 == 0) goto L_0x006b;
    L_0x0045:
        r0 = r0.mo2091a();	 Catch:{ RemoteException -> 0x0066 }
        if (r0 == 0) goto L_0x0065;	 Catch:{ RemoteException -> 0x0066 }
    L_0x004b:
        r0 = com.google.android.gms.dynamic.zzn.m17693a(r0);	 Catch:{ RemoteException -> 0x0066 }
        r0 = (android.graphics.drawable.Drawable) r0;	 Catch:{ RemoteException -> 0x0066 }
        r1 = new android.widget.ImageView;	 Catch:{ RemoteException -> 0x0066 }
        r2 = r3.f14575b;	 Catch:{ RemoteException -> 0x0066 }
        r1.<init>(r2);	 Catch:{ RemoteException -> 0x0066 }
        r1.setImageDrawable(r0);	 Catch:{ RemoteException -> 0x0066 }
        r0 = android.widget.ImageView.ScaleType.CENTER_INSIDE;	 Catch:{ RemoteException -> 0x0066 }
        r1.setScaleType(r0);	 Catch:{ RemoteException -> 0x0066 }
        r4 = (android.widget.FrameLayout) r4;	 Catch:{ RemoteException -> 0x0066 }
        r4.addView(r1, r5);	 Catch:{ RemoteException -> 0x0066 }
    L_0x0065:
        return;
    L_0x0066:
        r4 = "Could not get drawable from image";
        com.google.android.gms.internal.zzakb.m5371e(r4);
    L_0x006b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzow.a(android.view.View, com.google.android.gms.internal.zzoq):void");
    }

    public final void mo2074a(View view, String str, Bundle bundle, Map<String, WeakReference<View>> map, View view2) {
        JSONObject jSONObject;
        Throwable e;
        JSONObject a = m14118a((Map) map, view2);
        JSONObject e2 = m14124e(view2);
        JSONObject f = m14125f(view2);
        JSONObject g = m14126g(view2);
        JSONObject jSONObject2 = null;
        try {
            JSONObject a2 = zzbs.m4486e().m5226a(bundle);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("click_point", a2);
                jSONObject3.put("asset_id", str);
                jSONObject = jSONObject3;
            } catch (Exception e3) {
                e = e3;
                jSONObject2 = jSONObject3;
                zzakb.m5367b("Error occurred while grabbing click signals.", e);
                jSONObject = jSONObject2;
                m14119a(view, e2, a, f, g, str, jSONObject, null);
            }
        } catch (Exception e4) {
            e = e4;
            zzakb.m5367b("Error occurred while grabbing click signals.", e);
            jSONObject = jSONObject2;
            m14119a(view, e2, a, f, g, str, jSONObject, null);
        }
        m14119a(view, e2, a, f, g, str, jSONObject, null);
    }

    public void mo2075a(View view, Map<String, WeakReference<View>> map) {
        m14121a(m14124e(view), m14118a((Map) map, view), m14125f(view), m14126g(view), null);
    }

    public void mo2076a(View view, Map<String, WeakReference<View>> map, Bundle bundle, View view2) {
        zzbq.m4816b("performClick must be called on the main UI thread.");
        if (map != null) {
            synchronized (map) {
                for (Entry entry : map.entrySet()) {
                    if (view.equals((View) ((WeakReference) entry.getValue()).get())) {
                        mo2074a(view, (String) entry.getKey(), bundle, (Map) map, view2);
                        return;
                    }
                }
            }
        }
        if ("2".equals(this.f14576c.mo3540k())) {
            mo2074a(view, "2099", bundle, (Map) map, view2);
            return;
        }
        if ("1".equals(this.f14576c.mo3540k())) {
            mo2074a(view, "1099", bundle, (Map) map, view2);
        }
    }

    public void mo3544a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, OnTouchListener onTouchListener, OnClickListener onClickListener) {
        if (((Boolean) zzkb.m6350f().m6488a(zznh.bO)).booleanValue()) {
            view.setOnTouchListener(onTouchListener);
            view.setClickable(true);
            view.setOnClickListener(onClickListener);
            if (map != null) {
                synchronized (map) {
                    for (Entry value : map.entrySet()) {
                        View view2 = (View) ((WeakReference) value.getValue()).get();
                        if (view2 != null) {
                            view2.setOnTouchListener(onTouchListener);
                            view2.setClickable(true);
                            view2.setOnClickListener(onClickListener);
                        }
                    }
                }
            }
            if (map2 != null) {
                synchronized (map2) {
                    for (Entry value2 : map2.entrySet()) {
                        View view3 = (View) ((WeakReference) value2.getValue()).get();
                        if (view3 != null) {
                            view3.setOnTouchListener(onTouchListener);
                        }
                    }
                }
            }
        }
    }

    public final boolean mo2078a(Bundle bundle) {
        if (m14120a("impression_reporting")) {
            return m14121a(null, null, null, null, zzbs.m4486e().m5226a(bundle));
        }
        zzakb.m5368c("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
        return false;
    }

    public final void mo2079b(Bundle bundle) {
        if (bundle == null) {
            zzakb.m5366b("Click data is null. No click is reported.");
        } else if (m14120a("click_reporting")) {
            m14119a(null, null, null, null, null, bundle.getBundle("click_signal").getString("asset_id"), null, zzbs.m4486e().m5226a(bundle));
        } else {
            zzakb.m5368c("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        }
    }

    public final void mo2080b(View view) {
        this.f14585l = new WeakReference(view);
    }

    public void mo2081b(View view, Map<String, WeakReference<View>> map) {
        if (!((Boolean) zzkb.m6350f().m6488a(zznh.bN)).booleanValue()) {
            view.setOnTouchListener(null);
            view.setClickable(false);
            view.setOnClickListener(null);
            if (map != null) {
                synchronized (map) {
                    for (Entry value : map.entrySet()) {
                        View view2 = (View) ((WeakReference) value.getValue()).get();
                        if (view2 != null) {
                            view2.setOnTouchListener(null);
                            view2.setClickable(false);
                            view2.setOnClickListener(null);
                        }
                    }
                }
            }
        }
    }

    public boolean mo2082b() {
        return this.f14579f != null && this.f14579f.optBoolean("allow_pub_owned_ad_view", false);
    }

    public final boolean m14141b(View view, zzoq com_google_android_gms_internal_zzoq) {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 17);
        View o = this.f14576c.mo3543o();
        if (o == null) {
            return false;
        }
        ViewParent parent = o.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(o);
        }
        FrameLayout frameLayout = (FrameLayout) view;
        frameLayout.removeAllViews();
        frameLayout.addView(o, layoutParams);
        this.f14574a.mo4268a(com_google_android_gms_internal_zzoq);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo2084c(android.view.View r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5) {
        /*
        r3 = this;
        r0 = r3.f14578e;
        monitor-enter(r0);
        r1 = r3.f14577d;	 Catch:{ all -> 0x005e }
        if (r1 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        return;
    L_0x0009:
        r1 = m14122c(r4);	 Catch:{ all -> 0x005e }
        if (r1 == 0) goto L_0x0014;
    L_0x000f:
        r3.mo2075a(r4, r5);	 Catch:{ all -> 0x005e }
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        return;
    L_0x0014:
        r1 = com.google.android.gms.internal.zznh.bV;	 Catch:{ all -> 0x005e }
        r2 = com.google.android.gms.internal.zzkb.m6350f();	 Catch:{ all -> 0x005e }
        r1 = r2.m6488a(r1);	 Catch:{ all -> 0x005e }
        r1 = (java.lang.Boolean) r1;	 Catch:{ all -> 0x005e }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x005e }
        if (r1 == 0) goto L_0x005c;
    L_0x0026:
        if (r5 == 0) goto L_0x005c;
    L_0x0028:
        monitor-enter(r5);	 Catch:{ all -> 0x005e }
        r1 = r5.entrySet();	 Catch:{ all -> 0x0059 }
        r1 = r1.iterator();	 Catch:{ all -> 0x0059 }
    L_0x0031:
        r2 = r1.hasNext();	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x0057;
    L_0x0037:
        r2 = r1.next();	 Catch:{ all -> 0x0059 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ all -> 0x0059 }
        r2 = r2.getValue();	 Catch:{ all -> 0x0059 }
        r2 = (java.lang.ref.WeakReference) r2;	 Catch:{ all -> 0x0059 }
        r2 = r2.get();	 Catch:{ all -> 0x0059 }
        r2 = (android.view.View) r2;	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x0031;
    L_0x004b:
        r2 = m14122c(r2);	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x0031;
    L_0x0051:
        r3.mo2075a(r4, r5);	 Catch:{ all -> 0x0059 }
        monitor-exit(r5);	 Catch:{ all -> 0x0059 }
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        return;
    L_0x0057:
        monitor-exit(r5);	 Catch:{ all -> 0x0059 }
        goto L_0x005c;
    L_0x0059:
        r4 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0059 }
        throw r4;	 Catch:{ all -> 0x005e }
    L_0x005c:
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        return;
    L_0x005e:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x005e }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzow.c(android.view.View, java.util.Map):void");
    }

    public void mo2085f() {
        this.f14580g.mo3576a();
    }

    public void mo2086g() {
        this.f14574a.mo4262I();
    }

    public final View mo2087h() {
        return this.f14585l != null ? (View) this.f14585l.get() : null;
    }

    public final Context mo2088i() {
        return this.f14575b;
    }

    public final zzafe m14149j() {
        if (!zzbs.m4507z().m5097c(this.f14575b)) {
            return null;
        }
        if (this.f14584k == null) {
            this.f14584k = new zzafe(this.f14575b, this.f14574a.mo1985A());
        }
        return this.f14584k;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View mo2070a(android.view.View.OnClickListener r7, boolean r8) {
        /*
        r6 = this;
        r0 = r6.f14576c;
        r0 = r0.mo3542m();
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r7 = 0;
        return r7;
    L_0x000a:
        r1 = new android.widget.RelativeLayout$LayoutParams;
        r2 = -2;
        r1.<init>(r2, r2);
        if (r8 != 0) goto L_0x0036;
    L_0x0012:
        r8 = r0.f18187f;
        r2 = 9;
        r3 = 10;
        if (r8 == 0) goto L_0x0030;
    L_0x001a:
        r4 = 12;
        r5 = 11;
        switch(r8) {
            case 2: goto L_0x002c;
            case 3: goto L_0x0028;
            default: goto L_0x0021;
        };
    L_0x0021:
        r1.addRule(r3);
    L_0x0024:
        r1.addRule(r5);
        goto L_0x0036;
    L_0x0028:
        r1.addRule(r4);
        goto L_0x0033;
    L_0x002c:
        r1.addRule(r4);
        goto L_0x0024;
    L_0x0030:
        r1.addRule(r3);
    L_0x0033:
        r1.addRule(r2);
    L_0x0036:
        r8 = new com.google.android.gms.internal.zzoh;
        r2 = r6.f14575b;
        r8.<init>(r2, r0, r1);
        r8.setOnClickListener(r7);
        r7 = com.google.android.gms.internal.zznh.bQ;
        r0 = com.google.android.gms.internal.zzkb.m6350f();
        r7 = r0.m6488a(r7);
        r7 = (java.lang.CharSequence) r7;
        r8.setContentDescription(r7);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzow.a(android.view.View$OnClickListener, boolean):android.view.View");
    }

    public boolean mo2077a() {
        zzog m = this.f14576c.mo3542m();
        return m != null && m.f18188g;
    }

    private final void m14119a(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6) {
        zzbq.m4816b("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.f14579f);
            if (jSONObject2 != null) {
                jSONObject7.put("asset_view_signal", jSONObject2);
            }
            if (jSONObject != null) {
                jSONObject7.put("ad_view_signal", jSONObject);
            }
            if (jSONObject5 != null) {
                jSONObject7.put("click_signal", jSONObject5);
            }
            if (jSONObject3 != null) {
                jSONObject7.put("scroll_view_signal", jSONObject3);
            }
            if (jSONObject4 != null) {
                jSONObject7.put("lock_screen_signal", jSONObject4);
            }
            jSONObject = new JSONObject();
            jSONObject.put("asset_id", str);
            jSONObject.put("template", this.f14576c.mo3540k());
            zzbs.m4488g();
            jSONObject.put("is_privileged_process", zzaht.m5234e());
            jSONObject4 = null;
            jSONObject.put("has_custom_click_handler", this.f14574a.mo4271b(this.f14576c.mo3541l()) != null ? 1 : null);
            jSONObject2 = "has_custom_click_handler";
            if (this.f14574a.mo4271b(this.f14576c.mo3541l()) != null) {
                jSONObject4 = 1;
            }
            jSONObject7.put(jSONObject2, jSONObject4);
            try {
                jSONObject2 = this.f14579f.optJSONObject("tracking_urls_and_actions");
                if (jSONObject2 == null) {
                    jSONObject2 = new JSONObject();
                }
                jSONObject.put("click_signals", this.f14581h.f7187b.mo1518a(this.f14575b, jSONObject2.optString("click_string"), view));
            } catch (View view2) {
                zzakb.m5367b("Exception obtaining click signals", view2);
            }
            jSONObject7.put("click", jSONObject);
            if (jSONObject6 != null) {
                jSONObject7.put("provided_signals", jSONObject6);
            }
            jSONObject7.put("ads_id", this.f14583j);
            zzakj.m5376a(this.f14580g.mo3578b(jSONObject7), "NativeAdEngineImpl.performClick");
        } catch (View view22) {
            zzakb.m5367b("Unable to create click JSON.", view22);
        }
    }

    public final void mo2083c(Bundle bundle) {
        if (bundle == null) {
            zzakb.m5366b("Touch event data is null. No touch event is reported.");
        } else if (m14120a("touch_reporting")) {
            this.f14581h.f7187b.mo1520a((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
        } else {
            zzakb.m5368c("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        }
    }

    public final void mo2072a(View view) {
        if (((Boolean) zzkb.m6350f().m6488a(zznh.bt)).booleanValue() && this.f14581h != null) {
            zzcr com_google_android_gms_internal_zzcr = this.f14581h.f7187b;
            if (com_google_android_gms_internal_zzcr != null) {
                com_google_android_gms_internal_zzcr.mo1522a(view);
            }
        }
    }

    public zzanh mo3545e() throws zzanv {
        if (this.f14579f == null || this.f14579f.optJSONObject("overlay") == null) {
            return null;
        }
        zzbs.m4487f();
        Context context = this.f14575b;
        zzjn a = zzjn.m18776a();
        zzanh a2 = zzanr.m5464a(context, zzapa.m5486a(a), a.f18152a, false, false, this.f14581h, this.f14582i, null, null, null, zzis.m6322a());
        if (a2 != null) {
            if (a2 == null) {
                throw null;
            }
            ((View) a2).setVisibility(8);
            zzoy com_google_android_gms_internal_zzoy = new zzoy(a2);
            zzzb com_google_android_gms_internal_zzzb = this.f14580g;
            com_google_android_gms_internal_zzzb.mo2292a("/loadHtml", new zzoz(com_google_android_gms_internal_zzoy, com_google_android_gms_internal_zzzb));
            com_google_android_gms_internal_zzzb.mo2292a("/showOverlay", new zzpb(com_google_android_gms_internal_zzoy, com_google_android_gms_internal_zzzb));
            com_google_android_gms_internal_zzzb.mo2292a("/hideOverlay", new zzpc(com_google_android_gms_internal_zzoy, com_google_android_gms_internal_zzzb));
            zzanh com_google_android_gms_internal_zzanh = (zzanh) com_google_android_gms_internal_zzoy.f7954a.get();
            if (com_google_android_gms_internal_zzanh != null) {
                com_google_android_gms_internal_zzanh.mo4019w().m5446a("/sendMessageToSdk", new zzpd(com_google_android_gms_internal_zzoy, com_google_android_gms_internal_zzzb));
            }
        }
        return a2;
    }
}
