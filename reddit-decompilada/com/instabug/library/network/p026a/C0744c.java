package com.instabug.library.network.p026a;

import com.instabug.library.network.C0748c;
import com.instabug.library.network.NetworkManager;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.RequestResponse;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.util.ScalarSynchronousObservable;

/* compiled from: MigrateUUIDService */
public class C0744c {
    private static C0744c f9841b;
    public NetworkManager f9842a = new NetworkManager();

    /* compiled from: MigrateUUIDService */
    class C13922 implements Func1<Observable<? extends Throwable>, Observable<?>> {
        final /* synthetic */ Callbacks f15537a;
        final /* synthetic */ C0744c f15538b;

        /* compiled from: MigrateUUIDService */
        class C13901 implements Func1<Integer, Observable<?>> {
            final /* synthetic */ C13922 f15535a;

            C13901(C13922 c13922) {
                this.f15535a = c13922;
            }

            public /* synthetic */ Object call(Object obj) {
                Integer num = (Integer) obj;
                if (SettingsManager.getInstance().shouldMakeUUIDMigrationRequest()) {
                    return Observable.a((long) Math.pow(2.718281828459045d, (double) num.intValue()), TimeUnit.SECONDS);
                }
                return Observable.b(new C0748c());
            }
        }

        /* compiled from: MigrateUUIDService */
        class C13912 implements Func2<Throwable, Integer, Integer> {
            final /* synthetic */ C13922 f15536a;

            C13912(C13922 c13922) {
                this.f15536a = c13922;
            }

            public final /* synthetic */ Object m15448a(Object obj, Object obj2) {
                Integer num = (Integer) obj2;
                this.f15536a.f15537a.onFailed((Throwable) obj);
                return num;
            }
        }

        public C13922(C0744c c0744c, Callbacks callbacks) {
            this.f15538b = c0744c;
            this.f15537a = callbacks;
        }

        public /* synthetic */ Object call(Object obj) {
            obj = Observable.a((Observable) obj, Observable.c(), new C13912(this));
            Func1 c13901 = new C13901(this);
            if (obj.getClass() == ScalarSynchronousObservable.class) {
                return ((ScalarSynchronousObservable) obj).c(c13901);
            }
            return Observable.a(obj.b(c13901));
        }
    }

    /* compiled from: MigrateUUIDService */
    class C16641 extends Subscriber<RequestResponse> {
        final /* synthetic */ Callbacks f18579a;
        final /* synthetic */ C0744c f18580b;

        public C16641(C0744c c0744c, Callbacks callbacks) {
            this.f18580b = c0744c;
            this.f18579a = callbacks;
        }

        public final /* synthetic */ void a_(Object obj) {
            RequestResponse requestResponse = (RequestResponse) obj;
            StringBuilder stringBuilder = new StringBuilder("migrateUUID request onNext, Response code: ");
            stringBuilder.append(requestResponse.getResponseCode());
            stringBuilder.append(", Response body: ");
            stringBuilder.append(requestResponse.getResponseBody());
            InstabugSDKLogger.m8360v(this, stringBuilder.toString());
            this.f18579a.onSucceeded((String) requestResponse.getResponseBody());
        }

        public final void aV_() {
            InstabugSDKLogger.m8356d(this, "migrateUUID request started");
        }

        public final void m19514b() {
            InstabugSDKLogger.m8356d(this, "migrateUUID request completed");
        }

        public final void m19513a(Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("migrateUUID request got error: ");
            stringBuilder.append(th.getMessage());
            InstabugSDKLogger.m8358e(this, stringBuilder.toString(), th);
            this.f18579a.onFailed(th);
        }
    }

    public static C0744c m8308a() {
        if (f9841b == null) {
            f9841b = new C0744c();
        }
        return f9841b;
    }

    private C0744c() {
    }
}
