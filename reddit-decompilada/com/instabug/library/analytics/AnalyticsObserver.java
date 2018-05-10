package com.instabug.library.analytics;

import android.content.Context;
import com.instabug.library.analytics.model.Api;
import com.instabug.library.analytics.model.Api.Parameter;
import com.instabug.library.analytics.util.C0600a;
import com.instabug.library.analytics.util.C0601b;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.model.Session.SessionState;
import com.instabug.library.settings.SettingsManager;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import rx.functions.Action1;

@SuppressFBWarnings({"URF_UNREAD_FIELD", "DLS_DEAD_LOCAL_STORE", "DLS_DEAD_LOCAL_STORE"})
public class AnalyticsObserver {
    private static AnalyticsObserver INSTANCE = null;
    private static final String LAST_UPLOADED_AT = "analytics_last_uploaded";
    private LinkedHashMap<String, Api> loggingApisLinkedHashMap = new LinkedHashMap();
    private List<Api> sdkApisArrayList = Collections.synchronizedList(new ArrayList());
    private Action1<SessionState> sessionStateChangedAction = new C13421(this);

    class C13421 implements Action1<SessionState> {
        final /* synthetic */ AnalyticsObserver f15442a;

        C13421(AnalyticsObserver analyticsObserver) {
            this.f15442a = analyticsObserver;
        }

        public final /* synthetic */ void m15343a(Object obj) {
            this.f15442a.handleAPIsUsageWithSessionStateChanged((SessionState) obj);
            C0601b.m8018a();
        }
    }

    public static AnalyticsObserver getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AnalyticsObserver();
        }
        return INSTANCE;
    }

    private AnalyticsObserver() {
        SessionStateEventBus.getInstance().subscribe(this.sessionStateChangedAction);
    }

    public void catchApiUsage(Parameter... parameterArr) {
        catchApiUsage(getCallerMethodName(), false, parameterArr);
    }

    public void catchDeprecatedApiUsage(Parameter... parameterArr) {
        catchApiUsage(getCallerMethodName(), true, parameterArr);
    }

    public void catchLoggingApiUsage(Parameter... parameterArr) {
        catchLoggingApiUsage(getCallerMethodName(), false, parameterArr);
    }

    public void catchDeprecatedLoggingApiUsage(Parameter... parameterArr) {
        catchLoggingApiUsage(getCallerMethodName(), true, parameterArr);
    }

    private void catchApiUsage(String str, boolean z, Parameter... parameterArr) {
        this.sdkApisArrayList.add(createApiUsageInfo(str, z, parameterArr));
    }

    private void catchLoggingApiUsage(String str, boolean z, Parameter... parameterArr) {
        if (this.loggingApisLinkedHashMap.containsKey(str)) {
            Api api = (Api) this.loggingApisLinkedHashMap.get(str);
            api.incrementCount();
            this.loggingApisLinkedHashMap.put(str, api);
            return;
        }
        this.loggingApisLinkedHashMap.put(str, createApiUsageInfo(str, z, parameterArr));
    }

    private Api createApiUsageInfo(String str, boolean z, Parameter... parameterArr) {
        Api api = new Api();
        api.setApiName(str);
        api.setDeprecated(z);
        if (parameterArr != null) {
            str = new ArrayList(Arrays.asList(parameterArr));
        } else {
            str = new ArrayList();
        }
        api.setParameters(str);
        return api;
    }

    private String getCallerMethodName() {
        return Thread.currentThread().getStackTrace()[4].getMethodName();
    }

    private void handleAPIsUsageWithSessionStateChanged(SessionState sessionState) {
        long sessionStartedAt = SettingsManager.getInstance().getSessionStartedAt();
        if (sessionState == SessionState.FINISH) {
            C0600a.m8015a(this.sdkApisArrayList, sessionStartedAt);
            C0600a.m8015a(this.loggingApisLinkedHashMap.values(), sessionStartedAt);
            this.sdkApisArrayList.clear();
            this.loggingApisLinkedHashMap.clear();
        }
    }

    public static long getLastUploadedAt(Context context) {
        return context.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0).getLong(LAST_UPLOADED_AT, 0);
    }

    public static void setLastUploadedAt(long j, Context context) {
        context.getSharedPreferences(SettingsManager.INSTABUG_SHARED_PREF_NAME, 0).edit().putLong(LAST_UPLOADED_AT, j).apply();
    }
}
