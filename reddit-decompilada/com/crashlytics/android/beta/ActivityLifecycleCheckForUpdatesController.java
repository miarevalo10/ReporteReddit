package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Activity;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.ActivityLifecycleManager.Callbacks;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
class ActivityLifecycleCheckForUpdatesController extends AbstractCheckForUpdatesController {
    private final Callbacks callbacks = new C10881();
    private final ExecutorService executorService;

    class C10881 extends Callbacks {

        class C02971 implements Runnable {
            C02971() {
            }

            public void run() {
                ActivityLifecycleCheckForUpdatesController.this.checkForUpdates();
            }
        }

        C10881() {
        }

        public void onActivityStarted(Activity activity) {
            if (ActivityLifecycleCheckForUpdatesController.this.signalExternallyReady() != null) {
                ActivityLifecycleCheckForUpdatesController.this.executorService.submit(new C02971());
            }
        }
    }

    public boolean isActivityLifecycleTriggered() {
        return true;
    }

    public ActivityLifecycleCheckForUpdatesController(ActivityLifecycleManager activityLifecycleManager, ExecutorService executorService) {
        this.executorService = executorService;
        activityLifecycleManager.a(this.callbacks);
    }
}
