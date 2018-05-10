package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.instabug.library.model.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount extends zzbfm implements ReflectedParcelable {
    public static final Creator<GoogleSignInAccount> CREATOR = new zzb();
    public static zzd f17231a = zzh.m13111d();
    public String f17232b;
    public String f17233c;
    public long f17234d;
    public String f17235e;
    private int f17236f;
    private String f17237g;
    private String f17238h;
    private Uri f17239i;
    private String f17240j;
    private List<Scope> f17241k;
    private String f17242l;
    private String f17243m;
    private Set<Scope> f17244n = new HashSet();

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f17236f = i;
        this.f17237g = str;
        this.f17238h = str2;
        this.f17232b = str3;
        this.f17233c = str4;
        this.f17239i = uri;
        this.f17240j = str5;
        this.f17234d = j;
        this.f17235e = str6;
        this.f17241k = list;
        this.f17242l = str7;
        this.f17243m = str8;
    }

    public final Set<Scope> m17565a() {
        Set<Scope> hashSet = new HashSet(this.f17241k);
        hashSet.addAll(this.f17244n);
        return hashSet;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f17235e.equals(this.f17235e) && googleSignInAccount.m17565a().equals(m17565a());
    }

    public int hashCode() {
        return ((527 + this.f17235e.hashCode()) * 31) + m17565a().hashCode();
    }

    public static GoogleSignInAccount m17564a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        Object optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        Object hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.optString("tokenId", null);
        String optString4 = jSONObject.optString(State.KEY_EMAIL, null);
        String optString5 = jSONObject.optString("displayName", null);
        String optString6 = jSONObject.optString("givenName", null);
        String optString7 = jSONObject.optString("familyName", null);
        Long valueOf = Long.valueOf(parseLong);
        String string = jSONObject.getString("obfuscatedIdentifier");
        if (valueOf == null) {
            valueOf = Long.valueOf(f17231a.mo1632a() / 1000);
        }
        GoogleSignInAccount googleSignInAccount = r3;
        GoogleSignInAccount googleSignInAccount2 = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, valueOf.longValue(), zzbq.m4810a(string), new ArrayList((Collection) zzbq.m4808a(hashSet)), optString6, optString7);
        googleSignInAccount.f17240j = jSONObject.optString("serverAuthCode", null);
        return googleSignInAccount;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = zzbfp.m5536a(parcel);
        zzbfp.m5540a(parcel, 1, this.f17236f);
        zzbfp.m5545a(parcel, 2, this.f17237g);
        zzbfp.m5545a(parcel, 3, this.f17238h);
        zzbfp.m5545a(parcel, 4, this.f17232b);
        zzbfp.m5545a(parcel, 5, this.f17233c);
        zzbfp.m5544a(parcel, 6, this.f17239i, i);
        zzbfp.m5545a(parcel, 7, this.f17240j);
        zzbfp.m5541a(parcel, 8, this.f17234d);
        zzbfp.m5545a(parcel, 9, this.f17235e);
        zzbfp.m5559c(parcel, 10, this.f17241k);
        zzbfp.m5545a(parcel, 11, this.f17242l);
        zzbfp.m5545a(parcel, 12, this.f17243m);
        zzbfp.m5537a(parcel, a);
    }

    public final JSONObject m17566b() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f17237g != null) {
                jSONObject.put("id", this.f17237g);
            }
            if (this.f17238h != null) {
                jSONObject.put("tokenId", this.f17238h);
            }
            if (this.f17232b != null) {
                jSONObject.put(State.KEY_EMAIL, this.f17232b);
            }
            if (this.f17233c != null) {
                jSONObject.put("displayName", this.f17233c);
            }
            if (this.f17242l != null) {
                jSONObject.put("givenName", this.f17242l);
            }
            if (this.f17243m != null) {
                jSONObject.put("familyName", this.f17243m);
            }
            if (this.f17239i != null) {
                jSONObject.put("photoUrl", this.f17239i.toString());
            }
            if (this.f17240j != null) {
                jSONObject.put("serverAuthCode", this.f17240j);
            }
            jSONObject.put("expirationTime", this.f17234d);
            jSONObject.put("obfuscatedIdentifier", this.f17235e);
            JSONArray jSONArray = new JSONArray();
            Scope[] scopeArr = (Scope[]) this.f17241k.toArray(new Scope[this.f17241k.size()]);
            Arrays.sort(scopeArr, zza.f5727a);
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.f17261a);
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
