package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzba;
import com.google.android.gms.ads.internal.zzbs;
import com.instabug.chat.model.Attachment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import net.hockeyapp.android.UpdateFragment;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzzv
public final class zzym implements Callable<zzafo> {
    private static long f8154a = 10;
    private final Context f8155b;
    private final zzaiv f8156c;
    private final zzba f8157d;
    private final zzcv f8158e;
    private final zzzb f8159f;
    private final Object f8160g = new Object();
    private final zzafp f8161h;
    private final zznu f8162i;
    private boolean f8163j;
    private int f8164k;
    private List<String> f8165l;
    private JSONObject f8166m;
    private String f8167n;

    public zzym(Context context, zzba com_google_android_gms_ads_internal_zzba, zzaiv com_google_android_gms_internal_zzaiv, zzcv com_google_android_gms_internal_zzcv, zzafp com_google_android_gms_internal_zzafp, zznu com_google_android_gms_internal_zznu) {
        this.f8155b = context;
        this.f8157d = com_google_android_gms_ads_internal_zzba;
        this.f8156c = com_google_android_gms_internal_zzaiv;
        this.f8161h = com_google_android_gms_internal_zzafp;
        this.f8158e = com_google_android_gms_internal_zzcv;
        this.f8162i = com_google_android_gms_internal_zznu;
        this.f8159f = com_google_android_gms_ads_internal_zzba.m20862E();
        this.f8163j = false;
        this.f8164k = -2;
        this.f8165l = null;
        this.f8167n = null;
    }

    private final zzafo m6807a(zzou com_google_android_gms_internal_zzou) {
        int i;
        synchronized (this.f8160g) {
            try {
                int i2 = r1.f8164k;
                if (com_google_android_gms_internal_zzou == null && r1.f8164k == -2) {
                    i2 = 0;
                }
                i = i2;
            } catch (Throwable th) {
                while (true) {
                    Throwable th2 = th;
                }
            }
        }
        zzou com_google_android_gms_internal_zzou2 = i != -2 ? null : com_google_android_gms_internal_zzou;
        zzjj com_google_android_gms_internal_zzjj = r1.f8161h.f6314a.f17396c;
        List list = r1.f8161h.f6315b.f17443c;
        List list2 = r1.f8161h.f6315b.f17445e;
        List list3 = r1.f8165l;
        int i3 = r1.f8161h.f6315b.f17451k;
        long j = r1.f8161h.f6315b.f17450j;
        String str = r1.f8161h.f6314a.f17402i;
        zzjn com_google_android_gms_internal_zzjn = r1.f8161h.f6317d;
        long j2 = r1.f8161h.f6315b.f17446f;
        List list4 = list;
        long j3 = r1.f8161h.f6319f;
        long j4 = j2;
        long j5 = r1.f8161h.f6320g;
        String str2 = r1.f8161h.f6315b.f17454n;
        JSONObject jSONObject = r1.f8166m;
        boolean z = r1.f8161h.f6315b.f17424D;
        zzaaz com_google_android_gms_internal_zzaaz = r1.f8161h.f6315b.f17425E;
        List list5 = r1.f8161h.f6315b.f17428H;
        return new zzafo(com_google_android_gms_internal_zzjj, null, list4, i, list2, list3, i3, j, str, false, null, null, null, null, null, 0, com_google_android_gms_internal_zzjn, j4, j3, j5, str2, jSONObject, com_google_android_gms_internal_zzou2, null, null, null, z, com_google_android_gms_internal_zzaaz, null, list5, r1.f8167n, r1.f8161h.f6322i, r1.f8161h.f6315b.f17435O, r1.f8161h.f6323j);
    }

    static zzanh m6808a(zzakv<zzanh> com_google_android_gms_internal_zzakv_com_google_android_gms_internal_zzanh) {
        try {
            return (zzanh) com_google_android_gms_internal_zzakv_com_google_android_gms_internal_zzanh.get((long) ((Integer) zzkb.m6350f().m6488a(zznh.bP)).intValue(), TimeUnit.SECONDS);
        } catch (Throwable e) {
            zzakb.m5369c("InterruptedException occurred while waiting for video to load", e);
            Thread.currentThread().interrupt();
            return null;
        } catch (Throwable e2) {
            zzakb.m5369c("Exception occurred while waiting for video to load", e2);
            return null;
        }
    }

    private final void m6810a(int i) {
        synchronized (this.f8160g) {
            this.f8163j = true;
            this.f8164k = i;
        }
    }

