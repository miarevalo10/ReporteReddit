package com.instabug.survey.network.service;

import android.content.Context;
import com.instabug.library.network.InstabugNetworkBasedBackgroundService;
import com.instabug.library.network.Request;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.cache.SurveysCacheManager;
import com.instabug.survey.network.p030a.C0799a;
import com.instabug.survey.network.service.C0801a.C16702;
import com.instabug.survey.p027a.C1413c;
import java.util.List;
import rx.Observable;

public class InstabugSurveysSubmitterService extends InstabugNetworkBasedBackgroundService {
    protected void runBackgroundTask() throws Exception {
        InstabugSDKLogger.m8356d(this, "runBackgroundTask started");
        InstabugSDKLogger.m8356d(this, "submitSurveys started");
        List<C1413c> answeredAndNotSubmittedSurveys = SurveysCacheManager.getAnsweredAndNotSubmittedSurveys();
        StringBuilder stringBuilder = new StringBuilder("answeredSurveys size: ");
        stringBuilder.append(answeredAndNotSubmittedSurveys.size());
        InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        for (final C1413c c1413c : answeredAndNotSubmittedSurveys) {
            C0801a a = C0801a.m8428a();
            Callbacks c14181 = new Callbacks<Boolean, Throwable>(this) {
                final /* synthetic */ InstabugSurveysSubmitterService f15590b;

                public /* synthetic */ void onFailed(Object obj) {
                    Throwable th = (Throwable) obj;
                    InstabugSDKLogger.m8358e(this, th.getMessage(), th);
                }

                public /* synthetic */ void onSucceeded(Object obj) {
                    c1413c.f15579i = true;
                    SurveysCacheManager.saveCacheToDisk();
                }
            };
            InstabugSDKLogger.m8360v(a, "submitting survey");
            Request buildRequest = a.f9967a.buildRequest((Context) this, Endpoint.SubmitSurvey, RequestMethod.Post);
            buildRequest.setEndpoint(buildRequest.getEndpoint().replaceAll(":survey_id", String.valueOf(c1413c.f15571a)));
            C0799a.m8425a(buildRequest, c1413c);
            Observable.a(new C16702(a, c14181), a.f9967a.doRequest(buildRequest));
        }
    }
}
