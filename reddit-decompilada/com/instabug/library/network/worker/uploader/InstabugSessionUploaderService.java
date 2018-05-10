package com.instabug.library.network.worker.uploader;

import android.content.Context;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.internal.storage.cache.SessionsCacheManager;
import com.instabug.library.model.Session;
import com.instabug.library.model.State;
import com.instabug.library.network.InstabugNetworkBasedBackgroundService;
import com.instabug.library.network.Request;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.network.p026a.C0745d;
import com.instabug.library.network.p026a.C0745d.C16651;
import com.instabug.library.user.C0770a;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.Observable;

public class InstabugSessionUploaderService extends InstabugNetworkBasedBackgroundService {
    protected void runBackgroundTask() throws IOException, JSONException {
        List<Session> sessions = SessionsCacheManager.getSessions();
        StringBuilder stringBuilder = new StringBuilder("Found ");
        stringBuilder.append(sessions.size());
        stringBuilder.append(" sessions in cache");
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        for (final Session session : sessions) {
            StringBuilder stringBuilder2 = new StringBuilder("Syncing session ");
            stringBuilder2.append(session);
            InstabugSDKLogger.m8356d(this, stringBuilder2.toString());
            C0745d a = C0745d.m8309a();
            Callbacks c13931 = new Callbacks<Boolean, Throwable>(this) {
                final /* synthetic */ InstabugSessionUploaderService f15540b;

                public /* synthetic */ void onFailed(Object obj) {
                    obj = this.f15540b;
                    StringBuilder stringBuilder = new StringBuilder("Something went wrong while sending session: ");
                    stringBuilder.append(session);
                    InstabugSDKLogger.m8356d(obj, stringBuilder.toString());
                }

                public /* synthetic */ void onSucceeded(Object obj) {
                    obj = this.f15540b;
                    StringBuilder stringBuilder = new StringBuilder("Session ");
                    stringBuilder.append(session);
                    stringBuilder.append(" synced successfully");
                    InstabugSDKLogger.m8356d(obj, stringBuilder.toString());
                    obj = SessionsCacheManager.deleteSession(session);
                    InstabugSessionUploaderService instabugSessionUploaderService = this.f15540b;
                    StringBuilder stringBuilder2 = new StringBuilder("Session deleted: ");
                    stringBuilder2.append(obj);
                    InstabugSDKLogger.m8356d(instabugSessionUploaderService, stringBuilder2.toString());
                    SessionsCacheManager.saveCacheToDisk();
                }
            };
            InstabugSDKLogger.m8356d(a, "Sending session");
            Request buildRequest = a.f9844a.buildRequest((Context) this, Endpoint.SendSession, RequestMethod.Post);
            Request addParameter = buildRequest.addParameter(State.KEY_DEVICE, InstabugDeviceProperties.getDeviceType());
            String str = State.KEY_OS;
            StringBuilder stringBuilder3 = new StringBuilder("SDK Level ");
            stringBuilder3.append(Integer.toString(InstabugDeviceProperties.getCurrentOSLevel()));
            addParameter.addParameter(str, stringBuilder3.toString()).addParameter(State.KEY_APP_VERSION, InstabugDeviceProperties.getAppVersion(this)).addParameter(State.KEY_APP_PACKAGE_NAME, InstabugDeviceProperties.getPackageName(this)).addParameter(State.KEY_SDK_VERSION, "4.11.1").addParameter(State.KEY_EMAIL, C0770a.m8344b()).addParameter("name", C0770a.m8346c()).addParameter("started_at", String.valueOf(session.f15525b)).addParameter(State.KEY_DURATION, Long.valueOf(session.f15526c)).addParameter("custom_attributes", new JSONObject(session.f15527d)).addParameter(State.KEY_USER_EVENTS, new JSONArray(session.f15528e));
            if (session.f15524a != -1) {
                buildRequest.addParameter("session_number", Integer.valueOf(session.f15524a));
            }
            Observable.a(new C16651(a, c13931), a.f9844a.doRequest(buildRequest));
        }
    }
}
