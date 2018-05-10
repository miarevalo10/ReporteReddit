package com.instabug.bug.view.actionList.service;

import com.instabug.bug.settings.C0485a;
import com.instabug.library.network.NetworkManager;
import com.instabug.library.network.RequestResponse;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONArray;
import rx.Subscriber;

/* compiled from: ReportCategoriesServiceHelper */
public class C0504a {
    private static C0504a f9188b;
    NetworkManager f9189a = new NetworkManager();

    /* compiled from: ReportCategoriesServiceHelper */
    class C16281 extends Subscriber<RequestResponse> {
        final /* synthetic */ C0504a f18513a;

        C16281(C0504a c0504a) {
            this.f18513a = c0504a;
        }

        public final /* synthetic */ void a_(Object obj) {
            RequestResponse requestResponse = (RequestResponse) obj;
            StringBuilder stringBuilder = new StringBuilder("getReportCategories request onNext, Response code: ");
            stringBuilder.append(requestResponse.getResponseCode());
            stringBuilder.append(", Response body: ");
            stringBuilder.append(requestResponse.getResponseBody());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            C0504a.m7839a(System.currentTimeMillis());
            String str = (String) requestResponse.getResponseBody();
            try {
                if (new JSONArray(str).length() == 0) {
                    C0504a.m7840a((String) null);
                } else {
                    C0504a.m7840a(str);
                }
            } catch (Object obj2) {
                obj2.printStackTrace();
            }
        }

        public final void aV_() {
            InstabugSDKLogger.m8356d(this, "getReportCategories request started");
        }

        public final void m19377b() {
            InstabugSDKLogger.m8356d(this, "getReportCategories request completed");
        }

        public final void m19376a(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("getReportCategories request got error: ");
            stringBuilder.append(th.getMessage());
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
        }
    }

    public static C0504a m7838a() {
        if (f9188b == null) {
            f9188b = new C0504a();
        }
        return f9188b;
    }

    private C0504a() {
    }

    static long m7841b() {
        C0485a.m7793a();
        return C0485a.m7827r();
    }

    static /* synthetic */ void m7839a(long j) {
        C0485a.m7793a();
        C0485a.m7805b(j);
    }

    static /* synthetic */ void m7840a(String str) {
        C0485a.m7793a();
        C0485a.m7801a(str);
    }
}
