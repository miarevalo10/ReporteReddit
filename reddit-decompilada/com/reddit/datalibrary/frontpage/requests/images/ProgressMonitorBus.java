package com.reddit.datalibrary.frontpage.requests.images;

import de.greenrobot.event.EventBus;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;

public class ProgressMonitorBus {
    private static final EventBus f10927a = new EventBus();

    static class ProgressChangedEvent {
        public String f10923a;
        int f10924b = null;

        ProgressChangedEvent(String str) {
            this.f10923a = str;
        }
    }

    enum TAG {
        ;

        private TAG(String str) {
        }
    }

    public static EventBus m9343a() {
        return f10927a;
    }

    public static Interceptor m9345b() {
        return ProgressMonitorBus$$Lambda$0.f16346a;
    }

    static final /* synthetic */ Response m9344a(Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        return request.tag() == TAG.f10925a ? proceed.newBuilder().body(new ProgressResponseBody(proceed.body(), chain.request().url().toString())).build() : proceed;
    }
}
