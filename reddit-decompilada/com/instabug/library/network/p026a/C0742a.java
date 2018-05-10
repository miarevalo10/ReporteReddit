package com.instabug.library.network.p026a;

import com.instabug.library.network.NetworkManager;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.RequestResponse;
import com.instabug.library.util.InstabugSDKLogger;
import rx.Subscriber;

/* compiled from: FeaturesService */
public class C0742a {
    private static C0742a f9837b;
    public NetworkManager f9838a = new NetworkManager();

    /* compiled from: FeaturesService */
    class C16621 extends Subscriber<RequestResponse> {
        final /* synthetic */ Callbacks f18574a;
        final /* synthetic */ C0742a f18575b;

        public C16621(C0742a c0742a, Callbacks callbacks) {
            this.f18575b = c0742a;
            this.f18574a = callbacks;
        }

        public final /* synthetic */ void a_(Object obj) {
            RequestResponse requestResponse = (RequestResponse) obj;
            StringBuilder stringBuilder = new StringBuilder("getAppFeatures request onNext, Response code: ");
            stringBuilder.append(requestResponse.getResponseCode());
            stringBuilder.append(", Response body: ");
            stringBuilder.append(requestResponse.getResponseBody());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            this.f18574a.onSucceeded((String) requestResponse.getResponseBody());
        }

        public final void aV_() {
            InstabugSDKLogger.m8356d(this, "getAppFeatures request started");
        }

        public final void m19510b() {
            InstabugSDKLogger.m8356d(this, "getAppFeatures request completed");
        }

        public final void m19509a(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("getAppFeatures request got error: ");
            stringBuilder.append(th.getMessage());
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            this.f18574a.onFailed(th);
        }
    }

    public static C0742a m8305a() {
        if (f9837b == null) {
            f9837b = new C0742a();
        }
        return f9837b;
    }

    private C0742a() {
    }
}
