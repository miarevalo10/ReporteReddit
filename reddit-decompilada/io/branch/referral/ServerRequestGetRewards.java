package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch.BranchReferralStateChangedListener;
import org.json.JSONException;
import org.json.JSONObject;

class ServerRequestGetRewards extends ServerRequest {
    BranchReferralStateChangedListener f30963a;

    public boolean isGetRequest() {
        return true;
    }

    public ServerRequestGetRewards(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public String getRequestUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.getRequestUrl());
        stringBuilder.append(PrefHelper.m26170d("bnc_identity_id"));
        return stringBuilder.toString();
    }

    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        branch = serverResponse.m26198a().keys();
        while (branch.hasNext()) {
            String str = (String) branch.next();
            try {
                int i = serverResponse.m26198a().getInt(str);
                PrefHelper.m26159b(str);
                PrefHelper.m26153a(str, i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void handleFailure(int i, String str) {
        if (this.f30963a != null) {
            StringBuilder stringBuilder = new StringBuilder("Trouble retrieving user credits. ");
            stringBuilder.append(str);
            BranchError branchError = new BranchError(stringBuilder.toString(), i);
        }
    }

    public boolean handleErrors(Context context) {
        if (super.doesAppHasInternetPermission(context) != null) {
            return null;
        }
        if (this.f30963a != null) {
            context = new BranchError("Trouble retrieving user credits.", -102);
        }
        return true;
    }

    public void clearCallbacks() {
        this.f30963a = null;
    }
}
