package com.instabug.library.user;

import android.content.Context;
import android.util.Patterns;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.coreeventbus.C0655a;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent.User;
import com.instabug.library.core.plugin.C0657a;
import com.instabug.library.internal.storage.cache.CacheManager;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.network.NetworkManager;
import com.instabug.library.network.Request.Callbacks;
import com.instabug.library.network.Request.Endpoint;
import com.instabug.library.network.Request.RequestMethod;
import com.instabug.library.network.p026a.C0744c;
import com.instabug.library.network.p026a.C0744c.C13922;
import com.instabug.library.network.p026a.C0744c.C16641;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.C0774b;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.UUID;
import rx.Observable;
import rx.internal.operators.OnSubscribeRedo;
import rx.internal.util.InternalObservableUtils;
import rx.schedulers.Schedulers;

/* compiled from: UserManager */
public class C0770a {
    private C0770a() {
    }

    private static void m8341a(final Context context) {
        final String mD5Uuid = SettingsManager.getInstance().getMD5Uuid();
        if ((C0657a.m8159b() != 0) && SettingsManager.getInstance().isUserLoggedOut()) {
            SettingsManager.getInstance().setShouldMakeUUIDMigrationRequest(true);
            try {
                String uuid = SettingsManager.getInstance().getUuid();
                C0744c a = C0744c.m8308a();
                Callbacks c14011 = new Callbacks<String, Throwable>() {
                    public final /* synthetic */ void onFailed(Object obj) {
                        SettingsManager.getInstance().setShouldMakeUUIDMigrationRequest(true);
                    }

                    public final /* synthetic */ void onSucceeded(Object obj) {
                        C0770a.m8353g();
                        C0770a.m8349d(mD5Uuid);
                        SettingsManager.getInstance().setShouldMakeUUIDMigrationRequest(false);
                    }
                };
                context = a.f9842a.buildRequest(context, Endpoint.MigrateUUID, RequestMethod.put);
                context.addRequestBodyParameter("old_uuid", uuid);
                context.addRequestBodyParameter("new_uuid", mD5Uuid);
                context.addRequestBodyParameter(NetworkManager.APP_TOKEN, SettingsManager.getInstance().getAppToken());
                Observable.a(new C16641(a, c14011), OnSubscribeRedo.a(a.f9842a.doRequest(context).b(Schedulers.b()), InternalObservableUtils.a(new C13922(a, c14011))));
                return;
            } catch (Context context2) {
                InstabugSDKLogger.m8358e(C0770a.class, "Something went wrong while do UUID migration request", context2);
                return;
            }
        }
        C0770a.m8353g();
        C0770a.m8349d(mD5Uuid);
    }

    public static void m8342a(Context context, String str, String str2) {
        if (!(str == null || str.isEmpty() || str2 == null)) {
            if (!str2.isEmpty()) {
                if (!SettingsManager.getInstance().getIdentifiedUserEmail().equals(str2)) {
                    C0770a.m8345b(str2);
                    C0770a.m8351e(str2);
                    SettingsManager.getInstance().setUsername(str);
                    str = SettingsManager.getInstance();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str2);
                    stringBuilder.append(SettingsManager.getInstance().getAppToken());
                    str.setMD5Uuid(C0774b.m8363a(stringBuilder.toString()));
                    C0770a.m8341a(context);
                }
                return;
            }
        }
        InstabugSDKLogger.m8361w(C0770a.class, "Empty username or email");
    }

    private static void m8353g() {
        SettingsManager.getInstance().setLastContactedAt(0);
        CacheManager.getInstance().invalidateAllCaches();
        InstabugUserEventLogger.getInstance().clearAll();
        InstabugUserEventLogger.getInstance().clearLoggingData();
    }

    public static void m8340a() {
        if (!C0770a.m8344b().isEmpty()) {
            if (!SettingsManager.getInstance().getUsername().isEmpty()) {
                C0655a.m8155a(new SDKCoreEvent("user", User.VALUE_LOGGED_OUT));
                SettingsManager.getInstance().setUserLoggedOut(true);
                SettingsManager.getInstance().setUuid(null);
                SettingsManager.getInstance().setMD5Uuid(null);
                SettingsManager.getInstance().setUsername("");
                C0770a.m8345b("");
                C0770a.m8351e("");
                SettingsManager.getInstance().setShouldMakeUUIDMigrationRequest(false);
                C0770a.m8353g();
            }
        }
    }

    private static void m8349d(String str) {
        C0655a.m8155a(new SDKCoreEvent("user", User.VALUE_LOGGED_IN));
        SettingsManager.getInstance().setUserLoggedOut(false);
        SettingsManager.getInstance().setMD5Uuid(str);
        CacheManager.getInstance().invalidateAllCaches();
    }

    public static String m8344b() throws IllegalStateException {
        String identifiedUserEmail = SettingsManager.getInstance().getIdentifiedUserEmail();
        return identifiedUserEmail.isEmpty() ? SettingsManager.getInstance().getUserEmail() : identifiedUserEmail;
    }

    public static void m8343a(String str) {
        SettingsManager.getInstance().setUsername(str);
    }

    public static String m8346c() {
        return SettingsManager.getInstance().getUsername();
    }

    public static void m8345b(String str) {
        SettingsManager.getInstance().setUserEmail(str);
        if ("".equals(str)) {
            InstabugSDKLogger.m8356d(C0770a.class, "Email set to empty string, enabling user input of email");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
            StringBuilder stringBuilder = new StringBuilder("Invalid email ");
            stringBuilder.append(str);
            stringBuilder.append(" passed to setUserEmail, ignoring.");
            InstabugSDKLogger.m8361w(C0770a.class, stringBuilder.toString());
        }
    }

    private static void m8351e(String str) {
        SettingsManager.getInstance().setIdentifiedUserEmail(str);
        if ("".equals(str)) {
            InstabugSDKLogger.m8356d(C0770a.class, "Email set to empty string, enabling user input of email");
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(str).matches()) {
            StringBuilder stringBuilder = new StringBuilder("Invalid email ");
            stringBuilder.append(str);
            stringBuilder.append(" passed to setIdentifiedUserEmail, ignoring.");
            InstabugSDKLogger.m8361w(C0770a.class, stringBuilder.toString());
        }
    }

    public static String m8348d() {
        String mD5Uuid = SettingsManager.getInstance().getMD5Uuid();
        if (mD5Uuid != null && !mD5Uuid.isEmpty()) {
            return mD5Uuid;
        }
        mD5Uuid = SettingsManager.getInstance().getUuid();
        if (mD5Uuid != null && !mD5Uuid.isEmpty()) {
            return mD5Uuid;
        }
        mD5Uuid = UUID.randomUUID().toString();
        SettingsManager.getInstance().setUuid(mD5Uuid);
        return mD5Uuid;
    }

    public static void m8350e() {
        if (SettingsManager.getInstance().shouldMakeUUIDMigrationRequest()) {
            C0770a.m8341a(Instabug.getApplicationContext());
        }
    }
}
