package io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;

public class PrefHelper {
    public static JSONObject f24644b = null;
    private static boolean f24645c = false;
    private static boolean f24646d = false;
    private static String f24647e;
    private static PrefHelper f24648f;
    JSONObject f24649a;
    private SharedPreferences f24650g;
    private Editor f24651h;
    private Context f24652i;

    public static String m26152a() {
        return "https://api.branch.io/";
    }

    private PrefHelper(Context context) {
        this.f24650g = context.getSharedPreferences("branch_referral_shared_pref", 0);
        this.f24651h = this.f24650g.edit();
        this.f24652i = context;
        this.f24649a = new JSONObject();
    }

    public static PrefHelper m26151a(Context context) {
        if (f24648f == null) {
            f24648f = new PrefHelper(context);
        }
        return f24648f;
    }

    public static int m26158b() {
        return m26160b("bnc_timeout", 5500);
    }

    public static int m26164c() {
        return m26160b("bnc_retry_interval", 1000);
    }

    public final boolean m26181a(String str) {
        f24647e = str;
        String d = m26170d("bnc_branch_key");
        if (!(str == null || d == null)) {
            if (d.equals(str)) {
                return null;
            }
        }
        d = m26170d("bnc_link_click_id");
        String d2 = m26170d("bnc_link_click_identifier");
        String d3 = m26170d("bnc_app_link");
        String d4 = m26170d("bnc_push_identifier");
        this.f24651h.clear();
        m26156a("bnc_link_click_id", d);
        m26156a("bnc_link_click_identifier", d2);
        m26156a("bnc_app_link", d3);
        m26156a("bnc_push_identifier", d4);
        f24648f.f24651h.apply();
        m26156a("bnc_branch_key", str);
        return true;
    }

    public static String m26169d() {
        if (f24647e == null) {
            f24647e = m26170d("bnc_branch_key");
        }
        return f24647e;
    }

    public static void m26163b(boolean z) {
        m26155a("bnc_is_full_app_conversion", Boolean.valueOf(z));
    }

    static ArrayList<String> m26174f() {
        String d = m26170d("bnc_buckets");
        if (d.equals("bnc_no_value")) {
            return new ArrayList();
        }
        return m26176g(d);
    }

