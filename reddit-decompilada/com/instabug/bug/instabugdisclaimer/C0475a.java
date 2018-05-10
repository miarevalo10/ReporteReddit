package com.instabug.bug.instabugdisclaimer;

import com.instabug.bug.settings.C0485a;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library.Instabug;
import com.instabug.library.analytics.AnalyticsObserver;
import com.instabug.library.analytics.model.Api.Parameter;
import com.instabug.library.core.InstabugCore;

/* compiled from: InstabugDisclaimer */
class C0475a {
    private static String f9103a = "Disclaimer: Once submitted, this feedback and [metadata](#metadata) will be sent to and stored on Instabug's servers.<P/><P/>[Learn more](http://grasshopper.codes).";

    static void m7773a() {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter[0]);
        InstabugCore.setFeatureState(Feature.CONSOLE_LOGS, State.DISABLED);
        InstabugCore.setFeatureState(Feature.TRACK_USER_STEPS, State.DISABLED);
        InstabugCore.setFeatureState(Feature.REPRO_STEPS, State.DISABLED);
        InstabugCore.setFeatureState(Feature.VIEW_HIERARCHY, State.DISABLED);
        Instabug.setPromptOptionsEnabled(false, true, true);
        C0475a.m7774a(f9103a);
    }

    static void m7774a(String str) {
        AnalyticsObserver.getInstance().catchApiUsage(new Parameter().setName("disclaimer").setType(CharSequence.class));
        if (InstabugCore.getFeatureState(Feature.DISCLAIMER) == State.ENABLED) {
            C0485a.m7793a();
            C0485a.m7809c(str);
        }
    }
}
