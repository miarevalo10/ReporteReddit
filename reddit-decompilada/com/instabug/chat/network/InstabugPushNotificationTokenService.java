package com.instabug.chat.network;

import android.content.Context;
import com.instabug.chat.network.p008a.C0553a;
import com.instabug.chat.network.p008a.C0553a.C16376;
import com.instabug.chat.settings.C0554a;
import com.instabug.library.network.InstabugNetworkBasedBackgroundService;
import com.instabug.library.network.Request;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.IOException;
import org.json.JSONException;
import rx.Observable;

public class InstabugPushNotificationTokenService extends InstabugNetworkBasedBackgroundService {

    class C13141 implements Callbacks<String, Throwable> {
        final /* synthetic */ InstabugPushNotificationTokenService f15403a;

        C13141(InstabugPushNotificationTokenService instabugPushNotificationTokenService) {
            this.f15403a = instabugPushNotificationTokenService;
        }

        public /* synthetic */ void onSucceeded(Object obj) {
            if (((String) obj).equalsIgnoreCase("ok") != null) {
                C0554a.m7950f(true);
            } else {
                C0554a.m7950f(null);
            }
        }

        public /* synthetic */ void onFailed(Object obj) {
            C0554a.m7950f(null);
        }
    }

    protected void runBackgroundTask() throws Exception {
        StringBuilder stringBuilder;
        String l = C0554a.m7957l();
        try {
            C0553a a = C0553a.m7928a();
            Callbacks c13141 = new C13141(this);
            Request buildRequest = a.f9293a.buildRequest((Context) this, Endpoint.PushToken, RequestMethod.Post);
            buildRequest.addRequestBodyParameter("push_token", l);
            Observable.a(new C16376(a, c13141), a.f9293a.doRequest(buildRequest));
        } catch (JSONException e) {
            C0554a.m7950f(false);
            stringBuilder = new StringBuilder("sending push notification token got error: ");
            stringBuilder.append(e.getMessage());
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        } catch (IOException e2) {
            C0554a.m7950f(false);
            stringBuilder = new StringBuilder("sending push notification token got error: ");
            stringBuilder.append(e2.getMessage());
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        }
    }
}
