package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch.BranchListResponseListener;
import org.json.JSONObject;

class ServerRequestGetRewardHistory extends ServerRequest {
    BranchListResponseListener f30962a;

    public boolean isGetRequest() {
        return false;
    }

    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
    }

    public ServerRequestGetRewardHistory(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public void handleFailure(int i, String str) {
        if (this.f30962a != null) {
            StringBuilder stringBuilder = new StringBuilder("Trouble retrieving user credit history. ");
            stringBuilder.append(str);
            BranchError branchError = new BranchError(stringBuilder.toString(), i);
        }
    }

    public boolean handleErrors(Context context) {
        if (super.doesAppHasInternetPermission(context) != null) {
            return null;
        }
        if (this.f30962a != null) {
            context = new BranchError("Trouble retrieving user credit history.", -102);
        }
        return true;
    }

    public void clearCallbacks() {
        this.f30962a = null;
    }
}
