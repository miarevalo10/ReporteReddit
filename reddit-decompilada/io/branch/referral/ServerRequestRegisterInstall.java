package io.branch.referral;

import android.content.Context;
import io.branch.referral.Branch.BranchReferralInitListener;
import io.branch.referral.Defines.Jsonkey;
import io.branch.referral.Defines.RequestPath;
import org.json.JSONException;
import org.json.JSONObject;

class ServerRequestRegisterInstall extends ServerRequestInitSession {
    BranchReferralInitListener f34671a;
    final SystemObserver f34672b;

    public final String mo6588b() {
        return "install";
    }

    public boolean isGetRequest() {
        return false;
    }

    public ServerRequestRegisterInstall(Context context, BranchReferralInitListener branchReferralInitListener, SystemObserver systemObserver, String str) {
        super(context, RequestPath.RegisterInstall.f24623l);
        this.f34672b = systemObserver;
        this.f34671a = branchReferralInitListener;
        context = new JSONObject();
        try {
            if (str.equals("bnc_no_value") == null) {
                context.put(Jsonkey.LinkClickID.bc, str);
            }
            if (systemObserver.m26217b().equals("bnc_no_value") == null) {
                context.put(Jsonkey.AppVersion.bc, systemObserver.m26217b());
            }
            if (PrefHelper.m26179j() != null) {
                branchReferralInitListener = systemObserver.m26215a(systemObserver.f24673c.getPackageName());
                if (branchReferralInitListener.equals("bnc_no_value") == null) {
                    context.put(Jsonkey.URIScheme.bc, branchReferralInitListener);
                }
            }
            context.put(Jsonkey.FaceBookAppLinkChecked.bc, PrefHelper.m26172e("bnc_triggered_by_fb_app_link"));
            context.put(Jsonkey.IsReferrable.bc, PrefHelper.m26171e());
            context.put(Jsonkey.Update.bc, systemObserver.m26218i());
            context.put(Jsonkey.Debug.bc, PrefHelper.m26179j());
            setPost(context);
        } catch (Context context2) {
            context2.printStackTrace();
            this.constructError_ = true;
        }
    }

    public ServerRequestRegisterInstall(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.f34672b = new SystemObserver(context);
    }

    public final boolean mo6587a() {
        return this.f34671a != null;
    }

    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        super.onRequestSucceeded(serverResponse, branch);
        try {
            PrefHelper.m26156a("bnc_user_url", serverResponse.m26198a().getString(Jsonkey.Link.bc));
            if (serverResponse.m26198a().has(Jsonkey.Data.bc)) {
                JSONObject jSONObject = new JSONObject(serverResponse.m26198a().getString(Jsonkey.Data.bc));
                if (jSONObject.has(Jsonkey.Clicked_Branch_Link.bc) && jSONObject.getBoolean(Jsonkey.Clicked_Branch_Link.bc) && PrefHelper.m26170d("bnc_install_params").equals("bnc_no_value") && PrefHelper.m26171e() == 1) {
                    PrefHelper.m26156a("bnc_install_params", serverResponse.m26198a().getString(Jsonkey.Data.bc));
                }
            }
            if (serverResponse.m26198a().has(Jsonkey.LinkClickID.bc)) {
                PrefHelper.m26156a("bnc_link_click_id", serverResponse.m26198a().getString(Jsonkey.LinkClickID.bc));
            } else {
                PrefHelper.m26156a("bnc_link_click_id", "bnc_no_value");
            }
            if (serverResponse.m26198a().has(Jsonkey.Data.bc)) {
                PrefHelper.m26156a("bnc_session_params", serverResponse.m26198a().getString(Jsonkey.Data.bc));
            } else {
                PrefHelper.m26156a("bnc_session_params", "bnc_no_value");
            }
            if (this.f34671a != null) {
                this.f34671a.mo4560a(branch.m31922e(), null);
            }
            PrefHelper.m26156a("bnc_app_version", this.f34672b.m26217b());
        } catch (Exception e) {
            e.printStackTrace();
        }
        m31926a(serverResponse, branch);
    }

    public void handleFailure(int i, String str) {
        if (this.f34671a != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_message", "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            BranchReferralInitListener branchReferralInitListener = this.f34671a;
            StringBuilder stringBuilder = new StringBuilder("Trouble initializing Branch. ");
            stringBuilder.append(str);
            branchReferralInitListener.mo4560a(jSONObject, new BranchError(stringBuilder.toString(), i));
        }
    }

    public boolean handleErrors(Context context) {
        if (super.doesAppHasInternetPermission(context) != null) {
            return null;
        }
        if (this.f34671a != null) {
            this.f34671a.mo4560a(null, new BranchError("Trouble initializing Branch.", -102));
        }
        return true;
    }

    public void clearCallbacks() {
        this.f34671a = null;
    }
}
