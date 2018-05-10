package com.instabug.survey;

import com.instabug.library.Instabug;
import com.instabug.library.InstabugState;
import com.instabug.library.analytics.AnalyticsObserver;
import com.instabug.library.analytics.model.Api.Parameter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.p027a.C1413c;
import com.instabug.survey.p028b.C0791c;
import com.instabug.survey.p029c.C0796e;

public class InstabugSurvey {
    public static boolean showValidSurvey() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return C1414a.m15478a(Instabug.getApplicationContext()).m15484a();
    }

    public static boolean hasValidSurveys() throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        return C1414a.m15478a(Instabug.getApplicationContext()).m15485b();
    }

    public static void setPreShowingSurveyRunnable(Runnable runnable) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("preShowingSurveyRunnable").setType(Runnable.class));
        C0791c.m8400a(runnable);
    }

    public static void setAfterShowingSurveyRunnable(Runnable runnable) throws IllegalStateException {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("afterShowingSurveyRunnable").setType(Runnable.class));
        C0791c.m8404b(runnable);
    }

    public static void setSurveysAutoShowing(boolean z) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("isSurveysAutoShowing").setType(Boolean.class).setValue(Boolean.valueOf(z)));
        C0791c.m8401a(z);
    }

    public static boolean showSurvey(String str) {
        if (str != null) {
            if (!String.valueOf(str).equals("null")) {
                AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("showSurvey").setType(String.class).setValue(str));
                C1414a a = C1414a.m15478a(Instabug.getApplicationContext());
                if (Instabug.getState().equals(InstabugState.ENABLED) && C0796e.m8412a() && Instabug.isAppOnForeground()) {
                    C1413c a2 = a.m15480a(str);
                    if (!(a2 == null || a2.f15578h || a2.f15581k)) {
                        a.m15481a(a2);
                        return true;
                    }
                }
                return false;
            }
        }
        InstabugSDKLogger.m8359i(InstabugSurvey.class.getName(), "Optin survey token is NULL");
        return false;
    }

    public static boolean hasRespondToSurvey(String str) {
        if (str == null) {
            InstabugSDKLogger.m8359i(InstabugSurvey.class.getName(), "Optin survey token is NULL");
            return false;
        }
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("hasRespondToSurvey").setType(String.class).setValue(str));
        C1414a a = C1414a.m15478a(Instabug.getApplicationContext());
        C1413c a2 = a.m15480a(str);
        if (a2 != null) {
            return a2.f15578h;
        }
        StringBuilder stringBuilder = new StringBuilder("No survey with token=");
        stringBuilder.append(str);
        stringBuilder.append(" was found.");
        InstabugSDKLogger.m8357e(a, stringBuilder.toString());
        return false;
    }
}
