package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zzn;
import com.google.android.gms.auth.api.signin.internal.zzp;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.instabug.library.model.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions extends zzbfm implements Optional, ReflectedParcelable {
    public static final Creator<GoogleSignInOptions> CREATOR = new zze();
    public static final Scope f19083a = new Scope("profile");
    public static final Scope f19084b = new Scope(State.KEY_EMAIL);
    public static final Scope f19085c = new Scope("openid");
    public static final Scope f19086d = new Scope("https://www.googleapis.com/auth/games_lite");
    public static final Scope f19087e = new Scope("https://www.googleapis.com/auth/games");
    public static final GoogleSignInOptions f19088f;
    public static final GoogleSignInOptions f19089g = new Builder().m4596a(f19086d, new Scope[0]).m4597b();
    private static Comparator<Scope> f19090r = new zzd();
    public Account f19091h;
    public boolean f19092i;
    public final boolean f19093j;
    public String f19094k;
    private int f19095l;
    private final ArrayList<Scope> f19096m;
    private final boolean f19097n;
    private String f19098o;
    private ArrayList<zzn> f19099p;
    private Map<Integer, zzn> f19100q;

    public static final class Builder {
        public Set<Scope> f5708a = new HashSet();
        private boolean f5709b;
        private boolean f5710c;
        private boolean f5711d;
        private String f5712e;
        private Account f5713f;
        private String f5714g;
        private Map<Integer, zzn> f5715h = new HashMap();

        public Builder(GoogleSignInOptions googleSignInOptions) {
            zzbq.m4808a((Object) googleSignInOptions);
            this.f5708a = new HashSet(googleSignInOptions.f19096m);
            this.f5709b = googleSignInOptions.f19093j;
            this.f5710c = googleSignInOptions.f19097n;
            this.f5711d = googleSignInOptions.f19092i;
            this.f5712e = googleSignInOptions.f19094k;
            this.f5713f = googleSignInOptions.f19091h;
            this.f5714g = googleSignInOptions.f19098o;
            this.f5715h = GoogleSignInOptions.m20174b(googleSignInOptions.f19099p);
        }

        public final Builder m4595a() {
            this.f5708a.add(GoogleSignInOptions.f19085c);
            return this;
        }

        public final Builder m4596a(Scope scope, Scope... scopeArr) {
            this.f5708a.add(scope);
            this.f5708a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final GoogleSignInOptions m4597b() {
            if (this.f5708a.contains(GoogleSignInOptions.f19087e) && this.f5708a.contains(GoogleSignInOptions.f19086d)) {
                this.f5708a.remove(GoogleSignInOptions.f19086d);
            }
            if (this.f5711d && (this.f5713f == null || !this.f5708a.isEmpty())) {
                m4595a();
            }
            return new GoogleSignInOptions(new ArrayList(this.f5708a), this.f5713f, this.f5711d, this.f5709b, this.f5710c, this.f5712e, this.f5714g, this.f5715h);
        }
    }

    GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, ArrayList<zzn> arrayList2) {
        this(i, (ArrayList) arrayList, account, z, z2, z3, str, str2, m20174b((List) arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, zzn> map) {
        this.f19095l = i;
        this.f19096m = arrayList;
        this.f19091h = account;
        this.f19092i = z;
        this.f19093j = z2;
        this.f19097n = z3;
        this.f19094k = str;
        this.f19098o = str2;
        this.f19099p = new ArrayList(map.values());
        this.f19100q = map;
    }

    public static GoogleSignInOptions m20171a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Collection hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        Object optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    public final ArrayList<Scope> m20182a() {
        return new ArrayList(this.f19096m);
    }

    public boolean equals(java.lang.Object r4) {
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
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r3.f19099p;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 > 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x000e:
        r1 = r4.f19099p;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 <= 0) goto L_0x0017;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0016:
        return r0;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0017:
        r1 = r3.f19096m;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.size();	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.m20182a();	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r2.size();	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r2) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0027:
        r1 = r3.f19096m;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.m20182a();	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.containsAll(r2);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != 0) goto L_0x0034;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0033:
        return r0;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0034:
        r1 = r3.f19091h;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != 0) goto L_0x003d;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0038:
        r1 = r4.f19091h;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x003c:
        goto L_0x0047;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x003d:
        r1 = r3.f19091h;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.f19091h;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.equals(r2);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0047:
        r1 = r3.f19094k;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0058;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x004f:
        r1 = r4.f19094k;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0057:
        goto L_0x0062;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0058:
        r1 = r3.f19094k;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.f19094k;	 Catch:{ ClassCastException -> 0x0076 }
        r1 = r1.equals(r2);	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 == 0) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0062:
        r1 = r3.f19097n;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.f19097n;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r2) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x0068:
        r1 = r3.f19092i;	 Catch:{ ClassCastException -> 0x0076 }
        r2 = r4.f19092i;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r2) goto L_0x0076;	 Catch:{ ClassCastException -> 0x0076 }
    L_0x006e:
        r1 = r3.f19093j;	 Catch:{ ClassCastException -> 0x0076 }
        r4 = r4.f19093j;	 Catch:{ ClassCastException -> 0x0076 }
        if (r1 != r4) goto L_0x0076;
    L_0x0074:
        r4 = 1;
        return r4;
    L_0x0076:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f19095l);
        zzbfp.m5559c(parcel, 2, m20182a());
        zzbfp.m5544a(parcel, 3, this.f19091h, i);
        zzbfp.m5547a(parcel, 4, this.f19092i);
        zzbfp.m5547a(parcel, 5, this.f19093j);
        zzbfp.m5547a(parcel, 6, this.f19097n);
        zzbfp.m5545a(parcel, 7, this.f19094k);
        zzbfp.m5545a(parcel, 8, this.f19098o);
        zzbfp.m5559c(parcel, 9, this.f19099p);
        zzbfp.m5537a(parcel, a);
    }

    private static Map<Integer, zzn> m20174b(List<zzn> list) {
        Map<Integer, zzn> hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (zzn com_google_android_gms_auth_api_signin_internal_zzn : list) {
            hashMap.put(Integer.valueOf(com_google_android_gms_auth_api_signin_internal_zzn.f17252a), com_google_android_gms_auth_api_signin_internal_zzn);
        }
        return hashMap;
    }

    public int hashCode() {
        Object arrayList = new ArrayList();
        ArrayList arrayList2 = this.f19096m;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((Scope) obj).f17261a);
        }
        Collections.sort(arrayList);
        return new zzp().m4610a(arrayList).m4610a(this.f19091h).m4610a(this.f19094k).m4611a(this.f19097n).m4611a(this.f19092i).m4611a(this.f19093j).f5722a;
    }

    public final JSONObject m20183b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f19096m, f19090r);
            ArrayList arrayList = this.f19096m;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                jSONArray.put(((Scope) obj).f17261a);
            }
            jSONObject.put("scopes", jSONArray);
            if (this.f19091h != null) {
                jSONObject.put("accountName", this.f19091h.name);
            }
            jSONObject.put("idTokenRequested", this.f19092i);
            jSONObject.put("forceCodeForRefreshToken", this.f19097n);
            jSONObject.put("serverAuthRequested", this.f19093j);
            if (!TextUtils.isEmpty(this.f19094k)) {
                jSONObject.put("serverClientId", this.f19094k);
            }
            if (!TextUtils.isEmpty(this.f19098o)) {
                jSONObject.put("hostedDomain", this.f19098o);
            }
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    static {
        Builder a = new Builder().m4595a();
        a.f5708a.add(f19083a);
        f19088f = a.m4597b();
    }
}
