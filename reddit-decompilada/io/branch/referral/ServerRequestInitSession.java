package io.branch.referral;

import android.content.Context;
import io.branch.indexing.ContentDiscoveryManifest;
import org.json.JSONObject;

abstract class ServerRequestInitSession extends ServerRequest {
    private final Context f30966a;
    private final ContentDiscoveryManifest f30967b = ContentDiscoveryManifest.m26089a(this.f30966a);

    public abstract boolean mo6587a();

    public abstract String mo6588b();

    public boolean isGAdsParamsRequired() {
        return true;
    }

    ServerRequestInitSession(Context context, String str) {
        super(context, str);
        this.f30966a = context;
    }

    ServerRequestInitSession(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.f30966a = context;
    }

    protected void setPost(JSONObject jSONObject) {
        super.setPost(jSONObject);
        updateEnvironment(this.f30966a, jSONObject);
    }

    static boolean m31925a(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("open") || str.equalsIgnoreCase("install") != null;
        } else {
            return false;
        }
    }

    final boolean m31928a(io.branch.referral.ServerResponse r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        if (r5 == 0) goto L_0x0074;
    L_0x0002:
        r0 = r5.m26198a();
        if (r0 == 0) goto L_0x0074;
    L_0x0008:
        r0 = r5.m26198a();
        r1 = io.branch.referral.Defines.Jsonkey.BranchViewData;
        r1 = r1.bc;
        r0 = r0.has(r1);
        if (r0 == 0) goto L_0x0074;
    L_0x0016:
        r5 = r5.m26198a();	 Catch:{ JSONException -> 0x0074 }
        r0 = io.branch.referral.Defines.Jsonkey.BranchViewData;	 Catch:{ JSONException -> 0x0074 }
        r0 = r0.bc;	 Catch:{ JSONException -> 0x0074 }
        r5 = r5.getJSONObject(r0);	 Catch:{ JSONException -> 0x0074 }
        r0 = r4.mo6588b();	 Catch:{ JSONException -> 0x0074 }
        r1 = io.branch.referral.Branch.m31871a();	 Catch:{ JSONException -> 0x0074 }
        r1 = r1.f30933d;	 Catch:{ JSONException -> 0x0074 }
        if (r1 == 0) goto L_0x006b;	 Catch:{ JSONException -> 0x0074 }
    L_0x002e:
        r1 = io.branch.referral.Branch.m31871a();	 Catch:{ JSONException -> 0x0074 }
        r1 = r1.f30933d;	 Catch:{ JSONException -> 0x0074 }
        r1 = r1.get();	 Catch:{ JSONException -> 0x0074 }
        if (r1 == 0) goto L_0x006b;	 Catch:{ JSONException -> 0x0074 }
    L_0x003a:
        r1 = io.branch.referral.Branch.m31871a();	 Catch:{ JSONException -> 0x0074 }
        r1 = r1.f30933d;	 Catch:{ JSONException -> 0x0074 }
        r1 = r1.get();	 Catch:{ JSONException -> 0x0074 }
        r1 = (android.app.Activity) r1;	 Catch:{ JSONException -> 0x0074 }
        r2 = r1 instanceof io.branch.referral.Branch.IBranchViewControl;	 Catch:{ JSONException -> 0x0074 }
        r3 = 1;	 Catch:{ JSONException -> 0x0074 }
        if (r2 == 0) goto L_0x0053;	 Catch:{ JSONException -> 0x0074 }
    L_0x004b:
        r2 = r1;	 Catch:{ JSONException -> 0x0074 }
        r2 = (io.branch.referral.Branch.IBranchViewControl) r2;	 Catch:{ JSONException -> 0x0074 }
        r2 = r2.m26098a();	 Catch:{ JSONException -> 0x0074 }
        r3 = r3 ^ r2;	 Catch:{ JSONException -> 0x0074 }
    L_0x0053:
        if (r3 == 0) goto L_0x0062;	 Catch:{ JSONException -> 0x0074 }
    L_0x0055:
        r2 = io.branch.referral.BranchViewHandler.m26121a();	 Catch:{ JSONException -> 0x0074 }
        r3 = io.branch.referral.Branch.m31871a();	 Catch:{ JSONException -> 0x0074 }
        r5 = r2.m26135a(r5, r0, r1, r3);	 Catch:{ JSONException -> 0x0074 }
        goto L_0x0075;	 Catch:{ JSONException -> 0x0074 }
    L_0x0062:
        r1 = io.branch.referral.BranchViewHandler.m26121a();	 Catch:{ JSONException -> 0x0074 }
        r5 = r1.m26134a(r5, r0);	 Catch:{ JSONException -> 0x0074 }
        goto L_0x0075;	 Catch:{ JSONException -> 0x0074 }
    L_0x006b:
        r1 = io.branch.referral.BranchViewHandler.m26121a();	 Catch:{ JSONException -> 0x0074 }
        r5 = r1.m26134a(r5, r0);	 Catch:{ JSONException -> 0x0074 }
        goto L_0x0075;
    L_0x0074:
        r5 = 0;
    L_0x0075:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestInitSession.a(io.branch.referral.ServerResponse):boolean");
    }

    final void m31926a(io.branch.referral.ServerResponse r4, io.branch.referral.Branch r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.f30967b;
        if (r0 == 0) goto L_0x00b5;
    L_0x0004:
        r0 = r3.f30967b;
        r4 = r4.m26198a();
        r1 = "cd";
        r1 = r4.has(r1);
        if (r1 == 0) goto L_0x0095;
    L_0x0012:
        r1 = 1;
        r0.f24467f = r1;
        r1 = "cd";	 Catch:{ JSONException -> 0x0098 }
        r4 = r4.getJSONObject(r1);	 Catch:{ JSONException -> 0x0098 }
        r1 = "mv";	 Catch:{ JSONException -> 0x0098 }
        r1 = r4.has(r1);	 Catch:{ JSONException -> 0x0098 }
        if (r1 == 0) goto L_0x002b;	 Catch:{ JSONException -> 0x0098 }
    L_0x0023:
        r1 = "mv";	 Catch:{ JSONException -> 0x0098 }
        r1 = r4.getString(r1);	 Catch:{ JSONException -> 0x0098 }
        r0.f24463b = r1;	 Catch:{ JSONException -> 0x0098 }
    L_0x002b:
        r1 = "mhl";	 Catch:{ JSONException -> 0x0098 }
        r1 = r4.has(r1);	 Catch:{ JSONException -> 0x0098 }
        if (r1 == 0) goto L_0x003b;	 Catch:{ JSONException -> 0x0098 }
    L_0x0033:
        r1 = "mhl";	 Catch:{ JSONException -> 0x0098 }
        r1 = r4.getInt(r1);	 Catch:{ JSONException -> 0x0098 }
        r0.f24465d = r1;	 Catch:{ JSONException -> 0x0098 }
    L_0x003b:
        r1 = "m";	 Catch:{ JSONException -> 0x0098 }
        r1 = r4.has(r1);	 Catch:{ JSONException -> 0x0098 }
        if (r1 == 0) goto L_0x004b;	 Catch:{ JSONException -> 0x0098 }
    L_0x0043:
        r1 = "m";	 Catch:{ JSONException -> 0x0098 }
        r1 = r4.getJSONArray(r1);	 Catch:{ JSONException -> 0x0098 }
        r0.f24468g = r1;	 Catch:{ JSONException -> 0x0098 }
    L_0x004b:
        r1 = "mtl";	 Catch:{ JSONException -> 0x0098 }
        r1 = r4.has(r1);	 Catch:{ JSONException -> 0x0098 }
        if (r1 == 0) goto L_0x005d;	 Catch:{ JSONException -> 0x0098 }
    L_0x0053:
        r1 = "mtl";	 Catch:{ JSONException -> 0x0098 }
        r1 = r4.getInt(r1);	 Catch:{ JSONException -> 0x0098 }
        if (r1 <= 0) goto L_0x005d;	 Catch:{ JSONException -> 0x0098 }
    L_0x005b:
        r0.f24464c = r1;	 Catch:{ JSONException -> 0x0098 }
    L_0x005d:
        r1 = "mps";	 Catch:{ JSONException -> 0x0098 }
        r1 = r4.has(r1);	 Catch:{ JSONException -> 0x0098 }
        if (r1 == 0) goto L_0x006d;	 Catch:{ JSONException -> 0x0098 }
    L_0x0065:
        r1 = "mps";	 Catch:{ JSONException -> 0x0098 }
        r4 = r4.getInt(r1);	 Catch:{ JSONException -> 0x0098 }
        r0.f24466e = r4;	 Catch:{ JSONException -> 0x0098 }
    L_0x006d:
        r4 = r0.f24462a;	 Catch:{ JSONException -> 0x0098 }
        r1 = "mv";	 Catch:{ JSONException -> 0x0098 }
        r2 = r0.f24463b;	 Catch:{ JSONException -> 0x0098 }
        r4.put(r1, r2);	 Catch:{ JSONException -> 0x0098 }
        r4 = r0.f24462a;	 Catch:{ JSONException -> 0x0098 }
        r1 = "m";	 Catch:{ JSONException -> 0x0098 }
        r2 = r0.f24468g;	 Catch:{ JSONException -> 0x0098 }
        r4.put(r1, r2);	 Catch:{ JSONException -> 0x0098 }
        r4 = r0.f24469h;	 Catch:{ JSONException -> 0x0098 }
        r4 = r4.edit();	 Catch:{ JSONException -> 0x0098 }
        r1 = "BNC_CD_MANIFEST";	 Catch:{ JSONException -> 0x0098 }
        r0 = r0.f24462a;	 Catch:{ JSONException -> 0x0098 }
        r0 = r0.toString();	 Catch:{ JSONException -> 0x0098 }
        r4 = r4.putString(r1, r0);	 Catch:{ JSONException -> 0x0098 }
        r4.apply();	 Catch:{ JSONException -> 0x0098 }
        goto L_0x0098;
    L_0x0095:
        r4 = 0;
        r0.f24467f = r4;
    L_0x0098:
        r4 = r5.f30933d;
        if (r4 == 0) goto L_0x00b5;
    L_0x009c:
        r4 = io.branch.indexing.ContentDiscoverer.m26068a();	 Catch:{ Exception -> 0x00b5 }
        r0 = r5.f30933d;	 Catch:{ Exception -> 0x00b5 }
        r0 = r0.get();	 Catch:{ Exception -> 0x00b5 }
        r0 = (android.app.Activity) r0;	 Catch:{ Exception -> 0x00b5 }
        r5 = r5.f30934e;	 Catch:{ Exception -> 0x00b5 }
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x00b5 }
        r1.<init>();	 Catch:{ Exception -> 0x00b5 }
        r4.f24447e = r1;	 Catch:{ Exception -> 0x00b5 }
        r4.m26087a(r0, r5);	 Catch:{ Exception -> 0x00b5 }
        return;
    L_0x00b5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestInitSession.a(io.branch.referral.ServerResponse, io.branch.referral.Branch):void");
    }

    public void onPreExecute() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.getPost();
        r1 = "bnc_app_link";	 Catch:{ JSONException -> 0x0095 }
        r1 = io.branch.referral.PrefHelper.m26170d(r1);	 Catch:{ JSONException -> 0x0095 }
        r2 = "bnc_no_value";	 Catch:{ JSONException -> 0x0095 }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x0095 }
        if (r1 != 0) goto L_0x001f;	 Catch:{ JSONException -> 0x0095 }
    L_0x0012:
        r1 = io.branch.referral.Defines.Jsonkey.AndroidAppLinkURL;	 Catch:{ JSONException -> 0x0095 }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x0095 }
        r2 = "bnc_app_link";	 Catch:{ JSONException -> 0x0095 }
        r2 = io.branch.referral.PrefHelper.m26170d(r2);	 Catch:{ JSONException -> 0x0095 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0095 }
    L_0x001f:
        r1 = "bnc_push_identifier";	 Catch:{ JSONException -> 0x0095 }
        r1 = io.branch.referral.PrefHelper.m26170d(r1);	 Catch:{ JSONException -> 0x0095 }
        r2 = "bnc_no_value";	 Catch:{ JSONException -> 0x0095 }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x0095 }
        if (r1 != 0) goto L_0x003a;	 Catch:{ JSONException -> 0x0095 }
    L_0x002d:
        r1 = io.branch.referral.Defines.Jsonkey.AndroidPushIdentifier;	 Catch:{ JSONException -> 0x0095 }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x0095 }
        r2 = "bnc_push_identifier";	 Catch:{ JSONException -> 0x0095 }
        r2 = io.branch.referral.PrefHelper.m26170d(r2);	 Catch:{ JSONException -> 0x0095 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0095 }
    L_0x003a:
        r1 = "bnc_external_intent_uri";	 Catch:{ JSONException -> 0x0095 }
        r1 = io.branch.referral.PrefHelper.m26170d(r1);	 Catch:{ JSONException -> 0x0095 }
        r2 = "bnc_no_value";	 Catch:{ JSONException -> 0x0095 }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x0095 }
        if (r1 != 0) goto L_0x0055;	 Catch:{ JSONException -> 0x0095 }
    L_0x0048:
        r1 = io.branch.referral.Defines.Jsonkey.External_Intent_URI;	 Catch:{ JSONException -> 0x0095 }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x0095 }
        r2 = "bnc_external_intent_uri";	 Catch:{ JSONException -> 0x0095 }
        r2 = io.branch.referral.PrefHelper.m26170d(r2);	 Catch:{ JSONException -> 0x0095 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0095 }
    L_0x0055:
        r1 = "bnc_external_intent_extra";	 Catch:{ JSONException -> 0x0095 }
        r1 = io.branch.referral.PrefHelper.m26170d(r1);	 Catch:{ JSONException -> 0x0095 }
        r2 = "bnc_no_value";	 Catch:{ JSONException -> 0x0095 }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x0095 }
        if (r1 != 0) goto L_0x0070;	 Catch:{ JSONException -> 0x0095 }
    L_0x0063:
        r1 = io.branch.referral.Defines.Jsonkey.External_Intent_Extra;	 Catch:{ JSONException -> 0x0095 }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x0095 }
        r2 = "bnc_external_intent_extra";	 Catch:{ JSONException -> 0x0095 }
        r2 = io.branch.referral.PrefHelper.m26170d(r2);	 Catch:{ JSONException -> 0x0095 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0095 }
    L_0x0070:
        r1 = r4.f30967b;	 Catch:{ JSONException -> 0x0095 }
        if (r1 == 0) goto L_0x0094;	 Catch:{ JSONException -> 0x0095 }
    L_0x0074:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0095 }
        r1.<init>();	 Catch:{ JSONException -> 0x0095 }
        r2 = "mv";	 Catch:{ JSONException -> 0x0095 }
        r3 = r4.f30967b;	 Catch:{ JSONException -> 0x0095 }
        r3 = r3.m26091a();	 Catch:{ JSONException -> 0x0095 }
        r1.put(r2, r3);	 Catch:{ JSONException -> 0x0095 }
        r2 = "pn";	 Catch:{ JSONException -> 0x0095 }
        r3 = r4.f30966a;	 Catch:{ JSONException -> 0x0095 }
        r3 = r3.getPackageName();	 Catch:{ JSONException -> 0x0095 }
        r1.put(r2, r3);	 Catch:{ JSONException -> 0x0095 }
        r2 = "cd";	 Catch:{ JSONException -> 0x0095 }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x0095 }
    L_0x0094:
        return;
    L_0x0095:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestInitSession.onPreExecute():void");
    }

    public void onRequestSucceeded(io.branch.referral.ServerResponse r3, io.branch.referral.Branch r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r4 = "bnc_no_value";	 Catch:{ JSONException -> 0x0082 }
        r0 = "bnc_link_click_identifier";	 Catch:{ JSONException -> 0x0082 }
        io.branch.referral.PrefHelper.m26156a(r0, r4);	 Catch:{ JSONException -> 0x0082 }
        r4 = "bnc_no_value";	 Catch:{ JSONException -> 0x0082 }
        r0 = "bnc_google_search_install_identifier";	 Catch:{ JSONException -> 0x0082 }
        io.branch.referral.PrefHelper.m26156a(r0, r4);	 Catch:{ JSONException -> 0x0082 }
        r4 = "bnc_no_value";	 Catch:{ JSONException -> 0x0082 }
        r0 = "bnc_google_play_install_referrer_extras";	 Catch:{ JSONException -> 0x0082 }
        io.branch.referral.PrefHelper.m26156a(r0, r4);	 Catch:{ JSONException -> 0x0082 }
        r4 = "bnc_no_value";	 Catch:{ JSONException -> 0x0082 }
        r0 = "bnc_external_intent_uri";	 Catch:{ JSONException -> 0x0082 }
        io.branch.referral.PrefHelper.m26156a(r0, r4);	 Catch:{ JSONException -> 0x0082 }
        r4 = "bnc_no_value";	 Catch:{ JSONException -> 0x0082 }
        r0 = "bnc_external_intent_extra";	 Catch:{ JSONException -> 0x0082 }
        io.branch.referral.PrefHelper.m26156a(r0, r4);	 Catch:{ JSONException -> 0x0082 }
        r4 = "bnc_no_value";	 Catch:{ JSONException -> 0x0082 }
        r0 = "bnc_app_link";	 Catch:{ JSONException -> 0x0082 }
        io.branch.referral.PrefHelper.m26156a(r0, r4);	 Catch:{ JSONException -> 0x0082 }
        r4 = "bnc_no_value";	 Catch:{ JSONException -> 0x0082 }
        r0 = "bnc_push_identifier";	 Catch:{ JSONException -> 0x0082 }
        io.branch.referral.PrefHelper.m26156a(r0, r4);	 Catch:{ JSONException -> 0x0082 }
        r4 = 0;	 Catch:{ JSONException -> 0x0082 }
        r0 = java.lang.Boolean.valueOf(r4);	 Catch:{ JSONException -> 0x0082 }
        r1 = "bnc_triggered_by_fb_app_link";	 Catch:{ JSONException -> 0x0082 }
        io.branch.referral.PrefHelper.m26155a(r1, r0);	 Catch:{ JSONException -> 0x0082 }
        r0 = "bnc_no_value";	 Catch:{ JSONException -> 0x0082 }
        r1 = "bnc_install_referrer";	 Catch:{ JSONException -> 0x0082 }
        io.branch.referral.PrefHelper.m26156a(r1, r0);	 Catch:{ JSONException -> 0x0082 }
        io.branch.referral.PrefHelper.m26163b(r4);	 Catch:{ JSONException -> 0x0082 }
        r4 = r3.m26198a();	 Catch:{ JSONException -> 0x0082 }
        if (r4 == 0) goto L_0x0081;	 Catch:{ JSONException -> 0x0082 }
    L_0x004b:
        r4 = r3.m26198a();	 Catch:{ JSONException -> 0x0082 }
        r0 = io.branch.referral.Defines.Jsonkey.Data;	 Catch:{ JSONException -> 0x0082 }
        r0 = r0.bc;	 Catch:{ JSONException -> 0x0082 }
        r4 = r4.has(r0);	 Catch:{ JSONException -> 0x0082 }
        if (r4 == 0) goto L_0x0081;	 Catch:{ JSONException -> 0x0082 }
    L_0x0059:
        r4 = r2 instanceof io.branch.referral.ServerRequestRegisterInstall;	 Catch:{ JSONException -> 0x0082 }
        if (r4 == 0) goto L_0x0060;	 Catch:{ JSONException -> 0x0082 }
    L_0x005d:
        r4 = "Branch Install";	 Catch:{ JSONException -> 0x0082 }
        goto L_0x0062;	 Catch:{ JSONException -> 0x0082 }
    L_0x0060:
        r4 = "Branch Open";	 Catch:{ JSONException -> 0x0082 }
    L_0x0062:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0082 }
        r3 = r3.m26198a();	 Catch:{ JSONException -> 0x0082 }
        r1 = io.branch.referral.Defines.Jsonkey.Data;	 Catch:{ JSONException -> 0x0082 }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x0082 }
        r3 = r3.getString(r1);	 Catch:{ JSONException -> 0x0082 }
        r0.<init>(r3);	 Catch:{ JSONException -> 0x0082 }
        r3 = new io.branch.referral.ExtendedAnswerProvider;	 Catch:{ JSONException -> 0x0082 }
        r3.<init>();	 Catch:{ JSONException -> 0x0082 }
        r1 = "bnc_identity_id";	 Catch:{ JSONException -> 0x0082 }
        r1 = io.branch.referral.PrefHelper.m26170d(r1);	 Catch:{ JSONException -> 0x0082 }
        r3.m26144a(r4, r0, r1);	 Catch:{ JSONException -> 0x0082 }
    L_0x0081:
        return;
    L_0x0082:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestInitSession.onRequestSucceeded(io.branch.referral.ServerResponse, io.branch.referral.Branch):void");
    }
}
