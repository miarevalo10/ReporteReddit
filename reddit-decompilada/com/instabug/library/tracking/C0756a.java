package com.instabug.library.tracking;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.instabug.library.util.InstabugSDKLogger;

@TargetApi(14)
/* compiled from: InstabugActivityLifecycleListener */
public class C0756a implements ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        InstabugInternalTrackingDelegate.getInstance().handleActivityCreatedEvent(activity);
    }

    public void onActivityStarted(Activity activity) {
        InstabugInternalTrackingDelegate.getInstance().handleActivityStartedEvent(activity);
    }

    public void onActivityResumed(Activity activity) {
        InstabugInternalTrackingDelegate.getInstance().handleActivityResumedEvent(activity);
    }

    public void onActivityPaused(Activity activity) {
        InstabugInternalTrackingDelegate.getInstance().handleActivityPausedEvent(activity);
    }

    public void onActivityStopped(Activity activity) {
        InstabugInternalTrackingDelegate.getInstance().handleActivityStoppedEvent(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        bundle = new StringBuilder();
        bundle.append(activity.getClass().getSimpleName());
        bundle.append(" SaveInstanceState");
        InstabugSDKLogger.m8356d(this, bundle.toString());
    }

    public void onActivityDestroyed(Activity activity) {
        InstabugInternalTrackingDelegate.getInstance().handleActivityDestroyedEvent(activity);
    }
}
