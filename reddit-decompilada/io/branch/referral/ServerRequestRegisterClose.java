package io.branch.referral;

import android.content.Context;
import android.util.Log;
import io.branch.indexing.ContentDiscoverer;
import io.branch.referral.Defines.Jsonkey;
import io.branch.referral.Defines.RequestPath;
import org.json.JSONObject;

class ServerRequestRegisterClose extends ServerRequest {
    public void clearCallbacks() {
    }

    public void handleFailure(int i, String str) {
    }

    public boolean isGetRequest() {
        return false;
    }

    public ServerRequestRegisterClose(Context context) {
        super(context, RequestPath.RegisterClose.f24623l);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Jsonkey.DeviceFingerprintID.bc, PrefHelper.m26170d("bnc_device_fingerprint_id"));
            jSONObject.put(Jsonkey.IdentityID.bc, PrefHelper.m26170d("bnc_identity_id"));
            jSONObject.put(Jsonkey.SessionID.bc, PrefHelper.m26170d("bnc_session_id"));
            if (!PrefHelper.m26170d("bnc_link_click_id").equals("bnc_no_value")) {
                jSONObject.put(Jsonkey.LinkClickID.bc, PrefHelper.m26170d("bnc_link_click_id"));
            }
            context = ContentDiscoverer.m26068a().m26086a(context);
            if (context != null) {
                jSONObject.put(Jsonkey.ContentDiscovery.bc, context);
            }
            if (DeviceInfo.m26138a() != null) {
                jSONObject.put(Jsonkey.AppVersion.bc, DeviceInfo.m26138a().f24636l);
            }
            setPost(jSONObject);
        } catch (Context context2) {
            context2.printStackTrace();
            this.constructError_ = true;
        }
    }

    public ServerRequestRegisterClose(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    public boolean handleErrors(Context context) {
        if (super.doesAppHasInternetPermission(context) != null) {
            return null;
        }
        Log.i("BranchSDK", "Trouble executing your request. Please add 'android.permission.INTERNET' in your applications manifest file");
        return true;
    }

    public void onRequestSucceeded(ServerResponse serverResponse, Branch branch) {
        PrefHelper.m26156a("bnc_session_params", "bnc_no_value");
    }
}
