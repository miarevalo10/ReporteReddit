package io.branch.referral;

import android.content.Context;
import android.util.Log;
import io.branch.referral.BranchViewHandler.IBranchViewEvents;
import org.json.JSONObject;

class ServerRequestActionCompleted extends ServerRequest {
    private final IBranchViewEvents f30956a = null;

    public void clearCallbacks() {
    }

    public void handleFailure(int i, String str) {
    }

    public boolean isGetRequest() {
        return false;
    }

    public boolean shouldRetryOnFail() {
        return true;
    }

    public ServerRequestActionCompleted(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public void onRequestSucceeded(io.branch.referral.ServerResponse r4, io.branch.referral.Branch r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r5 = r4.m26198a();
        if (r5 == 0) goto L_0x0076;
    L_0x0006:
        r5 = r4.m26198a();
        r0 = io.branch.referral.Defines.Jsonkey.BranchViewData;
        r0 = r0.bc;
        r5 = r5.has(r0);
        if (r5 == 0) goto L_0x0076;
    L_0x0014:
        r5 = io.branch.referral.Branch.m31871a();
        r5 = r5.f30933d;
        if (r5 == 0) goto L_0x0076;
    L_0x001c:
        r5 = io.branch.referral.Branch.m31871a();
        r5 = r5.f30933d;
        r5 = r5.get();
        if (r5 == 0) goto L_0x0076;
    L_0x0028:
        r5 = "";
        r0 = r3.getPost();	 Catch:{ JSONException -> 0x006d }
        if (r0 == 0) goto L_0x0043;	 Catch:{ JSONException -> 0x006d }
    L_0x0030:
        r1 = io.branch.referral.Defines.Jsonkey.Event;	 Catch:{ JSONException -> 0x006d }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x006d }
        r1 = r0.has(r1);	 Catch:{ JSONException -> 0x006d }
        if (r1 == 0) goto L_0x0043;	 Catch:{ JSONException -> 0x006d }
    L_0x003a:
        r1 = io.branch.referral.Defines.Jsonkey.Event;	 Catch:{ JSONException -> 0x006d }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x006d }
        r0 = r0.getString(r1);	 Catch:{ JSONException -> 0x006d }
        r5 = r0;	 Catch:{ JSONException -> 0x006d }
    L_0x0043:
        r0 = io.branch.referral.Branch.m31871a();	 Catch:{ JSONException -> 0x006d }
        r0 = r0.f30933d;	 Catch:{ JSONException -> 0x006d }
        if (r0 == 0) goto L_0x006c;	 Catch:{ JSONException -> 0x006d }
    L_0x004b:
        r0 = io.branch.referral.Branch.m31871a();	 Catch:{ JSONException -> 0x006d }
        r0 = r0.f30933d;	 Catch:{ JSONException -> 0x006d }
        r0 = r0.get();	 Catch:{ JSONException -> 0x006d }
        r0 = (android.app.Activity) r0;	 Catch:{ JSONException -> 0x006d }
        r4 = r4.m26198a();	 Catch:{ JSONException -> 0x006d }
        r1 = io.branch.referral.Defines.Jsonkey.BranchViewData;	 Catch:{ JSONException -> 0x006d }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x006d }
        r4 = r4.getJSONObject(r1);	 Catch:{ JSONException -> 0x006d }
        r1 = io.branch.referral.BranchViewHandler.m26121a();	 Catch:{ JSONException -> 0x006d }
        r2 = r3.f30956a;	 Catch:{ JSONException -> 0x006d }
        r1.m26135a(r4, r5, r0, r2);	 Catch:{ JSONException -> 0x006d }
    L_0x006c:
        return;
    L_0x006d:
        r4 = r3.f30956a;
        if (r4 == 0) goto L_0x0076;
    L_0x0071:
        r4 = r3.f30956a;
        r4.mo5546d(r5);
    L_0x0076:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestActionCompleted.onRequestSucceeded(io.branch.referral.ServerResponse, io.branch.referral.Branch):void");
    }

    public boolean handleErrors(Context context) {
        if (super.doesAppHasInternetPermission(context) != null) {
            return null;
        }
        Log.i("BranchSDK", "Trouble executing your request. Please add 'android.permission.INTERNET' in your applications manifest file");
        return true;
    }
}
