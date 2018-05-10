package com.instabug.library.analytics.network;

import android.content.Context;
import com.instabug.library.analytics.AnalyticsObserver;
import com.instabug.library.analytics.model.Api;
import com.instabug.library.analytics.network.C0599a.C16461;
import com.instabug.library.analytics.util.C0600a;
import com.instabug.library.model.State;
import com.instabug.library.network.InstabugNetworkBasedBackgroundService;
import com.instabug.library.network.Request;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import rx.Observable;

public class InstabugAnalyticsUploaderService extends InstabugNetworkBasedBackgroundService {

    class C13431 implements Callbacks<Boolean, Throwable> {
        final /* synthetic */ InstabugAnalyticsUploaderService f15443a;

        C13431(InstabugAnalyticsUploaderService instabugAnalyticsUploaderService) {
            this.f15443a = instabugAnalyticsUploaderService;
        }

        public /* synthetic */ void onFailed(Object obj) {
            Throwable th = (Throwable) obj;
            InstabugSDKLogger.m8358e(InstabugAnalyticsUploaderService.class, th.getMessage(), th);
        }

        public /* synthetic */ void onSucceeded(Object obj) {
            AnalyticsObserver.setLastUploadedAt(System.currentTimeMillis(), this.f15443a);
            try {
                C0600a.m8014a();
                C0600a.m8017c();
            } catch (Object obj2) {
                InstabugSDKLogger.m8358e(InstabugAnalyticsUploaderService.class, obj2.getMessage(), obj2);
            }
        }
    }

    protected void runBackgroundTask() throws Exception {
        if (System.currentTimeMillis() - AnalyticsObserver.getLastUploadedAt(this) > 86400000) {
            ArrayList b = C0600a.m8016b();
            if (b.size() > 0) {
                C0599a a = C0599a.m8013a();
                Callbacks c13431 = new C13431(this);
                InstabugSDKLogger.m8356d(a, "starting upload SDK analytics");
                Request buildRequest = a.f9398a.buildRequest((Context) this, Endpoint.Analytics, RequestMethod.Post);
                buildRequest.addParameter(State.KEY_SDK_VERSION, "4.11.1");
                buildRequest.addParameter("platform", "android");
                buildRequest.addParameter("method_logs", Api.toJson(b));
                Observable.a(new C16461(a, c13431), a.f9398a.doRequest(buildRequest));
            }
        }
    }
}
