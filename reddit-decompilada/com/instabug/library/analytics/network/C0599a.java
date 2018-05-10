package com.instabug.library.analytics.network;

import com.instabug.library.network.NetworkManager;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.RequestResponse;
import com.instabug.library.util.InstabugSDKLogger;
import rx.Subscriber;

/* compiled from: AnalyticsService */
class C0599a {
    private static C0599a f9397b;
    NetworkManager f9398a = new NetworkManager();

    /* compiled from: AnalyticsService */
    class C16461 extends Subscriber<RequestResponse> {
        final /* synthetic */ Callbacks f18549a;
        final /* synthetic */ C0599a f18550b;

        C16461(C0599a c0599a, Callbacks callbacks) {
            this.f18550b = c0599a;
            this.f18549a = callbacks;
        }

        public final /* synthetic */ void a_(Object obj) {
            RequestResponse requestResponse = (RequestResponse) obj;
            StringBuilder stringBuilder = new StringBuilder("analyticsRequest onNext, Response code: ");
            stringBuilder.append(requestResponse.getResponseCode());
            stringBuilder.append(", Response body: ");
            stringBuilder.append(requestResponse.getResponseBody());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            this.f18549a.onSucceeded(Boolean.valueOf(true));
        }

        public final void aV_() {
            InstabugSDKLogger.m8360v(this, "analyticsRequest started");
        }

        public final void m19470b() {
            InstabugSDKLogger.m8360v(this, "analyticsRequest completed");
        }

        public final void m19469a(Throwable th) {
            this.f18549a.onFailed(th);
        }
    }

    public static C0599a m8013a() {
        if (f9397b == null) {
            f9397b = new C0599a();
        }
        return f9397b;
    }

    private C0599a() {
    }
}