    private static <V> zzakv<List<V>> m6812b(List<zzakv<V>> list) {
        zzakv com_google_android_gms_internal_zzalf = new zzalf();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (zzakv a : list) {
            a.mo1732a(new zzyr(atomicInteger, size, com_google_android_gms_internal_zzalf, list), zzahh.f6369a);
        }
        return com_google_android_gms_internal_zzalf;
    }

    private static java.lang.Integer m6813b(org.json.JSONObject r2, java.lang.String r3) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = r2.getJSONObject(r3);	 Catch:{ JSONException -> 0x001f }
        r3 = "r";	 Catch:{ JSONException -> 0x001f }
        r3 = r2.getInt(r3);	 Catch:{ JSONException -> 0x001f }
        r0 = "g";	 Catch:{ JSONException -> 0x001f }
        r0 = r2.getInt(r0);	 Catch:{ JSONException -> 0x001f }
        r1 = "b";	 Catch:{ JSONException -> 0x001f }
        r2 = r2.getInt(r1);	 Catch:{ JSONException -> 0x001f }
        r2 = android.graphics.Color.rgb(r3, r0, r2);	 Catch:{ JSONException -> 0x001f }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ JSONException -> 0x001f }
        return r2;
    L_0x001f:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzym.b(org.json.JSONObject, java.lang.String):java.lang.Integer");
    }

    private final boolean m6814b() {
        boolean z;
        synchronized (this.f8160g) {
            z = this.f8163j;
        }
        return z;
    }

    private static String[] m6815c(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        String[] strArr = new String[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            strArr[i] = optJSONArray.getString(i);
        }
        return strArr;
    }

    public final zzakv<zzog> m6816a(JSONObject jSONObject) throws JSONException {
        jSONObject = jSONObject.optJSONObject("attribution");
        if (jSONObject == null) {
            return zzakl.m5377a(null);
        }
        String optString = jSONObject.optString("text");
        int optInt = jSONObject.optInt("text_size", -1);
        Integer b = m6813b(jSONObject, "text_color");
        Integer b2 = m6813b(jSONObject, "bg_color");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        int i = (this.f8161h.f6314a.f17418y == null || this.f8161h.f6314a.f17418y.f18238a < 2) ? 1 : this.f8161h.f6314a.f17418y.f18242e;
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        List arrayList = new ArrayList();
        if (jSONObject.optJSONArray("images") != null) {
            arrayList = m6821b(jSONObject, "images", false, true);
        } else {
            arrayList.add(m6818a(jSONObject, Attachment.TYPE_IMAGE, false, false));
        }
        return zzakl.m5380a(m6812b(arrayList), new zzyp(optString, b2, b, optInt, optInt3, optInt2, i, optBoolean), zzahh.f6369a);
    }

    public final zzakv<zzanh> m6817a(JSONObject jSONObject, String str) throws JSONException {
        jSONObject = jSONObject.optJSONObject(str);
        if (jSONObject == null) {
            return zzakl.m5377a(null);
        }
        if (TextUtils.isEmpty(jSONObject.optString("vast_xml"))) {
            zzakb.m5371e("Required field 'vast_xml' is missing");
            return zzakl.m5377a(null);
        }
        zzyt com_google_android_gms_internal_zzyt = new zzyt(this.f8155b, this.f8158e, this.f8161h, this.f8162i, this.f8157d);
        zzakv com_google_android_gms_internal_zzalf = new zzalf();
        zzbs.m4486e();
        zzahn.m5173a(new zzyu(com_google_android_gms_internal_zzyt, jSONObject, com_google_android_gms_internal_zzalf));
        return com_google_android_gms_internal_zzalf;
    }

    public final zzakv<zzoi> m6818a(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        jSONObject = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return m6819a(jSONObject, z, z2);
    }

    public final void m6820a(int i, boolean z) {
        if (z) {
            m6810a(i);
        }
    }

    public final List<zzakv<zzoi>> m6821b(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        List<zzakv<zzoi>> arrayList = new ArrayList();
        if (optJSONArray != null) {
            if (optJSONArray.length() != 0) {
                int length = z2 ? optJSONArray.length() : 1;
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    arrayList.add(m6819a(jSONObject2, false, z));
                }
                return arrayList;
            }
        }
        m6820a(0, false);
        return arrayList;
    }

    public final /* synthetic */ Object call() throws Exception {
        return m6806a();
    }

    private final com.google.android.gms.internal.zzafo m6806a() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r13 = this;
        r0 = 0;
        r1 = 0;
        r2 = r13.f8157d;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r11 = r2.f19547l;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r13.m6814b();	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r2 != 0) goto L_0x0076;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x000c:
        r2 = new com.google.android.gms.internal.zzalf;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2.<init>();	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = new com.google.android.gms.internal.zzyl;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2.<init>();	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = new org.json.JSONObject;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r13.f8161h;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r3.f6315b;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r3.f17442b;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2.<init>(r3);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = new org.json.JSONObject;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = r13.f8161h;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = r4.f6315b;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = r4.f17442b;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3.<init>(r4);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = r3.length();	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r4 == 0) goto L_0x0048;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0032:
        r4 = "ads";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r3.optJSONArray(r4);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r3 == 0) goto L_0x003f;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x003a:
        r3 = r3.optJSONObject(r1);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        goto L_0x0040;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x003f:
        r3 = r0;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0040:
        if (r3 == 0) goto L_0x0048;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0042:
        r3 = r3.length();	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r3 != 0) goto L_0x004c;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0048:
        r3 = 3;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r13.m6810a(r3);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x004c:
        r3 = r13.f8159f;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r3.mo3575a(r2);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = f8154a;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r2.get(r3, r5);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = (org.json.JSONObject) r2;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = "success";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r2.optBoolean(r3, r1);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r3 == 0) goto L_0x0076;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0064:
        r3 = "json";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r2.getJSONObject(r3);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = "ads";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r2.optJSONArray(r3);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r2.getJSONObject(r1);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r8 = r2;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        goto L_0x0077;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0076:
        r8 = r0;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0077:
        r2 = r13.m6814b();	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r2 != 0) goto L_0x0120;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x007d:
        if (r8 != 0) goto L_0x0081;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x007f:
        goto L_0x0120;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0081:
        r2 = "template_id";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r8.getString(r2);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r13.f8161h;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r3.f6314a;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r3.f17418y;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r3 == 0) goto L_0x0098;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x008f:
        r3 = r13.f8161h;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r3.f6314a;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r3.f17418y;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r3.f18239b;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        goto L_0x0099;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0098:
        r3 = r1;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0099:
        r4 = r13.f8161h;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = r4.f6314a;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = r4.f17418y;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r4 == 0) goto L_0x00aa;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x00a1:
        r4 = r13.f8161h;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = r4.f6314a;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = r4.f17418y;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = r4.f18241d;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        goto L_0x00ab;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x00aa:
        r4 = r1;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x00ab:
        r5 = "2";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5 = r5.equals(r2);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r5 == 0) goto L_0x00bd;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x00b3:
        r2 = new com.google.android.gms.internal.zzzc;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5 = r13.f8161h;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5 = r5.f6323j;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2.<init>(r3, r4, r5);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        goto L_0x0121;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x00bd:
        r5 = "1";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5 = r5.equals(r2);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r5 == 0) goto L_0x00cf;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x00c5:
        r2 = new com.google.android.gms.internal.zzzd;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5 = r13.f8161h;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5 = r5.f6323j;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2.<init>(r3, r4, r5);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        goto L_0x0121;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x00cf:
        r4 = "3";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r4.equals(r2);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r2 == 0) goto L_0x011d;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x00d7:
        r2 = "custom_template_id";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r8.getString(r2);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = new com.google.android.gms.internal.zzalf;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4.<init>();	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5 = com.google.android.gms.internal.zzahn.f6379a;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r6 = new com.google.android.gms.internal.zzyn;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r6.<init>(r13, r4, r2);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5.post(r6);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5 = f8154a;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r4.get(r5, r2);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r2 == 0) goto L_0x00fc;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x00f6:
        r2 = new com.google.android.gms.internal.zzze;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2.<init>(r3);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        goto L_0x0121;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x00fc:
        r2 = "No handler for custom template: ";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = "custom_template_id";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r8.getString(r3);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = r3.length();	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r4 == 0) goto L_0x0113;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x010e:
        r2 = r2.concat(r3);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        goto L_0x0119;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0113:
        r3 = new java.lang.String;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3.<init>(r2);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r3;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0119:
        com.google.android.gms.internal.zzakb.m5368c(r2);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        goto L_0x0120;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x011d:
        r13.m6810a(r1);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0120:
        r2 = r0;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0121:
        r3 = r13.m6814b();	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r3 != 0) goto L_0x016f;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0127:
        if (r2 == 0) goto L_0x016f;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0129:
        if (r8 != 0) goto L_0x012c;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x012b:
        goto L_0x016f;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x012c:
        r3 = "tracking_urls_and_actions";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r8.getJSONObject(r3);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = "impression_tracking_urls";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = m6815c(r3, r4);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r4 != 0) goto L_0x013c;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x013a:
        r4 = r0;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        goto L_0x0140;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x013c:
        r4 = java.util.Arrays.asList(r4);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0140:
        r13.f8165l = r4;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = "active_view";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r3.optJSONObject(r4);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r13.f8166m = r3;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = "debug_signals";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r8.optString(r3);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r13.f8167n = r3;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2 = r2.mo2295a(r13, r8);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r12 = new com.google.android.gms.internal.zzow;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = r13.f8155b;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5 = r13.f8157d;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r6 = r13.f8159f;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r7 = r13.f8158e;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r13.f8161h;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r3.f6314a;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r10 = r3.f17404k;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r12;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r9 = r2;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r2.mo3539a(r12);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        goto L_0x0170;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x016f:
        r2 = r0;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0170:
        r3 = r2 instanceof com.google.android.gms.internal.zzon;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        if (r3 == 0) goto L_0x018a;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x0174:
        r3 = r2;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = (com.google.android.gms.internal.zzon) r3;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = new com.google.android.gms.internal.zzyl;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4.<init>();	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5 = new com.google.android.gms.internal.zzyo;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r5.<init>(r13, r3);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4.f8153a = r5;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3 = r13.f8159f;	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r4 = "/nativeAdCustomClick";	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        r3.mo2292a(r4, r5);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
    L_0x018a:
        r2 = r13.m6807a(r2);	 Catch:{ CancellationException -> 0x019d, CancellationException -> 0x019d, CancellationException -> 0x019d, JSONException -> 0x0197, TimeoutException -> 0x0193, Exception -> 0x018f }
        return r2;
    L_0x018f:
        r2 = move-exception;
        r3 = "Error occured while doing native ads initialization.";
        goto L_0x019a;
    L_0x0193:
        r2 = move-exception;
        r3 = "Timeout when loading native ad.";
        goto L_0x019a;
    L_0x0197:
        r2 = move-exception;
        r3 = "Malformed native JSON response.";
    L_0x019a:
        com.google.android.gms.internal.zzakb.m5369c(r3, r2);
    L_0x019d:
        r2 = r13.f8163j;
        if (r2 != 0) goto L_0x01a4;
    L_0x01a1:
        r13.m6810a(r1);
    L_0x01a4:
        r0 = r13.m6807a(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzym.a():com.google.android.gms.internal.zzafo");
    }

    final zzakv<zzoi> m6819a(JSONObject jSONObject, boolean z, boolean z2) throws JSONException {
        String string = z ? jSONObject.getString(UpdateFragment.FRAGMENT_URL) : jSONObject.optString(UpdateFragment.FRAGMENT_URL);
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        if (TextUtils.isEmpty(string) != null) {
            m6820a((int) null, z);
            return zzakl.m5377a(null);
        } else if (z2) {
            return zzakl.m5377a(new zzoi(null, Uri.parse(string), optDouble));
        } else {
            JSONObject com_google_android_gms_internal_zzyq = new zzyq(this, z, optDouble, optBoolean, string);
            zzakv com_google_android_gms_internal_zzalf = new zzalf();
            zzaiv.f6435a.m6692a(new zzajd(string, com_google_android_gms_internal_zzalf));
            return zzakl.m5381a(zzakl.m5380a(com_google_android_gms_internal_zzalf, new zzaiy(com_google_android_gms_internal_zzyq), zzala.f6512b), Throwable.class, new zzaix(com_google_android_gms_internal_zzyq), zzala.f6512b);
        }
    }

    static /* synthetic */ void m6811a(zzym com_google_android_gms_internal_zzym, zzqm com_google_android_gms_internal_zzqm, String str) {
        try {
            com_google_android_gms_internal_zzym = com_google_android_gms_internal_zzym.f8157d.mo4271b(com_google_android_gms_internal_zzqm.mo2149l());
            if (com_google_android_gms_internal_zzym != null) {
                com_google_android_gms_internal_zzym.mo2153a(com_google_android_gms_internal_zzqm, str);
            }
        } catch (zzym com_google_android_gms_internal_zzym2) {
            StringBuilder stringBuilder = new StringBuilder(40 + String.valueOf(str).length());
            stringBuilder.append("Failed to call onCustomClick for asset ");
            stringBuilder.append(str);
            stringBuilder.append(".");
            zzakb.m5369c(stringBuilder.toString(), com_google_android_gms_internal_zzym2);
        }
    }

    static /* synthetic */ List m6809a(List list) throws ExecutionException, InterruptedException {
        List arrayList = new ArrayList();
        for (zzakv com_google_android_gms_internal_zzakv : list) {
            Object obj = com_google_android_gms_internal_zzakv.get();
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
