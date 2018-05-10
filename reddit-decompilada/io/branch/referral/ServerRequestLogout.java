package io.branch.referral;

import android.content.Context;
import android.util.Log;
import io.branch.referral.Branch.LogoutStatusListener;
import io.branch.referral.Defines.Jsonkey;
import java.util.ArrayList;
import org.json.JSONObject;

class ServerRequestLogout extends ServerRequest {
    private LogoutStatusListener f30968a;

    public boolean isGetRequest() {
        return false;
    }

    public ServerRequestLogout(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        try {
            PrefHelper.m26156a("bnc_session_id", serverResponse.m26198a().getString(Jsonkey.SessionID.bc));
            PrefHelper.m26156a("bnc_identity_id", serverResponse.m26198a().getString(Jsonkey.IdentityID.bc));
            PrefHelper.m26156a("bnc_user_url", serverResponse.m26198a().getString(Jsonkey.Link.bc));
            PrefHelper.m26156a("bnc_install_params", "bnc_no_value");
            PrefHelper.m26156a("bnc_session_params", "bnc_no_value");
            PrefHelper.m26156a("bnc_identity", "bnc_no_value");
            serverResponse = PrefHelper.m26174f().iterator();
            while (serverResponse.hasNext() != null) {
                PrefHelper.m26153a((String) serverResponse.next(), 0);
            }
            PrefHelper.m26157a(new ArrayList());
            serverResponse = PrefHelper.m26175g().iterator();
            while (serverResponse.hasNext() != null) {
                String str = (String) serverResponse.next();
                ArrayList g = PrefHelper.m26175g();
                if (!g.contains(str)) {
                    g.add(str);
                    PrefHelper.m26162b(g);
                }
                StringBuilder stringBuilder = new StringBuilder("bnc_total_base_");
                stringBuilder.append(str);
                PrefHelper.m26167c(stringBuilder.toString(), 0);
                stringBuilder = new StringBuilder("bnc_balance_base_");
                stringBuilder.append(str);
                PrefHelper.m26167c(stringBuilder.toString(), 0);
            }
            PrefHelper.m26162b(new ArrayList());
            if (this.f30968a == null) {
            }
        } catch (ServerResponse serverResponse2) {
            serverResponse2.printStackTrace();
            if (this.f30968a != null) {
            }
        }
    }

    public void handleFailure(int i, String str) {
        if (this.f30968a != null) {
            StringBuilder stringBuilder = new StringBuilder("Logout error. ");
            stringBuilder.append(str);
            BranchError branchError = new BranchError(stringBuilder.toString(), i);
        }
    }

    public boolean handleErrors(Context context) {
        if (super.doesAppHasInternetPermission(context) != null) {
            return null;
        }
        Log.i("BranchSDK", "Trouble executing your request. Please add 'android.permission.INTERNET' in your applications manifest file");
        if (this.f30968a != null) {
            context = new BranchError("Logout failed", -102);
        }
        return true;
    }

    public void clearCallbacks() {
        this.f30968a = null;
    }
}
