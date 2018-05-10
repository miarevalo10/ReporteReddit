package com.facebook.stetho.inspector.elements.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import com.facebook.stetho.common.Util;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class ActivityTracker {
    private static final ActivityTracker sInstance = new ActivityTracker();
    private final ArrayList<WeakReference<Activity>> mActivities = new ArrayList();
    private final List<WeakReference<Activity>> mActivitiesUnmodifiable = Collections.unmodifiableList(this.mActivities);
    private AutomaticTracker mAutomaticTracker;
    private final List<Listener> mListeners = new CopyOnWriteArrayList();

    private static abstract class AutomaticTracker {

        @TargetApi(14)
        private static class AutomaticTrackerICSAndBeyond extends AutomaticTracker {
            private final Application mApplication;
            private final ActivityLifecycleCallbacks mLifecycleCallbacks = new C03441();
            private final ActivityTracker mTracker;

            class C03441 implements ActivityLifecycleCallbacks {
                public void onActivityPaused(Activity activity) {
                }

                public void onActivityResumed(Activity activity) {
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                public void onActivityStarted(Activity activity) {
                }

                public void onActivityStopped(Activity activity) {
                }

                C03441() {
                }

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    AutomaticTrackerICSAndBeyond.this.mTracker.add(activity);
                }

                public void onActivityDestroyed(Activity activity) {
                    AutomaticTrackerICSAndBeyond.this.mTracker.remove(activity);
                }
            }

            public AutomaticTrackerICSAndBeyond(Application application, ActivityTracker activityTracker) {
                super();
                this.mApplication = application;
                this.mTracker = activityTracker;
            }

            public void register() {
                this.mApplication.registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
            }

            public void unregister() {
                this.mApplication.unregisterActivityLifecycleCallbacks(this.mLifecycleCallbacks);
            }
        }

        public abstract void register();

        public abstract void unregister();

        private AutomaticTracker() {
        }

        public static AutomaticTracker newInstanceIfPossible(Application application, ActivityTracker activityTracker) {
            return VERSION.SDK_INT >= 14 ? new AutomaticTrackerICSAndBeyond(application, activityTracker) : null;
        }
    }

    public interface Listener {
        void onActivityAdded(Activity activity);

        void onActivityRemoved(Activity activity);
    }

    public static ActivityTracker get() {
        return sInstance;
    }

    public final void registerListener(Listener listener) {
        this.mListeners.add(listener);
    }

    public final void unregisterListener(Listener listener) {
        this.mListeners.remove(listener);
    }

    public final boolean beginTrackingIfPossible(Application application) {
        if (this.mAutomaticTracker == null) {
            application = AutomaticTracker.newInstanceIfPossible(application, this);
            if (application != null) {
                application.register();
                this.mAutomaticTracker = application;
                return true;
            }
        }
        return null;
    }

    public final boolean endTracking() {
        if (this.mAutomaticTracker == null) {
            return false;
        }
        this.mAutomaticTracker.unregister();
        this.mAutomaticTracker = null;
        return true;
    }

    public final void add(Activity activity) {
        Util.throwIfNull(activity);
        Util.throwIfNot(Looper.myLooper() == Looper.getMainLooper());
        this.mActivities.add(new WeakReference(activity));
        for (Listener onActivityAdded : this.mListeners) {
            onActivityAdded.onActivityAdded(activity);
        }
    }

    public final void remove(Activity activity) {
        Util.throwIfNull(activity);
        Util.throwIfNot(Looper.myLooper() == Looper.getMainLooper());
        if (removeFromWeakList(this.mActivities, activity)) {
            for (Listener onActivityRemoved : this.mListeners) {
                onActivityRemoved.onActivityRemoved(activity);
            }
        }
    }

    private static <T> boolean removeFromWeakList(ArrayList<WeakReference<T>> arrayList, T t) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((WeakReference) arrayList.get(i)).get() == t) {
                arrayList.remove(i);
                return true;
            }
        }
        return false;
    }

    public final List<WeakReference<Activity>> getActivitiesView() {
        return this.mActivitiesUnmodifiable;
    }

    public final Activity tryGetTopActivity() {
        if (this.mActivitiesUnmodifiable.isEmpty()) {
            return null;
        }
        for (int size = this.mActivitiesUnmodifiable.size() - 1; size >= 0; size--) {
            Activity activity = (Activity) ((WeakReference) this.mActivitiesUnmodifiable.get(size)).get();
            if (activity != null) {
                return activity;
            }
        }
        return null;
    }
}
