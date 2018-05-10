package com.instabug.library.network.worker.fetcher;

import android.content.Context;
import com.instabug.library.C0645b;
import com.instabug.library.C0645b.C13533;
import com.instabug.library.network.InstabugNetworkBasedBackgroundService;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.network.p026a.C0742a;
import com.instabug.library.network.p026a.C0742a.C16621;
import com.instabug.library.util.InstabugSDKLogger;
import rx.Observable;

public class InstabugFeaturesFetcherService extends InstabugNetworkBasedBackgroundService {
    protected void runBackgroundTask() throws Exception {
        C0645b a = C0645b.m8104a();
        try {
            if (System.currentTimeMillis() - C0645b.m8107b((Context) this) > 86400000) {
                InstabugSDKLogger.m8356d(a, "lLast fetched at is more than 24h, retrieve it again");
                C0742a a2 = C0742a.m8305a();
                Callbacks c13533 = new C13533(a, this);
                InstabugSDKLogger.m8356d(a2, "Getting enabled features for this application");
                Observable.a(new C16621(a2, c13533), a2.f9838a.doRequest(a2.f9838a.buildRequest((Context) this, Endpoint.AppSettings, RequestMethod.Get)));
            }
        } catch (Throwable e) {
            InstabugSDKLogger.m8358e(C0645b.class, "Something went wrong while do fetching features request", e);
        }
    }
}
