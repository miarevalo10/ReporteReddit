package com.reddit.frontpage.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/reddit/frontpage/util/ActivityUtil;", "", "()V", "isDestroyedActivity", "", "context", "Landroid/content/Context;", "app_standardRelease"}, k = 1, mv = {1, 1, 9})
/* compiled from: ActivityUtil.kt */
public final class ActivityUtil {
    public static final ActivityUtil f21688a = new ActivityUtil();

    private ActivityUtil() {
    }

    public static boolean m23632a(Context context) {
        Intrinsics.m26847b(context, "context");
        if (context instanceof Activity) {
            return ((Activity) context).isDestroyed();
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Object d = Util.m24014d(context);
        Intrinsics.m26843a(d, "Util.toActivity(context)");
        return d.isDestroyed();
    }
}
