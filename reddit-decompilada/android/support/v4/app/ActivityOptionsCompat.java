package android.support.v4.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;

public class ActivityOptionsCompat {

    @RequiresApi(16)
    private static class ActivityOptionsCompatApi16Impl extends ActivityOptionsCompat {
        protected final ActivityOptions f11251a;

        ActivityOptionsCompatApi16Impl(ActivityOptions activityOptions) {
            this.f11251a = activityOptions;
        }

        public final Bundle mo191a() {
            return this.f11251a.toBundle();
        }
    }

    @RequiresApi(23)
    private static class ActivityOptionsCompatApi23Impl extends ActivityOptionsCompatApi16Impl {
        ActivityOptionsCompatApi23Impl(ActivityOptions activityOptions) {
            super(activityOptions);
        }
    }

    @RequiresApi(24)
    private static class ActivityOptionsCompatApi24Impl extends ActivityOptionsCompatApi23Impl {
        ActivityOptionsCompatApi24Impl(ActivityOptions activityOptions) {
            super(activityOptions);
        }
    }

    public Bundle mo191a() {
        return null;
    }

    public static ActivityOptionsCompat m519a(Activity activity, View view, String str) {
        if (VERSION.SDK_INT < 21) {
            return new ActivityOptionsCompat();
        }
        activity = ActivityOptions.makeSceneTransitionAnimation(activity, view, str);
        if (VERSION.SDK_INT >= 24) {
            return new ActivityOptionsCompatApi24Impl(activity);
        }
        if (VERSION.SDK_INT >= 23) {
            return new ActivityOptionsCompatApi23Impl(activity);
        }
        return new ActivityOptionsCompatApi16Impl(activity);
    }

    protected ActivityOptionsCompat() {
    }
}
