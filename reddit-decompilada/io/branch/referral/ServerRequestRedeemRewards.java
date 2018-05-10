package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch.BranchReferralStateChangedListener;
import io.branch.referral.Defines.Jsonkey;
import org.json.JSONObject;

class ServerRequestRedeemRewards extends ServerRequest {
    BranchReferralStateChangedListener f30969a;
    int f30970b = null;

    public boolean isGetRequest() {
        return false;
    }

    public ServerRequestRedeemRewards(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public boolean handleErrors(Context context) {
        if (super.doesAppHasInternetPermission(context) == null) {
            if (this.f30969a != null) {
                context = new BranchError("Trouble redeeming rewards.", -102);
            }
            return true;
        } else if (this.f30970b > null) {
            return null;
        } else {
            if (this.f30969a != null) {
                context = new BranchError("Trouble redeeming rewards.", -107);
            }
            return true;
        }
    }

    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        serverResponse = getPost();
        branch = null;
        if (serverResponse != null && serverResponse.has(Jsonkey.Bucket.bc) && serverResponse.has(Jsonkey.Amount.bc)) {
            try {
                int i = serverResponse.getInt(Jsonkey.Amount.bc);
                String string = serverResponse.getString(Jsonkey.Bucket.bc);
                if (i > 0) {
                    branch = true;
                }
                PrefHelper.m26153a(string, PrefHelper.m26159b(string) - i);
            } catch (ServerResponse serverResponse2) {
                serverResponse2.printStackTrace();
            }
        }
        if (this.f30969a != null && r4 == null) {
            serverResponse2 = new BranchError("Trouble redeeming rewards.", -107);
        }
    }

    public void handleFailure(int i, String str) {
        if (this.f30969a != null) {
            StringBuilder stringBuilder = new StringBuilder("Trouble redeeming rewards. ");
            stringBuilder.append(str);
            BranchError branchError = new BranchError(stringBuilder.toString(), i);
        }
    }

    public void clearCallbacks() {
        this.f30969a = null;
    }
}
