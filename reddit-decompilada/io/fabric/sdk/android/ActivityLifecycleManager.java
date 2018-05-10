package io.fabric.sdk.android;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

public class ActivityLifecycleManager {
    public ActivityLifecycleCallbacksWrapper f24682a;
    private final Application f24683b;

    private static class ActivityLifecycleCallbacksWrapper {
        private final Set<ActivityLifecycleCallbacks> f24680a = new HashSet();
        private final Application f24681b;

        ActivityLifecycleCallbacksWrapper(Application application) {
            this.f24681b = application;
        }

        static /* synthetic */ boolean m26231a(ActivityLifecycleCallbacksWrapper activityLifecycleCallbacksWrapper, final Callbacks callbacks) {
            if (activityLifecycleCallbacksWrapper.f24681b == null) {
                return null;
            }
            ActivityLifecycleCallbacks c21131 = new ActivityLifecycleCallbacks(activityLifecycleCallbacksWrapper) {
                final /* synthetic */ ActivityLifecycleCallbacksWrapper f24679b;

                public void onActivityCreated(Activity activity, Bundle bundle) {
                    callbacks.onActivityCreated(activity, bundle);
                }

                public void onActivityStarted(Activity activity) {
                    callbacks.onActivityStarted(activity);
                }

                public void onActivityResumed(Activity activity) {
                    callbacks.onActivityResumed(activity);
                }

                public void onActivityPaused(Activity activity) {
                    callbacks.onActivityPaused(activity);
                }

                public void onActivityStopped(Activity activity) {
                    callbacks.onActivityStopped(activity);
                }

                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    callbacks.onActivitySaveInstanceState(activity, bundle);
                }

                public void onActivityDestroyed(Activity activity) {
                    callbacks.onActivityDestroyed(activity);
                }
            };
            activityLifecycleCallbacksWrapper.f24681b.registerActivityLifecycleCallbacks(c21131);
            activityLifecycleCallbacksWrapper.f24680a.add(c21131);
            return true;
        }

        public static /* synthetic */ void m26230a(ActivityLifecycleCallbacksWrapper activityLifecycleCallbacksWrapper) {
            for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : activityLifecycleCallbacksWrapper.f24680a) {
                activityLifecycleCallbacksWrapper.f24681b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }
    }

    public static abstract class Callbacks {
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

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
    }

    public ActivityLifecycleManager(Context context) {
        this.f24683b = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.f24682a = new ActivityLifecycleCallbacksWrapper(this.f24683b);
        }
    }

    public final boolean m26232a(Callbacks callbacks) {
        return (this.f24682a == null || ActivityLifecycleCallbacksWrapper.m26231a(this.f24682a, callbacks) == null) ? null : true;
    }
}
