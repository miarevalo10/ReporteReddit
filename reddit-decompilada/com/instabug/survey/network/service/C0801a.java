package com.instabug.survey.network.service;

import com.facebook.stetho.server.http.HttpStatus;
import com.instabug.library.network.NetworkManager;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.RequestResponse;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONArray;
import rx.Subscriber;

/* compiled from: SurveysService */
public class C0801a {
    private static C0801a f9966b;
    public NetworkManager f9967a = new NetworkManager();

    /* compiled from: SurveysService */
    class C16691 extends Subscriber<RequestResponse> {
        final /* synthetic */ Callbacks f18587a;
        final /* synthetic */ C0801a f18588b;

        public C16691(C0801a c0801a, Callbacks callbacks) {
            this.f18588b = c0801a;
            this.f18587a = callbacks;
        }

        public final /* synthetic */ void a_(Object obj) {
            RequestResponse requestResponse = (RequestResponse) obj;
            String simpleName = C0801a.class.getSimpleName();
            StringBuilder stringBuilder = new StringBuilder("fetchingSurveysRequest onNext, Response code: ");
            stringBuilder.append(requestResponse.getResponseCode());
            stringBuilder.append("Response body: ");
            stringBuilder.append(requestResponse.getResponseBody());
            InstabugSDKLogger.m8360v(simpleName, stringBuilder.toString());
            if (requestResponse.getResponseCode() == HttpStatus.HTTP_OK) {
                try {
                    this.f18587a.onSucceeded(new JSONArray((String) requestResponse.getResponseBody()));
                    return;
                } catch (Object obj2) {
                    simpleName = C0801a.class.getSimpleName();
                    stringBuilder = new StringBuilder("submittingSurveyRequest got JSONException: ");
                    stringBuilder.append(obj2.getMessage());
                    InstabugSDKLogger.m8358e(simpleName, stringBuilder.toString(), obj2);
                    this.f18587a.onFailed(obj2);
                    return;
                }
            }
            Callbacks callbacks = this.f18587a;
            StringBuilder stringBuilder2 = new StringBuilder("Fetching Surveys got error with response code:");
            stringBuilder2.append(requestResponse.getResponseCode());
            callbacks.onFailed(new Throwable(stringBuilder2.toString()));
        }

        public final void aV_() {
            InstabugSDKLogger.m8360v(C0801a.class.getSimpleName(), "fetchingSurveysRequest started");
        }

        public final void m19526b() {
            InstabugSDKLogger.m8360v(C0801a.class.getSimpleName(), "fetchingSurveysRequest completed");
        }

        public final void m19525a(Throwable th) {
            String simpleName = C0801a.class.getSimpleName();
            StringBuilder stringBuilder = new StringBuilder("fetchingSurveysRequest got error: ");
            stringBuilder.append(th.getMessage());
            InstabugSDKLogger.m8358e(simpleName, stringBuilder.toString(), th);
            this.f18587a.onFailed(th);
        }
    }

    /* compiled from: SurveysService */
    class C16702 extends Subscriber<RequestResponse> {
        final /* synthetic */ Callbacks f18589a;
        final /* synthetic */ C0801a f18590b;

        C16702(C0801a c0801a, Callbacks callbacks) {
            this.f18590b = c0801a;
            this.f18589a = callbacks;
        }

        public final /* synthetic */ void a_(Object obj) {
            RequestResponse requestResponse = (RequestResponse) obj;
            String simpleName = C0801a.class.getSimpleName();
            StringBuilder stringBuilder = new StringBuilder("submittingSurveyRequest onNext, Response code: ");
            stringBuilder.append(requestResponse.getResponseCode());
            stringBuilder.append("Response body: ");
            stringBuilder.append(requestResponse.getResponseBody());
            InstabugSDKLogger.m8360v(simpleName, stringBuilder.toString());
            if (requestResponse.getResponseCode() == HttpStatus.HTTP_OK) {
                this.f18589a.onSucceeded(Boolean.valueOf(true));
                return;
            }
            this.f18589a.onSucceeded(Boolean.valueOf(false));
            Callbacks callbacks = this.f18589a;
            StringBuilder stringBuilder2 = new StringBuilder("submittingSurveyRequest got error with response code:");
            stringBuilder2.append(requestResponse.getResponseCode());
            callbacks.onFailed(new Throwable(stringBuilder2.toString()));
        }

        public final void aV_() {
            InstabugSDKLogger.m8360v(this, "submittingSurveyRequest started");
        }

        public final void m19528b() {
            InstabugSDKLogger.m8360v(C0801a.class.getSimpleName(), "submittingSurveyRequest completed");
        }

        public final void m19527a(Throwable th) {
            String simpleName = C0801a.class.getSimpleName();
            StringBuilder stringBuilder = new StringBuilder("submittingSurveyRequest got error: ");
            stringBuilder.append(th.getMessage());
            InstabugSDKLogger.m8358e(simpleName, stringBuilder.toString(), th);
            this.f18589a.onFailed(th);
        }
    }

    private C0801a() {
    }

    public static C0801a m8428a() {
        if (f9966b == null) {
            f9966b = new C0801a();
        }
        return f9966b;
    }
}
