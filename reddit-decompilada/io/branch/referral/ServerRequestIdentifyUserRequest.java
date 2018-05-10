package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch.BranchReferralInitListener;
import io.branch.referral.Defines.Jsonkey;
import org.json.JSONException;
import org.json.JSONObject;

class ServerRequestIdentifyUserRequest extends ServerRequest {
    BranchReferralInitListener f30964a;
    String f30965b = null;

    public boolean isGetRequest() {
        return false;
    }

    public boolean shouldRetryOnFail() {
        return true;
    }

    public ServerRequestIdentifyUserRequest(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        try {
            if (getPost() != null && getPost().has(Jsonkey.Identity.bc)) {
                PrefHelper.m26156a("bnc_identity", getPost().getString(Jsonkey.Identity.bc));
            }
            PrefHelper.m26156a("bnc_identity_id", serverResponse.m26198a().getString(Jsonkey.IdentityID.bc));
            PrefHelper.m26156a("bnc_user_url", serverResponse.m26198a().getString(Jsonkey.Link.bc));
            if (serverResponse.m26198a().has(Jsonkey.ReferringData.bc)) {
                PrefHelper.m26156a("bnc_install_params", serverResponse.m26198a().getString(Jsonkey.ReferringData.bc));
            }
            if (this.f30964a != null) {
                serverResponse = this.f30964a;
                PrefHelper prefHelper = branch.f30931b;
                serverResponse.mo4560a(branch.m31913a(Branch.m31875a(PrefHelper.m26170d("bnc_install_params"))), null);
            }
        } catch (ServerResponse serverResponse2) {
            serverResponse2.printStackTrace();
        }
    }

    public void handleFailure(int i, String str) {
        if (this.f30964a != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_message", "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            BranchReferralInitListener branchReferralInitListener = this.f30964a;
            StringBuilder stringBuilder = new StringBuilder("Trouble setting the user alias. ");
            stringBuilder.append(str);
            branchReferralInitListener.mo4560a(jSONObject, new BranchError(stringBuilder.toString(), i));
        }
    }

    public boolean handleErrors(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r6 = super.doesAppHasInternetPermission(r6);
        r0 = 1;
        if (r6 != 0) goto L_0x001b;
    L_0x0007:
        r6 = r5.f30964a;
        if (r6 == 0) goto L_0x001a;
    L_0x000b:
        r6 = r5.f30964a;
        r1 = 0;
        r2 = new io.branch.referral.BranchError;
        r3 = "Trouble setting the user alias.";
        r4 = -102; // 0xffffffffffffff9a float:NaN double:NaN;
        r2.<init>(r3, r4);
        r6.mo4560a(r1, r2);
    L_0x001a:
        return r0;
    L_0x001b:
        r6 = r5.getPost();	 Catch:{ JSONException -> 0x003f }
        r1 = io.branch.referral.Defines.Jsonkey.Identity;	 Catch:{ JSONException -> 0x003f }
        r1 = r1.bc;	 Catch:{ JSONException -> 0x003f }
        r6 = r6.getString(r1);	 Catch:{ JSONException -> 0x003f }
        if (r6 == 0) goto L_0x003e;	 Catch:{ JSONException -> 0x003f }
    L_0x0029:
        r1 = r6.length();	 Catch:{ JSONException -> 0x003f }
        if (r1 == 0) goto L_0x003e;	 Catch:{ JSONException -> 0x003f }
    L_0x002f:
        r1 = "bnc_identity";	 Catch:{ JSONException -> 0x003f }
        r1 = io.branch.referral.PrefHelper.m26170d(r1);	 Catch:{ JSONException -> 0x003f }
        r6 = r6.equals(r1);	 Catch:{ JSONException -> 0x003f }
        if (r6 == 0) goto L_0x003c;
    L_0x003b:
        goto L_0x003e;
    L_0x003c:
        r6 = 0;
        return r6;
    L_0x003e:
        return r0;
    L_0x003f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: io.branch.referral.ServerRequestIdentifyUserRequest.handleErrors(android.content.Context):boolean");
    }

    public void clearCallbacks() {
        this.f30964a = null;
    }
}
