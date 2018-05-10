package com.instabug.library.tracking;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import com.instabug.library.C0645b;
import com.instabug.library.C0654c;
import com.instabug.library.C0654c.C0649a;
import com.instabug.library.Feature;
import com.instabug.library.Feature.State;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.model.C0740d;
import com.instabug.library.model.C0740d.C0739a;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.visualusersteps.C0786d;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class InstabugInternalTrackingDelegate {
    private static InstabugInternalTrackingDelegate INSTANCE;
    private WeakReference<Activity> currentActivity;

    public static void init(Application application) {
        if (INSTANCE == null) {
            INSTANCE = new InstabugInternalTrackingDelegate(application);
        }
    }

    public static InstabugInternalTrackingDelegate getInstance() {
        return INSTANCE;
    }

    private InstabugInternalTrackingDelegate(Application application) {
        if (application != null) {
            registerActivityLifecycleListener(application);
        }
    }

    public void onApplicationCreated(Application application) {
        if (isUserTrackingStepsEnable()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(application.getClass().getSimpleName());
            stringBuilder.append(" created");
            InstabugSDKLogger.m8360v(InstabugInternalTrackingDelegate.class, stringBuilder.toString());
            C0761d.m8330a().m8334a(application.getClass().getName(), C0739a.APPLICATION_CREATED);
        }
    }

    public void onActivityCreated(Activity activity) {
        if (beforeICS()) {
            handleActivityCreatedEvent(activity);
        }
    }

    void handleActivityCreatedEvent(Activity activity) {
        if (isNotInstabugActivity(activity)) {
            if (isUserTrackingStepsEnable()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(activity.getClass().getSimpleName());
                stringBuilder.append(" created");
                InstabugSDKLogger.m8360v(InstabugInternalTrackingDelegate.class, stringBuilder.toString());
                C0761d.m8330a().m8334a(activity.getClass().getName(), C0739a.ACTIVITY_CREATED);
            }
            if (isReproStepsEnable()) {
                C0786d.m8386a().m8392a("activity_created", activity.getClass().getSimpleName(), activity.getClass().getName());
            }
            CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.CREATED);
        }
    }

    public void onActivityStarted(Activity activity) {
        if (beforeICS()) {
            handleActivityStartedEvent(activity);
        }
    }

    void handleActivityStartedEvent(Activity activity) {
        if (isNotInstabugActivity(activity)) {
            if (isUserTrackingStepsEnable()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(activity.getClass().getSimpleName());
                stringBuilder.append(" started");
                InstabugSDKLogger.m8360v(InstabugInternalTrackingDelegate.class, stringBuilder.toString());
                C0761d.m8330a().m8334a(activity.getClass().getName(), C0739a.ACTIVITY_STARTED);
            }
            if (isReproStepsEnable()) {
                C0786d.m8386a().m8392a("activity_started", activity.getClass().getSimpleName(), activity.getClass().getName());
            }
        }
        CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.STARTED);
    }

    public void onActivityResumed(Activity activity) {
        if (beforeICS()) {
            handleActivityResumedEvent(activity);
        }
    }

    void handleActivityResumedEvent(Activity activity) {
        if (isNotInstabugActivity(activity)) {
            this.currentActivity = new WeakReference(activity);
            if (isUserTrackingStepsEnable()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(activity.getClass().getSimpleName());
                stringBuilder.append(" resumed");
                InstabugSDKLogger.m8360v(InstabugInternalTrackingDelegate.class, stringBuilder.toString());
                C0761d.m8330a().m8334a(activity.getClass().getName(), C0739a.ACTIVITY_RESUMED);
            }
            if (isReproStepsEnable()) {
                C0786d.m8386a().m8392a("activity_resumed", activity.getClass().getSimpleName(), activity.getClass().getName());
            }
            CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.RESUMED);
        }
    }

    public void onActivityPaused(Activity activity) {
        if (beforeICS()) {
            handleActivityPausedEvent(activity);
        }
    }

    void handleActivityPausedEvent(Activity activity) {
        if (isNotInstabugActivity(activity)) {
            if (this.currentActivity == null) {
                InstabugSDKLogger.m8361w(this, "No activity was set earlier than this call. Doing nothing");
            } else if (activity.equals(this.currentActivity.get())) {
                if (isUserTrackingStepsEnable()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(activity.getClass().getSimpleName());
                    stringBuilder.append(" paused");
                    InstabugSDKLogger.m8360v(InstabugInternalTrackingDelegate.class, stringBuilder.toString());
                    C0761d.m8330a().m8334a(activity.getClass().getName(), C0739a.ACTIVITY_PAUSED);
                }
                if (isReproStepsEnable()) {
                    C0786d.m8386a().m8392a("activity_paused", activity.getClass().getSimpleName(), activity.getClass().getName());
                }
                CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.PAUSED);
            } else {
                InstabugSDKLogger.m8361w(this, "You're trying to pause an activity that is not the current activity! Please make sure you're calling onCurrentActivityPaused and onCurrentActivityResumed on every activity");
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        if (beforeICS()) {
            handleActivityStoppedEvent(activity);
        }
    }

    void handleActivityStoppedEvent(Activity activity) {
        if (isNotInstabugActivity(activity)) {
            if (isUserTrackingStepsEnable()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(activity.getClass().getSimpleName());
                stringBuilder.append(" stopped");
                InstabugSDKLogger.m8360v(InstabugInternalTrackingDelegate.class, stringBuilder.toString());
                C0761d.m8330a().m8334a(activity.getClass().getName(), C0739a.ACTIVITY_STOPPED);
            }
            if (isReproStepsEnable()) {
                C0786d.m8386a().m8392a("activity_stopped", activity.getClass().getSimpleName(), activity.getClass().getName());
            }
        }
        CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.STOPPED);
    }

    public void onActivityDestroyed(Activity activity) {
        if (beforeICS()) {
            handleActivityDestroyedEvent(activity);
        }
    }

    void handleActivityDestroyedEvent(Activity activity) {
        if (isNotInstabugActivity(activity)) {
            if (isUserTrackingStepsEnable()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(activity.getClass().getSimpleName());
                stringBuilder.append(" destroyed");
                InstabugSDKLogger.m8360v(InstabugInternalTrackingDelegate.class, stringBuilder.toString());
                C0761d.m8330a().m8334a(activity.getClass().getName(), C0739a.ACTIVITY_DESTROYED);
            }
            if (isReproStepsEnable()) {
                C0786d.m8386a().m8392a("activity_destroyed", activity.getClass().getSimpleName(), activity.getClass().getName());
            }
            CurrentActivityLifeCycleEventBus.getInstance().post(ActivityLifeCycleEvent.DESTROYED);
        }
    }

    public void onFragmentAttached(Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_ATTACHED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_attached", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentViewCreated(Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_VIEW_CREATED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_view_created", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentStarted(Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_STARTED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_started", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentResumed(Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_RESUMED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_resumed", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentPaused(Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_PAUSED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_paused", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentStopped(Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_STOPPED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_stopped", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentDetached(Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_DETACHED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_detached", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentVisibilityChanged(boolean z, Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d a = C0761d.m8330a();
            String name = fragment.getClass().getName();
            activity = activity.getClass().getName();
            StringBuilder stringBuilder = new StringBuilder("Fragment visibility: ");
            stringBuilder.append(z);
            a.m8336a(name, activity, stringBuilder.toString(), C0739a.FRAGMENT_VISIBILITY_CHANGED);
        }
        if (isReproStepsEnable()) {
            C0786d.m8386a().m8392a("fragment_visibility_changed", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentAttached(android.support.v4.app.Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_ATTACHED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_attached", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentViewCreated(android.support.v4.app.Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_VIEW_CREATED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_view_created", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentStarted(android.support.v4.app.Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_STARTED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_started", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentResumed(android.support.v4.app.Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_RESUMED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_resumed", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentPaused(android.support.v4.app.Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_PAUSED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_paused", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentStopped(android.support.v4.app.Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_STOPPED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_stopped", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentDetached(android.support.v4.app.Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d.m8330a().m8335a(fragment.getClass().getName(), activity.getClass().getName(), C0739a.FRAGMENT_DETACHED);
        }
        if (isReproStepsEnable() != null) {
            C0786d.m8386a().m8392a("fragment_detached", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void onFragmentVisibilityChanged(boolean z, android.support.v4.app.Fragment fragment, Activity activity) {
        if (isUserTrackingStepsEnable()) {
            C0761d a = C0761d.m8330a();
            String name = fragment.getClass().getName();
            activity = activity.getClass().getName();
            StringBuilder stringBuilder = new StringBuilder("Fragment visibility: ");
            stringBuilder.append(z);
            a.m8336a(name, activity, stringBuilder.toString(), C0739a.FRAGMENT_VISIBILITY_CHANGED);
        }
        if (isReproStepsEnable()) {
            C0786d.m8386a().m8392a("fragment_visibility_changed", fragment.getClass().getSimpleName(), fragment.getClass().getName());
        }
    }

    public void trackTouchEvent(MotionEvent motionEvent, Activity activity) {
        C0759c a = C0759c.m8325a();
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        C0649a[] c0649aArr = new C0649a[motionEvent.getPointerCount()];
        for (int i = 0; i < motionEvent.getPointerCount(); i++) {
            c0649aArr[i] = new C0649a((int) motionEvent.getX(i), (int) motionEvent.getY(i));
        }
        C0654c.m8154a().f9583a = (C0649a[]) Arrays.copyOf(c0649aArr, c0649aArr.length);
        if (motionEvent.getAction() == 0) {
            a.f9880a = rawX;
            a.f9881b = rawY;
            return;
        }
        if (motionEvent.getAction() == 1 && Math.abs(a.f9880a - rawX) <= 25 && Math.abs(a.f9881b - rawY) <= 25) {
            motionEvent = a.m8329a(activity.getWindow().getDecorView(), rawX, rawY);
            if (motionEvent != null) {
                String a2 = C0759c.m8326a(activity, motionEvent.getId());
                if (C0759c.m8327b()) {
                    C0761d a3 = C0761d.m8330a();
                    String name = activity.getClass().getName();
                    motionEvent = motionEvent.getClass().getName();
                    C0740d c0740d = new C0740d();
                    c0740d.f9834f = C0739a.TAP;
                    c0740d.f9830b = name;
                    c0740d.f9829a = InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds();
                    if (a2 != null) {
                        c0740d.f9832d = a2;
                    }
                    if (motionEvent != null) {
                        c0740d.f9833e = motionEvent;
                    }
                    a3.m8337b();
                    a3.f9884a.add(c0740d);
                }
                if (C0759c.m8328c() != null) {
                    C0786d.m8386a().m8392a("view_tapped", activity.getClass().getSimpleName(), a2);
                }
            }
        }
    }

    public Activity getCurrentActivity() {
        return (this.currentActivity == null || this.currentActivity.get() == null) ? null : (Activity) this.currentActivity.get();
    }

    public Activity getTargetActivity() {
        if (this.currentActivity == null || this.currentActivity.get() == null || ((Activity) this.currentActivity.get()).getParent() == null) {
            return this.currentActivity != null ? (Activity) this.currentActivity.get() : null;
        } else {
            Activity parent = ((Activity) this.currentActivity.get()).getParent();
            while (parent.getParent() != null) {
                parent = parent.getParent();
            }
            return parent;
        }
    }

    private void registerActivityLifecycleListener(Application application) {
        if (VERSION.SDK_INT >= 14) {
            InstabugSDKLogger.m8360v(this, "Registering activity lifecycle listener");
            application.registerActivityLifecycleCallbacks(new C0756a());
        }
    }

    private boolean beforeICS() {
        return VERSION.SDK_INT < 14;
    }

    private boolean isUserTrackingStepsEnable() {
        return C0645b.m8104a().m8113b(Feature.TRACK_USER_STEPS) == State.ENABLED;
    }

    private boolean isReproStepsEnable() {
        return C0645b.m8104a().m8113b(Feature.REPRO_STEPS) == State.ENABLED;
    }

    private boolean isNotInstabugActivity(Activity activity) {
        return (activity instanceof _InstabugActivity) == null ? true : null;
    }
}