    static void m26157a(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            m26156a("bnc_buckets", "bnc_no_value");
        } else {
            m26156a("bnc_buckets", m26166c((ArrayList) arrayList));
        }
    }

    public static void m26153a(String str, int i) {
        ArrayList f = m26174f();
        if (!f.contains(str)) {
            f.add(str);
            m26157a(f);
        }
        StringBuilder stringBuilder = new StringBuilder("bnc_credit_base_");
        stringBuilder.append(str);
        m26167c(stringBuilder.toString(), i);
    }

    public static int m26159b(String str) {
        StringBuilder stringBuilder = new StringBuilder("bnc_credit_base_");
        stringBuilder.append(str);
        return m26160b(stringBuilder.toString(), 0);
    }

    static ArrayList<String> m26175g() {
        String d = m26170d("bnc_actions");
        if (d.equals("bnc_no_value")) {
            return new ArrayList();
        }
        return m26176g(d);
    }

    static void m26162b(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            m26156a("bnc_actions", "bnc_no_value");
        } else {
            m26156a("bnc_actions", m26166c((ArrayList) arrayList));
        }
    }

    private static String m26166c(ArrayList<String> arrayList) {
        String str = "";
        arrayList = arrayList.iterator();
        while (arrayList.hasNext()) {
            String str2 = (String) arrayList.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            stringBuilder.append(",");
            str = stringBuilder.toString();
        }
        return str.substring(null, str.length() - 1);
    }

    private static ArrayList<String> m26176g(String str) {
        Object arrayList = new ArrayList();
        Collections.addAll(arrayList, str.split(","));
        return arrayList;
    }

    public static int m26160b(String str, int i) {
        return f24648f.f24650g.getInt(str, i);
    }

    public static long m26165c(String str) {
        return f24648f.f24650g.getLong(str, 0);
    }

    public static String m26170d(String str) {
        return f24648f.f24650g.getString(str, "bnc_no_value");
    }

    public static boolean m26172e(String str) {
        return f24648f.f24650g.getBoolean(str, false);
    }

    public static void m26167c(String str, int i) {
        f24648f.f24651h.putInt(str, i);
        f24648f.f24651h.apply();
    }

    public static void m26154a(String str, long j) {
        f24648f.f24651h.putLong(str, j);
        f24648f.f24651h.apply();
    }

    public static void m26156a(String str, String str2) {
        f24648f.f24651h.putString(str, str2);
        f24648f.f24651h.apply();
    }

    public static void m26155a(String str, Boolean bool) {
        f24648f.f24651h.putBoolean(str, bool.booleanValue());
        f24648f.f24651h.apply();
    }

    public static int m26173f(String str) {
        StringBuilder stringBuilder = new StringBuilder("bnc_branch_view_use_");
        stringBuilder.append(str);
        return m26160b(stringBuilder.toString(), 0);
    }

    public static org.json.JSONObject m26177h() {
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
        r0 = f24644b;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0 = f24644b;
        goto L_0x0028;
    L_0x0007:
        r0 = "bnc_branch_analytical_data";
        r0 = m26170d(r0);
        r1 = new org.json.JSONObject;
        r1.<init>();
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 != 0) goto L_0x0027;
    L_0x0018:
        r2 = "bnc_no_value";
        r2 = r0.equals(r2);
        if (r2 != 0) goto L_0x0027;
    L_0x0020:
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0027 }
        r2.<init>(r0);	 Catch:{ JSONException -> 0x0027 }
        r0 = r2;
        goto L_0x0028;
    L_0x0027:
        r0 = r1;
    L_0x0028:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.PrefHelper.h():org.json.JSONObject");
    }

    public static void m26178i() {
        f24645c = true;
    }

    public static boolean m26179j() {
        return f24645c;
    }

    public static void m26168c(boolean z) {
        f24646d = z;
    }

    public static void m26161b(String str, String str2) {
        if (f24648f != null) {
            if (f24645c || f24646d) {
                Log.i(str, str2);
            }
            return;
        }
        if (f24645c || f24646d) {
            Log.i(str, str2);
        }
    }

    public final java.lang.String m26180a(boolean r6) {
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
        r5 = this;
        if (r6 == 0) goto L_0x0005;
    L_0x0002:
        r0 = "io.branch.sdk.BranchKey";
        goto L_0x0007;
    L_0x0005:
        r0 = "io.branch.sdk.BranchKey.test";
    L_0x0007:
        if (r6 != 0) goto L_0x000c;
    L_0x0009:
        r1 = 1;
        f24645c = r1;
    L_0x000c:
        r1 = 0;
        r2 = r5.f24652i;	 Catch:{ NameNotFoundException -> 0x0037 }
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0037 }
        r3 = r5.f24652i;	 Catch:{ NameNotFoundException -> 0x0037 }
        r3 = r3.getPackageName();	 Catch:{ NameNotFoundException -> 0x0037 }
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0037 }
        r2 = r2.getApplicationInfo(r3, r4);	 Catch:{ NameNotFoundException -> 0x0037 }
        r3 = r2.metaData;	 Catch:{ NameNotFoundException -> 0x0037 }
        if (r3 == 0) goto L_0x0037;	 Catch:{ NameNotFoundException -> 0x0037 }
    L_0x0023:
        r3 = r2.metaData;	 Catch:{ NameNotFoundException -> 0x0037 }
        r3 = r3.getString(r0);	 Catch:{ NameNotFoundException -> 0x0037 }
        if (r3 != 0) goto L_0x0036;
    L_0x002b:
        if (r6 != 0) goto L_0x0036;
    L_0x002d:
        r6 = r2.metaData;	 Catch:{ NameNotFoundException -> 0x0036 }
        r1 = "io.branch.sdk.BranchKey";	 Catch:{ NameNotFoundException -> 0x0036 }
        r1 = r6.getString(r1);	 Catch:{ NameNotFoundException -> 0x0036 }
        goto L_0x0037;
    L_0x0036:
        r1 = r3;
    L_0x0037:
        r6 = android.text.TextUtils.isEmpty(r1);
        if (r6 == 0) goto L_0x0054;
    L_0x003d:
        r6 = r5.f24652i;	 Catch:{ Exception -> 0x0054 }
        r6 = r6.getResources();	 Catch:{ Exception -> 0x0054 }
        r2 = "string";	 Catch:{ Exception -> 0x0054 }
        r3 = r5.f24652i;	 Catch:{ Exception -> 0x0054 }
        r3 = r3.getPackageName();	 Catch:{ Exception -> 0x0054 }
        r0 = r6.getIdentifier(r0, r2, r3);	 Catch:{ Exception -> 0x0054 }
        r6 = r6.getString(r0);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0055;
    L_0x0054:
        r6 = r1;
    L_0x0055:
        if (r6 != 0) goto L_0x0059;
    L_0x0057:
        r6 = "bnc_no_value";
    L_0x0059:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.PrefHelper.a(boolean):java.lang.String");
    }

    public static int m26171e() {
        return m26160b("bnc_is_referrable", 0);
    }
}
