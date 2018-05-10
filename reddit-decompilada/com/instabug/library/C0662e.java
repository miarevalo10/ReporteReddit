package com.instabug.library;

import com.instabug.library.Feature.State;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.core.eventbus.coreeventbus.C0655a;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.internal.storage.cache.SessionsCacheManager;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.instabug.library.logging.InstabugUserEventLogger;
import com.instabug.library.model.C1388b;
import com.instabug.library.model.Session;
import com.instabug.library.model.Session.SessionState;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.library.user.UserEvent;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import rx.Subscription;
import rx.functions.Action1;

/* compiled from: SessionManager */
public class C0662e {
    private static C0662e f9589c;
    public SettingsManager f9590a;
    public int f9591b;
    private Subscription f9592d = CurrentActivityLifeCycleEventBus.getInstance().subscribe(new C13561(this));

    /* compiled from: SessionManager */
    class C13561 implements Action1<ActivityLifeCycleEvent> {
        final /* synthetic */ C0662e f15462a;

        C13561(C0662e c0662e) {
            this.f15462a = c0662e;
        }

        public final /* synthetic */ void m15381a(Object obj) {
            switch ((ActivityLifeCycleEvent) obj) {
                case STARTED:
                    C0662e.m8165a(this.f15462a);
                    return;
                case STOPPED:
                    C0662e.m8168b(this.f15462a);
                    break;
                default:
                    break;
            }
        }
    }

    private C0662e(SettingsManager settingsManager) {
        this.f9590a = settingsManager;
    }

    public static C0662e m8164a() {
        return f9589c;
    }

    public static void m8167a(SettingsManager settingsManager) {
        if (f9589c == null) {
            f9589c = new C0662e(settingsManager);
        }
    }

    public final void m8171b() {
        if (this.f9590a.getSessionStartedAt() != 0) {
            int i = -1;
            if (SettingsManager.getInstance().isFirstDismiss()) {
                i = 1;
            }
            SessionsCacheManager.addSession(new Session(i, this.f9590a.getSessionStartedAt(), (System.currentTimeMillis() / 1000) - this.f9590a.getSessionStartedAt(), m8169c(), m8170d()));
            SessionsCacheManager.saveCacheToDisk();
            if (SettingsManager.getInstance().isFirstDismiss()) {
                SettingsManager.getInstance().setIsFirstDismiss(false);
            }
            C0662e.m8166a(SessionState.FINISH);
            return;
        }
        InstabugSDKLogger.m8356d(this, "Instabug is enabled after session started, Session ignored");
    }

    private String m8169c() {
        String str = "{}";
        HashMap all = UserAttributesCacheManager.getAll();
        if (all == null || all.size() == 0) {
            return str;
        }
        C1388b c1388b = new C1388b();
        c1388b.f15531a = all;
        try {
            return c1388b.toJson();
        } catch (Throwable e) {
            StringBuilder stringBuilder = new StringBuilder("parsing user attributes got error: ");
            stringBuilder.append(e.getMessage());
            InstabugSDKLogger.m8358e(this, stringBuilder.toString(), e);
            return str;
        }
    }

    private String m8170d() {
        Throwable th;
        StringBuilder stringBuilder;
        String str = "[]";
        try {
            List arrayList = new ArrayList();
            arrayList.addAll(InstabugUserEventLogger.getInstance().getUserEvents());
            String jSONArray = UserEvent.toJson(arrayList).toString();
            try {
                InstabugUserEventLogger.getInstance().clearAll();
                return jSONArray;
            } catch (Throwable e) {
                String str2 = jSONArray;
                th = e;
                str = str2;
                stringBuilder = new StringBuilder("parsing user events got error: ");
                stringBuilder.append(th.getMessage());
                InstabugSDKLogger.m8358e(this, stringBuilder.toString(), th);
                return str;
            }
        } catch (JSONException e2) {
            th = e2;
            stringBuilder = new StringBuilder("parsing user events got error: ");
            stringBuilder.append(th.getMessage());
            InstabugSDKLogger.m8358e(this, stringBuilder.toString(), th);
            return str;
        }
    }

    private static void m8166a(SessionState sessionState) {
        if (sessionState.equals(SessionState.FINISH)) {
            SettingsManager.getInstance().setIsAppOnForeground(false);
            C0655a.m8155a(new SDKCoreEvent(SDKCoreEvent.Session.TYPE_SESSION, SDKCoreEvent.Session.VALUE_FINISHED));
        } else {
            SettingsManager.getInstance().setIsAppOnForeground(true);
            C0655a.m8155a(new SDKCoreEvent(SDKCoreEvent.Session.TYPE_SESSION, SDKCoreEvent.Session.VALUE_STARTED));
        }
        SessionStateEventBus.getInstance().post(sessionState);
    }

    static /* synthetic */ void m8165a(C0662e c0662e) {
        if (C0645b.m8104a().m8113b(Feature.INSTABUG) == State.ENABLED && c0662e.f9591b == 0) {
            c0662e.f9590a.setSessionStartedAt(System.currentTimeMillis() / 1000);
            if (SettingsManager.getInstance().isFirstRun()) {
                c0662e.f9590a.setIsFirstRun(false);
            }
            if (SettingsManager.getInstance().getFirstRunAt().getTime() == 0) {
                c0662e.f9590a.setFirstRunAt(System.currentTimeMillis());
            }
            c0662e.f9590a.incrementSessionsCount();
            C0662e.m8166a(SessionState.START);
        }
        c0662e.f9591b++;
    }

    static /* synthetic */ void m8168b(C0662e c0662e) {
        C0645b.m8104a().m8109a(Instabug.getApplicationContext());
        if (C0645b.m8104a().m8113b(Feature.INSTABUG) == State.ENABLED && c0662e.f9591b == 1) {
            c0662e.m8171b();
        }
        c0662e.f9591b--;
    }
}
