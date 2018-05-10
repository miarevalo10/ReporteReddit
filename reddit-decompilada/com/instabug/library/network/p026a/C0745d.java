package com.instabug.library.network.p026a;

import com.facebook.stetho.server.http.HttpStatus;
import com.instabug.library.network.NetworkManager;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.RequestResponse;
import com.instabug.library.util.InstabugSDKLogger;
import rx.Subscriber;

/* compiled from: SessionService */
public class C0745d {
    private static C0745d f9843b;
    public NetworkManager f9844a = new NetworkManager();

    /* compiled from: SessionService */
    class C16651 extends Subscriber<RequestResponse> {
        final /* synthetic */ Callbacks f18581a;
        final /* synthetic */ C0745d f18582b;

        public C16651(C0745d c0745d, Callbacks callbacks) {
            this.f18582b = c0745d;
            this.f18581a = callbacks;
        }

        public final /* synthetic */ void a_(Object obj) {
            RequestResponse requestResponse = (RequestResponse) obj;
            StringBuilder stringBuilder = new StringBuilder("sendSession request onNext, Response code: ");
            stringBuilder.append(requestResponse.getResponseCode());
            stringBuilder.append(", Response body: ");
            stringBuilder.append(requestResponse.getResponseBody());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            if (requestResponse.getResponseCode() != HttpStatus.HTTP_OK || requestResponse.getResponseBody() == null) {
                this.f18581a.onSucceeded(Boolean.valueOf(false));
            } else {
                this.f18581a.onSucceeded(Boolean.valueOf(true));
            }
        }

        public final void aV_() {
            InstabugSDKLogger.m8356d(this, "sendSession request started");
        }

        public final void m19516b() {
            InstabugSDKLogger.m8356d(this, "sendSession request completed");
        }

        public final void m19515a(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("sendSession request got error: ");
            stringBuilder.append(th.getMessage());
            InstabugSDKLogger.m8356d(this, stringBuilder.toString());
            this.f18581a.onFailed(th);
        }
    }

    public static C0745d m8309a() {
        if (f9843b == null) {
            f9843b = new C0745d();
        }
        return f9843b;
    }

    private C0745d() {
    }
}
