package io.branch.indexing;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.AbsListView;
import android.widget.TextView;
import io.branch.referral.PrefHelper;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContentDiscoverer {
    private static ContentDiscoverer f24442h;
    public Handler f24443a = new Handler();
    public WeakReference<Activity> f24444b;
    public JSONObject f24445c;
    public final Map<String, WeakReference<ViewTreeObserver>> f24446d = new HashMap();
    public ArrayList<String> f24447e = new ArrayList();
    public Runnable f24448f = new C21001(this);
    public OnScrollChangedListener f24449g = new C21012(this);
    private String f24450i;
    private int f24451j;
    private int f24452k = 15;
    private final HashHelper f24453l = new HashHelper(this);
    private ContentDiscoveryManifest f24454m;
    private Runnable f24455n = new C21023(this);

    class C21001 implements Runnable {
        final /* synthetic */ ContentDiscoverer f24437a;

        C21001(ContentDiscoverer contentDiscoverer) {
            this.f24437a = contentDiscoverer;
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r9 = this;
            r0 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r0.f24451j = r0.f24451j + 1;	 Catch:{ Exception -> 0x01a7 }
            r0 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r0 = r0.f24454m;	 Catch:{ Exception -> 0x01a7 }
            r0 = r0.f24467f;	 Catch:{ Exception -> 0x01a7 }
            if (r0 == 0) goto L_0x01a6;	 Catch:{ Exception -> 0x01a7 }
        L_0x000f:
            r0 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r0 = r0.f24444b;	 Catch:{ Exception -> 0x01a7 }
            if (r0 == 0) goto L_0x01a6;	 Catch:{ Exception -> 0x01a7 }
        L_0x0017:
            r0 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r0 = r0.f24444b;	 Catch:{ Exception -> 0x01a7 }
            r0 = r0.get();	 Catch:{ Exception -> 0x01a7 }
            if (r0 == 0) goto L_0x01a6;	 Catch:{ Exception -> 0x01a7 }
        L_0x0023:
            r0 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r0 = r0.f24444b;	 Catch:{ Exception -> 0x01a7 }
            r0 = r0.get();	 Catch:{ Exception -> 0x01a7 }
            r0 = (android.app.Activity) r0;	 Catch:{ Exception -> 0x01a7 }
            r1 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x01a7 }
            r2.<init>();	 Catch:{ Exception -> 0x01a7 }
            r1.f24445c = r2;	 Catch:{ Exception -> 0x01a7 }
            r1 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r1 = r1.f24445c;	 Catch:{ Exception -> 0x01a7 }
            r2 = "ts";	 Catch:{ Exception -> 0x01a7 }
            r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01a7 }
            r1.put(r2, r3);	 Catch:{ Exception -> 0x01a7 }
            r1 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r1 = r1.f24450i;	 Catch:{ Exception -> 0x01a7 }
            r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x01a7 }
            if (r1 != 0) goto L_0x0065;	 Catch:{ Exception -> 0x01a7 }
        L_0x0054:
            r1 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r1 = r1.f24445c;	 Catch:{ Exception -> 0x01a7 }
            r2 = "rl";	 Catch:{ Exception -> 0x01a7 }
            r3 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r3 = r3.f24450i;	 Catch:{ Exception -> 0x01a7 }
            r1.put(r2, r3);	 Catch:{ Exception -> 0x01a7 }
        L_0x0065:
            r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01a7 }
            r2 = "/";	 Catch:{ Exception -> 0x01a7 }
            r1.<init>(r2);	 Catch:{ Exception -> 0x01a7 }
            r2 = r0.getClass();	 Catch:{ Exception -> 0x01a7 }
            r2 = r2.getSimpleName();	 Catch:{ Exception -> 0x01a7 }
            r1.append(r2);	 Catch:{ Exception -> 0x01a7 }
            r7 = r1.toString();	 Catch:{ Exception -> 0x01a7 }
            r1 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r1 = r1.f24445c;	 Catch:{ Exception -> 0x01a7 }
            r2 = "v";	 Catch:{ Exception -> 0x01a7 }
            r1.put(r2, r7);	 Catch:{ Exception -> 0x01a7 }
            r1 = 16908290; // 0x1020002 float:2.3877235E-38 double:8.353805E-317;	 Catch:{ Exception -> 0x01a7 }
            r1 = r0.findViewById(r1);	 Catch:{ Exception -> 0x01a7 }
            r1 = (android.view.ViewGroup) r1;	 Catch:{ Exception -> 0x01a7 }
            if (r1 == 0) goto L_0x01a6;	 Catch:{ Exception -> 0x01a7 }
        L_0x0092:
            r2 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r2 = r2.f24454m;	 Catch:{ Exception -> 0x01a7 }
            r2 = r2.m26090a(r0);	 Catch:{ Exception -> 0x01a7 }
            r3 = 0;	 Catch:{ Exception -> 0x01a7 }
            r4 = 0;	 Catch:{ Exception -> 0x01a7 }
            if (r2 == 0) goto L_0x00b6;	 Catch:{ Exception -> 0x01a7 }
        L_0x00a0:
            r3 = r2.f24457b;	 Catch:{ Exception -> 0x01a7 }
            r4 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r4 = r4.f24445c;	 Catch:{ Exception -> 0x01a7 }
            r5 = "h";	 Catch:{ Exception -> 0x01a7 }
            r6 = r3 ^ 1;	 Catch:{ Exception -> 0x01a7 }
            r4.put(r5, r6);	 Catch:{ Exception -> 0x01a7 }
            r2 = r2.m26088a();	 Catch:{ Exception -> 0x01a7 }
            r8 = r2;	 Catch:{ Exception -> 0x01a7 }
            r6 = r3;	 Catch:{ Exception -> 0x01a7 }
            goto L_0x00b8;	 Catch:{ Exception -> 0x01a7 }
        L_0x00b6:
            r6 = r3;	 Catch:{ Exception -> 0x01a7 }
            r8 = r4;	 Catch:{ Exception -> 0x01a7 }
        L_0x00b8:
            if (r8 == 0) goto L_0x00e8;	 Catch:{ Exception -> 0x01a7 }
        L_0x00ba:
            r2 = r8.length();	 Catch:{ Exception -> 0x01a7 }
            if (r2 <= 0) goto L_0x00e8;	 Catch:{ Exception -> 0x01a7 }
        L_0x00c0:
            r4 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01a7 }
            r4.<init>();	 Catch:{ Exception -> 0x01a7 }
            r1 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r1 = r1.f24445c;	 Catch:{ Exception -> 0x01a7 }
            r2 = "ck";	 Catch:{ Exception -> 0x01a7 }
            r1.put(r2, r4);	 Catch:{ Exception -> 0x01a7 }
            r3 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01a7 }
            r3.<init>();	 Catch:{ Exception -> 0x01a7 }
            r1 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r1 = r1.f24445c;	 Catch:{ Exception -> 0x01a7 }
            r2 = "cd";	 Catch:{ Exception -> 0x01a7 }
            r1.put(r2, r3);	 Catch:{ Exception -> 0x01a7 }
            r1 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r2 = r8;	 Catch:{ Exception -> 0x01a7 }
            r5 = r0;	 Catch:{ Exception -> 0x01a7 }
            io.branch.indexing.ContentDiscoverer.m26075a(r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x01a7 }
            goto L_0x010d;	 Catch:{ Exception -> 0x01a7 }
        L_0x00e8:
            r2 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r2 = r2.f24447e;	 Catch:{ Exception -> 0x01a7 }
            r2 = r2.contains(r7);	 Catch:{ Exception -> 0x01a7 }
            if (r2 != 0) goto L_0x010d;	 Catch:{ Exception -> 0x01a7 }
        L_0x00f4:
            r2 = new org.json.JSONArray;	 Catch:{ Exception -> 0x01a7 }
            r2.<init>();	 Catch:{ Exception -> 0x01a7 }
            r3 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r3 = r3.f24445c;	 Catch:{ Exception -> 0x01a7 }
            r4 = "ck";	 Catch:{ Exception -> 0x01a7 }
            r3.put(r4, r2);	 Catch:{ Exception -> 0x01a7 }
            r3 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r4 = r0.getResources();	 Catch:{ Exception -> 0x01a7 }
            r3.m26073a(r1, r2, r4);	 Catch:{ Exception -> 0x01a7 }
        L_0x010d:
            r1 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r1 = r1.f24447e;	 Catch:{ Exception -> 0x01a7 }
            r1.add(r7);	 Catch:{ Exception -> 0x01a7 }
            io.branch.referral.PrefHelper.m26151a(r0);	 Catch:{ Exception -> 0x01a7 }
            r1 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r1 = r1.f24445c;	 Catch:{ Exception -> 0x01a7 }
            r2 = "bnc_session_id";	 Catch:{ Exception -> 0x01a7 }
            r2 = io.branch.referral.PrefHelper.m26170d(r2);	 Catch:{ Exception -> 0x01a7 }
            r3 = "bnc_no_value";	 Catch:{ Exception -> 0x01a7 }
            r3 = r2.equals(r3);	 Catch:{ Exception -> 0x01a7 }
            if (r3 != 0) goto L_0x015f;	 Catch:{ Exception -> 0x01a7 }
        L_0x012d:
            r3 = io.branch.referral.PrefHelper.f24644b;	 Catch:{ Exception -> 0x01a7 }
            if (r3 != 0) goto L_0x0137;	 Catch:{ Exception -> 0x01a7 }
        L_0x0131:
            r3 = io.branch.referral.PrefHelper.m26177h();	 Catch:{ Exception -> 0x01a7 }
            io.branch.referral.PrefHelper.f24644b = r3;	 Catch:{ Exception -> 0x01a7 }
        L_0x0137:
            r3 = io.branch.referral.PrefHelper.f24644b;	 Catch:{ JSONException -> 0x015f }
            r3 = r3.has(r2);	 Catch:{ JSONException -> 0x015f }
            if (r3 == 0) goto L_0x0146;	 Catch:{ JSONException -> 0x015f }
        L_0x013f:
            r3 = io.branch.referral.PrefHelper.f24644b;	 Catch:{ JSONException -> 0x015f }
            r2 = r3.getJSONArray(r2);	 Catch:{ JSONException -> 0x015f }
            goto L_0x0151;	 Catch:{ JSONException -> 0x015f }
        L_0x0146:
            r3 = new org.json.JSONArray;	 Catch:{ JSONException -> 0x015f }
            r3.<init>();	 Catch:{ JSONException -> 0x015f }
            r4 = io.branch.referral.PrefHelper.f24644b;	 Catch:{ JSONException -> 0x015f }
            r4.put(r2, r3);	 Catch:{ JSONException -> 0x015f }
            r2 = r3;	 Catch:{ JSONException -> 0x015f }
        L_0x0151:
            r2.put(r1);	 Catch:{ JSONException -> 0x015f }
            r1 = "bnc_branch_analytical_data";	 Catch:{ JSONException -> 0x015f }
            r2 = io.branch.referral.PrefHelper.f24644b;	 Catch:{ JSONException -> 0x015f }
            r2 = r2.toString();	 Catch:{ JSONException -> 0x015f }
            io.branch.referral.PrefHelper.m26156a(r1, r2);	 Catch:{ JSONException -> 0x015f }
        L_0x015f:
            r1 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r1 = r1.f24454m;	 Catch:{ Exception -> 0x01a7 }
            r1 = r1.m26090a(r0);	 Catch:{ Exception -> 0x01a7 }
            r1 = r1.f24458c;	 Catch:{ Exception -> 0x01a7 }
            r2 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r3 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r3 = r3.f24454m;	 Catch:{ Exception -> 0x01a7 }
            r0 = r3.m26090a(r0);	 Catch:{ Exception -> 0x01a7 }
            r0 = r0.f24459d;	 Catch:{ Exception -> 0x01a7 }
            r2.f24452k = r0;	 Catch:{ Exception -> 0x01a7 }
            r0 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r0 = r0.f24451j;	 Catch:{ Exception -> 0x01a7 }
            r2 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r2 = r2.f24452k;	 Catch:{ Exception -> 0x01a7 }
            if (r0 >= r2) goto L_0x01a6;	 Catch:{ Exception -> 0x01a7 }
        L_0x018a:
            r0 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ Exception -> 0x01a7 }
            if (r1 < r0) goto L_0x01a6;	 Catch:{ Exception -> 0x01a7 }
        L_0x018e:
            if (r8 == 0) goto L_0x01a6;	 Catch:{ Exception -> 0x01a7 }
        L_0x0190:
            r0 = r8.length();	 Catch:{ Exception -> 0x01a7 }
            if (r0 <= 0) goto L_0x01a6;	 Catch:{ Exception -> 0x01a7 }
        L_0x0196:
            r0 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r0 = r0.f24443a;	 Catch:{ Exception -> 0x01a7 }
            r2 = r9.f24437a;	 Catch:{ Exception -> 0x01a7 }
            r2 = r2.f24448f;	 Catch:{ Exception -> 0x01a7 }
            r3 = (long) r1;	 Catch:{ Exception -> 0x01a7 }
            r0.postDelayed(r2, r3);	 Catch:{ Exception -> 0x01a7 }
        L_0x01a6:
            return;
        L_0x01a7:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.indexing.ContentDiscoverer.1.run():void");
        }
    }

    class C21012 implements OnScrollChangedListener {
        final /* synthetic */ ContentDiscoverer f24438a;

        C21012(ContentDiscoverer contentDiscoverer) {
            this.f24438a = contentDiscoverer;
        }

        public void onScrollChanged() {
            this.f24438a.f24443a.removeCallbacks(this.f24438a.f24455n);
            if (this.f24438a.f24452k > this.f24438a.f24451j) {
                this.f24438a.f24443a.postDelayed(this.f24438a.f24455n, 1500);
            }
        }
    }

    class C21023 implements Runnable {
        final /* synthetic */ ContentDiscoverer f24439a;

        C21023(ContentDiscoverer contentDiscoverer) {
            this.f24439a = contentDiscoverer;
        }

        public void run() {
            this.f24439a.f24448f.run();
        }
    }

    private class HashHelper {
        MessageDigest f24440a;
        final /* synthetic */ ContentDiscoverer f24441b;

        HashHelper(io.branch.indexing.ContentDiscoverer r1) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            r0.f24441b = r1;
            r0.<init>();
            r1 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x000e }
            r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x000e }
            r0.f24440a = r1;	 Catch:{ NoSuchAlgorithmException -> 0x000e }
            return;
        L_0x000e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: io.branch.indexing.ContentDiscoverer.HashHelper.<init>(io.branch.indexing.ContentDiscoverer):void");
        }
    }

    public static ContentDiscoverer m26068a() {
        if (f24442h == null) {
            f24442h = new ContentDiscoverer();
        }
        return f24442h;
    }

    private ContentDiscoverer() {
    }

    public final void m26087a(Activity activity, String str) {
        this.f24454m = ContentDiscoveryManifest.m26089a((Context) activity);
        this.f24450i = str;
        str = this.f24454m.m26090a(activity);
        if (str != null) {
            str = str.m26088a();
            str = (str == null || str.length() != null) ? null : true;
            if (str == null) {
                m26072a(activity);
            }
        } else if (TextUtils.isEmpty(this.f24450i) == null) {
            m26072a(activity);
        }
    }

    private void m26072a(Activity activity) {
        this.f24451j = 0;
        if (this.f24447e.size() < this.f24454m.f24465d) {
            this.f24443a.removeCallbacks(this.f24448f);
            this.f24444b = new WeakReference(activity);
            this.f24443a.postDelayed(this.f24448f, 1000);
        }
    }

    private void m26073a(ViewGroup viewGroup, JSONArray jSONArray, Resources resources) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                if (!(childAt instanceof AbsListView)) {
                    if (!childAt.getClass().getSimpleName().equals("RecyclerView")) {
                        if (childAt instanceof ViewGroup) {
                            m26073a((ViewGroup) childAt, jSONArray, resources);
                        } else if (childAt instanceof TextView) {
                            jSONArray.put(m26069a(childAt, resources));
                        }
                    }
                }
                childAt = (ViewGroup) childAt;
                JSONObject jSONObject = new JSONObject();
                if (childAt != null && childAt.getChildCount() >= 0) {
                    int i2 = 1;
                    if (childAt.getChildCount() <= 1) {
                        i2 = 0;
                    }
                    View childAt2 = childAt.getChildAt(i2);
                    if (childAt2 != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        try {
                            jSONObject.put(m26069a(childAt, resources), jSONArray2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (childAt2 instanceof ViewGroup) {
                            m26073a((ViewGroup) childAt2, jSONArray2, resources);
                        } else if (childAt2 instanceof TextView) {
                            jSONArray2.put(m26069a(childAt2, resources));
                        }
                        if (jSONObject.length() > 0) {
                            StringBuilder stringBuilder = new StringBuilder("$");
                            stringBuilder.append(jSONObject);
                            jSONArray.put(stringBuilder.toString());
                        }
                    }
                }
            }
        }
    }

    private static java.lang.String m26069a(android.view.View r1, android.content.res.Resources r2) {
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
        r0 = r1.getId();
        r0 = java.lang.String.valueOf(r0);
        r1 = r1.getId();	 Catch:{ Exception -> 0x0011 }
        r1 = r2.getResourceEntryName(r1);	 Catch:{ Exception -> 0x0011 }
        goto L_0x0012;
    L_0x0011:
        r1 = r0;
    L_0x0012:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.indexing.ContentDiscoverer.a(android.view.View, android.content.res.Resources):java.lang.String");
    }

    private String m26070a(View view, boolean z) {
        TextView textView = (TextView) view;
        if (textView.getText() == null) {
            return null;
        }
        view = textView.getText().toString().substring(0, Math.min(textView.getText().toString().length(), this.f24454m.f24464c));
        if (z) {
            return view;
        }
        z = this.f24453l;
        String str = "";
        if (z.f24440a == null) {
            return str;
        }
        z.f24440a.reset();
        z.f24440a.update(view.getBytes());
        return new String(z.f24440a.digest());
    }

    public final JSONObject m26086a(Context context) {
        JSONObject jSONObject;
        PrefHelper.m26151a(context);
        JSONObject h = PrefHelper.m26177h();
        if (h.length() <= 0 || h.toString().length() >= this.f24454m.f24466e) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("mv", ContentDiscoveryManifest.m26089a(context).m26091a()).put("e", h);
                if (context != null) {
                    jSONObject.put("p", context.getPackageName());
                    jSONObject.put("p", context.getPackageName());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        PrefHelper.m26151a(context);
        PrefHelper.f24644b = null;
        PrefHelper.m26156a("bnc_branch_analytical_data", "");
        return jSONObject;
    }

    static /* synthetic */ void m26075a(io.branch.indexing.ContentDiscoverer r18, org.json.JSONArray r19, org.json.JSONArray r20, org.json.JSONArray r21, android.app.Activity r22, boolean r23) {
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
        r1 = r18;
        r2 = r19;
        r3 = r20;
        r4 = r21;
        r5 = r22;
        r6 = r23;
        r8 = 0;
    L_0x000d:
        r9 = r19.length();	 Catch:{ JSONException -> 0x017e }
        if (r8 >= r9) goto L_0x017d;	 Catch:{ JSONException -> 0x017e }
    L_0x0013:
        r9 = r2.getString(r8);	 Catch:{ JSONException -> 0x017e }
        r10 = "$";	 Catch:{ JSONException -> 0x017e }
        r10 = r9.startsWith(r10);	 Catch:{ JSONException -> 0x017e }
        if (r10 == 0) goto L_0x0144;	 Catch:{ JSONException -> 0x017e }
    L_0x001f:
        r10 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x017e }
        r10.<init>();	 Catch:{ JSONException -> 0x017e }
        r4.put(r9);	 Catch:{ JSONException -> 0x017e }
        r3.put(r10);	 Catch:{ JSONException -> 0x017e }
        r11 = "$";	 Catch:{ JSONException -> 0x017e }
        r12 = "";	 Catch:{ JSONException -> 0x017e }
        r9 = r9.replace(r11, r12);	 Catch:{ JSONException -> 0x017e }
        r11 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x013a }
        r11.<init>(r9);	 Catch:{ JSONException -> 0x013a }
        r12 = r11.length();	 Catch:{ JSONException -> 0x013a }
        if (r12 <= 0) goto L_0x013f;	 Catch:{ JSONException -> 0x013a }
    L_0x003d:
        r12 = r11.keys();	 Catch:{ JSONException -> 0x013a }
        r12 = r12.next();	 Catch:{ JSONException -> 0x013a }
        r12 = (java.lang.String) r12;	 Catch:{ JSONException -> 0x013a }
        r13 = r22.getResources();	 Catch:{ JSONException -> 0x013a }
        r14 = "id";	 Catch:{ JSONException -> 0x013a }
        r15 = r22.getPackageName();	 Catch:{ JSONException -> 0x013a }
        r13 = r13.getIdentifier(r12, r14, r15);	 Catch:{ JSONException -> 0x013a }
        r14 = r22.getCurrentFocus();	 Catch:{ JSONException -> 0x013a }
        if (r14 == 0) goto L_0x0064;	 Catch:{ JSONException -> 0x013a }
    L_0x005b:
        r14 = r22.getCurrentFocus();	 Catch:{ JSONException -> 0x013a }
        r14 = r14.findViewById(r13);	 Catch:{ JSONException -> 0x013a }
        goto L_0x0065;	 Catch:{ JSONException -> 0x013a }
    L_0x0064:
        r14 = 0;	 Catch:{ JSONException -> 0x013a }
    L_0x0065:
        if (r14 != 0) goto L_0x006b;	 Catch:{ JSONException -> 0x013a }
    L_0x0067:
        r14 = r5.findViewById(r13);	 Catch:{ JSONException -> 0x013a }
    L_0x006b:
        if (r14 == 0) goto L_0x013f;	 Catch:{ JSONException -> 0x013a }
    L_0x006d:
        r13 = r14 instanceof android.view.ViewGroup;	 Catch:{ JSONException -> 0x013a }
        if (r13 == 0) goto L_0x013f;	 Catch:{ JSONException -> 0x013a }
    L_0x0071:
        r14 = (android.view.ViewGroup) r14;	 Catch:{ JSONException -> 0x013a }
        r12 = r11.getJSONArray(r12);	 Catch:{ JSONException -> 0x013a }
        r13 = r12.length();	 Catch:{ JSONException -> 0x013a }
        r13 = new int[r13];	 Catch:{ JSONException -> 0x013a }
        r15 = 0;	 Catch:{ JSONException -> 0x013a }
    L_0x007e:
        r7 = r12.length();	 Catch:{ JSONException -> 0x013a }
        if (r15 >= r7) goto L_0x00a1;	 Catch:{ JSONException -> 0x013a }
    L_0x0084:
        r7 = r22.getResources();	 Catch:{ JSONException -> 0x013a }
        r4 = r12.getString(r15);	 Catch:{ JSONException -> 0x013a }
        r3 = "id";	 Catch:{ JSONException -> 0x013a }
        r2 = r22.getPackageName();	 Catch:{ JSONException -> 0x013a }
        r2 = r7.getIdentifier(r4, r3, r2);	 Catch:{ JSONException -> 0x013a }
        r13[r15] = r2;	 Catch:{ JSONException -> 0x013a }
        r15 = r15 + 1;	 Catch:{ JSONException -> 0x013a }
        r2 = r19;	 Catch:{ JSONException -> 0x013a }
        r3 = r20;	 Catch:{ JSONException -> 0x013a }
        r4 = r21;	 Catch:{ JSONException -> 0x013a }
        goto L_0x007e;	 Catch:{ JSONException -> 0x013a }
    L_0x00a1:
        r2 = r14 instanceof android.widget.AbsListView;	 Catch:{ JSONException -> 0x013a }
        if (r2 == 0) goto L_0x00ad;	 Catch:{ JSONException -> 0x013a }
    L_0x00a5:
        r2 = r14;	 Catch:{ JSONException -> 0x013a }
        r2 = (android.widget.AbsListView) r2;	 Catch:{ JSONException -> 0x013a }
        r7 = r2.getFirstVisiblePosition();	 Catch:{ JSONException -> 0x013a }
        goto L_0x00ae;	 Catch:{ JSONException -> 0x013a }
    L_0x00ad:
        r7 = 0;	 Catch:{ JSONException -> 0x013a }
    L_0x00ae:
        r2 = 0;	 Catch:{ JSONException -> 0x013a }
    L_0x00af:
        r3 = r14.getChildCount();	 Catch:{ JSONException -> 0x013a }
        if (r2 >= r3) goto L_0x0105;	 Catch:{ JSONException -> 0x013a }
    L_0x00b5:
        r3 = r14.getChildAt(r2);	 Catch:{ JSONException -> 0x013a }
        if (r3 == 0) goto L_0x00fe;	 Catch:{ JSONException -> 0x013a }
    L_0x00bb:
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x013a }
        r3.<init>();	 Catch:{ JSONException -> 0x013a }
        r4 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x013a }
        r4.<init>();	 Catch:{ JSONException -> 0x013a }
        r15 = r2 + r7;	 Catch:{ JSONException -> 0x013a }
        r4.append(r15);	 Catch:{ JSONException -> 0x013a }
        r4 = r4.toString();	 Catch:{ JSONException -> 0x013a }
        r10.put(r4, r3);	 Catch:{ JSONException -> 0x013a }
        r4 = 0;	 Catch:{ JSONException -> 0x013a }
    L_0x00d2:
        r15 = r13.length;	 Catch:{ JSONException -> 0x013a }
        if (r4 >= r15) goto L_0x00fe;	 Catch:{ JSONException -> 0x013a }
    L_0x00d5:
        r15 = r14.getChildAt(r2);	 Catch:{ JSONException -> 0x013a }
        if (r15 == 0) goto L_0x00f7;	 Catch:{ JSONException -> 0x013a }
    L_0x00db:
        r15 = r14.getChildAt(r2);	 Catch:{ JSONException -> 0x013a }
        r16 = r7;	 Catch:{ JSONException -> 0x013a }
        r7 = r13[r4];	 Catch:{ JSONException -> 0x013a }
        r7 = r15.findViewById(r7);	 Catch:{ JSONException -> 0x013a }
        r15 = r7 instanceof android.widget.TextView;	 Catch:{ JSONException -> 0x013a }
        if (r15 == 0) goto L_0x00f9;	 Catch:{ JSONException -> 0x013a }
    L_0x00eb:
        r15 = r12.getString(r4);	 Catch:{ JSONException -> 0x013a }
        r7 = r1.m26070a(r7, r6);	 Catch:{ JSONException -> 0x013a }
        r3.put(r15, r7);	 Catch:{ JSONException -> 0x013a }
        goto L_0x00f9;	 Catch:{ JSONException -> 0x013a }
    L_0x00f7:
        r16 = r7;	 Catch:{ JSONException -> 0x013a }
    L_0x00f9:
        r4 = r4 + 1;	 Catch:{ JSONException -> 0x013a }
        r7 = r16;	 Catch:{ JSONException -> 0x013a }
        goto L_0x00d2;	 Catch:{ JSONException -> 0x013a }
    L_0x00fe:
        r16 = r7;	 Catch:{ JSONException -> 0x013a }
        r2 = r2 + 1;	 Catch:{ JSONException -> 0x013a }
        r7 = r16;	 Catch:{ JSONException -> 0x013a }
        goto L_0x00af;	 Catch:{ JSONException -> 0x013a }
    L_0x0105:
        r2 = "bnc_esw";	 Catch:{ JSONException -> 0x013a }
        r2 = r11.has(r2);	 Catch:{ JSONException -> 0x013a }
        if (r2 == 0) goto L_0x0117;	 Catch:{ JSONException -> 0x013a }
    L_0x010d:
        r2 = "bnc_esw";	 Catch:{ JSONException -> 0x013a }
        r2 = r11.getBoolean(r2);	 Catch:{ JSONException -> 0x013a }
        if (r2 == 0) goto L_0x0117;	 Catch:{ JSONException -> 0x013a }
    L_0x0115:
        r7 = 1;	 Catch:{ JSONException -> 0x013a }
        goto L_0x0118;	 Catch:{ JSONException -> 0x013a }
    L_0x0117:
        r7 = 0;	 Catch:{ JSONException -> 0x013a }
    L_0x0118:
        if (r7 == 0) goto L_0x013f;	 Catch:{ JSONException -> 0x013a }
    L_0x011a:
        r2 = r1.f24446d;	 Catch:{ JSONException -> 0x013a }
        r2 = r2.containsKey(r9);	 Catch:{ JSONException -> 0x013a }
        if (r2 != 0) goto L_0x013f;	 Catch:{ JSONException -> 0x013a }
    L_0x0122:
        r2 = r14.getViewTreeObserver();	 Catch:{ JSONException -> 0x013a }
        r3 = r1.f24449g;	 Catch:{ JSONException -> 0x013a }
        r2.addOnScrollChangedListener(r3);	 Catch:{ JSONException -> 0x013a }
        r2 = r1.f24446d;	 Catch:{ JSONException -> 0x013a }
        r3 = new java.lang.ref.WeakReference;	 Catch:{ JSONException -> 0x013a }
        r4 = r14.getViewTreeObserver();	 Catch:{ JSONException -> 0x013a }
        r3.<init>(r4);	 Catch:{ JSONException -> 0x013a }
        r2.put(r9, r3);	 Catch:{ JSONException -> 0x013a }
        goto L_0x013f;
    L_0x013a:
        r0 = move-exception;
        r2 = r0;
        r2.printStackTrace();	 Catch:{ JSONException -> 0x017e }
    L_0x013f:
        r2 = r21;	 Catch:{ JSONException -> 0x017e }
        r3 = r19;	 Catch:{ JSONException -> 0x017e }
        goto L_0x0171;	 Catch:{ JSONException -> 0x017e }
    L_0x0144:
        r2 = r22.getResources();	 Catch:{ JSONException -> 0x017e }
        r3 = r19;	 Catch:{ JSONException -> 0x017e }
        r4 = r3.getString(r8);	 Catch:{ JSONException -> 0x017e }
        r7 = "id";	 Catch:{ JSONException -> 0x017e }
        r10 = r22.getPackageName();	 Catch:{ JSONException -> 0x017e }
        r2 = r2.getIdentifier(r4, r7, r10);	 Catch:{ JSONException -> 0x017e }
        r2 = r5.findViewById(r2);	 Catch:{ JSONException -> 0x017e }
        r4 = r2 instanceof android.widget.TextView;	 Catch:{ JSONException -> 0x017e }
        if (r4 == 0) goto L_0x016f;	 Catch:{ JSONException -> 0x017e }
    L_0x0160:
        r2 = r1.m26070a(r2, r6);	 Catch:{ JSONException -> 0x017e }
        r4 = r20;	 Catch:{ JSONException -> 0x017e }
        r4.put(r2);	 Catch:{ JSONException -> 0x017e }
        r2 = r21;	 Catch:{ JSONException -> 0x017e }
        r2.put(r9);	 Catch:{ JSONException -> 0x017e }
        goto L_0x0173;
    L_0x016f:
        r2 = r21;
    L_0x0171:
        r4 = r20;
    L_0x0173:
        r8 = r8 + 1;
        r17 = r4;
        r4 = r2;
        r2 = r3;
        r3 = r17;
        goto L_0x000d;
    L_0x017d:
        return;
    L_0x017e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.indexing.ContentDiscoverer.a(io.branch.indexing.ContentDiscoverer, org.json.JSONArray, org.json.JSONArray, org.json.JSONArray, android.app.Activity, boolean):void");
    }
}
