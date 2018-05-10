package io.branch.referral;

import android.annotation.SuppressLint;
import java.util.Collection;
import org.json.JSONObject;

class BranchLinkData extends JSONObject {
    Collection<String> f24494a;
    String f24495b;
    int f24496c;
    String f24497d;
    String f24498e;
    String f24499f;
    String f24500g;
    String f24501h;
    int f24502i;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BranchLinkData branchLinkData = (BranchLinkData) obj;
        if (this.f24495b == null) {
            if (branchLinkData.f24495b != null) {
                return false;
            }
        } else if (!this.f24495b.equals(branchLinkData.f24495b)) {
            return false;
        }
        if (this.f24497d == null) {
            if (branchLinkData.f24497d != null) {
                return false;
            }
        } else if (!this.f24497d.equals(branchLinkData.f24497d)) {
            return false;
        }
        if (this.f24498e == null) {
            if (branchLinkData.f24498e != null) {
                return false;
            }
        } else if (!this.f24498e.equals(branchLinkData.f24498e)) {
            return false;
        }
        if (this.f24501h == null) {
            if (branchLinkData.f24501h != null) {
                return false;
            }
        } else if (!this.f24501h.equals(branchLinkData.f24501h)) {
            return false;
        }
        if (this.f24499f == null) {
            if (branchLinkData.f24499f != null) {
                return false;
            }
        } else if (!this.f24499f.equals(branchLinkData.f24499f)) {
            return false;
        }
        if (this.f24500g == null) {
            if (branchLinkData.f24500g != null) {
                return false;
            }
        } else if (!this.f24500g.equals(branchLinkData.f24500g)) {
            return false;
        }
        if (this.f24496c != branchLinkData.f24496c || this.f24502i != branchLinkData.f24502i) {
            return false;
        }
        if (this.f24494a == null) {
            if (branchLinkData.f24494a != null) {
                return false;
            }
        } else if (this.f24494a.toString().equals(branchLinkData.f24494a.toString()) == null) {
            return false;
        }
        return true;
    }

    @SuppressLint({"DefaultLocale"})
    public int hashCode() {
        int i;
        int i2 = (this.f24496c + 19) * 19;
        int i3 = 0;
        if (this.f24495b == null) {
            i = 0;
        } else {
            i = this.f24495b.toLowerCase().hashCode();
        }
        i2 = (i2 + i) * 19;
        if (this.f24497d == null) {
            i = 0;
        } else {
            i = this.f24497d.toLowerCase().hashCode();
        }
        i2 = (i2 + i) * 19;
        if (this.f24498e == null) {
            i = 0;
        } else {
            i = this.f24498e.toLowerCase().hashCode();
        }
        i2 = (i2 + i) * 19;
        if (this.f24499f == null) {
            i = 0;
        } else {
            i = this.f24499f.toLowerCase().hashCode();
        }
        i2 = (i2 + i) * 19;
        if (this.f24500g == null) {
            i = 0;
        } else {
            i = this.f24500g.toLowerCase().hashCode();
        }
        i2 = (i2 + i) * 19;
        if (this.f24501h != null) {
            i3 = this.f24501h.toLowerCase().hashCode();
        }
        i2 = ((i2 + i3) * 19) + this.f24502i;
        if (this.f24494a != null) {
            for (String toLowerCase : this.f24494a) {
                i2 = (i2 * 19) + toLowerCase.toLowerCase().hashCode();
            }
        }
        return i2;
    }

    public final org.json.JSONObject m26101a() {
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
        r3 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = r3.f24497d;	 Catch:{ JSONException -> 0x00ee }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00ee }
        if (r1 != 0) goto L_0x0025;	 Catch:{ JSONException -> 0x00ee }
    L_0x000d:
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00ee }
        r2 = "~";	 Catch:{ JSONException -> 0x00ee }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x00ee }
        r2 = io.branch.referral.Defines.LinkParam.f24603e;	 Catch:{ JSONException -> 0x00ee }
        r2 = r2.f24610k;	 Catch:{ JSONException -> 0x00ee }
        r1.append(r2);	 Catch:{ JSONException -> 0x00ee }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x00ee }
        r2 = r3.f24497d;	 Catch:{ JSONException -> 0x00ee }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x00ee }
    L_0x0025:
        r1 = r3.f24495b;	 Catch:{ JSONException -> 0x00ee }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00ee }
        if (r1 != 0) goto L_0x0045;	 Catch:{ JSONException -> 0x00ee }
    L_0x002d:
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00ee }
        r2 = "~";	 Catch:{ JSONException -> 0x00ee }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x00ee }
        r2 = io.branch.referral.Defines.LinkParam.f24600b;	 Catch:{ JSONException -> 0x00ee }
        r2 = r2.f24610k;	 Catch:{ JSONException -> 0x00ee }
        r1.append(r2);	 Catch:{ JSONException -> 0x00ee }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x00ee }
        r2 = r3.f24495b;	 Catch:{ JSONException -> 0x00ee }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x00ee }
    L_0x0045:
        r1 = r3.f24498e;	 Catch:{ JSONException -> 0x00ee }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00ee }
        if (r1 != 0) goto L_0x0065;	 Catch:{ JSONException -> 0x00ee }
    L_0x004d:
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00ee }
        r2 = "~";	 Catch:{ JSONException -> 0x00ee }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x00ee }
        r2 = io.branch.referral.Defines.LinkParam.f24604f;	 Catch:{ JSONException -> 0x00ee }
        r2 = r2.f24610k;	 Catch:{ JSONException -> 0x00ee }
        r1.append(r2);	 Catch:{ JSONException -> 0x00ee }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x00ee }
        r2 = r3.f24498e;	 Catch:{ JSONException -> 0x00ee }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x00ee }
    L_0x0065:
        r1 = r3.f24499f;	 Catch:{ JSONException -> 0x00ee }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00ee }
        if (r1 != 0) goto L_0x0085;	 Catch:{ JSONException -> 0x00ee }
    L_0x006d:
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00ee }
        r2 = "~";	 Catch:{ JSONException -> 0x00ee }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x00ee }
        r2 = io.branch.referral.Defines.LinkParam.f24605g;	 Catch:{ JSONException -> 0x00ee }
        r2 = r2.f24610k;	 Catch:{ JSONException -> 0x00ee }
        r1.append(r2);	 Catch:{ JSONException -> 0x00ee }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x00ee }
        r2 = r3.f24499f;	 Catch:{ JSONException -> 0x00ee }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x00ee }
    L_0x0085:
        r1 = r3.f24500g;	 Catch:{ JSONException -> 0x00ee }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ JSONException -> 0x00ee }
        if (r1 != 0) goto L_0x00a5;	 Catch:{ JSONException -> 0x00ee }
    L_0x008d:
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00ee }
        r2 = "~";	 Catch:{ JSONException -> 0x00ee }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x00ee }
        r2 = io.branch.referral.Defines.LinkParam.f24606h;	 Catch:{ JSONException -> 0x00ee }
        r2 = r2.f24610k;	 Catch:{ JSONException -> 0x00ee }
        r1.append(r2);	 Catch:{ JSONException -> 0x00ee }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x00ee }
        r2 = r3.f24500g;	 Catch:{ JSONException -> 0x00ee }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x00ee }
    L_0x00a5:
        r1 = io.branch.referral.Defines.LinkParam.f24599a;	 Catch:{ JSONException -> 0x00ee }
        r1 = r1.f24610k;	 Catch:{ JSONException -> 0x00ee }
        r1 = r3.has(r1);	 Catch:{ JSONException -> 0x00ee }
        if (r1 == 0) goto L_0x00be;	 Catch:{ JSONException -> 0x00ee }
    L_0x00af:
        r1 = io.branch.referral.Defines.LinkParam.f24599a;	 Catch:{ JSONException -> 0x00ee }
        r1 = r1.f24610k;	 Catch:{ JSONException -> 0x00ee }
        r2 = io.branch.referral.Defines.LinkParam.f24599a;	 Catch:{ JSONException -> 0x00ee }
        r2 = r2.f24610k;	 Catch:{ JSONException -> 0x00ee }
        r2 = r3.getJSONArray(r2);	 Catch:{ JSONException -> 0x00ee }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x00ee }
    L_0x00be:
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00ee }
        r2 = "~";	 Catch:{ JSONException -> 0x00ee }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x00ee }
        r2 = io.branch.referral.Defines.LinkParam.f24601c;	 Catch:{ JSONException -> 0x00ee }
        r2 = r2.f24610k;	 Catch:{ JSONException -> 0x00ee }
        r1.append(r2);	 Catch:{ JSONException -> 0x00ee }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x00ee }
        r2 = r3.f24496c;	 Catch:{ JSONException -> 0x00ee }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x00ee }
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x00ee }
        r2 = "~";	 Catch:{ JSONException -> 0x00ee }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x00ee }
        r2 = io.branch.referral.Defines.LinkParam.f24602d;	 Catch:{ JSONException -> 0x00ee }
        r2 = r2.f24610k;	 Catch:{ JSONException -> 0x00ee }
        r1.append(r2);	 Catch:{ JSONException -> 0x00ee }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x00ee }
        r2 = r3.f24502i;	 Catch:{ JSONException -> 0x00ee }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x00ee }
    L_0x00ee:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.BranchLinkData.a():org.json.JSONObject");
    }
}
