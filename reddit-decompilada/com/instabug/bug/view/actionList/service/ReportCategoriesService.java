package com.instabug.bug.view.actionList.service;

import android.content.Context;
import android.content.Intent;
import com.instabug.bug.view.actionList.service.C0504a.C16281;
import com.instabug.library.network.InstabugNetworkBasedBackgroundService;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.util.InstabugSDKLogger;
import rx.Observable;

public class ReportCategoriesService extends InstabugNetworkBasedBackgroundService {
    public static void m19375a(Context context) {
        if (System.currentTimeMillis() - C0504a.m7841b() > 86400000) {
            context.startService(new Intent(context, ReportCategoriesService.class));
        }
    }

    protected void runBackgroundTask() throws Exception {
        C0504a a = C0504a.m7838a();
        InstabugSDKLogger.m8356d(a, "Getting enabled features for this application");
        Observable.a(new C16281(a), a.f9189a.doRequest(a.f9189a.buildRequestWithoutUUID(this, Endpoint.ReportCategories, RequestMethod.Get)));
    }
}
