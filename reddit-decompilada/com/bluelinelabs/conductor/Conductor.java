package com.bluelinelabs.conductor;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import com.bluelinelabs.conductor.internal.LifecycleHandler;
import com.bluelinelabs.conductor.internal.ThreadUtils;

public final class Conductor {
    public static Router m2608a(Activity activity, ViewGroup viewGroup, Bundle bundle) {
        ThreadUtils.m2763a();
        activity = LifecycleHandler.m2756a(activity);
        Router router = (ActivityHostedRouter) activity.f3169c.get(Integer.valueOf(LifecycleHandler.m2755a(viewGroup)));
        if (router == null) {
            router = new ActivityHostedRouter();
            router.m11113a(activity, viewGroup);
            if (bundle != null) {
                StringBuilder stringBuilder = new StringBuilder("LifecycleHandler.routerState");
                stringBuilder.append(router.m2736k());
                bundle = bundle.getBundle(stringBuilder.toString());
                if (bundle != null) {
                    router.mo841b(bundle);
                }
            }
            activity.f3169c.put(Integer.valueOf(LifecycleHandler.m2755a(viewGroup)), router);
        } else {
            router.m11113a(activity, viewGroup);
        }
        router.m2740o();
        return router;
    }
}
