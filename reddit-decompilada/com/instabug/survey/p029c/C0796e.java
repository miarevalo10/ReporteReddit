package com.instabug.survey.p029c;

import android.os.Handler;
import android.os.Looper;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.p028b.C0791c;

/* compiled from: SurveysUtils */
public class C0796e {
    public static boolean m8412a() {
        return InstabugCore.getFeatureState(Feature.SURVEYS) == State.ENABLED;
    }

    public static void m8413b() {
        if (C0791c.m8403b() != null) {
            try {
                new Handler(Looper.getMainLooper()).post(C0791c.m8403b());
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e(C0796e.class, "AfterShowingSurveyRunnable has been failed to run.", e);
            }
        }
    }

    public static void m8414c() {
        if (C0791c.m8405c() != null) {
            try {
                new Handler(Looper.getMainLooper()).post(C0791c.m8405c());
            } catch (Throwable e) {
                InstabugSDKLogger.m8358e(C0796e.class, "AfterShowingSurveyRunnable has been failed to run.", e);
            }
        }
    }
}
