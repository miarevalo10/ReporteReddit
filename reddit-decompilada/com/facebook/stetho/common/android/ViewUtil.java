package com.facebook.stetho.common.android;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;

final class ViewUtil {
    private ViewUtil() {
    }

    static Activity tryGetActivity(View view) {
        while (view != null) {
            Activity tryGetActivity = tryGetActivity(view.getContext());
            if (tryGetActivity != null) {
                return tryGetActivity;
            }
            view = view.getParent();
            if (!(view instanceof View)) {
                return null;
            }
            view = view;
        }
        return null;
    }

    private static Activity tryGetActivity(Context context) {
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
